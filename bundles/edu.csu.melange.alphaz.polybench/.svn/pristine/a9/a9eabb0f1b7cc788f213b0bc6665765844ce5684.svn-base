package edu.csu.melange.alphaz.polybench;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.ScheduleIndependentMemoryAllocation;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.transformation.UniformizeInContext;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class MPIC_UOVAllocation {

	@Test
	public void findUOVallocationCorrelation() {
		findUOVallocation(POLYBENCH.CORRELATION, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationCovariance() {
		findUOVallocation(POLYBENCH.COVARIANCE, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocation2mm() {
		findUOVallocation(POLYBENCH.TWOMM, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocation3mm() {
		findUOVallocation(POLYBENCH.THREEMM, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationAtax() {
		findUOVallocation(POLYBENCH.ATAX, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationBicg() {
		findUOVallocation(POLYBENCH.BICG, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationCholesky() {
		findUOVallocation(POLYBENCH.CHOLESKY, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationDoitgen() {
		findUOVallocation(POLYBENCH.DOITGEN, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationGemm() {
		findUOVallocation(POLYBENCH.GEMM, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationGemver() {
		findUOVallocation(POLYBENCH.GEMVER, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationGesummv() {
		findUOVallocation(POLYBENCH.GESUMMV, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationMvt() {
		findUOVallocation(POLYBENCH.MVT, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationSymm() {
		findUOVallocation(POLYBENCH.SYMM, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationSyr2k() {
		findUOVallocation(POLYBENCH.SYR2K, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationSyrk() {
		findUOVallocation(POLYBENCH.SYRK, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationTrisolv() {
		findUOVallocation(POLYBENCH.TRISOLV, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationTrmm() {
		findUOVallocation(POLYBENCH.TRMM, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationDurbin() {
		findUOVallocation(POLYBENCH.DURBIN, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationDynprog() {
		findUOVallocation(POLYBENCH.DYNPROG, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationGramschmidt() {
		findUOVallocation(POLYBENCH.GRAMSCHMIDT, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationLu() {
		findUOVallocation(POLYBENCH.LU, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationLudcmp() {
		findUOVallocation(POLYBENCH.LUDCMP, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationFloyd_warshall() {
		findUOVallocation(POLYBENCH.FLOYD_WARSHALL, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationReg_detect() {
		findUOVallocation(POLYBENCH.REG_DETECT, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationAdi() {
		findUOVallocation(POLYBENCH.ADI, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationFdtd_2d() {
		findUOVallocation(POLYBENCH.FDTD_2D, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationFdtd_apml() {
		findUOVallocation(POLYBENCH.FDTD_APML, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationJacobi_1d_imper() {
//		AccessCollector.DEBUG = true;
		findUOVallocation(POLYBENCH.JACOBI_1D_IMPER, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationJacobi_2d_imper() {
		findUOVallocation(POLYBENCH.JACOBI_2D_IMPER, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationSeidel_2d() {
		findUOVallocation(POLYBENCH.SEIDEL_2D, VARIATION.MPIC_SPLIT);
	}
	

	@Test
	public void findUOVallocationDatamining() {
		findUOVallocationCorrelation();
		findUOVallocationCovariance();
	}

	@Test
	public void findUOVallocationLAkernel() {
		findUOVallocation2mm();
		findUOVallocation3mm();
		findUOVallocationAtax();
		findUOVallocationBicg();
		findUOVallocationCholesky();
		findUOVallocationDoitgen();
		findUOVallocationGemm();
		findUOVallocationGemver();
		findUOVallocationGesummv();
		findUOVallocationMvt();
		findUOVallocationSymm();
		findUOVallocationSyr2k();
		findUOVallocationSyrk();
		findUOVallocationTrisolv();
		findUOVallocationTrmm();
	}

	@Test
	public void findUOVallocationLAsolver() {
		findUOVallocationDurbin();
		findUOVallocationDynprog();
		findUOVallocationGramschmidt();
		findUOVallocationLu();
		findUOVallocationLudcmp();
	}

	@Test
	public void findUOVallocationMedley() {
		findUOVallocationFloyd_warshall();
		findUOVallocationReg_detect();
	}

	@Test
	public void findUOVallocationStencils() {
		findUOVallocationAdi();
		findUOVallocationFdtd_2d();
		findUOVallocationFdtd_apml();
		findUOVallocationJacobi_1d_imper();
		findUOVallocationJacobi_2d_imper();
		findUOVallocationSeidel_2d();
	}
	
	private void findUOVallocation(POLYBENCH bench, VARIATION var) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(bench.getFilePath(var));
		AffineSystem system = prog.getSystem(bench.getName());
		UniformizeInContext.apply(system);
//		ScheduleIndependentMemoryAllocation.DEBUG = true;
		System.out.println(bench.getName()+":");
		ScheduleIndependentMemoryAllocation scima = ScheduleIndependentMemoryAllocation.allocate(system, true);
		System.out.println(scima);
	}
	

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}

