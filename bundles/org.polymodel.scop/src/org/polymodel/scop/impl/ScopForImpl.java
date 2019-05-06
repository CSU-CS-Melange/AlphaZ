/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.ScopForImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopForImpl#getLB <em>LB</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopForImpl#getUB <em>UB</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopForImpl#getStride <em>Stride</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopForImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopForImpl extends AbstractScopNodeImpl implements ScopFor {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected Variable iterator;

	/**
	 * The cached value of the '{@link #getLB() <em>LB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLB()
	 * @generated
	 * @ordered
	 */
	protected IntExpression lb;

	/**
	 * The cached value of the '{@link #getUB() <em>UB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUB()
	 * @generated
	 * @ordered
	 */
	protected IntExpression ub;

	/**
	 * The cached value of the '{@link #getStride() <em>Stride</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStride()
	 * @generated
	 * @ordered
	 */
	protected IntExpression stride;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected AbstractScopNode body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopForImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_FOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getIterator() {
		if (iterator != null && iterator.eIsProxy()) {
			InternalEObject oldIterator = (InternalEObject)iterator;
			iterator = (Variable)eResolveProxy(oldIterator);
			if (iterator != oldIterator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScopPackage.SCOP_FOR__ITERATOR, oldIterator, iterator));
			}
		}
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(Variable newIterator) {
		Variable oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__ITERATOR, oldIterator, iterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getLB() {
		return lb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLB(IntExpression newLB, NotificationChain msgs) {
		IntExpression oldLB = lb;
		lb = newLB;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__LB, oldLB, newLB);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLB(IntExpression newLB) {
		if (newLB != lb) {
			NotificationChain msgs = null;
			if (lb != null)
				msgs = ((InternalEObject)lb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__LB, null, msgs);
			if (newLB != null)
				msgs = ((InternalEObject)newLB).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__LB, null, msgs);
			msgs = basicSetLB(newLB, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__LB, newLB, newLB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getUB() {
		return ub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUB(IntExpression newUB, NotificationChain msgs) {
		IntExpression oldUB = ub;
		ub = newUB;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__UB, oldUB, newUB);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUB(IntExpression newUB) {
		if (newUB != ub) {
			NotificationChain msgs = null;
			if (ub != null)
				msgs = ((InternalEObject)ub).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__UB, null, msgs);
			if (newUB != null)
				msgs = ((InternalEObject)newUB).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__UB, null, msgs);
			msgs = basicSetUB(newUB, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__UB, newUB, newUB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getStride() {
		return stride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStride(IntExpression newStride, NotificationChain msgs) {
		IntExpression oldStride = stride;
		stride = newStride;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__STRIDE, oldStride, newStride);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStride(IntExpression newStride) {
		if (newStride != stride) {
			NotificationChain msgs = null;
			if (stride != null)
				msgs = ((InternalEObject)stride).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__STRIDE, null, msgs);
			if (newStride != null)
				msgs = ((InternalEObject)newStride).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__STRIDE, null, msgs);
			msgs = basicSetStride(newStride, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__STRIDE, newStride, newStride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractScopNode getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(AbstractScopNode newBody, NotificationChain msgs) {
		AbstractScopNode oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(AbstractScopNode newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScopPackage.SCOP_FOR__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_FOR__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitScopFor(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScopPackage.SCOP_FOR__LB:
				return basicSetLB(null, msgs);
			case ScopPackage.SCOP_FOR__UB:
				return basicSetUB(null, msgs);
			case ScopPackage.SCOP_FOR__STRIDE:
				return basicSetStride(null, msgs);
			case ScopPackage.SCOP_FOR__BODY:
				return basicSetBody(null, msgs);
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
			case ScopPackage.SCOP_FOR__ITERATOR:
				if (resolve) return getIterator();
				return basicGetIterator();
			case ScopPackage.SCOP_FOR__LB:
				return getLB();
			case ScopPackage.SCOP_FOR__UB:
				return getUB();
			case ScopPackage.SCOP_FOR__STRIDE:
				return getStride();
			case ScopPackage.SCOP_FOR__BODY:
				return getBody();
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
			case ScopPackage.SCOP_FOR__ITERATOR:
				setIterator((Variable)newValue);
				return;
			case ScopPackage.SCOP_FOR__LB:
				setLB((IntExpression)newValue);
				return;
			case ScopPackage.SCOP_FOR__UB:
				setUB((IntExpression)newValue);
				return;
			case ScopPackage.SCOP_FOR__STRIDE:
				setStride((IntExpression)newValue);
				return;
			case ScopPackage.SCOP_FOR__BODY:
				setBody((AbstractScopNode)newValue);
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
			case ScopPackage.SCOP_FOR__ITERATOR:
				setIterator((Variable)null);
				return;
			case ScopPackage.SCOP_FOR__LB:
				setLB((IntExpression)null);
				return;
			case ScopPackage.SCOP_FOR__UB:
				setUB((IntExpression)null);
				return;
			case ScopPackage.SCOP_FOR__STRIDE:
				setStride((IntExpression)null);
				return;
			case ScopPackage.SCOP_FOR__BODY:
				setBody((AbstractScopNode)null);
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
			case ScopPackage.SCOP_FOR__ITERATOR:
				return iterator != null;
			case ScopPackage.SCOP_FOR__LB:
				return lb != null;
			case ScopPackage.SCOP_FOR__UB:
				return ub != null;
			case ScopPackage.SCOP_FOR__STRIDE:
				return stride != null;
			case ScopPackage.SCOP_FOR__BODY:
				return body != null;
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
				case ScopPackage.SCOP_VISITABLE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_FOR___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopNode.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_FOR___ACCEPT__SCOPVISITOR;
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
			case ScopPackage.SCOP_FOR___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		return String.format("for (%s=%s; %s<=%s; %s+=%s) ", getIterator(), getLB(), getIterator(), getUB(), getIterator(), getStride());
	}

} //ScopForImpl
