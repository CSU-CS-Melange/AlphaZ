package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.List;
import java.util.Stack;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * Inspects a subtree under an expression to extract coefficients for
 * scan in matrix form. 
 * 
 * Performs bottom-up traversal of the AST, essentially merging
 * all operators such that a sub-tree involving the recurrence 
 * distance of interest remains.
 * 
 * The main algorithm is as follows:
 *  1. The expression corresponding to the target recurrence variable
 *     is replaced by identity element of otimes, with attribute REGULAR.
 *  2. All other occurrences of recurrence variables are replaced by
 *     identity element of oplus, with attribute WEAK.
 *  3. All other expressions start with attribute WEAK.
 *  4. At any operator (assuming binary for now TODO) four cases may happens:
 *      a. Both operands are REGULAR   -> both operands are merged, attribute stays REGULAR
 *      b. Both operands are WEAK      -> both operands are merged, attribute stays WEAK 
 *      c. One with WEAK and one is REGULAR:
 *         c-1. Operator is otimes     -> both operands are merged, attribute becomes REGULAR
 *         c-2. Operator is not otimes -> only the operand with REGULAR is retained
 *      When the extraction is for constant operands, REGULAR is assigned only to
 *      variable expressions of non-recurrence variables.
 *  
 *  The key is in "promoting" WEAK when it is combined with REGULAR by otimes.
 * 
 * The extracted coefficients are expressed as Alpha Expressions.
 * However, it is not technically correct, as it omits dependence
 * expressions to 0 dimensional space for constants.
 * 
 * @author tyuki
 *
 */
