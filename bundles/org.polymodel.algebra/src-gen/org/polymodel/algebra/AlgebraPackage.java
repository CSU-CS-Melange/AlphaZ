/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.polymodel.algebra.AlgebraFactory
 * @model kind="package"
 * @generated
 */
public interface AlgebraPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "algebra";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/algebra";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "algebra";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgebraPackage eINSTANCE = org.polymodel.algebra.impl.AlgebraPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.AlgebraVisitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.AlgebraVisitable
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getAlgebraVisitable()
	 * @generated
	 */
	int ALGEBRA_VISITABLE = 6;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITABLE___ACCEPT__ALGEBRAVISITOR = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITABLE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.IntExpressionImpl <em>Int Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.IntExpressionImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntExpression()
	 * @generated
	 */
	int INT_EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION_FEATURE_COUNT = ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___SIMPLIFY = ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = ALGEBRA_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___TO_AFFINE = ALGEBRA_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___TO_QUASI_AFFINE = ALGEBRA_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___TO_POLYNOMIAL = ALGEBRA_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___TO_REDUCTION = ALGEBRA_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR = ALGEBRA_VISITABLE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION___COPY = ALGEBRA_VISITABLE_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION_OPERATION_COUNT = ALGEBRA_VISITABLE_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.IntTermImpl <em>Int Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.IntTermImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntTerm()
	 * @generated
	 */
	int INT_TERM = 1;

	/**
	 * The feature id for the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TERM__COEF = ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TERM_FEATURE_COUNT = ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TERM___ACCEPT__ALGEBRAVISITOR = ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TERM___IS_EQUIVALENT__INTTERM = ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TERM_OPERATION_COUNT = ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.VariableImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___ACCEPT__ALGEBRAVISITOR = ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.IntConstraintImpl <em>Int Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.IntConstraintImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntConstraint()
	 * @generated
	 */
	int INT_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT__LHS = ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT__RHS = ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comparison Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT__COMPARISON_OPERATOR = ALGEBRA_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Int Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_FEATURE_COUNT = ALGEBRA_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___IS_AFFINE = ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___IS_QUASI_AFFINE = ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___IS_POLYNOMIAL = ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___ACCEPT__ALGEBRAVISITOR = ALGEBRA_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___SUBSTITUTE__VARIABLE_VARIABLE = ALGEBRA_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___SUBSTITUTE__VARIABLE_INTEXPRESSION = ALGEBRA_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___SIMPLIFY = ALGEBRA_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT___IS_EQUIVALENT__INTCONSTRAINT = ALGEBRA_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Int Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_OPERATION_COUNT = ALGEBRA_VISITABLE_OPERATION_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.IntConstraintSystemImpl <em>Int Constraint System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.IntConstraintSystemImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntConstraintSystem()
	 * @generated
	 */
	int INT_CONSTRAINT_SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM__CONSTRAINTS = ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Constraint System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM_FEATURE_COUNT = ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM___ACCEPT__ALGEBRAVISITOR = ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_VARIABLE = ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_INTEXPRESSION = ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM___SIMPLIFY = ALGEBRA_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM___COPY = ALGEBRA_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Int Constraint System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONSTRAINT_SYSTEM_OPERATION_COUNT = ALGEBRA_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.AlgebraVisitorImpl <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.AlgebraVisitorImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getAlgebraVisitor()
	 * @generated
	 */
	int ALGEBRA_VISITOR = 5;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Visit Int Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_INT_TERM__INTTERM = 0;

	/**
	 * The operation id for the '<em>Visit Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_VARIABLE__VARIABLE = 1;

	/**
	 * The operation id for the '<em>Visit Int Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT__INTCONSTRAINT = 2;

	/**
	 * The operation id for the '<em>Visit Int Constraint System</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT_SYSTEM__INTCONSTRAINTSYSTEM = 3;

	/**
	 * The operation id for the '<em>Visit Affine Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_AFFINE_EXPRESSION__AFFINEEXPRESSION = 4;

	/**
	 * The operation id for the '<em>Visit Affine Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_AFFINE_TERM__AFFINETERM = 5;

	/**
	 * The operation id for the '<em>Visit Quasi Affine Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_EXPRESSION__QUASIAFFINEEXPRESSION = 6;

	/**
	 * The operation id for the '<em>Visit Quasi Affine Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_TERM__QUASIAFFINETERM = 7;

	/**
	 * The operation id for the '<em>Visit Simple Quasi Affine Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_SIMPLE_QUASI_AFFINE_TERM__SIMPLEQUASIAFFINETERM = 8;

	/**
	 * The operation id for the '<em>Visit Nested Quasi Affine Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_NESTED_QUASI_AFFINE_TERM__NESTEDQUASIAFFINETERM = 9;

	/**
	 * The operation id for the '<em>Visit Polynomial Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_POLYNOMIAL_EXPRESSION__POLYNOMIALEXPRESSION = 10;

	/**
	 * The operation id for the '<em>Visit Polynomial Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_POLYNOMIAL_TERM__POLYNOMIALTERM = 11;

	/**
	 * The operation id for the '<em>Visit Polynomial Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_POLYNOMIAL_VARIABLE__POLYNOMIALVARIABLE = 12;

	/**
	 * The operation id for the '<em>Visit Reduction Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_REDUCTION_EXPRESSION__REDUCTIONEXPRESSION = 13;

	/**
	 * The operation id for the '<em>Visit Int Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_INT_EXPRESSION__INTEXPRESSION = 14;

	/**
	 * The operation id for the '<em>Visit Composite Int Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_COMPOSITE_INT_EXPRESSION__COMPOSITEINTEXPRESSION = 15;

	/**
	 * The operation id for the '<em>Visit Select Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR___VISIT_SELECT_EXPRESSION__SELECTEXPRESSION = 16;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGEBRA_VISITOR_OPERATION_COUNT = 17;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.CompositeIntExpressionImpl <em>Composite Int Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.CompositeIntExpressionImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getCompositeIntExpression()
	 * @generated
	 */
	int COMPOSITE_INT_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION__LEFT = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION__RIGHT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION__OPERATOR = INT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___SIMPLIFY = INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___TO_AFFINE = INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___TO_QUASI_AFFINE = INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___TO_POLYNOMIAL = INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___TO_REDUCTION = INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___COPY = INT_EXPRESSION___COPY;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composite Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INT_EXPRESSION_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.impl.SelectExpressionImpl <em>Select Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.SelectExpressionImpl
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getSelectExpression()
	 * @generated
	 */
	int SELECT_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION__CONDITION = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION__THEN = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION__ELSE = INT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Select Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___SIMPLIFY = INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___TO_AFFINE = INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___TO_QUASI_AFFINE = INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___TO_POLYNOMIAL = INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___TO_REDUCTION = INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___ACCEPT__ALGEBRAVISITOR = INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION___COPY = INT_EXPRESSION___COPY;

	/**
	 * The number of operations of the '<em>Select Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_EXPRESSION_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.ComparisonOperator <em>Comparison Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.ComparisonOperator
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getComparisonOperator()
	 * @generated
	 */
	int COMPARISON_OPERATOR = 9;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.FuzzyBoolean <em>Fuzzy Boolean</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.FuzzyBoolean
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getFuzzyBoolean()
	 * @generated
	 */
	int FUZZY_BOOLEAN = 10;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.CompositeOperator <em>Composite Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.CompositeOperator
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getCompositeOperator()
	 * @generated
	 */
	int COMPOSITE_OPERATOR = 11;

	/**
	 * The meta object id for the '<em>Value</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 12;


	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.IntExpression <em>Int Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Expression</em>'.
	 * @see org.polymodel.algebra.IntExpression
	 * @generated
	 */
	EClass getIntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#isEquivalent(org.polymodel.algebra.IntExpression) <em>Is Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equivalent</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#isEquivalent(org.polymodel.algebra.IntExpression)
	 * @generated
	 */
	EOperation getIntExpression__IsEquivalent__IntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#simplify()
	 * @generated
	 */
	EOperation getIntExpression__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getIntExpression__Substitute__Variable_Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression)
	 * @generated
	 */
	EOperation getIntExpression__Substitute__Variable_IntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#toAffine() <em>To Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Affine</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#toAffine()
	 * @generated
	 */
	EOperation getIntExpression__ToAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#toQuasiAffine() <em>To Quasi Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Quasi Affine</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#toQuasiAffine()
	 * @generated
	 */
	EOperation getIntExpression__ToQuasiAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#toPolynomial() <em>To Polynomial</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Polynomial</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#toPolynomial()
	 * @generated
	 */
	EOperation getIntExpression__ToPolynomial();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#toReduction() <em>To Reduction</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Reduction</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#toReduction()
	 * @generated
	 */
	EOperation getIntExpression__ToReduction();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getIntExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntExpression#copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy</em>' operation.
	 * @see org.polymodel.algebra.IntExpression#copy()
	 * @generated
	 */
	EOperation getIntExpression__Copy();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.IntTerm <em>Int Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Term</em>'.
	 * @see org.polymodel.algebra.IntTerm
	 * @generated
	 */
	EClass getIntTerm();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.IntTerm#getCoef <em>Coef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coef</em>'.
	 * @see org.polymodel.algebra.IntTerm#getCoef()
	 * @see #getIntTerm()
	 * @generated
	 */
	EAttribute getIntTerm_Coef();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntTerm#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.IntTerm#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getIntTerm__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntTerm#isEquivalent(org.polymodel.algebra.IntTerm) <em>Is Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equivalent</em>' operation.
	 * @see org.polymodel.algebra.IntTerm#isEquivalent(org.polymodel.algebra.IntTerm)
	 * @generated
	 */
	EOperation getIntTerm__IsEquivalent__IntTerm();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.polymodel.algebra.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.algebra.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.Variable#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.Variable#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getVariable__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.IntConstraint <em>Int Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Constraint</em>'.
	 * @see org.polymodel.algebra.IntConstraint
	 * @generated
	 */
	EClass getIntConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.IntConstraint#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.polymodel.algebra.IntConstraint#getLhs()
	 * @see #getIntConstraint()
	 * @generated
	 */
	EReference getIntConstraint_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.IntConstraint#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.polymodel.algebra.IntConstraint#getRhs()
	 * @see #getIntConstraint()
	 * @generated
	 */
	EReference getIntConstraint_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.IntConstraint#getComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparison Operator</em>'.
	 * @see org.polymodel.algebra.IntConstraint#getComparisonOperator()
	 * @see #getIntConstraint()
	 * @generated
	 */
	EAttribute getIntConstraint_ComparisonOperator();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#isAffine() <em>Is Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Affine</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#isAffine()
	 * @generated
	 */
	EOperation getIntConstraint__IsAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#isQuasiAffine() <em>Is Quasi Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Quasi Affine</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#isQuasiAffine()
	 * @generated
	 */
	EOperation getIntConstraint__IsQuasiAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#isPolynomial() <em>Is Polynomial</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Polynomial</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#isPolynomial()
	 * @generated
	 */
	EOperation getIntConstraint__IsPolynomial();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getIntConstraint__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getIntConstraint__Substitute__Variable_Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression)
	 * @generated
	 */
	EOperation getIntConstraint__Substitute__Variable_IntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#simplify()
	 * @generated
	 */
	EOperation getIntConstraint__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraint#isEquivalent(org.polymodel.algebra.IntConstraint) <em>Is Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equivalent</em>' operation.
	 * @see org.polymodel.algebra.IntConstraint#isEquivalent(org.polymodel.algebra.IntConstraint)
	 * @generated
	 */
	EOperation getIntConstraint__IsEquivalent__IntConstraint();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.IntConstraintSystem <em>Int Constraint System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Constraint System</em>'.
	 * @see org.polymodel.algebra.IntConstraintSystem
	 * @generated
	 */
	EClass getIntConstraintSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.IntConstraintSystem#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.polymodel.algebra.IntConstraintSystem#getConstraints()
	 * @see #getIntConstraintSystem()
	 * @generated
	 */
	EReference getIntConstraintSystem_Constraints();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraintSystem#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.IntConstraintSystem#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getIntConstraintSystem__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraintSystem#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntConstraintSystem#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getIntConstraintSystem__Substitute__Variable_Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraintSystem#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression) <em>Substitute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Substitute</em>' operation.
	 * @see org.polymodel.algebra.IntConstraintSystem#substitute(org.polymodel.algebra.Variable, org.polymodel.algebra.IntExpression)
	 * @generated
	 */
	EOperation getIntConstraintSystem__Substitute__Variable_IntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraintSystem#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.algebra.IntConstraintSystem#simplify()
	 * @generated
	 */
	EOperation getIntConstraintSystem__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.IntConstraintSystem#copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy</em>' operation.
	 * @see org.polymodel.algebra.IntConstraintSystem#copy()
	 * @generated
	 */
	EOperation getIntConstraintSystem__Copy();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.AlgebraVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.polymodel.algebra.AlgebraVisitor
	 * @generated
	 */
	EClass getAlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitIntTerm(org.polymodel.algebra.IntTerm) <em>Visit Int Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Int Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitIntTerm(org.polymodel.algebra.IntTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitIntTerm__IntTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitVariable(org.polymodel.algebra.Variable) <em>Visit Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Variable</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitVariable(org.polymodel.algebra.Variable)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitVariable__Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitIntConstraint(org.polymodel.algebra.IntConstraint) <em>Visit Int Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Int Constraint</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitIntConstraint(org.polymodel.algebra.IntConstraint)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitIntConstraint__IntConstraint();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitIntConstraintSystem(org.polymodel.algebra.IntConstraintSystem) <em>Visit Int Constraint System</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Int Constraint System</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitIntConstraintSystem(org.polymodel.algebra.IntConstraintSystem)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitIntConstraintSystem__IntConstraintSystem();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitAffineExpression(org.polymodel.algebra.affine.AffineExpression) <em>Visit Affine Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Affine Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitAffineExpression(org.polymodel.algebra.affine.AffineExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitAffineExpression__AffineExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitAffineTerm(org.polymodel.algebra.affine.AffineTerm) <em>Visit Affine Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Affine Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitAffineTerm(org.polymodel.algebra.affine.AffineTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitAffineTerm__AffineTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitQuasiAffineExpression(org.polymodel.algebra.quasiAffine.QuasiAffineExpression) <em>Visit Quasi Affine Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Quasi Affine Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitQuasiAffineExpression(org.polymodel.algebra.quasiAffine.QuasiAffineExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitQuasiAffineExpression__QuasiAffineExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitQuasiAffineTerm(org.polymodel.algebra.quasiAffine.QuasiAffineTerm) <em>Visit Quasi Affine Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Quasi Affine Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitQuasiAffineTerm(org.polymodel.algebra.quasiAffine.QuasiAffineTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitQuasiAffineTerm__QuasiAffineTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitSimpleQuasiAffineTerm(org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm) <em>Visit Simple Quasi Affine Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Simple Quasi Affine Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitSimpleQuasiAffineTerm(org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitSimpleQuasiAffineTerm__SimpleQuasiAffineTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitNestedQuasiAffineTerm(org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm) <em>Visit Nested Quasi Affine Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Nested Quasi Affine Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitNestedQuasiAffineTerm(org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitNestedQuasiAffineTerm__NestedQuasiAffineTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitPolynomialExpression(org.polymodel.algebra.polynomials.PolynomialExpression) <em>Visit Polynomial Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Polynomial Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitPolynomialExpression(org.polymodel.algebra.polynomials.PolynomialExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitPolynomialExpression__PolynomialExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitPolynomialTerm(org.polymodel.algebra.polynomials.PolynomialTerm) <em>Visit Polynomial Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Polynomial Term</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitPolynomialTerm(org.polymodel.algebra.polynomials.PolynomialTerm)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitPolynomialTerm__PolynomialTerm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitPolynomialVariable(org.polymodel.algebra.polynomials.PolynomialVariable) <em>Visit Polynomial Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Polynomial Variable</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitPolynomialVariable(org.polymodel.algebra.polynomials.PolynomialVariable)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitPolynomialVariable__PolynomialVariable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitReductionExpression(org.polymodel.algebra.reductions.ReductionExpression) <em>Visit Reduction Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Reduction Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitReductionExpression(org.polymodel.algebra.reductions.ReductionExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitReductionExpression__ReductionExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitIntExpression(org.polymodel.algebra.IntExpression) <em>Visit Int Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Int Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitIntExpression(org.polymodel.algebra.IntExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitIntExpression__IntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitCompositeIntExpression(org.polymodel.algebra.CompositeIntExpression) <em>Visit Composite Int Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Composite Int Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitCompositeIntExpression(org.polymodel.algebra.CompositeIntExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitCompositeIntExpression__CompositeIntExpression();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitor#visitSelectExpression(org.polymodel.algebra.SelectExpression) <em>Visit Select Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Select Expression</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitor#visitSelectExpression(org.polymodel.algebra.SelectExpression)
	 * @generated
	 */
	EOperation getAlgebraVisitor__VisitSelectExpression__SelectExpression();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.AlgebraVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.polymodel.algebra.AlgebraVisitable
	 * @generated
	 */
	EClass getAlgebraVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.AlgebraVisitable#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.AlgebraVisitable#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getAlgebraVisitable__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.CompositeIntExpression <em>Composite Int Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Int Expression</em>'.
	 * @see org.polymodel.algebra.CompositeIntExpression
	 * @generated
	 */
	EClass getCompositeIntExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.CompositeIntExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.polymodel.algebra.CompositeIntExpression#getLeft()
	 * @see #getCompositeIntExpression()
	 * @generated
	 */
	EReference getCompositeIntExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.CompositeIntExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.polymodel.algebra.CompositeIntExpression#getRight()
	 * @see #getCompositeIntExpression()
	 * @generated
	 */
	EReference getCompositeIntExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.CompositeIntExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.algebra.CompositeIntExpression#getOperator()
	 * @see #getCompositeIntExpression()
	 * @generated
	 */
	EAttribute getCompositeIntExpression_Operator();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.CompositeIntExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.CompositeIntExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getCompositeIntExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.SelectExpression <em>Select Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Expression</em>'.
	 * @see org.polymodel.algebra.SelectExpression
	 * @generated
	 */
	EClass getSelectExpression();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.algebra.SelectExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Condition</em>'.
	 * @see org.polymodel.algebra.SelectExpression#getCondition()
	 * @see #getSelectExpression()
	 * @generated
	 */
	EReference getSelectExpression_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.SelectExpression#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.polymodel.algebra.SelectExpression#getThen()
	 * @see #getSelectExpression()
	 * @generated
	 */
	EReference getSelectExpression_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.SelectExpression#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.polymodel.algebra.SelectExpression#getElse()
	 * @see #getSelectExpression()
	 * @generated
	 */
	EReference getSelectExpression_Else();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.algebra.ComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Operator</em>'.
	 * @see org.polymodel.algebra.ComparisonOperator
	 * @generated
	 */
	EEnum getComparisonOperator();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.algebra.FuzzyBoolean <em>Fuzzy Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fuzzy Boolean</em>'.
	 * @see org.polymodel.algebra.FuzzyBoolean
	 * @generated
	 */
	EEnum getFuzzyBoolean();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.algebra.CompositeOperator <em>Composite Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Composite Operator</em>'.
	 * @see org.polymodel.algebra.CompositeOperator
	 * @generated
	 */
	EEnum getCompositeOperator();

	/**
	 * Returns the meta object for data type '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Value</em>'.
	 * @model instanceClass="long"
	 * @generated
	 */
	EDataType getValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AlgebraFactory getAlgebraFactory();

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
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.IntExpressionImpl <em>Int Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.IntExpressionImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntExpression()
		 * @generated
		 */
		EClass INT_EXPRESSION = eINSTANCE.getIntExpression();

		/**
		 * The meta object literal for the '<em><b>Is Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = eINSTANCE.getIntExpression__IsEquivalent__IntExpression();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___SIMPLIFY = eINSTANCE.getIntExpression__Simplify();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = eINSTANCE.getIntExpression__Substitute__Variable_Variable();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = eINSTANCE.getIntExpression__Substitute__Variable_IntExpression();

		/**
		 * The meta object literal for the '<em><b>To Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___TO_AFFINE = eINSTANCE.getIntExpression__ToAffine();

		/**
		 * The meta object literal for the '<em><b>To Quasi Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___TO_QUASI_AFFINE = eINSTANCE.getIntExpression__ToQuasiAffine();

		/**
		 * The meta object literal for the '<em><b>To Polynomial</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___TO_POLYNOMIAL = eINSTANCE.getIntExpression__ToPolynomial();

		/**
		 * The meta object literal for the '<em><b>To Reduction</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___TO_REDUCTION = eINSTANCE.getIntExpression__ToReduction();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getIntExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_EXPRESSION___COPY = eINSTANCE.getIntExpression__Copy();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.IntTermImpl <em>Int Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.IntTermImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntTerm()
		 * @generated
		 */
		EClass INT_TERM = eINSTANCE.getIntTerm();

		/**
		 * The meta object literal for the '<em><b>Coef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_TERM__COEF = eINSTANCE.getIntTerm_Coef();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_TERM___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getIntTerm__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Is Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_TERM___IS_EQUIVALENT__INTTERM = eINSTANCE.getIntTerm__IsEquivalent__IntTerm();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.VariableImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getVariable__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.IntConstraintImpl <em>Int Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.IntConstraintImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntConstraint()
		 * @generated
		 */
		EClass INT_CONSTRAINT = eINSTANCE.getIntConstraint();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_CONSTRAINT__LHS = eINSTANCE.getIntConstraint_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_CONSTRAINT__RHS = eINSTANCE.getIntConstraint_Rhs();

		/**
		 * The meta object literal for the '<em><b>Comparison Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_CONSTRAINT__COMPARISON_OPERATOR = eINSTANCE.getIntConstraint_ComparisonOperator();

		/**
		 * The meta object literal for the '<em><b>Is Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___IS_AFFINE = eINSTANCE.getIntConstraint__IsAffine();

		/**
		 * The meta object literal for the '<em><b>Is Quasi Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___IS_QUASI_AFFINE = eINSTANCE.getIntConstraint__IsQuasiAffine();

		/**
		 * The meta object literal for the '<em><b>Is Polynomial</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___IS_POLYNOMIAL = eINSTANCE.getIntConstraint__IsPolynomial();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getIntConstraint__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___SUBSTITUTE__VARIABLE_VARIABLE = eINSTANCE.getIntConstraint__Substitute__Variable_Variable();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___SUBSTITUTE__VARIABLE_INTEXPRESSION = eINSTANCE.getIntConstraint__Substitute__Variable_IntExpression();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___SIMPLIFY = eINSTANCE.getIntConstraint__Simplify();

		/**
		 * The meta object literal for the '<em><b>Is Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT___IS_EQUIVALENT__INTCONSTRAINT = eINSTANCE.getIntConstraint__IsEquivalent__IntConstraint();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.IntConstraintSystemImpl <em>Int Constraint System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.IntConstraintSystemImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getIntConstraintSystem()
		 * @generated
		 */
		EClass INT_CONSTRAINT_SYSTEM = eINSTANCE.getIntConstraintSystem();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_CONSTRAINT_SYSTEM__CONSTRAINTS = eINSTANCE.getIntConstraintSystem_Constraints();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT_SYSTEM___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getIntConstraintSystem__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_VARIABLE = eINSTANCE.getIntConstraintSystem__Substitute__Variable_Variable();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_INTEXPRESSION = eINSTANCE.getIntConstraintSystem__Substitute__Variable_IntExpression();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT_SYSTEM___SIMPLIFY = eINSTANCE.getIntConstraintSystem__Simplify();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INT_CONSTRAINT_SYSTEM___COPY = eINSTANCE.getIntConstraintSystem__Copy();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.AlgebraVisitorImpl <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.AlgebraVisitorImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getAlgebraVisitor()
		 * @generated
		 */
		EClass ALGEBRA_VISITOR = eINSTANCE.getAlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Visit Int Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_INT_TERM__INTTERM = eINSTANCE.getAlgebraVisitor__VisitIntTerm__IntTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_VARIABLE__VARIABLE = eINSTANCE.getAlgebraVisitor__VisitVariable__Variable();

		/**
		 * The meta object literal for the '<em><b>Visit Int Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT__INTCONSTRAINT = eINSTANCE.getAlgebraVisitor__VisitIntConstraint__IntConstraint();

		/**
		 * The meta object literal for the '<em><b>Visit Int Constraint System</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT_SYSTEM__INTCONSTRAINTSYSTEM = eINSTANCE.getAlgebraVisitor__VisitIntConstraintSystem__IntConstraintSystem();

		/**
		 * The meta object literal for the '<em><b>Visit Affine Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_AFFINE_EXPRESSION__AFFINEEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitAffineExpression__AffineExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Affine Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_AFFINE_TERM__AFFINETERM = eINSTANCE.getAlgebraVisitor__VisitAffineTerm__AffineTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Quasi Affine Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_EXPRESSION__QUASIAFFINEEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitQuasiAffineExpression__QuasiAffineExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Quasi Affine Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_TERM__QUASIAFFINETERM = eINSTANCE.getAlgebraVisitor__VisitQuasiAffineTerm__QuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Simple Quasi Affine Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_SIMPLE_QUASI_AFFINE_TERM__SIMPLEQUASIAFFINETERM = eINSTANCE.getAlgebraVisitor__VisitSimpleQuasiAffineTerm__SimpleQuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Nested Quasi Affine Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_NESTED_QUASI_AFFINE_TERM__NESTEDQUASIAFFINETERM = eINSTANCE.getAlgebraVisitor__VisitNestedQuasiAffineTerm__NestedQuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Polynomial Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_POLYNOMIAL_EXPRESSION__POLYNOMIALEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitPolynomialExpression__PolynomialExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Polynomial Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_POLYNOMIAL_TERM__POLYNOMIALTERM = eINSTANCE.getAlgebraVisitor__VisitPolynomialTerm__PolynomialTerm();

		/**
		 * The meta object literal for the '<em><b>Visit Polynomial Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_POLYNOMIAL_VARIABLE__POLYNOMIALVARIABLE = eINSTANCE.getAlgebraVisitor__VisitPolynomialVariable__PolynomialVariable();

		/**
		 * The meta object literal for the '<em><b>Visit Reduction Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_REDUCTION_EXPRESSION__REDUCTIONEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitReductionExpression__ReductionExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Int Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_INT_EXPRESSION__INTEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitIntExpression__IntExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Composite Int Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_COMPOSITE_INT_EXPRESSION__COMPOSITEINTEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitCompositeIntExpression__CompositeIntExpression();

		/**
		 * The meta object literal for the '<em><b>Visit Select Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITOR___VISIT_SELECT_EXPRESSION__SELECTEXPRESSION = eINSTANCE.getAlgebraVisitor__VisitSelectExpression__SelectExpression();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.AlgebraVisitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.AlgebraVisitable
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getAlgebraVisitable()
		 * @generated
		 */
		EClass ALGEBRA_VISITABLE = eINSTANCE.getAlgebraVisitable();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGEBRA_VISITABLE___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getAlgebraVisitable__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.CompositeIntExpressionImpl <em>Composite Int Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.CompositeIntExpressionImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getCompositeIntExpression()
		 * @generated
		 */
		EClass COMPOSITE_INT_EXPRESSION = eINSTANCE.getCompositeIntExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_INT_EXPRESSION__LEFT = eINSTANCE.getCompositeIntExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_INT_EXPRESSION__RIGHT = eINSTANCE.getCompositeIntExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_INT_EXPRESSION__OPERATOR = eINSTANCE.getCompositeIntExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITE_INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getCompositeIntExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.impl.SelectExpressionImpl <em>Select Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.SelectExpressionImpl
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getSelectExpression()
		 * @generated
		 */
		EClass SELECT_EXPRESSION = eINSTANCE.getSelectExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_EXPRESSION__CONDITION = eINSTANCE.getSelectExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_EXPRESSION__THEN = eINSTANCE.getSelectExpression_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_EXPRESSION__ELSE = eINSTANCE.getSelectExpression_Else();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.ComparisonOperator <em>Comparison Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.ComparisonOperator
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getComparisonOperator()
		 * @generated
		 */
		EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.FuzzyBoolean <em>Fuzzy Boolean</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.FuzzyBoolean
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getFuzzyBoolean()
		 * @generated
		 */
		EEnum FUZZY_BOOLEAN = eINSTANCE.getFuzzyBoolean();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.CompositeOperator <em>Composite Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.CompositeOperator
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getCompositeOperator()
		 * @generated
		 */
		EEnum COMPOSITE_OPERATOR = eINSTANCE.getCompositeOperator();

		/**
		 * The meta object literal for the '<em>Value</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.impl.AlgebraPackageImpl#getValue()
		 * @generated
		 */
		EDataType VALUE = eINSTANCE.getValue();

	}

} //AlgebraPackage
