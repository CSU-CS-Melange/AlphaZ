/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AIndex Affine Expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIndexAffineExpressionList()
 * @model
 * @generated
 */
public interface AIndexAffineExpressionList extends EObject
{
  /**
   * Returns the value of the '<em><b>Exprs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' attribute list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIndexAffineExpressionList_Exprs()
   * @model unique="false"
   * @generated
   */
  EList<String> getExprs();

} // AIndexAffineExpressionList
