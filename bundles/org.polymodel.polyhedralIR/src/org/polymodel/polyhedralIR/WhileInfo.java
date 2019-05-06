/**
 */
package org.polymodel.polyhedralIR;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.WhileInfo#getTimeDomain <em>Time Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.WhileInfo#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.WhileInfo#getContainerSystem <em>Container System</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getWhileInfo()
 * @model
 * @generated
 */
public interface WhileInfo extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Time Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Domain</em>' reference.
	 * @see #setTimeDomain(Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getWhileInfo_TimeDomain()
	 * @model required="true"
	 * @generated
	 */
	Domain getTimeDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.WhileInfo#getTimeDomain <em>Time Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Domain</em>' reference.
	 * @see #getTimeDomain()
	 * @generated
	 */
	void setTimeDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getWhileInfo_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.WhileInfo#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Container System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container System</em>' reference.
	 * @see #setContainerSystem(AffineSystem)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getWhileInfo_ContainerSystem()
	 * @model required="true"
	 * @generated
	 */
	AffineSystem getContainerSystem();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.WhileInfo#getContainerSystem <em>Container System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container System</em>' reference.
	 * @see #getContainerSystem()
	 * @generated
	 */
	void setContainerSystem(AffineSystem value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitWhileInfo(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // WhileInfo
