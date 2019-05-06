/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Volume Function Derivative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl#getUnknown <em>Unknown</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VolumeFunctionDerivativeImpl extends EObjectImpl implements VolumeFunctionDerivative {
	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable unknown;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VolumeFunctionDerivativeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScanPackage.Literals.VOLUME_FUNCTION_DERIVATIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getUnknown() {
		if (unknown != null && unknown.eIsProxy()) {
			InternalEObject oldUnknown = (InternalEObject)unknown;
			unknown = (AbstractVariable)eResolveProxy(oldUnknown);
			if (unknown != oldUnknown) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN, oldUnknown, unknown));
			}
		}
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetUnknown() {
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknown(AbstractVariable newUnknown) {
		AbstractVariable oldUnknown = unknown;
		unknown = newUnknown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN, oldUnknown, unknown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				return basicSetFunction(null, msgs);
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				return getFunction();
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN:
				if (resolve) return getUnknown();
				return basicGetUnknown();
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				setFunction((Function)newValue);
				return;
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN:
				setUnknown((AbstractVariable)newValue);
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				setFunction((Function)null);
				return;
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN:
				setUnknown((AbstractVariable)null);
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
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__FUNCTION:
				return getFunction() != null;
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE__UNKNOWN:
				return unknown != null;
		}
		return super.eIsSet(featureID);
	}

} //VolumeFunctionDerivativeImpl
