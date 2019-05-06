/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMemoryAccessExpression()
 * @model abstract="true"
 * @generated
 */
public interface MemoryAccessExpression extends EObject {
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMemoryAccessExpression_Variable()
	 * @model required="true"
	 * @generated
	 */
	CodeGenVariable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression#getVariable <em>Variable</em>}' reference.
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
	 * @model required="true" dimRequired="true"
	 * @generated
	 */
	IntExpression getIndexingExpression(int dim);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" dimRequired="true"
	 * @generated
	 */
	IntExpression getVolumeExpression(int dim);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IntExpression> getAccessExpressions();


} // MemoryAccessExpression
