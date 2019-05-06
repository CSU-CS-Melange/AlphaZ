package org.polymodel.polyhedralIR.polyIRCG.generator;

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.chunkID;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.chunkMID;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.chunkOrigin;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.chunkSize;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.getChunkMemoryIDMacroName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.getTileMemoryIDMacroPrefix;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.numP;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.numTilesPerChunk;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.numTilesPrefix;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.pid;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.recvEndFunctionName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.recvStartFunctionName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.sendFunctionName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.tileMemoryIDPrefix;

import org.polymodel.scop.dtiler.DTilingOptions;

public class DistributedCodeGenOptions extends TiledCodeGenOptions {
	
	public static DistributedCodeGenOptions PGASCDefault() {
		DistributedCodeGenOptions options = new DistributedCodeGenOptions();
		options.flattenArrays = false;
		options.optimized = false;
		return options;
	}
	
	public static DistributedCodeGenOptions scheduledCDefault() {
		return PGASCDefault();
	}
	
	@Override
	public void populateDTilingOptions(DTilingOptions dtoptions) {
		super.populateDTilingOptions(dtoptions);
//		dtoptions.forPGAS.numTilesPerChunk = numTilesPerChunk;
		dtoptions.forDist.pid = pid;
		dtoptions.forDist.numP = numP;
		dtoptions.forDist.chunkOrigin = chunkOrigin;
		dtoptions.forDist.chunkSize = chunkSize;
		dtoptions.forDist.chunkID = chunkID;
		dtoptions.forDist.chunkMID = chunkMID;
		dtoptions.forDist.numTilesPerChunk = numTilesPerChunk;
		dtoptions.forDist.numTilesPrefix = numTilesPrefix;
		dtoptions.forDist.tileMemoryIDPrefix = tileMemoryIDPrefix;
		dtoptions.forDist.getTileMemoryIDMacroPrefix = getTileMemoryIDMacroPrefix;
		dtoptions.forDist.getChunkMemoryIDMacroName = getChunkMemoryIDMacroName;
		dtoptions.forDist.recvStartFunctionName = recvStartFunctionName;
		dtoptions.forDist.recvEndFunctionName = recvEndFunctionName;
		dtoptions.forDist.sendFunctionName = sendFunctionName;
//		dtoptions.forPGAS.tileWaveFrontLifeTime = tileWaveFrontLifeTimePerProcessor;
	}
}
