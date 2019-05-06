package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class AddLocal  {
	
    
	/**
	Adds a local variable (of name specified by "nameLocal") for the expression "expr" and replace each occurrence of this expression in the considered system.
"expr" can be specified through a expression of the system (located in "nodeID"), or through an external expression "expr" whose list of indexes is "lInds".
	**/
	public AddLocal(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="nameLocal") String nameLocal,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.Transformation.AddLocal(program,system,nameLocal,nodeID);
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
	public AddLocal(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="nameLocal") String nameLocal, @IModuleArgumentName(name="expr") String expr,
@IModuleArgumentName(name="lInds") String lInds) {
	    try {
		    alphaz.mde.Transformation.AddLocal( program, system, nameLocal,  expr, lInds);
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
