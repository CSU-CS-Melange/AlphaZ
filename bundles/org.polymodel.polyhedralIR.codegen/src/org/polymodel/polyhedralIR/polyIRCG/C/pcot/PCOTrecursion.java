/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot;

import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCO Trecursion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion#getRecursion <em>Recursion</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage#getPCOTrecursion()
 * @model
 * @generated
 */
public interface PCOTrecursion extends Body {
	/**
	 * Returns the value of the '<em><b>Recursion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursion</em>' reference.
	 * @see #setRecursion(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage#getPCOTrecursion_Recursion()
	 * @model required="true"
	 * @generated
	 */
	Function getRecursion();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion#getRecursion <em>Recursion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recursion</em>' reference.
	 * @see #getRecursion()
	 * @generated
	 */
	void setRecursion(Function value);

} // PCOTrecursion
