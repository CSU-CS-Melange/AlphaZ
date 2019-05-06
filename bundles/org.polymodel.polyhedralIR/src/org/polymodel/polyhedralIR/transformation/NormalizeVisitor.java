package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.javatuples.Pair;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
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
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.transformation.reduction.PermutationCaseReduce;

/**
 * New implementation of the "Normalize", "LowerDependence" and "NormalizeExpression" transformations, with a single visitor
 * 
 * In particular:
 * 		- This transformation is now linear in the size of the AST, instead of being quadratic
 * 		- An option to allow permutation of dependence and reduction has been added
 * 		- An option to add "Id@" dependence in front of every constant values/variables has been added
 * 		- We do not need to use the context domain of the expression to prune the empty branches of a case :
 * 				the needed informations are computed during the recursion.
 * 
 * @author Guillaume I
 * 
 */
public class NormalizeVisitor extends PolyhedralIRDepthFirstVisitorImpl {
	
	// --- Main methods ---
	public static void normalize(Program prog) {
		for (AffineSystem syst : prog.getSystems())
			normalize(syst);
	}
	
	public static void normalize(AffineSystem syst) {
		normalizeAndLowerDependence(syst, false, false, false);
	}
	
	public static Expression normalizeExpression(Expression expr, Domain context) {
		return normalizeAndLowerDependence(expr, false, false, false, context);
	}
	
	public static void lowerDependence(AffineSystem syst) {
		normalizeAndLowerDependence(syst, true, true, false);
	}
	
	public static void normalizeAndLowerDependence(AffineSystem syst, boolean permuteDepReduce, boolean addIDDep,
			boolean permuteRedCase) {
		for (StandardEquation stEq : syst.getEquations())
			stEq.setExpression(normalizeAndLowerDependence(stEq.getExpression(), permuteDepReduce, addIDDep, permuteRedCase,
					stEq.getVariable().getDomain()));
		for (UseEquation useEq : syst.getUseEquations()) {
			List<Expression> nExpr = new BasicEList<Expression>();
			for (Expression expr : useEq.getInputs())
				nExpr.add(normalizeAndLowerDependence(expr, permuteDepReduce, addIDDep, permuteRedCase,
						expr.getContextDomain()));  // ContextDomain: overkill ???
			useEq.getInputs().clear();
			useEq.getInputs().addAll(nExpr);
		}
	}
	
	public static Expression normalizeAndLowerDependence(Expression expr, boolean permuteDepReduce, boolean addIDDep,
			boolean permuteRedCase, Domain context) {
		NormalizeVisitor visitor = new NormalizeVisitor(permuteDepReduce, addIDDep, permuteRedCase, context);
		expr.accept(visitor);
		return visitor.getNewExpression();
	}
	
	
	// --- Options ---
	private boolean _permuteDepReduce = false;			// Should we permute dependence and reduction and
														//     make reduction canonic (projection = (i1, i2 |-> i1) )
	private boolean _addIdFuncOnContVar = false;		// Should we add "Id@" in front of every variable/constant which do not have dependences
	private boolean _permuteRedCase = false;			// Should we permute reductions and case expressions
	
	
	/* --------------------------------- VISITOR PART --------------------------------- */
	private static PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	private static DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
	

	// Attributes for the recurrences
	private AffineFunction _currentDep;
	private List<Pair<Domain, Expression>> _lSubExpr;		// If the domain is null, then we have the universe
	private Domain _contextTop;
	private Domain _context;								// Context of the build expression after normalization
	
	// TODO: possible to use the information from _context to compute context domain ???
	
	private NormalizeVisitor(boolean permuteDepReduce, boolean addIDDep, boolean permuteRedCase, Domain context) {
		_permuteDepReduce = permuteDepReduce;
		_permuteRedCase = permuteRedCase;
		_addIdFuncOnContVar = addIDDep;
		
		_currentDep = PolyhedralIRUtility.createIdentityFunction(context);
		_contextTop = context;
		_context = context;
	}
	
	private Expression getNewExpression() {
		// Prunning with context
		List<Pair<Domain,Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pDomExpr : _lSubExpr) {
			if (pDomExpr.getValue0()==null)
				nlSubExpr.add(pDomExpr);
			else if (!pDomExpr.getValue0().intersection(_contextTop).isEmpty())
				nlSubExpr.add(pDomExpr);
		}
		
