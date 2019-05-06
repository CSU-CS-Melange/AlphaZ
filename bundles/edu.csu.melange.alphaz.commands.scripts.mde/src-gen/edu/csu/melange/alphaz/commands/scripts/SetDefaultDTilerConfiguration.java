package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetDefaultDTilerConfiguration  {
	
    
	/**
	Set up the default configuration for dtiler: apply parametric one level tiling to all the dimensions from [start to end].
	**/
	public SetDefaultDTilerConfiguration(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="startDim") int startDim,
@IModuleArgumentName(name="endDim") int endDim,
@IModuleArgumentName(name="tilingType") String tilingType) {
	    try {
		    alphaz.mde.TargetMapping.setDefaultDTilerConfiguration(program,system,startDim,endDim,tilingType);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	Default configuration for DTiler for the whole program: apply parametric one level tiling to all the dimensions of the given system in the program.
	**/
	public SetDefaultDTilerConfiguration(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="tilingType") String tilingType) {
	    try {
		    alphaz.mde.TargetMapping.setDefaultDTilerConfiguration( program, system, tilingType);
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
