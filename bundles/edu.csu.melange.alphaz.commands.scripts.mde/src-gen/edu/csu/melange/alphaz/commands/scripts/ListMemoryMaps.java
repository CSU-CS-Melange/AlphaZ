package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ListMemoryMaps  {
	
    
	/**
	Lists all memory mappings specified for a system.
	**/
	public ListMemoryMaps(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.TargetMapping.listMemoryMaps(prog,system);
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
