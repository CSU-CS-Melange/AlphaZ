package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.transformation.AlignVariables;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class AlignVariablesTest {

	@Test
	public void testCorrelation() {
		test(POLYBENCH.CORRELATION, VARIATION.FIXED_INLINED);
	}
	
	@Test
	public void testCovariance() {
		test(POLYBENCH.COVARIANCE, VARIATION.FIXED_INLINED);
	}
	

	@Test
	public void testSymm() {
		test(POLYBENCH.SYMM, VARIATION.FIXED_INLINED);
	}


	@Test
	public void testDynprog() {
		test(POLYBENCH.DYNPROG, VARIATION.FIXED_INLINED);
	}


	@Test
	public void testInlined() {
		for (String cat : PolyBench.getCategories()) {
			for (POLYBENCH bench : PolyBench.getBench(cat)) {
				test(bench, VARIATION.FIXED_INLINED);
			}
		}
	}

	
	private void test(POLYBENCH bench, VARIATION var) {
		System.out.println("Testing: " + bench.getName() + "(" + var.name() + ")");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		AlignVariables.apply(system);
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(VARIATION.FIXED_ALIGNED));
		
		alphaz.mde.Analysis.CheckProgram(prog);
//		PRDG prdg = PRDGBuilder.build(system);
//		List<ScheduledStatement> stmts = alphaz.mde.Analysis.PlutoScheduler(prdg);
//		System.out.println(stmts);
		
		UniformnessResult res = UniformnessCheck.apply(system);
		System.out.println(res);
	}
}
