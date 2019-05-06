/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.SchedulingFactory;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;
import org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingPackageImpl extends EPackageImpl implements SchedulingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduledStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementSchedulePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleCoefficientEClass = null;

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
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulingPackageImpl() {
		super(eNS_URI, SchedulingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SchedulingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulingPackage init() {
		if (isInited) return (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);

		// Obtain or create and register package
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PrdgPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StructuredPackageImpl theStructuredPackage = (StructuredPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI) instanceof StructuredPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI) : StructuredPackage.eINSTANCE);
		MultidimPackageImpl theMultidimPackage = (MultidimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI) instanceof MultidimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI) : MultidimPackage.eINSTANCE);

		// Create package meta-data objects
		theSchedulingPackage.createPackageContents();
		theStructuredPackage.createPackageContents();
		theMultidimPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulingPackage.initializePackageContents();
		theStructuredPackage.initializePackageContents();
		theMultidimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulingPackage.eNS_URI, theSchedulingPackage);
		return theSchedulingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduledStatement() {
		return scheduledStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduledStatement_Statement() {
		return (EReference)scheduledStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduledStatement_Schedule() {
		return (EReference)scheduledStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulePrototype() {
		return schedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulePrototype_Terms() {
		return (EReference)schedulePrototypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulePrototype_Coeficients() {
		return (EReference)schedulePrototypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulePrototype__Distribute() {
		return schedulePrototypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulePrototype__GetConstantTerm() {
		return schedulePrototypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulePrototype__Apply__Function() {
		return schedulePrototypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulePrototype__GetDomain() {
		return schedulePrototypeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulePrototype__GetScheduleIndices() {
		return schedulePrototypeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleTerm() {
		return scheduleTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleTerm_Var() {
		return (EReference)scheduleTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleTerm_Exp() {
		return (EReference)scheduleTermEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__IsConstant() {
		return scheduleTermEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__Distribute() {
		return scheduleTermEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__Apply__Function() {
		return scheduleTermEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__Negate() {
		return scheduleTermEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__Simplify() {
		return scheduleTermEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScheduleTerm__IsNull() {
		return scheduleTermEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_Source() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_Reference() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDependency__GetTerms__boolean() {
		return dependencyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDependency__GetCoefficientsContext() {
		return dependencyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementSchedulePrototype() {
		return statementSchedulePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatementSchedulePrototype_Statement() {
		return (EReference)statementSchedulePrototypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeDependency() {
		return edgeDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeDependency_Edge() {
		return (EReference)edgeDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEdgeDependency__IsUniform() {
		return edgeDependencyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleCoefficient() {
		return scheduleCoefficientEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleCoefficient_Owner() {
		return (EReference)scheduleCoefficientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleCoefficient_Dimension() {
		return (EAttribute)scheduleCoefficientEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactory getSchedulingFactory() {
		return (SchedulingFactory)getEFactoryInstance();
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
		scheduledStatementEClass = createEClass(SCHEDULED_STATEMENT);
		createEReference(scheduledStatementEClass, SCHEDULED_STATEMENT__STATEMENT);
		createEReference(scheduledStatementEClass, SCHEDULED_STATEMENT__SCHEDULE);

		schedulePrototypeEClass = createEClass(SCHEDULE_PROTOTYPE);
		createEReference(schedulePrototypeEClass, SCHEDULE_PROTOTYPE__TERMS);
		createEReference(schedulePrototypeEClass, SCHEDULE_PROTOTYPE__COEFICIENTS);
		createEOperation(schedulePrototypeEClass, SCHEDULE_PROTOTYPE___DISTRIBUTE);
		createEOperation(schedulePrototypeEClass, SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM);
		createEOperation(schedulePrototypeEClass, SCHEDULE_PROTOTYPE___APPLY__FUNCTION);
		createEOperation(schedulePrototypeEClass, SCHEDULE_PROTOTYPE___GET_DOMAIN);
		createEOperation(schedulePrototypeEClass, SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES);

		scheduleTermEClass = createEClass(SCHEDULE_TERM);
		createEReference(scheduleTermEClass, SCHEDULE_TERM__VAR);
		createEReference(scheduleTermEClass, SCHEDULE_TERM__EXP);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___IS_CONSTANT);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___DISTRIBUTE);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___APPLY__FUNCTION);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___NEGATE);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___SIMPLIFY);
		createEOperation(scheduleTermEClass, SCHEDULE_TERM___IS_NULL);

		dependencyEClass = createEClass(DEPENDENCY);
		createEReference(dependencyEClass, DEPENDENCY__SOURCE);
		createEReference(dependencyEClass, DEPENDENCY__REFERENCE);
		createEOperation(dependencyEClass, DEPENDENCY___GET_TERMS__BOOLEAN);
		createEOperation(dependencyEClass, DEPENDENCY___GET_COEFFICIENTS_CONTEXT);

		statementSchedulePrototypeEClass = createEClass(STATEMENT_SCHEDULE_PROTOTYPE);
		createEReference(statementSchedulePrototypeEClass, STATEMENT_SCHEDULE_PROTOTYPE__STATEMENT);

		edgeDependencyEClass = createEClass(EDGE_DEPENDENCY);
		createEReference(edgeDependencyEClass, EDGE_DEPENDENCY__EDGE);
		createEOperation(edgeDependencyEClass, EDGE_DEPENDENCY___IS_UNIFORM);

		scheduleCoefficientEClass = createEClass(SCHEDULE_COEFFICIENT);
		createEReference(scheduleCoefficientEClass, SCHEDULE_COEFFICIENT__OWNER);
		createEAttribute(scheduleCoefficientEClass, SCHEDULE_COEFFICIENT__DIMENSION);
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
		StructuredPackage theStructuredPackage = (StructuredPackage)EPackage.Registry.INSTANCE.getEPackage(StructuredPackage.eNS_URI);
		MultidimPackage theMultidimPackage = (MultidimPackage)EPackage.Registry.INSTANCE.getEPackage(MultidimPackage.eNS_URI);
		PrdgPackage thePrdgPackage = (PrdgPackage)EPackage.Registry.INSTANCE.getEPackage(PrdgPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		AffinePackage theAffinePackage = (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theStructuredPackage);
		getESubpackages().add(theMultidimPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		statementSchedulePrototypeEClass.getESuperTypes().add(this.getSchedulePrototype());
		edgeDependencyEClass.getESuperTypes().add(this.getDependency());
		scheduleCoefficientEClass.getESuperTypes().add(theAlgebraPackage.getVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(scheduledStatementEClass, ScheduledStatement.class, "ScheduledStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduledStatement_Statement(), thePrdgPackage.getPRDGNode(), null, "statement", null, 1, 1, ScheduledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledStatement_Schedule(), theAlgebraPackage.getIntExpression(), null, "schedule", null, 0, -1, ScheduledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulePrototypeEClass, SchedulePrototype.class, "SchedulePrototype", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulePrototype_Terms(), this.getScheduleTerm(), null, "terms", null, 0, -1, SchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulePrototype_Coeficients(), this.getScheduleCoefficient(), this.getScheduleCoefficient_Owner(), "coeficients", null, 0, -1, SchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSchedulePrototype__Distribute(), this.getScheduleTerm(), "distribute", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSchedulePrototype__GetConstantTerm(), this.getScheduleTerm(), "getConstantTerm", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getSchedulePrototype__Apply__Function(), this.getScheduleTerm(), "apply", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolymodelPackage.getFunction(), "mapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSchedulePrototype__GetDomain(), thePolymodelPackage.getDomain(), "getDomain", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSchedulePrototype__GetScheduleIndices(), theAlgebraPackage.getVariable(), "getScheduleIndices", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(scheduleTermEClass, ScheduleTerm.class, "ScheduleTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduleTerm_Var(), theAlgebraPackage.getVariable(), null, "var", null, 0, 1, ScheduleTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduleTerm_Exp(), theAffinePackage.getAffineExpression(), null, "exp", null, 0, 1, ScheduleTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScheduleTerm__IsConstant(), ecorePackage.getEBoolean(), "isConstant", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getScheduleTerm__Distribute(), this.getScheduleTerm(), "distribute", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScheduleTerm__Apply__Function(), this.getScheduleTerm(), "apply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolymodelPackage.getFunction(), "mapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getScheduleTerm__Negate(), this.getScheduleTerm(), "negate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getScheduleTerm__Simplify(), null, "simplify", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getScheduleTerm__IsNull(), ecorePackage.getEBoolean(), "isNull", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependency_Source(), this.getSchedulePrototype(), null, "source", null, 1, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Reference(), this.getSchedulePrototype(), null, "reference", null, 1, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDependency__GetTerms__boolean(), this.getScheduleTerm(), "getTerms", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "constantPart", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDependency__GetCoefficientsContext(), theAlgebraPackage.getIntConstraint(), "getCoefficientsContext", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(statementSchedulePrototypeEClass, StatementSchedulePrototype.class, "StatementSchedulePrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatementSchedulePrototype_Statement(), thePrdgPackage.getPRDGNode(), null, "statement", null, 1, 1, StatementSchedulePrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeDependencyEClass, EdgeDependency.class, "EdgeDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeDependency_Edge(), thePrdgPackage.getPRDGEdge(), null, "edge", null, 1, 1, EdgeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEdgeDependency__IsUniform(), ecorePackage.getEBoolean(), "isUniform", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scheduleCoefficientEClass, ScheduleCoefficient.class, "ScheduleCoefficient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduleCoefficient_Owner(), this.getSchedulePrototype(), this.getSchedulePrototype_Coeficients(), "owner", null, 0, 1, ScheduleCoefficient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduleCoefficient_Dimension(), ecorePackage.getEInt(), "dimension", null, 0, 1, ScheduleCoefficient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SchedulingPackageImpl
