package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SerializeReduction  {
	
    
	/**
	Serializes a reduction using the dependencies inferred from the given schedule.
	**/
	public SerializeReduction(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="nodeID") String nodeID,
@IModuleArgumentName(name="schedule") String schedule) {
	    try {
		    alphaz.mde.transformation.Reduction.SerializeReduction(program,nodeID,schedule);
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
	public SerializeReduction(@IModuleArgumentName(name="program") Program program, @IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="var") String var,
@IModuleArgumentName(name="schedule") String schedule) {
	    try {
		    alphaz.mde.transformation.Reduction.SerializeReduction( program,  system, var, schedule);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public void compute(){
		
	}
}//endclass
