/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper;

import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification#getSpecialVar <em>Special Var</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#getOutputVerification()
 * @model
 * @generated
 */
public interface OutputVerification extends CLoop {
	/**
	 * Returns the value of the '<em><b>Special Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Var</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Var</em>' reference.
	 * @see #setSpecialVar(SpecialVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#getOutputVerification_SpecialVar()
	 * @model
	 * @generated
	 */
	SpecialVariable getSpecialVar();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification#getSpecialVar <em>Special Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Special Var</em>' reference.
	 * @see #getSpecialVar()
	 * @generated
	 */
	void setSpecialVar(SpecialVariable value);

} // OutputVerification