		// Creating the final case
		if (nlSubExpr.size()==0) {		// Returns "" {... | 0=1 } : (i->)@1; ""
			AffineFunction depFunc = _polyIRFact.createAffineFunction(_contextTop.getParams(), _contextTop.getIndices(), new BasicEList<AffineExpression>());
			return _polyIRFact.createRestrictExpression(PolyhedralIRUtility.createEmptyDomain(_contextTop.getParams(), _contextTop.getIndices()), 
					_polyIRFact.createDependenceExpression(depFunc, _polyIRFact.createIntegerExpression(1)));
		} else if (nlSubExpr.size()==1) {
			Pair<Domain, Expression> pDomExpr = nlSubExpr.get(0);
			if (pDomExpr.getValue0()==null)		// Only one branch, which has the universe as expression domain
				return pDomExpr.getValue1();
			else
				return _polyIRFact.createRestrictExpression(pDomExpr.getValue0(), pDomExpr.getValue1());
		} else {
			List<Expression> lCaseExpr = new BasicEList<Expression>();
			for (Pair<Domain,Expression> pDomExpr : nlSubExpr)
				lCaseExpr.add(_polyIRFact.createRestrictExpression(pDomExpr.getValue0(), pDomExpr.getValue1()));
			return _polyIRFact.createCaseExpression(lCaseExpr);
		}
	}
	
	// *** Leaves ***
	@Override
	public void visitVariableExpression(VariableExpression varExpr) {
		_lSubExpr = new BasicEList<Pair<Domain,Expression>>();
		if (!_addIdFuncOnContVar && _currentDep.isIdentity())
			_lSubExpr.add(Pair.with((Domain) null, (Expression) varExpr.copy() ) );
		else
			_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createDependenceExpression(_currentDep.copy(), varExpr.copy()) ) );
	}
	
	@Override
	public void visitIndexExpression(IndexExpression indExpr) {
		AffineFunction nFunc = indExpr.getFunction().compose(_currentDep);
		_lSubExpr = new BasicEList<Pair<Domain,Expression>>();
		_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createIndexExpression(nFunc)));
	}
	
	@Override
	public void visitBooleanExpression(BooleanExpression boolExpr) {
		_lSubExpr = new BasicEList<Pair<Domain,Expression>>();
		if (_addIdFuncOnContVar || _currentDep.getNIndices()!=0)
			_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createDependenceExpression(_currentDep.copy(), boolExpr.copy()) ));
		else 
			_lSubExpr.add(Pair.with((Domain) null, (Expression) boolExpr.copy() ));
	}
	
	@Override
	public void visitIntegerExpression(IntegerExpression intExpr) {
		_lSubExpr = new BasicEList<Pair<Domain,Expression>>();
		if (_addIdFuncOnContVar || _currentDep.getNIndices()!=0)
			_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createDependenceExpression(_currentDep.copy(), intExpr.copy()) ));
		else 
			_lSubExpr.add(Pair.with((Domain) null, (Expression) intExpr.copy() ));
	}
	
	@Override
	public void visitRealExpression(RealExpression realExpr) {
		_lSubExpr = new BasicEList<Pair<Domain,Expression>>();
		if (_addIdFuncOnContVar || _currentDep.getNIndices()!=0)
			_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createDependenceExpression(_currentDep.copy(), realExpr.copy()) ));
		else 
			_lSubExpr.add(Pair.with((Domain) null, (Expression) realExpr.copy() ));
	}
	
	
	// *** Operations ***
	@Override
	public void visitDependenceExpression(DependenceExpression depExpr) {
		_currentDep = depExpr.getDep().compose(_currentDep);
		// No change on _context: the dependence is removed afterward... :/
		
		depExpr.getExpr().accept(this);
		// Bottom-up: Dependence removed => no change to _lSubExpr
	}
	
	@Override
	public void visitRestrictExpression(RestrictExpression restrExpr) {
		// _currentDep does not move
		Domain nRestrDom = restrExpr.getRestrictDomain().preimage(_currentDep);
		_context = _context.intersection(nRestrDom);
		restrExpr.getExpr().accept(this);
		
		List<Pair<Domain,Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pSubExpr : _lSubExpr)
			if (pSubExpr.getValue0()==null)
				nlSubExpr.add(Pair.with(nRestrDom.copy(), pSubExpr.getValue1()));
			else
				nlSubExpr.add(Pair.with(pSubExpr.getValue0().intersection(nRestrDom),  pSubExpr.getValue1()));
		_lSubExpr = nlSubExpr;
	}
	
	@Override
	public void visitReduceExpression(ReduceExpression redExpr) {
		AffineFunction f1 = null;				// If permutation allowed, new projection function
		AffineFunction topDep = null;			// If permutation not allowed, dependence in front of reduction
		Domain contextSubExpr;
		
		if (_permuteDepReduce) {
			// dep @ red(op, f, expr) -> red(op, f1, dep1@expr)
			AffineFunction projFunc = redExpr.getProjection();
			AffineFunction depG = _currentDep;
			
			// Define f' as "Id-like" projection function
			int nDimsProjected = projFunc.getNIndices() - projFunc.getDimRHS();
			int qDim = nDimsProjected + depG.getNIndices();
			
			long[][] linF1 = new long[depG.getNIndices()][qDim];
			for (int i=0; i<linF1.length; i++)
				linF1[i][i] = 1;
			
			List<Variable> lIndsf1 = new BasicEList<Variable>();
			for (int i=0; i<qDim; i++)
				lIndsf1.add(_dimMana.getDimension(i));
			
			f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[linF1.length][0],
					linF1, new long[linF1.length], depG.getParams(), lIndsf1);  // New projection function
			// Define g' = f_{right inverse} o g o f'  (ie fRInv o depG o f1)
			
			// TODO DEBUG
			//System.out.println();
			//System.out.println("redExpr = " + PolyhedralIRToAlphabets.toString(redExpr));
			//System.out.println("depG = " + depG.toString());
			//System.out.println("f1 = " + f1.toString());
			
			
			
			AffineFunction fRInv = FunctionOperations.computeRightInverse(projFunc);		// TODO: not only !!!
			AffineFunction gf1 = depG.compose(f1);
			_currentDep = fRInv.compose(gf1);		// g1
			
			// For each dimensions of _currentDep which are projected (thus, which are put to "0"), we add the corresponding index
			List<Variable> lIndProjected = new BasicEList<Variable>();
			for (int i=0; i<nDimsProjected; i++)
				lIndProjected.add(_currentDep.getIndices().get(i+f1.getDimRHS()));
			
			int nIndProj = 0;
			List<AffineExpression> nCurrentDepExpr = new BasicEList<AffineExpression>();
			for (int i=0; i<_currentDep.getExpressions().size(); i++) {
				if (fRInv.getExpressions().get(i).isZero()==FuzzyBoolean.YES) {
					nCurrentDepExpr.add(IntExpressionBuilder.affine(lIndProjected.get(nIndProj)));
					nIndProj++;
				} else
					nCurrentDepExpr.add((AffineExpression) _currentDep.getExpressions().get(i).copy());
			}
			_currentDep = _polyIRFact.createAffineFunction(_currentDep.getParams(), _currentDep.getIndices(), nCurrentDepExpr);
			
			contextSubExpr = _context.preimage(f1);
			_context = contextSubExpr.copy();
		} else {				// No permutation of dependences
			topDep = _currentDep;
			_currentDep = PolyhedralIRUtility.createIdentityFunction(redExpr.getProjection().getParams(), redExpr.getProjection().getIndices());
			
			// No permutation => topDep will be in front of the reduction
			contextSubExpr = _context.image(topDep).preimage(redExpr.getProjection());
			_context = contextSubExpr.copy();
		}
		
		redExpr.getExpr().accept(this);
		
		// Prunning with context
		List<Pair<Domain,Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pDomExpr : _lSubExpr) {
			if (pDomExpr.getValue0()==null)
				nlSubExpr.add(pDomExpr);
			else if (!pDomExpr.getValue0().intersection(contextSubExpr).isEmpty())
				nlSubExpr.add(pDomExpr);
		}
		
		Expression caseExpr;
		boolean caseUnderRed = false;			// Is there a case expression behind the reduction?
		if (nlSubExpr.size()==0) {		// "" {... | 0=1 } : (i->)@1; ""
			AffineFunction depFunc = _polyIRFact.createAffineFunction(_context.getParams(), _context.getIndices(), new BasicEList<AffineExpression>());
			caseExpr =  _polyIRFact.createRestrictExpression(PolyhedralIRUtility.createEmptyDomain(_context.getParams(), _context.getIndices()), 
					_polyIRFact.createDependenceExpression(depFunc, _polyIRFact.createIntegerExpression(1)));
		} else if (nlSubExpr.size()==1) {
			Pair<Domain,Expression> pSExpr = nlSubExpr.get(0);
			if (pSExpr.getValue0()==null)
				caseExpr = pSExpr.getValue1();
			else
				caseExpr = _polyIRFact.createRestrictExpression(pSExpr.getValue0(), pSExpr.getValue1());
		} else {
			List<Expression> lExprCase = new BasicEList<Expression>();
			for (Pair<Domain,Expression> pSExpr : nlSubExpr) {
				if (pSExpr.getValue0()==null)
					lExprCase.add(pSExpr.getValue1());
				else
					lExprCase.add(_polyIRFact.createRestrictExpression(pSExpr.getValue0(), pSExpr.getValue1()));
			}
			caseExpr = _polyIRFact.createCaseExpression(lExprCase);
			
			caseUnderRed = true;
		}
		
		_lSubExpr.clear();
		if (_permuteDepReduce) {
			ReduceExpression exprTemp = _polyIRFact.createReduceExpression(redExpr.getOP(), f1, caseExpr);
			Expression exprTemp2;
			if (caseUnderRed && _permuteRedCase)
				exprTemp2 = PermutationCaseReduce.applyCaseReduce(exprTemp);
			else
				exprTemp2 = exprTemp;
			_lSubExpr.add(Pair.with((Domain) null, exprTemp2) );
		} else {				// No permutation
			ReduceExpression exprTemp = _polyIRFact.createReduceExpression(redExpr.getOP(), redExpr.getProjection(), caseExpr);
			Expression exprTemp2;
			if (caseUnderRed && _permuteRedCase)
				exprTemp2 = PermutationCaseReduce.applyCaseReduce(exprTemp);
			else
				exprTemp2 = exprTemp;
			
			if (topDep.isIdentity())
				_lSubExpr.add(Pair.with((Domain) null, exprTemp2));
			else
				_lSubExpr.add(Pair.with((Domain) null, (Expression) _polyIRFact.createDependenceExpression(topDep, exprTemp2) ));
		}
	}
	
	@Override
	public void visitCaseExpression(CaseExpression caseExpr) {
		AffineFunction origCurrentDep = _currentDep.copy();
		Domain origContext = _context.copy();
		
		List<Pair<Domain,Expression>> lTotalSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Expression sExpr : caseExpr.getExprs()) {
			sExpr.accept(this);
			lTotalSubExpr.addAll(_lSubExpr);
			
			// Reinitializing the top-down recursion
			_currentDep = origCurrentDep;
			_context = origContext;
		}
		
		_lSubExpr = lTotalSubExpr;
	}
	
	@Override
	public void visitUnaryExpression(UnaryExpression unExpr) {
		// _currentDep does not move
		unExpr.getExpr().accept(this);
		
		List<Pair<Domain,Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pSubExpr : _lSubExpr)
			nlSubExpr.add(Pair.with(pSubExpr.getValue0(), (Expression) _polyIRFact.createUnaryExpression(unExpr.getOperator(), pSubExpr.getValue1())));
		_lSubExpr = nlSubExpr;
	}
	
	@Override
	public void visitBinaryExpression(BinaryExpression binExpr) {
		AffineFunction origCurrentDep = _currentDep.copy();
		Domain origContext = _context.copy();
		
		binExpr.getLexp().accept(this);
		List<Pair<Domain, Expression>> sExprLeft = _lSubExpr;

		// Reinitializing the top-down recursion
		_currentDep = origCurrentDep;
		_context = origContext;
		
		binExpr.getRexp().accept(this);
		List<Pair<Domain, Expression>> sExprRight = _lSubExpr;
		
		List<Pair<Domain, Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pExprLeft : sExprLeft)
			for (Pair<Domain,Expression> pExprRight : sExprRight) {
				if (pExprLeft.getValue0()==null) {
					if (pExprRight.getValue0()==null)
						nlSubExpr.add(Pair.with((Domain) null,
							(Expression) _polyIRFact.createBinaryExpression(binExpr.getOperator(), pExprLeft.getValue1().copy(), pExprRight.getValue1().copy())));
					else
						nlSubExpr.add(Pair.with(pExprRight.getValue0().copy(),
							(Expression) _polyIRFact.createBinaryExpression(binExpr.getOperator(), pExprLeft.getValue1().copy(), pExprRight.getValue1().copy())));
				} else {
					if (pExprRight.getValue0()==null)
						nlSubExpr.add(Pair.with(pExprLeft.getValue0().copy(),
								(Expression) _polyIRFact.createBinaryExpression(binExpr.getOperator(), pExprLeft.getValue1().copy(), pExprRight.getValue1().copy())));
					else {
						Domain domInter = pExprLeft.getValue0().intersection(pExprRight.getValue0());
						if (!domInter.isEmpty())
							nlSubExpr.add(Pair.with(domInter,
								(Expression) _polyIRFact.createBinaryExpression(binExpr.getOperator(), pExprLeft.getValue1().copy(), pExprRight.getValue1().copy())));
					}
				}
			}
		
		_lSubExpr = nlSubExpr;
	}
	
	
	@Override
	public void visitIfExpression(IfExpression ifExpr) {
		AffineFunction origCurrentDep = _currentDep.copy();
		Domain origContext = _context.copy();
		
		ifExpr.getCond().accept(this);
		List<Pair<Domain, Expression>> sExprCond = _lSubExpr;
		_currentDep = origCurrentDep;
		_context = origContext;
		
		ifExpr.getThen().accept(this);
		List<Pair<Domain, Expression>> sExprThen = _lSubExpr;
		_currentDep = origCurrentDep;
		_context = origContext;
		
		ifExpr.getElse().accept(this);
		List<Pair<Domain, Expression>> sExprElse = _lSubExpr;
		
		List<Pair<Domain, Expression>> nlSubExpr = new BasicEList<Pair<Domain,Expression>>();
		for (Pair<Domain,Expression> pExprCond : sExprCond)
		for (Pair<Domain,Expression> pExprThen : sExprThen)
		for (Pair<Domain,Expression> pExprElse : sExprElse) {
			Domain domInter = pExprCond.getValue0();
			if (domInter==null)
				if (pExprThen.getValue0()==null)
					domInter=null;
				else
					domInter = pExprThen.getValue0().copy();
			else
				if (pExprThen.getValue0()!=null)
					domInter = domInter.intersection(pExprThen.getValue0());
			if (domInter==null)
				if (pExprElse.getValue0()==null)
					domInter=null;
				else
					domInter = pExprElse.getValue0().copy();
			else
				if (pExprElse.getValue0()!=null)
					domInter = domInter.intersection(pExprElse.getValue0());
			
			if (domInter==null || !(domInter.isEmpty()))
				nlSubExpr.add(Pair.with(domInter,
						(Expression) _polyIRFact.createIfExpression(pExprCond.getValue1().copy(), pExprThen.getValue1().copy(), pExprElse.getValue1().copy())));
		}
		
		_lSubExpr = nlSubExpr;
	}
	
	@Override
	public void visitMultiArgExpression(MultiArgExpression multExpr) {
		AffineFunction origCurrentDep = _currentDep.copy();
		Domain origContext = _context.copy();
		
		List<List<Pair<Domain, Expression>>> llSubExpr = new BasicEList<List<Pair<Domain,Expression>>>();
		for (Expression sExpr : multExpr.getExprs()) {
			sExpr.accept(this);
			llSubExpr.add(_lSubExpr);
			_currentDep = origCurrentDep;
			_context = origContext;
		}
		
		
		// Initialization
		List<Pair<Domain, List<Expression>>> lCurrentSubExpr = new BasicEList<Pair<Domain,List<Expression>>>();
		for (Pair<Domain,Expression> pDomExpr : llSubExpr.get(0)) {
			List<Expression> lExprTemp = new BasicEList<Expression>();
			lExprTemp.add(pDomExpr.getValue1());
			lCurrentSubExpr.add(Pair.with(pDomExpr.getValue0(), lExprTemp));
		}
		
		// Cross intersection
		for (int k=1; k<llSubExpr.size(); k++) {
			List<Pair<Domain,List<Expression>>> lnCurrentSubExpr = new BasicEList<Pair<Domain,List<Expression>>>();
			for (Pair<Domain,List<Expression>> pCurrent : lCurrentSubExpr)
			for (Pair<Domain,Expression> pNew : llSubExpr.get(k)) {
				if (pCurrent.getValue0()==null) {
					List<Expression> nlTemp = new BasicEList<Expression>();
					nlTemp.addAll(pCurrent.getValue1());
					nlTemp.add(pNew.getValue1().copy());
					
					lnCurrentSubExpr.add(Pair.with(pNew.getValue0(), nlTemp));
				} else if (pNew.getValue0()==null) {
					List<Expression> nlTemp = new BasicEList<Expression>();
					nlTemp.addAll(pCurrent.getValue1());
					nlTemp.add(pNew.getValue1().copy());
					
					lnCurrentSubExpr.add(Pair.with(pCurrent.getValue0(), nlTemp));
				} else {
					Domain domInter = pNew.getValue0().intersection(pCurrent.getValue0());
					if (!domInter.isEmpty()) {
						List<Expression> nlTemp = new BasicEList<Expression>();
						nlTemp.addAll(pCurrent.getValue1());
						nlTemp.add(pNew.getValue1());
						
						lnCurrentSubExpr.add(Pair.with(domInter, nlTemp));
					}
				}
			}
			lCurrentSubExpr = lnCurrentSubExpr;
		}
		
		// Finishing
		_lSubExpr.clear();
		for (Pair<Domain, List<Expression>> pDomlExpr : lCurrentSubExpr)
			_lSubExpr.add(Pair.with(pDomlExpr.getValue0(), 
					(Expression) _polyIRFact.createMultiArgExpression(multExpr.getOperator(), pDomlExpr.getValue1())));
	}
	
	@Override
	public void visitExternalFunctionCall(ExternalFunctionCall multExpr) {
		AffineFunction origCurrentDep = _currentDep.copy();
		Domain origContext = _context.copy();
		
		List<List<Pair<Domain, Expression>>> llSubExpr = new BasicEList<List<Pair<Domain,Expression>>>();
		for (Expression sExpr : multExpr.getExprs()) {
			sExpr.accept(this);
			llSubExpr.add(_lSubExpr);
			_currentDep = origCurrentDep;
			_context = origContext;
		}
		
		
		// Initialization
		List<Pair<Domain, List<Expression>>> lCurrentSubExpr = new BasicEList<Pair<Domain,List<Expression>>>();
		for (Pair<Domain,Expression> pDomExpr : llSubExpr.get(0)) {
			List<Expression> lExprTemp = new BasicEList<Expression>();
			lExprTemp.add(pDomExpr.getValue1());
			lCurrentSubExpr.add(Pair.with(pDomExpr.getValue0(), lExprTemp));
		}
		
		// Cross intersection
		for (int k=1; k<llSubExpr.size(); k++) {
			List<Pair<Domain,List<Expression>>> lnCurrentSubExpr = new BasicEList<Pair<Domain,List<Expression>>>();
			for (Pair<Domain,List<Expression>> pCurrent : lCurrentSubExpr)
			for (Pair<Domain,Expression> pNew : llSubExpr.get(k)) {
				if (pCurrent.getValue0()==null) {
					List<Expression> nlTemp = new BasicEList<Expression>();
					nlTemp.addAll(pCurrent.getValue1());
					nlTemp.add(pNew.getValue1());
					
					lnCurrentSubExpr.add(Pair.with(pNew.getValue0(), nlTemp));
				} else if (pNew.getValue0()==null) {
					List<Expression> nlTemp = new BasicEList<Expression>();
					nlTemp.addAll(pCurrent.getValue1());
					nlTemp.add(pNew.getValue1().copy());
					
					lnCurrentSubExpr.add(Pair.with(pCurrent.getValue0(), nlTemp));
				} else {
					Domain domInter = pNew.getValue0().intersection(pCurrent.getValue0());
					if (!domInter.isEmpty()) {
						List<Expression> nlTemp = new BasicEList<Expression>();
						nlTemp.addAll(pCurrent.getValue1());
						nlTemp.add(pNew.getValue1());
						
						lnCurrentSubExpr.add(Pair.with(domInter, nlTemp));
					}
				}
			}
			lCurrentSubExpr = lnCurrentSubExpr;
		}
		
		// Finishing
		_lSubExpr.clear();
		for (Pair<Domain, List<Expression>> pDomlExpr : lCurrentSubExpr)
			_lSubExpr.add(Pair.with(pDomlExpr.getValue0(), 
					(Expression) _polyIRFact.createExternalFunctionCall(multExpr.getExFunc(), pDomlExpr.getValue1())));
	}
	
} // NormalizeVisitor
