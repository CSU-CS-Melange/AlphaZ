/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Dependency</b></em>'.
 * 
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMemoryDependency()
 * @model abstract="true"
 * @generated
 */
public interface MemoryDependency extends ChannelDependency {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BoundedChannel getChannel();

} // BoundedChannelDependency
