package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility.ConstructComputeFunction;

public class DTilerBufferingUtility{
	public static final PolyhedralIRUserFactory _IRfact = PolyhedralIRUserFactory.eINSTANCE;
	
	public static class FullTileBufferingInformation{
		public final List<EquationAsStatement> stmts;
		public final int tileDims;
		public final int level;
		
		public TiledCLoop mainLoop;
		public SIMDFunction function;
		public VariableInitialization initVariableBody;
		
		//Buffering information for the vectorization
		protected Map<VariableDeclaration, List<List<Integer>>> var_deps_map;
		protected Map<VariableDeclaration, List<List<Integer>>> var_range_map;
		protected Map<VariableDeclaration, List<List<Integer>>> var_unrolled_deps_map;
		protected Map<VariableDeclaration, List<List<Integer>>> var_unrolled_range_map;
		protected Map<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_range_map;
		protected Map<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_aligned_range_map;
		protected Map<VariableDeclaration, Map<Integer, Integer>> var_datastream_ndeps_map;
		protected Map<VariableDeclaration, Map<Integer, Integer>> var_datastream_rotatable_map;
		protected Map<VariableDeclaration, Map<Integer, Integer>> var_datastream_rotateval_map;
		protected Map<VariableDeclaration, Map<Integer, Integer>> var_datastream_register_aligne_value_map;
		
		protected Map<VariableDeclaration, List<Integer>> var_halo_map;
		protected Map<VariableDeclaration, List<Integer>> var_offset_map;	//record the starting offset for variable load, used for vectorization, by default the offset is the same as halo
		protected List<VariableDeclaration> bufferVars;
		protected List<VariableDeclaration> scalarVars;
		protected Map<String, VariableDeclaration> buffername_var_map;
		protected List<Integer> tileOffsets;
		protected List<String> tileSizes;
		protected List<String> tileIndex;
		
		protected boolean pointer;
		protected Map<String, VariableDeclaration> pointer_var_map;
		
		protected boolean padded;
		protected Map<VariableDeclaration, List<String>> var_padded_map;
		protected boolean isAligned;	//padded array so that the loads and store can be both aligned 
		protected Map<VariableDeclaration, List<Integer>> var_frontPadding_map;
		
		public FullTileBufferingInformation(List<EquationAsStatement> _fullTileStmts, int _tileDims, int _level){
			stmts = _fullTileStmts;
			tileDims = _tileDims;
			level = _level;
			padded = false;
			isAligned = false;
			pointer = false;
			
			//init the code information
			mainLoop = (TiledCLoop)stmts.get(0).getContainerLoop();
			function = (SIMDFunction)mainLoop.getFunction();
			
			bufferVars = new LinkedList<VariableDeclaration>();
			for(EquationAsStatement stmt: stmts){
				if(!bufferVars.contains(stmt.getVarDecl())){
					bufferVars.add(stmt.getVarDecl());
				}
			}
			
			buffername_var_map = new HashMap<String, VariableDeclaration>();
			
			var_deps_map = DTilerProcessUtility.UniformDependenceExtraction.extractDependeceFromStmts(stmts);
			//post processing for getting rid of the scalar variables
			scalarVars = new LinkedList<VariableDeclaration>();
			for(Entry<VariableDeclaration, List<List<Integer>>> map_entry: var_deps_map.entrySet()){
				VariableDeclaration var = map_entry.getKey();
				CodeGenVariable cvar = function.getCodeunit().findCGVariable(var.getName());
				if(cvar.getDomain().getNIndices() == 0)	{	//scalar variable
					scalarVars.add(var);
				}
			}
			//remove the scalar variable entry from the variable dependence entry
			for(VariableDeclaration var: scalarVars)	var_deps_map.remove(var);
			
//			for(Entry<VariableDeclaration, List<List<Integer>>> map_entry: var_deps_map.entrySet()){
//				System.out.println("dependence for variable " + map_entry.getKey().getName());
//				for(List<Integer> dep: map_entry.getValue()){
//					System.out.println(dep);
//				}
//			}
	
			//extract the dependence range for each variable
			var_range_map = new HashMap<VariableDeclaration, List<List<Integer>>>();
			var_halo_map = new HashMap<VariableDeclaration, List<Integer>>();
			var_offset_map = new HashMap<VariableDeclaration, List<Integer>>();
			for(Map.Entry<VariableDeclaration, List<List<Integer>>> deps_entry : var_deps_map.entrySet()){
				VariableDeclaration var = deps_entry.getKey();
				List<List<Integer>> ranges = DTilerProcessUtility.getRanges(var.getDomain().getNIndices(), deps_entry.getValue());
				var_range_map.put(deps_entry.getKey(), ranges);
				List<Integer> region = DTilerProcessUtility.getRegionSize(ranges);
				var_halo_map.put(deps_entry.getKey(), region);
				List<Integer> var_offset = new LinkedList<Integer>();
				var_offset.addAll(region);
				var_offset_map.put(deps_entry.getKey(), var_offset);
			}
			
			tileOffsets = DTilerProcessUtility.getFullTileOffsets(bufferVars, var_halo_map);
			
			//init the tile size name and tile index names
			tileSizes = new LinkedList<String>();
			tileIndex = new LinkedList<String>();
			for(int i = 1; i <= tileDims; i++){
				tileSizes.add(CodeGenConstantsForTiling.getTileSizeName(i, level));
				tileIndex.add(CodeGenConstantsForTiling.getTileIndexName(i, level));
			}
		}
	}
	
