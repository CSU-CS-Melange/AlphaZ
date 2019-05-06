/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>APolyhedron</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAPolyhedron()
 * @model
 * @generated
 */
public interface APolyhedron extends EObject
{
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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAPolyhedron_Indexes()
   * @model containment="true"
   * @generated
   */
  AIndexList getIndexes();

  /**
   * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron#getIndexes <em>Indexes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indexes</em>' containment reference.
   * @see #getIndexes()
   * @generated
   */
  void setIndexes(AIndexList value);

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' attribute list.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAPolyhedron_Constraints()
   * @model unique="false"
   * @generated
   */
  EList<String> getConstraints();

} // APolyhedron
