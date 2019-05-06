/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.polymodel.prdg.PRDGEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.EdgeDependency#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getEdgeDependency()
 * @model
 * @generated
 */
public interface EdgeDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' reference.
	 * @see #setEdge(PRDGEdge)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getEdgeDependency_Edge()
	 * @model required="true"
	 * @generated
	 */
	PRDGEdge getEdge();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.EdgeDependency#getEdge <em>Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(PRDGEdge value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isUniform();

	@Override
	public StatementSchedulePrototype getSource();
	@Override
	public StatementSchedulePrototype getReference();
} // EdgeDependency