	public static String getBufferAllocationFunctionName(String varName){
		return "MemoryAllocationForTempBuffer" + varName;
	}
	
	public static String getBufferFreeFunctionName(VariableDeclaration var){
		return "MemoryFreeForTempBuffer" + var.getName();
	}
	
	public static String getBufferStatementName(int stmtCount){
		return "SB"+stmtCount;
	}
	
	public static VariableDeclaration createTempBufferVar(VariableDeclaration var, int n, List<String> tileSizes, List<Integer> offsets){
		Domain bufferDom = constructTempBufferDomain(var, tileSizes, offsets);
		
		return createTempBufferVar(var, n, bufferDom);
	}
	
	public static VariableDeclaration createTempBufferVar(VariableDeclaration var, int n, Domain bufferDom){
		String bufferName = getTempBufferName(var, n);
		
		return createTempBufferVar(var, bufferName, bufferDom);
	}
	
	public static VariableDeclaration createTempBufferVar(VariableDeclaration var, String bufferName, Domain bufferDom){
		VariableDeclaration temp_var = PolyhedralIRUserFactory.eINSTANCE.createVariableDeclaration(bufferName, 
				EcoreUtil.copy(var.getType()), bufferDom);
		
		return temp_var;
	}
	
	public static VariableDeclaration createPaddedTempBufferVar(VariableDeclaration var, int n, List<String> tileSizes, List<Integer> offsets, List<String> padded){
		String bufferName = getTempBufferName(var, n);
		Domain bufferDom = constructTempBufferDomain(var, tileSizes, offsets, padded);
		
		return createTempBufferVar(var, bufferName, bufferDom);
	}
	
	/**
	 * Return the name for the nth temporary buffer for variable var
	 * @param var
	 * @param n
	 * @return
	 */
	public static String getTempBufferName(VariableDeclaration var, int n){
		String bufferName = "temp_" + var.getName() + "_" + n;
		
		return bufferName;
	}
	
	/**
	 * Return the name of the swaping buffer name for var
	 * @param var
	 * @return
	 */
	public static String getTempSwapBufferName(VariableDeclaration var){
		return "swap_temp_" + var.getName();
	}
	
	public static String getBookKeepingVariableNamePrefix(VariableDeclaration var){
		return "row_" + var.getName();
	}

	public static String getBookKeepingRowName(int dim, List<Integer> dep_vec, List<Integer> offset, String name_prefix){
		String rowName = name_prefix;
		
		for(int i = 0; i < dim; i++){
			rowName = rowName + "_" + (-dep_vec.get(i) + offset.get(i));
		}
		
		return rowName;
	}
	
