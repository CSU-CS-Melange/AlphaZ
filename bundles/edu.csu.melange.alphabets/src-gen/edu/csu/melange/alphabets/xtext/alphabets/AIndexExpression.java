/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AIndex Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getFunc <em>Func</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getIndexes <em>Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIndexExpression()
 * @model
 * @generated
 */
public interface AIndexExpression extends AAlphabetsExpression, AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Func</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Func</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Func</em>' attribute.
	 * @see #setFunc(String)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIndexExpression_Func()
	 * @model
	 * @generated
	 */
  String getFunc();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getFunc <em>Func</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Func</em>' attribute.
	 * @see #getFunc()
	 * @generated
	 */
  void setFunc(String value);

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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIndexExpression_Indexes()
	 * @model containment="true"
	 * @generated
	 */
  AIndexList getIndexes();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression#getIndexes <em>Indexes</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexes</em>' containment reference.
	 * @see #getIndexes()
	 * @generated
	 */
  void setIndexes(AIndexList value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAIndexExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AIndexExpression
