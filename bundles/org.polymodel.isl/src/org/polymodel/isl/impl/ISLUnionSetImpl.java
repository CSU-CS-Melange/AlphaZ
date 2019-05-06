/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISL Union Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.isl.impl.ISLUnionSetImpl#getSets <em>Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ISLUnionSetImpl extends EObjectImpl implements ISLUnionSet {
	/**
	 * The cached value of the '{@link #getSets() <em>Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ISLSet> sets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLUnionSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_UNION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ISLSet> getSets() {
		if (sets == null) {
			sets = new EObjectResolvingEList<ISLSet>(ISLSet.class, this, IslPackage.ISL_UNION_SET__SETS);
		}
		return sets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IslPackage.ISL_UNION_SET__SETS:
				return getSets();
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
			case IslPackage.ISL_UNION_SET__SETS:
				getSets().clear();
				getSets().addAll((Collection<? extends ISLSet>)newValue);
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
			case IslPackage.ISL_UNION_SET__SETS:
				getSets().clear();
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
			case IslPackage.ISL_UNION_SET__SETS:
				return sets != null && !sets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		String res = this.getSets().get(0).getDimensions().getParameters().toString() + " -> {\n";
		for (ISLSet s : this.getSets()) {
			res += "\t"+s.getLabel()+s.getDimensions().getIndices()+" : ";
			boolean first = true;
			for (IntConstraintSystem sys : s.getPolyhedra()) {
				if (first) first = false;
				else res += " or ";
				res += "("+sys+")";
			}
			res += "\n";
		}
		res += "}";
		return res;
	}
} //ISLUnionSetImpl
