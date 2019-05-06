/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ResolvedAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ADA Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.impl.ADASolutionImpl#getResolvedAccesses <em>Resolved Accesses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ADASolutionImpl extends EObjectImpl implements ADASolution {
	/**
	 * The cached value of the '{@link #getResolvedAccesses() <em>Resolved Accesses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ResolvedAccess> resolvedAccesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ADASolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.ADA_SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResolvedAccess> getResolvedAccesses() {
		if (resolvedAccesses == null) {
			resolvedAccesses = new EObjectContainmentEList<ResolvedAccess>(ResolvedAccess.class, this, DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES);
		}
		return resolvedAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBottom() {
		for (ResolvedAccess r : this.getResolvedAccesses()) {
			if (!r.isBottom()) return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES:
				return ((InternalEList<?>)getResolvedAccesses()).basicRemove(otherEnd, msgs);
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
			case DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES:
				return getResolvedAccesses();
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
			case DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES:
				getResolvedAccesses().clear();
				getResolvedAccesses().addAll((Collection<? extends ResolvedAccess>)newValue);
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
			case DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES:
				getResolvedAccesses().clear();
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
			case DataflowPackage.ADA_SOLUTION__RESOLVED_ACCESSES:
				return resolvedAccesses != null && !resolvedAccesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DataflowPackage.ADA_SOLUTION___IS_BOTTOM:
				return isBottom();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		String res = "ADASolution : {";
		boolean first = true;
		for (ResolvedAccess r : this.getResolvedAccesses()) {
			if (first) first = false;
			else res += ", ";
			res += r.toString();
		}
		res += "}";
		return res;
	}
} //ADASolutionImpl
