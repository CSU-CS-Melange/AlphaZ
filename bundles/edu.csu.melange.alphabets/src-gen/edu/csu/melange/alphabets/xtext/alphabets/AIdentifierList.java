/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AIdentifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIdentifierList()
 * @model
 * @generated
 */
public interface AIdentifierList extends AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Identifiers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifiers</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' attribute list.
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAIdentifierList_Identifiers()
	 * @model unique="false"
	 * @generated
	 */
  EList<String> getIdentifiers();

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAIdentifierList(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AIdentifierList
