package org.polymodel.polyhedralIR.transformation.reduction;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;
import org.polymodel.util.PolymodelException;

/**
 * Applies TransformReductionBody, a transformation that transforms the domain of the reducion body,
 * without changing the domain of other variables. It is a variation of Change of Basis.
 * 
 * Given ReduceExpression reduce(op, proj, expr) and AffineFunction T, transforms the reduction to
 * reduce(op, proj, image(expr) : Tinv@expr)
 * The domain is transformed to the image by T, and specified as restrict. All variable accesses are composed
 * with the inverse of T, so that other variables are unchanged.
 * 
 * This transformation should be followed by Normalize to propagate the dependency and restrict expression introduced
 * 
 * @author yuki
 *
 */
public class TransformReductionBody {

	public static void apply(StandardEquation eq, AffineFunction T) {
		if (eq.getExpression() instanceof ReduceExpression) {
			apply((ReduceExpression)eq.getExpression(), T);
		}
	}
	
	public static void apply(ReduceExpression reduce, AffineFunction T) {
		transformReductionBody(reduce, T);
	}
	
	protected static void transformReductionBody(ReduceExpression reduce, AffineFunction T) {
		//basic check
		if (T == null) {
			throw new RuntimeException("Transformation T is not given.");
		}
		//check if T is bijective in context
		AffineFunction Tinv;
		try {
			Tinv = T.inverseInContext(reduce.getExpr().getContextDomain(), null);
		} catch (PolymodelException pe) {
			throw new RuntimeException("Given transformation is not bijective.");
		}
		
		DependenceExpression dep = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(Tinv, reduce.getExpr());
		RestrictExpression restrict = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(dep.getExpr().getContextDomain().image(T), dep);
		reduce.setExpr(restrict);
		
		AffineSystem syst;
		if (dep.getContainerEquation() instanceof StandardEquation)
			syst = ((StandardEquation)dep.getContainerEquation()).getContainerSystem();
		else
			syst = ((UseEquation)dep.getContainerEquation()).getContainerSystem();
		
		ExpressionDomainCalculator.computeExpressionDomain(syst);
		ContextDomainCalculator.computeContextDomain(syst);
	}
}
