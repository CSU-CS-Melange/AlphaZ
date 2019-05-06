package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetSubTilingWithinBand  {
	
    
	/**
	Configure the subtiling specification for a band. The band is identified by the name. There are two types of tiling type: sequential and openmp wavefront. Represented with "sequential" and "wavefront" separately.
	**/
	public SetSubTilingWithinBand(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="bandName") String bandName,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="startDim") int startDim,
@IModuleArgumentName(name="endDim") int endDim,
@IModuleArgumentName(name="tilingType") String tilingType) {
	    try {
		    alphaz.mde.TargetMapping.setSubTilingWithinBand(program,system,bandName,level,startDim,endDim,tilingType);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	Tile all the dimensions in the band for the current level
	**/
	public SetSubTilingWithinBand(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="bandName") String bandName,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="tilingType") String tilingType) {
	    try {
		    alphaz.mde.TargetMapping.setSubTilingWithinBand( program, system, bandName, level, tilingType);
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
