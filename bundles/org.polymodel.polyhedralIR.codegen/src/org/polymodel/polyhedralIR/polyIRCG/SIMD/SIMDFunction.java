/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getInputsimdRegs <em>Inputsimd Regs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getOutputsimdRegs <em>Outputsimd Regs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getLocalsimdRegs <em>Localsimd Regs</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDFunction()
 * @model
 * @generated
 */
public interface SIMDFunction extends Function {
	/**
	 * Returns the value of the '<em><b>Inputsimd Regs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputsimd Regs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputsimd Regs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDFunction_InputsimdRegs()
	 * @model
	 * @generated
	 */
	EList<VRegister> getInputsimdRegs();

	/**
	 * Returns the value of the '<em><b>Outputsimd Regs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputsimd Regs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputsimd Regs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDFunction_OutputsimdRegs()
	 * @model
	 * @generated
	 */
	EList<VRegister> getOutputsimdRegs();

	/**
	 * Returns the value of the '<em><b>Localsimd Regs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Localsimd Regs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Localsimd Regs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDFunction_LocalsimdRegs()
	 * @model
	 * @generated
	 */
	EList<VRegister> getLocalsimdRegs();

} // SIMDFunction
