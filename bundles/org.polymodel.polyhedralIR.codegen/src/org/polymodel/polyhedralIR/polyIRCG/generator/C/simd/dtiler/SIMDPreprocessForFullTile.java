package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDCodeGenConstant;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDInstructionUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility.BasicVariableData;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.SIMDStmtConversionUtility.ConstructLoadsForRanges;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.VRegNameConstruction;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.DTilerBufferingUtility.FullTileBufferingInformation;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.DTilerSIMDUtility.BookKeepingVariableInitStmtConstructor;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class SIMDPreprocessForFullTile{
	public static boolean DEBUG = false;
	
	public static final PolyIRCGSIMDUserFactory _fact = PolyIRCGSIMDUserFactory.INSTANCE;
	public static final PolyIRCGUserFactory _cgfact = PolyIRCGUserFactory.INSTANCE;
	public static final PolyhedralIRUserFactory _irfact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected final CodeUnit cu;
	protected final TargetMapping tm;
	protected final VRegNameConstruction vregNameConstructor;
	protected FullTileBufferingInformation bufferInfo;
	//protected VariableInitialization initVariableBody;
	
	protected VType vtype;		//the vectorization instruction informations
	protected int[] unrollFactor;	//the unrollFactor along each dimension
	protected int strategy;	//support 3 vectorization strategy: 1 -- naive vectorization strategy, load for all the register needed
							//2 -- all aligned vectorization strategy 
							//3 -- mostly aligned vectorization strategy
	
	protected boolean isRotate;	//register rotation or copy back
	protected boolean getBounded;
	protected String stmtGroup;		//the statement group number
	protected int stmtCount;

	protected int cons1; 
	protected int cons2;
	
	//local variables
	protected Map<String, VRegister> regs; 	//record the register has been created
	protected Map<VariableDeclaration, Map<Integer, String>> var_dep_regname_map;	
	protected Map<VariableDeclaration, Map<Integer, List<String>>> var_datastream_regs_map;

	protected SIMDPreprocessForFullTile(CodeUnit _cu, TargetMapping _tm, TiledCodeGenOptions _options,  int _cons1, int _cons2, FullTileBufferingInformation _bufferInfo, String _stmtGroup){
		cu = _cu;
		tm = _tm;
		bufferInfo = _bufferInfo;
		stmtCount = 0;
		cons1 = _cons1;
		cons2 = _cons2;
		stmtGroup = _stmtGroup;
		
		initSIMDConfigure(_options);
		bufferInfo.padded = true;
		bufferInfo.var_padded_map = new HashMap<VariableDeclaration, List<String>>();
		//initialize the padded variable
		for(VariableDeclaration var: bufferInfo.bufferVars){
			List<String> padded_indices = new LinkedList<String>();
			for(int i = 1; i < var.getDomain().getNIndices(); i++){	//pad all the dimensions except the outermost time dimension
				String padded_index = var.getName() + "_padded_" + var.getDomain().getIndexNames().get(i);
				padded_indices.add(padded_index);
			}
			bufferInfo.var_padded_map.put(var, padded_indices);
		}
		//initialize the front padding variable for alignment, and adjust the tile offset for domain construction
		if(strategy >= 2){	
			bufferInfo.isAligned = true;
			bufferInfo.var_frontPadding_map = new HashMap<VariableDeclaration, List<Integer>>();
			int cache_line_elems = SIMDInstructionUtility.getCacheLineSize(vtype);
			for(VariableDeclaration var: bufferInfo.bufferVars){
				List<Integer> frontPaddingVals = new LinkedList<Integer>();
				//only pad the innermost dimension, and leave the other dimension unpadded, peel out the outermost time dimension
				List<Integer> var_halo = bufferInfo.var_halo_map.get(var);
				for(int i = 0; i < var.getDomain().getNIndices() - 2; i++){
					frontPaddingVals.add(0);
				}
				int padded_size = ((var_halo.get(var_halo.size() - 1) + cache_line_elems - 1)/cache_line_elems)*cache_line_elems - var_halo.get(var_halo.size() - 1);
				frontPaddingVals.add(padded_size);
				bufferInfo.var_frontPadding_map.put(var, frontPaddingVals);
				//update the innermost register offset
				int nElems = vtype.getNElements();
				int innermost_offset = ((var_halo.get(var_halo.size() - 1) + nElems - 1)/nElems)*nElems;
				bufferInfo.var_offset_map.get(var).set(var_halo.size() - 1, innermost_offset);
				for(Entry<Integer, List<Integer>>  var_datastream_aligned_range_map_entry: bufferInfo.var_datastream_aligned_range_map.get(var).entrySet()){
					int regsiter_align_val = -var_datastream_aligned_range_map_entry.getValue().get(1) + innermost_offset;
					bufferInfo.var_datastream_register_aligne_value_map.get(var).put(var_datastream_aligned_range_map_entry.getKey(), regsiter_align_val);
				}
				
			}
		}
		vregNameConstructor = new VRegNameConstruction();
	}
	
	protected SIMDPreprocessForFullTile(CodeUnit _cu, TargetMapping _tm, TiledCodeGenOptions _options){
		cu = _cu;
		tm = _tm;
		bufferInfo = initComputationInfo(_options);
		stmtCount = 0;
		cons1 = 0;
		cons2 = 0;
		stmtGroup = "G1";
		
		initSIMDConfigure(_options);
		vregNameConstructor = new VRegNameConstruction();
	}
	
	protected void initSIMDConfigure(TiledCodeGenOptions _options){
		SIMD_WIDTH  simdWidth;
		SIMD_INS simdIns;
		//init the SIMD information
		if(_options.simdSet == "SSE"){
			simdWidth = SIMD_WIDTH.M128;
			simdIns = SIMD_INS.SSE;
		}else{
			simdWidth = SIMD_WIDTH.M256;
			simdIns = SIMD_INS.AVX;
		}
		vtype = _fact.createVType(EcoreUtil.copy(bufferInfo.stmts.get(0).getVarDecl().getType()), simdWidth, simdIns);
		//saving intermediate information for DTiler
		_options.dataType = bufferInfo.stmts.get(0).getVarDecl().getType().getCName();
		
		strategy = _options.strategy;
		isRotate = _options.rotate;
		if(!_options.unrollAndJam){	//no unrolling
			int[] factors = new int[bufferInfo.tileDims];
			for(int i = 0; i < bufferInfo.tileDims; i++){
				factors[i] = 1;
			}
			unrollFactor = factors;
		}else{
			unrollFactor = _options.unrollFactors;
		}
		if(_options.pointer){
			bufferInfo.pointer = true;
			bufferInfo.pointer_var_map = new HashMap<String, VariableDeclaration>();
		}
		
		if(!_options.buffering){
			addTileSizeModularCheck();
		}
		//check whether there is dependence along the innermost dimension
		for(Entry<VariableDeclaration, List<List<Integer>>> var_dep_entry: bufferInfo.var_deps_map.entrySet()){
			for(List<Integer> dep_vec: var_dep_entry.getValue()){
				if(dep_vec.get(0) == 0){
					throw new RuntimeException("There is a loop carried dependence along the innermost dimension! sVectorization can not be performed!");
				}
			}
		}
		
		//configure unrolled dep information
		bufferInfo.var_unrolled_deps_map = new HashMap<VariableDeclaration, List<List<Integer>>>();
		for(Entry<VariableDeclaration, List<List<Integer>>> var_dep_entry: bufferInfo.var_deps_map.entrySet()){
			VariableDeclaration var = var_dep_entry.getKey();
			int unrollDim = unrollFactor.length - var.getDomain().getNIndices();
			List<List<Integer>> unrolled_dep_vecs = new LinkedList<List<Integer>>();
			for(List<Integer> dep_vec: var_dep_entry.getValue()){
				//get the unrolled dep_vec for the current dependence vector
				List<List<Integer>> unrolled_deps = new LinkedList<List<Integer>>();
				List<Integer> ori_deps = new LinkedList<Integer>();
				SIMDStmtConversionUtility.getUnrolledDeps(0, unrollDim, dep_vec, unrollFactor, ori_deps, unrolled_deps);
				unrolled_dep_vecs.addAll(unrolled_deps);
			}
			bufferInfo.var_unrolled_deps_map.put(var, unrolled_dep_vecs);
		}
		
		bufferInfo.var_datastream_range_map = new HashMap<VariableDeclaration, Map<Integer, List<Integer>>>();
		bufferInfo.var_datastream_aligned_range_map = new HashMap<VariableDeclaration, Map<Integer, List<Integer>>>();
		bufferInfo.var_datastream_ndeps_map = new HashMap<VariableDeclaration, Map<Integer, Integer>>();
		bufferInfo.var_datastream_rotatable_map = new HashMap<VariableDeclaration, Map<Integer, Integer>>();
		bufferInfo.var_datastream_rotateval_map = new HashMap<VariableDeclaration, Map<Integer, Integer>>();
		bufferInfo.var_datastream_register_aligne_value_map = new HashMap<VariableDeclaration, Map<Integer, Integer>>();
		for(Entry<VariableDeclaration, List<List<Integer>>> var_unrolled_deps_map_entry: bufferInfo.var_unrolled_deps_map.entrySet()){
			VariableDeclaration var = var_unrolled_deps_map_entry.getKey();
			Map<Integer, Integer> datastream_ndeps_map = DTilerSIMDUtility.extractDistinctDepNums(var_unrolled_deps_map_entry.getValue(), bufferInfo.var_offset_map.get(var));
			bufferInfo.var_datastream_ndeps_map.put(var, datastream_ndeps_map);
			Map<Integer, List<Integer>> datastream_range_map = DTilerSIMDUtility.extractDataStream(var_unrolled_deps_map_entry.getValue(), bufferInfo.var_offset_map.get(var));
			//compute the rotate-ability and value for rotation for each data stream, and compute the aligned range for each data stream
			Map<Integer, List<Integer>> datastream_aligned_range_map = new TreeMap<Integer, List<Integer>>();
			Map<Integer, Integer> datastream_rotatable_map = new TreeMap<Integer, Integer>();
			Map<Integer, Integer> datastream_rotateval_map = new TreeMap<Integer, Integer>();
			Map<Integer, Integer> datastream_register_aligned_value_map = new TreeMap<Integer, Integer>();
			for(Entry<Integer, List<Integer>> datastream_range_map_entry: datastream_range_map.entrySet()){
				//compute the number of vectors have to be loaded
				int nElems = vtype.getNElements();
				List<Integer> range = datastream_range_map_entry.getValue();
				int nLoads = ((2*nElems -1 + (range.get(1) - range.get(0)))/nElems);	//expand the range by vector length and then compute the ceiling of the number
				List<Integer> aligned_range = new LinkedList<Integer>();
				aligned_range.addAll(range);
				if(bufferInfo.bufferVars.contains(var) && (nLoads > 1 || strategy == 2)){	//pad the starting range at index 1 to be multiple of the vector size
					int inner_range = ((range.get(1) + nElems - 1)/nElems)*nElems;
					aligned_range.set(1, inner_range);
				}
				datastream_aligned_range_map.put(datastream_range_map_entry.getKey(), aligned_range);
				int register_aligned_val = -range.get(1) + bufferInfo.var_offset_map.get(var).get(var.getDomain().getNIndices() -1);
				datastream_register_aligned_value_map.put(datastream_range_map_entry.getKey(), register_aligned_val);
				
				//compute the new number of loads it required
				nLoads = ((2*nElems -1 + (aligned_range.get(1) - aligned_range.get(0)))/nElems);
				datastream_rotatable_map.put(datastream_range_map_entry.getKey(), nLoads);		//save the number of loads required in a data stream for each vector computation, used check rotatbility later
				int rotate_factor = unrollFactor[bufferInfo.tileDims-1];
				if(rotate_factor < nLoads)	rotate_factor = nLoads;
				int rotate = nElems*rotate_factor;
				if(!isRotate){
					rotate = (nLoads*unrollFactor[bufferInfo.tileDims-1] + 1)*nElems;
				}
				datastream_rotateval_map.put(datastream_range_map_entry.getKey(), rotate);
				
			}
			bufferInfo.var_datastream_range_map.put(var, datastream_range_map);
			bufferInfo.var_datastream_aligned_range_map.put(var, datastream_aligned_range_map);
			bufferInfo.var_datastream_register_aligne_value_map.put(var, datastream_register_aligned_value_map);
			bufferInfo.var_datastream_rotatable_map.put(var, datastream_rotatable_map);
			bufferInfo.var_datastream_rotateval_map.put(var, datastream_rotateval_map);
		}
		
		regs = new HashMap<String, VRegister>();
		var_datastream_regs_map = new HashMap<VariableDeclaration, Map<Integer, List<String>>>();
		for(Map.Entry<VariableDeclaration, Map<Integer, Integer>> var_datastream_rotateval_map_entry: bufferInfo.var_datastream_rotateval_map.entrySet()){
			Map<Integer, List<String>> datastream_regs_map = new TreeMap<Integer, List<String>>();
			for(Map.Entry<Integer, Integer> datastream_rotateval_map_entry: var_datastream_rotateval_map_entry.getValue().entrySet()){
				if(DEBUG)	System.out.println("init data stream reg list for data stream: " + datastream_rotateval_map_entry.getKey());
				List<String> regs = new LinkedList<String>();
				datastream_regs_map.put(datastream_rotateval_map_entry.getKey(), regs);
			}
			var_datastream_regs_map.put(var_datastream_rotateval_map_entry.getKey(), datastream_regs_map);
		}
	}
	
	protected void addTileSizeModularCheck(){
		Function entryFunction = null; 
		//find the entry function
		for(Function func: cu.getFunctions()){
			if(func.isEntryPoint()){
				entryFunction = func;
				break;
			}
		}
		
		String tileSizeCheckBody = "if( ";
		for(int i = 1; i < bufferInfo.tileDims-1; i++){
			tileSizeCheckBody += bufferInfo.tileSizes.get(i) + "%" + unrollFactor[i] + "!= 0 ";
			tileSizeCheckBody += "&& ";
		}
		//add the innermost one
		tileSizeCheckBody += bufferInfo.tileSizes.get(bufferInfo.tileDims - 1) + "%" + unrollFactor[bufferInfo.tileDims -1]*vtype.getNElements() + " != 0 ";
		tileSizeCheckBody += "){\n";
		tileSizeCheckBody += "\tprintf(\"The tile size must be a multiple of register block size.\\n\");\n\texit(-1);\n}\n";
		
		//add it to the beginning of all the bodies
		List<Body> bodies = new LinkedList<Body>();
		bodies.add(_cgfact.createBody(tileSizeCheckBody));
		for(Body body: entryFunction.getBodies()){
			bodies.add(body);
		}
		entryFunction.getBodies().clear();
		entryFunction.getBodies().addAll(bodies);
	}
	
	//TODO: This initialization can be merged with initialization of temporary buffer process
	protected FullTileBufferingInformation initComputationInfo(TiledCodeGenOptions _options){
		Function entryFunction = null; 
		//find the entry function
		for(Function func: cu.getFunctions()){
			if(func.isEntryPoint()){
				entryFunction = func;
				break;
			}
		}
		
		//a variable must be specified when temporary buffering or vectorization optimizations are applied
		if((_options.vecVar == null || _options.vecVar.size()== 0) && (_options.var_dom_map == null || _options.var_dom_map.size() == 0) ){
			throw new RuntimeException("Variable name must be specified when temporary buffering or vectorization optimization is used!");
		}
				
		//extract the candidate statements
		VariableInitialization initVariableBody = null;
		//extract the tiled loops and variable initialization body
		List<TiledCLoop> tiledloops = new LinkedList<TiledCLoop>();
		for(Body body: entryFunction.getBodies()){
			if(body instanceof TiledCLoop){
				tiledloops.add((TiledCLoop)body);
			}else if(body instanceof VariableInitialization){
				initVariableBody = (VariableInitialization)body;
			}
		}
		//extracting the candidate statements
		List<EquationAsStatement> fullTileStmts = new LinkedList<EquationAsStatement>();
		if(_options.vecVar != null && _options.vecVar.size() > 0){
			List<VariableDeclaration> vecVars = new LinkedList<VariableDeclaration>();
			for(String varName: _options.vecVar){
				vecVars.add(tm.getContainerSystem().getVariableDeclaration(varName));
			}
			fullTileStmts.addAll(DTilerProcessUtility.extractCandidateStmts(tiledloops, vecVars));
		}
				
		if(_options.var_dom_map != null && _options.var_dom_map.size() > 0){
			Map<VariableDeclaration, Domain> vecVar_dom_map = new HashMap<VariableDeclaration, Domain>();
			for(Map.Entry<String, Domain> var_dom_entry : _options.var_dom_map.entrySet()){
				vecVar_dom_map.put(tm.getContainerSystem().getVariableDeclaration(var_dom_entry.getKey()), var_dom_entry.getValue());
			}
			fullTileStmts.addAll(DTilerProcessUtility.extractCandidateStmts(tiledloops, vecVar_dom_map));
		}
				
		if(fullTileStmts.size() == 0){
			throw new RuntimeException("No candidtate statement can be extracted for optimization!");
		}
		
		//configure it at the Tiled Codegen options for later pass into DTiler
		_options.optimalPointLoopStmts = new LinkedList<List<String>>();
		List<String> statement_pattern = new ArrayList<String>();
		for(EquationAsStatement stmt: fullTileStmts){
			statement_pattern.add(stmt.getName());
		}
		_options.optimalPointLoopStmts.add(statement_pattern);
		
		//connect with multi-pass wavefront parallelization
		int level = 1;
		if(_options.multiPassSequential || _options.multiPassWavefront){
			level = 3;
		}
		FullTileBufferingInformation _bufferInfo = new FullTileBufferingInformation(fullTileStmts, tm.getSpaceTimeLevel(0).getNumberOfTiledDimensions(), level);
		_bufferInfo.initVariableBody = initVariableBody;
		//clear the buffered variable 
		_bufferInfo.bufferVars.clear();
		
		return _bufferInfo;
	}
	
	public static void vectorization(CodeUnit _cu, TargetMapping _tm, TiledCodeGenOptions _options){
		SIMDPreprocessForFullTile process = new SIMDPreprocessForFullTile(_cu, _tm, _options);
		if(_options.pointer){
			process.addAddressBookKeepingVariables();
		}
		process.generateVectorizedFullLoop();
	}
	
	protected void generateVectorizedFullLoop(){
		ParameterDomain paramDomCopy = cu.getSystem().getParameters().copy().toParameterDomain();
		//extend the parameter domain to include tile indices
		for(int i = 0; i < bufferInfo.tileIndex.size(); i++){
			paramDomCopy.addParameterDimension(bufferInfo.tileIndex.get(i));
		}
		//add extra constraints to tile size parameters
		List<Variable> tileSizeVars = paramDomCopy.getParams().subList(paramDomCopy.getNParams() - 2*bufferInfo.tileDims, paramDomCopy.getNParams());
		for(int i = 0; i < bufferInfo.tileDims; i++){
			//add tsi >= offset_{i}
			paramDomCopy.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
					IntExpressionBuilder.constant(bufferInfo.tileOffsets.get(i)), 
					ComparisonOperator.GT));
		}
		if(bufferInfo.padded){	//add the padded index as parameter
			for(VariableDeclaration var: bufferInfo.bufferVars){
				List<Integer> halo = bufferInfo.var_halo_map.get(var);
				int i = 0;
				for(String padded_index: bufferInfo.var_padded_map.get(var)){
					paramDomCopy.addParameterDimension(padded_index);
					i++;
					Variable padded_index_var = paramDomCopy.getParams().get(paramDomCopy.getNParams() - 1);
					paramDomCopy.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(padded_index_var), 
							IntExpressionBuilder.constant(halo.get(i)), 
							ComparisonOperator.GE));
				}
			}
		}
		
		List<String> paramList = DTilerBufferingUtility.getBufferStmtParameterList(paramDomCopy, bufferInfo.tileIndex, bufferInfo.tileSizes);
		//reparse the parameter domain
		String oriParamDomStr = paramDomCopy.toString();
		String paramDomStr = "{" + CodeGenUtility.toStringList(paramList, ",") + oriParamDomStr.substring(oriParamDomStr.indexOf('|'), oriParamDomStr.length());
		ParameterDomain paramDom = PolyhedralIRUtility.parseParameterDomain(paramDomStr);
		
		if(DEBUG){
			System.out.println("the parameter domain " + paramDom);
		}
		
		CLoop optLoop = _cgfact.createCLoop(paramDom, 2);	//add two more constant dimension: one before the time dimension, and one after time dimension
		optLoop.setDeclareIterators(false);

		optLoop.getStatements().addAll(getSIMDComputeBodyStatements());

		bufferInfo.mainLoop.setOptimizedPointLoop(optLoop);
	}
	
	/**
	 * Add variable declaration for the book keeping variable for pointer access
	 */
	public void addAddressBookKeepingVariables(){
		for(Map.Entry<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_aligned_range_map_entry: bufferInfo.var_datastream_aligned_range_map.entrySet()){
			VariableDeclaration var = var_datastream_aligned_range_map_entry.getKey();
			Domain rowVarDom = DTilerBufferingUtility.getProjectedVariableDomain(var, var.getDomain().getNIndices() - 1);	//project out the outer dims - 1 dimensions
			AffineFunction identity_access = PolyhedralIRUtility.createIdentityFunction(rowVarDom);
			
			List<Integer> offsets = bufferInfo.var_offset_map.get(var);
			boolean buffered = false;
			if(bufferInfo.bufferVars.contains(var)){
				buffered = true;
				offsets = offsets.subList(1, var.getDomain().getNIndices());
			}
			//add book keeping variable for each data stream
			List<String> rowVarNames = new LinkedList<String>();
			for(Map.Entry<Integer, List<Integer>> datastream_aligned_range_map_entry: var_datastream_aligned_range_map_entry.getValue().entrySet()){
				List<Integer> datastream_vec = DTilerSIMDUtility.decodeDep(datastream_aligned_range_map_entry.getKey(), bufferInfo.var_offset_map.get(var).subList(0, var.getDomain().getNIndices() - 1));
				if(buffered){
					String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, datastream_vec.get(0));
					VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
					String name_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(temp_buffer_var);
					rowVarNames.add(DTilerBufferingUtility.getBookKeepingRowName(temp_buffer_var.getDomain().getNIndices() - 1, datastream_vec.subList(1, datastream_vec.size()), offsets, name_prefix));
				}else{
					String name_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(var);
					rowVarNames.add(DTilerBufferingUtility.getBookKeepingRowName(var.getDomain().getNIndices() - 1, datastream_vec, offsets, name_prefix));
				}
			}
			
			//construct row pointer variables
			for(String name: rowVarNames){
				VariableDeclaration row_var = _irfact.createVariableDeclaration(name, EcoreUtil.copy(var.getType()), rowVarDom.copy());
				bufferInfo.pointer_var_map.put(name, row_var);
				
				//update the targetmapping
				MemoryMap mm = TargetMappingUserFactory.createMemoryMap(row_var, identity_access.copy(), null, tm.getMemorySpace(row_var.getName()));
				tm.getMemoryMaps().put(row_var, mm);
				SpaceTimeMap stmap = TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(row_var);
				tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(row_var.getName(), stmap);
					
				//add the code generation variable
				CVariable row_var_v = _cgfact.createCVariable(tm.getMemorySpace(row_var.getName()), true, false);
				cu.getVariables().add(row_var_v);
				bufferInfo.function.getSpecialLocals().add(row_var_v);
				bufferInfo.initVariableBody.getSpecialLocals().add(row_var_v);
			}
		}
	}
	
	public void addBufferPaddingBody(){
		//get padding for all the dimensions except the outer most time dimension
		List<Body> padding_bodies = new LinkedList<Body>();
		for(VariableDeclaration var: bufferInfo.bufferVars){
			List<String> padded_indices = bufferInfo.var_padded_map.get(var);
			List<Integer> var_halo = bufferInfo.var_halo_map.get(var);
			
			for(int i = 1; i < var.getDomain().getNIndices() - 1; i++){
				String padded_var_declaration = "int " + padded_indices.get(i - 1) + "=";
				//int cons_val = var_halo.get(i) + unrollFactor[i] - 1;
				int cons_val = unrollFactor[i] - 1;
				padded_var_declaration  +=  "( (" + bufferInfo.tileSizes.get(i) + "+" + cons_val + ") /" + unrollFactor[i] + ")*" + unrollFactor[i] +  "+" + var_halo.get(i) + ";"; 
				padding_bodies.add(_cgfact.createBody(padded_var_declaration));
			}
			//add padding body for the last dimension, padd to cache line size
			int padded_factor = vtype.getNElements()*unrollFactor[var.getDomain().getNIndices() - 1];
			String vec_padded_var_declaration = "int " + padded_indices.get(var.getDomain().getNIndices() - 2) + "=";
			//int cons = bufferInfo.var_halo_map.get(var).get(var.getDomain().getNIndices() - 1) + padded_factor - 1;
			int cons = padded_factor - 1;
			int cache_line_elems = SIMDInstructionUtility.getCacheLineSize(vtype);
			int cache_line_padding = ((bufferInfo.var_halo_map.get(var).get(var.getDomain().getNIndices() - 1) + cache_line_elems - 1)/cache_line_elems)*cache_line_elems;
	
			vec_padded_var_declaration += "((" + bufferInfo.tileSizes.get(var.getDomain().getNIndices() - 1) + "+" + cons + ")/" + padded_factor + ")*" + padded_factor + "+" + cache_line_padding + ";";
			padding_bodies.add(_cgfact.createBody(vec_padded_var_declaration));
		}
		//add the body into the main function
		List<Body> bodies = new LinkedList<Body>();
		for(Body body: bufferInfo.function.getBodies()){
			bodies.add(body);
			if(body instanceof VariableInitialization){
				bodies.addAll(padding_bodies);
			}
		}
		
		bufferInfo.function.getBodies().clear();
		bufferInfo.function.getBodies().addAll(bodies);
	}
		
	
	public List<Statement> getSIMDComputeBodyStatements(){
		List<Statement> computes = new LinkedList<Statement>();
		
		ParameterDomain paramDom = cu.getSystem().getParameters().copy().toParameterDomain();
		//extend the parameter domain to include tile indices
		for(int i = 0; i < bufferInfo.tileIndex.size(); i++){
			paramDom.addParameterDimension(bufferInfo.tileIndex.get(i));
		}
		
		//get the parameter list
		List<String> params = DTilerBufferingUtility.getBufferStmtParameterList(paramDom, bufferInfo.tileIndex, bufferInfo.tileSizes);
		
		//add the peeled load statements
		if(strategy >= 2){
			cons2++;
			if(bufferInfo.pointer){
				computes.addAll(getBookKeepingVariableInitStatement(params));
			}
			computes.addAll(getPeelingLoadStatements(params));
			//nRotateLoads = rotate_input_func_regs.size();
		}
		if(strategy >= 2){
			//get the other loads for the 0th compute block
			//cons2++;
			computes.addAll(getLoadStmtForComputeBlock(params, 0));
			//nTotalRotateLoads = rotate_input_func_regs.size();
		}
		if(strategy == 1){
			cons2++;
			computes.addAll(getAllLoadStmtForComputeBlock(params, 0));
		}
		//nNonRotateLoads = non_rotate_input_func_regs.size();
		
		//construct the main compute function
		Map<String, VRegister> input_regs = new HashMap<String, VRegister>();
		input_regs.putAll(regs);
		List<String> input_func_regs = new LinkedList<String>();
		//add the registers required for each datastream
		for(Map.Entry<VariableDeclaration, Map<Integer, List<String>>> var_datastream_regs_map_entry: var_datastream_regs_map.entrySet()){
			for(Map.Entry<Integer, List<String>> datastream_regs_map_entry: var_datastream_regs_map_entry.getValue().entrySet()){
				input_func_regs.addAll(datastream_regs_map_entry.getValue());
			}
		}
//		input_func_regs.addAll(rotate_input_func_regs);
//		input_func_regs.addAll(non_rotate_input_func_regs);
		Function computeFunc = null;
		if(bufferInfo.bufferVars.size() > 0){
			computeFunc = DTilerBufferingUtility.ConstructBufferedComputeFunction.getBufferedComputeFunction(bufferInfo, stmtGroup, input_regs, input_func_regs, vtype, unrollFactor);
		}else{
			computeFunc = SIMDStmtConversionUtility.ConstructComputeFunction.generateComputeFunction(bufferInfo.stmts, stmtGroup, bufferInfo.scalarVars, input_regs, input_func_regs, 
																											bufferInfo.var_unrolled_deps_map, bufferInfo.var_offset_map, vtype, unrollFactor);
		}
		cu.getFunctions().add(computeFunc);
		//construct the first computation statement
		Statement computStmt = getComputeFunctionCallStatements(params, 0);
		computes.add(computStmt);
		if((strategy > 1) && (!isRotate || ((unrollFactor[bufferInfo.tileDims - 1]-1) == 0))){
			computes.addAll(getRotateCopyStatements(params, 0));
		}
				
		//construct the body within the unrolled innermost body
		for(int i = 1; i < unrollFactor[bufferInfo.tileDims - 1]; i++){
			if(strategy >= 2){
				computes.addAll(getLoadStmtForComputeBlock(params, i));
			}else if(strategy == 1){
				computes.addAll(getAllLoadStmtForComputeBlock(params, i));
			}else {
				throw new RuntimeException("Vectorization Strategy " + strategy + " is not supported!");
			}
			Statement blockcomputStmt = getComputeFunctionCallStatements(params, i);
			computes.add(blockcomputStmt);
			if(strategy > 1 && (!isRotate || (i==(unrollFactor[bufferInfo.tileDims - 1]-1)))){
				computes.addAll(getRotateCopyStatements(params, i));
			}
		}
		
		addLocalRegisters();

		return computes;
	}
	
	
	private List<Statement> getBookKeepingVariableInitStatement(List<String> params){
		List<Statement> initStmts = new LinkedList<Statement>();
	
		for(Map.Entry<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_aligned_range_map_entry: bufferInfo.var_datastream_aligned_range_map.entrySet()){
			VariableDeclaration var = var_datastream_aligned_range_map_entry.getKey();
			Domain stmtDom = getPeelingLoadsDomain(params, var);	//the domain is constructed as the same as peeled loading statements
			int varDims = var.getDomain().getNIndices();
			
			//List<Integer> offset = bufferInfo.var_offset_map.get(var);
			//System.out.println("the offset size " + offset.size());
			if(bufferInfo.bufferVars.contains(var)){
				for(Map.Entry<Integer, List<Integer>> datastream_aligned_range_map_entry: var_datastream_aligned_range_map_entry.getValue().entrySet()){
					List<Integer> datastream_vec = DTilerSIMDUtility.decodeDep(datastream_aligned_range_map_entry.getKey(), bufferInfo.var_offset_map.get(var).subList(0, var.getDomain().getNIndices() - 1));
					List<Integer> aligned_range = datastream_aligned_range_map_entry.getValue();
					//offset = offset.subList(1, varDims);
					String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, datastream_vec.get(0));
					VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
						
					List<List<Integer>> ranges = new LinkedList<List<Integer>>();
					BasicVariableData tempVarData = new BasicVariableData(temp_buffer_var, cu.findCGVariable(temp_buffer_name), 
							tm.getSpaceTimeLevel(0).getAccessFunction(temp_buffer_var), ranges, bufferInfo.var_offset_map.get(var).subList(1, varDims), null, -1);	//no rotation value and register alignval needed
					BookKeepingVariableInitStmtConstructor constructor = new BookKeepingVariableInitStmtConstructor(tempVarData, stmtDom, stmtCount, stmtGroup, bufferInfo.pointer_var_map);
					//construct the dependence vector for the first reference in the datastream
					List<Integer> dep_vec = datastream_vec.subList(1, datastream_vec.size());
					dep_vec.add(aligned_range.get(1));
					initStmts.add(constructor.generateInitStmtWithDepVec(dep_vec));
					stmtCount++;
				}
			}else{
				for(Map.Entry<Integer, List<Integer>> datastream_aligned_range_map_entry: var_datastream_aligned_range_map_entry.getValue().entrySet()){
					List<Integer> datastream_vec = DTilerSIMDUtility.decodeDep(datastream_aligned_range_map_entry.getKey(), bufferInfo.var_offset_map.get(var).subList(0, var.getDomain().getNIndices() - 1));
					List<Integer> aligned_range = datastream_aligned_range_map_entry.getValue();
					BasicVariableData varData = new BasicVariableData(var, cu.findCGVariable(var.getName()), tm.getSpaceTimeLevel(0).getAccessFunction(var), new LinkedList<List<Integer>>(), bufferInfo.var_offset_map.get(var), null,  -1);
					BookKeepingVariableInitStmtConstructor constructor = new BookKeepingVariableInitStmtConstructor(varData, stmtDom, stmtCount, stmtGroup, bufferInfo.pointer_var_map);
					//get the dependence function for the first access function
					List<Integer> dep_vec = new LinkedList<Integer>();
					dep_vec.addAll(datastream_vec);
					dep_vec.add(aligned_range.get(1));
					initStmts.add(constructor.generateInitStmtWithDepVec(dep_vec));
					stmtCount++;
				}
			}
		}
		return initStmts;
	}
	
	
	/**
	 * Construct the SIMD load statements that are peeled out the main computation body
	 * @param params
	 * @return
	 */
	private List<Statement> getPeelingLoadStatements(List<String> params){
		List<Statement> peeledLoads = new LinkedList<Statement>();

		for(Map.Entry<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_aligned_range_map_entry: bufferInfo.var_datastream_aligned_range_map.entrySet()){
			//construct current variable information
			VariableDeclaration var = var_datastream_aligned_range_map_entry.getKey();
			int nElems = vtype.getNElements();
			
			//construct the domain for the peeling statement
			Domain peelDom = getPeelingLoadsDomain(params, var);
			//for each data stream, construct the nLoads-1 peeled off loading statement
			for(Map.Entry<Integer, List<Integer>> datastream_aligned_range_map_entry: var_datastream_aligned_range_map_entry.getValue().entrySet()){
				List<Integer> aligned_range = datastream_aligned_range_map_entry.getValue();
				List<Integer> load_range = new LinkedList<Integer>();
				load_range.addAll(aligned_range);
				
				//construct the peeled loads for the current data stream
				int nLoads = bufferInfo.var_datastream_rotatable_map.get(var).get(datastream_aligned_range_map_entry.getKey());
				int innermost_0 = load_range.get(1) - (nLoads - 1)*nElems;
				load_range.set(0, innermost_0);
				peeledLoads.addAll(getLoadStmtForDataStream(peelDom, var, datastream_aligned_range_map_entry.getKey(), load_range));
			}	
		}
		
		return peeledLoads;
	}
	
	private void addLocalRegisters(){
		//get the list of the local registers has to be declared
		List<VRegister> local_regs = new LinkedList<VRegister>();
		for(Map.Entry<String, VRegister> reg_entry: regs.entrySet()){
			local_regs.add(reg_entry.getValue());
		}
		
		//register the local regs in the function
		bufferInfo.function.getLocalsimdRegs().addAll(local_regs);
		//create the initial body for registers
		VRegisterInitialization regInitBody = _fact.createVRegisterInitialization(bufferInfo.function);
		
		//add the local register initialization body
		List<Body> bodies = new LinkedList<Body>();
		for(Body body: bufferInfo.function.getBodies()){
			bodies.add(body);
			if(body instanceof VariableInitialization){
				bodies.add(regInitBody);
			}
		}
		
		bufferInfo.function.getBodies().clear();
		bufferInfo.function.getBodies().addAll(bodies);
	}
	
	
	private Domain getPeelingLoadsDomain(List<String> params, VariableDeclaration var){
		//construct the indices list
		List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
		
		Domain stmtDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> indexVars = stmtDom.getIndices();
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)), 
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//add c1 < ts0 + ti0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), tileSizeVars.get(0)), ComparisonOperator.LT));
		//add c1 >= ti0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				IntExpressionBuilder.affine(tileIndexVars.get(0)), ComparisonOperator.GE));
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
		
		//add the rest dimensions except the last dimension to the same as computation
		if(bufferInfo.bufferVars.size() > 0){
			for(int i = 1; i < bufferInfo.tileDims - 1; i++){
				//add c_{i+2} < ts_{i} + offset_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), bufferInfo.tileOffsets.get(i)),
						ComparisonOperator.LT));
				//c_{i+2} >= offset_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						IntExpressionBuilder.constant(bufferInfo.tileOffsets.get(i)), 
						ComparisonOperator.GE));
			}
		}else{
			for(int i = 1; i < bufferInfo.tileDims - 1; i++){
				//add c_{i+2} < ti_{i} + ts_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(i), tileSizeVars.get(i)), 
						ComparisonOperator.LT));
				//add c_{i+2} >= ti_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
					 IntExpressionBuilder.affine(tileIndexVars.get(i)), 
					 ComparisonOperator.GE));
			}
		}
	
		
		//set the last dimensiom to buffer offset
		if(bufferInfo.bufferVars.size() > 0){
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(bufferInfo.tileDims + 1)), 
				IntExpressionBuilder.constant(bufferInfo.tileOffsets.get(bufferInfo.tileDims - 1)), ComparisonOperator.EQ));
		}else{
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(bufferInfo.tileDims + 1)), 
					IntExpressionBuilder.affine(tileIndexVars.get(bufferInfo.tileDims - 1)), ComparisonOperator.EQ));
		}
		
		
		return stmtDom;
	}

	/**
	 * Get the load statements for the nth computation block
	 * @param params
	 * @param n
	 * @return
	 */
	private List<Statement> getLoadStmtForComputeBlock(List<String> params, int n){
		List<Statement> loads = new LinkedList<Statement>();
		
		for(Map.Entry<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_aligned_range_map_entry: bufferInfo.var_datastream_aligned_range_map.entrySet()){
			//construct current variable information
			VariableDeclaration var = var_datastream_aligned_range_map_entry.getKey();
			int nElems = vtype.getNElements();
			
			//the domain for the compute block
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
			Domain stmtDom = getComputeStmtDomain(startDom);
			//for each data stream, construct the nLoads-1 peeled off loading statement
			for(Map.Entry<Integer, List<Integer>> datastream_aligned_range_map_entry: var_datastream_aligned_range_map_entry.getValue().entrySet()){
				List<Integer> aligned_range = datastream_aligned_range_map_entry.getValue();
				List<Integer> load_range = new LinkedList<Integer>();
				load_range.addAll(aligned_range);
				
				//construct the peeled loads for the current data stream
				int nLoads = bufferInfo.var_datastream_rotatable_map.get(var).get(datastream_aligned_range_map_entry.getKey());
				int innermost_1 = load_range.get(1) - (nElems*(nLoads-1 + n));
				int innermost_0 = innermost_1 - nElems;
				load_range.set(0, innermost_0);		load_range.set(1, innermost_1);
				loads.addAll(getLoadStmtForDataStream(stmtDom, var, datastream_aligned_range_map_entry.getKey(), load_range));
			}	
			
		}
//		//construct the loads 
//		for(Map.Entry<VariableDeclaration, List<List<Integer>>> range_entry: bufferInfo.var_range_map.entrySet()){
//			//construct current variable information
//			VariableDeclaration var = range_entry.getKey();
//			
//			int var_dims = var.getDomain().getNIndices();
//			int nElems = vtype.getNElements();
//			//make a copy of the original var range and halo
//			//List<List<Integer>> ori_var_ranges = range_entry.getValue();
//			List<List<Integer>> ori_var_ranges = bufferInfo.var_unrolled_rotate_range_map.get(var);
//			List<Integer> var_offset = bufferInfo.var_offset_map.get(var);
//			if(bufferInfo.isAligned){
//				//pad the starting range to be multiple of the vector size
//				int inner_range = ((ori_var_ranges.get(var_dims - 1).get(1) + nElems - 1)/nElems)*nElems;
//				ori_var_ranges.get(var_dims - 1).set(1, inner_range);
//			}
//			//make a copy of the original variable range
//			List<List<Integer>> var_ranges = new LinkedList<List<Integer>>();
//			for(List<Integer> dim_range: ori_var_ranges){
//				List<Integer> range = new LinkedList<Integer>();
//				range.addAll(dim_range);
//				var_ranges.add(range);
//			}
//			
//			//compute the number of loads required along the innermost dim for each vector computation
//			int nLoads = ((2*nElems -1 + (var_ranges.get(var_dims -1).get(1) - var_ranges.get(var_dims - 1).get(0)))/nElems);
//			int rotate = nElems*unrollFactor[bufferInfo.tileDims-1];
//			if(!isRotate){
//				rotate = (nLoads*unrollFactor[bufferInfo.tileDims-1] + 1)*nElems;
//			}
//					
//			//compute the range for the innermost dimension
//			int innermost_1 = var_ranges.get(var_dims - 1).get(1) - (nElems*(nLoads-1 + n));
//			int innermost_0 = innermost_1 - nElems;
//			var_ranges.get(var_dims - 1).set(1, innermost_1);
//			var_ranges.get(var_dims - 1).set(0, innermost_0);
//			
//			//the domain for the compute block
//			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
//			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
//			Domain stmtDom = getComputeStmtDomain(startDom);
//			loads.addAll(getLoadStmtForVar(stmtDom, var, var_ranges, var_offset, rotate));
//			
//			//get the rest of loads for the non-rotatable dependence
//			int varDims = var.getDomain().getNIndices();
//			List<List<Integer>> cur_deps = new LinkedList<List<Integer>>();
//			for(List<Integer> dep: bufferInfo.var_unrolled_norotate_deps_map.get(var)){
//				List<Integer> cur_dep = new LinkedList<Integer>();
//				cur_dep.addAll(dep);
//				int innermost = dep.get(varDims - 1) - n*vtype.getNElements();
//				cur_dep.set(varDims - 1, innermost);
//				cur_deps.add(cur_dep);
//			}
//			loads.addAll(getLoadStmtForVar(stmtDom, var, cur_deps, var_offset));
//		}
		
		return loads;
	}
	
	
	/**
	 * Get the load statement for all the dependence that occur in the statement
	 * @param params
	 * @param n
	 * @return
	 */
	private List<Statement> getAllLoadStmtForComputeBlock(List<String> params, int n){
		List<Statement> loads = new LinkedList<Statement>();
		
		//construct the necessary loads for all the variables
		for(Map.Entry<VariableDeclaration, List<List<Integer>>> deps_entry: bufferInfo.var_unrolled_deps_map.entrySet()){
			VariableDeclaration var = deps_entry.getKey();
			
			int varDims = var.getDomain().getNIndices();
			List<List<Integer>> cur_deps = new LinkedList<List<Integer>>();
			for(List<Integer> dep: deps_entry.getValue()){
				List<Integer> cur_dep = new LinkedList<Integer>();
				cur_dep.addAll(dep);
				int innermost = dep.get(varDims - 1) - n*vtype.getNElements();
				cur_dep.set(varDims - 1, innermost);
				cur_deps.add(cur_dep);
			}
			
			//create the Domain for the load statement
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
			Domain stmtDom = getComputeStmtDomain(startDom);
			loads.addAll(getLoadStmtForVar(stmtDom, var, cur_deps));
		}
		
		return loads;
	}

	/**
	 * Construct the statement domain for the vectorized loop body
	 * @param startDom
	 * @return
	 */
	private Domain getComputeStmtDomain(Domain startDom){
		Domain stmtDom = startDom;
		//adding constrains for each dimension
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> indexVars = stmtDom.getIndices();
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)), 
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//add c1 < ts0 + ti0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), tileSizeVars.get(0)), ComparisonOperator.LT));
		//add c1 >= ti0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				IntExpressionBuilder.affine(tileIndexVars.get(0)), ComparisonOperator.GE));
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
				
		//add the shifted domain for the rest of the dimensions
		if(bufferInfo.bufferVars.size() > 0){
			for(int i = 1; i < bufferInfo.tileDims; i++){
				//add c_{i+2} < ts_{i} + offset_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), bufferInfo.tileOffsets.get(i)),
						ComparisonOperator.LT));
				//c_{i+2} >= offset_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						IntExpressionBuilder.constant(bufferInfo.tileOffsets.get(i)), 
						ComparisonOperator.GE));
			}
		}else{
			for(int i = 1; i < bufferInfo.tileDims; i++){
				//add c_{i+2} < ts_{i} + ti_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)),
						DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(i), tileSizeVars.get(i)), 
						ComparisonOperator.LT));
				//add c_{i+2} >= ti_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
						IntExpressionBuilder.affine(tileIndexVars.get(i)), 
						ComparisonOperator.GE));
			}
		}
				
		return stmtDom;
	}
	
	private List<Statement> getLoadStmtForPointerVar(Domain stmtDom, VariableDeclaration var, List<List<Integer>> var_ranges, List<Integer> var_offset, Map<Integer, Integer> register_alignval_map, int rotate){
		List<Statement> loads = new LinkedList<Statement>();
		
		String row_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(var);
		int[] vec = new int[var.getDomain().getNIndices()];
		getLoadStmtForPointerVar(stmtDom, var, 0, var_ranges, var_offset, register_alignval_map, vec, row_prefix, rotate, loads);
		
		return loads;
	}
	
	private void getLoadStmtForPointerVar(Domain stmtDom, VariableDeclaration var, int k, List<List<Integer>> var_ranges, List<Integer> var_offsets, Map<Integer, Integer> register_alignval_map, int[] vec, String row_prefix, int rotate, List<Statement> loads){
		if(k == var.getDomain().getNIndices() - 1){	//reach the base case
			List<List<Integer>> row_ranges = new LinkedList<List<Integer>>();
			for(int i = 0; i < var.getDomain().getNIndices() - 1; i++){
				List<Integer> range = new LinkedList<Integer>();
				range.add(vec[i]); 	range.add(vec[i]);
				row_ranges.add(range);
			}
			List<Integer> last_range = new LinkedList<Integer>();
			last_range.addAll(var_ranges.get(var.getDomain().getNIndices() - 1));
			row_ranges.add(last_range);
			
			VariableDeclaration row_var = bufferInfo.pointer_var_map.get(row_prefix);
			BasicVariableData tempVarData = new BasicVariableData(row_var, cu.findCGVariable(row_prefix), row_ranges, var_offsets, register_alignval_map, rotate);
			String regPrefix = VRegNameConstruction.getVRegNamePrefix(var, stmtGroup);
			
			if(DEBUG){
				System.out.println("construct loads for variable " + row_var.getName());
				for(int i = 0; i < row_ranges.size(); i++)	System.out.println(row_ranges.get(i));
				System.out.println("the rotation value " + rotate);
			}
			//construct the loads statements
			ConstructLoadsForRanges tempVarLoadConstructor = new ConstructLoadsForRanges(tempVarData, stmtDom, var.getDomain().getNIndices(), stmtCount, stmtGroup, regPrefix, vtype);
			tempVarLoadConstructor.generate();
			stmtCount += tempVarLoadConstructor.loads.size();
			loads.addAll(tempVarLoadConstructor.loads);
			regs.putAll(tempVarLoadConstructor.regs);
		
			return;
		}
		
		for(int i= -var_ranges.get(k).get(1); i <= -var_ranges.get(k).get(0); i++){
			vec[k] = -i;
			String new_prefix = row_prefix + "_" + (i + var_offsets.get(k));
			getLoadStmtForPointerVar(stmtDom, var, k+1, var_ranges, var_offsets, register_alignval_map, vec, new_prefix, rotate, loads);
		}
		
		return;
	}
	
	private List<Statement> getLoadStmtForPointerVar(Domain stmtDom, VariableDeclaration var, List<Integer> dep_vec, List<Integer> offsets, String regName){
		List<Statement> loads = new LinkedList<Statement>();
		
		//get the register
		VRegister reg = _fact.createVRegister(EcoreUtil.copy(vtype), regName);
		//non_rotate_input_func_regs.add(regName);
		regs.put(regName, reg);
		
		//get the row variable
		String row_name_prefix = DTilerBufferingUtility.getBookKeepingVariableNamePrefix(var);
		String row_name = DTilerBufferingUtility.getBookKeepingRowName(var.getDomain().getNIndices()-1, dep_vec, offsets, row_name_prefix);
		
		BasicMemoryAddress address = null;
		address = _fact.createBasicMemoryAccess(cu.findCGVariable(row_name), false, true);
		
		SIMDExpression simd_load = _fact.createVLoadExpression(EcoreUtil.copy(vtype), reg, address);
		loads.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), simd_load));
		stmtCount++;
		String add_stmt_string = row_name + "+=" + reg.getVtype().getNElements();
		loads.add(_cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), add_stmt_string));
		stmtCount++;
		
		return loads;
	}
	
	private List<Statement> getLoadStmtForDataStream(Domain stmtDom, VariableDeclaration var, int data_stream, List<Integer> stream_range){
		List<Statement> loads = new LinkedList<Statement>();
		int var_dims = var.getDomain().getNIndices();
		List<Integer> datastream_vec = DTilerSIMDUtility.decodeDep(data_stream, bufferInfo.var_offset_map.get(var).subList(0, var.getDomain().getNIndices() - 1));
		List<List<Integer>> ranges = new LinkedList<List<Integer>>();	//should have the same number of entries as the variable
		for(int i = 0; i < datastream_vec.size(); i++){
			List<Integer> dim_range = new LinkedList<Integer>();
			dim_range.add(datastream_vec.get(i));
			dim_range.add(datastream_vec.get(i));
			ranges.add(dim_range);
		}
		List<Integer> last_range = new LinkedList<Integer>();
		last_range.addAll(stream_range);
		ranges.add(last_range);
		int rotate = bufferInfo.var_datastream_rotateval_map.get(var).get(data_stream);
		
		Map<Integer, Integer> register_alignval_map = new HashMap<Integer, Integer>();
		if(bufferInfo.bufferVars.contains(var)){
			//get the temp buffer information
			String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, datastream_vec.get(0));
			VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
			
			List<List<Integer>> temp_var_ranges = ranges.subList(1, var_dims);
			List<Integer> temp_var_offsets = bufferInfo.var_offset_map.get(var).subList(1, var_dims);
			int temp_data_stream = DTilerSIMDUtility.encodeDep(datastream_vec.subList(1, datastream_vec.size()), temp_var_offsets);
			register_alignval_map.put(temp_data_stream, bufferInfo.var_datastream_register_aligne_value_map.get(var).get(data_stream));
			
			if(bufferInfo.pointer){
				loads.addAll(getLoadStmtForPointerVar(stmtDom, temp_buffer_var, temp_var_ranges, temp_var_offsets, register_alignval_map, rotate));
			}else{
				BasicVariableData tempVarData = new BasicVariableData(temp_buffer_var, cu.findCGVariable(temp_buffer_name), 
						tm.getSpaceTimeLevel(0).getAccessFunction(temp_buffer_var), temp_var_ranges, temp_var_offsets, register_alignval_map, rotate);
				
				ConstructLoadsForRanges tempVarLoadConstructor = new ConstructLoadsForRanges(tempVarData, stmtDom, stmtCount, stmtGroup, vtype);
				tempVarLoadConstructor.generate();
				stmtCount += tempVarLoadConstructor.loads.size();
				loads.addAll(tempVarLoadConstructor.loads);
				regs.putAll(tempVarLoadConstructor.regs);
			}
			//construct the fixed order of loaded registers
			String prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + temp_buffer_var.getName();
			int[] vec = new int[temp_buffer_var.getDomain().getNIndices()];
			SIMDStmtConversionUtility.getRegNameWithinRanges(0, temp_buffer_var, temp_var_ranges, temp_var_offsets, register_alignval_map, rotate, vec, prefix, vtype, var_datastream_regs_map.get(var).get(data_stream));
		}else{
			register_alignval_map.put(data_stream, bufferInfo.var_datastream_register_aligne_value_map.get(var).get(data_stream));
			if(bufferInfo.pointer){
				loads.addAll(getLoadStmtForPointerVar(stmtDom, var, ranges, bufferInfo.var_offset_map.get(var), register_alignval_map, rotate));
			}else{
				BasicVariableData varData = new BasicVariableData(var, cu.findCGVariable(var.getName()), 
						tm.getSpaceTimeLevel(0).getAccessFunction(var), ranges, bufferInfo.var_offset_map.get(var), register_alignval_map, rotate);
				
				ConstructLoadsForRanges varloadConstructor = new ConstructLoadsForRanges(varData, stmtDom, stmtCount, stmtGroup, vtype);
				varloadConstructor.generate();
				stmtCount += varloadConstructor.loads.size();
				loads.addAll(varloadConstructor.loads);
				regs.putAll(varloadConstructor.regs);
			}
			//construct the fixed order of loaded registers
			String var_prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + var.getName();
			int[] vec = new int[var.getDomain().getNIndices()];
			SIMDStmtConversionUtility.getRegNameWithinRanges(0, var, ranges, bufferInfo.var_offset_map.get(var), register_alignval_map, rotate, vec, var_prefix, vtype, var_datastream_regs_map.get(var).get(data_stream));
		}
		
		return loads;
	}
	
	private List<Statement> getLoadStmtForVar(Domain stmtDom, VariableDeclaration var, List<List<Integer>> var_deps){
		List<Statement> loads = new LinkedList<Statement>();
		int var_dims = var.getDomain().getNIndices();
		
		Map<String, Integer> local_regs = new HashMap<String, Integer>();	//temporary record for naive strategy
 		for(List<Integer> dep_vec: var_deps){
			//extract the data stream
			int data_stream = DTilerSIMDUtility.encodeDep(dep_vec.subList(0, var_dims - 1), bufferInfo.var_offset_map.get(var).subList(0, var_dims - 1));
			if(bufferInfo.bufferVars.contains(var)){
				//extract the data stream
				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, dep_vec.get(0));
				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
				
				List<Integer> temp_var_dep = dep_vec.subList(1, var_dims);
				List<Integer> temp_var_offset = bufferInfo.var_offset_map.get(var).subList(1, var_dims);
				String regName = vregNameConstructor.getVRegName(temp_buffer_var, stmtGroup, temp_var_dep, temp_var_offset);
				if(regs.get(regName) == null || (strategy == 1 && local_regs.get(regName) == null)){	//extra loads is needed
					if(bufferInfo.pointer){
						loads.addAll(getLoadStmtForPointerVar(stmtDom, temp_buffer_var, temp_var_dep, temp_var_offset, regName));
					}else{
						loads.add(getLoadStmtForVar(stmtDom, temp_buffer_var, temp_var_dep, regName));
					}
					var_datastream_regs_map.get(var).get(data_stream).add(regName);
				}
				local_regs.put(regName, 1);
			}else{
				String regName = vregNameConstructor.getVRegName(var, stmtGroup, dep_vec, bufferInfo.var_offset_map.get(var));
				if(regs.get(regName) == null || (strategy == 1 && local_regs.get(regName) == null)) {
					if(bufferInfo.pointer){
						loads.addAll(getLoadStmtForPointerVar(stmtDom, var, dep_vec, bufferInfo.var_offset_map.get(var), regName));
					}else{
						loads.add(getLoadStmtForVar(stmtDom, var, dep_vec, regName));
					}
					var_datastream_regs_map.get(var).get(data_stream).add(regName);
				}
				local_regs.put(regName, 1);
			}
		}
