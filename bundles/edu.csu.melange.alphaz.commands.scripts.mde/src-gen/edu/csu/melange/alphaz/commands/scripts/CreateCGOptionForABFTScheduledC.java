package edu.csu.melange.alphaz.commands.scripts;

import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class CreateCGOptionForABFTScheduledC {

	private CodeGenOptions result;
    
	public CreateCGOptionForABFTScheduledC() {
	    try {
		 result = alphaz.mde.CodeGen.createCGOptionForScheduledABFTC();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}
	
    

	public CodeGenOptions compute(){
		return result;
	}
	
}