public class CoefficientExtractor extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	
	public static boolean DEBUG = false;
	
	private void debug(Object content) {
		if (DEBUG)
			System.out.println("[CoefExtractor] " + content);
	}

	private final boolean isVar;
	private final Semiring semiring;
	private List<VariableDeclaration> sccNodes;
	private VariableDeclaration targetVariable;
	private AffineFunction targetRecurrence; 
	private Stack<ExpressionTuple> expressionStack;

	//FIXME they should actually be identity elements of the semiring in the given scan, this only works for (add,mul)
	private final IntegerExpression intPlusID = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
	private final IntegerExpression intTimesID = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
	
	
	protected CoefficientExtractor(VariableDeclaration targetVar, AffineFunction targetRecurrence, List<VariableDeclaration> sccNodes, Semiring semiring) {
		this.targetVariable = targetVar;
		this.targetRecurrence = targetRecurrence;
		this.semiring = semiring;
		this.sccNodes = sccNodes;
		isVar = true;
		expressionStack = new Stack<ExpressionTuple>();
	}
	
	protected CoefficientExtractor(List<VariableDeclaration> sccNodes, Semiring semiring) {
		this.semiring = semiring;
		this.sccNodes = sccNodes;
		isVar = false;
		expressionStack = new Stack<ExpressionTuple>();
	}
	
	public static Expression extractVariableCoefficient(Expression expr, VariableDeclaration targetVar, AffineFunction targetRecurrence, List<VariableDeclaration> sccNodes, Semiring semiring) {
		CoefficientExtractor ce = new CoefficientExtractor(targetVar, targetRecurrence, sccNodes, semiring);
		(expr.copy()).accept(ce);
		return ce.getResult();
	}
	
	public static Expression extractConstantCoefficient(Expression expr, List<VariableDeclaration> sccNodes, Semiring semiring) {
		CoefficientExtractor ce = new CoefficientExtractor(sccNodes, semiring);
		(expr.copy()).accept(ce);
		return ce.getResult();
	}
	
	private Expression getResult() {
		ExpressionTuple et = expressionStack.pop();
		
		if (et.type == REGULAR) {
			return SimplifyCoefficient.simplify(et.expr);
		}

		return intPlusID.copy();
	}
	

	private static enum SUBTREE_TYPE {
		REGULAR,    //expression involving non-recurrence variables; would be coefficients
		WEAK,       //same as regular, but not yet encountered REGULAR, may be constant coefficient 
	}

	private static final SUBTREE_TYPE REGULAR   = SUBTREE_TYPE.REGULAR;
	private static final SUBTREE_TYPE WEAK      = SUBTREE_TYPE.WEAK;
	
	private class ExpressionTuple{
		private final Expression expr;
		private final SUBTREE_TYPE type;
		
		private ExpressionTuple(Expression e, SUBTREE_TYPE t){
			expr = e;
			type = t;
		}
		
		@Override
		public String toString() {
			if (expr == null) {
				return type.name();
			}
			return PolyhedralIRToAlphabets.toSimplifiedString(expr);
		}
	}
	
	private Expression createExpression(OP op, Expression expr1, Expression expr2){
		BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(op, expr1, expr2);
		return bin_exp;
	}
	

	private void expressionProcessing(OP op){
		ExpressionTuple et1 = expressionStack.pop();
		ExpressionTuple et2 = expressionStack.pop();
		
		debug("===================================");
		debug("stack size: " + this.expressionStack.size());
		debug("   " + et1 + " " + op + " " + et2);
		debug("   " + et1.type + " " + op + " " + et2.type);
		

		ExpressionTuple newExpr;
		
		if (et1.type == WEAK || et2.type == WEAK) {
			if (et1.type == et2.type) {
				newExpr = new ExpressionTuple(createExpression(op, et1.expr, et2.expr), WEAK);
			} else if (op == semiring.otimes) {
				newExpr = new ExpressionTuple(createExpression(op, et1.expr, et2.expr), REGULAR);
			} else {
				newExpr = select(et1, et2, WEAK);
			}
		} else {
			newExpr = new ExpressionTuple(createExpression(op, et1.expr, et2.expr), REGULAR);
		}
		
		expressionStack.push(newExpr);
		debug("res: " + newExpr + " " + newExpr.type);
	}
	
	/**
	 * Selects one of the expression tuples which does NOT have the given type.
	 * This should be used in a context where it is known that one of them has the given type.
	 * 
	 * @param et1
	 * @param et2
	 * @param unselectedType
	 * @return
	 */
	private ExpressionTuple select(ExpressionTuple et1, ExpressionTuple et2, SUBTREE_TYPE unselectedType) {
		if (et1.type == unselectedType) {
			return et2;
		} else if (et2.type == unselectedType) {
			return et1;
		} else {
			throw new RuntimeException("should not reach");
		}
	}
	
	@Override
	public void outMultiArgExpression(MultiArgExpression m) {
		if(m.getExprs().size() > 2){	//scans only handle binary operator
			throw new RuntimeException("[CoefExtractor] scans only handle binary operator");
		}
		
		expressionProcessing(m.getOperator());
	}
	
	
	@Override
	public void outBinaryExpression(BinaryExpression b) {
		expressionProcessing(b.getOperator());
	}
	
	@Override
	public void outUnaryExpression(UnaryExpression u) {
		ExpressionTuple et = expressionStack.pop();
		
		UnaryExpression e = PolyhedralIRUserFactory.eINSTANCE.createUnaryExpression(u.getOperator(), et.expr);
		
		expressionStack.push(new ExpressionTuple(e, et.type));
	}
	
	@Override
	public void outVariableExpression(VariableExpression v) {

		Expression parentExpr = (Expression)v.eContainer();
		Expression exprWithDep = null;

		AffineFunction dependence = null;
		if(parentExpr instanceof DependenceExpression){
			dependence = ((DependenceExpression) parentExpr).getDep();
			exprWithDep = parentExpr;
		}else{
			dependence = PolyhedralIRUtility.createIdentityFunction(v.getVarDecl().getDomain());
			exprWithDep = v;
		}

		//recurrence variable
		if(sccNodes.contains(v.getVarDecl())){
			boolean isConsidered = isVar && v.getVarDecl().equals(targetVariable) && dependence.equivalence(targetRecurrence) && isVar;

//			AffineFunction dep = PolyhedralIRUtility.createProjection(v.getVarDecl().getDomain(), new ArrayList<Variable>(0));
			
			if (isConsidered) {
//				Expression expr = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep, intMultID.copy());
				expressionStack.push(new ExpressionTuple(intTimesID.copy(), REGULAR));
			} else {
//				Expression expr = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep, intPlusID.copy());
				expressionStack.push(new ExpressionTuple(intPlusID.copy(), WEAK));
			}
		//non-recurrence variable is considered only when traversing for constant coefficient
		} else {
			SUBTREE_TYPE type = REGULAR;
			if (isVar) type = WEAK;
			
			expressionStack.push(new ExpressionTuple(exprWithDep, type));
		}
	}
	
	@Override
	public void outConstantExpression(ConstantExpression c) {
		SUBTREE_TYPE type = REGULAR;
		if (isVar) {
			type = WEAK;
		}
		
		expressionStack.push(new ExpressionTuple(c, type));
	}	
}
