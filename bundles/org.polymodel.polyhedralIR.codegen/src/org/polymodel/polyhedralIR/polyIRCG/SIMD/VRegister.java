/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VRegister</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getVtype <em>Vtype</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegister()
 * @model
 * @generated
 */
public interface VRegister extends AbstractVariable {
	/**
	 * Returns the value of the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vtype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vtype</em>' reference.
	 * @see #setVtype(VType)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegister_Vtype()
	 * @model required="true"
	 * @generated
	 */
	VType getVtype();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getVtype <em>Vtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vtype</em>' reference.
	 * @see #getVtype()
	 * @generated
	 */
	void setVtype(VType value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVRegister_Function()
	 * @model required="true"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getRegTypeString();

} // VRegister
