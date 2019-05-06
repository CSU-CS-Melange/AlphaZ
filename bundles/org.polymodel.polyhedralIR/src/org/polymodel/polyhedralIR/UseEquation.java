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
 * A representation of the model object '<em><b>Use Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getExtensionDomain <em>Extension Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getSubSystem <em>Sub System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getContainerSystem <em>Container System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.UseEquation#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation()
 * @model
 * @generated
 */
public interface UseEquation extends Equation, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Extension Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Domain</em>' containment reference.
	 * @see #setExtensionDomain(Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_ExtensionDomain()
	 * @model containment="true"
	 * @generated
	 */
	Domain getExtensionDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.UseEquation#getExtensionDomain <em>Extension Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Domain</em>' containment reference.
	 * @see #getExtensionDomain()
	 * @generated
	 */
	void setExtensionDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference.
	 * @see #setParameters(AffineFunction)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_Parameters()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getParameters();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.UseEquation#getParameters <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' containment reference.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_Outputs()
	 * @model
	 * @generated
	 */
	EList<VariableDeclaration> getOutputs();

	/**
	 * Returns the value of the '<em><b>Container System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.AffineSystem#getUseEquations <em>Use Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container System</em>' container reference.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_ContainerSystem()
	 * @see org.polymodel.polyhedralIR.AffineSystem#getUseEquations
	 * @model opposite="useEquations" unsettable="true" transient="false" changeable="false"
	 * @generated
	 */
	AffineSystem getContainerSystem();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_Label()
	 * @model default=""
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.UseEquation#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Sub System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System</em>' reference.
	 * @see #setSubSystem(AffineSystem)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getUseEquation_SubSystem()
	 * @model required="true"
	 * @generated
	 */
	AffineSystem getSubSystem();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.UseEquation#getSubSystem <em>Sub System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub System</em>' reference.
	 * @see #getSubSystem()
	 * @generated
	 */
	void setSubSystem(AffineSystem value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitUseEquation(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // UseEquation
