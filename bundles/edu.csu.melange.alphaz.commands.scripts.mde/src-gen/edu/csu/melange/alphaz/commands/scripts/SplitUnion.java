package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SplitUnion  {
	
    
	/**
	Replace an expression that has unions of polyhedra as its context domain with a case expression that splits the union into multiple disjiont polyhedra.
	**/
	public SplitUnion(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="nodeID") String nodeID) {
	    try {
		    alphaz.mde.Transformation.SplitUnion(prog,nodeID);
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
