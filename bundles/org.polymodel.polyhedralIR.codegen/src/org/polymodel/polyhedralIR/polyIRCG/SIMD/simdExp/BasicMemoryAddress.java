/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Memory Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getVar <em>Var</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getAccess <em>Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isAligned <em>Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getBasicMemoryAddress()
 * @model
 * @generated
 */
public interface BasicMemoryAddress extends EObject {
	/**
	 * Returns the value of the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' reference.
	 * @see #setVar(CodeGenVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getBasicMemoryAddress_Var()
	 * @model required="true"
	 * @generated
	 */
	CodeGenVariable getVar();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getVar <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(CodeGenVariable value);

	/**
	 * Returns the value of the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' reference.
	 * @see #setAccess(AffineFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getBasicMemoryAddress_Access()
	 * @model required="true"
	 * @generated
	 */
	AffineFunction getAccess();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getAccess <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' reference.
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aligned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aligned</em>' attribute.
	 * @see #setAligned(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getBasicMemoryAddress_Aligned()
	 * @model required="true"
	 * @generated
	 */
	boolean isAligned();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isAligned <em>Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aligned</em>' attribute.
	 * @see #isAligned()
	 * @generated
	 */
	void setAligned(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Pointer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pointer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pointer</em>' attribute.
	 * @see #setIsPointer(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage#getBasicMemoryAddress_IsPointer()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsPointer();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isIsPointer <em>Is Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pointer</em>' attribute.
	 * @see #isIsPointer()
	 * @generated
	 */
	void setIsPointer(boolean value);

} // BasicMemoryAddress
