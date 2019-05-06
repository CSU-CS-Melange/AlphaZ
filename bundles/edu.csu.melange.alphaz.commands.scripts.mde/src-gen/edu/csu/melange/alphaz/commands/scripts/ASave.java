package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ASave  {
	
    
	/**
	Outputs the program to the specified file with array syntax.
When filename is not specified, saves as "original_filename-ASave.ab".
	**/
	public ASave(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="filename") String filename) {
	    try {
		    alphaz.mde.Basic.ASave(program,filename);
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
	public ASave(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.Basic.ASave( program);
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
