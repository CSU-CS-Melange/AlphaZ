/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIMD Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SIMDExpressionImpl#getVtype <em>Vtype</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SIMDExpressionImpl extends EObjectImpl implements SIMDExpression {
	/**
	 * The cached value of the '{@link #getVtype() <em>Vtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVtype()
	 * @generated
	 * @ordered
	 */
	protected VType vtype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIMDExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.SIMD_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType getVtype() {
		if (vtype != null && vtype.eIsProxy()) {
			InternalEObject oldVtype = (InternalEObject)vtype;
			vtype = (VType)eResolveProxy(oldVtype);
			if (vtype != oldVtype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.SIMD_EXPRESSION__VTYPE, oldVtype, vtype));
			}
		}
		return vtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType basicGetVtype() {
		return vtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVtype(VType newVtype) {
		VType oldVtype = vtype;
		vtype = newVtype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.SIMD_EXPRESSION__VTYPE, oldVtype, vtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.SIMD_EXPRESSION__VTYPE:
				if (resolve) return getVtype();
				return basicGetVtype();
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
			case SimdExpPackage.SIMD_EXPRESSION__VTYPE:
				setVtype((VType)newValue);
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
			case SimdExpPackage.SIMD_EXPRESSION__VTYPE:
				setVtype((VType)null);
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
			case SimdExpPackage.SIMD_EXPRESSION__VTYPE:
				return vtype != null;
		}
		return super.eIsSet(featureID);
	}

} //SIMDExpressionImpl