//		if(bufferInfo.bufferVars.contains(var)){	//it is a buffered variable
//			for(List<Integer> dep_vec: var_deps){
//				//extract the data stream
//				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, dep_vec.get(0));
//				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
//				
//				List<Integer> temp_var_dep = dep_vec.subList(1, dep_vec.size());
//				List<Integer> temp_var_offset = var_offsets.subList(1, var_offsets.size());
//				String regName = vregNameConstructor.getVRegName(temp_buffer_var, stmtGroup, temp_var_dep, temp_var_offset);
//				if(regs.get(regName) == null){	//extra loads is needed
//					if(bufferInfo.pointer){
//						loads.addAll(getLoadStmtForPointerVar(stmtDom, temp_buffer_var, temp_var_dep, temp_var_offset, regName));
//					}else{
//						loads.add(getLoadStmtForVar(stmtDom, temp_buffer_var, temp_var_dep, regName));
//					}
//				}
//			}
//		}else{
//			for(List<Integer> dep_vec: var_deps){
//				String regName = vregNameConstructor.getVRegName(var, stmtGroup, dep_vec, var_offsets);
//				if(regs.get(regName) == null) {
//					if(bufferInfo.pointer){
//						loads.addAll(getLoadStmtForPointerVar(stmtDom, var, dep_vec, var_offsets, regName));
//					}else{
//						loads.add(getLoadStmtForVar(stmtDom, var, dep_vec, regName));
//					}
//					//loads.add(getLoadStmtForVar(stmtDom, var, dep_vec, regName));
//				}
//			}
//		}
		return loads;
	}
	
	private Statement getLoadStmtForVar(Domain stmtDom, VariableDeclaration var, List<Integer> var_deps, String regName){
		VRegister reg = _fact.createVRegister(EcoreUtil.copy(vtype), regName);
//		non_rotate_input_func_regs.add(regName);
		regs.put(regName, reg);
		
		int[] dep_cons = new int[var_deps.size()];
		for(int i = 0;  i < var_deps.size(); i++) {
			dep_cons[i] = -var_deps.get(i);
		}
		AffineFunction dep = PolyhedralIRUtility.createUniformFunction(var.getDomain(), dep_cons);
		//construct the access function 
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
		AffineFunction access = tm.getSpaceTimeLevel(0).getAccessFunction(var);
		access = access.compose(identity);
		access = access.compose(dep);
		//constuct the load instruction
		BasicMemoryAddress address = _fact.createBasicMemoryAccess(cu.findCGVariable(var.getName()), access, false);
		SIMDExpression simd_load = _fact.createVLoadExpression(EcoreUtil.copy(vtype), reg, address);
		
		Statement load = _fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), simd_load);
		stmtCount++;
		
		return load;
	}
	
