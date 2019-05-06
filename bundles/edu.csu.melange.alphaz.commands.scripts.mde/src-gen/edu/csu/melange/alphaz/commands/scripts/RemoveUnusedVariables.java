package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class RemoveUnusedVariables  {
	
    
	/**
	Removes unused variables and equations. Unused variables are variables that is not used by the definition of output.
	**/
	public RemoveUnusedVariables(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.Basic.RemoveUnusedVariables(program,system);
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
	public RemoveUnusedVariables(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.Basic.RemoveUnusedVariables( program);
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
