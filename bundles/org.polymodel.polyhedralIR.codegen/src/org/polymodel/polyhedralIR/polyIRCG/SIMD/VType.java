/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getWidth <em>Width</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getIns <em>Ins</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVType()
 * @model
 * @generated
 */
public interface VType extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVType_Type()
	 * @model required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH
	 * @see #setWidth(SIMD_WIDTH)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVType_Width()
	 * @model required="true"
	 * @generated
	 */
	SIMD_WIDTH getWidth();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(SIMD_WIDTH value);

	/**
	 * Returns the value of the '<em><b>Ins</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ins</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ins</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS
	 * @see #setIns(SIMD_INS)
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getVType_Ins()
	 * @model required="true"
	 * @generated
	 */
	SIMD_INS getIns();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getIns <em>Ins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ins</em>' attribute.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS
	 * @see #getIns()
	 * @generated
	 */
	void setIns(SIMD_INS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getSIMDName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNElements();

} // VType
