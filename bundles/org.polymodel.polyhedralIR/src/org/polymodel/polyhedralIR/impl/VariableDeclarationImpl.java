/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.VariableDeclarationImpl#getVarID <em>Var ID</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.VariableDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.VariableDeclarationImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationImpl extends EObjectImpl implements VariableDeclaration {
	/**
	 * The cached value of the '{@link #getVarID() <em>Var ID</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarID()
	 * @generated
	 * @ordered
	 */
	protected VariableIdentifier varID;

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
	protected Domain domain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getVariableDeclaration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableIdentifier getVarID() {
		return varID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarID(VariableIdentifier newVarID, NotificationChain msgs) {
		VariableIdentifier oldVarID = varID;
		varID = newVarID;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID, oldVarID, newVarID);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarID(VariableIdentifier newVarID) {
		if (newVarID != varID) {
			NotificationChain msgs = null;
			if (varID != null)
				msgs = ((InternalEObject)varID).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID, null, msgs);
			if (newVarID != null)
				msgs = ((InternalEObject)newVarID).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID, null, msgs);
			msgs = basicSetVarID(newVarID, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID, newVarID, newVarID));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(Domain newDomain, NotificationChain msgs) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN, oldDomain, newDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		if (newDomain != domain) {
			NotificationChain msgs = null;
			if (domain != null)
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return getVarID().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInput() {
		if (eContainer() instanceof AffineSystem) {
			return ((AffineSystem)eContainer()).getInputs().contains(this);
		} else {
			throw new RuntimeException("VariableDeclaration not contained by AffineSystem");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOutput() {
		if (eContainer() instanceof AffineSystem) {
			return ((AffineSystem)eContainer()).getOutputs().contains(this);
		} else {
			throw new RuntimeException("VariableDeclaration not contained by AffineSystem");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLocal() {
		if (eContainer() instanceof AffineSystem) {
			return ((AffineSystem)eContainer()).getLocals().contains(this);
		} else {
			throw new RuntimeException("VariableDeclaration not contained by AffineSystem");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitVariableDeclaration(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID:
				return basicSetVarID(null, msgs);
			case PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN:
				return basicSetDomain(null, msgs);
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
			case PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID:
				return getVarID();
			case PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN:
				return getDomain();
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
			case PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID:
				setVarID((VariableIdentifier)newValue);
				return;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE:
				setType((Type)newValue);
				return;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN:
				setDomain((Domain)newValue);
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
			case PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID:
				setVarID((VariableIdentifier)null);
				return;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE:
				setType((Type)null);
				return;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN:
				setDomain((Domain)null);
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
			case PolyhedralIRPackage.VARIABLE_DECLARATION__VAR_ID:
				return varID != null;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__TYPE:
				return type != null;
			case PolyhedralIRPackage.VARIABLE_DECLARATION__DOMAIN:
				return domain != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return getVarID().getName() + ":" + domain + " of " +type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VariableDeclaration) {
			boolean nameMatch = ((VariableDeclaration) obj).getVarID().equals(this.getVarID());
			boolean domainMatch = ((VariableDeclaration) obj).getDomain().equals(this.getDomain());
			boolean typeMatch = ((VariableDeclaration) obj).getType().equals(this.getType());
	
			return nameMatch && domainMatch && typeMatch;
		}
		
		return super.equals(obj);
	}

} //VariableDeclarationImpl
