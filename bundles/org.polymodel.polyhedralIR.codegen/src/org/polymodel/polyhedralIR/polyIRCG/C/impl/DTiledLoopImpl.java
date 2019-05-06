/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTiled Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl#getScop <em>Scop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl#getTiledBlocks <em>Tiled Blocks</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl#getDtilingOptions <em>Dtiling Options</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.DTiledLoopImpl#getGeneratorLoop <em>Generator Loop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DTiledLoopImpl extends EObjectImpl implements DTiledLoop {
	/**
	 * The cached value of the '{@link #getScop() <em>Scop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScop()
	 * @generated
	 * @ordered
	 */
	protected ScopRoot scop;

	/**
	 * The cached value of the '{@link #getTiledBlocks() <em>Tiled Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiledBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<DTiledBlock> tiledBlocks;

	/**
	 * The default value of the '{@link #getDtilingOptions() <em>Dtiling Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtilingOptions()
	 * @generated
	 * @ordered
	 */
	protected static final DTilingOptions DTILING_OPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDtilingOptions() <em>Dtiling Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtilingOptions()
	 * @generated
	 * @ordered
	 */
	protected DTilingOptions dtilingOptions = DTILING_OPTIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGeneratorLoop() <em>Generator Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorLoop()
	 * @generated
	 * @ordered
	 */
	protected TiledCLoop generatorLoop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTiledLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.DTILED_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopRoot getScop() {
		return scop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScop(ScopRoot newScop, NotificationChain msgs) {
		ScopRoot oldScop = scop;
		scop = newScop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.DTILED_LOOP__SCOP, oldScop, newScop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScop(ScopRoot newScop) {
		if (newScop != scop) {
			NotificationChain msgs = null;
			if (scop != null)
				msgs = ((InternalEObject)scop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.DTILED_LOOP__SCOP, null, msgs);
			if (newScop != null)
				msgs = ((InternalEObject)newScop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.DTILED_LOOP__SCOP, null, msgs);
			msgs = basicSetScop(newScop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_LOOP__SCOP, newScop, newScop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DTiledBlock> getTiledBlocks() {
		if (tiledBlocks == null) {
			tiledBlocks = new EObjectContainmentWithInverseEList<DTiledBlock>(DTiledBlock.class, this, CPackage.DTILED_LOOP__TILED_BLOCKS, CPackage.DTILED_BLOCK__CONTAINER_LOOP);
		}
		return tiledBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTilingOptions getDtilingOptions() {
		return dtilingOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDtilingOptions(DTilingOptions newDtilingOptions) {
		DTilingOptions oldDtilingOptions = dtilingOptions;
		dtilingOptions = newDtilingOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_LOOP__DTILING_OPTIONS, oldDtilingOptions, dtilingOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledCLoop getGeneratorLoop() {
		if (generatorLoop != null && generatorLoop.eIsProxy()) {
			InternalEObject oldGeneratorLoop = (InternalEObject)generatorLoop;
			generatorLoop = (TiledCLoop)eResolveProxy(oldGeneratorLoop);
			if (generatorLoop != oldGeneratorLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.DTILED_LOOP__GENERATOR_LOOP, oldGeneratorLoop, generatorLoop));
			}
		}
		return generatorLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledCLoop basicGetGeneratorLoop() {
		return generatorLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratorLoop(TiledCLoop newGeneratorLoop) {
		TiledCLoop oldGeneratorLoop = generatorLoop;
		generatorLoop = newGeneratorLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DTILED_LOOP__GENERATOR_LOOP, oldGeneratorLoop, generatorLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTiledBlocks()).basicAdd(otherEnd, msgs);
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
			case CPackage.DTILED_LOOP__SCOP:
				return basicSetScop(null, msgs);
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				return ((InternalEList<?>)getTiledBlocks()).basicRemove(otherEnd, msgs);
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
			case CPackage.DTILED_LOOP__SCOP:
				return getScop();
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				return getTiledBlocks();
			case CPackage.DTILED_LOOP__DTILING_OPTIONS:
				return getDtilingOptions();
			case CPackage.DTILED_LOOP__GENERATOR_LOOP:
				if (resolve) return getGeneratorLoop();
				return basicGetGeneratorLoop();
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
			case CPackage.DTILED_LOOP__SCOP:
				setScop((ScopRoot)newValue);
				return;
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				getTiledBlocks().clear();
				getTiledBlocks().addAll((Collection<? extends DTiledBlock>)newValue);
				return;
			case CPackage.DTILED_LOOP__DTILING_OPTIONS:
				setDtilingOptions((DTilingOptions)newValue);
				return;
			case CPackage.DTILED_LOOP__GENERATOR_LOOP:
				setGeneratorLoop((TiledCLoop)newValue);
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
			case CPackage.DTILED_LOOP__SCOP:
				setScop((ScopRoot)null);
				return;
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				getTiledBlocks().clear();
				return;
			case CPackage.DTILED_LOOP__DTILING_OPTIONS:
				setDtilingOptions(DTILING_OPTIONS_EDEFAULT);
				return;
			case CPackage.DTILED_LOOP__GENERATOR_LOOP:
				setGeneratorLoop((TiledCLoop)null);
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
			case CPackage.DTILED_LOOP__SCOP:
				return scop != null;
			case CPackage.DTILED_LOOP__TILED_BLOCKS:
				return tiledBlocks != null && !tiledBlocks.isEmpty();
			case CPackage.DTILED_LOOP__DTILING_OPTIONS:
				return DTILING_OPTIONS_EDEFAULT == null ? dtilingOptions != null : !DTILING_OPTIONS_EDEFAULT.equals(dtilingOptions);
			case CPackage.DTILED_LOOP__GENERATOR_LOOP:
				return generatorLoop != null;
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
		result.append(" (dtilingOptions: ");
		result.append(dtilingOptions);
		result.append(')');
		return result.toString();
	}

} //DTiledLoopImpl
