/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AWhile Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AWhileDeclarationImpl#getTimeDomain <em>Time Domain</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AWhileDeclarationImpl#getCond <em>Cond</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AWhileDeclarationImpl extends MinimalEObjectImpl.Container implements AWhileDeclaration
{
  /**
	 * The cached value of the '{@link #getTimeDomain() <em>Time Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeDomain()
	 * @generated
	 * @ordered
	 */
  protected ADomain timeDomain;

  /**
	 * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCond()
	 * @generated
	 * @ordered
	 */
  protected AAlphabetsExpression cond;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AWhileDeclarationImpl()
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
		return AlphabetsPackage.Literals.AWHILE_DECLARATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADomain getTimeDomain()
  {
		return timeDomain;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTimeDomain(ADomain newTimeDomain, NotificationChain msgs)
  {
		ADomain oldTimeDomain = timeDomain;
		timeDomain = newTimeDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN, oldTimeDomain, newTimeDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTimeDomain(ADomain newTimeDomain)
  {
		if (newTimeDomain != timeDomain) {
			NotificationChain msgs = null;
			if (timeDomain != null)
				msgs = ((InternalEObject)timeDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN, null, msgs);
			if (newTimeDomain != null)
				msgs = ((InternalEObject)newTimeDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN, null, msgs);
			msgs = basicSetTimeDomain(newTimeDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN, newTimeDomain, newTimeDomain));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAlphabetsExpression getCond()
  {
		return cond;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCond(AAlphabetsExpression newCond, NotificationChain msgs)
  {
		AAlphabetsExpression oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AWHILE_DECLARATION__COND, oldCond, newCond);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCond(AAlphabetsExpression newCond)
  {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AWHILE_DECLARATION__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AWHILE_DECLARATION__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AWHILE_DECLARATION__COND, newCond, newCond));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAWhileDeclaration(this);
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
			case AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN:
				return basicSetTimeDomain(null, msgs);
			case AlphabetsPackage.AWHILE_DECLARATION__COND:
				return basicSetCond(null, msgs);
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
			case AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN:
				return getTimeDomain();
			case AlphabetsPackage.AWHILE_DECLARATION__COND:
				return getCond();
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
			case AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN:
				setTimeDomain((ADomain)newValue);
				return;
			case AlphabetsPackage.AWHILE_DECLARATION__COND:
				setCond((AAlphabetsExpression)newValue);
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
			case AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN:
				setTimeDomain((ADomain)null);
				return;
			case AlphabetsPackage.AWHILE_DECLARATION__COND:
				setCond((AAlphabetsExpression)null);
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
			case AlphabetsPackage.AWHILE_DECLARATION__TIME_DOMAIN:
				return timeDomain != null;
			case AlphabetsPackage.AWHILE_DECLARATION__COND:
				return cond != null;
		}
		return super.eIsSet(featureID);
	}

} //AWhileDeclarationImpl
