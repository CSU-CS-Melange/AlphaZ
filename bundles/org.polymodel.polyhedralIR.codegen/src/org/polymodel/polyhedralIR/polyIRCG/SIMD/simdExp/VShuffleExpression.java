/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VShuffle Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg1 <em>Reg1</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg2 <em>Reg2</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getImm8 <em>Imm8</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShuffleExpression()
 * @model
 * @generated
 */
public interface VShuffleExpression extends SIMDExpression {
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShuffleExpression_Reg1()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getReg1();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg1 <em>Reg1</em>}' reference.
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShuffleExpression_Reg2()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getReg2();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg2 <em>Reg2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reg2</em>' reference.
	 * @see #getReg2()
	 * @generated
	 */
	void setReg2(SIMDExpression value);

	/**
	 * Returns the value of the '<em><b>Imm8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imm8</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imm8</em>' attribute.
	 * @see #setImm8(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVShuffleExpression_Imm8()
	 * @model required="true"
	 * @generated
	 */
	String getImm8();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getImm8 <em>Imm8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imm8</em>' attribute.
	 * @see #getImm8()
	 * @generated
	 */
	void setImm8(String value);

} // VShuffleExpression
