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
 * This annotation assumes that it is given to ScopFor. Iterations of the annotated loop is considered to be completely independent.
 * A representation of the model object '<em><b>Parallel Loop Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getPrivates <em>Privates</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getChunksize <em>Chunksize</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelLoopAnnotation()
 * @model
 * @generated
 */
public interface ParallelLoopAnnotation extends IScopAnnotation, ScopVisitable {
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
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelLoopAnnotation_Privates()
	 * @model
	 * @generated
	 */
	EList<String> getPrivates();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' attribute.
	 * @see #setSchedule(String)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelLoopAnnotation_Schedule()
	 * @model
	 * @generated
	 */
	String getSchedule();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getSchedule <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' attribute.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(String value);

	/**
	 * Returns the value of the '<em><b>Chunksize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chunksize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chunksize</em>' attribute.
	 * @see #setChunksize(int)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getParallelLoopAnnotation_Chunksize()
	 * @model
	 * @generated
	 */
	int getChunksize();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getChunksize <em>Chunksize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chunksize</em>' attribute.
	 * @see #getChunksize()
	 * @generated
	 */
	void setChunksize(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitParallelLoopAnnotation(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ParallelLoopAnnotation
