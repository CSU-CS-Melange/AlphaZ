/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;
import org.polymodel.prdg.PRDGNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduled Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduledStatement#getStatement <em>Statement</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduledStatement#getSchedule <em>Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduledStatement()
 * @model
 * @generated
 */
public interface ScheduledStatement extends EObject {
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
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduledStatement_Statement()
	 * @model required="true"
	 * @generated
	 */
	PRDGNode getStatement();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.ScheduledStatement#getStatement <em>Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(PRDGNode value);

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduledStatement_Schedule()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getSchedule();

} // ScheduledStatement
