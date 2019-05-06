/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.ScopGuardImpl#getConstraintSystems <em>Constraint Systems</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopGuardImpl#getThenBody <em>Then Body</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopGuardImpl#getElseBody <em>Else Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopGuardImpl extends AbstractScopNodeImpl implements ScopGuard {
	/**
	 * The cached value of the '{@link #getConstraintSystems() <em>Constraint Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<IntConstraintSystem> constraintSystems;

	/**
	 * The cached value of the '{@link #getThenBody() <em>Then Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenBody()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode thenBody;

	/**
	 * The cached value of the '{@link #getElseBody() <em>Else Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseBody()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode elseBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntConstraintSystem> getConstraintSystems() {
		if (constraintSystems == null) {
			constraintSystems = new EObjectContainmentEList<IntConstraintSystem>(IntConstraintSystem.class, this, ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS);
		}
		return constraintSystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getThenBody() {
		return thenBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenBody(AbstractScopNode newThenBody, NotificationChain msgs) {
		AbstractScopNode oldThenBody = thenBody;
		thenBody = newThenBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_GUARD__THEN_BODY, oldThenBody, newThenBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenBody(AbstractScopNode newThenBody) {
		if (newThenBody != thenBody) {
			NotificationChain msgs = null;
			if (thenBody != null)
				msgs = ((InternalEObject)thenBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_GUARD__THEN_BODY, null, msgs);
			if (newThenBody != null)
				msgs = ((InternalEObject)newThenBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_GUARD__THEN_BODY, null, msgs);
			msgs = basicSetThenBody(newThenBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_GUARD__THEN_BODY, newThenBody, newThenBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getElseBody() {
		return elseBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseBody(AbstractScopNode newElseBody, NotificationChain msgs) {
		AbstractScopNode oldElseBody = elseBody;
		elseBody = newElseBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_GUARD__ELSE_BODY, oldElseBody, newElseBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseBody(AbstractScopNode newElseBody) {
		if (newElseBody != elseBody) {
			NotificationChain msgs = null;
			if (elseBody != null)
				msgs = ((InternalEObject)elseBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_GUARD__ELSE_BODY, null, msgs);
			if (newElseBody != null)
				msgs = ((InternalEObject)newElseBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_GUARD__ELSE_BODY, null, msgs);
			msgs = basicSetElseBody(newElseBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_GUARD__ELSE_BODY, newElseBody, newElseBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitScopGuard(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS:
				return ((InternalEList<?>)getConstraintSystems()).basicRemove(otherEnd, msgs);
			case ScopPackage.SCOP_GUARD__THEN_BODY:
				return basicSetThenBody(null, msgs);
			case ScopPackage.SCOP_GUARD__ELSE_BODY:
				return basicSetElseBody(null, msgs);
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
			case ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS:
				return getConstraintSystems();
			case ScopPackage.SCOP_GUARD__THEN_BODY:
				return getThenBody();
			case ScopPackage.SCOP_GUARD__ELSE_BODY:
				return getElseBody();
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
			case ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS:
				getConstraintSystems().clear();
				getConstraintSystems().addAll((Collection<? extends IntConstraintSystem>)newValue);
				return;
			case ScopPackage.SCOP_GUARD__THEN_BODY:
				setThenBody((AbstractScopNode)newValue);
				return;
			case ScopPackage.SCOP_GUARD__ELSE_BODY:
				setElseBody((AbstractScopNode)newValue);
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
			case ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS:
				getConstraintSystems().clear();
				return;
			case ScopPackage.SCOP_GUARD__THEN_BODY:
				setThenBody((AbstractScopNode)null);
				return;
			case ScopPackage.SCOP_GUARD__ELSE_BODY:
				setElseBody((AbstractScopNode)null);
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
			case ScopPackage.SCOP_GUARD__CONSTRAINT_SYSTEMS:
				return constraintSystems != null && !constraintSystems.isEmpty();
			case ScopPackage.SCOP_GUARD__THEN_BODY:
				return thenBody != null;
			case ScopPackage.SCOP_GUARD__ELSE_BODY:
				return elseBody != null;
		}
		return super.eIsSet(featureID);
	}

	 /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ScopVisitable.class) {
			switch (baseOperationID) {
				case ScopPackage.SCOP_VISITABLE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_GUARD___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopNode.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_GUARD___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScopPackage.SCOP_GUARD___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

		@Override
	public String toString() {
		return String.format("if (%s) ", getConstraintSystems());
	 }

} //ScopGuardImpl
