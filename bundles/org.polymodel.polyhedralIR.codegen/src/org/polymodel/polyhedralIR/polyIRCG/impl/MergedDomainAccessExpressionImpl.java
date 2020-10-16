/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merged Domain Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl#getAccessExpression <em>Access Expression</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MergedDomainAccessExpressionImpl extends MemoryAccessExpressionImpl implements MergedDomainAccessExpression {
	/**
	 * The cached value of the '{@link #getAccessExpression() <em>Access Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessExpression()
	 * @generated
	 * @ordered
	 */
	protected MemoryAccessExpression accessExpression;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergedDomainAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.MERGED_DOMAIN_ACCESS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryAccessExpression getAccessExpression() {
		return accessExpression;
	}
	
	@Override
	public IntExpression getIndexingExpression(int dim) {
		return IntExpressionBuilder.affine(IntExpressionBuilder.term(getVariable().getDomain().getIndices().get(dim)));
	}
	
	@Override
	public EList<IntExpression> getAccessExpressions() {
		assert(getVariable().getDomain() instanceof MergedMemoryDomain);
		assert(getVariable().isFlattened());
		
		EList<IntExpression> exprs = getAccessExpression().getAccessExpressions();
		
		MergedMemoryDomain mmd = (MergedMemoryDomain)getVariable().getDomain();
		
		//sort the keys to ensure consistent order
		List<String> keys = new ArrayList<String>();
		for (String key : mmd.getMemoryDomains().keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);

		//collect offset up to the target variable
		ReductionExpression offset = IntExpressionBuilder.sum();
		for (String key : keys) {
			if (key.contentEquals(getIdentifier())) {
				break;
			}
			offset.getExpressions().add(mmd.getMemoryDomains().get(key).getVolumeExpression(0, -1));
		}
		
		
		//combine access expression with offset
		offset.getExpressions().add(exprs.get(0));
		exprs.set(0, offset);
		
		return exprs;

	}
	
	@Override
	public IntExpression getVolumeExpression(int dim) {
		return super.getVolumeExpression(dim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessExpression(MemoryAccessExpression newAccessExpression, NotificationChain msgs) {
		MemoryAccessExpression oldAccessExpression = accessExpression;
		accessExpression = newAccessExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION, oldAccessExpression, newAccessExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessExpression(MemoryAccessExpression newAccessExpression) {
		if (newAccessExpression != accessExpression) {
			NotificationChain msgs = null;
			if (accessExpression != null)
				msgs = ((InternalEObject)accessExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION, null, msgs);
			if (newAccessExpression != null)
				msgs = ((InternalEObject)newAccessExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION, null, msgs);
			msgs = basicSetAccessExpression(newAccessExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION, newAccessExpression, newAccessExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION:
				return basicSetAccessExpression(null, msgs);
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
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION:
				return getAccessExpression();
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER:
				return getIdentifier();
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
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION:
				setAccessExpression((MemoryAccessExpression)newValue);
				return;
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER:
				setIdentifier((String)newValue);
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
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION:
				setAccessExpression((MemoryAccessExpression)null);
				return;
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
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
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION:
				return accessExpression != null;
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(')');
		return result.toString();
	}

} //MergedDomainAccessExpressionImpl
