/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT.impl;

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
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTFactory;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;
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
public class PCOTPackageImpl extends EPackageImpl implements PCOTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recursionBodyEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PCOTPackageImpl() {
		super(eNS_URI, PCOTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PCOTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PCOTPackage init() {
		if (isInited) return (PCOTPackage)EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPCOTPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PCOTPackageImpl thePCOTPackage = registeredPCOTPackage instanceof PCOTPackageImpl ? (PCOTPackageImpl)registeredPCOTPackage : new PCOTPackageImpl();

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

		// Create package meta-data objects
		thePCOTPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();

		// Initialize created meta-data
		thePCOTPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePCOTPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PCOTPackage.eNS_URI, thePCOTPackage);
		return thePCOTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecursionBody() {
		return recursionBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecursionBody_Parallel() {
		return (EAttribute)recursionBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecursionBody_BaseFunction() {
		return (EReference)recursionBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecursionBody_BandStart() {
		return (EAttribute)recursionBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecursionBody_BandEnd() {
		return (EAttribute)recursionBodyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecursionBody_ParamStruct() {
		return (EReference)recursionBodyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecursionBody_LocalStruct() {
		return (EReference)recursionBodyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecursionBody_RecurStructs() {
		return (EReference)recursionBodyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecursionBody_TileSizes() {
		return (EAttribute)recursionBodyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCOTFactory getPCOTFactory() {
		return (PCOTFactory)getEFactoryInstance();
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
		recursionBodyEClass = createEClass(RECURSION_BODY);
		createEAttribute(recursionBodyEClass, RECURSION_BODY__PARALLEL);
		createEReference(recursionBodyEClass, RECURSION_BODY__BASE_FUNCTION);
		createEAttribute(recursionBodyEClass, RECURSION_BODY__BAND_START);
		createEAttribute(recursionBodyEClass, RECURSION_BODY__BAND_END);
		createEReference(recursionBodyEClass, RECURSION_BODY__PARAM_STRUCT);
		createEReference(recursionBodyEClass, RECURSION_BODY__LOCAL_STRUCT);
		createEReference(recursionBodyEClass, RECURSION_BODY__RECUR_STRUCTS);
		createEAttribute(recursionBodyEClass, RECURSION_BODY__TILE_SIZES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		recursionBodyEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());

		// Initialize classes and features; add operations and parameters
		initEClass(recursionBodyEClass, RecursionBody.class, "RecursionBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecursionBody_Parallel(), ecorePackage.getEBoolean(), "parallel", null, 1, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecursionBody_BaseFunction(), thePolyIRCGPackage.getFunction(), null, "baseFunction", null, 1, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecursionBody_BandStart(), ecorePackage.getEInt(), "bandStart", null, 1, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecursionBody_BandEnd(), ecorePackage.getEInt(), "bandEnd", null, 1, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecursionBody_ParamStruct(), thePolyIRCGPackage.getStruct(), null, "paramStruct", null, 1, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecursionBody_LocalStruct(), thePolyIRCGPackage.getStruct(), null, "localStruct", null, 0, 1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecursionBody_RecurStructs(), thePolyIRCGPackage.getStruct(), null, "recurStructs", null, 1, -1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecursionBody_TileSizes(), ecorePackage.getEString(), "tileSizes", null, 0, -1, RecursionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PCOTPackageImpl
