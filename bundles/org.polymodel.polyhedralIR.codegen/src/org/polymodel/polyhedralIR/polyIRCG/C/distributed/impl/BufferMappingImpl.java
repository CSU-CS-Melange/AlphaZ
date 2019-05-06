/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl#getValueAccess <em>Value Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl#getBufferAccess <em>Buffer Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl#getCommunicatedVariable <em>Communicated Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferMappingImpl extends EObjectImpl implements BufferMapping {
	/**
	 * The cached value of the '{@link #getValueAccess() <em>Value Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueAccess()
	 * @generated
	 * @ordered
	 */
	protected MemoryAccessExpression valueAccess;

	/**
	 * The cached value of the '{@link #getBufferAccess() <em>Buffer Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferAccess()
	 * @generated
	 * @ordered
	 */
	protected MemoryAccessExpression bufferAccess;

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
	 * The cached value of the '{@link #getCommunicatedVariable() <em>Communicated Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicatedVariable()
	 * @generated
	 * @ordered
	 */
	protected CommunicatedVariableForTiledSpace communicatedVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.BUFFER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryAccessExpression getValueAccess() {
		return valueAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueAccess(MemoryAccessExpression newValueAccess, NotificationChain msgs) {
		MemoryAccessExpression oldValueAccess = valueAccess;
		valueAccess = newValueAccess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS, oldValueAccess, newValueAccess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueAccess(MemoryAccessExpression newValueAccess) {
		if (newValueAccess != valueAccess) {
			NotificationChain msgs = null;
			if (valueAccess != null)
				msgs = ((InternalEObject)valueAccess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS, null, msgs);
			if (newValueAccess != null)
				msgs = ((InternalEObject)newValueAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS, null, msgs);
			msgs = basicSetValueAccess(newValueAccess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS, newValueAccess, newValueAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryAccessExpression getBufferAccess() {
		return bufferAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferAccess(MemoryAccessExpression newBufferAccess, NotificationChain msgs) {
		MemoryAccessExpression oldBufferAccess = bufferAccess;
		bufferAccess = newBufferAccess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS, oldBufferAccess, newBufferAccess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferAccess(MemoryAccessExpression newBufferAccess) {
		if (newBufferAccess != bufferAccess) {
			NotificationChain msgs = null;
			if (bufferAccess != null)
				msgs = ((InternalEObject)bufferAccess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS, null, msgs);
			if (newBufferAccess != null)
				msgs = ((InternalEObject)newBufferAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS, null, msgs);
			msgs = basicSetBufferAccess(newBufferAccess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS, newBufferAccess, newBufferAccess));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__DOMAIN, oldDomain, newDomain);
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
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MAPPING__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicatedVariableForTiledSpace getCommunicatedVariable() {
		if (communicatedVariable != null && communicatedVariable.eIsProxy()) {
			InternalEObject oldCommunicatedVariable = (InternalEObject)communicatedVariable;
			communicatedVariable = (CommunicatedVariableForTiledSpace)eResolveProxy(oldCommunicatedVariable);
			if (communicatedVariable != oldCommunicatedVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE, oldCommunicatedVariable, communicatedVariable));
			}
		}
		return communicatedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicatedVariableForTiledSpace basicGetCommunicatedVariable() {
		return communicatedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommunicatedVariable(CommunicatedVariableForTiledSpace newCommunicatedVariable) {
		CommunicatedVariableForTiledSpace oldCommunicatedVariable = communicatedVariable;
		communicatedVariable = newCommunicatedVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE, oldCommunicatedVariable, communicatedVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS:
				return basicSetValueAccess(null, msgs);
			case CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS:
				return basicSetBufferAccess(null, msgs);
			case CDistributedPackage.BUFFER_MAPPING__DOMAIN:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS:
				return getValueAccess();
			case CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS:
				return getBufferAccess();
			case CDistributedPackage.BUFFER_MAPPING__DOMAIN:
				return getDomain();
			case CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE:
				if (resolve) return getCommunicatedVariable();
				return basicGetCommunicatedVariable();
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
			case CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS:
				setValueAccess((MemoryAccessExpression)newValue);
				return;
			case CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS:
				setBufferAccess((MemoryAccessExpression)newValue);
				return;
			case CDistributedPackage.BUFFER_MAPPING__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE:
				setCommunicatedVariable((CommunicatedVariableForTiledSpace)newValue);
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
			case CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS:
				setValueAccess((MemoryAccessExpression)null);
				return;
			case CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS:
				setBufferAccess((MemoryAccessExpression)null);
				return;
			case CDistributedPackage.BUFFER_MAPPING__DOMAIN:
				setDomain((Domain)null);
				return;
			case CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE:
				setCommunicatedVariable((CommunicatedVariableForTiledSpace)null);
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
			case CDistributedPackage.BUFFER_MAPPING__VALUE_ACCESS:
				return valueAccess != null;
			case CDistributedPackage.BUFFER_MAPPING__BUFFER_ACCESS:
				return bufferAccess != null;
			case CDistributedPackage.BUFFER_MAPPING__DOMAIN:
				return domain != null;
			case CDistributedPackage.BUFFER_MAPPING__COMMUNICATED_VARIABLE:
				return communicatedVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //BufferMappingImpl
