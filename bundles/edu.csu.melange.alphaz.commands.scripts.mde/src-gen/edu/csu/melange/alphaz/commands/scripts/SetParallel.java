package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetParallel  {
	
    
	/**
	Specify the parallel dimensions for a system. The nth dimension (specified by parallelDims, start with zero) with the specified ordering prefix to be parallel.
	**/
	public SetParallel(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="orderingPrefix") String orderingPrefix,
@IModuleArgumentName(name="parallelDims") String parallelDims) {
	    try {
		    alphaz.mde.TargetMapping.setParallel(program,system,level,orderingPrefix,parallelDims);
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
	public SetParallel(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="orderingPrefix") String orderingPrefix,
@IModuleArgumentName(name="parallelDims") String parallelDims) {
	    try {
		    alphaz.mde.TargetMapping.setParallel( program, system, orderingPrefix, parallelDims);
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
