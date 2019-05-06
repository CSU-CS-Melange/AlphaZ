/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CFactory
 * @model kind="package"
 * @generated
 */
public interface CPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "C";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "C";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "C";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl <em>Equation As Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getEquationAsStatement()
	 * @generated
	 */
	int EQUATION_AS_STATEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__NAME = PolyIRCGPackage.STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__DOMAIN = PolyIRCGPackage.STATEMENT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__CONTAINER_LOOP = PolyIRCGPackage.STATEMENT__CONTAINER_LOOP;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__INLINED = PolyIRCGPackage.STATEMENT__INLINED;

	/**
	 * The feature id for the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__SCATTERING = PolyIRCGPackage.STATEMENT__SCATTERING;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__VARIABLE = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Access Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__ACCESS_FUNCTION = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__RHS = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Var Decl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT__VAR_DECL = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Equation As Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_AS_STATEMENT_FEATURE_COUNT = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParameterCheckImpl <em>Parameter Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ParameterCheckImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getParameterCheck()
	 * @generated
	 */
	int PARAMETER_CHECK = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CHECK__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CHECK__PARAMETER_DOMAIN = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CHECK_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getCLoop()
	 * @generated
	 */
	int CLOOP = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__FUNCTION = PolyIRCGPackage.LOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__PARAMETER_DOMAIN = PolyIRCGPackage.LOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__STATEMENTS = PolyIRCGPackage.LOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__DECLARE_ITERATORS = PolyIRCGPackage.LOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__ITERATOR_NAMES = PolyIRCGPackage.LOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__NUM_CONSTANT_DIMENSIONS = PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP__USE_MACROS = PolyIRCGPackage.LOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOOP_FEATURE_COUNT = PolyIRCGPackage.LOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl <em>Tiled CLoop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getTiledCLoop()
	 * @generated
	 */
	int TILED_CLOOP = 3;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__FUNCTION = CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__PARAMETER_DOMAIN = CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__STATEMENTS = CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__DECLARE_ITERATORS = CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__ITERATOR_NAMES = CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__NUM_CONSTANT_DIMENSIONS = CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__USE_MACROS = CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Optimize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__OPTIMIZE = CLOOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__TILES = CLOOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__ORDERING_DIMENSIONS = CLOOP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Optimized Point Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP__OPTIMIZED_POINT_LOOP = CLOOP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tiled CLoop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_CLOOP_FEATURE_COUNT = CLOOP_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl <em>Parallelized CLoop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getParallelizedCLoop()
	 * @generated
	 */
	int PARALLELIZED_CLOOP = 4;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__FUNCTION = CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__PARAMETER_DOMAIN = CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__STATEMENTS = CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__DECLARE_ITERATORS = CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__ITERATOR_NAMES = CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__NUM_CONSTANT_DIMENSIONS = CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__USE_MACROS = CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Parallelized Dims</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__PARALLELIZED_DIMS = CLOOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordering Dims</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__ORDERING_DIMS = CLOOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subsystem Variables</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES = CLOOP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parallelized CLoop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZED_CLOOP_FEATURE_COUNT = CLOOP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl <em>Scop Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getScopLoop()
	 * @generated
	 */
	int SCOP_LOOP = 5;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__FUNCTION = CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__PARAMETER_DOMAIN = CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__STATEMENTS = CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__DECLARE_ITERATORS = CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__ITERATOR_NAMES = CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__NUM_CONSTANT_DIMENSIONS = CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__USE_MACROS = CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Tiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__TILES = CLOOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scop Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP__SCOP_ROOT = CLOOP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scop Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_LOOP_FEATURE_COUNT = CLOOP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.CVariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CVariableImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getCVariable()
	 * @generated
	 */
	int CVARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__NAME = PolyIRCGPackage.CODE_GEN_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__CODEUNIT = PolyIRCGPackage.CODE_GEN_VARIABLE__CODEUNIT;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__GLOBAL = PolyIRCGPackage.CODE_GEN_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__TYPE = PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__DOMAIN = PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN;

	/**
	 * The feature id for the '<em><b>Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__ALIGNED = PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED;

	/**
	 * The feature id for the '<em><b>Flattened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__FLATTENED = PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED;

	/**
	 * The feature id for the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__ACCESS_EXPRESSION = PolyIRCGPackage.CODE_GEN_VARIABLE__ACCESS_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Isfrontpadded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__ISFRONTPADDED = PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED;

	/**
	 * The feature id for the '<em><b>Forntpadding Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE__FORNTPADDING_VALUE = PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVARIABLE_FEATURE_COUNT = PolyIRCGPackage.CODE_GEN_VARIABLE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl <em>DTiled Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTiledLoop()
	 * @generated
	 */
	int DTILED_LOOP = 7;

	/**
	 * The feature id for the '<em><b>Scop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_LOOP__SCOP = 0;

	/**
	 * The feature id for the '<em><b>Tiled Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_LOOP__TILED_BLOCKS = 1;

	/**
	 * The feature id for the '<em><b>Dtiling Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_LOOP__DTILING_OPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Generator Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_LOOP__GENERATOR_LOOP = 3;

	/**
	 * The number of structural features of the '<em>DTiled Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_LOOP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl <em>DTiled Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTiledBlock()
	 * @generated
	 */
	int DTILED_BLOCK = 8;

	/**
	 * The feature id for the '<em><b>Block Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK__BLOCK_START = 0;

	/**
	 * The feature id for the '<em><b>Point Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK__POINT_LOOP_START = 1;

	/**
	 * The feature id for the '<em><b>Tile Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK__TILE_LOOP_START = 2;

	/**
	 * The feature id for the '<em><b>Perfect Loop Nest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK__PERFECT_LOOP_NEST = 3;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK__CONTAINER_LOOP = 4;

	/**
	 * The number of structural features of the '<em>DTiled Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTILED_BLOCK_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl <em>Sub Tile Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getSubTileSpecification()
	 * @generated
	 */
	int SUB_TILE_SPECIFICATION = 9;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__LEVEL = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__START = 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__END = 2;

	/**
	 * The feature id for the '<em><b>Tile Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__TILE_SIZES = 3;

	/**
	 * The feature id for the '<em><b>Tile Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__TILE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Tile Index Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX = 5;

	/**
	 * The feature id for the '<em><b>Tile Size Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX = 6;

	/**
	 * The number of structural features of the '<em>Sub Tile Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILE_SPECIFICATION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl <em>Tile Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getTileSpecification()
	 * @generated
	 */
	int TILE_SPECIFICATION = 10;

	/**
	 * The feature id for the '<em><b>Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION__LEVELS = 0;

	/**
	 * The feature id for the '<em><b>Start Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION__START_DIM = 1;

	/**
	 * The feature id for the '<em><b>End Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION__END_DIM = 2;

	/**
	 * The feature id for the '<em><b>Sub Tiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION__SUB_TILES = 3;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION__ORDERING_PREFIX = 4;

	/**
	 * The number of structural features of the '<em>Tile Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_SPECIFICATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '<em>DTiling Options</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.dtiler.DTilingOptions
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTilingOptions()
	 * @generated
	 */
	int DTILING_OPTIONS = 11;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement <em>Equation As Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation As Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement
	 * @generated
	 */
	EClass getEquationAsStatement();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVariable()
	 * @see #getEquationAsStatement()
	 * @generated
	 */
	EReference getEquationAsStatement_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getAccessFunction <em>Access Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Access Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getAccessFunction()
	 * @see #getEquationAsStatement()
	 * @generated
	 */
	EReference getEquationAsStatement_AccessFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rhs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getRhs()
	 * @see #getEquationAsStatement()
	 * @generated
	 */
	EReference getEquationAsStatement_Rhs();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVarDecl <em>Var Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var Decl</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVarDecl()
	 * @see #getEquationAsStatement()
	 * @generated
	 */
	EReference getEquationAsStatement_VarDecl();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck <em>Parameter Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Check</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck
	 * @generated
	 */
	EClass getParameterCheck();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck#getParameterDomain <em>Parameter Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck#getParameterDomain()
	 * @see #getParameterCheck()
	 * @generated
	 */
	EReference getParameterCheck_ParameterDomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.CLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CLoop
	 * @generated
	 */
	EClass getCLoop();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.CLoop#isUseMacros <em>Use Macros</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Macros</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CLoop#isUseMacros()
	 * @see #getCLoop()
	 * @generated
	 */
	EAttribute getCLoop_UseMacros();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop <em>Tiled CLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tiled CLoop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop
	 * @generated
	 */
	EClass getTiledCLoop();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#isOptimize <em>Optimize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimize</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#isOptimize()
	 * @see #getTiledCLoop()
	 * @generated
	 */
	EAttribute getTiledCLoop_Optimize();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getTiles <em>Tiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tiles</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getTiles()
	 * @see #getTiledCLoop()
	 * @generated
	 */
	EReference getTiledCLoop_Tiles();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOrderingDimensions <em>Ordering Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordering Dimensions</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOrderingDimensions()
	 * @see #getTiledCLoop()
	 * @generated
	 */
	EAttribute getTiledCLoop_OrderingDimensions();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOptimizedPointLoop <em>Optimized Point Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Optimized Point Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOptimizedPointLoop()
	 * @see #getTiledCLoop()
	 * @generated
	 */
	EReference getTiledCLoop_OptimizedPointLoop();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop <em>Parallelized CLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallelized CLoop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop
	 * @generated
	 */
	EClass getParallelizedCLoop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getParallelizedDims <em>Parallelized Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parallelized Dims</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getParallelizedDims()
	 * @see #getParallelizedCLoop()
	 * @generated
	 */
	EReference getParallelizedCLoop_ParallelizedDims();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getOrderingDims <em>Ordering Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordering Dims</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getOrderingDims()
	 * @see #getParallelizedCLoop()
	 * @generated
	 */
	EAttribute getParallelizedCLoop_OrderingDims();

	/**
	 * Returns the meta object for the map '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getSubsystemVariables <em>Subsystem Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Subsystem Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getSubsystemVariables()
	 * @see #getParallelizedCLoop()
	 * @generated
	 */
	EReference getParallelizedCLoop_SubsystemVariables();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop <em>Scop Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scop Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop
	 * @generated
	 */
	EClass getScopLoop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getTiles <em>Tiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tiles</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getTiles()
	 * @see #getScopLoop()
	 * @generated
	 */
	EReference getScopLoop_Tiles();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getScopRoot <em>Scop Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scop Root</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getScopRoot()
	 * @see #getScopLoop()
	 * @generated
	 */
	EReference getScopLoop_ScopRoot();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.CVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CVariable
	 * @generated
	 */
	EClass getCVariable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop <em>DTiled Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTiled Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop
	 * @generated
	 */
	EClass getDTiledLoop();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getScop <em>Scop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getScop()
	 * @see #getDTiledLoop()
	 * @generated
	 */
	EReference getDTiledLoop_Scop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getTiledBlocks <em>Tiled Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tiled Blocks</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getTiledBlocks()
	 * @see #getDTiledLoop()
	 * @generated
	 */
	EReference getDTiledLoop_TiledBlocks();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getDtilingOptions <em>Dtiling Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dtiling Options</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getDtilingOptions()
	 * @see #getDTiledLoop()
	 * @generated
	 */
	EAttribute getDTiledLoop_DtilingOptions();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getGeneratorLoop <em>Generator Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generator Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getGeneratorLoop()
	 * @see #getDTiledLoop()
	 * @generated
	 */
	EReference getDTiledLoop_GeneratorLoop();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock <em>DTiled Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTiled Block</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock
	 * @generated
	 */
	EClass getDTiledBlock();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getBlockStart <em>Block Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Block Start</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getBlockStart()
	 * @see #getDTiledBlock()
	 * @generated
	 */
	EReference getDTiledBlock_BlockStart();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPointLoopStart <em>Point Loop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Point Loop Start</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPointLoopStart()
	 * @see #getDTiledBlock()
	 * @generated
	 */
	EReference getDTiledBlock_PointLoopStart();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getTileLoopStart <em>Tile Loop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tile Loop Start</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getTileLoopStart()
	 * @see #getDTiledBlock()
	 * @generated
	 */
	EReference getDTiledBlock_TileLoopStart();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPerfectLoopNest <em>Perfect Loop Nest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Perfect Loop Nest</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPerfectLoopNest()
	 * @see #getDTiledBlock()
	 * @generated
	 */
	EReference getDTiledBlock_PerfectLoopNest();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getContainerLoop <em>Container Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getContainerLoop()
	 * @see #getDTiledBlock()
	 * @generated
	 */
	EReference getDTiledBlock_ContainerLoop();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification <em>Sub Tile Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Tile Specification</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification
	 * @generated
	 */
	EClass getSubTileSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getLevel()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_Level();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getStart()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getEnd()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_End();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizes <em>Tile Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tile Sizes</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizes()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_TileSizes();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileType <em>Tile Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileType()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_TileType();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileIndexPrefix <em>Tile Index Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Index Prefix</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileIndexPrefix()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_TileIndexPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizePrefix <em>Tile Size Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Size Prefix</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizePrefix()
	 * @see #getSubTileSpecification()
	 * @generated
	 */
	EAttribute getSubTileSpecification_TileSizePrefix();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification <em>Tile Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tile Specification</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification
	 * @generated
	 */
	EClass getTileSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getLevels <em>Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Levels</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getLevels()
	 * @see #getTileSpecification()
	 * @generated
	 */
	EAttribute getTileSpecification_Levels();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getStartDim <em>Start Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Dim</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getStartDim()
	 * @see #getTileSpecification()
	 * @generated
	 */
	EAttribute getTileSpecification_StartDim();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getEndDim <em>End Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Dim</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getEndDim()
	 * @see #getTileSpecification()
	 * @generated
	 */
	EAttribute getTileSpecification_EndDim();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getSubTiles <em>Sub Tiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Tiles</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getSubTiles()
	 * @see #getTileSpecification()
	 * @generated
	 */
	EReference getTileSpecification_SubTiles();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getOrderingPrefix <em>Ordering Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordering Prefix</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getOrderingPrefix()
	 * @see #getTileSpecification()
	 * @generated
	 */
	EAttribute getTileSpecification_OrderingPrefix();

	/**
	 * Returns the meta object for data type '{@link org.polymodel.scop.dtiler.DTilingOptions <em>DTiling Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DTiling Options</em>'.
	 * @see org.polymodel.scop.dtiler.DTilingOptions
	 * @model instanceClass="org.polymodel.scop.dtiler.DTilingOptions"
	 * @generated
	 */
	EDataType getDTilingOptions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CFactory getCFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl <em>Equation As Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getEquationAsStatement()
		 * @generated
		 */
		EClass EQUATION_AS_STATEMENT = eINSTANCE.getEquationAsStatement();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_AS_STATEMENT__VARIABLE = eINSTANCE.getEquationAsStatement_Variable();

		/**
		 * The meta object literal for the '<em><b>Access Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_AS_STATEMENT__ACCESS_FUNCTION = eINSTANCE.getEquationAsStatement_AccessFunction();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_AS_STATEMENT__RHS = eINSTANCE.getEquationAsStatement_Rhs();

		/**
		 * The meta object literal for the '<em><b>Var Decl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_AS_STATEMENT__VAR_DECL = eINSTANCE.getEquationAsStatement_VarDecl();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParameterCheckImpl <em>Parameter Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ParameterCheckImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getParameterCheck()
		 * @generated
		 */
		EClass PARAMETER_CHECK = eINSTANCE.getParameterCheck();

		/**
		 * The meta object literal for the '<em><b>Parameter Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_CHECK__PARAMETER_DOMAIN = eINSTANCE.getParameterCheck_ParameterDomain();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getCLoop()
		 * @generated
		 */
		EClass CLOOP = eINSTANCE.getCLoop();

		/**
		 * The meta object literal for the '<em><b>Use Macros</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOOP__USE_MACROS = eINSTANCE.getCLoop_UseMacros();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl <em>Tiled CLoop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getTiledCLoop()
		 * @generated
		 */
		EClass TILED_CLOOP = eINSTANCE.getTiledCLoop();

		/**
		 * The meta object literal for the '<em><b>Optimize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILED_CLOOP__OPTIMIZE = eINSTANCE.getTiledCLoop_Optimize();

		/**
		 * The meta object literal for the '<em><b>Tiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILED_CLOOP__TILES = eINSTANCE.getTiledCLoop_Tiles();

		/**
		 * The meta object literal for the '<em><b>Ordering Dimensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILED_CLOOP__ORDERING_DIMENSIONS = eINSTANCE.getTiledCLoop_OrderingDimensions();

		/**
		 * The meta object literal for the '<em><b>Optimized Point Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILED_CLOOP__OPTIMIZED_POINT_LOOP = eINSTANCE.getTiledCLoop_OptimizedPointLoop();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl <em>Parallelized CLoop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getParallelizedCLoop()
		 * @generated
		 */
		EClass PARALLELIZED_CLOOP = eINSTANCE.getParallelizedCLoop();

		/**
		 * The meta object literal for the '<em><b>Parallelized Dims</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLELIZED_CLOOP__PARALLELIZED_DIMS = eINSTANCE.getParallelizedCLoop_ParallelizedDims();

		/**
		 * The meta object literal for the '<em><b>Ordering Dims</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLELIZED_CLOOP__ORDERING_DIMS = eINSTANCE.getParallelizedCLoop_OrderingDims();

		/**
		 * The meta object literal for the '<em><b>Subsystem Variables</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES = eINSTANCE.getParallelizedCLoop_SubsystemVariables();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl <em>Scop Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getScopLoop()
		 * @generated
		 */
		EClass SCOP_LOOP = eINSTANCE.getScopLoop();

		/**
		 * The meta object literal for the '<em><b>Tiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_LOOP__TILES = eINSTANCE.getScopLoop_Tiles();

		/**
		 * The meta object literal for the '<em><b>Scop Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_LOOP__SCOP_ROOT = eINSTANCE.getScopLoop_ScopRoot();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.CVariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CVariableImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getCVariable()
		 * @generated
		 */
		EClass CVARIABLE = eINSTANCE.getCVariable();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl <em>DTiled Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTiledLoop()
		 * @generated
		 */
		EClass DTILED_LOOP = eINSTANCE.getDTiledLoop();

		/**
		 * The meta object literal for the '<em><b>Scop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_LOOP__SCOP = eINSTANCE.getDTiledLoop_Scop();

		/**
		 * The meta object literal for the '<em><b>Tiled Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_LOOP__TILED_BLOCKS = eINSTANCE.getDTiledLoop_TiledBlocks();

		/**
		 * The meta object literal for the '<em><b>Dtiling Options</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DTILED_LOOP__DTILING_OPTIONS = eINSTANCE.getDTiledLoop_DtilingOptions();

		/**
		 * The meta object literal for the '<em><b>Generator Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_LOOP__GENERATOR_LOOP = eINSTANCE.getDTiledLoop_GeneratorLoop();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl <em>DTiled Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTiledBlock()
		 * @generated
		 */
		EClass DTILED_BLOCK = eINSTANCE.getDTiledBlock();

		/**
		 * The meta object literal for the '<em><b>Block Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_BLOCK__BLOCK_START = eINSTANCE.getDTiledBlock_BlockStart();

		/**
		 * The meta object literal for the '<em><b>Point Loop Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_BLOCK__POINT_LOOP_START = eINSTANCE.getDTiledBlock_PointLoopStart();

		/**
		 * The meta object literal for the '<em><b>Tile Loop Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_BLOCK__TILE_LOOP_START = eINSTANCE.getDTiledBlock_TileLoopStart();

		/**
		 * The meta object literal for the '<em><b>Perfect Loop Nest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_BLOCK__PERFECT_LOOP_NEST = eINSTANCE.getDTiledBlock_PerfectLoopNest();

		/**
		 * The meta object literal for the '<em><b>Container Loop</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTILED_BLOCK__CONTAINER_LOOP = eINSTANCE.getDTiledBlock_ContainerLoop();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl <em>Sub Tile Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getSubTileSpecification()
		 * @generated
		 */
		EClass SUB_TILE_SPECIFICATION = eINSTANCE.getSubTileSpecification();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__LEVEL = eINSTANCE.getSubTileSpecification_Level();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__START = eINSTANCE.getSubTileSpecification_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__END = eINSTANCE.getSubTileSpecification_End();

		/**
		 * The meta object literal for the '<em><b>Tile Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__TILE_SIZES = eINSTANCE.getSubTileSpecification_TileSizes();

		/**
		 * The meta object literal for the '<em><b>Tile Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__TILE_TYPE = eINSTANCE.getSubTileSpecification_TileType();

		/**
		 * The meta object literal for the '<em><b>Tile Index Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX = eINSTANCE.getSubTileSpecification_TileIndexPrefix();

		/**
		 * The meta object literal for the '<em><b>Tile Size Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX = eINSTANCE.getSubTileSpecification_TileSizePrefix();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl <em>Tile Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getTileSpecification()
		 * @generated
		 */
		EClass TILE_SPECIFICATION = eINSTANCE.getTileSpecification();

		/**
		 * The meta object literal for the '<em><b>Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE_SPECIFICATION__LEVELS = eINSTANCE.getTileSpecification_Levels();

		/**
		 * The meta object literal for the '<em><b>Start Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE_SPECIFICATION__START_DIM = eINSTANCE.getTileSpecification_StartDim();

		/**
		 * The meta object literal for the '<em><b>End Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE_SPECIFICATION__END_DIM = eINSTANCE.getTileSpecification_EndDim();

		/**
		 * The meta object literal for the '<em><b>Sub Tiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE_SPECIFICATION__SUB_TILES = eINSTANCE.getTileSpecification_SubTiles();

		/**
		 * The meta object literal for the '<em><b>Ordering Prefix</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE_SPECIFICATION__ORDERING_PREFIX = eINSTANCE.getTileSpecification_OrderingPrefix();

		/**
		 * The meta object literal for the '<em>DTiling Options</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.dtiler.DTilingOptions
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl#getDTilingOptions()
		 * @generated
		 */
		EDataType DTILING_OPTIONS = eINSTANCE.getDTilingOptions();

	}

} //CPackage
