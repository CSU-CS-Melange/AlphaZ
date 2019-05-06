/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.polymodel.prdg.PRDGNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement Schedule Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.StatementSchedulePrototype#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getStatementSchedulePrototype()
 * @model
 * @generated
 */
public interface StatementSchedulePrototype extends SchedulePrototype {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' reference.
	 * @see #setStatement(PRDGNode)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getStatementSchedulePrototype_Statement()
	 * @model required="true"
	 * @generated
	 */
	PRDGNode getStatement();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.StatementSchedulePrototype#getStatement <em>Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(PRDGNode value);

} // StatementSchedulePrototype
