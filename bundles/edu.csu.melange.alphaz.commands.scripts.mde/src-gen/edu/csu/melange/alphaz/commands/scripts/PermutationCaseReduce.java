package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class PermutationCaseReduce  {
	
    
	/**
	Takes case expression inside reductions out side of the reduction.
This transformation can be applied to three different targets, 
the entire program, an affine system, or an equation.
	**/
	public PermutationCaseReduce(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="targetVar") String targetVar) {
	    try {
		    alphaz.mde.transformation.Reduction.PermutationCaseReduce(program,systemName,targetVar);
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
	public PermutationCaseReduce(@IModuleArgumentName(name="program") Program program) {
	    try {
		    alphaz.mde.transformation.Reduction.PermutationCaseReduce( program);
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
	public PermutationCaseReduce(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName) {
	    try {
		    alphaz.mde.transformation.Reduction.PermutationCaseReduce( program, systemName);
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
