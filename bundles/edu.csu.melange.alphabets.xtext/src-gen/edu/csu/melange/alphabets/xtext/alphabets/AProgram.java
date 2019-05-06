/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AProgram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram#getExternalFunctions <em>External Functions</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram#getSystems <em>Systems</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAProgram()
 * @model
 * @generated
 */
public interface AProgram extends EObject
{
  /**
   * Returns the value of the '<em><b>External Functions</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Functions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Functions</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAProgram_ExternalFunctions()
   * @model containment="true"
   * @generated
   */
  EList<AExternalFunctionDeclaration> getExternalFunctions();

  /**
   * Returns the value of the '<em><b>Systems</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Systems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Systems</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAProgram_Systems()
   * @model containment="true"
   * @generated
   */
  EList<AAffineSystem> getSystems();

} // AProgram
