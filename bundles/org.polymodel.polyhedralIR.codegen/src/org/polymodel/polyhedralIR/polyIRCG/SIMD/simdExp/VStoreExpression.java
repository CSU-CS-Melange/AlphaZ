/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VStore Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getSrc <em>Src</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getDst <em>Dst</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVStoreExpression()
 * @model
 * @generated
 */
public interface VStoreExpression extends SIMDExpression {
	/**
	 * Returns the value of the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' reference.
	 * @see #setSrc(VRegister)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVStoreExpression_Src()
	 * @model required="true"
	 * @generated
	 */
	VRegister getSrc();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getSrc <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(VRegister value);

	/**
	 * Returns the value of the '<em><b>Dst</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst</em>' reference.
	 * @see #setDst(BasicMemoryAddress)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVStoreExpression_Dst()
	 * @model required="true"
	 * @generated
	 */
	BasicMemoryAddress getDst();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getDst <em>Dst</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst</em>' reference.
	 * @see #getDst()
	 * @generated
	 */
	void setDst(BasicMemoryAddress value);

} // VStoreExpression
