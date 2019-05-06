package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetCoBPreprocess  {
	
    
	/**
	Set the Change of Basis transformation that need to be performed before tiling (usually to make the rectangular tiling legal).
By default, this function is Id (i.e., no CoB is performed before the tiling)
	**/
	public SetCoBPreprocess(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="cobAffFunc") String cobAffFunc) {
	    try {
		    alphaz.mde.transformation.MonoparametricTiling.setCoBPreprocess(prog,syst,varName,cobAffFunc);
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
