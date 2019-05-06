/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AAffine System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getName <em>Name</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getInputDeclarations <em>Input Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getOutputDeclarations <em>Output Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getLocalvarDeclarations <em>Localvar Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem()
 * @model
 * @generated
 */
public interface AAffineSystem extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference.
   * @see #setParameters(ADomain)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_Parameters()
   * @model containment="true"
   * @generated
   */
  ADomain getParameters();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem#getParameters <em>Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameters</em>' containment reference.
   * @see #getParameters()
   * @generated
   */
  void setParameters(ADomain value);

  /**
   * Returns the value of the '<em><b>Input Declarations</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Declarations</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_InputDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<AInputDeclaration> getInputDeclarations();

  /**
   * Returns the value of the '<em><b>Output Declarations</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Declarations</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_OutputDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<AOutputDeclaration> getOutputDeclarations();

  /**
   * Returns the value of the '<em><b>Localvar Declarations</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Localvar Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Localvar Declarations</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_LocalvarDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ALocalDeclaration> getLocalvarDeclarations();

  /**
   * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
   * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equations</em>' containment reference list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAAffineSystem_Equations()
   * @model containment="true"
   * @generated
   */
  EList<AStandardEquation> getEquations();

} // AAffineSystem
