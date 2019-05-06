package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class GenerateFMPPCode  {
	
    
	/**
	generate code using the flattened multi-pass tiling and parallelization strategy
	**/
	public GenerateFMPPCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="TilingType") String TilingType,
@IModuleArgumentName(name="CodeGenOptions") TiledCodeGenOptions CodeGenOptions,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateFMPPCode(program,systemName,TilingType,CodeGenOptions,outDir);
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
	public GenerateFMPPCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="TilingType") String TilingType,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateFMPPCode( program, systemName, TilingType, outDir);
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
	public GenerateFMPPCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="TilingType") String TilingType) {
	    try {
		    alphaz.mde.CodeGen.generateFMPPCode( program, systemName, TilingType);
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
	public GenerateFMPPCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName) {
	    try {
		    alphaz.mde.CodeGen.generateFMPPCode( program, systemName);
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
