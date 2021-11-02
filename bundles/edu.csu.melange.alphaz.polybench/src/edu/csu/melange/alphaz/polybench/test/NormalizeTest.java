package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.transformation.Normalize;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class NormalizeTest {

	@Test
	public void testRawDataMining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			normalize(bench, VARIATION.RAW, VARIATION.RAW_NORMALIZED);
		}
	}
	@Test
	public void testRawLAkernels() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_KERNELS)) {
			normalize(bench, VARIATION.RAW, VARIATION.RAW_NORMALIZED);
		}
	}
	@Test
	public void testRawLAsolvers() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_SOLVERS)) {
			normalize(bench, VARIATION.RAW, VARIATION.RAW_NORMALIZED);
		}
	}
	@Test
	public void testRawMedley() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.MEDLEY)) {
			normalize(bench, VARIATION.RAW, VARIATION.RAW_NORMALIZED);
		}
	}
	@Test
	public void testRawStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			normalize(bench, VARIATION.RAW, VARIATION.RAW_NORMALIZED);
		}
	}
	
	@Test
	public void testFixedDataMining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			normalize(bench, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
		}
	}
	@Test
	public void testFixedLAkernels() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_KERNELS)) {
			normalize(bench, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
		}
	}
	@Test
	public void testFixedLAsolvers() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_SOLVERS)) {
			normalize(bench, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
		}
	}
	@Test
	public void testFixedMedley() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.MEDLEY)) {
			normalize(bench, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
		}
	}
	@Test
	public void testFixedStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			normalize(bench, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
		}
	}

	@Test
	public void testFixedFDTD() {
		normalize(POLYBENCH.FDTD_2D, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
	}

	@Test
	public void testFixedGemm() {
		normalize(POLYBENCH.GEMM, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
	}

	@Test
	public void testFixedCholesky() {
		normalize(POLYBENCH.CHOLESKY, VARIATION.FIXED, VARIATION.FIXED_NORMALIZED);
	}

	private void normalize(POLYBENCH bench, VARIATION var, VARIATION outVar) {
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
	    Normalize.normalize(prog);
	    ValidatorOutput output = UniquenessAndCompletenessCheck.validate(prog);
	    assert(output.isValid());
	    System.out.println(prog);
	    alphaz.mde.Basic.PrintAST(prog, bench.getName());
	    String savePath = bench.getFilePath(outVar);
	    alphaz.mde.Basic.ASave(prog,  savePath);
	}
//    String savePath = getBenchPath("./alphabets/fixed-normalized/", bench);
//    alphaz.mde.Basic.ASave(prog,  savePath);
}
