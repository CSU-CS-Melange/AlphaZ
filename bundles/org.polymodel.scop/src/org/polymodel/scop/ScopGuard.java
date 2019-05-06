/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntConstraintSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopGuard#getConstraintSystems <em>Constraint Systems</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopGuard#getThenBody <em>Then Body</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopGuard#getElseBody <em>Else Body</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopGuard()
 * @model
 * @generated
 */
public interface ScopGuard extends AbstractScopNode, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Constraint Systems</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntConstraintSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Systems</em>' containment reference list.
	 * @see org.polymodel.scop.ScopPackage#getScopGuard_ConstraintSystems()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntConstraintSystem> getConstraintSystems();

	/**
	 * Returns the value of the '<em><b>Then Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Body</em>' containment reference.
	 * @see #setThenBody(AbstractScopNode)
	 * @see org.polymodel.scop.ScopPackage#getScopGuard_ThenBody()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractScopNode getThenBody();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopGuard#getThenBody <em>Then Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Body</em>' containment reference.
	 * @see #getThenBody()
	 * @generated
	 */
	void setThenBody(AbstractScopNode value);

	/**
	 * Returns the value of the '<em><b>Else Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Body</em>' containment reference.
	 * @see #setElseBody(AbstractScopNode)
	 * @see org.polymodel.scop.ScopPackage#getScopGuard_ElseBody()
	 * @model containment="true"
	 * @generated
	 */
	AbstractScopNode getElseBody();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopGuard#getElseBody <em>Else Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Body</em>' containment reference.
	 * @see #getElseBody()
	 * @generated
	 */
	void setElseBody(AbstractScopNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopGuard(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopGuard
