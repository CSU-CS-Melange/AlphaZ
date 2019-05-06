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
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDGEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel</b></em>'.
 * 
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getSource <em>Source</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.Channel#getSubscriptDimension <em>Subscript Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel()
 * @model
 * @generated
 */
public interface Channel extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Edges()
	 * @model
	 * @generated
	 */
	EList<PRDGEdge> getEdges();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.structured.OutputPort#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OutputPort)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Source()
	 * @see org.polymodel.prdg.scheduling.structured.OutputPort#getChannel
	 * @model opposite="channel" containment="true" required="true"
	 * @generated
	 */
	OutputPort getSource();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.structured.InputPort#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(InputPort)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Destination()
	 * @see org.polymodel.prdg.scheduling.structured.InputPort#getChannel
	 * @model opposite="channel" containment="true" required="true"
	 * @generated
	 */
	InputPort getDestination();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(InputPort value);

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' containment reference.
	 * @see #setSchedule(ChannelSchedulePrototype)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Schedule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ChannelSchedulePrototype getSchedule();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getSchedule <em>Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' containment reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(ChannelSchedulePrototype value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Domain()
	 * @model containment="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

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
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Subscript Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscript Dimension</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscript Dimension</em>' containment reference.
	 * @see #setSubscriptDimension(Variable)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getChannel_SubscriptDimension()
	 * @model containment="true"
	 * @generated
	 */
	Variable getSubscriptDimension();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.Channel#getSubscriptDimension <em>Subscript Dimension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscript Dimension</em>' containment reference.
	 * @see #getSubscriptDimension()
	 * @generated
	 */
	void setSubscriptDimension(Variable value);

} // Channel
