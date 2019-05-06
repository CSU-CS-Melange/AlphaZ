/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.StandardEquation#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.StandardEquation#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.StandardEquation#getContainerSystem <em>Container System</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getStandardEquation()
 * @model
 * @generated
 */
public interface StandardEquation extends Equation, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getStandardEquation_Variable()
	 * @model
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.StandardEquation#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getStandardEquation_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.StandardEquation#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Container System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.AffineSystem#getEquations <em>Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container System</em>' container reference.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getStandardEquation_ContainerSystem()
	 * @see org.polymodel.polyhedralIR.AffineSystem#getEquations
	 * @model opposite="equations" unsettable="true" transient="false" changeable="false"
	 * @generated
	 */
	AffineSystem getContainerSystem();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitStandardEquation(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // StandardEquation
