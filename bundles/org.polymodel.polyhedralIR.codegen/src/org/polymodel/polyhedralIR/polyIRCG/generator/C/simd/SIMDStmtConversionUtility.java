package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.DTilerProcessUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.DTilerSIMDUtility;

public class SIMDStmtConversionUtility{
	public static final PolyIRCGSIMDUserFactory _fact = PolyIRCGSIMDUserFactory.INSTANCE;
	public static final PolyIRCGUserFactory _cgfact = PolyIRCGUserFactory.INSTANCE;
	
	public static boolean DEBUG = false;
 	
	public static String getVStmtName(int count, String stmtGroup){
		return SIMDCodeGenConstant.SIMDStmtNamePrefix + stmtGroup + count;
	}
	
	public static List<Integer> getIdentityDepVec(VariableDeclaration var){
		List<Integer> vec = new LinkedList<Integer>();
		
		for(int i = 0; i < var.getDomain().getNIndices(); i++){
			vec.add(0);
		}
		
		return vec;
	}
	
	
	/**
	 * Recursivesly construct the name of register within a range
	 */
	public static void getRegNameWithinRanges(int k, VariableDeclaration var, List<List<Integer>> ranges, List<Integer> offset, Map<Integer, Integer> aligned_registerval_map, 
					int rotate, int[] vec, String reg_prefix, VType vtype, List<String> regNames){
		if(k == var.getDomain().getNIndices() - 1){		//reach the last dimension
			List<Integer> dir_vec = new LinkedList<Integer>();
			for(int i = 0; i < k; i++)	dir_vec.add(vec[i]);
			int data_stream = DTilerSIMDUtility.encodeDep(dir_vec, offset);
			int aligned_registerval = aligned_registerval_map.get(data_stream);
			for(int i = -ranges.get(k).get(1); i < -ranges.get(k).get(0); i += vtype.getNElements()){
				//construct one vector
				//int innermost = (i + offset.get(k))%rotate;
				int innermost = (i+offset.get(k) - aligned_registerval)%rotate + aligned_registerval;
				String regName = reg_prefix + "_" + innermost;
				regNames.add(regName);
			}
			
			return;
		}
	
		for(int i= -ranges.get(k).get(1); i <= -ranges.get(k).get(0); i++){
			vec[k] = -i;
			String new_prefix = reg_prefix + "_" + (i + offset.get(k));
			getRegNameWithinRanges(k + 1, var, ranges, offset, aligned_registerval_map, rotate, vec,  new_prefix, vtype, regNames);
		}
		return;
	}
	
	/**
	 * get the unrolled dependences, the innermost dimension is not unrolled
	 * @param dim: current visited dimension number
	 * @param unrollDims: the offset for unrollFactors
	 * @param ori_deps:	the original dependence 
	 * @param unrollFactors
	 * @param cur_dep: the constructed unrolled dependence until the current dimension
	 * @param unrolled_deps: the solutions
	 */
	public static void getUnrolledDeps(int dim, int unrollDims, List<Integer> ori_deps, int[] unrollFactors, List<Integer> cur_dep, List<List<Integer>> unrolled_deps){
		if(dim == ori_deps.size() - 1){
			cur_dep.add(ori_deps.get(ori_deps.size() - 1));
			unrolled_deps.add(cur_dep);
			return;
		}
		
		for(int i = 0; i < unrollFactors[unrollDims + dim]; i++) {
			List<Integer> deps = new LinkedList<Integer>();
			deps.addAll(cur_dep);
			deps.add(ori_deps.get(dim) - i);
			getUnrolledDeps(dim + 1, unrollDims, ori_deps, unrollFactors, deps, unrolled_deps);
		}
		return;
	}
	
	/**
	 * Class that includes the basic information for each variable for vectorization
	 * @author zouyun
	 *
	 */
	public static class BasicVariableData{
		public final VariableDeclaration var;	
		public final CodeGenVariable codegenVar;
		public final AffineFunction mem_access;		//the memory access function for variables 
		public final boolean isPointer;
		public final List<List<Integer>> ranges;
		public final List<Integer> offset;
		public final Map<Integer, Integer> register_alignval_map;
		public final int rotate;
		
