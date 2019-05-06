/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.DimensionsManager;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ISL Union Map</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.isl.ISLUnionMap#getMaps <em>Maps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.isl.IslPackage#getISLUnionMap()
 * @model
 * @generated
 */
public interface ISLUnionMap extends EObject {

	/**
	 * Returns the value of the '<em><b>Maps</b></em>' reference list. The list
	 * contents are of type {@link org.polymodel.isl.ISLMap}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Maps</em>' reference list.
	 * @see org.polymodel.isl.IslPackage#getISLUnionMap_Maps()
	 * @model
	 * @generated
	 */
	EList<ISLMap> getMaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" managerRequired="true"
	 * @generated
	 */
	ISLUnionMap lexMax(DimensionsManager manager);

	ISLUnionMap plutoScheduling(ISLUnionSet domains);

} // ISLUnionMap
