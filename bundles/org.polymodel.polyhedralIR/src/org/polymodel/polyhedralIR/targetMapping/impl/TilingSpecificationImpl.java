/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tiling Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl#getEndDim <em>End Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl#getSubTiles <em>Sub Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl#getIdentificationName <em>Identification Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TilingSpecificationImpl extends FeatureSpecificationImpl implements TilingSpecification {
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
	 * The cached value of the '{@link #getSubTiles() <em>Sub Tiles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTiles()
	 * @generated
	 * @ordered
	 */
	protected EList<SubTilingSpecification> subTiles;

	/**
	 * The default value of the '{@link #getIdentificationName() <em>Identification Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentificationName()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFICATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentificationName() <em>Identification Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentificationName()
	 * @generated
	 * @ordered
	 */
	protected String identificationName = IDENTIFICATION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TilingSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.TILING_SPECIFICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.TILING_SPECIFICATION__START_DIM, oldStartDim, startDim));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.TILING_SPECIFICATION__END_DIM, oldEndDim, endDim));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.TILING_SPECIFICATION__LEVELS, oldLevels, levels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubTilingSpecification> getSubTiles() {
		if (subTiles == null) {
			subTiles = new EObjectContainmentEList<SubTilingSpecification>(SubTilingSpecification.class, this, TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES);
		}
		return subTiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentificationName() {
		return identificationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentificationName(String newIdentificationName) {
		String oldIdentificationName = identificationName;
		identificationName = newIdentificationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.TILING_SPECIFICATION__IDENTIFICATION_NAME, oldIdentificationName, identificationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SubTilingSpecification getSubTile(int level) {
		for(SubTilingSpecification subtile: getSubTiles()){
			if(subtile.getLevel() == level){
				return subtile;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitTilingSpecification(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES:
				return ((InternalEList<?>)getSubTiles()).basicRemove(otherEnd, msgs);
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
			case TargetMappingPackage.TILING_SPECIFICATION__START_DIM:
				return getStartDim();
			case TargetMappingPackage.TILING_SPECIFICATION__END_DIM:
				return getEndDim();
			case TargetMappingPackage.TILING_SPECIFICATION__LEVELS:
				return getLevels();
			case TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES:
				return getSubTiles();
			case TargetMappingPackage.TILING_SPECIFICATION__IDENTIFICATION_NAME:
				return getIdentificationName();
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
			case TargetMappingPackage.TILING_SPECIFICATION__START_DIM:
				setStartDim((Integer)newValue);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__END_DIM:
				setEndDim((Integer)newValue);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__LEVELS:
				setLevels((Integer)newValue);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES:
				getSubTiles().clear();
				getSubTiles().addAll((Collection<? extends SubTilingSpecification>)newValue);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__IDENTIFICATION_NAME:
				setIdentificationName((String)newValue);
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
			case TargetMappingPackage.TILING_SPECIFICATION__START_DIM:
				setStartDim(START_DIM_EDEFAULT);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__END_DIM:
				setEndDim(END_DIM_EDEFAULT);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__LEVELS:
				setLevels(LEVELS_EDEFAULT);
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES:
				getSubTiles().clear();
				return;
			case TargetMappingPackage.TILING_SPECIFICATION__IDENTIFICATION_NAME:
				setIdentificationName(IDENTIFICATION_NAME_EDEFAULT);
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
			case TargetMappingPackage.TILING_SPECIFICATION__START_DIM:
				return startDim != START_DIM_EDEFAULT;
			case TargetMappingPackage.TILING_SPECIFICATION__END_DIM:
				return endDim != END_DIM_EDEFAULT;
			case TargetMappingPackage.TILING_SPECIFICATION__LEVELS:
				return levels != LEVELS_EDEFAULT;
			case TargetMappingPackage.TILING_SPECIFICATION__SUB_TILES:
				return subTiles != null && !subTiles.isEmpty();
			case TargetMappingPackage.TILING_SPECIFICATION__IDENTIFICATION_NAME:
				return IDENTIFICATION_NAME_EDEFAULT == null ? identificationName != null : !IDENTIFICATION_NAME_EDEFAULT.equals(identificationName);
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
		result.append(" (startDim: ");
		result.append(startDim);
		result.append(", endDim: ");
		result.append(endDim);
		result.append(", levels: ");
		result.append(levels);
		result.append(", identificationName: ");
		result.append(identificationName);
		result.append(')');
		return result.toString();
	}

} //TilingSpecificationImpl
