/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VShift Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl#getReg1 <em>Reg1</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl#getReg2 <em>Reg2</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl#getDis <em>Dis</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VShiftExpressionImpl extends SIMDExpressionImpl implements VShiftExpression {
	/**
	 * The cached value of the '{@link #getReg1() <em>Reg1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReg1()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression reg1;

	/**
	 * The cached value of the '{@link #getReg2() <em>Reg2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReg2()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression reg2;

	/**
	 * The default value of the '{@link #getDis() <em>Dis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDis()
	 * @generated
	 * @ordered
	 */
	protected static final int DIS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDis() <em>Dis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDis()
	 * @generated
	 * @ordered
	 */
	protected int dis = DIS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VShiftExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.VSHIFT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getReg1() {
		if (reg1 != null && reg1.eIsProxy()) {
			InternalEObject oldReg1 = (InternalEObject)reg1;
			reg1 = (SIMDExpression)eResolveProxy(oldReg1);
			if (reg1 != oldReg1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VSHIFT_EXPRESSION__REG1, oldReg1, reg1));
			}
		}
		return reg1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetReg1() {
		return reg1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReg1(SIMDExpression newReg1) {
		SIMDExpression oldReg1 = reg1;
		reg1 = newReg1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VSHIFT_EXPRESSION__REG1, oldReg1, reg1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getReg2() {
		if (reg2 != null && reg2.eIsProxy()) {
			InternalEObject oldReg2 = (InternalEObject)reg2;
			reg2 = (SIMDExpression)eResolveProxy(oldReg2);
			if (reg2 != oldReg2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VSHIFT_EXPRESSION__REG2, oldReg2, reg2));
			}
		}
		return reg2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetReg2() {
		return reg2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReg2(SIMDExpression newReg2) {
		SIMDExpression oldReg2 = reg2;
		reg2 = newReg2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VSHIFT_EXPRESSION__REG2, oldReg2, reg2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDis() {
		return dis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDis(int newDis) {
		int oldDis = dis;
		dis = newDis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VSHIFT_EXPRESSION__DIS, oldDis, dis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.VSHIFT_EXPRESSION__REG1:
				if (resolve) return getReg1();
				return basicGetReg1();
			case SimdExpPackage.VSHIFT_EXPRESSION__REG2:
				if (resolve) return getReg2();
				return basicGetReg2();
			case SimdExpPackage.VSHIFT_EXPRESSION__DIS:
				return getDis();
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
			case SimdExpPackage.VSHIFT_EXPRESSION__REG1:
				setReg1((SIMDExpression)newValue);
				return;
			case SimdExpPackage.VSHIFT_EXPRESSION__REG2:
				setReg2((SIMDExpression)newValue);
				return;
			case SimdExpPackage.VSHIFT_EXPRESSION__DIS:
				setDis((Integer)newValue);
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
			case SimdExpPackage.VSHIFT_EXPRESSION__REG1:
				setReg1((SIMDExpression)null);
				return;
			case SimdExpPackage.VSHIFT_EXPRESSION__REG2:
				setReg2((SIMDExpression)null);
				return;
			case SimdExpPackage.VSHIFT_EXPRESSION__DIS:
				setDis(DIS_EDEFAULT);
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
			case SimdExpPackage.VSHIFT_EXPRESSION__REG1:
				return reg1 != null;
			case SimdExpPackage.VSHIFT_EXPRESSION__REG2:
				return reg2 != null;
			case SimdExpPackage.VSHIFT_EXPRESSION__DIS:
				return dis != DIS_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (dis: ");
		result.append(dis);
		result.append(')');
		return result.toString();
	}

} //VShiftExpressionImpl
