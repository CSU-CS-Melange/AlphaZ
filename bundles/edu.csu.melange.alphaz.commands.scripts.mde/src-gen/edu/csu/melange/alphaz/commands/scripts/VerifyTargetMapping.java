package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class VerifyTargetMapping  {
	
    
	/**
	Verifies the target mapping given to a system. The third input takes "NONE", "MIN", "MAX" to control the verbosity.
	**/
	public VerifyTargetMapping(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="verbose") String verbose) {
	    try {
		    alphaz.mde.Analysis.VerifyTargetMapping(program,system,verbose);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public void compute(){
		
	}
}//endclass
