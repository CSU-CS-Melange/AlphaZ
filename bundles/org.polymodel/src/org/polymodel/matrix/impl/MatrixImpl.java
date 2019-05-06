/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixPackage;
import org.polymodel.matrix.MatrixRow;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Matrix</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.matrix.impl.MatrixImpl#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixImpl extends EObjectImpl implements Matrix {
	/**
	 * The cached value of the '{@link #getRows() <em>Rows</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRows()
	 * @generated
	 * @ordered
	 */
	protected EList<MatrixRow> rows;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MatrixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MatrixPackage.Literals.MATRIX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatrixRow> getRows() {
		if (rows == null) {
			rows = new EObjectContainmentEList<MatrixRow>(MatrixRow.class, this, MatrixPackage.MATRIX__ROWS);
		}
		return rows;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Matrix inverse() {
		long[][] m = PolymodelMatrixOperation.toMatrix(this);
		long[][] res = MatrixOperations.intInverse(m);
		return PolymodelMatrixOperation.toMatrix(res);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix inverseInContext(Matrix context) {
		long[][] m = PolymodelMatrixOperation.toMatrix(this);
		long[][] c = (context==null)?null:PolymodelMatrixOperation.toMatrix(context);
		long[][] res = MatrixOperations.getInverseInContext(m, c);
		return PolymodelMatrixOperation.toMatrix(res);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Matrix mul(Matrix b) {
		return PolymodelMatrixOperation.mul(this, b);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix add(Matrix b) {
		return PolymodelMatrixOperation.add(this, b);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix sub(Matrix b) {
		return PolymodelMatrixOperation.sub(this, b);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Matrix transpose() {
		long[][] m = PolymodelMatrixOperation.toMatrix(this);
		long[][] res = MatrixOperations.transpose(m);
		return PolymodelMatrixOperation.toMatrix(res);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Matrix identity(int size) {
		return PolymodelMatrixOperation.createIdentityMatrix(size);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Matrix> findHermiteBasis() {
		return PolymodelMatrixOperation.smithNormalForm(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnimodular() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInHNF() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntegral() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Matrix> left_hermite() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isIdentity() {
		if (isSquare()) {
			for(int i=0;i<getNbCols();++i){
				long l = get(i, i);
				if(l!=1)
					return false;
			}
			return true;
		} 
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSquare() {
		return getNbCols() == getNbRows();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IntConstraintSystem toConstraints(EList<Variable> variables) {
		IntConstraint constraints[] = new IntConstraint[getNbRows()];
		for (int j = 0; j < getNbRows(); ++j) {
			constraints[j] = getRows().get(j).toConstraint(variables);
		}
		return IntExpressionBuilder.constraintSystem(constraints);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getNbCols() {
		if (getRows().size() > 0) {
			MatrixRow matrixRow = getRows().get(0);
			return matrixRow.getValues().size();
		} else {
			return 0;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getNbRows() {
		return getRows().size();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void set(int row, int col, long value) {
		assert(getNbRows() > row);
		assert(getNbCols() > col);
		getRows().get(row).getValues().set(col, value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long get(int row, int col) {
		return getRows().get(row).getValues().get(col);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equivalence(Matrix m) {
		for(int i=0;i<getNbRows();++i){
			for(int j=0;j<getNbCols();++j){
				if(get(i, j)!=m.get(i, j))
					return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix nullspace() {
		return PolymodelMatrixOperation.nullspace(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraintSystem toDomain(EList<Variable> params, EList<Variable> indices) {
		IntConstraintSystem system = IntExpressionBuilder.constraintSystem();
		for (MatrixRow row : getRows()) {
			system.getConstraints().add(row.toConstraint(params, indices));
		}
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IntExpression> toFunction(EList<Variable> params, EList<Variable> indices) {
		EList<IntExpression> exprs = new BasicEList<IntExpression>();
		
		List<Variable> vars = new ArrayList<Variable>(params.size()+indices.size());
		vars.addAll(params);
		vars.addAll(indices);
		
		for (MatrixRow row : getRows()) {
			AffineExpression expr = IntExpressionBuilder.affine();
			for (int c = 0; c < row.getSize()-1; c++) {
				if (row.get(c) != 0) {
					expr.getTerms().add(IntExpressionBuilder.term(row.get(c),vars.get(c)));
				}
			}
			//constant part
			if (row.get(row.getSize()-1) != 0 || expr.getTerms().size() == 0) {
				expr.getTerms().add(IntExpressionBuilder.term(row.get(row.getSize()-1)));
			}
			exprs.add(expr);
		}
		
		return exprs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int rowRank() {
		return MatrixOperations.getRank(PolymodelMatrixOperation.toMatrix(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int columnRank() {
		return MatrixOperations.getRank(MatrixOperations.transpose(PolymodelMatrixOperation.toMatrix(this)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFullRowRank() {
		return this.getNbRows() == rowRank();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFullColumnRank() {
		return this.getNbCols() == columnRank();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns basis vectors found by converting the matrix into RRE form.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix columnSpace() {
		double[][] dmat = MatrixOperations.toDoubleMatrix(PolymodelMatrixOperation.toMatrix(this));
		List<double[][]> gaussResult = MatrixOperations.gaussRow(dmat);
		double[] V = gaussResult.get(2)[0];
		
		long[][] cspace = new long[getNbRows()][V.length];
		for (int r = 0; r < getNbRows(); r++) {
			for (int i = 0; i < V.length; i++) {
				int c = (int)V[i];
				cspace[r][i] = get(r, c);
			}	
		}
		
		return PolymodelMatrixOperation.toMatrix(cspace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Matrix> hermiteNormalForm() {
		long[][] mat = PolymodelMatrixOperation.toMatrix(this);
		List<long[][]> hnf = MatrixOperations.HnfTransformation(mat);
		EList<Matrix> res = new BasicEList<Matrix>();

		res.add(PolymodelMatrixOperation.toMatrix(hnf.get(0)));
		res.add(PolymodelMatrixOperation.toMatrix(hnf.get(1)));
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix appendRow(Matrix mat) {
		if (this.getNbCols() != mat.getNbCols()) {
			throw new RuntimeException("appendRow: require same number of columns");
		}
		
		Matrix matrix = EcoreUtil.copy(this);
		for (MatrixRow row : mat.getRows()) {
			matrix.getRows().add(EcoreUtil.copy(row));
		}
		
		return matrix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix appendColumn(Matrix mat) {
		if (this.getNbRows() != mat.getNbRows()) {
			throw new RuntimeException("appendColumn: require same number of rows");
		}

		Matrix matrix = EcoreUtil.copy(this);
		for (int i = 0; i < matrix.getNbRows(); i++) {
			MatrixRow rowA = matrix.getRows().get(i);
			MatrixRow rowB = mat.getRows().get(i);
			for (long val : rowB.getValues()) {
				rowA.getValues().add(val);
			}
		}
		
		return matrix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MatrixPackage.MATRIX__ROWS:
				return ((InternalEList<?>)getRows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MatrixPackage.MATRIX__ROWS:
				return getRows();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MatrixPackage.MATRIX__ROWS:
				getRows().clear();
				getRows().addAll((Collection<? extends MatrixRow>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MatrixPackage.MATRIX__ROWS:
				getRows().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MatrixPackage.MATRIX__ROWS:
				return rows != null && !rows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MatrixPackage.MATRIX___INVERSE:
				return inverse();
			case MatrixPackage.MATRIX___INVERSE_IN_CONTEXT__MATRIX:
				return inverseInContext((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___MUL__MATRIX:
				return mul((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___ADD__MATRIX:
				return add((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___SUB__MATRIX:
				return sub((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___TRANSPOSE:
				return transpose();
			case MatrixPackage.MATRIX___IDENTITY__INT:
				return identity((Integer)arguments.get(0));
			case MatrixPackage.MATRIX___FIND_HERMITE_BASIS:
				return findHermiteBasis();
			case MatrixPackage.MATRIX___IS_UNIMODULAR:
				return isUnimodular();
			case MatrixPackage.MATRIX___IS_IN_HNF:
				return isInHNF();
			case MatrixPackage.MATRIX___IS_INTEGRAL:
				return isIntegral();
			case MatrixPackage.MATRIX___LEFT_HERMITE:
				return left_hermite();
			case MatrixPackage.MATRIX___IS_IDENTITY:
				return isIdentity();
			case MatrixPackage.MATRIX___IS_SQUARE:
				return isSquare();
			case MatrixPackage.MATRIX___TO_CONSTRAINTS__ELIST:
				return toConstraints((EList<Variable>)arguments.get(0));
			case MatrixPackage.MATRIX___GET_NB_COLS:
				return getNbCols();
			case MatrixPackage.MATRIX___GET_NB_ROWS:
				return getNbRows();
			case MatrixPackage.MATRIX___SET__INT_INT_LONG:
				set((Integer)arguments.get(0), (Integer)arguments.get(1), (Long)arguments.get(2));
				return null;
			case MatrixPackage.MATRIX___GET__INT_INT:
				return get((Integer)arguments.get(0), (Integer)arguments.get(1));
			case MatrixPackage.MATRIX___EQUIVALENCE__MATRIX:
				return equivalence((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___NULLSPACE:
				return nullspace();
			case MatrixPackage.MATRIX___TO_DOMAIN__ELIST_ELIST:
				return toDomain((EList<Variable>)arguments.get(0), (EList<Variable>)arguments.get(1));
			case MatrixPackage.MATRIX___TO_FUNCTION__ELIST_ELIST:
				return toFunction((EList<Variable>)arguments.get(0), (EList<Variable>)arguments.get(1));
			case MatrixPackage.MATRIX___ROW_RANK:
				return rowRank();
			case MatrixPackage.MATRIX___COLUMN_RANK:
				return columnRank();
			case MatrixPackage.MATRIX___IS_FULL_ROW_RANK:
				return isFullRowRank();
			case MatrixPackage.MATRIX___IS_FULL_COLUMN_RANK:
				return isFullColumnRank();
			case MatrixPackage.MATRIX___COLUMN_SPACE:
				return columnSpace();
			case MatrixPackage.MATRIX___HERMITE_NORMAL_FORM:
				return hermiteNormalForm();
			case MatrixPackage.MATRIX___APPEND_ROW__MATRIX:
				return appendRow((Matrix)arguments.get(0));
			case MatrixPackage.MATRIX___APPEND_COLUMN__MATRIX:
				return appendColumn((Matrix)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	public String toString() {
		StringBuffer tmp = new StringBuffer();
		tmp.append("\nMatrix [" + getNbCols() + "x" + getNbRows() + "]\n");
		for (int j = 0; j < getNbRows(); j++) {
			tmp.append(getRows().get(j)+"\n");
		}
		tmp.append("\n");
		return tmp.toString();
	}

	public List<Long> getColumn(int col) {
		List<Long> column =new ArrayList<Long>(getNbRows());
		for (int i = 0; i < getNbRows(); i++) {
			column.add(get(i, col));
		}
		return column;
	}
	
	public long[][] toLongArray() {
		long[][] mat = new long[getNbRows()][getNbCols()];

		for (int r = 0; r < getNbRows(); r++) {
			for (int c = 0; c < getNbCols(); c++) {
				mat[r][c] = get(r, c);
			}
		}
		
		return mat;
	}
} // MatrixImpl
