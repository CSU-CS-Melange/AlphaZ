/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

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
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;
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
public class SimdExpPackageImpl extends EPackageImpl implements SimdExpPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simdExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicMemoryAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vLoadExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vStoreExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vBinaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vShiftExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRegisterExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vAssignExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vSetExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vPermuteExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vShuffleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vopEEnum = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimdExpPackageImpl() {
		super(eNS_URI, SimdExpFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SimdExpPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimdExpPackage init() {
		if (isInited) return (SimdExpPackage)EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSimdExpPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SimdExpPackageImpl theSimdExpPackage = registeredSimdExpPackage instanceof SimdExpPackageImpl ? (SimdExpPackageImpl)registeredSimdExpPackage : new SimdExpPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(registeredPackage instanceof PCOTPackageImpl ? registeredPackage : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theSimdExpPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theSimdExpPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimdExpPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimdExpPackage.eNS_URI, theSimdExpPackage);
		return theSimdExpPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIMDExpression() {
		return simdExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIMDExpression_Vtype() {
		return (EReference)simdExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicMemoryAddress() {
		return basicMemoryAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicMemoryAddress_Var() {
		return (EReference)basicMemoryAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicMemoryAddress_Access() {
		return (EReference)basicMemoryAddressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicMemoryAddress_Aligned() {
		return (EAttribute)basicMemoryAddressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicMemoryAddress_IsPointer() {
		return (EAttribute)basicMemoryAddressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVLoadExpression() {
		return vLoadExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVLoadExpression_Dst() {
		return (EReference)vLoadExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVLoadExpression_Src() {
		return (EReference)vLoadExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVStoreExpression() {
		return vStoreExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVStoreExpression_Src() {
		return (EReference)vStoreExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVStoreExpression_Dst() {
		return (EReference)vStoreExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVBinaryExpression() {
		return vBinaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVBinaryExpression_Op() {
		return (EAttribute)vBinaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVBinaryExpression_Lreg() {
		return (EReference)vBinaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVBinaryExpression_Rreg() {
		return (EReference)vBinaryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVShiftExpression() {
		return vShiftExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVShiftExpression_Reg1() {
		return (EReference)vShiftExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVShiftExpression_Reg2() {
		return (EReference)vShiftExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVShiftExpression_Dis() {
		return (EAttribute)vShiftExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRegisterExpression() {
		return vRegisterExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRegisterExpression_Reg() {
		return (EReference)vRegisterExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVAssignExpression() {
		return vAssignExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVAssignExpression_Lreg() {
		return (EReference)vAssignExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVAssignExpression_Rexp() {
		return (EReference)vAssignExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVSetExpression() {
		return vSetExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVSetExpression_Values() {
		return (EAttribute)vSetExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVPermuteExpression() {
		return vPermuteExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVPermuteExpression_Reg1() {
		return (EReference)vPermuteExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVPermuteExpression_Reg2() {
		return (EReference)vPermuteExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVPermuteExpression_Imm8() {
		return (EAttribute)vPermuteExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVShuffleExpression() {
		return vShuffleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVShuffleExpression_Reg1() {
		return (EReference)vShuffleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVShuffleExpression_Reg2() {
		return (EReference)vShuffleExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVShuffleExpression_Imm8() {
		return (EAttribute)vShuffleExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVOP() {
		return vopEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimdExpFactory getSimdExpFactory() {
		return (SimdExpFactory)getEFactoryInstance();
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
		simdExpressionEClass = createEClass(SIMD_EXPRESSION);
		createEReference(simdExpressionEClass, SIMD_EXPRESSION__VTYPE);

		basicMemoryAddressEClass = createEClass(BASIC_MEMORY_ADDRESS);
		createEReference(basicMemoryAddressEClass, BASIC_MEMORY_ADDRESS__VAR);
		createEReference(basicMemoryAddressEClass, BASIC_MEMORY_ADDRESS__ACCESS);
		createEAttribute(basicMemoryAddressEClass, BASIC_MEMORY_ADDRESS__ALIGNED);
		createEAttribute(basicMemoryAddressEClass, BASIC_MEMORY_ADDRESS__IS_POINTER);

		vLoadExpressionEClass = createEClass(VLOAD_EXPRESSION);
		createEReference(vLoadExpressionEClass, VLOAD_EXPRESSION__DST);
		createEReference(vLoadExpressionEClass, VLOAD_EXPRESSION__SRC);

		vStoreExpressionEClass = createEClass(VSTORE_EXPRESSION);
		createEReference(vStoreExpressionEClass, VSTORE_EXPRESSION__SRC);
		createEReference(vStoreExpressionEClass, VSTORE_EXPRESSION__DST);

		vBinaryExpressionEClass = createEClass(VBINARY_EXPRESSION);
		createEAttribute(vBinaryExpressionEClass, VBINARY_EXPRESSION__OP);
		createEReference(vBinaryExpressionEClass, VBINARY_EXPRESSION__LREG);
		createEReference(vBinaryExpressionEClass, VBINARY_EXPRESSION__RREG);

		vShiftExpressionEClass = createEClass(VSHIFT_EXPRESSION);
		createEReference(vShiftExpressionEClass, VSHIFT_EXPRESSION__REG1);
		createEReference(vShiftExpressionEClass, VSHIFT_EXPRESSION__REG2);
		createEAttribute(vShiftExpressionEClass, VSHIFT_EXPRESSION__DIS);

		vRegisterExpressionEClass = createEClass(VREGISTER_EXPRESSION);
		createEReference(vRegisterExpressionEClass, VREGISTER_EXPRESSION__REG);

		vAssignExpressionEClass = createEClass(VASSIGN_EXPRESSION);
		createEReference(vAssignExpressionEClass, VASSIGN_EXPRESSION__LREG);
		createEReference(vAssignExpressionEClass, VASSIGN_EXPRESSION__REXP);

		vSetExpressionEClass = createEClass(VSET_EXPRESSION);
		createEAttribute(vSetExpressionEClass, VSET_EXPRESSION__VALUES);

		vPermuteExpressionEClass = createEClass(VPERMUTE_EXPRESSION);
		createEReference(vPermuteExpressionEClass, VPERMUTE_EXPRESSION__REG1);
		createEReference(vPermuteExpressionEClass, VPERMUTE_EXPRESSION__REG2);
		createEAttribute(vPermuteExpressionEClass, VPERMUTE_EXPRESSION__IMM8);

		vShuffleExpressionEClass = createEClass(VSHUFFLE_EXPRESSION);
		createEReference(vShuffleExpressionEClass, VSHUFFLE_EXPRESSION__REG1);
		createEReference(vShuffleExpressionEClass, VSHUFFLE_EXPRESSION__REG2);
		createEAttribute(vShuffleExpressionEClass, VSHUFFLE_EXPRESSION__IMM8);

		// Create enums
		vopEEnum = createEEnum(VOP);
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
		SIMDPackage theSIMDPackage = (SIMDPackage)EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI);
		PolyIRCGPackage thePolyIRCGPackage = (PolyIRCGPackage)EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vLoadExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vStoreExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vBinaryExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vShiftExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vRegisterExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vAssignExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vSetExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vPermuteExpressionEClass.getESuperTypes().add(this.getSIMDExpression());
		vShuffleExpressionEClass.getESuperTypes().add(this.getSIMDExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(simdExpressionEClass, SIMDExpression.class, "SIMDExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIMDExpression_Vtype(), theSIMDPackage.getVType(), null, "vtype", null, 1, 1, SIMDExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicMemoryAddressEClass, BasicMemoryAddress.class, "BasicMemoryAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicMemoryAddress_Var(), thePolyIRCGPackage.getCodeGenVariable(), null, "var", null, 1, 1, BasicMemoryAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicMemoryAddress_Access(), thePolyhedralIRPackage.getAffineFunction(), null, "access", null, 1, 1, BasicMemoryAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicMemoryAddress_Aligned(), ecorePackage.getEBoolean(), "aligned", null, 1, 1, BasicMemoryAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicMemoryAddress_IsPointer(), ecorePackage.getEBoolean(), "isPointer", null, 1, 1, BasicMemoryAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vLoadExpressionEClass, VLoadExpression.class, "VLoadExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVLoadExpression_Dst(), theSIMDPackage.getVRegister(), null, "dst", null, 1, 1, VLoadExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVLoadExpression_Src(), this.getBasicMemoryAddress(), null, "src", null, 1, 1, VLoadExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vStoreExpressionEClass, VStoreExpression.class, "VStoreExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVStoreExpression_Src(), theSIMDPackage.getVRegister(), null, "src", null, 1, 1, VStoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVStoreExpression_Dst(), this.getBasicMemoryAddress(), null, "dst", null, 1, 1, VStoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vBinaryExpressionEClass, VBinaryExpression.class, "VBinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVBinaryExpression_Op(), this.getVOP(), "op", null, 1, 1, VBinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVBinaryExpression_Lreg(), this.getSIMDExpression(), null, "lreg", null, 1, 1, VBinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVBinaryExpression_Rreg(), this.getSIMDExpression(), null, "rreg", null, 1, 1, VBinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vShiftExpressionEClass, VShiftExpression.class, "VShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVShiftExpression_Reg1(), this.getSIMDExpression(), null, "reg1", null, 1, 1, VShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVShiftExpression_Reg2(), this.getSIMDExpression(), null, "reg2", null, 1, 1, VShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVShiftExpression_Dis(), ecorePackage.getEInt(), "dis", null, 1, 1, VShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vRegisterExpressionEClass, VRegisterExpression.class, "VRegisterExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRegisterExpression_Reg(), theSIMDPackage.getVRegister(), null, "reg", null, 1, 1, VRegisterExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vAssignExpressionEClass, VAssignExpression.class, "VAssignExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVAssignExpression_Lreg(), theSIMDPackage.getVRegister(), null, "lreg", null, 1, 1, VAssignExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVAssignExpression_Rexp(), this.getSIMDExpression(), null, "rexp", null, 1, 1, VAssignExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vSetExpressionEClass, VSetExpression.class, "VSetExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVSetExpression_Values(), ecorePackage.getEString(), "values", null, 0, -1, VSetExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vPermuteExpressionEClass, VPermuteExpression.class, "VPermuteExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVPermuteExpression_Reg1(), this.getSIMDExpression(), null, "reg1", null, 1, 1, VPermuteExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVPermuteExpression_Reg2(), this.getSIMDExpression(), null, "reg2", null, 1, 1, VPermuteExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVPermuteExpression_Imm8(), ecorePackage.getEString(), "imm8", null, 1, 1, VPermuteExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vShuffleExpressionEClass, VShuffleExpression.class, "VShuffleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVShuffleExpression_Reg1(), this.getSIMDExpression(), null, "reg1", null, 1, 1, VShuffleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVShuffleExpression_Reg2(), this.getSIMDExpression(), null, "reg2", null, 1, 1, VShuffleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVShuffleExpression_Imm8(), ecorePackage.getEString(), "imm8", null, 1, 1, VShuffleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(vopEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP.class, "VOP");
		addEEnumLiteral(vopEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP.ADD);
		addEEnumLiteral(vopEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP.SUB);
		addEEnumLiteral(vopEEnum, org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP.MUL);
	}

} //SimdExpPackageImpl
