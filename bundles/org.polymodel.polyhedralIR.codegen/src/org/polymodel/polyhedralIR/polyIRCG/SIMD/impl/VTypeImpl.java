/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDInstructionUtility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VType</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl#getIns <em>Ins</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VTypeImpl extends EObjectImpl implements VType {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final SIMD_WIDTH WIDTH_EDEFAULT = SIMD_WIDTH.M128;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected SIMD_WIDTH width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getIns() <em>Ins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIns()
	 * @generated
	 * @ordered
	 */
	protected static final SIMD_INS INS_EDEFAULT = SIMD_INS.SSE;

	/**
	 * The cached value of the '{@link #getIns() <em>Ins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIns()
	 * @generated
	 * @ordered
	 */
	protected SIMD_INS ins = INS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.VTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SIMDPackage.VTYPE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VTYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMD_WIDTH getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(SIMD_WIDTH newWidth) {
		SIMD_WIDTH oldWidth = width;
		width = newWidth == null ? WIDTH_EDEFAULT : newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VTYPE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMD_INS getIns() {
		return ins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIns(SIMD_INS newIns) {
		SIMD_INS oldIns = ins;
		ins = newIns == null ? INS_EDEFAULT : newIns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.VTYPE__INS, oldIns, ins));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSIMDName() {
		String dataType = getType().getCName();
		String regType = "";
		switch(getWidth().getValue()){
		case SIMD_WIDTH.M128_VALUE:
			if(dataType == "int")
				regType = SIMDInstructionUtility.int128;
			else if(dataType == "float")
				regType = SIMDInstructionUtility.float128;
			else 
				regType = SIMDInstructionUtility.double128;
			break;
		case SIMD_WIDTH.M256_VALUE:
			if(dataType == "int")
				regType = SIMDInstructionUtility.int256;
			else if(dataType == "float")
				regType = SIMDInstructionUtility.float256;
			else 
				regType = SIMDInstructionUtility.double256;
			break;
		default:
			break;
		}
		
		return regType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNElements() {
		SIMD_WIDTH simdWidth = getWidth();
		String datatype = getType().getCName();
		int length = 4;
		switch(simdWidth.getValue()){
		case SIMD_WIDTH.M128_VALUE:
			if(datatype == "int"){
				length = 4;
			}else if(datatype == "float") {
				length = 4;
			}else if(datatype == "double"){
				length = 2;
			}
			break;
		case SIMD_WIDTH.M256_VALUE:
			if(datatype == "int"){
				length = 8;
			}else if(datatype == "float"){
				length = 8;
			}else if(datatype == "double"){
				length = 4;
			}
			break;
		default:
			throw new RuntimeException("Unkown data type");
		}
		
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SIMDPackage.VTYPE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SIMDPackage.VTYPE__WIDTH:
				return getWidth();
			case SIMDPackage.VTYPE__INS:
				return getIns();
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
			case SIMDPackage.VTYPE__TYPE:
				setType((Type)newValue);
				return;
			case SIMDPackage.VTYPE__WIDTH:
				setWidth((SIMD_WIDTH)newValue);
				return;
			case SIMDPackage.VTYPE__INS:
				setIns((SIMD_INS)newValue);
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
			case SIMDPackage.VTYPE__TYPE:
				setType((Type)null);
				return;
			case SIMDPackage.VTYPE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case SIMDPackage.VTYPE__INS:
				setIns(INS_EDEFAULT);
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
			case SIMDPackage.VTYPE__TYPE:
				return type != null;
			case SIMDPackage.VTYPE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case SIMDPackage.VTYPE__INS:
				return ins != INS_EDEFAULT;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", ins: ");
		result.append(ins);
		result.append(')');
		return result.toString();
	}

} //VTypeImpl
