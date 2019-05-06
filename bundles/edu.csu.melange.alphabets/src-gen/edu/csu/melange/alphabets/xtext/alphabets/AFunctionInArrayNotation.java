/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AFunction In Array Notation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation#getNewIds <em>New Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAFunctionInArrayNotation()
 * @model
 * @generated
 */
public interface AFunctionInArrayNotation extends AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>New Ids</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>New Ids</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>New Ids</em>' containment reference.
	 * @see #setNewIds(AIndexAffineExpressionList)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAFunctionInArrayNotation_NewIds()
	 * @model containment="true"
	 * @generated
	 */
  AIndexAffineExpressionList getNewIds();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation#getNewIds <em>New Ids</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Ids</em>' containment reference.
	 * @see #getNewIds()
	 * @generated
	 */
  void setNewIds(AIndexAffineExpressionList value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAFunctionInArrayNotation(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AFunctionInArrayNotation
