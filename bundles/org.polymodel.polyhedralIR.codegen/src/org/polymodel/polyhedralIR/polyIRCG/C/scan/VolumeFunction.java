/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Volume Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction#getUnknown <em>Unknown</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getVolumeFunction()
 * @model
 * @generated
 */
public interface VolumeFunction extends Body {
	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unknown</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference.
	 * @see #setUnknown(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getVolumeFunction_Unknown()
	 * @model required="true"
	 * @generated
	 */
	AbstractVariable getUnknown();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction#getUnknown <em>Unknown</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unknown</em>' reference.
	 * @see #getUnknown()
	 * @generated
	 */
	void setUnknown(AbstractVariable value);

} // VolumeFunction
