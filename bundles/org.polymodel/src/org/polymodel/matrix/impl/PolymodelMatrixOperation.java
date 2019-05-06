package org.polymodel.matrix.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixFactory;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.util.PolymodelException;

public class PolymodelMatrixOperation {
	private static MatrixFactory factory=MatrixFactory.eINSTANCE;


	public static Matrix mul(Matrix a, Matrix b) {
		if (a.getNbCols() != b.getNbRows())
			throw new IllegalArgumentException(
					"Matrix multiplication : number of columns and rows is not equals.");
		Matrix res = factory.createMatrix();

		for (int row = 0; row < a.getNbRows(); row++) {
			MatrixRow r = factory.createMatrixRow();
			for (int col = 0; col < b.getNbCols(); col++) {
				long val = 0;
				for (int k = 0; k < a.getNbCols(); k++) {
					val += a.get(row, k) * b.get(k, col);
				}
				r.getValues().add(col, val);
			}
			res.getRows().add(r);
		}
		return res;
	}
	
	public static Matrix add(Matrix a, Matrix b) {
		if (a.getNbRows() != b.getNbRows() || a.getNbCols() != b.getNbCols())
			throw new IllegalArgumentException(
					"Matrix addition: number of rows/columns does not match.");

		Matrix res = factory.createMatrix();

		for (int row = 0; row < a.getNbRows(); row++) {
			MatrixRow r = factory.createMatrixRow();
			for (int col = 0; col < b.getNbCols(); col++) {
				r.getValues().add(col, a.get(row, col) + b.get(row, col));
			}
			res.getRows().add(r);
		}
		return res;
	}
	
	public static Matrix sub(Matrix a, Matrix b) {
		if (a.getNbRows() != b.getNbRows() || a.getNbCols() != b.getNbCols())
			throw new IllegalArgumentException(
					"Matrix subtraction: number of rows/columns does not match.");

		Matrix res = factory.createMatrix();

		for (int row = 0; row < a.getNbRows(); row++) {
			MatrixRow r = factory.createMatrixRow();
			for (int col = 0; col < b.getNbCols(); col++) {
				r.getValues().add(col, a.get(row, col) - b.get(row, col));
			}
			res.getRows().add(r);
		}
		return res;
	}
	
	public static Matrix createMatrix(int nRow, int nCol, long initValue) {
		Matrix res;

		res = factory.createMatrix();
		for (int i = 0; i < nRow; i++) {
			MatrixRow row = factory.createMatrixRow();
			for (int j = 0; j < nCol; j++) {
				row.getValues().add(initValue);
			}
			res.getRows().add(row);
		}
		
		return res;
	}
	
	public static Matrix createIdentityMatrix(int size) {
		Matrix res = factory.createMatrix();

		for (int i = 0; i < size; i++) {
			MatrixRow row = factory.createMatrixRow();
			for (int j = 0; j < size; j++) {
				if (i == j) {
					row.getValues().add(1l);
				} else {
					row.getValues().add(0l);
				}
			}
			res.getRows().add(row);
		}
		
		return res;
	}

	/**
	 * Swaps row i with row j.
	 * 
	 * @param A
	 *            Matrix to operate on.
	 * @param i
	 *            Index if a row to swap
	 * @param j
	 *            Index if a row to swap
	 */
	public static void swapRows(Matrix A, int i, int j) {
		for (int c = 0; c < A.getNbCols(); c++) {
			long temp = A.get(i, c);
			A.set(i, c, A.get(j, c));
			A.set(j, c, temp);
		}
	}
	/**
	 * Swaps column i with row j.
	 * 
	 * @param A
	 *            Matrix to operate on.
	 * @param i
	 *            Index if a column to swap
	 * @param j
	 *            Index if a column to swap
	 */

	public static void swapColumns(Matrix A, int i, int j) {
		for (int r = 0; r < A.getNbRows(); r++) {
			long temp = A.get(r, i);
			A.set(r, i, A.get(r, j));
			A.set(r, j, temp);
		}
	}

	/**
	 * calculate the Smith Normal Form of A
	 * 
	 * @param A
	 *            Matrix to operate on.
	 * @return A list contains 3 elements: List[0] is the Smith Normal Form of
	 *         A, List[1] is P and List[2] is Q which P and Q are unimodular
	 *         matrix and P*A*Q=SNF of A
	 */ 
	public static EList<Matrix> smithNormalForm(Matrix A) {

		// initialize 
		EList<Matrix> result = new BasicEList<Matrix>();
		
		Triplet<long[][], long[][], long[][]> snf = MatrixOperations.smithNormalForm(toMatrix(A));
		result.add(toMatrix(snf.getValue0()));
		result.add(toMatrix(snf.getValue1()));
		result.add(toMatrix(snf.getValue2()));
		
		return result;
	}
	

	/**
	 * Calculate inverse transformation of T with equations A (Only the
	 * equations in domain should be input) T is n*m, A is r*m, the return
	 * matrix should be m*n
	 * 
	 * @param T
	 *            Transformation matrix
	 * @param A
	 *            Equations matrix
	 * @return Inverse Matrix of T
	 */
	public static Matrix getInverseInContext(Matrix T, Matrix A) throws PolymodelException {
		return toMatrix(MatrixOperations.getInverseInContext(toMatrix(T), toMatrix(A)));
	}
	
