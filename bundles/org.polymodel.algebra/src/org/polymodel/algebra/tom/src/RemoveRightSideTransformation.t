package org.polymodel.algebra.tom;

import static org.polymodel.algebra.tom.ArithmeticOperations.add;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;

/**
 * Variable isolation tool.
 *   
 * @author antoine
 *   
 */
@SuppressWarnings("all")
public class RemoveRightSideTransformation{

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

	public static IntConstraint transform(IntConstraint expression) {
		try {
			return `OnceTopDown(RemoveRightSide()).visitLight(expression.copy(), tom.mapping.GenericIntrospector.INSTANCE); 
		} catch(Exception e) { 
			//e.printStackTrace(); 
			throw new RuntimeException("Visitor failure on "+expression, e);
		}
	}
 
	%strategy RemoveRightSide () extends Identity() {
		visit C {
			eq(l@_,r@_) -> {return `eq(IntExpressionBuilder.sub(l,r),affine(terms(constant(0))));}
			ne(l@_,r@_) -> {return `ne(IntExpressionBuilder.sub(l,r),affine(terms(constant(0))));}
			ge(l@_,r@_) -> {return `ge(IntExpressionBuilder.sub(l,r),affine(terms(constant(0))));}
			gt(l@_,r@_) -> {return `ge(IntExpressionBuilder.sub(l,add(r,1L)),affine(terms(constant(0L))));}
			le(l@_,r@_) -> {return `ge(IntExpressionBuilder.sub(r,l),affine(terms(constant(0))));}
			lt(l@_,r@_) -> {return `ge(IntExpressionBuilder.sub(r,add(l,1L)),affine(terms(constant(0L))));}
		} 
	}
}