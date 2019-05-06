package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class ApplySTMap  {
	
    
	/**
	Applies sequence of CoBs using STMap given for each variable.
This is identical to the pre-processing step of ScheduledC code generator, where all variables are mapped to a common space so that ordering of iterations can be defined.
Assumes correct schedule [TODO:run verifier before applying the transformation once the verifier is fixed]
All STMaps and MemoryMaps given for the system will also be transformed appropriately.
	**/
	public ApplySTMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName) {
	    try {
		    alphaz.mde.Transformation.ApplySTMap(program,systemName);
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
