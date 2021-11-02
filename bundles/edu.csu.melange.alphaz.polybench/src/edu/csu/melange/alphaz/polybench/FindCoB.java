package edu.csu.melange.alphaz.polybench;

import java.util.List;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.DetectTilableBands;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.util.TilableBand;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class FindCoB {

	@Test
	public void scheduleCorrelation() {
		schedule(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleCovariance() {
		schedule(POLYBENCH.COVARIANCE, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void schedule2mm() {
		schedule(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void schedule3mm() {
		schedule(POLYBENCH.THREEMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleAtax() {
		schedule(POLYBENCH.ATAX, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleBicg() {
		schedule(POLYBENCH.BICG, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleCholesky() {
		schedule(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleDoitgen() {
		schedule(POLYBENCH.DOITGEN, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleGemm() {
		schedule(POLYBENCH.GEMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleGemver() {
		schedule(POLYBENCH.GEMVER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleGesummv() {
		schedule(POLYBENCH.GESUMMV, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleMvt() {
		schedule(POLYBENCH.MVT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleSymm() {
		schedule(POLYBENCH.SYMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleSyr2k() {
		schedule(POLYBENCH.SYR2K, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleSyrk() {
		schedule(POLYBENCH.SYRK, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleTrisolv() {
		schedule(POLYBENCH.TRISOLV, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleTrmm() {
		schedule(POLYBENCH.TRMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleDurbin() {
		schedule(POLYBENCH.DURBIN, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleDynprog() {
		schedule(POLYBENCH.DYNPROG, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleGramschmidt() {
		schedule(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleLu() {
		schedule(POLYBENCH.LU, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleLudcmp() {
		schedule(POLYBENCH.LUDCMP, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleFloyd_warshall() {
		schedule(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleReg_detect() {
		schedule(POLYBENCH.REG_DETECT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleAdi() {
		schedule(POLYBENCH.ADI, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleFdtd_2d() {
		schedule(POLYBENCH.FDTD_2D, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleFdtd_apml() {
		schedule(POLYBENCH.FDTD_APML, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleJacobi_1d_imper() {
		schedule(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleJacobi_2d_imper() {
		schedule(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}
	

	@Test
	public void scheduleSeidel_2d() {
		schedule(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_HAND_ALIGNED, VARIATION.MPIC_UNIFORMIZED);
	}

	@Test	
	public void scheduleStencils() {
		scheduleAdi();
		scheduleFdtd_2d();
		scheduleFdtd_apml();
		scheduleJacobi_1d_imper();
		scheduleJacobi_2d_imper();
		scheduleSeidel_2d();
	}
	
	private void schedule(POLYBENCH bench, VARIATION var, VARIATION varOut) {
		System.out.println(bench.getName() + "(" + var.name() +"):");
		Program prog = alphaz.mde.Basic.ReadAlphabets(bench.getFilePath(var));
		AffineSystem system = prog.getSystem(bench.getName());
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, bench.getName());
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
//		alphaz.mde.Analysis.printScheduledStatements(schedules);

		alphaz.mde.TargetMapping.setSchedule(prog, bench.getName(), schedules);
		
		List<TilableBand> bands = DetectTilableBands.detect(system);
		DetectTilableBands.printTilableBands(bands);
	}
	

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}

