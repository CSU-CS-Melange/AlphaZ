package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class CreateCGOptionsForPCOT  {
	private TiledCodeGenOptions result;
    
	/**
	Creates instance of CodeGenOptions for PCOTC using default values for tiling.
	**/
	public CreateCGOptionsForPCOT() {
	    try {
		 result =     alphaz.mde.CodeGen.createCGOptionsForPCOT();
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
