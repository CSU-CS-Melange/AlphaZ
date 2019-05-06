/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.VariableDeclaration#getVarID <em>Var ID</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.VariableDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.VariableDeclaration#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Var ID</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var ID</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var ID</em>' containment reference.
	 * @see #setVarID(VariableIdentifier)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getVariableDeclaration_VarID()
	 * @model containment="true"
	 * @generated
	 */
	VariableIdentifier getVarID();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.VariableDeclaration#getVarID <em>Var ID</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var ID</em>' containment reference.
	 * @see #getVarID()
	 * @generated
	 */
	void setVarID(VariableIdentifier value);

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
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getVariableDeclaration_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.VariableDeclaration#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getVariableDeclaration_Domain()
	 * @model containment="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.VariableDeclaration#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isInput();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isOutput();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isLocal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitVariableDeclaration(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // VariableDeclaration
