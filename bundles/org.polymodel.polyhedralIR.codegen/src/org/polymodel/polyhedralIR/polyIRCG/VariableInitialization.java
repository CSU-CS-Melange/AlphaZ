/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Initialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getSpecialLocals <em>Special Locals</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableInitialization()
 * @model
 * @generated
 */
public interface VariableInitialization extends Body {

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableInitialization_Inputs()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableInitialization_Outputs()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getOutputs();

	/**
	 * Returns the value of the '<em><b>Locals</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locals</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableInitialization_Locals()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getLocals();

	/**
	 * Returns the value of the '<em><b>Special Locals</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Locals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Locals</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getVariableInitialization_SpecialLocals()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getSpecialLocals();
} // VariableInitialization
