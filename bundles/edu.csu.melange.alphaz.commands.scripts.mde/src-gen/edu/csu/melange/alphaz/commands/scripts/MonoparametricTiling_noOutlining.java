package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class MonoparametricTiling_noOutlining  {
	
    
	/**
	Perform a monoparametric tiling transformation without outlining (the result is a single system in which all the dimensions are doubled).
By default, the ratio taken is 1^k (square), the minimum values of the blocked parameters are 0
    and each variables of the system are tiled independently, with no change of basis as a preprocessing.
	**/
	public MonoparametricTiling_noOutlining(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="systName") String systName,
@IModuleArgumentName(name="nameBlockSizeParam") String nameBlockSizeParam,
@IModuleArgumentName(name="areParamDivisible") Boolean areParamDivisible,
@IModuleArgumentName(name="minblSizeParam") int minblSizeParam) {
	    try {
		    alphaz.mde.transformation.MonoparametricTiling.monoparametricTiling_noOutlining(prog,systName,nameBlockSizeParam,areParamDivisible,minblSizeParam);
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
