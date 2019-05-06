package org.polymodel.scop.dtiler.hierarchy.basic;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class SubstituteVariable  {

  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
  %include { algebra_affine.tom }
  %include { algebra_defaultOperators.tom }
  %include { algebra_reductions.tom }


 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include { dtiler.tom }


	/**
	 * Shift up an expression. Shifted expression isn'modified and has to be
	 * contained into a {@link ScopFor} in order to find outer indexes.
	 * 
	 * @param e
	 * @param options
	 * @return
	 */
  public static IntExpression substitute(IntExpression af, Variable v, IntExpression newExpr){
	  SubstituteVariable t = new SubstituteVariable();
	  try{
		  IntExpression s  = t.subVarWithExpression(af, v, newExpr);
		  return s;
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }

  protected IntExpression subVarWithExpression(IntExpression af, Variable v, IntExpression newExpr) throws VisitFailure{
	  //System.out.println("handle expression " + af + " variable " + v.getName() + " with expression " + newExpr);
	  IntExpression res = `BottomUp(subTrans(v, newExpr)).visitLight(af,tom.mapping.GenericIntrospector.INSTANCE);;

	  return res;
  }
  /**
    Convert affine expression to summation of affine terms to make it easier to deal with.
    The result of ShiftUp/Down is no longer an affine expression.
  */
  %strategy toSummation() extends Identity() { 
  	visit E {
  		//remove empty affine
  		sum(EL(x1*, affine(terms()), x2*)) -> {return `sum(EL(x1*,x2*)); } 
  		//merge summations
  		sum(EL(x1*, sum(EL(y*)), x2*)) -> {return `sum(EL(x1*, y*, x2*)); }
  		//outline affine terms
  		affine(terms(x1, x2, x3*)) -> { return `sum(EL(affine(terms(x1)), affine(terms(x2,x3*))));} 
 	 } 
  }

  %strategy subTrans(idx : V, newExpr: E) extends Identity() {
    visit E {
    	affine(terms(term(c,v))) -> {
    			//System.out.println("current variable " + `v);
    			//all expressions involving outer loop indices (not including the current loop)
    			if((`v != null) && (`v.getName().contentEquals(idx.getName()))){
    			if(`c > 1){
    				return  `prod(EL(affine(terms(constant(c))), newExpr.copy()));
    			}else{
    				return newExpr.copy();
    			}
    		}
    	}
    }
 
  }


}