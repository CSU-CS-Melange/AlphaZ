/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Body#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getBody()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Body extends EObject {

	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getBodies <em>Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getBody_Function()
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getBodies
	 * @model opposite="bodies" transient="false"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Body#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);
} // Body
