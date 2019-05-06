/**
 */
package org.polymodel.scop.annotation;

import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopVisitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vectorization Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.VectorizationAnnotation#isIvdep <em>Ivdep</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getVectorizationAnnotation()
 * @model
 * @generated
 */
public interface VectorizationAnnotation extends IScopAnnotation, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Ivdep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ivdep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ivdep</em>' attribute.
	 * @see #setIvdep(boolean)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getVectorizationAnnotation_Ivdep()
	 * @model required="true"
	 * @generated
	 */
	boolean isIvdep();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.VectorizationAnnotation#isIvdep <em>Ivdep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ivdep</em>' attribute.
	 * @see #isIvdep()
	 * @generated
	 */
	void setIvdep(boolean value);

} // VectorizationAnnotation
