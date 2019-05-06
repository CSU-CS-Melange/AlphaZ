/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.Domain;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.util.PRDGPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PRDG Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.impl.PRDGNodeImpl#getPrdg <em>Prdg</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGNodeImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGNodeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PRDGNodeImpl extends EObjectImpl implements PRDGNode {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PRDGNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrdgPackage.Literals.PRDG_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDG getPrdg() {
		if (eContainerFeatureID() != PrdgPackage.PRDG_NODE__PRDG) return null;
		return (PRDG)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrdg(PRDG newPrdg, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPrdg, PrdgPackage.PRDG_NODE__PRDG, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrdg(PRDG newPrdg) {
		if (newPrdg != eInternalContainer() || (eContainerFeatureID() != PrdgPackage.PRDG_NODE__PRDG && newPrdg != null)) {
			if (EcoreUtil.isAncestor(this, newPrdg))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPrdg != null)
				msgs = ((InternalEObject)newPrdg).eInverseAdd(this, PrdgPackage.PRDG__NODES, PRDG.class, msgs);
			msgs = basicSetPrdg(newPrdg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_NODE__PRDG, newPrdg, newPrdg));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_NODE__DOMAIN, oldDomain, newDomain);
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
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrdgPackage.PRDG_NODE__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrdgPackage.PRDG_NODE__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_NODE__DOMAIN, newDomain, newDomain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<PRDGEdge> getDestinations() {
		EList<PRDGEdge> dsts = new BasicEList<PRDGEdge>();
		for (PRDGEdge edge : getPrdg().getEdges()) {
			if (edge.getSource().equals(this)) {
				dsts.add(edge);
			}
		}
		return dsts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<PRDGEdge> getSources() {
		EList<PRDGEdge> dsts = new BasicEList<PRDGEdge>();
		for (PRDGEdge edge : getPrdg().getEdges()) {
			if (edge.getDestination().equals(this)) {
				dsts.add(edge);
			}
		}
		return dsts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrdgPackage.PRDG_NODE__PRDG:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPrdg((PRDG)otherEnd, msgs);
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
			case PrdgPackage.PRDG_NODE__PRDG:
				return basicSetPrdg(null, msgs);
			case PrdgPackage.PRDG_NODE__DOMAIN:
				return basicSetDomain(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PrdgPackage.PRDG_NODE__PRDG:
				return eInternalContainer().eInverseRemove(this, PrdgPackage.PRDG__NODES, PRDG.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrdgPackage.PRDG_NODE__PRDG:
				return getPrdg();
			case PrdgPackage.PRDG_NODE__DOMAIN:
				return getDomain();
			case PrdgPackage.PRDG_NODE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PrdgPackage.PRDG_NODE__PRDG:
				setPrdg((PRDG)newValue);
				return;
			case PrdgPackage.PRDG_NODE__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case PrdgPackage.PRDG_NODE__NAME:
				setName((String)newValue);
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
			case PrdgPackage.PRDG_NODE__PRDG:
				setPrdg((PRDG)null);
				return;
			case PrdgPackage.PRDG_NODE__DOMAIN:
				setDomain((Domain)null);
				return;
			case PrdgPackage.PRDG_NODE__NAME:
				setName(NAME_EDEFAULT);
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
			case PrdgPackage.PRDG_NODE__PRDG:
				return getPrdg() != null;
			case PrdgPackage.PRDG_NODE__DOMAIN:
				return domain != null;
			case PrdgPackage.PRDG_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PrdgPackage.PRDG_NODE___GET_DESTINATIONS:
				return getDestinations();
			case PrdgPackage.PRDG_NODE___GET_SOURCES:
				return getSources();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		return PRDGPrettyPrinter.pretty(this);
	}

} //PRDGNodeImpl
