/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AStandard Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getVar <em>Var</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAStandardEquation()
 * @model
 * @generated
 */
public interface AStandardEquation extends EObject
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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAStandardEquation_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAStandardEquation_Indexes()
   * @model containment="true"
   * @generated
   */
  AIndexList getIndexes();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getIndexes <em>Indexes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indexes</em>' containment reference.
   * @see #getIndexes()
   * @generated
   */
  void setIndexes(AIndexList value);

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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAStandardEquation_Expr()
   * @model containment="true"
   * @generated
   */
  AAlphabetsExpression getExpr();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(AAlphabetsExpression value);

} // AStandardEquation
