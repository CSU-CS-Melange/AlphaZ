package org.polymodel.polyhedralIR.polyIRCG.generator.C.PCOT;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;

/*
 * Generated Polyhedral Cache oblivious tiled code.
 * 
 * 1. Find legal tiling hyper-planes
 * 2. Do a CoB
 * 3. Find Memory allocation
 * 4. Generate code
 */
public class PCOTC extends ScheduledC {
	
	/**
	 * Static method for public access to PCOTC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		systemCodeGenenration(system, options, outDir);
	}
	
	/**
	 * Static method for public access to PCOTC code generator for one system
	 * It generates one file for each system
	 * @param program
	 * @param options
	 * @param outDir
	 */
	public static void systemCodeGenenration(AffineSystem system, CodeGenOptions options, String outDir){
		PCOTC pcotC = new PCOTC(system, options);
		pcotC.generate(options, outDir);
	}
	
	protected PCOTC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.PCOT_C;
	}
	
	@Override
	protected void initialize() {
		setTargetMapping();
		
		super.initialize();
		
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		boolean isParallel = false;
		for(TilingSpecification tile: stlevel.getTilingSpecifications()){
			int levels = tile.getLevels();
			for(int i = 1; i <= levels; i++){
				SubTilingSpecification subtile = tile.getSubTile(i);
				if(subtile == null){
					throw new RuntimeException("subtile at level " + i +" is not specified for tile band with prefix " + 
							tile.getOrderingPrefix().toString() + " [" + tile.getStartDim() + "," + tile.getEndDim() + "].");
				}
				isParallel |= subtile.getTilingType().compareTo(TILING_TYPE.OMPWAVEFRONT) == 0;
			}
		}
//		
//		if (isParallel) {
//			List<String> params = new ArrayList<String>();
//			params.add("rec_depth");
//			ExtendParameterDomain.addParameters(system, params);
//		}
	}

	/**
	 * To be implemented by Nirmal to update 
	 * 1. space time maps
	 * 2. memory maps
	 * 3. tiling config (which dimensions to be tiled)
	 */
	private void setTargetMapping() {
		//TODO
		
	}

	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();
	}
	
	protected StatementVisitorForPCOTC getStatementVisitor(CodeUnit unit) {
		return new StatementVisitorForPCOTC(unit, system.getTargetMapping(), options);
	}

}
