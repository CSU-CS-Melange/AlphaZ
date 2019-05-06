package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class MergeReductions  {
	
    
	/**
	Merges two reductions combined by a binary operator into one reduction (with case branches) if possible.
It is possible if all the operators are the same and the projection functions matches.
	**/
	public MergeReductions(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.transformation.Reduction.MergeReductions(program,nodeID);
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
