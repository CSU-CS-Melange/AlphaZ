package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetBandForTiling  {
	
    
	/**
	configure a band of continuous dimensions for tiling.
	**/
	public SetBandForTiling(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="bandName") String bandName,
@IModuleArgumentName(name="levels") int levels,
@IModuleArgumentName(name="orderingPrefix") String orderingPrefix,
@IModuleArgumentName(name="startDim") int startDim,
@IModuleArgumentName(name="endDim") int endDim) {
	    try {
		    alphaz.mde.TargetMapping.setBandForTiling(program,system,bandName,levels,orderingPrefix,startDim,endDim);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	set up tiling band with empty ordering prefix
	**/
	public SetBandForTiling(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="bandName") String bandName,
@IModuleArgumentName(name="levels") int levels,
@IModuleArgumentName(name="startDim") int startDim,
@IModuleArgumentName(name="endDim") int endDim) {
	    try {
		    alphaz.mde.TargetMapping.setBandForTiling( program, system, bandName, levels, startDim, endDim);
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
