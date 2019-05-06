/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.polymodel.prdg.scheduling.SchedulePrototype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel Schedule Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannelSchedulePrototype()
 * @model
 * @generated
 */
public interface ChannelSchedulePrototype extends SchedulePrototype {
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
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannelSchedulePrototype_Channel()
	 * @model
	 * @generated
	 */
	Channel getChannel();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype#getChannel <em>Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' reference.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(Channel value);
	
	void setName(String name);

} // ChannelSchedulePrototype
