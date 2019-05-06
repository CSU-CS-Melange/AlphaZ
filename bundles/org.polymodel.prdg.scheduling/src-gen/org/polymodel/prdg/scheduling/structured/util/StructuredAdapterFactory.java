/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage
 * @generated
 */
public class StructuredAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StructuredPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StructuredPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredSwitch<Adapter> modelSwitch =
		new StructuredSwitch<Adapter>() {
			@Override
			public Adapter caseChannel(Channel object) {
				return createChannelAdapter();
			}
			@Override
			public Adapter caseProcess(org.polymodel.prdg.scheduling.structured.Process object) {
				return createProcessAdapter();
			}
			@Override
			public Adapter caseProcessNetwork(ProcessNetwork object) {
				return createProcessNetworkAdapter();
			}
			@Override
			public Adapter caseDataPort(DataPort object) {
				return createDataPortAdapter();
			}
			@Override
			public Adapter caseInputPort(InputPort object) {
				return createInputPortAdapter();
			}
			@Override
			public Adapter caseOutputPort(OutputPort object) {
				return createOutputPortAdapter();
			}
			@Override
			public Adapter caseChannelSchedulePrototype(ChannelSchedulePrototype object) {
				return createChannelSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseChannelDependency(ChannelDependency object) {
				return createChannelDependencyAdapter();
			}
			@Override
			public Adapter caseChannelReadDependency(ChannelReadDependency object) {
				return createChannelReadDependencyAdapter();
			}
			@Override
			public Adapter caseChannelWriteDependency(ChannelWriteDependency object) {
				return createChannelWriteDependencyAdapter();
			}
			@Override
			public Adapter caseMemoryDependency(MemoryDependency object) {
				return createMemoryDependencyAdapter();
			}
			@Override
			public Adapter caseLinearMemoryReadDependency(LinearMemoryReadDependency object) {
				return createLinearMemoryReadDependencyAdapter();
			}
			@Override
			public Adapter caseLinearMemoryWriteDependency(LinearMemoryWriteDependency object) {
				return createLinearMemoryWriteDependencyAdapter();
			}
			@Override
			public Adapter caseBoundedChannel(BoundedChannel object) {
				return createBoundedChannelAdapter();
			}
			@Override
			public Adapter caseLinearMemoryAllocationDependency(LinearMemoryAllocationDependency object) {
				return createLinearMemoryAllocationDependencyAdapter();
			}
			@Override
			public Adapter caseMemoryReadDependency(MemoryReadDependency object) {
				return createMemoryReadDependencyAdapter();
			}
			@Override
			public Adapter caseMemoryWriteDependency(MemoryWriteDependency object) {
				return createMemoryWriteDependencyAdapter();
			}
			@Override
			public Adapter caseMemoryAllocationDependency(MemoryAllocationDependency object) {
				return createMemoryAllocationDependencyAdapter();
			}
			@Override
			public Adapter caseMemoryDeallocationDependency(MemoryDeallocationDependency object) {
				return createMemoryDeallocationDependencyAdapter();
			}
			@Override
			public Adapter caseLinearDependency(LinearDependency object) {
				return createLinearDependencyAdapter();
			}
			@Override
			public Adapter caseChannelLinearReadDependency(ChannelLinearReadDependency object) {
				return createChannelLinearReadDependencyAdapter();
			}
			@Override
			public Adapter caseChannelLinearWriteDependency(ChannelLinearWriteDependency object) {
				return createChannelLinearWriteDependencyAdapter();
			}
			@Override
			public Adapter caseCompositeDependency(CompositeDependency object) {
				return createCompositeDependencyAdapter();
			}
			@Override
			public Adapter caseMultidimDeallocationDependency(MultidimDeallocationDependency object) {
				return createMultidimDeallocationDependencyAdapter();
			}
			@Override
			public Adapter caseMultidimMemoryReadDependencyComponent(MultidimMemoryReadDependencyComponent object) {
				return createMultidimMemoryReadDependencyComponentAdapter();
			}
			@Override
			public Adapter caseBoundingCoefficient(BoundingCoefficient object) {
				return createBoundingCoefficientAdapter();
			}
			@Override
			public Adapter caseLinearMemoryDeallocationDependency(LinearMemoryDeallocationDependency object) {
				return createLinearMemoryDeallocationDependencyAdapter();
			}
			@Override
			public Adapter caseSchedulePrototype(SchedulePrototype object) {
				return createSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseDependency(Dependency object) {
				return createDependencyAdapter();
			}
			@Override
			public Adapter caseIObservable(IObservable object) {
				return createIObservableAdapter();
			}
			@Override
			public Adapter caseMultidimDependency(MultidimDependency object) {
				return createMultidimDependencyAdapter();
			}
			@Override
			public Adapter caseAlgebraVisitable(AlgebraVisitable object) {
				return createAlgebraVisitableAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.Channel
	 * @generated
	 */
	public Adapter createChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork <em>Process Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ProcessNetwork
	 * @generated
	 */
	public Adapter createProcessNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.DataPort
	 * @generated
	 */
	public Adapter createDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.InputPort
	 * @generated
	 */
	public Adapter createInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.OutputPort
	 * @generated
	 */
	public Adapter createOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype <em>Channel Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype
	 * @generated
	 */
	public Adapter createChannelSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelDependency <em>Channel Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelDependency
	 * @generated
	 */
	public Adapter createChannelDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelReadDependency <em>Channel Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelReadDependency
	 * @generated
	 */
	public Adapter createChannelReadDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelWriteDependency <em>Channel Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelWriteDependency
	 * @generated
	 */
	public Adapter createChannelWriteDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MemoryDependency <em>Memory Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDependency
	 * @generated
	 */
	public Adapter createMemoryDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency <em>Linear Memory Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency
	 * @generated
	 */
	public Adapter createLinearMemoryReadDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency <em>Linear Memory Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency
	 * @generated
	 */
	public Adapter createLinearMemoryWriteDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel <em>Bounded Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel
	 * @generated
	 */
	public Adapter createBoundedChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency <em>Linear Memory Allocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency
	 * @generated
	 */
	public Adapter createLinearMemoryAllocationDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MemoryReadDependency <em>Memory Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryReadDependency
	 * @generated
	 */
	public Adapter createMemoryReadDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MemoryWriteDependency <em>Memory Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryWriteDependency
	 * @generated
	 */
	public Adapter createMemoryWriteDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency <em>Memory Allocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency
	 * @generated
	 */
	public Adapter createMemoryAllocationDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency <em>Memory Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency
	 * @generated
	 */
	public Adapter createMemoryDeallocationDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.LinearDependency <em>Linear Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.LinearDependency
	 * @generated
	 */
	public Adapter createLinearDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency <em>Channel Linear Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency
	 * @generated
	 */
	public Adapter createChannelLinearReadDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency <em>Channel Linear Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency
	 * @generated
	 */
	public Adapter createChannelLinearWriteDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.CompositeDependency <em>Composite Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.CompositeDependency
	 * @generated
	 */
	public Adapter createCompositeDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency <em>Multidim Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency
	 * @generated
	 */
	public Adapter createMultidimDeallocationDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent <em>Multidim Memory Read Dependency Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent
	 * @generated
	 */
	public Adapter createMultidimMemoryReadDependencyComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.BoundingCoefficient <em>Bounding Coefficient</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.BoundingCoefficient
	 * @generated
	 */
	public Adapter createBoundingCoefficientAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency <em>Linear Memory Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency
	 * @generated
	 */
	public Adapter createLinearMemoryDeallocationDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.SchedulePrototype <em>Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype
	 * @generated
	 */
	public Adapter createSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.irisa.cairn.graph.observer.IObservable <em>IObservable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.irisa.cairn.graph.observer.IObservable
	 * @generated
	 */
	public Adapter createIObservableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency
	 * @generated
	 */
	public Adapter createMultidimDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.AlgebraVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.AlgebraVisitable
	 * @generated
	 */
	public Adapter createAlgebraVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StructuredAdapterFactory
