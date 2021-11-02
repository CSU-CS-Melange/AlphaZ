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

public class UniformizeFixedHandAligned {

	@Test
	public void uniformizeFixedHandAlignedCorrelation() {
		uniformize(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedCovariance() {
		uniformize(POLYBENCH.COVARIANCE, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAligned2mm() {
		uniformize(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAligned3mm() {
		uniformize(POLYBENCH.THREEMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedAtax() {
		uniformize(POLYBENCH.ATAX, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedBicg() {
		uniformize(POLYBENCH.BICG, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedCholesky() {
		uniformize(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedDoitgen() {
		uniformize(POLYBENCH.DOITGEN, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedGemm() {
		uniformize(POLYBENCH.GEMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedGemver() {
		uniformize(POLYBENCH.GEMVER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedGesummv() {
		uniformize(POLYBENCH.GESUMMV, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedMvt() {
		uniformize(POLYBENCH.MVT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedSymm() {
		uniformize(POLYBENCH.SYMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedSyr2k() {
		uniformize(POLYBENCH.SYR2K, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedSyrk() {
		uniformize(POLYBENCH.SYRK, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedTrisolv() {
		uniformize(POLYBENCH.TRISOLV, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedTrmm() {
		uniformize(POLYBENCH.TRMM, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedDurbin() {
		uniformize(POLYBENCH.DURBIN, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedDynprog() {
		uniformize(POLYBENCH.DYNPROG, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedGramschmidt() {
		uniformize(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedLu() {
		uniformize(POLYBENCH.LU, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedLudcmp() {
		uniformize(POLYBENCH.LUDCMP, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedFloyd_warshall() {
		uniformize(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedReg_detect() {
		uniformize(POLYBENCH.REG_DETECT, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	
	@Test
	public void uniformizeStencils() {
		uniformizeFixedHandAlignedAdi();
		uniformizeFixedHandAlignedFdtd_apml();
		uniformizeFixedHandAlignedFdtd_2d();
		uniformizeFixedHandAlignedJacobi_1d_imper();
		uniformizeFixedHandAlignedJacobi_2d_imper();
		uniformizeFixedHandAlignedSeidel_2d();
	}

	@Test
	public void uniformizeFixedHandAlignedAdi() {
		uniformize(POLYBENCH.ADI, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedFdtd_2d() {
		uniformize(POLYBENCH.FDTD_2D, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedFdtd_apml() {
		uniformize(POLYBENCH.FDTD_APML, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedJacobi_1d_imper() {
		uniformize(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedJacobi_2d_imper() {
		uniformize(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void uniformizeFixedHandAlignedSeidel_2d() {
		uniformize(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_HAND_ALIGNED, VARIATION.FIXED_UNIFORMIZED);
	}

	private void uniformize(POLYBENCH bench, VARIATION var, VARIATION outVar) {
//		Uniformize.DEBUG = true;
		UniformizeWithPipelining.DEBUG = true;
		System.out.println(bench.getName() + "(" + var.name() + "): ");
		String file = bench.getFilePath(var);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		checkProgram(prog);
		Uniformize.apply(system);
		Normalize.normalize(system);
		checkProgram(prog);
//		UniformnessResult res = UniformnessCheck.apply(system);
//		System.out.println(res.isUniform());
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(outVar));
		
	}
	
	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}

}

