/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.polyIRCG.Body;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck#getParameterDomain <em>Parameter Domain</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParameterCheck()
 * @model
 * @generated
 */
public interface ParameterCheck extends Body {

	/**
	 * Returns the value of the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Domain</em>' reference.
	 * @see #setParameterDomain(ParameterDomain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParameterCheck_ParameterDomain()
	 * @model
	 * @generated
	 */
	ParameterDomain getParameterDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck#getParameterDomain <em>Parameter Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Domain</em>' reference.
	 * @see #getParameterDomain()
	 * @generated
	 */
	void setParameterDomain(ParameterDomain value);
} // ParameterCheck
