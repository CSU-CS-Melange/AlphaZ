/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.DimensionsManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADA Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.ADAInput#getAdaStatements <em>Ada Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getADAInput()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ADAInput extends EObject {
	/**
	 * Returns the value of the '<em><b>Ada Statements</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.dataflow.ADAStatement}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.ADAStatement#getParentADAInput <em>Parent ADA Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ada Statements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ada Statements</em>' reference list.
	 * @see org.polymodel.dataflow.DataflowPackage#getADAInput_AdaStatements()
	 * @see org.polymodel.dataflow.ADAStatement#getParentADAInput
	 * @model opposite="parentADAInput"
	 * @generated
	 */
	EList<ADAStatement> getAdaStatements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	DimensionsManager getDimensionsManager();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" idRequired="true"
	 * @generated
	 */
	ADAStatement getStatementByID(int id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isResolved();

} // ADAInput
