/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableFunctionParameter()
 * @model
 * @generated
 */
public interface VariableFunctionParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(CodeGenVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableFunctionParameter_Variable()
	 * @model
	 * @generated
	 */
	CodeGenVariable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(CodeGenVariable value);

} // VariableFunctionParameter
