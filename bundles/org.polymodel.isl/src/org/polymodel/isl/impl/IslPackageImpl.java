/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslFactory;
import org.polymodel.isl.IslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IslPackageImpl extends EPackageImpl implements IslPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islUnionMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islUnionSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islBasicMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass islFunctionEClass = null;

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
	 * @see org.polymodel.isl.IslPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IslPackageImpl() {
		super(eNS_URI, IslFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IslPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IslPackage init() {
		if (isInited) return (IslPackage)EPackage.Registry.INSTANCE.getEPackage(IslPackage.eNS_URI);

		// Obtain or create and register package
		IslPackageImpl theIslPackage = (IslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IslPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolymodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theIslPackage.createPackageContents();

		// Initialize created meta-data
		theIslPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIslPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IslPackage.eNS_URI, theIslPackage);
		return theIslPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLMap() {
		return islMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLSet() {
		return islSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLUnionMap() {
		return islUnionMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISLUnionMap_Maps() {
		return (EReference)islUnionMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getISLUnionMap__LexMax__DimensionsManager() {
		return islUnionMapEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLUnionSet() {
		return islUnionSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISLUnionSet_Sets() {
		return (EReference)islUnionSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLBasicMap() {
		return islBasicMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLPoint() {
		return islPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISLPoint_Coordinates() {
		return (EAttribute)islPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISLFunction() {
		return islFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IslFactory getIslFactory() {
		return (IslFactory)getEFactoryInstance();
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
		islMapEClass = createEClass(ISL_MAP);

		islSetEClass = createEClass(ISL_SET);

		islUnionMapEClass = createEClass(ISL_UNION_MAP);
		createEReference(islUnionMapEClass, ISL_UNION_MAP__MAPS);
		createEOperation(islUnionMapEClass, ISL_UNION_MAP___LEX_MAX__DIMENSIONSMANAGER);

		islUnionSetEClass = createEClass(ISL_UNION_SET);
		createEReference(islUnionSetEClass, ISL_UNION_SET__SETS);

		islBasicMapEClass = createEClass(ISL_BASIC_MAP);

		islPointEClass = createEClass(ISL_POINT);
		createEAttribute(islPointEClass, ISL_POINT__COORDINATES);

		islFunctionEClass = createEClass(ISL_FUNCTION);
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
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		islMapEClass.getESuperTypes().add(thePolymodelPackage.getRelation());
		islSetEClass.getESuperTypes().add(thePolymodelPackage.getDomain());
		islBasicMapEClass.getESuperTypes().add(thePolymodelPackage.getBasicRelation());
		islFunctionEClass.getESuperTypes().add(thePolymodelPackage.getFunction());

		// Initialize classes, features, and operations; add parameters
		initEClass(islMapEClass, ISLMap.class, "ISLMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(islSetEClass, ISLSet.class, "ISLSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(islUnionMapEClass, ISLUnionMap.class, "ISLUnionMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getISLUnionMap_Maps(), this.getISLMap(), null, "maps", null, 0, -1, ISLUnionMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getISLUnionMap__LexMax__DimensionsManager(), this.getISLUnionMap(), "lexMax", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolymodelPackage.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(islUnionSetEClass, ISLUnionSet.class, "ISLUnionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getISLUnionSet_Sets(), this.getISLSet(), null, "sets", null, 0, -1, ISLUnionSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(islBasicMapEClass, ISLBasicMap.class, "ISLBasicMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(islPointEClass, ISLPoint.class, "ISLPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getISLPoint_Coordinates(), ecorePackage.getELong(), "coordinates", null, 0, -1, ISLPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(islFunctionEClass, ISLFunction.class, "ISLFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //IslPackageImpl
