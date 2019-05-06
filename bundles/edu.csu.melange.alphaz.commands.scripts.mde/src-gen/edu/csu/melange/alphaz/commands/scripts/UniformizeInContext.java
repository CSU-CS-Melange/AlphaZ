package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class UniformizeInContext  {
	
    
	/**
	Attempts to uniformize all dependencies when possible.
	**/
	public UniformizeInContext(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="excludeInputs") int excludeInputs) {
	    try {
		    alphaz.mde.Transformation.UniformizeInContext(prog,system,excludeInputs);
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
	public UniformizeInContext(@IModuleArgumentName(name="prog") Program prog) {
	    try {
		    alphaz.mde.Transformation.UniformizeInContext( prog);
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
	public UniformizeInContext(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.Transformation.UniformizeInContext( prog, system);
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
