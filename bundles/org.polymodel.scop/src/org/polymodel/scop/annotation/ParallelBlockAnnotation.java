/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation;

import org.eclipse.emf.common.util.EList;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel Block Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.ParallelBlockAnnotation#getPrivates <em>Privates</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelBlockAnnotation()
 * @model
 * @generated
 */
public interface ParallelBlockAnnotation extends IScopAnnotation, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Privates</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Privates</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Privates</em>' attribute list.
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelBlockAnnotation_Privates()
	 * @model
	 * @generated
	 */
	EList<String> getPrivates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitParallelBlockAnnotation(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ParallelBlockAnnotation
