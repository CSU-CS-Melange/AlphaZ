package org.polymodel.polyhedralIR.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.impl.MatrixOperations;
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
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import tom.library.sl.VisitFailure;

public class LowerDependences extends PolyhedralIRTomTransformation {

	public static boolean DEBUG = true;
	
	private static DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
	
	public static void lowerDependences(AffineSystem syst) {
		AffineSystem nsyst = syst.copy();
		for (StandardEquation stEq : nsyst.getEquations())
			stEq.setExpression(lowerDependences(stEq.getExpression()));
		for (UseEquation uEq : nsyst.getUseEquations()) {
			List<Expression> uEqnInputs = new BasicEList<Expression>();
			for (int k=0; k<uEq.getInputs().size(); k++)
				uEq.getInputs().set(k, lowerDependences(uEq.getInputs().get(k)));
		}
		ContextDomainCalculator.computeContextDomain(nsyst);
	}
	
	
	public static Expression lowerDependences(Expression expr){
		// DEBUG
		//System.out.println("Expression in : " + PolyhedralIRToAlphabets.toString(expr));
		
		LowerDependences lDep = new LowerDependences();
		Expression nExpr = lDep.ntransform(expr);
		
		// DEBUG
		//System.out.println("Expression out : " + PolyhedralIRToAlphabets.toString(nExpr) + "\n");
		return nExpr;
	}
	
	protected Expression ntransform(Expression expr){
		return (Expression) gtransform(expr);
	}

	protected LowerDependences(){}

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		EObject t = null;
		if (o instanceof Expression) {
			t = `BottomUp(AddDependencesVariables()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
			//t = `TopDown(LowerDependencesStrat()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
			//t = `TopDown(MergeDependences()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
			return t;
		} else {
			throw new RuntimeException("LowerDependences can only be applied to Expression");
		}
	}

	%include { sl.tom }
	%include { polyhedralIR.tom }

	private static void debug(String name, String rule, String other) {
		if (DEBUG) System.out.println(name+": " + rule + " " + other);
	}
	
	%strategy AddDependencesVariables() extends Identity() {
		visit Expression {
			varExpr@var(varDecl) -> {
				int nDimVar = `varExpr.getExpressionDomain().getNIndices();
				long[][] linId = new long[nDimVar][nDimVar];
				for (int i=0; i<linId.length; i++)
					linId[i][i] = 1;
				AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
						linId, new long[nDimVar], `varExpr.getExpressionDomain().getParams(), `varExpr.getExpressionDomain().getIndices());			
				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
						PolyhedralIRUserFactory.eINSTANCE.createVariableExpression(`varDecl));
			}
			
			cst@boolConst(val) -> {
				int nDimVar = `cst.getExpressionDomain().getNIndices();
				long[][] linId = new long[nDimVar][nDimVar];
				for (int i=0; i<linId.length; i++)
					linId[i][i] = 1;
				AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
						linId, new long[nDimVar], `cst.getExpressionDomain().getParams(), `cst.getExpressionDomain().getIndices());
				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
						PolyhedralIRUserFactory.eINSTANCE.createBooleanExpression(`val));
			}
			
			cst@intConst(val) -> {
				int nDimVar = `cst.getExpressionDomain().getNIndices();
				long[][] linId = new long[nDimVar][nDimVar];
				for (int i=0; i<linId.length; i++)
					linId[i][i] = 1;
				AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
						linId, new long[nDimVar], `cst.getExpressionDomain().getParams(), `cst.getExpressionDomain().getIndices());
				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
						PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(`val));
			}
			
			cst@realConst(val) -> {
				int nDimVar = `cst.getExpressionDomain().getNIndices();
				long[][] linId = new long[nDimVar][nDimVar];
				for (int i=0; i<linId.length; i++)
					linId[i][i] = 1;
				AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
						linId, new long[nDimVar], `cst.getExpressionDomain().getParams(), `cst.getExpressionDomain().getIndices());
				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
						PolyhedralIRUserFactory.eINSTANCE.createRealExpression(`val));
			}
			
