/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADA Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.ADASolution#getResolvedAccesses <em>Resolved Accesses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getADASolution()
 * @model
 * @generated
 */
public interface ADASolution extends EObject {
	/**
	 * Returns the value of the '<em><b>Resolved Accesses</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.dataflow.ResolvedAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Accesses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Accesses</em>' containment reference list.
	 * @see org.polymodel.dataflow.DataflowPackage#getADASolution_ResolvedAccesses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ResolvedAccess> getResolvedAccesses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isBottom();

} // ADASolution
