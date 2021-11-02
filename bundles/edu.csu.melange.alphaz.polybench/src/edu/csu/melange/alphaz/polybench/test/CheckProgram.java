package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class CheckProgram {
	
	@Test
	public void testRawDataMining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			test(bench, VARIATION.RAW);
		}
	}
	@Test
	public void testRawLAkernels() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_KERNELS)) {
			test(bench, VARIATION.RAW);
		}
	}
	@Test
	public void testRawLAsolvers() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_SOLVERS)) {
			test(bench, VARIATION.RAW);
		}
	}
	@Test
	public void testRawMedley() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.MEDLEY)) {
			test(bench, VARIATION.RAW);
		}
	}
	@Test
	public void testRawStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			test(bench, VARIATION.RAW);
		}
	}
	@Test
	public void test2d() {
		test(POLYBENCH.SEIDEL_2D, VARIATION.RAW);
	}

	@Test
	public void testCholesky() {
		test(POLYBENCH.CHOLESKY, VARIATION.FIXED);
		test(POLYBENCH.CHOLESKY, VARIATION.FIXED_NORMALIZED);
	}

	@Test
	public void testAll() {
		for (String cat : PolyBench.getCategories()) {
			for (POLYBENCH bench : PolyBench.getBench(cat)) {
				test(bench, VARIATION.RAW);
				test(bench, VARIATION.RAW_NORMALIZED);
				test(bench, VARIATION.FIXED);
				test(bench, VARIATION.FIXED_NORMALIZED);
			}
		}
	}
	
	
	private void test(POLYBENCH bench, VARIATION var) {
		System.out.println("Testing: " + bench.getName() + " (" + var.name() + ")");
		checkProgram(bench.getFilePath(var), bench);
	}

	private void checkProgram(String file, POLYBENCH bench) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
	    ValidatorOutput output = UniquenessAndCompletenessCheck.validate(prog);
	    assert(output.isValid()) : output.toString(VERBOSITY.MAX);
	}
}
