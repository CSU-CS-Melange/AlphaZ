/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getUnsigned <em>Unsigned</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAType()
 * @model
 * @generated
 */
public interface AType extends EObject
{
  /**
   * Returns the value of the '<em><b>Unsigned</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unsigned</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unsigned</em>' attribute.
   * @see #setUnsigned(String)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAType_Unsigned()
   * @model
   * @generated
   */
  String getUnsigned();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getUnsigned <em>Unsigned</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unsigned</em>' attribute.
   * @see #getUnsigned()
   * @generated
   */
  void setUnsigned(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAType_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AType#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // AType
