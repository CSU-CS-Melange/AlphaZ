/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Scop Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.scop.ScopPackage#getAbstractScopStatement()
 * @model abstract="true"
 * @generated
 */
public interface AbstractScopStatement extends AbstractScopNode, ScopVisitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAbstractScopStatement(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // AbstractScopStatement
