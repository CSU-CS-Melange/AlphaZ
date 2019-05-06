package org.polymodel.algebra.tom;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.polynomials.PolynomialVariable;

/**
 * Variable isolation tool.
 * 
 * @author antoine
 * 
 */
@SuppressWarnings("all")
public class Replace{

	%include { sl.tom }

	%include { algebra_common.tom}   
	%include { algebra_terminals.tom}    
	%include { algebra_all_ops.tom}      

	/**
	 * Build an expression corresponding to a variable isolation. Variable is removed and
	 * other terms are negated. Input expression isn't modified.
	 * 
	 * @param expression 
	 * @param var variable to isolate
	 * @return a new expression
	 */
	public static IntExpression newExpr;
	public static boolean VERBOSE=false;  

	public static IntExpression replace(IntExpression expression, Variable var,IntExpression anewExpr) {
		try {
			newExpr= anewExpr;
			return `OnceTopDown(VariableReplacement(var)).visitLight(expression, tom.mapping.GenericIntrospector.INSTANCE); 
		} catch(Exception e) { 
			e.printStackTrace(); 
			throw new RuntimeException("Visitor failure on "+expression+ ":"+e.getMessage());
		}
	}

	%strategy VariableReplacement(var:V) extends Identity() {
		visit E {
			affine(terms(x1*,term(a,var),x3*)) 	-> {
				IntExpression newRes= newExpr.copy();
				IntExpression scaleExpr = ArithmeticOperations.scale(newRes, `a);
				%match(scaleExpr) {
					affine(terms(z*)) -> {
						if ( `var == var) {
							IntExpression newExpr = `affine(terms(x1*,x3*,z*)); 
							debug("r1 ", newExpr);
							return newExpr.simplify();
						}
					 }
					qaffine(terms(z*)) -> {
						if ( `var == var) {
							IntExpression affExpr = `affine(terms(x1*,x3*));
							IntExpression newExpr = `qaffine(terms(mul(affExpr,1),z*));
							debug("r2 ", newExpr);
							return newExpr.simplify();
						} 
					 }
					 _ -> {
						 	if ( `var == var ) {
						 		return `sum(EL(affine(terms(x1*,x3*)),
						 					ArithmeticOperations.scale(newRes,a))).simplify();
						 	}
					 }
				}
			}  
		}  
	}

	private static void debug(String name, IntExpression intExpression) {
		if(VERBOSE)
			System.out.println("rule "+name+" :\n\t"+intExpression);
	}
}