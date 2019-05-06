/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tile Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl#getEndDim <em>End Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl#getSubTiles <em>Sub Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TileSpecificationImpl#getOrderingPrefix <em>Ordering Prefix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TileSpecificationImpl extends EObjectImpl implements TileSpecification {
	/**
	 * The default value of the '{@link #getLevels() <em>Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevels()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVELS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevels() <em>Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevels()
	 * @generated
	 * @ordered
	 */
	protected int levels = LEVELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartDim() <em>Start Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDim()
	 * @generated
	 * @ordered
	 */
	protected static final int START_DIM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartDim() <em>Start Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDim()
	 * @generated
	 * @ordered
	 */
	protected int startDim = START_DIM_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDim() <em>End Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDim()
	 * @generated
	 * @ordered
	 */
	protected static final int END_DIM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndDim() <em>End Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDim()
	 * @generated
	 * @ordered
	 */
	protected int endDim = END_DIM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubTiles() <em>Sub Tiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTiles()
	 * @generated
	 * @ordered
	 */
	protected EList<SubTileSpecification> subTiles;

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
	protected TileSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.TILE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevels() {
		return levels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevels(int newLevels) {
		int oldLevels = levels;
		levels = newLevels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.TILE_SPECIFICATION__LEVELS, oldLevels, levels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartDim() {
		return startDim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDim(int newStartDim) {
		int oldStartDim = startDim;
		startDim = newStartDim;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.TILE_SPECIFICATION__START_DIM, oldStartDim, startDim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndDim() {
		return endDim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDim(int newEndDim) {
		int oldEndDim = endDim;
		endDim = newEndDim;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.TILE_SPECIFICATION__END_DIM, oldEndDim, endDim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubTileSpecification> getSubTiles() {
		if (subTiles == null) {
			subTiles = new EObjectResolvingEList<SubTileSpecification>(SubTileSpecification.class, this, CPackage.TILE_SPECIFICATION__SUB_TILES);
		}
		return subTiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOrderingPrefix() {
		if (orderingPrefix == null) {
			orderingPrefix = new EDataTypeUniqueEList<Integer>(Integer.class, this, CPackage.TILE_SPECIFICATION__ORDERING_PREFIX);
		}
		return orderingPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CPackage.TILE_SPECIFICATION__LEVELS:
				return getLevels();
			case CPackage.TILE_SPECIFICATION__START_DIM:
				return getStartDim();
			case CPackage.TILE_SPECIFICATION__END_DIM:
				return getEndDim();
			case CPackage.TILE_SPECIFICATION__SUB_TILES:
				return getSubTiles();
			case CPackage.TILE_SPECIFICATION__ORDERING_PREFIX:
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
			case CPackage.TILE_SPECIFICATION__LEVELS:
				setLevels((Integer)newValue);
				return;
			case CPackage.TILE_SPECIFICATION__START_DIM:
				setStartDim((Integer)newValue);
				return;
			case CPackage.TILE_SPECIFICATION__END_DIM:
				setEndDim((Integer)newValue);
				return;
			case CPackage.TILE_SPECIFICATION__SUB_TILES:
				getSubTiles().clear();
				getSubTiles().addAll((Collection<? extends SubTileSpecification>)newValue);
				return;
			case CPackage.TILE_SPECIFICATION__ORDERING_PREFIX:
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
			case CPackage.TILE_SPECIFICATION__LEVELS:
				setLevels(LEVELS_EDEFAULT);
				return;
			case CPackage.TILE_SPECIFICATION__START_DIM:
				setStartDim(START_DIM_EDEFAULT);
				return;
			case CPackage.TILE_SPECIFICATION__END_DIM:
				setEndDim(END_DIM_EDEFAULT);
				return;
			case CPackage.TILE_SPECIFICATION__SUB_TILES:
				getSubTiles().clear();
				return;
			case CPackage.TILE_SPECIFICATION__ORDERING_PREFIX:
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
			case CPackage.TILE_SPECIFICATION__LEVELS:
				return levels != LEVELS_EDEFAULT;
			case CPackage.TILE_SPECIFICATION__START_DIM:
				return startDim != START_DIM_EDEFAULT;
			case CPackage.TILE_SPECIFICATION__END_DIM:
				return endDim != END_DIM_EDEFAULT;
			case CPackage.TILE_SPECIFICATION__SUB_TILES:
				return subTiles != null && !subTiles.isEmpty();
			case CPackage.TILE_SPECIFICATION__ORDERING_PREFIX:
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
		result.append(" (levels: ");
		result.append(levels);
		result.append(", startDim: ");
		result.append(startDim);
		result.append(", endDim: ");
		result.append(endDim);
		result.append(", orderingPrefix: ");
		result.append(orderingPrefix);
		result.append(')');
		return result.toString();
	}

} //TileSpecificationImpl
