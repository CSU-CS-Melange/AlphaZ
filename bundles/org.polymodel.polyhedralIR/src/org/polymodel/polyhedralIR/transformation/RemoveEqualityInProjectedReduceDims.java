package org.polymodel.polyhedralIR.transformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
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
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMatrix;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class RemoveEqualityInProjectedReduceDims extends PolyhedralIRDepthFirstVisitorImpl {
	private static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	/**
	 * Remove the dimensions of a reduction which is involved in a equality, whenever possible
	 * If all projected dimensions are removed, remove the reduction
	 * 			\sum_{k=C} Expr[k] ==> Expr[C]
	 * 
	 * @param prog
	 */
	public static void removeEqualityInProjectedReduceDims(Program prog) {
		for (AffineSystem syst : prog.getSystems())
			if (syst.getUseEquations().size()==0)
				removeEqualityInProjectedReduceDims(syst);
	}
	
	/**
	 * Remove the dimensions of a reduction which is involved in a equality, whenever possible
	 * If all projected dimensions are removed, remove the reduction
	 * 			\sum_{k=C} Expr[k] ==> Expr[C]
	 * 
	 * @param syst
	 */
	public static void removeEqualityInProjectedReduceDims(AffineSystem syst) {
		ContextDomainCalculator.computeContextDomain(syst);		// Needed, because we will call "getContextDomain"
																// when we encounter a reduction, and part of the program might have already been changed
		// DEBUG TODO
		//System.out.println("syst = " + syst.toString());
		
		RemoveEqualityInProjectedReduceDims visit = new RemoveEqualityInProjectedReduceDims();
		syst.accept(visit);
		
		if (visit._changed)
			NormalizeVisitor.normalize(syst);
	}
	
	
	/* ---------------------------------------------------------------- */
	
	private Expression _sExprToBePropagated;
	public boolean _changed = false;
	
	@Override
	public void outStandardEquation(StandardEquation stEq) {
		stEq.setExpression(_sExprToBePropagated);
	}
	
	@Override
	public void outReduceExpression(ReduceExpression redExpr) {
		// ASSERTION: the projection function of the reduction is CANONIC
		
		// We check if one of the projected dimensions is actually a scalar dimension
		
		AffineFunction projFunc = redExpr.getProjection();
		FastISLMap bmapProjFunc;
		if (projFunc instanceof FastISLMap)
			bmapProjFunc = ((FastISLMap) projFunc.copy());
		else
			bmapProjFunc = _polyIRFact.createFastISLMap(projFunc.getPMmapping());
		
		Domain contDom = redExpr.getExpr().getContextDomain();
		JNIISLSet setContDom;
		if (contDom instanceof FastISLDomain)
			setContDom = ((FastISLDomain) contDom).getIslSet();
		else
			setContDom = _polyIRFact.createFastISLDomain(contDom.getPMdomain()).getIslSet();
		
		// DEBUG
		//System.out.println();
		//System.out.println("bmapProjFunc = " + bmapProjFunc);
		//System.out.println("setContDom = " + setContDom);
		
		
		int nParam = setContDom.getNbDims(JNIISLDimType.isl_dim_param);
		
		
		// First, we get the projected dimensions - because the dependence was disociated from the projfunc, the projections are orthogonal
		//		(ie, of the form (\vec{i} -> \vec{i'}) where \vec{i'} is a subset of the dimensions of \vec{i})
		long[][] matProjFunc = bmapProjFunc.toLongMatrix();
		
		// List of indexes dimensions which are projected by the projection function
		List<Integer> ldimProjected = new BasicEList<Integer>();
		for (int j=0; j<bmapProjFunc.getNIndices(); j++) {
			boolean isNotOnlyZero = false;
			for (int i=0; i<matProjFunc.length; i++)
				if (matProjFunc[i][bmapProjFunc.getNParams()+j]!=0) {
					isNotOnlyZero = true;
					break;
				}
			if (!isNotOnlyZero)
				ldimProjected.add(j);
		}
		
		// Second, we get the equalities of the context domain of the subexpression
		
		
		JNIISLBasicSet bsetContDom = setContDom.affineHull();
		bsetContDom = bsetContDom.detectEqualities();
		JNIISLMatrix matEq = bsetContDom.getEqualityMatrix(JNIISLDimType.isl_dim_param,
				JNIISLDimType.isl_dim_div, JNIISLDimType.isl_dim_set, JNIISLDimType.isl_dim_cst);
		if (bsetContDom.getNbDims(JNIISLDimType.isl_dim_div)>0)
			throw new RuntimeException("The context domain of the expression under a reduction expression is not a polyhedron");
		
		long[][] lMatEq = new long[matEq.getNbRows()][matEq.getNbCols()];
		for (int i=0; i<lMatEq.length; i++)
			for (int j=0; j<lMatEq[0].length; j++)
				lMatEq[i][j] = matEq.getElement(i, j);
		
		
		// DEBUG
		//System.out.println("bsetContDom = " + bsetContDom.toString());
		//System.out.println("lMatEq =\n" + MatrixOperations.toString(lMatEq));
		//System.out.println("ldimProjected = " + ldimProjected.toString());
		
		
		// QUICK EXIT !
		// We check if one of the dimensions projected is involved inside one of these equalities
		List<Integer> lDimProjEq = new BasicEList<Integer>();		// List of projected dimensions which contributes to an equality
		for (int dimProj : ldimProjected) {
			boolean gotANonZeroComponent = false;
			for (int i=0; i<matEq.getNbRows(); i++)
				if (matEq.getElement(i, nParam+dimProj)!=0) {
					gotANonZeroComponent = true;
					break;
				}
			if (gotANonZeroComponent)
				lDimProjEq.add(dimProj);
		}
		
		if (lDimProjEq.size()==0) {	// Nothing to do here
			_sExprToBePropagated = _polyIRFact.createReduceExpression(redExpr.getOP(), projFunc, _sExprToBePropagated);
			return;
		}
		// END QUICK EXIT
		
		_changed = true;			// MODIF of the projection function!
		
		
		// Preparation of the main while loop which eliminates dimensions by dimensions using equalities
		
		// List of projected dimensions which contributes to an equality, using the current dimensions
		//	(ie, taking account of the previously projected dimensions in the incomming while loop)
		List<Integer> lCurrDimProjEq = new BasicEList<Integer>();
		lCurrDimProjEq.addAll(lDimProjEq);
		
		Map<Integer,Integer> mCurrentDimOldDim = new HashMap<Integer, Integer>();		// Init: all current dim corresponds to themselves
		for (int dim=0; dim<bmapProjFunc.getNIndices(); dim++)							//		(no dim projected yet)
			mCurrentDimOldDim.put(dim, dim);
		
		// We have to eliminate the scalar dimensions of lDimProjEq
		// Heuristic: we eliminate the scalar dimensions only if they contain a "1" coefficient
		//		=> check where the "1" are in the matrix matEq
		int dimJ = -1;
		int equalityI = -1;
		for (int j : lDimProjEq) {
			for (int i=0; i<lMatEq.length; i++) {
				long elem = lMatEq[i][j+nParam];
				if (elem==1 || elem==-1) {
					dimJ = j;
					equalityI = i;
					break;
				}
			}
			if (dimJ>=0)
				break;
		}
		
		FastISLMap nDepSExpr = null;		// Accumulation of the affine dependence function
		while (dimJ>=0) {
			// We select the first coefficient equal to one, propagate the rest of the equality matrix
			
			// DEBUG
			//System.out.println("dimJ = " + dimJ + " | equalityI = " + equalityI);
			// dimJ = num of the indexes to be eliminated using the equalityI-th equality
			
			
			// equalityIVector = rest of the equality used to eliminate the dimJ-th dimension
			//	"-1" multiplicator added, if the coefficient corresponding to dimJ is equal to 1
			long[] equalityIVector = lMatEq[equalityI];
			if (lMatEq[equalityI][dimJ+nParam]==1) {
				for (int i=0; i<equalityIVector.length; i++)
					equalityIVector[i] = -equalityIVector[i];
			}
			
			// We use the equalityIth equality to eliminate dimJ
			
			// Update nDepSExpr
			List<Variable> lIndsContribDepSExpr = new BasicEList<Variable>();
			if (nDepSExpr==null) {
				for (int k=0; k<projFunc.getNIndices(); k++)
					lIndsContribDepSExpr.add(projFunc.getIndices().get(k));
				lIndsContribDepSExpr.remove(dimJ);
			} else {
				for (int k=0; k<nDepSExpr.getNIndices(); k++)
					lIndsContribDepSExpr.add(nDepSExpr.getIndices().get(k));
				lIndsContribDepSExpr.remove(dimJ);
			}
			
			long[][] lmatContribDepSExpr = new long[lIndsContribDepSExpr.size()+1][nParam+lIndsContribDepSExpr.size()+1];
			for (int k=0; k<lIndsContribDepSExpr.size(); k++)
				if (k<dimJ)
					lmatContribDepSExpr[k][nParam+k] = 1;
				else
					lmatContribDepSExpr[k+1][nParam+k] = 1;
			// dimJ-th row
			for (int k=0; k<equalityIVector.length-1; k++)
				if (k<nParam+dimJ)
					lmatContribDepSExpr[dimJ][k] = equalityIVector[k];
				else
					lmatContribDepSExpr[dimJ][k] = equalityIVector[k+1];
			FastISLMap contribDepSExpr = _polyIRFact.createFastISLMapMatLong(redExpr.getProjection().getParams(),
					lIndsContribDepSExpr, lmatContribDepSExpr);
			
			// Accumulate
			if (nDepSExpr==null)
				nDepSExpr = contribDepSExpr;
			else
				nDepSExpr = (FastISLMap) nDepSExpr.compose(contribDepSExpr);
			
			// DEBUG
			//System.out.println("nDepSExpr = " + nDepSExpr.toString());
			
			
			// --- MANAGING THE RECURSION ---
			
			// Update lMatEq
			long[][] nlMatEq = new long[lMatEq.length-1][lMatEq[0].length-1];
			for (int i=0; i<equalityI; i++) {
				long coeffDimJ = lMatEq[i][dimJ];
				for (int j=0; j<dimJ; j++)
					nlMatEq[i][j] = lMatEq[i][j] + coeffDimJ*equalityIVector[j];
				for (int j=dimJ+1; j<lMatEq[0].length; j++)
					nlMatEq[i][j-1] = lMatEq[i][j] + coeffDimJ*equalityIVector[j];
			}
			for (int i=equalityI+1; i<lMatEq.length; i++) {
				long coeffDimJ = lMatEq[i][dimJ];
				for (int j=0; j<dimJ; j++)
					nlMatEq[i-1][j] = lMatEq[i][j] + coeffDimJ*equalityIVector[j];
				for (int j=dimJ+1; j<lMatEq[0].length; j++)
					nlMatEq[i-1][j-1] = lMatEq[i][j] + coeffDimJ*equalityIVector[j];
			}
			
			lMatEq = nlMatEq;
			
			// We update lCurrDimProjEq to take account of the fact that dimJ was projected
			List<Integer> nlCurrDimProjEq = new BasicEList<Integer>();
			for (int i=0; i<lCurrDimProjEq.size(); i++) {
				if (lCurrDimProjEq.get(i)>dimJ)
					nlCurrDimProjEq.add(lCurrDimProjEq.get(i)-1);
				if (lCurrDimProjEq.get(i)<dimJ)
					nlCurrDimProjEq.add(lCurrDimProjEq.get(i));
			}
			lCurrDimProjEq = nlCurrDimProjEq;
			
			// DEBUG
			//System.out.println("lCurrDimProjEq = " + lCurrDimProjEq.toString());
			

			// DEBUG
			//System.out.println("(old) mCurrentDimOldDim = " + mCurrentDimOldDim.toString());
			
			// We update mCurrentDimOldDim
			Map<Integer,Integer> nmCurrentDimOldDim = new HashMap<Integer, Integer>();
			for (int oldCurrentDim : mCurrentDimOldDim.keySet()) {
				if (oldCurrentDim<dimJ)
					nmCurrentDimOldDim.put(oldCurrentDim, mCurrentDimOldDim.get(oldCurrentDim));
				if (oldCurrentDim>dimJ)
					nmCurrentDimOldDim.put(oldCurrentDim-1, mCurrentDimOldDim.get(oldCurrentDim));
			}
			mCurrentDimOldDim = nmCurrentDimOldDim;
			
			// DEBUG
			//System.out.println("mCurrentDimOldDim = " + mCurrentDimOldDim.toString());
			
			
			
			// We update dimJ/equalityI again
			dimJ = -1;
			equalityI = -1;
			for (int j : lCurrDimProjEq) {
				for (int i=0; i<lMatEq.length; i++) {
					long elem = lMatEq[i][j+nParam];
					if (elem==1 || elem==-1) {
						dimJ = j;
						equalityI = i;
						break;
					}
				}
				if (dimJ>=0)
					break;
			}
		} // END WHILE LOOP
		
		assert(nDepSExpr!=null);
		
		/* DEBUG
		System.out.println("mCurrentDimOldDim = ");
		for (int i : mCurrentDimOldDim.keySet())
			System.out.println("	* " + i + " => " + mCurrentDimOldDim.get(i));
		System.out.println("bmapProjFunc = " + bmapProjFunc.getIslMap().toString());
		//*/
		
		
		// At this point, mCurrentDimOldDim contains the mapping from the remaining projected dims to the original dims
		if (mCurrentDimOldDim.keySet().size()==projFunc.getDimRHS()) {		// All projected dimensions were eliminated
														//			=> no need for a reduction
			_sExprToBePropagated = _polyIRFact.createDependenceExpression(nDepSExpr, _sExprToBePropagated);
		} else {
			// We build the final reduction
			JNIISLBasicMap islBMapProjFunc = bmapProjFunc.getIslMap().copy();
			
			
			// DEBUG
			//System.out.println("islBMapProjFunc = " + islBMapProjFunc.toString());
			//System.out.println("mCurrentDimOldDim = " + mCurrentDimOldDim.toString());
			
			
			List<Variable> lIndsNProjFunc = new BasicEList<Variable>();
			int nDimAlreadyRemoved = 0;
			for (int i=0; i<projFunc.getNIndices(); i++) {
				if (!mCurrentDimOldDim.containsValue(i)) {
					islBMapProjFunc = islBMapProjFunc.projectOut(JNIISLDimType.isl_dim_in, i-nDimAlreadyRemoved, 1);
					nDimAlreadyRemoved++;
				} else
					lIndsNProjFunc.add(projFunc.getIndices().get(i));
			}
			
			DomainDimensions domDimsNProjFunc = PolymodelComponent.INSTANCE.getFactory().createDomainDimensions(
					lIndsNProjFunc, projFunc.getParams());
			FastISLMap nProjFunc = _polyIRFact.createFastISLMap(domDimsNProjFunc, islBMapProjFunc, null, null);
			
			// DEBUG
			//System.out.println("islBMapProjFunc = " + islBMapProjFunc.toString());
			//System.out.println("nProjFunc = " + nProjFunc.toString());
			
			_sExprToBePropagated = _polyIRFact.createReduceExpression(redExpr.getOP(), nProjFunc,
					_polyIRFact.createDependenceExpression(nDepSExpr, _sExprToBePropagated)
					);
		}
		
		// DEBUG
		//System.out.println("_sExprToBePropagated = " + PolyhedralIRToAlphabets.toString(_sExprToBePropagated));
		
	}
	
	
	// Leaves
	@Override
	public void visitVariableExpression(VariableExpression varExpr) {
		_sExprToBePropagated = varExpr.copy();
	}
	
	@Override
	public void visitIntegerExpression(IntegerExpression intExpr) {
		_sExprToBePropagated = intExpr.copy();
	}
	
	@Override
	public void visitRealExpression(RealExpression realExpr) {
		_sExprToBePropagated = realExpr.copy();
	}
	
	@Override
	public void visitBooleanExpression(BooleanExpression boolExpr) {
		_sExprToBePropagated = boolExpr.copy();
	}
	
	@Override
	public void visitIndexExpression(IndexExpression indExpr) {
		_sExprToBePropagated = indExpr.copy();
	}
	
	
	// Branching
	@Override
	public void outDependenceExpression(DependenceExpression depExpr) {
		_sExprToBePropagated = _polyIRFact.createDependenceExpression(depExpr.getDep().copy(), _sExprToBePropagated);
	}
	
	@Override
	public void outRestrictExpression(RestrictExpression restExpr) {
		_sExprToBePropagated = _polyIRFact.createRestrictExpression(restExpr.getRestrictDomain().copy(), _sExprToBePropagated);
	}
	
	@Override
	public void outUnaryExpression(UnaryExpression uExpr) {
		_sExprToBePropagated = _polyIRFact.createUnaryExpression(uExpr.getOperator(), _sExprToBePropagated);
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
	
} // RemoveEqualityInProjectedReduceDims
