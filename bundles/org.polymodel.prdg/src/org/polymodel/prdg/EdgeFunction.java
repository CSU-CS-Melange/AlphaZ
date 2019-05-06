/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.EdgeFunction#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.PrdgPackage#getEdgeFunction()
 * @model abstract="true"
 * @generated
 */
public interface EdgeFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference.
	 * @see #setMapping(Function)
	 * @see org.polymodel.prdg.PrdgPackage#getEdgeFunction_Mapping()
	 * @model containment="true"
	 * @generated
	 */
	Function getMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.EdgeFunction#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Function value);

} // EdgeFunction
