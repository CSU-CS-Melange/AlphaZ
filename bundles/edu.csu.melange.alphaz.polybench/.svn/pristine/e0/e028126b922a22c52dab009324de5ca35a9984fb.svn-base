package edu.csu.melange.alphaz.polybench.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class IsUniformTest {

	protected static Map<VARIATION, Map<POLYBENCH, Boolean>> expected = new HashMap<VARIATION, Map<POLYBENCH, Boolean>>();
	
	static {
		//expected output for FIXED_INLINED
		{
			Map<POLYBENCH, Boolean> fixedInlined = new HashMap<POLYBENCH, Boolean>();
			fixedInlined.put(POLYBENCH.BICG, true);
			fixedInlined.put(POLYBENCH.GEMM, true);
			fixedInlined.put(POLYBENCH.MVT, true);
			fixedInlined.put(POLYBENCH.SYR2K, true);
			fixedInlined.put(POLYBENCH.SYRK, true);;
			fixedInlined.put(POLYBENCH.JACOBI_1D_IMPER, true);
			fixedInlined.put(POLYBENCH.JACOBI_2D_IMPER, true);
			fixedInlined.put(POLYBENCH.SEIDEL_2D, true);
			expected.put(VARIATION.FIXED_INLINED, fixedInlined);
		}
		
		//expected output for FIXED_HAND_ALIGNED
		{
			Map<POLYBENCH, Boolean> fixedHandAligned = new HashMap<POLYBENCH, Boolean>();
			fixedHandAligned.put(POLYBENCH.BICG, true);
			fixedHandAligned.put(POLYBENCH.DOITGEN, true);
			fixedHandAligned.put(POLYBENCH.GEMM, true);
			fixedHandAligned.put(POLYBENCH.GESUMMV, true);
			fixedHandAligned.put(POLYBENCH.MVT, true);
			fixedHandAligned.put(POLYBENCH.SYR2K, true);
			fixedHandAligned.put(POLYBENCH.SYRK, true);
			fixedHandAligned.put(POLYBENCH.REG_DETECT, true);
			fixedHandAligned.put(POLYBENCH.ADI, true);
			fixedHandAligned.put(POLYBENCH.FDTD_2D, true);
			fixedHandAligned.put(POLYBENCH.FDTD_APML, true);
			fixedHandAligned.put(POLYBENCH.JACOBI_1D_IMPER, true);
			fixedHandAligned.put(POLYBENCH.JACOBI_2D_IMPER, true);
			fixedHandAligned.put(POLYBENCH.SEIDEL_2D, true);
			expected.put(VARIATION.FIXED_HAND_ALIGNED, fixedHandAligned);
		}

	}
	

	@Test
	public void testInlined() {
		for (String cat : PolyBench.getCategories()) {
			for (POLYBENCH bench : PolyBench.getBench(cat)) {
				test(bench, VARIATION.FIXED_INLINED);
			}
		}
	}

	@Test
	public void testHandAligned() {
		for (String cat : PolyBench.getCategories()) {
			for (POLYBENCH bench : PolyBench.getBench(cat)) {
				test(bench, VARIATION.FIXED_HAND_ALIGNED);
			}
		}
	}


	@Test
	public void testSelected() {
		test(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED_PLUTO_SCHEDULED);
//		test(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED);
		
//		test(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.COVARIANCE, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.TRMM, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.DURBIN, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.LUDCMP, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.THREEMM, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.ATAX, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.TRMM, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.DURBIN, VARIATION.FIXED_INLINED);
//		test(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED);
//		test(POLYBENCH.GEMVER, VARIATION.FIXED_HAND_ALIGNED);
	}
	
	private void test(POLYBENCH bench, VARIATION var) {
		System.out.print(bench.getName() + "(" + var.name() + "): ");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		UniformnessResult uniformness = UniformnessCheck.apply(system);
		System.out.println(uniformness.isUniform());
		assert(uniformness.isUniform() == expected(bench, var)) : uniformness.toString();
		if (uniformness.isEmbedded() && !uniformness.isUniform()) {
			System.out.println(uniformness);
		}
	}
	

	@Test
	public void testPlutoScheduled() {
		testUniformnessAfterPlutoScheduling(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED);
		testUniformnessAfterPlutoScheduling(POLYBENCH.COVARIANCE, VARIATION.FIXED_HAND_ALIGNED);
		testUniformnessAfterPlutoScheduling(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED);
		testUniformnessAfterPlutoScheduling(POLYBENCH.TRMM, VARIATION.FIXED_HAND_ALIGNED);
		testUniformnessAfterPlutoScheduling(POLYBENCH.DURBIN, VARIATION.FIXED_HAND_ALIGNED);
		testUniformnessAfterPlutoScheduling(POLYBENCH.LUDCMP, VARIATION.FIXED_HAND_ALIGNED);
	}
	
	private void testUniformnessAfterPlutoScheduling(POLYBENCH bench, VARIATION var) {
		System.out.print(bench.getName() + "(" + var.name() + "): ");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		
		PRDG prdg = PRDGBuilder.build(system);
		
		List<ScheduledStatement> plutoSchedule = alphaz.mde.Analysis.PlutoScheduler(prdg);
		alphaz.mde.TargetMapping.setSchedule(prog, system.getName(), plutoSchedule);
		alphaz.mde.Transformation.ApplySTMap(prog, system.getName());
		
		UniformnessResult uniformness = UniformnessCheck.apply(system);
		System.out.println(uniformness.isUniform());
//		assert(uniformness.isUniform() == expected(bench, var)) : uniformness.toString();
		if (uniformness.isEmbedded() && !uniformness.isUniform()) {
			System.out.println(uniformness);
		}
	}
	
	private boolean expected(POLYBENCH bench, VARIATION var) {
		if (expected.containsKey(var) && expected.get(var).containsKey(bench)) {
			return expected.get(var).get(bench);
		}
		return false;
	}
}
