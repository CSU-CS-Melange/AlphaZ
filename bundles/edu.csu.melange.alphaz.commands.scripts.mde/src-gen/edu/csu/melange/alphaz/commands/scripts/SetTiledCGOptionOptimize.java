package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class SetTiledCGOptionOptimize  {
	
    
	/**
	Applies optimizations to the tiled code generated using full-tile splitting of a selected statement group.
Statement group is selected with heuristics that may not be accurate.
	**/
	public SetTiledCGOptionOptimize(@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="optimize") int optimize) {
	    try {
		    alphaz.mde.CodeGen.setTiledCGOptionOptimize(options,optimize);
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
