package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Uniformize;
import org.polymodel.polyhedralIR.transformation.UniformizeWithPipelining;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class UniformizeTest {


	@Test
	public void testSelected() {
//		test(POLYBENCH.TWOMM, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.THREEMM, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.ATAX, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.TRMM, VARIATION.FIXED_INLINED);
	}

	@Test
	public void test2mm() {
		test(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void test3mm() {
		test(POLYBENCH.THREEMM, VARIATION.FIXED_HAND_ALIGNED);
	}
	
	@Test
	public void testAtax() {
		test(POLYBENCH.ATAX, VARIATION.FIXED_INLINED);
	}
	
	@Test
	public void testGemver() {
		test(POLYBENCH.GEMVER, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void testSymm() {
		test(POLYBENCH.SYMM, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void testTrisolv() {
		test(POLYBENCH.TRISOLV, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void testDynprog() {
		test(POLYBENCH.DYNPROG, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void testGramshmidt() {
		test(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_HAND_ALIGNED);
	}

	@Test
	public void testLU() {
		test(POLYBENCH.LU, VARIATION.FIXED_HAND_ALIGNED);
	}
	
	@Test
	public void testFloydWarshall() {
		test(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_HAND_ALIGNED);
	}
	

	private void test(POLYBENCH bench, VARIATION var) {
		Uniformize.DEBUG = true;
		UniformizeWithPipelining.DEBUG = true;
		System.out.print(bench.getName() + "(" + var.name() + "): ");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		Uniformize.apply(system);
		Normalize.normalize(system);
		alphaz.mde.Basic.AShow(prog);
		alphaz.mde.Analysis.CheckProgram(prog);
		UniformnessResult res = UniformnessCheck.apply(system);
		System.out.println(res.isUniform());
	}
}
