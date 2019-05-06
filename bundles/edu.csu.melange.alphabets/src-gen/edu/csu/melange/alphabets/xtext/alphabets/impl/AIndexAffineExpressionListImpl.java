/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AIndex Affine Expression List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AIndexAffineExpressionListImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIndexAffineExpressionListImpl extends MinimalEObjectImpl.Container implements AIndexAffineExpressionList
{
  /**
	 * The cached value of the '{@link #getExprs() <em>Exprs</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExprs()
	 * @generated
	 * @ordered
	 */
  protected EList<String> exprs;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AIndexAffineExpressionListImpl()
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
		return AlphabetsPackage.Literals.AINDEX_AFFINE_EXPRESSION_LIST;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getExprs()
  {
		if (exprs == null) {
			exprs = new EDataTypeEList<String>(String.class, this, AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST__EXPRS);
		}
		return exprs;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAIndexAffineExpressionList(this);
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
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST__EXPRS:
				return getExprs();
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
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST__EXPRS:
				getExprs().clear();
				getExprs().addAll((Collection<? extends String>)newValue);
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
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST__EXPRS:
				getExprs().clear();
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
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST__EXPRS:
				return exprs != null && !exprs.isEmpty();
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
		result.append(" (exprs: ");
		result.append(exprs);
		result.append(')');
		return result.toString();
	}

} //AIndexAffineExpressionListImpl
