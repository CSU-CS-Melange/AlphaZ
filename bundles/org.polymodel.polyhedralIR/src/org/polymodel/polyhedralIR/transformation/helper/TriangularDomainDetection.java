package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.javatuples.Pair;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class TriangularDomainDetection {
	private static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	// *** Identifiers
	private static final ParameterDomain _paramDomTriangle = PolyhedralIRUtility.parseParameterDomain("{NparamTriang | NparamTriang>0}");
	private static final Domain _domTriangleLowStrict = PolyhedralIRUtility.parseDomain(_paramDomTriangle, "{iTri,jTri | 0<=iTri<jTri<NparamTriang}");
	public static final int _idTriangleLowStrict = 1;
	private static final Domain _domTriangleLowNStrict = PolyhedralIRUtility.parseDomain(_paramDomTriangle, "{iTri,jTri | 0<=iTri<=jTri<NparamTriang}");
	public static final int _idTriangleLowNStrict = 2;
	private static final Domain _domTriangleUppStrict = PolyhedralIRUtility.parseDomain(_paramDomTriangle, "{iTri,jTri | 0<=jTri<iTri<NparamTriang}");
	public static final int _idTriangleUppStrict = 3;
	private static final Domain _domTriangleUppNStrict = PolyhedralIRUtility.parseDomain(_paramDomTriangle, "{iTri,jTri | 0<=jTri<=iTri<NparamTriang}");
	public static final int _idTriangleUppNStrict = 4;
	
	
	/**
	 * Detect if the domain "dom" is a 2D triangle (of the form described in the above lines,
	 * 		where the parameter "NparamTriang" is to be found)
	 * 
	 * Output is "true" if something matched, plus the identifier to know which kind of triangle we have
	 * 
	 * @param dom
	 * @param currentSyst
	 * @return
	 */
	public static Pair<Boolean,Integer> isATriangularDomain(Domain dom, AffineSystem currentSyst) {
		if (dom.getNIndices()!=2)
			return Pair.with(false,-1);
		
		// We want to check if domIsl is of one of the following form:
		//		* {i,j | 0<=i<j<N};
		//		* {i,j | 0<=i<=j<N};
		//		* {i,j | 0<=j<i<N};
		//		* {i,j | 0<=j<=i<N};
		JNIISLSet condParam = getConstraintParamFromParamDom(currentSyst.getParameters(),_paramDomTriangle);
		
		// Lower Strict
		JNIISLSet condParamElimOutputLStrict = getSubstractConstraintParamFromOutputs(
				currentSyst.getParameters().getParams(), _paramDomTriangle.getParams(),
				dom, _domTriangleLowStrict);
		JNIISLSet ncondParamLStrict = condParam.copy().subtract(condParamElimOutputLStrict);
		if (!ncondParamLStrict.isEmpty())		// Does match
			return Pair.with(true,_idTriangleLowStrict);
		
		// Lower Non-Strict
		JNIISLSet condParamElimOutputLNStrict = getSubstractConstraintParamFromOutputs(
				currentSyst.getParameters().getParams(), _paramDomTriangle.getParams(),
				dom, _domTriangleLowNStrict);
		JNIISLSet ncondParamLNStrict = condParam.copy().subtract(condParamElimOutputLNStrict);
		if (!ncondParamLNStrict.isEmpty())		// Does match
			return Pair.with(true,_idTriangleLowNStrict);
				
		// Upper Strict
		JNIISLSet condParamElimOutputUStrict = getSubstractConstraintParamFromOutputs(
				currentSyst.getParameters().getParams(), _paramDomTriangle.getParams(),
				dom, _domTriangleUppStrict);
		JNIISLSet ncondParamUStrict = condParam.copy().subtract(condParamElimOutputUStrict);
		if (!ncondParamUStrict.isEmpty())		// Does match
			return Pair.with(true,_idTriangleUppStrict);
		
		// Upper Non-Strict
		JNIISLSet condParamElimOutputUNStrict = getSubstractConstraintParamFromOutputs(
				currentSyst.getParameters().getParams(), _paramDomTriangle.getParams(),
				dom, _domTriangleUppNStrict);
		JNIISLSet ncondParamUNStrict = condParam.copy().subtract(condParamElimOutputUNStrict);
		if (!ncondParamUNStrict.isEmpty())		// Does match
			return Pair.with(true,_idTriangleUppNStrict);
		
		return Pair.with(false,-1);
	}
	
	
	private static JNIISLSet getConstraintParamFromParamDom(ParameterDomain paramDomSyst1, ParameterDomain paramDomSyst2) {
		// Getting the conditions on the parameters coming from the respective parameters domain
		int nParam1 = paramDomSyst1.getNParams();
		int nParam2 = paramDomSyst2.getNParams();
		
		FastISLDomain domParam1 = _polyIRFact.createFastISLDomain(paramDomSyst1.getPMdomain());
		JNIISLSet islSetParam1 = domParam1.getIslSet();
		islSetParam1 = islSetParam1.moveDims(JNIISLDimType.isl_dim_set, 0, JNIISLDimType.isl_dim_param, 0, nParam1);
		
		FastISLDomain domParam2 = _polyIRFact.createFastISLDomain(paramDomSyst2.getPMdomain());
		JNIISLSet islSetParam2 = domParam2.getIslSet();
		islSetParam2 = islSetParam2.moveDims(JNIISLDimType.isl_dim_set, 0, JNIISLDimType.isl_dim_param, 0, nParam2);
		
		islSetParam1 = islSetParam1.insertDims(JNIISLDimType.isl_dim_set, nParam1, nParam2);
		islSetParam2 = islSetParam2.insertDims(JNIISLDimType.isl_dim_set, 0, nParam1);
		
		JNIISLSet islSetParamCrossProf = islSetParam1.intersect(islSetParam2);
		for (int i=0; i<nParam1; i++)
			islSetParamCrossProf = islSetParamCrossProf.setDimName(JNIISLDimType.isl_dim_set, i, domParam1.getParams().get(i).getName());
		for (int i=0; i<nParam2; i++)
			islSetParamCrossProf = islSetParamCrossProf.setDimName(JNIISLDimType.isl_dim_set, i+nParam1, domParam2.getParams().get(i).getName());
		
		return islSetParamCrossProf;
	}
	
	private static JNIISLSet getSubstractConstraintParamFromOutputs(List<Variable> paramSyst1, List<Variable> paramSyst2,
			Domain domOutputLeft, Domain domOutputRight) {
		int nParam1 = paramSyst1.size();
		int nParam2 = paramSyst2.size();
		
		// setOutputLeft = [N] -> { [i] : ... }
		JNIISLSet setOutputLeft;
		if (domOutputLeft instanceof FastISLDomain)
			setOutputLeft = ((FastISLDomain) domOutputLeft).getIslSet().copy();
		else
			setOutputLeft = (_polyIRFact.createFastISLDomain(domOutputLeft.getPMdomain())).getIslSet();
		
		// setOutputRight = [N'] -> { [i'] : ... }
		JNIISLSet setOutputRight;
		if (domOutputRight instanceof FastISLDomain)
			setOutputRight = ((FastISLDomain) domOutputRight).getIslSet().copy();
		else
			setOutputRight = (_polyIRFact.createFastISLDomain(domOutputRight.getPMdomain())).getIslSet();
		
		// setOutputLeft = [N,N'] -> { [i] : ... }
		setOutputLeft = setOutputLeft.insertDims(JNIISLDimType.isl_dim_param, nParam1, nParam2);
		for (int i=0; i<nParam2; i++)
			setOutputLeft = setOutputLeft.setDimName(JNIISLDimType.isl_dim_param, nParam1+i, paramSyst2.get(i).getName());

		// setOutputRight = [N,N'] -> { [i'] : ... }
		setOutputRight = setOutputRight.insertDims(JNIISLDimType.isl_dim_param, 0, nParam1);
		for (int i=0; i<nParam1; i++)
			setOutputRight = setOutputRight.setDimName(JNIISLDimType.isl_dim_param, i, paramSyst1.get(i).getName());
		
		// The domains of the outputs are identical iff (setOutputLeft - setOutputRight) and (setOutputRight - setOutputLeft) are both empty
		JNIISLSet domLminR = setOutputLeft.copy().subtract(setOutputRight.copy());
		JNIISLSet domRminL = setOutputRight.copy().subtract(setOutputLeft.copy());
		
		// Check for which values of the parameter both of domLminR and domRminL are empty
		int nIndDomDiffParam = domLminR.getNbDims(JNIISLDimType.isl_dim_set);
		domLminR = domLminR.moveDims(JNIISLDimType.isl_dim_set, 0, JNIISLDimType.isl_dim_param, 0,
				domLminR.getNbDims(JNIISLDimType.isl_dim_param));
		domLminR = domLminR.projectOut(JNIISLDimType.isl_dim_set, nParam1+nParam2, nIndDomDiffParam);
		
		domRminL = domRminL.moveDims(JNIISLDimType.isl_dim_set, 0, JNIISLDimType.isl_dim_param, 0,
				domRminL.getNbDims(JNIISLDimType.isl_dim_param));
		domRminL = domRminL.projectOut(JNIISLDimType.isl_dim_set, nParam1+nParam2, nIndDomDiffParam);
		//		=> domLminR and domRminL = {[N,N'] : ... }
		
		return domLminR.union(domRminL);
	}
	
} // TriangularDomainDetection
