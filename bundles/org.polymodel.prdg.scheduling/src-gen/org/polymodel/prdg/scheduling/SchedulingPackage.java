/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.algebra.AlgebraPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.SchedulingFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.prdg.scheduling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scheduling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingPackage eINSTANCE = org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.ScheduledStatementImpl <em>Scheduled Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.ScheduledStatementImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduledStatement()
	 * @generated
	 */
	int SCHEDULED_STATEMENT = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_STATEMENT__STATEMENT = 0;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_STATEMENT__SCHEDULE = 1;

	/**
	 * The number of structural features of the '<em>Scheduled Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_STATEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Scheduled Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl <em>Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getSchedulePrototype()
	 * @generated
	 */
	int SCHEDULE_PROTOTYPE = 1;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE__TERMS = 0;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE__COEFICIENTS = 1;

	/**
	 * The number of structural features of the '<em>Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE___DISTRIBUTE = 0;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = 1;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE___APPLY__FUNCTION = 2;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE___GET_DOMAIN = 3;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = 4;

	/**
	 * The number of operations of the '<em>Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PROTOTYPE_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.ScheduleTermImpl <em>Schedule Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.ScheduleTermImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduleTerm()
	 * @generated
	 */
	int SCHEDULE_TERM = 2;

	/**
	 * The feature id for the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM__VAR = 0;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM__EXP = 1;

	/**
	 * The number of structural features of the '<em>Schedule Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Is Constant</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___IS_CONSTANT = 0;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___DISTRIBUTE = 1;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___APPLY__FUNCTION = 2;

	/**
	 * The operation id for the '<em>Negate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___NEGATE = 3;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___SIMPLIFY = 4;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM___IS_NULL = 5;

	/**
	 * The number of operations of the '<em>Schedule Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TERM_OPERATION_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.DependencyImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__REFERENCE = 1;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 2;


	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_TERMS__BOOLEAN = 0;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_COEFFICIENTS_CONTEXT = 1;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl <em>Statement Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getStatementSchedulePrototype()
	 * @generated
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE = 4;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE__TERMS = SCHEDULE_PROTOTYPE__TERMS;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE__COEFICIENTS = SCHEDULE_PROTOTYPE__COEFICIENTS;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE__STATEMENT = SCHEDULE_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Statement Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE_FEATURE_COUNT = SCHEDULE_PROTOTYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE___DISTRIBUTE = SCHEDULE_PROTOTYPE___DISTRIBUTE;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE___APPLY__FUNCTION = SCHEDULE_PROTOTYPE___APPLY__FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE___GET_DOMAIN = SCHEDULE_PROTOTYPE___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES;

	/**
	 * The number of operations of the '<em>Statement Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCHEDULE_PROTOTYPE_OPERATION_COUNT = SCHEDULE_PROTOTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl <em>Edge Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getEdgeDependency()
	 * @generated
	 */
	int EDGE_DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY__SOURCE = DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY__REFERENCE = DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY__EDGE = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY___GET_TERMS__BOOLEAN = DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Is Uniform</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY___IS_UNIFORM = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEPENDENCY_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.impl.ScheduleCoefficientImpl <em>Schedule Coefficient</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.impl.ScheduleCoefficientImpl
	 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduleCoefficient()
	 * @generated
	 */
	int SCHEDULE_COEFFICIENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT__NAME = AlgebraPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT__OWNER = AlgebraPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT__DIMENSION = AlgebraPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Schedule Coefficient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT_FEATURE_COUNT = AlgebraPackage.VARIABLE_FEATURE_COUNT + 2;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.VARIABLE___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The number of operations of the '<em>Schedule Coefficient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_COEFFICIENT_OPERATION_COUNT = AlgebraPackage.VARIABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.ScheduledStatement <em>Scheduled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduled Statement</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduledStatement
	 * @generated
	 */
	EClass getScheduledStatement();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.ScheduledStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Statement</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduledStatement#getStatement()
	 * @see #getScheduledStatement()
	 * @generated
	 */
	EReference getScheduledStatement_Statement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.ScheduledStatement#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schedule</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduledStatement#getSchedule()
	 * @see #getScheduledStatement()
	 * @generated
	 */
	EReference getScheduledStatement_Schedule();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.SchedulePrototype <em>Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype
	 * @generated
	 */
	EClass getSchedulePrototype();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getTerms()
	 * @see #getSchedulePrototype()
	 * @generated
	 */
	EReference getSchedulePrototype_Terms();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getCoeficients <em>Coeficients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Coeficients</em>'.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getCoeficients()
	 * @see #getSchedulePrototype()
	 * @generated
	 */
	EReference getSchedulePrototype_Coeficients();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.SchedulePrototype#distribute() <em>Distribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Distribute</em>' operation.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#distribute()
	 * @generated
	 */
	EOperation getSchedulePrototype__Distribute();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getConstantTerm() <em>Get Constant Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Constant Term</em>' operation.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getConstantTerm()
	 * @generated
	 */
	EOperation getSchedulePrototype__GetConstantTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.SchedulePrototype#apply(org.polymodel.Function) <em>Apply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Apply</em>' operation.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#apply(org.polymodel.Function)
	 * @generated
	 */
	EOperation getSchedulePrototype__Apply__Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getDomain() <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain</em>' operation.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getDomain()
	 * @generated
	 */
	EOperation getSchedulePrototype__GetDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getScheduleIndices() <em>Get Schedule Indices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Schedule Indices</em>' operation.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getScheduleIndices()
	 * @generated
	 */
	EOperation getSchedulePrototype__GetScheduleIndices();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.ScheduleTerm <em>Schedule Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Term</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm
	 * @generated
	 */
	EClass getScheduleTerm();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.ScheduleTerm#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#getVar()
	 * @see #getScheduleTerm()
	 * @generated
	 */
	EReference getScheduleTerm_Var();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.ScheduleTerm#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exp</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#getExp()
	 * @see #getScheduleTerm()
	 * @generated
	 */
	EReference getScheduleTerm_Exp();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#isConstant() <em>Is Constant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Constant</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#isConstant()
	 * @generated
	 */
	EOperation getScheduleTerm__IsConstant();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#distribute() <em>Distribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Distribute</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#distribute()
	 * @generated
	 */
	EOperation getScheduleTerm__Distribute();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#apply(org.polymodel.Function) <em>Apply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Apply</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#apply(org.polymodel.Function)
	 * @generated
	 */
	EOperation getScheduleTerm__Apply__Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#negate() <em>Negate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Negate</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#negate()
	 * @generated
	 */
	EOperation getScheduleTerm__Negate();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#simplify()
	 * @generated
	 */
	EOperation getScheduleTerm__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Null</em>' operation.
	 * @see org.polymodel.prdg.scheduling.ScheduleTerm#isNull()
	 * @generated
	 */
	EOperation getScheduleTerm__IsNull();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.Dependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.polymodel.prdg.scheduling.Dependency#getSource()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Source();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.Dependency#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.polymodel.prdg.scheduling.Dependency#getReference()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Reference();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.Dependency#getTerms(boolean) <em>Get Terms</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Terms</em>' operation.
	 * @see org.polymodel.prdg.scheduling.Dependency#getTerms(boolean)
	 * @generated
	 */
	EOperation getDependency__GetTerms__boolean();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.Dependency#getCoefficientsContext() <em>Get Coefficients Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Coefficients Context</em>' operation.
	 * @see org.polymodel.prdg.scheduling.Dependency#getCoefficientsContext()
	 * @generated
	 */
	EOperation getDependency__GetCoefficientsContext();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.StatementSchedulePrototype <em>Statement Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.StatementSchedulePrototype
	 * @generated
	 */
	EClass getStatementSchedulePrototype();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.StatementSchedulePrototype#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Statement</em>'.
	 * @see org.polymodel.prdg.scheduling.StatementSchedulePrototype#getStatement()
	 * @see #getStatementSchedulePrototype()
	 * @generated
	 */
	EReference getStatementSchedulePrototype_Statement();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.EdgeDependency <em>Edge Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.EdgeDependency
	 * @generated
	 */
	EClass getEdgeDependency();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.EdgeDependency#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge</em>'.
	 * @see org.polymodel.prdg.scheduling.EdgeDependency#getEdge()
	 * @see #getEdgeDependency()
	 * @generated
	 */
	EReference getEdgeDependency_Edge();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.EdgeDependency#isUniform() <em>Is Uniform</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Uniform</em>' operation.
	 * @see org.polymodel.prdg.scheduling.EdgeDependency#isUniform()
	 * @generated
	 */
	EOperation getEdgeDependency__IsUniform();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient <em>Schedule Coefficient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Coefficient</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleCoefficient
	 * @generated
	 */
	EClass getScheduleCoefficient();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner()
	 * @see #getScheduleCoefficient()
	 * @generated
	 */
	EReference getScheduleCoefficient_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.polymodel.prdg.scheduling.ScheduleCoefficient#getDimension()
	 * @see #getScheduleCoefficient()
	 * @generated
	 */
	EAttribute getScheduleCoefficient_Dimension();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulingFactory getSchedulingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.ScheduledStatementImpl <em>Scheduled Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.ScheduledStatementImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduledStatement()
		 * @generated
		 */
		EClass SCHEDULED_STATEMENT = eINSTANCE.getScheduledStatement();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_STATEMENT__STATEMENT = eINSTANCE.getScheduledStatement_Statement();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_STATEMENT__SCHEDULE = eINSTANCE.getScheduledStatement_Schedule();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl <em>Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getSchedulePrototype()
		 * @generated
		 */
		EClass SCHEDULE_PROTOTYPE = eINSTANCE.getSchedulePrototype();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_PROTOTYPE__TERMS = eINSTANCE.getSchedulePrototype_Terms();

		/**
		 * The meta object literal for the '<em><b>Coeficients</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_PROTOTYPE__COEFICIENTS = eINSTANCE.getSchedulePrototype_Coeficients();

		/**
		 * The meta object literal for the '<em><b>Distribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_PROTOTYPE___DISTRIBUTE = eINSTANCE.getSchedulePrototype__Distribute();

		/**
		 * The meta object literal for the '<em><b>Get Constant Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = eINSTANCE.getSchedulePrototype__GetConstantTerm();

		/**
		 * The meta object literal for the '<em><b>Apply</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_PROTOTYPE___APPLY__FUNCTION = eINSTANCE.getSchedulePrototype__Apply__Function();

		/**
		 * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_PROTOTYPE___GET_DOMAIN = eINSTANCE.getSchedulePrototype__GetDomain();

		/**
		 * The meta object literal for the '<em><b>Get Schedule Indices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = eINSTANCE.getSchedulePrototype__GetScheduleIndices();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.ScheduleTermImpl <em>Schedule Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.ScheduleTermImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduleTerm()
		 * @generated
		 */
		EClass SCHEDULE_TERM = eINSTANCE.getScheduleTerm();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_TERM__VAR = eINSTANCE.getScheduleTerm_Var();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_TERM__EXP = eINSTANCE.getScheduleTerm_Exp();

		/**
		 * The meta object literal for the '<em><b>Is Constant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___IS_CONSTANT = eINSTANCE.getScheduleTerm__IsConstant();

		/**
		 * The meta object literal for the '<em><b>Distribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___DISTRIBUTE = eINSTANCE.getScheduleTerm__Distribute();

		/**
		 * The meta object literal for the '<em><b>Apply</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___APPLY__FUNCTION = eINSTANCE.getScheduleTerm__Apply__Function();

		/**
		 * The meta object literal for the '<em><b>Negate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___NEGATE = eINSTANCE.getScheduleTerm__Negate();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___SIMPLIFY = eINSTANCE.getScheduleTerm__Simplify();

		/**
		 * The meta object literal for the '<em><b>Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULE_TERM___IS_NULL = eINSTANCE.getScheduleTerm__IsNull();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.DependencyImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__SOURCE = eINSTANCE.getDependency_Source();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__REFERENCE = eINSTANCE.getDependency_Reference();

		/**
		 * The meta object literal for the '<em><b>Get Terms</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEPENDENCY___GET_TERMS__BOOLEAN = eINSTANCE.getDependency__GetTerms__boolean();

		/**
		 * The meta object literal for the '<em><b>Get Coefficients Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEPENDENCY___GET_COEFFICIENTS_CONTEXT = eINSTANCE.getDependency__GetCoefficientsContext();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl <em>Statement Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getStatementSchedulePrototype()
		 * @generated
		 */
		EClass STATEMENT_SCHEDULE_PROTOTYPE = eINSTANCE.getStatementSchedulePrototype();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT_SCHEDULE_PROTOTYPE__STATEMENT = eINSTANCE.getStatementSchedulePrototype_Statement();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl <em>Edge Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getEdgeDependency()
		 * @generated
		 */
		EClass EDGE_DEPENDENCY = eINSTANCE.getEdgeDependency();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_DEPENDENCY__EDGE = eINSTANCE.getEdgeDependency_Edge();

		/**
		 * The meta object literal for the '<em><b>Is Uniform</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_DEPENDENCY___IS_UNIFORM = eINSTANCE.getEdgeDependency__IsUniform();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.impl.ScheduleCoefficientImpl <em>Schedule Coefficient</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.impl.ScheduleCoefficientImpl
		 * @see org.polymodel.prdg.scheduling.impl.SchedulingPackageImpl#getScheduleCoefficient()
		 * @generated
		 */
		EClass SCHEDULE_COEFFICIENT = eINSTANCE.getScheduleCoefficient();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_COEFFICIENT__OWNER = eINSTANCE.getScheduleCoefficient_Owner();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_COEFFICIENT__DIMENSION = eINSTANCE.getScheduleCoefficient_Dimension();

	}

} //SchedulingPackage
