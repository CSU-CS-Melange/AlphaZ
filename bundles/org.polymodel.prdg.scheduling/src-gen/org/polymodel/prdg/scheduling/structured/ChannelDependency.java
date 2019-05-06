/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.polymodel.prdg.scheduling.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.ChannelDependency#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannelDependency()
 * @model abstract="true"
 * @generated
 */
public interface ChannelDependency extends Dependency {

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' reference.
	 * @see #setChannel(Channel)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannelDependency_Channel()
	 * @model required="true"
	 * @generated
	 */
	Channel getChannel();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.ChannelDependency#getChannel <em>Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' reference.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(Channel value);
} // ChannelDependency
