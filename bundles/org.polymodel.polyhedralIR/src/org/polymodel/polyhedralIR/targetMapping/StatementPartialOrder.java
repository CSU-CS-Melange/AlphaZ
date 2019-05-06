/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement Partial Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getSuccessor <em>Successor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getStatementPartialOrder()
 * @model
 * @generated
 */
public interface StatementPartialOrder extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(Equation)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getStatementPartialOrder_Predecessor()
	 * @model required="true"
	 * @generated
	 */
	Equation getPredecessor();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(Equation value);

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(Equation)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getStatementPartialOrder_Successor()
	 * @model required="true"
	 * @generated
	 */
	Equation getSuccessor();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(Equation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitStatementPartialOrder(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // StatementPartialOrder
