/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryDomainImpl#isZeroAligned <em>Zero Aligned</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MemoryDomainImpl extends EObjectImpl implements MemoryDomain {
	/**
	 * The default value of the '{@link #isZeroAligned() <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZeroAligned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ZERO_ALIGNED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isZeroAligned() <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZeroAligned()
	 * @generated
	 * @ordered
	 */
	protected boolean zeroAligned = ZERO_ALIGNED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.MEMORY_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isZeroAligned() {
		return zeroAligned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZeroAligned(boolean newZeroAligned) {
		boolean oldZeroAligned = zeroAligned;
		zeroAligned = newZeroAligned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.MEMORY_DOMAIN__ZERO_ALIGNED, oldZeroAligned, zeroAligned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNParams() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNIndices() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParams() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getIndices() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getBounds(int dim) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getVolumeExpression(int startingDim, int endingDim) {
		List<IntExpression> LBs = new LinkedList<IntExpression>();
		List<IntExpression> UBs = new LinkedList<IntExpression>();
		
		if (endingDim < 0) {
			endingDim = getNIndices();
		}
		
		//Scalar domain
		if (getNIndices() == 0 || startingDim == endingDim) {
			return constant(1);
		}
		//Dimension check
		if (startingDim >= endingDim || getNIndices() < endingDim || startingDim < 0) {
			throw new RuntimeException("Invalid range for computing volume expression ("+ startingDim +":"+endingDim+")");
		}
		
		// Compute Upper & Lower bounds
		for (int i = startingDim; i < endingDim; i++) {
			EList<IntExpression> lbub = getBounds(i);
			LBs.add(lbub.get(0));
			UBs.add(lbub.get(1));
		}
		
		List<IntExpression> exprs = new LinkedList<IntExpression>();

		for (int i = 0; i < UBs.size(); i++) {
			//size is UB - LB +1
			ReductionExpression sum = IntExpressionBuilder.sum();
			sum.getExpressions().add(UBs.get(i));
			//Ignore lower bound when zero aligned
			if (!isZeroAligned()) {
				//negate the LB by multiplying with -1
				ReductionExpression neg = IntExpressionBuilder.prod(LBs.get(i), constant(-1));
				sum.getExpressions().add(neg);
				
			}
			//Add one (size is UB - LB + 1)
			sum.getExpressions().add(constant(1));

			exprs.add(sum);
		}
		
		//If one dimensional, then no need to multiply
		if (exprs.size() == 1) {
			return exprs.get(0).simplify();
		}
		
		//Otherwise take the product of volumes of all dimension
		ReductionExpression prod = IntExpressionBuilder.prod(exprs);
		
		return prod.simplify();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_DOMAIN__ZERO_ALIGNED:
				return isZeroAligned();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_DOMAIN__ZERO_ALIGNED:
				setZeroAligned((Boolean)newValue);
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
			case PolyIRCGPackage.MEMORY_DOMAIN__ZERO_ALIGNED:
				setZeroAligned(ZERO_ALIGNED_EDEFAULT);
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
			case PolyIRCGPackage.MEMORY_DOMAIN__ZERO_ALIGNED:
				return zeroAligned != ZERO_ALIGNED_EDEFAULT;
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
		result.append(" (zeroAligned: ");
		result.append(zeroAligned);
		result.append(')');
		return result.toString();
	}

} //MemoryDomainImpl
