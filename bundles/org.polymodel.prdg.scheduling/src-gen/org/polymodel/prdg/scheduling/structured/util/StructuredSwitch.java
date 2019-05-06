/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.BoundingCoefficient;
import org.polymodel.prdg.scheduling.structured.Channel;
import org.polymodel.prdg.scheduling.structured.ChannelDependency;
import org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency;
import org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency;
import org.polymodel.prdg.scheduling.structured.ChannelReadDependency;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelWriteDependency;
import org.polymodel.prdg.scheduling.structured.CompositeDependency;
import org.polymodel.prdg.scheduling.structured.DataPort;
import org.polymodel.prdg.scheduling.structured.InputPort;
import org.polymodel.prdg.scheduling.structured.LinearDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency;
import org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency;
import org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.MemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.MemoryWriteDependency;
import org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent;
import org.polymodel.prdg.scheduling.structured.OutputPort;
import org.polymodel.prdg.scheduling.structured.ProcessNetwork;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

import fr.irisa.cairn.graph.observer.IObservable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage
 * @generated
 */
public class StructuredSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StructuredPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredSwitch() {
		if (modelPackage == null) {
			modelPackage = StructuredPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StructuredPackage.CHANNEL: {
				Channel channel = (Channel)theEObject;
				T result = caseChannel(channel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.PROCESS: {
				org.polymodel.prdg.scheduling.structured.Process process = (org.polymodel.prdg.scheduling.structured.Process)theEObject;
				T result = caseProcess(process);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.PROCESS_NETWORK: {
				ProcessNetwork processNetwork = (ProcessNetwork)theEObject;
				T result = caseProcessNetwork(processNetwork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.DATA_PORT: {
				DataPort dataPort = (DataPort)theEObject;
				T result = caseDataPort(dataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.INPUT_PORT: {
				InputPort inputPort = (InputPort)theEObject;
				T result = caseInputPort(inputPort);
				if (result == null) result = caseDataPort(inputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.OUTPUT_PORT: {
				OutputPort outputPort = (OutputPort)theEObject;
				T result = caseOutputPort(outputPort);
				if (result == null) result = caseDataPort(outputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE: {
				ChannelSchedulePrototype channelSchedulePrototype = (ChannelSchedulePrototype)theEObject;
				T result = caseChannelSchedulePrototype(channelSchedulePrototype);
				if (result == null) result = caseSchedulePrototype(channelSchedulePrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_DEPENDENCY: {
				ChannelDependency channelDependency = (ChannelDependency)theEObject;
				T result = caseChannelDependency(channelDependency);
				if (result == null) result = caseDependency(channelDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_READ_DEPENDENCY: {
				ChannelReadDependency channelReadDependency = (ChannelReadDependency)theEObject;
				T result = caseChannelReadDependency(channelReadDependency);
				if (result == null) result = caseChannelDependency(channelReadDependency);
				if (result == null) result = caseDependency(channelReadDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_WRITE_DEPENDENCY: {
				ChannelWriteDependency channelWriteDependency = (ChannelWriteDependency)theEObject;
				T result = caseChannelWriteDependency(channelWriteDependency);
				if (result == null) result = caseChannelDependency(channelWriteDependency);
				if (result == null) result = caseDependency(channelWriteDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MEMORY_DEPENDENCY: {
				MemoryDependency memoryDependency = (MemoryDependency)theEObject;
				T result = caseMemoryDependency(memoryDependency);
				if (result == null) result = caseChannelDependency(memoryDependency);
				if (result == null) result = caseDependency(memoryDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.LINEAR_MEMORY_READ_DEPENDENCY: {
				LinearMemoryReadDependency linearMemoryReadDependency = (LinearMemoryReadDependency)theEObject;
				T result = caseLinearMemoryReadDependency(linearMemoryReadDependency);
				if (result == null) result = caseChannelLinearReadDependency(linearMemoryReadDependency);
				if (result == null) result = caseMemoryDependency(linearMemoryReadDependency);
				if (result == null) result = caseChannelReadDependency(linearMemoryReadDependency);
				if (result == null) result = caseLinearDependency(linearMemoryReadDependency);
				if (result == null) result = caseChannelDependency(linearMemoryReadDependency);
				if (result == null) result = caseDependency(linearMemoryReadDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.LINEAR_MEMORY_WRITE_DEPENDENCY: {
				LinearMemoryWriteDependency linearMemoryWriteDependency = (LinearMemoryWriteDependency)theEObject;
				T result = caseLinearMemoryWriteDependency(linearMemoryWriteDependency);
				if (result == null) result = caseChannelLinearWriteDependency(linearMemoryWriteDependency);
				if (result == null) result = caseMemoryDependency(linearMemoryWriteDependency);
				if (result == null) result = caseChannelWriteDependency(linearMemoryWriteDependency);
				if (result == null) result = caseLinearDependency(linearMemoryWriteDependency);
				if (result == null) result = caseChannelDependency(linearMemoryWriteDependency);
				if (result == null) result = caseDependency(linearMemoryWriteDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.BOUNDED_CHANNEL: {
				BoundedChannel boundedChannel = (BoundedChannel)theEObject;
				T result = caseBoundedChannel(boundedChannel);
				if (result == null) result = caseChannel(boundedChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.LINEAR_MEMORY_ALLOCATION_DEPENDENCY: {
				LinearMemoryAllocationDependency linearMemoryAllocationDependency = (LinearMemoryAllocationDependency)theEObject;
				T result = caseLinearMemoryAllocationDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseChannelLinearReadDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseMemoryDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseChannelReadDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseLinearDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseChannelDependency(linearMemoryAllocationDependency);
				if (result == null) result = caseDependency(linearMemoryAllocationDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MEMORY_READ_DEPENDENCY: {
				MemoryReadDependency memoryReadDependency = (MemoryReadDependency)theEObject;
				T result = caseMemoryReadDependency(memoryReadDependency);
				if (result == null) result = caseChannelReadDependency(memoryReadDependency);
				if (result == null) result = caseMemoryDependency(memoryReadDependency);
				if (result == null) result = caseChannelDependency(memoryReadDependency);
				if (result == null) result = caseDependency(memoryReadDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MEMORY_WRITE_DEPENDENCY: {
				MemoryWriteDependency memoryWriteDependency = (MemoryWriteDependency)theEObject;
				T result = caseMemoryWriteDependency(memoryWriteDependency);
				if (result == null) result = caseChannelWriteDependency(memoryWriteDependency);
				if (result == null) result = caseMemoryDependency(memoryWriteDependency);
				if (result == null) result = caseChannelDependency(memoryWriteDependency);
				if (result == null) result = caseDependency(memoryWriteDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MEMORY_ALLOCATION_DEPENDENCY: {
				MemoryAllocationDependency memoryAllocationDependency = (MemoryAllocationDependency)theEObject;
				T result = caseMemoryAllocationDependency(memoryAllocationDependency);
				if (result == null) result = caseChannelReadDependency(memoryAllocationDependency);
				if (result == null) result = caseMemoryDependency(memoryAllocationDependency);
				if (result == null) result = caseChannelDependency(memoryAllocationDependency);
				if (result == null) result = caseDependency(memoryAllocationDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MEMORY_DEALLOCATION_DEPENDENCY: {
				MemoryDeallocationDependency memoryDeallocationDependency = (MemoryDeallocationDependency)theEObject;
				T result = caseMemoryDeallocationDependency(memoryDeallocationDependency);
				if (result == null) result = caseMemoryDependency(memoryDeallocationDependency);
				if (result == null) result = caseChannelDependency(memoryDeallocationDependency);
				if (result == null) result = caseDependency(memoryDeallocationDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.LINEAR_DEPENDENCY: {
				LinearDependency linearDependency = (LinearDependency)theEObject;
				T result = caseLinearDependency(linearDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_LINEAR_READ_DEPENDENCY: {
				ChannelLinearReadDependency channelLinearReadDependency = (ChannelLinearReadDependency)theEObject;
				T result = caseChannelLinearReadDependency(channelLinearReadDependency);
				if (result == null) result = caseChannelReadDependency(channelLinearReadDependency);
				if (result == null) result = caseLinearDependency(channelLinearReadDependency);
				if (result == null) result = caseChannelDependency(channelLinearReadDependency);
				if (result == null) result = caseDependency(channelLinearReadDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY: {
				ChannelLinearWriteDependency channelLinearWriteDependency = (ChannelLinearWriteDependency)theEObject;
				T result = caseChannelLinearWriteDependency(channelLinearWriteDependency);
				if (result == null) result = caseChannelWriteDependency(channelLinearWriteDependency);
				if (result == null) result = caseLinearDependency(channelLinearWriteDependency);
				if (result == null) result = caseChannelDependency(channelLinearWriteDependency);
				if (result == null) result = caseDependency(channelLinearWriteDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.COMPOSITE_DEPENDENCY: {
				CompositeDependency compositeDependency = (CompositeDependency)theEObject;
				T result = caseCompositeDependency(compositeDependency);
				if (result == null) result = caseDependency(compositeDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY: {
				MultidimDeallocationDependency multidimDeallocationDependency = (MultidimDeallocationDependency)theEObject;
				T result = caseMultidimDeallocationDependency(multidimDeallocationDependency);
				if (result == null) result = caseMultidimDependency(multidimDeallocationDependency);
				if (result == null) result = caseIObservable(multidimDeallocationDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT: {
				MultidimMemoryReadDependencyComponent multidimMemoryReadDependencyComponent = (MultidimMemoryReadDependencyComponent)theEObject;
				T result = caseMultidimMemoryReadDependencyComponent(multidimMemoryReadDependencyComponent);
				if (result == null) result = caseMemoryReadDependency(multidimMemoryReadDependencyComponent);
				if (result == null) result = caseChannelReadDependency(multidimMemoryReadDependencyComponent);
				if (result == null) result = caseMemoryDependency(multidimMemoryReadDependencyComponent);
				if (result == null) result = caseChannelDependency(multidimMemoryReadDependencyComponent);
				if (result == null) result = caseDependency(multidimMemoryReadDependencyComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.BOUNDING_COEFFICIENT: {
				BoundingCoefficient boundingCoefficient = (BoundingCoefficient)theEObject;
				T result = caseBoundingCoefficient(boundingCoefficient);
				if (result == null) result = caseVariable(boundingCoefficient);
				if (result == null) result = caseAlgebraVisitable(boundingCoefficient);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY: {
				LinearMemoryDeallocationDependency linearMemoryDeallocationDependency = (LinearMemoryDeallocationDependency)theEObject;
				T result = caseLinearMemoryDeallocationDependency(linearMemoryDeallocationDependency);
				if (result == null) result = caseMemoryDependency(linearMemoryDeallocationDependency);
				if (result == null) result = caseLinearDependency(linearMemoryDeallocationDependency);
				if (result == null) result = caseChannelDependency(linearMemoryDeallocationDependency);
				if (result == null) result = caseDependency(linearMemoryDeallocationDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannel(Channel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(org.polymodel.prdg.scheduling.structured.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessNetwork(ProcessNetwork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPort(DataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPort(InputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPort(OutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelSchedulePrototype(ChannelSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelDependency(ChannelDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Read Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelReadDependency(ChannelReadDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Write Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelWriteDependency(ChannelWriteDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryDependency(MemoryDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Memory Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Memory Read Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearMemoryReadDependency(LinearMemoryReadDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Memory Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Memory Write Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearMemoryWriteDependency(LinearMemoryWriteDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounded Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounded Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundedChannel(BoundedChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Memory Allocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Memory Allocation Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearMemoryAllocationDependency(LinearMemoryAllocationDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Read Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryReadDependency(MemoryReadDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Write Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryWriteDependency(MemoryWriteDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Allocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Allocation Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryAllocationDependency(MemoryAllocationDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Deallocation Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryDeallocationDependency(MemoryDeallocationDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearDependency(LinearDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Linear Read Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Linear Read Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelLinearReadDependency(ChannelLinearReadDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Linear Write Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Linear Write Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelLinearWriteDependency(ChannelLinearWriteDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeDependency(CompositeDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multidim Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multidim Deallocation Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultidimDeallocationDependency(MultidimDeallocationDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multidim Memory Read Dependency Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multidim Memory Read Dependency Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultidimMemoryReadDependencyComponent(MultidimMemoryReadDependencyComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounding Coefficient</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounding Coefficient</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundingCoefficient(BoundingCoefficient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Memory Deallocation Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Memory Deallocation Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearMemoryDeallocationDependency(LinearMemoryDeallocationDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulePrototype(SchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObservable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObservable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObservable(IObservable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultidimDependency(MultidimDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgebraVisitable(AlgebraVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StructuredSwitch
