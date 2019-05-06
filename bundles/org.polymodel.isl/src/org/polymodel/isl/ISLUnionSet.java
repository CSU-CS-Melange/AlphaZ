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
 * A representation of the model object '<em><b>ISL Union Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.isl.ISLUnionSet#getSets <em>Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.isl.IslPackage#getISLUnionSet()
 * @model
 * @generated
 */
public interface ISLUnionSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Sets</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.isl.ISLSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sets</em>' reference list.
	 * @see org.polymodel.isl.IslPackage#getISLUnionSet_Sets()
	 * @model
	 * @generated
	 */
	EList<ISLSet> getSets();

} // ISLUnionSet
