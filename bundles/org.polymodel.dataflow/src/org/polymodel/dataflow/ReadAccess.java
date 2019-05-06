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
 * A representation of the model object '<em><b>Read Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.ReadAccess#getParentADAStatement <em>Parent ADA Statement</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ReadAccess#getLastWrite <em>Last Write</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getReadAccess()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ReadAccess extends Access {
	/**
	 * Returns the value of the '<em><b>Last Write</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Write</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Write</em>' containment reference.
	 * @see #setLastWrite(ADASolution)
	 * @see org.polymodel.dataflow.DataflowPackage#getReadAccess_LastWrite()
	 * @model containment="true"
	 * @generated
	 */
	ADASolution getLastWrite();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ReadAccess#getLastWrite <em>Last Write</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Write</em>' containment reference.
	 * @see #getLastWrite()
	 * @generated
	 */
	void setLastWrite(ADASolution value);

	/**
	 * Returns the value of the '<em><b>Parent ADA Statement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.ADAStatement#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent ADA Statement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent ADA Statement</em>' reference.
	 * @see #setParentADAStatement(ADAStatement)
	 * @see org.polymodel.dataflow.DataflowPackage#getReadAccess_ParentADAStatement()
	 * @see org.polymodel.dataflow.ADAStatement#getReads
	 * @model opposite="reads" required="true"
	 * @generated
	 */
	ADAStatement getParentADAStatement();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ReadAccess#getParentADAStatement <em>Parent ADA Statement</em>}' reference.
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
	EList<WriteAccess> getAllWriteCandidates();


} // ReadAccess
