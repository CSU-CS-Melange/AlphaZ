package org.polymodel.polyhedralIR.transformation;

import java.util.Map;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

import tom.library.sl.VisitFailure;

public class Simplify extends PolyhedralIRTomTransformation {

	private static boolean modified = false;

	public static void simplify(Program p){
		Simplify s = new Simplify();
		s.transform(p);
	}


	public static void simplify(AffineSystem as){
		Simplify s = new Simplify();
		s.transform(as);
	}
	protected Simplify(){} 

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		modified = true;
		while (modified) {
			modified = false;
			o = `BottomUp(SimplifyExpr()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		}
		return o;
	} 
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy SimplifyExpr() extends Identity() {
		visit Expression {

			expr@ifExpr(condExpr@binEq(lexpr, rexpr), thenExpr, elseExpr) -> {
				return simplifyIfExpr((IfExpression)`expr, (BinaryExpression)`condExpr);
			}
			
			expr@reduce(op, func, exprBody) -> {
				if (checkScalarReduction((ReduceExpression)`expr)) {
					modified = true;
					return simplifyScalarReduction((ReduceExpression)`expr);
				} else {
					return `expr;
				}
			}
			orig@caseExpr(exprList(expr))-> {
				modified = true;
				return `expr;
			}
			orig@caseExpr(exprList(exprA, exprs@_*, exprB))->{
				EList<Expression> newExprs = `exprs;
				int count = 0;
				if (!`exprA.getContextDomain().isEmpty()) {
					newExprs.add(`exprA);
					count++;
				}
				if (!`exprB.getContextDomain().isEmpty()) {
					newExprs.add(`exprB);
					count++;
				}
				if (count < 2) {
					modified = true;
					return PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(newExprs);
                } else {
					return `orig;
				}
			}
			
			//constant index expressions
			expr@val(f) -> {
				boolean isConstant = `f.getExpressions().size() == 1 && `f.getExpressions().get(0).isConstant() == FuzzyBoolean.YES;
				if (isConstant) { return `intConst(f.getExpressions().get(0).getConstantTerm().getCoef()); } else { return `expr; } 
			}

			//add by identity
			expr@binAdd(depExpr(func, intConst(0L)), rexpr) -> { return `rexpr; }
			expr@binAdd(lexpr, depExpr(func, intConst(0L))) -> { return `lexpr; }
			
			expr@binAdd(depExpr(func, intConst(0L)), depExpr(func, intConst(0L))) -> { return `depExpr(func, intConst(0L)); }
			
			//mult by identity
			expr@binMul(depExpr(func, intConst(1L)), rexpr) -> { return `rexpr; }
			expr@binMul(lexpr, depExpr(func, intConst(1L))) -> { return `lexpr; }
			
			//mult by 0
			expr@binMul(depExpr(func, intConst(0L)), rexpr) -> { return `depExpr(func, intConst(0L)); }
			expr@binMul(lexpr, depExpr(func, intConst(0L))) -> { return `depExpr(func, intConst(0L)); }
			
			//universe in context restrict expressions
			restrict@restrictExpr(domain, expr) ->{
				Domain context = `restrict.getContextDomain().copy();
				if (`restrict.eContainer() instanceof StandardEquation) {
					context.simplifyInContext(((StandardEquation)`restrict.eContainer()).getVariable().getDomain());
				} else if (`restrict.eContainer() instanceof ReduceExpression) {
					ReduceExpression re = (ReduceExpression)`restrict.eContainer();
					context.simplifyInContext(re.getContextDomain().preimage(re.getProjection()));
				} else if (`restrict.eContainer() instanceof DependenceExpression) {
					DependenceExpression de = (DependenceExpression)`restrict.eContainer();
					context.simplifyInContext(de.getContextDomain().image(de.getDep()));
				} else if (`restrict.eContainer() instanceof Expression) {
					context.simplifyInContext(((Expression)`restrict.eContainer()).getContextDomain());
				}
				if (`context.isUniverse()) {
					modified = true;
					return `expr;
				} else {
					return `restrict;
				}
			}

		}
		
	}


	private static Expression addIdentityTest(OP op, Expression sexp, Expression expr) {
		if (op.getValue() == OP.ADD_VALUE) {
			return sexp;
		} else {
			return expr;
		}
	}

	private static Expression multIdentityTest(OP op, Expression sexp, Expression expr) {
		if (op.getValue() == OP.MUL_VALUE) {
			return sexp;
		} else {
			return expr;
		}
	}

	private static boolean checkScalarReduction(ReduceExpression reduce) {
		ParameterDomain params;
		
		if (reduce.getContainerEquation() instanceof StandardEquation)
			params = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			params = ((UseEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
		
		//create the problem domain where domain of reduction expression is equated with projection function to another copy of the domain now as parameters
		Domain prob = DomainOperations.extendParameterDomain(reduce.getExpr().getContextDomain(), reduce.getExpr().getContextDomain());
		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(params, prob, 
				new DomainOperations.Constraint(reduce.getProjection(), reduce.getProjection(), ComparisonOperator.EQ));
		//If lex min and max is the same, then there is a constant point
		org.polymodel.Domain max = ((ISLSet)prob.getPMdomain()).lexMax();
		org.polymodel.Domain min = ((ISLSet)prob.getPMdomain()).lexMin();
		return max.equivalence(min);
	}

	private static Expression simplifyScalarReduction(ReduceExpression reduce) {
		ParameterDomain params;
		
		if (reduce.getContainerEquation() instanceof StandardEquation)
			params = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			params = ((UseEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
		//If the domain is only a constant point, the returned quast should actually be a function
		Map<Domain,AffineFunction> quast = DomainOperations.findDependencies(params, reduce.getContextDomain(), reduce.getExpr().getContextDomain(), 
					new DomainOperations.Constraint(PolyhedralIRUtility.createIdentityFunction(reduce.getContextDomain()), reduce.getProjection(), ComparisonOperator.EQ), null);

		
		if (quast.size() == 1) {
			AffineFunction dep = quast.values().iterator().next();
			if (dep != null) {
				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep, reduce.getExpr());
			}
		}
		throw new RuntimeException("Unexpected case : possible bug in scalar reduction detection");
	}

	private static Expression simplifyIfExpr(IfExpression ifExpr, BinaryExpression binExpr) {
		
		IntExpression lexpr = getIntExpression(binExpr.getLexp());
		IntExpression rexpr = getIntExpression(binExpr.getRexp());

		if (lexpr == null || rexpr == null)
			return ifExpr;

		IntConstraint trueCond = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.EQ);
		org.polymodel.Domain trueDom = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
		trueDom.addConstraint(trueCond);
		
		if (trueDom.isEmpty()) {
			return ifExpr.getElse();
		}
		
		IntConstraint falseCond1 = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.LT);
		IntConstraint falseCond2 = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.GT);
		org.polymodel.Domain falseDom1 = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
		org.polymodel.Domain falseDom2 = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
		falseDom1.addConstraint(falseCond1);
		falseDom2.addConstraint(falseCond2);
		
		if (falseDom1.isEmpty() && falseDom2.isEmpty()) {
			return ifExpr.getThen();
		}
		
		return ifExpr;
	}
	
	private static IntExpression getIntExpression(Expression expr) {
		if (expr instanceof DependenceExpression) {
			expr = ((DependenceExpression)expr).getExpr();

			if (expr instanceof IntegerExpression)
				return IntExpressionBuilder.constant((int)((IntegerExpression) expr).getValue());
		}
		
		if (expr instanceof IndexExpression) {
			return ((IndexExpression) expr).getFunction().getExpressions().get(0).copy();
		}
		
		return null;
	}
	
	
}