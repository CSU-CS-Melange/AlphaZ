/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VShift Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg1 <em>Reg1</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg2 <em>Reg2</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getDis <em>Dis</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShiftExpression()
 * @model
 * @generated
 */
public interface VShiftExpression extends SIMDExpression {
	/**
	 * Returns the value of the '<em><b>Reg1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reg1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reg1</em>' reference.
	 * @see #setReg1(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShiftExpression_Reg1()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getReg1();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg1 <em>Reg1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reg1</em>' reference.
	 * @see #getReg1()
	 * @generated
	 */
	void setReg1(SIMDExpression value);

	/**
	 * Returns the value of the '<em><b>Reg2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reg2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reg2</em>' reference.
	 * @see #setReg2(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShiftExpression_Reg2()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getReg2();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg2 <em>Reg2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reg2</em>' reference.
	 * @see #getReg2()
	 * @generated
	 */
	void setReg2(SIMDExpression value);

	/**
	 * Returns the value of the '<em><b>Dis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dis</em>' attribute.
	 * @see #setDis(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShiftExpression_Dis()
	 * @model required="true"
	 * @generated
	 */
	int getDis();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getDis <em>Dis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dis</em>' attribute.
	 * @see #getDis()
	 * @generated
	 */
	void setDis(int value);

} // VShiftExpression
