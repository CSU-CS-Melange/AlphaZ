package org.polymodel.polyhedralIR.recurrence.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.*;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

//import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import tom.library.sl.VisitFailure;

public class SimpleExpressionEquivalence {

	protected final Expression expr1;
	protected final Expression expr2;

	public static boolean check(Expression e1, Expression e2) {
		SimpleExpressionEquivalence see = new SimpleExpressionEquivalence(e1, e2);
		return see.apply();
	}

	protected SimpleExpressionEquivalence(Expression e1, Expression e2) {
		expr1 = e1;
		expr2 = e2;
	}

	protected boolean apply() {
		try {
			List<Expression> exprs = new ArrayList<Expression>(2);
			exprs.add(expr1.copy());
			exprs.add(expr2.copy());
			CaseExpression caseExpr = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(exprs);

			CaseExpression expr = `InnermostId(check()).visitLight(caseExpr, tom.mapping.GenericIntrospector.INSTANCE);

			//System.out.println(PolyhedralIRToAlphabets.toString(expr));

			return expr.getExprs().size() == 0;
		} catch (VisitFailure e) {
			e.printStackTrace();
			return false;
		}
	}
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy check() extends Identity() {
		visit Expression {
			caseExpr@caseExpr(exprList(binOp(op, lexpr, rexpr1), binOp(op, lexpr, rexpr2))) ->{
				return `caseExpr(exprList(rexpr1, rexpr2));
			}
			//base case
			caseExpr@caseExpr(exprList(var(v), var(v))) ->{
				return `caseExpr(exprList());
			}
		}
	}


}