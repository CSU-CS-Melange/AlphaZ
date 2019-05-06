/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Dimensions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.RelationDimensions#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.RelationDimensions#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.RelationDimensions#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.RelationDimensions#getExistential <em>Existential</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getRelationDimensions()
 * @model
 * @generated
 */
public interface RelationDimensions extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.InputDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.PolymodelPackage#getRelationDimensions_Inputs()
	 * @model
	 * @generated
	 */
	EList<InputDimension> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.OutputDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.PolymodelPackage#getRelationDimensions_Outputs()
	 * @model
	 * @generated
	 */
	EList<OutputDimension> getOutputs();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.polymodel.PolymodelPackage#getRelationDimensions_Parameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getParameters();

	/**
	 * Returns the value of the '<em><b>Existential</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.ExistentialVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Existential</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Existential</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getRelationDimensions_Existential()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExistentialVariable> getExistential();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitRelationDimensions(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getParameterDimensionOf(Variable variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getInputDimensionOf(Variable variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getOutputDimensionOf(Variable variable);

	InputDimension getInput(Variable v);
	OutputDimension getOutput(Variable v);

} // RelationDimensions
