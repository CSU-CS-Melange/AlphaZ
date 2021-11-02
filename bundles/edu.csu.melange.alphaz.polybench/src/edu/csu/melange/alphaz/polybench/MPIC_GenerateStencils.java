package edu.csu.melange.alphaz.polybench;
import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.DistributedCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPIC;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;


public class MPIC_GenerateStencils {

	@Test
	public void generateJacobi_1d_imper() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(POLYBENCH.JACOBI_1D_IMPER.getFilePath(VARIATION.MPIC_SPLIT));
		String systemName = POLYBENCH.JACOBI_1D_IMPER.getName();
		
		MPIC_SetMemory.allocateJacobi_1d_imper(prog);
		
//		prog.getSystem(systemName).getTargetMapping();
		alphaz.mde.TargetMapping.setTiling(prog, systemName, 0);
		
		MPIC.generate(prog.getSystem(systemName), DistributedCodeGenOptions.scheduledCDefault(), "./test-out/");
	}
	
	@Test
	public void generateSeidel() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(POLYBENCH.SEIDEL_2D.getFilePath(VARIATION.MPIC_SPLIT));
		String systemName = POLYBENCH.SEIDEL_2D.getName();
		
		MPIC_SetMemory.allocateSeidel_2d(prog);
		
		MPIC.generate(prog.getSystem(systemName), DistributedCodeGenOptions.scheduledCDefault(), "./test-out/");
	}
}
