/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AModuloExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AModulo Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AModuloExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AModuloExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AModuloExpressionImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AModuloExpressionImpl extends AAlphabetsExpressionImpl implements AModuloExpression
{
  /**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
  protected AAlphabetsExpression left;

  /**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
  protected static final String OP_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
  protected String op = OP_EDEFAULT;

  /**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
  protected AAlphabetsExpression right;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AModuloExpressionImpl()
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
		return AlphabetsPackage.Literals.AMODULO_EXPRESSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAlphabetsExpression getLeft()
  {
		return left;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLeft(AAlphabetsExpression newLeft, NotificationChain msgs)
  {
		AAlphabetsExpression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AMODULO_EXPRESSION__LEFT, oldLeft, newLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLeft(AAlphabetsExpression newLeft)
  {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AMODULO_EXPRESSION__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AMODULO_EXPRESSION__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AMODULO_EXPRESSION__LEFT, newLeft, newLeft));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getOp()
  {
		return op;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOp(String newOp)
  {
		String oldOp = op;
		op = newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AMODULO_EXPRESSION__OP, oldOp, op));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAlphabetsExpression getRight()
  {
		return right;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRight(AAlphabetsExpression newRight, NotificationChain msgs)
  {
		AAlphabetsExpression oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AMODULO_EXPRESSION__RIGHT, oldRight, newRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRight(AAlphabetsExpression newRight)
  {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AMODULO_EXPRESSION__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AMODULO_EXPRESSION__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AMODULO_EXPRESSION__RIGHT, newRight, newRight));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAModuloExpression(this);
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
			case AlphabetsPackage.AMODULO_EXPRESSION__LEFT:
				return basicSetLeft(null, msgs);
			case AlphabetsPackage.AMODULO_EXPRESSION__RIGHT:
				return basicSetRight(null, msgs);
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
			case AlphabetsPackage.AMODULO_EXPRESSION__LEFT:
				return getLeft();
			case AlphabetsPackage.AMODULO_EXPRESSION__OP:
				return getOp();
			case AlphabetsPackage.AMODULO_EXPRESSION__RIGHT:
				return getRight();
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
			case AlphabetsPackage.AMODULO_EXPRESSION__LEFT:
				setLeft((AAlphabetsExpression)newValue);
				return;
			case AlphabetsPackage.AMODULO_EXPRESSION__OP:
				setOp((String)newValue);
				return;
			case AlphabetsPackage.AMODULO_EXPRESSION__RIGHT:
				setRight((AAlphabetsExpression)newValue);
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
			case AlphabetsPackage.AMODULO_EXPRESSION__LEFT:
				setLeft((AAlphabetsExpression)null);
				return;
			case AlphabetsPackage.AMODULO_EXPRESSION__OP:
				setOp(OP_EDEFAULT);
				return;
			case AlphabetsPackage.AMODULO_EXPRESSION__RIGHT:
				setRight((AAlphabetsExpression)null);
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
			case AlphabetsPackage.AMODULO_EXPRESSION__LEFT:
				return left != null;
			case AlphabetsPackage.AMODULO_EXPRESSION__OP:
				return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
			case AlphabetsPackage.AMODULO_EXPRESSION__RIGHT:
				return right != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} //AModuloExpressionImpl
