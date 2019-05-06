package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class RenameVariable  {
	
    
	/**
	Renames a variable.
	**/
	public RenameVariable(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="newVarName") String newVarName) {
	    try {
		    alphaz.mde.Basic.RenameVariable(program,system,varName,newVarName);
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
