/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl#getLexp <em>Lexp</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.BinaryExpressionImpl#getRexp <em>Rexp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryExpressionImpl extends ExpressionImpl implements BinaryExpression {
	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final OP OPERATOR_EDEFAULT = OP.ADD;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected OP operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLexp() <em>Lexp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLexp()
	 * @generated
	 * @ordered
	 */
	protected Expression lexp;

	/**
	 * The cached value of the '{@link #getRexp() <em>Rexp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRexp()
	 * @generated
	 * @ordered
	 */
	protected Expression rexp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.BINARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OP getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(OP newOperator) {
		OP oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.BINARY_EXPRESSION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLexp() {
		return lexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLexp(Expression newLexp, NotificationChain msgs) {
		Expression oldLexp = lexp;
		lexp = newLexp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.BINARY_EXPRESSION__LEXP, oldLexp, newLexp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLexp(Expression newLexp) {
		if (newLexp != lexp) {
			NotificationChain msgs = null;
			if (lexp != null)
				msgs = ((InternalEObject)lexp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.BINARY_EXPRESSION__LEXP, null, msgs);
			if (newLexp != null)
				msgs = ((InternalEObject)newLexp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.BINARY_EXPRESSION__LEXP, null, msgs);
			msgs = basicSetLexp(newLexp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.BINARY_EXPRESSION__LEXP, newLexp, newLexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRexp() {
		return rexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRexp(Expression newRexp, NotificationChain msgs) {
		Expression oldRexp = rexp;
		rexp = newRexp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.BINARY_EXPRESSION__REXP, oldRexp, newRexp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRexp(Expression newRexp) {
		if (newRexp != rexp) {
			NotificationChain msgs = null;
			if (rexp != null)
				msgs = ((InternalEObject)rexp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.BINARY_EXPRESSION__REXP, null, msgs);
			if (newRexp != null)
				msgs = ((InternalEObject)newRexp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.BINARY_EXPRESSION__REXP, null, msgs);
			msgs = basicSetRexp(newRexp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.BINARY_EXPRESSION__REXP, newRexp, newRexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitBinaryExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.BINARY_EXPRESSION__LEXP:
				return basicSetLexp(null, msgs);
			case ExpressionPackage.BINARY_EXPRESSION__REXP:
				return basicSetRexp(null, msgs);
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
			case ExpressionPackage.BINARY_EXPRESSION__OPERATOR:
				return getOperator();
			case ExpressionPackage.BINARY_EXPRESSION__LEXP:
				return getLexp();
			case ExpressionPackage.BINARY_EXPRESSION__REXP:
				return getRexp();
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
			case ExpressionPackage.BINARY_EXPRESSION__OPERATOR:
				setOperator((OP)newValue);
				return;
			case ExpressionPackage.BINARY_EXPRESSION__LEXP:
				setLexp((Expression)newValue);
				return;
			case ExpressionPackage.BINARY_EXPRESSION__REXP:
				setRexp((Expression)newValue);
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
			case ExpressionPackage.BINARY_EXPRESSION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case ExpressionPackage.BINARY_EXPRESSION__LEXP:
				setLexp((Expression)null);
				return;
			case ExpressionPackage.BINARY_EXPRESSION__REXP:
				setRexp((Expression)null);
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
			case ExpressionPackage.BINARY_EXPRESSION__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case ExpressionPackage.BINARY_EXPRESSION__LEXP:
				return lexp != null;
			case ExpressionPackage.BINARY_EXPRESSION__REXP:
				return rexp != null;
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public Type basicGetExpressionType() {
		//if the operator is a compare operator, set the expression type to be boolean 
		if(getOperator().isRelational()){
			Type type = PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.BOOL);
			return type;
		}
		
		Type left = getLexp().getExpressionType();
		Type right = getRexp().getExpressionType();
		
		//If they are the same, no problem
		if (left.equals(right)) {
			return left;
		}
		
		return mergeTypes(left, right);
	}
	
	@Override
	public boolean equivalence(Expression expr) {
		if (!(expr instanceof BinaryExpression))
			return false;
		if (!(this.getOperator() == ((BinaryExpression) expr).getOperator()))
			return false;
		if (!(this.getLexp().equivalence(((BinaryExpression) expr).getLexp())))
			return false;
		if (!(this.getRexp().equivalence(((BinaryExpression) expr).getRexp())))
			return false;
		return true;
	}
	
} //BinaryExpressionImpl
