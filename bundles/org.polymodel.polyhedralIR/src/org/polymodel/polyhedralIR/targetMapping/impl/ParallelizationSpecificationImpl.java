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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallelization Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.ParallelizationSpecificationImpl#getParallelDims <em>Parallel Dims</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParallelizationSpecificationImpl extends FeatureSpecificationImpl implements ParallelizationSpecification {
	/**
	 * The cached value of the '{@link #getParallelDims() <em>Parallel Dims</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallelDims()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> parallelDims;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelizationSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.PARALLELIZATION_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getParallelDims() {
		if (parallelDims == null) {
			parallelDims = new EDataTypeUniqueEList<Integer>(Integer.class, this, TargetMappingPackage.PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS);
		}
		return parallelDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitParallelizationSpecification(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS:
				return getParallelDims();
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
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS:
				getParallelDims().clear();
				getParallelDims().addAll((Collection<? extends Integer>)newValue);
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
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS:
				getParallelDims().clear();
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
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS:
				return parallelDims != null && !parallelDims.isEmpty();
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
		result.append(" (parallelDims: ");
		result.append(parallelDims);
		result.append(')');
		return result.toString();
	}

} //ParallelizationSpecificationImpl
