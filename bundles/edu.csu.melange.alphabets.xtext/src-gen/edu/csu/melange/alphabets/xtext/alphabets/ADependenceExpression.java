/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADependence Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getFunc <em>Func</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceExpression()
 * @model
 * @generated
 */
public interface ADependenceExpression extends AAlphabetsExpression
{
  /**
   * Returns the value of the '<em><b>Func</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Func</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Func</em>' containment reference.
   * @see #setFunc(AFunction)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceExpression_Func()
   * @model containment="true"
   * @generated
   */
  AFunction getFunc();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getFunc <em>Func</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Func</em>' containment reference.
   * @see #getFunc()
   * @generated
   */
  void setFunc(AFunction value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(AAlphabetsExpression)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADependenceExpression_Expr()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getExpr();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(AAlphabetsExpression value);

} // ADependenceExpression
