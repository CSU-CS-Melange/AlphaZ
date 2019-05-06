package edu.csu.melange.alphaz.mde.tests.regression;

import static edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.createTestEntry;
import static edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.createStencilTestEntry;
import static edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.createTestEntryWithDefaultNames;

import java.io.IOException;

import org.junit.Test;

import edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.TEST_SETTING;

/**
 * Collection of test cases for testing code generators.
 * 
 * Note:
 * Due to some issue in memory management, running all test at once is likely to cause 
 * your machine to run out of memory. Right click on each sub-tests to run them individually.
 * 
 * @author yuki
 *
 */
public class CodeGenRegressionTests {
	
	protected static final String TEST_TMFILE_DIR  = "regression/codegen/targetmapping/";
	protected static final String TEST_INPUT_DIR  = "regression/codegen/inputs/";
	protected static final String TEST_OUTPUT_DIR = "regression/codegen/outputs/";
	
	protected static final String[][] COMMON_TESTS = new String[][]{
		createTestEntryWithDefaultNames("matrix_product", "100 200 300"),
		createTestEntryWithDefaultNames("matrix_product", "4 8 2"),
		createTestEntryWithDefaultNames("matrix_product_withReduce", "100 200 300"),
		
		createTestEntryWithDefaultNames("2mm", "5"),
		
		createTestEntryWithDefaultNames("jacobi_1d", "100 100"),
		createTestEntryWithDefaultNames("jacobi_1d_imper", "100 100"),
		
		createTestEntryWithDefaultNames("jacobi_2d", "10 5"),
		createTestEntryWithDefaultNames("jacobi_2d", "200 100"),
		createTestEntryWithDefaultNames("jacobi_2d_imper", "200 100"),
		
		createTestEntryWithDefaultNames("smith_waterman", "20 10"),
		
		createTestEntryWithDefaultNames("cholesky", "10"),
		createTestEntryWithDefaultNames("cholesky_withReduce", "10"),
		createTestEntryWithDefaultNames("cholesky", "100"),

		createTestEntryWithDefaultNames("mss", "7"),
		createTestEntryWithDefaultNames("mssNoTemp", "7"),
	};
	
	protected static final String[][] WRITEC_TESTS = new String[][] {
		createTestEntry("fibonacci", "5", null, null, "fibonacci.out.5"),
	};
	
	protected static final String[][] TILING_TESTS = new String[][] {
		createTestEntry("matrix_product", "4 8 2 2 2 2", "tiled", "4x8x2"),
		createTestEntry("matrix_product", "100 200 300 10 30 20", "tiled", "100x200x300"),
		
		createTestEntry("smith_waterman", "20 10 10 5", "tiled", "20x10"),
		createTestEntry("smith_waterman", "20 10 10 5", "tiled2", "20x10"),

		createTestEntry("jacobi_1d", "100 100 10 5", "tiled", "100x100"),
		createTestEntry("jacobi_1d", "100 100 10 5", "tiled2", "100x100"),
		createTestEntry("jacobi_1d_imper", "100 100 10 5", "tiled", "100x100"),
		
		createTestEntry("jacobi_2d", "10 5 2 2 2", "tiled", "10x5"),
		createTestEntry("jacobi_2d", "200 100 10 10 10", "tiled", "200x100" ),
		createTestEntry("jacobi_2d", "200 100 10 10 10", "tiled2", "200x100" ),
		createTestEntry("jacobi_2d_imper", "10 5 2 2 2", "tiled", "10x5"),
		createTestEntry("jacobi_2d_imper", "200 100 10 10 5", "tiled", "200x100"),
	};
	
	protected static final String[][] REDUCTIONBODY_TESTS = new String[][]{
		createTestEntryWithDefaultNames("matrix_product_withReduce", "100 200 300", "reduction"),
		createTestEntryWithDefaultNames("dot_product_withReduce", "10", "reduction"),
	};
	
