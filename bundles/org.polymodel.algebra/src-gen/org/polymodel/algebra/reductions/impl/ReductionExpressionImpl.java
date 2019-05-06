/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.reductions.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.impl.IntExpressionImpl;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.algebra.reductions.ReductionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reduction Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.reductions.impl.ReductionExpressionImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.polymodel.algebra.reductions.impl.ReductionExpressionImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReductionExpressionImpl extends IntExpressionImpl implements ReductionExpression {
	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> expressions;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final ReductionOperator OPERATOR_EDEFAULT = ReductionOperator.MIN;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected ReductionOperator operator = OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReductionExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReductionsPackage.Literals.REDUCTION_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReductionOperator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(ReductionOperator newOperator) {
		ReductionOperator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReductionsPackage.REDUCTION_EXPRESSION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitReductionExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS:
				return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
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
			case ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS:
				return getExpressions();
			case ReductionsPackage.REDUCTION_EXPRESSION__OPERATOR:
				return getOperator();
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
			case ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS:
				getExpressions().clear();
				getExpressions().addAll((Collection<? extends IntExpression>)newValue);
				return;
			case ReductionsPackage.REDUCTION_EXPRESSION__OPERATOR:
				setOperator((ReductionOperator)newValue);
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
			case ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS:
				getExpressions().clear();
				return;
			case ReductionsPackage.REDUCTION_EXPRESSION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
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
			case ReductionsPackage.REDUCTION_EXPRESSION__EXPRESSIONS:
				return expressions != null && !expressions.isEmpty();
			case ReductionsPackage.REDUCTION_EXPRESSION__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
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
			case ReductionsPackage.REDUCTION_EXPRESSION___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
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
		return operator.toString()+getExpressions();
	}
	
	@Override
	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
		List<IntExpression> newExprs = new ArrayList<IntExpression>(getExpressions().size());
		for (IntExpression expr : getExpressions()) {
			newExprs.add(expr.substitute(substituted, newExpr));
		}
		ReductionExpression copy = EcoreUtil.copy(this);
		copy.getExpressions().clear();
		copy.getExpressions().addAll(newExprs);
		return copy;
	}
	
	@Override
	public IntExpression substitute(Variable substituted, Variable newVar) {
		List<IntExpression> newExprs = new ArrayList<IntExpression>(getExpressions().size());
		for (IntExpression expr : getExpressions()) {
			newExprs.add(expr.substitute(substituted, newVar));
		}
		ReductionExpression copy = EcoreUtil.copy(this);
		copy.getExpressions().clear();
		copy.getExpressions().addAll(newExprs);
		return copy;
	}

	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}
} //ReductionExpressionImpl