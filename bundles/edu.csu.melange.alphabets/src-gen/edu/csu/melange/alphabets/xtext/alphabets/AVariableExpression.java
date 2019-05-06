/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AVariable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression#getVar <em>Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAVariableExpression()
 * @model
 * @generated
 */
public interface AVariableExpression extends AAlphabetsExpression, AlphabetsVisitable
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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAVariableExpression_Var()
	 * @model
	 * @generated
	 */
  String getVar();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression#getVar <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' attribute.
	 * @see #getVar()
	 * @generated
	 */
  void setVar(String value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAVariableExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AVariableExpression
