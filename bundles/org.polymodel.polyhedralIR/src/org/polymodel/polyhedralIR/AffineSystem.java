/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affine System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getContainerProgram <em>Container Program</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getUseEquations <em>Use Equations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getTargetMapping <em>Target Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getWhileInfo <em>While Info</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.AffineSystem#getTilingInfo <em>Tiling Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem()
 * @model
 * @generated
 */
public interface AffineSystem extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Container Program</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.Program#getSystems <em>Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Program</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Program</em>' container reference.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_ContainerProgram()
	 * @see org.polymodel.polyhedralIR.Program#getSystems
	 * @model opposite="systems" unsettable="true" transient="false" changeable="false"
	 * @generated
	 */
	Program getContainerProgram();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference.
	 * @see #setParameters(ParameterDomain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Parameters()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ParameterDomain getParameters();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineSystem#getParameters <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' containment reference.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(ParameterDomain value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getOutputs();

	/**
	 * Returns the value of the '<em><b>Locals</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locals</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Locals()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getLocals();

	/**
	 * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.StandardEquation}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.StandardEquation#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equations</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_Equations()
	 * @see org.polymodel.polyhedralIR.StandardEquation#getContainerSystem
	 * @model opposite="containerSystem" containment="true"
	 * @generated
	 */
	EList<StandardEquation> getEquations();

	/**
	 * Returns the value of the '<em><b>Use Equations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.UseEquation}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.UseEquation#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Equations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Equations</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_UseEquations()
	 * @see org.polymodel.polyhedralIR.UseEquation#getContainerSystem
	 * @model opposite="containerSystem" containment="true"
	 * @generated
	 */
	EList<UseEquation> getUseEquations();

	/**
	 * Returns the value of the '<em><b>Target Mapping</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Mapping</em>' containment reference.
	 * @see #setTargetMapping(TargetMapping)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_TargetMapping()
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getContainerSystem
	 * @model opposite="containerSystem" containment="true" required="true"
	 * @generated
	 */
	TargetMapping getTargetMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineSystem#getTargetMapping <em>Target Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Mapping</em>' containment reference.
	 * @see #getTargetMapping()
	 * @generated
	 */
	void setTargetMapping(TargetMapping value);

	/**
	 * Returns the value of the '<em><b>While Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>While Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>While Info</em>' containment reference.
	 * @see #setWhileInfo(WhileInfo)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_WhileInfo()
	 * @model containment="true"
	 * @generated
	 */
	WhileInfo getWhileInfo();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineSystem#getWhileInfo <em>While Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>While Info</em>' containment reference.
	 * @see #getWhileInfo()
	 * @generated
	 */
	void setWhileInfo(WhileInfo value);

	/**
	 * Returns the value of the '<em><b>Tiling Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Info</em>' reference.
	 * @see #setTilingInfo(TilingInformations)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineSystem_TilingInfo()
	 * @model
	 * @generated
	 */
	TilingInformations getTilingInfo();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineSystem#getTilingInfo <em>Tiling Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Info</em>' reference.
	 * @see #getTilingInfo()
	 * @generated
	 */
	void setTilingInfo(TilingInformations value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	VariableDeclaration getVariableDeclaration(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	StandardEquation getEquation(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	UseEquation getUseEquation(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" varNameRequired="true"
	 * @generated
	 */
	boolean containsVariable(String varName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	AffineSystem copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	UseEquation findLabel(String label);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	boolean isInput(VariableDeclaration var);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	boolean isOutput(VariableDeclaration var);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	boolean isLocal(VariableDeclaration var);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAffineSystem(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // AffineSystem
