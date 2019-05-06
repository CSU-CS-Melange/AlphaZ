/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADomain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.ADomain#getPolyhedra <em>Polyhedra</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADomain()
 * @model
 * @generated
 */
public interface ADomain extends AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Polyhedra</b></em>' containment reference list.
	 * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Polyhedra</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Polyhedra</em>' containment reference list.
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getADomain_Polyhedra()
	 * @model containment="true"
	 * @generated
	 */
  EList<APolyhedron> getPolyhedra();

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitADomain(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // ADomain
