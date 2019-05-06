/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx;

import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modulo Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getDenominator <em>Denominator</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage#getModuloExpression()
 * @model
 * @generated
 */
public interface ModuloExpression extends IntExpression {
	/**
	 * Returns the value of the '<em><b>Numerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numerator</em>' containment reference.
	 * @see #setNumerator(IntExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage#getModuloExpression_Numerator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getNumerator();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getNumerator <em>Numerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numerator</em>' containment reference.
	 * @see #getNumerator()
	 * @generated
	 */
	void setNumerator(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Denominator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Denominator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Denominator</em>' containment reference.
	 * @see #setDenominator(IntExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage#getModuloExpression_Denominator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getDenominator();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getDenominator <em>Denominator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Denominator</em>' containment reference.
	 * @see #getDenominator()
	 * @generated
	 */
	void setDenominator(IntExpression value);

} // ModuloExpression
