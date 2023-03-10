/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARelational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARelationalExpression()
 * @model
 * @generated
 */
public interface ARelationalExpression extends AAlphabetsExpression, AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(AAlphabetsExpression)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARelationalExpression_Left()
	 * @model containment="true"
	 * @generated
	 */
  AAlphabetsExpression getLeft();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
  void setLeft(AAlphabetsExpression value);

  /**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARelationalExpression_Operator()
	 * @model
	 * @generated
	 */
  String getOperator();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
  void setOperator(String value);

  /**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(AAlphabetsExpression)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getARelationalExpression_Right()
	 * @model containment="true"
	 * @generated
	 */
  AAlphabetsExpression getRight();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
  void setRight(AAlphabetsExpression value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitARelationalExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // ARelationalExpression
