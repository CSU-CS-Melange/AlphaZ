/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space Time Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl#getInverseOfMapping <em>Inverse Of Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpaceTimeMapImpl extends EObjectImpl implements SpaceTimeMap {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction mapping;

	/**
	 * The cached value of the '{@link #getInverseOfMapping() <em>Inverse Of Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseOfMapping()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction inverseOfMapping;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpaceTimeMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.SPACE_TIME_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(AffineFunction newMapping, NotificationChain msgs) {
		AffineFunction oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_MAP__MAPPING, oldMapping, newMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(AffineFunction newMapping) {
		if (newMapping != mapping) {
			NotificationChain msgs = null;
			if (mapping != null)
				msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SPACE_TIME_MAP__MAPPING, null, msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SPACE_TIME_MAP__MAPPING, null, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_MAP__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getInverseOfMapping() {
		return inverseOfMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInverseOfMapping(AffineFunction newInverseOfMapping, NotificationChain msgs) {
		AffineFunction oldInverseOfMapping = inverseOfMapping;
		inverseOfMapping = newInverseOfMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING, oldInverseOfMapping, newInverseOfMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseOfMapping(AffineFunction newInverseOfMapping) {
		if (newInverseOfMapping != inverseOfMapping) {
			NotificationChain msgs = null;
			if (inverseOfMapping != null)
				msgs = ((InternalEObject)inverseOfMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING, null, msgs);
			if (newInverseOfMapping != null)
				msgs = ((InternalEObject)newInverseOfMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING, null, msgs);
			msgs = basicSetInverseOfMapping(newInverseOfMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING, newInverseOfMapping, newInverseOfMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_MAP__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitSpaceTimeMap(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.SPACE_TIME_MAP__MAPPING:
				return basicSetMapping(null, msgs);
			case TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING:
				return basicSetInverseOfMapping(null, msgs);
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
			case TargetMappingPackage.SPACE_TIME_MAP__MAPPING:
				return getMapping();
			case TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING:
				return getInverseOfMapping();
			case TargetMappingPackage.SPACE_TIME_MAP__LABEL:
				return getLabel();
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
			case TargetMappingPackage.SPACE_TIME_MAP__MAPPING:
				setMapping((AffineFunction)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING:
				setInverseOfMapping((AffineFunction)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_MAP__LABEL:
				setLabel((String)newValue);
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
			case TargetMappingPackage.SPACE_TIME_MAP__MAPPING:
				setMapping((AffineFunction)null);
				return;
			case TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING:
				setInverseOfMapping((AffineFunction)null);
				return;
			case TargetMappingPackage.SPACE_TIME_MAP__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case TargetMappingPackage.SPACE_TIME_MAP__MAPPING:
				return mapping != null;
			case TargetMappingPackage.SPACE_TIME_MAP__INVERSE_OF_MAPPING:
				return inverseOfMapping != null;
			case TargetMappingPackage.SPACE_TIME_MAP__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(" (label: ");
		result.append(label);
		result.append(" mapping: " + this.mapping);
		result.append(')');
		return result.toString();
	}

} //SpaceTimeMapImpl
