package org.polymodel.scop.dtiler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.dtiler.basic.DTilerPointLoops;
import org.polymodel.scop.dtiler.basic.DTilerTileLoops;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.basic.selection.LargestVolumeStatement;
import org.polymodel.scop.dtiler.basic.selection.StatementSelectionStrategy;
import org.polymodel.scop.dtiler.distributed.DTilerForMPICTileLoops;
import org.polymodel.scop.dtiler.distributed.DTilerPGASTileLoops;

public class DTilingOptions {
	
	public static boolean DEBUG = true;

	public StatementSelectionStrategy strategy = new LargestVolumeStatement();
	public AbstractPointLoopGenerator pointLoopGenerator = new DTilerPointLoops(this);
	public AbstractTileLoopGenerator  tileLoopGenerator  = new DTilerTileLoops(this);
	
	//sub options for specific type of code generation
	public DTilingOptionsForDistributed forDist = new DTilingOptionsForDistributed();
	
	protected String tileIndexPrefix = "ti";
	protected String tileSizePrefix = "ts";

	/*constants for wavefront parallelization*/
	public static String wavefrontTimeName = "time";
	public static String wavefrontStartName = "start";
	public static String wavefrontEndName = "end";
	public static String innerLoopOffset = "lower_bound";
	public static String innerLoopTileOffset = "tile_start";
	
	public static final int PARAMETRIC = 0;
	
	public int numberOfTiledDimensions = -1;
	public boolean vectorizable = false;	//whether the innermost loop is vectorizable
	
	/*Information for optimized loop generation*/
	public List<List<String>> statement_pattern;	//specify the statement pattern to identify the loop nest for point loop optimization
	
	public TilingBand tilingBand;	//it has to be specified when creating the dtiling options

	//Map to keep track of created variables
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	
	//TODO: needs to be removed later, save it for now 
	public final int level;
	
	
	//lambdas for configuring namings
	
	public interface TileSizeName {
		String name(int dim, int level);
	}
	public interface TileIndexName {
		String name(int dim, int level);
	}
	
	protected TileSizeName tileSizeNameF = new TileSizeName() {
		@Override
		public String name(int dim, int level) {
			return tileSizePrefix+dim+"_l"+ level;
		}
	};
	
	protected TileIndexName tileIndexNameF = new TileIndexName() {
		@Override
		public String name(int dim, int level) {
			return tileIndexPrefix+dim+"_l"+ level;
		}
	};
	
	
	private String tileSizeName(int dim) {
		return tileSizeNameF.name(dim, level);
	}
	private String tileIndexName(int dim) {
		return tileIndexNameF.name(dim, level);
	}
	
	/////////////////Constructors//////////////////////////
	public DTilingOptions(int _level, int[] tileSize, List<Integer> orderingPrefix, int start, int end) {
		level = _level;
		tilingBand = new TilingBand(tileSize, orderingPrefix, start, end);
	}
	
	public DTilingOptions(int _level, List<Integer> orderingPrefix, int start, int end){
		level = _level;
		int[] tileSize = new int[0];
		tilingBand = new TilingBand(tileSize,orderingPrefix, start, end);
	}
	
	public DTilingOptions(int _level, List<Integer> sizeList, List<Integer> orderingPrefix, int start, int end){
		level = _level;
		int[] tileSize = convertTileSize(sizeList);
		tilingBand = new TilingBand(tileSize, orderingPrefix, start, end);
	}
	
	//////////////////////////Set the prefix string
	//These should probably replaced by the lambdas introduced above FIXME
	public void setTileIndexPrefix(String tileIndexPrefix) {
		this.tileIndexPrefix = tileIndexPrefix;
	}

	public void setTileSizePrefix(String tileSizePrefix) {
		this.tileSizePrefix = tileSizePrefix;
	}
	
	public String getTileIndexPrefix(){
		return this.tileIndexPrefix;
	}
	
	public String getTileSizePrefix(){
		return this.tileSizePrefix;
	}

	public void setTileSizeNameF(TileSizeName f) {
		tileSizeNameF = f;
	}
	public void setTileIndexNameF(TileIndexName f) {
		tileIndexNameF = f;
	}
	
	//////////////////Functions to get special variables for the tiled code ///////////////////////
	public TilingBand createTililngBand(List<Integer> orderingPrefix, int start, int end){
		int[] tileSize = new int[0];
		return createTilingBand(tileSize, orderingPrefix, start, end);
	}
	
	public TilingBand createTilingBand(int[] tileSize, List<Integer> orderingPrefix, int start, int end){
		return new TilingBand(tileSize, orderingPrefix, start, end);
	}
	
