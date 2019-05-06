/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExFactory
 * @model kind="package"
 * @generated
 */
public interface AlgebraExPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "algebraEx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.algebra.polyIRCG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "algebraEx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgebraExPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl <em>Modulo Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExPackageImpl#getModuloExpression()
	 * @generated
	 */
	int MODULO_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULO_EXPRESSION__NUMERATOR = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULO_EXPRESSION__DENOMINATOR = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Modulo Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULO_EXPRESSION_FEATURE_COUNT = AlgebraPackage.INT_EXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression <em>Modulo Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modulo Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression
	 * @generated
	 */
	EClass getModuloExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Numerator</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getNumerator()
	 * @see #getModuloExpression()
	 * @generated
	 */
	EReference getModuloExpression_Numerator();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Denominator</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression#getDenominator()
	 * @see #getModuloExpression()
	 * @generated
	 */
	EReference getModuloExpression_Denominator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AlgebraExFactory getAlgebraExFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl <em>Modulo Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExPackageImpl#getModuloExpression()
		 * @generated
		 */
		EClass MODULO_EXPRESSION = eINSTANCE.getModuloExpression();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULO_EXPRESSION__NUMERATOR = eINSTANCE.getModuloExpression_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULO_EXPRESSION__DENOMINATOR = eINSTANCE.getModuloExpression_Denominator();

	}

} //AlgebraExPackage
