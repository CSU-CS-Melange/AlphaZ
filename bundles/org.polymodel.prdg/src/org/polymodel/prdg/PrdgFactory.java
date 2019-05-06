/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.PrdgPackage
 * @generated
 */
public interface PrdgFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrdgFactory eINSTANCE = org.polymodel.prdg.impl.PrdgFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PRDG Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PRDG Node</em>'.
	 * @generated
	 */
	PRDGNode createPRDGNode();

	/**
	 * Returns a new object of class '<em>PRDG Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PRDG Edge</em>'.
	 * @generated
	 */
	PRDGEdge createPRDGEdge();

	/**
	 * Returns a new object of class '<em>PRDG</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PRDG</em>'.
	 * @generated
	 */
	PRDG createPRDG();

	/**
	 * Returns a new object of class '<em>Projection Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Projection Function</em>'.
	 * @generated
	 */
	ProjectionFunction createProjectionFunction();

	/**
	 * Returns a new object of class '<em>Dependence Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependence Function</em>'.
	 * @generated
	 */
	DependenceFunction createDependenceFunction();

	/**
	 * Returns a new object of class '<em>PRDG Sub System Hyper Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PRDG Sub System Hyper Edge</em>'.
	 * @generated
	 */
	PRDGSubSystemHyperEdge createPRDGSubSystemHyperEdge();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PrdgPackage getPrdgPackage();

} //PrdgFactory
