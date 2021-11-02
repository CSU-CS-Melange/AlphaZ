package edu.csu.melange.alphaz.polybench.test;

import java.util.List;

import org.junit.Test;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.util.TilableBand;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class ISLPlutoScheduling {

	@Test
	public void testAlignedCorrelation() {
		computePlutoSchedule(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_HAND_ALIGNED_PLUTO_SCHEDULED);
	}

	@Test
	public void testFixedCorrelation() {
		computePlutoSchedule(POLYBENCH.CORRELATION, VARIATION.FIXED_INLINED, null);
	}
	
	@Test
	public void testAligned2mm() {
		computePlutoSchedule(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_HAND_ALIGNED_PLUTO_SCHEDULED);
	}
	
	@Test
	public void testInlinedDatamining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			computePlutoSchedule(bench, VARIATION.FIXED_INLINED, null);
		}
	}
	@Test
	public void testInlinedLAkernels() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_KERNELS)) {
			computePlutoSchedule(bench, VARIATION.FIXED_INLINED, null);
		}
	}
	@Test
	public void testInlinedLAsolvers() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.LA_SOLVERS)) {
			computePlutoSchedule(bench, VARIATION.FIXED_INLINED, null);
		}
	}
	
	@Test
	public void testInlinedMedley() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.MEDLEY)) {
			computePlutoSchedule(bench, VARIATION.FIXED_INLINED, null);
		}
	}
	
	@Test
	public void testInlinedStencls() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			computePlutoSchedule(bench, VARIATION.FIXED_INLINED, null);
		}
	}
	
	
	@Test
	public void testFixedStencils() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.STENCILS)) {
			computePlutoSchedule(bench, VARIATION.FIXED_NORMALIZED, null);
		}
	}

	@Test
	public void testADI() {
		computePlutoSchedule(POLYBENCH.ADI, VARIATION.FIXED_NORMALIZED, null);
	}
	
	@Test
	public void testJacobi1D() {
		computePlutoSchedule(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_NORMALIZED, null);
	}

	@Test
	public void testGemm() {
		computePlutoSchedule(POLYBENCH.GEMM, VARIATION.FIXED_NORMALIZED, null);
	}
	

	@Test
	public void testLudcmp() {
		computePlutoSchedule(POLYBENCH.LUDCMP, VARIATION.FIXED_INLINED, null);
	}
	
	@Test
	public void testMvt() {
		computePlutoSchedule(POLYBENCH.MVT, VARIATION.FIXED_INLINED, null);
	}


	private void computePlutoSchedule(POLYBENCH bench, VARIATION var, VARIATION outVar) {
		System.out.println("Scheduling: " + bench.getName() + "(" + var.name() + ")");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
//	    alphaz.mde.Basic.AShow(prog);
	    PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, bench.getName());
//	    System.out.println(prdg);
	    List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
	    System.out.println(schedules);
	    alphaz.mde.TargetMapping.setSchedule(prog, bench.getName(), schedules);
	    List<TilableBand> bands = org.polymodel.polyhedralIR.analysis.DetectTilableBands.detect(prog.getSystem(bench.getName()));
	    System.out.println(bands.get(0));
	    removeLastDimension(schedules);
	    applyAsCoB(prog, bench, schedules);
	    UniformnessResult res = UniformnessCheck.apply(prog.getSystems().get(0));
	    System.out.println(res);
//	    if (outVar != null)
//	    	alphaz.mde.Basic.ASave(prog, bench.getFilePath(outVar));
	}
	
	/**
	 * Removes last dimension, which is statement ordering.
	 * 
	 * @param schedules
	 */
	private void removeLastDimension(List<ScheduledStatement> schedules) {
		int dim = schedules.get(0).getSchedule().size()-1;
		
		boolean isConstant = true;
		for (ScheduledStatement schedule : schedules) {
			isConstant &= schedule.getSchedule().get(dim).isConstant() == FuzzyBoolean.YES;
		}
		
		if (!isConstant) return;
		
		for (ScheduledStatement schedule : schedules) {
			schedule.getSchedule().remove(dim);
		}
	}
	
	private void applyAsCoB(Program prog, POLYBENCH bench, List<ScheduledStatement> schedules) {
		alphaz.mde.TargetMapping.setSchedule(prog, bench.getName(), schedules);
		alphaz.mde.Transformation.ApplySTMap(prog, bench.getName());
		Normalize.normalize(prog);
	}
}
