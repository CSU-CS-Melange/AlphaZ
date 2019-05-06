/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VRegister Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression#getReg <em>Reg</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVRegisterExpression()
 * @model
 * @generated
 */
public interface VRegisterExpression extends SIMDExpression {
	/**
	 * Returns the value of the '<em><b>Reg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reg</em>' reference.
	 * @see #setReg(VRegister)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVRegisterExpression_Reg()
	 * @model required="true"
	 * @generated
	 */
	VRegister getReg();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression#getReg <em>Reg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reg</em>' reference.
	 * @see #getReg()
	 * @generated
	 */
	void setReg(VRegister value);

} // VRegisterExpression
