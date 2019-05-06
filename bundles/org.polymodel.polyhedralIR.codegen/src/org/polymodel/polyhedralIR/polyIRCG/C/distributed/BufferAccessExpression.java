/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferingFactor <em>Buffering Factor</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferID <em>Buffer ID</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferAccessExpression()
 * @model
 * @generated
 */
public interface BufferAccessExpression extends MergedDomainAccessExpression {

	/**
	 * Returns the value of the '<em><b>Buffering Factor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffering Factor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffering Factor</em>' containment reference.
	 * @see #setBufferingFactor(IntExpression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferAccessExpression_BufferingFactor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getBufferingFactor();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferingFactor <em>Buffering Factor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffering Factor</em>' containment reference.
	 * @see #getBufferingFactor()
	 * @generated
	 */
	void setBufferingFactor(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Buffer ID</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer ID</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer ID</em>' reference.
	 * @see #setBufferID(Variable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getBufferAccessExpression_BufferID()
	 * @model required="true"
	 * @generated
	 */
	Variable getBufferID();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferID <em>Buffer ID</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer ID</em>' reference.
	 * @see #getBufferID()
	 * @generated
	 */
	void setBufferID(Variable value);
} // BufferAccessExpression
