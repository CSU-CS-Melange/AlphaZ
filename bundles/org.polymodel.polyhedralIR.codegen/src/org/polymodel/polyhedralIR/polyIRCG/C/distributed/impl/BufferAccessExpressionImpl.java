/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl#getBufferingFactor <em>Buffering Factor</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl#getBufferID <em>Buffer ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferAccessExpressionImpl extends MergedDomainAccessExpressionImpl implements BufferAccessExpression {
	/**
	 * The cached value of the '{@link #getBufferingFactor() <em>Buffering Factor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferingFactor()
	 * @generated
	 * @ordered
	 */
	protected IntExpression bufferingFactor;

	/**
	 * The cached value of the '{@link #getBufferID() <em>Buffer ID</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferID()
	 * @generated
	 * @ordered
	 */
	protected Variable bufferID;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.BUFFER_ACCESS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getBufferingFactor() {
		return bufferingFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferingFactor(IntExpression newBufferingFactor, NotificationChain msgs) {
		IntExpression oldBufferingFactor = bufferingFactor;
		bufferingFactor = newBufferingFactor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR, oldBufferingFactor, newBufferingFactor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferingFactor(IntExpression newBufferingFactor) {
		if (newBufferingFactor != bufferingFactor) {
			NotificationChain msgs = null;
			if (bufferingFactor != null)
				msgs = ((InternalEObject)bufferingFactor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR, null, msgs);
			if (newBufferingFactor != null)
				msgs = ((InternalEObject)newBufferingFactor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR, null, msgs);
			msgs = basicSetBufferingFactor(newBufferingFactor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR, newBufferingFactor, newBufferingFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getBufferID() {
		if (bufferID != null && bufferID.eIsProxy()) {
			InternalEObject oldBufferID = (InternalEObject)bufferID;
			bufferID = (Variable)eResolveProxy(oldBufferID);
			if (bufferID != oldBufferID) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID, oldBufferID, bufferID));
			}
		}
		return bufferID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetBufferID() {
		return bufferID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferID(Variable newBufferID) {
		Variable oldBufferID = bufferID;
		bufferID = newBufferID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID, oldBufferID, bufferID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR:
				return basicSetBufferingFactor(null, msgs);
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
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR:
				return getBufferingFactor();
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID:
				if (resolve) return getBufferID();
				return basicGetBufferID();
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
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR:
				setBufferingFactor((IntExpression)newValue);
				return;
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID:
				setBufferID((Variable)newValue);
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
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR:
				setBufferingFactor((IntExpression)null);
				return;
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID:
				setBufferID((Variable)null);
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
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR:
				return bufferingFactor != null;
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION__BUFFER_ID:
				return bufferID != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public EList<IntExpression> getAccessExpressions() {
		assert(getVariable().getDomain() instanceof MergedMemoryDomain);
		assert(getVariable().isFlattened());

//		EList<IntExpression> exprs = getAccessExpression().getAccessExpressions();
		EList<IntExpression> exprs = arrayIndexing1D(getAccessExpression());
		
//		System.err.println("BAE:"+exprs);
//		System.err.println("BAEai1D:"+arrayIndexing1D(getAccessExpression()));
//		
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
			offset.getExpressions().add(tileVolumeExpression(mmd.getMemoryDomains().get(key), 0));
//			offset.getExpressions().add(mmd.getMemoryDomains().get(key).getVolumeExpression(0, -1));
		}
		
		
		//combine access expression with offset
		offset.getExpressions().add(exprs.get(0));
		exprs.set(0, offset);
		
		exprs.add(0, IntExpressionBuilder.affine(IntExpressionBuilder.term(getBufferID())));
		
		return exprs;
	}

	private static EList<IntExpression> arrayIndexing1D(MemoryAccessExpression mae) {
		
		EList<IntExpression> exprs = new BasicEList<IntExpression>();

		ReductionExpression sum = IntExpressionBuilder.sum();
		
		for (int d = 0; d < mae.getVariable().getDomain().getNIndices(); d++) {
			sum.getExpressions().add(IntExpressionBuilder.prod(mae.getIndexingExpression(d), tileVolumeExpression(mae, d+1)));
		}

		exprs.add(sum.simplify());
		
		return exprs;
		
		
	}
	
	private static IntExpression tileVolumeExpression(MemoryAccessExpression mae, int dim) {
		return tileVolumeExpression(mae.getVariable().getDomain(), dim);
	}
	
	private static IntExpression tileVolumeExpression(MemoryDomain md, int dim) {
		List<IntExpression> sizes = new ArrayList<IntExpression>(10);
		
		for (int d = dim; d < md.getNIndices(); d++) {
			List<IntExpression> lbub = md.getBounds(d);
			sizes.add(IntExpressionBuilder.sum(IntExpressionBuilder.constant(1), IntExpressionBuilder.sub(lbub.get(1), lbub.get(0))).simplify());
		}
		
		if (sizes.isEmpty()) {
			return IntExpressionBuilder.constant(1);
		}
		
		return IntExpressionBuilder.prod(sizes).simplify();
	}

} //BufferAccessExpressionImpl
