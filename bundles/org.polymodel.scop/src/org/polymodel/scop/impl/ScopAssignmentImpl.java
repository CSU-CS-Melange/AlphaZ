/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.ScopAssignmentImpl#getLHS <em>LHS</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopAssignmentImpl#getRHS <em>RHS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopAssignmentImpl extends AbstractScopStatementImpl implements ScopAssignment {
	/**
	 * The cached value of the '{@link #getLHS() <em>LHS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLHS()
	 * @generated
	 * @ordered
	 */
	protected Variable lhs;

	/**
	 * The cached value of the '{@link #getRHS() <em>RHS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRHS()
	 * @generated
	 * @ordered
	 */
	protected IntExpression rhs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getLHS() {
		if (lhs != null && lhs.eIsProxy()) {
			InternalEObject oldLHS = (InternalEObject)lhs;
			lhs = (Variable)eResolveProxy(oldLHS);
			if (lhs != oldLHS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScopPackage.SCOP_ASSIGNMENT__LHS, oldLHS, lhs));
			}
		}
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetLHS() {
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLHS(Variable newLHS) {
		Variable oldLHS = lhs;
		lhs = newLHS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_ASSIGNMENT__LHS, oldLHS, lhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getRHS() {
		if (rhs != null && rhs.eIsProxy()) {
			InternalEObject oldRHS = (InternalEObject)rhs;
			rhs = (IntExpression)eResolveProxy(oldRHS);
			if (rhs != oldRHS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScopPackage.SCOP_ASSIGNMENT__RHS, oldRHS, rhs));
			}
		}
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression basicGetRHS() {
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRHS(IntExpression newRHS) {
		IntExpression oldRHS = rhs;
		rhs = newRHS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_ASSIGNMENT__RHS, oldRHS, rhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitScopAssignment(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScopPackage.SCOP_ASSIGNMENT__LHS:
				if (resolve) return getLHS();
				return basicGetLHS();
			case ScopPackage.SCOP_ASSIGNMENT__RHS:
				if (resolve) return getRHS();
				return basicGetRHS();
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
			case ScopPackage.SCOP_ASSIGNMENT__LHS:
				setLHS((Variable)newValue);
				return;
			case ScopPackage.SCOP_ASSIGNMENT__RHS:
				setRHS((IntExpression)newValue);
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
			case ScopPackage.SCOP_ASSIGNMENT__LHS:
				setLHS((Variable)null);
				return;
			case ScopPackage.SCOP_ASSIGNMENT__RHS:
				setRHS((IntExpression)null);
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
			case ScopPackage.SCOP_ASSIGNMENT__LHS:
				return lhs != null;
			case ScopPackage.SCOP_ASSIGNMENT__RHS:
				return rhs != null;
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
				case ScopPackage.SCOP_VISITABLE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopNode.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopStatement.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_STATEMENT___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR;
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
			case ScopPackage.SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ScopAssignmentImpl
