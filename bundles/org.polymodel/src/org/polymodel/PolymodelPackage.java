/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

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
 * @see org.polymodel.PolymodelFactory
 * @model kind="package"
 * @generated
 */
public interface PolymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "polymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolymodelPackage eINSTANCE = org.polymodel.impl.PolymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.PolymodelVisitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.PolymodelVisitable
	 * @see org.polymodel.impl.PolymodelPackageImpl#getPolymodelVisitable()
	 * @generated
	 */
	int POLYMODEL_VISITABLE = 16;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITABLE___ACCEPT__POLYMODELVISITOR = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITABLE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.DomainImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Polyhedra</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__POLYHEDRA = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__LABEL = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Union</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___UNION__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Image</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___IMAGE__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___DIFFERENCE__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Intersection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___INTERSECTION__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___IS_EMPTY = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___SIMPLIFY__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___SIMPLIFY = POLYMODEL_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Bounding Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___BOUNDING_BOX = POLYMODEL_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___EQUIVALENCE__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Universe</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___IS_UNIVERSE = POLYMODEL_VISITABLE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Lex Min</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___LEX_MIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Lex Max</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___LEX_MAX = POLYMODEL_VISITABLE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Detect Equalities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___DETECT_EQUALITIES = POLYMODEL_VISITABLE_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Affine Hull</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___AFFINE_HULL = POLYMODEL_VISITABLE_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Polyhedral Hull</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___POLYHEDRAL_HULL = POLYMODEL_VISITABLE_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>To Matrices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___TO_MATRICES = POLYMODEL_VISITABLE_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Complement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___COMPLEMENT = POLYMODEL_VISITABLE_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Cartesian Product</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___CARTESIAN_PRODUCT__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 18;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 19;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.DimensionsManagerImpl <em>Dimensions Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.DimensionsManagerImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getDimensionsManager()
	 * @generated
	 */
	int DIMENSIONS_MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER__DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER__PARAMETERS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inputs Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER__INPUTS_DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outputs Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Dimensions Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_DIMENSION__INT = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_DIMENSION__INT_STRING = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Input Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_INPUT_DIMENSION__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Output Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_OUTPUT_DIMENSION__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_PARAMETER__INT = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___GET_PARAMETER__INT_STRING = POLYMODEL_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Dimensions Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONS_MANAGER_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.AbstractRelationImpl <em>Abstract Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.AbstractRelationImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getAbstractRelation()
	 * @generated
	 */
	int ABSTRACT_RELATION = 2;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Basic Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__BASIC_RELATIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Reverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___REVERSE__DIMENSIONSMANAGER = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Bijective</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___IS_BIJECTIVE = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Single Valued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___IS_SINGLE_VALUED = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___IS_EMPTY = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___EQUIVALENCE__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Intersect Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___INTERSECT_DOMAIN__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Intersect Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___INTERSECT_RANGE__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Intersection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___INTERSECTION__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Union</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___UNION__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___DIFFERENCE__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Build Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___BUILD_FUNCTION = POLYMODEL_VISITABLE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___GET_DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Get Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___GET_RANGE = POLYMODEL_VISITABLE_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Apply Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___APPLY_DOMAIN__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Apply Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___APPLY_RANGE__ABSTRACTRELATION = POLYMODEL_VISITABLE_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___TRANSITIVE_CLOSURE = POLYMODEL_VISITABLE_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Exact Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___EXACT_TRANSITIVE_CLOSURE = POLYMODEL_VISITABLE_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___SIMPLIFY = POLYMODEL_VISITABLE_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>To Matrices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION___TO_MATRICES = POLYMODEL_VISITABLE_OPERATION_COUNT + 19;

	/**
	 * The number of operations of the '<em>Abstract Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 20;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.ExistentialVariableImpl <em>Existential Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.ExistentialVariableImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getExistentialVariable()
	 * @generated
	 */
	int EXISTENTIAL_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE__NAME = AlgebraPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE__DEFINITION = AlgebraPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE__DOMAIN = AlgebraPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Existential Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE_FEATURE_COUNT = AlgebraPackage.VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.VARIABLE___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE___ACCEPT__POLYMODELVISITOR = AlgebraPackage.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Existential Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTENTIAL_VARIABLE_OPERATION_COUNT = AlgebraPackage.VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.DomainDimensionsImpl <em>Domain Dimensions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.DomainDimensionsImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getDomainDimensions()
	 * @generated
	 */
	int DOMAIN_DIMENSIONS = 4;

	/**
	 * The feature id for the '<em><b>Indices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS__INDICES = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS__PARAMETERS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Existential</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS__EXISTENTIAL = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS___COPY = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Parameter Dimension Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Dimension Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS___GET_DIMENSION_OF__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Domain Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DIMENSIONS_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.IndexDimensionImpl <em>Index Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.IndexDimensionImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getIndexDimension()
	 * @generated
	 */
	int INDEX_DIMENSION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION__NAME = AlgebraPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION__DIMENSION = AlgebraPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION_FEATURE_COUNT = AlgebraPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.VARIABLE___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION___ACCEPT__POLYMODELVISITOR = AlgebraPackage.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Index Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DIMENSION_OPERATION_COUNT = AlgebraPackage.VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.RelationDimensionsImpl <em>Relation Dimensions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.RelationDimensionsImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getRelationDimensions()
	 * @generated
	 */
	int RELATION_DIMENSIONS = 6;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS__INPUTS = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS__OUTPUTS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS__PARAMETERS = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Existential</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS__EXISTENTIAL = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Relation Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Parameter Dimension Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Input Dimension Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS___GET_INPUT_DIMENSION_OF__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Output Dimension Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS___GET_OUTPUT_DIMENSION_OF__VARIABLE = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relation Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSIONS_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.BasicRelationImpl <em>Basic Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.BasicRelationImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getBasicRelation()
	 * @generated
	 */
	int BASIC_RELATION = 7;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION__INPUT = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION__OUTPUT = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION__RELATION = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION__IN = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION__OUT = POLYMODEL_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Basic Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Basic Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RELATION_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.FunctionImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 9;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.ValueContainedMapImpl <em>Value Contained Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.ValueContainedMapImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getValueContainedMap()
	 * @generated
	 */
	int VALUE_CONTAINED_MAP = 10;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.RelationImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 8;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DIMENSIONS = ABSTRACT_RELATION__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Basic Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__BASIC_RELATIONS = ABSTRACT_RELATION__BASIC_RELATIONS;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = ABSTRACT_RELATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Reverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___REVERSE__DIMENSIONSMANAGER = ABSTRACT_RELATION___REVERSE__DIMENSIONSMANAGER;

	/**
	 * The operation id for the '<em>Is Bijective</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_BIJECTIVE = ABSTRACT_RELATION___IS_BIJECTIVE;

	/**
	 * The operation id for the '<em>Is Single Valued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_SINGLE_VALUED = ABSTRACT_RELATION___IS_SINGLE_VALUED;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_EMPTY = ABSTRACT_RELATION___IS_EMPTY;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___EQUIVALENCE__ABSTRACTRELATION = ABSTRACT_RELATION___EQUIVALENCE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Intersect Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___INTERSECT_DOMAIN__DOMAIN = ABSTRACT_RELATION___INTERSECT_DOMAIN__DOMAIN;

	/**
	 * The operation id for the '<em>Intersect Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___INTERSECT_RANGE__DOMAIN = ABSTRACT_RELATION___INTERSECT_RANGE__DOMAIN;

	/**
	 * The operation id for the '<em>Intersection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___INTERSECTION__ABSTRACTRELATION = ABSTRACT_RELATION___INTERSECTION__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Union</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___UNION__ABSTRACTRELATION = ABSTRACT_RELATION___UNION__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___DIFFERENCE__ABSTRACTRELATION = ABSTRACT_RELATION___DIFFERENCE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Build Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___BUILD_FUNCTION = ABSTRACT_RELATION___BUILD_FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_DOMAIN = ABSTRACT_RELATION___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_RANGE = ABSTRACT_RELATION___GET_RANGE;

	/**
	 * The operation id for the '<em>Apply Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___APPLY_DOMAIN__ABSTRACTRELATION = ABSTRACT_RELATION___APPLY_DOMAIN__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Apply Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___APPLY_RANGE__ABSTRACTRELATION = ABSTRACT_RELATION___APPLY_RANGE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___TRANSITIVE_CLOSURE = ABSTRACT_RELATION___TRANSITIVE_CLOSURE;

	/**
	 * The operation id for the '<em>Exact Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___EXACT_TRANSITIVE_CLOSURE = ABSTRACT_RELATION___EXACT_TRANSITIVE_CLOSURE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___SIMPLIFY = ABSTRACT_RELATION___SIMPLIFY;

	/**
	 * The operation id for the '<em>To Matrices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___TO_MATRICES = ABSTRACT_RELATION___TO_MATRICES;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___ACCEPT__POLYMODELVISITOR = ABSTRACT_RELATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = ABSTRACT_RELATION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expressions Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__EXPRESSIONS_MAP = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DIMENSIONS = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IN = POLYMODEL_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OUT = POLYMODEL_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___GET_EXPRESSION__INT = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Expressions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___GET_EXPRESSIONS = POLYMODEL_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Build Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER = POLYMODEL_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___EQUIVALENCE__FUNCTION = POLYMODEL_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Compose</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___COMPOSE__FUNCTION = POLYMODEL_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___INVERSE__DIMENSIONSMANAGER = POLYMODEL_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Inverse In Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>To Matrix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___TO_MATRIX = POLYMODEL_VISITABLE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Uniformize In Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN = POLYMODEL_VISITABLE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Nullspace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___NULLSPACE = POLYMODEL_VISITABLE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Linear Part</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___LINEAR_PART = POLYMODEL_VISITABLE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Linear Part With Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___LINEAR_PART_WITH_PARAMETERS = POLYMODEL_VISITABLE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Linear Part As Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___LINEAR_PART_AS_FUNCTION = POLYMODEL_VISITABLE_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Constant Part</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___CONSTANT_PART = POLYMODEL_VISITABLE_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Uniform</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___IS_UNIFORM = POLYMODEL_VISITABLE_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Identity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___IS_IDENTITY = POLYMODEL_VISITABLE_OPERATION_COUNT + 16;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONTAINED_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONTAINED_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Value Contained Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONTAINED_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Value Contained Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONTAINED_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.LabelImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__NAME = POLYMODEL_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = POLYMODEL_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL___ACCEPT__POLYMODELVISITOR = POLYMODEL_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_OPERATION_COUNT = POLYMODEL_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.RelationDimensionImpl <em>Relation Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.RelationDimensionImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getRelationDimension()
	 * @generated
	 */
	int RELATION_DIMENSION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION__NAME = AlgebraPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION__DIMENSION = AlgebraPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Relation Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION_FEATURE_COUNT = AlgebraPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.VARIABLE___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION___ACCEPT__POLYMODELVISITOR = AlgebraPackage.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Relation Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DIMENSION_OPERATION_COUNT = AlgebraPackage.VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.InputDimensionImpl <em>Input Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.InputDimensionImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getInputDimension()
	 * @generated
	 */
	int INPUT_DIMENSION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION__NAME = RELATION_DIMENSION__NAME;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION__DIMENSION = RELATION_DIMENSION__DIMENSION;

	/**
	 * The number of structural features of the '<em>Input Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION_FEATURE_COUNT = RELATION_DIMENSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION___ACCEPT__ALGEBRAVISITOR = RELATION_DIMENSION___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION___ACCEPT__POLYMODELVISITOR = RELATION_DIMENSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DIMENSION_OPERATION_COUNT = RELATION_DIMENSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.OutputDimensionImpl <em>Output Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.OutputDimensionImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getOutputDimension()
	 * @generated
	 */
	int OUTPUT_DIMENSION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION__NAME = RELATION_DIMENSION__NAME;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION__DIMENSION = RELATION_DIMENSION__DIMENSION;

	/**
	 * The number of structural features of the '<em>Output Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION_FEATURE_COUNT = RELATION_DIMENSION_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION___ACCEPT__ALGEBRAVISITOR = RELATION_DIMENSION___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION___ACCEPT__POLYMODELVISITOR = RELATION_DIMENSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DIMENSION_OPERATION_COUNT = RELATION_DIMENSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.impl.PolymodelVisitorImpl <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.impl.PolymodelVisitorImpl
	 * @see org.polymodel.impl.PolymodelPackageImpl#getPolymodelVisitor()
	 * @generated
	 */
	int POLYMODEL_VISITOR = 15;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR_FEATURE_COUNT = 0;


	/**
	 * The operation id for the '<em>Visit Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_DOMAIN__DOMAIN = 0;

	/**
	 * The operation id for the '<em>Visit Dimensions Manager</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_DIMENSIONS_MANAGER__DIMENSIONSMANAGER = 1;

	/**
	 * The operation id for the '<em>Visit Existential Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_EXISTENTIAL_VARIABLE__EXISTENTIALVARIABLE = 2;

	/**
	 * The operation id for the '<em>Visit Domain Dimensions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_DOMAIN_DIMENSIONS__DOMAINDIMENSIONS = 3;

	/**
	 * The operation id for the '<em>Visit Index Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_INDEX_DIMENSION__INDEXDIMENSION = 4;

	/**
	 * The operation id for the '<em>Visit Relation Dimensions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_RELATION_DIMENSIONS__RELATIONDIMENSIONS = 5;

	/**
	 * The operation id for the '<em>Visit Basic Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_BASIC_RELATION__BASICRELATION = 6;

	/**
	 * The operation id for the '<em>Visit Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_FUNCTION__FUNCTION = 7;

	/**
	 * The operation id for the '<em>Visit Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_RELATION__RELATION = 8;

	/**
	 * The operation id for the '<em>Visit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_LABEL__LABEL = 9;

	/**
	 * The operation id for the '<em>Visit Input Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_INPUT_DIMENSION__INPUTDIMENSION = 10;

	/**
	 * The operation id for the '<em>Visit Output Dimension</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR___VISIT_OUTPUT_DIMENSION__OUTPUTDIMENSION = 11;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMODEL_VISITOR_OPERATION_COUNT = 12;


	/**
	 * Returns the meta object for class '{@link org.polymodel.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see org.polymodel.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.Domain#getPolyhedra <em>Polyhedra</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Polyhedra</em>'.
	 * @see org.polymodel.Domain#getPolyhedra()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Polyhedra();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.Domain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dimensions</em>'.
	 * @see org.polymodel.Domain#getDimensions()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Dimensions();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.Domain#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see org.polymodel.Domain#getLabel()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Label();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#union(org.polymodel.Domain) <em>Union</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Union</em>' operation.
	 * @see org.polymodel.Domain#union(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__Union__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#image(org.polymodel.AbstractRelation) <em>Image</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Image</em>' operation.
	 * @see org.polymodel.Domain#image(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getDomain__Image__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#difference(org.polymodel.Domain) <em>Difference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Difference</em>' operation.
	 * @see org.polymodel.Domain#difference(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__Difference__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#intersection(org.polymodel.Domain) <em>Intersection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Intersection</em>' operation.
	 * @see org.polymodel.Domain#intersection(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__Intersection__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#isEmpty() <em>Is Empty</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Empty</em>' operation.
	 * @see org.polymodel.Domain#isEmpty()
	 * @generated
	 */
	EOperation getDomain__IsEmpty();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#simplify(org.polymodel.Domain) <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.Domain#simplify(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__Simplify__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.Domain#simplify()
	 * @generated
	 */
	EOperation getDomain__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#boundingBox() <em>Bounding Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Bounding Box</em>' operation.
	 * @see org.polymodel.Domain#boundingBox()
	 * @generated
	 */
	EOperation getDomain__BoundingBox();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#equivalence(org.polymodel.Domain) <em>Equivalence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equivalence</em>' operation.
	 * @see org.polymodel.Domain#equivalence(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__Equivalence__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.Domain#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getDomain__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#isUniverse() <em>Is Universe</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Universe</em>' operation.
	 * @see org.polymodel.Domain#isUniverse()
	 * @generated
	 */
	EOperation getDomain__IsUniverse();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#lexMin() <em>Lex Min</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lex Min</em>' operation.
	 * @see org.polymodel.Domain#lexMin()
	 * @generated
	 */
	EOperation getDomain__LexMin();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#lexMax() <em>Lex Max</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lex Max</em>' operation.
	 * @see org.polymodel.Domain#lexMax()
	 * @generated
	 */
	EOperation getDomain__LexMax();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#detectEqualities() <em>Detect Equalities</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Detect Equalities</em>' operation.
	 * @see org.polymodel.Domain#detectEqualities()
	 * @generated
	 */
	EOperation getDomain__DetectEqualities();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#affineHull() <em>Affine Hull</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Affine Hull</em>' operation.
	 * @see org.polymodel.Domain#affineHull()
	 * @generated
	 */
	EOperation getDomain__AffineHull();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#polyhedralHull() <em>Polyhedral Hull</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Polyhedral Hull</em>' operation.
	 * @see org.polymodel.Domain#polyhedralHull()
	 * @generated
	 */
	EOperation getDomain__PolyhedralHull();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#toMatrices() <em>To Matrices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Matrices</em>' operation.
	 * @see org.polymodel.Domain#toMatrices()
	 * @generated
	 */
	EOperation getDomain__ToMatrices();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#complement() <em>Complement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complement</em>' operation.
	 * @see org.polymodel.Domain#complement()
	 * @generated
	 */
	EOperation getDomain__Complement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Domain#cartesianProduct(org.polymodel.Domain) <em>Cartesian Product</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Cartesian Product</em>' operation.
	 * @see org.polymodel.Domain#cartesianProduct(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getDomain__CartesianProduct__Domain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.DimensionsManager <em>Dimensions Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimensions Manager</em>'.
	 * @see org.polymodel.DimensionsManager
	 * @generated
	 */
	EClass getDimensionsManager();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.DimensionsManager#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimensions</em>'.
	 * @see org.polymodel.DimensionsManager#getDimensions()
	 * @see #getDimensionsManager()
	 * @generated
	 */
	EReference getDimensionsManager_Dimensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.DimensionsManager#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.polymodel.DimensionsManager#getParameters()
	 * @see #getDimensionsManager()
	 * @generated
	 */
	EReference getDimensionsManager_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.DimensionsManager#getInputsDimensions <em>Inputs Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs Dimensions</em>'.
	 * @see org.polymodel.DimensionsManager#getInputsDimensions()
	 * @see #getDimensionsManager()
	 * @generated
	 */
	EReference getDimensionsManager_InputsDimensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.DimensionsManager#getOutputsDimensions <em>Outputs Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs Dimensions</em>'.
	 * @see org.polymodel.DimensionsManager#getOutputsDimensions()
	 * @see #getDimensionsManager()
	 * @generated
	 */
	EReference getDimensionsManager_OutputsDimensions();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getDimension(int) <em>Get Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dimension</em>' operation.
	 * @see org.polymodel.DimensionsManager#getDimension(int)
	 * @generated
	 */
	EOperation getDimensionsManager__GetDimension__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getDimension(int, java.lang.String) <em>Get Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dimension</em>' operation.
	 * @see org.polymodel.DimensionsManager#getDimension(int, java.lang.String)
	 * @generated
	 */
	EOperation getDimensionsManager__GetDimension__int_String();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getInputDimension(org.polymodel.algebra.Variable) <em>Get Input Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Dimension</em>' operation.
	 * @see org.polymodel.DimensionsManager#getInputDimension(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getDimensionsManager__GetInputDimension__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getOutputDimension(org.polymodel.algebra.Variable) <em>Get Output Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Output Dimension</em>' operation.
	 * @see org.polymodel.DimensionsManager#getOutputDimension(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getDimensionsManager__GetOutputDimension__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getParameter(int) <em>Get Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter</em>' operation.
	 * @see org.polymodel.DimensionsManager#getParameter(int)
	 * @generated
	 */
	EOperation getDimensionsManager__GetParameter__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#getParameter(int, java.lang.String) <em>Get Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter</em>' operation.
	 * @see org.polymodel.DimensionsManager#getParameter(int, java.lang.String)
	 * @generated
	 */
	EOperation getDimensionsManager__GetParameter__int_String();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DimensionsManager#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.DimensionsManager#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getDimensionsManager__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.AbstractRelation <em>Abstract Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Relation</em>'.
	 * @see org.polymodel.AbstractRelation
	 * @generated
	 */
	EClass getAbstractRelation();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.AbstractRelation#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dimensions</em>'.
	 * @see org.polymodel.AbstractRelation#getDimensions()
	 * @see #getAbstractRelation()
	 * @generated
	 */
	EReference getAbstractRelation_Dimensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.AbstractRelation#getBasicRelations <em>Basic Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Basic Relations</em>'.
	 * @see org.polymodel.AbstractRelation#getBasicRelations()
	 * @see #getAbstractRelation()
	 * @generated
	 */
	EReference getAbstractRelation_BasicRelations();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.AbstractRelation#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getAbstractRelation__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#reverse(org.polymodel.DimensionsManager) <em>Reverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reverse</em>' operation.
	 * @see org.polymodel.AbstractRelation#reverse(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getAbstractRelation__Reverse__DimensionsManager();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#isBijective() <em>Is Bijective</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Bijective</em>' operation.
	 * @see org.polymodel.AbstractRelation#isBijective()
	 * @generated
	 */
	EOperation getAbstractRelation__IsBijective();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#isSingleValued() <em>Is Single Valued</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Single Valued</em>' operation.
	 * @see org.polymodel.AbstractRelation#isSingleValued()
	 * @generated
	 */
	EOperation getAbstractRelation__IsSingleValued();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#isEmpty() <em>Is Empty</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Empty</em>' operation.
	 * @see org.polymodel.AbstractRelation#isEmpty()
	 * @generated
	 */
	EOperation getAbstractRelation__IsEmpty();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#equivalence(org.polymodel.AbstractRelation) <em>Equivalence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equivalence</em>' operation.
	 * @see org.polymodel.AbstractRelation#equivalence(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__Equivalence__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#intersectDomain(org.polymodel.Domain) <em>Intersect Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Intersect Domain</em>' operation.
	 * @see org.polymodel.AbstractRelation#intersectDomain(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getAbstractRelation__IntersectDomain__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#intersectRange(org.polymodel.Domain) <em>Intersect Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Intersect Range</em>' operation.
	 * @see org.polymodel.AbstractRelation#intersectRange(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getAbstractRelation__IntersectRange__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#intersection(org.polymodel.AbstractRelation) <em>Intersection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Intersection</em>' operation.
	 * @see org.polymodel.AbstractRelation#intersection(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__Intersection__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#union(org.polymodel.AbstractRelation) <em>Union</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Union</em>' operation.
	 * @see org.polymodel.AbstractRelation#union(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__Union__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#difference(org.polymodel.AbstractRelation) <em>Difference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Difference</em>' operation.
	 * @see org.polymodel.AbstractRelation#difference(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__Difference__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#buildFunction() <em>Build Function</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Function</em>' operation.
	 * @see org.polymodel.AbstractRelation#buildFunction()
	 * @generated
	 */
	EOperation getAbstractRelation__BuildFunction();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#getDomain() <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain</em>' operation.
	 * @see org.polymodel.AbstractRelation#getDomain()
	 * @generated
	 */
	EOperation getAbstractRelation__GetDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#getRange() <em>Get Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Range</em>' operation.
	 * @see org.polymodel.AbstractRelation#getRange()
	 * @generated
	 */
	EOperation getAbstractRelation__GetRange();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#applyDomain(org.polymodel.AbstractRelation) <em>Apply Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Apply Domain</em>' operation.
	 * @see org.polymodel.AbstractRelation#applyDomain(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__ApplyDomain__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#applyRange(org.polymodel.AbstractRelation) <em>Apply Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Apply Range</em>' operation.
	 * @see org.polymodel.AbstractRelation#applyRange(org.polymodel.AbstractRelation)
	 * @generated
	 */
	EOperation getAbstractRelation__ApplyRange__AbstractRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#transitiveClosure() <em>Transitive Closure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Transitive Closure</em>' operation.
	 * @see org.polymodel.AbstractRelation#transitiveClosure()
	 * @generated
	 */
	EOperation getAbstractRelation__TransitiveClosure();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#exactTransitiveClosure() <em>Exact Transitive Closure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Exact Transitive Closure</em>' operation.
	 * @see org.polymodel.AbstractRelation#exactTransitiveClosure()
	 * @generated
	 */
	EOperation getAbstractRelation__ExactTransitiveClosure();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.AbstractRelation#simplify()
	 * @generated
	 */
	EOperation getAbstractRelation__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.AbstractRelation#toMatrices() <em>To Matrices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Matrices</em>' operation.
	 * @see org.polymodel.AbstractRelation#toMatrices()
	 * @generated
	 */
	EOperation getAbstractRelation__ToMatrices();

	/**
	 * Returns the meta object for class '{@link org.polymodel.ExistentialVariable <em>Existential Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existential Variable</em>'.
	 * @see org.polymodel.ExistentialVariable
	 * @generated
	 */
	EClass getExistentialVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.ExistentialVariable#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see org.polymodel.ExistentialVariable#getDefinition()
	 * @see #getExistentialVariable()
	 * @generated
	 */
	EReference getExistentialVariable_Definition();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.ExistentialVariable#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.ExistentialVariable#getDomain()
	 * @see #getExistentialVariable()
	 * @generated
	 */
	EReference getExistentialVariable_Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.ExistentialVariable#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.ExistentialVariable#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getExistentialVariable__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.DomainDimensions <em>Domain Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Dimensions</em>'.
	 * @see org.polymodel.DomainDimensions
	 * @generated
	 */
	EClass getDomainDimensions();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.DomainDimensions#getIndices <em>Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Indices</em>'.
	 * @see org.polymodel.DomainDimensions#getIndices()
	 * @see #getDomainDimensions()
	 * @generated
	 */
	EReference getDomainDimensions_Indices();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.DomainDimensions#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.polymodel.DomainDimensions#getParameters()
	 * @see #getDomainDimensions()
	 * @generated
	 */
	EReference getDomainDimensions_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.DomainDimensions#getExistential <em>Existential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Existential</em>'.
	 * @see org.polymodel.DomainDimensions#getExistential()
	 * @see #getDomainDimensions()
	 * @generated
	 */
	EReference getDomainDimensions_Existential();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DomainDimensions#copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy</em>' operation.
	 * @see org.polymodel.DomainDimensions#copy()
	 * @generated
	 */
	EOperation getDomainDimensions__Copy();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DomainDimensions#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.DomainDimensions#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getDomainDimensions__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DomainDimensions#getParameterDimensionOf(org.polymodel.algebra.Variable) <em>Get Parameter Dimension Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter Dimension Of</em>' operation.
	 * @see org.polymodel.DomainDimensions#getParameterDimensionOf(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getDomainDimensions__GetParameterDimensionOf__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.DomainDimensions#getDimensionOf(org.polymodel.algebra.Variable) <em>Get Dimension Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dimension Of</em>' operation.
	 * @see org.polymodel.DomainDimensions#getDimensionOf(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getDomainDimensions__GetDimensionOf__Variable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.IndexDimension <em>Index Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Dimension</em>'.
	 * @see org.polymodel.IndexDimension
	 * @generated
	 */
	EClass getIndexDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.IndexDimension#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.polymodel.IndexDimension#getDimension()
	 * @see #getIndexDimension()
	 * @generated
	 */
	EAttribute getIndexDimension_Dimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.IndexDimension#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.IndexDimension#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getIndexDimension__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.RelationDimensions <em>Relation Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Dimensions</em>'.
	 * @see org.polymodel.RelationDimensions
	 * @generated
	 */
	EClass getRelationDimensions();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.RelationDimensions#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.RelationDimensions#getInputs()
	 * @see #getRelationDimensions()
	 * @generated
	 */
	EReference getRelationDimensions_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.RelationDimensions#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.RelationDimensions#getOutputs()
	 * @see #getRelationDimensions()
	 * @generated
	 */
	EReference getRelationDimensions_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.RelationDimensions#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.polymodel.RelationDimensions#getParameters()
	 * @see #getRelationDimensions()
	 * @generated
	 */
	EReference getRelationDimensions_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.RelationDimensions#getExistential <em>Existential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Existential</em>'.
	 * @see org.polymodel.RelationDimensions#getExistential()
	 * @see #getRelationDimensions()
	 * @generated
	 */
	EReference getRelationDimensions_Existential();

	/**
	 * Returns the meta object for the '{@link org.polymodel.RelationDimensions#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.RelationDimensions#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getRelationDimensions__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.RelationDimensions#getParameterDimensionOf(org.polymodel.algebra.Variable) <em>Get Parameter Dimension Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter Dimension Of</em>' operation.
	 * @see org.polymodel.RelationDimensions#getParameterDimensionOf(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getRelationDimensions__GetParameterDimensionOf__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.RelationDimensions#getInputDimensionOf(org.polymodel.algebra.Variable) <em>Get Input Dimension Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Dimension Of</em>' operation.
	 * @see org.polymodel.RelationDimensions#getInputDimensionOf(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getRelationDimensions__GetInputDimensionOf__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.RelationDimensions#getOutputDimensionOf(org.polymodel.algebra.Variable) <em>Get Output Dimension Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Output Dimension Of</em>' operation.
	 * @see org.polymodel.RelationDimensions#getOutputDimensionOf(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getRelationDimensions__GetOutputDimensionOf__Variable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.BasicRelation <em>Basic Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Relation</em>'.
	 * @see org.polymodel.BasicRelation
	 * @generated
	 */
	EClass getBasicRelation();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.BasicRelation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.polymodel.BasicRelation#getInput()
	 * @see #getBasicRelation()
	 * @generated
	 */
	EReference getBasicRelation_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.BasicRelation#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see org.polymodel.BasicRelation#getOutput()
	 * @see #getBasicRelation()
	 * @generated
	 */
	EReference getBasicRelation_Output();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.BasicRelation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Relation</em>'.
	 * @see org.polymodel.BasicRelation#getRelation()
	 * @see #getBasicRelation()
	 * @generated
	 */
	EReference getBasicRelation_Relation();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.BasicRelation#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.polymodel.BasicRelation#getIn()
	 * @see #getBasicRelation()
	 * @generated
	 */
	EReference getBasicRelation_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.BasicRelation#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out</em>'.
	 * @see org.polymodel.BasicRelation#getOut()
	 * @see #getBasicRelation()
	 * @generated
	 */
	EReference getBasicRelation_Out();

	/**
	 * Returns the meta object for the '{@link org.polymodel.BasicRelation#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.BasicRelation#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getBasicRelation__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.polymodel.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the map '{@link org.polymodel.Function#getExpressionsMap <em>Expressions Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Expressions Map</em>'.
	 * @see org.polymodel.Function#getExpressionsMap()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ExpressionsMap();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.Function#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.polymodel.Function#getIn()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.Function#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out</em>'.
	 * @see org.polymodel.Function#getOut()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Out();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.Function#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getFunction__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#getExpression(int) <em>Get Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Expression</em>' operation.
	 * @see org.polymodel.Function#getExpression(int)
	 * @generated
	 */
	EOperation getFunction__GetExpression__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#getExpressions() <em>Get Expressions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Expressions</em>' operation.
	 * @see org.polymodel.Function#getExpressions()
	 * @generated
	 */
	EOperation getFunction__GetExpressions();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#buildRelation(org.polymodel.DimensionsManager) <em>Build Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Relation</em>' operation.
	 * @see org.polymodel.Function#buildRelation(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getFunction__BuildRelation__DimensionsManager();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#equivalence(org.polymodel.Function) <em>Equivalence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equivalence</em>' operation.
	 * @see org.polymodel.Function#equivalence(org.polymodel.Function)
	 * @generated
	 */
	EOperation getFunction__Equivalence__Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#compose(org.polymodel.Function) <em>Compose</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compose</em>' operation.
	 * @see org.polymodel.Function#compose(org.polymodel.Function)
	 * @generated
	 */
	EOperation getFunction__Compose__Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#inverse(org.polymodel.DimensionsManager) <em>Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inverse</em>' operation.
	 * @see org.polymodel.Function#inverse(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getFunction__Inverse__DimensionsManager();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#inverseInContext(org.polymodel.DimensionsManager, org.polymodel.Domain) <em>Inverse In Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inverse In Context</em>' operation.
	 * @see org.polymodel.Function#inverseInContext(org.polymodel.DimensionsManager, org.polymodel.Domain)
	 * @generated
	 */
	EOperation getFunction__InverseInContext__DimensionsManager_Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#toMatrix() <em>To Matrix</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Matrix</em>' operation.
	 * @see org.polymodel.Function#toMatrix()
	 * @generated
	 */
	EOperation getFunction__ToMatrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#uniformizeInContext(org.polymodel.Domain) <em>Uniformize In Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uniformize In Context</em>' operation.
	 * @see org.polymodel.Function#uniformizeInContext(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getFunction__UniformizeInContext__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#nullspace() <em>Nullspace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Nullspace</em>' operation.
	 * @see org.polymodel.Function#nullspace()
	 * @generated
	 */
	EOperation getFunction__Nullspace();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#linearPart() <em>Linear Part</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Linear Part</em>' operation.
	 * @see org.polymodel.Function#linearPart()
	 * @generated
	 */
	EOperation getFunction__LinearPart();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#linearPartWithParameters() <em>Linear Part With Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Linear Part With Parameters</em>' operation.
	 * @see org.polymodel.Function#linearPartWithParameters()
	 * @generated
	 */
	EOperation getFunction__LinearPartWithParameters();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#linearPartAsFunction() <em>Linear Part As Function</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Linear Part As Function</em>' operation.
	 * @see org.polymodel.Function#linearPartAsFunction()
	 * @generated
	 */
	EOperation getFunction__LinearPartAsFunction();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#constantPart() <em>Constant Part</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Constant Part</em>' operation.
	 * @see org.polymodel.Function#constantPart()
	 * @generated
	 */
	EOperation getFunction__ConstantPart();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#isUniform() <em>Is Uniform</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Uniform</em>' operation.
	 * @see org.polymodel.Function#isUniform()
	 * @generated
	 */
	EOperation getFunction__IsUniform();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Function#isIdentity() <em>Is Identity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Identity</em>' operation.
	 * @see org.polymodel.Function#isIdentity()
	 * @generated
	 */
	EOperation getFunction__IsIdentity();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.Function#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dimensions</em>'.
	 * @see org.polymodel.Function#getDimensions()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Dimensions();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Value Contained Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Contained Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyKind="reference" keyType="K"
	 *        valueKind="reference" valueType="V" valueContainment="true"
	 * @generated
	 */
	EClass getValueContainedMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getValueContainedMap()
	 * @generated
	 */
	EReference getValueContainedMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getValueContainedMap()
	 * @generated
	 */
	EReference getValueContainedMap_Value();

	/**
	 * Returns the meta object for class '{@link org.polymodel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.polymodel.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Relation#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.Relation#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getRelation__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.polymodel.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.Label#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.Label#getName()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Name();

	/**
	 * Returns the meta object for the '{@link org.polymodel.Label#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.Label#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getLabel__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.RelationDimension <em>Relation Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Dimension</em>'.
	 * @see org.polymodel.RelationDimension
	 * @generated
	 */
	EClass getRelationDimension();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.RelationDimension#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dimension</em>'.
	 * @see org.polymodel.RelationDimension#getDimension()
	 * @see #getRelationDimension()
	 * @generated
	 */
	EReference getRelationDimension_Dimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.RelationDimension#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.RelationDimension#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getRelationDimension__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.InputDimension <em>Input Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Dimension</em>'.
	 * @see org.polymodel.InputDimension
	 * @generated
	 */
	EClass getInputDimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.InputDimension#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.InputDimension#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getInputDimension__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.OutputDimension <em>Output Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Dimension</em>'.
	 * @see org.polymodel.OutputDimension
	 * @generated
	 */
	EClass getOutputDimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.OutputDimension#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.OutputDimension#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getOutputDimension__Accept__PolymodelVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.PolymodelVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.polymodel.PolymodelVisitor
	 * @generated
	 */
	EClass getPolymodelVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitDomain(org.polymodel.Domain) <em>Visit Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Domain</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitDomain(org.polymodel.Domain)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitDomain__Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitDimensionsManager(org.polymodel.DimensionsManager) <em>Visit Dimensions Manager</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Dimensions Manager</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitDimensionsManager(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitDimensionsManager__DimensionsManager();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitExistentialVariable(org.polymodel.ExistentialVariable) <em>Visit Existential Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Existential Variable</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitExistentialVariable(org.polymodel.ExistentialVariable)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitExistentialVariable__ExistentialVariable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitDomainDimensions(org.polymodel.DomainDimensions) <em>Visit Domain Dimensions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Domain Dimensions</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitDomainDimensions(org.polymodel.DomainDimensions)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitDomainDimensions__DomainDimensions();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitIndexDimension(org.polymodel.IndexDimension) <em>Visit Index Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Index Dimension</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitIndexDimension(org.polymodel.IndexDimension)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitIndexDimension__IndexDimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitRelationDimensions(org.polymodel.RelationDimensions) <em>Visit Relation Dimensions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Relation Dimensions</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitRelationDimensions(org.polymodel.RelationDimensions)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitRelationDimensions__RelationDimensions();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitBasicRelation(org.polymodel.BasicRelation) <em>Visit Basic Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Basic Relation</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitBasicRelation(org.polymodel.BasicRelation)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitBasicRelation__BasicRelation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitFunction(org.polymodel.Function) <em>Visit Function</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Function</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitFunction(org.polymodel.Function)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitFunction__Function();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitRelation(org.polymodel.Relation) <em>Visit Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Relation</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitRelation(org.polymodel.Relation)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitRelation__Relation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitLabel(org.polymodel.Label) <em>Visit Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Label</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitLabel(org.polymodel.Label)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitLabel__Label();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitInputDimension(org.polymodel.InputDimension) <em>Visit Input Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Input Dimension</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitInputDimension(org.polymodel.InputDimension)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitInputDimension__InputDimension();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitor#visitOutputDimension(org.polymodel.OutputDimension) <em>Visit Output Dimension</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Output Dimension</em>' operation.
	 * @see org.polymodel.PolymodelVisitor#visitOutputDimension(org.polymodel.OutputDimension)
	 * @generated
	 */
	EOperation getPolymodelVisitor__VisitOutputDimension__OutputDimension();

	/**
	 * Returns the meta object for class '{@link org.polymodel.PolymodelVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.polymodel.PolymodelVisitable
	 * @generated
	 */
	EClass getPolymodelVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.PolymodelVisitable#accept(org.polymodel.PolymodelVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.PolymodelVisitable#accept(org.polymodel.PolymodelVisitor)
	 * @generated
	 */
	EOperation getPolymodelVisitable__Accept__PolymodelVisitor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PolymodelFactory getPolymodelFactory();

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
		 * The meta object literal for the '{@link org.polymodel.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.DomainImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Polyhedra</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__POLYHEDRA = eINSTANCE.getDomain_Polyhedra();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__DIMENSIONS = eINSTANCE.getDomain_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__LABEL = eINSTANCE.getDomain_Label();

		/**
		 * The meta object literal for the '<em><b>Union</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___UNION__DOMAIN = eINSTANCE.getDomain__Union__Domain();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___IMAGE__ABSTRACTRELATION = eINSTANCE.getDomain__Image__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Difference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___DIFFERENCE__DOMAIN = eINSTANCE.getDomain__Difference__Domain();

		/**
		 * The meta object literal for the '<em><b>Intersection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___INTERSECTION__DOMAIN = eINSTANCE.getDomain__Intersection__Domain();

		/**
		 * The meta object literal for the '<em><b>Is Empty</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___IS_EMPTY = eINSTANCE.getDomain__IsEmpty();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___SIMPLIFY__DOMAIN = eINSTANCE.getDomain__Simplify__Domain();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___SIMPLIFY = eINSTANCE.getDomain__Simplify();

		/**
		 * The meta object literal for the '<em><b>Bounding Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___BOUNDING_BOX = eINSTANCE.getDomain__BoundingBox();

		/**
		 * The meta object literal for the '<em><b>Equivalence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___EQUIVALENCE__DOMAIN = eINSTANCE.getDomain__Equivalence__Domain();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___ACCEPT__POLYMODELVISITOR = eINSTANCE.getDomain__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Is Universe</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___IS_UNIVERSE = eINSTANCE.getDomain__IsUniverse();

		/**
		 * The meta object literal for the '<em><b>Lex Min</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___LEX_MIN = eINSTANCE.getDomain__LexMin();

		/**
		 * The meta object literal for the '<em><b>Lex Max</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___LEX_MAX = eINSTANCE.getDomain__LexMax();

		/**
		 * The meta object literal for the '<em><b>Detect Equalities</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___DETECT_EQUALITIES = eINSTANCE.getDomain__DetectEqualities();

		/**
		 * The meta object literal for the '<em><b>Affine Hull</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___AFFINE_HULL = eINSTANCE.getDomain__AffineHull();

		/**
		 * The meta object literal for the '<em><b>Polyhedral Hull</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___POLYHEDRAL_HULL = eINSTANCE.getDomain__PolyhedralHull();

		/**
		 * The meta object literal for the '<em><b>To Matrices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___TO_MATRICES = eINSTANCE.getDomain__ToMatrices();

		/**
		 * The meta object literal for the '<em><b>Complement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___COMPLEMENT = eINSTANCE.getDomain__Complement();

		/**
		 * The meta object literal for the '<em><b>Cartesian Product</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___CARTESIAN_PRODUCT__DOMAIN = eINSTANCE.getDomain__CartesianProduct__Domain();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.DimensionsManagerImpl <em>Dimensions Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.DimensionsManagerImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getDimensionsManager()
		 * @generated
		 */
		EClass DIMENSIONS_MANAGER = eINSTANCE.getDimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSIONS_MANAGER__DIMENSIONS = eINSTANCE.getDimensionsManager_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSIONS_MANAGER__PARAMETERS = eINSTANCE.getDimensionsManager_Parameters();

		/**
		 * The meta object literal for the '<em><b>Inputs Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSIONS_MANAGER__INPUTS_DIMENSIONS = eINSTANCE.getDimensionsManager_InputsDimensions();

		/**
		 * The meta object literal for the '<em><b>Outputs Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS = eINSTANCE.getDimensionsManager_OutputsDimensions();

		/**
		 * The meta object literal for the '<em><b>Get Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_DIMENSION__INT = eINSTANCE.getDimensionsManager__GetDimension__int();

		/**
		 * The meta object literal for the '<em><b>Get Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_DIMENSION__INT_STRING = eINSTANCE.getDimensionsManager__GetDimension__int_String();

		/**
		 * The meta object literal for the '<em><b>Get Input Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_INPUT_DIMENSION__VARIABLE = eINSTANCE.getDimensionsManager__GetInputDimension__Variable();

		/**
		 * The meta object literal for the '<em><b>Get Output Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_OUTPUT_DIMENSION__VARIABLE = eINSTANCE.getDimensionsManager__GetOutputDimension__Variable();

		/**
		 * The meta object literal for the '<em><b>Get Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_PARAMETER__INT = eINSTANCE.getDimensionsManager__GetParameter__int();

		/**
		 * The meta object literal for the '<em><b>Get Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___GET_PARAMETER__INT_STRING = eINSTANCE.getDimensionsManager__GetParameter__int_String();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSIONS_MANAGER___ACCEPT__POLYMODELVISITOR = eINSTANCE.getDimensionsManager__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.AbstractRelationImpl <em>Abstract Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.AbstractRelationImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getAbstractRelation()
		 * @generated
		 */
		EClass ABSTRACT_RELATION = eINSTANCE.getAbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RELATION__DIMENSIONS = eINSTANCE.getAbstractRelation_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Basic Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RELATION__BASIC_RELATIONS = eINSTANCE.getAbstractRelation_BasicRelations();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getAbstractRelation__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Reverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___REVERSE__DIMENSIONSMANAGER = eINSTANCE.getAbstractRelation__Reverse__DimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Is Bijective</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___IS_BIJECTIVE = eINSTANCE.getAbstractRelation__IsBijective();

		/**
		 * The meta object literal for the '<em><b>Is Single Valued</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___IS_SINGLE_VALUED = eINSTANCE.getAbstractRelation__IsSingleValued();

		/**
		 * The meta object literal for the '<em><b>Is Empty</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___IS_EMPTY = eINSTANCE.getAbstractRelation__IsEmpty();

		/**
		 * The meta object literal for the '<em><b>Equivalence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___EQUIVALENCE__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__Equivalence__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Intersect Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___INTERSECT_DOMAIN__DOMAIN = eINSTANCE.getAbstractRelation__IntersectDomain__Domain();

		/**
		 * The meta object literal for the '<em><b>Intersect Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___INTERSECT_RANGE__DOMAIN = eINSTANCE.getAbstractRelation__IntersectRange__Domain();

		/**
		 * The meta object literal for the '<em><b>Intersection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___INTERSECTION__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__Intersection__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Union</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___UNION__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__Union__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Difference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___DIFFERENCE__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__Difference__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Build Function</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___BUILD_FUNCTION = eINSTANCE.getAbstractRelation__BuildFunction();

		/**
		 * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___GET_DOMAIN = eINSTANCE.getAbstractRelation__GetDomain();

		/**
		 * The meta object literal for the '<em><b>Get Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___GET_RANGE = eINSTANCE.getAbstractRelation__GetRange();

		/**
		 * The meta object literal for the '<em><b>Apply Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___APPLY_DOMAIN__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__ApplyDomain__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Apply Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___APPLY_RANGE__ABSTRACTRELATION = eINSTANCE.getAbstractRelation__ApplyRange__AbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Transitive Closure</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___TRANSITIVE_CLOSURE = eINSTANCE.getAbstractRelation__TransitiveClosure();

		/**
		 * The meta object literal for the '<em><b>Exact Transitive Closure</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___EXACT_TRANSITIVE_CLOSURE = eINSTANCE.getAbstractRelation__ExactTransitiveClosure();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___SIMPLIFY = eINSTANCE.getAbstractRelation__Simplify();

		/**
		 * The meta object literal for the '<em><b>To Matrices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_RELATION___TO_MATRICES = eINSTANCE.getAbstractRelation__ToMatrices();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.ExistentialVariableImpl <em>Existential Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.ExistentialVariableImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getExistentialVariable()
		 * @generated
		 */
		EClass EXISTENTIAL_VARIABLE = eINSTANCE.getExistentialVariable();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTENTIAL_VARIABLE__DEFINITION = eINSTANCE.getExistentialVariable_Definition();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTENTIAL_VARIABLE__DOMAIN = eINSTANCE.getExistentialVariable_Domain();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXISTENTIAL_VARIABLE___ACCEPT__POLYMODELVISITOR = eINSTANCE.getExistentialVariable__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.DomainDimensionsImpl <em>Domain Dimensions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.DomainDimensionsImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getDomainDimensions()
		 * @generated
		 */
		EClass DOMAIN_DIMENSIONS = eINSTANCE.getDomainDimensions();

		/**
		 * The meta object literal for the '<em><b>Indices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_DIMENSIONS__INDICES = eINSTANCE.getDomainDimensions_Indices();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_DIMENSIONS__PARAMETERS = eINSTANCE.getDomainDimensions_Parameters();

		/**
		 * The meta object literal for the '<em><b>Existential</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_DIMENSIONS__EXISTENTIAL = eINSTANCE.getDomainDimensions_Existential();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN_DIMENSIONS___COPY = eINSTANCE.getDomainDimensions__Copy();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN_DIMENSIONS___ACCEPT__POLYMODELVISITOR = eINSTANCE.getDomainDimensions__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Get Parameter Dimension Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE = eINSTANCE.getDomainDimensions__GetParameterDimensionOf__Variable();

		/**
		 * The meta object literal for the '<em><b>Get Dimension Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN_DIMENSIONS___GET_DIMENSION_OF__VARIABLE = eINSTANCE.getDomainDimensions__GetDimensionOf__Variable();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.IndexDimensionImpl <em>Index Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.IndexDimensionImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getIndexDimension()
		 * @generated
		 */
		EClass INDEX_DIMENSION = eINSTANCE.getIndexDimension();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DIMENSION__DIMENSION = eINSTANCE.getIndexDimension_Dimension();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INDEX_DIMENSION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getIndexDimension__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.RelationDimensionsImpl <em>Relation Dimensions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.RelationDimensionsImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getRelationDimensions()
		 * @generated
		 */
		EClass RELATION_DIMENSIONS = eINSTANCE.getRelationDimensions();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DIMENSIONS__INPUTS = eINSTANCE.getRelationDimensions_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DIMENSIONS__OUTPUTS = eINSTANCE.getRelationDimensions_Outputs();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DIMENSIONS__PARAMETERS = eINSTANCE.getRelationDimensions_Parameters();

		/**
		 * The meta object literal for the '<em><b>Existential</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DIMENSIONS__EXISTENTIAL = eINSTANCE.getRelationDimensions_Existential();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DIMENSIONS___ACCEPT__POLYMODELVISITOR = eINSTANCE.getRelationDimensions__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Get Parameter Dimension Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE = eINSTANCE.getRelationDimensions__GetParameterDimensionOf__Variable();

		/**
		 * The meta object literal for the '<em><b>Get Input Dimension Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DIMENSIONS___GET_INPUT_DIMENSION_OF__VARIABLE = eINSTANCE.getRelationDimensions__GetInputDimensionOf__Variable();

		/**
		 * The meta object literal for the '<em><b>Get Output Dimension Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DIMENSIONS___GET_OUTPUT_DIMENSION_OF__VARIABLE = eINSTANCE.getRelationDimensions__GetOutputDimensionOf__Variable();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.BasicRelationImpl <em>Basic Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.BasicRelationImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getBasicRelation()
		 * @generated
		 */
		EClass BASIC_RELATION = eINSTANCE.getBasicRelation();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_RELATION__INPUT = eINSTANCE.getBasicRelation_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_RELATION__OUTPUT = eINSTANCE.getBasicRelation_Output();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_RELATION__RELATION = eINSTANCE.getBasicRelation_Relation();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_RELATION__IN = eINSTANCE.getBasicRelation_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_RELATION__OUT = eINSTANCE.getBasicRelation_Out();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BASIC_RELATION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getBasicRelation__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.FunctionImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Expressions Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__EXPRESSIONS_MAP = eINSTANCE.getFunction_ExpressionsMap();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__IN = eINSTANCE.getFunction_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__OUT = eINSTANCE.getFunction_Out();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getFunction__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Get Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___GET_EXPRESSION__INT = eINSTANCE.getFunction__GetExpression__int();

		/**
		 * The meta object literal for the '<em><b>Get Expressions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___GET_EXPRESSIONS = eINSTANCE.getFunction__GetExpressions();

		/**
		 * The meta object literal for the '<em><b>Build Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER = eINSTANCE.getFunction__BuildRelation__DimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Equivalence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___EQUIVALENCE__FUNCTION = eINSTANCE.getFunction__Equivalence__Function();

		/**
		 * The meta object literal for the '<em><b>Compose</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___COMPOSE__FUNCTION = eINSTANCE.getFunction__Compose__Function();

		/**
		 * The meta object literal for the '<em><b>Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___INVERSE__DIMENSIONSMANAGER = eINSTANCE.getFunction__Inverse__DimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Inverse In Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN = eINSTANCE.getFunction__InverseInContext__DimensionsManager_Domain();

		/**
		 * The meta object literal for the '<em><b>To Matrix</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___TO_MATRIX = eINSTANCE.getFunction__ToMatrix();

		/**
		 * The meta object literal for the '<em><b>Uniformize In Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN = eINSTANCE.getFunction__UniformizeInContext__Domain();

		/**
		 * The meta object literal for the '<em><b>Nullspace</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___NULLSPACE = eINSTANCE.getFunction__Nullspace();

		/**
		 * The meta object literal for the '<em><b>Linear Part</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___LINEAR_PART = eINSTANCE.getFunction__LinearPart();

		/**
		 * The meta object literal for the '<em><b>Linear Part With Parameters</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___LINEAR_PART_WITH_PARAMETERS = eINSTANCE.getFunction__LinearPartWithParameters();

		/**
		 * The meta object literal for the '<em><b>Linear Part As Function</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___LINEAR_PART_AS_FUNCTION = eINSTANCE.getFunction__LinearPartAsFunction();

		/**
		 * The meta object literal for the '<em><b>Constant Part</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___CONSTANT_PART = eINSTANCE.getFunction__ConstantPart();

		/**
		 * The meta object literal for the '<em><b>Is Uniform</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___IS_UNIFORM = eINSTANCE.getFunction__IsUniform();

		/**
		 * The meta object literal for the '<em><b>Is Identity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___IS_IDENTITY = eINSTANCE.getFunction__IsIdentity();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__DIMENSIONS = eINSTANCE.getFunction_Dimensions();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.ValueContainedMapImpl <em>Value Contained Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.ValueContainedMapImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getValueContainedMap()
		 * @generated
		 */
		EClass VALUE_CONTAINED_MAP = eINSTANCE.getValueContainedMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_CONTAINED_MAP__KEY = eINSTANCE.getValueContainedMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_CONTAINED_MAP__VALUE = eINSTANCE.getValueContainedMap_Value();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.RelationImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getRelation__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.LabelImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LABEL___ACCEPT__POLYMODELVISITOR = eINSTANCE.getLabel__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.RelationDimensionImpl <em>Relation Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.RelationDimensionImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getRelationDimension()
		 * @generated
		 */
		EClass RELATION_DIMENSION = eINSTANCE.getRelationDimension();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DIMENSION__DIMENSION = eINSTANCE.getRelationDimension_Dimension();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DIMENSION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getRelationDimension__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.InputDimensionImpl <em>Input Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.InputDimensionImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getInputDimension()
		 * @generated
		 */
		EClass INPUT_DIMENSION = eINSTANCE.getInputDimension();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INPUT_DIMENSION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getInputDimension__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.OutputDimensionImpl <em>Output Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.OutputDimensionImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getOutputDimension()
		 * @generated
		 */
		EClass OUTPUT_DIMENSION = eINSTANCE.getOutputDimension();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OUTPUT_DIMENSION___ACCEPT__POLYMODELVISITOR = eINSTANCE.getOutputDimension__Accept__PolymodelVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.impl.PolymodelVisitorImpl <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.impl.PolymodelVisitorImpl
		 * @see org.polymodel.impl.PolymodelPackageImpl#getPolymodelVisitor()
		 * @generated
		 */
		EClass POLYMODEL_VISITOR = eINSTANCE.getPolymodelVisitor();

		/**
		 * The meta object literal for the '<em><b>Visit Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_DOMAIN__DOMAIN = eINSTANCE.getPolymodelVisitor__VisitDomain__Domain();

		/**
		 * The meta object literal for the '<em><b>Visit Dimensions Manager</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_DIMENSIONS_MANAGER__DIMENSIONSMANAGER = eINSTANCE.getPolymodelVisitor__VisitDimensionsManager__DimensionsManager();

		/**
		 * The meta object literal for the '<em><b>Visit Existential Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_EXISTENTIAL_VARIABLE__EXISTENTIALVARIABLE = eINSTANCE.getPolymodelVisitor__VisitExistentialVariable__ExistentialVariable();

		/**
		 * The meta object literal for the '<em><b>Visit Domain Dimensions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_DOMAIN_DIMENSIONS__DOMAINDIMENSIONS = eINSTANCE.getPolymodelVisitor__VisitDomainDimensions__DomainDimensions();

		/**
		 * The meta object literal for the '<em><b>Visit Index Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_INDEX_DIMENSION__INDEXDIMENSION = eINSTANCE.getPolymodelVisitor__VisitIndexDimension__IndexDimension();

		/**
		 * The meta object literal for the '<em><b>Visit Relation Dimensions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_RELATION_DIMENSIONS__RELATIONDIMENSIONS = eINSTANCE.getPolymodelVisitor__VisitRelationDimensions__RelationDimensions();

		/**
		 * The meta object literal for the '<em><b>Visit Basic Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_BASIC_RELATION__BASICRELATION = eINSTANCE.getPolymodelVisitor__VisitBasicRelation__BasicRelation();

		/**
		 * The meta object literal for the '<em><b>Visit Function</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_FUNCTION__FUNCTION = eINSTANCE.getPolymodelVisitor__VisitFunction__Function();

		/**
		 * The meta object literal for the '<em><b>Visit Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_RELATION__RELATION = eINSTANCE.getPolymodelVisitor__VisitRelation__Relation();

		/**
		 * The meta object literal for the '<em><b>Visit Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_LABEL__LABEL = eINSTANCE.getPolymodelVisitor__VisitLabel__Label();

		/**
		 * The meta object literal for the '<em><b>Visit Input Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_INPUT_DIMENSION__INPUTDIMENSION = eINSTANCE.getPolymodelVisitor__VisitInputDimension__InputDimension();

		/**
		 * The meta object literal for the '<em><b>Visit Output Dimension</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITOR___VISIT_OUTPUT_DIMENSION__OUTPUTDIMENSION = eINSTANCE.getPolymodelVisitor__VisitOutputDimension__OutputDimension();

		/**
		 * The meta object literal for the '{@link org.polymodel.PolymodelVisitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.PolymodelVisitable
		 * @see org.polymodel.impl.PolymodelPackageImpl#getPolymodelVisitable()
		 * @generated
		 */
		EClass POLYMODEL_VISITABLE = eINSTANCE.getPolymodelVisitable();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYMODEL_VISITABLE___ACCEPT__POLYMODELVISITOR = eINSTANCE.getPolymodelVisitable__Accept__PolymodelVisitor();

	}

} //PolymodelPackage
