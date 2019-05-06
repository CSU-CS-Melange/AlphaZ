/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.polynomials.PolynomialsPackage
 * @generated
 */
public interface PolynomialsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolynomialsFactory eINSTANCE = org.polymodel.algebra.polynomials.impl.PolynomialsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Polynomial Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polynomial Expression</em>'.
	 * @generated
	 */
	PolynomialExpression createPolynomialExpression();

	/**
	 * Returns a new object of class '<em>Polynomial Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polynomial Variable</em>'.
	 * @generated
	 */
	PolynomialVariable createPolynomialVariable();

	/**
	 * Returns a new object of class '<em>Polynomial Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polynomial Term</em>'.
	 * @generated
	 */
	PolynomialTerm createPolynomialTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PolynomialsPackage getPolynomialsPackage();

} //PolynomialsFactory
