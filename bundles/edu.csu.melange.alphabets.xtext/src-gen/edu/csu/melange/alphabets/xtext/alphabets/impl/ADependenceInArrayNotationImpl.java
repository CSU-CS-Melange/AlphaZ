/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ADependence In Array Notation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl#getVar <em>Var</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.ADependenceInArrayNotationImpl#getDep <em>Dep</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ADependenceInArrayNotationImpl extends AAlphabetsExpressionImpl implements ADependenceInArrayNotation
{
  /**
   * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected static final String VAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected String var = VAR_EDEFAULT;

  /**
   * The cached value of the '{@link #getDep() <em>Dep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDep()
   * @generated
   * @ordered
   */
  protected AIndexAffineExpressionList dep;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ADependenceInArrayNotationImpl()
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
    return AlphabetsPackage.Literals.ADEPENDENCE_IN_ARRAY_NOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar(String newVar)
  {
    String oldVar = var;
    var = newVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__VAR, oldVar, var));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AIndexAffineExpressionList getDep()
  {
    return dep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDep(AIndexAffineExpressionList newDep, NotificationChain msgs)
  {
    AIndexAffineExpressionList oldDep = dep;
    dep = newDep;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP, oldDep, newDep);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDep(AIndexAffineExpressionList newDep)
  {
    if (newDep != dep)
    {
      NotificationChain msgs = null;
      if (dep != null)
        msgs = ((InternalEObject)dep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP, null, msgs);
      if (newDep != null)
        msgs = ((InternalEObject)newDep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP, null, msgs);
      msgs = basicSetDep(newDep, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP, newDep, newDep));
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
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP:
        return basicSetDep(null, msgs);
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
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__VAR:
        return getVar();
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP:
        return getDep();
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
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__VAR:
        setVar((String)newValue);
        return;
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP:
        setDep((AIndexAffineExpressionList)newValue);
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
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__VAR:
        setVar(VAR_EDEFAULT);
        return;
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP:
        setDep((AIndexAffineExpressionList)null);
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
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__VAR:
        return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
      case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION__DEP:
        return dep != null;
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
    result.append(" (var: ");
    result.append(var);
    result.append(')');
    return result.toString();
  }

} //ADependenceInArrayNotationImpl
