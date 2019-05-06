package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Show  {
	private String result;
    
	/**
	Pretty prints the program using alpha-purist syntax.
Prints out the entire program when target system is unspecified.
	**/
	public Show(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		 result =     alphaz.mde.Basic.Show(program,system);
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
	public Show(@IModuleArgumentName(name="program") Program program) {
	    try {
		 result =     alphaz.mde.Basic.Show( program);
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
