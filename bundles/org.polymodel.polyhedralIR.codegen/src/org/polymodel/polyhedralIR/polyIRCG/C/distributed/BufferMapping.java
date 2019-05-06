/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getValueAccess <em>Value Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getBufferAccess <em>Buffer Access</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getCommunicatedVariable <em>Communicated Variable</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferMapping()
 * @model
 * @generated
 */
public interface BufferMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Value Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Access</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Access</em>' containment reference.
	 * @see #setValueAccess(MemoryAccessExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferMapping_ValueAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MemoryAccessExpression getValueAccess();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getValueAccess <em>Value Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Access</em>' containment reference.
	 * @see #getValueAccess()
	 * @generated
	 */
	void setValueAccess(MemoryAccessExpression value);

	/**
	 * Returns the value of the '<em><b>Buffer Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer Access</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Access</em>' containment reference.
	 * @see #setBufferAccess(MemoryAccessExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferMapping_BufferAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MemoryAccessExpression getBufferAccess();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getBufferAccess <em>Buffer Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Access</em>' containment reference.
	 * @see #getBufferAccess()
	 * @generated
	 */
	void setBufferAccess(MemoryAccessExpression value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferMapping_Domain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Communicated Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communicated Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communicated Variable</em>' reference.
	 * @see #setCommunicatedVariable(CommunicatedVariableForTiledSpace)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferMapping_CommunicatedVariable()
	 * @model required="true"
	 * @generated
	 */
	CommunicatedVariableForTiledSpace getCommunicatedVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getCommunicatedVariable <em>Communicated Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communicated Variable</em>' reference.
	 * @see #getCommunicatedVariable()
	 * @generated
	 */
	void setCommunicatedVariable(CommunicatedVariableForTiledSpace value);

} // BufferMapping
