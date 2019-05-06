/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;
import org.polymodel.prdg.PRDGNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Process#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Process#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Process#getInternalNodes <em>Internal Nodes</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Process#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Process#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends EObject {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.structured.InputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess_Inputs()
	 * @model
	 * @generated
	 */
	EList<InputPort> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.structured.OutputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess_Outputs()
	 * @model
	 * @generated
	 */
	EList<OutputPort> getOutputs();

	/**
	 * Returns the value of the '<em><b>Internal Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Nodes</em>' reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess_InternalNodes()
	 * @model
	 * @generated
	 */
	EList<PRDGNode> getInternalNodes();

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
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Process#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(Domain)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcess_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	Domain getConstraints();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Process#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(Domain value);

} // Process
