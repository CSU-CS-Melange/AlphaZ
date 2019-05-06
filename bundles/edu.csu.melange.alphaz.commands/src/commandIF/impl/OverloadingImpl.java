/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import commandIF.Category;
import commandIF.Command;
import commandIF.CommandIFPackage;
import commandIF.Input;
import commandIF.Overloading;
import commandIF.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overloading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link commandIF.impl.OverloadingImpl#getOverLoadedInputs <em>Over Loaded Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OverloadingImpl extends CommandImpl implements Overloading {
	/**
	 * The cached value of the '{@link #getOverLoadedInputs() <em>Over Loaded Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverLoadedInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> overLoadedInputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OverloadingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandIFPackage.Literals.OVERLOADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getOverLoadedInputs() {
		if (overLoadedInputs == null) {
			overLoadedInputs = new EObjectResolvingEList<Input>(Input.class, this, CommandIFPackage.OVERLOADING__OVER_LOADED_INPUTS);
		}
		return overLoadedInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommandIFPackage.OVERLOADING__OVER_LOADED_INPUTS:
				return getOverLoadedInputs();
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
			case CommandIFPackage.OVERLOADING__OVER_LOADED_INPUTS:
				getOverLoadedInputs().clear();
				getOverLoadedInputs().addAll((Collection<? extends Input>)newValue);
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
			case CommandIFPackage.OVERLOADING__OVER_LOADED_INPUTS:
				getOverLoadedInputs().clear();
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
			case CommandIFPackage.OVERLOADING__OVER_LOADED_INPUTS:
				return overLoadedInputs != null && !overLoadedInputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String getName() {
		return ((Command)this.eContainer()).getName();
	}

	@Override
	public Type getOutput() {
		return ((Command)this.eContainer()).getOutput();
	}
	
	@Override
	public Category getCategory() {
		return ((Command)this.eContainer).getCategory();
	}


} //OverloadingImpl
