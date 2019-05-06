package org.polymodel.scop.dtiler.basic;

import java.util.List;
import java.util.LinkedList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFactory;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.AnnotationFactory;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.util.ScopPrinter;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class DTilerFullTile {

	
  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include{ dtiler.tom }

  protected final DTilingOptions _options;
  protected final OptimizationOptions _optOptions;

  public DTilerFullTile(DTilingOptions options, OptimizationOptions optOptions) {
	  _options = options;
	  _optOptions = optOptions;
  }

  public DTilerFullTile(DTilingOptions options){
	  _options = options;
	  _optOptions = null;
  }


  private List<String> indexes;

	/**
	 * Build the conditions of full tile for a loop nest and build box loops.
	 * Each loop is transformed into a box loop. Transformed box loop nest is
	 * surrounded by the full tile conditions guard. Input {@link ScopFor} is
	 * not modified.
	 * 
	 * @param stmt
	 * @return
	 */
	public static ScopGuard build(ScopFor stmt, DTilingOptions options) {
		DTilerFullTile builder = new DTilerFullTile(options);
		return (ScopGuard) builder.generate(stmt);
	}

	public static ScopGuard build(ScopFor stmt, DTilingOptions options, OptimizationOptions _optOptions) {
		DTilerFullTile builder = new DTilerFullTile(options, _optOptions);
		return (ScopGuard) builder.generate(stmt);
	}

  protected AbstractScopNode generate(ScopFor o) {
	  try {
		  ScopGuard fullTileGuard =  (ScopGuard)`BottomUp(FullTileTest(_options)).visitLight(EcoreUtil.copy(o),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
		  fullTileGuard = (ScopGuard)`BottomUp(CollapseGuards()).visitLight(fullTileGuard,tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);

		  DescriptionAnnotation annotation = AnnotationFactory.eINSTANCE.createDescriptionAnnotation();
		  annotation.setDescription("full-tile guard");
		  fullTileGuard.getScopAnnotations().add(annotation);
          
          if(_optOptions != null && _optOptions.optimizedPointLoop != null){
        	  List<AbstractScopNode> _stmts = new LinkedList<AbstractScopNode>();
        	  _stmts.addAll(_optOptions.optimizedPointLoop.getStatements());
        	  ScopBlock sb = ScopUserFactory.scopBlock(_stmts);
        	  fullTileGuard.setThenBody(sb);
          }else{
        	  ScopFor boxLoops = (ScopFor)`BottomUp(BoxLoop(_options)).visitLight(EcoreUtil.copy(o),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
        	  //add box loop inside full tile guard
        	  fullTileGuard.setThenBody(boxLoops);
          }

		  fullTileGuard.setElseBody((new DTilerPointLoops(_options)).generate(o));
	  return fullTileGuard.simplify();
	  } catch (VisitFailure vf) {
		  vf.printStackTrace();
		  throw new RuntimeException("VisitFailure at DTilerTileLoops : " + vf.getMessage());
	  }
  }

  %strategy FullTileTest(options:DTilingOptions) extends Identity() {
    visit node {
    	o@loop(ite, lb, ub, _, body)->{
    		int depth = `o.getLoopDepth();
    		List<ScopFor> loops = `o.getSurroundingScopFors();
    		//replace all iterators with loop index
    		Variable tileIndex = options.getTileIndex(depth);
    		//shift up/down by the current dim
    		IntExpression lbc = Shift.up(`lb, `ite, options);
    		IntExpression ubc = Shift.down(`ub, `ite, options);
    		lbc = `lbc.substitute(`ite, tileIndex);
    		ubc = `ubc.substitute(`ite, tileIndex);
    		for (int i = 1; i < depth; i++) {
    			Variable lite = loops.get(i-1).getIterator();
    			lbc = lbc.substitute(lite, options.getTileIndex(i));
    			ubc = ubc.substitute(lite, options.getTileIndex(i));
    		}
    		
    		AffineExpression afTI = IntExpressionBuilder.affine(IntExpressionBuilder.term(tileIndex));

    		IntConstraintSystem ics = IntExpressionBuilder.constraintSystem(
    				IntExpressionBuilder.constraint(lbc, EcoreUtil.copy(afTI), ComparisonOperator.LE),
    				IntExpressionBuilder.constraint(afTI, ubc, ComparisonOperator.LE)
    			);
    		EList<IntConstraintSystem> icsList = new BasicEList<IntConstraintSystem>(1);
    		icsList.add(ics);
    		
    		return `guard(icsList, body, null);
    	}
    }
  }

  %strategy CollapseGuards() extends Identity() {
    visit node {
    	guard(cond1, guard(cond2, body, else1), _) -> {
    		if (`cond1.size() == 1 && `cond2.size() == 1) {
    			`cond1.get(0).getConstraints().addAll(`cond2.get(0).getConstraints());
    		return `guard(cond1, body, else1);
    		}
    		throw new RuntimeException("Expecting single constraint system in guards.");
    	}
    }
  }

  %strategy BoxLoop(options : DTilingOptions) extends Identity() {
    visit node {
    	o@loop(_,_,_,_,_)->{
    		int depth = `o.getLoopDepth();
    		AffineTerm tileSize = options.getTileSize(depth);
    		AffineTerm tileIndex = IntExpressionBuilder.term(options.getTileIndex(depth));
    		IntExpression boxLB = IntExpressionBuilder.affine(EcoreUtil.copy(tileIndex));
    		IntExpression boxUB = IntExpressionBuilder.affine(tileIndex, tileSize, IntExpressionBuilder.term(-1));
    		((ScopFor)`o).setLB(boxLB);
    		((ScopFor)`o).setUB(boxUB);
    		return `o;
    	}
    }
  }
}