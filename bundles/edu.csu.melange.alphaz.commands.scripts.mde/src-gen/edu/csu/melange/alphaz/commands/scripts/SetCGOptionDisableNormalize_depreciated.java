package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class SetCGOptionDisableNormalize_depreciated  {
	
    
	/**
	Options to skip Normalize before generating code with the ScheduleC code generator.
This is an option added as an workaround to scalability problems with Normalize, and will be removed in the future.
Not normalizing may lead to significantly inefficient code.
	**/
	public SetCGOptionDisableNormalize_depreciated(@IModuleArgumentName(name="options") CodeGenOptions options) {
	    try {
		    alphaz.mde.CodeGen.setCGOptionDisableNormalize_depreciated(options);
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
