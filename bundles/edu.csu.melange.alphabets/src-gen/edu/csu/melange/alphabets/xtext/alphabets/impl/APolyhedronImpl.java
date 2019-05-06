/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.APolyhedron;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>APolyhedron</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.APolyhedronImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class APolyhedronImpl extends MinimalEObjectImpl.Container implements APolyhedron
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
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
  protected EList<String> constraints;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected APolyhedronImpl()
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
		return AlphabetsPackage.Literals.APOLYHEDRON;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.APOLYHEDRON__INDEXES, oldIndexes, newIndexes);
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
				msgs = ((InternalEObject)indexes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.APOLYHEDRON__INDEXES, null, msgs);
			if (newIndexes != null)
				msgs = ((InternalEObject)newIndexes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.APOLYHEDRON__INDEXES, null, msgs);
			msgs = basicSetIndexes(newIndexes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.APOLYHEDRON__INDEXES, newIndexes, newIndexes));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getConstraints()
  {
		if (constraints == null) {
			constraints = new EDataTypeEList<String>(String.class, this, AlphabetsPackage.APOLYHEDRON__CONSTRAINTS);
		}
		return constraints;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAPolyhedron(this);
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
			case AlphabetsPackage.APOLYHEDRON__INDEXES:
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
		switch (featureID) {
			case AlphabetsPackage.APOLYHEDRON__INDEXES:
				return getIndexes();
			case AlphabetsPackage.APOLYHEDRON__CONSTRAINTS:
				return getConstraints();
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
			case AlphabetsPackage.APOLYHEDRON__INDEXES:
				setIndexes((AIndexList)newValue);
				return;
			case AlphabetsPackage.APOLYHEDRON__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends String>)newValue);
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
			case AlphabetsPackage.APOLYHEDRON__INDEXES:
				setIndexes((AIndexList)null);
				return;
			case AlphabetsPackage.APOLYHEDRON__CONSTRAINTS:
				getConstraints().clear();
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
			case AlphabetsPackage.APOLYHEDRON__INDEXES:
				return indexes != null;
			case AlphabetsPackage.APOLYHEDRON__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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
		result.append(" (constraints: ");
		result.append(constraints);
		result.append(')');
		return result.toString();
	}

} //APolyhedronImpl
