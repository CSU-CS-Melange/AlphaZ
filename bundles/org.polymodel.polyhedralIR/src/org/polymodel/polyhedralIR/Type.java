/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.Type#getSigned <em>Signed</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Type#getTypeID <em>Type ID</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Type#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject {

	/**
	 * Returns the value of the '<em><b>Signed</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.SIGNED}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signed</em>' attribute.
	 * @see org.polymodel.polyhedralIR.SIGNED
	 * @see #setSigned(SIGNED)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getType_Signed()
	 * @model required="true"
	 * @generated
	 */
	SIGNED getSigned();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Type#getSigned <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signed</em>' attribute.
	 * @see org.polymodel.polyhedralIR.SIGNED
	 * @see #getSigned()
	 * @generated
	 */
	void setSigned(SIGNED value);

	/**
	 * Returns the value of the '<em><b>Type ID</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.DATATYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type ID</em>' attribute.
	 * @see org.polymodel.polyhedralIR.DATATYPE
	 * @see #setTypeID(DATATYPE)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getType_TypeID()
	 * @model required="true"
	 * @generated
	 */
	DATATYPE getTypeID();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Type#getTypeID <em>Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type ID</em>' attribute.
	 * @see org.polymodel.polyhedralIR.DATATYPE
	 * @see #getTypeID()
	 * @generated
	 */
	void setTypeID(DATATYPE value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getType_Width()
	 * @model required="true"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Type#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getCName();

	String getCPrintfSpecifier();

	String getCScanfSpecifier();
	
	String getCScanfPostProcess();

} // Type
