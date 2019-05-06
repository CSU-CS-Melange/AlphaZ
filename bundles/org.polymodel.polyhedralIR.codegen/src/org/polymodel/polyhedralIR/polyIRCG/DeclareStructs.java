/**
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declare Structs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.DeclareStructs#getStructs <em>Structs</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getDeclareStructs()
 * @model
 * @generated
 */
public interface DeclareStructs extends CodeUnitHeader {
	/**
	 * Returns the value of the '<em><b>Structs</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.Struct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structs</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getDeclareStructs_Structs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Struct> getStructs();

} // DeclareStructs
