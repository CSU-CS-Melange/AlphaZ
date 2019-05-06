/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISL Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.isl.ISLPoint#getCoordinates <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.isl.IslPackage#getISLPoint()
 * @model
 * @generated
 */
public interface ISLPoint extends EObject {

	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' attribute list.
	 * @see org.polymodel.isl.IslPackage#getISLPoint_Coordinates()
	 * @model
	 * @generated
	 */
	EList<Long> getCoordinates();
} // ISLPoint
