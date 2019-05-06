/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage
 * @generated
 */
public interface PCOTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCOTFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Recursion Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recursion Body</em>'.
	 * @generated
	 */
	RecursionBody createRecursionBody();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PCOTPackage getPCOTPackage();

} //PCOTFactory
