package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class CreateCGOptionForHybridScheduledCGPU  {
	private CodeGenOptions result;
    
	/**
	Creates instance of CodeGenOptions for Hybrid ScheduledC for GPU using dimToInsertChecks to insert checks.
	**/
	public CreateCGOptionForHybridScheduledCGPU(@IModuleArgumentName(name="dimToInsertChecks") int dimToInsertChecks) {
	    try {
		 result =     alphaz.mde.CodeGen.createCGOptionForHybridScheduledCGPU(dimToInsertChecks);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public CodeGenOptions compute(){
		return result;
	}
}//endclass
