/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl#getInputsimdRegs <em>Inputsimd Regs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl#getOutputsimdRegs <em>Outputsimd Regs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl#getLocalsimdRegs <em>Localsimd Regs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SIMDFunctionImpl extends FunctionImpl implements SIMDFunction {
	/**
	 * The cached value of the '{@link #getInputsimdRegs() <em>Inputsimd Regs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputsimdRegs()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> inputsimdRegs;

	/**
	 * The cached value of the '{@link #getOutputsimdRegs() <em>Outputsimd Regs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputsimdRegs()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> outputsimdRegs;

	/**
	 * The cached value of the '{@link #getLocalsimdRegs() <em>Localsimd Regs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalsimdRegs()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> localsimdRegs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIMDFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.SIMD_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getInputsimdRegs() {
		if (inputsimdRegs == null) {
			inputsimdRegs = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.SIMD_FUNCTION__INPUTSIMD_REGS);
		}
		return inputsimdRegs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getOutputsimdRegs() {
		if (outputsimdRegs == null) {
			outputsimdRegs = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.SIMD_FUNCTION__OUTPUTSIMD_REGS);
		}
		return outputsimdRegs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getLocalsimdRegs() {
		if (localsimdRegs == null) {
			localsimdRegs = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.SIMD_FUNCTION__LOCALSIMD_REGS);
		}
		return localsimdRegs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SIMDPackage.SIMD_FUNCTION__INPUTSIMD_REGS:
				return getInputsimdRegs();
			case SIMDPackage.SIMD_FUNCTION__OUTPUTSIMD_REGS:
				return getOutputsimdRegs();
			case SIMDPackage.SIMD_FUNCTION__LOCALSIMD_REGS:
				return getLocalsimdRegs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SIMDPackage.SIMD_FUNCTION__INPUTSIMD_REGS:
				getInputsimdRegs().clear();
				getInputsimdRegs().addAll((Collection<? extends VRegister>)newValue);
				return;
			case SIMDPackage.SIMD_FUNCTION__OUTPUTSIMD_REGS:
				getOutputsimdRegs().clear();
				getOutputsimdRegs().addAll((Collection<? extends VRegister>)newValue);
				return;
			case SIMDPackage.SIMD_FUNCTION__LOCALSIMD_REGS:
				getLocalsimdRegs().clear();
				getLocalsimdRegs().addAll((Collection<? extends VRegister>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SIMDPackage.SIMD_FUNCTION__INPUTSIMD_REGS:
				getInputsimdRegs().clear();
				return;
			case SIMDPackage.SIMD_FUNCTION__OUTPUTSIMD_REGS:
				getOutputsimdRegs().clear();
				return;
			case SIMDPackage.SIMD_FUNCTION__LOCALSIMD_REGS:
				getLocalsimdRegs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SIMDPackage.SIMD_FUNCTION__INPUTSIMD_REGS:
				return inputsimdRegs != null && !inputsimdRegs.isEmpty();
			case SIMDPackage.SIMD_FUNCTION__OUTPUTSIMD_REGS:
				return outputsimdRegs != null && !outputsimdRegs.isEmpty();
			case SIMDPackage.SIMD_FUNCTION__LOCALSIMD_REGS:
				return localsimdRegs != null && !localsimdRegs.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public FunctionSignature getDefaultFunctionSignature(boolean includeSystemParams) {
		FunctionSignature fs = super.getDefaultFunctionSignature(includeSystemParams);

		List<VRegister> inout_vregs = new LinkedList<VRegister>();
		inout_vregs.addAll(getInputsimdRegs());
		inout_vregs.addAll(getOutputsimdRegs());
		for(VRegister reg: inout_vregs){
			fs.getParameters().add(reg);
		}
		
		return fs;
	}
		
} //SIMDFunctionImpl
