/**
 */
package org.polymodel.polyhedralIR.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.TilingInformations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tiling Informations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TilingInformationsImpl#getRatios <em>Ratios</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TilingInformationsImpl#getMinParamValues <em>Min Param Values</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TilingInformationsImpl#getTileGroups <em>Tile Groups</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.TilingInformationsImpl#getCobPreprocess <em>Cob Preprocess</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TilingInformationsImpl extends EObjectImpl implements TilingInformations {
	/**
	 * The cached value of the '{@link #getRatios() <em>Ratios</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatios()
	 * @generated
	 * @ordered
	 */
	protected Map<String, EList<Integer>> ratios;

	/**
	 * The cached value of the '{@link #getMinParamValues() <em>Min Param Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinParamValues()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> minParamValues;

	/**
	 * The cached value of the '{@link #getTileGroups() <em>Tile Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileGroups()
	 * @generated
	 * @ordered
	 */
	protected Map<String, List<String>> tileGroups;

	/**
	 * The cached value of the '{@link #getCobPreprocess() <em>Cob Preprocess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCobPreprocess()
	 * @generated
	 * @ordered
	 */
	protected Map<String, AffineFunction> cobPreprocess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TilingInformationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getTilingInformations();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, EList<Integer>> getRatios() {
		return ratios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatios(Map<String, EList<Integer>> newRatios) {
		Map<String, EList<Integer>> oldRatios = ratios;
		ratios = newRatios;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TILING_INFORMATIONS__RATIOS, oldRatios, ratios));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getMinParamValues() {
		return minParamValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinParamValues(Map<String, Integer> newMinParamValues) {
		Map<String, Integer> oldMinParamValues = minParamValues;
		minParamValues = newMinParamValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TILING_INFORMATIONS__MIN_PARAM_VALUES, oldMinParamValues, minParamValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, List<String>> getTileGroups() {
		return tileGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileGroups(Map<String, List<String>> newTileGroups) {
		Map<String, List<String>> oldTileGroups = tileGroups;
		tileGroups = newTileGroups;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TILING_INFORMATIONS__TILE_GROUPS, oldTileGroups, tileGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, AffineFunction> getCobPreprocess() {
		return cobPreprocess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCobPreprocess(Map<String, AffineFunction> newCobPreprocess) {
		Map<String, AffineFunction> oldCobPreprocess = cobPreprocess;
		cobPreprocess = newCobPreprocess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.TILING_INFORMATIONS__COB_PREPROCESS, oldCobPreprocess, cobPreprocess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitTilingInformations(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyhedralIRPackage.TILING_INFORMATIONS__RATIOS:
				return getRatios();
			case PolyhedralIRPackage.TILING_INFORMATIONS__MIN_PARAM_VALUES:
				return getMinParamValues();
			case PolyhedralIRPackage.TILING_INFORMATIONS__TILE_GROUPS:
				return getTileGroups();
			case PolyhedralIRPackage.TILING_INFORMATIONS__COB_PREPROCESS:
				return getCobPreprocess();
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
			case PolyhedralIRPackage.TILING_INFORMATIONS__RATIOS:
				setRatios((Map<String, EList<Integer>>)newValue);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__MIN_PARAM_VALUES:
				setMinParamValues((Map<String, Integer>)newValue);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__TILE_GROUPS:
				setTileGroups((Map<String, List<String>>)newValue);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__COB_PREPROCESS:
				setCobPreprocess((Map<String, AffineFunction>)newValue);
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
			case PolyhedralIRPackage.TILING_INFORMATIONS__RATIOS:
				setRatios((Map<String, EList<Integer>>)null);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__MIN_PARAM_VALUES:
				setMinParamValues((Map<String, Integer>)null);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__TILE_GROUPS:
				setTileGroups((Map<String, List<String>>)null);
				return;
			case PolyhedralIRPackage.TILING_INFORMATIONS__COB_PREPROCESS:
				setCobPreprocess((Map<String, AffineFunction>)null);
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
			case PolyhedralIRPackage.TILING_INFORMATIONS__RATIOS:
				return ratios != null;
			case PolyhedralIRPackage.TILING_INFORMATIONS__MIN_PARAM_VALUES:
				return minParamValues != null;
			case PolyhedralIRPackage.TILING_INFORMATIONS__TILE_GROUPS:
				return tileGroups != null;
			case PolyhedralIRPackage.TILING_INFORMATIONS__COB_PREPROCESS:
				return cobPreprocess != null;
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
		result.append(" (ratios: ");
		result.append(ratios);
		result.append(", minParamValues: ");
		result.append(minParamValues);
		result.append(", tileGroups: ");
		result.append(tileGroups);
		result.append(", cobPreprocess: ");
		result.append(cobPreprocess);
		result.append(')');
		return result.toString();
	}

} //TilingInformationsImpl
