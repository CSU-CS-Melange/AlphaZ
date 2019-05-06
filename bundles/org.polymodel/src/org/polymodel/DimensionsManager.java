/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Dimensions Manager</b></em>'. It contains all variables that can be
 * referred in a {@link Domain} or a {@link Relation}.
 * 
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.DimensionsManager#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.DimensionsManager#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.DimensionsManager#getInputsDimensions <em>Inputs Dimensions</em>}</li>
 *   <li>{@link org.polymodel.DimensionsManager#getOutputsDimensions <em>Outputs Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getDimensionsManager()
 * @model
 * @generated
 */
public interface DimensionsManager extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDimensionsManager_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getDimensions();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDimensionsManager_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getParameters();

	/**
	 * Returns the value of the '<em><b>Inputs Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.InputDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs Dimensions</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs Dimensions</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDimensionsManager_InputsDimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputDimension> getInputsDimensions();

	/**
	 * Returns the value of the '<em><b>Outputs Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.OutputDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs Dimensions</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs Dimensions</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDimensionsManager_OutputsDimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputDimension> getOutputsDimensions();

	/**
	 * <!-- begin-user-doc --> Get the dimension for a given position. If there
	 * is no variable then an {@link IndexDimension} is created. <!--
	 * end-user-doc -->
	 * @model
	 * @generated
	 */
	Variable getDimension(int position);

	/**
	 * <!-- begin-user-doc --> Get the input dimension of any relation for a
	 * given dimension.<!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	InputDimension getInputDimension(Variable var);

	/**
	 * <!-- begin-user-doc --> Get the output dimension of any relation for a
	 * given dimension. <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	OutputDimension getOutputDimension(Variable var);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model positionRequired="true"
	 * @generated
	 */
	Variable getParameter(int position);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	Variable getParameter(int position, String name);

	/**
	 * <!-- begin-user-doc --> Get the dimension for a given position. If there
	 * is no variable then an {@link IndexDimension} is created. <!--
	 * end-user-doc -->
	 * @model
	 * @generated
	 */
	Variable getDimension(int position, String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDimensionsManager(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

	List<OutputDimension> getOutputsDimensionsFor(List<? extends Variable> dims);

	List<InputDimension> getInputsDimensionsFor(List<? extends Variable> dims);

	List<Variable> getAllVariables();
} // DimensionsManager
