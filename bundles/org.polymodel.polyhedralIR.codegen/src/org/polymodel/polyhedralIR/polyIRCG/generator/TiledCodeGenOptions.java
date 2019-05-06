package org.polymodel.polyhedralIR.polyIRCG.generator;

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.tileIndexPrefix;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.tileSizePrefix;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.wavefrontEndName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.wavefrontStartName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.wavefrontTimeName;

import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.scop.dtiler.DTilingOptions;

public class TiledCodeGenOptions extends CodeGenOptions {
	
	public boolean optimized;
	public boolean vectorizable = false;
	
	//current multipass strategy is enabled here
	//TODO: this has to be moved to targetmapping with a clean solution 
	public boolean multiPassSequential;
	public boolean multiPassWavefront;
	
	//TODO: This configuration has to be moved to targetmapping
	public boolean unrollAndJam;
	public int[] unrollDims;
	public int[] unrollFactors;
	
	//vectorization configuration
	/*must be configured*/
	public boolean vec = false;
	public String simdSet;	//SSE, AVX or others. Only AVX is currently supported
	public int strategy = -1; 	//0, 1, 2
	public List<String> vecVar;	//the variable for whom corresponding statement has to be extracted for vectorization
	/*Optional option*/
	public boolean rotate;	//True -- rotate the register for loads; False -- generate register copy at every iteration
							//Default -- True
	public Map<String, Domain> var_dom_map; 	//Domain of statement from each variable that has to be vectorized, the variable specified here has to be an non-overlapped set with vecVar
	/*Intermediate saved information for DTiler post-processing*/
	/*Specification from user is not required*/
	public String dataType;
	
	
	//temporary buffering configuration
	public boolean buffering;
	public boolean pointer;

	//intermediate configuration for fullTileStatement
	public List<List<String>> fullTileStmtPattern;	
	public List<List<String>> optimalPointLoopStmts; 	//used as an intermediate configuration for the stmts selected for the optimal full tile loop 
	
	//PCOT 
	public boolean pcot = false;
	public boolean recursion_depth = false;
	
	public static TiledCodeGenOptions scheduledCDefault() {
		TiledCodeGenOptions options = new TiledCodeGenOptions();
		options.flattenArrays = false;
		options.optimized = false;
		options.multiPassSequential = false;
		options.multiPassWavefront = false;
		
		return options;
	}
	
	public void populateDTilingOptions(DTilingOptions dtoptions) {
		dtoptions.setTileIndexPrefix(tileIndexPrefix);
		dtoptions.setTileSizePrefix(tileSizePrefix);
		dtoptions.wavefrontTimeName = wavefrontTimeName;
		dtoptions.wavefrontStartName = wavefrontStartName;
		dtoptions.wavefrontEndName = wavefrontEndName;
	}
	
	public static TiledCodeGenOptions pcotCDefault() {
		TiledCodeGenOptions options = scheduledCDefault();
		options.pcot = true;
		return options;
	}
	
	
//	public String getTileIndexRegex() {
//		return tileIndexPrefix+"\\d+";
//	}
//	public String getTileSizeRegex() {
//		return tileSizePrefix+"\\d+";
//	}
}
