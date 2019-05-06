/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.impl;

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
import org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimFactory;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;
import org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl;

import fr.irisa.cairn.graph.observer.IObservable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultidimPackageImpl extends EPackageImpl implements MultidimPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullifiableDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multidimDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multidimSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementScalarSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelScalarSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObservableEClass = null;

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
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MultidimPackageImpl() {
		super(eNS_URI, MultidimFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MultidimPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MultidimPackage init() {
		if (isInited) return (MultidimPackage)EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI);

		// Obtain or create and register package
		MultidimPackageImpl theMultidimPackage = (MultidimPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MultidimPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MultidimPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PrdgPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		StructuredPackageImpl theStructuredPackage = (StructuredPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI) instanceof StructuredPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI) : StructuredPackage.eINSTANCE);

		// Create package meta-data objects
		theMultidimPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theStructuredPackage.createPackageContents();

		// Initialize created meta-data
		theMultidimPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theStructuredPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMultidimPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MultidimPackage.eNS_URI, theMultidimPackage);
		return theMultidimPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullifiableDependency() {
		return nullifiableDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNullifiableDependency_Dimension() {
		return (EAttribute)nullifiableDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNullifiableDependency_PreviousDimensionsDependencies() {
		return (EReference)nullifiableDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNullifiableDependency_SatisfactionVariable() {
		return (EReference)nullifiableDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNullifiableDependency_Dependency() {
		return (EReference)nullifiableDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNullifiableDependency_K() {
		return (EAttribute)nullifiableDependencyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultidimDependency() {
		return multidimDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultidimDependency_Dependencies() {
		return (EReference)multidimDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDependency__ComputeConstraints() {
		return multidimDependencyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDependency__GetAllScheduleCoefficients() {
		return multidimDependencyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDependency__GetAllSatisfactionVariables() {
		return multidimDependencyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDependency__GetAllSourceCoefficients() {
		return multidimDependencyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultidimDependency__GetAllReferenceCoefficients() {
		return multidimDependencyEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultidimSchedulePrototype() {
		return multidimSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultidimSchedulePrototype_Prototypes() {
		return (EReference)multidimSchedulePrototypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultidimSchedulePrototype_Scalars() {
		return (EReference)multidimSchedulePrototypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultidimSchedulePrototype_Reference() {
		return (EReference)multidimSchedulePrototypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarSchedulePrototype() {
		return scalarSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementScalarSchedulePrototype() {
		return statementScalarSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelScalarSchedulePrototype() {
		return channelScalarSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIObservable() {
		return iObservableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimFactory getMultidimFactory() {
		return (MultidimFactory)getEFactoryInstance();
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
		nullifiableDependencyEClass = createEClass(NULLIFIABLE_DEPENDENCY);
		createEAttribute(nullifiableDependencyEClass, NULLIFIABLE_DEPENDENCY__DIMENSION);
		createEReference(nullifiableDependencyEClass, NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES);
		createEReference(nullifiableDependencyEClass, NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE);
		createEReference(nullifiableDependencyEClass, NULLIFIABLE_DEPENDENCY__DEPENDENCY);
		createEAttribute(nullifiableDependencyEClass, NULLIFIABLE_DEPENDENCY__K);

		multidimDependencyEClass = createEClass(MULTIDIM_DEPENDENCY);
		createEReference(multidimDependencyEClass, MULTIDIM_DEPENDENCY__DEPENDENCIES);
		createEOperation(multidimDependencyEClass, MULTIDIM_DEPENDENCY___COMPUTE_CONSTRAINTS);
		createEOperation(multidimDependencyEClass, MULTIDIM_DEPENDENCY___GET_ALL_SCHEDULE_COEFFICIENTS);
		createEOperation(multidimDependencyEClass, MULTIDIM_DEPENDENCY___GET_ALL_SATISFACTION_VARIABLES);
		createEOperation(multidimDependencyEClass, MULTIDIM_DEPENDENCY___GET_ALL_SOURCE_COEFFICIENTS);
		createEOperation(multidimDependencyEClass, MULTIDIM_DEPENDENCY___GET_ALL_REFERENCE_COEFFICIENTS);

		multidimSchedulePrototypeEClass = createEClass(MULTIDIM_SCHEDULE_PROTOTYPE);
		createEReference(multidimSchedulePrototypeEClass, MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES);
		createEReference(multidimSchedulePrototypeEClass, MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS);
		createEReference(multidimSchedulePrototypeEClass, MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE);

		scalarSchedulePrototypeEClass = createEClass(SCALAR_SCHEDULE_PROTOTYPE);

		statementScalarSchedulePrototypeEClass = createEClass(STATEMENT_SCALAR_SCHEDULE_PROTOTYPE);

		channelScalarSchedulePrototypeEClass = createEClass(CHANNEL_SCALAR_SCHEDULE_PROTOTYPE);

		iObservableEClass = createEClass(IOBSERVABLE);
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
		SchedulingPackage theSchedulingPackage = (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		StructuredPackage theStructuredPackage = (StructuredPackage)EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nullifiableDependencyEClass.getESuperTypes().add(theSchedulingPackage.getDependency());
		multidimDependencyEClass.getESuperTypes().add(this.getIObservable());
		scalarSchedulePrototypeEClass.getESuperTypes().add(theSchedulingPackage.getSchedulePrototype());
		statementScalarSchedulePrototypeEClass.getESuperTypes().add(theSchedulingPackage.getStatementSchedulePrototype());
		statementScalarSchedulePrototypeEClass.getESuperTypes().add(this.getScalarSchedulePrototype());
		channelScalarSchedulePrototypeEClass.getESuperTypes().add(theStructuredPackage.getChannelSchedulePrototype());
		channelScalarSchedulePrototypeEClass.getESuperTypes().add(this.getScalarSchedulePrototype());

		// Initialize classes, features, and operations; add parameters
		initEClass(nullifiableDependencyEClass, NullifiableDependency.class, "NullifiableDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNullifiableDependency_Dimension(), ecorePackage.getEInt(), "dimension", null, 0, 1, NullifiableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNullifiableDependency_PreviousDimensionsDependencies(), this.getNullifiableDependency(), null, "previousDimensionsDependencies", null, 0, -1, NullifiableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNullifiableDependency_SatisfactionVariable(), theAlgebraPackage.getVariable(), null, "satisfactionVariable", null, 0, 1, NullifiableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNullifiableDependency_Dependency(), theSchedulingPackage.getDependency(), null, "dependency", null, 0, 1, NullifiableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNullifiableDependency_K(), ecorePackage.getELong(), "K", null, 0, 1, NullifiableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multidimDependencyEClass, MultidimDependency.class, "MultidimDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultidimDependency_Dependencies(), this.getNullifiableDependency(), null, "dependencies", null, 0, -1, MultidimDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMultidimDependency__ComputeConstraints(), thePolymodelPackage.getDomain(), "computeConstraints", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMultidimDependency__GetAllScheduleCoefficients(), theAlgebraPackage.getVariable(), "getAllScheduleCoefficients", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMultidimDependency__GetAllSatisfactionVariables(), theAlgebraPackage.getVariable(), "getAllSatisfactionVariables", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMultidimDependency__GetAllSourceCoefficients(), theAlgebraPackage.getVariable(), "getAllSourceCoefficients", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMultidimDependency__GetAllReferenceCoefficients(), theAlgebraPackage.getVariable(), "getAllReferenceCoefficients", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(multidimSchedulePrototypeEClass, MultidimSchedulePrototype.class, "MultidimSchedulePrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultidimSchedulePrototype_Prototypes(), theSchedulingPackage.getSchedulePrototype(), null, "prototypes", null, 0, -1, MultidimSchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultidimSchedulePrototype_Scalars(), this.getScalarSchedulePrototype(), null, "scalars", null, 0, -1, MultidimSchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultidimSchedulePrototype_Reference(), theSchedulingPackage.getSchedulePrototype(), null, "reference", null, 1, 1, MultidimSchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarSchedulePrototypeEClass, ScalarSchedulePrototype.class, "ScalarSchedulePrototype", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(statementScalarSchedulePrototypeEClass, StatementScalarSchedulePrototype.class, "StatementScalarSchedulePrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(channelScalarSchedulePrototypeEClass, ChannelScalarSchedulePrototype.class, "ChannelScalarSchedulePrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iObservableEClass, IObservable.class, "IObservable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //MultidimPackageImpl
