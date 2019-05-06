/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Gen Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#isAligned <em>Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#isFlattened <em>Flattened</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#getAccessExpression <em>Access Expression</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#isIsfrontpadded <em>Isfrontpadded</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl#getForntpaddingValue <em>Forntpadding Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeGenVariableImpl extends AbstractVariableImpl implements CodeGenVariable {
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
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected MemoryDomain domain;

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
	 * The default value of the '{@link #isFlattened() <em>Flattened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlattened()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLATTENED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlattened() <em>Flattened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlattened()
	 * @generated
	 * @ordered
	 */
	protected boolean flattened = FLATTENED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsfrontpadded() <em>Isfrontpadded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsfrontpadded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ISFRONTPADDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsfrontpadded() <em>Isfrontpadded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsfrontpadded()
	 * @generated
	 * @ordered
	 */
	protected boolean isfrontpadded = ISFRONTPADDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForntpaddingValue() <em>Forntpadding Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForntpaddingValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> forntpaddingValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeGenVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.CODE_GEN_VARIABLE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryDomain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(MemoryDomain newDomain, NotificationChain msgs) {
		MemoryDomain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN, oldDomain, newDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(MemoryDomain newDomain) {
		if (newDomain != domain) {
			NotificationChain msgs = null;
			if (domain != null)
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Flattened is only for 2D+ variables. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFlattened() {
		return flattened;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlattened(boolean newFlattened) {
		boolean oldFlattened = flattened;
		flattened = newFlattened;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED, oldFlattened, flattened));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MemoryAccessExpression getAccessExpression() {
		//TODO why do we need a loop here? Looks like redundant since loop 
		// iterator "i" is not used in the loop body.
		for (int i = 0; i < getDomain().getNIndices(); i++) {
			if (getDomain() instanceof PseudoProjection && 
					((PseudoProjection)getDomain()).isModFactorInEffect()) {				
				return PolyIRCGUserFactory.INSTANCE.createPseudoProjectiveExpression(this);
			}
		}
		return PolyIRCGUserFactory.INSTANCE.createIdentityAccessExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessExpression(MemoryAccessExpression newAccessExpression, NotificationChain msgs) {
		// TODO: implement this method to set the contained 'Access Expression' containment reference
		// -> this method is automatically invoked to keep the containment relationship in synch
		// -> do not modify other features
		// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsfrontpadded() {
		return isfrontpadded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsfrontpadded(boolean newIsfrontpadded) {
		boolean oldIsfrontpadded = isfrontpadded;
		isfrontpadded = newIsfrontpadded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED, oldIsfrontpadded, isfrontpadded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getForntpaddingValue() {
		if (forntpaddingValue == null) {
			forntpaddingValue = new EDataTypeEList<Integer>(Integer.class, this, PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE);
		}
		return forntpaddingValue;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED, oldAligned, aligned));
	}
	


	@Override
	public String asParameter() {
		//pass pointer for scalars
		//List<Variable> localVariable = ((FunctionSignature)this.eContainer()).getFunction().getLocals();
		if (getDomain().getNIndices() == 0) {
			return "&"+getName();
		} else {
			return getName();
		}
	}

	@Override
	public String asParameterType() {
		return getPointerType();		
	}
	
	@Override
	public String getPointerType() {
		//Scalar
		if (getDomain().getNIndices() == 0) {
//			get
			return getType().getCName()+"*";
		}
		//One-level if flattened
		if (isFlattened()) {
			return getType().getCName()+"*";
		}
		//Else the number of dimensions
		StringBuffer pointer = new StringBuffer(getType().getCName().toString());
		for (int i = 0; i < getDomain().getNIndices(); i++) {
			pointer.append("*");
		}
		
		return pointer.toString();
	}

	
	@Override
	public String getPrintfSpecifier() {
		String length = "";
		if (getType().getWidth() == DATATYPE.LONG_WIDTH) {
			length = "l";
		} else if (getType().getWidth() == DATATYPE.SHORT_WIDTH) {
			length = "h";
		}
		
		switch (getType().getTypeID()) {
			case INTEGER:
				if (getType().getSigned() == SIGNED.SIGNED) {
					return "%"+length+"d";
				} else {
					return "%"+length+"u";
				}
			case FLOATING_POINT:
				return "%"+length+"f";
			case BOOL:
				return "%d";
			case CHAR:
				return "%c";
		}
		
		throw new RuntimeException("Unhandled type " + getType() + " encountered.");
	}



	@Override
	public String getTypeString() {
		return getType().getCName();
	}

	public IntExpression getModFactor(int dim) {
		
		if (this.getDomain() instanceof PseudoProjection) {
			PseudoProjection pp = (PseudoProjection) getDomain();
			return pp.getModFactors().get(dim);
		}
		
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getVolumeExpression(int startingDim, int endingDim) {
		return getDomain().getVolumeExpression(startingDim, endingDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMPITypeString() {
		return "MPI_"+type.getCName().toUpperCase();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN:
				return basicSetDomain(null, msgs);
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ACCESS_EXPRESSION:
				return basicSetAccessExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN:
				return getDomain();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED:
				return isAligned();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED:
				return isFlattened();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ACCESS_EXPRESSION:
				return getAccessExpression();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED:
				return isIsfrontpadded();
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE:
				return getForntpaddingValue();
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
			case PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE:
				setType((Type)newValue);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN:
				setDomain((MemoryDomain)newValue);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED:
				setAligned((Boolean)newValue);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED:
				setFlattened((Boolean)newValue);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED:
				setIsfrontpadded((Boolean)newValue);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE:
				getForntpaddingValue().clear();
				getForntpaddingValue().addAll((Collection<? extends Integer>)newValue);
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
			case PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE:
				setType((Type)null);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN:
				setDomain((MemoryDomain)null);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED:
				setAligned(ALIGNED_EDEFAULT);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED:
				setFlattened(FLATTENED_EDEFAULT);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED:
				setIsfrontpadded(ISFRONTPADDED_EDEFAULT);
				return;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE:
				getForntpaddingValue().clear();
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
			case PolyIRCGPackage.CODE_GEN_VARIABLE__TYPE:
				return type != null;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__DOMAIN:
				return domain != null;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ALIGNED:
				return aligned != ALIGNED_EDEFAULT;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FLATTENED:
				return flattened != FLATTENED_EDEFAULT;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ACCESS_EXPRESSION:
				return getAccessExpression() != null;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__ISFRONTPADDED:
				return isfrontpadded != ISFRONTPADDED_EDEFAULT;
			case PolyIRCGPackage.CODE_GEN_VARIABLE__FORNTPADDING_VALUE:
				return forntpaddingValue != null && !forntpaddingValue.isEmpty();
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
		result.append(" (aligned: ");
		result.append(aligned);
		result.append(", flattened: ");
		result.append(flattened);
		result.append(", isfrontpadded: ");
		result.append(isfrontpadded);
		result.append(", forntpaddingValue: ");
		result.append(forntpaddingValue);
		result.append(')');
		return result.toString();
	}

} //CodeGenVariableImpl
