/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.SchedulingPackage
 * @generated
 */
public interface SchedulingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingFactory eINSTANCE = org.polymodel.prdg.scheduling.impl.SchedulingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scheduled Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduled Statement</em>'.
	 * @generated
	 */
	ScheduledStatement createScheduledStatement();

	/**
	 * Returns a new object of class '<em>Schedule Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Term</em>'.
	 * @generated
	 */
	ScheduleTerm createScheduleTerm();

	/**
	 * Returns a new object of class '<em>Statement Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Schedule Prototype</em>'.
	 * @generated
	 */
	StatementSchedulePrototype createStatementSchedulePrototype();

	/**
	 * Returns a new object of class '<em>Edge Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Dependency</em>'.
	 * @generated
	 */
	EdgeDependency createEdgeDependency();

	/**
	 * Returns a new object of class '<em>Schedule Coefficient</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Coefficient</em>'.
	 * @generated
	 */
	ScheduleCoefficient createScheduleCoefficient();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulingPackage getSchedulingPackage();

} //SchedulingFactory
