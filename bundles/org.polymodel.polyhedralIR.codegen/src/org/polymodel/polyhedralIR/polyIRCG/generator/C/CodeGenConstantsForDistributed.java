package org.polymodel.polyhedralIR.polyIRCG.generator.C;

public class CodeGenConstantsForDistributed {

	public final static String numP = "numP";
	public final static String numT = "numT";

	public final static String pid = "pid";
	public final static String tid = "tid";

	//number of tiles per chunk in a processor
	public final static String numTilesPerChunk = "numTilesPerChunk";
	public final static String chunkID = "chunkID";
	public final static String chunkMID = "chunkMID";
	public final static String chunkSize = "chunkSize";
	
	public final static String chunkOrigin = "chunkOrigin";
	public final static String chunkPerP = "chunkPerP";

	public final static String recvStartFunctionName = "recvStart";
	public final static String recvEndFunctionName = "recvEnd";
	public final static String sendFunctionName = "send";

	public final static String getChunkIDMacroName = "getChunkID";
	public final static String getChunkMemoryIDMacroName = "getChunkMemoryID";
	public final static String getTileMemoryIDMacroPrefix = "getTileMemoryID";

	public final static String numTilesPrefix = "numTiles";
	public final static String tileMemoryIDPrefix = "tileMID";
	public final static String tileWaveFrontLifeTimePerProcessor = "tileWFlifetimePP";

	public final static String bufferID = "bufferID";
	public final static String sendBuffer = "sendBuffer";
	public final static String recvBuffer = "recvBuffer";
	public final static String BUFFERING_FACTOR = "BUFFERING_FACTOR";
	public final static int BUFFERING_FACTOR_VALUE = 2;
	public final static String requests = "requests";
		

	public static final String getNumberOfTiles(int dim) {
		return numTilesPrefix + dim;
	}
	
	public static final String getTileMemoryID(int dim) {
		return tileMemoryIDPrefix + dim;
	}
	
}
