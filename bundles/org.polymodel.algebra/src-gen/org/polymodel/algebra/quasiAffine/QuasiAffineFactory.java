/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage
 * @generated
 */
public interface QuasiAffineFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QuasiAffineFactory eINSTANCE = org.polymodel.algebra.quasiAffine.impl.QuasiAffineFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	QuasiAffineExpression createQuasiAffineExpression();

	/**
	 * Returns a new object of class '<em>Simple Quasi Affine Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Quasi Affine Term</em>'.
	 * @generated
	 */
	SimpleQuasiAffineTerm createSimpleQuasiAffineTerm();

	/**
	 * Returns a new object of class '<em>Nested Quasi Affine Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nested Quasi Affine Term</em>'.
	 * @generated
	 */
	NestedQuasiAffineTerm createNestedQuasiAffineTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QuasiAffinePackage getQuasiAffinePackage();

} //QuasiAffineFactory
