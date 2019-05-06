/**
 */
package org.polymodel.polyhedralIR.polyIRCG;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Pack Struct</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct#getInitValues <em>Init Values</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCustomPackStruct()
 * @model
 * @generated
 */
public interface CustomPackStruct extends StructManagement {
	/**
	 * Returns the value of the '<em><b>Init Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Values</em>' attribute.
	 * @see #setInitValues(Map)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCustomPackStruct_InitValues()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, String> getInitValues();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct#getInitValues <em>Init Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Values</em>' attribute.
	 * @see #getInitValues()
	 * @generated
	 */
	void setInitValues(Map<String, String> value);

} // CustomPackStruct
