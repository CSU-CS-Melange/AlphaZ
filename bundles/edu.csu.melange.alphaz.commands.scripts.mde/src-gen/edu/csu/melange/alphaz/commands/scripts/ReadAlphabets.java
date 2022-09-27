package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ReadAlphabets  {
	private Program result;
    
	/**
	Parses the given alphabets program and returns a Program object.
	**/
	public ReadAlphabets(@IModuleArgumentName(name="file") String file) {
	    try {
		 result =     alphaz.mde.Basic.ReadAlphabets(file);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    System.out.println("Unexpected Exception");
		    e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public Program compute(){
		return result;
	}
}//endclass
