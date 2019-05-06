package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SimplifyingReduction  {
	
    
	/**
	Simplifies the specified reduction using the reuse specified. It does not check if the given reuse is correct.
	**/
	public SimplifyingReduction(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="reuseVector") String reuseVector) {
	    try {
		    alphaz.mde.transformation.Reduction.SimplifyingReduction(program,system,varName,reuseVector);
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
	public SimplifyingReduction(@IModuleArgumentName(name="program") Program program, @IModuleArgumentName(name="nodeID") String nodeID,
@IModuleArgumentName(name="reuseVector") String reuseVector) {
	    try {
		    alphaz.mde.transformation.Reduction.SimplifyingReduction( program,  nodeID, reuseVector);
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
