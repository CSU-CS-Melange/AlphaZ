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
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restrict Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl#getRestrictDomain <em>Restrict Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.RestrictExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestrictExpressionImpl extends ExpressionImpl implements RestrictExpression {
	/**
	 * The cached value of the '{@link #getRestrictDomain() <em>Restrict Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain restrictDomain;
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
	protected RestrictExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.RESTRICT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getRestrictDomain() {
		return restrictDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestrictDomain(Domain newRestrictDomain, NotificationChain msgs) {
		Domain oldRestrictDomain = restrictDomain;
		restrictDomain = newRestrictDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN, oldRestrictDomain, newRestrictDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictDomain(Domain newRestrictDomain) {
		if (newRestrictDomain != restrictDomain) {
			NotificationChain msgs = null;
			if (restrictDomain != null)
				msgs = ((InternalEObject)restrictDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN, null, msgs);
			if (newRestrictDomain != null)
				msgs = ((InternalEObject)newRestrictDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN, null, msgs);
			msgs = basicSetRestrictDomain(newRestrictDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN, newRestrictDomain, newRestrictDomain));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESTRICT_EXPRESSION__EXPR, oldExpr, newExpr);
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
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESTRICT_EXPRESSION__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESTRICT_EXPRESSION__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESTRICT_EXPRESSION__EXPR, newExpr, newExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitRestrictExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN:
				return basicSetRestrictDomain(null, msgs);
			case ExpressionPackage.RESTRICT_EXPRESSION__EXPR:
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
			case ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN:
				return getRestrictDomain();
			case ExpressionPackage.RESTRICT_EXPRESSION__EXPR:
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
			case ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN:
				setRestrictDomain((Domain)newValue);
				return;
			case ExpressionPackage.RESTRICT_EXPRESSION__EXPR:
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
			case ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN:
				setRestrictDomain((Domain)null);
				return;
			case ExpressionPackage.RESTRICT_EXPRESSION__EXPR:
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
			case ExpressionPackage.RESTRICT_EXPRESSION__RESTRICT_DOMAIN:
				return restrictDomain != null;
			case ExpressionPackage.RESTRICT_EXPRESSION__EXPR:
				return expr != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Type basicGetExpressionType() {
		return getExpr().getExpressionType();
	}

	@Override
	public boolean equivalence(Expression expr) {
		if (!(expr instanceof RestrictExpression))
			return false;
		RestrictExpression rexpr = (RestrictExpression) expr;
		if (!(this.getRestrictDomain().equivalence(rexpr.getRestrictDomain())))
			return false;
		return (this.getExpr().equivalence(rexpr.getExpr()));
	}
	
} //RestrictExpressionImpl
