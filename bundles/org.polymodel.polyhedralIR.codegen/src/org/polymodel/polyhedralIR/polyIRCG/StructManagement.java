/**
 */
package org.polymodel.polyhedralIR.polyIRCG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Management</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getStruct <em>Struct</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStructManagement()
 * @model abstract="true"
 * @generated
 */
public interface StructManagement extends Body {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStructManagement_Instance()
	 * @model
	 * @generated
	 */
	AbstractVariable getInstance();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(AbstractVariable value);

	/**
	 * Returns the value of the '<em><b>Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Struct</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struct</em>' reference.
	 * @see #setStruct(Struct)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStructManagement_Struct()
	 * @model
	 * @generated
	 */
	Struct getStruct();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getStruct <em>Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struct</em>' reference.
	 * @see #getStruct()
	 * @generated
	 */
	void setStruct(Struct value);

} // StructManagement