	public static void getBookKeepingRowName(int k, int dim, List<List<Integer>> ranges, List<Integer> offset, String name_prefix, List<String> rowNames){
		if(k == dim){
			rowNames.add(name_prefix);
			return;
		}
		
		for(int i= -ranges.get(k).get(1); i <= -ranges.get(k).get(0); i++){
			String new_prefix = name_prefix + "_" + (i + offset.get(k));
			getBookKeepingRowName(k + 1, dim, ranges, offset, new_prefix, rowNames);
		}
		return;
		
	}
	
	
	/**
	 * Construct the domain for the temporary buffer for variable var, project out the outer most time dimension
	 * {c2, c3, ...cd| 0<= c2 < ts2 + offset1, 0<= c3 < ts3 + offset2, ..., 0 <= cd < tsd + offsetd}
	 * @param var
	 * @param tileSizes
	 * @param offsets: the ghost region size
	 * @return
	 */
	public static Domain constructTempBufferDomain(VariableDeclaration var, List<String> tileSizes, List<Integer> offsets){
		//construct the full list of parameter names
		List<String> params = new LinkedList<String>();
		List<String> extraParams = new LinkedList<String>();
		for(String name: var.getDomain().getParamNames()){
			if(!tileSizes.contains(name)){
				extraParams.add(name);
			}
		}
		params.addAll(extraParams);
		params.addAll(tileSizes);
		
		//construct the full list of index names
		int ndims = var.getDomain().getNIndices();
		List<String> indices = new LinkedList<String>();
		indices.addAll(var.getDomain().getIndexNames().subList(1, ndims));
		
		//construct an ndims-dimensional universal domain
		Domain bufferDom = PolyhedralIRUtility.parseDomainFromString(params, indices, new ArrayList<String>());
		List<Variable> tileSizeVars = bufferDom.getParams().subList(bufferDom.getNParams() - ndims, bufferDom.getNParams());
		List<Variable> indexVars = bufferDom.getIndices();
		//add the constraints inside
		for(int i = 1; i < ndims; i++){
			//ci< ts + offset
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i-1)), 
					DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), offsets.get(i)),
					ComparisonOperator.LT));
			
			//0 <= ci
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(0), 
					IntExpressionBuilder.affine(indexVars.get(i-1)), 
					ComparisonOperator.LE));
			
			//tsi >= offset
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
					IntExpressionBuilder.constant(offsets.get(i)), 
					ComparisonOperator.GE));
		}
		//add constraint for tile size 0
		bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(0)), 
				IntExpressionBuilder.constant(offsets.get(0)), 
				ComparisonOperator.GE));
		
		return bufferDom;
	}
	
	/**
	 * Construct the domain for the temporary buffer for variable var
	 * @param var
	 * @param tileSizes
	 * @param offsets
	 * @param padded_dims: the dimensions that is padded
	 * @return
	 */
	public static Domain constructTempBufferDomain(VariableDeclaration var, List<String> tileSizes, List<Integer> offsets, List<String> padded_params){
		int ndims = var.getDomain().getNIndices();
		//construct the full parameter names
		List<String> params = new LinkedList<String>();
		List<String> extraParams = new LinkedList<String>();
		for(String name: var.getDomain().getParamNames()){
			if(!tileSizes.contains(name)){
				extraParams.add(name);
			}
		}
		params.addAll(extraParams);
		params.addAll(padded_params);
		params.addAll(tileSizes);

		//construct the full list of index names
		List<String> indices = new LinkedList<String>();
		indices.addAll(var.getDomain().getIndexNames().subList(1, ndims));
		
		//construct an ndims-dimensional universal domain
		Domain bufferDom = PolyhedralIRUtility.parseDomainFromString(params, indices, new ArrayList<String>());
		List<Variable> tileSizeVars = bufferDom.getParams().subList(bufferDom.getNParams() - ndims, bufferDom.getNParams());
		List<Variable> paddedParamVars = bufferDom.getParams().subList(bufferDom.getNParams() - 2*ndims + 1, bufferDom.getNParams() - ndims);
		List<Variable> indexVars = bufferDom.getIndices();
		
		//add ts0 >= 1
		bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(0)), 
				IntExpressionBuilder.constant(1), 
				ComparisonOperator.GE));
		//add the domain constraints
		for(int i = 1; i < ndims; i++){
			//ci < padded parameter
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i-1)), 
					IntExpressionBuilder.affine(paddedParamVars.get(i-1)), 
					ComparisonOperator.LT));
			
			//0 <= ci
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(0), 
					IntExpressionBuilder.affine(indexVars.get(i-1)), 
					ComparisonOperator.LE));
			
			//tsi >= offset
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
					IntExpressionBuilder.constant(offsets.get(i)), 
					ComparisonOperator.GE));
			
			//padded_params_{i-1} >= offset_{i}
			bufferDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(paddedParamVars.get(i-1)), 
					IntExpressionBuilder.constant(offsets.get(i)), 
					ComparisonOperator.GE));
		}
		return bufferDom;
	}
	
	/**
	 * Get the variable domain with the outer dim dimensions projected out
	 * @param var
	 * @param k
	 * @return
	 */
	public static Domain getProjectedVariableDomain(VariableDeclaration var, int k){
		Domain oriDom = var.getDomain().copy();
		//construct the projection function
		List<AffineExpression> exprs = new LinkedList<AffineExpression>();
		List<Variable> index_vars = oriDom.getIndices();
		for(int i = k; i < index_vars.size(); i++){
			exprs.add(IntExpressionBuilder.affine(index_vars.get(i)));
		}
		AffineFunction function = _IRfact.createAffineFunction(oriDom.getParams(), index_vars, exprs);
		return oriDom.image(function);
	}
	
	public static List<String> getBufferDomainIndexList(List<String> ori_indices, int tileDims){
		List<String> indices = new LinkedList<String>();
		
		//padded the index list to match the number of tiled dimensions
		List<String> paddedIndices = new LinkedList<String>();
		for(int i = 0; i < tileDims - ori_indices.size(); i++){
			paddedIndices.add("p"+i);
		}
		paddedIndices.addAll(ori_indices);
		
		indices.add("c"+0);	//the first constant dimension
		indices.add(paddedIndices.get(0));
		indices.add("c"+2);	//the second constant dimension
		indices.addAll(paddedIndices.subList(1, paddedIndices.size()));
		
		return indices;
	}
	
	public static List<String> getBufferStmtParameterList(ParameterDomain oriParam, List<String> tileIndex, List<String> tileSizes){
		List<String> params = new LinkedList<String>();
		List<String> program_params = new LinkedList<String>();
		
		for(String param: oriParam.getParamNames()){
			if((!tileIndex.contains(param)) &&(!tileSizes.contains(param))){
				program_params.add(param);
			}
		}
		
		params.addAll(program_params);
		params.addAll(tileSizes);	//add tile size 
		params.addAll(tileIndex); 	//add tile index first
		
		return params;
	}
	

	public static Domain createBufferStmtStartDomain(List<String> params, List<String> indices, List<Integer> offsets, int tileDims){
		Domain domain = PolyhedralIRUtility.parseDomainFromString(params, indices, new ArrayList<String>());
		
		List<Variable> tileSizeVars = domain.getParams().subList(params.size() - 2*tileDims, params.size() - tileDims);
		//add constraints for tile sizes
		for(int i = 0; i < tileDims; i++){
			//add tsi >= offset_i
			domain.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
					IntExpressionBuilder.constant(offsets.get(i)), ComparisonOperator.GT));
		}
		return domain;
	}

	
	/**
	 * Extends the ConstructComputeFunction class to deal with compute functions that are performed on the temporary buffer instead of original data 
	 * @author zouyun
	 *
	 */
	public static class ConstructBufferedComputeFunction extends ConstructComputeFunction{
		protected FullTileBufferingInformation bufferInfo;
	
		public ConstructBufferedComputeFunction(FullTileBufferingInformation _bufferInfo, String _stmtGroup, Map<String, VRegister> _ori_reg_map, VType _vtype, int[] _unrollFactors){
			super(_bufferInfo.stmts,  _stmtGroup, _bufferInfo.scalarVars, _ori_reg_map, _bufferInfo.var_unrolled_deps_map, _bufferInfo.var_offset_map, _vtype, 
										_unrollFactors, new DTilerVRegNameConstruction(_bufferInfo.bufferVars, _bufferInfo.buffername_var_map));
			bufferInfo = _bufferInfo;
		}
		
		//entrance for getting the function for the main computation body
		public static SIMDFunction getBufferedComputeFunction(FullTileBufferingInformation _bufferInfo, String _stmtGroup, Map<String, VRegister> _ori_reg_map, List<String> input_regs, VType _vtype, int[] _unrollFactors){
			//construt the function 
			String func_name = "Compute" + _stmtGroup;
			SIMDFunction function = PolyIRCGSIMDUserFactory.INSTANCE.createSIMDFunction(func_name, "void");
			
			//add variable index as parameters, all the statements share the same indeices as the first statement
			List<String> indices = _bufferInfo.stmts.get(0).getAccessFunction().getIndexNames();
			for(int i = 0; i < indices.size(); i++){
				function.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(indices.get(i), "int"));
			}
			
			//add the padded parameters
			if(_bufferInfo.padded){
				for(Map.Entry<VariableDeclaration, List<String>> var_padded_params_entry: _bufferInfo.var_padded_map.entrySet()){
					for(String padded_param: var_padded_params_entry.getValue()){
						function.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(padded_param, "int"));
					}
				}
			}
			//add the scalar variable
			for(VariableDeclaration var: _bufferInfo.scalarVars){
				function.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(var.getName(), var.getType().getCName()));
			}
			//add input arrays
			for(EquationAsStatement stmt: _bufferInfo.stmts){	//add the buffered variable
				String temp_buffer_bame = getTempBufferName(stmt.getVarDecl(), 0);
				CodeGenVariable cgVar = _bufferInfo.function.getCodeunit().findCGVariable(temp_buffer_bame);
				function.getInputs().add(cgVar);
			}
	
			//add the input registers
			for(String reg: input_regs)
				function.getInputsimdRegs().add(_ori_reg_map.get(reg));
					
			ConstructBufferedComputeFunction constructor = new ConstructBufferedComputeFunction(_bufferInfo, _stmtGroup,_ori_reg_map, _vtype, _unrollFactors);
			constructor.generateIntraRegs();
			constructor.generateComputeStatements();
					
			//add the local registers for function
			function.getLocalsimdRegs().addAll(constructor.intraRegs);
					
			//create local register initialization body
			VRegisterInitialization regInit = PolyIRCGSIMDUserFactory.INSTANCE.createVRegisterInitialization(function);
			function.getBodies().add(regInit);
					
			//construct the main Loop 
			CLoop loop = PolyIRCGUserFactory.INSTANCE.createCLoop(constructor.stmtDom.toParameterDomain(), 0);	
			//add the statements
			loop.getStatements().addAll(constructor.stmts);
					
			function.getBodies().add(loop);
					
			return function;
		}
		
		@Override
		protected BasicMemoryAddress getStoreVarAccess(EquationAsStatement stmt, int []iter){
			if(bufferInfo.bufferVars.contains(stmt.getVarDecl())){	//a buffered variable
				String temp_buffer_name = getTempBufferName(stmt.getVarDecl(), 0);
				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
				CodeGenVariable temp_buffer_codegen = bufferInfo.function.getCodeunit().findCGVariable(temp_buffer_name);
				int[] temp_buffer_iter = new int[iter.length - 1];
				for(int i = 1; i < iter.length;  i++)	temp_buffer_iter[i-1] = iter[i];
				AffineFunction access = PolyhedralIRUtility.createUniformFunction(temp_buffer_var.getDomain(), temp_buffer_iter);
				//AffineFunction access = PolyhedralIRUtility.createIdentityFunction(temp_buffer_var.getDomain());
				
				
				return PolyIRCGSIMDUserFactory.INSTANCE.createBasicMemoryAccess(temp_buffer_codegen, access, false);
			}else{
				AffineFunction access = PolyhedralIRUtility.createUniformFunction(stmt.getVarDecl().getDomain(), iter);
				return PolyIRCGSIMDUserFactory.INSTANCE.createBasicMemoryAccess(stmt.getVariable(), stmt.getAccessFunction().copy().compose(access), false);
			}
		}
	}
}