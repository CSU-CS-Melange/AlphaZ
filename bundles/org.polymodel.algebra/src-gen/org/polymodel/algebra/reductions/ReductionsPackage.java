/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.reductions;

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
 * @see org.polymodel.algebra.reductions.ReductionsFactory
 * @model kind="package"
 * @generated
 */
public interface ReductionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "reductions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/algebra/reductions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "reductions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReductionsPackage eINSTANCE = org.polymodel.algebra.reductions.impl.ReductionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.reductions.impl.ReductionExpressionImpl <em>Reduction Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.reductions.impl.ReductionExpressionImpl
	 * @see org.polymodel.algebra.reductions.impl.ReductionsPackageImpl#getReductionExpression()
	 * @generated
	 */
	int REDUCTION_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION__EXPRESSIONS = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION__OPERATOR = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reduction Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION_FEATURE_COUNT = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___SIMPLIFY = AlgebraPackage.INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___TO_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___TO_QUASI_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___TO_POLYNOMIAL = AlgebraPackage.INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___TO_REDUCTION = AlgebraPackage.INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___COPY = AlgebraPackage.INT_EXPRESSION___COPY;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reduction Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_EXPRESSION_OPERATION_COUNT = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.reductions.ReductionOperator <em>Reduction Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.reductions.ReductionOperator
	 * @see org.polymodel.algebra.reductions.impl.ReductionsPackageImpl#getReductionOperator()
	 * @generated
	 */
	int REDUCTION_OPERATOR = 1;


	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.reductions.ReductionExpression <em>Reduction Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reduction Expression</em>'.
	 * @see org.polymodel.algebra.reductions.ReductionExpression
	 * @generated
	 */
	EClass getReductionExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.reductions.ReductionExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.polymodel.algebra.reductions.ReductionExpression#getExpressions()
	 * @see #getReductionExpression()
	 * @generated
	 */
	EReference getReductionExpression_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.reductions.ReductionExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polymodel.algebra.reductions.ReductionExpression#getOperator()
	 * @see #getReductionExpression()
	 * @generated
	 */
	EAttribute getReductionExpression_Operator();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.reductions.ReductionExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.reductions.ReductionExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getReductionExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.algebra.reductions.ReductionOperator <em>Reduction Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reduction Operator</em>'.
	 * @see org.polymodel.algebra.reductions.ReductionOperator
	 * @generated
	 */
	EEnum getReductionOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReductionsFactory getReductionsFactory();

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
		 * The meta object literal for the '{@link org.polymodel.algebra.reductions.impl.ReductionExpressionImpl <em>Reduction Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.reductions.impl.ReductionExpressionImpl
		 * @see org.polymodel.algebra.reductions.impl.ReductionsPackageImpl#getReductionExpression()
		 * @generated
		 */
		EClass REDUCTION_EXPRESSION = eINSTANCE.getReductionExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCTION_EXPRESSION__EXPRESSIONS = eINSTANCE.getReductionExpression_Expressions();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUCTION_EXPRESSION__OPERATOR = eINSTANCE.getReductionExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REDUCTION_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getReductionExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.reductions.ReductionOperator <em>Reduction Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.reductions.ReductionOperator
		 * @see org.polymodel.algebra.reductions.impl.ReductionsPackageImpl#getReductionOperator()
		 * @generated
		 */
		EEnum REDUCTION_OPERATOR = eINSTANCE.getReductionOperator();

	}

} //ReductionsPackage
