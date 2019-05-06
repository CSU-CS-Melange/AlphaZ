/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Read Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.MemoryReadDependency#getDimensionSizes <em>Dimension Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMemoryReadDependency()
 * @model
 * @generated
 */
public interface MemoryReadDependency extends ChannelReadDependency, MemoryDependency {

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
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMemoryReadDependency_DimensionSizes()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getDimensionSizes();
} // MemoryReadDependency
