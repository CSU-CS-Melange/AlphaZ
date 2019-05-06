package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.LinkedList;
import java.util.List;

public class CodeGenConstantsForTiling {


	public static final String tileIndexPrefix = "ti";
	public static final String tileSizePrefix = "ts";
	
	public static final String passIndexPrefix = "pi";
	public static final String passSizePrefix = "ps";

	public static final String wavefrontTimeName = "time";
	public static final String wavefrontStartName = "start";
	public static final String wavefrontEndName = "end";
	
	public static String getTileIndexName(int dim) {
		return getTileIndexName(new LinkedList<Integer>(), dim, 1);
	}
	public static String getTileSizeName(int dim) {
		return getTileSizeName(new LinkedList<Integer>(), dim,1);
	}
	
	public static String getTileIndexName(int dim, int level) {
		return getTileIndexName(new LinkedList<Integer>(), dim, level);
	}
	public static String getTileSizeName(int dim, int level) {
		return getTileSizeName(new LinkedList<Integer>(), dim, level);
	}
	
	public static String getTileIndexName(List<Integer> orderingPrefix, int dim, int level){
		String indexName = tileIndexPrefix+dim+"_l"+level;
		if(orderingPrefix.size() > 0){
			indexName += "o_";
			for(int i = 0; i < orderingPrefix.size(); i++){
				indexName += orderingPrefix.get(i);
			}
		}
		
		return indexName;
	}
	
	public static String getTileSizeName(List<Integer> orderingPrefix, int dim, int level){
		String sizeName = tileSizePrefix + dim + "_l" + level;
		if(orderingPrefix.size() > 0){
			sizeName += "o_";
			for(int i = 0; i < orderingPrefix.size(); i++){
				sizeName += orderingPrefix.get(i);
			}
		}
		
		return sizeName;
	}
	
	public static String getPassIndexName(int dim, int level) {
		return passIndexPrefix + dim + "_l" + level;
	}
	
	public static String getPassSizeName(int dim, int level) {
		return passSizePrefix + dim + "_l" + level;
	}
}
