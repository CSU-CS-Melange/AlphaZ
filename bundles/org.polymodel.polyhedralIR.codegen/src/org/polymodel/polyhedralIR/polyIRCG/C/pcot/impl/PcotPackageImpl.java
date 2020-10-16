/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl;

import org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl;

import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl;

import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;

import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl;

import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;

import org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl;

import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

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
public class PcotPackageImpl extends EPackageImpl implements PcotPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcoTrecursionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcoTbaseEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PcotPackageImpl() {
		super(eNS_URI, PcotFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PcotPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PcotPackage init() {
		if (isInited) return (PcotPackage)EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPcotPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PcotPackageImpl thePcotPackage = registeredPcotPackage instanceof PcotPackageImpl ? (PcotPackageImpl)registeredPcotPackage : new PcotPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI);
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(registeredPackage instanceof AlgebraExPackageImpl ? registeredPackage : AlgebraExPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(registeredPackage instanceof SIMDPackageImpl ? registeredPackage : SIMDPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(registeredPackage instanceof SimdExpPackageImpl ? registeredPackage : SimdExpPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(registeredPackage instanceof PCOTPackageImpl ? registeredPackage : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		thePcotPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		thePcotPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePcotPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PcotPackage.eNS_URI, thePcotPackage);
		return thePcotPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCOTrecursion() {
		return pcoTrecursionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCOTrecursion_Recursion() {
		return (EReference)pcoTrecursionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCOTbase() {
		return pcoTbaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCOTbase_Loop() {
		return (EReference)pcoTbaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcotFactory getPcotFactory() {
		return (PcotFactory)getEFactoryInstance();
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
		pcoTrecursionEClass = createEClass(PCO_TRECURSION);
		createEReference(pcoTrecursionEClass, PCO_TRECURSION__RECURSION);

		pcoTbaseEClass = createEClass(PCO_TBASE);
		createEReference(pcoTbaseEClass, PCO_TBASE__LOOP);
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
		pcoTrecursionEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		pcoTbaseEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());

		// Initialize classes and features; add operations and parameters
		initEClass(pcoTrecursionEClass, PCOTrecursion.class, "PCOTrecursion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCOTrecursion_Recursion(), thePolyIRCGPackage.getFunction(), null, "recursion", null, 1, 1, PCOTrecursion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcoTbaseEClass, PCOTbase.class, "PCOTbase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCOTbase_Loop(), thePolyIRCGPackage.getLoop(), null, "loop", null, 0, 1, PCOTbase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PcotPackageImpl
