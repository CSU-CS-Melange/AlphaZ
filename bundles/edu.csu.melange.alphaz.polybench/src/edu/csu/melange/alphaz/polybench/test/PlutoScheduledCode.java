package edu.csu.melange.alphaz.polybench.test;

import java.util.List;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class PlutoScheduledCode {

	@Test
	public void testFixedStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			test(bench, VARIATION.FIXED_NORMALIZED);
		}
	}

	@Test
	public void testADI() {
		test(POLYBENCH.ADI, VARIATION.FIXED_NORMALIZED);
	}
	
	@Test
	public void testJacobi1D() {
		test(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_NORMALIZED);
	}

	@Test
	public void testGemm() {
		test(POLYBENCH.GEMM, VARIATION.FIXED_NORMALIZED);
	}


	private void test(POLYBENCH bench, VARIATION var) {
		computePlutoSchedule(bench.getFilePath(var), bench);
	}

	private void computePlutoSchedule(String file, POLYBENCH bench) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
	    System.out.println(prog);
	    PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, bench.getName());
	    List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
	    System.out.println(schedules);
	    scheduledC(prog, bench, schedules);
	}
	
	private void scheduledC(Program prog, POLYBENCH bench, List<ScheduledStatement> schedules) {
		final String outDir= "./test-out/PlutoScheduled/" + bench.getName() + "/";
		CodeGenOptions options = alphaz.mde.CodeGen.createCGOptionForScheduledC();
		options.DEBUG = true;
		alphaz.mde.CodeGen.generateScheduledCode(prog, bench.getName(), options, outDir);
	}
}
