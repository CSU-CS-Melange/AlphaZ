/**
 */
package org.polymodel.algebra.polynomials;

import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polynomial Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialVariable#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialVariable#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialVariable()
 * @model
 * @generated
 */
public interface PolynomialVariable extends AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialVariable_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.polynomials.PolynomialVariable#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' attribute.
	 * @see #setExponent(long)
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialVariable_Exponent()
	 * @model dataType="org.polymodel.algebra.Value"
	 * @generated
	 */
	long getExponent();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.polynomials.PolynomialVariable#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' attribute.
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitPolynomialVariable(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isEquivalent(PolynomialVariable other);

} // PolynomialVariable
