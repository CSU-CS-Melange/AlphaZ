package edu.csu.melange.alphaz.polybench;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.adapter.PRDGAdapterComponent;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;
import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.analysis.GraphAnalysis;

public class MemorySpaceAnalysis {

	@Test
	public void analyzeCorrelation() {
		analyze(POLYBENCH.CORRELATION, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeCovariance() {
		analyze(POLYBENCH.COVARIANCE, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyze2mm() {
		analyze(POLYBENCH.TWOMM, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyze3mm() {
		analyze(POLYBENCH.THREEMM, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeAtax() {
		analyze(POLYBENCH.ATAX, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeBicg() {
		analyze(POLYBENCH.BICG, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeCholesky() {
		analyze(POLYBENCH.CHOLESKY, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeDoitgen() {
		analyze(POLYBENCH.DOITGEN, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeGemm() {
		analyze(POLYBENCH.GEMM, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeGemver() {
		analyze(POLYBENCH.GEMVER, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeGesummv() {
		analyze(POLYBENCH.GESUMMV, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeMvt() {
		analyze(POLYBENCH.MVT, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeSymm() {
		analyze(POLYBENCH.SYMM, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeSyr2k() {
		analyze(POLYBENCH.SYR2K, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeSyrk() {
		analyze(POLYBENCH.SYRK, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeTrisolv() {
		analyze(POLYBENCH.TRISOLV, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeTrmm() {
		analyze(POLYBENCH.TRMM, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeDurbin() {
		analyze(POLYBENCH.DURBIN, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeDynprog() {
		analyze(POLYBENCH.DYNPROG, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeGramschmidt() {
		analyze(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeLu() {
		analyze(POLYBENCH.LU, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeLudcmp() {
		analyze(POLYBENCH.LUDCMP, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeFloyd_warshall() {
		analyze(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeReg_detect() {
		analyze(POLYBENCH.REG_DETECT, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeAdi() {
		analyze(POLYBENCH.ADI, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeFdtd_2d() {
		analyze(POLYBENCH.FDTD_2D, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeFdtd_apml() {
		analyze(POLYBENCH.FDTD_APML, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeJacobi_1d_imper() {
		analyze(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeJacobi_2d_imper() {
		analyze(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_UNIFORMIZED);
	}
	

	@Test
	public void analyzeSeidel_2d() {
		analyze(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_UNIFORMIZED);
	}
	
	
	private void analyze(POLYBENCH bench, VARIATION var) {
		System.out.println(bench.getName()+"("+var.name()+"):");

		Program prog = alphaz.mde.Basic.ReadAlphabets(bench.getFilePath(var));
		AffineSystem sytem = prog.getSystem(bench.getName());
		PRDG prdg = PRDGBuilder.build(sytem);
		
//		System.out.println(prdg);
		
		IPRDGAdapter adapter = PRDGAdapterComponent.INSTANCE.build(prdg);
		List<Set<INode>> scc = GraphAnalysis.findStronglyConnectedSets(adapter);
		System.out.println(scc);
	}

	private void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}

