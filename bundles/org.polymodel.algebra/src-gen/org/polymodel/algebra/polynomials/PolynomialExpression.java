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
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polynomial Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.PolynomialExpression#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialExpression()
 * @model
 * @generated
 */
public interface PolynomialExpression extends IntExpression, AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.polynomials.PolynomialTerm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#getPolynomialExpression_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<PolynomialTerm> getTerms();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitPolynomialExpression(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the expression is trivially affine.
	 * It will return false if it requires simplification (e.g., x^3 - x^3 + x + y)
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAffine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isQuasiAffine();

} // PolynomialExpression
