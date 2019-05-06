/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AWhile Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration#getTimeDomain <em>Time Domain</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration#getCond <em>Cond</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAWhileDeclaration()
 * @model
 * @generated
 */
public interface AWhileDeclaration extends AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Time Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Domain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Domain</em>' containment reference.
	 * @see #setTimeDomain(ADomain)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAWhileDeclaration_TimeDomain()
	 * @model containment="true"
	 * @generated
	 */
  ADomain getTimeDomain();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration#getTimeDomain <em>Time Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Domain</em>' containment reference.
	 * @see #getTimeDomain()
	 * @generated
	 */
  void setTimeDomain(ADomain value);

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
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAWhileDeclaration_Cond()
	 * @model containment="true"
	 * @generated
	 */
  AAlphabetsExpression getCond();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration#getCond <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond</em>' containment reference.
	 * @see #getCond()
	 * @generated
	 */
  void setCond(AAlphabetsExpression value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAWhileDeclaration(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AWhileDeclaration
