/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.scop.ScopRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scop Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ScopLoopImpl#getScopRoot <em>Scop Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopLoopImpl extends CLoopImpl implements ScopLoop {
	/**
	 * The cached value of the '{@link #getTiles() <em>Tiles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiles()
	 * @generated
	 * @ordered
	 */
	protected EList<TileSpecification> tiles;
	/**
	 * The cached value of the '{@link #getScopRoot() <em>Scop Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopRoot()
	 * @generated
	 * @ordered
	 */
	protected ScopRoot scopRoot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.SCOP_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TileSpecification> getTiles() {
		if (tiles == null) {
			tiles = new EObjectContainmentEList<TileSpecification>(TileSpecification.class, this, CPackage.SCOP_LOOP__TILES);
		}
		return tiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopRoot getScopRoot() {
		if (scopRoot != null && scopRoot.eIsProxy()) {
			InternalEObject oldScopRoot = (InternalEObject)scopRoot;
			scopRoot = (ScopRoot)eResolveProxy(oldScopRoot);
			if (scopRoot != oldScopRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.SCOP_LOOP__SCOP_ROOT, oldScopRoot, scopRoot));
			}
		}
		return scopRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopRoot basicGetScopRoot() {
		return scopRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopRoot(ScopRoot newScopRoot) {
		ScopRoot oldScopRoot = scopRoot;
		scopRoot = newScopRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SCOP_LOOP__SCOP_ROOT, oldScopRoot, scopRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CPackage.SCOP_LOOP__TILES:
				return ((InternalEList<?>)getTiles()).basicRemove(otherEnd, msgs);
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
			case CPackage.SCOP_LOOP__TILES:
				return getTiles();
			case CPackage.SCOP_LOOP__SCOP_ROOT:
				if (resolve) return getScopRoot();
				return basicGetScopRoot();
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
			case CPackage.SCOP_LOOP__TILES:
				getTiles().clear();
				getTiles().addAll((Collection<? extends TileSpecification>)newValue);
				return;
			case CPackage.SCOP_LOOP__SCOP_ROOT:
				setScopRoot((ScopRoot)newValue);
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
			case CPackage.SCOP_LOOP__TILES:
				getTiles().clear();
				return;
			case CPackage.SCOP_LOOP__SCOP_ROOT:
				setScopRoot((ScopRoot)null);
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
			case CPackage.SCOP_LOOP__TILES:
				return tiles != null && !tiles.isEmpty();
			case CPackage.SCOP_LOOP__SCOP_ROOT:
				return scopRoot != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public ScopRoot generateScop() {
		return getScopRoot();
	}

} //ScopLoopImpl
