package org.polymodel.scop.dtiler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.ScopRoot;

public class OptimizationOptions {
	
	public static boolean DEBUG = true;

	//loop unrolling-and-jam configuration
	public boolean unrollAndJam;
	public boolean noPeeling;	//whether peeling is involved in any dimension
	private List<LoopUnrollOptions> unrollLoops;
	
	//loop vectorization configuration	#vectorization is only along the innermost dim
	public boolean vectorization;
	//private int vecDim;
	private String dataType;		//int, float or double
	private String simdSet;		//SSE, SSE2, AVX, AVX2
	private int strategy;
	private Map<String, EList<String>> simd_stmt_map;	//the map from the original statement to the SIMD statements
	
	//configuration for register reuse
	public boolean registerReuse;

	//temporary buffering optimization
	public boolean buffering = false;
	public ScopRoot optimizedPointLoop = null; 
	//statement selected to for the optimized point loop
	public int numberOfTiledDimensions = -1;
	public List<List<String>> pointLoopStmts = null;
	
	public List<String> specialVariables;
	
	//prefix for peelingl loop bound variables
	public static String lbPrefix = "lb";
	public static String ubPrefix = "ub";
	public static String midBoundPrefix = "mid";
	
	//Map to keep track of created variables
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	/////////////////Constructors//////////////////////////
	public OptimizationOptions(){
		//by default set all
		unrollAndJam = false;
		vectorization = false;
		registerReuse = false;
		buffering = false;
		specialVariables = new LinkedList<String>();
	}
	
	public OptimizationOptions(boolean _unroll_and_jam, boolean _vetorization, boolean _reuse, boolean _buffering){
		unrollAndJam = _unroll_and_jam;
		vectorization = _vetorization;
		registerReuse = _reuse;
		buffering = _buffering;
		specialVariables = new LinkedList<String>();
		
		if(unrollAndJam){
			unrollLoops = new LinkedList<LoopUnrollOptions>();
		}
	}
	
	//////////////////////Utility functions for loop unroll options
	public LoopUnrollOptions createLoopUnrollOptions(int _dim, int _factor){
		return new LoopUnrollOptions(_dim, _factor);
	}
	
	public LoopUnrollOptions createLoopUnrollOptions(int _dim, int _factor, boolean _noPeeling){
		return new LoopUnrollOptions(_dim, _factor, _noPeeling);
	}
	
	public void addLoopUnrollOptionsList(List<LoopUnrollOptions> options){
		unrollLoops.addAll(options);
	}
	
	public void setLoopUnrollOptions(List<LoopUnrollOptions> options){
		unrollLoops = options;
	}
	
	public void addLoopUnrollOptions(int _dim, int _factor){
		if(unrollLoops == null){
			unrollLoops = new LinkedList<LoopUnrollOptions>();
		}
		unrollLoops.add(createLoopUnrollOptions(_dim, _factor));
	}
	
	public void addLoopUnrollOptions(int _dim, int _factor, boolean _noPeeling){
		if(unrollLoops == null){
			unrollLoops = new LinkedList<LoopUnrollOptions>();
		}
		unrollLoops.add(createLoopUnrollOptions(_dim, _factor, _noPeeling));
	}
	
	public void addLoopUnrollOptions(LoopUnrollOptions options){
		if(unrollLoops == null){
			unrollLoops = new LinkedList<LoopUnrollOptions>();
		}
		unrollLoops.add(options);
	}
	
	public List<LoopUnrollOptions> getUnrollOptions(){
		return unrollLoops;
	}
	
	public LoopUnrollOptions getInnerMostUnrollOptions(){
		int nitems = unrollLoops.size();
		return unrollLoops.get(nitems-1);
	}
	
	//////////////////////Untility functions for Vectorizations
//	public void setVecDim(int _dim){
//		vecDim = _dim;
//	}
	public void setDataType(String _dataType){
		dataType = _dataType;
	}
	
	public void setSIMDSet(String _simdSet){
		simdSet = _simdSet;
	}
	
	public void setVecStrategy(int _strategy){
		strategy = _strategy;
	}
	
	public void setSIMDStmtMap(Map<String, EList<String>> _simd_stmt_map){
		simd_stmt_map = _simd_stmt_map;
	}
	
//	public int getVecDim(){
//		return vecDim;
//	}
	
	public String getVecDataType(){
		return dataType;
	}
	
	public String getSIMDIns(){
		return simdSet;
	}
	
	public int getStrategy(){
		return strategy;
	}
	
	public Map<String, EList<String>> getSimdStmtMap(){
		return simd_stmt_map;
	}
	
	public int getNElementsPerVec(){
		int length = 4;
		if(simdSet == "SSE"){
			if(dataType == "double"){
				length = 2;
			}else if(dataType == "float"){
				length = 4;
			}else if(dataType == "int"){
				length = 4;
			}
		}else{
			if(dataType == "double"){
				length = 4;
			}else if(dataType == "float"){
				length = 8;
			}else if(dataType == "int") {
				length = 8;
			}
		}
		
		return length;
	}
	/////////////////Functions for getting special bound variable names
	public Variable getPeelingLB(int dim){
		//construt the variable for the lower bound at dim 
		String lb_name = lbPrefix + "_d" + dim;
		return getVariable(lb_name);
	}
	
	public Variable getPeelingUB(int dim){
		String ub_name = ubPrefix + "_d" + dim;
		return getVariable(ub_name);
	}
	
	public Variable getPeelingMidBound(int dim){
		String mid_name = midBoundPrefix + "_d" + dim;
		return getVariable(mid_name);
	}
	
	public List<String> getAdditionalLoopBoundVariablesTosDeclare(){
		List<String> names = new LinkedList<String>();
		
		for(Map.Entry<String, Variable> variable: variables.entrySet()){
			names.add(variable.getKey());
		}
		
		return names;
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
	
	
	public class LoopUnrollOptions{
		public int dim;
		public int factor;
		public boolean noPeeling;	//Default, simple unroll, no peeling
		
		public LoopUnrollOptions(int _dim, int _factor){
			dim = _dim;
			factor = _factor;
			noPeeling = true;
		}
		
		public LoopUnrollOptions(int _dim, int _factor, boolean _noPeeling){
			dim = _dim;
			factor = _factor;
			noPeeling = _noPeeling;
		}
	}
}