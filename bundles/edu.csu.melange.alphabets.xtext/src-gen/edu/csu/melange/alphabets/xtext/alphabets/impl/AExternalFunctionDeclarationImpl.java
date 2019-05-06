/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier;
import edu.csu.melange.alphabets.xtext.alphabets.AType;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AExternal Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AExternalFunctionDeclarationImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AExternalFunctionDeclarationImpl extends MinimalEObjectImpl.Container implements AExternalFunctionDeclaration
{
  /**
   * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected AType output;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected AExternalFunctionIdentifier name;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<AType> inputs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AExternalFunctionDeclarationImpl()
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
    return AlphabetsPackage.Literals.AEXTERNAL_FUNCTION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AType getOutput()
  {
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutput(AType newOutput, NotificationChain msgs)
  {
    AType oldOutput = output;
    output = newOutput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT, oldOutput, newOutput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutput(AType newOutput)
  {
    if (newOutput != output)
    {
      NotificationChain msgs = null;
      if (output != null)
        msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT, null, msgs);
      if (newOutput != null)
        msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT, null, msgs);
      msgs = basicSetOutput(newOutput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT, newOutput, newOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AExternalFunctionIdentifier getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(AExternalFunctionIdentifier newName, NotificationChain msgs)
  {
    AExternalFunctionIdentifier oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(AExternalFunctionIdentifier newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AType> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<AType>(AType.class, this, AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS);
    }
    return inputs;
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
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT:
        return basicSetOutput(null, msgs);
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME:
        return basicSetName(null, msgs);
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
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
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT:
        return getOutput();
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME:
        return getName();
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS:
        return getInputs();
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
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT:
        setOutput((AType)newValue);
        return;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME:
        setName((AExternalFunctionIdentifier)newValue);
        return;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends AType>)newValue);
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
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT:
        setOutput((AType)null);
        return;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME:
        setName((AExternalFunctionIdentifier)null);
        return;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS:
        getInputs().clear();
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
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__OUTPUT:
        return output != null;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__NAME:
        return name != null;
      case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION__INPUTS:
        return inputs != null && !inputs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AExternalFunctionDeclarationImpl
