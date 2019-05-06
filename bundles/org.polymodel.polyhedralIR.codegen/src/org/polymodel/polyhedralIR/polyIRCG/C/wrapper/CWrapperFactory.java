/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage
 * @generated
 */
public interface CWrapperFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CWrapperFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Input Initialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Initialization</em>'.
	 * @generated
	 */
	InputInitialization createInputInitialization();

	/**
	 * Returns a new object of class '<em>Output Printing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Printing</em>'.
	 * @generated
	 */
	OutputPrinting createOutputPrinting();

	/**
	 * Returns a new object of class '<em>Output Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Verification</em>'.
	 * @generated
	 */
	OutputVerification createOutputVerification();

	/**
	 * Returns a new object of class '<em>Special Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Special Variable</em>'.
	 * @generated
	 */
	SpecialVariable createSpecialVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CWrapperPackage getCWrapperPackage();

} //CWrapperFactory
