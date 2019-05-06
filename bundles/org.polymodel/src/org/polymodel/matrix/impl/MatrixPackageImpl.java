/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.impl.PolymodelPackageImpl;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixFactory;
import org.polymodel.matrix.MatrixPackage;
import org.polymodel.matrix.MatrixRow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MatrixPackageImpl extends EPackageImpl implements MatrixPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixRowEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.matrix.MatrixPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MatrixPackageImpl() {
		super(eNS_URI, MatrixFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MatrixPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MatrixPackage init() {
		if (isInited) return (MatrixPackage)EPackage.Registry.INSTANCE.getEPackage(MatrixPackage.eNS_URI);

		// Obtain or create and register package
		MatrixPackageImpl theMatrixPackage = (MatrixPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MatrixPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MatrixPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AlgebraPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PolymodelPackageImpl thePolymodelPackage = (PolymodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI) instanceof PolymodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI) : PolymodelPackage.eINSTANCE);

		// Create package meta-data objects
		theMatrixPackage.createPackageContents();
		thePolymodelPackage.createPackageContents();

		// Initialize created meta-data
		theMatrixPackage.initializePackageContents();
		thePolymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMatrixPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MatrixPackage.eNS_URI, theMatrixPackage);
		return theMatrixPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrix() {
		return matrixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatrix_Rows() {
		return (EReference)matrixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Inverse() {
		return matrixEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__InverseInContext__Matrix() {
		return matrixEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Mul__Matrix() {
		return matrixEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Add__Matrix() {
		return matrixEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Sub__Matrix() {
		return matrixEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Transpose() {
		return matrixEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Identity__int() {
		return matrixEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__FindHermiteBasis() {
		return matrixEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsUnimodular() {
		return matrixEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsInHNF() {
		return matrixEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsIntegral() {
		return matrixEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Left_hermite() {
		return matrixEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsIdentity() {
		return matrixEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsSquare() {
		return matrixEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__ToConstraints__EList() {
		return matrixEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__GetNbCols() {
		return matrixEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__GetNbRows() {
		return matrixEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Set__int_int_long() {
		return matrixEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Get__int_int() {
		return matrixEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Equivalence__Matrix() {
		return matrixEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__Nullspace() {
		return matrixEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__ToDomain__EList_EList() {
		return matrixEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__ToFunction__EList_EList() {
		return matrixEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__RowRank() {
		return matrixEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__ColumnRank() {
		return matrixEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsFullRowRank() {
		return matrixEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__IsFullColumnRank() {
		return matrixEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__ColumnSpace() {
		return matrixEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__HermiteNormalForm() {
		return matrixEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__AppendRow__Matrix() {
		return matrixEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrix__AppendColumn__Matrix() {
		return matrixEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrixRow() {
		return matrixRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatrixRow_Values() {
		return (EAttribute)matrixRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrixRow__GetSize() {
		return matrixRowEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrixRow__ToConstraint__EList() {
		return matrixRowEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrixRow__Get__int() {
		return matrixRowEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatrixRow__Set__int_long() {
		return matrixRowEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixFactory getMatrixFactory() {
		return (MatrixFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		matrixEClass = createEClass(MATRIX);
		createEReference(matrixEClass, MATRIX__ROWS);
		createEOperation(matrixEClass, MATRIX___INVERSE);
		createEOperation(matrixEClass, MATRIX___INVERSE_IN_CONTEXT__MATRIX);
		createEOperation(matrixEClass, MATRIX___MUL__MATRIX);
		createEOperation(matrixEClass, MATRIX___ADD__MATRIX);
		createEOperation(matrixEClass, MATRIX___SUB__MATRIX);
		createEOperation(matrixEClass, MATRIX___TRANSPOSE);
		createEOperation(matrixEClass, MATRIX___IDENTITY__INT);
		createEOperation(matrixEClass, MATRIX___FIND_HERMITE_BASIS);
		createEOperation(matrixEClass, MATRIX___IS_UNIMODULAR);
		createEOperation(matrixEClass, MATRIX___IS_IN_HNF);
		createEOperation(matrixEClass, MATRIX___IS_INTEGRAL);
		createEOperation(matrixEClass, MATRIX___LEFT_HERMITE);
		createEOperation(matrixEClass, MATRIX___IS_IDENTITY);
		createEOperation(matrixEClass, MATRIX___IS_SQUARE);
		createEOperation(matrixEClass, MATRIX___TO_CONSTRAINTS__ELIST);
		createEOperation(matrixEClass, MATRIX___GET_NB_COLS);
		createEOperation(matrixEClass, MATRIX___GET_NB_ROWS);
		createEOperation(matrixEClass, MATRIX___SET__INT_INT_LONG);
		createEOperation(matrixEClass, MATRIX___GET__INT_INT);
		createEOperation(matrixEClass, MATRIX___EQUIVALENCE__MATRIX);
		createEOperation(matrixEClass, MATRIX___NULLSPACE);
		createEOperation(matrixEClass, MATRIX___TO_DOMAIN__ELIST_ELIST);
		createEOperation(matrixEClass, MATRIX___TO_FUNCTION__ELIST_ELIST);
		createEOperation(matrixEClass, MATRIX___ROW_RANK);
		createEOperation(matrixEClass, MATRIX___COLUMN_RANK);
		createEOperation(matrixEClass, MATRIX___IS_FULL_ROW_RANK);
		createEOperation(matrixEClass, MATRIX___IS_FULL_COLUMN_RANK);
		createEOperation(matrixEClass, MATRIX___COLUMN_SPACE);
		createEOperation(matrixEClass, MATRIX___HERMITE_NORMAL_FORM);
		createEOperation(matrixEClass, MATRIX___APPEND_ROW__MATRIX);
		createEOperation(matrixEClass, MATRIX___APPEND_COLUMN__MATRIX);

		matrixRowEClass = createEClass(MATRIX_ROW);
		createEAttribute(matrixRowEClass, MATRIX_ROW__VALUES);
		createEOperation(matrixRowEClass, MATRIX_ROW___GET_SIZE);
		createEOperation(matrixRowEClass, MATRIX_ROW___TO_CONSTRAINT__ELIST);
		createEOperation(matrixRowEClass, MATRIX_ROW___GET__INT);
		createEOperation(matrixRowEClass, MATRIX_ROW___SET__INT_LONG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(matrixEClass, Matrix.class, "Matrix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatrix_Rows(), this.getMatrixRow(), null, "rows", null, 0, -1, Matrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMatrix__Inverse(), this.getMatrix(), "inverse", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getMatrix__InverseInContext__Matrix(), this.getMatrix(), "inverseInContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Mul__Matrix(), this.getMatrix(), "mul", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Add__Matrix(), this.getMatrix(), "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Sub__Matrix(), this.getMatrix(), "sub", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__Transpose(), this.getMatrix(), "transpose", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Identity__int(), this.getMatrix(), "identity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "size", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__FindHermiteBasis(), this.getMatrix(), "findHermiteBasis", 2, 2, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsUnimodular(), ecorePackage.getEBoolean(), "isUnimodular", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsInHNF(), ecorePackage.getEBoolean(), "isInHNF", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsIntegral(), ecorePackage.getEBoolean(), "isIntegral", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__Left_hermite(), this.getMatrix(), "left_hermite", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsIdentity(), ecorePackage.getEBoolean(), "isIdentity", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsSquare(), ecorePackage.getEBoolean(), "isSquare", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__ToConstraints__EList(), theAlgebraPackage.getIntConstraintSystem(), "toConstraints", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variables", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__GetNbCols(), ecorePackage.getEInt(), "getNbCols", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__GetNbRows(), ecorePackage.getEInt(), "getNbRows", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Set__int_int_long(), null, "set", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "row", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "col", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Get__int_int(), ecorePackage.getELong(), "get", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "row", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "col", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__Equivalence__Matrix(), ecorePackage.getEBoolean(), "equivalence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__Nullspace(), this.getMatrix(), "nullspace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__ToDomain__EList_EList(), theAlgebraPackage.getIntConstraintSystem(), "toDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "params", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "indices", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__ToFunction__EList_EList(), theAlgebraPackage.getIntExpression(), "toFunction", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "params", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "indices", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__RowRank(), ecorePackage.getEInt(), "rowRank", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__ColumnRank(), ecorePackage.getEInt(), "columnRank", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsFullRowRank(), ecorePackage.getEBoolean(), "isFullRowRank", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__IsFullColumnRank(), ecorePackage.getEBoolean(), "isFullColumnRank", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__ColumnSpace(), this.getMatrix(), "columnSpace", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatrix__HermiteNormalForm(), this.getMatrix(), "hermiteNormalForm", 1, 2, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__AppendRow__Matrix(), this.getMatrix(), "appendRow", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "mat", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrix__AppendColumn__Matrix(), this.getMatrix(), "appendColumn", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMatrix(), "mat", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matrixRowEClass, MatrixRow.class, "MatrixRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatrixRow_Values(), ecorePackage.getELongObject(), "values", null, 0, -1, MatrixRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMatrixRow__GetSize(), ecorePackage.getEInt(), "getSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrixRow__ToConstraint__EList(), theAlgebraPackage.getIntConstraint(), "toConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variables", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrixRow__Get__int(), ecorePackage.getELong(), "get", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "col", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatrixRow__Set__int_long(), null, "set", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "col", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
	}

} //MatrixPackageImpl
