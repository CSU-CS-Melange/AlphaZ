/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.InputPort#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getInputPort()
 * @model
 * @generated
 */
public interface InputPort extends DataPort {
	/**
	 * Returns the value of the '<em><b>Channel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.structured.Channel#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' container reference.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getInputPort_Channel()
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getDestination
	 * @model opposite="destination" transient="false" changeable="false"
	 * @generated
	 */
	Channel getChannel();

} // InputPort
