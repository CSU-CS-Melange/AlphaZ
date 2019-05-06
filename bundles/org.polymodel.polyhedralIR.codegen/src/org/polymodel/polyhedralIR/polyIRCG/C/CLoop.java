/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;


import org.polymodel.polyhedralIR.polyIRCG.Loop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.CLoop#isUseMacros <em>Use Macros</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getCLoop()
 * @model
 * @generated
 */
public interface CLoop extends Loop {
	/**
	 * Returns the value of the '<em><b>Use Macros</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Macros</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Macros</em>' attribute.
	 * @see #setUseMacros(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getCLoop_UseMacros()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUseMacros();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.CLoop#isUseMacros <em>Use Macros</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Macros</em>' attribute.
	 * @see #isUseMacros()
	 * @generated
	 */
	void setUseMacros(boolean value);

} // CLoop