	public Variable getTileIndex(int dim) {
		String varName;
		{
			varName = tileIndexName(dim);
			if(tilingBand.orderingPrefix.size() > 0){
				varName += "_o";
				for(int i = 0; i < tilingBand.orderingPrefix.size(); i++){
					varName += tilingBand.orderingPrefix.get(i);
				}
			}
		}
		
		return getVariable(varName);
	}
	  
	/**
	 * Get the tile size for the corresponding dimension in the band
	 * @param dim: the dimension within the whole loop nest, starts from 1
	 * @return
	 */
	public AffineTerm getTileSize(int dim) {
		//the tileSize name is set externally
		String varName = tileSizeName(dim);
		if(tilingBand.orderingPrefix.size() > 0){
			varName += "_o";
			for(int i = 0; i < tilingBand.orderingPrefix.size(); i++){
				varName += tilingBand.orderingPrefix.get(i);
			}
		}
		return IntExpressionBuilder.term(getVariable(varName));
	}
	
	public int getTileLevel(){
		return level;
	}
	
	public Variable getWFstart() {
		String varName = wavefrontStartName + "_l"+level + "_d"+(tilingBand.start+1);
		
		return getVariable(varName);
		//return getVariable(wavefrontStartName);
	}
	public Variable getWFend() {
		String varName = wavefrontEndName + "_l"+level + "_d"+(tilingBand.start+1);
		
		return getVariable(varName);
		//return getVariable(wavefrontEndName);
	}
	public Variable getWFtime() {
		String varName = wavefrontTimeName + "_l"+level + "_d"+(tilingBand.start+1);
		
		return getVariable(varName);
		//return getVariable(wavefrontTimeName);
	}
	
	public Variable getWFInnerLoopTileOffset(){
		return getVariable(innerLoopTileOffset);
	}
	
	public Variable getWFInnerLoopOffset(){
		return getVariable(innerLoopOffset);
	}
	
	
	protected Variable getVariable(String name) {
		if (!variables.containsKey(name)) {
			Variable var = AlgebraFactory.eINSTANCE.createVariable();
			var.setName(name);
			//Variable var = ScopUserFactory.variable(name);
			variables.put(name, var);
		}
		return variables.get(name);
	}
	
	/**
	 * convert the tile size from a list of integer to an int array
	 * @param sizeList
	 * @return
	 */
	protected int[] convertTileSize(List<Integer> sizeList){
		if(sizeList ==null) return null;
		
		int[] sizes = new int[sizeList.size()];
		int i=0;
		for(int value : sizeList) {
			sizes[i]=value;
			i++;
		}
		
		return sizes;
	}
	
	public List<Variable> getTileSizeVariableToDeclare(){
		List<Variable> tileSizeVariables = new LinkedList<Variable>();
		for(int i = tilingBand.start+1; i <= tilingBand.end+1; i++){
			String varName = tileSizeName(i);
			tileSizeVariables.add(getVariable(varName));
		}
		
		return tileSizeVariables;
	}
	
	public List<Variable> getTileIndexVariableToDeclare(){
		List<Variable> tileIndexVariables = new LinkedList<Variable>();
		
		List<String> tileIndexes = getTileIndexToDeclare();
		
		for(String index: tileIndexes){
			tileIndexVariables.add(getVariable(index));
		}
		return tileIndexVariables;
	}
	
	public List<String> getTileIndexToDeclare(){
		List<String> tileIndexes = new LinkedList<String>();
		for(int i = tilingBand.start+1; i <= tilingBand.end+1; i++){
			String indexName = tileIndexName(i);
			tileIndexes.add(indexName);
		}
		
		return tileIndexes;
	}
	
	
	public List<String> getAddtitionalIndicesToDeclare(){
		List<String> names = new LinkedList<String>();
		
		if(tileLoopGenerator instanceof DTilerWaveFrontTileLoops){
			names.add(getWFstart().getName());
			names.add(getWFend().getName());
			names.add(getWFtime().getName());
		}
		
		//for PGAS
		if (tileLoopGenerator instanceof DTilerPGASTileLoops) {
			names.add(forDist.getPID().getName());
			names.add(forDist.getPartitioningChunkID().getName());
			names.add(forDist.getPartitioningChunkMemoryID().getName());
			for (int dim = 1; dim <= this.tilingBand.tileSize.length; dim++) {
				//names.add(forPGAS.getNumberOfTiles(dim).getName());
				names.add(forDist.getTileMemoryID(dim).getName());
			}
		}
		//for PGAS
		if (tileLoopGenerator instanceof DTilerForMPICTileLoops) {
//			names.add(outerTilesLB);
//			names.add(outerTilesUB);
			names.add(forDist.chunkMID);
		}
		return names;
	}
	
	/**
	 * Code generation options specific to PGAS-type OpenMP code
	 * 
	 * @author yuki
	 *
	 */
	public class DTilingOptionsForDistributed {
		public final String PIDInitMacroName = "pidInit";

