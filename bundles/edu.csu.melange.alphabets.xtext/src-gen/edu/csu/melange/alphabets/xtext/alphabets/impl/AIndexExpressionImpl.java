/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AIndex Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl#getFunc <em>Func</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexExpressionImpl#getIndexes <em>Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIndexExpressionImpl extends AAlphabetsExpressionImpl implements AIndexExpression
{
  /**
   * The default value of the '{@link #getFunc() <em>Func</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunc()
   * @generated
   * @ordered
   */
  protected static final String FUNC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFunc() <em>Func</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunc()
   * @generated
   * @ordered
   */
  protected String func = FUNC_EDEFAULT;

  /**
   * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexes()
   * @generated
   * @ordered
   */
  protected AIndexList indexes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AIndexExpressionImpl()
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
    return AlphabetsPackage.Literals.AINDEX_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFunc()
  {
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunc(String newFunc)
  {
    String oldFunc = func;
    func = newFunc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AINDEX_EXPRESSION__FUNC, oldFunc, func));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AIndexList getIndexes()
  {
    return indexes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndexes(AIndexList newIndexes, NotificationChain msgs)
  {
    AIndexList oldIndexes = indexes;
    indexes = newIndexes;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AINDEX_EXPRESSION__INDEXES, oldIndexes, newIndexes);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndexes(AIndexList newIndexes)
  {
    if (newIndexes != indexes)
    {
      NotificationChain msgs = null;
      if (indexes != null)
        msgs = ((InternalEObject)indexes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AINDEX_EXPRESSION__INDEXES, null, msgs);
      if (newIndexes != null)
        msgs = ((InternalEObject)newIndexes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AINDEX_EXPRESSION__INDEXES, null, msgs);
      msgs = basicSetIndexes(newIndexes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AINDEX_EXPRESSION__INDEXES, newIndexes, newIndexes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AlphabetsPackage.AINDEX_EXPRESSION__INDEXES:
        return basicSetIndexes(null, msgs);
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
    switch (featureID)
    {
      case AlphabetsPackage.AINDEX_EXPRESSION__FUNC:
        return getFunc();
      case AlphabetsPackage.AINDEX_EXPRESSION__INDEXES:
        return getIndexes();
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
    switch (featureID)
    {
      case AlphabetsPackage.AINDEX_EXPRESSION__FUNC:
        setFunc((String)newValue);
        return;
      case AlphabetsPackage.AINDEX_EXPRESSION__INDEXES:
        setIndexes((AIndexList)newValue);
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
    switch (featureID)
    {
      case AlphabetsPackage.AINDEX_EXPRESSION__FUNC:
        setFunc(FUNC_EDEFAULT);
        return;
      case AlphabetsPackage.AINDEX_EXPRESSION__INDEXES:
        setIndexes((AIndexList)null);
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
    switch (featureID)
    {
      case AlphabetsPackage.AINDEX_EXPRESSION__FUNC:
        return FUNC_EDEFAULT == null ? func != null : !FUNC_EDEFAULT.equals(func);
      case AlphabetsPackage.AINDEX_EXPRESSION__INDEXES:
        return indexes != null;
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
    result.append(" (func: ");
    result.append(func);
    result.append(')');
    return result.toString();
  }

} //AIndexExpressionImpl
