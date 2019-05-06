package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ListSpaceTimeMaps  {
	
    
	/**
	Lists all SpaceTime maps that have been specified for a system.
	**/
	public ListSpaceTimeMaps(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level) {
	    try {
		    alphaz.mde.TargetMapping.listSpaceTimeMaps(prog,system,level);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	TODO : add description (to the model)
	**/
	public ListSpaceTimeMaps(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.TargetMapping.listSpaceTimeMaps( prog, system);
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
