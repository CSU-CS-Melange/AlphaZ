/**
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Pack Struct</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CustomPackStructImpl#getInitValues <em>Init Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomPackStructImpl extends StructManagementImpl implements CustomPackStruct {
	/**
	 * The cached value of the '{@link #getInitValues() <em>Init Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitValues()
	 * @generated
	 * @ordered
	 */
	protected Map<String, String> initValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomPackStructImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.CUSTOM_PACK_STRUCT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, String> getInitValues() {
		return initValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitValues(Map<String, String> newInitValues) {
		Map<String, String> oldInitValues = initValues;
		initValues = newInitValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CUSTOM_PACK_STRUCT__INIT_VALUES, oldInitValues, initValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT__INIT_VALUES:
				return getInitValues();
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
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT__INIT_VALUES:
				setInitValues((Map<String, String>)newValue);
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
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT__INIT_VALUES:
				setInitValues((Map<String, String>)null);
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
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT__INIT_VALUES:
				return initValues != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initValues: ");
		result.append(initValues);
		result.append(')');
		return result.toString();
	}

} //CustomPackStructImpl
