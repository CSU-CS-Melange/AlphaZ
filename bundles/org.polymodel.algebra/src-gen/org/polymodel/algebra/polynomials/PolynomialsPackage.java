/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials;

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
 * @see org.polymodel.algebra.polynomials.PolynomialsFactory
 * @model kind="package"
 * @generated
 */
public interface PolynomialsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "polynomials";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/algebra/polynomials";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polynomials";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolynomialsPackage eINSTANCE = org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialExpressionImpl <em>Polynomial Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialExpressionImpl
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialExpression()
	 * @generated
	 */
	int POLYNOMIAL_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION__TERMS = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Polynomial Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION_FEATURE_COUNT = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___SIMPLIFY = AlgebraPackage.INT_EXPRESSION___SIMPLIFY;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE;

	/**
	 * The operation id for the '<em>Substitute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION = AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION;

	/**
	 * The operation id for the '<em>To Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___TO_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_AFFINE;

	/**
	 * The operation id for the '<em>To Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___TO_QUASI_AFFINE = AlgebraPackage.INT_EXPRESSION___TO_QUASI_AFFINE;

	/**
	 * The operation id for the '<em>To Polynomial</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___TO_POLYNOMIAL = AlgebraPackage.INT_EXPRESSION___TO_POLYNOMIAL;

	/**
	 * The operation id for the '<em>To Reduction</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___TO_REDUCTION = AlgebraPackage.INT_EXPRESSION___TO_REDUCTION;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___COPY = AlgebraPackage.INT_EXPRESSION___COPY;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___IS_AFFINE = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION___IS_QUASI_AFFINE = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Polynomial Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_EXPRESSION_OPERATION_COUNT = AlgebraPackage.INT_EXPRESSION_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl <em>Polynomial Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialVariable()
	 * @generated
	 */
	int POLYNOMIAL_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE__VARIABLE = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE__EXPONENT = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Polynomial Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE_FEATURE_COUNT = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE___IS_EQUIVALENT__POLYNOMIALVARIABLE = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Polynomial Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VARIABLE_OPERATION_COUNT = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialTermImpl <em>Polynomial Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialTermImpl
	 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialTerm()
	 * @generated
	 */
	int POLYNOMIAL_TERM = 2;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM__NUMERATOR = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM__DENOMINATOR = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM__VARIABLES = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Polynomial Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM_FEATURE_COUNT = AlgebraPackage.ALGEBRA_VISITABLE_FEATURE_COUNT + 3;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM___IS_AFFINE = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Quasi Affine</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM___IS_QUASI_AFFINE = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Polynomial Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_TERM_OPERATION_COUNT = AlgebraPackage.ALGEBRA_VISITABLE_OPERATION_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.polynomials.PolynomialExpression <em>Polynomial Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polynomial Expression</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialExpression
	 * @generated
	 */
	EClass getPolynomialExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.polynomials.PolynomialExpression#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialExpression#getTerms()
	 * @see #getPolynomialExpression()
	 * @generated
	 */
	EReference getPolynomialExpression_Terms();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialExpression#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialExpression#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getPolynomialExpression__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialExpression#isAffine() <em>Is Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Affine</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialExpression#isAffine()
	 * @generated
	 */
	EOperation getPolynomialExpression__IsAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialExpression#isQuasiAffine() <em>Is Quasi Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Quasi Affine</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialExpression#isQuasiAffine()
	 * @generated
	 */
	EOperation getPolynomialExpression__IsQuasiAffine();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.polynomials.PolynomialVariable <em>Polynomial Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polynomial Variable</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialVariable
	 * @generated
	 */
	EClass getPolynomialVariable();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.algebra.polynomials.PolynomialVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialVariable#getVariable()
	 * @see #getPolynomialVariable()
	 * @generated
	 */
	EReference getPolynomialVariable_Variable();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.polynomials.PolynomialVariable#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialVariable#getExponent()
	 * @see #getPolynomialVariable()
	 * @generated
	 */
	EAttribute getPolynomialVariable_Exponent();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialVariable#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialVariable#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getPolynomialVariable__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialVariable#isEquivalent(org.polymodel.algebra.polynomials.PolynomialVariable) <em>Is Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equivalent</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialVariable#isEquivalent(org.polymodel.algebra.polynomials.PolynomialVariable)
	 * @generated
	 */
	EOperation getPolynomialVariable__IsEquivalent__PolynomialVariable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.algebra.polynomials.PolynomialTerm <em>Polynomial Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polynomial Term</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm
	 * @generated
	 */
	EClass getPolynomialTerm();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.polynomials.PolynomialTerm#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numerator</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#getNumerator()
	 * @see #getPolynomialTerm()
	 * @generated
	 */
	EAttribute getPolynomialTerm_Numerator();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.algebra.polynomials.PolynomialTerm#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Denominator</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#getDenominator()
	 * @see #getPolynomialTerm()
	 * @generated
	 */
	EAttribute getPolynomialTerm_Denominator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.algebra.polynomials.PolynomialTerm#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#getVariables()
	 * @see #getPolynomialTerm()
	 * @generated
	 */
	EReference getPolynomialTerm_Variables();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialTerm#accept(org.polymodel.algebra.AlgebraVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#accept(org.polymodel.algebra.AlgebraVisitor)
	 * @generated
	 */
	EOperation getPolynomialTerm__Accept__AlgebraVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialTerm#isAffine() <em>Is Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Affine</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#isAffine()
	 * @generated
	 */
	EOperation getPolynomialTerm__IsAffine();

	/**
	 * Returns the meta object for the '{@link org.polymodel.algebra.polynomials.PolynomialTerm#isQuasiAffine() <em>Is Quasi Affine</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Quasi Affine</em>' operation.
	 * @see org.polymodel.algebra.polynomials.PolynomialTerm#isQuasiAffine()
	 * @generated
	 */
	EOperation getPolynomialTerm__IsQuasiAffine();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PolynomialsFactory getPolynomialsFactory();

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
		 * The meta object literal for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialExpressionImpl <em>Polynomial Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialExpressionImpl
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialExpression()
		 * @generated
		 */
		EClass POLYNOMIAL_EXPRESSION = eINSTANCE.getPolynomialExpression();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYNOMIAL_EXPRESSION__TERMS = eINSTANCE.getPolynomialExpression_Terms();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_EXPRESSION___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getPolynomialExpression__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Is Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_EXPRESSION___IS_AFFINE = eINSTANCE.getPolynomialExpression__IsAffine();

		/**
		 * The meta object literal for the '<em><b>Is Quasi Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_EXPRESSION___IS_QUASI_AFFINE = eINSTANCE.getPolynomialExpression__IsQuasiAffine();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl <em>Polynomial Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialVariable()
		 * @generated
		 */
		EClass POLYNOMIAL_VARIABLE = eINSTANCE.getPolynomialVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYNOMIAL_VARIABLE__VARIABLE = eINSTANCE.getPolynomialVariable_Variable();

		/**
		 * The meta object literal for the '<em><b>Exponent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYNOMIAL_VARIABLE__EXPONENT = eINSTANCE.getPolynomialVariable_Exponent();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_VARIABLE___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getPolynomialVariable__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Is Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_VARIABLE___IS_EQUIVALENT__POLYNOMIALVARIABLE = eINSTANCE.getPolynomialVariable__IsEquivalent__PolynomialVariable();

		/**
		 * The meta object literal for the '{@link org.polymodel.algebra.polynomials.impl.PolynomialTermImpl <em>Polynomial Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialTermImpl
		 * @see org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl#getPolynomialTerm()
		 * @generated
		 */
		EClass POLYNOMIAL_TERM = eINSTANCE.getPolynomialTerm();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYNOMIAL_TERM__NUMERATOR = eINSTANCE.getPolynomialTerm_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYNOMIAL_TERM__DENOMINATOR = eINSTANCE.getPolynomialTerm_Denominator();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYNOMIAL_TERM__VARIABLES = eINSTANCE.getPolynomialTerm_Variables();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_TERM___ACCEPT__ALGEBRAVISITOR = eINSTANCE.getPolynomialTerm__Accept__AlgebraVisitor();

		/**
		 * The meta object literal for the '<em><b>Is Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_TERM___IS_AFFINE = eINSTANCE.getPolynomialTerm__IsAffine();

		/**
		 * The meta object literal for the '<em><b>Is Quasi Affine</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYNOMIAL_TERM___IS_QUASI_AFFINE = eINSTANCE.getPolynomialTerm__IsQuasiAffine();

	}

} //PolynomialsPackage
