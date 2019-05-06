/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AIdentifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIdentifierListImpl#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIdentifierListImpl extends MinimalEObjectImpl.Container implements AIdentifierList
{
  /**
	 * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIdentifiers()
	 * @generated
	 * @ordered
	 */
  protected EList<String> identifiers;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AIdentifierListImpl()
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
		return AlphabetsPackage.Literals.AIDENTIFIER_LIST;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getIdentifiers()
  {
		if (identifiers == null) {
			identifiers = new EDataTypeEList<String>(String.class, this, AlphabetsPackage.AIDENTIFIER_LIST__IDENTIFIERS);
		}
		return identifiers;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAIdentifierList(this);
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
			case AlphabetsPackage.AIDENTIFIER_LIST__IDENTIFIERS:
				return getIdentifiers();
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
			case AlphabetsPackage.AIDENTIFIER_LIST__IDENTIFIERS:
				getIdentifiers().clear();
				getIdentifiers().addAll((Collection<? extends String>)newValue);
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
			case AlphabetsPackage.AIDENTIFIER_LIST__IDENTIFIERS:
				getIdentifiers().clear();
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
			case AlphabetsPackage.AIDENTIFIER_LIST__IDENTIFIERS:
				return identifiers != null && !identifiers.isEmpty();
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
		result.append(" (identifiers: ");
		result.append(identifiers);
		result.append(')');
		return result.toString();
	}

} //AIdentifierListImpl
