package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class CheckProgram  {
	
    
	/**
	Performs uniqueness and completeness check of the program.
The program is a valid alphabets program, if it passes this check.
Details of the check can be found at {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=check_program}.
	**/
	public CheckProgram(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.Analysis.CheckProgram(program);
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
