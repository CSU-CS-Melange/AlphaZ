package org.polymodel.polyhedralIR.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;

import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.expression.*;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import tom.mapping.introspectors.polyhedralIR.expression.ExpressionIntrospector;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

import tom.library.sl.VisitFailure;
import tom.library.sl.*;
//import strat.term.types.*;

public class Normalize extends PolyhedralIRTomTransformation {

	public static boolean DEBUG = false;
	public static int EMPTY_BRANCH_THOLD = 0;

	public static void normalize(Program p){
		for (AffineSystem system : p.getSystems()) {
			normalize(system);
		}
	}
	public static void normalize(AffineSystem s){
		Normalize norm = new Normalize();
		norm.transform(s);
	}

	protected Normalize(){}

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		EObject t = null;
		if (o instanceof AffineSystem) {
			ExpressionIntrospector.REMOVE_EMPTY_BRANCH_AT_SETTER = true;
			EMPTY_BRANCH_THOLD = 10;
			t = `InnermostId(EfficientNormalizeRule()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
			// TODO: InnermostId too powerful (just looking at degree 1 is enough)
			
			// Solution PE:
			//Strategy x = `MuVar("x");
			//Strategy propagate = `mu(x, Sequence(EfficientNormalizeRule(), Try(All(x))));
			//t = `BottomUp(Try(propagate)).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
			// Remember to change the "extends" of "EfficientNormalizeRule" to "Fail"
			// TODO: does not work (failing example: test 2 of CART with subsystem - after Cob)
			
			EMPTY_BRANCH_THOLD = 0;
			t = `BottomUp(RemoveEmptyBranch()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
			t = `BottomUp(NormalizeIdentityFunction()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
			ExpressionIntrospector.REMOVE_EMPTY_BRANCH_AT_SETTER = false;
		} else {
			throw new RuntimeException("Normalize can only be applied to AffineSystem");
		}
		return t;
	}
	
	%include { sl.tom }
	%include { polyhedralIR.tom }

	public static Expression removeEmptyBranch(Expression e) {
		try {
			if (!(e instanceof CaseExpression)) {
				return e;
			}

			CaseExpression caseExpr = (CaseExpression)e;

			if (caseExpr.getExprs().size() < EMPTY_BRANCH_THOLD) {
				return e;
			}

			if(DEBUG){
				System.out.print("Empty Branch Check: " + caseExpr.getExprs().size());
			}
			
			List<Expression> emptyExprs = new LinkedList<Expression>();
			for(Expression expr : caseExpr.getExprs()){
				if(expr.getContextDomain().isEmpty()){
					emptyExprs.add(expr);
				}
			}

			if (DEBUG)
				System.out.println(" -> " + (caseExpr.getExprs().size() - emptyExprs.size()));

			//get the context domain before removing
			Domain contextDom;
			if (caseExpr.getExprs().size() == 0) {
				contextDom = ((Expression)caseExpr.eContainer()).getContextDomain();
			} else {
				contextDom = caseExpr.getContextDomain();
			}

			//remove empty branches
			caseExpr.getExprs().removeAll(emptyExprs);

			return handleEmptyBranch(caseExpr, contextDom);
		} catch (Exception ex) {
			return e;
		}
	}

