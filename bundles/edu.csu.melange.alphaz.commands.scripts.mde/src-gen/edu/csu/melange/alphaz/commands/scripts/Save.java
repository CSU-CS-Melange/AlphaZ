package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Save  {
	
    
	/**
	Saves the output of show to the specified file.
When output filename is unspecified, saves to "original_filename-Show.ab".
	**/
	public Save(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="filename") String filename) {
	    try {
		    alphaz.mde.Basic.Save(program,filename);
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
	public Save(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.Basic.Save( program);
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
