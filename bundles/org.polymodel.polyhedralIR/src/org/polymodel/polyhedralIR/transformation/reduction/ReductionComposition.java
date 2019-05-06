package org.polymodel.polyhedralIR.transformation.reduction;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;

/**
 * Composes the given reduction with its immediate child assuming that it is also a reduction with the same operator.
 * 
 * In other words, this transformation implements the following
 *   reduce(op, f1, reduce(op, f2, body));
 * =>
 *   reduce(op, f1 o f2, body);
 * and is the reverse of ReductionDecomposition.
 * 
 * Added support for the case when there is a restrict expression surrounding the inner reduction.
 * 
 * @author yuki
 *
 */
public class ReductionComposition {

	
	public static void transform(ReduceExpression re) {
		
		final ReduceExpression innerRE;
		final RestrictExpression outerRestrict;
		if (re.getExpr() instanceof ReduceExpression) {
			outerRestrict = null;
			innerRE =  (ReduceExpression)re.getExpr();
		} else if (re.getExpr() instanceof RestrictExpression && ((RestrictExpression)re.getExpr()).getExpr() instanceof ReduceExpression) {
			outerRestrict = (RestrictExpression)re.getExpr();
			innerRE = (ReduceExpression)outerRestrict.getExpr();
		} else {
			throw new RuntimeException("The body of the reduction given to ReductionComposition is not a reduction.");
		}
		
		if (innerRE.getOP() != re.getOP()) {
			throw new RuntimeException("The operator of the two reductions to be composed does not match.");			
		}

		AffineFunction f1 = re.getProjection();
		AffineFunction f2 = innerRE.getProjection();
		AffineFunction f= f1.compose(f2);
		
		Expression innerExpr;
		if (outerRestrict == null) {
			innerExpr = innerRE.getExpr().copy();
		} else {
			innerExpr = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(
					outerRestrict.getRestrictDomain().preimage(innerRE.getProjection()),
					innerRE.getExpr().copy());
			}
		
		ReduceExpression newRed = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(
				re.getOP(), f, innerExpr);
		//Update all references to the original object
		EcoreUpdater.update(re, newRed);

	}

}