	private static Expression handleEmptyBranch(CaseExpression caseExpr, Domain contextDomain) {
		//when all branches are empty, no more expression
		if (caseExpr.getExprs().size() == 0) {
			Domain emptyDom =  PolyhedralIRUtility.createEmptyDomain(contextDomain.getParams(), contextDomain.getIndices());
			AffineFunction emptyFunc = PolyhedralIRUtility.createProjection(emptyDom, new LinkedList<Variable>());	
			
			return `restrictExpr(emptyDom, depExpr(emptyFunc, intConst(1)));
		//when all but one branche are empty
		} else if (caseExpr.getExprs().size() == 1) {
			return caseExpr.getExprs().get(0);
		} else {
			return caseExpr;
		}
	}


	%strategy RemoveEmptyBranch() extends Identity(){ 
		visit Expression {
			//removing empty branch in a caseExpression
			caseExpr@caseExpr(exprs) ->{
				return removeEmptyBranch((CaseExpression)`caseExpr);
			}
		} 
	}
	
	%strategy NormalizeIdentityFunction() extends Identity(){ 
		visit Expression {
			//dependence expression with identity function
			depExpr(func, expr) -> {
				if(DEBUG){
				//System.out.println("start normalize identity funciton");
				}
				AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(`expr.getExpressionDomain());
				if(`func.equivalence(identity)){
					if(DEBUG){
						System.out.println("dependence expression with identity function");
						System.out.flush();
					}
					return `expr;
				}
			}

		} 
	}

	private static void debug(String name, String rule, String other) {
		if (DEBUG) System.out.println(name+": " + rule + " " + other);
	}

	%strategy EfficientNormalizeRule() extends Identity() {
		visit Expression {
			//dependence expression with binary expression
			depExpr(func, binOp(op,lexp,rexp)) -> {
				debug("rule1", "dep@(A op B) -> dep@A op dep@B", "");
				return `binOp(op,depExpr(func.copy(),lexp),depExpr(func,rexp));
			}
			//binary expression with restrict expression
			binOp(op, restrictExpr(domain, expr), rexp) ->{
				debug("rule2a", "((dom : A) op B) -> dom : (A op B)", "");
				return `restrictExpr(domain, binOp(op, expr, rexp));
			}

			binOp(op, lexpr, restrictExpr(domain, expr)) ->{
				debug("rule2b", "(A op (dom : B)) -> dom : (A op B)", "");
				return `restrictExpr(domain, binOp(op, lexpr, expr));
			}
			
			//dependence expression with dependence expression inside
			depExpr(func, depExpr(func2, expr)) -> {
				debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
				return `depExpr(func2.compose(func), expr);
			}
			
			//restrict expression with restrict expression inside
			rest@restrictExpr(OuterDomain, restrictExpr(innerDomain, expr)) -> {
				debug("rule4", "domA : domB : E -> (domA intersection domB)@E", "");
				
				Domain domain = `OuterDomain.intersection(`innerDomain);
				return `restrictExpr(domain, expr.copy());
			}

			// dependence expression with restrict expression
			depExpr(func, restrictExpr(domain, expr)) ->{
				debug("rule5", "dep@(dom : E)-> dom.preimage(dep) : (dep@E)", "");

				return `restrictExpr(domain.preimage(func), depExpr(func, expr));
			}
			//dependence expression with uniary expression
			depExpr(func, unaryOp(op, expr)) -> {
				debug("rule6", "dep@(op E)-> op (dep@E)", "");
				return `unaryOp(op, depExpr(func, expr));
			}
			// unary expression with restrict expression
			unaryOp(op, restrictExpr(domain, expr)) -> {
				debug("rule7", "(op dom : E)-> dom : (op E)", "");
				return `restrictExpr(domain, unaryOp(op, expr));
			}

			depExpr(func, external@externalCall(op, exprs, exfunc)) ->{
				debug("rule8b", "dep @ exf(op, E)-> exf(op, dep@E)", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn :tempList){
					DependenceExpression depExpn = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(`func.copy(), expn);
					newExprs.add(depExpn);
				}
				
				return `externalCall(op, newExprs, exfunc);
			}

			// multi-argument expression with dependence expression
			depExpr(func, multiArgExpr@multOp(op, exprs)) ->{
				debug("rule8a", "dep @ f(op, E)-> f(op, dep@E)", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn : tempList){
					DependenceExpression depExpn = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(`func.copy(), expn);
					newExprs.add(depExpn);
				}
				
				return `multOp(op, newExprs);
			}

			

			// index expression with dependence expression
			depExpr(func, indexExpr(function)) -> {
				debug("rule9", "dep@(val(f) -> val(f o dep)", "");

				return `indexExpr(function.compose(func));
			}

			//case expression with nested case expression
			caseExpr@caseExpr(exprList(exprs1@_*, rmCase@caseExpr(exprs), exprs2@_*)) ->{
				debug("rule10", "case E1; case E2 esac; E3; esac -> case E1; E2; E3; esac", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				newExprs.addAll(`exprs1);
				newExprs.addAll(`exprs);
				newExprs.addAll(`exprs2);

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}

			//binary case expression
			binExpr@binOp(op, caseExpr@caseExpr(exprs), rexp) ->{
				debug("rule11a", "case E1; esac op E2 -> case E1 op E2; esac", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn : tempList){
					newExprs.add(`binOp(op, expn, rexp.copy()));
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}
			//binary case expression
			binExpr@binOp(op, lexp, caseExpr@caseExpr(exprs)) ->{
				debug("rule11b", "E1 op case E2; esac -> case E1 op E2; esac", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn : tempList){
					newExprs.add(`binOp(op, lexp.copy(), expn));
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}

			//unary case expression
			unaryOp(op, caseExpr@caseExpr(exprs)) -> {
				debug("rule12", "op case E; esac -> case op E; esac", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn :tempList){
					newExprs.add(`unaryOp(op, expn));
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}

			orig@externalCall(f, exprList(caseExpr(exprs)), func) -> {
				debug("rule13", "f(op, case E; esac) -> case f(op, E) esac;", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn : tempList){
					ExternalFunctionCall ext = (ExternalFunctionCall)`externalCall(f, exprList(expn.copy()), func);
					ext.setExFunc(((ExternalFunctionCall)`orig).getExFunc());
					newExprs.add(ext);
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}

			//dependence expression with case expression
			depExpr(func, caseExpr@caseExpr(exprs)) -> {
				debug("rule14", "dep case E; esac -> case dep E; esac", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);
				
				for(Expression expn : tempList){
					Expression depExpn = `depExpr(func.copy(), expn);
					newExprs.add(depExpn);
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}
			//restriction expression with case expression
			restCase@restrictExpr(domain, caseExpr(exprs)) ->{
				debug("rule15", "dom : case E; esac -> case dom : E; esac", "");
				
				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);
				

				for(Expression expn : tempList){
					Expression restExp = `restrictExpr(domain.copy(), expn.copy());
					newExprs.add(restExp);
				}

				CaseExpression caseExpr =  (CaseExpression)`caseExpr(newExprs);

				assert(caseExpr.getExprs().size() > 0);

				return caseExpr;
			}

			//dependence expression with if then else expression
			depExpr(func, ifExpr(cond, thenExp, elseExp)) -> {
				debug("rule16", "dep @ if (cond, then, else) -> if(dep@cond, dep@then, dep@else) ", "");

				return `ifExpr(depExpr(func.copy(), cond), depExpr(func.copy(), thenExp), depExpr(func.copy(), elseExp));
			}
			
			//if expression with restrict expression in cond expression
			ifExpr(restrictExpr(domain, cond), thenExp, elseExp) -> {
				debug("rule17a", "if(dom : cond, then, else) -> dom : if (cond, then, else)", "");

				return `restrictExpr(domain, ifExpr(cond, thenExp, elseExp));
			}
			
			//if expression with restrict expression in then expression
			ifExpr(cond, restrictExpr(domain, thenExp), elseExp) -> {
				debug("rule17b", "if(cond, dom : then, else) -> dom : if (cond, then, else)", "");

				return `restrictExpr(domain, ifExpr(cond, thenExp, elseExp));
			}
			
			//if expression with restrict expression in else expression
			ifExpr(cond, thenExp, restrictExpr(domain, elseExp)) -> {
				debug("rule17c", "if(cond, then, dom : else) -> dom : if (cond, then, else)", "");

				return `restrictExpr(domain, ifExpr(cond, thenExp, elseExp));
			}

			// if then else expression with case expression
			ifExpr(caseExpr(exprs), thenExp, elseExp) -> {
				debug("rule18a", "if(case E; esac, then, else) -> esac if (E, then, else); case", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);
				
				for(Expression expn : tempList){
					Expression ifExpn = `ifExpr(expn.copy(), thenExp.copy(), elseExp.copy());
					newExprs.add(ifExpn);
				}

				CaseExpression caseExpr = (CaseExpression)`caseExpr(newExprs);
				assert(caseExpr.getExprs().size() > 0);

				return `caseExpr;
			}
			
			// if then else expression with case expression
			ifExpr(cond, caseExpr(exprs), elseExp) -> {
				debug("rule18b", "if(cond, case E; esac, else) -> esac if (cond, E, else); case", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);
				
				for(Expression expn : tempList){
					Expression ifExpn = `ifExpr(cond.copy(), expn.copy(), elseExp.copy());
					newExprs.add(ifExpn);
				}

				CaseExpression caseExpr = (CaseExpression)`caseExpr(newExprs);
				assert(caseExpr.getExprs().size() > 0);

				return `caseExpr;
			}

			// if then else expression with case expression
			ifExpr(cond, thenExp, caseExpr(exprs)) -> {
				debug("rule18c", "if(cond, then, case E; esac) -> esac if (cond, then, E); case", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);
				
				for(Expression expn : tempList){
					Expression ifExpn = `ifExpr(cond.copy(), thenExp.copy(), expn.copy());
					newExprs.add(ifExpn);
				}

				CaseExpression caseExpr = (CaseExpression)`caseExpr(newExprs);
				assert(caseExpr.getExprs().size() > 0);

				return `caseExpr;
			}
			//binary expression with restrict expression
			externalCall(op, exprList(restrictExpr(domain, expr)), exfunc) ->{
				debug("rule19", "exFunc(op, dom : E) -> dom : exFunc(op, E)", "");
				return `restrictExpr(domain, externalCall(op, exprList(expr), exfunc));
			}

		}
	}

}