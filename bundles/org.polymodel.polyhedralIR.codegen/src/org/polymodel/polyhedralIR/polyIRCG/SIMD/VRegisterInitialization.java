/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.Body;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VRegister Initialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegisterInitialization()
 * @model
 * @generated
 */
public interface VRegisterInitialization extends Body {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegisterInitialization_Inputs()
	 * @model
	 * @generated
	 */
	EList<VRegister> getInputs();

	/**
	 * Returns the value of the '<em><b>Locals</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locals</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegisterInitialization_Locals()
	 * @model
	 * @generated
	 */
	EList<VRegister> getLocals();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegisterInitialization_Outputs()
	 * @model
	 * @generated
	 */
	EList<VRegister> getOutputs();

} // VRegisterInitialization
