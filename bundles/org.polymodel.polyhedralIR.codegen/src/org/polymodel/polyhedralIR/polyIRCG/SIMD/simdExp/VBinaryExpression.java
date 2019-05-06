/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VBinary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getLreg <em>Lreg</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getRreg <em>Rreg</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVBinaryExpression()
 * @model
 * @generated
 */
public interface VBinaryExpression extends SIMDExpression {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP
	 * @see #setOp(VOP)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVBinaryExpression_Op()
	 * @model required="true"
	 * @generated
	 */
	VOP getOp();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP
	 * @see #getOp()
	 * @generated
	 */
	void setOp(VOP value);

	/**
	 * Returns the value of the '<em><b>Lreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lreg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lreg</em>' reference.
	 * @see #setLreg(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVBinaryExpression_Lreg()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getLreg();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getLreg <em>Lreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lreg</em>' reference.
	 * @see #getLreg()
	 * @generated
	 */
	void setLreg(SIMDExpression value);

	/**
	 * Returns the value of the '<em><b>Rreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rreg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rreg</em>' reference.
	 * @see #setRreg(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getVBinaryExpression_Rreg()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getRreg();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getRreg <em>Rreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rreg</em>' reference.
	 * @see #getRreg()
	 * @generated
	 */
	void setRreg(SIMDExpression value);

} // VBinaryExpression
