/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.Program#getExternalFunctionDeclarations <em>External Function Declarations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Program#getSystems <em>Systems</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Program#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends PolyhedralIRVisitable {
	

	
	
	/**
	 * Returns the value of the '<em><b>External Function Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Function Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Function Declarations</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getProgram_ExternalFunctionDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExternalFunctionDeclaration> getExternalFunctionDeclarations();

	/**
	 * Returns the value of the '<em><b>Systems</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.AffineSystem}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.AffineSystem#getContainerProgram <em>Container Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Systems</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getProgram_Systems()
	 * @see org.polymodel.polyhedralIR.AffineSystem#getContainerProgram
	 * @model opposite="containerProgram" containment="true"
	 * @generated
	 */
	EList<AffineSystem> getSystems();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getProgram_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model signedRequired="true" typeRequired="true" widthRequired="true"
	 * @generated
	 */
	Type getType(SIGNED signed, DATATYPE type, int width);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	OP getBinaryOperator(String op);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	OP getUnaryOperator(String op);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	OP getMultiArgOperator(String op);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	OP getExternalFunctionOperator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inputsMany="true"
	 * @generated
	 */
	ExternalFunctionDeclaration getExternalFunctionDeclaration(String name, Type output, EList<Type> inputs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" systemNameRequired="true"
	 * @generated
	 */
	AffineSystem getSystem(String systemName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" systemNameRequired="true"
	 * @generated
	 */
	ParameterDomain getParameterDomain(String systemName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Program copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isContainingSystem(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitProgram(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);
	
	
	/**
	 * Set filename where the program was read from.
	 * Used by AlphaZ side where each Program have a corresponding alphabets input file.
	 */
	void setFilename(String filename);
	
	/**
	 * Returns the filename where this program was read from.
	 * Used by AlphaZ side where each Program have a corresponding alphabets input file.
	 * 
	 * @return
	 */
	String getFilename();

} // Program
