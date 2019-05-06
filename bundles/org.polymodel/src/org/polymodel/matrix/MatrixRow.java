/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.matrix.MatrixRow#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.matrix.MatrixPackage#getMatrixRow()
 * @model
 * @generated
 */
public interface MatrixRow extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.polymodel.matrix.MatrixPackage#getMatrixRow_Values()
	 * @model
	 * @generated
	 */
	EList<Long> getValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model variablesMany="true"
	 * @generated
	 */
	IntConstraint toConstraint(EList<Variable> variables);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" colRequired="true"
	 * @generated
	 */
	long get(int col);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void set(int col, long value);

	/**
	 * Returns a constraint representation of the matrix row.
	 * Assumes polylib format.
	 * 
	 * @param params
	 * @param indices
	 * @return
	 */
	IntConstraint toConstraint(List<Variable> params, List<Variable> indices);
	

} // MatrixRow
