/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot;

import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.Loop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCO Tbase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase#getLoop <em>Loop</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage#getPCOTbase()
 * @model
 * @generated
 */
public interface PCOTbase extends Body {
	/**
	 * Returns the value of the '<em><b>Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' reference.
	 * @see #setLoop(Loop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage#getPCOTbase_Loop()
	 * @model
	 * @generated
	 */
	Loop getLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase#getLoop <em>Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' reference.
	 * @see #getLoop()
	 * @generated
	 */
	void setLoop(Loop value);

} // PCOTbase
