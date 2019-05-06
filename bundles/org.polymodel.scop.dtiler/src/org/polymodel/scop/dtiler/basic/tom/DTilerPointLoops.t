package org.polymodel.scop.dtiler.basic;


import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.max;
import static org.polymodel.algebra.factory.IntExpressionBuilder.min;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sum;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.AbstractPointLoopGenerator;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.VectorizationAnnotation;
import org.polymodel.scop.dtiler.opt.LoopVectorization;

import tom.library.sl.VisitFailure;


/**
 * Build point loops from a {@link AbstractScopNode}. The given node is assumed to be either a block of loopnests in a ScopBlock,
 * or a single ScopFor. In bothe cases, the loop nests must be full dimensional.
 * 
 * @author antoine
 * 
 */
@SuppressWarnings("all")
public class DTilerPointLoops extends AbstractPointLoopGenerator{

	
  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include{ dtiler.tom }


  public DTilerPointLoops(DTilingOptions options) {
	  super(options);
  }

  public AbstractScopNode generate(ScopFor loopNest) {
	  return generateForBoth(loopNest);
  }

  public AbstractScopNode generate(ScopBlock loopNests) {
	  return generateForBoth(loopNests);
  }

  protected AbstractScopNode generateForBoth(AbstractScopNode loopNest) {
	  try {
	  	AbstractScopNode res = `BottomUp(PointLoopStrategy(options)).visitLight(EcoreUtil.copy(loopNest),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
	  	//post processing for vectorization pragma attachment
	  	if(options.vectorizable){
	  		LoopVectorization.vectorizeInnermost(res, -1);
	  	}
	  	
	  	return res;
	  } catch (VisitFailure vf) {
		  vf.printStackTrace();
		  throw new RuntimeException("VisitFailure at DTilerTileLoops : " + vf.getMessage());
	  }
  }

  %strategy PointLoopStrategy(options:DTilingOptions) extends Identity() {
    visit node {
      o@loop(_,lb,ub,_, _) -> {
    	  //System.out.println("visiting point loop: " + `o);
    	  int depth = ((ScopFor)`o).getLoopDepth();
    	  Variable tileIndex = options.getTileIndex(depth+options.tilingBand.getStart());
    	  //get the last level tile index expression and tile size
    	  AffineExpression tiExpr = IntExpressionBuilder.affine(IntExpressionBuilder.term(tileIndex));
    	  AffineTerm tileSize = options.getTileSize(depth+options.tilingBand.getStart());
    	  IntExpression newLB = lower(EcoreUtil.copy(tiExpr), `lb);
    	  IntExpression newUB = upper(tiExpr, tileSize, `ub);
    	  ((ScopFor)`o).setLB(newLB);
    	  ((ScopFor)`o).setUB(newUB);
    	  
    	  //System.out.println("The new point loop " + `o);
    	  return ((ScopFor)`o).simplify();
      }
    }
 
  }


  private static IntExpression lower(AffineExpression tileIndex, IntExpression lb){
	  return max(tileIndex, lb);
  }

  private static IntExpression upper(AffineExpression tileIndex, AffineTerm tileSize, IntExpression ub){
	  return min(sum(tileIndex, affine(tileSize), affine(term(-1))), ub);
  }
}