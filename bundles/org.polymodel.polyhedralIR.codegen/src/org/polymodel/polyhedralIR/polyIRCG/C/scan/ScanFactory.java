/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage
 * @generated
 */
public interface ScanFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScanFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bound Computation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Computation</em>'.
	 * @generated
	 */
	BoundComputation createBoundComputation();

	/**
	 * Returns a new object of class '<em>Volume Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Volume Function</em>'.
	 * @generated
	 */
	VolumeFunction createVolumeFunction();

	/**
	 * Returns a new object of class '<em>Volume Function Derivative</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Volume Function Derivative</em>'.
	 * @generated
	 */
	VolumeFunctionDerivative createVolumeFunctionDerivative();

	/**
	 * Returns a new object of class '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Body</em>'.
	 * @generated
	 */
	ScanBody createScanBody();

	/**
	 * Returns a new object of class '<em>Origin Domain Volume</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Origin Domain Volume</em>'.
	 * @generated
	 */
	OriginDomainVolume createOriginDomainVolume();

	/**
	 * Returns a new object of class '<em>Reduction Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reduction Body</em>'.
	 * @generated
	 */
	ScanReductionBody createScanReductionBody();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScanPackage getScanPackage();

} //ScanFactory
