/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement#getSimdExp <em>Simd Exp</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDStatement()
 * @model
 * @generated
 */
public interface SIMDStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Simd Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simd Exp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simd Exp</em>' reference.
	 * @see #setSimdExp(SIMDExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMDStatement_SimdExp()
	 * @model required="true"
	 * @generated
	 */
	SIMDExpression getSimdExp();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement#getSimdExp <em>Simd Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simd Exp</em>' reference.
	 * @see #getSimdExp()
	 * @generated
	 */
	void setSimdExp(SIMDExpression value);

} // SIMDStatement
