/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AMulti Arg Arithmetic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAMultiArgArithmeticExpression()
 * @model
 * @generated
 */
public interface AMultiArgArithmeticExpression extends AMultiArgExpression, AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see #setOp(String)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAMultiArgArithmeticExpression_Op()
	 * @model
	 * @generated
	 */
  String getOp();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see #getOp()
	 * @generated
	 */
  void setOp(String value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAMultiArgArithmeticExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AMultiArgArithmeticExpression
