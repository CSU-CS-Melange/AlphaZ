package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SplitReductionBody  {
	
    
	/**
	Takes a nodeID of a reduce expression, reduce(op, f, expr), and transform it in to two reductions;
reduce(op, f, D1 : expr) op reduce(op, f, D2 : expr) where D1 is the splitDomain, and D2 is the difference between the original expression domain of the reduction body and the splitDomain.
	**/
	public SplitReductionBody(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID,
@IModuleArgumentName(name="splitDomain") String splitDomain) {
	    try {
		    alphaz.mde.transformation.Reduction.SplitReductionBody(program,nodeID,splitDomain);
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
