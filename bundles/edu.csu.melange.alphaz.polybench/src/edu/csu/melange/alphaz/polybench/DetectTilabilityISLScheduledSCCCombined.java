package edu.csu.melange.alphaz.polybench;

import java.util.List;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.DetectTilableBands;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.prdg.scheduling.util.TilableBand;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;

public class DetectTilabilityISLScheduledSCCCombined {

//	@Test TODO
//	public void detectCorrelation() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleCorrelation();
//	
//		detect(p, POLYBENCH.CORRELATION);
//	}
	

//	@Test TODO
//	public void detectCovariance() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleCovariance();
//	
//		detect(p, POLYBENCH.COVARIANCE);
//	}
	

	@Test
	public void detect2mm() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.schedule2mm();
	
		detect(p, POLYBENCH.TWOMM);
	}
	

	@Test
	public void detect3mm() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.schedule3mm();
	
		detect(p, POLYBENCH.THREEMM);
	}
	

	@Test
	public void detectAtax() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleAtax();
	
		detect(p, POLYBENCH.ATAX);
	}
	

	@Test
	public void detectBicg() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleBicg();
	
		detect(p, POLYBENCH.BICG);
	}
	

//	@Test TODO
//	public void detectCholesky() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleCholesky();
//	
//		detect(p, POLYBENCH.CHOLESKY);
//	}
	

	@Test
	public void detectDoitgen() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleDoitgen();
	
		detect(p, POLYBENCH.DOITGEN);
	}
	

	@Test
	public void detectGemm() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGemm();
	
		detect(p, POLYBENCH.GEMM);
	}
	

	@Test
	public void detectGemver() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGemver();
	
		detect(p, POLYBENCH.GEMVER);
	}
	

	@Test
	public void detectGesummv() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGesummv();
	
		detect(p, POLYBENCH.GESUMMV);
	}
	

	@Test
	public void detectMvt() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleMvt();
	
		detect(p, POLYBENCH.MVT);
	}
	

	@Test
	public void detectSymm() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSymm();
	
		detect(p, POLYBENCH.SYMM);
	}
	

	@Test
	public void detectSyr2k() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSyr2k();
	
		detect(p, POLYBENCH.SYR2K);
	}
	

	@Test
	public void detectSyrk() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSyrk();
	
		detect(p, POLYBENCH.SYRK);
	}
	

	@Test
	public void detectTrisolv() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleTrisolv();
	
		detect(p, POLYBENCH.TRISOLV);
	}
	

//	@Test TODO
//	public void detectTrmm() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleTrmm();
//	
//		detect(p, POLYBENCH.TRMM);
//	}
	

//	@Test TODO
//	public void detectDurbin() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleDurbin();
//	
//		detect(p, POLYBENCH.DURBIN);
//	}
	

	@Test
	public void detectDynprog() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleDynprog();
	
		detect(p, POLYBENCH.DYNPROG);
	}
	

	@Test
	public void detectGramschmidt() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGramschmidt();
	
		detect(p, POLYBENCH.GRAMSCHMIDT);
	}
	

	@Test
	public void detectLu() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleLu();
	
		detect(p, POLYBENCH.LU);
	}
	

//	@Test TODO
//	public void detectLudcmp() {
//		Program p = ISLPlutoScheduleSCCCombined.scheduleLudcmp();
//	
//		detect(p, POLYBENCH.LUDCMP);
//	}
	

	@Test
	public void detectFloyd_warshall() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFloyd_warshall();
	
		detect(p, POLYBENCH.FLOYD_WARSHALL);
	}
	

	@Test
	public void detectReg_detect() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleReg_detect();
	
		detect(p, POLYBENCH.REG_DETECT);
	}
	

	@Test
	public void detectAdi() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleAdi();
	
		detect(p, POLYBENCH.ADI);
	}
	

	@Test
	public void detectFdtd_2d() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFdtd_2d();
	
		detect(p, POLYBENCH.FDTD_2D);
	}
	

	@Test
	public void detectFdtd_apml() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFdtd_apml();
	
		detect(p, POLYBENCH.FDTD_APML);
	}
	

	@Test
	public void detectJacobi_1d_imper() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleJacobi_1d_imper();
	
		detect(p, POLYBENCH.JACOBI_1D_IMPER);
	}
	

	@Test
	public void detectJacobi_2d_imper() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleJacobi_2d_imper();
	
		detect(p, POLYBENCH.JACOBI_2D_IMPER);
	}
	

	@Test
	public void detectSeidel_2d() {
		Program p = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSeidel_2d();
	
		detect(p, POLYBENCH.SEIDEL_2D);
	}
	

	private void detect(Program prog, POLYBENCH bench) {
		AffineSystem system = prog.getSystem(bench.getName());
		checkProgram(prog);
		List<TilableBand> bands = DetectTilableBands.detect(system);
		DetectTilableBands.printTilableBands(bands);
	}

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}

