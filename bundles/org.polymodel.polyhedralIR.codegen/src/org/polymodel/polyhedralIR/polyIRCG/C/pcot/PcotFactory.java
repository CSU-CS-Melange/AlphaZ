/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage
 * @generated
 */
public interface PcotFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PcotFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PCO Trecursion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCO Trecursion</em>'.
	 * @generated
	 */
	PCOTrecursion createPCOTrecursion();

	/**
	 * Returns a new object of class '<em>PCO Tbase</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCO Tbase</em>'.
	 * @generated
	 */
	PCOTbase createPCOTbase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PcotPackage getPcotPackage();

} //PcotFactory
