package edu.csu.melange.alphaz.polybench.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.transformation.InlineConstants;
import org.polymodel.polyhedralIR.transformation.Normalize;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class InlineConstantsTest {
	
	private static Map<POLYBENCH, String> expected;
	
	static {
		expected = new HashMap<POLYBENCH, String>();
		
		//data mining
		expected.put(POLYBENCH.CORRELATION, "[S1, S4, S7, S11, S12, S15]");
		expected.put(POLYBENCH.COVARIANCE, "[S0, S4]");
		
		//LA kernels
		expected.put(POLYBENCH.TWOMM, "[S0, S2]");
		expected.put(POLYBENCH.THREEMM, "[S0, S2, S4]");
		expected.put(POLYBENCH.ATAX, "[S0, S1]");
		expected.put(POLYBENCH.BICG, "[S0, S1]");
		expected.put(POLYBENCH.CHOLESKY, "[S0, S3]");
		expected.put(POLYBENCH.DOITGEN, "[S0]");
		expected.put(POLYBENCH.GEMM, "[S0]");
		expected.put(POLYBENCH.GEMVER, "[]");
		expected.put(POLYBENCH.GESUMMV, "[S0, S1]");
		expected.put(POLYBENCH.MVT, "[]");
		expected.put(POLYBENCH.SYMM, "[S0]");
		expected.put(POLYBENCH.SYR2K, "[S0]");
		expected.put(POLYBENCH.SYRK, "[S0]");
		expected.put(POLYBENCH.TRISOLV, "[S0]");
		expected.put(POLYBENCH.TRMM, "[]");
		
		//LA solvers
		expected.put(POLYBENCH.DURBIN, "[S0, S1, S2, S4, S8]");
		expected.put(POLYBENCH.DYNPROG, "[S0, S1, S2]");
		expected.put(POLYBENCH.GRAMSCHMIDT, "[S0, S4]");
		expected.put(POLYBENCH.LU, "[]");
		expected.put(POLYBENCH.LUDCMP, "[S0, S1, S4, S7, S8, S11]");
		
		//medley
		expected.put(POLYBENCH.FLOYD_WARSHALL, "[]");
		expected.put(POLYBENCH.REG_DETECT, "[]");
		
		//stencils
		expected.put(POLYBENCH.ADI, "[]");
		expected.put(POLYBENCH.FDTD_2D, "[]");
//		expected.put(POLYBENCH.FDTD_APML, "[S7, S13]");
		expected.put(POLYBENCH.FDTD_APML, "[S0, S4, S7, S15]");
		expected.put(POLYBENCH.JACOBI_1D_IMPER, "[]");
		expected.put(POLYBENCH.JACOBI_2D_IMPER, "[]");
		expected.put(POLYBENCH.SEIDEL_2D, "[]");
	}
	
	@Test
	public void test2mm() {
		test(POLYBENCH.TWOMM, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
	}

	@Test
	public void testDoitgen() {
		test(POLYBENCH.DOITGEN, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
	}
	@Test
	public void testCholesky() {
		test(POLYBENCH.CHOLESKY, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
	}
	
	@Test
	public void testDataMining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			test(bench, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
		}
	}
	
	@Test
	public void testLAkernels() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_KERNELS)) {
			test(bench, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
		}
	}

	@Test
	public void testLAsolvers() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_SOLVERS)) {
			test(bench, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
		}
	}

	@Test
	public void testMedley() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.MEDLEY)) {
			test(bench, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
		}
	}

	@Test
	public void testStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			test(bench, VARIATION.FIXED_NORMALIZED, VARIATION.FIXED_INLINED);
		}
	}

	
	private void test(POLYBENCH bench, VARIATION var, VARIATION outVar) {
//		InlineConstants.DEBUG = true;
		
		System.out.println("Testing: " + bench.getName());
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		{
			ValidatorOutput vout = UniquenessAndCompletenessCheck.validate(system);
			assert(vout.isValid()) : vout.toString(VERBOSITY.MAX);
		}
		
		List<String> inlinedEqs = InlineConstants.apply(system);
		assert(inlinedEqs.toString().contentEquals(expected.get(bench))) : inlinedEqs;
		
		Normalize.normalize(system);
		{
			ValidatorOutput vout = UniquenessAndCompletenessCheck.validate(system);
			assert(vout.isValid()) : vout.toString(VERBOSITY.MAX);
		}
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(outVar));
	}
}
