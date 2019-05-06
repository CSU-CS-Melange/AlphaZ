package org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.Variable;

public class MultiPassDTilerOptions {
	
	public static boolean DEBUG = false;
	
	/*constants for tile sizes and index*/
	public String passIndexPrefix = "pi";
	public String passSizePrefix = "ps";
	public String tileIndexPrefix = "ti";
	public String tileSizePrefix = "ts";
	
	/*constants for flattened pass*/
	public static String npassPrefrix = "npass";
	public static String flattenedLoopIndex = "col";
	public static String totalPassName = "total_pass";
	public static String tilePerPassName = "tile_per_pass";
	public static String tileLastPassName = "tile_last_pass";
	public static String flattenPassUpperBound = "nCols";
	public static String curPassNumber = "pass_num";
	public static String tempPassNumber = "temp_pass_num";
	public static String curTileIndexPrefix = "cur_t";
	public static String divVariableName = "div";
	
	/*constants for wavefront parallelization*/
	public static String wavefrontTimeName = "time";
	public static String totalwavefrontName = "nWave";
	public static String subwavefrontName = "subWave";
	public static String wavefrontStartName = "start";
	public static String wavefrontEndName = "end";
	
	public int total_dim;	//the number of dimensions of the original loop
	public boolean vectorizable;	//specify whether the innermost loop is vectoizable
	
	//TODO: set up pass size and index is not supported yet, needs to be supported 
//	public List<String> passSize = new LinkedList<String>();
//	public List<String> passIndex = new LinkedList<String>();
//	public List<String> tileSize = new LinkedList<String>();
//	public List<String> tileIndex = new LinkedList<String>();
	
	//Map to keep track of created variables
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	
	public MultiPassDTilerOptions(int _total_dim){
		total_dim = _total_dim;
	}
	
	
	///////////////////////////Functions for setting prefixes
	public void setPassIndexPrefix(String prefix){
		passIndexPrefix = prefix;
	}
	
	public void setPassSizePrefix(String prefix){
		passSizePrefix = prefix;
	}
	
	public void setTileIndexPrefix(String prefix){
		tileIndexPrefix = prefix;
	}
	
	public void setTileSizePrefix(String prefix){
		tileSizePrefix = prefix;
	}
	
	////////////////////////////Functions for getting variable for special variables
	public Variable getNPassVariable(int dim){
		String name = npassPrefrix + dim;
		
		return getVariable(name);
	}
	
	public Variable getFlattenedLoopIndexVariable(){
		return getVariable(flattenedLoopIndex);
	}
	
	public Variable getTotalPassVariable(){
		return getVariable(totalPassName);
	}
	
	public Variable getTilePerPassVariable(){
		return getVariable(tilePerPassName);
	}
	
	public Variable getTileLastPassName(){
		return getVariable(tileLastPassName);
	}
	
	public Variable getCurPassNumber(){
		return getVariable(curPassNumber);
	}
	
	public Variable getTempPassNumber(){
		return getVariable(tempPassNumber);
	}
	
	public Variable getCurTileIndex(int dim){
		String name = curTileIndexPrefix + dim;
		
		return getVariable(name);
	}
	
	public Variable getFlattenPassUpperBound(){
		return getVariable(flattenPassUpperBound);
	}
	
	public Variable getDivVariable(){
		return getVariable(divVariableName);
	}
	
	////////////////////////////////get variable for Wavefront parallelization
	public Variable getWaveFrontTimeName(){
		return getVariable(wavefrontTimeName);
	}
	
	public Variable getTotalWaveFrontName(){
		return getVariable(totalwavefrontName);
	}
	
	public Variable getWaveFrontStartName(){
		return getVariable(wavefrontStartName);
	}
	
	public Variable getWaveFrontEndName(){
		return getVariable(wavefrontEndName);
	}
	
	public Variable getSubWaveFrontName(){
		return getVariable(subwavefrontName);
	}
	
