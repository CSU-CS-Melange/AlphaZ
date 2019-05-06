/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.LinearDependency#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getLinearDependency()
 * @model
 * @generated
 */
public interface LinearDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscript</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscript</em>' containment reference.
	 * @see #setSubscript(IntExpression)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getLinearDependency_Subscript()
	 * @model containment="true"
	 * @generated
	 */
	IntExpression getSubscript();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.LinearDependency#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscript</em>' containment reference.
	 * @see #getSubscript()
	 * @generated
	 */
	void setSubscript(IntExpression value);

} // LinearDependency
