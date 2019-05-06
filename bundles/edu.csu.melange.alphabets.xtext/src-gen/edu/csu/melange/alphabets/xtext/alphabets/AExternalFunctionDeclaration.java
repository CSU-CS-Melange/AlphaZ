/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AExternal Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getOutput <em>Output</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionDeclaration()
 * @model
 * @generated
 */
public interface AExternalFunctionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' containment reference.
   * @see #setOutput(AType)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionDeclaration_Output()
   * @model containment="true"
   * @generated
   */
  AType getOutput();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getOutput <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' containment reference.
   * @see #getOutput()
   * @generated
   */
  void setOutput(AType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(AExternalFunctionIdentifier)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  AExternalFunctionIdentifier getName();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(AExternalFunctionIdentifier value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAExternalFunctionDeclaration_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<AType> getInputs();

} // AExternalFunctionDeclaration
