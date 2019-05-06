/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage
 * @generated
 */
public interface StructuredFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructuredFactory eINSTANCE = org.polymodel.prdg.scheduling.structured.impl.StructuredFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel</em>'.
	 * @generated
	 */
	Channel createChannel();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Process Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Network</em>'.
	 * @generated
	 */
	ProcessNetwork createProcessNetwork();

	/**
	 * Returns a new object of class '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Port</em>'.
	 * @generated
	 */
	InputPort createInputPort();

	/**
	 * Returns a new object of class '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Port</em>'.
	 * @generated
	 */
	OutputPort createOutputPort();

	/**
	 * Returns a new object of class '<em>Channel Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Schedule Prototype</em>'.
	 * @generated
	 */
	ChannelSchedulePrototype createChannelSchedulePrototype();

	/**
	 * Returns a new object of class '<em>Channel Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Read Dependency</em>'.
	 * @generated
	 */
	ChannelReadDependency createChannelReadDependency();

	/**
	 * Returns a new object of class '<em>Channel Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Write Dependency</em>'.
	 * @generated
	 */
	ChannelWriteDependency createChannelWriteDependency();

	/**
	 * Returns a new object of class '<em>Linear Memory Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Memory Read Dependency</em>'.
	 * @generated
	 */
	LinearMemoryReadDependency createLinearMemoryReadDependency();

	/**
	 * Returns a new object of class '<em>Linear Memory Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Memory Write Dependency</em>'.
	 * @generated
	 */
	LinearMemoryWriteDependency createLinearMemoryWriteDependency();

	/**
	 * Returns a new object of class '<em>Bounded Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bounded Channel</em>'.
	 * @generated
	 */
	BoundedChannel createBoundedChannel();

	/**
	 * Returns a new object of class '<em>Linear Memory Allocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Memory Allocation Dependency</em>'.
	 * @generated
	 */
	LinearMemoryAllocationDependency createLinearMemoryAllocationDependency();

	/**
	 * Returns a new object of class '<em>Memory Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Read Dependency</em>'.
	 * @generated
	 */
	MemoryReadDependency createMemoryReadDependency();

	/**
	 * Returns a new object of class '<em>Memory Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Write Dependency</em>'.
	 * @generated
	 */
	MemoryWriteDependency createMemoryWriteDependency();

	/**
	 * Returns a new object of class '<em>Memory Allocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Allocation Dependency</em>'.
	 * @generated
	 */
	MemoryAllocationDependency createMemoryAllocationDependency();

	/**
	 * Returns a new object of class '<em>Memory Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Deallocation Dependency</em>'.
	 * @generated
	 */
	MemoryDeallocationDependency createMemoryDeallocationDependency();

	/**
	 * Returns a new object of class '<em>Linear Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Dependency</em>'.
	 * @generated
	 */
	LinearDependency createLinearDependency();

	/**
	 * Returns a new object of class '<em>Channel Linear Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Linear Read Dependency</em>'.
	 * @generated
	 */
	ChannelLinearReadDependency createChannelLinearReadDependency();

	/**
	 * Returns a new object of class '<em>Channel Linear Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Linear Write Dependency</em>'.
	 * @generated
	 */
	ChannelLinearWriteDependency createChannelLinearWriteDependency();

	/**
	 * Returns a new object of class '<em>Composite Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Dependency</em>'.
	 * @generated
	 */
	CompositeDependency createCompositeDependency();

	/**
	 * Returns a new object of class '<em>Multidim Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multidim Deallocation Dependency</em>'.
	 * @generated
	 */
	MultidimDeallocationDependency createMultidimDeallocationDependency();

	/**
	 * Returns a new object of class '<em>Multidim Memory Read Dependency Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multidim Memory Read Dependency Component</em>'.
	 * @generated
	 */
	MultidimMemoryReadDependencyComponent createMultidimMemoryReadDependencyComponent();

	/**
	 * Returns a new object of class '<em>Bounding Coefficient</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bounding Coefficient</em>'.
	 * @generated
	 */
	BoundingCoefficient createBoundingCoefficient();

	/**
	 * Returns a new object of class '<em>Linear Memory Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Memory Deallocation Dependency</em>'.
	 * @generated
	 */
	LinearMemoryDeallocationDependency createLinearMemoryDeallocationDependency();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StructuredPackage getStructuredPackage();

} //StructuredFactory
