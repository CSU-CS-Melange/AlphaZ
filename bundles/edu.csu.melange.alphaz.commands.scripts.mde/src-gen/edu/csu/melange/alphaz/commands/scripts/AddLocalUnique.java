package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class AddLocalUnique  {
	
    
	/**
	Replace only the expression (specified by the location "nodeID") by a new local variable (of name "nameLocal").
	**/
	public AddLocalUnique(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="nameLocal") String nameLocal,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.Transformation.AddLocalUnique(program,system,nameLocal,nodeID);
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
