/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.matrix.MatrixFactory
 * @model kind="package"
 * @generated
 */
public interface MatrixPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "matrix";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.matrix";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "matrix";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MatrixPackage eINSTANCE = org.polymodel.matrix.impl.MatrixPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.matrix.impl.MatrixImpl <em>Matrix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.matrix.impl.MatrixImpl
	 * @see org.polymodel.matrix.impl.MatrixPackageImpl#getMatrix()
	 * @generated
	 */
	int MATRIX = 0;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX__ROWS = 0;

	/**
	 * The number of structural features of the '<em>Matrix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___INVERSE = 0;

	/**
	 * The operation id for the '<em>Inverse In Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___INVERSE_IN_CONTEXT__MATRIX = 1;

	/**
	 * The operation id for the '<em>Mul</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___MUL__MATRIX = 2;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___ADD__MATRIX = 3;

	/**
	 * The operation id for the '<em>Sub</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___SUB__MATRIX = 4;

	/**
	 * The operation id for the '<em>Transpose</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___TRANSPOSE = 5;

	/**
	 * The operation id for the '<em>Identity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IDENTITY__INT = 6;

	/**
	 * The operation id for the '<em>Find Hermite Basis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___FIND_HERMITE_BASIS = 7;

	/**
	 * The operation id for the '<em>Is Unimodular</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_UNIMODULAR = 8;

	/**
	 * The operation id for the '<em>Is In HNF</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_IN_HNF = 9;

	/**
	 * The operation id for the '<em>Is Integral</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_INTEGRAL = 10;

	/**
	 * The operation id for the '<em>Left hermite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___LEFT_HERMITE = 11;

	/**
	 * The operation id for the '<em>Is Identity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_IDENTITY = 12;

	/**
	 * The operation id for the '<em>Is Square</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_SQUARE = 13;

	/**
	 * The operation id for the '<em>To Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___TO_CONSTRAINTS__ELIST = 14;

	/**
	 * The operation id for the '<em>Get Nb Cols</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___GET_NB_COLS = 15;

	/**
	 * The operation id for the '<em>Get Nb Rows</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___GET_NB_ROWS = 16;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___SET__INT_INT_LONG = 17;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___GET__INT_INT = 18;

	/**
	 * The operation id for the '<em>Equivalence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___EQUIVALENCE__MATRIX = 19;

	/**
	 * The operation id for the '<em>Nullspace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___NULLSPACE = 20;

	/**
	 * The operation id for the '<em>To Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___TO_DOMAIN__ELIST_ELIST = 21;

	/**
	 * The operation id for the '<em>To Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___TO_FUNCTION__ELIST_ELIST = 22;

	/**
	 * The operation id for the '<em>Row Rank</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___ROW_RANK = 23;

	/**
	 * The operation id for the '<em>Column Rank</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___COLUMN_RANK = 24;

	/**
	 * The operation id for the '<em>Is Full Row Rank</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_FULL_ROW_RANK = 25;

	/**
	 * The operation id for the '<em>Is Full Column Rank</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___IS_FULL_COLUMN_RANK = 26;

	/**
	 * The operation id for the '<em>Column Space</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___COLUMN_SPACE = 27;

	/**
	 * The operation id for the '<em>Hermite Normal Form</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___HERMITE_NORMAL_FORM = 28;

	/**
	 * The operation id for the '<em>Append Row</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___APPEND_ROW__MATRIX = 29;

	/**
	 * The operation id for the '<em>Append Column</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX___APPEND_COLUMN__MATRIX = 30;

	/**
	 * The number of operations of the '<em>Matrix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_OPERATION_COUNT = 31;

	/**
	 * The meta object id for the '{@link org.polymodel.matrix.impl.MatrixRowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.matrix.impl.MatrixRowImpl
	 * @see org.polymodel.matrix.impl.MatrixPackageImpl#getMatrixRow()
	 * @generated
	 */
	int MATRIX_ROW = 1;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW__VALUES = 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW_FEATURE_COUNT = 1;


	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW___GET_SIZE = 0;

	/**
	 * The operation id for the '<em>To Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW___TO_CONSTRAINT__ELIST = 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW___GET__INT = 2;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW___SET__INT_LONG = 3;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_ROW_OPERATION_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.polymodel.matrix.Matrix <em>Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matrix</em>'.
	 * @see org.polymodel.matrix.Matrix
	 * @generated
	 */
	EClass getMatrix();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.matrix.Matrix#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rows</em>'.
	 * @see org.polymodel.matrix.Matrix#getRows()
	 * @see #getMatrix()
	 * @generated
	 */
	EReference getMatrix_Rows();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#inverse() <em>Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inverse</em>' operation.
	 * @see org.polymodel.matrix.Matrix#inverse()
	 * @generated
	 */
	EOperation getMatrix__Inverse();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#inverseInContext(org.polymodel.matrix.Matrix) <em>Inverse In Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inverse In Context</em>' operation.
	 * @see org.polymodel.matrix.Matrix#inverseInContext(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__InverseInContext__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#mul(org.polymodel.matrix.Matrix) <em>Mul</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Mul</em>' operation.
	 * @see org.polymodel.matrix.Matrix#mul(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__Mul__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#add(org.polymodel.matrix.Matrix) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see org.polymodel.matrix.Matrix#add(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__Add__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#sub(org.polymodel.matrix.Matrix) <em>Sub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sub</em>' operation.
	 * @see org.polymodel.matrix.Matrix#sub(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__Sub__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#transpose() <em>Transpose</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Transpose</em>' operation.
	 * @see org.polymodel.matrix.Matrix#transpose()
	 * @generated
	 */
	EOperation getMatrix__Transpose();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#identity(int) <em>Identity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Identity</em>' operation.
	 * @see org.polymodel.matrix.Matrix#identity(int)
	 * @generated
	 */
	EOperation getMatrix__Identity__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#findHermiteBasis() <em>Find Hermite Basis</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Hermite Basis</em>' operation.
	 * @see org.polymodel.matrix.Matrix#findHermiteBasis()
	 * @generated
	 */
	EOperation getMatrix__FindHermiteBasis();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isUnimodular() <em>Is Unimodular</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Unimodular</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isUnimodular()
	 * @generated
	 */
	EOperation getMatrix__IsUnimodular();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isInHNF() <em>Is In HNF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is In HNF</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isInHNF()
	 * @generated
	 */
	EOperation getMatrix__IsInHNF();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isIntegral() <em>Is Integral</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Integral</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isIntegral()
	 * @generated
	 */
	EOperation getMatrix__IsIntegral();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#left_hermite() <em>Left hermite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Left hermite</em>' operation.
	 * @see org.polymodel.matrix.Matrix#left_hermite()
	 * @generated
	 */
	EOperation getMatrix__Left_hermite();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isIdentity() <em>Is Identity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Identity</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isIdentity()
	 * @generated
	 */
	EOperation getMatrix__IsIdentity();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isSquare() <em>Is Square</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Square</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isSquare()
	 * @generated
	 */
	EOperation getMatrix__IsSquare();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#toConstraints(org.eclipse.emf.common.util.EList) <em>To Constraints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Constraints</em>' operation.
	 * @see org.polymodel.matrix.Matrix#toConstraints(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMatrix__ToConstraints__EList();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#getNbCols() <em>Get Nb Cols</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Nb Cols</em>' operation.
	 * @see org.polymodel.matrix.Matrix#getNbCols()
	 * @generated
	 */
	EOperation getMatrix__GetNbCols();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#getNbRows() <em>Get Nb Rows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Nb Rows</em>' operation.
	 * @see org.polymodel.matrix.Matrix#getNbRows()
	 * @generated
	 */
	EOperation getMatrix__GetNbRows();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#set(int, int, long) <em>Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set</em>' operation.
	 * @see org.polymodel.matrix.Matrix#set(int, int, long)
	 * @generated
	 */
	EOperation getMatrix__Set__int_int_long();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#get(int, int) <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see org.polymodel.matrix.Matrix#get(int, int)
	 * @generated
	 */
	EOperation getMatrix__Get__int_int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#equivalence(org.polymodel.matrix.Matrix) <em>Equivalence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equivalence</em>' operation.
	 * @see org.polymodel.matrix.Matrix#equivalence(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__Equivalence__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#nullspace() <em>Nullspace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Nullspace</em>' operation.
	 * @see org.polymodel.matrix.Matrix#nullspace()
	 * @generated
	 */
	EOperation getMatrix__Nullspace();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#toDomain(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>To Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Domain</em>' operation.
	 * @see org.polymodel.matrix.Matrix#toDomain(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMatrix__ToDomain__EList_EList();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#toFunction(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>To Function</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Function</em>' operation.
	 * @see org.polymodel.matrix.Matrix#toFunction(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMatrix__ToFunction__EList_EList();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#rowRank() <em>Row Rank</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Row Rank</em>' operation.
	 * @see org.polymodel.matrix.Matrix#rowRank()
	 * @generated
	 */
	EOperation getMatrix__RowRank();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#columnRank() <em>Column Rank</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Column Rank</em>' operation.
	 * @see org.polymodel.matrix.Matrix#columnRank()
	 * @generated
	 */
	EOperation getMatrix__ColumnRank();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isFullRowRank() <em>Is Full Row Rank</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Full Row Rank</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isFullRowRank()
	 * @generated
	 */
	EOperation getMatrix__IsFullRowRank();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#isFullColumnRank() <em>Is Full Column Rank</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Full Column Rank</em>' operation.
	 * @see org.polymodel.matrix.Matrix#isFullColumnRank()
	 * @generated
	 */
	EOperation getMatrix__IsFullColumnRank();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#columnSpace() <em>Column Space</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Column Space</em>' operation.
	 * @see org.polymodel.matrix.Matrix#columnSpace()
	 * @generated
	 */
	EOperation getMatrix__ColumnSpace();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#hermiteNormalForm() <em>Hermite Normal Form</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hermite Normal Form</em>' operation.
	 * @see org.polymodel.matrix.Matrix#hermiteNormalForm()
	 * @generated
	 */
	EOperation getMatrix__HermiteNormalForm();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#appendRow(org.polymodel.matrix.Matrix) <em>Append Row</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Append Row</em>' operation.
	 * @see org.polymodel.matrix.Matrix#appendRow(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__AppendRow__Matrix();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.Matrix#appendColumn(org.polymodel.matrix.Matrix) <em>Append Column</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Append Column</em>' operation.
	 * @see org.polymodel.matrix.Matrix#appendColumn(org.polymodel.matrix.Matrix)
	 * @generated
	 */
	EOperation getMatrix__AppendColumn__Matrix();

	/**
	 * Returns the meta object for class '{@link org.polymodel.matrix.MatrixRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see org.polymodel.matrix.MatrixRow
	 * @generated
	 */
	EClass getMatrixRow();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.matrix.MatrixRow#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.polymodel.matrix.MatrixRow#getValues()
	 * @see #getMatrixRow()
	 * @generated
	 */
	EAttribute getMatrixRow_Values();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.MatrixRow#getSize() <em>Get Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Size</em>' operation.
	 * @see org.polymodel.matrix.MatrixRow#getSize()
	 * @generated
	 */
	EOperation getMatrixRow__GetSize();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.MatrixRow#toConstraint(org.eclipse.emf.common.util.EList) <em>To Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Constraint</em>' operation.
	 * @see org.polymodel.matrix.MatrixRow#toConstraint(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMatrixRow__ToConstraint__EList();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.MatrixRow#get(int) <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see org.polymodel.matrix.MatrixRow#get(int)
	 * @generated
	 */
	EOperation getMatrixRow__Get__int();

	/**
	 * Returns the meta object for the '{@link org.polymodel.matrix.MatrixRow#set(int, long) <em>Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set</em>' operation.
	 * @see org.polymodel.matrix.MatrixRow#set(int, long)
	 * @generated
	 */
	EOperation getMatrixRow__Set__int_long();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MatrixFactory getMatrixFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.matrix.impl.MatrixImpl <em>Matrix</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.matrix.impl.MatrixImpl
		 * @see org.polymodel.matrix.impl.MatrixPackageImpl#getMatrix()
		 * @generated
		 */
		EClass MATRIX = eINSTANCE.getMatrix();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATRIX__ROWS = eINSTANCE.getMatrix_Rows();

		/**
		 * The meta object literal for the '<em><b>Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___INVERSE = eINSTANCE.getMatrix__Inverse();

		/**
		 * The meta object literal for the '<em><b>Inverse In Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___INVERSE_IN_CONTEXT__MATRIX = eINSTANCE.getMatrix__InverseInContext__Matrix();

		/**
		 * The meta object literal for the '<em><b>Mul</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___MUL__MATRIX = eINSTANCE.getMatrix__Mul__Matrix();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___ADD__MATRIX = eINSTANCE.getMatrix__Add__Matrix();

		/**
		 * The meta object literal for the '<em><b>Sub</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___SUB__MATRIX = eINSTANCE.getMatrix__Sub__Matrix();

		/**
		 * The meta object literal for the '<em><b>Transpose</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___TRANSPOSE = eINSTANCE.getMatrix__Transpose();

		/**
		 * The meta object literal for the '<em><b>Identity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IDENTITY__INT = eINSTANCE.getMatrix__Identity__int();

		/**
		 * The meta object literal for the '<em><b>Find Hermite Basis</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___FIND_HERMITE_BASIS = eINSTANCE.getMatrix__FindHermiteBasis();

		/**
		 * The meta object literal for the '<em><b>Is Unimodular</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_UNIMODULAR = eINSTANCE.getMatrix__IsUnimodular();

		/**
		 * The meta object literal for the '<em><b>Is In HNF</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_IN_HNF = eINSTANCE.getMatrix__IsInHNF();

		/**
		 * The meta object literal for the '<em><b>Is Integral</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_INTEGRAL = eINSTANCE.getMatrix__IsIntegral();

		/**
		 * The meta object literal for the '<em><b>Left hermite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___LEFT_HERMITE = eINSTANCE.getMatrix__Left_hermite();

		/**
		 * The meta object literal for the '<em><b>Is Identity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_IDENTITY = eINSTANCE.getMatrix__IsIdentity();

		/**
		 * The meta object literal for the '<em><b>Is Square</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_SQUARE = eINSTANCE.getMatrix__IsSquare();

		/**
		 * The meta object literal for the '<em><b>To Constraints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___TO_CONSTRAINTS__ELIST = eINSTANCE.getMatrix__ToConstraints__EList();

		/**
		 * The meta object literal for the '<em><b>Get Nb Cols</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___GET_NB_COLS = eINSTANCE.getMatrix__GetNbCols();

		/**
		 * The meta object literal for the '<em><b>Get Nb Rows</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___GET_NB_ROWS = eINSTANCE.getMatrix__GetNbRows();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___SET__INT_INT_LONG = eINSTANCE.getMatrix__Set__int_int_long();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___GET__INT_INT = eINSTANCE.getMatrix__Get__int_int();

		/**
		 * The meta object literal for the '<em><b>Equivalence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___EQUIVALENCE__MATRIX = eINSTANCE.getMatrix__Equivalence__Matrix();

		/**
		 * The meta object literal for the '<em><b>Nullspace</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___NULLSPACE = eINSTANCE.getMatrix__Nullspace();

		/**
		 * The meta object literal for the '<em><b>To Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___TO_DOMAIN__ELIST_ELIST = eINSTANCE.getMatrix__ToDomain__EList_EList();

		/**
		 * The meta object literal for the '<em><b>To Function</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___TO_FUNCTION__ELIST_ELIST = eINSTANCE.getMatrix__ToFunction__EList_EList();

		/**
		 * The meta object literal for the '<em><b>Row Rank</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___ROW_RANK = eINSTANCE.getMatrix__RowRank();

		/**
		 * The meta object literal for the '<em><b>Column Rank</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___COLUMN_RANK = eINSTANCE.getMatrix__ColumnRank();

		/**
		 * The meta object literal for the '<em><b>Is Full Row Rank</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_FULL_ROW_RANK = eINSTANCE.getMatrix__IsFullRowRank();

		/**
		 * The meta object literal for the '<em><b>Is Full Column Rank</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___IS_FULL_COLUMN_RANK = eINSTANCE.getMatrix__IsFullColumnRank();

		/**
		 * The meta object literal for the '<em><b>Column Space</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___COLUMN_SPACE = eINSTANCE.getMatrix__ColumnSpace();

		/**
		 * The meta object literal for the '<em><b>Hermite Normal Form</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___HERMITE_NORMAL_FORM = eINSTANCE.getMatrix__HermiteNormalForm();

		/**
		 * The meta object literal for the '<em><b>Append Row</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___APPEND_ROW__MATRIX = eINSTANCE.getMatrix__AppendRow__Matrix();

		/**
		 * The meta object literal for the '<em><b>Append Column</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX___APPEND_COLUMN__MATRIX = eINSTANCE.getMatrix__AppendColumn__Matrix();

		/**
		 * The meta object literal for the '{@link org.polymodel.matrix.impl.MatrixRowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.matrix.impl.MatrixRowImpl
		 * @see org.polymodel.matrix.impl.MatrixPackageImpl#getMatrixRow()
		 * @generated
		 */
		EClass MATRIX_ROW = eINSTANCE.getMatrixRow();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRIX_ROW__VALUES = eINSTANCE.getMatrixRow_Values();

		/**
		 * The meta object literal for the '<em><b>Get Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX_ROW___GET_SIZE = eINSTANCE.getMatrixRow__GetSize();

		/**
		 * The meta object literal for the '<em><b>To Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX_ROW___TO_CONSTRAINT__ELIST = eINSTANCE.getMatrixRow__ToConstraint__EList();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX_ROW___GET__INT = eINSTANCE.getMatrixRow__Get__int();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATRIX_ROW___SET__INT_LONG = eINSTANCE.getMatrixRow__Set__int_long();

	}

} //MatrixPackage
