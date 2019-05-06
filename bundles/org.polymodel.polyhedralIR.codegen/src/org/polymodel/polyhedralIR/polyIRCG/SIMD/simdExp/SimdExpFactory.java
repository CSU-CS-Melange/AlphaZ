/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage
 * @generated
 */
public interface SimdExpFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimdExpFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Basic Memory Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Memory Address</em>'.
	 * @generated
	 */
	BasicMemoryAddress createBasicMemoryAddress();

	/**
	 * Returns a new object of class '<em>VLoad Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VLoad Expression</em>'.
	 * @generated
	 */
	VLoadExpression createVLoadExpression();

	/**
	 * Returns a new object of class '<em>VStore Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VStore Expression</em>'.
	 * @generated
	 */
	VStoreExpression createVStoreExpression();

	/**
	 * Returns a new object of class '<em>VBinary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VBinary Expression</em>'.
	 * @generated
	 */
	VBinaryExpression createVBinaryExpression();

	/**
	 * Returns a new object of class '<em>VShift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VShift Expression</em>'.
	 * @generated
	 */
	VShiftExpression createVShiftExpression();

	/**
	 * Returns a new object of class '<em>VRegister Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VRegister Expression</em>'.
	 * @generated
	 */
	VRegisterExpression createVRegisterExpression();

	/**
	 * Returns a new object of class '<em>VAssign Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VAssign Expression</em>'.
	 * @generated
	 */
	VAssignExpression createVAssignExpression();

	/**
	 * Returns a new object of class '<em>VSet Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VSet Expression</em>'.
	 * @generated
	 */
	VSetExpression createVSetExpression();

	/**
	 * Returns a new object of class '<em>VPermute Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VPermute Expression</em>'.
	 * @generated
	 */
	VPermuteExpression createVPermuteExpression();

	/**
	 * Returns a new object of class '<em>VShuffle Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VShuffle Expression</em>'.
	 * @generated
	 */
	VShuffleExpression createVShuffleExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimdExpPackage getSimdExpPackage();

} //SimdExpFactory
