/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.polymodel.prdg.PRDGNode;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Output Port</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.OutputPort#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends DataPort {
	/**
	 * Returns the value of the '<em><b>Channel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.structured.Channel#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' container reference.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getOutputPort_Channel()
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getSource
	 * @model opposite="source" transient="false" changeable="false"
	 * @generated
	 */
	Channel getChannel();

	/**
	 * <!-- begin-user-doc --> Get the {@link PRDGNode} that produce the data.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	PRDGNode getSourceNode();

} // OutputPort
