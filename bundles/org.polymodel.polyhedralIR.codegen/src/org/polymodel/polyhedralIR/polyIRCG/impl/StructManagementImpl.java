/**
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.StructManagement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Management</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl#getStruct <em>Struct</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StructManagementImpl extends EObjectImpl implements StructManagement {
	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariable instance;

	/**
	 * The cached value of the '{@link #getStruct() <em>Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStruct()
	 * @generated
	 * @ordered
	 */
	protected Struct struct;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructManagementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.STRUCT_MANAGEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (AbstractVariable)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariable basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(AbstractVariable newInstance) {
		AbstractVariable oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Struct getStruct() {
		if (struct != null && struct.eIsProxy()) {
			InternalEObject oldStruct = (InternalEObject)struct;
			struct = (Struct)eResolveProxy(oldStruct);
			if (struct != oldStruct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT, oldStruct, struct));
			}
		}
		return struct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct basicGetStruct() {
		return struct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStruct(Struct newStruct) {
		Struct oldStruct = struct;
		struct = newStruct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT, oldStruct, struct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				return basicSetFunction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				return getFunction();
			case PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
			case PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT:
				if (resolve) return getStruct();
				return basicGetStruct();
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
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				setFunction((Function)newValue);
				return;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE:
				setInstance((AbstractVariable)newValue);
				return;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT:
				setStruct((Struct)newValue);
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
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				setFunction((Function)null);
				return;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE:
				setInstance((AbstractVariable)null);
				return;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT:
				setStruct((Struct)null);
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
			case PolyIRCGPackage.STRUCT_MANAGEMENT__FUNCTION:
				return getFunction() != null;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__INSTANCE:
				return instance != null;
			case PolyIRCGPackage.STRUCT_MANAGEMENT__STRUCT:
				return struct != null;
		}
		return super.eIsSet(featureID);
	}

} //StructManagementImpl
