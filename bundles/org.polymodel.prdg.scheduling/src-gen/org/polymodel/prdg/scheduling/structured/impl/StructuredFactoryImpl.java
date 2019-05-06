/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.BoundingCoefficient;
import org.polymodel.prdg.scheduling.structured.Channel;
import org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency;
import org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency;
import org.polymodel.prdg.scheduling.structured.ChannelReadDependency;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelWriteDependency;
import org.polymodel.prdg.scheduling.structured.CompositeDependency;
import org.polymodel.prdg.scheduling.structured.InputPort;
import org.polymodel.prdg.scheduling.structured.LinearDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency;
import org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency;
import org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.MemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.MemoryWriteDependency;
import org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent;
import org.polymodel.prdg.scheduling.structured.OutputPort;
import org.polymodel.prdg.scheduling.structured.ProcessNetwork;
import org.polymodel.prdg.scheduling.structured.StructuredFactory;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuredFactoryImpl extends EFactoryImpl implements StructuredFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StructuredFactory init() {
		try {
			StructuredFactory theStructuredFactory = (StructuredFactory)EPackage.Registry.INSTANCE.getEFactory(StructuredPackage.eNS_URI);
			if (theStructuredFactory != null) {
				return theStructuredFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StructuredFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StructuredPackage.CHANNEL: return createChannel();
			case StructuredPackage.PROCESS: return createProcess();
			case StructuredPackage.PROCESS_NETWORK: return createProcessNetwork();
			case StructuredPackage.INPUT_PORT: return createInputPort();
			case StructuredPackage.OUTPUT_PORT: return createOutputPort();
			case StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE: return createChannelSchedulePrototype();
			case StructuredPackage.CHANNEL_READ_DEPENDENCY: return createChannelReadDependency();
			case StructuredPackage.CHANNEL_WRITE_DEPENDENCY: return createChannelWriteDependency();
			case StructuredPackage.LINEAR_MEMORY_READ_DEPENDENCY: return createLinearMemoryReadDependency();
			case StructuredPackage.LINEAR_MEMORY_WRITE_DEPENDENCY: return createLinearMemoryWriteDependency();
			case StructuredPackage.BOUNDED_CHANNEL: return createBoundedChannel();
			case StructuredPackage.LINEAR_MEMORY_ALLOCATION_DEPENDENCY: return createLinearMemoryAllocationDependency();
			case StructuredPackage.MEMORY_READ_DEPENDENCY: return createMemoryReadDependency();
			case StructuredPackage.MEMORY_WRITE_DEPENDENCY: return createMemoryWriteDependency();
			case StructuredPackage.MEMORY_ALLOCATION_DEPENDENCY: return createMemoryAllocationDependency();
			case StructuredPackage.MEMORY_DEALLOCATION_DEPENDENCY: return createMemoryDeallocationDependency();
			case StructuredPackage.LINEAR_DEPENDENCY: return createLinearDependency();
			case StructuredPackage.CHANNEL_LINEAR_READ_DEPENDENCY: return createChannelLinearReadDependency();
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY: return createChannelLinearWriteDependency();
			case StructuredPackage.COMPOSITE_DEPENDENCY: return createCompositeDependency();
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY: return createMultidimDeallocationDependency();
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT: return createMultidimMemoryReadDependencyComponent();
			case StructuredPackage.BOUNDING_COEFFICIENT: return createBoundingCoefficient();
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY: return createLinearMemoryDeallocationDependency();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Channel createChannel() {
		ChannelImpl channel = new ChannelImpl();
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.polymodel.prdg.scheduling.structured.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessNetwork createProcessNetwork() {
		ProcessNetworkImpl processNetwork = new ProcessNetworkImpl();
		return processNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSchedulePrototype createChannelSchedulePrototype() {
		ChannelSchedulePrototypeImpl channelSchedulePrototype = new ChannelSchedulePrototypeImpl();
		return channelSchedulePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelReadDependency createChannelReadDependency() {
		ChannelReadDependencyImpl channelReadDependency = new ChannelReadDependencyImpl();
		return channelReadDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelWriteDependency createChannelWriteDependency() {
		ChannelWriteDependencyImpl channelWriteDependency = new ChannelWriteDependencyImpl();
		return channelWriteDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearMemoryReadDependency createLinearMemoryReadDependency() {
		LinearMemoryReadDependencyImpl linearMemoryReadDependency = new LinearMemoryReadDependencyImpl();
		return linearMemoryReadDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearMemoryWriteDependency createLinearMemoryWriteDependency() {
		LinearMemoryWriteDependencyImpl linearMemoryWriteDependency = new LinearMemoryWriteDependencyImpl();
		return linearMemoryWriteDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundedChannel createBoundedChannel() {
		BoundedChannelImpl boundedChannel = new BoundedChannelImpl();
		return boundedChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearMemoryAllocationDependency createLinearMemoryAllocationDependency() {
		LinearMemoryAllocationDependencyImpl linearMemoryAllocationDependency = new LinearMemoryAllocationDependencyImpl();
		return linearMemoryAllocationDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryReadDependency createMemoryReadDependency() {
		MemoryReadDependencyImpl memoryReadDependency = new MemoryReadDependencyImpl();
		return memoryReadDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryWriteDependency createMemoryWriteDependency() {
		MemoryWriteDependencyImpl memoryWriteDependency = new MemoryWriteDependencyImpl();
		return memoryWriteDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryAllocationDependency createMemoryAllocationDependency() {
		MemoryAllocationDependencyImpl memoryAllocationDependency = new MemoryAllocationDependencyImpl();
		return memoryAllocationDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryDeallocationDependency createMemoryDeallocationDependency() {
		MemoryDeallocationDependencyImpl memoryDeallocationDependency = new MemoryDeallocationDependencyImpl();
		return memoryDeallocationDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearDependency createLinearDependency() {
		LinearDependencyImpl linearDependency = new LinearDependencyImpl();
		return linearDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelLinearReadDependency createChannelLinearReadDependency() {
		ChannelLinearReadDependencyImpl channelLinearReadDependency = new ChannelLinearReadDependencyImpl();
		return channelLinearReadDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelLinearWriteDependency createChannelLinearWriteDependency() {
		ChannelLinearWriteDependencyImpl channelLinearWriteDependency = new ChannelLinearWriteDependencyImpl();
		return channelLinearWriteDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeDependency createCompositeDependency() {
		CompositeDependencyImpl compositeDependency = new CompositeDependencyImpl();
		return compositeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimDeallocationDependency createMultidimDeallocationDependency() {
		MultidimDeallocationDependencyImpl multidimDeallocationDependency = new MultidimDeallocationDependencyImpl();
		return multidimDeallocationDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimMemoryReadDependencyComponent createMultidimMemoryReadDependencyComponent() {
		MultidimMemoryReadDependencyComponentImpl multidimMemoryReadDependencyComponent = new MultidimMemoryReadDependencyComponentImpl();
		return multidimMemoryReadDependencyComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundingCoefficient createBoundingCoefficient() {
		BoundingCoefficientImpl boundingCoefficient = new BoundingCoefficientImpl();
		return boundingCoefficient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearMemoryDeallocationDependency createLinearMemoryDeallocationDependency() {
		LinearMemoryDeallocationDependencyImpl linearMemoryDeallocationDependency = new LinearMemoryDeallocationDependencyImpl();
		return linearMemoryDeallocationDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredPackage getStructuredPackage() {
		return (StructuredPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StructuredPackage getPackage() {
		return StructuredPackage.eINSTANCE;
	}

} //StructuredFactoryImpl
