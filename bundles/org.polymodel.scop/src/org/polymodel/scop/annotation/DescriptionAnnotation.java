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
 * A representation of the model object '<em><b>Description Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.DescriptionAnnotation#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getDescriptionAnnotation()
 * @model
 * @generated
 */
public interface DescriptionAnnotation extends IScopAnnotation, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getDescriptionAnnotation_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.DescriptionAnnotation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDescriptionAnnotation(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // DescriptionAnnotation
