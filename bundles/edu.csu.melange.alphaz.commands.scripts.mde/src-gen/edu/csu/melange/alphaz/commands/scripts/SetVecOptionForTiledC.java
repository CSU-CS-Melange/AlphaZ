package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;

public class SetVecOptionForTiledC  {
	
    
	/**
	Turn on the vectorization option for TiledC. Right now it is only open for DTiler -- Where only 1 level of tiling is applied and all dimensions are tiled.
Four types of vectorization strategy is supported: naive, opt nobuff -- optimized vectorization strategy without temporary buffering, all aligned -- optimized vectorization strategy with temporary buffering and all vectors aligned, mostly aligned -- optimized vectorization strategy with temporary buffering and mostly aligned strategy. The default strategy is set to be "opt nobuff".
Register block size only corresponds to the data dimensions of stencil computations, the default register block size is set to unroll the innermost vectorized dimension 4 times. 
	**/
	public SetVecOptionForTiledC(@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="vecSet") String vecSet,
@IModuleArgumentName(name="vecStrategy") String vecStrategy,
@IModuleArgumentName(name="registerBlockSize") String registerBlockSize) {
	    try {
		    alphaz.mde.CodeGen.setVecOptionForTiledC(options,vecSet,vecStrategy,registerBlockSize);
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
	public SetVecOptionForTiledC(@IModuleArgumentName(name="options") TiledCodeGenOptions options) {
	    try {
		    alphaz.mde.CodeGen.setVecOptionForTiledC( options);
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
	public SetVecOptionForTiledC(@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="vecStrategy") String vecStrategy) {
	    try {
		    alphaz.mde.CodeGen.setVecOptionForTiledC( options, vecStrategy);
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
	public SetVecOptionForTiledC(@IModuleArgumentName(name="options") TiledCodeGenOptions options,
@IModuleArgumentName(name="vecStrategy") String vecStrategy,
@IModuleArgumentName(name="registerBlockSize") String registerBlockSize) {
	    try {
		    alphaz.mde.CodeGen.setVecOptionForTiledC( options, vecStrategy, registerBlockSize);
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