		public BasicVariableData(VariableDeclaration _var, CodeGenVariable _codegenVar, AffineFunction _access, List<List<Integer>> _ranges, List<Integer> _offset, Map<Integer, Integer> _register_alignval_map, int _rotate){
			var = _var;
			codegenVar = _codegenVar;
			mem_access = _access;
			isPointer = false;
			ranges = _ranges;
			offset = _offset;
			rotate = _rotate;
			register_alignval_map = _register_alignval_map;
		}
		
		public BasicVariableData(VariableDeclaration _var, CodeGenVariable _codegenVar, List<List<Integer>> _ranges, List<Integer> _offset, Map<Integer, Integer> _register_alignval_map, int _rotate){
			var = _var;
			codegenVar = _codegenVar;
			mem_access = null;
			isPointer = true;
			ranges = _ranges;
			offset = _offset;
			register_alignval_map = _register_alignval_map;
			rotate = _rotate;
		}
	}
	
	/**
	 * class for constructing the SIMD loads for a variable in a register block
	 * It generates all the registers and SIMD load statements required for a region specified by varData.ranges
	 * @author zouyun
	 *
	 */
	public static class ConstructLoadsForRanges {
		public List<Statement> loads;
		public Map<String, VRegister> regs;
		public Map<Integer, String> dep_regname_map;
		public int stmtCount;	//the start number for vectorized statement
		public String stmtGroup;
		public String regPrefix;
		
		//configuration local variables 
		protected int dims;	//number of dimensions of the compuation
		protected BasicVariableData varData;
		protected Domain stmtDom;	//the domain for the load statement, all the loads must share the same statement domain
		protected VType vtype;	//the SIMD instruction/register type
		
		public ConstructLoadsForRanges(BasicVariableData _varData, Domain _stmtDom, int _stmtCount, String _stmtGroup, VType _vtype){
			commonInit(_varData, _varData.var.getDomain().getNIndices(),_stmtDom,_stmtCount,_stmtGroup,_vtype);
			regPrefix = VRegNameConstruction.getVRegNamePrefix(varData.var, stmtGroup);
		}
		
		public ConstructLoadsForRanges(BasicVariableData _varData, Domain _stmtDom, int _dims, int _stmtCount, String _stmtGroup, String _regPrefix, VType _vtype){
			commonInit(_varData, _dims,_stmtDom,_stmtCount,_stmtGroup,_vtype);
			regPrefix = _regPrefix;
		}
		
		private void commonInit(BasicVariableData _varData, int _dims, Domain _stmtDom, int _stmtCount, String _stmtGroup, VType _vtype){
			varData = _varData;
			dims = _dims;
			stmtDom = _stmtDom;
			vtype = _vtype;
			stmtCount = _stmtCount;
			stmtGroup = _stmtGroup;
			loads = new LinkedList<Statement>();
			regs = new HashMap<String, VRegister>();
		}
		
		public void generate(){
			int[] vec = new int[dims];
			getLoadsAtDimk(0, vec, regPrefix);
		}
		