	/**
	 * Converts Matrix in model to 2D array of primitive longs.
	 * Used to interface with MatrixOperations class.
	 * 
	 * @param A
	 * @return
	 */
	public static long[][] toMatrix(Matrix A) {
		long[][] mat = new long[A.getNbRows()][A.getNbCols()];

		for (int r = 0; r < A.getNbRows(); r++) {
			for (int c = 0; c < A.getNbCols(); c++) {
				mat[r][c] = A.get(r, c);
			}
		}
		
		return mat;
	}
	
	/**
	 * Converts matrix as 2D array of longs to Matrix in model.
	 * Used to interface with MatrixOperations class.
	 * 
	 * @param A
	 * @return
	 */
	public static Matrix toMatrix(long[][] A) {
		if (A == null || A.length == 0) {
			throw new RuntimeException("Empty matrix");
		}
		
		Matrix mat = createMatrix(A.length, A[0].length, 0);

		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				mat.set(r,c, A[r][c]);
			}
		}
		
		return mat;
	}


	public static Matrix nullspace(Matrix A) {
		return toMatrix(MatrixOperations.nullspace(toMatrix(A)));
	}

	/**
	 * calculate the Smith Normal Form of A
	 * 
	 * @param A
	 *            Matrix to operate on.
	 * @return A list contains 3 elements: List[0] is the Smith Normal Form of
	 *         A, List[1] is P and List[2] is Q which P and Q are unimodular
	 *         matrix and P*A*Q=SNF of A
	 * 
	public EList<Matrix> smithNormalForm(Matrix A) {

		// initialize 
		EList<Matrix> result = new BasicEList<Matrix>();
		int M = A.getNbRows();
		int N = A.getNbCols();
		int bound = Math.min(M, N);
		Matrix left, right;
		left  = createIdentityMatrix(M);
		right = createIdentityMatrix(N);

		// operate row by row 
		for (int i = 0; i < bound; i++) {

			// found gcd of the matrix 
			long gcd = A.get(i, i);

			for (int j = i; j < M; j++) {
				for (int k = i; k < N; k++) {
					gcd = gcd(A.get(j, k), gcd);
				}
			}

			// Look for the min value 
			long Min = Long.MAX_VALUE;
			int posX = -1, posY = -1;

			for (int j = i; j < M; j++) {
				for (int k = i; k < N; k++) {
					if (Math.abs(A.get(j,k)) < Min && A.get(j,k) != 0) {
						posX = j;
						posY = k;
						Min = Math.abs(A.get(j,k));
					}
				}
			}

			// swap min value to left-up corner 
			if (posX != i) {
				if (posX == -1) {
					for (int j = 0; j < Math.min(M, N); j++) {
						if (A.get(j, j) < 0) {
							A.set(j, j, -A.get(j, j));
							//TODO It was like this in the original code : check with Simon
							scalarMultiplication(left.getRows().get(j), -1);
						}
					}
					result.add(A);
					result.add(left);
					result.add(right);
					return result;
				}
				swapRows(A, i, posX);
				swapRows(left, i, posX);
			}
			if (posY != i) {
				if (posY == -1) {
					for (int j = 0; j < Math.min(M, N); j++) {
						if (A.get(j, j) < 0) {
							A.set(j, j, -A.get(j, j));
							scalarMultiplication(left.getRows().get(j), -1);
						}
					}
					result.add(A);
					result.add(left);
					result.add(right);
					return result;
				}
				swapColumns(A, i, posY);
				swapColumns(right, i, posY);
			}
			while (true) {

				// massage the row i 
				for (int j = i + 1; j < N; j++) {
					while (A.get(i, j) % A.get(i, i) != 0) {
						long scalar = -A.get(i, j) / A.get(i, i);

						columnAddition(A, j, i, scalar);
						columnAddition(right, j, i, scalar);
						swapColumns(A, i, j);
						swapColumns(right, i, j);
					}
					long scalar = -A.get(i, j) / A.get(i, i);

					columnAddition(A, j, i, scalar);
					columnAddition(right, j, i, scalar);
				}

				// massage the column i 
				for (int j = i + 1; j < M; j++) {
					while (A.get(j, i) % A.get(i, i) != 0) {
						long scalar = -A.get(j, i) / A.get(i, i);

						rowAddition(A, j, i, scalar);
						rowAddition(left, j, i, scalar);
						swapRows(A, i, j);
						swapRows(left, i, j);
					}
					long scalar = -A[j][i] / A[i][i];

					rowAddition(A, j, i, scalar);
					rowAddition(left, j, i, scalar);
				}

				// massage the row i
				for (int j = i + 1; j < N; j++) {
					long scalar = -A[i][j] / A[i][i];

					columnAddition(A, j, i, scalar);
					columnAddition(right, j, i, scalar);
				}

				// massage the column i 
				for (int j = i + 1; j < M; j++) {
					long scalar = -A[j][i] / A[i][i];

					rowAddition(A, j, i, scalar);
					rowAddition(left, j, i, scalar);
				}

				// do the remaining
				if (Math.abs(A[i][i]) != Math.abs(gcd)) {
					for (int j = i + 1; j < M; j++) {
						for (int k = i + 1; k < N; k++) {
							if (A[j][k] % A[i][i] != 0) {
								rowAddition(A, j, i, 1);
								rowAddition(left, j, i, 1);
								j = M + 1;
								k = N + 1;
							}
						}
					}
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < Math.min(M, N); i++) {
			if (A[i][i] < 0) {
				A[i][i] = -A[i][i];
				left[i] = scalarMultiplication(left[i], -1);
			}
		}
		result.add(A);
		result.add(left);
		result.add(right);
		return result;
	}
* */
}