	protected static final String[][] PARALLEL_TESTS = new String[][]{
		createTestEntryWithDefaultNames("matrix_product", "100 200 300", "parallelized"),
		createTestEntryWithDefaultNames("matrix_product", "4 8 2", "parallelized"),
		
		createTestEntryWithDefaultNames("jacobi_1d", "100 100", "parallelized"),
		
		createTestEntryWithDefaultNames("jacobi_2d", "10 5", "parallelized"),
		createTestEntryWithDefaultNames("jacobi_2d", "200 100", "parallelized"),
	};
	
	protected static final String[][] SUBSYSTEM_TESTS = new String[][]{
		createTestEntryWithDefaultNames("matrix_product_SubSyst", "100 200 300"),
		createTestEntryWithDefaultNames("matrix_product_SubSyst", "4 8 2"),
		
		createTestEntryWithDefaultNames("strip_matrix_product_SubSyst_v1", "4 2 2"),
		createTestEntryWithDefaultNames("strip_matrix_product_SubSyst_v1", "200 10 10"),
		
		createTestEntryWithDefaultNames("hierarchy_matrix_product_SubSyst", "4 2 8"),
		createTestEntryWithDefaultNames("hierarchy_matrix_product_SubSyst", "100 300 200"),
		
		createTestEntryWithDefaultNames("forward_substitution_SubSyst", "5"),
		createTestEntryWithDefaultNames("forward_substitution_SubSyst", "100"),
	};
	
	protected static final String[][] STENCIL_VEC_TESTS = new String[][] {
		createStencilTestEntry("jacobi_1d", "100 200 16 32", "tiledvec"),
		createStencilTestEntry("jacobi_1d", "300 400 64 48", "tiledvec2"),
		
		createStencilTestEntry("jacobi_2d", "100 100 100 16 16 16", "tiledvec"),
		createStencilTestEntry("jacobi_2d", "200 100 200 16 18 48", "tiledvec2"),
		
		createStencilTestEntry("wave_2d", "100 100 100 16 16 16", "tiledvec"),
		createStencilTestEntry("wave_2d", "200 100 300 16 18 48", "tiledvec2"),
	};
	
	protected static final String[][] STENCIL_FMPP_TESTS = new String[][] {
		createStencilTestEntry("jacobi_1d", "200 400 100 16 16", "tiledvec"),
	};
	
	@Test
	public void testWriteC() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, COMMON_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, WRITEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C_FLATTEN, COMMON_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C_FLATTEN, WRITEC_TESTS);
	}

	@Test
	public void testScheduledC() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C, COMMON_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN, COMMON_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C, REDUCTIONBODY_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN, REDUCTIONBODY_TESTS);
	}

	@Test
	public void testScheduledCParallelized() throws IOException, InterruptedException{
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_PARALLEL, PARALLEL_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_PARALLEL, PARALLEL_TESTS);
	}
	
	@Test
	public void testSequentialTiling() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_TILING_SEQ, TILING_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_TILING_SEQ_OPT, TILING_TESTS);
	}

	@Test
	public void testSequentialTilingFlattened() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ, TILING_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ_OPT, TILING_TESTS);
	}

	@Test
	public void testWavefrontTiling() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_TILING_OMPWF, TILING_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_TILING_OMPWF_OPT, TILING_TESTS);
	}
	
	@Test
	public void testWavefrontTilingFlattened() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF, TILING_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF_OPT, TILING_TESTS);
	}
	
	@Test
	public void testScheduledCWithSubSystem() throws IOException, InterruptedException{
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_SUBSYSTEM, SUBSYSTEM_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_SUBSYSTEM, SUBSYSTEM_TESTS);
	}
	
	@Test
	public void testTiledVec() throws IOException, InterruptedException{
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_NAIVE, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_NAIVE, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_OPTNOBUFF, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_OPTNOBUFF, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALLALIGNED, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALLALIGNED, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALMOST, STENCIL_VEC_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALMOST, STENCIL_VEC_TESTS);
	}
	
//	@Test
//	public void testFMPP() throws IOException, InterruptedException{
//		CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_MULTIPASS_TILING_SEQ, STENCIL_FMPP_TESTS);
//		//CodeGenTestingFramework.run(TEST_SETTING.SCHEDULED_C_MULTIPASS_TILING_OMPWF, STENCIL_VEC_TESTS);
//	}
}
