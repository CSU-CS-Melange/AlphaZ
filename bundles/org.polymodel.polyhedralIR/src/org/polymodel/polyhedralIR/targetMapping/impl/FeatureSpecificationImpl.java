/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.FeatureSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.FeatureSpecificationImpl#getOrderingPrefix <em>Ordering Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureSpecificationImpl extends EObjectImpl implements FeatureSpecification {
	/**
	 * The cached value of the '{@link #getOrderingPrefix() <em>Ordering Prefix</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderingPrefix()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> orderingPrefix;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.FEATURE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOrderingPrefix() {
		if (orderingPrefix == null) {
			orderingPrefix = new EDataTypeUniqueEList<Integer>(Integer.class, this, TargetMappingPackage.FEATURE_SPECIFICATION__ORDERING_PREFIX);
		}
		return orderingPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitFeatureSpecification(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetMappingPackage.FEATURE_SPECIFICATION__ORDERING_PREFIX:
				return getOrderingPrefix();
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
			case TargetMappingPackage.FEATURE_SPECIFICATION__ORDERING_PREFIX:
				getOrderingPrefix().clear();
				getOrderingPrefix().addAll((Collection<? extends Integer>)newValue);
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
			case TargetMappingPackage.FEATURE_SPECIFICATION__ORDERING_PREFIX:
				getOrderingPrefix().clear();
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
			case TargetMappingPackage.FEATURE_SPECIFICATION__ORDERING_PREFIX:
				return orderingPrefix != null && !orderingPrefix.isEmpty();
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
		result.append(" (orderingPrefix: ");
		result.append(orderingPrefix);
		result.append(')');
		return result.toString();
	}

} //FeatureSpecificationImpl
