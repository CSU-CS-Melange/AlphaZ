package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class CreateCGOptionForHybridScheduledC  {
	private CodeGenOptions result;
    
	/**
	Creates instance of CodeGenOptions for Hybrid ScheduledC using dimToInsertChecks to insert checks.
	**/
	public CreateCGOptionForHybridScheduledC(@IModuleArgumentName(name="dimToInsertChecks") int dimToInsertChecks) {
	    try {
		 result =     alphaz.mde.CodeGen.createCGOptionForHybridScheduledC(dimToInsertChecks);
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
