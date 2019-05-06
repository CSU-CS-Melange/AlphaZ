package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;

public class FactorOutFromReduction {

	protected Expression parentExpression = null;
	protected Expression factoredExpression = null;
	protected OP factoredOP = null;
	
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;

	public static void apply(Expression expression) {
		new FactorOutFromReduction(expression);
	}
	
	protected FactorOutFromReduction(Expression targetExpr) {
		
		EObject current = targetExpr.eContainer();
		EObject prev = targetExpr;
		while (current != null && current instanceof Expression) {
			//While traversing the AST backwards, check all point-wise OPs 
			{
				OP op = null;
				if (current instanceof BinaryExpression) {
					op = ((BinaryExpression)current).getOperator();
				}
				if (current instanceof MultiArgExpression) {
					op = ((MultiArgExpression)current).getOperator();
				}
				//If current was one of the above
				if (op != null) {
					if (op == OP.EXTERNAL_FUNCTION) {
						throw new RuntimeException("Factoring out from external function is not handled.");
					}
					//If this was the first point-wise OP, the child of current is what is factored out
					if (factoredOP == null) {
						factoredExpression = (Expression)prev;
						factoredOP = op;
					//otherwise, check if the OP matches previously found ones
					} else {
						if (factoredOP != op) {
							throw new RuntimeException("Found operator that does not match the operator applied to the expression to be factored out.");
						}
					}
				}
			}
			//Any one of the following expressions are where the expressions have to be factored out
			{
				if (current instanceof ReduceExpression) {
					if (factoredOP == null) {
						throw new RuntimeException("ReduceExpression encountered before point-wise OP.");
					}
					//check operator
					if (!factoredOP.isDistributiveOver(((ReduceExpression)current).getOP())) {
						throw new RuntimeException(factoredOP + " is not distributive over " + ((ReduceExpression)current).getOP());
					}
					//Found matching parent
					parentExpression = (Expression)current;
					break;
				}
			}
			
			//keep traversing
			prev = current;
			current = current.eContainer();
		}
		
		//check if everything found
		if (parentExpression == null) {
			throw new RuntimeException("Target expression was not contained by ReduceExpression.");
		}
		if (factoredExpression == null || factoredOP == null) {
			throw new RuntimeException("Target expression was not contained by any point-wise operation.");
		}
		
		//More test to do
		
		if (parentExpression instanceof ReduceExpression) {
			factorizeExpressionInReduce();
		}
	}
	
	private void factorizeExpressionInReduce() {
		ReduceExpression reduce = (ReduceExpression)parentExpression;
		
		//check  domain
		
		//InverseInContext must be done before removing the expression to factor out
		// (removing the expression may loosen the context)
		Domain context = _fact.createDomain(((ISLSet)reduce.getExpr().getContextDomain().getPMdomain()).lexMin());
		AffineFunction inv = reduce.getProjection().inverseInContext(context, null);
		
		//Handle the operation where the expression is going to be removed first
		removeExpressionFromPointwiseOp(factoredExpression);
		
//		ParameterDomain param;
//		if (parentExpression.getContainerEquation() instanceof StandardEquation)
//			param = ((StandardEquation)parentExpression.getContainerEquation()).getContainerSystem().getParameters();
//		else
//			param = ((UseEquation)parentExpression.getContainerEquation()).getContainerSystem().getParameters();
		
		List<Constraint> constraints = new LinkedList<Constraint>();
		constraints.add(new Constraint(PolyhedralIRUtility.createIdentityFunction(reduce.getContextDomain()), reduce.getProjection(), ComparisonOperator.EQ));
		//constraints.add(new Constraint(_fact.createIdentityFunction(reduce.getContextDomain()), ));
		
		try {
			DependenceExpression depExpr = _fact.createDependenceExpression(inv, factoredExpression);
			BinaryExpression factoring = _fact.createBinaryExpression(factoredOP, reduce.copy(), depExpr);
			EcoreUtil.replace(reduce, factoring);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Map<Domain, AffineFunction> inverseQuast = DomainOperations.findDependencies(param, reduce.getContextDomain(), reduce.getExpr().getContextDomain(), 
//				constraints, null);
//		
//		List<Expression> exprs = new LinkedList<Expression>();
//		for (Domain key : inverseQuast.keySet()) {
//			System.err.println(key + " : " + inverseQuast.get(key));
//			DependenceExpression projDep = _fact.createDependenceExpression(inverseQuast.get(key), factoredExpression.copy());
//			RestrictExpression restrict = _fact.createRestrictExpression(key, projDep);
//			exprs.add(restrict);
//		}
		
//		CaseExpression caseExpr = _fact.createCaseExpression(exprs);
	}
	
	private static void removeExpressionFromPointwiseOp(Expression exprToRemove) {
		//parent is binary
		if (exprToRemove.eContainer() instanceof BinaryExpression) {
			BinaryExpression parent = (BinaryExpression)exprToRemove.eContainer();
			//replace the binary expression with the other child that is not removed
			if (parent.getLexp().equals(exprToRemove)) {
				EcoreUtil.replace(parent, parent.getRexp().copy());
			} else {
				EcoreUtil.replace(parent, parent.getLexp().copy());
			}
		//parent is multi-arg
		} else if (exprToRemove.eContainer() instanceof MultiArgExpression) {
			MultiArgExpression parent = (MultiArgExpression)exprToRemove.eContainer();
			//make sure its not external function
			if (parent.getOperator() == OP.EXTERNAL_FUNCTION) {
				throw new RuntimeException("External functions are not handled.");
			}
			//remove from the list
			parent.getExprs().remove(exprToRemove);
			//If the remaining expression is the only child, remove the point-wise op
			if (parent.getExprs().size() == 1) {
				EcoreUtil.replace(parent, parent.getExprs().get(0).copy());
			}
		} else {
			throw new RuntimeException("Given expression is not directly contained by point-wise op.");
		}
		
	}
}
