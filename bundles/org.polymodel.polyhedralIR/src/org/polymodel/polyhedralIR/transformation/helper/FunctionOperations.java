package org.polymodel.polyhedralIR.transformation.helper;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.javatuples.Triplet;
import org.polymodel.DimensionsManager;
import org.polymodel.IndexDimension;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class FunctionOperations {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Uses ISL to apply a function to a constant point in the iteration space.
	 * Somewhat hacky implementation
	 * 
	 * @param vector
	 * @param function
	 * @return
	 */
	public static List<Integer> applyFunction(List<Integer> vector, AffineFunction function) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		//size check
		if (vector.size() != function.getDimLHS() - function.getParams().size()) {
			System.err.println(vector);
			System.err.println(function);
			throw new RuntimeException("Size of the function and vector does not match.");
		}
		

		StringBuffer consts = new StringBuffer();
		for (Integer c : vector) {
			if (consts.length() > 0) {
				consts.append(",");
			}
			consts.append(c);
		}
		StringBuffer sb = new StringBuffer();
		for (Variable v : function.getParams()) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(v.getName());
		}
		JNIISLSet set = ISLFactory.islSet("["+sb+"]->{["+consts+"]}");
		function.getPMmapping().toString(OUTPUT_FORMAT.ISL);
		JNIISLMap map = ISLNativeBinder.jniIslMap(function.getPMmapping().buildRelation(manager));
		JNIISLSet res = set.apply(map);
		String polylibStr = res.toString(ISL_FORMAT.POLYLIB);
		String[] line = polylibStr.split("\r|\n");
		//number of polyhedron
		int numP = Integer.parseInt(line[0]);
		//check
		if (numP != 1) {
			throw new RuntimeException("Application of function to a constant point did not result in a signle polyhedron.");
		}

		//size of polyhedron
		String[] sizeStr = line[2].split("(\\s|\\t)+");
		int numRow = Integer.parseInt(sizeStr[0]);
		int numCol = Integer.parseInt(sizeStr[1]);

 		//Initialize Result
		List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < numRow; i++) {
			result.add(0);
		}
		
		//look row by row
 		for (int r = 0; r < numRow; r++) {
 			String[] rowStr = line[r+3].split("(\\s|\\t)+");
 			//make sure its an equality
 			if (Integer.parseInt(rowStr[0]) != 0) {
 				throw new RuntimeException("One of the constraints was not an equality.");
 			}
 			int currentDim = -1;
 			for (int d = 0; d < numRow; d++) {
 				if (Integer.parseInt(rowStr[d+1]) == 1) {
 					currentDim = d;
 					break;
 				}
 			}
 			if (currentDim == -1) {
 				throw new RuntimeException("Unexpected Error.");
 			}
 			result.set(currentDim, -Integer.parseInt(rowStr[numCol-1]));
 		}
		
		return result;
		
	}
	
	
	
	public static AffineFunction insertDimension(AffineFunction function, AffineExpression expr, int dim) {
		List<AffineExpression> exprs = function.getExpressions();
		exprs.add(dim, expr);
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(function.getParams(), function.getIndices(), exprs);
	}
	
	/**
	 * Creates a function that is identity + shifts as specified by the input list.
	 * Inputs indices and shifts must be the same size.
	 * 
	 * @param params
	 * @param indices
	 * @param shifts
	 * @return
	 */
	public static AffineFunction createShiftFunction(List<Variable> params, List<Variable> indices, List<AffineTerm> shifts) {
		assert(indices.size() == shifts.size());
		
		List<AffineExpression> exprs = new ArrayList<AffineExpression>(indices.size());
		
		for (int i = 0; i < indices.size(); i++) {
			AffineExpression expr = affine(term(indices.get(i)));
			AffineTerm s = shifts.get(i);
			if (s != null) {
				expr.getTerms().add(s);
			}
			exprs.add(expr);
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, exprs);
	
	}

	/**
	 * Overload for createShiftFunction when only one dimension needs to be shifted.
	 * 
	 * @param params
	 * @param indices
	 * @param shift
	 * @param dim
	 * @return
	 */
	public static AffineFunction createShiftFunction(List<Variable> params, List<Variable> indices, AffineTerm shift, int dim) {
		List<AffineTerm> shifts = new ArrayList<AffineTerm>(indices.size());
		
		for (int i = 0; i < indices.size(); i++) {
			if (i == dim) {
				shifts.add(shift);
			} else {
				shifts.add(null);
			}
		}

		return createShiftFunction(params, indices, shifts);
	}
	
	/**
	 * Add the dimensions corresponding to indices at the beginning of function
	 * 
	 * @param function
	 * @param indices
	 * @return
	 */
	public static AffineFunction addFirstDimension(AffineFunction function, List<Variable> indices) {
		List<AffineExpression> lexpr = function.getExpressions();
		List<Variable> lparam = function.getParams();
		List<Variable> lind = function.getIndices();
		
		List<Variable> nInd = new BasicEList<Variable>();
		nInd.addAll(indices);
		nInd.addAll(lind);
		
		List<AffineExpression> nlexpr = new BasicEList<AffineExpression>();
		for (Variable var : indices) {
			nlexpr.add(affine(term(var)));
		}
		nlexpr.addAll(lexpr);
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(lparam, nInd, nlexpr);
	}
	
	/**
	 * Add the dimensions corresponding to indices at the end of function
	 * @param function
	 * @param indices
	 * @return
	 */
	public static AffineFunction addLastDimensions(AffineFunction function, List<Variable> indices){
		List<AffineExpression> lexpr = function.getExpressions();
		List<Variable> lparam = function.getParams();
		List<Variable> lind = function.getIndices();
		
		List<Variable> nInd = new BasicEList<Variable>();
		nInd.addAll(lind);
		nInd.addAll(indices);
		
		List<AffineExpression> nlexpr = new BasicEList<AffineExpression>();
		nlexpr.addAll(lexpr);
		for(Variable var : indices) {
			nlexpr.add(affine(term(var)));
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(lparam, nInd, nlexpr);
	}
	
	/**
	 * Build the AffineFunction (func \times Id_{d})
	 * 
	 * @param func
	 * @param d
	 */
	public static AffineFunction addLastDimensions(AffineFunction func, int d) {
		List<Variable> indices = new BasicEList<Variable>();
		DimensionsManager dm = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		for (int k=0; k<d; k++)
			indices.add(dm.getDimension(k+func.getNIndices()));// Create these new indices
		
		return addLastDimensions(func, indices);
	}
	
	/**
	 * Translate parameters of an affine function, according to a mapping that might replace parameters by indexes of extDom
	 *     (used with sub-systems)
	 * Gives back the same function, but translated, and with dimensions for extDom added in the first positions.
	 * 
	 * @param afOrig
	 * @param mapping
	 * @param extDom
	 * @return
	 */
	public static AffineFunction translateParams(AffineFunction afOrig, AffineFunction mapping, Domain extDom) {
		
		// Extending the first dimension of afOrig
		
		//get the set of extension domain index
		//make sure that the extension domain index does not conflict with the original affine function or with the extension domain parameters
		List<Variable> variables = afOrig.getIndices();
		
		//check whether the variables are used in the affine function
		for(int i = 0; i < afOrig.getNIndices(); i++){
			IndexDimension id = (IndexDimension) variables.get(i);
			StringBuffer postFix = new StringBuffer("");
			while (extDom.getParamNames().contains(id.getName() + postFix) || extDom.getIndexNames().contains(id.getName() + postFix)) {
				postFix.append("p");
			}
			//new var
			Variable newVar = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(i, id.getName() + postFix);
			variables.set(i,newVar);
		}
		
		//get the set of new index
		List<String> newIndex = new LinkedList<String>();
		newIndex.addAll(extDom.getIndexNames());
		for(int i = 0; i < variables.size(); i++) newIndex.add(variables.get(i).toString());
		
		//get the set of new expressions
		List<String> nlExprs = new LinkedList<String>();
		//add the extension domain index as the first few expressions
		//if(newVarDeclared)
		nlExprs.addAll(extDom.getIndexNames());
		
		//construct new expressions for the original functions
		for(AffineExpression expr : afOrig.getExpressions()){
			AffineExpression nexpr = (AffineExpression)expr.copy();
			//substitute the old function index with the new index
			for(int k = 0; k < afOrig.getNIndices(); k++){
				if(!variables.get(k).getName().contentEquals(afOrig.getIndexNames().get(k)))
					nexpr = (AffineExpression) nexpr.substitute(afOrig.getIndices().get(k), variables.get(k));
			}
			//substitute the parameters with the passed inside expression
			for(int k = 0; k < afOrig.getNParams(); k++){
				Variable origParam = afOrig.getParams().get(k);
				nexpr = (AffineExpression) nexpr.substitute(origParam, mapping.getExpressions().get(k));
			}
			nlExprs.add(nexpr.toString(OUTPUT_FORMAT.ALPHABETS));
		}
		
		//construct the new affine function
		AffineFunction extendedFunction = PolyhedralIRUtility.parseAffineFunctionFromString(extDom.getParamNames(), newIndex, nlExprs);
		
		return extendedFunction;
	}
	
	/**
	 * Given a function f = Ax + b, returns f' = Ax
	 * 
	 * @param f
	 * @return
	 */
	public static AffineFunction dropAffinePart(AffineFunction f) {
		List<AffineExpression> exprs = f.getExpressions();
		for (AffineExpression expr : exprs) {
			if (expr.getTerm(null) != null) {
				expr.getTerm(null).setCoef(0);
			}
		}
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(f.getParams(), f.getIndices(), exprs);
	}
	
	
	/* ------------------------------------------- */
	
	/**
	 * Computes the right-inverse of a function f
	 * Throws an error if the input function does not admit any right inverse
	 * 
	 * @param f
	 * @return
	 */
	public static AffineFunction computeRightInverse(AffineFunction f) {
		if (f.getDimRHS()==0) {
			// f = (\vec{i} ->)  => return (-> \vec{0})
			
			List<AffineExpression> lExprZeros = new BasicEList<AffineExpression>();
			for (int k=0; k<f.getNIndices(); k++)
				lExprZeros.add(IntExpressionBuilder.affine(IntExpressionBuilder.constant(0)));
			
			return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(f.getParams(), new BasicEList<Variable>(), lExprZeros);
		}
		
		Triplet<long[][], long[][], long[]> matInfof = getMatrixRepresentation(f);
		long[][] linF = matInfof.getValue1();
		
		
		
		Triplet<long[][], long[][], long[][]> lSnfLinF = MatrixOperations.smithNormalForm(linF);
		
		// Check if f admit a right-inverse
		assert(linF.length<=linF[0].length);
		for (int i=0; i<linF.length; i++)
			assert(lSnfLinF.getValue0()[i][i]==1);
		
		// *** Computes the right inverse of linF
		//	We want to find "R" such that "linF.R = Id"
		//		=> S = Q1inv.A.Q2inv (HNF)  where S = (Id | 0)  (because admits a right-inverse)
		//		=> R = Q2inv.[Id |0]^T.Q1inv  (one possible solution)
		long[][] Q1inv = lSnfLinF.getValue1(); // Q1inv.A.Q2inv = S
		long[][] Q2inv = lSnfLinF.getValue2();
		long[][] id0 = new long[Q2inv.length][Q1inv.length];
		for (int i=0; i<Q1inv.length; i++)
			id0[i][i] = 1;
		long[][] R = MatrixOperations.matrixMultiplication(Q2inv,
				MatrixOperations.matrixMultiplication(id0,Q1inv)
				);
		
		/* DEBUG
		System.out.println("Q1inv = " + MatrixOperations.toString(Q1inv));
		System.out.println("Q2inv = " + MatrixOperations.toString(Q2inv));
		System.out.println("R = " + MatrixOperations.toString(R));
		//*/
		
		
		// *** Computes the right inverse of the function
		// If f:(i |-> Q.i + Qp.p + q), then f = fParam o fLin where:
		//		* fLin:(i |-> Q.i)
		//		* fParam:(i1 |-> i1 + Qp.p + q)
		// Thus, the right inverse of f is "(i1 |-> i1 - Qp.p - q) o (i1 |-> R.i1)" 
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		List<Variable> lInds1 = new BasicEList<Variable>();
		for (int k=0; k<linF.length;k++)
			lInds1.add(dimMana.getDimension(k));
		
		long[][] idI1 = new long[linF.length][linF.length];
		for (int i=0; i<idI1.length; i++)
			idI1[i][i] = 1;
		
		long[][] minusParF = new long[linF.length][f.getNParams()];
		for (int i=0; i<minusParF.length; i++)
			for (int j=0; j<minusParF[0].length; j++)
				minusParF[i][j] = - matInfof.getValue0()[i][j];
		
		long[] minusConstF = new long[linF.length];
		for (int i=0; i<minusConstF.length; i++)
			minusConstF[i] = - matInfof.getValue2()[i];
		AffineFunction fParamInv = createAffineFunctionFromMatrix(minusParF, idI1, minusConstF, f.getParams(), lInds1);
		AffineFunction fLinInv = createAffineFunctionFromMatrix(new long[linF[0].length][f.getNParams()], R, new long[linF[0].length],
				f.getParams(), lInds1);
		
		return fLinInv.compose(fParamInv);
	}
	
	/**
	 * Extract the basic informations of an affine function under the form of a matrix
	 * 
	 * @param f
	 * @return
	 */
	public static Triplet<long[][], long[][], long[]> getMatrixRepresentation(AffineFunction f) {
		
		long[][] fparamlinConst = f.getPMmapping().toMatrix().toLongArray();
		
		if (fparamlinConst.length==0)
			return Triplet.with(new long[0][f.getNParams()], new long[0][f.getNIndices()], new long[0]);
		
		long[][] fparam;
		if (f.getNParams()>0)
			fparam = MatrixOperations.submatrixColumn(fparamlinConst, 0, f.getNParams()-1);
		else
			fparam = new long[fparamlinConst.length][0];
		
		long[][] flin;
		if (f.getNIndices()>0)
			flin = MatrixOperations.submatrixColumn(fparamlinConst, f.getNParams(), f.getNParams()+ f.getNIndices()-1);
		else
			flin = new long[fparamlinConst.length][0];
		
		long[] fConst = new long[f.getExpressions().size()];
		for (int i=0; i<fConst.length; i++)
			fConst[i] = fparamlinConst[i][fparamlinConst[0].length-1];
		
		return new Triplet<long[][], long[][], long[]>(fparam, flin, fConst);
	}
	
	/**
	 * Creates an affine function from its matrices
	 * 
	 * @param Qp
	 * @param Qi
	 * @param q
	 * @param lParams
	 * @param lInds
	 * @return
	 */
	public static AffineFunction createAffineFunctionFromMatrix(long[][] Qp, long[][] Qi, long[] q,
			List<Variable> lParams, List<Variable> lInds) {
		List<AffineExpression> lExprQpQiq = new BasicEList<>();
		for (int i=0; i<q.length; i++) {
			List<AffineTerm> lterms = new BasicEList<AffineTerm>();
			
			if (Qp.length>0)											// Parameters
				for (int j=0; j<Qp[0].length; j++)
					if (Qp[i][j]!=0)
						lterms.add(IntExpressionBuilder.term(Qp[i][j], lParams.get(j)));
			for (int j=0; j<Qi[0].length; j++)							// Variables
				if (Qi[i][j]!=0)
					lterms.add(IntExpressionBuilder.term(Qi[i][j], lInds.get(j)));
			if (q[i]!=0)
				lterms.add(IntExpressionBuilder.term(q[i]));			// Constant
			
			lExprQpQiq.add(IntExpressionBuilder.affine(lterms));
		}
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(lParams, lInds, lExprQpQiq);
	}
	
} // FunctionOperations
