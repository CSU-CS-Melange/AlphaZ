/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine;

import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.affine.AffineTerm#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.affine.AffinePackage#getAffineTerm()
 * @model
 * @generated
 */
public interface AffineTerm extends IntTerm, AlgebraVisitable {
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
	 * @see org.polymodel.algebra.affine.AffinePackage#getAffineTerm_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.affine.AffineTerm#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAffineTerm(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

} // AffineTerm
