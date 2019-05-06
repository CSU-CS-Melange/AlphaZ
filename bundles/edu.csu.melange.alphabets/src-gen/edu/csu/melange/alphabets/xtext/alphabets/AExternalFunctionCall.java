/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AExternal Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall#getFunc <em>Func</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionCall()
 * @model
 * @generated
 */
public interface AExternalFunctionCall extends AMultiArgExpression, AlphabetsVisitable
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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionCall_Func()
	 * @model
	 * @generated
	 */
  String getFunc();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall#getFunc <em>Func</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Func</em>' attribute.
	 * @see #getFunc()
	 * @generated
	 */
  void setFunc(String value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAExternalFunctionCall(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AExternalFunctionCall
