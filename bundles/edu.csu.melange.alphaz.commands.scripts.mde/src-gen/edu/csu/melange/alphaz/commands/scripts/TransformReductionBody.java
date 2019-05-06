package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class TransformReductionBody  {
	
    
	/**
	Given a transformation T, and (the node id of a) reduce expression, reduce(op, f, expr), it transforms the reduction body by T.  Specifically, it first computes T’, the left-inverse of T in “the context of expr,” and then replaces the reduction by reduce(op, T'@f, T'@expr).
	**/
	public TransformReductionBody(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID,
@IModuleArgumentName(name="T") String T) {
	    try {
		    alphaz.mde.transformation.Reduction.TransformReductionBody(program,nodeID,T);
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
