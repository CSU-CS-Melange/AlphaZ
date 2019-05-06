package edu.csu.melange.alphaz.mde.tests.codegen;

import static edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.createTestEntry;

import org.junit.Test;

public class PolyIRPGASCTest {
	
	protected static final String TEST_TMFILE_DIR  = "PGAStests/targetmapping/";
	protected static final String TEST_INPUT_DIR  = "PGAStests/inputs/";
	protected static final String TEST_OUTPUT_DIR = "PGAStests/outputs/";
	
	
	protected static final String[][] TILING_TESTS = new String[][] {
//		createTestEntry("jacobi_1d", "100 100 10 10 1 1", "tiled", "100x100"),
//		createTestEntry("jacobi_1d", "100 100 10 10 4 1", "tiled", "100x100"),
//		createTestEntry("jacobi_1d_imper", "100 100 10 10 1 1", "tiled", "100x100"),
//		createTestEntry("jacobi_1d_imper", "100 100 10 10 4 1", "tiled", "100x100"),
		createTestEntry("smith_waterman", "20 10 5 5 2 1", "tiled", "20x10"),
//		createTestEntry("matrix_product", "4 8 2 2 2 2 1 1", "tiled", "4x8x2"),
//		createTestEntry("matrix_product", "100 200 300 25 50 50 1 1", "tiled", "100x200x300"),
//		createTestEntry("matrix_product", "100 200 300 50 50 50 4 1", "tiled", "100x200x300"),
//		createTestEntry("jacobi_2d", "10 5 2 2 2 1 1", "tiled", "10x5"),
//		createTestEntry("jacobi_2d", "200 100 30 20 1 1", "tiled", "200x100"),
//		createTestEntry("jacobi_2d", "200 100 30 20 4 1", "tiled", "200x100"),
//		createTestEntry("jacobi_2d_imper", "200 100 30 20 1 1", "tiled", "200x100"),
//		createTestEntry("jacobi_2d_imper", "200 100 30 20 4 1", "tiled", "200x100"),
//		new String[] {"alphabets/matrix_product.ab", "matrix_product", "4 8 2 2 2 2 2 1", TEST_TMFILE_DIR+"matmult.tiled.tm", TEST_INPUT_DIR+"matmult.testin.4x8x2", TEST_OUTPUT_DIR+"matmult.testout.4x8x2"},
//		new String[] {"alphabets/matrix_product.ab", "matrix_product", "100 200 300 50 50 50 1 1", TEST_TMFILE_DIR+"matmult.tiled.tm", TEST_INPUT_DIR+"matmult.testin.100x200x300", TEST_OUTPUT_DIR+"matmult.testout.100x200x300"},
		//new String[] {"jacobi-1d-imper.ab", "jacobi_1d_imper", "100 100 10 10 4 1", TEST_TMFILE_DIR+"jacobi-1d-imper.tiled.tm", TEST_INPUT_DIR+"jacobi-1d-imper.testin.100x100", TEST_OUTPUT_DIR+"jacobi-1d-imper.testout.100x100"},
		//new String[] {"alphabets/jacobi-1d-imper.ab", "jacobi_1d_imper", "10 10 5 5 4 1", TEST_TMFILE_DIR+"jacobi-1d-imper.tiled.tm", TEST_INPUT_DIR+"jacobi-1d-imper.testin.10x10", TEST_OUTPUT_DIR+"jacobi-1d-imper.testout.10x10"},
//		new String[] {"alphabets/jacobi-2d-imper.ab", "jacobi_2d_imper", "10 5 2 2 2 1 0", TEST_TMFILE_DIR+"jacobi-2d-imper.tiled.tm", TEST_INPUT_DIR+"jacobi-2d-imper.testin.10x5", TEST_OUTPUT_DIR+"jacobi-2d-imper.testout.10x5"},
//		new String[] {"alphabets/codegenTests/jacobi_1d_2arrays.ab", "jacobi_1d_2arrays", "10 5 2 2 2", TEST_TMFILE_DIR+"jacobi_1d_2arrays.tiled.tm", TEST_INPUT_DIR+"jacobi_1d_2arrays.testin.10x5", TEST_OUTPUT_DIR+"jacobi_1d_2arrays.testout.10x5"},
//		new String[] {"alphabets/smith-waterman.ab", "smith_waterman", "20 10 5 5 2 1", TEST_TMFILE_DIR+"smith-waterman.tiled.tm", TEST_INPUT_DIR+"smith-waterman.testin.20x10", TEST_OUTPUT_DIR+"smith-waterman.testout.20x10"},
//		new String[] {"alphabets/jacobi-1d-polybench.ab", "jacobi_1d_polybench", "10 10 5 5 2 1", TEST_TMFILE_DIR+"jacobi-1d-polybench.tiled.tm", TEST_INPUT_DIR+"jacobi-1d-imper.testin.10x10", TEST_OUTPUT_DIR+"jacobi-1d-imper.testout.10x10"},
//		new String[] {"alphabets/jacobi-1d-polybench.ab", "jacobi_1d_polybench", "100 100 10 10 2 1", TEST_TMFILE_DIR+"jacobi-1d-polybench.tiled.tm", TEST_INPUT_DIR+"jacobi-1d-imper.testin.100x100", TEST_OUTPUT_DIR+"jacobi-1d-imper.testout.100x100"},
	};
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test(){
//		CodeGenTestingFramework.run(CODEGEN.PGAS_C, TILING_TESTS);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		CodeGenTestingFramework.run(CODEGEN.PGAS_C, TILING_TESTS);
	}
	
	
}
