/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage
 * @generated
 */
public interface MultidimFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MultidimFactory eINSTANCE = org.polymodel.prdg.scheduling.multidim.impl.MultidimFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Nullifiable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nullifiable Dependency</em>'.
	 * @generated
	 */
	NullifiableDependency createNullifiableDependency();

	/**
	 * Returns a new object of class '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency</em>'.
	 * @generated
	 */
	MultidimDependency createMultidimDependency();

	/**
	 * Returns a new object of class '<em>Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Prototype</em>'.
	 * @generated
	 */
	MultidimSchedulePrototype createMultidimSchedulePrototype();

	/**
	 * Returns a new object of class '<em>Statement Scalar Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Scalar Schedule Prototype</em>'.
	 * @generated
	 */
	StatementScalarSchedulePrototype createStatementScalarSchedulePrototype();

	/**
	 * Returns a new object of class '<em>Channel Scalar Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Scalar Schedule Prototype</em>'.
	 * @generated
	 */
	ChannelScalarSchedulePrototype createChannelScalarSchedulePrototype();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MultidimPackage getMultidimPackage();

} //MultidimFactory
