package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class GenerateWriteC  {
	
    
	/**
	Generates WriteC code for a system.
TargetMapping is ignored except for MemoryMapping given for output variables.
Detailed options can be given through optional argument.
	**/
	public GenerateWriteC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="options") CodeGenOptions options,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateWriteC(program,system,options,outDir);
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
	public GenerateWriteC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateWriteC( program, system, outDir);
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
	public GenerateWriteC(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.CodeGen.generateWriteC( program, system);
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
