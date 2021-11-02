package edu.csu.melange.alphaz.polybench;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.UOVGuidedSplit;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class MPIC_UOVGuidedSplit {

	@Test
	public void splitCorrelation() {
		split(POLYBENCH.CORRELATION, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitCovariance() {
		split(POLYBENCH.COVARIANCE, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void split2mm() {
		split(POLYBENCH.TWOMM, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void split3mm() {
		split(POLYBENCH.THREEMM, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitAtax() {
		split(POLYBENCH.ATAX, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitBicg() {
		split(POLYBENCH.BICG, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitCholesky() {
		split(POLYBENCH.CHOLESKY, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitDoitgen() {
		split(POLYBENCH.DOITGEN, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitGemm() {
		split(POLYBENCH.GEMM, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitGemver() {
		split(POLYBENCH.GEMVER, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitGesummv() {
		split(POLYBENCH.GESUMMV, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitMvt() {
		split(POLYBENCH.MVT, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitSymm() {
		split(POLYBENCH.SYMM, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitSyr2k() {
		split(POLYBENCH.SYR2K, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitSyrk() {
		split(POLYBENCH.SYRK, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitTrisolv() {
		split(POLYBENCH.TRISOLV, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitTrmm() {
		split(POLYBENCH.TRMM, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitDurbin() {
		split(POLYBENCH.DURBIN, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitDynprog() {
		split(POLYBENCH.DYNPROG, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitGramschmidt() {
		split(POLYBENCH.GRAMSCHMIDT, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitLu() {
		split(POLYBENCH.LU, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitLudcmp() {
		split(POLYBENCH.LUDCMP, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitFloyd_warshall() {
		split(POLYBENCH.FLOYD_WARSHALL, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitReg_detect() {
		split(POLYBENCH.REG_DETECT, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitAdi() {
		split(POLYBENCH.ADI, VARIATION.MPIC_UNIFORMIZED, VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitFdtd_2d() {
		split(POLYBENCH.FDTD_2D, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitFdtd_apml() {
		split(POLYBENCH.FDTD_APML, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitJacobi_1d_imper() {
		split(POLYBENCH.JACOBI_1D_IMPER, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitJacobi_2d_imper() {
		split(POLYBENCH.JACOBI_2D_IMPER, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	@Test
	public void splitSeidel_2d() {
		split(POLYBENCH.SEIDEL_2D, VARIATION.MPIC_UNIFORMIZED,
				VARIATION.MPIC_SPLIT);
	}

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert (out.isValid()) : out.toString(VERBOSITY.MAX);
	}
	
	private void split(POLYBENCH bench, VARIATION var, VARIATION outVar) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(bench.getFilePath(var));
		
		UOVGuidedSplit.apply(prog.getSystem(bench.getName()));
		Normalize.normalize(prog);
		
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(outVar));
	}

	@Test
	public void splitDatamining() {
		splitCorrelation();
		splitCovariance();
	}

	@Test
	public void splitLAkernel() {
		split2mm();
		split3mm();
		splitAtax();
		splitBicg();
		splitCholesky();
		splitDoitgen();
		splitGemm();
		splitGemver();
		splitGesummv();
		splitMvt();
		splitSymm();
		splitSyr2k();
		splitSyrk();
		splitTrisolv();
		splitTrmm();
	}

	@Test
	public void splitLAsolver() {
		splitDurbin();
		splitDynprog();
		splitGramschmidt();
		splitLu();
		splitLudcmp();
	}

	@Test
	public void splitMedley() {
		splitFloyd_warshall();
		splitReg_detect();
	}

	@Test
	public void splitStencils() {
		splitAdi();
		splitFdtd_2d();
		splitFdtd_apml();
		splitJacobi_1d_imper();
		splitJacobi_2d_imper();
		splitSeidel_2d();
	}

}
