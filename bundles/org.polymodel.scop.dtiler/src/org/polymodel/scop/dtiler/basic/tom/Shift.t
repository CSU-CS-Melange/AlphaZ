package org.polymodel.scop.dtiler.basic;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.AlgebraVisitorImpl;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class Shift   {

  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
  %include { algebra_affine.tom }
  %include { algebra_defaultOperators.tom }
  %include { algebra_reductions.tom }


 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include { dtiler.tom }

  protected final DTilingOptions _options;
  private Variable var;

  protected Shift(Variable v, DTilingOptions options) {
	  this.var = v;
	  _options = options;
  }


	/**
	 * Shift up an expression. Shifted expression isn'modified and has to be
	 * contained into a {@link ScopFor} in order to find outer indexes.
	 * 
	 * @param e
	 * @param options
	 * @return
	 */
  public static IntExpression up(IntExpression af, Variable v, DTilingOptions options){
	  Shift t = new Shift(v, options);
	  try{
		  IntExpression s  = t.shiftUp(af);
		  return s;
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }

	/**
	 * Shift down an expression. Shifted expression isn'modified and has to be
	 * contained into a {@link ScopFor} in order to find outer indexes.
	 * 
	 * @param e
	 * @param options
	 * @return
	 */
  public static IntExpression down(IntExpression af, Variable v, DTilingOptions options){
	  Shift t = new Shift(v, options);
	  try{
		  IntExpression s  = t.shiftDown(af);
		  return s;
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }

  /**
    Perform a shift with c > 0 as constraint and then append the original affine expression.
    ShiftUp procedure from DaeGon's thesis.
  */
  protected IntExpression shiftUp(IntExpression expr) throws VisitFailure {
	  IntExpression af = expr.copy();
	  EList<Variable> indices = DTilingTools.findSurroundingLoopIndices(expr);
	  int depth = indices.indexOf(var)+1; //depth is from 1
	  
	  //ShiftBounds shifts = new ShiftBounds(var, _options, indices, true);
	  //af.accept(shifts);
	  //return af;
	  IntExpression sumForm = `InnermostId(toSummation()).visitLight(expr,tom.mapping.GenericIntrospector.INSTANCE);
	  IntExpression res = `BottomUp(ShiftTrans(var,_options,indices, true)).visitLight(sumForm,tom.mapping.GenericIntrospector.INSTANCE);

	  return res;
	  //return `sum(EL(af, res)).simplify();
  }


  /**
    Perform a shift with c < 0 as constraint and then append the original affine expression, and -c*(sk-1) .
    ShiftDown procedure from DaeGon's thesis.
  */
  protected IntExpression shiftDown(IntExpression expr) throws VisitFailure {
	  IntExpression af = expr.copy();
	  EList<Variable> indices = DTilingTools.findSurroundingLoopIndices(expr);
	  int depth = indices.indexOf(var) + 1; //depth is from 1
	  AffineTerm tilesize = _options.getTileSize(depth+_options.tilingBand.getStart());
	 
	  IntExpression sumForm = `InnermostId(toSummation()).visitLight(expr,tom.mapping.GenericIntrospector.INSTANCE);
	  IntExpression res = `BottomUp(ShiftTrans(var,_options,indices, false)).visitLight(sumForm,tom.mapping.GenericIntrospector.INSTANCE);
	  res = `sum(EL(res, prod(EL(affine(terms(constant(-1))), affine(terms(tilesize, constant(-1)))))));

	  return res;
	  //return `sum(EL(af, res)).simplify();
  }

  private static class ShiftBounds extends AlgebraVisitorImpl{
	 protected Variable target;
	 protected boolean up;
	 protected DTilingOptions options;
	 protected List<Variable> indices;

	 public ShiftBounds(Variable _target, DTilingOptions _options, List<Variable> _vars, boolean _up){
		 target = _target;
		 up = _up;
		 options = _options;
		 indices = _vars;
	 }

	 @Override
	  public void visitAffineTerm(AffineTerm a) {
		 //System.out.println("visite affine term " + a);
		 Variable var = a.getVariable();
		if (var != target && indices.contains(var)){
			int coef = (int)a.getCoef();
			if((up && coef > 0) || (!up && coef < 0)){
				IntExpression shift_expr = IntExpressionBuilder.add(IntExpressionBuilder.affine(options.getTileSize(indices.indexOf(var)+1)), -1);
				IntExpression prod_expr = IntExpressionBuilder.prod(shift_expr, IntExpressionBuilder.constant(coef));
				IntExpression sum_expr = IntExpressionBuilder.sum(IntExpressionBuilder.affine(EcoreUtil.copy(a)), prod_expr);
				EcoreUtil.replace(a, sum_expr);
			}
        }
      }
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

  %strategy ShiftTrans(idx : V, options:DTilingOptions, indices: vars, up : boolean) extends Identity() {
    visit E {
    	affine(terms(term(c,v))) -> {
    			//all expressions involving outer loop indices (not including the current loop)
    			if(`v != idx && indices.contains(`v)){
    				//whose coefficient is positive when up and negative when down (= !up)
    				if((`up && `c > 0) || (!`up && `c < 0)) {
    					//temp = temp + c * (tilesize - 1)
    					IntExpression e = `affine(terms(options.getTileSize(indices.indexOf(v)+1), constant(-1)));
    					if(`c != 1){
    						e = `prod(EL(affine(terms(constant(c))), e));
    					}
    					e = `sum(EL(affine(terms(term(c,v))),e));
    					return `e;
    				}
    			}
    			//others are removed
    			//return `affine(terms(constant(0)));
    	}
 //   	affine(terms(constant(_))) -> {
 //  			return `affine(terms(constant(0)));
 //   	}
 
    }
 
  }


}