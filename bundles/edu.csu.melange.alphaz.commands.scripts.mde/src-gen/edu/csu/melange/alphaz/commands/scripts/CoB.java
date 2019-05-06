package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class CoB  {
	
    
	/**
	Change of Basis transforms the domain of a variable to the image by the given function, while adding necessary dependence expressions to maintain the original semantics of the program. Details can be found at {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=change_of_basis}.
	**/
	public CoB(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="function") AffineFunction function) {
	    try {
		    alphaz.mde.Transformation.CoB(program,systemName,varName,function);
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
	public CoB(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="varName") String varName, @IModuleArgumentName(name="function") String function) {
	    try {
		    alphaz.mde.Transformation.CoB( program, systemName, varName,  function);
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
