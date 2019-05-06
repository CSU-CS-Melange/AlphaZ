/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VReg Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter#getRegister <em>Register</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegFunctionParameter()
 * @model
 * @generated
 */
public interface VRegFunctionParameter extends EObject {

	/**
	 * Returns the value of the '<em><b>Register</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Register</em>' reference.
	 * @see #setRegister(VRegister)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegFunctionParameter_Register()
	 * @model required="true"
	 * @generated
	 */
	VRegister getRegister();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter#getRegister <em>Register</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register</em>' reference.
	 * @see #getRegister()
	 * @generated
	 */
	void setRegister(VRegister value);
} // VRegFunctionParameter
