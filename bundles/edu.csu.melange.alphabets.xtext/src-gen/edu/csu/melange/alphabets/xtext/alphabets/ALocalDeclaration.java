/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ALocal Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getIdentifierList <em>Identifier List</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getALocalDeclaration()
 * @model
 * @generated
 */
public interface ALocalDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(AType)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getALocalDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  AType getType();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(AType value);

  /**
   * Returns the value of the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier List</em>' containment reference.
   * @see #setIdentifierList(AIdentifierList)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getALocalDeclaration_IdentifierList()
   * @model containment="true"
   * @generated
   */
  AIdentifierList getIdentifierList();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getIdentifierList <em>Identifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier List</em>' containment reference.
   * @see #getIdentifierList()
   * @generated
   */
  void setIdentifierList(AIdentifierList value);

  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(ADomain)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getALocalDeclaration_Domain()
   * @model containment="true"
   * @generated
   */
  ADomain getDomain();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(ADomain value);

} // ALocalDeclaration
