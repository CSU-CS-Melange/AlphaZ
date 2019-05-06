/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADependence In Array Notation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getVar <em>Var</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getDep <em>Dep</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceInArrayNotation()
 * @model
 * @generated
 */
public interface ADependenceInArrayNotation extends AAlphabetsExpression
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceInArrayNotation_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Returns the value of the '<em><b>Dep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dep</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dep</em>' containment reference.
   * @see #setDep(AIndexAffineExpressionList)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceInArrayNotation_Dep()
   * @model containment="true"
   * @generated
   */
  AIndexAffineExpressionList getDep();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation#getDep <em>Dep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dep</em>' containment reference.
   * @see #getDep()
   * @generated
   */
  void setDep(AIndexAffineExpressionList value);

} // ADependenceInArrayNotation
