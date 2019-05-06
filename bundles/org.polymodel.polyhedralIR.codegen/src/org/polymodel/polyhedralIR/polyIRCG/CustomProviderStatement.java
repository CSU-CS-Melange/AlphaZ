/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Provider Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement#getProvider <em>Provider</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCustomProviderStatement()
 * @model
 * @generated
 */
public interface CustomProviderStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(MacroBodyProvider)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCustomProviderStatement_Provider()
	 * @model dataType="org.polymodel.polyhedralIR.polyIRCG.MacroBodyProvider" required="true"
	 * @generated
	 */
	MacroBodyProvider getProvider();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(MacroBodyProvider value);

} // CustomProviderStatement
