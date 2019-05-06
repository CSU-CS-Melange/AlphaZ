/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;
import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multidim Deallocation Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getDimensionSizes <em>Dimension Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMultidimDeallocationDependency()
 * @model
 * @generated
 */
public interface MultidimDeallocationDependency extends MultidimDependency {
	/**
	 * Returns the value of the '<em><b>Dimension Sizes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension Sizes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension Sizes</em>' attribute list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMultidimDeallocationDependency_DimensionSizes()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getDimensionSizes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BoundedChannel getChannel();

} // MultidimDeallocationDependency
