package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ReductionDecomposition  {
	
    
	/**
	Decomposes a reduction spanning more than one dimensions to two reductions.
Function f1 composed with f2 should match the original projection function.

The target reduction is specified as the n-th occurrence in the rhs of an equation indexed from 0.
	**/
	public ReductionDecomposition(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID,
@IModuleArgumentName(name="f1") String f1,
@IModuleArgumentName(name="f2") String f2) {
	    try {
		    alphaz.mde.transformation.Reduction.ReductionDecomposition(program,nodeID,f1,f2);
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