	protected Variable getVariable(String name) {
		if (!variables.containsKey(name)) {
			Variable var = AlgebraFactory.eINSTANCE.createVariable();
			var.setName(name); 
			variables.put(name, var);
		}
		return variables.get(name);
	}
	
	//////////////////////////////////////////functions for getting names of the pass index, pass size, tile size and pass index of the multi pass parallelization strategy
	public Variable getPassIndexVariable(int dim, int level){
		return getVariable(getPassIndexName(dim, level));
	}
	
	public Variable getPassSizeVariable(int dim, int level){
		return getVariable(getPassSizeName(dim , level));
	}
	
	public Variable getTileIndexVariable(int dim, int level){
		return getVariable(getTileIndexName(dim, level));
	}
	
	public Variable getTileSizeVariable(int dim, int level){
		return getVariable(getTileSizeName(dim, level));
	}
	
	public String getPassIndexName(int dim, int level){
		return (passIndexPrefix + dim + "_l" + level);
	}
	
	public String getPassSizeName(int dim, int level){
		return (passSizePrefix + dim + "_l" + level);
	}
	
	public String getTileIndexName(int dim, int level){
		return (tileIndexPrefix + dim + "_l" + level);
	}
	
	public String getTileSizeName(int dim, int level){
		return (tileSizePrefix + dim + "_l" + level);
	}
	
	////////////////////////////////additional functions for extra variables needs to be declared outside the scop
	public List<String> getTileIndicesForMultiPass(){
		List<String> indices = new LinkedList<String>();
		
		indices.add(getPassIndexName(1, 1));
		//add pass index for the second pass level 
		for(int i = 2; i <= total_dim - 1; i++){
			indices.add(getPassIndexName(i, 2));
		}
		//add tile index for the last level
		for(int i = 1; i <= total_dim; i++){
			indices.add(getTileIndexName(i, 3));
		}
			
		return indices;
	}
	
	public List<String> getTileSizesForMultiPass(){
		List<String> sizes = new LinkedList<String>();
		
		//add pass size for the first level
		sizes.add(getPassSizeName(1, 1));
		//add pass sizes for the second level 
		for(int i = 2; i <= total_dim - 1; i++){
			sizes.add(getPassSizeName(i, 2));
		}
		
		//add tile sizes for the last level
		for(int i = 1; i <= total_dim; i++){
			sizes.add(getTileSizeName(i, 3));
		}
		return sizes;
	}
	
	public List<String> getAddtitionalIndicesForMultiPass(){
		List<String> indices = new LinkedList<String>();
		indices.add(flattenedLoopIndex);
		
		return indices;
	}
	
	public List<String> getAdditionalVariableForMultiPass(){
		List<String> vars = new LinkedList<String>();
		
		vars.add(totalPassName);
		vars.add(tilePerPassName);
		vars.add(tileLastPassName);
		vars.add(flattenPassUpperBound);
		vars.add(curPassNumber);
		vars.add(tempPassNumber);
		vars.add(divVariableName);
		String cur_tile_var = curTileIndexPrefix + total_dim;
		vars.add(cur_tile_var);
		//add the variable for the number of passes for each dimension
		for(int i = 1; i <= total_dim - 1; i++){
			String pass_num_var = npassPrefrix + i;
			vars.add(pass_num_var);
		}
		
		return vars;
	}
	
	public List<String> getAdditionalWavefrontVariables(){
		List<String> vars = new LinkedList<String>();
		
		vars.add(wavefrontStartName);
		vars.add(wavefrontEndName);
		vars.add(wavefrontTimeName);
		vars.add(totalwavefrontName);
		vars.add(subwavefrontName);
		
		return vars; 
	}
	public List<String> getPrivateSpecilVariablesForWavefront(){
		List<String> vars = new LinkedList<String>();
		
		vars.add(curPassNumber);
		vars.add(tempPassNumber);
		vars.add(divVariableName);
		String cur_tile_var = curTileIndexPrefix + total_dim;
		vars.add(cur_tile_var);
		
		return vars;
	}
}
