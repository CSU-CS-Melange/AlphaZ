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
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Tile Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getTileSizes <em>Tile Sizes</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getTileType <em>Tile Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getTileIndexPrefix <em>Tile Index Prefix</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.SubTileSpecificationImpl#getTileSizePrefix <em>Tile Size Prefix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubTileSpecificationImpl extends EObjectImpl implements SubTileSpecification {
	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected int end = END_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTileSizes() <em>Tile Sizes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizes()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> tileSizes;

	/**
	 * The default value of the '{@link #getTileType() <em>Tile Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileType()
	 * @generated
	 * @ordered
	 */
	protected static final TILING_TYPE TILE_TYPE_EDEFAULT = TILING_TYPE.SEQUENTIAL;

	/**
	 * The cached value of the '{@link #getTileType() <em>Tile Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileType()
	 * @generated
	 * @ordered
	 */
	protected TILING_TYPE tileType = TILE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTileIndexPrefix() <em>Tile Index Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileIndexPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String TILE_INDEX_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTileIndexPrefix() <em>Tile Index Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileIndexPrefix()
	 * @generated
	 * @ordered
	 */
	protected String tileIndexPrefix = TILE_INDEX_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTileSizePrefix() <em>Tile Size Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String TILE_SIZE_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTileSizePrefix() <em>Tile Size Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizePrefix()
	 * @generated
	 * @ordered
	 */
	protected String tileSizePrefix = TILE_SIZE_PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubTileSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.SUB_TILE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(int newEnd) {
		int oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getTileSizes() {
		if (tileSizes == null) {
			tileSizes = new EDataTypeUniqueEList<Integer>(Integer.class, this, CPackage.SUB_TILE_SPECIFICATION__TILE_SIZES);
		}
		return tileSizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TILING_TYPE getTileType() {
		return tileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileType(TILING_TYPE newTileType) {
		TILING_TYPE oldTileType = tileType;
		tileType = newTileType == null ? TILE_TYPE_EDEFAULT : newTileType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__TILE_TYPE, oldTileType, tileType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTileIndexPrefix() {
		return tileIndexPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileIndexPrefix(String newTileIndexPrefix) {
		String oldTileIndexPrefix = tileIndexPrefix;
		tileIndexPrefix = newTileIndexPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX, oldTileIndexPrefix, tileIndexPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTileSizePrefix() {
		return tileSizePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileSizePrefix(String newTileSizePrefix) {
		String oldTileSizePrefix = tileSizePrefix;
		tileSizePrefix = newTileSizePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX, oldTileSizePrefix, tileSizePrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CPackage.SUB_TILE_SPECIFICATION__LEVEL:
				return getLevel();
			case CPackage.SUB_TILE_SPECIFICATION__START:
				return getStart();
			case CPackage.SUB_TILE_SPECIFICATION__END:
				return getEnd();
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZES:
				return getTileSizes();
			case CPackage.SUB_TILE_SPECIFICATION__TILE_TYPE:
				return getTileType();
			case CPackage.SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX:
				return getTileIndexPrefix();
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX:
				return getTileSizePrefix();
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
			case CPackage.SUB_TILE_SPECIFICATION__LEVEL:
				setLevel((Integer)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__START:
				setStart((Integer)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__END:
				setEnd((Integer)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZES:
				getTileSizes().clear();
				getTileSizes().addAll((Collection<? extends Integer>)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_TYPE:
				setTileType((TILING_TYPE)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX:
				setTileIndexPrefix((String)newValue);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX:
				setTileSizePrefix((String)newValue);
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
			case CPackage.SUB_TILE_SPECIFICATION__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__START:
				setStart(START_EDEFAULT);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__END:
				setEnd(END_EDEFAULT);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZES:
				getTileSizes().clear();
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_TYPE:
				setTileType(TILE_TYPE_EDEFAULT);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX:
				setTileIndexPrefix(TILE_INDEX_PREFIX_EDEFAULT);
				return;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX:
				setTileSizePrefix(TILE_SIZE_PREFIX_EDEFAULT);
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
			case CPackage.SUB_TILE_SPECIFICATION__LEVEL:
				return level != LEVEL_EDEFAULT;
			case CPackage.SUB_TILE_SPECIFICATION__START:
				return start != START_EDEFAULT;
			case CPackage.SUB_TILE_SPECIFICATION__END:
				return end != END_EDEFAULT;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZES:
				return tileSizes != null && !tileSizes.isEmpty();
			case CPackage.SUB_TILE_SPECIFICATION__TILE_TYPE:
				return tileType != TILE_TYPE_EDEFAULT;
			case CPackage.SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX:
				return TILE_INDEX_PREFIX_EDEFAULT == null ? tileIndexPrefix != null : !TILE_INDEX_PREFIX_EDEFAULT.equals(tileIndexPrefix);
			case CPackage.SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX:
				return TILE_SIZE_PREFIX_EDEFAULT == null ? tileSizePrefix != null : !TILE_SIZE_PREFIX_EDEFAULT.equals(tileSizePrefix);
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
		result.append(" (level: ");
		result.append(level);
		result.append(", start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", tileSizes: ");
		result.append(tileSizes);
		result.append(", tileType: ");
		result.append(tileType);
		result.append(", tileIndexPrefix: ");
		result.append(tileIndexPrefix);
		result.append(", tileSizePrefix: ");
		result.append(tileSizePrefix);
		result.append(')');
		return result.toString();
	}

} //SubTileSpecificationImpl
