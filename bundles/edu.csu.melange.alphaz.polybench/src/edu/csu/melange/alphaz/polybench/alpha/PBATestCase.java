package edu.csu.melange.alphaz.polybench.alpha;

import org.junit.Test;

import junit.framework.TestCase;

public abstract class PBATestCase extends TestCase {
	

	private static final String POLYBENCH_ALPHA_DIR = "./polybench-alpha/";
	private static final String DATAMINING_DIR = POLYBENCH_ALPHA_DIR + "datamining/";
	private static final String LA_KERNELS_DIR = POLYBENCH_ALPHA_DIR + "linear-algebra/kernels/";
	private static final String LA_SOLVERS_DIR = POLYBENCH_ALPHA_DIR + "linear-algebra/solvers/";
	private static final String MEDLEY_DIR = POLYBENCH_ALPHA_DIR + "medley/";
	private static final String STENCILS_DIR = POLYBENCH_ALPHA_DIR + "stencils/";
	
	protected abstract void test(String filename);
	
	@Test
	public void test_correlation() {
		test(DATAMINING_DIR + "correlation.ab");
	}
	
	@Test
	public void test_covariance() {
		test(DATAMINING_DIR + "covariance.ab");
	}

	@Test
	public void test__2mm() {
		test(LA_KERNELS_DIR + "2mm.ab");
	}

	@Test
	public void test__3mm() {
		test(LA_KERNELS_DIR + "3mm.ab");
	}

	@Test
	public void test_atax() {
		test(LA_KERNELS_DIR + "atax.ab");
	}

	@Test
	public void test_bicg() {
		test(LA_KERNELS_DIR + "bicg.ab");
	}

	@Test
	public void test_cholesky() {
		test(LA_KERNELS_DIR + "cholesky.ab");
	}
	
	@Test
	public void test_doitgen() {
		test(LA_KERNELS_DIR + "doitgen.ab");
	}
	
	@Test
	public void test_gemm() {
		test(LA_KERNELS_DIR + "gemm.ab");
	}
	
	@Test
	public void test_gemver() {
		test(LA_KERNELS_DIR + "gemver.ab");
	}
	
	@Test
	public void test_gesummv() {
		test(LA_KERNELS_DIR + "gesummv.ab");
	}
	
	@Test
	public void test_mvt() {
		test(LA_KERNELS_DIR + "mvt.ab");
	}
	
	@Test
	public void test_symm() {
		test(LA_KERNELS_DIR + "symm.ab");
	}
	
	@Test
	public void test_syr2k() {
		test(LA_KERNELS_DIR + "syr2k.ab");
	}
	
	@Test
	public void test_syrk() {
		test(LA_KERNELS_DIR + "syrk.ab");
	}
	
	@Test
	public void test_trisolv() {
		test(LA_KERNELS_DIR + "trisolv.ab");
	}
	
	@Test
	public void test_trmm() {
		test(LA_KERNELS_DIR + "trmm.ab");
	}

	@Test
	public void test_dynprog() {
		test(LA_SOLVERS_DIR + "dynprog.ab");
	}

	@Test
	public void test_gramschmidt() {
		test(LA_SOLVERS_DIR + "gramschmidt.ab");
	}

	@Test
	public void test_lu() {
		test(LA_SOLVERS_DIR + "lu.ab");
	}

	@Test
	public void test_ludcmp() {
		test(LA_SOLVERS_DIR + "ludcmp.ab");
	}

	@Test
	public void test_floyd_warshall() {
		test(MEDLEY_DIR + "floyd-warshall.ab");
	}

	@Test
	public void test_reg_detect() {
		test(MEDLEY_DIR + "reg_detect.ab");
	}
	
	@Test
	public void test_fdtd_2d() {
		test(STENCILS_DIR + "fdtd-2d.ab");
	}

	@Test
	public void test_jacobi_1d() {
		test(STENCILS_DIR + "jacobi_1d.ab");
	}
	
	@Test
	public void test_jacobi_2d() {
		test(STENCILS_DIR + "jacobi_2d.ab");
	}

	@Test
	public void test_seidel_2d() {
		test(STENCILS_DIR + "seidel_2d.ab");
	}
}
