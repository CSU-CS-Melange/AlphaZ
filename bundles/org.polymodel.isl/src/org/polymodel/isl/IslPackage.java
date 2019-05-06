/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.PolymodelPackage;

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
 * @see org.polymodel.isl.IslFactory
 * @model kind="package"
 * @generated
 */
public interface IslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "isl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.isl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.polymodel.isl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IslPackage eINSTANCE = org.polymodel.isl.impl.IslPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLMapImpl <em>ISL Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLMapImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLMap()
	 * @generated
	 */
	int ISL_MAP = 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP__DIMENSIONS = PolymodelPackage.RELATION__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Basic Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP__BASIC_RELATIONS = PolymodelPackage.RELATION__BASIC_RELATIONS;

	/**
	 * The number of structural features of the '<em>ISL Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP_FEATURE_COUNT = PolymodelPackage.RELATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Reverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___REVERSE__DIMENSIONSMANAGER = PolymodelPackage.RELATION___REVERSE__DIMENSIONSMANAGER;

	/**
	 * The operation id for the '<em>Is Bijective</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___IS_BIJECTIVE = PolymodelPackage.RELATION___IS_BIJECTIVE;

	/**
	 * The operation id for the '<em>Is Single Valued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___IS_SINGLE_VALUED = PolymodelPackage.RELATION___IS_SINGLE_VALUED;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___IS_EMPTY = PolymodelPackage.RELATION___IS_EMPTY;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___EQUIVALENCE__ABSTRACTRELATION = PolymodelPackage.RELATION___EQUIVALENCE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Intersect Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___INTERSECT_DOMAIN__DOMAIN = PolymodelPackage.RELATION___INTERSECT_DOMAIN__DOMAIN;

	/**
	 * The operation id for the '<em>Intersect Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___INTERSECT_RANGE__DOMAIN = PolymodelPackage.RELATION___INTERSECT_RANGE__DOMAIN;

	/**
	 * The operation id for the '<em>Intersection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___INTERSECTION__ABSTRACTRELATION = PolymodelPackage.RELATION___INTERSECTION__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Union</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___UNION__ABSTRACTRELATION = PolymodelPackage.RELATION___UNION__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___DIFFERENCE__ABSTRACTRELATION = PolymodelPackage.RELATION___DIFFERENCE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Build Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___BUILD_FUNCTION = PolymodelPackage.RELATION___BUILD_FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___GET_DOMAIN = PolymodelPackage.RELATION___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___GET_RANGE = PolymodelPackage.RELATION___GET_RANGE;

	/**
	 * The operation id for the '<em>Apply Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___APPLY_DOMAIN__ABSTRACTRELATION = PolymodelPackage.RELATION___APPLY_DOMAIN__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Apply Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___APPLY_RANGE__ABSTRACTRELATION = PolymodelPackage.RELATION___APPLY_RANGE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___TRANSITIVE_CLOSURE = PolymodelPackage.RELATION___TRANSITIVE_CLOSURE;

	/**
	 * The operation id for the '<em>Exact Transitive Closure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___EXACT_TRANSITIVE_CLOSURE = PolymodelPackage.RELATION___EXACT_TRANSITIVE_CLOSURE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___SIMPLIFY = PolymodelPackage.RELATION___SIMPLIFY;

	/**
	 * The operation id for the '<em>To Matrices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___TO_MATRICES = PolymodelPackage.RELATION___TO_MATRICES;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP___ACCEPT__POLYMODELVISITOR = PolymodelPackage.RELATION___ACCEPT__POLYMODELVISITOR;

	/**
	 * The number of operations of the '<em>ISL Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_MAP_OPERATION_COUNT = PolymodelPackage.RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLSetImpl <em>ISL Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLSetImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLSet()
	 * @generated
	 */
	int ISL_SET = 1;

	/**
	 * The feature id for the '<em><b>Polyhedra</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET__POLYHEDRA = PolymodelPackage.DOMAIN__POLYHEDRA;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET__DIMENSIONS = PolymodelPackage.DOMAIN__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET__LABEL = PolymodelPackage.DOMAIN__LABEL;

	/**
	 * The number of structural features of the '<em>ISL Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET_FEATURE_COUNT = PolymodelPackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Union</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___UNION__DOMAIN = PolymodelPackage.DOMAIN___UNION__DOMAIN;

	/**
	 * The operation id for the '<em>Image</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___IMAGE__ABSTRACTRELATION = PolymodelPackage.DOMAIN___IMAGE__ABSTRACTRELATION;

	/**
	 * The operation id for the '<em>Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___DIFFERENCE__DOMAIN = PolymodelPackage.DOMAIN___DIFFERENCE__DOMAIN;

	/**
	 * The operation id for the '<em>Intersection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___INTERSECTION__DOMAIN = PolymodelPackage.DOMAIN___INTERSECTION__DOMAIN;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___IS_EMPTY = PolymodelPackage.DOMAIN___IS_EMPTY;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___SIMPLIFY__DOMAIN = PolymodelPackage.DOMAIN___SIMPLIFY__DOMAIN;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___SIMPLIFY = PolymodelPackage.DOMAIN___SIMPLIFY;

	/**
	 * The operation id for the '<em>Bounding Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___BOUNDING_BOX = PolymodelPackage.DOMAIN___BOUNDING_BOX;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___EQUIVALENCE__DOMAIN = PolymodelPackage.DOMAIN___EQUIVALENCE__DOMAIN;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___ACCEPT__POLYMODELVISITOR = PolymodelPackage.DOMAIN___ACCEPT__POLYMODELVISITOR;

	/**
	 * The operation id for the '<em>Is Universe</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___IS_UNIVERSE = PolymodelPackage.DOMAIN___IS_UNIVERSE;

	/**
	 * The operation id for the '<em>Lex Min</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___LEX_MIN = PolymodelPackage.DOMAIN___LEX_MIN;

	/**
	 * The operation id for the '<em>Lex Max</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___LEX_MAX = PolymodelPackage.DOMAIN___LEX_MAX;

	/**
	 * The operation id for the '<em>Detect Equalities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___DETECT_EQUALITIES = PolymodelPackage.DOMAIN___DETECT_EQUALITIES;

	/**
	 * The operation id for the '<em>Affine Hull</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___AFFINE_HULL = PolymodelPackage.DOMAIN___AFFINE_HULL;

	/**
	 * The operation id for the '<em>Polyhedral Hull</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___POLYHEDRAL_HULL = PolymodelPackage.DOMAIN___POLYHEDRAL_HULL;

	/**
	 * The operation id for the '<em>To Matrices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___TO_MATRICES = PolymodelPackage.DOMAIN___TO_MATRICES;

	/**
	 * The operation id for the '<em>Complement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET___COMPLEMENT = PolymodelPackage.DOMAIN___COMPLEMENT;

	/**
	 * The number of operations of the '<em>ISL Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_SET_OPERATION_COUNT = PolymodelPackage.DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLUnionMapImpl <em>ISL Union Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLUnionMapImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLUnionMap()
	 * @generated
	 */
	int ISL_UNION_MAP = 2;

	/**
	 * The feature id for the '<em><b>Maps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_MAP__MAPS = 0;

	/**
	 * The number of structural features of the '<em>ISL Union Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_MAP_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Lex Max</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_MAP___LEX_MAX__DIMENSIONSMANAGER = 0;

	/**
	 * The number of operations of the '<em>ISL Union Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_MAP_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLUnionSetImpl <em>ISL Union Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLUnionSetImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLUnionSet()
	 * @generated
	 */
	int ISL_UNION_SET = 3;

	/**
	 * The feature id for the '<em><b>Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_SET__SETS = 0;

	/**
	 * The number of structural features of the '<em>ISL Union Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_SET_FEATURE_COUNT = 1;


	/**
	 * The number of operations of the '<em>ISL Union Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_UNION_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLBasicMapImpl <em>ISL Basic Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLBasicMapImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLBasicMap()
	 * @generated
	 */
	int ISL_BASIC_MAP = 4;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP__INPUT = PolymodelPackage.BASIC_RELATION__INPUT;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP__OUTPUT = PolymodelPackage.BASIC_RELATION__OUTPUT;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP__RELATION = PolymodelPackage.BASIC_RELATION__RELATION;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP__IN = PolymodelPackage.BASIC_RELATION__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP__OUT = PolymodelPackage.BASIC_RELATION__OUT;

	/**
	 * The number of structural features of the '<em>ISL Basic Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP_FEATURE_COUNT = PolymodelPackage.BASIC_RELATION_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP___ACCEPT__POLYMODELVISITOR = PolymodelPackage.BASIC_RELATION___ACCEPT__POLYMODELVISITOR;

	/**
	 * The number of operations of the '<em>ISL Basic Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_BASIC_MAP_OPERATION_COUNT = PolymodelPackage.BASIC_RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLPointImpl <em>ISL Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLPointImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLPoint()
	 * @generated
	 */
	int ISL_POINT = 5;

	/**
	 * The feature id for the '<em><b>Coordinates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_POINT__COORDINATES = 0;

	/**
	 * The number of structural features of the '<em>ISL Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_POINT_FEATURE_COUNT = 1;


	/**
	 * The number of operations of the '<em>ISL Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.isl.impl.ISLFunctionImpl <em>ISL Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.isl.impl.ISLFunctionImpl
	 * @see org.polymodel.isl.impl.IslPackageImpl#getISLFunction()
	 * @generated
	 */
	int ISL_FUNCTION = 6;

	/**
	 * The feature id for the '<em><b>Expressions Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION__EXPRESSIONS_MAP = PolymodelPackage.FUNCTION__EXPRESSIONS_MAP;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION__DIMENSIONS = PolymodelPackage.FUNCTION__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION__IN = PolymodelPackage.FUNCTION__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION__OUT = PolymodelPackage.FUNCTION__OUT;

	/**
	 * The number of structural features of the '<em>ISL Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION_FEATURE_COUNT = PolymodelPackage.FUNCTION_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___ACCEPT__POLYMODELVISITOR = PolymodelPackage.FUNCTION___ACCEPT__POLYMODELVISITOR;

	/**
	 * The operation id for the '<em>Get Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___GET_EXPRESSION__INT = PolymodelPackage.FUNCTION___GET_EXPRESSION__INT;

	/**
	 * The operation id for the '<em>Get Expressions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___GET_EXPRESSIONS = PolymodelPackage.FUNCTION___GET_EXPRESSIONS;

	/**
	 * The operation id for the '<em>Build Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER = PolymodelPackage.FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___EQUIVALENCE__FUNCTION = PolymodelPackage.FUNCTION___EQUIVALENCE__FUNCTION;

	/**
	 * The operation id for the '<em>Compose</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___COMPOSE__FUNCTION = PolymodelPackage.FUNCTION___COMPOSE__FUNCTION;

	/**
	 * The operation id for the '<em>Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___INVERSE__DIMENSIONSMANAGER = PolymodelPackage.FUNCTION___INVERSE__DIMENSIONSMANAGER;

	/**
	 * The operation id for the '<em>Inverse In Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN = PolymodelPackage.FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN;

	/**
	 * The operation id for the '<em>To Matrix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___TO_MATRIX = PolymodelPackage.FUNCTION___TO_MATRIX;

	/**
	 * The operation id for the '<em>Uniformize In Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN = PolymodelPackage.FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN;

	/**
	 * The operation id for the '<em>Nullspace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___NULLSPACE = PolymodelPackage.FUNCTION___NULLSPACE;

	/**
	 * The operation id for the '<em>Linear Part</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___LINEAR_PART = PolymodelPackage.FUNCTION___LINEAR_PART;

	/**
	 * The operation id for the '<em>Linear Part With Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___LINEAR_PART_WITH_PARAMETERS = PolymodelPackage.FUNCTION___LINEAR_PART_WITH_PARAMETERS;

	/**
	 * The operation id for the '<em>Linear Part As Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___LINEAR_PART_AS_FUNCTION = PolymodelPackage.FUNCTION___LINEAR_PART_AS_FUNCTION;

	/**
	 * The operation id for the '<em>Constant Part</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___CONSTANT_PART = PolymodelPackage.FUNCTION___CONSTANT_PART;

	/**
	 * The operation id for the '<em>Is Uniform</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___IS_UNIFORM = PolymodelPackage.FUNCTION___IS_UNIFORM;

	/**
	 * The operation id for the '<em>Is Identity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION___IS_IDENTITY = PolymodelPackage.FUNCTION___IS_IDENTITY;

	/**
	 * The number of operations of the '<em>ISL Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISL_FUNCTION_OPERATION_COUNT = PolymodelPackage.FUNCTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLMap <em>ISL Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Map</em>'.
	 * @see org.polymodel.isl.ISLMap
	 * @generated
	 */
	EClass getISLMap();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLSet <em>ISL Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Set</em>'.
	 * @see org.polymodel.isl.ISLSet
	 * @generated
	 */
	EClass getISLSet();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLUnionMap <em>ISL Union Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Union Map</em>'.
	 * @see org.polymodel.isl.ISLUnionMap
	 * @generated
	 */
	EClass getISLUnionMap();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.isl.ISLUnionMap#getMaps <em>Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maps</em>'.
	 * @see org.polymodel.isl.ISLUnionMap#getMaps()
	 * @see #getISLUnionMap()
	 * @generated
	 */
	EReference getISLUnionMap_Maps();

	/**
	 * Returns the meta object for the '{@link org.polymodel.isl.ISLUnionMap#lexMax(org.polymodel.DimensionsManager) <em>Lex Max</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lex Max</em>' operation.
	 * @see org.polymodel.isl.ISLUnionMap#lexMax(org.polymodel.DimensionsManager)
	 * @generated
	 */
	EOperation getISLUnionMap__LexMax__DimensionsManager();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLUnionSet <em>ISL Union Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Union Set</em>'.
	 * @see org.polymodel.isl.ISLUnionSet
	 * @generated
	 */
	EClass getISLUnionSet();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.isl.ISLUnionSet#getSets <em>Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sets</em>'.
	 * @see org.polymodel.isl.ISLUnionSet#getSets()
	 * @see #getISLUnionSet()
	 * @generated
	 */
	EReference getISLUnionSet_Sets();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLBasicMap <em>ISL Basic Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Basic Map</em>'.
	 * @see org.polymodel.isl.ISLBasicMap
	 * @generated
	 */
	EClass getISLBasicMap();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLPoint <em>ISL Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Point</em>'.
	 * @see org.polymodel.isl.ISLPoint
	 * @generated
	 */
	EClass getISLPoint();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.isl.ISLPoint#getCoordinates <em>Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Coordinates</em>'.
	 * @see org.polymodel.isl.ISLPoint#getCoordinates()
	 * @see #getISLPoint()
	 * @generated
	 */
	EAttribute getISLPoint_Coordinates();

	/**
	 * Returns the meta object for class '{@link org.polymodel.isl.ISLFunction <em>ISL Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISL Function</em>'.
	 * @see org.polymodel.isl.ISLFunction
	 * @generated
	 */
	EClass getISLFunction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IslFactory getIslFactory();

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
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLMapImpl <em>ISL Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLMapImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLMap()
		 * @generated
		 */
		EClass ISL_MAP = eINSTANCE.getISLMap();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLSetImpl <em>ISL Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLSetImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLSet()
		 * @generated
		 */
		EClass ISL_SET = eINSTANCE.getISLSet();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLUnionMapImpl <em>ISL Union Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLUnionMapImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLUnionMap()
		 * @generated
		 */
		EClass ISL_UNION_MAP = eINSTANCE.getISLUnionMap();

		/**
		 * The meta object literal for the '<em><b>Maps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISL_UNION_MAP__MAPS = eINSTANCE.getISLUnionMap_Maps();

		/**
		 * The meta object literal for the '<em><b>Lex Max</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISL_UNION_MAP___LEX_MAX__DIMENSIONSMANAGER = eINSTANCE.getISLUnionMap__LexMax__DimensionsManager();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLUnionSetImpl <em>ISL Union Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLUnionSetImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLUnionSet()
		 * @generated
		 */
		EClass ISL_UNION_SET = eINSTANCE.getISLUnionSet();

		/**
		 * The meta object literal for the '<em><b>Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISL_UNION_SET__SETS = eINSTANCE.getISLUnionSet_Sets();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLBasicMapImpl <em>ISL Basic Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLBasicMapImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLBasicMap()
		 * @generated
		 */
		EClass ISL_BASIC_MAP = eINSTANCE.getISLBasicMap();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLPointImpl <em>ISL Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLPointImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLPoint()
		 * @generated
		 */
		EClass ISL_POINT = eINSTANCE.getISLPoint();

		/**
		 * The meta object literal for the '<em><b>Coordinates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISL_POINT__COORDINATES = eINSTANCE.getISLPoint_Coordinates();

		/**
		 * The meta object literal for the '{@link org.polymodel.isl.impl.ISLFunctionImpl <em>ISL Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.isl.impl.ISLFunctionImpl
		 * @see org.polymodel.isl.impl.IslPackageImpl#getISLFunction()
		 * @generated
		 */
		EClass ISL_FUNCTION = eINSTANCE.getISLFunction();

	}

} //IslPackage
