/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VStore Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl#getDst <em>Dst</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VStoreExpressionImpl extends SIMDExpressionImpl implements VStoreExpression {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected VRegister src;

	/**
	 * The cached value of the '{@link #getDst() <em>Dst</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDst()
	 * @generated
	 * @ordered
	 */
	protected BasicMemoryAddress dst;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VStoreExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.VSTORE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegister getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject)src;
			src = (VRegister)eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VSTORE_EXPRESSION__SRC, oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegister basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(VRegister newSrc) {
		VRegister oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VSTORE_EXPRESSION__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicMemoryAddress getDst() {
		if (dst != null && dst.eIsProxy()) {
			InternalEObject oldDst = (InternalEObject)dst;
			dst = (BasicMemoryAddress)eResolveProxy(oldDst);
			if (dst != oldDst) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.VSTORE_EXPRESSION__DST, oldDst, dst));
			}
		}
		return dst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicMemoryAddress basicGetDst() {
		return dst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDst(BasicMemoryAddress newDst) {
		BasicMemoryAddress oldDst = dst;
		dst = newDst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.VSTORE_EXPRESSION__DST, oldDst, dst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.VSTORE_EXPRESSION__SRC:
				if (resolve) return getSrc();
				return basicGetSrc();
			case SimdExpPackage.VSTORE_EXPRESSION__DST:
				if (resolve) return getDst();
				return basicGetDst();
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
			case SimdExpPackage.VSTORE_EXPRESSION__SRC:
				setSrc((VRegister)newValue);
				return;
			case SimdExpPackage.VSTORE_EXPRESSION__DST:
				setDst((BasicMemoryAddress)newValue);
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
			case SimdExpPackage.VSTORE_EXPRESSION__SRC:
				setSrc((VRegister)null);
				return;
			case SimdExpPackage.VSTORE_EXPRESSION__DST:
				setDst((BasicMemoryAddress)null);
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
			case SimdExpPackage.VSTORE_EXPRESSION__SRC:
				return src != null;
			case SimdExpPackage.VSTORE_EXPRESSION__DST:
				return dst != null;
		}
		return super.eIsSet(featureID);
	}

} //VStoreExpressionImpl
