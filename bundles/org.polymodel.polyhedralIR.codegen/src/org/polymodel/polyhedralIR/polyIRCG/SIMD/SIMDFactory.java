/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage
 * @generated
 */
public interface SIMDFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SIMDFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>VType</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VType</em>'.
	 * @generated
	 */
	VType createVType();

	/**
	 * Returns a new object of class '<em>VRegister</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VRegister</em>'.
	 * @generated
	 */
	VRegister createVRegister();

	/**
	 * Returns a new object of class '<em>VRegister Initialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VRegister Initialization</em>'.
	 * @generated
	 */
	VRegisterInitialization createVRegisterInitialization();

	/**
	 * Returns a new object of class '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement</em>'.
	 * @generated
	 */
	SIMDStatement createSIMDStatement();

	/**
	 * Returns a new object of class '<em>VReg Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VReg Function Parameter</em>'.
	 * @generated
	 */
	VRegFunctionParameter createVRegFunctionParameter();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	SIMDFunction createSIMDFunction();

	/**
	 * Returns a new object of class '<em>Tiled SIMDC Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tiled SIMDC Loop</em>'.
	 * @generated
	 */
	TiledSIMDCLoop createTiledSIMDCLoop();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SIMDPackage getSIMDPackage();

} //SIMDFactory
