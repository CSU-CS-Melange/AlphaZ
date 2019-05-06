/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AProgram;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AProgram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl#getExternalFunctions <em>External Functions</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AProgramImpl#getSystems <em>Systems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AProgramImpl extends MinimalEObjectImpl.Container implements AProgram
{
  /**
   * The cached value of the '{@link #getExternalFunctions() <em>External Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalFunctions()
   * @generated
   * @ordered
   */
  protected EList<AExternalFunctionDeclaration> externalFunctions;

  /**
   * The cached value of the '{@link #getSystems() <em>Systems</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystems()
   * @generated
   * @ordered
   */
  protected EList<AAffineSystem> systems;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AProgramImpl()
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
    return AlphabetsPackage.Literals.APROGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AExternalFunctionDeclaration> getExternalFunctions()
  {
    if (externalFunctions == null)
    {
      externalFunctions = new EObjectContainmentEList<AExternalFunctionDeclaration>(AExternalFunctionDeclaration.class, this, AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS);
    }
    return externalFunctions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AAffineSystem> getSystems()
  {
    if (systems == null)
    {
      systems = new EObjectContainmentEList<AAffineSystem>(AAffineSystem.class, this, AlphabetsPackage.APROGRAM__SYSTEMS);
    }
    return systems;
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
      case AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS:
        return ((InternalEList<?>)getExternalFunctions()).basicRemove(otherEnd, msgs);
      case AlphabetsPackage.APROGRAM__SYSTEMS:
        return ((InternalEList<?>)getSystems()).basicRemove(otherEnd, msgs);
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
      case AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS:
        return getExternalFunctions();
      case AlphabetsPackage.APROGRAM__SYSTEMS:
        return getSystems();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS:
        getExternalFunctions().clear();
        getExternalFunctions().addAll((Collection<? extends AExternalFunctionDeclaration>)newValue);
        return;
      case AlphabetsPackage.APROGRAM__SYSTEMS:
        getSystems().clear();
        getSystems().addAll((Collection<? extends AAffineSystem>)newValue);
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
      case AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS:
        getExternalFunctions().clear();
        return;
      case AlphabetsPackage.APROGRAM__SYSTEMS:
        getSystems().clear();
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
      case AlphabetsPackage.APROGRAM__EXTERNAL_FUNCTIONS:
        return externalFunctions != null && !externalFunctions.isEmpty();
      case AlphabetsPackage.APROGRAM__SYSTEMS:
        return systems != null && !systems.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AProgramImpl
