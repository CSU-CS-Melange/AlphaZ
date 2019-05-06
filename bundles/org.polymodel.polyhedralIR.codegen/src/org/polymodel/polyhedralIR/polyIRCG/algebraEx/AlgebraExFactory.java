/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage
 * @generated
 */
public interface AlgebraExFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgebraExFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modulo Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modulo Expression</em>'.
	 * @generated
	 */
	ModuloExpression createModuloExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AlgebraExPackage getAlgebraExPackage();

} //AlgebraExFactory
