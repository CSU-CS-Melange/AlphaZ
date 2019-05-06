/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

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
 * @see org.polymodel.prdg.PrdgFactory
 * @model kind="package"
 * @generated
 */
public interface PrdgPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "prdg";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polymodel.org/prdg";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "prdg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrdgPackage eINSTANCE = org.polymodel.prdg.impl.PrdgPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.PRDGNodeImpl <em>PRDG Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.PRDGNodeImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGNode()
	 * @generated
	 */
	int PRDG_NODE = 0;

	/**
	 * The feature id for the '<em><b>Prdg</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE__PRDG = 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE__DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE__NAME = 2;

	/**
	 * The number of structural features of the '<em>PRDG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Destinations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE___GET_DESTINATIONS = 0;

	/**
	 * The operation id for the '<em>Get Sources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE___GET_SOURCES = 1;

	/**
	 * The number of operations of the '<em>PRDG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_NODE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.PRDGEdgeImpl <em>PRDG Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.PRDGEdgeImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGEdge()
	 * @generated
	 */
	int PRDG_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE__DOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE__FUNCTION = 3;

	/**
	 * The number of structural features of the '<em>PRDG Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>To Edge Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE___TO_EDGE_RELATION__DIMENSIONSMANAGER = 0;

	/**
	 * The number of operations of the '<em>PRDG Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_EDGE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.PRDGImpl <em>PRDG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.PRDGImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDG()
	 * @generated
	 */
	int PRDG = 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG__NODES = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG__EDGES = 1;

	/**
	 * The feature id for the '<em><b>Hedges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG__HEDGES = 2;

	/**
	 * The number of structural features of the '<em>PRDG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG___GET_NODE__STRING = 0;

	/**
	 * The number of operations of the '<em>PRDG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.EdgeFunctionImpl <em>Edge Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.EdgeFunctionImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getEdgeFunction()
	 * @generated
	 */
	int EDGE_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FUNCTION__MAPPING = 0;

	/**
	 * The number of structural features of the '<em>Edge Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FUNCTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Edge Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.ProjectionFunctionImpl <em>Projection Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.ProjectionFunctionImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getProjectionFunction()
	 * @generated
	 */
	int PROJECTION_FUNCTION = 4;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECTION_FUNCTION__MAPPING = EDGE_FUNCTION__MAPPING;

	/**
	 * The number of structural features of the '<em>Projection Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECTION_FUNCTION_FEATURE_COUNT = EDGE_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Projection Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECTION_FUNCTION_OPERATION_COUNT = EDGE_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.DependenceFunctionImpl <em>Dependence Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.DependenceFunctionImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getDependenceFunction()
	 * @generated
	 */
	int DEPENDENCE_FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_FUNCTION__MAPPING = EDGE_FUNCTION__MAPPING;

	/**
	 * The number of structural features of the '<em>Dependence Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_FUNCTION_FEATURE_COUNT = EDGE_FUNCTION_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Is Uniform</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_FUNCTION___IS_UNIFORM = EDGE_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dependence Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_FUNCTION_OPERATION_COUNT = EDGE_FUNCTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl <em>PRDG Sub System Hyper Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl
	 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGSubSystemHyperEdge()
	 * @generated
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE = 6;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES = 0;

	/**
	 * The feature id for the '<em><b>Destinations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS = 1;

	/**
	 * The feature id for the '<em><b>Ext Dom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM = 2;

	/**
	 * The feature id for the '<em><b>Params</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS = 3;

	/**
	 * The number of structural features of the '<em>PRDG Sub System Hyper Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE_FEATURE_COUNT = 4;


	/**
	 * The number of operations of the '<em>PRDG Sub System Hyper Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRDG_SUB_SYSTEM_HYPER_EDGE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.PRDGNode <em>PRDG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PRDG Node</em>'.
	 * @see org.polymodel.prdg.PRDGNode
	 * @generated
	 */
	EClass getPRDGNode();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.prdg.PRDGNode#getPrdg <em>Prdg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Prdg</em>'.
	 * @see org.polymodel.prdg.PRDGNode#getPrdg()
	 * @see #getPRDGNode()
	 * @generated
	 */
	EReference getPRDGNode_Prdg();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.PRDGNode#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.prdg.PRDGNode#getDomain()
	 * @see #getPRDGNode()
	 * @generated
	 */
	EReference getPRDGNode_Domain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.PRDGNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.prdg.PRDGNode#getName()
	 * @see #getPRDGNode()
	 * @generated
	 */
	EAttribute getPRDGNode_Name();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.PRDGNode#getDestinations() <em>Get Destinations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Destinations</em>' operation.
	 * @see org.polymodel.prdg.PRDGNode#getDestinations()
	 * @generated
	 */
	EOperation getPRDGNode__GetDestinations();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.PRDGNode#getSources() <em>Get Sources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Sources</em>' operation.
	 * @see org.polymodel.prdg.PRDGNode#getSources()
	 * @generated
	 */
	EOperation getPRDGNode__GetSources();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.PRDGEdge <em>PRDG Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PRDG Edge</em>'.
	 * @see org.polymodel.prdg.PRDGEdge
	 * @generated
	 */
	EClass getPRDGEdge();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.PRDGEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.polymodel.prdg.PRDGEdge#getSource()
	 * @see #getPRDGEdge()
	 * @generated
	 */
	EReference getPRDGEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.PRDGEdge#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.polymodel.prdg.PRDGEdge#getDestination()
	 * @see #getPRDGEdge()
	 * @generated
	 */
	EReference getPRDGEdge_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.PRDGEdge#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.prdg.PRDGEdge#getDomain()
	 * @see #getPRDGEdge()
	 * @generated
	 */
	EReference getPRDGEdge_Domain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.PRDGEdge#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see org.polymodel.prdg.PRDGEdge#getFunction()
	 * @see #getPRDGEdge()
	 * @generated
	 */
	EReference getPRDGEdge_Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.PRDGEdge#toEdgeRelation(org.polymodel.DimensionsManager) <em>To Edge Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Edge Relation</em>' operation.
	 * @see org.polymodel.prdg.PRDGEdge#toEdgeRelation(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getPRDGEdge__ToEdgeRelation__DimensionsManager();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.PRDG <em>PRDG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PRDG</em>'.
	 * @see org.polymodel.prdg.PRDG
	 * @generated
	 */
	EClass getPRDG();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.PRDG#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.polymodel.prdg.PRDG#getNodes()
	 * @see #getPRDG()
	 * @generated
	 */
	EReference getPRDG_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.PRDG#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.polymodel.prdg.PRDG#getEdges()
	 * @see #getPRDG()
	 * @generated
	 */
	EReference getPRDG_Edges();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.PRDG#getHedges <em>Hedges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hedges</em>'.
	 * @see org.polymodel.prdg.PRDG#getHedges()
	 * @see #getPRDG()
	 * @generated
	 */
	EReference getPRDG_Hedges();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.PRDG#getNode(java.lang.String) <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.polymodel.prdg.PRDG#getNode(java.lang.String)
	 * @generated
	 */
	EOperation getPRDG__GetNode__String();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.EdgeFunction <em>Edge Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Function</em>'.
	 * @see org.polymodel.prdg.EdgeFunction
	 * @generated
	 */
	EClass getEdgeFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.EdgeFunction#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see org.polymodel.prdg.EdgeFunction#getMapping()
	 * @see #getEdgeFunction()
	 * @generated
	 */
	EReference getEdgeFunction_Mapping();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.ProjectionFunction <em>Projection Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Projection Function</em>'.
	 * @see org.polymodel.prdg.ProjectionFunction
	 * @generated
	 */
	EClass getProjectionFunction();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.DependenceFunction <em>Dependence Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependence Function</em>'.
	 * @see org.polymodel.prdg.DependenceFunction
	 * @generated
	 */
	EClass getDependenceFunction();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.DependenceFunction#isUniform() <em>Is Uniform</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Uniform</em>' operation.
	 * @see org.polymodel.prdg.DependenceFunction#isUniform()
	 * @generated
	 */
	EOperation getDependenceFunction__IsUniform();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge <em>PRDG Sub System Hyper Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PRDG Sub System Hyper Edge</em>'.
	 * @see org.polymodel.prdg.PRDGSubSystemHyperEdge
	 * @generated
	 */
	EClass getPRDGSubSystemHyperEdge();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.polymodel.prdg.PRDGSubSystemHyperEdge#getSources()
	 * @see #getPRDGSubSystemHyperEdge()
	 * @generated
	 */
	EReference getPRDGSubSystemHyperEdge_Sources();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getDestinations <em>Destinations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destinations</em>'.
	 * @see org.polymodel.prdg.PRDGSubSystemHyperEdge#getDestinations()
	 * @see #getPRDGSubSystemHyperEdge()
	 * @generated
	 */
	EReference getPRDGSubSystemHyperEdge_Destinations();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getExtDom <em>Ext Dom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ext Dom</em>'.
	 * @see org.polymodel.prdg.PRDGSubSystemHyperEdge#getExtDom()
	 * @see #getPRDGSubSystemHyperEdge()
	 * @generated
	 */
	EReference getPRDGSubSystemHyperEdge_ExtDom();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Params</em>'.
	 * @see org.polymodel.prdg.PRDGSubSystemHyperEdge#getParams()
	 * @see #getPRDGSubSystemHyperEdge()
	 * @generated
	 */
	EReference getPRDGSubSystemHyperEdge_Params();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PrdgFactory getPrdgFactory();

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
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.PRDGNodeImpl <em>PRDG Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.PRDGNodeImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGNode()
		 * @generated
		 */
		EClass PRDG_NODE = eINSTANCE.getPRDGNode();

		/**
		 * The meta object literal for the '<em><b>Prdg</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_NODE__PRDG = eINSTANCE.getPRDGNode_Prdg();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_NODE__DOMAIN = eINSTANCE.getPRDGNode_Domain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRDG_NODE__NAME = eINSTANCE.getPRDGNode_Name();

		/**
		 * The meta object literal for the '<em><b>Get Destinations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRDG_NODE___GET_DESTINATIONS = eINSTANCE.getPRDGNode__GetDestinations();

		/**
		 * The meta object literal for the '<em><b>Get Sources</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRDG_NODE___GET_SOURCES = eINSTANCE.getPRDGNode__GetSources();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.PRDGEdgeImpl <em>PRDG Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.PRDGEdgeImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGEdge()
		 * @generated
		 */
		EClass PRDG_EDGE = eINSTANCE.getPRDGEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_EDGE__SOURCE = eINSTANCE.getPRDGEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_EDGE__DESTINATION = eINSTANCE.getPRDGEdge_Destination();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_EDGE__DOMAIN = eINSTANCE.getPRDGEdge_Domain();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_EDGE__FUNCTION = eINSTANCE.getPRDGEdge_Function();

		/**
		 * The meta object literal for the '<em><b>To Edge Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRDG_EDGE___TO_EDGE_RELATION__DIMENSIONSMANAGER = eINSTANCE.getPRDGEdge__ToEdgeRelation__DimensionsManager();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.PRDGImpl <em>PRDG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.PRDGImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDG()
		 * @generated
		 */
		EClass PRDG = eINSTANCE.getPRDG();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG__NODES = eINSTANCE.getPRDG_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG__EDGES = eINSTANCE.getPRDG_Edges();

		/**
		 * The meta object literal for the '<em><b>Hedges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG__HEDGES = eINSTANCE.getPRDG_Hedges();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRDG___GET_NODE__STRING = eINSTANCE.getPRDG__GetNode__String();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.EdgeFunctionImpl <em>Edge Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.EdgeFunctionImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getEdgeFunction()
		 * @generated
		 */
		EClass EDGE_FUNCTION = eINSTANCE.getEdgeFunction();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_FUNCTION__MAPPING = eINSTANCE.getEdgeFunction_Mapping();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.ProjectionFunctionImpl <em>Projection Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.ProjectionFunctionImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getProjectionFunction()
		 * @generated
		 */
		EClass PROJECTION_FUNCTION = eINSTANCE.getProjectionFunction();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.DependenceFunctionImpl <em>Dependence Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.DependenceFunctionImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getDependenceFunction()
		 * @generated
		 */
		EClass DEPENDENCE_FUNCTION = eINSTANCE.getDependenceFunction();

		/**
		 * The meta object literal for the '<em><b>Is Uniform</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEPENDENCE_FUNCTION___IS_UNIFORM = eINSTANCE.getDependenceFunction__IsUniform();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl <em>PRDG Sub System Hyper Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl
		 * @see org.polymodel.prdg.impl.PrdgPackageImpl#getPRDGSubSystemHyperEdge()
		 * @generated
		 */
		EClass PRDG_SUB_SYSTEM_HYPER_EDGE = eINSTANCE.getPRDGSubSystemHyperEdge();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES = eINSTANCE.getPRDGSubSystemHyperEdge_Sources();

		/**
		 * The meta object literal for the '<em><b>Destinations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS = eINSTANCE.getPRDGSubSystemHyperEdge_Destinations();

		/**
		 * The meta object literal for the '<em><b>Ext Dom</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM = eINSTANCE.getPRDGSubSystemHyperEdge_ExtDom();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS = eINSTANCE.getPRDGSubSystemHyperEdge_Params();

	}

} //PrdgPackage
