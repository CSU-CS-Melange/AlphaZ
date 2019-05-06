package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetRatio  {
	
    
	/**
	Specify the ratio of a variable, before the tiling transformation. The default ratio taken for a variable is 1^k (square ratio)
	**/
	public SetRatio(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="lRatios") String lRatios) {
	    try {
		    alphaz.mde.transformation.MonoparametricTiling.setRatio(prog,syst,varName,lRatios);
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
