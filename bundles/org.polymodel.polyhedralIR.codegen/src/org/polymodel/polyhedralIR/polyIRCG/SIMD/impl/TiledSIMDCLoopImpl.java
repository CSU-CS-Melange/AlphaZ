/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tiled SIMDC Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.TiledSIMDCLoopImpl#getSimdStatements <em>Simd Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TiledSIMDCLoopImpl extends TiledCLoopImpl implements TiledSIMDCLoop {
	/**
	 * The cached value of the '{@link #getSimdStatements() <em>Simd Statements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimdStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<SIMDStatement> simdStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TiledSIMDCLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.TILED_SIMDC_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SIMDStatement> getSimdStatements() {
		if (simdStatements == null) {
			simdStatements = new EObjectResolvingEList<SIMDStatement>(SIMDStatement.class, this, SIMDPackage.TILED_SIMDC_LOOP__SIMD_STATEMENTS);
		}
		return simdStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SIMDPackage.TILED_SIMDC_LOOP__SIMD_STATEMENTS:
				return getSimdStatements();
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
			case SIMDPackage.TILED_SIMDC_LOOP__SIMD_STATEMENTS:
				getSimdStatements().clear();
				getSimdStatements().addAll((Collection<? extends SIMDStatement>)newValue);
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
			case SIMDPackage.TILED_SIMDC_LOOP__SIMD_STATEMENTS:
				getSimdStatements().clear();
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
			case SIMDPackage.TILED_SIMDC_LOOP__SIMD_STATEMENTS:
				return simdStatements != null && !simdStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TiledSIMDCLoopImpl
