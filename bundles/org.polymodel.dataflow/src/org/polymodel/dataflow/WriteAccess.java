/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.WriteAccess#getParentADAStatement <em>Parent ADA Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getWriteAccess()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WriteAccess extends Access {
	/**
	 * Returns the value of the '<em><b>Parent ADA Statement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.ADAStatement#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent ADA Statement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent ADA Statement</em>' reference.
	 * @see #setParentADAStatement(ADAStatement)
	 * @see org.polymodel.dataflow.DataflowPackage#getWriteAccess_ParentADAStatement()
	 * @see org.polymodel.dataflow.ADAStatement#getWrites
	 * @model opposite="writes" required="true"
	 * @generated
	 */
	ADAStatement getParentADAStatement();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.WriteAccess#getParentADAStatement <em>Parent ADA Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent ADA Statement</em>' reference.
	 * @see #getParentADAStatement()
	 * @generated
	 */
	void setParentADAStatement(ADAStatement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ReadAccess> getAllReadCandidates();

} // WriteAccess
