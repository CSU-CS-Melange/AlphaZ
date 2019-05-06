package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SaveSystem  {
	
    
	/**
	Saves the output of show to the specified file.
When output filename is unspecified, saves to "original_filename-Show.ab".
	**/
	public SaveSystem(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="filename") String filename) {
	    try {
		    alphaz.mde.Basic.SaveSystem(program,system,filename);
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
	public SaveSystem(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.Basic.SaveSystem( program, system);
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
