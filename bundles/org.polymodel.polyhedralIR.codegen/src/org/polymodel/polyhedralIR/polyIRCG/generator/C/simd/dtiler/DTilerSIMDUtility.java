package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility.BasicVariableData;

public class DTilerSIMDUtility{
	public static final PolyhedralIRUserFactory _IRfact = PolyhedralIRUserFactory.eINSTANCE;
	public static final PolyIRCGUserFactory _cgfact = PolyIRCGUserFactory.INSTANCE;
	
	public static class BookKeepingVariableInitStmtConstructor{
		public List<Statement> initStmts;
		public int stmtCount;	//the start number for vectorized statement
		public String stmtGroup;

		//configuration local variables 
		protected final int dims;	//number of dimensions of the compuation
		protected final BasicVariableData varData;
		protected final Domain stmtDom;	//the domain for the load statement, all the loads must share the same statement domain
		protected final Map<String, VariableDeclaration> row_variables;
		
		public BookKeepingVariableInitStmtConstructor(BasicVariableData _varData, Domain _stmtDom, int _stmtCount, String _stmtGroup, Map<String, VariableDeclaration> _row_variables){
			varData = _varData;
			dims = _varData.var.getDomain().getNIndices();
			stmtDom = _stmtDom;
			row_variables = _row_variables;
			
			//initialization
			stmtCount = _stmtCount;
			stmtGroup = _stmtGroup;
			initStmts = new LinkedList<Statement>();
		}
		
		public void generate(){
			int[] vec = new int[dims];
			String row_name_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(varData.var);
			getInitStmtAtDimk(0, vec, row_name_prefix);
		}
		
		public Statement generateInitStmtWithDepVec(List<Integer> dep_vec){
			//construction the dependence function for memory access
			int[] vec = new int[dims];
			for(int i = 0; i < dims; i++)	vec[i] = -dep_vec.get(i);
			AffineFunction dep = PolyhedralIRUtility.createUniformFunction(varData.var.getDomain(), vec);
			
			String row_name_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(varData.var);
			String row_name = DTilerBufferingUtility.getBookKeepingRowName(dims - 1, dep_vec, varData.offset, row_name_prefix);
			
			return constructInitStmtWithDepFunction(dep, row_name);
		}
		
		private void getInitStmtAtDimk(int k, int[] vec, String row_name_prefix){
			if(k == dims - 1){	//the base case, start constructing the load instruction
				vec[dims - 1] = -varData.ranges.get(k).get(1);
				AffineFunction dep = PolyhedralIRUtility.createUniformFunction(varData.var.getDomain(), vec);
				
				initStmts.add(constructInitStmtWithDepFunction(dep, row_name_prefix));
				return;
			}
			
			for(int i= -varData.ranges.get(k).get(1); i <= -varData.ranges.get(k).get(0); i++){
				vec[k] = i;
				String new_prefix = row_name_prefix + "_" + (i + varData.offset.get(k));
				getInitStmtAtDimk(k + 1, vec, new_prefix);
			}
			return;
		}
		
		private Statement constructInitStmtWithDepFunction(AffineFunction dep, String row_name){
			//construct the access function 
			AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(varData.var.getDomain());
			AffineFunction access = varData.mem_access.copy();
			access = access.compose(identity);
			access = access.compose(dep);
			
			
			List<String> access_strs = new LinkedList<String>();
			for(AffineExpression access_expr: access.getExpressions()){
				access_strs.add(access_expr.toString(OUTPUT_FORMAT.C));
			}
			
			String init_stmt_str = row_name + "=";
			init_stmt_str += "&" + varData.var.getName() + "(" + CodeGenUtility.toStringList(access_strs, ",") + ")";
			Statement initStmt = _cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), init_stmt_str);  
		
			stmtCount++;
			
			return initStmt;
		}
		
	}
	
	public static int encodeDep(List<Integer> dep, List<Integer> offsets){
		int val = 0;
		for(int i = dep.size() - 1; i >= 0; i--){
			val = val*100 + (-dep.get(i) + offsets.get(i));
		}
		return val;
	}
	
	public static List<Integer> decodeDep(int dep_val, List<Integer> offsets){
		List<Integer> dep = new LinkedList<Integer>();
		int ndim = offsets.size();
		int temp_val = dep_val;
		int count = 0;
		while(temp_val != 0){
			int cur_val = temp_val%100;
			temp_val /= 100;
			cur_val = -cur_val + offsets.get(count);
			dep.add(cur_val);
			count++;
		}
		
		for(int i = count; i < ndim; i++)	dep.add(offsets.get(i));
		
		return dep;
	}
	
