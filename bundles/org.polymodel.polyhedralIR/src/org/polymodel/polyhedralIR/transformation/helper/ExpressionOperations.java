package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.Type;
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

public class ExpressionOperations {

	/**
	 * Get the list of indexes of an expression, by looking inside it, instead of relying on the expression domain
	 * @param expr
	 * @return
	 */
	public static List<Variable> getLIndicesExpression(Expression expr) {
		// Leaves
		if (expr instanceof VariableExpression)
			return ((VariableExpression) expr).getVarDecl().getDomain().getIndices();
		
		if (expr instanceof IntegerExpression)
			return new BasicEList<Variable>();
		if (expr instanceof RealExpression)
			return new BasicEList<Variable>();
		if (expr instanceof BooleanExpression)
			return new BasicEList<Variable>();
		
		if (expr instanceof IndexExpression)
			return ((IndexExpression) expr).getFunction().getIndices();
		
		// Stopping
		if (expr instanceof DependenceExpression)
			return ((DependenceExpression) expr).getDep().getIndices();
		if (expr instanceof RestrictExpression)
			return ((RestrictExpression) expr).getRestrictDomain().getIndices();
		if (expr instanceof ReduceExpression) {
			AffineFunction func = ((ReduceExpression) expr).getProjection();
			
			List<Variable> lInds = new BasicEList<Variable>();
			for (int k=0; k<func.getDimRHS(); k++)
				lInds.add(func.getIndices().get(k));
			return lInds;
		}
		
		// Propagation
		if (expr instanceof UnaryExpression)
			return getLIndicesExpression(((UnaryExpression) expr).getExpr());
		
		// Branching
		if (expr instanceof BinaryExpression)
			return getLIndicesExpression(((BinaryExpression) expr).getLexp());
		if (expr instanceof MultiArgExpression)
			return getLIndicesExpression(((MultiArgExpression) expr).getExprs().get(0));
		if (expr instanceof CaseExpression)
			return getLIndicesExpression(((CaseExpression) expr).getExprs().get(0));
		if (expr instanceof IfExpression)
			return getLIndicesExpression(((IfExpression) expr).getCond());
		if (expr instanceof ExternalFunctionCall) {
			if (((ExternalFunctionCall) expr).getExprs().size()==0) {
				// External function with no argument => always return a constant?
				// (because, if not, there is a dependence before)
				// TODO: NOT SURE
				return new BasicEList<Variable>();
				
			} else
				return getLIndicesExpression(((ExternalFunctionCall) expr).getExprs().get(0));
		}
		
		// Default
		throw new RuntimeException("getLIndicesExpression => expression type not recognized");
	}
	
	/**
	 * Get the type of an expression, by looking inside it, instead of relying on the containing equation
	 * 
	 * @param expr
	 * @param prog
	 * @return
	 */
	public static Type getExpressionType(Expression expr, Program prog) {
		// Leaves
		if (expr instanceof VariableExpression)
			return ((VariableExpression) expr).getVarDecl().getType();
		
		if (expr instanceof IntegerExpression)
			return prog.getType(SIGNED.SIGNED,DATATYPE.INTEGER, DATATYPE.INT_WIDTH);
		if (expr instanceof RealExpression)
			return prog.getType(SIGNED.SIGNED, DATATYPE.FLOATING_POINT, DATATYPE.INT_WIDTH);
		if (expr instanceof BooleanExpression)
			return prog.getType(SIGNED.UNSIGNED, DATATYPE.BOOL, 8);
		
		if (expr instanceof IndexExpression)
			return null;
		
		// Propagation
		if (expr instanceof DependenceExpression)
			return getExpressionType(((DependenceExpression) expr).getExpr(),prog);
		if (expr instanceof RestrictExpression)
			return getExpressionType(((RestrictExpression) expr).getExpr(),prog);
		if (expr instanceof ReduceExpression)
			return getExpressionType(((ReduceExpression) expr).getExpr(),prog);
		if (expr instanceof UnaryExpression)
			return getExpressionType(((UnaryExpression) expr).getExpr(),prog);
		
		// Branching
		if (expr instanceof BinaryExpression) {
			Type tLeft = getExpressionType(((BinaryExpression) expr).getLexp(),prog);
			if (tLeft!=null)
				return tLeft;
			else
				return getExpressionType(((BinaryExpression) expr).getRexp(), prog);
		}
		if (expr instanceof IfExpression) {
			Type tThen = getExpressionType(((IfExpression) expr).getThen(),prog);
			if (tThen!=null)
				return tThen;
			else
				return getExpressionType(((IfExpression) expr).getElse(), prog);
		}
		if (expr instanceof MultiArgExpression) {
			// TODO
			
			return getExpressionType(((MultiArgExpression) expr).getExprs().get(0),prog);
		}
		if (expr instanceof CaseExpression) {
			// TODO
			
			return getExpressionType(((CaseExpression) expr).getExprs().get(0),prog);
		}
		if (expr instanceof ExternalFunctionCall) {
			return ((ExternalFunctionCall) expr).getExFunc().getOutput();
		}
		
		// Default
		throw new RuntimeException("getLIndicesExpression => expression type not recognized");
	}

} // ExpressionOperations
