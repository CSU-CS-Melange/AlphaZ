/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VBinary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl#getLreg <em>Lreg</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl#getRreg <em>Rreg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VBinaryExpressionImpl extends SIMDExpressionImpl implements VBinaryExpression {
	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final VOP OP_EDEFAULT = VOP.ADD;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected VOP op = OP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLreg() <em>Lreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLreg()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression lreg;

	/**
	 * The cached value of the '{@link #getRreg() <em>Rreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRreg()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression rreg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VBinaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.VBINARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VOP getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(VOP newOp) {
		VOP oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VBINARY_EXPRESSION__OP, oldOp, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getLreg() {
		if (lreg != null && lreg.eIsProxy()) {
			InternalEObject oldLreg = (InternalEObject)lreg;
			lreg = (SIMDExpression)eResolveProxy(oldLreg);
			if (lreg != oldLreg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VBINARY_EXPRESSION__LREG, oldLreg, lreg));
			}
		}
		return lreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetLreg() {
		return lreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLreg(SIMDExpression newLreg) {
		SIMDExpression oldLreg = lreg;
		lreg = newLreg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VBINARY_EXPRESSION__LREG, oldLreg, lreg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getRreg() {
		if (rreg != null && rreg.eIsProxy()) {
			InternalEObject oldRreg = (InternalEObject)rreg;
			rreg = (SIMDExpression)eResolveProxy(oldRreg);
			if (rreg != oldRreg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VBINARY_EXPRESSION__RREG, oldRreg, rreg));
			}
		}
		return rreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetRreg() {
		return rreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRreg(SIMDExpression newRreg) {
		SIMDExpression oldRreg = rreg;
		rreg = newRreg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VBINARY_EXPRESSION__RREG, oldRreg, rreg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.VBINARY_EXPRESSION__OP:
				return getOp();
			case SimdExpPackage.VBINARY_EXPRESSION__LREG:
				if (resolve) return getLreg();
				return basicGetLreg();
			case SimdExpPackage.VBINARY_EXPRESSION__RREG:
				if (resolve) return getRreg();
				return basicGetRreg();
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
			case SimdExpPackage.VBINARY_EXPRESSION__OP:
				setOp((VOP)newValue);
				return;
			case SimdExpPackage.VBINARY_EXPRESSION__LREG:
				setLreg((SIMDExpression)newValue);
				return;
			case SimdExpPackage.VBINARY_EXPRESSION__RREG:
				setRreg((SIMDExpression)newValue);
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
			case SimdExpPackage.VBINARY_EXPRESSION__OP:
				setOp(OP_EDEFAULT);
				return;
			case SimdExpPackage.VBINARY_EXPRESSION__LREG:
				setLreg((SIMDExpression)null);
				return;
			case SimdExpPackage.VBINARY_EXPRESSION__RREG:
				setRreg((SIMDExpression)null);
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
			case SimdExpPackage.VBINARY_EXPRESSION__OP:
				return op != OP_EDEFAULT;
			case SimdExpPackage.VBINARY_EXPRESSION__LREG:
				return lreg != null;
			case SimdExpPackage.VBINARY_EXPRESSION__RREG:
				return rreg != null;
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
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} //VBinaryExpressionImpl
