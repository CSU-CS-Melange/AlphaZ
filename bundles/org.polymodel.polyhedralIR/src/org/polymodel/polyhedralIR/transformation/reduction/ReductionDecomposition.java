package org.polymodel.polyhedralIR.transformation.reduction;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;

/**
 * Decomposes the given reduction into two reductions.
 * Two functions given are used as the projection functions of the decomposed reductions.
 * f1 composed with f2 should be equivalent to the original projection function.
 * 
 * @author yuki
 *
 */
public class ReductionDecomposition {
	
	public static void transform(ReduceExpression re, AffineFunction f1, AffineFunction f2) {
		//Check for equivalence of the projection functions
		if (f1.compose(f2).equivalence(re.getProjection())) {
			//Create new reductions
			ReduceExpression inner = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(re.getOP(), f2, re.getExpr().copy());
			ReduceExpression newRed = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(re.getOP(), f1, inner);
			//Update all references to the original object
			EcoreUpdater.update(re, newRed);

			ContextDomainCalculator.computeContextDomain(newRed);
			RestrictExpression restrictedInner = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(
					inner.getContextDomain(),
					inner.copy()
			);
			EcoreUpdater.update(inner, restrictedInner);
		} else {
			throw new RuntimeException(f1 + " o " + f2 + " does not equal to the original projection function : " + re.getProjection());
		}
	}

}
