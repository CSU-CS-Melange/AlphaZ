package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class CreateSpaceTimeLevel  {
	
    
	/**
	Create a spacetimelevel data stucture for level (level)
	**/
	public CreateSpaceTimeLevel(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level) {
	    try {
		    alphaz.mde.TargetMapping.CreateSpaceTimeLevel(program,system,level);
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
