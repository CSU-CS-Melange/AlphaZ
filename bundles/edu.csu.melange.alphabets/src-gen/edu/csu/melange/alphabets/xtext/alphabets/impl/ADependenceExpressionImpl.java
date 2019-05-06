/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AFunction;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ADependence Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl#getFunc <em>Func</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ADependenceExpressionImpl extends AAlphabetsExpressionImpl implements ADependenceExpression
{
  /**
	 * The cached value of the '{@link #getFunc() <em>Func</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFunc()
	 * @generated
	 * @ordered
	 */
  protected AFunction func;

  /**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
  protected AAlphabetsExpression expr;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ADependenceExpressionImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return AlphabetsPackage.Literals.ADEPENDENCE_EXPRESSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AFunction getFunc()
  {
		return func;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFunc(AFunction newFunc, NotificationChain msgs)
  {
		AFunction oldFunc = func;
		func = newFunc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC, oldFunc, newFunc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFunc(AFunction newFunc)
  {
		if (newFunc != func) {
			NotificationChain msgs = null;
			if (func != null)
				msgs = ((InternalEObject)func).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC, null, msgs);
			if (newFunc != null)
				msgs = ((InternalEObject)newFunc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC, null, msgs);
			msgs = basicSetFunc(newFunc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC, newFunc, newFunc));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAlphabetsExpression getExpr()
  {
		return expr;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExpr(AAlphabetsExpression newExpr, NotificationChain msgs)
  {
		AAlphabetsExpression oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpr(AAlphabetsExpression newExpr)
  {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR, newExpr, newExpr));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitADependenceExpression(this);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC:
				return basicSetFunc(null, msgs);
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC:
				return getFunc();
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR:
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC:
				setFunc((AFunction)newValue);
				return;
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR:
				setExpr((AAlphabetsExpression)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC:
				setFunc((AFunction)null);
				return;
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR:
				setExpr((AAlphabetsExpression)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__FUNC:
				return func != null;
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION__EXPR:
				return expr != null;
		}
		return super.eIsSet(featureID);
	}

} //ADependenceExpressionImpl
