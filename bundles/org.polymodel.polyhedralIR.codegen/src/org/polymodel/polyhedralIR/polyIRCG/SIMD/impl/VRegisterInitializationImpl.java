/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VRegister Initialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VRegisterInitializationImpl extends EObjectImpl implements VRegisterInitialization {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> inputs;

	/**
	 * The cached value of the '{@link #getLocals() <em>Locals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> locals;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VRegister> outputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VRegisterInitializationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.VREGISTER_INITIALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION && newFunction != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.VREGISTER_INITIALIZATION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getLocals() {
		if (locals == null) {
			locals = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.VREGISTER_INITIALIZATION__LOCALS);
		}
		return locals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VRegister> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<VRegister>(VRegister.class, this, SIMDPackage.VREGISTER_INITIALIZATION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
				return getFunction();
			case SIMDPackage.VREGISTER_INITIALIZATION__INPUTS:
				return getInputs();
			case SIMDPackage.VREGISTER_INITIALIZATION__LOCALS:
				return getLocals();
			case SIMDPackage.VREGISTER_INITIALIZATION__OUTPUTS:
				return getOutputs();
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends VRegister>)newValue);
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__LOCALS:
				getLocals().clear();
				getLocals().addAll((Collection<? extends VRegister>)newValue);
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends VRegister>)newValue);
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
				setFunction((Function)null);
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__INPUTS:
				getInputs().clear();
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__LOCALS:
				getLocals().clear();
				return;
			case SIMDPackage.VREGISTER_INITIALIZATION__OUTPUTS:
				getOutputs().clear();
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
			case SIMDPackage.VREGISTER_INITIALIZATION__FUNCTION:
				return getFunction() != null;
			case SIMDPackage.VREGISTER_INITIALIZATION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case SIMDPackage.VREGISTER_INITIALIZATION__LOCALS:
				return locals != null && !locals.isEmpty();
			case SIMDPackage.VREGISTER_INITIALIZATION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VRegisterInitializationImpl
