package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class NormalizeReduction  {
	
    
	/**
	Transforms reductions specified into normal form.
The normal form of a reduction is when a reduce expression is the direct child of an equation.
	**/
	public NormalizeReduction(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.transformation.Reduction.NormalizeReduction(program,nodeID);
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
	public NormalizeReduction(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.transformation.Reduction.NormalizeReduction( program);
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
	public NormalizeReduction(@IModuleArgumentName(name="program") Program program, @IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="equationName") String equationName) {
	    try {
		    alphaz.mde.transformation.Reduction.NormalizeReduction( program,  system, equationName);
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
