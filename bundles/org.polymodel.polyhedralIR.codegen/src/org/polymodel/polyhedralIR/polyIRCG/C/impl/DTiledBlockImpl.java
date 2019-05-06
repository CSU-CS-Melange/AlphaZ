/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTiled Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl#getBlockStart <em>Block Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl#getPointLoopStart <em>Point Loop Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl#getTileLoopStart <em>Tile Loop Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl#getPerfectLoopNest <em>Perfect Loop Nest</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledBlockImpl#getContainerLoop <em>Container Loop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DTiledBlockImpl extends EObjectImpl implements DTiledBlock {
	/**
	 * The cached value of the '{@link #getBlockStart() <em>Block Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockStart()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode blockStart;

	/**
	 * The cached value of the '{@link #getPointLoopStart() <em>Point Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointLoopStart()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode pointLoopStart;

	/**
	 * The cached value of the '{@link #getTileLoopStart() <em>Tile Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileLoopStart()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode tileLoopStart;

	/**
	 * The cached value of the '{@link #getPerfectLoopNest() <em>Perfect Loop Nest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerfectLoopNest()
	 * @generated
	 * @ordered
	 */
	protected ScopFor perfectLoopNest;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTiledBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.DTILED_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getBlockStart() {
		if (blockStart != null && blockStart.eIsProxy()) {
			InternalEObject oldBlockStart = (InternalEObject)blockStart;
			blockStart = (AbstractScopNode)eResolveProxy(oldBlockStart);
			if (blockStart != oldBlockStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.DTILED_BLOCK__BLOCK_START, oldBlockStart, blockStart));
			}
		}
		return blockStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode basicGetBlockStart() {
		return blockStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockStart(AbstractScopNode newBlockStart) {
		AbstractScopNode oldBlockStart = blockStart;
		blockStart = newBlockStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_BLOCK__BLOCK_START, oldBlockStart, blockStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getPointLoopStart() {
		if (pointLoopStart != null && pointLoopStart.eIsProxy()) {
			InternalEObject oldPointLoopStart = (InternalEObject)pointLoopStart;
			pointLoopStart = (AbstractScopNode)eResolveProxy(oldPointLoopStart);
			if (pointLoopStart != oldPointLoopStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.DTILED_BLOCK__POINT_LOOP_START, oldPointLoopStart, pointLoopStart));
			}
		}
		return pointLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode basicGetPointLoopStart() {
		return pointLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointLoopStart(AbstractScopNode newPointLoopStart) {
		AbstractScopNode oldPointLoopStart = pointLoopStart;
		pointLoopStart = newPointLoopStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_BLOCK__POINT_LOOP_START, oldPointLoopStart, pointLoopStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getTileLoopStart() {
		if (tileLoopStart != null && tileLoopStart.eIsProxy()) {
			InternalEObject oldTileLoopStart = (InternalEObject)tileLoopStart;
			tileLoopStart = (AbstractScopNode)eResolveProxy(oldTileLoopStart);
			if (tileLoopStart != oldTileLoopStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.DTILED_BLOCK__TILE_LOOP_START, oldTileLoopStart, tileLoopStart));
			}
		}
		return tileLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode basicGetTileLoopStart() {
		return tileLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileLoopStart(AbstractScopNode newTileLoopStart) {
		AbstractScopNode oldTileLoopStart = tileLoopStart;
		tileLoopStart = newTileLoopStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_BLOCK__TILE_LOOP_START, oldTileLoopStart, tileLoopStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopFor getPerfectLoopNest() {
		return perfectLoopNest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerfectLoopNest(ScopFor newPerfectLoopNest, NotificationChain msgs) {
		ScopFor oldPerfectLoopNest = perfectLoopNest;
		perfectLoopNest = newPerfectLoopNest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST, oldPerfectLoopNest, newPerfectLoopNest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerfectLoopNest(ScopFor newPerfectLoopNest) {
		if (newPerfectLoopNest != perfectLoopNest) {
			NotificationChain msgs = null;
			if (perfectLoopNest != null)
				msgs = ((InternalEObject)perfectLoopNest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST, null, msgs);
			if (newPerfectLoopNest != null)
				msgs = ((InternalEObject)newPerfectLoopNest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST, null, msgs);
			msgs = basicSetPerfectLoopNest(newPerfectLoopNest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST, newPerfectLoopNest, newPerfectLoopNest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTiledLoop getContainerLoop() {
		if (eContainerFeatureID() != CPackage.DTILED_BLOCK__CONTAINER_LOOP) return null;
		return (DTiledLoop)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CPackage.DTILED_BLOCK__CONTAINER_LOOP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, CPackage.DTILED_BLOCK__CONTAINER_LOOP, msgs);
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
			case CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST:
				return basicSetPerfectLoopNest(null, msgs);
			case CPackage.DTILED_BLOCK__CONTAINER_LOOP:
				return eBasicSetContainer(null, CPackage.DTILED_BLOCK__CONTAINER_LOOP, msgs);
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
			case CPackage.DTILED_BLOCK__CONTAINER_LOOP:
				return eInternalContainer().eInverseRemove(this, CPackage.DTILED_LOOP__TILED_BLOCKS, DTiledLoop.class, msgs);
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
			case CPackage.DTILED_BLOCK__BLOCK_START:
				if (resolve) return getBlockStart();
				return basicGetBlockStart();
			case CPackage.DTILED_BLOCK__POINT_LOOP_START:
				if (resolve) return getPointLoopStart();
				return basicGetPointLoopStart();
			case CPackage.DTILED_BLOCK__TILE_LOOP_START:
				if (resolve) return getTileLoopStart();
				return basicGetTileLoopStart();
			case CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST:
				return getPerfectLoopNest();
			case CPackage.DTILED_BLOCK__CONTAINER_LOOP:
				return getContainerLoop();
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
			case CPackage.DTILED_BLOCK__BLOCK_START:
				setBlockStart((AbstractScopNode)newValue);
				return;
			case CPackage.DTILED_BLOCK__POINT_LOOP_START:
				setPointLoopStart((AbstractScopNode)newValue);
				return;
			case CPackage.DTILED_BLOCK__TILE_LOOP_START:
				setTileLoopStart((AbstractScopNode)newValue);
				return;
			case CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST:
				setPerfectLoopNest((ScopFor)newValue);
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
			case CPackage.DTILED_BLOCK__BLOCK_START:
				setBlockStart((AbstractScopNode)null);
				return;
			case CPackage.DTILED_BLOCK__POINT_LOOP_START:
				setPointLoopStart((AbstractScopNode)null);
				return;
			case CPackage.DTILED_BLOCK__TILE_LOOP_START:
				setTileLoopStart((AbstractScopNode)null);
				return;
			case CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST:
				setPerfectLoopNest((ScopFor)null);
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
			case CPackage.DTILED_BLOCK__BLOCK_START:
				return blockStart != null;
			case CPackage.DTILED_BLOCK__POINT_LOOP_START:
				return pointLoopStart != null;
			case CPackage.DTILED_BLOCK__TILE_LOOP_START:
				return tileLoopStart != null;
			case CPackage.DTILED_BLOCK__PERFECT_LOOP_NEST:
				return perfectLoopNest != null;
			case CPackage.DTILED_BLOCK__CONTAINER_LOOP:
				return getContainerLoop() != null;
		}
		return super.eIsSet(featureID);
	}

} //DTiledBlockImpl