//	/**
//	 * Separate the given list of dependence vector into reusable and non-rotatable dependence 
//	 * A dependence vector is non-rotatable if and only if their is only one dependence along the direction
//	 * A direction of a dependence vector is defined as the projection of the vector along the outer dimensions
//	 * @param deps
//	 * @return A list of rotatable dependence in list_{0}, and a list of non-rotatable dependence in list_{1}
//	 */
//	public static List<List<List<Integer>>> separateDepsWithRotatibility(List<List<Integer>> deps, List<Integer> offsets){
//		List<List<List<Integer>>> separated_deps = new LinkedList<List<List<Integer>>>();
//		
//		Map<Integer,Set<Integer>> dir_deps_map = new HashMap<Integer, Set<Integer>>();
//		for(List<Integer> dep: deps){
//			int dep_dir_val = encodeDep(dep.subList(0, dep.size() - 1), offsets);
//			int dep_val = encodeDep(dep, offsets);
//			if(dir_deps_map.get(dep_dir_val) == null){	//the dep direction does not exist
//				Set<Integer> dir_deps = new HashSet<Integer>();
//				dir_deps.add(dep_val);
//				dir_deps_map.put(dep_dir_val, dir_deps);
//			}else {
//				if(!dir_deps_map.get(dep_dir_val).contains(dep_val)){
//					dir_deps_map.get(dep_dir_val).add(dep_val);
//				}
//			}
//		}
//		
//		List<List<Integer>> rotatable_deps = new LinkedList<List<Integer>>();
//		List<List<Integer>> non_rotatable_deps = new LinkedList<List<Integer>>();
//		for(Entry<Integer, Set<Integer>> dir_deps_entry: dir_deps_map.entrySet()){
//			if(dir_deps_entry.getValue().size() > 1){	//rotatble
//				for(Integer dep_val: dir_deps_entry.getValue()){
//					rotatable_deps.add(decodeDep(dep_val, offsets));
//				}
//			}else{
//				for(Integer dep_val: dir_deps_entry.getValue()){
//					non_rotatable_deps.add(decodeDep(dep_val, offsets));
//				}
//			}
//		}
//		separated_deps.add(rotatable_deps);
//		separated_deps.add(non_rotatable_deps);
//		
//		return separated_deps;
//	}
	
	public static Map<Integer, Set<Integer>> encodeDataStreamDeps(List<List<Integer>> deps, List<Integer> offsets){
		Map<Integer,Set<Integer>> dir_deps_map = new HashMap<Integer, Set<Integer>>();
		for(List<Integer> dep: deps){
			int dep_dir_val = encodeDep(dep.subList(0, dep.size() - 1), offsets);
			int dep_val = encodeDep(dep, offsets);
			if(dir_deps_map.get(dep_dir_val) == null){	//the dep direction does not exist
				Set<Integer> dir_deps = new HashSet<Integer>();
				dir_deps.add(dep_val);
				dir_deps_map.put(dep_dir_val, dir_deps);
			}else {
				if(!dir_deps_map.get(dep_dir_val).contains(dep_val)){
					dir_deps_map.get(dep_dir_val).add(dep_val);
				}
			}
		}
		
		return dir_deps_map;
	}
	
	/**
	 * Extract the set of data stream that is touched by the uniform accesses
	 * @param deps
	 * @return A map of data stream and its range
	 */
	public static Map<Integer, List<Integer>> extractDataStream(List<List<Integer>> deps, List<Integer> offsets){
		Map<Integer, List<Integer>> data_streams = new TreeMap<Integer, List<Integer>>();
		
		Map<Integer, Set<Integer>> dir_deps_map = encodeDataStreamDeps(deps, offsets);
//		Map<Integer,Set<Integer>> dir_deps_map = new HashMap<Integer, Set<Integer>>();
//		for(List<Integer> dep: deps){
//			int dep_dir_val = encodeDep(dep.subList(0, dep.size() - 1), offsets);
//			int dep_val = encodeDep(dep, offsets);
//			if(dir_deps_map.get(dep_dir_val) == null){	//the dep direction does not exist
//				Set<Integer> dir_deps = new HashSet<Integer>();
//				dir_deps.add(dep_val);
//				dir_deps_map.put(dep_dir_val, dir_deps);
//			}else {
//				if(!dir_deps_map.get(dep_dir_val).contains(dep_val)){
//					dir_deps_map.get(dep_dir_val).add(dep_val);
//				}
//			}
//		}
		
		for(Entry<Integer, Set<Integer>> dir_deps_entry: dir_deps_map.entrySet()){
			int min=-999999, max=-999999;
			for(Integer dep_val: dir_deps_entry.getValue()){
				List<Integer> cur_dep = decodeDep(dep_val, offsets);
				if(min == -999999){
					min = max = cur_dep.get(cur_dep.size() - 1);
				}else {
					int val = cur_dep.get(cur_dep.size() - 1);
					if(val > max)	max = val;
					if(val < min)	min = val;
				}
			}
			List<Integer> data_stream_range = new LinkedList<Integer>();
			data_stream_range.add(min);
			data_stream_range.add(max);
			data_streams.put(dir_deps_entry.getKey(), data_stream_range);
		}
	
		return data_streams;
	}
	
	/**
	 * Extract the number of distinct Dependences occurred in each data stream. This information is used in the naive vectorization strategy
	 * @param deps
	 * @param offsets
	 * @return
	 */
	public static Map<Integer, Integer> extractDistinctDepNums(List<List<Integer>> deps, List<Integer> offsets){
		Map<Integer, Integer> stream_ndeps_map = new HashMap<Integer, Integer>();
		
		Map<Integer, Set<Integer>> dir_deps_map = encodeDataStreamDeps(deps, offsets);
//		Map<Integer,Set<Integer>> dir_deps_map = new HashMap<Integer, Set<Integer>>();
//		for(List<Integer> dep: deps){
//			int dep_dir_val = encodeDep(dep.subList(0, dep.size() - 1), offsets);
//			int dep_val = encodeDep(dep, offsets);
//			if(dir_deps_map.get(dep_dir_val) == null){	//the dep direction does not exist
//				Set<Integer> dir_deps = new HashSet<Integer>();
//				dir_deps.add(dep_val);
//				dir_deps_map.put(dep_dir_val, dir_deps);
//			}else {
//				if(!dir_deps_map.get(dep_dir_val).contains(dep_val)){
//					dir_deps_map.get(dep_dir_val).add(dep_val);
//				}
//			}
//		}
		
		for(Entry<Integer, Set<Integer>> dir_deps_entry: dir_deps_map.entrySet()){
			stream_ndeps_map.put(dir_deps_entry.getKey(), dir_deps_entry.getValue().size());
		}
		
		return stream_ndeps_map;
	}
	
}