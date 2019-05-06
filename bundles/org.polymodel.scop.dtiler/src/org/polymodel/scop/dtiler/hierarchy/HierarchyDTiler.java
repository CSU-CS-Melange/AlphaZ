 package org.polymodel.scop.dtiler.hierarchy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTiler;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.DTiler.TiledBlock;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.basic.DTilingTools;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions.HierarchyBandDTilingOptions;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;



/** 
 * DTiler. After tiling, each {@link AbstractScopStatement} is surrounded by tiles and
 * points loops. Sizes of the tiles are parametric. (cf.
 * http://doi.acm.org/10.1145/1250734.1250780)
 * 
 * @author antoine
 * 
 */
public class HierarchyDTiler {
	
	/**
	 * DTiling for the entire SCoP. Extracts loop nests before applying DTiling.
	 * Does not alter the SCoP given.
	 * 
	 * @param clast
	 * @param options
	 * @return
	 */
	public static ScopRoot hierarchyTile(ScopRoot scop, HierarchyDTilingOptions hierarchy_dtiling_options) {
		return hierarchyTileWithHierarchyDTilingOutput(scop, hierarchy_dtiling_options).tiledScop;
	}
	
	public static HierarchyDTilingOutput hierarchyTileWithHierarchyDTilingOutput(ScopRoot scop, HierarchyDTilingOptions hierarchy_dtiling_options){
		ScopRoot copy = EcoreUtil.copy(scop);
		HierarchyDTilingOutput output = new HierarchyDTilingOutput(copy);
		
		List<HierarchyBandDTilingOptions> hierarchy_band_dtiling_options = hierarchy_dtiling_options.getHierarchyBandDTilingOptions();
		//applying tiling from band to band
		for(int i = 0; i < hierarchy_band_dtiling_options.size(); i++){
			//current hierarchy band for tiling
			HierarchyBandDTilingOptions hierarchy_band_dtiling_option = hierarchy_band_dtiling_options.get(i);
			//apply tiling from level to level for the current band
			int n_tiled = 0;
			for(int j = 0; j < hierarchy_band_dtiling_option.getTilingLevel(); j++){
				DTilingOptions options = hierarchy_band_dtiling_option.getDTilingOption(j+1);
		
				//extract the sub tilable block
				SubTilableBlock subBlock = extractSubTilableBlock(copy, options.tilingBand.getStart(), options.tilingBand.getEnd(), n_tiled);
				
				Set<String> additionalPrivateVarsForOmpParallel = new TreeSet<String>();
				for (AbstractScopNode node : subBlock.stmtBodyMap.values()) {
					CollectIterators collectIterators = new CollectIterators();
					node.accept(collectIterators);
					additionalPrivateVarsForOmpParallel.addAll(collectIterators.getIterators());
				}
				
				for(TilableBlock tilable_block: subBlock.tilableBlock){
					
					// additionalPrivateVarsForOmpParallel set contains the 
					// loop iterator variables of the loops that are not tiled.
					// These vars should added to the list of private variables 
					// when generating omp wavefront parallel code. Otherwise
					// code is not correct.
					TiledBlock tiledBlock = DTiler.tile(tilable_block, options,
							additionalPrivateVarsForOmpParallel);
					
					//replace the tilable block with tiled block
					for (int k = 1; k < tilable_block.loops.size(); k++) {
						EcoreUtil.remove(tilable_block.loops.get(k));
					}	
					EcoreUtil.replace(tilable_block.loops.get(0), tiledBlock.tiledLoopStart);
				}
				
				//replace the temporary statment back with the exact body back
				DTilingTools.replaceStatementWithBody(copy, subBlock.stmtBodyMap, "tiling_stmt");
				
				//accumulate the number of tiled loop
				n_tiled += options.tilingBand.getEnd() - options.tilingBand.getStart() + 1;
			}
		}
		
		return output;
	} 
	
	private static class CollectIterators extends ScopDepthFirstVisitorImpl {
		Set<String> iterators;
		
		public CollectIterators() {
			iterators = new TreeSet<String>();
		}
		
		@Override
		public void inScopFor(ScopFor s) {
			iterators.add(s.getIterator().getName());
		}

		public Set<String> getIterators() {
			return iterators;
		}
		
		
		
	}
	
	public static SubTilableBlock extractSubTilableBlock(ScopRoot scop, int band_start, int band_end, int n_tiled){
		SubTilableBlock subTilableBlock = new SubTilableBlock(band_start, band_end);
		
		//remove all the nodes after the for loop at end
		Map<String, AbstractScopNode> stmt_body_map = DTilingTools.replaceForBodyWithStatement(scop, band_end + n_tiled+1, "tiling_stmt");
		//get the blocks for tiling
		List<ScopBlock> blocks = DTilingTools.getScopBlockWithDepth(scop, band_start + n_tiled+1); 
		//extract tilable block for all the blocks
		List<TilableBlock> tilableBlocks = new LinkedList<TilableBlock>();
		for(ScopBlock block: blocks){
			tilableBlocks.addAll(DTiler.extractTilableBlock(block));
		}
		
		subTilableBlock.stmtBodyMap = stmt_body_map;
		subTilableBlock.tilableBlock = tilableBlocks;
		
		return subTilableBlock;
		
	}
	
	
	public static class SubTilableBlock{
		public final int start, end;
		public List<TilableBlock> tilableBlock;
		public Map<String, AbstractScopNode> stmtBodyMap;
		
		public SubTilableBlock(int _start, int _end){
			start = _start;
			end = _end;
			tilableBlock = new LinkedList<TilableBlock>();
			stmtBodyMap = new HashMap<String, AbstractScopNode>();
		}
	}
	
	public static class HierarchyTiledBlock{
		public final TilableBlock tilableBlock;		//the tilable block from the whole program for tiling
		public final ScopFor perfectNestLoop;	//the perfect nested loop created for the tilable block
		public final ScopFor tiledPerfectNestLoop;	//the perfect nested loop after tiling
		
		public HierarchyTiledBlock(TilableBlock _tilableBlock, ScopFor _perfectNestLoop, ScopFor _tiledPerfectNestLoop){
			tilableBlock = _tilableBlock;
			perfectNestLoop = _perfectNestLoop;
			tiledPerfectNestLoop = _tiledPerfectNestLoop;
		}
	} 
}
