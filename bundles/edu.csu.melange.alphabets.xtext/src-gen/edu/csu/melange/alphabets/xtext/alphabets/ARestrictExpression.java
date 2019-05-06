/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARestrict Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getDomain <em>Domain</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARestrictExpression()
 * @model
 * @generated
 */
public interface ARestrictExpression extends AAlphabetsExpression
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(ADomain)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARestrictExpression_Domain()
   * @model containment="true"
   * @generated
   */
  ADomain getDomain();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(ADomain value);

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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARestrictExpression_Expr()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getExpr();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(AAlphabetsExpression value);

} // ARestrictExpression
