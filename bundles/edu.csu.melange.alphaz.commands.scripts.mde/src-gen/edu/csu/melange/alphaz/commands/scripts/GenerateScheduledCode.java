package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class GenerateScheduledCode  {
	
    
	/**
	Generates scheduledC code for a system using the TargetMapping specified for the system.
Detailed options can be given through optional argument.
	**/
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="options") CodeGenOptions options,
@IModuleArgumentName(name="outDir") String outDir,
@IModuleArgumentName(name="genVerifier") Boolean genVerifier) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode(program,system,options,outDir,genVerifier);
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
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode( program, system, outDir);
		} catch (Exception e) {
			System.err.println(e.getMessage());
//		    System.out.println("Unexpected Exception");
//		    e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	/**
	TODO : add description (to the model)
	**/
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="outDir") String outDir,
@IModuleArgumentName(name="genVerifier") Boolean genVerifier) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode( program, system, outDir, genVerifier);
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
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode( program, system);
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
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="genVerifier") Boolean genVerifier) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode( program, system, genVerifier);
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
	public GenerateScheduledCode(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="options") CodeGenOptions options,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateScheduledCode( program, system, options, outDir);
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
