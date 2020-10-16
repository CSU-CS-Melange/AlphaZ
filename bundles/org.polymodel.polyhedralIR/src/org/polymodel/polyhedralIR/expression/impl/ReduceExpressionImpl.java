/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reduce Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl#getOP <em>OP</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl#getProjection <em>Projection</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.ReduceExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReduceExpressionImpl extends ExpressionImpl implements ReduceExpression {
	/**
	 * The default value of the '{@link #getOP() <em>OP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOP()
	 * @generated
	 * @ordered
	 */
	protected static final OP OP_EDEFAULT = OP.ADD;

	/**
	 * The cached value of the '{@link #getOP() <em>OP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOP()
	 * @generated
	 * @ordered
	 */
	protected OP op = OP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjection() <em>Projection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjection()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction projection;

	/**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected Expression expr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReduceExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.REDUCE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OP getOP() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOP(OP newOP) {
		OP oldOP = op;
		op = newOP == null ? OP_EDEFAULT : newOP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.REDUCE_EXPRESSION__OP, oldOP, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getProjection() {
		return projection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjection(AffineFunction newProjection, NotificationChain msgs) {
		AffineFunction oldProjection = projection;
		projection = newProjection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.REDUCE_EXPRESSION__PROJECTION, oldProjection, newProjection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjection(AffineFunction newProjection) {
		if (newProjection != projection) {
			NotificationChain msgs = null;
			if (projection != null)
				msgs = ((InternalEObject)projection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.REDUCE_EXPRESSION__PROJECTION, null, msgs);
			if (newProjection != null)
				msgs = ((InternalEObject)newProjection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.REDUCE_EXPRESSION__PROJECTION, null, msgs);
			msgs = basicSetProjection(newProjection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.REDUCE_EXPRESSION__PROJECTION, newProjection, newProjection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr() {
		return expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs) {
		Expression oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.REDUCE_EXPRESSION__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.REDUCE_EXPRESSION__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.REDUCE_EXPRESSION__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.REDUCE_EXPRESSION__EXPR, newExpr, newExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated　NOT
	 */
	public IntExpression getIdentityValue() {
		Type expressionType = getExpressionType();
		switch (getOP()) {
			case ADD:
			case OR:
				return  affine(term(0));
			case MUL:
			case AND:
				return  affine(term(1));
			case MAX:
				//When unsigned, 0 is the minimum
				if (expressionType.getSigned() == SIGNED.UNSIGNED) {
					return affine(term(0));
				//Otherwise, use symbolic value MIN_INT
				} else {
					if (expressionType.getTypeID().equals(DATATYPE.FLOATING_POINT)) {
						if (expressionType.getWidth() == DATATYPE.SINGLE_PRECISION_WIDTH) {
							return affine(term(-1, IntExpressionBuilder.var("FLT_MAX")));
						} else {
							return affine(term(-1, IntExpressionBuilder.var("DBL_MAX")));
						}
					} else {
						return affine(term(1, IntExpressionBuilder.var("INT_MIN")));
//						IntMin min = IntegerExpressionUserFactory.intMin();
//						IntExpressionBuilder.
//						min.setSigned(true);
//						min.setWidth(getExpressionType().getWidth());
//						return min;
					}
				}
			case MIN:
				if (expressionType.getTypeID().equals(DATATYPE.FLOATING_POINT)) {
					if (expressionType.getWidth() == DATATYPE.SINGLE_PRECISION_WIDTH) {
						return affine(term(1, IntExpressionBuilder.var("FLT_MAX")));
					} else {
						return affine(term(1, IntExpressionBuilder.var("DBL_MAX")));
					}
				} else {
					return affine(term(1, IntExpressionBuilder.var("INT_MAX")));
//					IntMax max = IntegerExpressionUserFactory.intMax();
//					max.setSigned(getExpressionType().getSigned() == SIGNED.SIGNED);
//					max.setWidth(getExpressionType().getWidth());
//					return max;
				}
			default:
				throw new RuntimeException("Reduction with operator " + getOP() + " is currently not supported.");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitReduceExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.REDUCE_EXPRESSION__PROJECTION:
				return basicSetProjection(null, msgs);
			case ExpressionPackage.REDUCE_EXPRESSION__EXPR:
				return basicSetExpr(null, msgs);
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
			case ExpressionPackage.REDUCE_EXPRESSION__OP:
				return getOP();
			case ExpressionPackage.REDUCE_EXPRESSION__PROJECTION:
				return getProjection();
			case ExpressionPackage.REDUCE_EXPRESSION__EXPR:
				return getExpr();
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
			case ExpressionPackage.REDUCE_EXPRESSION__OP:
				setOP((OP)newValue);
				return;
			case ExpressionPackage.REDUCE_EXPRESSION__PROJECTION:
				setProjection((AffineFunction)newValue);
				return;
			case ExpressionPackage.REDUCE_EXPRESSION__EXPR:
				setExpr((Expression)newValue);
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
			case ExpressionPackage.REDUCE_EXPRESSION__OP:
				setOP(OP_EDEFAULT);
				return;
			case ExpressionPackage.REDUCE_EXPRESSION__PROJECTION:
				setProjection((AffineFunction)null);
				return;
			case ExpressionPackage.REDUCE_EXPRESSION__EXPR:
				setExpr((Expression)null);
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
			case ExpressionPackage.REDUCE_EXPRESSION__OP:
				return op != OP_EDEFAULT;
			case ExpressionPackage.REDUCE_EXPRESSION__PROJECTION:
				return projection != null;
			case ExpressionPackage.REDUCE_EXPRESSION__EXPR:
				return expr != null;
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
		result.append(" (OP: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public Type basicGetExpressionType() {
		return getExpr().getExpressionType();
	}
	
	@Override
	public boolean equivalence(Expression expr) {
		if (!(expr instanceof ReduceExpression))
			return false;
		ReduceExpression rexpr = (ReduceExpression) expr;
		if (this.getOP()!=rexpr.getOP())
			return false;
		if (!(this.getProjection().equivalence(rexpr.getProjection())))
			return false;
		return (this.getExpr().equivalence(rexpr.getExpr()));
	}
	
} //ReduceExpressionImpl
