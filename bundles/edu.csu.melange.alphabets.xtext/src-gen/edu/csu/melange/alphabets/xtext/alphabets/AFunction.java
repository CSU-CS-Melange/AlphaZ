/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AFunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getFunc <em>Func</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAFunction()
 * @model
 * @generated
 */
public interface AFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>Indexes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indexes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indexes</em>' containment reference.
   * @see #setIndexes(AIndexList)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAFunction_Indexes()
   * @model containment="true"
   * @generated
   */
  AIndexList getIndexes();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getIndexes <em>Indexes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indexes</em>' containment reference.
   * @see #getIndexes()
   * @generated
   */
  void setIndexes(AIndexList value);

  /**
   * Returns the value of the '<em><b>Func</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Func</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Func</em>' containment reference.
   * @see #setFunc(AIndexAffineExpressionList)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAFunction_Func()
   * @model containment="true"
   * @generated
   */
  AIndexAffineExpressionList getFunc();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction#getFunc <em>Func</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Func</em>' containment reference.
   * @see #getFunc()
   * @generated
   */
  void setFunc(AIndexAffineExpressionList value);

} // AFunction
