package org.polymodel.polyhedralIR.analysis;

import org.polymodel.Function;
import org.polymodel.matrix.Matrix;
import org.polymodel.polyhedralIR.AffineFunction;

/**
 * This class implement a number of analysis to check uniformization.
 * These checks are described in the thesis by Roychowdhury.
 * 
 * These methods are shared among the analysis to find uniformization vectors,
 *  and by the uniformizing transformation, and thus defined in a separate class.
 * 
 * @author yuki
 *
 */
public class UniformizationChecks {

	/**
	 * Corresponds to Theorem 13 of Roychowdhury thesis.
	 * When x[Iz] = y [Qz + b], the dependence Qz+b is uniformizable with uniformization
	 * vector in nullspace of Q, null(Q), iff Q = Q^2
	 * 
	 * @param f
	 * @return
	 */
	public static boolean checkIdempotence(AffineFunction f) {
		return checkIdempotence(f.getPMmapping());
	}
	
	public static boolean checkIdempotence(Function f) {
		Matrix mat = f.linearPartWithParameters();
		
		Matrix sq = mat.mul(mat);
		
		return mat.equivalence(sq);
	}
	
	/**
	 * The rank of a dependence f = Ax+b is the rank of matrix I - A.
	 * 
	 * @param f
	 * @return
	 */
	public static int getDependenceRank(AffineFunction f) {
		Matrix A = f.getPMmapping().linearPartWithParameters();
		Matrix I = A.identity(A.getNbRows());
		return I.sub(A).rowRank();
	}
	
	/**
	 * Checks if the given vector is a valid uniformization vector for the dependence f.
	 * 
	 * @param u
	 * @param f
	 * @return
	 */
	public static boolean isValidUniformizationVector(int[] u, AffineFunction f) {
		return vectorInRange(u, f.getPMmapping().linearPart());
	}
	
	private static boolean vectorInRange(int[] v, Matrix m) {
		Matrix R = m.columnSpace();
		assert(R.getNbRows() == v.length);
		
		for (int r = 0; r < R.getNbRows(); r++) {
			R.getRows().get(r).getValues().add((long)v[r]);
		}
		return R.isFullColumnRank();
	}
}
