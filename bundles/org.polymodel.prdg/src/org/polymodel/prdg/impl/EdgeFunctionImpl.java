/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.Function;
import org.polymodel.prdg.EdgeFunction;
import org.polymodel.prdg.PrdgPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.impl.EdgeFunctionImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EdgeFunctionImpl extends EObjectImpl implements EdgeFunction {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected Function mapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrdgPackage.Literals.EDGE_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(Function newMapping, NotificationChain msgs) {
		Function oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrdgPackage.EDGE_FUNCTION__MAPPING, oldMapping, newMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(Function newMapping) {
		if (newMapping != mapping) {
			NotificationChain msgs = null;
			if (mapping != null)
				msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrdgPackage.EDGE_FUNCTION__MAPPING, null, msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrdgPackage.EDGE_FUNCTION__MAPPING, null, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.EDGE_FUNCTION__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrdgPackage.EDGE_FUNCTION__MAPPING:
				return basicSetMapping(null, msgs);
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
			case PrdgPackage.EDGE_FUNCTION__MAPPING:
				return getMapping();
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
			case PrdgPackage.EDGE_FUNCTION__MAPPING:
				setMapping((Function)newValue);
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
			case PrdgPackage.EDGE_FUNCTION__MAPPING:
				setMapping((Function)null);
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
			case PrdgPackage.EDGE_FUNCTION__MAPPING:
				return mapping != null;
		}
		return super.eIsSet(featureID);
	}

} //EdgeFunctionImpl
