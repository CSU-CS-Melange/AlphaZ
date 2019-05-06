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
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Unrolling Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.LoopUnrollingSpecificationImpl#getUnrollingFactors <em>Unrolling Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopUnrollingSpecificationImpl extends FeatureSpecificationImpl implements LoopUnrollingSpecification {
	/**
	 * The cached value of the '{@link #getUnrollingFactors() <em>Unrolling Factors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnrollingFactors()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> unrollingFactors;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopUnrollingSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.LOOP_UNROLLING_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getUnrollingFactors() {
		if (unrollingFactors == null) {
			unrollingFactors = new EDataTypeEList<Integer>(Integer.class, this, TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS);
		}
		return unrollingFactors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitLoopUnrollingSpecification(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS:
				return getUnrollingFactors();
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
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS:
				getUnrollingFactors().clear();
				getUnrollingFactors().addAll((Collection<? extends Integer>)newValue);
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
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS:
				getUnrollingFactors().clear();
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
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS:
				return unrollingFactors != null && !unrollingFactors.isEmpty();
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
		result.append(" (unrollingFactors: ");
		result.append(unrollingFactors);
		result.append(')');
		return result.toString();
	}

} //LoopUnrollingSpecificationImpl
