/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.polymodel.algebra.quasiAffine.QuasiAffineFactory
 * @model kind="package"
 * @generated
 */
public interface QuasiAffinePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "quasiAffine";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/algebra/quasiAffine";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "quasiAffine";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QuasiAffinePackage eINSTANCE = org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.quasiAffine.impl.QuasiAffineExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffineExpressionImpl
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineExpression()
	 * @generated
	 */
	int QUASI_AFFINE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION__TERMS = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION_FEATURE_COUNT = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___SIMPLIFY = AlgebraPackage.INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___TO_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___TO_QUASI_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___TO_POLYNOMIAL = AlgebraPackage.INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___TO_REDUCTION = AlgebraPackage.INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___COPY = AlgebraPackage.INT_EXPRESSION___COPY;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_EXPRESSION_OPERATION_COUNT = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.quasiAffine.impl.QuasiAffineTermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffineTermImpl
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineTerm()
	 * @generated
	 */
	int QUASI_AFFINE_TERM = 1;

	/**
	 * The feature id for the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM__COEF = AlgebraPackage.INT_TERM__COEF;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM__OPERATOR = AlgebraPackage.INT_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM_FEATURE_COUNT = AlgebraPackage.INT_TERM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM___IS_EQUIVALENT__INTTERM = AlgebraPackage.INT_TERM___IS_EQUIVALENT__INTTERM;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_TERM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUASI_AFFINE_TERM_OPERATION_COUNT = AlgebraPackage.INT_TERM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.quasiAffine.impl.SimpleQuasiAffineTermImpl <em>Simple Quasi Affine Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.quasiAffine.impl.SimpleQuasiAffineTermImpl
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getSimpleQuasiAffineTerm()
	 * @generated
	 */
	int SIMPLE_QUASI_AFFINE_TERM = 2;

	/**
	 * The feature id for the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM__COEF = QUASI_AFFINE_TERM__COEF;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM__OPERATOR = QUASI_AFFINE_TERM__OPERATOR;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM__EXPRESSION = QUASI_AFFINE_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Quasi Affine Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM_FEATURE_COUNT = QUASI_AFFINE_TERM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM___IS_EQUIVALENT__INTTERM = QUASI_AFFINE_TERM___IS_EQUIVALENT__INTTERM;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The number of operations of the '<em>Simple Quasi Affine Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QUASI_AFFINE_TERM_OPERATION_COUNT = QUASI_AFFINE_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.quasiAffine.impl.NestedQuasiAffineTermImpl <em>Nested Quasi Affine Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.quasiAffine.impl.NestedQuasiAffineTermImpl
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getNestedQuasiAffineTerm()
	 * @generated
	 */
	int NESTED_QUASI_AFFINE_TERM = 3;

	/**
	 * The feature id for the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM__COEF = QUASI_AFFINE_TERM__COEF;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM__OPERATOR = QUASI_AFFINE_TERM__OPERATOR;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM__EXPRESSION = QUASI_AFFINE_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nested Quasi Affine Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM_FEATURE_COUNT = QUASI_AFFINE_TERM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM___IS_EQUIVALENT__INTTERM = QUASI_AFFINE_TERM___IS_EQUIVALENT__INTTERM;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The number of operations of the '<em>Nested Quasi Affine Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_QUASI_AFFINE_TERM_OPERATION_COUNT = QUASI_AFFINE_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.quasiAffine.QuasiAffineOperator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineOperator
	 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineOperator()
	 * @generated
	 */
	int QUASI_AFFINE_OPERATOR = 4;


	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.quasiAffine.QuasiAffineExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineExpression
	 * @generated
	 */
	EClass getQuasiAffineExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.quasiAffine.QuasiAffineExpression#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineExpression#getTerms()
	 * @see #getQuasiAffineExpression()
	 * @generated
	 */
	EReference getQuasiAffineExpression_Terms();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.quasiAffine.QuasiAffineExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getQuasiAffineExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineTerm
	 * @generated
	 */
	EClass getQuasiAffineTerm();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineTerm#getOperator()
	 * @see #getQuasiAffineTerm()
	 * @generated
	 */
	EAttribute getQuasiAffineTerm_Operator();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineTerm#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getQuasiAffineTerm__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm <em>Simple Quasi Affine Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Quasi Affine Term</em>'.
	 * @see org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm
	 * @generated
	 */
	EClass getSimpleQuasiAffineTerm();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm#getExpression()
	 * @see #getSimpleQuasiAffineTerm()
	 * @generated
	 */
	EReference getSimpleQuasiAffineTerm_Expression();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm <em>Nested Quasi Affine Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Quasi Affine Term</em>'.
	 * @see org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm
	 * @generated
	 */
	EClass getNestedQuasiAffineTerm();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm#getExpression()
	 * @see #getNestedQuasiAffineTerm()
	 * @generated
	 */
	EReference getNestedQuasiAffineTerm_Expression();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.algebra.quasiAffine.QuasiAffineOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineOperator
	 * @generated
	 */
	EEnum getQuasiAffineOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QuasiAffineFactory getQuasiAffineFactory();

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
		 * The meta object literal for the '{@link org.polymodel.algebra.quasiAffine.impl.QuasiAffineExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffineExpressionImpl
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineExpression()
		 * @generated
		 */
		EClass QUASI_AFFINE_EXPRESSION = eINSTANCE.getQuasiAffineExpression();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUASI_AFFINE_EXPRESSION__TERMS = eINSTANCE.getQuasiAffineExpression_Terms();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation QUASI_AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getQuasiAffineExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.quasiAffine.impl.QuasiAffineTermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffineTermImpl
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineTerm()
		 * @generated
		 */
		EClass QUASI_AFFINE_TERM = eINSTANCE.getQuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUASI_AFFINE_TERM__OPERATOR = eINSTANCE.getQuasiAffineTerm_Operator();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getQuasiAffineTerm__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.quasiAffine.impl.SimpleQuasiAffineTermImpl <em>Simple Quasi Affine Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.quasiAffine.impl.SimpleQuasiAffineTermImpl
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getSimpleQuasiAffineTerm()
		 * @generated
		 */
		EClass SIMPLE_QUASI_AFFINE_TERM = eINSTANCE.getSimpleQuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_QUASI_AFFINE_TERM__EXPRESSION = eINSTANCE.getSimpleQuasiAffineTerm_Expression();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.quasiAffine.impl.NestedQuasiAffineTermImpl <em>Nested Quasi Affine Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.quasiAffine.impl.NestedQuasiAffineTermImpl
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getNestedQuasiAffineTerm()
		 * @generated
		 */
		EClass NESTED_QUASI_AFFINE_TERM = eINSTANCE.getNestedQuasiAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_QUASI_AFFINE_TERM__EXPRESSION = eINSTANCE.getNestedQuasiAffineTerm_Expression();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.quasiAffine.QuasiAffineOperator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.quasiAffine.QuasiAffineOperator
		 * @see org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl#getQuasiAffineOperator()
		 * @generated
		 */
		EEnum QUASI_AFFINE_OPERATOR = eINSTANCE.getQuasiAffineOperator();

	}

} //QuasiAffinePackage
