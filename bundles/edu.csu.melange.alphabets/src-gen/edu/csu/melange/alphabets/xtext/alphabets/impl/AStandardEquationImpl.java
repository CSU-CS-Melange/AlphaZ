/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AStandard Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl#getVar <em>Var</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AStandardEquationImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AStandardEquationImpl extends AEquationImpl implements AStandardEquation
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
	 * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIndexes()
	 * @generated
	 * @ordered
	 */
  protected AIndexList indexes;

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
  protected AStandardEquationImpl()
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
		return AlphabetsPackage.Literals.ASTANDARD_EQUATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ASTANDARD_EQUATION__VAR, oldVar, var));
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
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ASTANDARD_EQUATION__INDEXES, oldIndexes, newIndexes);
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
		if (newIndexes != indexes) {
			NotificationChain msgs = null;
			if (indexes != null)
				msgs = ((InternalEObject)indexes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ASTANDARD_EQUATION__INDEXES, null, msgs);
			if (newIndexes != null)
				msgs = ((InternalEObject)newIndexes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ASTANDARD_EQUATION__INDEXES, null, msgs);
			msgs = basicSetIndexes(newIndexes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ASTANDARD_EQUATION__INDEXES, newIndexes, newIndexes));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ASTANDARD_EQUATION__EXPR, oldExpr, newExpr);
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
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ASTANDARD_EQUATION__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.ASTANDARD_EQUATION__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.ASTANDARD_EQUATION__EXPR, newExpr, newExpr));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAStandardEquation(this);
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
			case AlphabetsPackage.ASTANDARD_EQUATION__INDEXES:
				return basicSetIndexes(null, msgs);
			case AlphabetsPackage.ASTANDARD_EQUATION__EXPR:
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
			case AlphabetsPackage.ASTANDARD_EQUATION__VAR:
				return getVar();
			case AlphabetsPackage.ASTANDARD_EQUATION__INDEXES:
				return getIndexes();
			case AlphabetsPackage.ASTANDARD_EQUATION__EXPR:
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
			case AlphabetsPackage.ASTANDARD_EQUATION__VAR:
				setVar((String)newValue);
				return;
			case AlphabetsPackage.ASTANDARD_EQUATION__INDEXES:
				setIndexes((AIndexList)newValue);
				return;
			case AlphabetsPackage.ASTANDARD_EQUATION__EXPR:
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
			case AlphabetsPackage.ASTANDARD_EQUATION__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case AlphabetsPackage.ASTANDARD_EQUATION__INDEXES:
				setIndexes((AIndexList)null);
				return;
			case AlphabetsPackage.ASTANDARD_EQUATION__EXPR:
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
			case AlphabetsPackage.ASTANDARD_EQUATION__VAR:
				return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
			case AlphabetsPackage.ASTANDARD_EQUATION__INDEXES:
				return indexes != null;
			case AlphabetsPackage.ASTANDARD_EQUATION__EXPR:
				return expr != null;
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

} //AStandardEquationImpl
