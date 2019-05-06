package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class DetectReductions  {
	
    
	/**
	Detects simple reductions in the program and exposes as reduce expressions.
	**/
	public DetectReductions(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.Transformation.DetectReductions(prog,system);
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
