/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.affine.AffinePackage;
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
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable;
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
public class CWrapperPackageImpl extends EPackageImpl implements CWrapperPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputInitializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPrintingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputVerificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specialVariableEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CWrapperPackageImpl() {
		super(eNS_URI, CWrapperFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CWrapperPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CWrapperPackage init() {
		if (isInited) return (CWrapperPackage)EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI);

		// Obtain or create and register package
		CWrapperPackageImpl theCWrapperPackage = (CWrapperPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CWrapperPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CWrapperPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolyhedralIRPackage.eINSTANCE.eClass();
		ScopPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PolyIRCGPackageImpl thePolyIRCGPackage = (PolyIRCGPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) instanceof PolyIRCGPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) : PolyIRCGPackage.eINSTANCE);
		CPackageImpl theCPackage = (CPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) instanceof CPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) : CPackage.eINSTANCE);
		CDistributedPackageImpl theCDistributedPackage = (CDistributedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) instanceof CDistributedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) : CDistributedPackage.eINSTANCE);
		ScanPackageImpl theScanPackage = (ScanPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) instanceof ScanPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) : ScanPackage.eINSTANCE);
		PcotPackageImpl thePcotPackage = (PcotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) instanceof PcotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) : PcotPackage.eINSTANCE);
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) instanceof AlgebraExPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) : AlgebraExPackage.eINSTANCE);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) instanceof SIMDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) : SIMDPackage.eINSTANCE);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) instanceof SimdExpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) : SimdExpPackage.eINSTANCE);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) instanceof PCOTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theCWrapperPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theCWrapperPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCWrapperPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CWrapperPackage.eNS_URI, theCWrapperPackage);
		return theCWrapperPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputInitialization() {
		return inputInitializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputInitialization_SpecialVar() {
		return (EReference)inputInitializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPrinting() {
		return outputPrintingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPrinting_SpecialVar() {
		return (EReference)outputPrintingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputVerification() {
		return outputVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputVerification_SpecialVar() {
		return (EReference)outputVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecialVariable() {
		return specialVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecialVariable_VarDecl() {
		return (EReference)specialVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecialVariable_Access() {
		return (EReference)specialVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CWrapperFactory getCWrapperFactory() {
		return (CWrapperFactory)getEFactoryInstance();
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
		inputInitializationEClass = createEClass(INPUT_INITIALIZATION);
		createEReference(inputInitializationEClass, INPUT_INITIALIZATION__SPECIAL_VAR);

		outputPrintingEClass = createEClass(OUTPUT_PRINTING);
		createEReference(outputPrintingEClass, OUTPUT_PRINTING__SPECIAL_VAR);

		outputVerificationEClass = createEClass(OUTPUT_VERIFICATION);
		createEReference(outputVerificationEClass, OUTPUT_VERIFICATION__SPECIAL_VAR);

		specialVariableEClass = createEClass(SPECIAL_VARIABLE);
		createEReference(specialVariableEClass, SPECIAL_VARIABLE__VAR_DECL);
		createEReference(specialVariableEClass, SPECIAL_VARIABLE__ACCESS);
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
		CPackage theCPackage = (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		AffinePackage theAffinePackage = (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputInitializationEClass.getESuperTypes().add(theCPackage.getCLoop());
		outputPrintingEClass.getESuperTypes().add(theCPackage.getCLoop());
		outputVerificationEClass.getESuperTypes().add(theCPackage.getCLoop());

		// Initialize classes and features; add operations and parameters
		initEClass(inputInitializationEClass, InputInitialization.class, "InputInitialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputInitialization_SpecialVar(), this.getSpecialVariable(), null, "specialVar", null, 0, 1, InputInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputPrintingEClass, OutputPrinting.class, "OutputPrinting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPrinting_SpecialVar(), this.getSpecialVariable(), null, "specialVar", null, 0, 1, OutputPrinting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputVerificationEClass, OutputVerification.class, "OutputVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputVerification_SpecialVar(), this.getSpecialVariable(), null, "specialVar", null, 0, 1, OutputVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specialVariableEClass, SpecialVariable.class, "SpecialVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecialVariable_VarDecl(), thePolyhedralIRPackage.getVariableDeclaration(), null, "varDecl", null, 0, 1, SpecialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecialVariable_Access(), thePolyhedralIRPackage.getAffineFunction(), null, "access", null, 0, 1, SpecialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(specialVariableEClass, theAffinePackage.getAffineExpression(), "getMemoryAccessExpressions", 0, -1, IS_UNIQUE, IS_ORDERED);
	}

} //CWrapperPackageImpl
