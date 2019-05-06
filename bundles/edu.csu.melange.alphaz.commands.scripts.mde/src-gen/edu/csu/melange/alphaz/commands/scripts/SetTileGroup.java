package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetTileGroup  {
	
    
	/**
	Set the tile group of a variable (through a common name), before a tiling.
By default, each variable is alone in its tile group (which has the same name than the variable name)
	**/
	public SetTileGroup(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="tileGroupName") String tileGroupName) {
	    try {
		    alphaz.mde.transformation.MonoparametricTiling.setTileGroup(prog,syst,varName,tileGroupName);
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
