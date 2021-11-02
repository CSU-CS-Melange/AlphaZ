package edu.csu.melange.alphaz.polybench;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Uniformize;
import org.polymodel.polyhedralIR.transformation.UniformizeWithPipelining;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class MPIC_Uniformize {
	
	@Test
	public void uniformizeCorrelation() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleCorrelation();
		uniformize(POLYBENCH.CORRELATION, prog);
	}
	

	@Test
	public void uniformizeCovariance() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleCovariance();
		uniformize(POLYBENCH.COVARIANCE, prog);
	}
	

	@Test
	public void uniformize2mm() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.schedule2mm();
		uniformize(POLYBENCH.TWOMM, prog);
	}
	

	@Test
	public void uniformize3mm() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.schedule3mm();
		uniformize(POLYBENCH.THREEMM, prog);
	}
	

	@Test
	public void uniformizeAtax() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleAtax();
		uniformize(POLYBENCH.ATAX, prog);
	}
	

	@Test
	public void uniformizeBicg() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleBicg();
		uniformize(POLYBENCH.BICG, prog);
	}
	

	@Test
	public void uniformizeCholesky() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleCholesky();
		uniformize(POLYBENCH.CHOLESKY, prog);
	}
	

	@Test
	public void uniformizeDoitgen() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleDoitgen();
		uniformize(POLYBENCH.DOITGEN, prog);
	}
	

	@Test
	public void uniformizeGemm() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGemm();
		uniformize(POLYBENCH.GEMM, prog);
	}
	

	@Test
	public void uniformizeGemver() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGemver();
		uniformize(POLYBENCH.GEMVER, prog);
	}
	

	@Test
	public void uniformizeGesummv() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGesummv();
		uniformize(POLYBENCH.GESUMMV, prog);
	}
	

	@Test
	public void uniformizeMvt() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleMvt();
		uniformize(POLYBENCH.MVT, prog);
	}
	

	@Test
	public void uniformizeSymm() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSymm();
		uniformize(POLYBENCH.SYMM, prog);
	}
	

	@Test
	public void uniformizeSyr2k() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSyr2k();
		uniformize(POLYBENCH.SYR2K, prog);
	}
	

	@Test
	public void uniformizeSyrk() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSyrk();
		uniformize(POLYBENCH.SYRK, prog);
	}
	

	@Test
	public void uniformizeTrisolv() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleTrisolv();
		uniformize(POLYBENCH.TRISOLV, prog);
	}
	

	@Test
	public void uniformizeTrmm() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleTrmm();
		uniformize(POLYBENCH.TRMM, prog);
	}
	

	@Test
	public void uniformizeDurbin() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleDurbin();
		uniformize(POLYBENCH.DURBIN, prog);
	}
	

	@Test
	public void uniformizeDynprog() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleDynprog();
		uniformize(POLYBENCH.DYNPROG, prog);
	}
	

	@Test
	public void uniformizeGramschmidt() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleGramschmidt();
		uniformize(POLYBENCH.GRAMSCHMIDT, prog);
	}
	

	@Test
	public void uniformizeLu() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleLu();
		uniformize(POLYBENCH.LU, prog);
	}
	

	@Test
	public void uniformizeLudcmp() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleLudcmp();
		uniformize(POLYBENCH.LUDCMP, prog);
	}
	

	@Test
	public void uniformizeFloyd_warshall() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFloyd_warshall();
		uniformize(POLYBENCH.FLOYD_WARSHALL, prog);
	}
	

	@Test
	public void uniformizeReg_detect() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleReg_detect();
		uniformize(POLYBENCH.REG_DETECT, prog);
	}
	

	@Test
	public void uniformizeAdi() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleAdi();
		uniformize(POLYBENCH.ADI, prog);
	}
	

	@Test
	public void uniformizeFdtd_2d() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFdtd_2d();
		uniformize(POLYBENCH.FDTD_2D, prog);
	}
	

	@Test
	public void uniformizeFdtd_apml() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleFdtd_apml();
		uniformize(POLYBENCH.FDTD_APML, prog);
	}
	

	@Test
	public void uniformizeJacobi_1d_imper() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleJacobi_1d_imper();
		uniformize(POLYBENCH.JACOBI_1D_IMPER, prog);
	}
	

	@Test
	public void uniformizeJacobi_2d_imper() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleJacobi_2d_imper();
		uniformize(POLYBENCH.JACOBI_2D_IMPER, prog);
	}
	

	@Test
	public void uniformizeSeidel_2d() {
		Program prog = ISLPlutoScheduleSCCCombinedHandAligned.scheduleSeidel_2d();
		uniformize(POLYBENCH.SEIDEL_2D, prog);
	}
	
	@Test
	public void uniformizeStencils() {
		uniformizeAdi();
		uniformizeFdtd_2d();
		uniformizeFdtd_apml();
		uniformizeJacobi_1d_imper();
		uniformizeJacobi_2d_imper();
		uniformizeSeidel_2d();
	}

	private void uniformize(POLYBENCH bench, Program prog) {
		AffineSystem system = prog.getSystem(bench.getName());
		alphaz.mde.Transformation.ApplySTMap(prog, bench.getName());
		Normalize.normalize(prog);
		checkProgram(prog);

		Uniformize.DEBUG = true;
		UniformizeWithPipelining.DEBUG = true;
		System.out.println(bench.getName()+": ");
		Uniformize.apply(system);
		Normalize.normalize(system);
		checkProgram(prog);
//		UniformnessResult res = UniformnessCheck.apply(system);
//		System.out.println(res.isUniform());
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(VARIATION.MPIC_UNIFORMIZED));
		
	}

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}

}
