/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.structured.Channel;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.InputPort;
import org.polymodel.prdg.scheduling.structured.OutputPort;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl#getSubscriptDimension <em>Subscript Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelImpl extends EObjectImpl implements Channel {
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGEdge> edges;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OutputPort source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected InputPort destination;

	/**
	 * The cached value of the '{@link #getSchedule() <em>Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected ChannelSchedulePrototype schedule;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubscriptDimension() <em>Subscript Dimension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscriptDimension()
	 * @generated
	 * @ordered
	 */
	protected Variable subscriptDimension;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectResolvingEList<PRDGEdge>(PRDGEdge.class, this, StructuredPackage.CHANNEL__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OutputPort newSource, NotificationChain msgs) {
		OutputPort oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OutputPort newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, StructuredPackage.OUTPUT_PORT__CHANNEL, OutputPort.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, StructuredPackage.OUTPUT_PORT__CHANNEL, OutputPort.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(InputPort newDestination, NotificationChain msgs) {
		InputPort oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(InputPort newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, StructuredPackage.INPUT_PORT__CHANNEL, InputPort.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, StructuredPackage.INPUT_PORT__CHANNEL, InputPort.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSchedulePrototype getSchedule() {
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(ChannelSchedulePrototype newSchedule, NotificationChain msgs) {
		ChannelSchedulePrototype oldSchedule = schedule;
		schedule = newSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SCHEDULE, oldSchedule, newSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(ChannelSchedulePrototype newSchedule) {
		if (newSchedule != schedule) {
			NotificationChain msgs = null;
			if (schedule != null)
				msgs = ((InternalEObject)schedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__SCHEDULE, null, msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__SCHEDULE, null, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SCHEDULE, newSchedule, newSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(Domain newDomain, NotificationChain msgs) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__DOMAIN, oldDomain, newDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		if (newDomain != domain) {
			NotificationChain msgs = null;
			if (domain != null)
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getSubscriptDimension() {
		return subscriptDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscriptDimension(Variable newSubscriptDimension, NotificationChain msgs) {
		Variable oldSubscriptDimension = subscriptDimension;
		subscriptDimension = newSubscriptDimension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION, oldSubscriptDimension, newSubscriptDimension);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscriptDimension(Variable newSubscriptDimension) {
		if (newSubscriptDimension != subscriptDimension) {
			NotificationChain msgs = null;
			if (subscriptDimension != null)
				msgs = ((InternalEObject)subscriptDimension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION, null, msgs);
			if (newSubscriptDimension != null)
				msgs = ((InternalEObject)newSubscriptDimension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION, null, msgs);
			msgs = basicSetSubscriptDimension(newSubscriptDimension, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION, newSubscriptDimension, newSubscriptDimension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__SOURCE, null, msgs);
				return basicSetSource((OutputPort)otherEnd, msgs);
			case StructuredPackage.CHANNEL__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL__DESTINATION, null, msgs);
				return basicSetDestination((InputPort)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__SOURCE:
				return basicSetSource(null, msgs);
			case StructuredPackage.CHANNEL__DESTINATION:
				return basicSetDestination(null, msgs);
			case StructuredPackage.CHANNEL__SCHEDULE:
				return basicSetSchedule(null, msgs);
			case StructuredPackage.CHANNEL__DOMAIN:
				return basicSetDomain(null, msgs);
			case StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION:
				return basicSetSubscriptDimension(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__EDGES:
				return getEdges();
			case StructuredPackage.CHANNEL__SOURCE:
				return getSource();
			case StructuredPackage.CHANNEL__DESTINATION:
				return getDestination();
			case StructuredPackage.CHANNEL__SCHEDULE:
				return getSchedule();
			case StructuredPackage.CHANNEL__DOMAIN:
				return getDomain();
			case StructuredPackage.CHANNEL__NAME:
				return getName();
			case StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION:
				return getSubscriptDimension();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends PRDGEdge>)newValue);
				return;
			case StructuredPackage.CHANNEL__SOURCE:
				setSource((OutputPort)newValue);
				return;
			case StructuredPackage.CHANNEL__DESTINATION:
				setDestination((InputPort)newValue);
				return;
			case StructuredPackage.CHANNEL__SCHEDULE:
				setSchedule((ChannelSchedulePrototype)newValue);
				return;
			case StructuredPackage.CHANNEL__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case StructuredPackage.CHANNEL__NAME:
				setName((String)newValue);
				return;
			case StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION:
				setSubscriptDimension((Variable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__EDGES:
				getEdges().clear();
				return;
			case StructuredPackage.CHANNEL__SOURCE:
				setSource((OutputPort)null);
				return;
			case StructuredPackage.CHANNEL__DESTINATION:
				setDestination((InputPort)null);
				return;
			case StructuredPackage.CHANNEL__SCHEDULE:
				setSchedule((ChannelSchedulePrototype)null);
				return;
			case StructuredPackage.CHANNEL__DOMAIN:
				setDomain((Domain)null);
				return;
			case StructuredPackage.CHANNEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION:
				setSubscriptDimension((Variable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructuredPackage.CHANNEL__EDGES:
				return edges != null && !edges.isEmpty();
			case StructuredPackage.CHANNEL__SOURCE:
				return source != null;
			case StructuredPackage.CHANNEL__DESTINATION:
				return destination != null;
			case StructuredPackage.CHANNEL__SCHEDULE:
				return schedule != null;
			case StructuredPackage.CHANNEL__DOMAIN:
				return domain != null;
			case StructuredPackage.CHANNEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StructuredPackage.CHANNEL__SUBSCRIPT_DIMENSION:
				return subscriptDimension != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ChannelImpl
