/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.impl;

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
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
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
import org.polymodel.scop.ScopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScanPackageImpl extends EPackageImpl implements ScanPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundComputationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass volumeFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass volumeFunctionDerivativeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scanBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass originDomainVolumeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scanReductionBodyEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScanPackageImpl() {
		super(eNS_URI, ScanFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScanPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScanPackage init() {
		if (isInited) return (ScanPackage)EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredScanPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ScanPackageImpl theScanPackage = registeredScanPackage instanceof ScanPackageImpl ? (ScanPackageImpl)registeredScanPackage : new ScanPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI);
		CDistributedPackageImpl theCDistributedPackage = (CDistributedPackageImpl)(registeredPackage instanceof CDistributedPackageImpl ? registeredPackage : CDistributedPackage.eINSTANCE);
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
		theScanPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theScanPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScanPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScanPackage.eNS_URI, theScanPackage);
		return theScanPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundComputation() {
		return boundComputationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_Lb() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_Ub() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_ConstantTerm() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_VolumeFunction() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_VolumeFunctionDerivative() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundComputation_InitialValue() {
		return (EReference)boundComputationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVolumeFunction() {
		return volumeFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVolumeFunction_Unknown() {
		return (EReference)volumeFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVolumeFunctionDerivative() {
		return volumeFunctionDerivativeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVolumeFunctionDerivative_Unknown() {
		return (EReference)volumeFunctionDerivativeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScanBody() {
		return scanBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_Domain() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_VolumeFunction() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_BoundComputationFunction() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_OriginDomainVolume() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_LocalReductionFunction() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_LocalScanFunction() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_LocalReductionVariables() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_LocalScanReductionVariables() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_LocalInitialVariables() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScanBody_NthreadVariableName() {
		return (EAttribute)scanBodyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScanBody_ThreadNumVariableName() {
		return (EAttribute)scanBodyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScanBody_BeginVariableName() {
		return (EAttribute)scanBodyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScanBody_EndVariableName() {
		return (EAttribute)scanBodyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanBody_ScanReductionBody() {
		return (EReference)scanBodyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOriginDomainVolume() {
		return originDomainVolumeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScanReductionBody() {
		return scanReductionBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_PreProcessLoop() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_ScanLoop() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_PostProcessLoop() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_MatrixTempVariables() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_InitTempVariables() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_AssignmentLoop() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_InitValueUpdate() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_InitValueCopy() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScanReductionBody_MatrixInitLoop() {
		return (EReference)scanReductionBodyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanFactory getScanFactory() {
		return (ScanFactory)getEFactoryInstance();
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
		boundComputationEClass = createEClass(BOUND_COMPUTATION);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__LB);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__UB);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__CONSTANT_TERM);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__VOLUME_FUNCTION);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE);
		createEReference(boundComputationEClass, BOUND_COMPUTATION__INITIAL_VALUE);

		volumeFunctionEClass = createEClass(VOLUME_FUNCTION);
		createEReference(volumeFunctionEClass, VOLUME_FUNCTION__UNKNOWN);

		volumeFunctionDerivativeEClass = createEClass(VOLUME_FUNCTION_DERIVATIVE);
		createEReference(volumeFunctionDerivativeEClass, VOLUME_FUNCTION_DERIVATIVE__UNKNOWN);

		scanBodyEClass = createEClass(SCAN_BODY);
		createEReference(scanBodyEClass, SCAN_BODY__DOMAIN);
		createEReference(scanBodyEClass, SCAN_BODY__VOLUME_FUNCTION);
		createEReference(scanBodyEClass, SCAN_BODY__BOUND_COMPUTATION_FUNCTION);
		createEReference(scanBodyEClass, SCAN_BODY__ORIGIN_DOMAIN_VOLUME);
		createEReference(scanBodyEClass, SCAN_BODY__LOCAL_REDUCTION_FUNCTION);
		createEReference(scanBodyEClass, SCAN_BODY__LOCAL_SCAN_FUNCTION);
		createEReference(scanBodyEClass, SCAN_BODY__LOCAL_REDUCTION_VARIABLES);
		createEReference(scanBodyEClass, SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES);
		createEReference(scanBodyEClass, SCAN_BODY__LOCAL_INITIAL_VARIABLES);
		createEAttribute(scanBodyEClass, SCAN_BODY__NTHREAD_VARIABLE_NAME);
		createEAttribute(scanBodyEClass, SCAN_BODY__THREAD_NUM_VARIABLE_NAME);
		createEAttribute(scanBodyEClass, SCAN_BODY__BEGIN_VARIABLE_NAME);
		createEAttribute(scanBodyEClass, SCAN_BODY__END_VARIABLE_NAME);
		createEReference(scanBodyEClass, SCAN_BODY__SCAN_REDUCTION_BODY);

		originDomainVolumeEClass = createEClass(ORIGIN_DOMAIN_VOLUME);

		scanReductionBodyEClass = createEClass(SCAN_REDUCTION_BODY);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__SCAN_LOOP);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__POST_PROCESS_LOOP);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__INIT_VALUE_COPY);
		createEReference(scanReductionBodyEClass, SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP);
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
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		CPackage theCPackage = (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		boundComputationEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		volumeFunctionEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		volumeFunctionDerivativeEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		scanBodyEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		originDomainVolumeEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		scanReductionBodyEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());

		// Initialize classes and features; add operations and parameters
		initEClass(boundComputationEClass, BoundComputation.class, "BoundComputation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundComputation_Lb(), thePolyIRCGPackage.getAbstractVariable(), null, "lb", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundComputation_Ub(), thePolyIRCGPackage.getAbstractVariable(), null, "ub", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundComputation_ConstantTerm(), thePolyIRCGPackage.getAbstractVariable(), null, "ConstantTerm", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundComputation_VolumeFunction(), this.getVolumeFunction(), null, "volumeFunction", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundComputation_VolumeFunctionDerivative(), this.getVolumeFunctionDerivative(), null, "volumeFunctionDerivative", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundComputation_InitialValue(), thePolyIRCGPackage.getAbstractVariable(), null, "initialValue", null, 1, 1, BoundComputation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(volumeFunctionEClass, VolumeFunction.class, "VolumeFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVolumeFunction_Unknown(), thePolyIRCGPackage.getAbstractVariable(), null, "unknown", null, 1, 1, VolumeFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(volumeFunctionDerivativeEClass, VolumeFunctionDerivative.class, "VolumeFunctionDerivative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVolumeFunctionDerivative_Unknown(), thePolyIRCGPackage.getAbstractVariable(), null, "unknown", null, 1, 1, VolumeFunctionDerivative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scanBodyEClass, ScanBody.class, "ScanBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScanBody_Domain(), thePolyhedralIRPackage.getDomain(), null, "domain", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_VolumeFunction(), this.getVolumeFunction(), null, "volumeFunction", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_BoundComputationFunction(), this.getBoundComputation(), null, "boundComputationFunction", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_OriginDomainVolume(), this.getOriginDomainVolume(), null, "originDomainVolume", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_LocalReductionFunction(), thePolyIRCGPackage.getFunction(), null, "localReductionFunction", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_LocalScanFunction(), thePolyIRCGPackage.getFunction(), null, "localScanFunction", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_LocalReductionVariables(), thePolyIRCGPackage.getCodeGenVariable(), null, "localReductionVariables", null, 0, -1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_LocalScanReductionVariables(), thePolyIRCGPackage.getCodeGenVariable(), null, "localScanReductionVariables", null, 0, -1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_LocalInitialVariables(), thePolyIRCGPackage.getCodeGenVariable(), null, "localInitialVariables", null, 0, -1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScanBody_NthreadVariableName(), ecorePackage.getEString(), "nthreadVariableName", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScanBody_ThreadNumVariableName(), ecorePackage.getEString(), "threadNumVariableName", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScanBody_BeginVariableName(), ecorePackage.getEString(), "beginVariableName", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScanBody_EndVariableName(), ecorePackage.getEString(), "endVariableName", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanBody_ScanReductionBody(), this.getScanReductionBody(), null, "scanReductionBody", null, 1, 1, ScanBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(originDomainVolumeEClass, OriginDomainVolume.class, "OriginDomainVolume", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scanReductionBodyEClass, ScanReductionBody.class, "ScanReductionBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScanReductionBody_PreProcessLoop(), theCPackage.getCLoop(), null, "preProcessLoop", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_ScanLoop(), theCPackage.getCLoop(), null, "scanLoop", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_PostProcessLoop(), theCPackage.getCLoop(), null, "postProcessLoop", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScanReductionBody_MatrixTempVariables(), thePolyIRCGPackage.getCodeGenVariable(), null, "matrixTempVariables", null, 0, -1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_InitTempVariables(), thePolyIRCGPackage.getCodeGenVariable(), null, "initTempVariables", null, 1, -1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_AssignmentLoop(), theCPackage.getCLoop(), null, "assignmentLoop", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_InitValueUpdate(), theCPackage.getCLoop(), null, "initValueUpdate", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_InitValueCopy(), theCPackage.getCLoop(), null, "initValueCopy", null, 1, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScanReductionBody_MatrixInitLoop(), theCPackage.getCLoop(), null, "matrixInitLoop", null, 0, 1, ScanReductionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ScanPackageImpl
