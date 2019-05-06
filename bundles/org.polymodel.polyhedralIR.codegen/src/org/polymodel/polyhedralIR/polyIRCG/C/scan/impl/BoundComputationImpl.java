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
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Computation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getLb <em>Lb</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getUb <em>Ub</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getVolumeFunction <em>Volume Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getVolumeFunctionDerivative <em>Volume Function Derivative</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundComputationImpl extends EObjectImpl implements BoundComputation {
	/**
	 * The cached value of the '{@link #getLb() <em>Lb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLb()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable lb;

	/**
	 * The cached value of the '{@link #getUb() <em>Ub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUb()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable ub;

	/**
	 * The cached value of the '{@link #getConstantTerm() <em>Constant Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantTerm()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable constantTerm;

	/**
	 * The cached value of the '{@link #getVolumeFunction() <em>Volume Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolumeFunction()
	 * @generated
	 * @ordered
	 */
	protected VolumeFunction volumeFunction;

	/**
	 * The cached value of the '{@link #getVolumeFunctionDerivative() <em>Volume Function Derivative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolumeFunctionDerivative()
	 * @generated
	 * @ordered
	 */
	protected VolumeFunctionDerivative volumeFunctionDerivative;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable initialValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundComputationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScanPackage.Literals.BOUND_COMPUTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != ScanPackage.BOUND_COMPUTATION__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, ScanPackage.BOUND_COMPUTATION__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != ScanPackage.BOUND_COMPUTATION__FUNCTION && newFunction != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getLb() {
		if (lb != null && lb.eIsProxy()) {
			InternalEObject oldLb = (InternalEObject)lb;
			lb = (AbstractVariable)eResolveProxy(oldLb);
			if (lb != oldLb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__LB, oldLb, lb));
			}
		}
		return lb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetLb() {
		return lb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLb(AbstractVariable newLb) {
		AbstractVariable oldLb = lb;
		lb = newLb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__LB, oldLb, lb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getUb() {
		if (ub != null && ub.eIsProxy()) {
			InternalEObject oldUb = (InternalEObject)ub;
			ub = (AbstractVariable)eResolveProxy(oldUb);
			if (ub != oldUb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__UB, oldUb, ub));
			}
		}
		return ub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetUb() {
		return ub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUb(AbstractVariable newUb) {
		AbstractVariable oldUb = ub;
		ub = newUb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__UB, oldUb, ub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getConstantTerm() {
		if (constantTerm != null && constantTerm.eIsProxy()) {
			InternalEObject oldConstantTerm = (InternalEObject)constantTerm;
			constantTerm = (AbstractVariable)eResolveProxy(oldConstantTerm);
			if (constantTerm != oldConstantTerm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM, oldConstantTerm, constantTerm));
			}
		}
		return constantTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetConstantTerm() {
		return constantTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantTerm(AbstractVariable newConstantTerm) {
		AbstractVariable oldConstantTerm = constantTerm;
		constantTerm = newConstantTerm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM, oldConstantTerm, constantTerm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunction getVolumeFunction() {
		if (volumeFunction != null && volumeFunction.eIsProxy()) {
			InternalEObject oldVolumeFunction = (InternalEObject)volumeFunction;
			volumeFunction = (VolumeFunction)eResolveProxy(oldVolumeFunction);
			if (volumeFunction != oldVolumeFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION, oldVolumeFunction, volumeFunction));
			}
		}
		return volumeFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunction basicGetVolumeFunction() {
		return volumeFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolumeFunction(VolumeFunction newVolumeFunction) {
		VolumeFunction oldVolumeFunction = volumeFunction;
		volumeFunction = newVolumeFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION, oldVolumeFunction, volumeFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunctionDerivative getVolumeFunctionDerivative() {
		if (volumeFunctionDerivative != null && volumeFunctionDerivative.eIsProxy()) {
			InternalEObject oldVolumeFunctionDerivative = (InternalEObject)volumeFunctionDerivative;
			volumeFunctionDerivative = (VolumeFunctionDerivative)eResolveProxy(oldVolumeFunctionDerivative);
			if (volumeFunctionDerivative != oldVolumeFunctionDerivative) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE, oldVolumeFunctionDerivative, volumeFunctionDerivative));
			}
		}
		return volumeFunctionDerivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunctionDerivative basicGetVolumeFunctionDerivative() {
		return volumeFunctionDerivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolumeFunctionDerivative(VolumeFunctionDerivative newVolumeFunctionDerivative) {
		VolumeFunctionDerivative oldVolumeFunctionDerivative = volumeFunctionDerivative;
		volumeFunctionDerivative = newVolumeFunctionDerivative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE, oldVolumeFunctionDerivative, volumeFunctionDerivative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getInitialValue() {
		if (initialValue != null && initialValue.eIsProxy()) {
			InternalEObject oldInitialValue = (InternalEObject)initialValue;
			initialValue = (AbstractVariable)eResolveProxy(oldInitialValue);
			if (initialValue != oldInitialValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE, oldInitialValue, initialValue));
			}
		}
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(AbstractVariable newInitialValue) {
		AbstractVariable oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE, oldInitialValue, initialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
				return getFunction();
			case ScanPackage.BOUND_COMPUTATION__LB:
				if (resolve) return getLb();
				return basicGetLb();
			case ScanPackage.BOUND_COMPUTATION__UB:
				if (resolve) return getUb();
				return basicGetUb();
			case ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM:
				if (resolve) return getConstantTerm();
				return basicGetConstantTerm();
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION:
				if (resolve) return getVolumeFunction();
				return basicGetVolumeFunction();
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE:
				if (resolve) return getVolumeFunctionDerivative();
				return basicGetVolumeFunctionDerivative();
			case ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE:
				if (resolve) return getInitialValue();
				return basicGetInitialValue();
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__LB:
				setLb((AbstractVariable)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__UB:
				setUb((AbstractVariable)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM:
				setConstantTerm((AbstractVariable)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION:
				setVolumeFunction((VolumeFunction)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE:
				setVolumeFunctionDerivative((VolumeFunctionDerivative)newValue);
				return;
			case ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE:
				setInitialValue((AbstractVariable)newValue);
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
				setFunction((Function)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__LB:
				setLb((AbstractVariable)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__UB:
				setUb((AbstractVariable)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM:
				setConstantTerm((AbstractVariable)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION:
				setVolumeFunction((VolumeFunction)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE:
				setVolumeFunctionDerivative((VolumeFunctionDerivative)null);
				return;
			case ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE:
				setInitialValue((AbstractVariable)null);
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
			case ScanPackage.BOUND_COMPUTATION__FUNCTION:
				return getFunction() != null;
			case ScanPackage.BOUND_COMPUTATION__LB:
				return lb != null;
			case ScanPackage.BOUND_COMPUTATION__UB:
				return ub != null;
			case ScanPackage.BOUND_COMPUTATION__CONSTANT_TERM:
				return constantTerm != null;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION:
				return volumeFunction != null;
			case ScanPackage.BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE:
				return volumeFunctionDerivative != null;
			case ScanPackage.BOUND_COMPUTATION__INITIAL_VALUE:
				return initialValue != null;
		}
		return super.eIsSet(featureID);
	}

} //BoundComputationImpl
