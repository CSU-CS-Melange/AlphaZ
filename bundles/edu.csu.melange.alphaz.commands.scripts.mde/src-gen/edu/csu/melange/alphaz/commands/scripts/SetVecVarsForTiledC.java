package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class SetVecVarsForTiledC  {
	
    
	/**
	Set the variables for vectorization. All the variable statement must occur under the same innermost loop nest. 
	**/
	public SetVecVarsForTiledC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="vars") String vars) {
	    try {
		    alphaz.mde.CodeGen.setVecVarsForTiledC(program,systemName,options,vars);
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
