/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AFunction;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AFunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionImpl#getFunc <em>Func</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AFunctionImpl extends MinimalEObjectImpl.Container implements AFunction
{
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
   * The cached value of the '{@link #getFunc() <em>Func</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunc()
   * @generated
   * @ordered
   */
  protected AIndexAffineExpressionList func;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AFunctionImpl()
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
    return AlphabetsPackage.Literals.AFUNCTION;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION__INDEXES, oldIndexes, newIndexes);
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
        msgs = ((InternalEObject)indexes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION__INDEXES, null, msgs);
      if (newIndexes != null)
        msgs = ((InternalEObject)newIndexes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION__INDEXES, null, msgs);
      msgs = basicSetIndexes(newIndexes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION__INDEXES, newIndexes, newIndexes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AIndexAffineExpressionList getFunc()
  {
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunc(AIndexAffineExpressionList newFunc, NotificationChain msgs)
  {
    AIndexAffineExpressionList oldFunc = func;
    func = newFunc;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION__FUNC, oldFunc, newFunc);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunc(AIndexAffineExpressionList newFunc)
  {
    if (newFunc != func)
    {
      NotificationChain msgs = null;
      if (func != null)
        msgs = ((InternalEObject)func).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION__FUNC, null, msgs);
      if (newFunc != null)
        msgs = ((InternalEObject)newFunc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION__FUNC, null, msgs);
      msgs = basicSetFunc(newFunc, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION__FUNC, newFunc, newFunc));
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
      case AlphabetsPackage.AFUNCTION__INDEXES:
        return basicSetIndexes(null, msgs);
      case AlphabetsPackage.AFUNCTION__FUNC:
        return basicSetFunc(null, msgs);
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
      case AlphabetsPackage.AFUNCTION__INDEXES:
        return getIndexes();
      case AlphabetsPackage.AFUNCTION__FUNC:
        return getFunc();
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
      case AlphabetsPackage.AFUNCTION__INDEXES:
        setIndexes((AIndexList)newValue);
        return;
      case AlphabetsPackage.AFUNCTION__FUNC:
        setFunc((AIndexAffineExpressionList)newValue);
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
      case AlphabetsPackage.AFUNCTION__INDEXES:
        setIndexes((AIndexList)null);
        return;
      case AlphabetsPackage.AFUNCTION__FUNC:
        setFunc((AIndexAffineExpressionList)null);
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
      case AlphabetsPackage.AFUNCTION__INDEXES:
        return indexes != null;
      case AlphabetsPackage.AFUNCTION__FUNC:
        return func != null;
    }
    return super.eIsSet(featureID);
  }

} //AFunctionImpl
