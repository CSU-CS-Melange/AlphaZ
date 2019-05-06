/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.prdg.PRDG;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getProcesses <em>Processes</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getPrdg <em>Prdg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcessNetwork()
 * @model
 * @generated
 */
public interface ProcessNetwork extends EObject {
	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.structured.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcessNetwork_Processes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<org.polymodel.prdg.scheduling.structured.Process> getProcesses();

	/**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.structured.Channel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcessNetwork_Channels()
	 * @model containment="true"
	 * @generated
	 */
	EList<Channel> getChannels();

	/**
	 * Returns the value of the '<em><b>Prdg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prdg</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prdg</em>' reference.
	 * @see #setPrdg(PRDG)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getProcessNetwork_Prdg()
	 * @model
	 * @generated
	 */
	PRDG getPrdg();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getPrdg <em>Prdg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prdg</em>' reference.
	 * @see #getPrdg()
	 * @generated
	 */
	void setPrdg(PRDG value);

} // ProcessNetwork
