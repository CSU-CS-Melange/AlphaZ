/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAlphabetsVisitable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AlphabetsVisitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AlphabetsVisitable
