package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ReductionComposition  {
	
    
	/**
	Composes the given reduction (represented by the nodeID) with its immediate child assuming that it is also a reduction with the same operator. this transformation implements the following reduce(op, f1, reduce(op, f2, body)); => reduce(op, f1 o f2, body); and is the reverse of ReductionDecomposition. Added support for the case when there is a restrict expression surrounding the inner reduction.
	**/
	public ReductionComposition(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.transformation.Reduction.ReductionComposition(program,nodeID);
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
