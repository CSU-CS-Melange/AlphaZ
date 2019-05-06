/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopBlock#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopBlock()
 * @model
 * @generated
 */
public interface ScopBlock extends AbstractScopNode, ScopVisitable {
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
	 * @see org.polymodel.scop.ScopPackage#getScopBlock_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractScopNode> getStatements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopBlock(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopBlock
