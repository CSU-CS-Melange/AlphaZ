/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.AlgebraPackage
 * @generated
 */
public interface AlgebraFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgebraFactory eINSTANCE = org.polymodel.algebra.impl.AlgebraFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Int Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Term</em>'.
	 * @generated
	 */
	IntTerm createIntTerm();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Int Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Constraint</em>'.
	 * @generated
	 */
	IntConstraint createIntConstraint();

	/**
	 * Returns a new object of class '<em>Int Constraint System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Constraint System</em>'.
	 * @generated
	 */
	IntConstraintSystem createIntConstraintSystem();

	/**
	 * Returns a new object of class '<em>Composite Int Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Int Expression</em>'.
	 * @generated
	 */
	CompositeIntExpression createCompositeIntExpression();

	/**
	 * Returns a new object of class '<em>Select Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Expression</em>'.
	 * @generated
	 */
	SelectExpression createSelectExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AlgebraPackage getAlgebraPackage();

} //AlgebraFactory
