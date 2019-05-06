/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

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
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Memory Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl#getBufferingFactor <em>Buffering Factor</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl#getBufferID <em>Buffer ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferMemoryDomainImpl extends MergedMemoryDomainImpl implements BufferMemoryDomain {
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
	protected BufferMemoryDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.BUFFER_MEMORY_DOMAIN;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR, oldBufferingFactor, newBufferingFactor);
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
				msgs = ((InternalEObject)bufferingFactor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR, null, msgs);
			if (newBufferingFactor != null)
				msgs = ((InternalEObject)newBufferingFactor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR, null, msgs);
			msgs = basicSetBufferingFactor(newBufferingFactor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR, newBufferingFactor, newBufferingFactor));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID, oldBufferID, bufferID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID, oldBufferID, bufferID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR:
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
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR:
				return getBufferingFactor();
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID:
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
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR:
				setBufferingFactor((IntExpression)newValue);
				return;
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID:
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
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR:
				setBufferingFactor((IntExpression)null);
				return;
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID:
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
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR:
				return bufferingFactor != null;
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN__BUFFER_ID:
				return bufferID != null;
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	public int getNIndices() {
		return super.getNIndices() + 1;
	}
	
	@Override
	public EList<Variable> getIndices() {
		EList<Variable> indices = super.getIndices();
		indices.add(0, getBufferID());
		return indices;
	}
	
	@Override
	public EList<IntExpression> getBounds(int dim) {
		if (dim == 0) {
			EList<IntExpression> lbub = new BasicEList<IntExpression>(2);

			lbub.add(IntExpressionBuilder.constant(0));
			//subtract 1 since bound starts from 0
			lbub.add(IntExpressionBuilder.sum(getBufferingFactor().copy(), IntExpressionBuilder.constant(-1)).simplify());
			
			return lbub;
		} else {
			return super.getBounds(dim - 1);
		}
	}
	
	@Override
	public IntExpression getVolumeExpression(int startingDim, int endingDim) {
		IntExpression vol = super.getVolumeExpression(startingDim, endingDim);
		return vol;
	}
} //BufferMemoryDomainImpl
