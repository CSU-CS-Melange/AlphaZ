package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;

/**
 * Variable isolation tool.
 * 
 * @author antoine 
 * 
 */
@SuppressWarnings("all")
public class Isolate{ 

	%include { sl.tom }

	%include { algebra_common.tom}   
	%include { algebra_terminals.tom}  
	%include { algebra_all_ops.tom} 
 
	private static boolean DEBUG=false;

	private static void debug(String mess) {
		if(DEBUG) {
			System.out.println(mess);
		} 
	}
 
	/** 
	 * Build an new constraint, where the specified variable is isolated on the LHS
	 * with coeficent 1 . Input constraint isn't modified.
	 * 
	 * @param constraint 
	 * @param var variable to isolate
	 * @return a new constraint
	 */
	public static IntConstraint isolateToLhs(IntConstraint constraint, Variable var) {
		IntConstraint tmp = constraint.copy();
		ComparisonOperator op = tmp.getComparisonOperator();
		IntExpression expression = IntExpressionBuilder.sub(tmp.getLhs(), tmp.getRhs()).simplify();
		IntExpression rhs = null;
		IntExpression lhs = null;

		%match (expression) {
			affine(terms(x1*,term(coef,varia),x2*)) -> {	
				if(`varia==var) {
					if(`coef < 0) { //move var to rhs => coef become > 0 => div by coef donot change comparison operator ; then switch lhs and rhs => inverse(op)
						lhs = `affine(terms(term(1, varia)));
						rhs = `affine(terms(x1*,x2*));
						if(`coef < -1)
							rhs = `qaffine(terms(floor(rhs, -coef)));
						op = ComparisonOperator.negateOperator(op);
					}
					else {//keep var on lhs, move others to rhs
						lhs = `affine(terms(term(1,varia)));
						rhs = ArithmeticOperations.scale(`affine(terms(x1*,x2*)),-1);
						if(`coef > 1)
							rhs = `qaffine(terms(floor(rhs, coef)));
					}
					return `contraint(lhs, op, rhs);
				}
			}

			sum(EL(exp1*, affine(terms(x1*,term(coef,varia),x2*)), exp2*)) -> {
				if(`varia==var) { 
					if(`coef < 0) { //move var to rhs => coef become > 0 => div by coef donot change comparison operator ; then switch lhs and rhs => inverse(op)
						lhs = `affine(terms(term(1, varia)));
						rhs = `sum(EL(exp1*, affine(terms(x1*,x2*)), exp2*));
						if(`coef < -1)
							rhs = `qaffine(terms(floor(rhs, -coef)));
						op = ComparisonOperator.negateOperator(op);
					}
					else {//keep var on lhs, move others to rhs
						lhs = `affine(terms(term(1,varia)));
						rhs = ArithmeticOperations.scale(`sum(EL(exp1*, affine(terms(x1*,x2*)), exp2*)),-1);
						if(`coef > 1)
							rhs = `qaffine(terms(floor(rhs, coef)));
					}
					return `contraint(lhs, op, rhs);
				}
			}
		}
		return null; 
		//throw new RuntimeException("Isolating "+var+" in "+constraint+"not implemented yet!");
	}

	/**
	 * Build an expression corresponding to a variable isolation. Variable is removed and
	 * other terms are negated. Input expression isn't modified.
	 * 
	 * @param expression 
	 * @param var variable to isolate
	 * @return a new expression
	 */
	/* Isolating a var in a IntExpression doesn't make much sense */
	@Deprecated
	public static IntExpression isolate(IntExpression expression, Variable var) {
		try {
			return `OnceTopDown(VariableIsolation(var)).visitLight(expression, tom.mapping.GenericIntrospector.INSTANCE); 
		} catch(Exception e) { 
			e.printStackTrace(); 
			throw new RuntimeException("Visitor failure on "+expression+ ":"+e.getMessage());
		}
	}
  
	%strategy VariableIsolation(var:V) extends Identity() {
		visit E {
			affine(terms(x1*,term(k,var),x2*)) -> {
				if(`var==var) {
					AffineExpression res= ArithmeticOperations.scale((AffineExpression)`affine(terms(x1*,x2*)),-1);
					if (`k==1 || `k==-1) {					
						return `res; 
					}
					else
						return `qaffine(terms(floor(res,k)));
				}
			}
			a -> {
					debug("Fail on "+`a+" with " +`var+" for "+var);
					throw new RuntimeException("Fail in Isolate("+`a+") for "+var);  
			}
		} 
	}
}
