/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;

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
 * @see org.polymodel.polyhedralIR.expression.ExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "polyhedralIR.expression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polyhedralIR.expression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.CaseExpressionImpl <em>Case Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.CaseExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getCaseExpression()
	 * @generated
	 */
	int CASE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION__EXPRS = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.DependenceExpressionImpl <em>Dependence Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.DependenceExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getDependenceExpression()
	 * @generated
	 */
	int DEPENDENCE_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Dep</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION__DEP = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION__EXPR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dependence Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCE_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.IfExpressionImpl <em>If Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.IfExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIfExpression()
	 * @generated
	 */
	int IF_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__COND = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__THEN = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__ELSE = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.IndexExpressionImpl <em>Index Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.IndexExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIndexExpression()
	 * @generated
	 */
	int INDEX_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPRESSION__FUNCTION = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl <em>Reduce Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getReduceExpression()
	 * @generated
	 */
	int REDUCE_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>OP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__OP = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__PROJECTION = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION__EXPR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reduce Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCE_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl <em>Restrict Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getRestrictExpression()
	 * @generated
	 */
	int RESTRICT_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Restrict Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION__RESTRICT_DOMAIN = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION__EXPR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Restrict Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICT_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.VariableExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getVariableExpression()
	 * @generated
	 */
	int VARIABLE_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Var Decl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__VAR_DECL = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__OPERATOR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lexp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEXP = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rexp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__REXP = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.ConstantExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getConstantExpression()
	 * @generated
	 */
	int CONSTANT_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The number of structural features of the '<em>Constant Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.BooleanExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__CONTEXT_DOMAIN = CONSTANT_EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__EXPRESSION_DOMAIN = CONSTANT_EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__EXPRESSION_TYPE = CONSTANT_EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.IntegerExpressionImpl <em>Integer Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.IntegerExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIntegerExpression()
	 * @generated
	 */
	int INTEGER_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__CONTEXT_DOMAIN = CONSTANT_EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__EXPRESSION_DOMAIN = CONSTANT_EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__EXPRESSION_TYPE = CONSTANT_EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.RealExpressionImpl <em>Real Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.RealExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getRealExpression()
	 * @generated
	 */
	int REAL_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__CONTEXT_DOMAIN = CONSTANT_EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__EXPRESSION_DOMAIN = CONSTANT_EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__EXPRESSION_TYPE = CONSTANT_EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.MultiArgExpressionImpl <em>Multi Arg Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.MultiArgExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getMultiArgExpression()
	 * @generated
	 */
	int MULTI_ARG_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION__OPERATOR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION__EXPRS = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Arg Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARG_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.ExternalFunctionCallImpl <em>External Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.ExternalFunctionCallImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getExternalFunctionCall()
	 * @generated
	 */
	int EXTERNAL_FUNCTION_CALL = 13;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__CONTEXT_DOMAIN = MULTI_ARG_EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__EXPRESSION_DOMAIN = MULTI_ARG_EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__EXPRESSION_TYPE = MULTI_ARG_EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__OPERATOR = MULTI_ARG_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__EXPRS = MULTI_ARG_EXPRESSION__EXPRS;

	/**
	 * The feature id for the '<em><b>Ex Func</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL__EX_FUNC = MULTI_ARG_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Function Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_CALL_FEATURE_COUNT = MULTI_ARG_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.expression.impl.UnaryExpressionImpl
	 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__CONTEXT_DOMAIN = PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__EXPRESSION_DOMAIN = PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__EXPRESSION_TYPE = PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATOR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__EXPR = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = PolyhedralIRPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.CaseExpression <em>Case Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.CaseExpression
	 * @generated
	 */
	EClass getCaseExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.expression.CaseExpression#getExprs <em>Exprs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exprs</em>'.
	 * @see org.polymodel.polyhedralIR.expression.CaseExpression#getExprs()
	 * @see #getCaseExpression()
	 * @generated
	 */
	EReference getCaseExpression_Exprs();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.DependenceExpression <em>Dependence Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependence Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.DependenceExpression
	 * @generated
	 */
	EClass getDependenceExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getDep <em>Dep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dep</em>'.
	 * @see org.polymodel.polyhedralIR.expression.DependenceExpression#getDep()
	 * @see #getDependenceExpression()
	 * @generated
	 */
	EReference getDependenceExpression_Dep();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.polymodel.polyhedralIR.expression.DependenceExpression#getExpr()
	 * @see #getDependenceExpression()
	 * @generated
	 */
	EReference getDependenceExpression_Expr();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.IfExpression <em>If Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IfExpression
	 * @generated
	 */
	EClass getIfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.IfExpression#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IfExpression#getCond()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_Cond();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.IfExpression#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IfExpression#getThen()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.IfExpression#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IfExpression#getElse()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_Else();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.IndexExpression <em>Index Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IndexExpression
	 * @generated
	 */
	EClass getIndexExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.IndexExpression#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IndexExpression#getFunction()
	 * @see #getIndexExpression()
	 * @generated
	 */
	EReference getIndexExpression_Function();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.ReduceExpression <em>Reduce Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reduce Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ReduceExpression
	 * @generated
	 */
	EClass getReduceExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getOP <em>OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>OP</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ReduceExpression#getOP()
	 * @see #getReduceExpression()
	 * @generated
	 */
	EAttribute getReduceExpression_OP();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getProjection <em>Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Projection</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ReduceExpression#getProjection()
	 * @see #getReduceExpression()
	 * @generated
	 */
	EReference getReduceExpression_Projection();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ReduceExpression#getExpr()
	 * @see #getReduceExpression()
	 * @generated
	 */
	EReference getReduceExpression_Expr();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.RestrictExpression <em>Restrict Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restrict Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.RestrictExpression
	 * @generated
	 */
	EClass getRestrictExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getRestrictDomain <em>Restrict Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restrict Domain</em>'.
	 * @see org.polymodel.polyhedralIR.expression.RestrictExpression#getRestrictDomain()
	 * @see #getRestrictExpression()
	 * @generated
	 */
	EReference getRestrictExpression_RestrictDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.polymodel.polyhedralIR.expression.RestrictExpression#getExpr()
	 * @see #getRestrictExpression()
	 * @generated
	 */
	EReference getRestrictExpression_Expr();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.VariableExpression <em>Variable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.VariableExpression
	 * @generated
	 */
	EClass getVariableExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.expression.VariableExpression#getVarDecl <em>Var Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var Decl</em>'.
	 * @see org.polymodel.polyhedralIR.expression.VariableExpression#getVarDecl()
	 * @see #getVariableExpression()
	 * @generated
	 */
	EReference getVariableExpression_VarDecl();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BinaryExpression#getOperator()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EAttribute getBinaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getLexp <em>Lexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lexp</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BinaryExpression#getLexp()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Lexp();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getRexp <em>Rexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rexp</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BinaryExpression#getRexp()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Rexp();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.ConstantExpression <em>Constant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ConstantExpression
	 * @generated
	 */
	EClass getConstantExpression();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.BooleanExpression#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polymodel.polyhedralIR.expression.BooleanExpression#isValue()
	 * @see #getBooleanExpression()
	 * @generated
	 */
	EAttribute getBooleanExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.IntegerExpression <em>Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IntegerExpression
	 * @generated
	 */
	EClass getIntegerExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.IntegerExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polymodel.polyhedralIR.expression.IntegerExpression#getValue()
	 * @see #getIntegerExpression()
	 * @generated
	 */
	EAttribute getIntegerExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.RealExpression <em>Real Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.RealExpression
	 * @generated
	 */
	EClass getRealExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.RealExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polymodel.polyhedralIR.expression.RealExpression#getValue()
	 * @see #getRealExpression()
	 * @generated
	 */
	EAttribute getRealExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.MultiArgExpression <em>Multi Arg Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Arg Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.MultiArgExpression
	 * @generated
	 */
	EClass getMultiArgExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.MultiArgExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.polyhedralIR.expression.MultiArgExpression#getOperator()
	 * @see #getMultiArgExpression()
	 * @generated
	 */
	EAttribute getMultiArgExpression_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.expression.MultiArgExpression#getExprs <em>Exprs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exprs</em>'.
	 * @see org.polymodel.polyhedralIR.expression.MultiArgExpression#getExprs()
	 * @see #getMultiArgExpression()
	 * @generated
	 */
	EReference getMultiArgExpression_Exprs();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.ExternalFunctionCall <em>External Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Function Call</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ExternalFunctionCall
	 * @generated
	 */
	EClass getExternalFunctionCall();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.expression.ExternalFunctionCall#getExFunc <em>Ex Func</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ex Func</em>'.
	 * @see org.polymodel.polyhedralIR.expression.ExternalFunctionCall#getExFunc()
	 * @see #getExternalFunctionCall()
	 * @generated
	 */
	EReference getExternalFunctionCall_ExFunc();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.expression.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see org.polymodel.polyhedralIR.expression.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.expression.UnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.polyhedralIR.expression.UnaryExpression#getOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.expression.UnaryExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.polymodel.polyhedralIR.expression.UnaryExpression#getExpr()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Expr();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionFactory getExpressionFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.CaseExpressionImpl <em>Case Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.CaseExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getCaseExpression()
		 * @generated
		 */
		EClass CASE_EXPRESSION = eINSTANCE.getCaseExpression();

		/**
		 * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_EXPRESSION__EXPRS = eINSTANCE.getCaseExpression_Exprs();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.DependenceExpressionImpl <em>Dependence Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.DependenceExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getDependenceExpression()
		 * @generated
		 */
		EClass DEPENDENCE_EXPRESSION = eINSTANCE.getDependenceExpression();

		/**
		 * The meta object literal for the '<em><b>Dep</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCE_EXPRESSION__DEP = eINSTANCE.getDependenceExpression_Dep();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCE_EXPRESSION__EXPR = eINSTANCE.getDependenceExpression_Expr();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.IfExpressionImpl <em>If Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.IfExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIfExpression()
		 * @generated
		 */
		EClass IF_EXPRESSION = eINSTANCE.getIfExpression();

		/**
		 * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__COND = eINSTANCE.getIfExpression_Cond();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__THEN = eINSTANCE.getIfExpression_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__ELSE = eINSTANCE.getIfExpression_Else();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.IndexExpressionImpl <em>Index Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.IndexExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIndexExpression()
		 * @generated
		 */
		EClass INDEX_EXPRESSION = eINSTANCE.getIndexExpression();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_EXPRESSION__FUNCTION = eINSTANCE.getIndexExpression_Function();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl <em>Reduce Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getReduceExpression()
		 * @generated
		 */
		EClass REDUCE_EXPRESSION = eINSTANCE.getReduceExpression();

		/**
		 * The meta object literal for the '<em><b>OP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUCE_EXPRESSION__OP = eINSTANCE.getReduceExpression_OP();

		/**
		 * The meta object literal for the '<em><b>Projection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCE_EXPRESSION__PROJECTION = eINSTANCE.getReduceExpression_Projection();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCE_EXPRESSION__EXPR = eINSTANCE.getReduceExpression_Expr();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl <em>Restrict Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getRestrictExpression()
		 * @generated
		 */
		EClass RESTRICT_EXPRESSION = eINSTANCE.getRestrictExpression();

		/**
		 * The meta object literal for the '<em><b>Restrict Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTRICT_EXPRESSION__RESTRICT_DOMAIN = eINSTANCE.getRestrictExpression_RestrictDomain();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTRICT_EXPRESSION__EXPR = eINSTANCE.getRestrictExpression_Expr();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.VariableExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getVariableExpression()
		 * @generated
		 */
		EClass VARIABLE_EXPRESSION = eINSTANCE.getVariableExpression();

		/**
		 * The meta object literal for the '<em><b>Var Decl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXPRESSION__VAR_DECL = eINSTANCE.getVariableExpression_VarDecl();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION__OPERATOR = eINSTANCE.getBinaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Lexp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEXP = eINSTANCE.getBinaryExpression_Lexp();

		/**
		 * The meta object literal for the '<em><b>Rexp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__REXP = eINSTANCE.getBinaryExpression_Rexp();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.ConstantExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getConstantExpression()
		 * @generated
		 */
		EClass CONSTANT_EXPRESSION = eINSTANCE.getConstantExpression();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.BooleanExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_EXPRESSION__VALUE = eINSTANCE.getBooleanExpression_Value();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.IntegerExpressionImpl <em>Integer Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.IntegerExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getIntegerExpression()
		 * @generated
		 */
		EClass INTEGER_EXPRESSION = eINSTANCE.getIntegerExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_EXPRESSION__VALUE = eINSTANCE.getIntegerExpression_Value();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.RealExpressionImpl <em>Real Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.RealExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getRealExpression()
		 * @generated
		 */
		EClass REAL_EXPRESSION = eINSTANCE.getRealExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_EXPRESSION__VALUE = eINSTANCE.getRealExpression_Value();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.MultiArgExpressionImpl <em>Multi Arg Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.MultiArgExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getMultiArgExpression()
		 * @generated
		 */
		EClass MULTI_ARG_EXPRESSION = eINSTANCE.getMultiArgExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ARG_EXPRESSION__OPERATOR = eINSTANCE.getMultiArgExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_ARG_EXPRESSION__EXPRS = eINSTANCE.getMultiArgExpression_Exprs();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.ExternalFunctionCallImpl <em>External Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.ExternalFunctionCallImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getExternalFunctionCall()
		 * @generated
		 */
		EClass EXTERNAL_FUNCTION_CALL = eINSTANCE.getExternalFunctionCall();

		/**
		 * The meta object literal for the '<em><b>Ex Func</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_FUNCTION_CALL__EX_FUNC = eINSTANCE.getExternalFunctionCall_ExFunc();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.expression.impl.UnaryExpressionImpl
		 * @see org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__EXPR = eINSTANCE.getUnaryExpression_Expr();

	}

} //ExpressionPackage
