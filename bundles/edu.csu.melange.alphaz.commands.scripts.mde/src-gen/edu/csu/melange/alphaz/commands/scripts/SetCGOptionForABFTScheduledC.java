package edu.csu.melange.alphaz.commands.scripts;

import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;

public class SetCGOptionForABFTScheduledC {
	
	private ABFTCodeGenOptions result;
	
	public SetCGOptionForABFTScheduledC(ABFTCodeGenOptions options, String key, String value) {
	    try {
		 result = alphaz.mde.CodeGen.setCGOptionForScheduledABFTC(options, key, value);
		 int x = 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}
	
	public ABFTCodeGenOptions compute(){
		return result;
	}
}
