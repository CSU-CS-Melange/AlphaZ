/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polynomial Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialTerm#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialTerm#getDenominator <em>Denominator</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialTerm#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialTerm()
 * @model
 * @generated
 */
public interface PolynomialTerm extends AlgebraVisitable {

	/**
	 * Returns the value of the '<em><b>Numerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numerator</em>' attribute.
	 * @see #setNumerator(long)
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialTerm_Numerator()
	 * @model dataType="org.polymodel.algebra.Value"
	 * @generated
	 */
	long getNumerator();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.polynomials.PolynomialTerm#getNumerator <em>Numerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numerator</em>' attribute.
	 * @see #getNumerator()
	 * @generated
	 */
	void setNumerator(long value);

	/**
	 * Returns the value of the '<em><b>Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Denominator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Denominator</em>' attribute.
	 * @see #setDenominator(long)
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialTerm_Denominator()
	 * @model dataType="org.polymodel.algebra.Value"
	 * @generated
	 */
	long getDenominator();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.polynomials.PolynomialTerm#getDenominator <em>Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Denominator</em>' attribute.
	 * @see #getDenominator()
	 * @generated
	 */
	void setDenominator(long value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.polynomials.PolynomialVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialTerm_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<PolynomialVariable> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitPolynomialTerm(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if isQuasiAffine is true and if numerator % denominator == 0
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAffine();

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if all the variables involved in this term have exponent of 0 or 1, and there is only one variable with exponent 1
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isQuasiAffine();

} // PolynomialTerm
