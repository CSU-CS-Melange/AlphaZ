package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Normalize  {
	
    
	/**
	Normalizes the program. Normalization rules are described in more detail at: {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=normalize}.
	**/
	public Normalize(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.Basic.Normalize(program);
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
