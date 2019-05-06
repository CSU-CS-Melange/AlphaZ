/**
 */
package org.polymodel.algebra.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.impl.SelectExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.polymodel.algebra.impl.SelectExpressionImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.polymodel.algebra.impl.SelectExpressionImpl#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectExpressionImpl extends IntExpressionImpl implements SelectExpression {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<IntConstraintSystem> condition;

	/**
	 * The cached value of the '{@link #getThen() <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThen()
	 * @generated
	 * @ordered
	 */
	protected IntExpression then;

	/**
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected IntExpression else_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.SELECT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntConstraintSystem> getCondition() {
		if (condition == null) {
			condition = new EObjectResolvingEList<IntConstraintSystem>(IntConstraintSystem.class, this, AlgebraPackage.SELECT_EXPRESSION__CONDITION);
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getThen() {
		return then;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThen(IntExpression newThen, NotificationChain msgs) {
		IntExpression oldThen = then;
		then = newThen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraPackage.SELECT_EXPRESSION__THEN, oldThen, newThen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThen(IntExpression newThen) {
		if (newThen != then) {
			NotificationChain msgs = null;
			if (then != null)
				msgs = ((InternalEObject)then).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.SELECT_EXPRESSION__THEN, null, msgs);
			if (newThen != null)
				msgs = ((InternalEObject)newThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.SELECT_EXPRESSION__THEN, null, msgs);
			msgs = basicSetThen(newThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.SELECT_EXPRESSION__THEN, newThen, newThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getElse() {
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElse(IntExpression newElse, NotificationChain msgs) {
		IntExpression oldElse = else_;
		else_ = newElse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraPackage.SELECT_EXPRESSION__ELSE, oldElse, newElse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(IntExpression newElse) {
		if (newElse != else_) {
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.SELECT_EXPRESSION__ELSE, null, msgs);
			if (newElse != null)
				msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.SELECT_EXPRESSION__ELSE, null, msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.SELECT_EXPRESSION__ELSE, newElse, newElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgebraPackage.SELECT_EXPRESSION__THEN:
				return basicSetThen(null, msgs);
			case AlgebraPackage.SELECT_EXPRESSION__ELSE:
				return basicSetElse(null, msgs);
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
			case AlgebraPackage.SELECT_EXPRESSION__CONDITION:
				return getCondition();
			case AlgebraPackage.SELECT_EXPRESSION__THEN:
				return getThen();
			case AlgebraPackage.SELECT_EXPRESSION__ELSE:
				return getElse();
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
			case AlgebraPackage.SELECT_EXPRESSION__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends IntConstraintSystem>)newValue);
				return;
			case AlgebraPackage.SELECT_EXPRESSION__THEN:
				setThen((IntExpression)newValue);
				return;
			case AlgebraPackage.SELECT_EXPRESSION__ELSE:
				setElse((IntExpression)newValue);
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
			case AlgebraPackage.SELECT_EXPRESSION__CONDITION:
				getCondition().clear();
				return;
			case AlgebraPackage.SELECT_EXPRESSION__THEN:
				setThen((IntExpression)null);
				return;
			case AlgebraPackage.SELECT_EXPRESSION__ELSE:
				setElse((IntExpression)null);
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
			case AlgebraPackage.SELECT_EXPRESSION__CONDITION:
				return condition != null && !condition.isEmpty();
			case AlgebraPackage.SELECT_EXPRESSION__THEN:
				return then != null;
			case AlgebraPackage.SELECT_EXPRESSION__ELSE:
				return else_ != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return "Select(" + getCondition() + ", " + getThen() + ", " + getElse() + ")";
	}
	
//	@Override
//	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
//		SelectExpression sExpression = (SelectExpression) this.copy();
//		List<IntConstraintSystem> cond = sExpression.getCondition();
//		List<IntConstraintSystem> newCond = new ArrayList<IntConstraintSystem>();
//		for ( IntConstraintSystem ics : cond ) {
//			newCond.add(ics.substitute(substituted, newExpr));
//		}
//		IntExpression t = sExpression.getThen().substitute(substituted, newExpr);
//		IntExpression e = sExpression.getElse().substitute(substituted, newExpr);
//		return IntExpressionBuilder.selectExpression(newCond, t, e);
//	}
	@Override
	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
		List<IntConstraintSystem> newCond = getCondition().stream()
			.map(s -> s.substitute(substituted, newExpr))
			.collect(Collectors.toList());
		
		SelectExpression copy = EcoreUtil.copy(this);
		copy.getCondition().clear();
		copy.getCondition().addAll(newCond);
		copy.setThen(getThen().substitute(substituted, newExpr));
		copy.setElse(getElse().substitute(substituted, newExpr));
		return copy;
	}
	
	@Override
	public IntExpression substitute(Variable substituted, Variable newVar) {
		List<IntConstraintSystem> newCond = getCondition().stream()
			.map(s -> s.substitute(substituted, newVar))
			.collect(Collectors.toList());
		
		SelectExpression copy = EcoreUtil.copy(this);
		copy.getCondition().clear();
		copy.getCondition().addAll(newCond);
		copy.setThen(getThen().substitute(substituted, newVar));
		copy.setElse(getElse().substitute(substituted, newVar));
		return copy;
	}
	
	@Override
	public String toString(OUTPUT_FORMAT format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(AlgebraVisitor visitor) {
		visitor.visitSelectExpression(this);
	}
	
} //SelectExpressionImpl
