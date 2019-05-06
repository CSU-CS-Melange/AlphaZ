/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReduce Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getOp <em>Op</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getProjection <em>Projection</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAReduceExpression()
 * @model
 * @generated
 */
public interface AReduceExpression extends AAlphabetsExpression, AlphabetsVisitable
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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAReduceExpression_Op()
	 * @model
	 * @generated
	 */
  String getOp();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see #getOp()
	 * @generated
	 */
  void setOp(String value);

  /**
	 * Returns the value of the '<em><b>Projection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Projection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Projection</em>' containment reference.
	 * @see #setProjection(EObject)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAReduceExpression_Projection()
	 * @model containment="true"
	 * @generated
	 */
  EObject getProjection();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getProjection <em>Projection</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projection</em>' containment reference.
	 * @see #getProjection()
	 * @generated
	 */
  void setProjection(EObject value);

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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAReduceExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
  AAlphabetsExpression getExpr();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
  void setExpr(AAlphabetsExpression value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAReduceExpression(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AReduceExpression