		public String pid = "pid";
		public String tid = "tid";
		
		public String numP = "numP";
		public String numT = "numT";
		
		public String chunkOrigin = "chunkOrigin";
		public String chunkID = "chunkID";
		public String chunkMID = "chunkMID";

		public String chunkSize = "chunkSize";
		public String numTilesPerChunk = "numTilesPerChunk";
		
		public String tilePChunksPerProcessorName = "numChunksPerProcessor";
		//when tile offset coefficient is set to this value, treated as N/p distribution
		public static final int N_OVER_P_DISTRIBUTION = 0;
		
		public String numTilesPrefix = "numTiles";
		
		public String tileMemoryIDPrefix = "tileMID";
//		public String tileWaveFrontLifeTime = "tileWFlifetime";

		public String recvStartFunctionName = "recvStart";
		public String recvEndFunctionName = "recvEnd";
		public String sendFunctionName = "send";

		public String getChunkIDMacroName = "getChunkID";
		public String getChunkMemoryIDMacroName = "getChunkMID";
		public String getTileMemoryIDMacroPrefix = "getTileMID";
		
		public Variable getPID() {
			return getVariable(pid);
		}
		
		public Variable getPCount() {
			return getVariable(numP);
		}
		
		public String getPIDInitMacroBody() {
			return pid + " = omp_get_thread_num()";
		}
		public Variable getChunkOrigin() {
			return getVariable(chunkOrigin);
		}
		public Variable getNumTilesPerChunk() {
			return getVariable(numTilesPerChunk);
		}
		public Variable getChunkSize() {
			return getVariable(chunkSize);
		}
		public Variable getPartitioningChunkID() {
			return getVariable(chunkID);
		}
		public Variable getPartitioningChunkMemoryID() {
			return getVariable(chunkMID);
		}
		public Variable getNumberOfTiles(int dim) {
			return getVariable(numTilesPrefix+dim);
		}
		public Variable getTileMemoryID(int dim) {
			return getVariable(tileMemoryIDPrefix+dim);
		}
		
		public String getTileMIDMacroName(int dim) {
			return getTileMemoryIDMacroPrefix+dim;
		}
		
		/**
		 * Returns the variable used for tid in the next WF time step.
		 * Used in MPIC to place communication code 
		 * 
		 * @param dim
		 * @return
		 */
		public Variable getNextTileIndex(int dim) {
			String varName = tileIndexPrefix+dim+"next";
			
			return getVariable(varName);
		}
	}

	
	public class TilingBand{
		private int start;
		private int end;
		public final int[] tileSize;
		public List<Integer> orderingPrefix;
		public List<IntExpression> offsets;
		public List<String> tileSizeName;
		public List<String> tileIndexName;
		//private final boolean isPermuted;	TODO: permutation is not supported here yet
		
		public TilingBand(int[] tile_size, List<Integer> _orderingPrefix, int _start, int _end){
			tileSize = tile_size;
			if (tileSize == null) {
				throw new RuntimeException("tileSize must be specified");
			}
			
			orderingPrefix = _orderingPrefix;
			offsets = new LinkedList<IntExpression>();
			start = _start;
			end = _end;

			initNames();
		}
		
		public TilingBand(List<IntExpression> _offsets, int[] tile_size, List<Integer> _orderingPrefix, int _start, int _end){
			tileSize = tile_size;
			if (tileSize == null) {
				throw new RuntimeException("tileSize must be specified");
			}
			
			orderingPrefix = _orderingPrefix;
			offsets = _offsets;
			start = _start;
			end = _end;

			initNames();
		}
		
		private void initNames() {
			tileSizeName = new LinkedList<String>();
			tileIndexName = new LinkedList<String>();
			for (int i = start+1; i<= end+1; i++) {
				tileSizeName.add(tileSizeName(i));
				tileIndexName.add(tileIndexName(i));
			}
		}
		
		public int getStart(){
			return start;
		}
		
		public int getEnd(){
			return end;
		}
		
		public IntExpression getOffset(int band_dim){
			if(offsets.size() >= band_dim){
				return offsets.get(band_dim - 1);
			}
			
			return null;
		}
		
		public void setStart(int _start){
			start = _start;
		}
		
		public void setEnd(int _end){
			end = _end;
		}
		
		public void setOffsets(List<IntExpression> _offsets){
			offsets.clear();
			offsets.addAll(_offsets);
		}
		
		public void setTileSizeName(List<String> _tileSizeName){
			tileSizeName.clear();
			tileSizeName.addAll(_tileSizeName);
		}
		
		public void setTileIndexName(List<String> _tileIndexName){
			tileIndexName.clear();
			tileIndexName.addAll(_tileIndexName);
		}
		
	}
}
