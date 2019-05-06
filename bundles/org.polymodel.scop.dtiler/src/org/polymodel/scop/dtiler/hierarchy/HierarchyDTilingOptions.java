package org.polymodel.scop.dtiler.hierarchy;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.scop.dtiler.DTilingOptions;


/**
 * Stores tiling specifications for each level
 * @author zou
 *
 */
public class HierarchyDTilingOptions {
	//DEBUGGING FLAG
	public static boolean DEBUG = true;
	
	private List<HierarchyBandDTilingOptions> hierarchyOptions;
	
	/******CONSTRUCTORS*****/
	public HierarchyDTilingOptions(){
		hierarchyOptions = new LinkedList<HierarchyBandDTilingOptions>();
	}
	
	public HierarchyDTilingOptions(List<HierarchyBandDTilingOptions> _hierarchyOptions){
		hierarchyOptions = _hierarchyOptions;
	}
	
	/*function for set and adding the hierachy dtiling options*/
	public void setHierarchyBandDTilingOptions(List<HierarchyBandDTilingOptions> _hierarchyOptions){
		hierarchyOptions.clear();
		hierarchyOptions.addAll(_hierarchyOptions);
	}
	
	public void addHierarchyBandDTilingOptions(HierarchyBandDTilingOptions _hierarchyBandOptions){
		hierarchyOptions.add(_hierarchyBandOptions);
	}
	
	public HierarchyBandDTilingOptions createHierarchyBandDTilingOptions(int tilingLevel, int band_start, int band_end, Map<Integer, DTilingOptions> dtilingOptions){
		return new HierarchyBandDTilingOptions(tilingLevel, band_start, band_end, dtilingOptions);
	}
	
	/**
	 * Function for getting the hierarchy Band DTiling Options
	 * return a list of HierarchyBandDTilingOptions that are sorted according to the starting dimension
	 * with decreasing order
	 * @return
	 */
	public List<HierarchyBandDTilingOptions> getHierarchyBandDTilingOptions(){
		Collections.sort(hierarchyOptions, new Comparator<HierarchyBandDTilingOptions>() {
			@Override
			public int compare(HierarchyBandDTilingOptions option1, HierarchyBandDTilingOptions option2) {
				return option1.getBandStart() - option2.getBandStart();
			}
			
		});
		
		return hierarchyOptions;
	}
	
	public List<String> getAllTileIndexToDeclare(){
		List<String> tileIndexes = new LinkedList<String>();
		
		for(int i = 0; i < hierarchyOptions.size(); i++){
			for(int j = 1; j<= hierarchyOptions.get(i).getTilingLevel(); j++){
				DTilingOptions options = hierarchyOptions.get(i).getDTilingOption(j);
				tileIndexes.addAll(options.getTileIndexToDeclare());
			}
		}
		
		return tileIndexes;
	}
	
	
	public List<String> getAllAddtitionalIndicesToDeclare(){
		List<String> indices = new LinkedList<String>();
		
		for(int i = 0; i < hierarchyOptions.size(); i++){
			for(int j = 1; j <= hierarchyOptions.get(i).getTilingLevel(); j++){
				DTilingOptions options = hierarchyOptions.get(i).getDTilingOption(j);
				indices.addAll(options.getAddtitionalIndicesToDeclare());
			}
		}
		
		return indices;
	}
	/**
	 * The DTiling Options for each big band for tiling
	 * @author zou
	 *
	 */
	public class HierarchyBandDTilingOptions{
		private final int tilingLevels;	//total number of levels for tiling for the current band, starts from 1
		private final int band_start;
		private final int band_end;
		private Map<Integer, DTilingOptions> dtilingOptions;	//mapping of the dtiling options for each level
		
		//////////////////CONSTRUCTORS///////////////////////////
		public HierarchyBandDTilingOptions(int _tilingLevels, int _band_start, int _band_end,Map<Integer, DTilingOptions> _dtilingOptions){
			band_start = _band_start;
			band_end = _band_end;
			tilingLevels = _tilingLevels;
			dtilingOptions = _dtilingOptions;
		}
		
		//////////////////////////functions for getting and setting member values
		public void addDTilingOptions(int level, DTilingOptions options){
			dtilingOptions.put(level, options);
		}
		
		public int getTilingLevel()
		{
			return tilingLevels;
		}
		
		public Map<Integer, DTilingOptions> getDTilingOptions(){
			return dtilingOptions;
		}
		
		/**
		 * Get the DTiling Option for a given level
		 * @param level
		 * @return
		 */
		public DTilingOptions getDTilingOption(int level){
			return dtilingOptions.get(level);
		}
		
		/**
		 * Get the starting dimension for the current hierarchy band
		 * @return
		 */
		public int getBandStart(){
			return band_start;
		}
		
		public int getBandEnd(){
			return band_end;
		}
	}
}
