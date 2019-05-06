/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopRoot#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopRoot()
 * @model
 * @generated
 */
public interface ScopRoot extends ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.scop.AbstractScopNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see org.polymodel.scop.ScopPackage#getScopRoot_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractScopNode> getStatements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ScopRoot simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopRoot(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

	EList<? extends AbstractScopStatement> getAllStatements();
	EList<? extends Variable> getAllParameters();
	EList<? extends Variable> getAllIterators();

	
} // ScopRoot
