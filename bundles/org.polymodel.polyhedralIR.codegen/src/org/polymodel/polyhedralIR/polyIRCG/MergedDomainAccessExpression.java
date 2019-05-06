/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merged Domain Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getAccessExpression <em>Access Expression</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMergedDomainAccessExpression()
 * @model
 * @generated
 */
public interface MergedDomainAccessExpression extends MemoryAccessExpression {
	/**
	 * Returns the value of the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Expression</em>' containment reference.
	 * @see #setAccessExpression(MemoryAccessExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMergedDomainAccessExpression_AccessExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MemoryAccessExpression getAccessExpression();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getAccessExpression <em>Access Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Expression</em>' containment reference.
	 * @see #getAccessExpression()
	 * @generated
	 */
	void setAccessExpression(MemoryAccessExpression value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMergedDomainAccessExpression_Identifier()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // MergedDomainAccessExpression