//			ind@indexExpr(func) -> {
//				// TODO: not working???
//				// Entering the function, but not doing anything !!!
//				int nDimVar = `func.getNIndices();
//				long[][] linId = new long[nDimVar][nDimVar];
//				for (int i=0; i<linId.length; i++)
//					linId[i][i] = 1;
//				AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
//						linId, new long[nDimVar], `ind.getExpressionDomain().getParams(), `ind.getExpressionDomain().getIndices());
//				
//				return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
//						PolyhedralIRUserFactory.eINSTANCE.createIndexExpression(`func));
//			}
			
		}
	}

	%strategy LowerDependencesStrat() extends Identity() {
		visit Expression {
			// Commutation dependence - binary operator
			depExpr(func, binOp(op,lexp,rexp)) -> {
				debug("rule1", "dep@(A op B) -> dep@A op dep@B", "");
				return `binOp(op,depExpr(func.copy(),lexp),depExpr(func,rexp));
			}
			
			// Dependence - dependence
			depExpr(func, depExpr(func2, expr)) -> {
				debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
				return `depExpr(func2.compose(func), expr);
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
			
			depExpr(func, external@externalCall(op, exprs, exfunc)) ->{
				debug("rule8b", "dep @ exf(op, E)-> exf(op, dep@E)", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn :tempList)
					newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(`func.copy(), expn));
				return `externalCall(op, newExprs, exfunc);
			}

			// multi-argument expression with dependence expression
			depExpr(func, multiArgExpr@multOp(op, exprs)) ->{
				debug("rule8a", "dep @ f(op, E)-> f(op, dep@E)", "");

				EList<Expression> newExprs = new BasicEList<Expression>();
				List<Expression> tempList = new LinkedList<Expression>();
				tempList.addAll(`exprs);

				for(Expression expn : tempList)
					newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(`func.copy(), expn));
				
				return `multOp(op, newExprs);
			}
			
			// index expression with dependence expression
			depExpr(func, indexExpr(function)) -> {
				debug("rule9", "dep@(val(f) -> val(f o dep)", "");

				return `indexExpr(function.compose(func));
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
			
			//dependence expression with if then else expression
			depExpr(func, ifExpr(cond, thenExp, elseExp)) -> {
				debug("rule16", "dep @ if (cond, then, else) -> if(dep@cond, dep@then, dep@else) ", "");

				return `ifExpr(depExpr(func.copy(), cond), depExpr(func.copy(), thenExp), depExpr(func.copy(), elseExp));
			}
			

			// Dependence expression with reduce expression
			depExpr(g, reduce(op, f, exprBody)) -> {
				debug("rule42", "dep @ red(op, f, expr) -> red(op, f1, dep1@expr)", "");
				
				// Define f' as "Id-like" projection function
				int qDim = `f.getNIndices() + `g.getNIndices() - `g.getDimRHS();
				long[][] linF1 = new long[`g.getDimRHS()][qDim];
				for (int i=0; i<linF1.length; i++)
					linF1[i][i] = 1;
				
				List<Variable> lIndsf1 = new BasicEList<Variable>();
				for (int i=0; i<qDim; i++)
					lIndsf1.add(_dimMana.getDimension(i));
				
				AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[`g.getDimRHS()][0],
						linF1, new long[`g.getDimRHS()], `g.getParams(), lIndsf1);
				
				// Define g' = f_{right inverse} o g o f'
				AffineFunction fRInv = FunctionOperations.computeRightInverse(`f);
				
				// DEBUG TODO
				//System.out.println("f1 = " + f1);
				//System.out.println("g = " +`g);
				//System.out.println("fRInv = " + fRInv);
				
				AffineFunction gf1 = `g.compose(f1);
				AffineFunction g1 = fRInv.compose(gf1);
				
				return `reduce(op,f1, depExpr(g1,exprBody));
				
			}

			// Reduce expression alone
			reduce(op, f, exprBody) -> {
				debug("rule42b", "red(op, f, expr) -> red(op, f1, dep@expr) if f is not canonic", "");
				
				// Is f canonic ?
				long[][] fLinPart = FunctionOperations.getMatrixRepresentation(`f).getValue1();
				boolean isCanonic = true;
				for (int i=0; i<fLinPart.length; i++)
					for (int j=0; j<fLinPart[0].length; j++)
						if (i==j) {
							if (fLinPart[i][j]!=1)
								isCanonic = false;
						} else {
							if (fLinPart[i][j]!=0)
								isCanonic = false;
						}
				
				if (isCanonic)
					return `reduce(op,f,exprBody);
				
				// f is not canonic => we extract the dependence (cf rule42 for the details)
				
				// New projection functionZ
				long[][] linF1 = new long[`f.getDimRHS()][`f.getNIndices()];
				for (int i=0; i<linF1.length; i++)
					linF1[i][i] = 1;
				List<Variable> lIndsf1 = new BasicEList<Variable>();
				for (int i=0; i<`f.getNIndices(); i++)
					lIndsf1.add(_dimMana.getDimension(i));
				
				AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[`f.getDimRHS()][0],
						linF1, new long[`f.getDimRHS()], `f.getParams(), lIndsf1);
				
				AffineFunction fRInv = FunctionOperations.computeRightInverse(`f);
				AffineFunction g1 = fRInv.compose(f1);
				
				return `reduce(op,f1, depExpr(g1,exprBody));
			}
			
		}
	}

	%strategy MergeDependences() extends Identity() {
		visit Expression {
			// Dependence - dependence
			depExpr(func, depExpr(func2, expr)) -> {
				debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
				return `depExpr(func2.compose(func), expr);
			}
		}
	}
}