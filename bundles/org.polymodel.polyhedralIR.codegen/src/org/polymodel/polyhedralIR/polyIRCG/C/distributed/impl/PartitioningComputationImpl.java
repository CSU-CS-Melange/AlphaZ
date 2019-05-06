/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partitioning Computation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl#getPartitionedTile <em>Partitioned Tile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartitioningComputationImpl extends EObjectImpl implements PartitioningComputation {
	/**
	 * The cached value of the '{@link #getPartitionedTile() <em>Partitioned Tile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionedTile()
	 * @generated
	 * @ordered
	 */
	protected TiledCLoop partitionedTile;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitioningComputationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.PARTITIONING_COMPUTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION && newFunction != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledCLoop getPartitionedTile() {
		if (partitionedTile != null && partitionedTile.eIsProxy()) {
			InternalEObject oldPartitionedTile = (InternalEObject)partitionedTile;
			partitionedTile = (TiledCLoop)eResolveProxy(oldPartitionedTile);
			if (partitionedTile != oldPartitionedTile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE, oldPartitionedTile, partitionedTile));
			}
		}
		return partitionedTile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledCLoop basicGetPartitionedTile() {
		return partitionedTile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionedTile(TiledCLoop newPartitionedTile) {
		TiledCLoop oldPartitionedTile = partitionedTile;
		partitionedTile = newPartitionedTile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE, oldPartitionedTile, partitionedTile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
				return getFunction();
			case CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE:
				if (resolve) return getPartitionedTile();
				return basicGetPartitionedTile();
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE:
				setPartitionedTile((TiledCLoop)newValue);
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
				setFunction((Function)null);
				return;
			case CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE:
				setPartitionedTile((TiledCLoop)null);
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
			case CDistributedPackage.PARTITIONING_COMPUTATION__FUNCTION:
				return getFunction() != null;
			case CDistributedPackage.PARTITIONING_COMPUTATION__PARTITIONED_TILE:
				return partitionedTile != null;
		}
		return super.eIsSet(featureID);
	}

} //PartitioningComputationImpl
