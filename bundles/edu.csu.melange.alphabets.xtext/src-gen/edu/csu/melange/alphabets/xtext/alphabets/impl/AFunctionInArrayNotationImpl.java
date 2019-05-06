/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AFunction In Array Notation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AFunctionInArrayNotationImpl#getNewIds <em>New Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AFunctionInArrayNotationImpl extends MinimalEObjectImpl.Container implements AFunctionInArrayNotation
{
  /**
   * The cached value of the '{@link #getNewIds() <em>New Ids</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewIds()
   * @generated
   * @ordered
   */
  protected AIndexAffineExpressionList newIds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AFunctionInArrayNotationImpl()
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
    return AlphabetsPackage.Literals.AFUNCTION_IN_ARRAY_NOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AIndexAffineExpressionList getNewIds()
  {
    return newIds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewIds(AIndexAffineExpressionList newNewIds, NotificationChain msgs)
  {
    AIndexAffineExpressionList oldNewIds = newIds;
    newIds = newNewIds;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS, oldNewIds, newNewIds);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewIds(AIndexAffineExpressionList newNewIds)
  {
    if (newNewIds != newIds)
    {
      NotificationChain msgs = null;
      if (newIds != null)
        msgs = ((InternalEObject)newIds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS, null, msgs);
      if (newNewIds != null)
        msgs = ((InternalEObject)newNewIds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS, null, msgs);
      msgs = basicSetNewIds(newNewIds, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS, newNewIds, newNewIds));
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
      case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS:
        return basicSetNewIds(null, msgs);
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
      case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS:
        return getNewIds();
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
      case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS:
        setNewIds((AIndexAffineExpressionList)newValue);
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
      case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS:
        setNewIds((AIndexAffineExpressionList)null);
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
      case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS:
        return newIds != null;
    }
    return super.eIsSet(featureID);
  }

} //AFunctionInArrayNotationImpl
