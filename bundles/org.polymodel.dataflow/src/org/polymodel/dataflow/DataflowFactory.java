/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.dataflow.DataflowPackage
 * @generated
 */
public interface DataflowFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataflowFactory eINSTANCE = org.polymodel.dataflow.impl.DataflowFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ADA Solution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ADA Solution</em>'.
	 * @generated
	 */
	ADASolution createADASolution();

	/**
	 * Returns a new object of class '<em>Resolved Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolved Access</em>'.
	 * @generated
	 */
	ResolvedAccess createResolvedAccess();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataflowPackage getDataflowPackage();

} //DataflowFactory
