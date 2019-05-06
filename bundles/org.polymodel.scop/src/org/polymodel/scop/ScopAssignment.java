/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopAssignment#getLHS <em>LHS</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopAssignment#getRHS <em>RHS</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopAssignment()
 * @model
 * @generated
 */
public interface ScopAssignment extends AbstractScopStatement, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>LHS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LHS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LHS</em>' reference.
	 * @see #setLHS(Variable)
	 * @see org.polymodel.scop.ScopPackage#getScopAssignment_LHS()
	 * @model required="true"
	 * @generated
	 */
	Variable getLHS();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopAssignment#getLHS <em>LHS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LHS</em>' reference.
	 * @see #getLHS()
	 * @generated
	 */
	void setLHS(Variable value);

	/**
	 * Returns the value of the '<em><b>RHS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RHS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RHS</em>' reference.
	 * @see #setRHS(IntExpression)
	 * @see org.polymodel.scop.ScopPackage#getScopAssignment_RHS()
	 * @model required="true"
	 * @generated
	 */
	IntExpression getRHS();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopAssignment#getRHS <em>RHS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RHS</em>' reference.
	 * @see #getRHS()
	 * @generated
	 */
	void setRHS(IntExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopAssignment(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopAssignment
