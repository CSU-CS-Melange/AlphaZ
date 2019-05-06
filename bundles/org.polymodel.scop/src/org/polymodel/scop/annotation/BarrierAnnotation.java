/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation;

import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * This annotation specifies that a barrier synchronization is necessary before or after the ScopNode.
 * A representation of the model object '<em><b>Barrier Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.BarrierAnnotation#isBefore <em>Before</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.BarrierAnnotation#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getBarrierAnnotation()
 * @model
 * @generated
 */
public interface BarrierAnnotation extends IScopAnnotation, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' attribute.
	 * @see #setBefore(boolean)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getBarrierAnnotation_Before()
	 * @model required="true"
	 * @generated
	 */
	boolean isBefore();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.BarrierAnnotation#isBefore <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Before</em>' attribute.
	 * @see #isBefore()
	 * @generated
	 */
	void setBefore(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The type is an integer value to be used by custom code generators. What the int value means is up to the user.
	 * (One possible use it to allow for two different kind of barriers in case of MPI+OpenMP hybrid code)
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(int)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getBarrierAnnotation_Type()
	 * @model required="true"
	 * @generated
	 */
	int getType();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.BarrierAnnotation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitBarrierAnnotation(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // BarrierAnnotation
