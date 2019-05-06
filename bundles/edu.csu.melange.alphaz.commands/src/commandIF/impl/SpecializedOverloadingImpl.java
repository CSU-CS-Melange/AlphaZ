/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF.impl;

import commandIF.CommandIFPackage;
import commandIF.Input;
import commandIF.SpecializedOverloading;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialized Overloading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link commandIF.impl.SpecializedOverloadingImpl#getAdditionalInputs <em>Additional Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecializedOverloadingImpl extends OverloadingImpl implements SpecializedOverloading {
	/**
	 * The cached value of the '{@link #getAdditionalInputs() <em>Additional Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> additionalInputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializedOverloadingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandIFPackage.Literals.SPECIALIZED_OVERLOADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getAdditionalInputs() {
		if (additionalInputs == null) {
			additionalInputs = new EObjectContainmentEList<Input>(Input.class, this, CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS);
		}
		return additionalInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS:
				return ((InternalEList<?>)getAdditionalInputs()).basicRemove(otherEnd, msgs);
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
			case CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS:
				return getAdditionalInputs();
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
			case CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS:
				getAdditionalInputs().clear();
				getAdditionalInputs().addAll((Collection<? extends Input>)newValue);
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
			case CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS:
				getAdditionalInputs().clear();
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
			case CommandIFPackage.SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS:
				return additionalInputs != null && !additionalInputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecializedOverloadingImpl
