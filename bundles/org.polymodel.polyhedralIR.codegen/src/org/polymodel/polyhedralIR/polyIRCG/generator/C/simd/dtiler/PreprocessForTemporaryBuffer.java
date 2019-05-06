package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ExpressionPrinterForScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.DTilerBufferingUtility.FullTileBufferingInformation;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class PreprocessForTemporaryBuffer{
	public static boolean DEBUG = false;
	
	public final static PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	public final static PolyhedralIRUserFactory _IRfact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected final CodeUnit cu;
	protected final TargetMapping tm;
	protected final TiledCodeGenOptions options;
	
	
	//variables for local recording
	//protected VariableInitialization initVariableBody;
	protected FullTileBufferingInformation bufferInfo;
	SIMDPreprocessForFullTile simdFullTileProcess;
	
	protected int stmtCount;	//record the statement number count
	protected int cons1;	//record the current value for the first constant dimension
	protected int cons2; 	//record the current value for the second constant dimension (third dimension)
	
	protected PreprocessForTemporaryBuffer(CodeUnit _cu, TargetMapping _tm, TiledCodeGenOptions _options){
		cu = _cu;
		tm = _tm;
		options = _options;
		stmtCount = 0;
		cons1 = 0;
		cons2 = 0;
		initialization();
	}
	
	//initialize the local recording variables
	private void initialization(){
		Function entryFunction = null; 
		//find the entry function
		for(Function func: cu.getFunctions()){
			if(func.isEntryPoint()){
				entryFunction = func;
				break;
			}
		}
		
		//a variable must be specified when temporary buffering or vectorization optimizations are applied
		if((options.vecVar == null || options.vecVar.size()== 0) && (options.var_dom_map == null || options.var_dom_map.size() == 0) ){
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
		if(options.vecVar != null && options.vecVar.size() > 0){
			List<VariableDeclaration> vecVars = new LinkedList<VariableDeclaration>();
			for(String varName: options.vecVar){
				vecVars.add(tm.getContainerSystem().getVariableDeclaration(varName));
			}
			fullTileStmts.addAll(DTilerProcessUtility.extractCandidateStmts(tiledloops, vecVars));
		}
		
		if(options.var_dom_map != null && options.var_dom_map.size() > 0){
			Map<VariableDeclaration, Domain> vecVar_dom_map = new HashMap<VariableDeclaration, Domain>();
			for(Map.Entry<String, Domain> var_dom_entry : options.var_dom_map.entrySet()){
				vecVar_dom_map.put(tm.getContainerSystem().getVariableDeclaration(var_dom_entry.getKey()), var_dom_entry.getValue());
			}
			fullTileStmts.addAll(DTilerProcessUtility.extractCandidateStmts(tiledloops, vecVar_dom_map));
		}
		
		if(fullTileStmts.size() == 0){
			throw new RuntimeException("No candidtate statement can be extracted for optimization!");
		}
		
//		for(EquationAsStatement stmt: fullTileStmts) {
//			System.out.println("the extracted statemet : " + stmt.getName());
//		}
		//configure it at the Tiled Codegen options for later pass into DTiler
		options.optimalPointLoopStmts = new LinkedList<List<String>>();
		List<String> statement_pattern = new ArrayList<String>();
		for(EquationAsStatement stmt: fullTileStmts){
			statement_pattern.add(stmt.getName());
		}
		options.optimalPointLoopStmts.add(statement_pattern);
		
		int level = 1;
		if(options.multiPassSequential || options.multiPassWavefront){
			level = 3;
		}
		bufferInfo = new FullTileBufferingInformation(fullTileStmts, tm.getSpaceTimeLevel(0).getNumberOfTiledDimensions(), level);
		bufferInfo.initVariableBody = initVariableBody;
		if(options.vec)
			simdFullTileProcess = new SIMDPreprocessForFullTile(cu, tm, options, cons1, cons2, bufferInfo, "G1");
	}
	
	public static void process(CodeUnit _cu, TargetMapping _tm, TiledCodeGenOptions _options){
		PreprocessForTemporaryBuffer processor = new PreprocessForTemporaryBuffer(_cu, _tm, _options);
		if(_options.vec){
			processor.simdFullTileProcess.addBufferPaddingBody();
		}
		processor.addTemporaryBufferVariables();
		if(_options.vec && _options.pointer){
			//processor.addAddressBookKeepingVariables();
			processor.simdFullTileProcess.addAddressBookKeepingVariables();
		}
		processor.generateOptimizedFullTilePointLoop();
	}
	
	private void addTemporaryBufferVariables(){
		for(VariableDeclaration var: bufferInfo.bufferVars){
			//extract the halo size for the variable
			List<Integer> halo = bufferInfo.var_halo_map.get(var);
			Domain bufferDom = null;
			if(bufferInfo.padded){
				bufferDom = DTilerBufferingUtility.constructTempBufferDomain(var, bufferInfo.tileSizes, halo, bufferInfo.var_padded_map.get(var));
			}else{
				bufferDom = DTilerBufferingUtility.constructTempBufferDomain(var, bufferInfo.tileSizes, halo);
			}
			AffineFunction identity_access = PolyhedralIRUtility.createIdentityFunction(bufferDom);
			int nbuffer = halo.get(0);	//allocate number of time slices temporary buffer for each variable
			for(int i = 0; i <= nbuffer; i++){
				VariableDeclaration temp_var = DTilerBufferingUtility.createTempBufferVar(var, i, bufferDom.copy());
				bufferInfo.buffername_var_map.put(temp_var.getName(), temp_var);
				//update the targetmapping
				MemoryMap mm = TargetMappingUserFactory.createMemoryMap(temp_var, identity_access.copy(), null, tm.getMemorySpace(temp_var.getName()));
				tm.getMemoryMaps().put(temp_var, mm);
				SpaceTimeMap stmap = TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(temp_var);
				tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(temp_var.getName(), stmap);
				
				//add the code gen component
				CVariable v = null;
				if(bufferInfo.isAligned){
					v = _fact.createCVariable(tm.getMemorySpace(temp_var.getName()), true, false, true, true, bufferInfo.var_frontPadding_map.get(var));
				}else{
					v = _fact.createCVariable(tm.getMemorySpace(temp_var.getName()), true, false);
				}
				cu.getVariables().add(v);
				bufferInfo.function.getSpecialLocals().add(v);
				bufferInfo.initVariableBody.getSpecialLocals().add(v);
				Function alloc_func = createBufferAllocation(temp_var);
				if(bufferInfo.padded){
					for(String padded_index: bufferInfo.var_padded_map.get(var)){
						alloc_func.getParameters().add(_fact.createBasicVariable(padded_index, "int"));
					}
				}
				cu.getFunctions().add(alloc_func);
				Function free_func = createBufferFree(temp_var);
				cu.getFunctions().add(free_func);
			}
			//add a temporary swapping buffer
			VariableDeclaration temp_swap_var = DTilerBufferingUtility.createTempBufferVar(var, DTilerBufferingUtility.getTempSwapBufferName(var), bufferDom.copy());
			//update the targetmapping
			MemoryMap tmp_mm = TargetMappingUserFactory.createMemoryMap(temp_swap_var, identity_access.copy(), null, tm.getMemorySpace(temp_swap_var.getName()));
			tm.getMemoryMaps().put(temp_swap_var, tmp_mm);
			SpaceTimeMap tmp_stmap = TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(temp_swap_var);
			tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(temp_swap_var.getName(), tmp_stmap);
			
			//handle the special temp variable specially
			CVariable tmp_v = _fact.createCVariable(tm.getMemorySpace(temp_swap_var.getName()), true, false);
			cu.getVariables().add(tmp_v);
			bufferInfo.function.getSpecialLocals().add(tmp_v);
			bufferInfo.initVariableBody.getSpecialLocals().add(tmp_v);
		}
	}
	
	
	private void generateOptimizedFullTilePointLoop(){
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
		
		CLoop optLoop = _fact.createCLoop(paramDom, 2);	//add two more constant dimension: one before the time dimension, and one after time dimension
		optLoop.setDeclareIterators(false);
		//construct the memory allocation function an statement call
		List<VariableDeclaration> tempBufferVars = new LinkedList<VariableDeclaration>();
		for(Map.Entry<String, VariableDeclaration> buffer_var_entry: bufferInfo.buffername_var_map.entrySet()){
			tempBufferVars.add(buffer_var_entry.getValue());
		}
		
		optLoop.getStatements().addAll(getBufferAllocationFunctionCallStmts(paramList, tempBufferVars));
		//construct value copy statement for each variable
		optLoop.getStatements().addAll(getBufferInitializationStatements(paramList, bufferInfo.bufferVars));
		//construct the halo load statement
		optLoop.getStatements().addAll(getHaloLoadStatements(paramList, bufferInfo.bufferVars));
		
		if(options.vec){
			simdFullTileProcess.cons1 = cons1;
			simdFullTileProcess.cons2 = cons2;
			//construct the vectorized statements
			optLoop.getStatements().addAll(simdFullTileProcess.getSIMDComputeBodyStatements());
			cons1 = simdFullTileProcess.cons1;
			cons2 = simdFullTileProcess.cons2;
		}else{
			//construct the main computation statements
			optLoop.getStatements().addAll(getMainComputationStatements(paramList, bufferInfo.stmts));
		}
		//construct the halo copy back statements
		optLoop.getStatements().addAll(getHaloStoreStatements(paramList, bufferInfo.bufferVars));
//		//construct the buffer swap statement for each variable
		optLoop.getStatements().addAll(getBufferSwapStatements(paramList, bufferInfo.bufferVars));
		//construct the final copy back statements
		optLoop.getStatements().addAll(getFinalBufferCopyBackStatements(paramList, bufferInfo.bufferVars));
		//construct the memory free function
		optLoop.getStatements().addAll(getBufferFreeFunctionCallStmts(paramList, tempBufferVars));

		bufferInfo.mainLoop.setOptimizedPointLoop(optLoop);
	}
	
	/**
	 * Get the set of load statements that loads the value from the global variable to the halo region
	 * A load statement is constructed for each temp buffer variable at each halo dimension
	 * @param startDom
	 * @param vars
	 * @return
	 */
	private List<Statement> getHaloLoadStatements(List<String> params, List<VariableDeclaration> vars){
		List<Statement> loads = new LinkedList<Statement>();
		
		cons1++; 	cons2 = 0;
		for(VariableDeclaration var: vars){	//for each variable
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
			
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
			//int nbuffer = bufferInfo.var_halo_map.get(var).get(0);
			//load the halo for the most recent plane which should be stored in the 1st buffer
			//for each halo dimension
			Domain loadedDom = null;
			for(int j = 1; j < bufferInfo.var_halo_map.get(var).size(); j++){
				Statement loadStmt = getHaloLoadStatementForVar(startDom, var, 1, j, loadedDom);
				if(loadedDom == null)	loadedDom = loadStmt.getDomain().copy();
				else	loadedDom = loadedDom.union(loadStmt.getDomain().copy());
				loads.add(loadStmt);	
			}
//			for(int i = 1; i <= nbuffer; i++){	//for each temporary buffer
//				//for each halo dimension
//				Domain loadedDom = null;
//				for(int j = 1; j < bufferInfo.var_halo_map.get(var).size(); j++){
//					Statement loadStmt = getHaloLoadStatementForVar(startDom, var, i, j, loadedDom);
//					if(loadedDom == null)	loadedDom = loadStmt.getDomain().copy();
//					else	loadedDom = loadedDom.union(loadStmt.getDomain().copy());
//					loads.add(loadStmt);	
//				}
//			}
		}
		
		return loads;
	}
	

	private Statement getHaloLoadStatementForVar(Domain startDom, VariableDeclaration var, int n, int dim, Domain loadedDom){
		String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, n);
		VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
		
		Domain stmtDom = constructHaloStatementDomain(startDom, var, dim, true);
		if(loadedDom != null){
			stmtDom = stmtDom.difference(loadedDom);
		}
		
		//construct the access to var
		AffineFunction access = getOriVarAccessFunction(stmtDom.getParamNames(), var, n);
		
		List<String> access_strs = new LinkedList<String>();
		for(AffineExpression access_expr: access.getExpressions()){
			access_strs.add(access_expr.toString(OUTPUT_FORMAT.C));
		}
		
		String load_stmt_str = temp_buffer_var.getName() + "(" + CodeGenUtility.toStringList(temp_buffer_var.getDomain().getIndexNames(), ",") + ")";
		load_stmt_str += "=";
		load_stmt_str += var.getName() + "(" + CodeGenUtility.toStringList(access_strs, ",") + ")";
		
		Statement load_stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, load_stmt_str);
		stmtCount++;
		
		return load_stmt;
	}
	
	/**
	 * Get the list of statement that shifts the buffers for one time step for the next computation
	 * @param startDom
	 * @param vars
	 * @return
	 */
	private List<Statement> getBufferSwapStatements(List<String> params, List<VariableDeclaration> vars){
		List<Statement> swaps = new LinkedList<Statement>();
		
		cons2++;
		for(VariableDeclaration var: vars){
			//construct the indices list
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
			Domain stmtDom = constructBufferSwapStatementDomain(startDom);
			
			int nbuffer = bufferInfo.var_halo_map.get(var).get(0);
			String swap_buffer_name  = DTilerBufferingUtility.getTempSwapBufferName(var);
			//construct swap_buffer = buffer_nbuffer
			String init_swap_stmt_str = swap_buffer_name + "=" + DTilerBufferingUtility.getTempBufferName(var, nbuffer);
			Statement init_swap_stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom.copy(), init_swap_stmt_str);
			stmtCount++;
			swaps.add(init_swap_stmt);
			for(int i = nbuffer; i >= 1; i--){
				String l_buffer = DTilerBufferingUtility.getTempBufferName(var, i);
				String r_buffer = DTilerBufferingUtility.getTempBufferName(var, i-1);
				String wap_stmt_str = l_buffer + "=" + r_buffer;
				Statement swap_stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom.copy(), wap_stmt_str);
				stmtCount++;
				swaps.add(swap_stmt);
			}
			//add final buffer swap statement
			String final_swap_stmt_str = DTilerBufferingUtility.getTempBufferName(var, 0) + "=" + swap_buffer_name;
			Statement final_swap_stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom.copy(), final_swap_stmt_str);
			stmtCount++;
			swaps.add(final_swap_stmt);
		}
		
		return swaps;
	}
	
	private Domain constructBufferSwapStatementDomain(Domain startDom){
		Domain stmtDom = startDom.copy();
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> indexVars = stmtDom.getIndices();
		
		//set the first (constant) dimension to cons1 = 2
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)), 
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//set the second (time) dimension to t0 <= c1 < t0 + ts0
		//add c1 < t0 + ts0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), tileSizeVars.get(0)), 
				ComparisonOperator.LT));
		//add t0 <= c1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileIndexVars.get(0)), 
				IntExpressionBuilder.affine(indexVars.get(1)), 
				ComparisonOperator.LE));
		//set the third (constant) dimension to cons2: c2 = 3
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
		
		//set the rest dimension to 0
		for(int i = 3; i < startDom.getNIndices(); i++){
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
					IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
		}
		return stmtDom;
	}
	
	/**
	 * Get the set of statements that stores the halo region back to the original memory space
	 * A store statement is constructed for each variable at each halo dimension
	 * @param startDom
	 * @param vars
	 * @return
	 */
	private List<Statement> getHaloStoreStatements(List<String> params, List<VariableDeclaration> vars){
		List<Statement> stores = new LinkedList<Statement>();
		
		cons2++;
		for(VariableDeclaration var: vars){
			//construct the index list for the statement domain
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
			
			Domain storedDom = null;
			for(int i = 1; i < bufferInfo.var_halo_map.get(var).size(); i++){
				Statement storeStmt = getHaloStoreStatementsForVar(startDom, var, i, storedDom);
				if(storedDom == null)	storedDom = storeStmt.getDomain().copy();
				else	storedDom = storedDom.union(storeStmt.getDomain().copy());
				stores.add(storeStmt);
			}
		}
		return stores;
	}
	
	
	private Statement getHaloStoreStatementsForVar(Domain startDom, VariableDeclaration var, int dim, Domain storedDom){
		String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, 0);
		VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
		
		//get the statement domain
		Domain stmtDom = constructHaloStatementDomain(startDom, var, dim, false);
		if(storedDom != null)	stmtDom = stmtDom.difference(storedDom);
		
		if(DEBUG){
			System.out.println("the store statement domain for variable " + var.getName() + " at dimension: " + dim + " is " + stmtDom);
		}
		
		//construct the access to var
		AffineFunction var_access = getOriVarAccessFunction(stmtDom.getParamNames(), var, 0);
		
		List<String> var_access_strs = new LinkedList<String>();
		for(AffineExpression access_expr: var_access.getExpressions()){
			var_access_strs.add(access_expr.toString(OUTPUT_FORMAT.C));
		}
		
		String store_stmt_str = var.getName() + "(" + CodeGenUtility.toStringList(var_access_strs, ",") + ")";
		store_stmt_str += "=" + temp_buffer_var.getName() + "(" + CodeGenUtility.toStringList(temp_buffer_var.getDomain().getIndexNames(), ",") + ")";
		
		//construct the final statement
		Statement store_stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, store_stmt_str);
		stmtCount++;
		
		return store_stmt;
	}
	

	/**
	 * For variable var with dimension (t, i0, i1, ... id) get the memory access function 
	 * for access function (t, i0, i1, ..., id)->(t-n, i0 + ti0, i1 + ti1, i2 + ti2, ..., id+tid)
	 * @param params
	 * @param var
	 * @param n
	 * @return
	 */
	private AffineFunction getOriVarAccessFunction(List<String> params, VariableDeclaration var, int n){
		List<Integer> halo = bufferInfo.var_halo_map.get(var);
		List<String> affine_exprs = new LinkedList<String>();
		List<String> indices = var.getDomain().getIndexNames();
		affine_exprs.add(indices.get(0) + "-" + n);
		for(int i = 1; i < indices.size(); i++){
			String expr = indices.get(i) + "+" + bufferInfo.tileIndex.get(i) + "-" + halo.get(i);
			affine_exprs.add(expr);
		}
		AffineFunction  access = PolyhedralIRUtility.parseAffineFunctionFromString(params, indices, affine_exprs);
		//System.out.println("current affine function " + access + " with params: " + access.getParamNames());
		AffineFunction ori_access = tm.getSpaceTimeLevel(0).getAccessFunction(var).copy();
		for(int i = 0; i < bufferInfo.tileIndex.size(); i++){
			ori_access.addParameterDimension(bufferInfo.tileIndex.get(i));
		}
		access = ori_access.compose(access);
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
		access = access.compose(identity);
		
		return access;
	}
	
	/**
	 * Construct the statement Domain for halo store/load statement along dimension dim for the variable var
	 * @param startDom
	 * @param var
	 * @param dim
	 * @return
	 */
	private Domain constructHaloStatementDomain(Domain startDom, VariableDeclaration var, int dim, boolean load){
		Domain stmtDom = startDom.copy();
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> indexVars = stmtDom.getIndices();
		
		//set the first (constant) dimension to cons1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)), 
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//set the second (time) dimension to t0 <= c1 < t0 + ts0
		//add c1 < t0 + ts0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
		        DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), tileSizeVars.get(0)), 
		        ComparisonOperator.LT));
		//add t0 <= c1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileIndexVars.get(0)), 
				IntExpressionBuilder.affine(indexVars.get(1)), 
				ComparisonOperator.LE));
		//set the third (constant) dimension to c2 = cons2
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
		
		List<Integer> halo = bufferInfo.var_halo_map.get(var);
		int halo_dim = halo.size() - 1;
		//set middle dimension until the data dimension to 0
		for(int i = 3; i < startDom.getNIndices() - halo_dim; i++){
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
					IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
		}
		
		int startDim = startDom.getNIndices() - halo_dim;
		for(int i = 1; i < halo.size(); i++){
			if(i == dim){
				if(load){
					//add c_{i + startDom - 1} < halo_{i}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							IntExpressionBuilder.constant(halo.get(i)), 
							ComparisonOperator.LT));
					//add 0 <= c_{i + startDom - 1}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(0), 
							IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							ComparisonOperator.LE));
					
				}else{
					//add c_{i + startDom - 1} < ts_{i} + halo_{i}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), halo.get(i)), 
							ComparisonOperator.LT));
					//add ts_{i} <= c_{i + startDom - 1}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
							IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							ComparisonOperator.LE));
				}
			}else{
				//add c_{i + startDom - 1} < ts_{i} + halo_{i}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
						DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), halo.get(i)), 
						ComparisonOperator.LT));
				if(load){
					//add 0 <= c_{i + startDom - 1}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(0), 
							IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							ComparisonOperator.LE));
				}else{
					//add halo_{i} <= c_{i + startDom - 1}
					stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(halo.get(i)), 
							IntExpressionBuilder.affine(indexVars.get(i + startDim - 1)), 
							ComparisonOperator.LE));
				}
			}
		}
		
		stmtDom = PolyhedralIRUtility.parseDomain(stmtDom.getParamNames(), stmtDom.toString());
		return stmtDom;
	}
	
	
	private List<Statement> getMainComputationStatements(List<String> params, List<EquationAsStatement> oriComputs){
		List<Statement> bufferComputeStmts = new LinkedList<Statement>();
		cons2++;
		//create the main statements
		for(EquationAsStatement stmt: oriComputs){
			VariableDeclaration stmtVar = stmt.getVarDecl();
			List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(stmtVar.getDomain().getIndexNames(), bufferInfo.tileDims);
			Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.tileOffsets, bufferInfo.tileDims);
			
			Domain stmtDom = constructBufferComputationStmtDomain(startDom, stmtVar);
			Expression rexp = convertExp(stmt.getRhs());
			//Construct the computation equation
			String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(stmtVar, 0);	//the computed value is put in the first temporary buffer
			VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
			StandardEquation stEq = _IRfact.createStandardEquation(temp_buffer_var, rexp);
			//add the equation to the current system temporary
			cu.getSystem().getEquations().add(stEq);
			String rexp_str = ExpressionPrinterForScheduledC.print(rexp, true);
			//remove the temporary equation
			cu.getSystem().getEquations().remove(stEq);
			
			//create the statement
			String comput_stmt_str = temp_buffer_var.getName() + "(" + CodeGenUtility.toStringList(temp_buffer_var.getDomain().getIndexNames(), ",") + ")";
			comput_stmt_str += "=" + rexp_str;
			Statement bufferComputeStmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, comput_stmt_str);
			stmtCount++;
			bufferComputeStmts.add(bufferComputeStmt);
		}
		
		return bufferComputeStmts;
	}
	

	private Domain constructBufferComputationStmtDomain(Domain startDom, VariableDeclaration stmtVar){
		Domain stmtDom = startDom.copy();
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> indexVars = stmtDom.getIndices();
		//set the first constant dimension to 2: c0 = 2
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)),
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//set the second (time) dimension to t0 <= c1 < t0 + ts0
		//add c1 < t0 + ts0
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), tileSizeVars.get(0)), 
				ComparisonOperator.LT));
		//add t0 <= c1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileIndexVars.get(0)), 
				IntExpressionBuilder.affine(indexVars.get(1)), 
				ComparisonOperator.LE));
		//set the third (constant) dimension to 1: c2 = 1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
	
		//the rest dimension is shifted tile domain halo_i <= c_{i+2} < tsi + halo_i
		List<Integer> halo = bufferInfo.var_halo_map.get(stmtVar);
		int temp_var_dims = halo.size() - 1;
		for(int i = 3; i < stmtDom.getNIndices() - temp_var_dims; i++){
			//add ci = 0
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
					IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
		}
		
		int startDim = stmtDom.getNIndices() - temp_var_dims;
		for(int i = 0; i < temp_var_dims; i++){
			//add c_{i+startDim} < ts_{i+1} + halo_{i+1}
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+startDim)), 
					DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i+1), halo.get(i+1)),
					ComparisonOperator.LT));
			//add halo_{i+1} <= c_{i+startDim}
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.constant(halo.get(i+1)), 
					IntExpressionBuilder.affine(indexVars.get(i+startDim)), 
					ComparisonOperator.LE));
			
		}

		return stmtDom;
	}
	
	/**
	 * Replace the buffered variable with the corresponding temp buffer variable
	 * @param exp
	 * @return
	 */
	private Expression convertExp(Expression exp){
		if(exp == null)	return null;
		//start copy the whole expression and replace the corresponding variable
		Expression final_exp = null;
		if(exp instanceof BinaryExpression){
			Expression lexp = convertExp(((BinaryExpression)exp).getLexp());
			Expression rexp = convertExp(((BinaryExpression)exp).getRexp());
			
			final_exp = _IRfact.createBinaryExpression(((BinaryExpression)exp).getOperator(), lexp, rexp);
		}else if(exp instanceof RestrictExpression){
			final_exp = convertExp(((RestrictExpression)exp).getExpr());
		}else if(exp instanceof VariableExpression){	//possible target
			//check whether the variable is one of the buffered variable
			VariableDeclaration var = ((VariableExpression)exp).getVarDecl();
			if(bufferInfo.bufferVars.contains(var)){	//replace it with access to the first(0th) buffer 
				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, 0);
				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
				
				final_exp = _IRfact.createVariableExpression(temp_buffer_var);
			}else{
				final_exp = exp.copy();
			}
		}else if(exp instanceof DependenceExpression){
			Expression sub_exp = ((DependenceExpression)exp).getExpr();
			AffineFunction dep_func = ((DependenceExpression)exp).getDep();
			boolean buffered_var = false;
			if(sub_exp instanceof VariableExpression){
				VariableDeclaration var = ((VariableExpression)sub_exp).getVarDecl();
				if(bufferInfo.bufferVars.contains(var)){
					buffered_var = true;
					List<Integer> dep_vec = DTilerProcessUtility.extractDepVec(dep_func);
					String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, dep_vec.get(0));
					VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
					//reconstruct dependence function
					AffineFunction dep_func_copy = dep_func.copy();
					int[] constant = new int[dep_vec.size() - 1];
					for(int i = 1; i < dep_vec.size(); i++){
						constant[i-1] = -dep_vec.get(i);
					}
					
					AffineFunction new_dep_func = PolyhedralIRUtility.createUniformFunction(dep_func_copy.getParams(), dep_func_copy.getIndices().subList(1, dep_func_copy.getNIndices()), constant);
			
					VariableExpression var_exp = _IRfact.createVariableExpression(temp_buffer_var);
					final_exp = _IRfact.createDependenceExpression(new_dep_func, var_exp);
					
				}
			}
			
			if(!buffered_var){
				List<String> params = new LinkedList<String>();
				params.addAll(dep_func.getParamNames());
				params.add(dep_func.getIndexNames().get(0));
				List<String> indices = dep_func.getIndexNames().subList(1, dep_func.getNIndices());
				List<String> affine_expr_strs = new LinkedList<String>();
				for(AffineExpression expr: dep_func.getExpressions()){
					affine_expr_strs.add(expr.toString(OUTPUT_FORMAT.C));
				}
				AffineFunction new_dep_func = PolyhedralIRUtility.parseAffineFunctionFromString(params, indices, affine_expr_strs);
				
				Expression converted_sub_exp = convertExp(sub_exp);
				final_exp = _IRfact.createDependenceExpression(new_dep_func, converted_sub_exp);
			}
		}else{
			return exp.copy();
		}
		return final_exp;
		
	}		

	private Domain constructBufferFinalStmtDomain(Domain startDom, VariableDeclaration var){
		Domain stmtDom = startDom.copy();
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> indexVars = stmtDom.getIndices();
		
		//set the first constant dimension to 2: c0 = 4
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)),
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//set the time dimension to ti1_l1 + ts1_l1 - 1
		List<IntExpression> sub_exprs = new LinkedList<IntExpression>();
		sub_exprs.add(IntExpressionBuilder.affine(tileIndexVars.get(0)));
		sub_exprs.add(IntExpressionBuilder.affine(tileSizeVars.get(0)));
		sub_exprs.add(IntExpressionBuilder.constant(-1));
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(1)), 
				IntExpressionBuilder.sum(sub_exprs), ComparisonOperator.EQ));
		//set second constant dimension 
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
		List<Integer> halo = bufferInfo.var_halo_map.get(var);
		for(int i = 1; i < halo.size(); i++){	//add shifted domain
//			//add c_{i + 2} < ts_{i} + halo_{i}
//			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
//					DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i), halo.get(i)), ComparisonOperator.LT));
			//add c_{i + 2} < ts_{i}
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
					IntExpressionBuilder.affine(tileSizeVars.get(i)), ComparisonOperator.LT));
			//add c_{i+2} >= halo_{i}
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i+2)), 
					IntExpressionBuilder.constant(halo.get(i)), ComparisonOperator.GE));
			
		}
		
		return stmtDom;
	}
	
	private List<Statement> getFinalBufferCopyBackStatements(List<String> params, List<VariableDeclaration> vars){
		List<Statement> finalStmts = new LinkedList<Statement>();
		
		cons1++;	cons2 = 0;
		for(VariableDeclaration var: vars){
			//the final computed value is stored in last n-1 temporary buffer
			for(int i = 1; i <= bufferInfo.var_halo_map.get(var).get(0); i++){	//copy back all the buffer that is needed
				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, i);
				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
			
				//construct statement domain for final copy back statement
				List<String> indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
				Domain startDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.var_halo_map.get(var), bufferInfo.tileDims);
				Domain stmtDom = constructBufferFinalStmtDomain(startDom, var);
			
				//construct the statement string
				AffineFunction var_access = getOriVarAccessFunction(stmtDom.getParamNames(), var, i-1);
				List<String> var_access_strs = new LinkedList<String>();
				for(AffineExpression access_expr: var_access.getExpressions()){
					var_access_strs.add(access_expr.toString(OUTPUT_FORMAT.C));
				}
				String copy_stmt_str = var.getName() + "(" + CodeGenUtility.toStringList(var_access_strs, ",") + ")";
				copy_stmt_str += "=";
				copy_stmt_str += temp_buffer_var.getName() + "(" + CodeGenUtility.toStringList(temp_buffer_var.getDomain().getIndexNames(), ",") + ")";
			
				Statement stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, copy_stmt_str);
				stmtCount++;
				finalStmts.add(stmt);
			}
		}
		
		return finalStmts;
	}
	
	private Domain constructBufferInitStmtDomain(int dims, List<String> params, VariableDeclaration var, VariableDeclaration temp_buffer_var, int n){
		List<Integer> var_halo = bufferInfo.var_halo_map.get(var);
		List<String> dom_indices = DTilerBufferingUtility.getBufferDomainIndexList(var.getDomain().getIndexNames(), bufferInfo.tileDims);
		Domain stmtDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, dom_indices, var_halo, bufferInfo.tileDims);
		
		List<Variable> tileSizeVars = stmtDom.getParams().subList(stmtDom.getNParams() - 2*bufferInfo.tileDims, stmtDom.getNParams() - bufferInfo.tileDims);
		List<Variable> tileIndexVars = stmtDom.getParams().subList(stmtDom.getNParams() - bufferInfo.tileDims, stmtDom.getNParams());
		List<Variable> indices = stmtDom.getIndices();
		
		//sect c0 = cons1
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(0)), 
				IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
		//set c1 = ti0 - n
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(1)), 
				DTilerProcessUtility.binaryAddExpression(tileIndexVars.get(0), -n), ComparisonOperator.EQ));
		//set c2 = cons2
		stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(2)), 
				IntExpressionBuilder.constant(cons2), ComparisonOperator.EQ));
		
		//compute the halo for current time step
		List<List<Integer>> var_deps_collect = new LinkedList<List<Integer>>();
		for(List<Integer> cur_dep: bufferInfo.var_deps_map.get(var)){
			if(cur_dep.get(0) == n){
				var_deps_collect.add(cur_dep);
			}
		}
		List<List<Integer>> cur_region = DTilerProcessUtility.getRanges(var.getDomain().getNIndices(), var_deps_collect);
		for(int i = 3; i < stmtDom.getNIndices(); i++){
			if(n == 1){	//for the first time step avoid reload the halo region
				//add ci >= halo_{i-2}
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(i)), 
						IntExpressionBuilder.constant(var_halo.get(i-2)), ComparisonOperator.GE));
			}else{
				//add ci >= halo_{i-2} - cur_region_{i-2}_1	//1 gives the lower bound, 0 gives the upper bound
				int lower_dis = var_halo.get(i-2) - cur_region.get(i-2).get(1);
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(i)), 
						IntExpressionBuilder.constant(lower_dis), ComparisonOperator.GE));
			}
		
			//add ci < ts_{i-2} + halo_{i-2} - cur_region_{i-2}_0
			int upper_dis = var_halo.get(i-2) - cur_region.get(i-2).get(0);
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indices.get(i)), 
					DTilerProcessUtility.binaryAddExpression(tileSizeVars.get(i - 2), upper_dis), 
					ComparisonOperator.LT));
		}
		
	
		return stmtDom;
	}

	private List<Statement> getBufferInitializationStatements(List<String> params, List<VariableDeclaration> vars){
		List<Statement> initStmts = new LinkedList<Statement>(); 
		
		cons1++; cons2 = 0;
		for(VariableDeclaration var: vars){
			int nbuffer = bufferInfo.var_halo_map.get(var).get(0);		
			//initialize all the buffers
			for(int i = 1; i <= nbuffer; i++){
				String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, i);
				VariableDeclaration temp_buffer_var = bufferInfo.buffername_var_map.get(temp_buffer_name);
				Domain stmtDom = constructBufferInitStmtDomain(temp_buffer_var.getDomain().getNIndices() + 3, params, var, temp_buffer_var, i);
				
				initStmts.add(getBufferInitializationStmtForVar(stmtDom, var, temp_buffer_var));
			}
		}
		return initStmts;
	}
	
	
	private Statement getBufferInitializationStmtForVar(Domain stmtDom, VariableDeclaration var, VariableDeclaration temp_buffer_var){
		/**
		 * Create access function for variable var: (i0, i1, i2, ..., id -> i0, i1 + t1 - halo_1, i2 + t2 - halo_2, ..., id + td - halo_d)
		 * skip the two constant dimension
		 */
		List<String> affine_exprs = new LinkedList<String>();
		List<String> indices = var.getDomain().getIndexNames();
		List<Integer> halo = bufferInfo.var_halo_map.get(var);
		affine_exprs.add(indices.get(0));
		for(int i = 1; i < indices.size(); i++){
			String expr = indices.get(i) + " + " + bufferInfo.tileIndex.get(i) + "-" + halo.get(i);
			affine_exprs.add(expr);
		}
		
		AffineFunction access = PolyhedralIRUtility.parseAffineFunctionFromString(stmtDom.getParamNames(), indices, affine_exprs);
		
		access = access.compose(tm.getSpaceTimeLevel(0).getAccessFunction(var));
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
		access = access.compose(identity);
		
		List<String> access_strs = new LinkedList<String>();
		for(AffineExpression access_expr: access.getExpressions()){
			access_strs.add(access_expr.toString(OUTPUT_FORMAT.C));
		}
		
		String copy_stmt = temp_buffer_var.getName() + "(" + CodeGenUtility.toStringList(temp_buffer_var.getDomain().getIndexNames(), ",") + ")";
		copy_stmt += "=" + var.getName() + "(" + CodeGenUtility.toStringList(access_strs, ",") + ")";
		
		Statement stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, copy_stmt);
		stmtCount++;
		
		return stmt;
	}

	
	private List<Statement> getBufferAllocationFunctionCallStmts(List<String> params, List<VariableDeclaration> buffer_vars){
		List<Statement> stmts = new LinkedList<Statement>();
		for(VariableDeclaration buffer_var: buffer_vars){
			//create the statement domain
			List<String> indices = new LinkedList<String>();
			for(int i = 0; i < 3; i++) {
				String index = "c" + i;
				indices.add(index);
			}
			indices.addAll(buffer_var.getDomain().getIndexNames());
			Domain stmtDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices, bufferInfo.tileOffsets, bufferInfo.tileDims);
			List<Variable> indexVars = stmtDom.getIndices();
			for(int i = 0; i < stmtDom.getNIndices(); i++){	//set all the dimensin to 0
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
						IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
			}
			
			//construct the function call statement
			String func_name = DTilerBufferingUtility.getBufferAllocationFunctionName(buffer_var.getName());
			List<String> func_call_params = new LinkedList<String>();
			func_call_params.addAll(cu.getSystem().getParameters().getParamNames());
			for(String var_params: buffer_var.getDomain().getParamNames()){
				if(var_params.contains("padded")){
					func_call_params.add(var_params);
				}
			}
			String func_call = buffer_var.getName() + "=" + func_name + "(";
			func_call += CodeGenUtility.toStringList(func_call_params, ",");
			func_call += ")";
			
			//construct the statement
			Statement stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, func_call);
			stmtCount++;
			
			stmts.add(stmt);
		}
		
		return stmts;
	}
	
	private List<Statement> getBufferFreeFunctionCallStmts(List<String> params, List<VariableDeclaration> buffer_vars){
		List<Statement> stmts = new LinkedList<Statement>();
		cons1++; cons2 = 0;
		for(VariableDeclaration buffer_var: buffer_vars){
			//construct statement domain
			List<String> indices = new LinkedList<String>();
			for(int i = 0; i < 3; i++){
				indices.add("c"+i);
			}
			indices.addAll(buffer_var.getDomain().getIndexNames());
			Domain stmtDom = DTilerBufferingUtility.createBufferStmtStartDomain(params, indices,bufferInfo.tileOffsets, bufferInfo.tileDims);
			List<Variable> indexVars = stmtDom.getIndices();
			//set the first constant dimension to 4
			stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(0)), 
					IntExpressionBuilder.constant(cons1), ComparisonOperator.EQ));
			for(int i = 1; i < indexVars.size(); i++){
				stmtDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
						IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
			}
			
			//construct function all statement
			String func_name = DTilerBufferingUtility.getBufferFreeFunctionName(buffer_var);
			String func_call = func_name + "(" + CodeGenUtility.toStringList(cu.getSystem().getParameters().getParamNames(), ",") + "," + buffer_var.getName() + ")";
			
			//construct the statement
			Statement stmt = _fact.createStatement(DTilerBufferingUtility.getBufferStatementName(stmtCount), stmtDom, func_call);
			stmtCount++;
			
			stmts.add(stmt);
		}
		
		return stmts;
	}
	
	private Function createBufferAllocation(VariableDeclaration buffer_var){
		String func_name = DTilerBufferingUtility.getBufferAllocationFunctionName(buffer_var.getName());
				
		CodeGenVariable v = cu.findCGVariable(buffer_var.getName());	//create code generation variable for the variable
		
		Function function = _fact.createFunction(func_name, org.polymodel.polyhedralIR.codegen.xtend2.Utility.pointerType(v));
		
		function.getLocals().add(v);
		
		function.getBodies().add(_fact.createVariableInitialization(function));
		function.getBodies().add(_fact.createBody("return " + v.getName() + ";"));
		
		
		return function;
	}
	
	private Function createBufferFree(VariableDeclaration buffer_var){
		String func_name = DTilerBufferingUtility.getBufferFreeFunctionName(buffer_var);
		
		CodeGenVariable v = cu.findCGVariable(buffer_var.getName());
		
		Function function = _fact.createFunction(func_name, "void");
		
		function.getSpecialLocals().add(v);
		function.getOutputs().add(v);
		function.getBodies().add(_fact.createVariableFinalization(function));
		
		return function;
	}

	
}