		private void getLoadsAtDimk(int k, int[] vec, String reg_prefix){
			if(k == dims - 1){	//the base case, start constructing the load instruction
				//encode the data stream
				List<Integer> dir_vec = new LinkedList<Integer>();
				for(int j = 0; j < k; j ++)	dir_vec.add(-vec[j]);
				int data_stream = DTilerSIMDUtility.encodeDep(dir_vec, varData.offset);
				int register_alignval = varData.register_alignval_map.get(data_stream);
				for(int i = -varData.ranges.get(k).get(1); i < -varData.ranges.get(k).get(0); i += vtype.getNElements()){
					//construct one vector
					//int innermost = (i + varData.offset.get(k))%varData.rotate;
					int innermost = (i + varData.offset.get(k) - register_alignval)%varData.rotate + register_alignval;
					String regName = reg_prefix + "_" + innermost;
					if(DEBUG){
						System.out.println(varData.offset.get(k)  + " " + register_alignval + " " + varData.rotate);
						System.out.println("register offset: " + varData.offset.get(k)  + "construct register: " + regName);
					}
					VRegister reg = null;
					if(regs.get(regName) != null){
						reg = regs.get(regName);
					}else{
						reg = _fact.createVRegister(EcoreUtil.copy(vtype), regName);
						regs.put(regName, reg);
					}
					//if(regs.get(regName) == null)	regs.put(regName, reg);
					//construct the dependence vector
					vec[dims - 1] = i;
					BasicMemoryAddress address = null;
					if(varData.isPointer){
						address = _fact.createBasicMemoryAccess(varData.codegenVar, false, true);
					}else {
						AffineFunction dep = PolyhedralIRUtility.createUniformFunction(varData.var.getDomain(), vec);
						//construct the access function 
						AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(varData.var.getDomain());
						AffineFunction access = varData.mem_access.copy();
						access = access.compose(identity);
						access = access.compose(dep);
						//constuct the load instruction
						address = _fact.createBasicMemoryAccess(varData.codegenVar, access, false);
					}
					SIMDExpression simd_load = _fact.createVLoadExpression(EcoreUtil.copy(vtype), reg, address);
					loads.add(_fact.createSIMDStatement(getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), simd_load));
					stmtCount++;
					if(varData.isPointer){//add pointer increasement statement
						String add_stmt_string = varData.var.getName() + "+=" + reg.getVtype().getNElements();
						loads.add(_cgfact.createStatement(getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), add_stmt_string));
						stmtCount++;
					}
				}
				
				return;
			}
			
