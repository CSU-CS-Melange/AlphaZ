/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;
import org.polymodel.scop.ScopRoot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scop Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getScopRoot <em>Scop Root</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getScopLoop()
 * @model
 * @generated
 */
public interface ScopLoop extends CLoop {
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getScopLoop_Tiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<TileSpecification> getTiles();

	/**
	 * Returns the value of the '<em><b>Scop Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scop Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scop Root</em>' reference.
	 * @see #setScopRoot(ScopRoot)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getScopLoop_ScopRoot()
	 * @model
	 * @generated
	 */
	ScopRoot getScopRoot();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop#getScopRoot <em>Scop Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scop Root</em>' reference.
	 * @see #getScopRoot()
	 * @generated
	 */
	void setScopRoot(ScopRoot value);

} // ScopLoop
