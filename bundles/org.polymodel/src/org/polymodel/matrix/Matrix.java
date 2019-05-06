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
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.matrix.Matrix#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.matrix.MatrixPackage#getMatrix()
 * @model
 * @generated
 */
public interface Matrix extends EObject {
	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.matrix.MatrixRow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see org.polymodel.matrix.MatrixPackage#getMatrix_Rows()
	 * @model containment="true"
	 * @generated
	 */
	EList<MatrixRow> getRows();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix inverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix inverseInContext(Matrix context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix mul(Matrix b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix add(Matrix b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix sub(Matrix b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix transpose();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix identity(int size);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Matrix> findHermiteBasis();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isUnimodular();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInHNF();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isIntegral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Matrix> left_hermite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isIdentity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isSquare();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model variablesMany="true"
	 * @generated
	 */
	IntConstraintSystem toConstraints(EList<Variable> variables);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getNbCols();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getNbRows();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void set(int row, int col, long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	long get(int row, int col);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equivalence(Matrix m);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix nullspace();

	/**
	 * <!-- begin-user-doc -->
	 * Constructs Domain assuming the matrix is in polylib format with parameters being the first columns.
	 * <!-- end-user-doc -->
	 * @model paramsMany="true" indicesMany="true"
	 * @generated
	 */
	IntConstraintSystem toDomain(EList<Variable> params, EList<Variable> indices);

	/**
	 * <!-- begin-user-doc -->
	 * Constructs Function assuming that the parameters are the first columns.
	 * <!-- end-user-doc -->
	 * @model paramsMany="true" indicesMany="true"
	 * @generated
	 */
	EList<IntExpression> toFunction(EList<Variable> params, EList<Variable> indices);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int rowRank();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int columnRank();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isFullRowRank();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isFullColumnRank();

	/**
	 * <!-- begin-user-doc -->
	 * Returns column space, also called range, of the matrix.
	 * This function returns a matrix where each column is a basis (column) vector forming the space.
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Matrix columnSpace();

	/**
	 * <!-- begin-user-doc -->
	 * Returns Hermite Normal Form of the matrix.
	 * 
	 * Given matrix A, returns two matrices H and U such that H = AU.
	 * H is the HNF, and U is an unimodular matrix.
	 *  
	 * The first element of the returned list is H, and the second element is U.
	 * <!-- end-user-doc -->
	 * @model required="true" upper="2"
	 * @generated
	 */
	EList<Matrix> hermiteNormalForm();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" matRequired="true"
	 * @generated
	 */
	Matrix appendRow(Matrix mat);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" matRequired="true"
	 * @generated
	 */
	Matrix appendColumn(Matrix mat);

	public List<Long> getColumn(int pos);
	
	public long[][] toLongArray();

} // Matrix
