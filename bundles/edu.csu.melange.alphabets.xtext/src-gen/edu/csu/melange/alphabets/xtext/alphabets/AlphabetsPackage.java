/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsFactory
 * @model kind="package"
 * @generated
 */
public interface AlphabetsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "alphabets";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.Alphabets.xtext";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "alphabets";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlphabetsPackage eINSTANCE = edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl <em>AProgram</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAProgram()
   * @generated
   */
  int APROGRAM = 0;

  /**
   * The feature id for the '<em><b>External Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROGRAM__EXTERNAL_FUNCTIONS = 0;

  /**
   * The feature id for the '<em><b>Systems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROGRAM__SYSTEMS = 1;

  /**
   * The number of structural features of the '<em>AProgram</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROGRAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl <em>AExternal Function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionDeclaration()
   * @generated
   */
  int AEXTERNAL_FUNCTION_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_DECLARATION__OUTPUT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_DECLARATION__INPUTS = 2;

  /**
   * The number of structural features of the '<em>AExternal Function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionIdentifierImpl <em>AExternal Function Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionIdentifierImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionIdentifier()
   * @generated
   */
  int AEXTERNAL_FUNCTION_IDENTIFIER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_IDENTIFIER__NAME = 0;

  /**
   * The number of structural features of the '<em>AExternal Function Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_IDENTIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl <em>AAffine System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAffineSystem()
   * @generated
   */
  int AAFFINE_SYSTEM = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Input Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__INPUT_DECLARATIONS = 2;

  /**
   * The feature id for the '<em><b>Output Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__OUTPUT_DECLARATIONS = 3;

  /**
   * The feature id for the '<em><b>Localvar Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS = 4;

  /**
   * The feature id for the '<em><b>Equations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM__EQUATIONS = 5;

  /**
   * The number of structural features of the '<em>AAffine System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAFFINE_SYSTEM_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AOutputDeclarationImpl <em>AOutput Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AOutputDeclarationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAOutputDeclaration()
   * @generated
   */
  int AOUTPUT_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOUTPUT_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOUTPUT_DECLARATION__IDENTIFIER_LIST = 1;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOUTPUT_DECLARATION__DOMAIN = 2;

  /**
   * The number of structural features of the '<em>AOutput Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOUTPUT_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AInputDeclarationImpl <em>AInput Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AInputDeclarationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAInputDeclaration()
   * @generated
   */
  int AINPUT_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINPUT_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINPUT_DECLARATION__IDENTIFIER_LIST = 1;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINPUT_DECLARATION__DOMAIN = 2;

  /**
   * The number of structural features of the '<em>AInput Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINPUT_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ALocalDeclarationImpl <em>ALocal Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ALocalDeclarationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getALocalDeclaration()
   * @generated
   */
  int ALOCAL_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALOCAL_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALOCAL_DECLARATION__IDENTIFIER_LIST = 1;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALOCAL_DECLARATION__DOMAIN = 2;

  /**
   * The number of structural features of the '<em>ALocal Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALOCAL_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIdentifierListImpl <em>AIdentifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIdentifierListImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIdentifierList()
   * @generated
   */
  int AIDENTIFIER_LIST = 7;

  /**
   * The feature id for the '<em><b>Identifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIDENTIFIER_LIST__IDENTIFIERS = 0;

  /**
   * The number of structural features of the '<em>AIdentifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIDENTIFIER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADomainImpl <em>ADomain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADomainImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADomain()
   * @generated
   */
  int ADOMAIN = 8;

  /**
   * The feature id for the '<em><b>Polyhedra</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADOMAIN__POLYHEDRA = 0;

  /**
   * The number of structural features of the '<em>ADomain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADOMAIN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl <em>APolyhedron</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAPolyhedron()
   * @generated
   */
  int APOLYHEDRON = 9;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APOLYHEDRON__INDEXES = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APOLYHEDRON__CONSTRAINTS = 1;

  /**
   * The number of structural features of the '<em>APolyhedron</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APOLYHEDRON_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl <em>AStandard Equation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAStandardEquation()
   * @generated
   */
  int ASTANDARD_EQUATION = 10;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTANDARD_EQUATION__VAR = 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTANDARD_EQUATION__INDEXES = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTANDARD_EQUATION__EXPR = 2;

  /**
   * The number of structural features of the '<em>AStandard Equation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTANDARD_EQUATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAlphabetsExpressionImpl <em>AAlphabets Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAlphabetsExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAlphabetsExpression()
   * @generated
   */
  int AALPHABETS_EXPRESSION = 11;

  /**
   * The number of structural features of the '<em>AAlphabets Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AALPHABETS_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ANotExpressionImpl <em>ANot Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ANotExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getANotExpression()
   * @generated
   */
  int ANOT_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANOT_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANOT_EXPRESSION__EXPR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ANot Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANOT_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ANegateExpressionImpl <em>ANegate Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ANegateExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getANegateExpression()
   * @generated
   */
  int ANEGATE_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANEGATE_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANEGATE_EXPRESSION__EXPR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ANegate Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANEGATE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ACaseExpressionImpl <em>ACase Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ACaseExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getACaseExpression()
   * @generated
   */
  int ACASE_EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACASE_EXPRESSION__EXPRS = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ACase Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACASE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl <em>ADependence Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADependenceExpression()
   * @generated
   */
  int ADEPENDENCE_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Func</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_EXPRESSION__FUNC = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_EXPRESSION__EXPR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ADependence Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl <em>ADependence In Array Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADependenceInArrayNotation()
   * @generated
   */
  int ADEPENDENCE_IN_ARRAY_NOTATION = 16;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_IN_ARRAY_NOTATION__VAR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Dep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_IN_ARRAY_NOTATION__DEP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ADependence In Array Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADEPENDENCE_IN_ARRAY_NOTATION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIfExpressionImpl <em>AIf Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIfExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIfExpression()
   * @generated
   */
  int AIF_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIF_EXPRESSION__COND = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIF_EXPRESSION__THEN = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIF_EXPRESSION__ELSE = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AIf Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AIF_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl <em>AIndex Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexExpression()
   * @generated
   */
  int AINDEX_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Func</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_EXPRESSION__FUNC = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_EXPRESSION__INDEXES = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AIndex Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AReduceExpressionImpl <em>AReduce Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AReduceExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAReduceExpression()
   * @generated
   */
  int AREDUCE_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREDUCE_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Projection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREDUCE_EXPRESSION__PROJECTION = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREDUCE_EXPRESSION__EXPR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AReduce Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREDUCE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARestrictExpressionImpl <em>ARestrict Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARestrictExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARestrictExpression()
   * @generated
   */
  int ARESTRICT_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARESTRICT_EXPRESSION__DOMAIN = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARESTRICT_EXPRESSION__EXPR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ARestrict Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARESTRICT_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AVariableExpressionImpl <em>AVariable Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AVariableExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAVariableExpression()
   * @generated
   */
  int AVARIABLE_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_EXPRESSION__VAR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AVariable Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AConstantExpressionImpl <em>AConstant Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AConstantExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAConstantExpression()
   * @generated
   */
  int ACONSTANT_EXPRESSION = 22;

  /**
   * The number of structural features of the '<em>AConstant Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONSTANT_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ABooleanExpressionImpl <em>ABoolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ABooleanExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getABooleanExpression()
   * @generated
   */
  int ABOOLEAN_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABOOLEAN_EXPRESSION__VALUE = ACONSTANT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ABoolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABOOLEAN_EXPRESSION_FEATURE_COUNT = ACONSTANT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIntegerExpressionImpl <em>AInteger Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIntegerExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIntegerExpression()
   * @generated
   */
  int AINTEGER_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINTEGER_EXPRESSION__VALUE = ACONSTANT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AInteger Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINTEGER_EXPRESSION_FEATURE_COUNT = ACONSTANT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARealExpressionImpl <em>AReal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARealExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARealExpression()
   * @generated
   */
  int AREAL_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREAL_EXPRESSION__VALUE = ACONSTANT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AReal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AREAL_EXPRESSION_FEATURE_COUNT = ACONSTANT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgExpressionImpl <em>AMulti Arg Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgExpression()
   * @generated
   */
  int AMULTI_ARG_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_EXPRESSION__EXPRS = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AMulti Arg Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgArithmeticExpressionImpl <em>AMulti Arg Arithmetic Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgArithmeticExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgArithmeticExpression()
   * @generated
   */
  int AMULTI_ARG_ARITHMETIC_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_ARITHMETIC_EXPRESSION__EXPRS = AMULTI_ARG_EXPRESSION__EXPRS;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_ARITHMETIC_EXPRESSION__OP = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AMulti Arg Arithmetic Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_ARITHMETIC_EXPRESSION_FEATURE_COUNT = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgLogicalExpressionImpl <em>AMulti Arg Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgLogicalExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgLogicalExpression()
   * @generated
   */
  int AMULTI_ARG_LOGICAL_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_LOGICAL_EXPRESSION__EXPRS = AMULTI_ARG_EXPRESSION__EXPRS;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_LOGICAL_EXPRESSION__OP = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AMulti Arg Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTI_ARG_LOGICAL_EXPRESSION_FEATURE_COUNT = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionCallImpl <em>AExternal Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionCallImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionCall()
   * @generated
   */
  int AEXTERNAL_FUNCTION_CALL = 29;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_CALL__EXPRS = AMULTI_ARG_EXPRESSION__EXPRS;

  /**
   * The feature id for the '<em><b>Func</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_CALL__FUNC = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AExternal Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXTERNAL_FUNCTION_CALL_FEATURE_COUNT = AMULTI_ARG_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexListImpl <em>AIndex List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexListImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexList()
   * @generated
   */
  int AINDEX_LIST = 30;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_LIST__IDS = 0;

  /**
   * The number of structural features of the '<em>AIndex List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexAffineExpressionListImpl <em>AIndex Affine Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexAffineExpressionListImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexAffineExpressionList()
   * @generated
   */
  int AINDEX_AFFINE_EXPRESSION_LIST = 31;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_AFFINE_EXPRESSION_LIST__EXPRS = 0;

  /**
   * The number of structural features of the '<em>AIndex Affine Expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AINDEX_AFFINE_EXPRESSION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl <em>AFunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAFunction()
   * @generated
   */
  int AFUNCTION = 32;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION__INDEXES = 0;

  /**
   * The feature id for the '<em><b>Func</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION__FUNC = 1;

  /**
   * The number of structural features of the '<em>AFunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionInArrayNotationImpl <em>AFunction In Array Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionInArrayNotationImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAFunctionInArrayNotation()
   * @generated
   */
  int AFUNCTION_IN_ARRAY_NOTATION = 33;

  /**
   * The feature id for the '<em><b>New Ids</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS = 0;

  /**
   * The number of structural features of the '<em>AFunction In Array Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_IN_ARRAY_NOTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ATypeImpl <em>AType</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ATypeImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAType()
   * @generated
   */
  int ATYPE = 34;

  /**
   * The feature id for the '<em><b>Unsigned</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE__UNSIGNED = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>AType</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AOrExpressionImpl <em>AOr Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AOrExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAOrExpression()
   * @generated
   */
  int AOR_EXPRESSION = 35;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOR_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOR_EXPRESSION__OPERATOR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOR_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AOr Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AOR_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAndExpressionImpl <em>AAnd Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAndExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAndExpression()
   * @generated
   */
  int AAND_EXPRESSION = 36;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAND_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAND_EXPRESSION__OPERATOR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAND_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AAnd Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AAND_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARelationalExpressionImpl <em>ARelational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARelationalExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARelationalExpression()
   * @generated
   */
  int ARELATIONAL_EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARELATIONAL_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARELATIONAL_EXPRESSION__OPERATOR = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARELATIONAL_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>ARelational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARELATIONAL_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAdditiveExpressionImpl <em>AAdditive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAdditiveExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAdditiveExpression()
   * @generated
   */
  int AADDITIVE_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AADDITIVE_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AADDITIVE_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AADDITIVE_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AAdditive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AADDITIVE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiplicativeExpressionImpl <em>AMultiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiplicativeExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiplicativeExpression()
   * @generated
   */
  int AMULTIPLICATIVE_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTIPLICATIVE_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTIPLICATIVE_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTIPLICATIVE_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AMultiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMinMaxExpressionImpl <em>AMin Max Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMinMaxExpressionImpl
   * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMinMaxExpression()
   * @generated
   */
  int AMIN_MAX_EXPRESSION = 40;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMIN_MAX_EXPRESSION__LEFT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMIN_MAX_EXPRESSION__OP = AALPHABETS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMIN_MAX_EXPRESSION__RIGHT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AMin Max Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMIN_MAX_EXPRESSION_FEATURE_COUNT = AALPHABETS_EXPRESSION_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram <em>AProgram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AProgram</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AProgram
   * @generated
   */
  EClass getAProgram();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram#getExternalFunctions <em>External Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Functions</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AProgram#getExternalFunctions()
   * @see #getAProgram()
   * @generated
   */
  EReference getAProgram_ExternalFunctions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram#getSystems <em>Systems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Systems</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AProgram#getSystems()
   * @see #getAProgram()
   * @generated
   */
  EReference getAProgram_Systems();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration <em>AExternal Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExternal Function Declaration</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration
   * @generated
   */
  EClass getAExternalFunctionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getOutput()
   * @see #getAExternalFunctionDeclaration()
   * @generated
   */
  EReference getAExternalFunctionDeclaration_Output();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getName()
   * @see #getAExternalFunctionDeclaration()
   * @generated
   */
  EReference getAExternalFunctionDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getInputs()
   * @see #getAExternalFunctionDeclaration()
   * @generated
   */
  EReference getAExternalFunctionDeclaration_Inputs();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier <em>AExternal Function Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExternal Function Identifier</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier
   * @generated
   */
  EClass getAExternalFunctionIdentifier();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier#getName()
   * @see #getAExternalFunctionIdentifier()
   * @generated
   */
  EAttribute getAExternalFunctionIdentifier_Name();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem <em>AAffine System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AAffine System</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem
   * @generated
   */
  EClass getAAffineSystem();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getName()
   * @see #getAAffineSystem()
   * @generated
   */
  EAttribute getAAffineSystem_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getParameters()
   * @see #getAAffineSystem()
   * @generated
   */
  EReference getAAffineSystem_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getInputDeclarations <em>Input Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Input Declarations</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getInputDeclarations()
   * @see #getAAffineSystem()
   * @generated
   */
  EReference getAAffineSystem_InputDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getOutputDeclarations <em>Output Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Output Declarations</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getOutputDeclarations()
   * @see #getAAffineSystem()
   * @generated
   */
  EReference getAAffineSystem_OutputDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getLocalvarDeclarations <em>Localvar Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Localvar Declarations</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getLocalvarDeclarations()
   * @see #getAAffineSystem()
   * @generated
   */
  EReference getAAffineSystem_LocalvarDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getEquations <em>Equations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equations</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getEquations()
   * @see #getAAffineSystem()
   * @generated
   */
  EReference getAAffineSystem_Equations();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration <em>AOutput Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AOutput Declaration</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration
   * @generated
   */
  EClass getAOutputDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getType()
   * @see #getAOutputDeclaration()
   * @generated
   */
  EReference getAOutputDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getIdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getIdentifierList()
   * @see #getAOutputDeclaration()
   * @generated
   */
  EReference getAOutputDeclaration_IdentifierList();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration#getDomain()
   * @see #getAOutputDeclaration()
   * @generated
   */
  EReference getAOutputDeclaration_Domain();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration <em>AInput Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AInput Declaration</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration
   * @generated
   */
  EClass getAInputDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getType()
   * @see #getAInputDeclaration()
   * @generated
   */
  EReference getAInputDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getIdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getIdentifierList()
   * @see #getAInputDeclaration()
   * @generated
   */
  EReference getAInputDeclaration_IdentifierList();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration#getDomain()
   * @see #getAInputDeclaration()
   * @generated
   */
  EReference getAInputDeclaration_Domain();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration <em>ALocal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ALocal Declaration</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration
   * @generated
   */
  EClass getALocalDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getType()
   * @see #getALocalDeclaration()
   * @generated
   */
  EReference getALocalDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getIdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getIdentifierList()
   * @see #getALocalDeclaration()
   * @generated
   */
  EReference getALocalDeclaration_IdentifierList();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getDomain()
   * @see #getALocalDeclaration()
   * @generated
   */
  EReference getALocalDeclaration_Domain();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList <em>AIdentifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AIdentifier List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList
   * @generated
   */
  EClass getAIdentifierList();

  /**
   * Returns the meta object for the attribute list '{@link edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList#getIdentifiers <em>Identifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Identifiers</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList#getIdentifiers()
   * @see #getAIdentifierList()
   * @generated
   */
  EAttribute getAIdentifierList_Identifiers();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADomain <em>ADomain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ADomain</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADomain
   * @generated
   */
  EClass getADomain();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.ADomain#getPolyhedra <em>Polyhedra</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Polyhedra</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADomain#getPolyhedra()
   * @see #getADomain()
   * @generated
   */
  EReference getADomain_Polyhedra();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron <em>APolyhedron</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>APolyhedron</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.APolyhedron
   * @generated
   */
  EClass getAPolyhedron();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indexes</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getIndexes()
   * @see #getAPolyhedron()
   * @generated
   */
  EReference getAPolyhedron_Indexes();

  /**
   * Returns the meta object for the attribute list '{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Constraints</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getConstraints()
   * @see #getAPolyhedron()
   * @generated
   */
  EAttribute getAPolyhedron_Constraints();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation <em>AStandard Equation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AStandard Equation</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation
   * @generated
   */
  EClass getAStandardEquation();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getVar()
   * @see #getAStandardEquation()
   * @generated
   */
  EAttribute getAStandardEquation_Var();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indexes</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getIndexes()
   * @see #getAStandardEquation()
   * @generated
   */
  EReference getAStandardEquation_Indexes();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getExpr()
   * @see #getAStandardEquation()
   * @generated
   */
  EReference getAStandardEquation_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression <em>AAlphabets Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AAlphabets Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression
   * @generated
   */
  EClass getAAlphabetsExpression();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ANotExpression <em>ANot Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANot Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANotExpression
   * @generated
   */
  EClass getANotExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ANotExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANotExpression#getOp()
   * @see #getANotExpression()
   * @generated
   */
  EAttribute getANotExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ANotExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANotExpression#getExpr()
   * @see #getANotExpression()
   * @generated
   */
  EReference getANotExpression_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression <em>ANegate Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANegate Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression
   * @generated
   */
  EClass getANegateExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression#getOp()
   * @see #getANegateExpression()
   * @generated
   */
  EAttribute getANegateExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression#getExpr()
   * @see #getANegateExpression()
   * @generated
   */
  EReference getANegateExpression_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression <em>ACase Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ACase Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression
   * @generated
   */
  EClass getACaseExpression();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression#getExprs()
   * @see #getACaseExpression()
   * @generated
   */
  EReference getACaseExpression_Exprs();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression <em>ADependence Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ADependence Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression
   * @generated
   */
  EClass getADependenceExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Func</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getFunc()
   * @see #getADependenceExpression()
   * @generated
   */
  EReference getADependenceExpression_Func();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getExpr()
   * @see #getADependenceExpression()
   * @generated
   */
  EReference getADependenceExpression_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation <em>ADependence In Array Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ADependence In Array Notation</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation
   * @generated
   */
  EClass getADependenceInArrayNotation();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getVar()
   * @see #getADependenceInArrayNotation()
   * @generated
   */
  EAttribute getADependenceInArrayNotation_Var();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getDep <em>Dep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dep</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getDep()
   * @see #getADependenceInArrayNotation()
   * @generated
   */
  EReference getADependenceInArrayNotation_Dep();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression <em>AIf Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AIf Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIfExpression
   * @generated
   */
  EClass getAIfExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getCond()
   * @see #getAIfExpression()
   * @generated
   */
  EReference getAIfExpression_Cond();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getThen()
   * @see #getAIfExpression()
   * @generated
   */
  EReference getAIfExpression_Then();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getElse()
   * @see #getAIfExpression()
   * @generated
   */
  EReference getAIfExpression_Else();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression <em>AIndex Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AIndex Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression
   * @generated
   */
  EClass getAIndexExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Func</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getFunc()
   * @see #getAIndexExpression()
   * @generated
   */
  EAttribute getAIndexExpression_Func();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indexes</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getIndexes()
   * @see #getAIndexExpression()
   * @generated
   */
  EReference getAIndexExpression_Indexes();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression <em>AReduce Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AReduce Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression
   * @generated
   */
  EClass getAReduceExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getOp()
   * @see #getAReduceExpression()
   * @generated
   */
  EAttribute getAReduceExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getProjection <em>Projection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Projection</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getProjection()
   * @see #getAReduceExpression()
   * @generated
   */
  EReference getAReduceExpression_Projection();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getExpr()
   * @see #getAReduceExpression()
   * @generated
   */
  EReference getAReduceExpression_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression <em>ARestrict Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ARestrict Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression
   * @generated
   */
  EClass getARestrictExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getDomain()
   * @see #getARestrictExpression()
   * @generated
   */
  EReference getARestrictExpression_Domain();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getExpr()
   * @see #getARestrictExpression()
   * @generated
   */
  EReference getARestrictExpression_Expr();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression <em>AVariable Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AVariable Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression
   * @generated
   */
  EClass getAVariableExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression#getVar()
   * @see #getAVariableExpression()
   * @generated
   */
  EAttribute getAVariableExpression_Var();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AConstantExpression <em>AConstant Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AConstant Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AConstantExpression
   * @generated
   */
  EClass getAConstantExpression();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression <em>ABoolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ABoolean Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression
   * @generated
   */
  EClass getABooleanExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression#getValue()
   * @see #getABooleanExpression()
   * @generated
   */
  EAttribute getABooleanExpression_Value();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression <em>AInteger Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AInteger Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression
   * @generated
   */
  EClass getAIntegerExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression#getValue()
   * @see #getAIntegerExpression()
   * @generated
   */
  EAttribute getAIntegerExpression_Value();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARealExpression <em>AReal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AReal Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARealExpression
   * @generated
   */
  EClass getARealExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ARealExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARealExpression#getValue()
   * @see #getARealExpression()
   * @generated
   */
  EAttribute getARealExpression_Value();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression <em>AMulti Arg Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AMulti Arg Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression
   * @generated
   */
  EClass getAMultiArgExpression();

  /**
   * Returns the meta object for the containment reference list '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression#getExprs()
   * @see #getAMultiArgExpression()
   * @generated
   */
  EReference getAMultiArgExpression_Exprs();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression <em>AMulti Arg Arithmetic Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AMulti Arg Arithmetic Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression
   * @generated
   */
  EClass getAMultiArgArithmeticExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression#getOp()
   * @see #getAMultiArgArithmeticExpression()
   * @generated
   */
  EAttribute getAMultiArgArithmeticExpression_Op();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression <em>AMulti Arg Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AMulti Arg Logical Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression
   * @generated
   */
  EClass getAMultiArgLogicalExpression();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression#getOp()
   * @see #getAMultiArgLogicalExpression()
   * @generated
   */
  EAttribute getAMultiArgLogicalExpression_Op();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall <em>AExternal Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExternal Function Call</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall
   * @generated
   */
  EClass getAExternalFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Func</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall#getFunc()
   * @see #getAExternalFunctionCall()
   * @generated
   */
  EAttribute getAExternalFunctionCall_Func();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexList <em>AIndex List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AIndex List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexList
   * @generated
   */
  EClass getAIndexList();

  /**
   * Returns the meta object for the attribute list '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexList#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexList#getIds()
   * @see #getAIndexList()
   * @generated
   */
  EAttribute getAIndexList_Ids();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList <em>AIndex Affine Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AIndex Affine Expression List</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList
   * @generated
   */
  EClass getAIndexAffineExpressionList();

  /**
   * Returns the meta object for the attribute list '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Exprs</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList#getExprs()
   * @see #getAIndexAffineExpressionList()
   * @generated
   */
  EAttribute getAIndexAffineExpressionList_Exprs();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction <em>AFunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AFunction</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunction
   * @generated
   */
  EClass getAFunction();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indexes</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunction#getIndexes()
   * @see #getAFunction()
   * @generated
   */
  EReference getAFunction_Indexes();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Func</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunction#getFunc()
   * @see #getAFunction()
   * @generated
   */
  EReference getAFunction_Func();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation <em>AFunction In Array Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AFunction In Array Notation</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation
   * @generated
   */
  EClass getAFunctionInArrayNotation();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation#getNewIds <em>New Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>New Ids</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation#getNewIds()
   * @see #getAFunctionInArrayNotation()
   * @generated
   */
  EReference getAFunctionInArrayNotation_NewIds();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AType <em>AType</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AType</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AType
   * @generated
   */
  EClass getAType();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getUnsigned <em>Unsigned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unsigned</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AType#getUnsigned()
   * @see #getAType()
   * @generated
   */
  EAttribute getAType_Unsigned();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AType#getType()
   * @see #getAType()
   * @generated
   */
  EAttribute getAType_Type();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AOrExpression <em>AOr Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AOr Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOrExpression
   * @generated
   */
  EClass getAOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getLeft()
   * @see #getAOrExpression()
   * @generated
   */
  EReference getAOrExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getOperator()
   * @see #getAOrExpression()
   * @generated
   */
  EAttribute getAOrExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOrExpression#getRight()
   * @see #getAOrExpression()
   * @generated
   */
  EReference getAOrExpression_Right();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAndExpression <em>AAnd Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AAnd Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAndExpression
   * @generated
   */
  EClass getAAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getLeft()
   * @see #getAAndExpression()
   * @generated
   */
  EReference getAAndExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getOperator()
   * @see #getAAndExpression()
   * @generated
   */
  EAttribute getAAndExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAndExpression#getRight()
   * @see #getAAndExpression()
   * @generated
   */
  EReference getAAndExpression_Right();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression <em>ARelational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ARelational Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression
   * @generated
   */
  EClass getARelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getLeft()
   * @see #getARelationalExpression()
   * @generated
   */
  EReference getARelationalExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getOperator()
   * @see #getARelationalExpression()
   * @generated
   */
  EAttribute getARelationalExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getRight()
   * @see #getARelationalExpression()
   * @generated
   */
  EReference getARelationalExpression_Right();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression <em>AAdditive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AAdditive Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression
   * @generated
   */
  EClass getAAdditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getLeft()
   * @see #getAAdditiveExpression()
   * @generated
   */
  EReference getAAdditiveExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getOp()
   * @see #getAAdditiveExpression()
   * @generated
   */
  EAttribute getAAdditiveExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression#getRight()
   * @see #getAAdditiveExpression()
   * @generated
   */
  EReference getAAdditiveExpression_Right();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression <em>AMultiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AMultiplicative Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression
   * @generated
   */
  EClass getAMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getLeft()
   * @see #getAMultiplicativeExpression()
   * @generated
   */
  EReference getAMultiplicativeExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getOp()
   * @see #getAMultiplicativeExpression()
   * @generated
   */
  EAttribute getAMultiplicativeExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression#getRight()
   * @see #getAMultiplicativeExpression()
   * @generated
   */
  EReference getAMultiplicativeExpression_Right();

  /**
   * Returns the meta object for class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression <em>AMin Max Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AMin Max Expression</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression
   * @generated
   */
  EClass getAMinMaxExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getLeft()
   * @see #getAMinMaxExpression()
   * @generated
   */
  EReference getAMinMaxExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getOp()
   * @see #getAMinMaxExpression()
   * @generated
   */
  EAttribute getAMinMaxExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression#getRight()
   * @see #getAMinMaxExpression()
   * @generated
   */
  EReference getAMinMaxExpression_Right();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AlphabetsFactory getAlphabetsFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl <em>AProgram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAProgram()
     * @generated
     */
    EClass APROGRAM = eINSTANCE.getAProgram();

    /**
     * The meta object literal for the '<em><b>External Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APROGRAM__EXTERNAL_FUNCTIONS = eINSTANCE.getAProgram_ExternalFunctions();

    /**
     * The meta object literal for the '<em><b>Systems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APROGRAM__SYSTEMS = eINSTANCE.getAProgram_Systems();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl <em>AExternal Function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionDeclaration()
     * @generated
     */
    EClass AEXTERNAL_FUNCTION_DECLARATION = eINSTANCE.getAExternalFunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXTERNAL_FUNCTION_DECLARATION__OUTPUT = eINSTANCE.getAExternalFunctionDeclaration_Output();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXTERNAL_FUNCTION_DECLARATION__NAME = eINSTANCE.getAExternalFunctionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXTERNAL_FUNCTION_DECLARATION__INPUTS = eINSTANCE.getAExternalFunctionDeclaration_Inputs();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionIdentifierImpl <em>AExternal Function Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionIdentifierImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionIdentifier()
     * @generated
     */
    EClass AEXTERNAL_FUNCTION_IDENTIFIER = eINSTANCE.getAExternalFunctionIdentifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AEXTERNAL_FUNCTION_IDENTIFIER__NAME = eINSTANCE.getAExternalFunctionIdentifier_Name();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl <em>AAffine System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAffineSystem()
     * @generated
     */
    EClass AAFFINE_SYSTEM = eINSTANCE.getAAffineSystem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AAFFINE_SYSTEM__NAME = eINSTANCE.getAAffineSystem_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAFFINE_SYSTEM__PARAMETERS = eINSTANCE.getAAffineSystem_Parameters();

    /**
     * The meta object literal for the '<em><b>Input Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAFFINE_SYSTEM__INPUT_DECLARATIONS = eINSTANCE.getAAffineSystem_InputDeclarations();

    /**
     * The meta object literal for the '<em><b>Output Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAFFINE_SYSTEM__OUTPUT_DECLARATIONS = eINSTANCE.getAAffineSystem_OutputDeclarations();

    /**
     * The meta object literal for the '<em><b>Localvar Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS = eINSTANCE.getAAffineSystem_LocalvarDeclarations();

    /**
     * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAFFINE_SYSTEM__EQUATIONS = eINSTANCE.getAAffineSystem_Equations();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AOutputDeclarationImpl <em>AOutput Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AOutputDeclarationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAOutputDeclaration()
     * @generated
     */
    EClass AOUTPUT_DECLARATION = eINSTANCE.getAOutputDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AOUTPUT_DECLARATION__TYPE = eINSTANCE.getAOutputDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Identifier List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AOUTPUT_DECLARATION__IDENTIFIER_LIST = eINSTANCE.getAOutputDeclaration_IdentifierList();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AOUTPUT_DECLARATION__DOMAIN = eINSTANCE.getAOutputDeclaration_Domain();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AInputDeclarationImpl <em>AInput Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AInputDeclarationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAInputDeclaration()
     * @generated
     */
    EClass AINPUT_DECLARATION = eINSTANCE.getAInputDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AINPUT_DECLARATION__TYPE = eINSTANCE.getAInputDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Identifier List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AINPUT_DECLARATION__IDENTIFIER_LIST = eINSTANCE.getAInputDeclaration_IdentifierList();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AINPUT_DECLARATION__DOMAIN = eINSTANCE.getAInputDeclaration_Domain();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ALocalDeclarationImpl <em>ALocal Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ALocalDeclarationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getALocalDeclaration()
     * @generated
     */
    EClass ALOCAL_DECLARATION = eINSTANCE.getALocalDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALOCAL_DECLARATION__TYPE = eINSTANCE.getALocalDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Identifier List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALOCAL_DECLARATION__IDENTIFIER_LIST = eINSTANCE.getALocalDeclaration_IdentifierList();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALOCAL_DECLARATION__DOMAIN = eINSTANCE.getALocalDeclaration_Domain();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIdentifierListImpl <em>AIdentifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIdentifierListImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIdentifierList()
     * @generated
     */
    EClass AIDENTIFIER_LIST = eINSTANCE.getAIdentifierList();

    /**
     * The meta object literal for the '<em><b>Identifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AIDENTIFIER_LIST__IDENTIFIERS = eINSTANCE.getAIdentifierList_Identifiers();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADomainImpl <em>ADomain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADomainImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADomain()
     * @generated
     */
    EClass ADOMAIN = eINSTANCE.getADomain();

    /**
     * The meta object literal for the '<em><b>Polyhedra</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADOMAIN__POLYHEDRA = eINSTANCE.getADomain_Polyhedra();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl <em>APolyhedron</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAPolyhedron()
     * @generated
     */
    EClass APOLYHEDRON = eINSTANCE.getAPolyhedron();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APOLYHEDRON__INDEXES = eINSTANCE.getAPolyhedron_Indexes();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute APOLYHEDRON__CONSTRAINTS = eINSTANCE.getAPolyhedron_Constraints();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl <em>AStandard Equation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAStandardEquation()
     * @generated
     */
    EClass ASTANDARD_EQUATION = eINSTANCE.getAStandardEquation();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASTANDARD_EQUATION__VAR = eINSTANCE.getAStandardEquation_Var();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASTANDARD_EQUATION__INDEXES = eINSTANCE.getAStandardEquation_Indexes();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASTANDARD_EQUATION__EXPR = eINSTANCE.getAStandardEquation_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAlphabetsExpressionImpl <em>AAlphabets Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAlphabetsExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAlphabetsExpression()
     * @generated
     */
    EClass AALPHABETS_EXPRESSION = eINSTANCE.getAAlphabetsExpression();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ANotExpressionImpl <em>ANot Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ANotExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getANotExpression()
     * @generated
     */
    EClass ANOT_EXPRESSION = eINSTANCE.getANotExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANOT_EXPRESSION__OP = eINSTANCE.getANotExpression_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANOT_EXPRESSION__EXPR = eINSTANCE.getANotExpression_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ANegateExpressionImpl <em>ANegate Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ANegateExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getANegateExpression()
     * @generated
     */
    EClass ANEGATE_EXPRESSION = eINSTANCE.getANegateExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANEGATE_EXPRESSION__OP = eINSTANCE.getANegateExpression_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANEGATE_EXPRESSION__EXPR = eINSTANCE.getANegateExpression_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ACaseExpressionImpl <em>ACase Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ACaseExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getACaseExpression()
     * @generated
     */
    EClass ACASE_EXPRESSION = eINSTANCE.getACaseExpression();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACASE_EXPRESSION__EXPRS = eINSTANCE.getACaseExpression_Exprs();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl <em>ADependence Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADependenceExpression()
     * @generated
     */
    EClass ADEPENDENCE_EXPRESSION = eINSTANCE.getADependenceExpression();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADEPENDENCE_EXPRESSION__FUNC = eINSTANCE.getADependenceExpression_Func();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADEPENDENCE_EXPRESSION__EXPR = eINSTANCE.getADependenceExpression_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl <em>ADependence In Array Notation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getADependenceInArrayNotation()
     * @generated
     */
    EClass ADEPENDENCE_IN_ARRAY_NOTATION = eINSTANCE.getADependenceInArrayNotation();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADEPENDENCE_IN_ARRAY_NOTATION__VAR = eINSTANCE.getADependenceInArrayNotation_Var();

    /**
     * The meta object literal for the '<em><b>Dep</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADEPENDENCE_IN_ARRAY_NOTATION__DEP = eINSTANCE.getADependenceInArrayNotation_Dep();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIfExpressionImpl <em>AIf Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIfExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIfExpression()
     * @generated
     */
    EClass AIF_EXPRESSION = eINSTANCE.getAIfExpression();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AIF_EXPRESSION__COND = eINSTANCE.getAIfExpression_Cond();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AIF_EXPRESSION__THEN = eINSTANCE.getAIfExpression_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AIF_EXPRESSION__ELSE = eINSTANCE.getAIfExpression_Else();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl <em>AIndex Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexExpression()
     * @generated
     */
    EClass AINDEX_EXPRESSION = eINSTANCE.getAIndexExpression();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AINDEX_EXPRESSION__FUNC = eINSTANCE.getAIndexExpression_Func();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AINDEX_EXPRESSION__INDEXES = eINSTANCE.getAIndexExpression_Indexes();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AReduceExpressionImpl <em>AReduce Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AReduceExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAReduceExpression()
     * @generated
     */
    EClass AREDUCE_EXPRESSION = eINSTANCE.getAReduceExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AREDUCE_EXPRESSION__OP = eINSTANCE.getAReduceExpression_Op();

    /**
     * The meta object literal for the '<em><b>Projection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AREDUCE_EXPRESSION__PROJECTION = eINSTANCE.getAReduceExpression_Projection();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AREDUCE_EXPRESSION__EXPR = eINSTANCE.getAReduceExpression_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARestrictExpressionImpl <em>ARestrict Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARestrictExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARestrictExpression()
     * @generated
     */
    EClass ARESTRICT_EXPRESSION = eINSTANCE.getARestrictExpression();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARESTRICT_EXPRESSION__DOMAIN = eINSTANCE.getARestrictExpression_Domain();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARESTRICT_EXPRESSION__EXPR = eINSTANCE.getARestrictExpression_Expr();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AVariableExpressionImpl <em>AVariable Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AVariableExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAVariableExpression()
     * @generated
     */
    EClass AVARIABLE_EXPRESSION = eINSTANCE.getAVariableExpression();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVARIABLE_EXPRESSION__VAR = eINSTANCE.getAVariableExpression_Var();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AConstantExpressionImpl <em>AConstant Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AConstantExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAConstantExpression()
     * @generated
     */
    EClass ACONSTANT_EXPRESSION = eINSTANCE.getAConstantExpression();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ABooleanExpressionImpl <em>ABoolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ABooleanExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getABooleanExpression()
     * @generated
     */
    EClass ABOOLEAN_EXPRESSION = eINSTANCE.getABooleanExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABOOLEAN_EXPRESSION__VALUE = eINSTANCE.getABooleanExpression_Value();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIntegerExpressionImpl <em>AInteger Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIntegerExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIntegerExpression()
     * @generated
     */
    EClass AINTEGER_EXPRESSION = eINSTANCE.getAIntegerExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AINTEGER_EXPRESSION__VALUE = eINSTANCE.getAIntegerExpression_Value();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARealExpressionImpl <em>AReal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARealExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARealExpression()
     * @generated
     */
    EClass AREAL_EXPRESSION = eINSTANCE.getARealExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AREAL_EXPRESSION__VALUE = eINSTANCE.getARealExpression_Value();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgExpressionImpl <em>AMulti Arg Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgExpression()
     * @generated
     */
    EClass AMULTI_ARG_EXPRESSION = eINSTANCE.getAMultiArgExpression();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMULTI_ARG_EXPRESSION__EXPRS = eINSTANCE.getAMultiArgExpression_Exprs();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgArithmeticExpressionImpl <em>AMulti Arg Arithmetic Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgArithmeticExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgArithmeticExpression()
     * @generated
     */
    EClass AMULTI_ARG_ARITHMETIC_EXPRESSION = eINSTANCE.getAMultiArgArithmeticExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AMULTI_ARG_ARITHMETIC_EXPRESSION__OP = eINSTANCE.getAMultiArgArithmeticExpression_Op();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgLogicalExpressionImpl <em>AMulti Arg Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiArgLogicalExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiArgLogicalExpression()
     * @generated
     */
    EClass AMULTI_ARG_LOGICAL_EXPRESSION = eINSTANCE.getAMultiArgLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AMULTI_ARG_LOGICAL_EXPRESSION__OP = eINSTANCE.getAMultiArgLogicalExpression_Op();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionCallImpl <em>AExternal Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionCallImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAExternalFunctionCall()
     * @generated
     */
    EClass AEXTERNAL_FUNCTION_CALL = eINSTANCE.getAExternalFunctionCall();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AEXTERNAL_FUNCTION_CALL__FUNC = eINSTANCE.getAExternalFunctionCall_Func();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexListImpl <em>AIndex List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexListImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexList()
     * @generated
     */
    EClass AINDEX_LIST = eINSTANCE.getAIndexList();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AINDEX_LIST__IDS = eINSTANCE.getAIndexList_Ids();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexAffineExpressionListImpl <em>AIndex Affine Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexAffineExpressionListImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAIndexAffineExpressionList()
     * @generated
     */
    EClass AINDEX_AFFINE_EXPRESSION_LIST = eINSTANCE.getAIndexAffineExpressionList();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AINDEX_AFFINE_EXPRESSION_LIST__EXPRS = eINSTANCE.getAIndexAffineExpressionList_Exprs();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl <em>AFunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAFunction()
     * @generated
     */
    EClass AFUNCTION = eINSTANCE.getAFunction();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFUNCTION__INDEXES = eINSTANCE.getAFunction_Indexes();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFUNCTION__FUNC = eINSTANCE.getAFunction_Func();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionInArrayNotationImpl <em>AFunction In Array Notation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionInArrayNotationImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAFunctionInArrayNotation()
     * @generated
     */
    EClass AFUNCTION_IN_ARRAY_NOTATION = eINSTANCE.getAFunctionInArrayNotation();

    /**
     * The meta object literal for the '<em><b>New Ids</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS = eINSTANCE.getAFunctionInArrayNotation_NewIds();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ATypeImpl <em>AType</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ATypeImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAType()
     * @generated
     */
    EClass ATYPE = eINSTANCE.getAType();

    /**
     * The meta object literal for the '<em><b>Unsigned</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATYPE__UNSIGNED = eINSTANCE.getAType_Unsigned();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATYPE__TYPE = eINSTANCE.getAType_Type();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AOrExpressionImpl <em>AOr Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AOrExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAOrExpression()
     * @generated
     */
    EClass AOR_EXPRESSION = eINSTANCE.getAOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AOR_EXPRESSION__LEFT = eINSTANCE.getAOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AOR_EXPRESSION__OPERATOR = eINSTANCE.getAOrExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AOR_EXPRESSION__RIGHT = eINSTANCE.getAOrExpression_Right();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAndExpressionImpl <em>AAnd Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAndExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAndExpression()
     * @generated
     */
    EClass AAND_EXPRESSION = eINSTANCE.getAAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAND_EXPRESSION__LEFT = eINSTANCE.getAAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AAND_EXPRESSION__OPERATOR = eINSTANCE.getAAndExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AAND_EXPRESSION__RIGHT = eINSTANCE.getAAndExpression_Right();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ARelationalExpressionImpl <em>ARelational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.ARelationalExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getARelationalExpression()
     * @generated
     */
    EClass ARELATIONAL_EXPRESSION = eINSTANCE.getARelationalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARELATIONAL_EXPRESSION__LEFT = eINSTANCE.getARelationalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getARelationalExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getARelationalExpression_Right();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAdditiveExpressionImpl <em>AAdditive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AAdditiveExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAAdditiveExpression()
     * @generated
     */
    EClass AADDITIVE_EXPRESSION = eINSTANCE.getAAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AADDITIVE_EXPRESSION__LEFT = eINSTANCE.getAAdditiveExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AADDITIVE_EXPRESSION__OP = eINSTANCE.getAAdditiveExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AADDITIVE_EXPRESSION__RIGHT = eINSTANCE.getAAdditiveExpression_Right();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiplicativeExpressionImpl <em>AMultiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMultiplicativeExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMultiplicativeExpression()
     * @generated
     */
    EClass AMULTIPLICATIVE_EXPRESSION = eINSTANCE.getAMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMULTIPLICATIVE_EXPRESSION__LEFT = eINSTANCE.getAMultiplicativeExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AMULTIPLICATIVE_EXPRESSION__OP = eINSTANCE.getAMultiplicativeExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMULTIPLICATIVE_EXPRESSION__RIGHT = eINSTANCE.getAMultiplicativeExpression_Right();

    /**
     * The meta object literal for the '{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AMinMaxExpressionImpl <em>AMin Max Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AMinMaxExpressionImpl
     * @see edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsPackageImpl#getAMinMaxExpression()
     * @generated
     */
    EClass AMIN_MAX_EXPRESSION = eINSTANCE.getAMinMaxExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMIN_MAX_EXPRESSION__LEFT = eINSTANCE.getAMinMaxExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AMIN_MAX_EXPRESSION__OP = eINSTANCE.getAMinMaxExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMIN_MAX_EXPRESSION__RIGHT = eINSTANCE.getAMinMaxExpression_Right();

  }

} //AlphabetsPackage
