package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class AddRecursionDepthForPCOT  {
	private TiledCodeGenOptions result;
    
	/**
	Generates code with recursion depth as an input parameter.
	**/
	public AddRecursionDepthForPCOT(@IModuleArgumentName(name="options") TiledCodeGenOptions options) {
	    try {
		 result =     alphaz.mde.CodeGen.addRecursionDepthForPCOT(options);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public TiledCodeGenOptions compute(){
		return result;
	}
}//endclass
