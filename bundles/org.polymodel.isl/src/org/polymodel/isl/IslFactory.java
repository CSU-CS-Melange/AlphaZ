/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.isl.IslPackage
 * @generated
 */
public interface IslFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IslFactory eINSTANCE = org.polymodel.isl.impl.IslFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ISL Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Map</em>'.
	 * @generated
	 */
	ISLMap createISLMap();

	/**
	 * Returns a new object of class '<em>ISL Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Set</em>'.
	 * @generated
	 */
	ISLSet createISLSet();

	/**
	 * Returns a new object of class '<em>ISL Union Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Union Map</em>'.
	 * @generated
	 */
	ISLUnionMap createISLUnionMap();

	/**
	 * Returns a new object of class '<em>ISL Union Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Union Set</em>'.
	 * @generated
	 */
	ISLUnionSet createISLUnionSet();

	/**
	 * Returns a new object of class '<em>ISL Basic Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Basic Map</em>'.
	 * @generated
	 */
	ISLBasicMap createISLBasicMap();

	/**
	 * Returns a new object of class '<em>ISL Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Point</em>'.
	 * @generated
	 */
	ISLPoint createISLPoint();

	/**
	 * Returns a new object of class '<em>ISL Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISL Function</em>'.
	 * @generated
	 */
	ISLFunction createISLFunction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IslPackage getIslPackage();

} //IslFactory
