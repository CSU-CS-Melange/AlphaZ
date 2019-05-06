package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

/**
 * 
 * 
 * @author yuki
 *
 */
public class SplitReductionBody {

	public static void apply(StandardEquation eq, Domain newDomain) {
		if (eq.getExpression() instanceof ReduceExpression) {
			apply((ReduceExpression)eq.getExpression(), newDomain);
		}
	}
	
	public static void apply(ReduceExpression reduce, Domain newDomain) {
		splitReductionBody(reduce, newDomain);
	}
	
	protected static void splitReductionBody(ReduceExpression reduce, Domain newDomain) {
		//basic check
		if (newDomain == null) {
			throw new RuntimeException("Domain to split is not given.");
		}
		//check dimensionality
		if (newDomain.getDim() != reduce.getExpr().getContextDomain().getDim()) {
			throw new RuntimeException("Dimension of the new domain does not match the body of reduction.");
		}
		
		//subtract the new domain with original domain to get the domain that stays
		Domain stayDom = reduce.getExpr().getContextDomain().difference(newDomain);
		//take the intersection to find out the domain of new variable
		Domain splitDom = reduce.getExpr().getContextDomain().intersection(newDomain);
		
		//check split/stay domain
		if (stayDom.isEmpty()) {
			throw new RuntimeException("Given domain is the super set of the original domain.");
		}
		if (splitDom.isEmpty()) {
			throw new RuntimeException("Given domain does not intersect with the original domain.");
		}
		
		//Create a copy of reduction restricted to the stay domain
		RestrictExpression stayRestrict = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(stayDom, reduce.getExpr().copy());
//		ReduceExpression stayReduce = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(reduce.getOP(), reduce.getProjection().copy(), stayRestrict);
		//Create another one restricted split domain
		RestrictExpression splitRestrict = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(splitDom, reduce.getExpr().copy());
//		ReduceExpression splitReduce = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(reduce.getOP(), reduce.getProjection().copy(), splitRestrict);
		//combine the two by binary expression
//		BinaryExpression splitExpr = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(reduce.getOP(), splitReduce, stayReduce);
		List<Expression> exprs = new LinkedList<Expression>();
		exprs.add(stayRestrict);
		exprs.add(splitRestrict);
		CaseExpression caseExpr = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(exprs);
		
		reduce.setExpr(caseExpr);
		
//		System.err.println(reduce.getContainerEquation().getContainerSystem());
		
		if (reduce.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement this for UseEquation");
		PermutationCaseReduce.caseReduce((StandardEquation)reduce.getContainerEquation());
//		//replace the original reduce with the binary expression
//		EcoreUtil.replace(reduce, splitExpr);
	}
}
