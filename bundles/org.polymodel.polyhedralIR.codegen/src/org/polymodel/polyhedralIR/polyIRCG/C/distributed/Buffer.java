/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getBufferMappings <em>Buffer Mappings</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBuffer()
 * @model
 * @generated
 */
public interface Buffer extends EObject {
	/**
	 * Returns the value of the '<em><b>Buffer Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Mappings</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBuffer_BufferMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<BufferMapping> getBufferMappings();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(CodeGenVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBuffer_Variable()
	 * @model required="true"
	 * @generated
	 */
	CodeGenVariable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(CodeGenVariable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	IntExpression computeBufferSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Domain getSendDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Domain getReceiveDomain();

} // Buffer
