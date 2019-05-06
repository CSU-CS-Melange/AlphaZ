package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class AShow  {
	private String result;
    
	/**
	Prints out the program using array notation.
Prints out the entire program when target system is unspecified.

	**/
	public AShow(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		 result =     alphaz.mde.Basic.AShow(program,system);
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
	public AShow(@IModuleArgumentName(name="program") Program program) {
	    try {
		 result =     alphaz.mde.Basic.AShow( program);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public String compute(){
		return result;
	}
}//endclass
