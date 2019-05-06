package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;

public class SetCGOptionFlattenArrays  {
	
    
	/**
	Specifies true/false (1/0) values for if the multi-dimensional arrays allocated should be flattened to 1D or not.
	**/
	public SetCGOptionFlattenArrays(@IModuleArgumentName(name="CGoptions") CodeGenOptions CGoptions,
@IModuleArgumentName(name="flatten") int flatten) {
	    try {
		    alphaz.mde.CodeGen.setCGOptionFlattenArrays(CGoptions,flatten);
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
