package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class OutlineSubSystem  {
	
    
	/**
	Outline a list of equations of a given system. These equation are defined through a list of variable ("listEquations") that corresponds to the variable of a StandardEquation or to the output of a UseEquation.
[V1] The created use equation will have no extension domain, and only variable expressions as inputs.
	**/
	public OutlineSubSystem(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="listEquations") String listEquations) {
	    try {
		    alphaz.mde.Transformation.OutlineSubSystem(program,system,listEquations);
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
