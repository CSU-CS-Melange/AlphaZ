/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
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
public class SIMDPackageImpl extends EPackageImpl implements SIMDPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRegisterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRegisterInitializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simdStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRegFunctionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simdFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simdcLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tiledSIMDCLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum simD_WIDTHEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum simD_INSEEnum = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SIMDPackageImpl() {
		super(eNS_URI, SIMDFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SIMDPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SIMDPackage init() {
		if (isInited) return (SIMDPackage)EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSIMDPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SIMDPackageImpl theSIMDPackage = registeredSIMDPackage instanceof SIMDPackageImpl ? (SIMDPackageImpl)registeredSIMDPackage : new SIMDPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(registeredPackage instanceof SimdExpPackageImpl ? registeredPackage : SimdExpPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(registeredPackage instanceof PCOTPackageImpl ? registeredPackage : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theSIMDPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theSIMDPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSIMDPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SIMDPackage.eNS_URI, theSIMDPackage);
		return theSIMDPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVType() {
		return vTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVType_Type() {
		return (EReference)vTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVType_Width() {
		return (EAttribute)vTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVType_Ins() {
		return (EAttribute)vTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRegister() {
		return vRegisterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegister_Vtype() {
		return (EReference)vRegisterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegister_Function() {
		return (EReference)vRegisterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRegisterInitialization() {
		return vRegisterInitializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegisterInitialization_Inputs() {
		return (EReference)vRegisterInitializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegisterInitialization_Locals() {
		return (EReference)vRegisterInitializationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegisterInitialization_Outputs() {
		return (EReference)vRegisterInitializationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIMDStatement() {
		return simdStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDStatement_SimdExp() {
		return (EReference)simdStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRegFunctionParameter() {
		return vRegFunctionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegFunctionParameter_Register() {
		return (EReference)vRegFunctionParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIMDFunction() {
		return simdFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDFunction_InputsimdRegs() {
		return (EReference)simdFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDFunction_OutputsimdRegs() {
		return (EReference)simdFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDFunction_LocalsimdRegs() {
		return (EReference)simdFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIMDCLoop() {
		return simdcLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDCLoop_SimdStatements() {
		return (EReference)simdcLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTiledSIMDCLoop() {
		return tiledSIMDCLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTiledSIMDCLoop_SimdStatements() {
		return (EReference)tiledSIMDCLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIMD_WIDTH() {
		return simD_WIDTHEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIMD_INS() {
		return simD_INSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDFactory getSIMDFactory() {
		return (SIMDFactory)getEFactoryInstance();
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
		vTypeEClass = createEClass(VTYPE);
		createEReference(vTypeEClass, VTYPE__TYPE);
		createEAttribute(vTypeEClass, VTYPE__WIDTH);
		createEAttribute(vTypeEClass, VTYPE__INS);

		vRegisterEClass = createEClass(VREGISTER);
		createEReference(vRegisterEClass, VREGISTER__VTYPE);
		createEReference(vRegisterEClass, VREGISTER__FUNCTION);

		vRegisterInitializationEClass = createEClass(VREGISTER_INITIALIZATION);
		createEReference(vRegisterInitializationEClass, VREGISTER_INITIALIZATION__INPUTS);
		createEReference(vRegisterInitializationEClass, VREGISTER_INITIALIZATION__LOCALS);
		createEReference(vRegisterInitializationEClass, VREGISTER_INITIALIZATION__OUTPUTS);

		simdStatementEClass = createEClass(SIMD_STATEMENT);
		createEReference(simdStatementEClass, SIMD_STATEMENT__SIMD_EXP);

		vRegFunctionParameterEClass = createEClass(VREG_FUNCTION_PARAMETER);
		createEReference(vRegFunctionParameterEClass, VREG_FUNCTION_PARAMETER__REGISTER);

		simdFunctionEClass = createEClass(SIMD_FUNCTION);
		createEReference(simdFunctionEClass, SIMD_FUNCTION__INPUTSIMD_REGS);
		createEReference(simdFunctionEClass, SIMD_FUNCTION__OUTPUTSIMD_REGS);
		createEReference(simdFunctionEClass, SIMD_FUNCTION__LOCALSIMD_REGS);

		simdcLoopEClass = createEClass(SIMD_CLOOP);
		createEReference(simdcLoopEClass, SIMD_CLOOP__SIMD_STATEMENTS);

		tiledSIMDCLoopEClass = createEClass(TILED_SIMDC_LOOP);
		createEReference(tiledSIMDCLoopEClass, TILED_SIMDC_LOOP__SIMD_STATEMENTS);

		// Create enums
		simD_WIDTHEEnum = createEEnum(SIMD_WIDTH);
		simD_INSEEnum = createEEnum(SIMD_INS);
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
		SimdExpPackage theSimdExpPackage = (SimdExpPackage)EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		PolyIRCGPackage thePolyIRCGPackage = (PolyIRCGPackage)EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);
		CPackage theCPackage = (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSimdExpPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vRegisterEClass.getESuperTypes().add(thePolyIRCGPackage.getAbstractVariable());
		vRegisterInitializationEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		simdStatementEClass.getESuperTypes().add(thePolyIRCGPackage.getStatement());
		simdFunctionEClass.getESuperTypes().add(thePolyIRCGPackage.getFunction());
		simdcLoopEClass.getESuperTypes().add(theCPackage.getCLoop());
		tiledSIMDCLoopEClass.getESuperTypes().add(theCPackage.getTiledCLoop());

		// Initialize classes and features; add operations and parameters
		initEClass(vTypeEClass, VType.class, "VType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVType_Type(), thePolyhedralIRPackage.getType(), null, "type", null, 1, 1, VType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVType_Width(), this.getSIMD_WIDTH(), "width", null, 1, 1, VType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVType_Ins(), this.getSIMD_INS(), "ins", null, 1, 1, VType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(vTypeEClass, ecorePackage.getEString(), "getSIMDName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(vTypeEClass, ecorePackage.getEInt(), "getNElements", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(vRegisterEClass, VRegister.class, "VRegister", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRegister_Vtype(), this.getVType(), null, "vtype", null, 1, 1, VRegister.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVRegister_Function(), thePolyIRCGPackage.getFunction(), null, "function", null, 1, 1, VRegister.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(vRegisterEClass, ecorePackage.getEString(), "getRegTypeString", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(vRegisterInitializationEClass, VRegisterInitialization.class, "VRegisterInitialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRegisterInitialization_Inputs(), this.getVRegister(), null, "inputs", null, 0, -1, VRegisterInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVRegisterInitialization_Locals(), this.getVRegister(), null, "locals", null, 0, -1, VRegisterInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVRegisterInitialization_Outputs(), this.getVRegister(), null, "outputs", null, 0, -1, VRegisterInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simdStatementEClass, SIMDStatement.class, "SIMDStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIMDStatement_SimdExp(), theSimdExpPackage.getSIMDExpression(), null, "simdExp", null, 1, 1, SIMDStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vRegFunctionParameterEClass, VRegFunctionParameter.class, "VRegFunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRegFunctionParameter_Register(), this.getVRegister(), null, "register", null, 1, 1, VRegFunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simdFunctionEClass, SIMDFunction.class, "SIMDFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIMDFunction_InputsimdRegs(), this.getVRegister(), null, "inputsimdRegs", null, 0, -1, SIMDFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSIMDFunction_OutputsimdRegs(), this.getVRegister(), null, "outputsimdRegs", null, 0, -1, SIMDFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSIMDFunction_LocalsimdRegs(), this.getVRegister(), null, "localsimdRegs", null, 0, -1, SIMDFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simdcLoopEClass, SIMDCLoop.class, "SIMDCLoop", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIMDCLoop_SimdStatements(), this.getSIMDStatement(), null, "simdStatements", null, 0, -1, SIMDCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tiledSIMDCLoopEClass, TiledSIMDCLoop.class, "TiledSIMDCLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTiledSIMDCLoop_SimdStatements(), this.getSIMDStatement(), null, "simdStatements", null, 0, -1, TiledSIMDCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(simD_WIDTHEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH.class, "SIMD_WIDTH");
		addEEnumLiteral(simD_WIDTHEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH.M128);
		addEEnumLiteral(simD_WIDTHEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH.M256);

		initEEnum(simD_INSEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS.class, "SIMD_INS");
		addEEnumLiteral(simD_INSEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS.SSE);
		addEEnumLiteral(simD_INSEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS.AVX);
		addEEnumLiteral(simD_INSEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS.FMA);
	}

} //SIMDPackageImpl
