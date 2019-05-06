/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schedule Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl#getPrototypes <em>Prototypes</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl#getScalars <em>Scalars</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultidimSchedulePrototypeImpl extends EObjectImpl implements MultidimSchedulePrototype {
	/**
	 * The cached value of the '{@link #getPrototypes() <em>Prototypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrototypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulePrototype> prototypes;

	/**
	 * The cached value of the '{@link #getScalars() <em>Scalars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalars()
	 * @generated
	 * @ordered
	 */
	protected EList<ScalarSchedulePrototype> scalars;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected SchedulePrototype reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultidimSchedulePrototypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultidimPackage.Literals.MULTIDIM_SCHEDULE_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulePrototype> getPrototypes() {
		if (prototypes == null) {
			prototypes = new EObjectContainmentEList<SchedulePrototype>(SchedulePrototype.class, this, MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES);
		}
		return prototypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScalarSchedulePrototype> getScalars() {
		if (scalars == null) {
			scalars = new EObjectContainmentEList<ScalarSchedulePrototype>(ScalarSchedulePrototype.class, this, MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS);
		}
		return scalars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (SchedulePrototype)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(SchedulePrototype newReference) {
		SchedulePrototype oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES:
				return ((InternalEList<?>)getPrototypes()).basicRemove(otherEnd, msgs);
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS:
				return ((InternalEList<?>)getScalars()).basicRemove(otherEnd, msgs);
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
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES:
				return getPrototypes();
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS:
				return getScalars();
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
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
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES:
				getPrototypes().clear();
				getPrototypes().addAll((Collection<? extends SchedulePrototype>)newValue);
				return;
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS:
				getScalars().clear();
				getScalars().addAll((Collection<? extends ScalarSchedulePrototype>)newValue);
				return;
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE:
				setReference((SchedulePrototype)newValue);
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
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES:
				getPrototypes().clear();
				return;
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS:
				getScalars().clear();
				return;
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE:
				setReference((SchedulePrototype)null);
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
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES:
				return prototypes != null && !prototypes.isEmpty();
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS:
				return scalars != null && !scalars.isEmpty();
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE:
				return reference != null;
		}
		return super.eIsSet(featureID);
	}

} //MultidimSchedulePrototypeImpl
