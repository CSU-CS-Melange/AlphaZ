package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;

public class ManageUnarySubstraction extends PolyhedralIRDepthFirstVisitorImpl {
	private static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	/**
	 * Perform the following transformation: " - ( (i->)@Const) " ===>  " (i->)@(-Const) "
	 * 	=> this happens frequently, when parsing a .ab program with a -const
	 * 
	 * @param prog
	 */
	public static void manageUnarySubstraction(Program prog) {
		for (AffineSystem syst : prog.getSystems()) {
			ManageUnarySubstraction visitor = new ManageUnarySubstraction();
			syst.accept(visitor);
		}
	}
	
	/**
	 * Perform the following transformation: " - ( (i->)@Const) " ===>  " (i->)@(-Const) "
	 * 	=> this happens frequently, when parsing a .ab program with a -const
	 * 
	 * @param prog
	 */
	public static void manageUnarySubstraction(AffineSystem syst) {
		ManageUnarySubstraction visitor = new ManageUnarySubstraction();
		syst.accept(visitor);
	}
	
	
	/* -------------------------------------------------------------------------------------- */
	
	private Expression _sExprToBePropagated;
	
	@Override
	public void visitUnaryExpression(UnaryExpression uExpr) {
		uExpr.getExpr().accept(this);
		
		if (uExpr.getOperator().equals(OP.NEG) && ConstantExpressionHelper.isConstantExpressionAfterDep(_sExprToBePropagated)) {
			oppositeConstantValue(_sExprToBePropagated);
			return;
		} else
			_sExprToBePropagated = _polyIRFact.createUnaryExpression(uExpr.getOperator(), _sExprToBePropagated);
	}
	
	private void oppositeConstantValue(Expression expr) {
		if (expr instanceof DependenceExpression) {
			oppositeConstantValue(((DependenceExpression) expr).getExpr());
			return;
		}
		if (expr instanceof IntegerExpression) {
			((IntegerExpression) expr).setValue(-((IntegerExpression) expr).getValue());
			return;
		}
		if (expr instanceof RealExpression) {
			((RealExpression) expr).setValue(-((RealExpression) expr).getValue());
			return;
		}
	}
	
	@Override
	public void outStandardEquation(StandardEquation stEq) {
		stEq.setExpression(_sExprToBePropagated);
	}
	
	// Leaves
	@Override
	public void visitVariableExpression(VariableExpression varExpr) {
		_sExprToBePropagated = varExpr;
	}
	
	@Override
	public void visitIntegerExpression(IntegerExpression intExpr) {
		_sExprToBePropagated = _polyIRFact.createIntegerExpression(intExpr.getValue());
	}
	
	@Override
	public void visitRealExpression(RealExpression realExpr) {
		_sExprToBePropagated = _polyIRFact.createRealExpression(realExpr.getValue());
	}
	
	@Override
	public void visitBooleanExpression(BooleanExpression boolExpr) {
		_sExprToBePropagated = _polyIRFact.createBooleanExpression(boolExpr.isValue());
	}
	
	@Override
	public void visitIndexExpression(IndexExpression indExpr) {
		_sExprToBePropagated = indExpr;
	}
	
	
	// Branching
	public void outReduceExpression(ReduceExpression redExpr) {
		_sExprToBePropagated = _polyIRFact.createReduceExpression(redExpr.getOP(), redExpr.getProjection(), _sExprToBePropagated);
	}
	
	@Override
	public void outDependenceExpression(DependenceExpression depExpr) {
		_sExprToBePropagated = _polyIRFact.createDependenceExpression(depExpr.getDep(), _sExprToBePropagated);
	}
	
	@Override
	public void outRestrictExpression(RestrictExpression restExpr) {
		_sExprToBePropagated = _polyIRFact.createRestrictExpression(restExpr.getRestrictDomain(), _sExprToBePropagated);
	}
	
	@Override
	public void visitBinaryExpression(BinaryExpression bExpr) {
		bExpr.getLexp().accept(this);
		Expression subExprLeft = _sExprToBePropagated;
		
		bExpr.getRexp().accept(this);
		Expression subExprRight = _sExprToBePropagated;
		
		_sExprToBePropagated = _polyIRFact.createBinaryExpression(bExpr.getOperator(), subExprLeft, subExprRight);
	}
	
	@Override
	public void visitCaseExpression(CaseExpression cExpr) {
		List<Expression> lSExprToBePropagated = new BasicEList<Expression>();
		for (Expression subExpr : cExpr.getExprs()) {
			subExpr.accept(this);
			lSExprToBePropagated.add(_sExprToBePropagated);
		}
		
		_sExprToBePropagated = _polyIRFact.createCaseExpression(lSExprToBePropagated);
	}
	
	@Override
	public void visitIfExpression(IfExpression ifExpr) {
		ifExpr.getCond().accept(this);
		Expression sExprToBePropagatedCond = _sExprToBePropagated;
		
		ifExpr.getThen().accept(this);
		Expression sExprToBePropagatedThen = _sExprToBePropagated;

		ifExpr.getElse().accept(this);
		Expression sExprToBePropagatedElse = _sExprToBePropagated;
		
		_sExprToBePropagated = _polyIRFact.createIfExpression(sExprToBePropagatedCond, sExprToBePropagatedThen, sExprToBePropagatedElse);
	}
	
	@Override
	public void visitMultiArgExpression(MultiArgExpression mExpr) {
		List<Expression> lSExprToBePropagated = new BasicEList<Expression>();
		for (Expression subExpr : mExpr.getExprs()) {
			subExpr.accept(this);
			lSExprToBePropagated.add(_sExprToBePropagated);
		}
		
		_sExprToBePropagated = _polyIRFact.createMultiArgExpression(mExpr.getOperator(), lSExprToBePropagated);
	}
	
	@Override
	public void visitExternalFunctionCall(ExternalFunctionCall efExpr) {
		List<Expression> lSExprToBePropagated = new BasicEList<Expression>();
		for (Expression subExpr : efExpr.getExprs()) {
			subExpr.accept(this);
			lSExprToBePropagated.add(_sExprToBePropagated);
		}
		
		_sExprToBePropagated = _polyIRFact.createExternalFunctionCall(efExpr.getExFunc(), lSExprToBePropagated);
	}
	
} // ManageUnarySubstraction
