/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VAssign Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl#getLreg <em>Lreg</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl#getRexp <em>Rexp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VAssignExpressionImpl extends SIMDExpressionImpl implements VAssignExpression {
	/**
	 * The cached value of the '{@link #getLreg() <em>Lreg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLreg()
	 * @generated
	 * @ordered
	 */
	protected VRegister lreg;

	/**
	 * The cached value of the '{@link #getRexp() <em>Rexp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRexp()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression rexp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VAssignExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.VASSIGN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegister getLreg() {
		if (lreg != null && lreg.eIsProxy()) {
			InternalEObject oldLreg = (InternalEObject)lreg;
			lreg = (VRegister)eResolveProxy(oldLreg);
			if (lreg != oldLreg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VASSIGN_EXPRESSION__LREG, oldLreg, lreg));
			}
		}
		return lreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegister basicGetLreg() {
		return lreg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLreg(VRegister newLreg) {
		VRegister oldLreg = lreg;
		lreg = newLreg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VASSIGN_EXPRESSION__LREG, oldLreg, lreg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getRexp() {
		if (rexp != null && rexp.eIsProxy()) {
			InternalEObject oldRexp = (InternalEObject)rexp;
			rexp = (SIMDExpression)eResolveProxy(oldRexp);
			if (rexp != oldRexp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VASSIGN_EXPRESSION__REXP, oldRexp, rexp));
			}
		}
		return rexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetRexp() {
		return rexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRexp(SIMDExpression newRexp) {
		SIMDExpression oldRexp = rexp;
		rexp = newRexp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VASSIGN_EXPRESSION__REXP, oldRexp, rexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.VASSIGN_EXPRESSION__LREG:
				if (resolve) return getLreg();
				return basicGetLreg();
			case SimdExpPackage.VASSIGN_EXPRESSION__REXP:
				if (resolve) return getRexp();
				return basicGetRexp();
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
			case SimdExpPackage.VASSIGN_EXPRESSION__LREG:
				setLreg((VRegister)newValue);
				return;
			case SimdExpPackage.VASSIGN_EXPRESSION__REXP:
				setRexp((SIMDExpression)newValue);
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
			case SimdExpPackage.VASSIGN_EXPRESSION__LREG:
				setLreg((VRegister)null);
				return;
			case SimdExpPackage.VASSIGN_EXPRESSION__REXP:
				setRexp((SIMDExpression)null);
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
			case SimdExpPackage.VASSIGN_EXPRESSION__LREG:
				return lreg != null;
			case SimdExpPackage.VASSIGN_EXPRESSION__REXP:
				return rexp != null;
		}
		return super.eIsSet(featureID);
	}

} //VAssignExpressionImpl
