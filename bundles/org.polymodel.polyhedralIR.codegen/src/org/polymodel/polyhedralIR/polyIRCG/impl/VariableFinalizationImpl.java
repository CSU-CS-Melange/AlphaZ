/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

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
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Finalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl#getSpecialLocals <em>Special Locals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableFinalizationImpl extends EObjectImpl implements VariableFinalization {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> inputs;
	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> outputs;

	/**
	 * The cached value of the '{@link #getLocals() <em>Locals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> locals;

	/**
	 * The cached value of the '{@link #getSpecialLocals() <em>Special Locals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> specialLocals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableFinalizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.VARIABLE_FINALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION && newFunction != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.VARIABLE_FINALIZATION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.VARIABLE_FINALIZATION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getLocals() {
		if (locals == null) {
			locals = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.VARIABLE_FINALIZATION__LOCALS);
		}
		return locals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getSpecialLocals() {
		if (specialLocals == null) {
			specialLocals = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, PolyIRCGPackage.VARIABLE_FINALIZATION__SPECIAL_LOCALS);
		}
		return specialLocals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
				return getFunction();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__INPUTS:
				return getInputs();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__OUTPUTS:
				return getOutputs();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__LOCALS:
				return getLocals();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__SPECIAL_LOCALS:
				return getSpecialLocals();
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__LOCALS:
				getLocals().clear();
				getLocals().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__SPECIAL_LOCALS:
				getSpecialLocals().clear();
				getSpecialLocals().addAll((Collection<? extends CodeGenVariable>)newValue);
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
				setFunction((Function)null);
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__INPUTS:
				getInputs().clear();
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__OUTPUTS:
				getOutputs().clear();
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__LOCALS:
				getLocals().clear();
				return;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__SPECIAL_LOCALS:
				getSpecialLocals().clear();
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
			case PolyIRCGPackage.VARIABLE_FINALIZATION__FUNCTION:
				return getFunction() != null;
			case PolyIRCGPackage.VARIABLE_FINALIZATION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__LOCALS:
				return locals != null && !locals.isEmpty();
			case PolyIRCGPackage.VARIABLE_FINALIZATION__SPECIAL_LOCALS:
				return specialLocals != null && !specialLocals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VariableFinalizationImpl
