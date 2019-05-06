/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Quasi Affine Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getNestedQuasiAffineTerm()
 * @model
 * @generated
 */
public interface NestedQuasiAffineTerm extends QuasiAffineTerm {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(QuasiAffineExpression)
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getNestedQuasiAffineTerm_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QuasiAffineExpression getExpression();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(QuasiAffineExpression value);

} // NestedQuasiAffineTerm
