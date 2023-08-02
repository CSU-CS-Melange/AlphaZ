package edu.csu.melange.alphaz.commands.scripts;

import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;


public class GenerateABFTWrapper {

	
	public GenerateABFTWrapper(@IModuleArgumentName(name="program") Program program,
			@IModuleArgumentName(name="system") String system,
			@IModuleArgumentName(name="outDir") String outDir) {
	    try {
		    alphaz.mde.CodeGen.generateABFTWrapper( program, system, outDir);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}
	
	public GenerateABFTWrapper(@IModuleArgumentName(name="program") Program program,
			@IModuleArgumentName(name="system") String system,
			@IModuleArgumentName(name="options") ABFTCodeGenOptions options,
			@IModuleArgumentName(name="outDir") String outDir) {
		try {
			alphaz.mde.CodeGen.generateABFTWrapper( program, system, options, outDir);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			//System.out.println("Unexpected Exception");
			//e.printStackTrace();
			throw new RuntimeException("Exception to terminate script");
		}
	}

	
	//@IModuleArgumentName(name="options") CodeGenOptions options,

	public void compute(){
		
	}
	
}
