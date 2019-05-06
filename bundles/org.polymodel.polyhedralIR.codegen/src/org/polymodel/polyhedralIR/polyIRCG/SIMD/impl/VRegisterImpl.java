/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.impl.AbstractVariableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VRegister</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl#getVtype <em>Vtype</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VRegisterImpl extends AbstractVariableImpl implements VRegister {
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
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VRegisterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.VREGISTER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SIMDPackage.VREGISTER__VTYPE, oldVtype, vtype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VREGISTER__VTYPE, oldVtype, vtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (Function)eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SIMDPackage.VREGISTER__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VREGISTER__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRegTypeString() {
		String regType = "";
		String dataType = getVtype().getType().getCName();
		if(dataType == "int"){
			if(getVtype().getWidth() == SIMD_WIDTH.M128){
				regType = "__m128i";
			}else if(getVtype().getWidth() == SIMD_WIDTH.M256){
				regType = "__m256i";
			}
		}else if(dataType == "float"){
			if(getVtype().getWidth() == SIMD_WIDTH.M128){
				regType = "__m128";
			}else if(getVtype().getWidth() == SIMD_WIDTH.M256){
				regType = "__m256";
			}
		}else if(dataType == "double"){
			if(getVtype().getWidth() == SIMD_WIDTH.M128){
				regType = "__m128d";
			}else if(getVtype().getWidth() == SIMD_WIDTH.M256){
				regType = "__m256d";
			}
		}
		
		return regType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SIMDPackage.VREGISTER__VTYPE:
				if (resolve) return getVtype();
				return basicGetVtype();
			case SIMDPackage.VREGISTER__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
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
			case SIMDPackage.VREGISTER__VTYPE:
				setVtype((VType)newValue);
				return;
			case SIMDPackage.VREGISTER__FUNCTION:
				setFunction((Function)newValue);
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
			case SIMDPackage.VREGISTER__VTYPE:
				setVtype((VType)null);
				return;
			case SIMDPackage.VREGISTER__FUNCTION:
				setFunction((Function)null);
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
			case SIMDPackage.VREGISTER__VTYPE:
				return vtype != null;
			case SIMDPackage.VREGISTER__FUNCTION:
				return function != null;
		}
		return super.eIsSet(featureID);
	}

} //VRegisterImpl
