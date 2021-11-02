package edu.csu.melange.alphaz.polybench;

import java.util.List;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.DetectTilableBands;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.util.TilableBand;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class TilableBandsAnalysis {

	@Test
	public void analyzeInlined() {
		for (POLYBENCH bench : POLYBENCH.values()) {
			analyze(bench, VARIATION.FIXED_INLINED);
		}
	}
	
	@Test
	public void analyzeInlinedStencil() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			analyze(bench, VARIATION.FIXED_INLINED);
		}
	}
	

	@Test
	public void analyzeHandAligned() {
		for (POLYBENCH bench : POLYBENCH.values()) {
			analyze(bench, VARIATION.FIXED_HAND_ALIGNED);
		}
	}
	
	@Test
	public void analyzeHandAlignedStencil() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			analyze(bench, VARIATION.FIXED_HAND_ALIGNED);
		}
	}

	@Test
	public void analayzeFixedCorrelation() {
		analyze(POLYBENCH.CORRELATION, VARIATION.FIXED_NORMALIZED);
		analyze(POLYBENCH.CORRELATION, VARIATION.FIXED_INLINED);
	}
	

	@Test
	public void analayzeFixedJacobi1D() {
		analyze(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_NORMALIZED);
		analyze(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_INLINED);
	}

	private void analyze(POLYBENCH bench, VARIATION var) {
//		org.polymodel.prdg.scheduling.util.DetectTilableBands.DEBUG = true;
		
		System.out.println(bench.getName()+":");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
	    PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, bench.getName());
	    List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
	    alphaz.mde.TargetMapping.setSchedule(prog, bench.getName(), schedules);
	    printTilableBands(DetectTilableBands.detect(prog.getSystem(bench.getName())));
	}
	
	private void printTilableBands(List<TilableBand> bands) {
		for (TilableBand band : bands) {
			System.out.println(band);
		}
	}
}
