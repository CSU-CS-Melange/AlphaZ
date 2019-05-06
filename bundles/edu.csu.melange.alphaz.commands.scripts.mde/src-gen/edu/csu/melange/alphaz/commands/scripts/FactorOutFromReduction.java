package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class FactorOutFromReduction  {
	
    
	/**
	Factors out an operand of point-wise operations (specified with nodeID) from the reduction body.
It checks if the operator is distributive over the reduction operator, but does not verify that the given expression is constant in context.
	**/
	public FactorOutFromReduction(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.transformation.Reduction.FactorOutFromReduction(program,nodeID);
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
