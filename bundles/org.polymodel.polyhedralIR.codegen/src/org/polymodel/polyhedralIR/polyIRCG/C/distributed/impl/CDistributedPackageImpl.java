/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.scop.ScopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDistributedPackageImpl extends EPackageImpl implements CDistributedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitioningComputationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distributedPseudoProjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mpicLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferMemoryDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferAccessExpressionEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CDistributedPackageImpl() {
		super(eNS_URI, CDistributedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CDistributedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CDistributedPackage init() {
		if (isInited) return (CDistributedPackage)EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCDistributedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CDistributedPackageImpl theCDistributedPackage = registeredCDistributedPackage instanceof CDistributedPackageImpl ? (CDistributedPackageImpl)registeredCDistributedPackage : new CDistributedPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		AlgebraPackage.eINSTANCE.eClass();
		PolyhedralIRPackage.eINSTANCE.eClass();
		PolymodelPackage.eINSTANCE.eClass();
		ScopPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);
		PolyIRCGPackageImpl thePolyIRCGPackage = (PolyIRCGPackageImpl)(registeredPackage instanceof PolyIRCGPackageImpl ? registeredPackage : PolyIRCGPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);
		CPackageImpl theCPackage = (CPackageImpl)(registeredPackage instanceof CPackageImpl ? registeredPackage : CPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI);
		CWrapperPackageImpl theCWrapperPackage = (CWrapperPackageImpl)(registeredPackage instanceof CWrapperPackageImpl ? registeredPackage : CWrapperPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI);
		ScanPackageImpl theScanPackage = (ScanPackageImpl)(registeredPackage instanceof ScanPackageImpl ? registeredPackage : ScanPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI);
		PcotPackageImpl thePcotPackage = (PcotPackageImpl)(registeredPackage instanceof PcotPackageImpl ? registeredPackage : PcotPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI);
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(registeredPackage instanceof AlgebraExPackageImpl ? registeredPackage : AlgebraExPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(registeredPackage instanceof SIMDPackageImpl ? registeredPackage : SIMDPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(registeredPackage instanceof SimdExpPackageImpl ? registeredPackage : SimdExpPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(registeredPackage instanceof PCOTPackageImpl ? registeredPackage : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theCDistributedPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theCDistributedPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCDistributedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CDistributedPackage.eNS_URI, theCDistributedPackage);
		return theCDistributedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartitioningComputation() {
		return partitioningComputationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartitioningComputation_PartitionedTile() {
		return (EReference)partitioningComputationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistributedPseudoProjection() {
		return distributedPseudoProjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDistributedPseudoProjection_DistributedDims() {
		return (EAttribute)distributedPseudoProjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistributedPseudoProjection_DistributedDimSizes() {
		return (EReference)distributedPseudoProjectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPICLoop() {
		return mpicLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMPICLoop_Buffers() {
		return (EReference)mpicLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBufferMapping() {
		return bufferMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMapping_ValueAccess() {
		return (EReference)bufferMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMapping_BufferAccess() {
		return (EReference)bufferMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMapping_Domain() {
		return (EReference)bufferMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMapping_CommunicatedVariable() {
		return (EReference)bufferMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuffer() {
		return bufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuffer_BufferMappings() {
		return (EReference)bufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuffer_Variable() {
		return (EReference)bufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBufferMemoryDomain() {
		return bufferMemoryDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMemoryDomain_BufferingFactor() {
		return (EReference)bufferMemoryDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferMemoryDomain_BufferID() {
		return (EReference)bufferMemoryDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBufferAccessExpression() {
		return bufferAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferAccessExpression_BufferingFactor() {
		return (EReference)bufferAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferAccessExpression_BufferID() {
		return (EReference)bufferAccessExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDistributedFactory getCDistributedFactory() {
		return (CDistributedFactory)getEFactoryInstance();
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
		partitioningComputationEClass = createEClass(PARTITIONING_COMPUTATION);
		createEReference(partitioningComputationEClass, PARTITIONING_COMPUTATION__PARTITIONED_TILE);

		distributedPseudoProjectionEClass = createEClass(DISTRIBUTED_PSEUDO_PROJECTION);
		createEAttribute(distributedPseudoProjectionEClass, DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS);
		createEReference(distributedPseudoProjectionEClass, DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES);

		mpicLoopEClass = createEClass(MPIC_LOOP);
		createEReference(mpicLoopEClass, MPIC_LOOP__BUFFERS);

		bufferMappingEClass = createEClass(BUFFER_MAPPING);
		createEReference(bufferMappingEClass, BUFFER_MAPPING__VALUE_ACCESS);
		createEReference(bufferMappingEClass, BUFFER_MAPPING__BUFFER_ACCESS);
		createEReference(bufferMappingEClass, BUFFER_MAPPING__DOMAIN);
		createEReference(bufferMappingEClass, BUFFER_MAPPING__COMMUNICATED_VARIABLE);

		bufferEClass = createEClass(BUFFER);
		createEReference(bufferEClass, BUFFER__BUFFER_MAPPINGS);
		createEReference(bufferEClass, BUFFER__VARIABLE);

		bufferMemoryDomainEClass = createEClass(BUFFER_MEMORY_DOMAIN);
		createEReference(bufferMemoryDomainEClass, BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR);
		createEReference(bufferMemoryDomainEClass, BUFFER_MEMORY_DOMAIN__BUFFER_ID);

		bufferAccessExpressionEClass = createEClass(BUFFER_ACCESS_EXPRESSION);
		createEReference(bufferAccessExpressionEClass, BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR);
		createEReference(bufferAccessExpressionEClass, BUFFER_ACCESS_EXPRESSION__BUFFER_ID);
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
		PolyIRCGPackage thePolyIRCGPackage = (PolyIRCGPackage)EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);
		CPackage theCPackage = (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		TargetMappingPackage theTargetMappingPackage = (TargetMappingPackage)EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		partitioningComputationEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		distributedPseudoProjectionEClass.getESuperTypes().add(thePolyIRCGPackage.getPseudoProjection());
		mpicLoopEClass.getESuperTypes().add(theCPackage.getTiledCLoop());
		bufferMemoryDomainEClass.getESuperTypes().add(thePolyIRCGPackage.getMergedMemoryDomain());
		bufferAccessExpressionEClass.getESuperTypes().add(thePolyIRCGPackage.getMergedDomainAccessExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(partitioningComputationEClass, PartitioningComputation.class, "PartitioningComputation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartitioningComputation_PartitionedTile(), theCPackage.getTiledCLoop(), null, "partitionedTile", null, 1, 1, PartitioningComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(distributedPseudoProjectionEClass, DistributedPseudoProjection.class, "DistributedPseudoProjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDistributedPseudoProjection_DistributedDims(), ecorePackage.getEInt(), "distributedDims", null, 0, -1, DistributedPseudoProjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDistributedPseudoProjection_DistributedDimSizes(), theAlgebraPackage.getIntExpression(), null, "distributedDimSizes", null, 0, -1, DistributedPseudoProjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mpicLoopEClass, MPICLoop.class, "MPICLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMPICLoop_Buffers(), this.getBuffer(), null, "buffers", null, 0, -1, MPICLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mpicLoopEClass, theCPackage.getCLoop(), "getSendBufferCopyLoop", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mpicLoopEClass, theCPackage.getCLoop(), "getReceiveBufferCopyLoop", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bufferMappingEClass, BufferMapping.class, "BufferMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferMapping_ValueAccess(), thePolyIRCGPackage.getMemoryAccessExpression(), null, "valueAccess", null, 1, 1, BufferMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferMapping_BufferAccess(), thePolyIRCGPackage.getMemoryAccessExpression(), null, "bufferAccess", null, 1, 1, BufferMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferMapping_Domain(), thePolyhedralIRPackage.getDomain(), null, "domain", null, 1, 1, BufferMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferMapping_CommunicatedVariable(), theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), null, "communicatedVariable", null, 1, 1, BufferMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuffer_BufferMappings(), this.getBufferMapping(), null, "bufferMappings", null, 0, -1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuffer_Variable(), thePolyIRCGPackage.getCodeGenVariable(), null, "variable", null, 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(bufferEClass, theAlgebraPackage.getIntExpression(), "computeBufferSize", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bufferEClass, thePolyhedralIRPackage.getDomain(), "getSendDomain", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bufferEClass, thePolyhedralIRPackage.getDomain(), "getReceiveDomain", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bufferMemoryDomainEClass, BufferMemoryDomain.class, "BufferMemoryDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferMemoryDomain_BufferingFactor(), theAlgebraPackage.getIntExpression(), null, "bufferingFactor", null, 1, 1, BufferMemoryDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferMemoryDomain_BufferID(), theAlgebraPackage.getVariable(), null, "bufferID", null, 1, 1, BufferMemoryDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferAccessExpressionEClass, BufferAccessExpression.class, "BufferAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferAccessExpression_BufferingFactor(), theAlgebraPackage.getIntExpression(), null, "bufferingFactor", null, 1, 1, BufferAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferAccessExpression_BufferID(), theAlgebraPackage.getVariable(), null, "bufferID", null, 1, 1, BufferAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CDistributedPackageImpl
