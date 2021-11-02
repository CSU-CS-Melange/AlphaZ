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

public class DetectTilability {
	
	//correlation
	//covariance
	//cholesky
	//trmm
	//durbin
	//ludcmp

	@Test
	public void detectCorrelation() {
		detect(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED, null);
	}
	

	@Test
	public void detectCovariance() {
		detect(POLYBENCH.COVARIANCE, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detect2mm() {
		detect(POLYBENCH.TWOMM, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detect3mm() {
		detect(POLYBENCH.THREEMM, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectAtax() {
		detect(POLYBENCH.ATAX, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectBicg() {
		detect(POLYBENCH.BICG, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectCholesky() {
		detect(POLYBENCH.CHOLESKY, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectDoitgen() {
		detect(POLYBENCH.DOITGEN, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectGemm() {
		detect(POLYBENCH.GEMM, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectGemver() {
		detect(POLYBENCH.GEMVER, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectGesummv() {
		detect(POLYBENCH.GESUMMV, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectMvt() {
		detect(POLYBENCH.MVT, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectSymm() {
		detect(POLYBENCH.SYMM, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectSyr2k() {
		detect(POLYBENCH.SYR2K, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectSyrk() {
		detect(POLYBENCH.SYRK, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectTrisolv() {
		detect(POLYBENCH.TRISOLV, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectTrmm() {
		detect(POLYBENCH.TRMM, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectDurbin() {
		detect(POLYBENCH.DURBIN, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectDynprog() {
		detect(POLYBENCH.DYNPROG, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectGramschmidt() {
		detect(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectLu() {
		detect(POLYBENCH.LU, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectLudcmp() {
		detect(POLYBENCH.LUDCMP, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectFloyd_warshall() {
		detect(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectReg_detect() {
		detect(POLYBENCH.REG_DETECT, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectStencils() {
		detectAdi();
		detectFdtd_apml();
		detectFdtd_2d();
		detectJacobi_1d_imper();
		detectJacobi_2d_imper();
		detectSeidel_2d();
	}
	

	@Test
	public void detectAdi() {
		detect(POLYBENCH.ADI, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectFdtd_2d() {
		detect(POLYBENCH.FDTD_2D, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectFdtd_apml() {
		detect(POLYBENCH.FDTD_APML, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectJacobi_1d_imper() {
		detect(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectJacobi_2d_imper() {
		detect(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_UNIFORMIZED, null);
	}
	

	@Test
	public void detectSeidel_2d() {
		detect(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_UNIFORMIZED, null);
	}
	


	private void detect(POLYBENCH bench, VARIATION var, VARIATION outVar) {
		System.out.println(bench.getName() + "(" + var.name() + "):");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		checkProgram(prog);
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, system.getName());
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
		alphaz.mde.TargetMapping.setSchedule(prog, system.getName(), schedules);
		List<TilableBand> bands = DetectTilableBands.detect(system);
		DetectTilableBands.printTilableBands(bands);
	}
	
	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}

