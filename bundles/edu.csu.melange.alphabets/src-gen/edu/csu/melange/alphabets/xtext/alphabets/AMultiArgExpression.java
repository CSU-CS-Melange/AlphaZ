/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AMulti Arg Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAMultiArgExpression()
 * @model
 * @generated
 */
public interface AMultiArgExpression extends AAlphabetsExpression, AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Exprs</em>' containment reference list.
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAMultiArgExpression_Exprs()
	 * @model containment="true"
	 * @generated
	 */
  EList<AAlphabetsExpression> getExprs();

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAMultiArgExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AMultiArgExpression
