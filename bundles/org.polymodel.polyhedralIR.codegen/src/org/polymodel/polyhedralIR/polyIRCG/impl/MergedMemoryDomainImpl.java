/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.impl.ValueContainedMapImpl;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merged Memory Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl#getMemoryDomains <em>Memory Domains</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MergedMemoryDomainImpl extends MemoryDomainImpl implements MergedMemoryDomain {
	/**
	 * The cached value of the '{@link #getMemoryDomains() <em>Memory Domains</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryDomains()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, MemoryDomain> memoryDomains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergedMemoryDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.MERGED_MEMORY_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, MemoryDomain> getMemoryDomains() {
		if (memoryDomains == null) {
			memoryDomains = new EcoreEMap<String,MemoryDomain>(PolymodelPackage.Literals.VALUE_CONTAINED_MAP, ValueContainedMapImpl.class, this, PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS);
		}
		return memoryDomains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDim() {
		return getNParams() + getNIndices();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNParams() {
		if (memoryDomains.size() == 0) {
			throw new RuntimeException("No MemoryDomains specified in MergedMemoryDomain");
		}
		
		int n = -1;
		for (MemoryDomain dom : getMemoryDomains().values()) {
			if (n < 0) {
				n = dom.getNParams();
			} else {
				if (n != dom.getNParams()) {
					throw new RuntimeException("Number of parameters must be consistent across all merged domains.");
				}
			}
		}
		
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNIndices() {
		if (memoryDomains.size() == 0) {
			throw new RuntimeException("No MemoryDomains specified in MergedMemoryDomain");
		}
		
		return 1;
		
//		int n = -1;
//		for (MemoryDomain dom : getMemoryDomains().values()) {
//			if (n < 0) {
//				n = dom.getNIndices();
//			} else {
//				if (n != dom.getNIndices()) {
//					throw new RuntimeException("Number of indices must be consistent across all merged domains.");
//				}
//			}
//		}
//		
//		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getParams() {
		if (memoryDomains.size() == 0) {
			throw new RuntimeException("No MemoryDomains specified in MergedMemoryDomain");
		}
	
		return getMemoryDomains().values().iterator().next().getParams();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getIndices() {
		if (memoryDomains.size() == 0) {
			throw new RuntimeException("No MemoryDomains specified in MergedMemoryDomain");
		}
		
		EList<Variable> indices = new BasicEList<Variable>();
		indices.add(getMemoryDomains().values().iterator().next().getIndices().get(0));
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("serial")
	public EList<IntExpression> getBounds(int dim) {
		if (memoryDomains.size() == 0) {
			throw new RuntimeException("No MemoryDomains specified in MergedMemoryDomain");
		}
		//everything except the innermost dimensions is a single point
		if (dim > 0) {
			return new BasicEList<IntExpression>() { { add(IntExpressionBuilder.constant(0)); add(IntExpressionBuilder.constant(0)); } };
		}
		
		//first dimension is the sum of all volumes of the merged domains

		final ReductionExpression volumeSum = IntExpressionBuilder.sum();
		for (MemoryDomain md : getMemoryDomains().values()) {
			ReductionExpression mdVol = IntExpressionBuilder.prod();
			for (int d = 0; d < md.getNIndices(); d++) {
				List<IntExpression> lbub = md.getBounds(d);
				mdVol.getExpressions().add(IntExpressionBuilder.add(1, IntExpressionBuilder.sub(lbub.get(1), lbub.get(0))));
			}
			volumeSum.getExpressions().add(mdVol);
		}
		
		return new BasicEList<IntExpression>() { { add(IntExpressionBuilder.constant(1)); add(volumeSum); } };
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS:
				return ((InternalEList<?>)getMemoryDomains()).basicRemove(otherEnd, msgs);
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
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS:
				if (coreType) return getMemoryDomains();
				else return getMemoryDomains().map();
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
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS:
				((EStructuralFeature.Setting)getMemoryDomains()).set(newValue);
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
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS:
				getMemoryDomains().clear();
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
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS:
				return memoryDomains != null && !memoryDomains.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MergedMemoryDomainImpl
