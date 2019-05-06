package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.javatuples.Pair;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class ReduceDimensionVariable {
	
	private static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	/**
	 * Reduce the number of dimension of a variable, by using its equalities
	 * 
	 * @param syst
	 * @param varDecl
	 */
	public static AffineFunction reduceDimVariable(AffineSystem syst, VariableDeclaration varDecl) {
		Domain domVarDecl = varDecl.getDomain();
		
		JNIISLSet setVarDecl;
		if (domVarDecl instanceof FastISLDomain)
			setVarDecl = ((FastISLDomain) domVarDecl).getIslSet();
		else
			setVarDecl = _polyIRFact.createFastISLDomain(domVarDecl.getPMdomain()).getIslSet();
		
		if (true)
			throw new UnsupportedOperationException("Not supported due to AffineLattice not being ported.");
		Pair<JNIISLSet,JNIISLBasicMap> pResProjEq = null;//AffineLatticeMatrixOperations.projectEqualities(setVarDecl);
		if (pResProjEq==null)		// Nothing to project
			return PolyhedralIRUtility.createIdentityFunction(domVarDecl);
		
		// phi(nDomVarDeclOut) = domVarDeclOut
		FastISLDomain nDomVarDecl = _polyIRFact.createFastISLDomain(pResProjEq.getValue0());
		JNIISLBasicMap phi = pResProjEq.getValue1();
		
		FastISLMap nDep = _polyIRFact.createFastISLMap(phi);
		AffineFunction invInContnDep = nDep.inverseInContext(nDomVarDecl,
				varDecl.getDomain().getIndexNames());
		
		/* DEBUG
		System.out.println("Simplification of the domain of variable " + varDecl.getName());
		System.out.println("	=> Original domain = " + domVarDecl.toString());
		System.out.println("	=> New Domain = " + nDomVarDecl.toString());
		System.out.println("	=> phi function = " + phi.toString());
		System.out.println("	=> nDep function = " + nDep.toString());
		//System.out.println("	=> invInContnDep function = " + invInContnDep.toString());
		//*/
		
		
		// Note: not possible to reuse CoB, because the function is not unimodular... :/
		
		// We change the variable declaration of the output variable
		//VariableDeclaration nVarDecl = _polyIRFact.createVariableDeclaration(varDecl.getName(), varDecl.getType(), nDomVarDecl);
		//syst.accept(new CoBInverse(varDecl, nDep, invInContnDep, nVarDecl));
		//syst.getOutputs().remove(varDecl);
		//syst.getOutputs().add(nVarDecl);
		
		// Simpler alternative
		
		// DEBUG
		//System.out.println("varDecl = " + varDecl.toString());
		//System.out.println("invInContnDep = " + invInContnDep.toString());
		ChangeOfBasis.CoB(syst, varDecl.getName(), invInContnDep, true);
		
		return nDep;		// New => Old
	}
	
	/**
	 * Reduce the number of dims of the output of a system, using its equalities
	 * 		Note: will not change the signature of the calling systems
	 * 
	 * @param syst
	 */
	public static void reduceDimOutputs(AffineSystem syst) {
		for (int k=0; k<syst.getOutputs().size(); k++) {
			VariableDeclaration varDeclOut = syst.getOutputs().get(k);
			reduceDimVariable(syst, varDeclOut);
		}
		return;
	}
	
	/**
	 * Reduce the number of dims of the input of a system, using its equalities
	 * 		Note: will not change the signature of the calling systems
	 * 
	 * @param syst
	 */
	public static void reduceDimInputs(AffineSystem syst) {
		for (int k=0; k<syst.getInputs().size(); k++) {
			VariableDeclaration varDeclIn = syst.getInputs().get(k);
			reduceDimVariable(syst, varDeclIn);
		}
		return;
	}
	
	/* ---------------------------------------------------------------------------------------------------------- */
	
	/**
	 * Align the lexicographic minimum of the bounding box of the domain of a variable with \vec{0}.
	 * 
	 * @param syst
	 * @param varDecl
	 * @return
	 */
	public static AffineFunction alignDimVariable(AffineSystem syst, VariableDeclaration varDecl) {
		Domain domVarDecl = varDecl.getDomain();
		
		org.polymodel.Domain pmDomVarDecl = domVarDecl.getPMdomain();
		
		// *** Complicated case ***
		if (pmDomVarDecl.getPolyhedra().size()>1) {
			
			// DEBUG
			//System.out.println("\n VarDeclDom = " + domVarDecl);
			//System.out.println("pmDomVarDecl = " + pmDomVarDecl);
			//System.out.println("pmDomVarDecl.getPolyhedra().size() = " + pmDomVarDecl.getPolyhedra().size());
			
			// In that case the bounding box does not work correctly... :/
			//		(just consider the first polyhedron of the union)
			
			// We try to check if the lower bound of each bounding box is a constant
			//		If yes, we can compare them. Else, we do nothing here (cannot deal with complex "max" expressions)
			
			List<IntConstraintSystem> lConstSyst = pmDomVarDecl.getPolyhedra();
			
			List<List<IntExpression>> llLowBound = new BasicEList<List<IntExpression>>();		// Storing the low bound of all expressions
							// First List: dimensions
							// Second List: polyhedron
			Boolean[] lDimNotAligned = new Boolean[pmDomVarDecl.getNbIndices()];			// True: expression too complicated => do nothing on that dimension
			for (int i=0; i<pmDomVarDecl.getNbIndices(); i++) {
				llLowBound.add(new BasicEList<IntExpression>());
				lDimNotAligned[i] = false;
			}
			
			// --- Gathering all lower bounds
			for (IntConstraintSystem constSyst : lConstSyst) {
				org.polymodel.Domain pmDomConstSyst = PolymodelComponent.INSTANCE.getFactory().createDomain(
						pmDomVarDecl.getDimensions().copy(), constSyst.copy());
				
				Domain boundBoxConstSyst = _polyIRFact.createDomain(pmDomConstSyst.boundingBox());
				
				for (int i=0; i<boundBoxConstSyst.getNIndices(); i++) {
					List<IntExpression> lLowBound = llLowBound.get(i);
					
					IntExpression lowBoundi = boundBoxConstSyst.getLowerBound(i);
					
					if (lowBoundi instanceof AffineExpression) 
						lLowBound.add(lowBoundi);
					else {
						lDimNotAligned[i] = true;			// One lower bound is not affine => FAIL for that dimension!
						break;
					}
				}
			}
			
			// DEBUG
			//System.out.println("llLowBound =");
			//for (List<IntExpression> lLowBound : llLowBound) {
			//	System.out.println("	* " + lLowBound.toString());
			//}
			
			
			// --- Treating the lower bounds of each dimensions separately
			List<IntExpression> lLowBoundTransl = new BasicEList<IntExpression>();
			for (int i=0; i<pmDomVarDecl.getNbIndices(); i++) {
				if (lDimNotAligned[i]) {
					// Complicated lower bound => we do nothing here
					
					// Heuristic: cannot do anything here
					//		=> tell that the lower bound is 0, which will do nothing
					lLowBoundTransl.add(IntExpressionBuilder.constant(0));
				} else {
					List<IntExpression> lLowBoundDimi = llLowBound.get(i);
					
					List<AffineExpression> lLowBoundDimiAffine = new BasicEList<AffineExpression>();
					for (IntExpression iExpr : lLowBoundDimi)
						lLowBoundDimiAffine.add(IntExpressionBuilder.affine(iExpr));
					
					boolean paramPos = true; //checkParamsArePositive();	//  Check Assertion: "\vec{p}>=0"
					// FIXME IMPLEMENT THAT !!! <==============
					
					if (paramPos) {
						
						// Under this condition, \vec{a_1}.\vec{p} + b_1 \leq \vec{a_2}.\vec{p} + b_2, \forall \vec{p}
						//			iff \vec{a_1} \leq \vec{a_2} && b_1 \leq b_2
						// NOTE: this is an heuristic !
						
						// Get the minimal expression (according to the constants first)
						List<AffineExpression> lAffExpr = getMinExpression(lLowBoundDimiAffine);
						
						if (lAffExpr.size()==0)
							lLowBoundTransl.add(IntExpressionBuilder.constant(0));
						else
							lLowBoundTransl.add(lAffExpr.get(0));
					} else
						lLowBoundTransl.add(IntExpressionBuilder.constant(0));
				}
			}
			
			// DEBUG
			//System.out.println("lLowBoundTransl =");
			//for (IntExpression lowBoundTransl : lLowBoundTransl) {
			//	System.out.println("	* " + lowBoundTransl.toString());
			//}
			
			
			// Build the affine function which translate the lowerbound of the bounding box to 0
			List<AffineExpression> lAffExpr = new BasicEList<AffineExpression>();
			for (int i=0; i<domVarDecl.getNIndices(); i++) {
				lAffExpr.add(IntExpressionBuilder.affine(
						IntExpressionBuilder.sub(IntExpressionBuilder.affine(domVarDecl.getIndices().get(i)), lLowBoundTransl.get(i))));
			}
			
			AffineFunction translationFunction = _polyIRFact.createAffineFunction(domVarDecl.getParams(),
					domVarDecl.getIndices(), lAffExpr);
			
			// Perform the CoB
			ChangeOfBasis.CoB(syst, varDecl.getName(), translationFunction, true);
			
			return translationFunction.inverse();
			
		}
		
		
		
		// OLD CODE - Simple case : Case where we have a single polyhedron here
		
		Domain domBoundBox = _polyIRFact.createDomain(pmDomVarDecl.boundingBox());
		
		List<IntExpression> lLowBoundDimi = new BasicEList<IntExpression>();
		for (int i=0; i<domBoundBox.getNIndices(); i++) {
			IntExpression lowBoundi = domBoundBox.getLowerBound(i);
			
			if (lowBoundi instanceof AffineExpression) {
				lLowBoundDimi.add(lowBoundi);
			} else {
				
				//System.out.println("lowBoundi = " + lowBoundi);
				
				// Heuristic: cannot do anything here
				//		=> tell that the lower bound is 0, which will d nothing
				lowBoundi = IntExpressionBuilder.constant(0);
				lLowBoundDimi.add(lowBoundi);
			}
		}
		
		// Build the affine function which translate the lowerbound of the bounding box to 0
		List<AffineExpression> lAffExpr = new BasicEList<AffineExpression>();
		for (int i=0; i<domBoundBox.getNIndices(); i++) {
			lAffExpr.add(IntExpressionBuilder.affine(
					IntExpressionBuilder.sub(IntExpressionBuilder.affine(domBoundBox.getIndices().get(i)), lLowBoundDimi.get(i))));
		}
		
		AffineFunction translationFunction = _polyIRFact.createAffineFunction(domVarDecl.getParams(),
				domVarDecl.getIndices(), lAffExpr);
		
		// Perform the CoB
		ChangeOfBasis.CoB(syst, varDecl.getName(), translationFunction, true);
		
		return translationFunction.inverse();
	}
	
	/**
	 * Return an empty list if there is no certain minimum, for all parameters
	 * Return a list with a single element if there is a certain minimum
	 * 
	 * @param lLowBoundDimiAffine
	 * @return
	 */
	private static List<AffineExpression> getMinExpression(List<AffineExpression> lLowBoundDimiAffine) {
		AffineExpression currentMinExpr = lLowBoundDimiAffine.get(0);
		
		for (int k=1; k<lLowBoundDimiAffine.size(); k++) {
			AffineExpression newChallenger = lLowBoundDimiAffine.get(k);
			
			boolean minLowerThanChallenger = checkLowerOrEqual(currentMinExpr, newChallenger);
			boolean challengerLowerThanMin = checkLowerOrEqual(newChallenger, currentMinExpr);
			
			if (minLowerThanChallenger) {
				continue;
			}
			if (challengerLowerThanMin) {
				currentMinExpr = newChallenger;
				continue;
			}
			return new BasicEList<AffineExpression>();		// Fail: affine expr not comparable
		}
		
		List<AffineExpression> lRet = new BasicEList<AffineExpression>();
		lRet.add(currentMinExpr);
		return lRet;
	}
	
	/**
	 * Check if the first affine expression on parameters are always lower than the other, for all values of parameters
	 * 
	 * @param affExpr1
	 * @param affExpr2
	 * @return
	 */
	private static boolean checkLowerOrEqual(AffineExpression affExpr1, AffineExpression affExpr2) {
		
		if (affExpr1.getConstantTerm().getCoef()>affExpr2.getConstantTerm().getCoef())
			return false;
		
		for (AffineTerm affTerm1 : affExpr1.getTerms()) {
			Variable varAffTerm1 = affTerm1.getVariable();
			AffineTerm affTerm2 = affExpr2.getTerm(varAffTerm1);
			
			if (affTerm2==null) {
				if (affTerm1.getCoef()>0)
					return false;
			} else {
				if (affTerm1.getCoef()>affTerm2.getCoef())
					return false;
			}
		}
		
		for (AffineTerm affTerm2 : affExpr2.getTerms()) {
			Variable varAffTerm2 = affTerm2.getVariable();
			AffineTerm affTerm1 = affExpr1.getTerm(varAffTerm2);
			
			if (affTerm1==null) {
				if (affTerm2.getCoef()<0)
					return false;
			}	// Don't care about the "else" which was already managed
		}
		return true;
	}
	
	
	
	public static void alignDimOutputs(AffineSystem syst) {
		for (int k=0; k<syst.getOutputs().size(); k++) {
			VariableDeclaration varDeclOut = syst.getOutputs().get(k);
			alignDimVariable(syst, varDeclOut);
		}
		return;
	}
	
	public static void alignDimInputs(AffineSystem syst) {
		for (int k=0; k<syst.getInputs().size(); k++) {
			VariableDeclaration varDeclIn = syst.getInputs().get(k);
			alignDimVariable(syst, varDeclIn);
		}
		return;
	}
	

	/* ---------------------------------------------------------------------------------------------------------- */
	
	/**
	 * First remove the equalities of the domain of varDecl, then align the lexmin of its bounding box with \vec{0}
	 * 
	 * Returns the mapping from the old domain to the new one
	 * 
	 * @param syst
	 * @param varDecl
	 * @return
	 */
	public static AffineFunction reduceAndAlignDimVariable(AffineSystem syst, VariableDeclaration varDecl) {
		
		// DEBUG
		//System.out.println("varDeclOrig = " + varDecl.getDomain());
		
		AffineFunction redAffFunc = reduceDimVariable(syst, varDecl);
		
		// DEBUG
		//System.out.println("	=> varDeclRedDim = " + varDecl.getDomain());
		
		AffineFunction aligAffFunc = alignDimVariable(syst, varDecl);
		
		// DEBUG
		//System.out.println("	=> varDeclAlign = " + varDecl.getDomain() + "\n");		// TODO: bug here... :/
		
		return redAffFunc.compose(aligAffFunc);
	}
	
	public static List<AffineFunction> reduceAndAlignDimOutputs(AffineSystem syst) {
		List<AffineFunction> lAffFuncRet = new BasicEList<AffineFunction>();
		for (int k=0; k<syst.getOutputs().size(); k++) {
			VariableDeclaration varDeclOut = syst.getOutputs().get(k);
			lAffFuncRet.add(reduceAndAlignDimVariable(syst, varDeclOut));
		}
		return lAffFuncRet;
	}
	
	public static List<AffineFunction> reduceAndAlignDimInputs(AffineSystem syst) {
		List<AffineFunction> lAffFuncRet = new BasicEList<AffineFunction>();
		for (int k=0; k<syst.getInputs().size(); k++) {
			VariableDeclaration varDeclIn = syst.getInputs().get(k);
			lAffFuncRet.add(reduceAndAlignDimVariable(syst, varDeclIn));
		}
		return lAffFuncRet;
	}
	
	
} // ReduceDimensionVariable
