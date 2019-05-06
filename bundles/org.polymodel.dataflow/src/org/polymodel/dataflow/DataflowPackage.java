/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.polymodel.dataflow.DataflowFactory
 * @model kind="package"
 * @generated
 */
public interface DataflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymlodel.dataflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dataflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataflowPackage eINSTANCE = org.polymodel.dataflow.impl.DataflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.ADAInput <em>ADA Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.ADAInput
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADAInput()
	 * @generated
	 */
	int ADA_INPUT = 0;

	/**
	 * The feature id for the '<em><b>Ada Statements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT__ADA_STATEMENTS = 0;

	/**
	 * The number of structural features of the '<em>ADA Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Dimensions Manager</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT___GET_DIMENSIONS_MANAGER = 0;

	/**
	 * The operation id for the '<em>Get Statement By ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT___GET_STATEMENT_BY_ID__INT = 1;

	/**
	 * The operation id for the '<em>Is Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT___IS_RESOLVED = 2;

	/**
	 * The number of operations of the '<em>ADA Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_INPUT_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.ADAStatement <em>ADA Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.ADAStatement
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADAStatement()
	 * @generated
	 */
	int ADA_STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Writes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT__WRITES = 1;

	/**
	 * The feature id for the '<em><b>Reads</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT__READS = 2;

	/**
	 * The feature id for the '<em><b>Parent ADA Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT__PARENT_ADA_INPUT = 3;

	/**
	 * The number of structural features of the '<em>ADA Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT___GET_DOMAIN = 0;

	/**
	 * The operation id for the '<em>Get ID Schedule</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT___GET_ID_SCHEDULE = 1;

	/**
	 * The operation id for the '<em>Is Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT___IS_RESOLVED = 2;

	/**
	 * The number of operations of the '<em>ADA Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_STATEMENT_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.ReadAccess <em>Read Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.ReadAccess
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getReadAccess()
	 * @generated
	 */
	int READ_ACCESS = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.WriteAccess <em>Write Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.WriteAccess
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getWriteAccess()
	 * @generated
	 */
	int WRITE_ACCESS = 4;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.Access <em>Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.Access
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getAccess()
	 * @generated
	 */
	int ACCESS = 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__INDEX = 0;

	/**
	 * The number of structural features of the '<em>Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Access Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS___GET_ACCESS_ID = 0;

	/**
	 * The operation id for the '<em>Get Parent ADA Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS___GET_PARENT_ADA_STATEMENT = 1;

	/**
	 * The operation id for the '<em>Is Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS___IS_RESOLVED = 2;

	/**
	 * The number of operations of the '<em>Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_OPERATION_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS__INDEX = ACCESS__INDEX;

	/**
	 * The feature id for the '<em><b>Parent ADA Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS__PARENT_ADA_STATEMENT = ACCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Write</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS__LAST_WRITE = ACCESS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Read Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS_FEATURE_COUNT = ACCESS_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Access Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS___GET_ACCESS_ID = ACCESS___GET_ACCESS_ID;

	/**
	 * The operation id for the '<em>Get Parent ADA Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS___GET_PARENT_ADA_STATEMENT = ACCESS___GET_PARENT_ADA_STATEMENT;

	/**
	 * The operation id for the '<em>Is Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS___IS_RESOLVED = ACCESS___IS_RESOLVED;

	/**
	 * The operation id for the '<em>Get All Write Candidates</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS___GET_ALL_WRITE_CANDIDATES = ACCESS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Read Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ACCESS_OPERATION_COUNT = ACCESS_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS__INDEX = ACCESS__INDEX;

	/**
	 * The feature id for the '<em><b>Parent ADA Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS__PARENT_ADA_STATEMENT = ACCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Write Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS_FEATURE_COUNT = ACCESS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Access Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS___GET_ACCESS_ID = ACCESS___GET_ACCESS_ID;

	/**
	 * The operation id for the '<em>Get Parent ADA Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS___GET_PARENT_ADA_STATEMENT = ACCESS___GET_PARENT_ADA_STATEMENT;

	/**
	 * The operation id for the '<em>Is Resolved</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS___IS_RESOLVED = ACCESS___IS_RESOLVED;

	/**
	 * The operation id for the '<em>Get All Read Candidates</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS___GET_ALL_READ_CANDIDATES = ACCESS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Write Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_ACCESS_OPERATION_COUNT = ACCESS_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.impl.ADASolutionImpl <em>ADA Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.impl.ADASolutionImpl
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADASolution()
	 * @generated
	 */
	int ADA_SOLUTION = 5;

	/**
	 * The feature id for the '<em><b>Resolved Accesses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_SOLUTION__RESOLVED_ACCESSES = 0;

	/**
	 * The number of structural features of the '<em>ADA Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_SOLUTION_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Is Bottom</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_SOLUTION___IS_BOTTOM = 0;

	/**
	 * The number of operations of the '<em>ADA Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADA_SOLUTION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.dataflow.impl.ResolvedAccessImpl <em>Resolved Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.dataflow.impl.ResolvedAccessImpl
	 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getResolvedAccess()
	 * @generated
	 */
	int RESOLVED_ACCESS = 6;

	/**
	 * The feature id for the '<em><b>Validity Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS__VALIDITY_DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Iteration Vector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS__ITERATION_VECTOR = 1;

	/**
	 * The feature id for the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS__ACCESS = 2;

	/**
	 * The number of structural features of the '<em>Resolved Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS_FEATURE_COUNT = 3;


	/**
	 * The operation id for the '<em>Is Bottom</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS___IS_BOTTOM = 0;

	/**
	 * The number of operations of the '<em>Resolved Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVED_ACCESS_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.ADAInput <em>ADA Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ADA Input</em>'.
	 * @see org.polymodel.dataflow.ADAInput
	 * @generated
	 */
	EClass getADAInput();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.dataflow.ADAInput#getAdaStatements <em>Ada Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ada Statements</em>'.
	 * @see org.polymodel.dataflow.ADAInput#getAdaStatements()
	 * @see #getADAInput()
	 * @generated
	 */
	EReference getADAInput_AdaStatements();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAInput#getDimensionsManager() <em>Get Dimensions Manager</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dimensions Manager</em>' operation.
	 * @see org.polymodel.dataflow.ADAInput#getDimensionsManager()
	 * @generated
	 */
	EOperation getADAInput__GetDimensionsManager();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAInput#getStatementByID(int) <em>Get Statement By ID</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statement By ID</em>' operation.
	 * @see org.polymodel.dataflow.ADAInput#getStatementByID(int)
	 * @generated
	 */
	EOperation getADAInput__GetStatementByID__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAInput#isResolved() <em>Is Resolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Resolved</em>' operation.
	 * @see org.polymodel.dataflow.ADAInput#isResolved()
	 * @generated
	 */
	EOperation getADAInput__IsResolved();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.ADAStatement <em>ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ADA Statement</em>'.
	 * @see org.polymodel.dataflow.ADAStatement
	 * @generated
	 */
	EClass getADAStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.dataflow.ADAStatement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polymodel.dataflow.ADAStatement#getId()
	 * @see #getADAStatement()
	 * @generated
	 */
	EAttribute getADAStatement_Id();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.dataflow.ADAStatement#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Writes</em>'.
	 * @see org.polymodel.dataflow.ADAStatement#getWrites()
	 * @see #getADAStatement()
	 * @generated
	 */
	EReference getADAStatement_Writes();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.dataflow.ADAStatement#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reads</em>'.
	 * @see org.polymodel.dataflow.ADAStatement#getReads()
	 * @see #getADAStatement()
	 * @generated
	 */
	EReference getADAStatement_Reads();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.dataflow.ADAStatement#getParentADAInput <em>Parent ADA Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent ADA Input</em>'.
	 * @see org.polymodel.dataflow.ADAStatement#getParentADAInput()
	 * @see #getADAStatement()
	 * @generated
	 */
	EReference getADAStatement_ParentADAInput();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAStatement#getDomain() <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain</em>' operation.
	 * @see org.polymodel.dataflow.ADAStatement#getDomain()
	 * @generated
	 */
	EOperation getADAStatement__GetDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAStatement#getIDSchedule() <em>Get ID Schedule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get ID Schedule</em>' operation.
	 * @see org.polymodel.dataflow.ADAStatement#getIDSchedule()
	 * @generated
	 */
	EOperation getADAStatement__GetIDSchedule();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADAStatement#isResolved() <em>Is Resolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Resolved</em>' operation.
	 * @see org.polymodel.dataflow.ADAStatement#isResolved()
	 * @generated
	 */
	EOperation getADAStatement__IsResolved();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.ReadAccess <em>Read Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Access</em>'.
	 * @see org.polymodel.dataflow.ReadAccess
	 * @generated
	 */
	EClass getReadAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.dataflow.ReadAccess#getLastWrite <em>Last Write</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last Write</em>'.
	 * @see org.polymodel.dataflow.ReadAccess#getLastWrite()
	 * @see #getReadAccess()
	 * @generated
	 */
	EReference getReadAccess_LastWrite();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ReadAccess#getAllWriteCandidates() <em>Get All Write Candidates</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Write Candidates</em>' operation.
	 * @see org.polymodel.dataflow.ReadAccess#getAllWriteCandidates()
	 * @generated
	 */
	EOperation getReadAccess__GetAllWriteCandidates();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.dataflow.ReadAccess#getParentADAStatement <em>Parent ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent ADA Statement</em>'.
	 * @see org.polymodel.dataflow.ReadAccess#getParentADAStatement()
	 * @see #getReadAccess()
	 * @generated
	 */
	EReference getReadAccess_ParentADAStatement();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.WriteAccess <em>Write Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Access</em>'.
	 * @see org.polymodel.dataflow.WriteAccess
	 * @generated
	 */
	EClass getWriteAccess();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.ADASolution <em>ADA Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ADA Solution</em>'.
	 * @see org.polymodel.dataflow.ADASolution
	 * @generated
	 */
	EClass getADASolution();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.dataflow.ADASolution#getResolvedAccesses <em>Resolved Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolved Accesses</em>'.
	 * @see org.polymodel.dataflow.ADASolution#getResolvedAccesses()
	 * @see #getADASolution()
	 * @generated
	 */
	EReference getADASolution_ResolvedAccesses();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ADASolution#isBottom() <em>Is Bottom</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Bottom</em>' operation.
	 * @see org.polymodel.dataflow.ADASolution#isBottom()
	 * @generated
	 */
	EOperation getADASolution__IsBottom();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.dataflow.WriteAccess#getParentADAStatement <em>Parent ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent ADA Statement</em>'.
	 * @see org.polymodel.dataflow.WriteAccess#getParentADAStatement()
	 * @see #getWriteAccess()
	 * @generated
	 */
	EReference getWriteAccess_ParentADAStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.WriteAccess#getAllReadCandidates() <em>Get All Read Candidates</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Read Candidates</em>' operation.
	 * @see org.polymodel.dataflow.WriteAccess#getAllReadCandidates()
	 * @generated
	 */
	EOperation getWriteAccess__GetAllReadCandidates();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access</em>'.
	 * @see org.polymodel.dataflow.Access
	 * @generated
	 */
	EClass getAccess();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.dataflow.Access#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Index</em>'.
	 * @see org.polymodel.dataflow.Access#getIndex()
	 * @see #getAccess()
	 * @generated
	 */
	EReference getAccess_Index();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.Access#getAccessId() <em>Get Access Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Access Id</em>' operation.
	 * @see org.polymodel.dataflow.Access#getAccessId()
	 * @generated
	 */
	EOperation getAccess__GetAccessId();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.Access#getParentADAStatement() <em>Get Parent ADA Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parent ADA Statement</em>' operation.
	 * @see org.polymodel.dataflow.Access#getParentADAStatement()
	 * @generated
	 */
	EOperation getAccess__GetParentADAStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.Access#isResolved() <em>Is Resolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Resolved</em>' operation.
	 * @see org.polymodel.dataflow.Access#isResolved()
	 * @generated
	 */
	EOperation getAccess__IsResolved();

	/**
	 * Returns the meta object for class '{@link org.polymodel.dataflow.ResolvedAccess <em>Resolved Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolved Access</em>'.
	 * @see org.polymodel.dataflow.ResolvedAccess
	 * @generated
	 */
	EClass getResolvedAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.dataflow.ResolvedAccess#getValidityDomain <em>Validity Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validity Domain</em>'.
	 * @see org.polymodel.dataflow.ResolvedAccess#getValidityDomain()
	 * @see #getResolvedAccess()
	 * @generated
	 */
	EReference getResolvedAccess_ValidityDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.dataflow.ResolvedAccess#getIterationVector <em>Iteration Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iteration Vector</em>'.
	 * @see org.polymodel.dataflow.ResolvedAccess#getIterationVector()
	 * @see #getResolvedAccess()
	 * @generated
	 */
	EReference getResolvedAccess_IterationVector();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.dataflow.ResolvedAccess#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Access</em>'.
	 * @see org.polymodel.dataflow.ResolvedAccess#getAccess()
	 * @see #getResolvedAccess()
	 * @generated
	 */
	EReference getResolvedAccess_Access();

	/**
	 * Returns the meta object for the '{@link org.polymodel.dataflow.ResolvedAccess#isBottom() <em>Is Bottom</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Bottom</em>' operation.
	 * @see org.polymodel.dataflow.ResolvedAccess#isBottom()
	 * @generated
	 */
	EOperation getResolvedAccess__IsBottom();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataflowFactory getDataflowFactory();

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
		 * The meta object literal for the '{@link org.polymodel.dataflow.ADAInput <em>ADA Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.ADAInput
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADAInput()
		 * @generated
		 */
		EClass ADA_INPUT = eINSTANCE.getADAInput();

		/**
		 * The meta object literal for the '<em><b>Ada Statements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADA_INPUT__ADA_STATEMENTS = eINSTANCE.getADAInput_AdaStatements();

		/**
		 * The meta object literal for the '<em><b>Get Dimensions Manager</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_INPUT___GET_DIMENSIONS_MANAGER = eINSTANCE.getADAInput__GetDimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Get Statement By ID</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_INPUT___GET_STATEMENT_BY_ID__INT = eINSTANCE.getADAInput__GetStatementByID__int();

		/**
		 * The meta object literal for the '<em><b>Is Resolved</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_INPUT___IS_RESOLVED = eINSTANCE.getADAInput__IsResolved();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.ADAStatement <em>ADA Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.ADAStatement
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADAStatement()
		 * @generated
		 */
		EClass ADA_STATEMENT = eINSTANCE.getADAStatement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADA_STATEMENT__ID = eINSTANCE.getADAStatement_Id();

		/**
		 * The meta object literal for the '<em><b>Writes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADA_STATEMENT__WRITES = eINSTANCE.getADAStatement_Writes();

		/**
		 * The meta object literal for the '<em><b>Reads</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADA_STATEMENT__READS = eINSTANCE.getADAStatement_Reads();

		/**
		 * The meta object literal for the '<em><b>Parent ADA Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADA_STATEMENT__PARENT_ADA_INPUT = eINSTANCE.getADAStatement_ParentADAInput();

		/**
		 * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_STATEMENT___GET_DOMAIN = eINSTANCE.getADAStatement__GetDomain();

		/**
		 * The meta object literal for the '<em><b>Get ID Schedule</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_STATEMENT___GET_ID_SCHEDULE = eINSTANCE.getADAStatement__GetIDSchedule();

		/**
		 * The meta object literal for the '<em><b>Is Resolved</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_STATEMENT___IS_RESOLVED = eINSTANCE.getADAStatement__IsResolved();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.ReadAccess <em>Read Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.ReadAccess
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getReadAccess()
		 * @generated
		 */
		EClass READ_ACCESS = eINSTANCE.getReadAccess();

		/**
		 * The meta object literal for the '<em><b>Last Write</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READ_ACCESS__LAST_WRITE = eINSTANCE.getReadAccess_LastWrite();

		/**
		 * The meta object literal for the '<em><b>Get All Write Candidates</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation READ_ACCESS___GET_ALL_WRITE_CANDIDATES = eINSTANCE.getReadAccess__GetAllWriteCandidates();

		/**
		 * The meta object literal for the '<em><b>Parent ADA Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READ_ACCESS__PARENT_ADA_STATEMENT = eINSTANCE.getReadAccess_ParentADAStatement();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.WriteAccess <em>Write Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.WriteAccess
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getWriteAccess()
		 * @generated
		 */
		EClass WRITE_ACCESS = eINSTANCE.getWriteAccess();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.impl.ADASolutionImpl <em>ADA Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.impl.ADASolutionImpl
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getADASolution()
		 * @generated
		 */
		EClass ADA_SOLUTION = eINSTANCE.getADASolution();

		/**
		 * The meta object literal for the '<em><b>Resolved Accesses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADA_SOLUTION__RESOLVED_ACCESSES = eINSTANCE.getADASolution_ResolvedAccesses();

		/**
		 * The meta object literal for the '<em><b>Is Bottom</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADA_SOLUTION___IS_BOTTOM = eINSTANCE.getADASolution__IsBottom();

		/**
		 * The meta object literal for the '<em><b>Parent ADA Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_ACCESS__PARENT_ADA_STATEMENT = eINSTANCE.getWriteAccess_ParentADAStatement();

		/**
		 * The meta object literal for the '<em><b>Get All Read Candidates</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WRITE_ACCESS___GET_ALL_READ_CANDIDATES = eINSTANCE.getWriteAccess__GetAllReadCandidates();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.Access <em>Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.Access
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getAccess()
		 * @generated
		 */
		EClass ACCESS = eINSTANCE.getAccess();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS__INDEX = eINSTANCE.getAccess_Index();

		/**
		 * The meta object literal for the '<em><b>Get Access Id</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESS___GET_ACCESS_ID = eINSTANCE.getAccess__GetAccessId();

		/**
		 * The meta object literal for the '<em><b>Get Parent ADA Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESS___GET_PARENT_ADA_STATEMENT = eINSTANCE.getAccess__GetParentADAStatement();

		/**
		 * The meta object literal for the '<em><b>Is Resolved</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACCESS___IS_RESOLVED = eINSTANCE.getAccess__IsResolved();

		/**
		 * The meta object literal for the '{@link org.polymodel.dataflow.impl.ResolvedAccessImpl <em>Resolved Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.dataflow.impl.ResolvedAccessImpl
		 * @see org.polymodel.dataflow.impl.DataflowPackageImpl#getResolvedAccess()
		 * @generated
		 */
		EClass RESOLVED_ACCESS = eINSTANCE.getResolvedAccess();

		/**
		 * The meta object literal for the '<em><b>Validity Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVED_ACCESS__VALIDITY_DOMAIN = eINSTANCE.getResolvedAccess_ValidityDomain();

		/**
		 * The meta object literal for the '<em><b>Iteration Vector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVED_ACCESS__ITERATION_VECTOR = eINSTANCE.getResolvedAccess_IterationVector();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVED_ACCESS__ACCESS = eINSTANCE.getResolvedAccess_Access();

		/**
		 * The meta object literal for the '<em><b>Is Bottom</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESOLVED_ACCESS___IS_BOTTOM = eINSTANCE.getResolvedAccess__IsBottom();

	}

} //DataflowPackage
