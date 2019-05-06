/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolved Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.ResolvedAccess#getValidityDomain <em>Validity Domain</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ResolvedAccess#getIterationVector <em>Iteration Vector</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ResolvedAccess#getAccess <em>Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getResolvedAccess()
 * @model
 * @generated
 */
public interface ResolvedAccess extends EObject {
	/**
	 * Returns the value of the '<em><b>Validity Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validity Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validity Domain</em>' containment reference.
	 * @see #setValidityDomain(Domain)
	 * @see org.polymodel.dataflow.DataflowPackage#getResolvedAccess_ValidityDomain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Domain getValidityDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ResolvedAccess#getValidityDomain <em>Validity Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validity Domain</em>' containment reference.
	 * @see #getValidityDomain()
	 * @generated
	 */
	void setValidityDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Iteration Vector</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Vector</em>' containment reference list.
	 * @see org.polymodel.dataflow.DataflowPackage#getResolvedAccess_IterationVector()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getIterationVector();

	/**
	 * Returns the value of the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' reference.
	 * @see #setAccess(Access)
	 * @see org.polymodel.dataflow.DataflowPackage#getResolvedAccess_Access()
	 * @model
	 * @generated
	 */
	Access getAccess();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ResolvedAccess#getAccess <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' reference.
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(Access value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isBottom();

} // ResolvedAccess