//	private List<Statement> getLoadStmtForVar(Domain stmtDom, VariableDeclaration var, List<List<Integer>> var_ranges, List<Integer> var_halo, int rotate){
//		List<Statement> loads = new LinkedList<Statement>();
//		int var_dims = var.getDomain().getNIndices();
//		if(DEBUG){
//			System.out.println("the current domain for the load statements " + stmtDom);
//			for(int i = 0; i < var_ranges.size(); i++)	System.out.println(var_ranges.get(i));
//			System.out.println("with the rotation value " + rotate);
//		}
//		if(bufferInfo.bufferVars.contains(var)){
//			for(int i = var_ranges.get(0).get(0); i <= var_ranges.get(0).get(1); i++){
//				//get the temp buffer information
//				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, i);
//				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
//				
//				List<List<Integer>> temp_var_ranges = var_ranges.subList(1, var_ranges.size());
//				List<Integer> temp_var_halo = var_halo.subList(1, var_dims);
//				
//				if(bufferInfo.pointer){
//					loads.addAll(getLoadStmtForPointerVar(stmtDom, temp_buffer_var, temp_var_ranges, temp_var_halo, rotate));
//				}else{
//					BasicVariableData tempVarData = new BasicVariableData(temp_buffer_var, cu.findVariable(temp_buffer_name), 
//							tm.getSpaceTimeLevel(0).getAccessFunction(temp_buffer_var), temp_var_ranges, temp_var_halo, rotate);
//					
//					ConstructLoadsForRanges tempVarLoadConstructor = new ConstructLoadsForRanges(tempVarData, stmtDom, stmtCount, stmtGroup, vtype);
//					tempVarLoadConstructor.generate();
//					stmtCount += tempVarLoadConstructor.loads.size();
//					loads.addAll(tempVarLoadConstructor.loads);
//					regs.putAll(tempVarLoadConstructor.regs);
//				}
//				//construct the fixed order of loaded registers
//				String prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + temp_buffer_var.getName();
//				SIMDStmtConversionUtility.getRegNameWithinRanges(0, temp_buffer_var, temp_var_ranges, temp_var_halo, rotate, prefix, vtype, rotate_input_func_regs);
//			}
//		}else{
//			BasicVariableData varData = new BasicVariableData(var, cu.findVariable(var.getName()), 
//					tm.getSpaceTimeLevel(0).getAccessFunction(var), var_ranges, var_halo, rotate);
//			
//			ConstructLoadsForRanges varloadConstructor = new ConstructLoadsForRanges(varData, stmtDom, stmtCount, stmtGroup, vtype);
//			varloadConstructor.generate();
//			stmtCount += varloadConstructor.loads.size();
//			loads.addAll(varloadConstructor.loads);
//			regs.putAll(varloadConstructor.regs);
//			
//			//construct the fixed order of loaded registers
//			String var_prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + var.getName();
//			SIMDStmtConversionUtility.getRegNameWithinRanges(0, var, var_ranges, var_halo, rotate, var_prefix, vtype, rotate_input_func_regs);
//		}
//		
//		return loads;
//	}
	
	
	private Statement getComputeFunctionCallStatements(List<String> params, int n){
		//the name of the function
		String func_name = "Compute" + stmtGroup;
		
		//extract the corresponding subset of registers add to be passed
		List<String> input_regs = new LinkedList<String>();
		for(Map.Entry<VariableDeclaration, Map<Integer, List<String>>> var_datastream_regs_map_entry: var_datastream_regs_map.entrySet()){
			VariableDeclaration var = var_datastream_regs_map_entry.getKey();
			for(Map.Entry<Integer, List<String>> datastream_regs_map_entry: var_datastream_regs_map_entry.getValue().entrySet()){
				int data_stream = datastream_regs_map_entry.getKey();
				List<String> datastream_regs = datastream_regs_map_entry.getValue();
				int nLoads = bufferInfo.var_datastream_rotatable_map.get(var).get(data_stream);
				if(strategy == 1) nLoads = bufferInfo.var_datastream_ndeps_map.get(var).get(data_stream).intValue();
				int rotate_start = n%datastream_regs.size();
				if(!isRotate)	rotate_start = (nLoads*n)%datastream_regs.size();
				int rotate_end = rotate_start + nLoads;
				if(rotate_end <= datastream_regs.size()){
					input_regs.addAll(datastream_regs.subList(rotate_start, rotate_end));
				}else{
					input_regs.addAll(datastream_regs.subList(rotate_start, datastream_regs.size()));
					input_regs.addAll(datastream_regs.subList(0, rotate_end - datastream_regs.size())); //get the rotated registers
				}
			}
		}
		
		//get the statement domain
		List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(new LinkedList<String>(), bufferInfo.tileDims);
		Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.tileOffsets, bufferInfo.tileDims);
		Domain stmtDom = getComputeStmtDomain(startDom);
		if(DEBUG){
			System.out.println("The domain for compute body: " + stmtDom);
		}
		
		//constructing call statement
		String func_call = func_name + "(";
		List<String> func_params = new LinkedList<String>();
		//add the program parameter
		func_params.addAll(cu.getSystem().getParameters().getParamNames());
		//add indices parameter
		func_params.add(stmtDom.getIndexNames().get(1));
		func_params.addAll(stmtDom.getIndexNames().subList(3, stmtDom.getNIndices() - 1));
		//add the last unrolled index value
		int offset = vtype.getNElements()*n;
		String index = stmtDom.getIndexNames().get(stmtDom.getNIndices() - 1);
		if(offset != 0){
			index += "+" + offset;
		}
		func_params.add(index);
		//add padding parameter if needed
		if(bufferInfo.padded){
			for(Map.Entry<VariableDeclaration, List<String>> var_padded_params_entry: bufferInfo.var_padded_map.entrySet()){
				func_params.addAll(var_padded_params_entry.getValue());
			}
		}
		//add scalar variables
		for(VariableDeclaration var: bufferInfo.scalarVars){
			func_params.add(var.getName());
		}
		//add input array parameters
		for(EquationAsStatement stmt: bufferInfo.stmts){
			if(bufferInfo.bufferVars.contains(stmt.getVarDecl())){
				func_params.add(DTilerBufferingUtility.getTempBufferName(stmt.getVarDecl(), 0));
			}else{
				func_params.add(stmt.getVarDecl().getName());
			}
		}
		func_params.addAll(input_regs);
		func_call += CodeGenUtility.toStringList(func_params, ",") + ")";
		
		Statement func_call_stmt = _cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom, func_call);
		stmtCount++;
				
		return func_call_stmt;
	}	


	/**
	 * Get the copy statement for registers that can be reused for the next computation vector
	 * @param params
	 * @param n
	 * @return
	 */
	private List<Statement> getRotateCopyStatements(List<String> params, int n){
		List<Statement> copies = new LinkedList<Statement>();
		int block_num = (n+1)%unrollFactor[bufferInfo.tileDims - 1];
		
		//construct the copy statements
		List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(new LinkedList<String>(), bufferInfo.tileDims);
		Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.tileOffsets, bufferInfo.tileDims);
		Domain stmtDom = getComputeStmtDomain(startDom);
		
		//if(n < (unrollFactor[bufferInfo.tileDims - 1] - 1))
			for(Map.Entry<VariableDeclaration, Map<Integer, List<Integer>>> var_datastream_range_map_entry: bufferInfo.var_datastream_aligned_range_map.entrySet()){
				VariableDeclaration var = var_datastream_range_map_entry.getKey();
				int var_dims = var.getDomain().getNIndices();
				int nElems = vtype.getNElements();
				
				for(Map.Entry<Integer, List<Integer>> datastream_range_map_entry: var_datastream_range_map_entry.getValue().entrySet()){
					int data_stream = datastream_range_map_entry.getKey();
					List<Integer> datastream_vec =  DTilerSIMDUtility.decodeDep(data_stream, bufferInfo.var_offset_map.get(var).subList(0, var.getDomain().getNIndices() - 1));
					List<Integer> load_ranges = new LinkedList<Integer>();
					load_ranges.addAll(datastream_range_map_entry.getValue());
					int nLoads = bufferInfo.var_datastream_rotatable_map.get(var).get(data_stream);
					int rotate = bufferInfo.var_datastream_rotateval_map.get(var).get(data_stream);
					
					if(n < (unrollFactor[bufferInfo.tileDims - 1] - 1)){
						int innermost_0 = load_ranges.get(1) - (nLoads-1)*nElems;
						load_ranges.set(0, innermost_0);
						List<List<Integer>> ranges = new LinkedList<List<Integer>>();
						for(int i = 0; i < datastream_vec.size(); i++){
							List<Integer> dim_range = new LinkedList<Integer>();
							dim_range.add(datastream_vec.get(i));
							dim_range.add(datastream_vec.get(i));
							ranges.add(dim_range);
						}
						ranges.add(load_ranges);
						
						Map<Integer, Integer> register_alignval_map = new HashMap<Integer, Integer>();
						if(bufferInfo.bufferVars.contains(var)){
							String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, datastream_vec.get(0));
							VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
							List<List<Integer>> temp_var_ranges = ranges.subList(1, var_dims);
							List<Integer> temp_var_offsets = bufferInfo.var_offset_map.get(var).subList(1, var_dims);
							int temp_data_stream = DTilerSIMDUtility.encodeDep(datastream_vec.subList(1, datastream_vec.size()), temp_var_offsets);
							register_alignval_map.put(temp_data_stream, bufferInfo.var_datastream_register_aligne_value_map.get(var).get(data_stream));
							
							String prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + "B" + block_num  + temp_buffer_var.getName();
							int[] vec = new int[temp_buffer_var.getDomain().getNIndices()];
							SIMDStmtConversionUtility.getRegNameWithinRanges(0, temp_buffer_var, temp_var_ranges, temp_var_offsets, register_alignval_map, rotate, vec, prefix, vtype, var_datastream_regs_map.get(var).get(data_stream));
						}else{
							register_alignval_map.put(data_stream, bufferInfo.var_datastream_register_aligne_value_map.get(var).get(data_stream));
							String prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + "B" + block_num + var.getName();
							int[] vec = new int[var.getDomain().getNIndices()];
							SIMDStmtConversionUtility.getRegNameWithinRanges(0, var, ranges, bufferInfo.var_offset_map.get(var), register_alignval_map, rotate, vec, prefix, vtype, var_datastream_regs_map.get(var).get(data_stream));
						}
					}
					
					//construct copies
					List<String> data_stream_regs = var_datastream_regs_map.get(var).get(data_stream);
					int l_start = data_stream_regs.size() - (nLoads-1);
					int r_start = data_stream_regs.size() - 2*(nLoads-1);
//					//the last block
					if(n == unrollFactor[bufferInfo.tileDims - 1] - 1){
						l_start = 0;
						r_start = data_stream_regs.size() - (nLoads-1);
					}
					if((n < unrollFactor[bufferInfo.tileDims - 1] - 1) || !isRotate || n == 0){
						for(int i = 0; i < (nLoads-1); i++){
							//create register for the left hand side
							String lregName = data_stream_regs.get(i+l_start);
							if(regs.get(lregName) == null){
								VRegister lreg = _fact.createVRegister(vtype, lregName);
								regs.put(lregName, lreg);
							}
							//construct the statement lreg = rreg
							String rregName = data_stream_regs.get(i+r_start);
							String reg_copy_stmt_str = lregName  + "=" + rregName;
							Statement reg_copy_stmt = _cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), reg_copy_stmt_str);
							stmtCount++;
							copies.add(reg_copy_stmt);
						}
					}else{
						if(DEBUG)	System.out.println("check whether the copy is needed for rotatble implemetation");
						if(nLoads > unrollFactor[bufferInfo.tileDims - 1]){	//extra copy is required
							//create nLoads-1 temp_regsister
							String prefix = SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + "RT" + block_num  + var.getName();
							List<Integer> offsets = bufferInfo.var_offset_map.get(var);
							for(int i = 0; i < datastream_vec.size(); i++)	prefix += "_" + (-datastream_vec.get(i) + offsets.get(i));
							for(int i = 0; i < (nLoads-1); i++){
								//create registers for intermediate copy
								String regName = prefix + "_" + i;
								if(regs.get(regName) == null){
									VRegister reg = _fact.createVRegister(vtype, regName);
									regs.put(regName, reg);
								}
								//construct reg = rreg
								String rregName = data_stream_regs.get(i+r_start);
								String reg_copy_stmt_str0 = regName + "=" + rregName;
								Statement reg_copy_stmt0 = _cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), reg_copy_stmt_str0);
								stmtCount++;
								copies.add(reg_copy_stmt0);
							}
							
							for(int i = 0; i < (nLoads-1); i++){
								//construct lreg = reg
								String regName = prefix + "_" + i;
								if(regs.get(regName) == null){
									VRegister reg = _fact.createVRegister(vtype, regName);
									regs.put(regName, reg);
								}
								String lregName = data_stream_regs.get(i+l_start);
								String reg_copy_stmt_str1 = lregName + "=" + regName;
								Statement reg_copy_stmt1 = _cgfact.createStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), reg_copy_stmt_str1);
								stmtCount++;
								copies.add(reg_copy_stmt1);
							}
						}
					}
				}
			}
		
		
		return copies; 
	}
}
	