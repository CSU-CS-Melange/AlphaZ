package org.polymodel.scop.dtiler.basic;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.AbstractTileLoopGenerator;
import org.polymodel.scop.dtiler.DTilingOptions;

import tom.library.sl.VisitFailure;


/**
 * Build tile loops from a {@link ScopFor}. Conditions of the loops are stored
 * in a list of equations. The given loop is assumed to be perfectly nested without any statements.
 * 
 * @author antoine
 * 
 */
@SuppressWarnings("all")
public class DTilerTileLoops extends AbstractTileLoopGenerator {

  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include { dtiler.tom }

  private ScopFor innermost = null;

  public DTilerTileLoops(DTilingOptions options) {
	  super(options);
  }

  public TileLoop generate(ScopFor perfectNest, Set<String> untiledPointLoopIterators) {
	  //Ignoring the names of the loop iterators of loops which are not tiled
	  return generate(perfectNest);
  }

  public TileLoop generate(ScopFor perfectNest) {
	  try {
	  	ScopFor res = (ScopFor)`BottomUp(TileLoopStrategy(options)).visitLight(EcoreUtil.copy(perfectNest),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
		//get to the inner most loop
		ScopFor innermost = res;
		
		while (innermost.getBody() != null) {
			if (innermost.getBody() instanceof ScopBlock) {
				innermost = (ScopFor)(((ScopBlock)innermost.getBody()).getStatements().get(0));
			} else {
				innermost = (ScopFor)innermost.getBody();
			}
		}

	  	TileLoop tl = new TileLoop(res, innermost);
	  	return tl;
	  } catch (VisitFailure vf) {
		  vf.printStackTrace();
		  throw new RuntimeException("VisitFailure at DTilerTileLoops : " + vf.getMessage());
	  }
  }

  %strategy TileLoopStrategy(options:DTilingOptions) extends Identity() {
    visit node {
      o@loop(ite,lb,ub,_,body) -> {
    	  //System.out.println("visiting tiled loop: " + `o);
    	  int depth = `o.getLoopDepth();	//depth within the whole loop nest, starts from 1
    	  AffineExpression tileSize = IntExpressionBuilder.affine(options.getTileSize(depth+options.tilingBand.getStart()));
    	  Variable tileIndex = options.getTileIndex(depth+options.tilingBand.getStart());
    	  
    	  IntExpression lbe = Shift.down(`lb,`ite, options);
    	  //up transformation is missing
    	  IntExpression ube = Shift.up(`ub,`ite, options);
    	  lbe = lbe.substitute(`ite, tileIndex);
    	  ube = ube.substitute(`ite, tileIndex);
    	  
    	  //rename indices of outer dimensions to tile indices
    	  List<ScopFor> loops = `o.getSurroundingScopFors();
    	  for (int i = 1; i < depth; i++) {
    		  Variable lite = loops.get(i-1).getIterator();
    		  lbe = lbe.substitute(lite, options.getTileIndex(i+options.tilingBand.getStart()));
    		  ube = ube.substitute(lite, options.getTileIndex(i+options.tilingBand.getStart()));
    	  }
    	  
    	  //create new upper bound and lower bound for the current loop
    	  IntExpression offset = options.tilingBand.getOffset(depth);
    	  if(offset != null){	//construct lower bounds with offset
    		  lbe = IntExpressionBuilder.sub(lbe, offset.copy());
    		  lbe = IntExpressionBuilder.symbolicCeil(lbe, tileSize.copy());
    		  List<IntExpression> exprs = new LinkedList<IntExpression>();
    		  exprs.add(IntExpressionBuilder.prod(lbe, tileSize.copy()));
    		  exprs.add(offset);
    		  lbe = IntExpressionBuilder.sum(exprs);
    	  }else{
    		  lbe = IntExpressionBuilder.symbolicCeil(lbe, tileSize);
    		  lbe = IntExpressionBuilder.prod(lbe, tileSize.copy());
    	  }
    	  
    	  AbstractScopNode tileLoop = `loop(tileIndex, lbe.simplify(), ube.simplify(), tileSize, body);
    	  //add tiled loop annotations to save the tiled loop informations
    	  tileLoop.getScopAnnotations().add(ScopUserFactory.tileLoopAnnotation(`tileIndex, `tileSize, options.tilingBand.getOffset(depth)));
    	  
    	  return tileLoop;
      }
    }
 
  }
}