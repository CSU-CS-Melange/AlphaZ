/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.DataflowFactory;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.ResolvedAccess;
import org.polymodel.dataflow.WriteAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataflowPackageImpl extends EPackageImpl implements DataflowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adaInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adaStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adaSolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolvedAccessEClass = null;

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
	 * @see org.polymodel.dataflow.DataflowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataflowPackageImpl() {
		super(eNS_URI, DataflowFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataflowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataflowPackage init() {
		if (isInited) return (DataflowPackage)EPackage.Registry.INSTANCE.getEPackage(DataflowPackage.eNS_URI);

		// Obtain or create and register package
		DataflowPackageImpl theDataflowPackage = (DataflowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataflowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataflowPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolymodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDataflowPackage.createPackageContents();

		// Initialize created meta-data
		theDataflowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataflowPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataflowPackage.eNS_URI, theDataflowPackage);
		return theDataflowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getADAInput() {
		return adaInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADAInput_AdaStatements() {
		return (EReference)adaInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAInput__GetDimensionsManager() {
		return adaInputEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAInput__GetStatementByID__int() {
		return adaInputEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAInput__IsResolved() {
		return adaInputEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getADAStatement() {
		return adaStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getADAStatement_Id() {
		return (EAttribute)adaStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADAStatement_Writes() {
		return (EReference)adaStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADAStatement_Reads() {
		return (EReference)adaStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADAStatement_ParentADAInput() {
		return (EReference)adaStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAStatement__GetDomain() {
		return adaStatementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAStatement__GetIDSchedule() {
		return adaStatementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADAStatement__IsResolved() {
		return adaStatementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadAccess() {
		return readAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadAccess_LastWrite() {
		return (EReference)readAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReadAccess__GetAllWriteCandidates() {
		return readAccessEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadAccess_ParentADAStatement() {
		return (EReference)readAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriteAccess() {
		return writeAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getADASolution() {
		return adaSolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADASolution_ResolvedAccesses() {
		return (EReference)adaSolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getADASolution__IsBottom() {
		return adaSolutionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriteAccess_ParentADAStatement() {
		return (EReference)writeAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWriteAccess__GetAllReadCandidates() {
		return writeAccessEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccess() {
		return accessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccess_Index() {
		return (EReference)accessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAccess__GetAccessId() {
		return accessEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAccess__GetParentADAStatement() {
		return accessEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAccess__IsResolved() {
		return accessEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolvedAccess() {
		return resolvedAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolvedAccess_ValidityDomain() {
		return (EReference)resolvedAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolvedAccess_IterationVector() {
		return (EReference)resolvedAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolvedAccess_Access() {
		return (EReference)resolvedAccessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResolvedAccess__IsBottom() {
		return resolvedAccessEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataflowFactory getDataflowFactory() {
		return (DataflowFactory)getEFactoryInstance();
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
		adaInputEClass = createEClass(ADA_INPUT);
		createEReference(adaInputEClass, ADA_INPUT__ADA_STATEMENTS);
		createEOperation(adaInputEClass, ADA_INPUT___GET_DIMENSIONS_MANAGER);
		createEOperation(adaInputEClass, ADA_INPUT___GET_STATEMENT_BY_ID__INT);
		createEOperation(adaInputEClass, ADA_INPUT___IS_RESOLVED);

		adaStatementEClass = createEClass(ADA_STATEMENT);
		createEAttribute(adaStatementEClass, ADA_STATEMENT__ID);
		createEReference(adaStatementEClass, ADA_STATEMENT__WRITES);
		createEReference(adaStatementEClass, ADA_STATEMENT__READS);
		createEReference(adaStatementEClass, ADA_STATEMENT__PARENT_ADA_INPUT);
		createEOperation(adaStatementEClass, ADA_STATEMENT___GET_DOMAIN);
		createEOperation(adaStatementEClass, ADA_STATEMENT___GET_ID_SCHEDULE);
		createEOperation(adaStatementEClass, ADA_STATEMENT___IS_RESOLVED);

		accessEClass = createEClass(ACCESS);
		createEReference(accessEClass, ACCESS__INDEX);
		createEOperation(accessEClass, ACCESS___GET_ACCESS_ID);
		createEOperation(accessEClass, ACCESS___GET_PARENT_ADA_STATEMENT);
		createEOperation(accessEClass, ACCESS___IS_RESOLVED);

		readAccessEClass = createEClass(READ_ACCESS);
		createEReference(readAccessEClass, READ_ACCESS__PARENT_ADA_STATEMENT);
		createEReference(readAccessEClass, READ_ACCESS__LAST_WRITE);
		createEOperation(readAccessEClass, READ_ACCESS___GET_ALL_WRITE_CANDIDATES);

		writeAccessEClass = createEClass(WRITE_ACCESS);
		createEReference(writeAccessEClass, WRITE_ACCESS__PARENT_ADA_STATEMENT);
		createEOperation(writeAccessEClass, WRITE_ACCESS___GET_ALL_READ_CANDIDATES);

		adaSolutionEClass = createEClass(ADA_SOLUTION);
		createEReference(adaSolutionEClass, ADA_SOLUTION__RESOLVED_ACCESSES);
		createEOperation(adaSolutionEClass, ADA_SOLUTION___IS_BOTTOM);

		resolvedAccessEClass = createEClass(RESOLVED_ACCESS);
		createEReference(resolvedAccessEClass, RESOLVED_ACCESS__VALIDITY_DOMAIN);
		createEReference(resolvedAccessEClass, RESOLVED_ACCESS__ITERATION_VECTOR);
		createEReference(resolvedAccessEClass, RESOLVED_ACCESS__ACCESS);
		createEOperation(resolvedAccessEClass, RESOLVED_ACCESS___IS_BOTTOM);
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
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		readAccessEClass.getESuperTypes().add(this.getAccess());
		writeAccessEClass.getESuperTypes().add(this.getAccess());

		// Initialize classes, features, and operations; add parameters
		initEClass(adaInputEClass, ADAInput.class, "ADAInput", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getADAInput_AdaStatements(), this.getADAStatement(), this.getADAStatement_ParentADAInput(), "adaStatements", null, 0, -1, ADAInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getADAInput__GetDimensionsManager(), thePolymodelPackage.getDimensionsManager(), "getDimensionsManager", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getADAInput__GetStatementByID__int(), this.getADAStatement(), "getStatementByID", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "id", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getADAInput__IsResolved(), ecorePackage.getEBoolean(), "isResolved", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(adaStatementEClass, ADAStatement.class, "ADAStatement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getADAStatement_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ADAStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADAStatement_Writes(), this.getWriteAccess(), this.getWriteAccess_ParentADAStatement(), "writes", null, 0, -1, ADAStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADAStatement_Reads(), this.getReadAccess(), this.getReadAccess_ParentADAStatement(), "reads", null, 0, -1, ADAStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADAStatement_ParentADAInput(), this.getADAInput(), this.getADAInput_AdaStatements(), "parentADAInput", null, 1, 1, ADAStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getADAStatement__GetDomain(), thePolymodelPackage.getDomain(), "getDomain", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getADAStatement__GetIDSchedule(), thePolymodelPackage.getFunction(), "getIDSchedule", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getADAStatement__IsResolved(), ecorePackage.getEBoolean(), "isResolved", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(accessEClass, Access.class, "Access", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccess_Index(), theAlgebraPackage.getIntExpression(), null, "index", null, 0, -1, Access.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAccess__GetAccessId(), ecorePackage.getEString(), "getAccessId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAccess__GetParentADAStatement(), this.getADAStatement(), "getParentADAStatement", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAccess__IsResolved(), ecorePackage.getEBoolean(), "isResolved", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(readAccessEClass, ReadAccess.class, "ReadAccess", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadAccess_ParentADAStatement(), this.getADAStatement(), this.getADAStatement_Reads(), "parentADAStatement", null, 1, 1, ReadAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReadAccess_LastWrite(), this.getADASolution(), null, "lastWrite", null, 0, 1, ReadAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReadAccess__GetAllWriteCandidates(), this.getWriteAccess(), "getAllWriteCandidates", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(writeAccessEClass, WriteAccess.class, "WriteAccess", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWriteAccess_ParentADAStatement(), this.getADAStatement(), this.getADAStatement_Writes(), "parentADAStatement", null, 1, 1, WriteAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getWriteAccess__GetAllReadCandidates(), this.getReadAccess(), "getAllReadCandidates", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(adaSolutionEClass, ADASolution.class, "ADASolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getADASolution_ResolvedAccesses(), this.getResolvedAccess(), null, "resolvedAccesses", null, 1, -1, ADASolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getADASolution__IsBottom(), ecorePackage.getEBoolean(), "isBottom", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resolvedAccessEClass, ResolvedAccess.class, "ResolvedAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolvedAccess_ValidityDomain(), thePolymodelPackage.getDomain(), null, "validityDomain", null, 1, 1, ResolvedAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolvedAccess_IterationVector(), theAlgebraPackage.getIntExpression(), null, "iterationVector", null, 0, -1, ResolvedAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolvedAccess_Access(), this.getAccess(), null, "access", null, 0, 1, ResolvedAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getResolvedAccess__IsBottom(), ecorePackage.getEBoolean(), "isBottom", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DataflowPackageImpl