			for(int i= -varData.ranges.get(k).get(1); i <= -varData.ranges.get(k).get(0); i++){
				vec[k] = i;
				String new_prefix = reg_prefix + "_" + (i + varData.offset.get(k));
				getLoadsAtDimk(k + 1, vec, new_prefix);
			}
			return;
		}
		
	}
	
	public static class ConstructComputeFunction {
		public List<SIMDStatement> stmts;	//the converted SIMD statements for main computation
		public List<VRegister> intraRegs;
		
		public final VRegNameConstruction vregNameConstructor;
		
		//configure variables
		protected List<EquationAsStatement> oriStmts;	//the statement for translating into SIMD instructions
		protected List<VariableDeclaration> scalarVars;	//record of the scalar variables 
		protected Map<String, VRegister> reg_map;		//the created name register map
		protected Map<VariableDeclaration, List<List<Integer>>> var_deps_map;	//the extracted uniform dependence for each variable
		protected Map<VariableDeclaration, List<Integer>> var_offsets_map;	//the start offset for the register name
		protected VType vtype;
		protected int[] unrollFactors;
		
		//recording variabels
		protected int stmtCount;	//the statement count
		protected Domain stmtDom;	//the statement domain for the main computation is the same
		protected String stmtGroup;	
		
		//protected Map<VariableDeclaration, Map<Integer, String>> var_regname_map;	
		
		//use default register name constructor
		protected ConstructComputeFunction(List<EquationAsStatement> _oriStmts, String _stmtGroup, List<VariableDeclaration> _scalarVars, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map,
										Map<VariableDeclaration, List<Integer>> _var_offsets_map, VType _vtype, int[] _unrollFactors){
			commonInit(_oriStmts, _stmtGroup, _scalarVars, _ori_reg_map, _var_deps_map, _var_offsets_map, _vtype, _unrollFactors);
			vregNameConstructor = new VRegNameConstruction();
		}
		
		//use user provided name constructor
		protected ConstructComputeFunction(List<EquationAsStatement> _oriStmts, String _stmtGroup, List<VariableDeclaration> _scalarVars, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map,
				Map<VariableDeclaration, List<Integer>> _var_offsets_map, VType _vtype, int[] _unrollFactors, VRegNameConstruction _vregNameConstructor){
			commonInit(_oriStmts, _stmtGroup, _scalarVars, _ori_reg_map, _var_deps_map, _var_offsets_map, _vtype, _unrollFactors);
			vregNameConstructor = _vregNameConstructor;
		}
		
		private void commonInit(List<EquationAsStatement> _oriStmts, String _stmtGroup, List<VariableDeclaration> _scalarVars, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map,
										Map<VariableDeclaration, List<Integer>> _var_offsets_map, VType _vtype, int[] _unrollFactors){
			oriStmts = _oriStmts;
			stmtGroup = _stmtGroup;
			scalarVars = _scalarVars;
			reg_map = _ori_reg_map;
			var_deps_map = _var_deps_map;
			var_offsets_map = _var_offsets_map;
			vtype = _vtype;
			unrollFactors = _unrollFactors;
			
			//initial variables 
			stmts = new LinkedList<SIMDStatement>();
			intraRegs = new LinkedList<VRegister>();
			stmtCount = 0;
			stmtDom = PolyhedralIRUtility.parseDomain("{|}"); //create scalar domain
		}
		
		//entrance for getting the function for the main computation body
		public static SIMDFunction generateComputeFunction(List<EquationAsStatement> _oriStmts, String _stmtGroup, List<VariableDeclaration> _scalarVars, Map<String, VRegister> _ori_reg_map, List<String> input_func_regs,
				Map<VariableDeclaration, List<List<Integer>>> _var_deps_map, Map<VariableDeclaration, List<Integer>> _var_offset_map, VType _vtype, int[] _unrollFactors) {
			//construt the function 
			String func_name = "Compute" + _stmtGroup;
			SIMDFunction function = _fact.createSIMDFunction(func_name, "void");
			
			//add indices as parameter
			List<String> indices = _oriStmts.get(0).getAccessFunction().getIndexNames();
			for(int i = 0; i < indices.size(); i++){
				function.getParameters().add(_cgfact.createBasicVariable(indices.get(i), "int"));
			}
			//add scalar variables
			for(VariableDeclaration var: _scalarVars){
				function.getParameters().add(_cgfact.createBasicVariable(var.getName(), var.getType().getCName()));
			}
			//add input arrays
			for(EquationAsStatement stmt: _oriStmts){
				function.getInputs().add(stmt.getVariable());
			}
			for(String reg_name: input_func_regs){
				function.getInputsimdRegs().add(_ori_reg_map.get(reg_name));
			}
			
			ConstructComputeFunction constructor = new ConstructComputeFunction(_oriStmts, _stmtGroup, _scalarVars, _ori_reg_map, _var_deps_map, _var_offset_map, _vtype, _unrollFactors);
			constructor.generateIntraRegs();
			constructor.generateComputeStatements();
			
			//add the local registers for function
			function.getLocalsimdRegs().addAll(constructor.intraRegs);
			
			//create local register initialization body
			VRegisterInitialization regInit = _fact.createVRegisterInitialization(function);
			function.getBodies().add(regInit);
			
			//construct the main Loop 
			CLoop loop = _cgfact.createCLoop(constructor.stmtDom.toParameterDomain(), 0);	
			//add the statements
			loop.getStatements().addAll(constructor.stmts);
			
			function.getBodies().add(loop);
			
			return function;
		}
		
		
		protected String getVRegNameForVar(VariableDeclaration var, List<Integer> dep_vec, List<Integer> offsets){
			return vregNameConstructor.getVRegisterName(var, stmtGroup, dep_vec, offsets);
		}
	
		/**
		 * Construct the intermediate registers with the initial loaded registers
		 */
		protected void generateIntraRegs(){
			SIMDIntraRegConstruction intraRegConstructor;
			if(vtype.getIns() == SIMD_INS.AVX){
				if(vtype.getType().getCName() == "double"){
					intraRegConstructor = new SIMDAVXPDIntraRegConstruction(vtype, stmtDom, stmtGroup, stmtCount, reg_map, var_deps_map, var_offsets_map, vregNameConstructor);
				}else if(vtype.getType().getCName() == "float"){
					intraRegConstructor = new SIMDAVXPSIntraRegConstruction(vtype, stmtDom, stmtGroup, stmtCount, reg_map, var_deps_map, var_offsets_map, vregNameConstructor);
				}else {
					throw new RuntimeException("only 4way double AVX and 8way float AVX is currently supported");
				}
			}else{
				throw new RuntimeException("only AVX currently supported");
			}
			
			intraRegConstructor.generateIntraRegisters();
			stmts.addAll(intraRegConstructor.stmts);
			intraRegs.addAll(intraRegConstructor.intraRegs);
			stmtCount += intraRegConstructor.stmts.size();
		}
		


		protected void generateComputeStatements(){
			List<Integer> cur_iter = new LinkedList<Integer>();
			generateComputeStatements(0, unrollFactors, cur_iter);
		}
		
		protected void generateComputeStatements(int dim, int[] unrollFactor, List<Integer> cur_iter){
			if(dim == unrollFactor.length - 1){	
				int[] iter = new int[unrollFactor.length];
				for(int i = 0; i < unrollFactor.length - 1; i++){
					iter[i] = cur_iter.get(i);
				}
				iter[unrollFactor.length - 1] = 0;	//no unrolling for innermost iterator
				generateComputeStatements(iter);
				return;
			}
			
			for(int i = 0; i < unrollFactor[dim]; i++){
				List<Integer> temp_iter = new LinkedList<Integer>();
				temp_iter.addAll(cur_iter);
				temp_iter.add(i);
				generateComputeStatements(dim + 1, unrollFactor, temp_iter);
			}
			
		}
		/**
		 * Generate the compuation statement at the current iteration
		 * @param iter
		 */
		protected void generateComputeStatements(int[] iter){
			//convert each statement
			for(EquationAsStatement stmt: oriStmts){
				Expression iter_exp = DTilerProcessUtility.DependenceConversion.ConvertDependence(EcoreUtil.copy(stmt.getRhs()), iter);
				SIMDExpression simd_exp = this.convertExp(iter_exp);
				//construct the final statement
				//1. construct an output vector register
				VariableDeclaration var = stmt.getVarDecl();
				AffineFunction dep_func = PolyhedralIRUtility.createUniformFunction(var.getDomain(), iter);
				List<Integer> dep_vec = DTilerProcessUtility.extractDepVec(dep_func);
				//List<Integer> identity_vec = getIdentityDepVec(var);
				VRegister reg = _fact.createVRegister(EcoreUtil.copy(vtype), getVRegNameForVar(stmt.getVarDecl(), dep_vec, var_offsets_map.get(var)));
				intraRegs.add(reg); 
				//2. construct a vector assign expression reg = simd_exp
				SIMDExpression assign_exp = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, simd_exp);
				stmts.add(_fact.createSIMDStatement(getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign_exp));
				stmtCount++;
				//3. construct a store expression to store the value into the correct memroy
				BasicMemoryAddress address = getStoreVarAccess(stmt, iter);
				SIMDExpression store_exp = _fact.createVStoreExpression(EcoreUtil.copy(vtype), reg, address);
				stmts.add(_fact.createSIMDStatement(getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), store_exp));
				stmtCount++;
			}
		}
		
		
		protected BasicMemoryAddress getStoreVarAccess(EquationAsStatement stmt, int[] iter){
			AffineFunction access = PolyhedralIRUtility.createUniformFunction(stmt.getVarDecl().getDomain(), iter);
			
			return  _fact.createBasicMemoryAccess(stmt.getVariable(), stmt.getAccessFunction().copy().compose(access), false);
		}
		
		/**
		 * Recursive function that traverse the whole expression tree 
		 * and construct the corresponding SIMD Expression
		 * @param exp
		 * @return
		 */
		protected SIMDExpression convertExp(Expression exp){
			if(exp == null)	return null;
			//start copy the whole expression and construct the corresponding SIMD expression
			SIMDExpression simd_exp = null;
			if(exp instanceof BinaryExpression){
				SIMDExpression lexp = convertExp(((BinaryExpression)exp).getLexp());
				SIMDExpression rexp = convertExp(((BinaryExpression)exp).getRexp());
				VOP op = VOP.ADD;
				switch(((BinaryExpression) exp).getOperator().getValue()){
					case OP.ADD_VALUE:
						op = VOP.ADD;
						break;
					case OP.MUL_VALUE:
						op = VOP.MUL;
						break;
					case OP.SUB_VALUE:
						op = VOP.SUB;
						break;
					default:
						throw new RuntimeException("Only ADD, SUB and MUL is supported in the current SIMD operation");
				}
				
				simd_exp = _fact.createVBinaryExpression(EcoreUtil.copy(vtype), lexp, rexp, op);
			}else if(exp instanceof DependenceExpression){
				simd_exp = convertDependenceExpression((DependenceExpression)exp);
			}else if(exp instanceof VariableExpression){	//get load expression
				simd_exp = convertVariableExpression((VariableExpression)exp);
			}else if(exp instanceof IndexExpression){
				simd_exp = convertIndexExpression((IndexExpression)exp);
				
			}else if(exp instanceof ConstantExpression){
				simd_exp = convertConstantExpression((ConstantExpression)exp);
			}else if(exp instanceof RestrictExpression){
				simd_exp = convertExp(((RestrictExpression)exp).getExpr());
			}else{
				throw new RuntimeException("at an expression that is not supported");
			}
			return simd_exp;
			
		}
		
		protected SIMDExpression convertDependenceExpression(DependenceExpression exp){
			//check whether to use load expression or set expression
			if(((DependenceExpression)exp).getExpr() instanceof VariableExpression){
				VariableExpression var_exp = (VariableExpression)((DependenceExpression)exp).getExpr();
				if(scalarVars.contains(var_exp.getVarDecl()))	return convertScalarVariableExpression(var_exp);
				
				List<Integer> dep_vec = DTilerProcessUtility.extractDepVec(exp.getDep());
				String regName = getVRegNameForVar(var_exp.getVarDecl(), dep_vec, var_offsets_map.get(var_exp.getVarDecl()));
				return _fact.createVRegisterExpression(EcoreUtil.copy(vtype), reg_map.get(regName));
			}else if(((DependenceExpression)exp).getExpr() instanceof ConstantExpression){
				//the same as how constant expression is handled
				return convertConstantExpression((ConstantExpression)((DependenceExpression)exp).getExpr());
			}else {
				throw new RuntimeException("Other than variable expression and constant expression in dependence expression is supported in vectorization");
			}
		}
		
	
		protected SIMDExpression convertVariableExpression(VariableExpression exp){
			VariableDeclaration var = exp.getVarDecl();
			if(scalarVars.contains(var))	return convertScalarVariableExpression(exp);
			
			List<Integer> dep_vec = new LinkedList<Integer>();
			for(int i = 0; i < var.getDomain().getDim(); i++){
				dep_vec.add(0);
			}
			String regName = getVRegNameForVar(var, dep_vec, var_offsets_map.get(var));
			return _fact.createVRegisterExpression(EcoreUtil.copy(vtype), reg_map.get(regName));
		}
		
		protected SIMDExpression convertScalarVariableExpression(VariableExpression exp){
			List<String> exprs = new LinkedList<String>();
			exprs.add(exp.getVarDecl().getName());
			
			return _fact.createVSetExpression(EcoreUtil.copy(vtype), exprs);
		}
		
		protected SIMDExpression convertIndexExpression(IndexExpression exp){
			//get the Index List
			AffineFunction index_func = ((IndexExpression)exp).getFunction();
			List<Variable> indices = index_func.getIndices();
			Variable innermost = indices.get(indices.size() - 1);
		
			AffineExpression index_exp = index_func.getExpressions().get(0);
			List<String> exprs = new LinkedList<String>();
			exprs.add(index_exp.copy().toString(OUTPUT_FORMAT.C));
			for(int i = 1; i < vtype.getNElements(); i++){	//constructing other element
				IntExpression var_exp = IntExpressionBuilder.add(IntExpressionBuilder.affine(innermost), i);
				AffineExpression exp_copy = index_exp.copy();
				exp_copy = (AffineExpression) exp_copy.substitute(innermost, var_exp);
				exprs.add(exp_copy.toString(OUTPUT_FORMAT.C));
			}
			
			//create a register statement
			return _fact.createVSetExpression(EcoreUtil.copy(vtype), exprs);
		}
		
		protected SIMDExpression convertConstantExpression(ConstantExpression exp){
			List<String> exprs = new LinkedList<String>();
			if(exp instanceof RealExpression){
				String val = String.valueOf(((RealExpression) exp).getValue());
				exprs.add(val);
			}else if(exp instanceof IntegerExpression){
				String val = String.valueOf(((IntegerExpression)exp).getValue());
				exprs.add(val);
			}else {
				throw new RuntimeException("Other set instruction type is not supported");
			}
			
			return  _fact.createVSetExpression(EcoreUtil.copy(vtype), exprs);
		}
	}
}
