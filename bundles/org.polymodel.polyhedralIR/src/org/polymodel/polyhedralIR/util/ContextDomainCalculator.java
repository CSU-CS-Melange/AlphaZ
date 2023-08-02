package org.polymodel.polyhedralIR.util;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

public class ContextDomainCalculator extends PolyhedralIRInheritedDepthFirstVisitorImpl {

	private static final ContextDomainCalculator calc = new ContextDomainCalculator();
	
	public static void computeContextDomain(Program program) {
		program.accept(calc);
	}
	
	public static void computeContextDomain(AffineSystem system) {
		system.accept(calc);
	}
	
	public static void computeContextDomain(Expression expr) {
		expr.accept(calc);
	}

	protected ContextDomainCalculator() {
		super();
	}
	
	@Override
	public void visitWhileInfo(WhileInfo w) {
		// Do nothing for now TODO
	}

	@Override
	public void inExpression(Expression expr) {
		Domain context;
		//If the parent is an Expression, intersect its expression domain with its parent to get the context domain
		if (expr.eContainer() != null && expr.eContainer() instanceof Expression) {
			context = ((Expression)expr.eContainer()).getContextDomain();
		} else if (expr.eContainer() != null && expr.eContainer() instanceof StandardEquation) {
			context = ((StandardEquation)expr.eContainer()).getVariable().getDomain();
		} else if (expr.eContainer() != null && expr.eContainer() instanceof UseEquation) {
			UseEquation ueqCont = (UseEquation) expr.eContainer();
			
			// Solution currently implemented: [context = input variable domain in the subsystem]
			int numInp = ueqCont.getInputs().indexOf(expr);
			if (numInp == -1)
				throw new RuntimeException("Input do not appear in the UseEquation that contains it");
			Domain contextTemp = ueqCont.getSubSystem().getInputs().get(numInp).getDomain();
			
			context = DomainOperations.translateParams(contextTemp, ueqCont.getParameters(), ueqCont.getExtensionDomain());
			
		} else if (expr.eContainer() != null && expr.eContainer() instanceof WhileInfo) {
			return;
//			WhileInfo wi = (WhileInfo)expr.eContainer();
//			
//			context = EcoreUtil.copy(wi.getTimeDomain());
//			// TODO;
//			throw new UnsupportedOperationException("Calculation of context domain for condition expresion of the while loop is not yet implemented!");
		} else {
			throw new RuntimeException("Unexpected container of expression : " + expr.eContainer());
		}
		
		// Take the image of context domain by the dependence function, in the case of dependence expression
		if (expr.eContainer() instanceof DependenceExpression) {
			context = context.image(((DependenceExpression)expr.eContainer()).getDep());
		}
		// Take the pre-image of context domain by the projection function, in the case of reduce expression
		if (expr.eContainer() instanceof ReduceExpression)
			context = context.preimage(((ReduceExpression)expr.eContainer()).getProjection());
		
		
		/* DEBUG
		System.out.println(expr);
		System.out.println("DEBUG (context computation):");
		System.out.println(" - ExprDom = " + expr.getExpressionDomain().toString());
		System.out.println(" - Temp ContDom = " + context.toString());
		System.out.println();//*/
	
		// Two cases when one of them does not have any constraints or if only parameter domains are involved
		if ((expr.getExpressionDomain().isUniverse()) || (expr.getExpressionDomain().getNIndices() == 0)) {
			expr.setContextDomain(context.copy());
		} else if ((context.isUniverse()) || (context.getNIndices() == 0)) {
			expr.setContextDomain(expr.getExpressionDomain().copy());
		// When both domains have some constraints
		} else {
			
			/* DEBUG
			System.out.println(PolyhedralIRToAlphabets.toString(expr));
			System.out.println("context = " + context.toString());
			if (context instanceof FastISLDomain) {
				System.out.println("context.islSet() = " + ((FastISLDomain) context).getIslSet().toString());
				System.out.println("context.domDims() = " + ((FastISLDomain) context).getDomDims().toString());
			}
			System.out.println("exprDom = " + expr.getExpressionDomain().toString());
			if (expr.getExpressionDomain() instanceof FastISLDomain) {
				System.out.println("exprDom.islSet() = " + ((FastISLDomain) expr.getExpressionDomain()).getIslSet().toString());
				System.out.println("exprDom.domDims() = " + ((FastISLDomain) expr.getExpressionDomain()).getDomDims().toString());
			}
			System.out.println();
			//*/
			
			expr.setContextDomain(expr.getExpressionDomain().intersection(context));
			int x = 0;
		}
		
		expr.getContextDomain().simplify();
	}
	
	
} // ContextDomainCalculator
