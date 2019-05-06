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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.structured.Channel;
import org.polymodel.prdg.scheduling.structured.ProcessNetwork;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl#getPrdg <em>Prdg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessNetworkImpl extends EObjectImpl implements ProcessNetwork {
	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.polymodel.prdg.scheduling.structured.Process> processes;

	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<Channel> channels;

	/**
	 * The cached value of the '{@link #getPrdg() <em>Prdg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrdg()
	 * @generated
	 * @ordered
	 */
	protected PRDG prdg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.PROCESS_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.polymodel.prdg.scheduling.structured.Process> getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentEList<org.polymodel.prdg.scheduling.structured.Process>(org.polymodel.prdg.scheduling.structured.Process.class, this, StructuredPackage.PROCESS_NETWORK__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Channel> getChannels() {
		if (channels == null) {
			channels = new EObjectContainmentEList<Channel>(Channel.class, this, StructuredPackage.PROCESS_NETWORK__CHANNELS);
		}
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDG getPrdg() {
		if (prdg != null && prdg.eIsProxy()) {
			InternalEObject oldPrdg = (InternalEObject)prdg;
			prdg = (PRDG)eResolveProxy(oldPrdg);
			if (prdg != oldPrdg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructuredPackage.PROCESS_NETWORK__PRDG, oldPrdg, prdg));
			}
		}
		return prdg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDG basicGetPrdg() {
		return prdg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrdg(PRDG newPrdg) {
		PRDG oldPrdg = prdg;
		prdg = newPrdg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.PROCESS_NETWORK__PRDG, oldPrdg, prdg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.PROCESS_NETWORK__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
			case StructuredPackage.PROCESS_NETWORK__CHANNELS:
				return ((InternalEList<?>)getChannels()).basicRemove(otherEnd, msgs);
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
			case StructuredPackage.PROCESS_NETWORK__PROCESSES:
				return getProcesses();
			case StructuredPackage.PROCESS_NETWORK__CHANNELS:
				return getChannels();
			case StructuredPackage.PROCESS_NETWORK__PRDG:
				if (resolve) return getPrdg();
				return basicGetPrdg();
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
			case StructuredPackage.PROCESS_NETWORK__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends org.polymodel.prdg.scheduling.structured.Process>)newValue);
				return;
			case StructuredPackage.PROCESS_NETWORK__CHANNELS:
				getChannels().clear();
				getChannels().addAll((Collection<? extends Channel>)newValue);
				return;
			case StructuredPackage.PROCESS_NETWORK__PRDG:
				setPrdg((PRDG)newValue);
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
			case StructuredPackage.PROCESS_NETWORK__PROCESSES:
				getProcesses().clear();
				return;
			case StructuredPackage.PROCESS_NETWORK__CHANNELS:
				getChannels().clear();
				return;
			case StructuredPackage.PROCESS_NETWORK__PRDG:
				setPrdg((PRDG)null);
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
			case StructuredPackage.PROCESS_NETWORK__PROCESSES:
				return processes != null && !processes.isEmpty();
			case StructuredPackage.PROCESS_NETWORK__CHANNELS:
				return channels != null && !channels.isEmpty();
			case StructuredPackage.PROCESS_NETWORK__PRDG:
				return prdg != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessNetworkImpl
