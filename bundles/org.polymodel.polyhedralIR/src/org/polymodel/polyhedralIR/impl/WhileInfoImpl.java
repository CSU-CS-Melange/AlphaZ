/**
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
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.WhileInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.WhileInfoImpl#getTimeDomain <em>Time Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.WhileInfoImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.WhileInfoImpl#getContainerSystem <em>Container System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileInfoImpl extends EObjectImpl implements WhileInfo {
	/**
	 * The cached value of the '{@link #getTimeDomain() <em>Time Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain timeDomain;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getContainerSystem() <em>Container System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerSystem()
	 * @generated
	 * @ordered
	 */
	protected AffineSystem containerSystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getWhileInfo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getTimeDomain() {
		if (timeDomain != null && timeDomain.eIsProxy()) {
			InternalEObject oldTimeDomain = (InternalEObject)timeDomain;
			timeDomain = (Domain)eResolveProxy(oldTimeDomain);
			if (timeDomain != oldTimeDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN, oldTimeDomain, timeDomain));
			}
		}
		return timeDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetTimeDomain() {
		return timeDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeDomain(Domain newTimeDomain) {
		Domain oldTimeDomain = timeDomain;
		timeDomain = newTimeDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN, oldTimeDomain, timeDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.WHILE_INFO__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.WHILE_INFO__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.WHILE_INFO__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.WHILE_INFO__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem getContainerSystem() {
		if (containerSystem != null && containerSystem.eIsProxy()) {
			InternalEObject oldContainerSystem = (InternalEObject)containerSystem;
			containerSystem = (AffineSystem)eResolveProxy(oldContainerSystem);
			if (containerSystem != oldContainerSystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM, oldContainerSystem, containerSystem));
			}
		}
		return containerSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem basicGetContainerSystem() {
		return containerSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerSystem(AffineSystem newContainerSystem) {
		AffineSystem oldContainerSystem = containerSystem;
		containerSystem = newContainerSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM, oldContainerSystem, containerSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitWhileInfo(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.WHILE_INFO__CONDITION:
				return basicSetCondition(null, msgs);
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
			case PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN:
				if (resolve) return getTimeDomain();
				return basicGetTimeDomain();
			case PolyhedralIRPackage.WHILE_INFO__CONDITION:
				return getCondition();
			case PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM:
				if (resolve) return getContainerSystem();
				return basicGetContainerSystem();
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
			case PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN:
				setTimeDomain((Domain)newValue);
				return;
			case PolyhedralIRPackage.WHILE_INFO__CONDITION:
				setCondition((Expression)newValue);
				return;
			case PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM:
				setContainerSystem((AffineSystem)newValue);
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
			case PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN:
				setTimeDomain((Domain)null);
				return;
			case PolyhedralIRPackage.WHILE_INFO__CONDITION:
				setCondition((Expression)null);
				return;
			case PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM:
				setContainerSystem((AffineSystem)null);
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
			case PolyhedralIRPackage.WHILE_INFO__TIME_DOMAIN:
				return timeDomain != null;
			case PolyhedralIRPackage.WHILE_INFO__CONDITION:
				return condition != null;
			case PolyhedralIRPackage.WHILE_INFO__CONTAINER_SYSTEM:
				return containerSystem != null;
		}
		return super.eIsSet(featureID);
	}

} //WhileInfoImpl
