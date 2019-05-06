/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.util.PRDGPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PRDG Sub System Hyper Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl#getDestinations <em>Destinations</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl#getExtDom <em>Ext Dom</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGSubSystemHyperEdgeImpl#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PRDGSubSystemHyperEdgeImpl extends EObjectImpl implements PRDGSubSystemHyperEdge {
	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGNode> sources;

	/**
	 * The cached value of the '{@link #getDestinations() <em>Destinations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinations()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGNode> destinations;

	/**
	 * The cached value of the '{@link #getExtDom() <em>Ext Dom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtDom()
	 * @generated
	 * @ordered
	 */
	protected Domain extDom;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected Function params;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PRDGSubSystemHyperEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrdgPackage.Literals.PRDG_SUB_SYSTEM_HYPER_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGNode> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<PRDGNode>(PRDGNode.class, this, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGNode> getDestinations() {
		if (destinations == null) {
			destinations = new EObjectResolvingEList<PRDGNode>(PRDGNode.class, this, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS);
		}
		return destinations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getExtDom() {
		if (extDom != null && extDom.eIsProxy()) {
			InternalEObject oldExtDom = (InternalEObject)extDom;
			extDom = (Domain)eResolveProxy(oldExtDom);
			if (extDom != oldExtDom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM, oldExtDom, extDom));
			}
		}
		return extDom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetExtDom() {
		return extDom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtDom(Domain newExtDom) {
		Domain oldExtDom = extDom;
		extDom = newExtDom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM, oldExtDom, extDom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getParams() {
		if (params != null && params.eIsProxy()) {
			InternalEObject oldParams = (InternalEObject)params;
			params = (Function)eResolveProxy(oldParams);
			if (params != oldParams) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS, oldParams, params));
			}
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetParams() {
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParams(Function newParams) {
		Function oldParams = params;
		params = newParams;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS, oldParams, params));
	}
	
	@Override
	public String toString() {
		return PRDGPrettyPrinter.pretty(this);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES:
				return getSources();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS:
				return getDestinations();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM:
				if (resolve) return getExtDom();
				return basicGetExtDom();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS:
				if (resolve) return getParams();
				return basicGetParams();
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
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends PRDGNode>)newValue);
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS:
				getDestinations().clear();
				getDestinations().addAll((Collection<? extends PRDGNode>)newValue);
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM:
				setExtDom((Domain)newValue);
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS:
				setParams((Function)newValue);
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
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES:
				getSources().clear();
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS:
				getDestinations().clear();
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM:
				setExtDom((Domain)null);
				return;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS:
				setParams((Function)null);
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
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES:
				return sources != null && !sources.isEmpty();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS:
				return destinations != null && !destinations.isEmpty();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM:
				return extDom != null;
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS:
				return params != null;
		}
		return super.eIsSet(featureID);
	}

} //PRDGSubSystemHyperEdgeImpl
