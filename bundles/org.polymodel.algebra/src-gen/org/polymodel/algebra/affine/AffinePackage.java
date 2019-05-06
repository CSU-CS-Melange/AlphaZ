/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine;

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
 * @see org.polymodel.algebra.affine.AffineFactory
 * @model kind="package"
 * @generated
 */
public interface AffinePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "affine";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/algebra/affine";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "affine";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AffinePackage eINSTANCE = org.polymodel.algebra.affine.impl.AffinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.affine.impl.AffineExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.affine.impl.AffineExpressionImpl
	 * @see org.polymodel.algebra.affine.impl.AffinePackageImpl#getAffineExpression()
	 * @generated
	 */
	int AFFINE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION__TERMS = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION_FEATURE_COUNT = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___SIMPLIFY = AlgebraPackage.INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___TO_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___TO_QUASI_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___TO_POLYNOMIAL = AlgebraPackage.INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___TO_REDUCTION = AlgebraPackage.INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___COPY = AlgebraPackage.INT_EXPRESSION___COPY;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_EXPRESSION_OPERATION_COUNT = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.affine.impl.AffineTermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.affine.impl.AffineTermImpl
	 * @see org.polymodel.algebra.affine.impl.AffinePackageImpl#getAffineTerm()
	 * @generated
	 */
	int AFFINE_TERM = 1;

	/**
	 * The feature id for the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM__COEF = AlgebraPackage.INT_TERM__COEF;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM__VARIABLE = AlgebraPackage.INT_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM_FEATURE_COUNT = AlgebraPackage.INT_TERM_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM___IS_EQUIVALENT__INTTERM = AlgebraPackage.INT_TERM___IS_EQUIVALENT__INTTERM;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_TERM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_TERM_OPERATION_COUNT = AlgebraPackage.INT_TERM_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.affine.AffineExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.polymodel.algebra.affine.AffineExpression
	 * @generated
	 */
	EClass getAffineExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.affine.AffineExpression#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see org.polymodel.algebra.affine.AffineExpression#getTerms()
	 * @see #getAffineExpression()
	 * @generated
	 */
	EReference getAffineExpression_Terms();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.affine.AffineExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.affine.AffineExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getAffineExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.affine.AffineTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see org.polymodel.algebra.affine.AffineTerm
	 * @generated
	 */
	EClass getAffineTerm();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.algebra.affine.AffineTerm#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.algebra.affine.AffineTerm#getVariable()
	 * @see #getAffineTerm()
	 * @generated
	 */
	EReference getAffineTerm_Variable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.affine.AffineTerm#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.affine.AffineTerm#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getAffineTerm__Accept__AlgebraVisitor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AffineFactory getAffineFactory();

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
		 * The meta object literal for the '{@link org.polymodel.algebra.affine.impl.AffineExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.affine.impl.AffineExpressionImpl
		 * @see org.polymodel.algebra.affine.impl.AffinePackageImpl#getAffineExpression()
		 * @generated
		 */
		EClass AFFINE_EXPRESSION = eINSTANCE.getAffineExpression();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFFINE_EXPRESSION__TERMS = eINSTANCE.getAffineExpression_Terms();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getAffineExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.affine.impl.AffineTermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.affine.impl.AffineTermImpl
		 * @see org.polymodel.algebra.affine.impl.AffinePackageImpl#getAffineTerm()
		 * @generated
		 */
		EClass AFFINE_TERM = eINSTANCE.getAffineTerm();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFFINE_TERM__VARIABLE = eINSTANCE.getAffineTerm_Variable();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AFFINE_TERM___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getAffineTerm__Accept__AlgebraVisitor();

	}

} //AffinePackage
