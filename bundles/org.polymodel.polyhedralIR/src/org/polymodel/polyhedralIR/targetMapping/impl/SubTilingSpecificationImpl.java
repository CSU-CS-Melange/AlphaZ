/**
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Tiling Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getTileSizes <em>Tile Sizes</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getTileSizeType <em>Tile Size Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getTilingType <em>Tiling Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getCommunicationMapping <em>Communication Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl#getEndDim <em>End Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubTilingSpecificationImpl extends EObjectImpl implements SubTilingSpecification {
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
	 * The default value of the '{@link #getTileSizeType() <em>Tile Size Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizeType()
	 * @generated
	 * @ordered
	 */
	protected static final TILE_SIZE_TYPE TILE_SIZE_TYPE_EDEFAULT = TILE_SIZE_TYPE.PARAMETERIZED;

	/**
	 * The cached value of the '{@link #getTileSizeType() <em>Tile Size Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizeType()
	 * @generated
	 * @ordered
	 */
	protected TILE_SIZE_TYPE tileSizeType = TILE_SIZE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTilingType() <em>Tiling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTilingType()
	 * @generated
	 * @ordered
	 */
	protected static final TILING_TYPE TILING_TYPE_EDEFAULT = TILING_TYPE.SEQUENTIAL;

	/**
	 * The cached value of the '{@link #getTilingType() <em>Tiling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTilingType()
	 * @generated
	 * @ordered
	 */
	protected TILING_TYPE tilingType = TILING_TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getCommunicationMapping() <em>Communication Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationMapping()
	 * @generated
	 * @ordered
	 */
	protected CommunicationMappingForTiledSpace communicationMapping;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubTilingSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.SUB_TILING_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getTileSizes() {
		if (tileSizes == null) {
			tileSizes = new EDataTypeUniqueEList<Integer>(Integer.class, this, TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZES);
		}
		return tileSizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TILE_SIZE_TYPE getTileSizeType() {
		return tileSizeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileSizeType(TILE_SIZE_TYPE newTileSizeType) {
		TILE_SIZE_TYPE oldTileSizeType = tileSizeType;
		tileSizeType = newTileSizeType == null ? TILE_SIZE_TYPE_EDEFAULT : newTileSizeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE, oldTileSizeType, tileSizeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TILING_TYPE getTilingType() {
		return tilingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingType(TILING_TYPE newTilingType) {
		TILING_TYPE oldTilingType = tilingType;
		tilingType = newTilingType == null ? TILING_TYPE_EDEFAULT : newTilingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__TILING_TYPE, oldTilingType, tilingType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__START_DIM, oldStartDim, startDim));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationMappingForTiledSpace getCommunicationMapping() {
		return communicationMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommunicationMapping(CommunicationMappingForTiledSpace newCommunicationMapping, NotificationChain msgs) {
		CommunicationMappingForTiledSpace oldCommunicationMapping = communicationMapping;
		communicationMapping = newCommunicationMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING, oldCommunicationMapping, newCommunicationMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommunicationMapping(CommunicationMappingForTiledSpace newCommunicationMapping) {
		if (newCommunicationMapping != communicationMapping) {
			NotificationChain msgs = null;
			if (communicationMapping != null)
				msgs = ((InternalEObject)communicationMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING, null, msgs);
			if (newCommunicationMapping != null)
				msgs = ((InternalEObject)newCommunicationMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING, null, msgs);
			msgs = basicSetCommunicationMapping(newCommunicationMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING, newCommunicationMapping, newCommunicationMapping));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SUB_TILING_SPECIFICATION__END_DIM, oldEndDim, endDim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitSubTilingSpecification(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING:
				return basicSetCommunicationMapping(null, msgs);
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
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZES:
				return getTileSizes();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE:
				return getTileSizeType();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILING_TYPE:
				return getTilingType();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__START_DIM:
				return getStartDim();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__LEVEL:
				return getLevel();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING:
				return getCommunicationMapping();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__END_DIM:
				return getEndDim();
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
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZES:
				getTileSizes().clear();
				getTileSizes().addAll((Collection<? extends Integer>)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE:
				setTileSizeType((TILE_SIZE_TYPE)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILING_TYPE:
				setTilingType((TILING_TYPE)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__START_DIM:
				setStartDim((Integer)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__LEVEL:
				setLevel((Integer)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING:
				setCommunicationMapping((CommunicationMappingForTiledSpace)newValue);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__END_DIM:
				setEndDim((Integer)newValue);
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
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZES:
				getTileSizes().clear();
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE:
				setTileSizeType(TILE_SIZE_TYPE_EDEFAULT);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILING_TYPE:
				setTilingType(TILING_TYPE_EDEFAULT);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__START_DIM:
				setStartDim(START_DIM_EDEFAULT);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING:
				setCommunicationMapping((CommunicationMappingForTiledSpace)null);
				return;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__END_DIM:
				setEndDim(END_DIM_EDEFAULT);
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
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZES:
				return tileSizes != null && !tileSizes.isEmpty();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE:
				return tileSizeType != TILE_SIZE_TYPE_EDEFAULT;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__TILING_TYPE:
				return tilingType != TILING_TYPE_EDEFAULT;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__START_DIM:
				return startDim != START_DIM_EDEFAULT;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__LEVEL:
				return level != LEVEL_EDEFAULT;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING:
				return communicationMapping != null;
			case TargetMappingPackage.SUB_TILING_SPECIFICATION__END_DIM:
				return endDim != END_DIM_EDEFAULT;
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
		result.append(" (tileSizes: ");
		result.append(tileSizes);
		result.append(", tileSizeType: ");
		result.append(tileSizeType);
		result.append(", tilingType: ");
		result.append(tilingType);
		result.append(", startDim: ");
		result.append(startDim);
		result.append(", level: ");
		result.append(level);
		result.append(", endDim: ");
		result.append(endDim);
		result.append(')');
		return result.toString();
	}

} //SubTilingSpecificationImpl
