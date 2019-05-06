/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCOT Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.PCOTLoop#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.PCOTLoop#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getPCOTLoop()
 * @model
 * @generated
 */
public interface PCOTLoop extends ScopLoop {
	/**
	 * Returns the value of the '<em><b>Tiles</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiles</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getPCOTLoop_Tiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<TileSpecification> getTiles();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(org.polymodel.Domain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getPCOTLoop_Domain()
	 * @model containment="true"
	 * @generated
	 */
	org.polymodel.Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.PCOTLoop#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(org.polymodel.Domain value);

} // PCOTLoop
