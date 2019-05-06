/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AIf Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getCond <em>Cond</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getThen <em>Then</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIfExpression()
 * @model
 * @generated
 */
public interface AIfExpression extends AAlphabetsExpression
{
  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(AAlphabetsExpression)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIfExpression_Cond()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getCond();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(AAlphabetsExpression value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(AAlphabetsExpression)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIfExpression_Then()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getThen();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(AAlphabetsExpression value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(AAlphabetsExpression)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIfExpression_Else()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getElse();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(AAlphabetsExpression value);

} // AIfExpression
