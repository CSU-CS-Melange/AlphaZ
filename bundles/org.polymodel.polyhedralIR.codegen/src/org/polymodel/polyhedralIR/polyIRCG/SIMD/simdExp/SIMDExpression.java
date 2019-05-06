/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SIMD Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression#getVtype <em>Vtype</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getSIMDExpression()
 * @model abstract="true"
 * @generated
 */
public interface SIMDExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vtype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vtype</em>' reference.
	 * @see #setVtype(VType)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getSIMDExpression_Vtype()
	 * @model required="true"
	 * @generated
	 */
	VType getVtype();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression#getVtype <em>Vtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vtype</em>' reference.
	 * @see #getVtype()
	 * @generated
	 */
	void setVtype(VType value);

} // SIMDExpression
