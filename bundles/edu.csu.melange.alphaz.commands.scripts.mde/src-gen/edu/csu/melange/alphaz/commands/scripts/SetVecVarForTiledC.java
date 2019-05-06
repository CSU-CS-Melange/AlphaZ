package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class SetVecVarForTiledC  {
	
    
	/**
	TODO : add description (to the model)
	**/
	public SetVecVarForTiledC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="var") String var,
@IModuleArgumentName(name="domain") String domain) {
	    try {
		    alphaz.mde.CodeGen.setVecVarForTiledC(program,systemName,options,var,domain);
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
	public SetVecVarForTiledC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="var") String var) {
	    try {
		    alphaz.mde.CodeGen.setVecVarForTiledC( program, systemName, options, var);
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
