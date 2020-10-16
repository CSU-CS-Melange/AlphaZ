/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distributed Pseudo Projection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl#getDistributedDims <em>Distributed Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl#getDistributedDimSizes <em>Distributed Dim Sizes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DistributedPseudoProjectionImpl extends PseudoProjectionImpl implements DistributedPseudoProjection {
	/**
	 * The cached value of the '{@link #getDistributedDims() <em>Distributed Dims</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributedDims()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> distributedDims;

	/**
	 * The cached value of the '{@link #getDistributedDimSizes() <em>Distributed Dim Sizes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributedDimSizes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> distributedDimSizes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributedPseudoProjectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.DISTRIBUTED_PSEUDO_PROJECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getDistributedDims() {
		if (distributedDims == null) {
			distributedDims = new EDataTypeUniqueEList<Integer>(Integer.class, this, CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS);
		}
		return distributedDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getDistributedDimSizes() {
		if (distributedDimSizes == null) {
			distributedDimSizes = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES);
		}
		return distributedDimSizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES:
				return ((InternalEList<?>)getDistributedDimSizes()).basicRemove(otherEnd, msgs);
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
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS:
				return getDistributedDims();
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES:
				return getDistributedDimSizes();
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
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS:
				getDistributedDims().clear();
				getDistributedDims().addAll((Collection<? extends Integer>)newValue);
				return;
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES:
				getDistributedDimSizes().clear();
				getDistributedDimSizes().addAll((Collection<? extends IntExpression>)newValue);
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
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS:
				getDistributedDims().clear();
				return;
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES:
				getDistributedDimSizes().clear();
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
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS:
				return distributedDims != null && !distributedDims.isEmpty();
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES:
				return distributedDimSizes != null && !distributedDimSizes.isEmpty();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (distributedDims: ");
		result.append(distributedDims);
		result.append(')');
		return result.toString();
	}

	@Override
	public EList<IntExpression> getBounds(int dim) {
		if (getDistributedDims().contains(dim)) {
			EList<IntExpression> lbub = new BasicEList<IntExpression>(2);

			lbub.add(IntExpressionBuilder.constant(0));
			//because things start from 0, the UB is shifted down by 1
			lbub.add(IntExpressionBuilder.sum(getDistributedDimSizes().get(getDistributedDims().indexOf(dim)).copy(), IntExpressionBuilder.constant(-1)));
			
			return lbub;
		} else {
			return super.getBounds(dim);
		}
	}
	
} //DistributedPseudoProjectionImpl
