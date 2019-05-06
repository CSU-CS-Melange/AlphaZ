/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TypeImpl#getSigned <em>Signed</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TypeImpl#getTypeID <em>Type ID</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TypeImpl#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends EObjectImpl implements Type {
	/**
	 * The default value of the '{@link #getSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigned()
	 * @generated
	 * @ordered
	 */
	protected static final SIGNED SIGNED_EDEFAULT = SIGNED.SIGNED;

	/**
	 * The cached value of the '{@link #getSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigned()
	 * @generated
	 * @ordered
	 */
	protected SIGNED signed = SIGNED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeID() <em>Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final DATATYPE TYPE_ID_EDEFAULT = DATATYPE.INTEGER;

	/**
	 * The cached value of the '{@link #getTypeID() <em>Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeID()
	 * @generated
	 * @ordered
	 */
	protected DATATYPE typeID = TYPE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIGNED getSigned() {
		return signed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigned(SIGNED newSigned) {
		SIGNED oldSigned = signed;
		signed = newSigned == null ? SIGNED_EDEFAULT : newSigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TYPE__SIGNED, oldSigned, signed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DATATYPE getTypeID() {
		return typeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeID(DATATYPE newTypeID) {
		DATATYPE oldTypeID = typeID;
		typeID = newTypeID == null ? TYPE_ID_EDEFAULT : newTypeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TYPE__TYPE_ID, oldTypeID, typeID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TYPE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCName() {
		switch (getTypeID()) {
			case INTEGER:
				String sign;
				if (getSigned() == SIGNED.SIGNED) {
					sign = "";
				} else {
					sign = "unsigned ";
				}
				if (width == DATATYPE.SHORT_WIDTH) {
					return sign + "short";
				} else if (width == DATATYPE.INT_WIDTH) {
					return sign + "int";
				} else if (width == DATATYPE.LONG_WIDTH) {
					return sign + "long";
				}
				break;
			case FLOATING_POINT:
				if (width == DATATYPE.LONG_WIDTH) {
					return "double";
				} else {
					return "float";
				}
			case BOOL:
				return "bool";
			case CHAR:
				return "char";
		}
		
		throw new RuntimeException("Unhandled type " + this + " encountered.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyhedralIRPackage.TYPE__SIGNED:
				return getSigned();
			case PolyhedralIRPackage.TYPE__TYPE_ID:
				return getTypeID();
			case PolyhedralIRPackage.TYPE__WIDTH:
				return getWidth();
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
			case PolyhedralIRPackage.TYPE__SIGNED:
				setSigned((SIGNED)newValue);
				return;
			case PolyhedralIRPackage.TYPE__TYPE_ID:
				setTypeID((DATATYPE)newValue);
				return;
			case PolyhedralIRPackage.TYPE__WIDTH:
				setWidth((Integer)newValue);
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
			case PolyhedralIRPackage.TYPE__SIGNED:
				setSigned(SIGNED_EDEFAULT);
				return;
			case PolyhedralIRPackage.TYPE__TYPE_ID:
				setTypeID(TYPE_ID_EDEFAULT);
				return;
			case PolyhedralIRPackage.TYPE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
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
			case PolyhedralIRPackage.TYPE__SIGNED:
				return signed != SIGNED_EDEFAULT;
			case PolyhedralIRPackage.TYPE__TYPE_ID:
				return typeID != TYPE_ID_EDEFAULT;
			case PolyhedralIRPackage.TYPE__WIDTH:
				return width != WIDTH_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String toString() {
		return PolyhedralIRToAlphabets.toString(this);
		
		//return signed+" "+typeID;
		/*
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (signed: ");
		result.append(signed);
		result.append(", typeID: ");
		result.append(typeID);
		result.append(')');
		return result.toString();*/
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCPrintfSpecifier() {
		String length = "";
		if (getWidth() == DATATYPE.LONG_WIDTH) {
			length = "l";
		} else if (getWidth() == DATATYPE.SHORT_WIDTH) {
			length = "h";
		}
		
		switch (getTypeID()) {
			case INTEGER:
				if (getSigned() == SIGNED.SIGNED) {
					return "%"+length+"d";
				} else {
					return "%"+length+"u";
				}
			case FLOATING_POINT:
				return "%0.2"+length+"f";
			case BOOL:
				return "%d";
			case CHAR:
				return "%c";
		}
		
		throw new RuntimeException("Unhandled type " + this + " encountered.");
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCScanfSpecifier() {
		switch (getTypeID()) {
			case INTEGER:
			case BOOL:
			case CHAR:
				return getCPrintfSpecifier();
			case FLOATING_POINT:
				String length = "";
				if (getWidth() == DATATYPE.LONG_WIDTH) {
					length = "l";
				} else if (getWidth() == DATATYPE.SHORT_WIDTH) {
					length = "h";
				}
				return "%"+length+"f";
		}
		
		throw new RuntimeException("Unhandled type " + this + " encountered.");
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCScanfPostProcess() {
		switch (getTypeID()) {
			case INTEGER:
			case BOOL:
			case FLOATING_POINT:
				return "";
			case CHAR:
				return "; char c; while((c=getchar())!=-1 && c !="  + "'" + "\\" + "n" + "'" + ")";
		}
		
		throw new RuntimeException("Unhandled type " + this + " encountered.");
	}

} //TypeImpl
