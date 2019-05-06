/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.PolymodelPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends AbstractRelation, PolymodelVisitable {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitRelation(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);
} // Relation
