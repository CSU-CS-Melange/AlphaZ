/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Memory Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl#getVar <em>Var</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl#isAligned <em>Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl#isIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicMemoryAddressImpl extends EObjectImpl implements BasicMemoryAddress {
	/**
	 * The cached value of the '{@link #getVar() <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
	protected CodeGenVariable var;

	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction access;

	/**
	 * The default value of the '{@link #isAligned() <em>Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAligned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALIGNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAligned() <em>Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAligned()
	 * @generated
	 * @ordered
	 */
	protected boolean aligned = ALIGNED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPointer() <em>Is Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPointer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_POINTER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPointer() <em>Is Pointer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPointer()
	 * @generated
	 * @ordered
	 */
	protected boolean isPointer = IS_POINTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicMemoryAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimdExpPackage.Literals.BASIC_MEMORY_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable getVar() {
		if (var != null && var.eIsProxy()) {
			InternalEObject oldVar = (InternalEObject)var;
			var = (CodeGenVariable)eResolveProxy(oldVar);
			if (var != oldVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR, oldVar, var));
			}
		}
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable basicGetVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVar(CodeGenVariable newVar) {
		CodeGenVariable oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getAccess() {
		if (access != null && access.eIsProxy()) {
			InternalEObject oldAccess = (InternalEObject)access;
			access = (AffineFunction)eResolveProxy(oldAccess);
			if (access != oldAccess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS, oldAccess, access));
			}
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction basicGetAccess() {
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccess(AffineFunction newAccess) {
		AffineFunction oldAccess = access;
		access = newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAligned() {
		return aligned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAligned(boolean newAligned) {
		boolean oldAligned = aligned;
		aligned = newAligned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.BASIC_MEMORY_ADDRESS__ALIGNED, oldAligned, aligned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPointer() {
		return isPointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPointer(boolean newIsPointer) {
		boolean oldIsPointer = isPointer;
		isPointer = newIsPointer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimdExpPackage.BASIC_MEMORY_ADDRESS__IS_POINTER, oldIsPointer, isPointer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR:
				if (resolve) return getVar();
				return basicGetVar();
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS:
				if (resolve) return getAccess();
				return basicGetAccess();
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ALIGNED:
				return isAligned();
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__IS_POINTER:
				return isIsPointer();
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
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR:
				setVar((CodeGenVariable)newValue);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS:
				setAccess((AffineFunction)newValue);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ALIGNED:
				setAligned((Boolean)newValue);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__IS_POINTER:
				setIsPointer((Boolean)newValue);
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
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR:
				setVar((CodeGenVariable)null);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS:
				setAccess((AffineFunction)null);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ALIGNED:
				setAligned(ALIGNED_EDEFAULT);
				return;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__IS_POINTER:
				setIsPointer(IS_POINTER_EDEFAULT);
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
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__VAR:
				return var != null;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ACCESS:
				return access != null;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__ALIGNED:
				return aligned != ALIGNED_EDEFAULT;
			case SimdExpPackage.BASIC_MEMORY_ADDRESS__IS_POINTER:
				return isPointer != IS_POINTER_EDEFAULT;
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
		result.append(" (aligned: ");
		result.append(aligned);
		result.append(", isPointer: ");
		result.append(isPointer);
		result.append(')');
		return result.toString();
	}

} //BasicMemoryAddressImpl
