/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl;
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
import org.polymodel.prdg.scheduling.structured.StructuredFactory;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuredPackageImpl extends EPackageImpl implements StructuredPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processNetworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelReadDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelWriteDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearMemoryReadDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearMemoryWriteDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundedChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearMemoryAllocationDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryReadDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryWriteDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryAllocationDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryDeallocationDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelLinearReadDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelLinearWriteDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multidimDeallocationDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multidimMemoryReadDependencyComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundingCoefficientEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearMemoryDeallocationDependencyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StructuredPackageImpl() {
		super(eNS_URI, StructuredFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StructuredPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StructuredPackage init() {
		if (isInited) return (StructuredPackage)EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI);

		// Obtain or create and register package
		StructuredPackageImpl theStructuredPackage = (StructuredPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StructuredPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StructuredPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PrdgPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		MultidimPackageImpl theMultidimPackage = (MultidimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI) instanceof MultidimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI) : MultidimPackage.eINSTANCE);

		// Create package meta-data objects
		theStructuredPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theMultidimPackage.createPackageContents();

		// Initialize created meta-data
		theStructuredPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theMultidimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStructuredPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StructuredPackage.eNS_URI, theStructuredPackage);
		return theStructuredPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannel() {
		return channelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Edges() {
		return (EReference)channelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Source() {
		return (EReference)channelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Destination() {
		return (EReference)channelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Schedule() {
		return (EReference)channelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Domain() {
		return (EReference)channelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChannel_Name() {
		return (EAttribute)channelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_SubscriptDimension() {
		return (EReference)channelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Inputs() {
		return (EReference)processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Outputs() {
		return (EReference)processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_InternalNodes() {
		return (EReference)processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_Name() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Constraints() {
		return (EReference)processEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessNetwork() {
		return processNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessNetwork_Processes() {
		return (EReference)processNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessNetwork_Channels() {
		return (EReference)processNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessNetwork_Prdg() {
		return (EReference)processNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPort() {
		return dataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__GetChannel() {
		return dataPortEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPort() {
		return inputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPort_Channel() {
		return (EReference)inputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPort() {
		return outputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPort_Channel() {
		return (EReference)outputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputPort__GetSourceNode() {
		return outputPortEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelSchedulePrototype() {
		return channelSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannelSchedulePrototype_Channel() {
		return (EReference)channelSchedulePrototypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelDependency() {
		return channelDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannelDependency_Channel() {
		return (EReference)channelDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelReadDependency() {
		return channelReadDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannelReadDependency_Edge() {
		return (EReference)channelReadDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelWriteDependency() {
		return channelWriteDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryDependency() {
		return memoryDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemoryDependency__GetChannel() {
		return memoryDependencyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearMemoryReadDependency() {
		return linearMemoryReadDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearMemoryWriteDependency() {
		return linearMemoryWriteDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundedChannel() {
		return boundedChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundedChannel_MaximalChannelSize() {
		return (EAttribute)boundedChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundedChannel_SizeVariable() {
		return (EReference)boundedChannelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundedChannel_BoundingCoefficients() {
		return (EReference)boundedChannelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundedChannel__GetBoundingCoefficient__int_int() {
		return boundedChannelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearMemoryAllocationDependency() {
		return linearMemoryAllocationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryReadDependency() {
		return memoryReadDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemoryReadDependency_DimensionSizes() {
		return (EAttribute)memoryReadDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryWriteDependency() {
		return memoryWriteDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryAllocationDependency() {
		return memoryAllocationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryDeallocationDependency() {
		return memoryDeallocationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemoryDeallocationDependency_DimensionSizes() {
		return (EAttribute)memoryDeallocationDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearDependency() {
		return linearDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinearDependency_Subscript() {
		return (EReference)linearDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelLinearReadDependency() {
		return channelLinearReadDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelLinearWriteDependency() {
		return channelLinearWriteDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeDependency() {
		return compositeDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeDependency_Dependencies() {
		return (EReference)compositeDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeDependency_DependencyDomain() {
		return (EReference)compositeDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultidimDeallocationDependency() {
		return multidimDeallocationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultidimDeallocationDependency_DimensionSizes() {
		return (EAttribute)multidimDeallocationDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDeallocationDependency__GetDomain() {
		return multidimDeallocationDependencyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDeallocationDependency__GetChannel() {
		return multidimDeallocationDependencyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultidimMemoryReadDependencyComponent() {
		return multidimMemoryReadDependencyComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultidimMemoryReadDependencyComponent_Dimension() {
		return (EAttribute)multidimMemoryReadDependencyComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundingCoefficient() {
		return boundingCoefficientEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingCoefficient_Index() {
		return (EAttribute)boundingCoefficientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingCoefficient_Dimension() {
		return (EAttribute)boundingCoefficientEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearMemoryDeallocationDependency() {
		return linearMemoryDeallocationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredFactory getStructuredFactory() {
		return (StructuredFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		channelEClass = createEClass(CHANNEL);
		createEReference(channelEClass, CHANNEL__EDGES);
		createEReference(channelEClass, CHANNEL__SOURCE);
		createEReference(channelEClass, CHANNEL__DESTINATION);
		createEReference(channelEClass, CHANNEL__SCHEDULE);
		createEReference(channelEClass, CHANNEL__DOMAIN);
		createEAttribute(channelEClass, CHANNEL__NAME);
		createEReference(channelEClass, CHANNEL__SUBSCRIPT_DIMENSION);

		processEClass = createEClass(PROCESS);
		createEReference(processEClass, PROCESS__INPUTS);
		createEReference(processEClass, PROCESS__OUTPUTS);
		createEReference(processEClass, PROCESS__INTERNAL_NODES);
		createEAttribute(processEClass, PROCESS__NAME);
		createEReference(processEClass, PROCESS__CONSTRAINTS);

		processNetworkEClass = createEClass(PROCESS_NETWORK);
		createEReference(processNetworkEClass, PROCESS_NETWORK__PROCESSES);
		createEReference(processNetworkEClass, PROCESS_NETWORK__CHANNELS);
		createEReference(processNetworkEClass, PROCESS_NETWORK__PRDG);

		dataPortEClass = createEClass(DATA_PORT);
		createEOperation(dataPortEClass, DATA_PORT___GET_CHANNEL);

		inputPortEClass = createEClass(INPUT_PORT);
		createEReference(inputPortEClass, INPUT_PORT__CHANNEL);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEReference(outputPortEClass, OUTPUT_PORT__CHANNEL);
		createEOperation(outputPortEClass, OUTPUT_PORT___GET_SOURCE_NODE);

		channelSchedulePrototypeEClass = createEClass(CHANNEL_SCHEDULE_PROTOTYPE);
		createEReference(channelSchedulePrototypeEClass, CHANNEL_SCHEDULE_PROTOTYPE__CHANNEL);

		channelDependencyEClass = createEClass(CHANNEL_DEPENDENCY);
		createEReference(channelDependencyEClass, CHANNEL_DEPENDENCY__CHANNEL);

		channelReadDependencyEClass = createEClass(CHANNEL_READ_DEPENDENCY);
		createEReference(channelReadDependencyEClass, CHANNEL_READ_DEPENDENCY__EDGE);

		channelWriteDependencyEClass = createEClass(CHANNEL_WRITE_DEPENDENCY);

		memoryDependencyEClass = createEClass(MEMORY_DEPENDENCY);
		createEOperation(memoryDependencyEClass, MEMORY_DEPENDENCY___GET_CHANNEL);

		linearMemoryReadDependencyEClass = createEClass(LINEAR_MEMORY_READ_DEPENDENCY);

		linearMemoryWriteDependencyEClass = createEClass(LINEAR_MEMORY_WRITE_DEPENDENCY);

		boundedChannelEClass = createEClass(BOUNDED_CHANNEL);
		createEAttribute(boundedChannelEClass, BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE);
		createEReference(boundedChannelEClass, BOUNDED_CHANNEL__SIZE_VARIABLE);
		createEReference(boundedChannelEClass, BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS);
		createEOperation(boundedChannelEClass, BOUNDED_CHANNEL___GET_BOUNDING_COEFFICIENT__INT_INT);

		linearMemoryAllocationDependencyEClass = createEClass(LINEAR_MEMORY_ALLOCATION_DEPENDENCY);

		memoryReadDependencyEClass = createEClass(MEMORY_READ_DEPENDENCY);
		createEAttribute(memoryReadDependencyEClass, MEMORY_READ_DEPENDENCY__DIMENSION_SIZES);

		memoryWriteDependencyEClass = createEClass(MEMORY_WRITE_DEPENDENCY);

		memoryAllocationDependencyEClass = createEClass(MEMORY_ALLOCATION_DEPENDENCY);

		memoryDeallocationDependencyEClass = createEClass(MEMORY_DEALLOCATION_DEPENDENCY);
		createEAttribute(memoryDeallocationDependencyEClass, MEMORY_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES);

		linearDependencyEClass = createEClass(LINEAR_DEPENDENCY);
		createEReference(linearDependencyEClass, LINEAR_DEPENDENCY__SUBSCRIPT);

		channelLinearReadDependencyEClass = createEClass(CHANNEL_LINEAR_READ_DEPENDENCY);

		channelLinearWriteDependencyEClass = createEClass(CHANNEL_LINEAR_WRITE_DEPENDENCY);

		compositeDependencyEClass = createEClass(COMPOSITE_DEPENDENCY);
		createEReference(compositeDependencyEClass, COMPOSITE_DEPENDENCY__DEPENDENCIES);
		createEReference(compositeDependencyEClass, COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN);

		multidimDeallocationDependencyEClass = createEClass(MULTIDIM_DEALLOCATION_DEPENDENCY);
		createEAttribute(multidimDeallocationDependencyEClass, MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES);
		createEOperation(multidimDeallocationDependencyEClass, MULTIDIM_DEALLOCATION_DEPENDENCY___GET_DOMAIN);
		createEOperation(multidimDeallocationDependencyEClass, MULTIDIM_DEALLOCATION_DEPENDENCY___GET_CHANNEL);

		multidimMemoryReadDependencyComponentEClass = createEClass(MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT);
		createEAttribute(multidimMemoryReadDependencyComponentEClass, MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION);

		boundingCoefficientEClass = createEClass(BOUNDING_COEFFICIENT);
		createEAttribute(boundingCoefficientEClass, BOUNDING_COEFFICIENT__INDEX);
		createEAttribute(boundingCoefficientEClass, BOUNDING_COEFFICIENT__DIMENSION);

		linearMemoryDeallocationDependencyEClass = createEClass(LINEAR_MEMORY_DEALLOCATION_DEPENDENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PrdgPackage thePrdgPackage = (PrdgPackage)EPackage.Registry.INSTANCE.getEPackage(PrdgPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		SchedulingPackage theSchedulingPackage = (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		MultidimPackage theMultidimPackage = (MultidimPackage)EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputPortEClass.getESuperTypes().add(this.getDataPort());
		outputPortEClass.getESuperTypes().add(this.getDataPort());
		channelSchedulePrototypeEClass.getESuperTypes().add(theSchedulingPackage.getSchedulePrototype());
		channelDependencyEClass.getESuperTypes().add(theSchedulingPackage.getDependency());
		channelReadDependencyEClass.getESuperTypes().add(this.getChannelDependency());
		channelWriteDependencyEClass.getESuperTypes().add(this.getChannelDependency());
		memoryDependencyEClass.getESuperTypes().add(this.getChannelDependency());
		linearMemoryReadDependencyEClass.getESuperTypes().add(this.getChannelLinearReadDependency());
		linearMemoryReadDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		linearMemoryWriteDependencyEClass.getESuperTypes().add(this.getChannelLinearWriteDependency());
		linearMemoryWriteDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		boundedChannelEClass.getESuperTypes().add(this.getChannel());
		linearMemoryAllocationDependencyEClass.getESuperTypes().add(this.getChannelLinearReadDependency());
		linearMemoryAllocationDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		memoryReadDependencyEClass.getESuperTypes().add(this.getChannelReadDependency());
		memoryReadDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		memoryWriteDependencyEClass.getESuperTypes().add(this.getChannelWriteDependency());
		memoryWriteDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		memoryAllocationDependencyEClass.getESuperTypes().add(this.getChannelReadDependency());
		memoryAllocationDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		memoryDeallocationDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		channelLinearReadDependencyEClass.getESuperTypes().add(this.getChannelReadDependency());
		channelLinearReadDependencyEClass.getESuperTypes().add(this.getLinearDependency());
		channelLinearWriteDependencyEClass.getESuperTypes().add(this.getChannelWriteDependency());
		channelLinearWriteDependencyEClass.getESuperTypes().add(this.getLinearDependency());
		compositeDependencyEClass.getESuperTypes().add(theSchedulingPackage.getDependency());
		multidimDeallocationDependencyEClass.getESuperTypes().add(theMultidimPackage.getMultidimDependency());
		multidimMemoryReadDependencyComponentEClass.getESuperTypes().add(this.getMemoryReadDependency());
		boundingCoefficientEClass.getESuperTypes().add(theAlgebraPackage.getVariable());
		linearMemoryDeallocationDependencyEClass.getESuperTypes().add(this.getMemoryDependency());
		linearMemoryDeallocationDependencyEClass.getESuperTypes().add(this.getLinearDependency());

		// Initialize classes, features, and operations; add parameters
		initEClass(channelEClass, Channel.class, "Channel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannel_Edges(), thePrdgPackage.getPRDGEdge(), null, "edges", null, 0, -1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannel_Source(), this.getOutputPort(), this.getOutputPort_Channel(), "source", null, 1, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannel_Destination(), this.getInputPort(), this.getInputPort_Channel(), "destination", null, 1, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannel_Schedule(), this.getChannelSchedulePrototype(), null, "schedule", null, 1, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannel_Domain(), thePolymodelPackage.getDomain(), null, "domain", null, 0, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChannel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannel_SubscriptDimension(), theAlgebraPackage.getVariable(), null, "subscriptDimension", null, 0, 1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processEClass, org.polymodel.prdg.scheduling.structured.Process.class, "Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcess_Inputs(), this.getInputPort(), null, "inputs", null, 0, -1, org.polymodel.prdg.scheduling.structured.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_Outputs(), this.getOutputPort(), null, "outputs", null, 0, -1, org.polymodel.prdg.scheduling.structured.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_InternalNodes(), thePrdgPackage.getPRDGNode(), null, "internalNodes", null, 0, -1, org.polymodel.prdg.scheduling.structured.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcess_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.polymodel.prdg.scheduling.structured.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_Constraints(), thePolymodelPackage.getDomain(), null, "constraints", null, 0, 1, org.polymodel.prdg.scheduling.structured.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processNetworkEClass, ProcessNetwork.class, "ProcessNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessNetwork_Processes(), this.getProcess(), null, "processes", null, 1, -1, ProcessNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessNetwork_Channels(), this.getChannel(), null, "channels", null, 0, -1, ProcessNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessNetwork_Prdg(), thePrdgPackage.getPRDG(), null, "prdg", null, 0, 1, ProcessNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataPortEClass, DataPort.class, "DataPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDataPort__GetChannel(), this.getChannel(), "getChannel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputPort_Channel(), this.getChannel(), this.getChannel_Destination(), "channel", null, 0, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPort_Channel(), this.getChannel(), this.getChannel_Source(), "channel", null, 0, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOutputPort__GetSourceNode(), thePrdgPackage.getPRDGNode(), "getSourceNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(channelSchedulePrototypeEClass, ChannelSchedulePrototype.class, "ChannelSchedulePrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannelSchedulePrototype_Channel(), this.getChannel(), null, "channel", null, 0, 1, ChannelSchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelDependencyEClass, ChannelDependency.class, "ChannelDependency", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannelDependency_Channel(), this.getChannel(), null, "channel", null, 1, 1, ChannelDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelReadDependencyEClass, ChannelReadDependency.class, "ChannelReadDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannelReadDependency_Edge(), thePrdgPackage.getPRDGEdge(), null, "edge", null, 1, 1, ChannelReadDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelWriteDependencyEClass, ChannelWriteDependency.class, "ChannelWriteDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryDependencyEClass, MemoryDependency.class, "MemoryDependency", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getMemoryDependency__GetChannel(), this.getBoundedChannel(), "getChannel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linearMemoryReadDependencyEClass, LinearMemoryReadDependency.class, "LinearMemoryReadDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linearMemoryWriteDependencyEClass, LinearMemoryWriteDependency.class, "LinearMemoryWriteDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundedChannelEClass, BoundedChannel.class, "BoundedChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundedChannel_MaximalChannelSize(), ecorePackage.getEInt(), "maximalChannelSize", null, 0, 1, BoundedChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundedChannel_SizeVariable(), theAlgebraPackage.getVariable(), null, "sizeVariable", null, 0, 1, BoundedChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundedChannel_BoundingCoefficients(), this.getBoundingCoefficient(), null, "boundingCoefficients", null, 0, -1, BoundedChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getBoundedChannel__GetBoundingCoefficient__int_int(), this.getBoundingCoefficient(), "getBoundingCoefficient", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dimension", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linearMemoryAllocationDependencyEClass, LinearMemoryAllocationDependency.class, "LinearMemoryAllocationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryReadDependencyEClass, MemoryReadDependency.class, "MemoryReadDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemoryReadDependency_DimensionSizes(), ecorePackage.getELong(), "dimensionSizes", null, 0, -1, MemoryReadDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryWriteDependencyEClass, MemoryWriteDependency.class, "MemoryWriteDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryAllocationDependencyEClass, MemoryAllocationDependency.class, "MemoryAllocationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryDeallocationDependencyEClass, MemoryDeallocationDependency.class, "MemoryDeallocationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemoryDeallocationDependency_DimensionSizes(), ecorePackage.getELong(), "dimensionSizes", null, 0, -1, MemoryDeallocationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linearDependencyEClass, LinearDependency.class, "LinearDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinearDependency_Subscript(), theAlgebraPackage.getIntExpression(), null, "subscript", null, 0, 1, LinearDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelLinearReadDependencyEClass, ChannelLinearReadDependency.class, "ChannelLinearReadDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(channelLinearWriteDependencyEClass, ChannelLinearWriteDependency.class, "ChannelLinearWriteDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeDependencyEClass, CompositeDependency.class, "CompositeDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeDependency_Dependencies(), theSchedulingPackage.getDependency(), null, "dependencies", null, 0, -1, CompositeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeDependency_DependencyDomain(), thePolymodelPackage.getDomain(), null, "dependencyDomain", null, 0, 1, CompositeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multidimDeallocationDependencyEClass, MultidimDeallocationDependency.class, "MultidimDeallocationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultidimDeallocationDependency_DimensionSizes(), ecorePackage.getELong(), "dimensionSizes", null, 0, -1, MultidimDeallocationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMultidimDeallocationDependency__GetDomain(), thePolymodelPackage.getDomain(), "getDomain", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMultidimDeallocationDependency__GetChannel(), this.getBoundedChannel(), "getChannel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(multidimMemoryReadDependencyComponentEClass, MultidimMemoryReadDependencyComponent.class, "MultidimMemoryReadDependencyComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultidimMemoryReadDependencyComponent_Dimension(), ecorePackage.getEInt(), "dimension", null, 0, 1, MultidimMemoryReadDependencyComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundingCoefficientEClass, BoundingCoefficient.class, "BoundingCoefficient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundingCoefficient_Index(), ecorePackage.getEInt(), "index", null, 0, 1, BoundingCoefficient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingCoefficient_Dimension(), ecorePackage.getEInt(), "dimension", null, 0, 1, BoundingCoefficient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linearMemoryDeallocationDependencyEClass, LinearMemoryDeallocationDependency.class, "LinearMemoryDeallocationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //StructuredPackageImpl
