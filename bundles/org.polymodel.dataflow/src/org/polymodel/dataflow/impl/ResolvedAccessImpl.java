/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ResolvedAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolved Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.impl.ResolvedAccessImpl#getValidityDomain <em>Validity Domain</em>}</li>
 *   <li>{@link org.polymodel.dataflow.impl.ResolvedAccessImpl#getIterationVector <em>Iteration Vector</em>}</li>
 *   <li>{@link org.polymodel.dataflow.impl.ResolvedAccessImpl#getAccess <em>Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolvedAccessImpl extends EObjectImpl implements ResolvedAccess {
	/**
	 * The cached value of the '{@link #getValidityDomain() <em>Validity Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidityDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain validityDomain;

	/**
	 * The cached value of the '{@link #getIterationVector() <em>Iteration Vector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationVector()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> iterationVector;

	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected Access access;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolvedAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.RESOLVED_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getValidityDomain() {
		return validityDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidityDomain(Domain newValidityDomain, NotificationChain msgs) {
		Domain oldValidityDomain = validityDomain;
		validityDomain = newValidityDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN, oldValidityDomain, newValidityDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidityDomain(Domain newValidityDomain) {
		if (newValidityDomain != validityDomain) {
			NotificationChain msgs = null;
			if (validityDomain != null)
				msgs = ((InternalEObject)validityDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN, null, msgs);
			if (newValidityDomain != null)
				msgs = ((InternalEObject)newValidityDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN, null, msgs);
			msgs = basicSetValidityDomain(newValidityDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN, newValidityDomain, newValidityDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getIterationVector() {
		if (iterationVector == null) {
			iterationVector = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR);
		}
		return iterationVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getAccess() {
		if (access != null && access.eIsProxy()) {
			InternalEObject oldAccess = (InternalEObject)access;
			access = (Access)eResolveProxy(oldAccess);
			if (access != oldAccess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataflowPackage.RESOLVED_ACCESS__ACCESS, oldAccess, access));
			}
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access basicGetAccess() {
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccess(Access newAccess) {
		Access oldAccess = access;
		access = newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.RESOLVED_ACCESS__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBottom() {
		return (this.getAccess() == null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN:
				return basicSetValidityDomain(null, msgs);
			case DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR:
				return ((InternalEList<?>)getIterationVector()).basicRemove(otherEnd, msgs);
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
			case DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN:
				return getValidityDomain();
			case DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR:
				return getIterationVector();
			case DataflowPackage.RESOLVED_ACCESS__ACCESS:
				if (resolve) return getAccess();
				return basicGetAccess();
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
			case DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN:
				setValidityDomain((Domain)newValue);
				return;
			case DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR:
				getIterationVector().clear();
				getIterationVector().addAll((Collection<? extends IntExpression>)newValue);
				return;
			case DataflowPackage.RESOLVED_ACCESS__ACCESS:
				setAccess((Access)newValue);
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
			case DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN:
				setValidityDomain((Domain)null);
				return;
			case DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR:
				getIterationVector().clear();
				return;
			case DataflowPackage.RESOLVED_ACCESS__ACCESS:
				setAccess((Access)null);
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
			case DataflowPackage.RESOLVED_ACCESS__VALIDITY_DOMAIN:
				return validityDomain != null;
			case DataflowPackage.RESOLVED_ACCESS__ITERATION_VECTOR:
				return iterationVector != null && !iterationVector.isEmpty();
			case DataflowPackage.RESOLVED_ACCESS__ACCESS:
				return access != null;
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
			case DataflowPackage.RESOLVED_ACCESS___IS_BOTTOM:
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
		String res = "";
		if (this.isBottom()) res += "<bottom>";
		else {
			res += "S"+this.getAccess().getParentADAStatement().getId()+":"+this.getAccess();
			if (this.getIterationVector().size() > 0) res += "@"+this.getIterationVector();
		}
		res += " : "+this.getValidityDomain();
		return res;
	}

} //ResolvedAccessImpl
