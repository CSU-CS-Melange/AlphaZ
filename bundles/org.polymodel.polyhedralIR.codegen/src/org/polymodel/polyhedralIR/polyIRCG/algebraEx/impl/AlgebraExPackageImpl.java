/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
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
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExFactory;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression;
import org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl;
import org.polymodel.scop.ScopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlgebraExPackageImpl extends EPackageImpl implements AlgebraExPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduloExpressionEClass = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AlgebraExPackageImpl() {
		super(eNS_URI, AlgebraExFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AlgebraExPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AlgebraExPackage init() {
		if (isInited) return (AlgebraExPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI);

		// Obtain or create and register package
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlgebraExPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlgebraExPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolyhedralIRPackage.eINSTANCE.eClass();
		ScopPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PolyIRCGPackageImpl thePolyIRCGPackage = (PolyIRCGPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) instanceof PolyIRCGPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) : PolyIRCGPackage.eINSTANCE);
		CPackageImpl theCPackage = (CPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) instanceof CPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) : CPackage.eINSTANCE);
		CWrapperPackageImpl theCWrapperPackage = (CWrapperPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) instanceof CWrapperPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) : CWrapperPackage.eINSTANCE);
		CDistributedPackageImpl theCDistributedPackage = (CDistributedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) instanceof CDistributedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) : CDistributedPackage.eINSTANCE);
		ScanPackageImpl theScanPackage = (ScanPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) instanceof ScanPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) : ScanPackage.eINSTANCE);
		PcotPackageImpl thePcotPackage = (PcotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) instanceof PcotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) : PcotPackage.eINSTANCE);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) instanceof SIMDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) : SIMDPackage.eINSTANCE);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) instanceof SimdExpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) : SimdExpPackage.eINSTANCE);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) instanceof PCOTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theAlgebraExPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theAlgebraExPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAlgebraExPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AlgebraExPackage.eNS_URI, theAlgebraExPackage);
		return theAlgebraExPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuloExpression() {
		return moduloExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuloExpression_Numerator() {
		return (EReference)moduloExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuloExpression_Denominator() {
		return (EReference)moduloExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgebraExFactory getAlgebraExFactory() {
		return (AlgebraExFactory)getEFactoryInstance();
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
		moduloExpressionEClass = createEClass(MODULO_EXPRESSION);
		createEReference(moduloExpressionEClass, MODULO_EXPRESSION__NUMERATOR);
		createEReference(moduloExpressionEClass, MODULO_EXPRESSION__DENOMINATOR);
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
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		moduloExpressionEClass.getESuperTypes().add(theAlgebraPackage.getIntExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(moduloExpressionEClass, ModuloExpression.class, "ModuloExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuloExpression_Numerator(), theAlgebraPackage.getIntExpression(), null, "numerator", null, 1, 1, ModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuloExpression_Denominator(), theAlgebraPackage.getIntExpression(), null, "denominator", null, 1, 1, ModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //AlgebraExPackageImpl
