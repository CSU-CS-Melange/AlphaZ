/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExternalFunctionDeclaration()
 * @model
 * @generated
 */
public interface ExternalFunctionDeclaration extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExternalFunctionDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExternalFunctionDeclaration_Inputs()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EList<Type> getInputs();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' reference.
	 * @see #setOutput(Type)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExternalFunctionDeclaration_Output()
	 * @model
	 * @generated
	 */
	Type getOutput();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getOutput <em>Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Type value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitExternalFunctionDeclaration(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // ExternalFunctionDeclaration
