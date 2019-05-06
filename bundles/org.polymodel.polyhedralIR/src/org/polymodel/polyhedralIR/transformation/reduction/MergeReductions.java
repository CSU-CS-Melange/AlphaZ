package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;

public class MergeReductions {
	
	private static final PolyhedralIRUserFactory fact = PolyhedralIRUserFactory.eINSTANCE;

	public static void apply(BinaryExpression binExpr) {
		if (!(binExpr.getLexp() instanceof ReduceExpression)) {
			throw new RuntimeException("LExp of given binary expression is not a reduction.");
		}
		if (!(binExpr.getRexp() instanceof ReduceExpression)) {
			throw new RuntimeException("RExp of given binary expression is not a reduction.");
		}
		ReduceExpression reduceL = (ReduceExpression)binExpr.getLexp();
		ReduceExpression reduceR = (ReduceExpression)binExpr.getRexp();
		
		//OP check
		if (reduceL.getOP() != reduceR.getOP()) {
			throw new RuntimeException("Operators of two reductions do no match.");
		}
		if (reduceL.getOP() != binExpr.getOperator()) {
			throw new RuntimeException("Operator of reductions and binary expression do not match.");
		}
		if (!reduceL.getProjection().equivalence(reduceR.getProjection())) {
			throw new RuntimeException("Projection functions of two reductions do no match.");
		}

		Domain domI = reduceL.getExpr().getContextDomain().intersection(reduceR.getExpr().getContextDomain());
		
		List<Expression> exprs = new LinkedList<Expression>();
		Domain LsubI = reduceL.getExpr().getContextDomain().difference(domI);
		if (!LsubI.isEmpty()) {
			exprs.add(fact.createRestrictExpression(LsubI, reduceL.getExpr().copy()));
		}
		
		Domain RsubI = reduceR.getExpr().getContextDomain().difference(domI);
		if (!RsubI.isEmpty()) {
			exprs.add(fact.createRestrictExpression(RsubI, reduceR.getExpr().copy()));
		}
		
		if (!domI.isEmpty()) {
			exprs.add(fact.createRestrictExpression(domI, fact.createBinaryExpression(binExpr.getOperator(), reduceL.getExpr(), reduceR.getExpr())));
		}
		
		CaseExpression caseExpr = fact.createCaseExpression(exprs);
		EcoreUpdater.update(binExpr, fact.createReduceExpression(binExpr.getOperator(), reduceL.getProjection().copy(), caseExpr));
		
	}
}
