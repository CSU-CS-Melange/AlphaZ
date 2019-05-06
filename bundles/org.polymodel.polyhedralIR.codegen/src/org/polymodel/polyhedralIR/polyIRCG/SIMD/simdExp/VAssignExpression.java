/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VAssign Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getLreg <em>Lreg</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getRexp <em>Rexp</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVAssignExpression()
 * @model
 * @generated
 */
public interface VAssignExpression extends SIMDExpression {
	/**
	 * Returns the value of the '<em><b>Lreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lreg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lreg</em>' reference.
	 * @see #setLreg(VRegister)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVAssignExpression_Lreg()
	 * @model required="true"
	 * @generated
	 */
	VRegister getLreg();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getLreg <em>Lreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lreg</em>' reference.
	 * @see #getLreg()
	 * @generated
	 */
	void setLreg(VRegister value);

	/**
	 * Returns the value of the '<em><b>Rexp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rexp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rexp</em>' reference.
	 * @see #setRexp(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVAssignExpression_Rexp()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getRexp();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getRexp <em>Rexp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rexp</em>' reference.
	 * @see #getRexp()
	 * @generated
	 */
	void setRexp(SIMDExpression value);

} // VAssignExpression
