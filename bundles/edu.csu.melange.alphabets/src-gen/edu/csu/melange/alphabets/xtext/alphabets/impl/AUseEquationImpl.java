/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AUseEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AUse Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AUseEquationImpl#getExtDom <em>Ext Dom</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AUseEquationImpl#getNameSubSys <em>Name Sub Sys</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AUseEquationImpl#getParam <em>Param</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AUseEquationImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AUseEquationImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AUseEquationImpl extends AEquationImpl implements AUseEquation
{
  /**
	 * The cached value of the '{@link #getExtDom() <em>Ext Dom</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExtDom()
	 * @generated
	 * @ordered
	 */
  protected ADomain extDom;

  /**
	 * The default value of the '{@link #getNameSubSys() <em>Name Sub Sys</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNameSubSys()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_SUB_SYS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getNameSubSys() <em>Name Sub Sys</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNameSubSys()
	 * @generated
	 * @ordered
	 */
  protected String nameSubSys = NAME_SUB_SYS_EDEFAULT;

  /**
	 * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParam()
	 * @generated
	 * @ordered
	 */
  protected AIndexAffineExpressionList param;

  /**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
  protected EList<AAlphabetsExpression> inputs;

  /**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
  protected AIdentifierList outputs;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AUseEquationImpl()
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
		return AlphabetsPackage.Literals.AUSE_EQUATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADomain getExtDom()
  {
		return extDom;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExtDom(ADomain newExtDom, NotificationChain msgs)
  {
		ADomain oldExtDom = extDom;
		extDom = newExtDom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__EXT_DOM, oldExtDom, newExtDom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExtDom(ADomain newExtDom)
  {
		if (newExtDom != extDom) {
			NotificationChain msgs = null;
			if (extDom != null)
				msgs = ((InternalEObject)extDom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__EXT_DOM, null, msgs);
			if (newExtDom != null)
				msgs = ((InternalEObject)newExtDom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__EXT_DOM, null, msgs);
			msgs = basicSetExtDom(newExtDom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__EXT_DOM, newExtDom, newExtDom));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getNameSubSys()
  {
		return nameSubSys;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNameSubSys(String newNameSubSys)
  {
		String oldNameSubSys = nameSubSys;
		nameSubSys = newNameSubSys;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__NAME_SUB_SYS, oldNameSubSys, nameSubSys));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIndexAffineExpressionList getParam()
  {
		return param;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetParam(AIndexAffineExpressionList newParam, NotificationChain msgs)
  {
		AIndexAffineExpressionList oldParam = param;
		param = newParam;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__PARAM, oldParam, newParam);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParam(AIndexAffineExpressionList newParam)
  {
		if (newParam != param) {
			NotificationChain msgs = null;
			if (param != null)
				msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__PARAM, null, msgs);
			if (newParam != null)
				msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__PARAM, null, msgs);
			msgs = basicSetParam(newParam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__PARAM, newParam, newParam));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AAlphabetsExpression> getInputs()
  {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<AAlphabetsExpression>(AAlphabetsExpression.class, this, AlphabetsPackage.AUSE_EQUATION__INPUTS);
		}
		return inputs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIdentifierList getOutputs()
  {
		return outputs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetOutputs(AIdentifierList newOutputs, NotificationChain msgs)
  {
		AIdentifierList oldOutputs = outputs;
		outputs = newOutputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__OUTPUTS, oldOutputs, newOutputs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOutputs(AIdentifierList newOutputs)
  {
		if (newOutputs != outputs) {
			NotificationChain msgs = null;
			if (outputs != null)
				msgs = ((InternalEObject)outputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__OUTPUTS, null, msgs);
			if (newOutputs != null)
				msgs = ((InternalEObject)newOutputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AUSE_EQUATION__OUTPUTS, null, msgs);
			msgs = basicSetOutputs(newOutputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AUSE_EQUATION__OUTPUTS, newOutputs, newOutputs));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAUseEquation(this);
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
			case AlphabetsPackage.AUSE_EQUATION__EXT_DOM:
				return basicSetExtDom(null, msgs);
			case AlphabetsPackage.AUSE_EQUATION__PARAM:
				return basicSetParam(null, msgs);
			case AlphabetsPackage.AUSE_EQUATION__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case AlphabetsPackage.AUSE_EQUATION__OUTPUTS:
				return basicSetOutputs(null, msgs);
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
			case AlphabetsPackage.AUSE_EQUATION__EXT_DOM:
				return getExtDom();
			case AlphabetsPackage.AUSE_EQUATION__NAME_SUB_SYS:
				return getNameSubSys();
			case AlphabetsPackage.AUSE_EQUATION__PARAM:
				return getParam();
			case AlphabetsPackage.AUSE_EQUATION__INPUTS:
				return getInputs();
			case AlphabetsPackage.AUSE_EQUATION__OUTPUTS:
				return getOutputs();
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
		switch (featureID) {
			case AlphabetsPackage.AUSE_EQUATION__EXT_DOM:
				setExtDom((ADomain)newValue);
				return;
			case AlphabetsPackage.AUSE_EQUATION__NAME_SUB_SYS:
				setNameSubSys((String)newValue);
				return;
			case AlphabetsPackage.AUSE_EQUATION__PARAM:
				setParam((AIndexAffineExpressionList)newValue);
				return;
			case AlphabetsPackage.AUSE_EQUATION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends AAlphabetsExpression>)newValue);
				return;
			case AlphabetsPackage.AUSE_EQUATION__OUTPUTS:
				setOutputs((AIdentifierList)newValue);
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
			case AlphabetsPackage.AUSE_EQUATION__EXT_DOM:
				setExtDom((ADomain)null);
				return;
			case AlphabetsPackage.AUSE_EQUATION__NAME_SUB_SYS:
				setNameSubSys(NAME_SUB_SYS_EDEFAULT);
				return;
			case AlphabetsPackage.AUSE_EQUATION__PARAM:
				setParam((AIndexAffineExpressionList)null);
				return;
			case AlphabetsPackage.AUSE_EQUATION__INPUTS:
				getInputs().clear();
				return;
			case AlphabetsPackage.AUSE_EQUATION__OUTPUTS:
				setOutputs((AIdentifierList)null);
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
			case AlphabetsPackage.AUSE_EQUATION__EXT_DOM:
				return extDom != null;
			case AlphabetsPackage.AUSE_EQUATION__NAME_SUB_SYS:
				return NAME_SUB_SYS_EDEFAULT == null ? nameSubSys != null : !NAME_SUB_SYS_EDEFAULT.equals(nameSubSys);
			case AlphabetsPackage.AUSE_EQUATION__PARAM:
				return param != null;
			case AlphabetsPackage.AUSE_EQUATION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case AlphabetsPackage.AUSE_EQUATION__OUTPUTS:
				return outputs != null;
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
		result.append(" (nameSubSys: ");
		result.append(nameSubSys);
		result.append(')');
		return result.toString();
	}

} //AUseEquationImpl
