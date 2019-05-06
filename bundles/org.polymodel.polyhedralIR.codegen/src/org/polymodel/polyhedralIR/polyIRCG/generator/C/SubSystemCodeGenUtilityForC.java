package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGFactory;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;
import org.polymodel.util.PolymodelException;


public class SubSystemCodeGenUtilityForC {
	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	
	//functions for the subsystem code generator
	
	public static final String getUseEquationFunctionName(UseEquation eq){
		return eq.getLabel() + "_" + eq.getContainerSystem().getName();
	}

	public static final String getUseEquationMemoryAllocationFunctionName(UseEquation eq, boolean isInput, int num){
		return "memory_allocation_for_" + eq.getLabel() + "_" + getInputOutputString(isInput) + "_" + num;
	}
	
	public static final String getUseEquatonMemoryFreeFunctionName(UseEquation eq, boolean isInput, int num){
		return "memory_free_for_" + eq.getLabel() + "_" + getInputOutputString(isInput) + "_" + num;
	}
	
	public static final String getUseEquationValueCopyFunctionName(UseEquation eq, boolean isInput, int num){
		return "value_copy_for_" + eq.getLabel() + "_" + getInputOutputString(isInput) + "_" + num;
	}
	
	public static final String getUseEquationVariableName(UseEquation eq, boolean isInput, int num){
		return eq.getLabel() + "_" + getInputOutputString(isInput) + "_" + num;
	}
	
	private static String getInputOutputString(boolean isInput){
		if(isInput){
			return "input";
		}else{
			return "output";
		}
	}
	
	/*
	 * create a temporary variable for the nth input/output of the use equation(eq)
	 * the domain of the temporary variable the domain for each instance of use for the input/output
	 */
	public static VariableDeclaration createTemporaryVariable(UseEquation eq, boolean isInput, int num, ParameterDomain paramDom, TargetMapping targetMapping, MemorySpace space){
		String temp_name = getUseEquationVariableName(eq, isInput, num);	//name
		Domain contextDom = null;
		Type variableType = null;
		//get the context doamin of the variable
		if(isInput){	
			contextDom = eq.getInputs().get(num).getContextDomain().copy();
			variableType = eq.getInputs().get(num).getExpressionType();
		}else{
			contextDom = eq.getOutputs().get(num).getDomain().copy();
			variableType = eq.getOutputs().get(num).getType();
		}
	
		Domain temp_dom = null;
		temp_dom = DomainOperations.subSystemInstanceDomain(paramDom, contextDom,  eq.getExtensionDomain().copy());	//domain
		VariableDeclaration var = PolyhedralIRUserFactory.eINSTANCE.createVariableDeclaration(temp_name, variableType, temp_dom);	//construction
		
		//update the target mapping
		//create a memory map for the temporary variable
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
		MemoryMap mem_map = TargetMappingUserFactory.createMemoryMap(var, identity.copy(), null, space);
		//create a spacetime map for the the memory allocation statement
		SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, identity.copy());
		targetMapping.getMemoryMaps().put(var, mem_map);
		targetMapping.getSpaceTimeLevel(0).getSpaceTimeMaps().put(var.getName(), stMap);
		
		return var;
	}
	
	/**
	 * special function for subsystem code generator, put the index namespace of the statment under the same namespace with the extension domain
	 * @param oriExtDom 
	 * @param spacetimeMap
	 * @param extDom
	 * @return
	 */
	public static Domain createSpecialStatementDomain(Domain oriExtDom, AffineFunction spacetimeMap, Domain extDom){
		//get the domain
		Domain oriDom = oriExtDom.image(spacetimeMap);
		//set the index name to be the same with the extDom
		Domain dom = DomainOperations.setFirstFewDimensions(oriDom, extDom.getIndices ());
		return dom;
	}

	public static PseudoProjection getSpaceDomainforSystemCallDeclaration(MemorySpace space, TargetMapping tmap){
		PseudoProjection pproj = PolyIRCGFactory.eINSTANCE.createPseudoProjection();
		pproj.setZeroAligned(space.isZeroAligned());
		//pproj.setDomain(space.getDomain());
		for (IntExpression expr : space.getModFactors()) {
			pproj.getModFactors().add(expr.copy());
		}
		
		//get the space domain
		Domain res = null;
		SpaceTimeLevel splevel = tmap.getSpaceTimeLevel(0);
		for (MemoryMap mmap : space.getMemoryMaps()) {
			AffineFunction inv;
			try {
				AffineFunction spmap = splevel.getSpaceTimeMaps().get(mmap.getVariable().getName()).getMapping();
				Domain oriDomain = mmap.getVariable().getDomain().copy();
				Domain varDomain = oriDomain.image(spmap);
				inv = splevel.getSpaceTimeMaps().get(mmap.getVariable().getName()).getInverseOfMapping();
				Domain dom = varDomain.image(mmap.getMapping().compose(inv));
				if (res == null) {
					res = dom;
				} else {
					if (res.getDim() != dom.getDim()) {
						throw new RuntimeException("Multiple memory maps for the same memory space must share the same number of dimensions.");
					}
					res = dom.union(res);
				}
			} catch (PolymodelException e) {
				throw new RuntimeException("SpaceTimeMap given for " + mmap.getVariable() + " does not admit an Inverse");
			}	
		}
		
		if (res == null) {
			throw new RuntimeException("No variable is mapped to memory space : " + space.getName());
		} else {
			pproj.setDomain(res);
		}
		
		return pproj;
	}
	
	public static Function createMemoryAllocationFunction(UseEquation eq, boolean isInput, int num, VariableDeclaration var, CodeGenOptions options){
		//create code generation variables for all the temporary input and output variables
		TargetMapping tm = TargetMappingFactory.eINSTANCE.createTargetMapping();
		SpaceTimeLevel stlevel = TargetMappingFactory.eINSTANCE.createSpaceTimeLevel();
		//create targetMapping for the variable
		stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
		MemorySpace ms = tm.getMemorySpace(var.getName());
		tm.getMemoryMaps().put(var, TargetMappingUserFactory.createIdentityMemoryMap(var, ms));
		tm.getSpaceTimeLevels().add(stlevel);
				
		CodeGenVariable v = _fact.createCVariable(ms, options.flattenArrays, false);
		
		String func_name = getUseEquationMemoryAllocationFunctionName(eq, isInput, num);
		Function function = _fact.createFunction(func_name, org.polymodel.polyhedralIR.codegen.xtend2.Utility.pointerType(v));
		//add all the parameters in the parameter domain as the parameters of the function
		for(String param : eq.getExtensionDomain().getIndexNames()){
			function.getParameters().add(_fact.createBasicVariable(param, "int"));
		}
		
		
		
		function.getLocals().add(v);
	
		function.getBodies().add(_fact.createVariableInitialization(function));
		function.getBodies().add(_fact.createBody("return " + v.getName() + ";"));
		
		return function;
	}
	
	public static Function createValueCopyFunctionForInput(ParameterDomain paramDom, UseEquation eq, int num, VariableDeclaration var, List<VariableDeclaration> variables, TargetMapping tMap, CodeGenOptions options, CodeUnit unit){
		String func_name = getUseEquationValueCopyFunctionName(eq, true, num);
		//create a function for the value copy
		Function function = _fact.createFunction(func_name, "void");
		//add parameters
		for(String param : eq.getExtensionDomain().getIndexNames()){
			function.getParameters().add(_fact.createBasicVariable(param, "int"));
		}
		//add all the input variables
		for(VariableDeclaration variable: variables){
			String name = tMap.getMemoryMaps().get(variable).getSpace().getName();
			function.getInputs().add(unit.findVariable(name));
		}
		function.getOutputs().add(unit.findVariable(var.getName()));
		
		CLoop loop = _fact.createCLoop(paramDom, 0);
		//get the access function for the left hand variables
		AffineFunction access = tMap.getSpaceTimeLevel(0).getAccessFunction(var);
		//create the statement of the copy
		Statement stmt = _fact.createStatement(var, 
				CodeGenUtility.createStatementName(unit, 0), var.getDomain().copy(), unit.findCGVariable(var.getName()), access, eq.getInputs().get(num));
		
		loop.getStatements().add(stmt);
		function.getBodies().add(loop);
		
		return function;
	}
	
	public static Function createValueCopyFunctionForOutput(ParameterDomain paramDom, UseEquation eq, int num, VariableDeclaration var, TargetMapping tMap, CodeGenOptions options, CodeUnit unit){
		String func_name = getUseEquationValueCopyFunctionName(eq, false, num);
		//create function for the value copy
		Function function = _fact.createFunction(func_name, "void");
		
		//add parameters
		for(String param : eq.getExtensionDomain().getIndexNames()){
			function.getParameters().add(_fact.createBasicVariable(param, "int"));
		} 
		//add input variable
		function.getInputs().add(unit.findVariable(var.getName()));
		//add output variable
		String output_var_name = tMap.getMemoryMaps().get(eq.getOutputs().get(num)).getSpace().getName();
		function.getOutputs().add(unit.findVariable(output_var_name));
		
		CLoop loop = _fact.createCLoop(paramDom, 0);
		
		//get the index list of the output variable domain
		List<Variable> indexs = new LinkedList<Variable>();
		Domain outputDom = var.getDomain();
		for(int j = eq.getExtensionDomain().getNParams(); j < outputDom.getNParams(); j++){
			indexs.add(outputDom.getParams().get(j));
		}
		indexs.addAll(outputDom.getIndices());
		//create access function for the left hand side variable
		AffineFunction lidentity = PolyhedralIRUtility.createIdentityFunction(outputDom.getParams(), indexs);
		//create access function for the right hand side variable
		AffineFunction raccess = PolyhedralIRUtility.createIdentityFunction(outputDom.getParams(), indexs.subList(eq.getExtensionDomain().getNIndices(), indexs.size()));
		
		//get the access function for the output variable
		AffineFunction access = tMap.getSpaceTimeLevel(0).getAccessFunction(eq.getOutputs().get(num));
		AffineFunction laccess = access.compose(lidentity);
		
		//create Variable Copying Statement
		String assign = createVariableAssignmentStatement(unit.findCGVariable(output_var_name), laccess, unit.findCGVariable(var.getName()), raccess);
		
		Statement stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, 0), outputDom, assign);
		loop.getStatements().add(stmt);
		
		function.getBodies().add(loop);
		
		return function;
	}
	
	public static Function createMemoryFreeFunction(UseEquation eq, boolean isInput, int num, CodeGenVariable v){
		String function_name = getUseEquatonMemoryFreeFunctionName(eq, isInput, num);
		Function function = _fact.createFunction(function_name, "void");
		//add parameters
		for(String param : eq.getExtensionDomain().getIndexNames()){
			function.getParameters().add(_fact.createBasicVariable(param, "int"));
		}
		//no input, no output
		function.getOutputs().add(v);
		function.getSpecialLocals().add(v);
		function.getBodies().add(_fact.createVariableFinalization(function));
		
		return function;
	}
	
	public static Map<CodeGenVariable, AffineFunction> createCodeVarAccessMap(CodeGenVariable v, AffineFunction access){
		Map<CodeGenVariable, AffineFunction> variable_access = new HashMap<CodeGenVariable, AffineFunction>();
		
		variable_access.put(v, access);
		return variable_access;
	}
	
	public static Map<CodeGenVariable, AffineFunction> createCodeVarAccessMap(VariableDeclaration var, AffineFunction access, TargetMapping tmap, CodeUnit unit){
		String spacename = tmap.getMemoryMaps().get(var).getSpace().getName();
		CodeGenVariable v = unit.findCGVariable(spacename);
		
		Map<CodeGenVariable, AffineFunction> variable_access = createCodeVarAccessMap(v, access);
		
		return variable_access;
	}
	/**
	 * extract the subarray access function for the num(th) input/output of use equation eq
	 * The equation must be a dependence expression with only one variable 
	 * @param eq	
	 * @param isInput
	 * @param num
	 * @return
	 */
	public static AffineFunction extractSubarrayAccessFunction(UseEquation eq, boolean isInput, int num, TargetMapping tmap){
		//get the affine expression
		AffineFunction dep_func = null;
		Domain context_domain = null;
		if(isInput){
			Expression expr = eq.getInputs().get(num);
			if(expr instanceof DependenceExpression){	//expr has to be dependence expression
				Expression subexpr = ((DependenceExpression)expr).getExpr();
				if(subexpr instanceof VariableExpression){
					VariableDeclaration var = ((VariableExpression)subexpr).getVarDecl();
					dep_func = tmap.getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()).getInverseOfMapping().compose(((DependenceExpression)expr).getDep());
					dep_func = tmap.getMemoryMaps().get(var).getMapping().compose(dep_func);
					context_domain = expr.getContextDomain();
				}
			}
		}else{
			VariableDeclaration var = eq.getOutputs().get(num);
			//create Identity function for output
			dep_func = tmap.getSpaceTimeLevel(0).getAccessFunction(var);
			context_domain = var.getDomain();
		}
		
		if(dep_func == null)	return null;

		Domain use_domain = eq.getExtensionDomain();
		//compute the number of local indices
		int instance_indices = use_domain.getNIndices();
		int local_indices = context_domain.getNIndices() - instance_indices;
		
		//filter out the lower local_indices dimensions of the dependence function
		if(dep_func.getDimRHS() < local_indices)	return null;	//illegal situation
		List<Variable> params = dep_func.getParams();
		List<Variable> indices = dep_func.getIndices().subList(0, instance_indices);
		List<String> exprs = new LinkedList<String>();
		for(int i = 0; i < dep_func.getDimRHS() - local_indices; i++){
			exprs.add(dep_func.getExpressions().get(i).toString(OUTPUT_FORMAT.ALPHABETS));
		}
		
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(params, eq.getExtensionDomain().getIndices());
		AffineFunction subarray_access_func = PolyhedralIRUtility.parseAffineFunction(params, indices, exprs);
		
		return subarray_access_func.compose(identity);
	}
	////////////////////////////////////////////
	/**
	 * Construct the function call statement for subsystem with a given function call name
	 * @param name: function call name
	 * @param parameters: input parameters
	 * @param variables: input variables
	 * @return
	 */
	public static String createFunctionCallStatement(String name, List<String> parameters, List<Map<CodeGenVariable, AffineFunction>> variables){
		return createFunctionCallStatement(name, parameters, variables, Collections.<List<IntExpression>>emptyList());
	}
	/*public static String createFunctionCallStatement(String name, List<String> parameters, List<Map<CodeGenVariable, AffineFunction>> variables){
		String functionCallStatement = name + "(";
		
		List<String>functionParams = new LinkedList<String>();
		functionParams.addAll(parameters);	//fist add all the parameters
		
		if(variables != null){
			for(int i = 0; i < variables.size(); i++){	//add variables
				for(Map.Entry<CodeGenVariable, AffineFunction> entry: variables.get(i).entrySet()){
					CodeGenVariable v = entry.getKey();
					
					AffineFunction mapping = entry.getValue();
					if(org.polymodel.polyhedralIR.codegen.xtend2.Utility.isScalar(v)){	//add scalar variable input
						//TODO if we want to pass a pointer form the arguments of the main function, then we do not need to add &
						functionParams.add("&" + v.getName());
					}else if(mapping != null && mapping.getDimRHS() > 0){	//add variable input with pointer for subarray
						String subarray = "";
						if(mapping.getDimRHS() == v.getDomain().getNIndices()){
							subarray += "&";
						}
						subarray += v.getName();
						for(int j = 0; j < mapping.getDimRHS(); j++){
							subarray += "[" + mapping.getExpressions().get(j).toString(OUTPUT_FORMAT.C) + "]";
						}
						functionParams.add(subarray);
					}else{	//add the whole variables
						functionParams.add(v.getName());
					}
				}
			}
		}
		
		functionCallStatement += CodeGenUtility.toStringList(functionParams, ",");
		functionCallStatement += ")";
		
		return functionCallStatement;
	}*/
	
	/**
	 * Construct the function call statement for subsystem with a given function call name
	 * @param name: function call name
	 * @param parameters: input parameters
	 * @param variables: input variables
	 * @param modList 
	 * @return
	 */
	public static String createFunctionCallStatement(String name, 
			List<String> parameters, List<Map<CodeGenVariable, 
			AffineFunction>> variables, List<List<IntExpression>> modList){
		String functionCallStatement = name + "(";
		
		List<String>functionParams = new LinkedList<String>();
		functionParams.addAll(parameters);	//fist add all the parameters
		
		if(variables != null){
			for(int i = 0; i < variables.size(); i++){	//add variables
				List<IntExpression> modFactors;
				if (modList.isEmpty()) {
					modFactors = Collections.<IntExpression>emptyList();
				} else {
					modFactors = modList.get(i);
				}
				for(Map.Entry<CodeGenVariable, AffineFunction> entry: variables.get(i).entrySet()){
					CodeGenVariable v = entry.getKey();
					AffineFunction mapping = entry.getValue();
					if(org.polymodel.polyhedralIR.codegen.xtend2.Utility.isScalar(v)){	//add scalar variable input
						//TODO if we want to pass a pointer form the arguments of the main function, then we do not need to add &
						functionParams.add("&" + v.getName());
					}else if(mapping != null && mapping.getDimRHS() > 0){	//add variable input with pointer for subarray
						String subarray = "";
						if(mapping.getDimRHS() == v.getDomain().getNIndices()){
							subarray += "&";
						}
						subarray += v.getName();
						for(int j = 0; j < mapping.getDimRHS(); j++){
							//If their is no modulo memory allocation or, if the mod factor is 0.
							if (modFactors.isEmpty() || modFactors.get(j).isZero().equals(FuzzyBoolean.YES)) {
								subarray += "[" + mapping.getExpressions().get(j).toString(OUTPUT_FORMAT.C) + "]";
							} else {//if there is a mod factor
								subarray += "[MOD(" + mapping.getExpressions().get(j).toString(OUTPUT_FORMAT.C) 
										+ ","+modFactors.get(j).toString(OUTPUT_FORMAT.C)+")]";
							}
						}
						functionParams.add(subarray);
					}else{	//add the whole variables
						functionParams.add(v.getName());
					}
				}
			}
		}
		
		functionCallStatement += CodeGenUtility.toStringList(functionParams, ",");
		functionCallStatement += ")";
		
		return functionCallStatement;
	}
	
	public static String createSpecialAssignmentStatement(String lexp, String rexp){
		return lexp + "=" + rexp;
	}
	
	public static String createMemoryAccessExpression(CodeGenVariable var, AffineFunction access){
		String exp = null;
		
		exp = var.getName();
		
		if(access != null){
			if(access.getDimRHS()>0){
				exp += "(";
				List<String> exprs = new LinkedList<String>();
				for (AffineExpression ae : access.getExpressions()) {
					exprs.add(ae.toString(OUTPUT_FORMAT.C));
				}
				exp += CodeGenUtility.toStringList(exprs, ",");
				exp += ")";
			}
		}
		
		return exp;
	}
	public static String createVariableAssignmentStatement(CodeGenVariable lvar, AffineFunction laccess, CodeGenVariable rvar, AffineFunction raccess){
		String exp = null;
		
		//create the left hand side of the expression
		String lexp = null;
		if(lvar.getDomain().getNIndices() == 0){
			lexp = "*" + lvar.getName();
		}else{
			lexp = createMemoryAccessExpression(lvar, laccess);
		}
		
		//create the right hand side of the expression
		String rexp = null;
		if(rvar.getDomain().getNIndices() == 0){
			rexp = "*" + rvar.getName();
		}else{
			rexp = createMemoryAccessExpression(rvar, raccess);
		}
		
		exp = lexp + "=" + rexp;
		
		return exp;
	}
	
	//////////////////////////special function for generating parallelized loop//////////////////////////////////
	/**
	 * Special function for parallel loops for subsystem code generation
	 * Find the special variables generated for inputs/outputs that have to be private to a certain loop
	 * @param node: the for loop
	 * @param special_vars	: list of special variables generated for the whole system
	 * @return
	 */
	public static List<String> getSepcialVariablesWithinForLoop(AbstractScopNode node, Map<String, VariableDeclaration> special_vars){
		PrivateSpecialVariableWithinScopFor instance = new PrivateSpecialVariableWithinScopFor(special_vars);
		node.accept(instance);
		
		//if the outer most node is a for loop, remove the outermost iteration name
		return instance.variables;
	}
	
	private static class PrivateSpecialVariableWithinScopFor extends ScopDepthFirstVisitorImpl{
		//list of special variables
		private Map<String, VariableDeclaration> special_vars = null;
		//list of special variables within the for loop
		private List<String> variables = null;
		
		public PrivateSpecialVariableWithinScopFor(Map<String, VariableDeclaration> _special_vars){
			special_vars = new HashMap<String, VariableDeclaration>();
			for(Map.Entry<String, VariableDeclaration> var : _special_vars.entrySet()){
				special_vars.put(var.getKey(), var.getValue());
			}
			variables = new LinkedList<String>();
		}
		
		@Override
		public void inScopStatementMacro(ScopStatementMacro a) {
			//check is all the schedule dimension the same
			VariableDeclaration matched_var = null;
			for(Map.Entry<String, VariableDeclaration> var: special_vars.entrySet()){
				//check for each scalar epxression to be the same
				boolean matched = false;
				if(var.getKey().contentEquals(a.getName())){
						matched = true;
				}
				if(matched){
					matched_var = var.getValue();
					break;
				}
			}
			
			if(matched_var != null){
				variables.add(matched_var.getName());
				special_vars.remove(matched_var.getName());
			}
		}
		
		/*@Override
		public void inScopStatementMacro(ScopStatementMacro a) {
			//check is all the schedule dimension the same
			VariableDeclaration matched_var = null;
			for(Map.Entry<VariableDeclaration, Integer> var: special_vars.entrySet()){
				//find the matching special variable
				List<AffineExpression> exprs = var.getValue().getExpressions();
				//check for each scalar epxression to be the same
				boolean matched = true;
				for(int i = 0; i < exprs.size(); i++){
					AffineExpression expr = exprs.get(i);
					IntExpression macro_expr = a.getMacroParams().get(i);
					if(expr.isConstant() == FuzzyBoolean.YES && macro_expr.isConstant() == FuzzyBoolean.YES){
						if(expr.getConstantTerm().getCoef() != macro_expr.toAffine().getConstantTerm().getCoef()){
							matched = false;
							break;
						}
					}
				}
				if(matched){
					matched_var = var.getKey();
					break;
				}
			}
			
			if(matched_var != null){
				variables.add(matched_var.getName());
				special_vars.remove(matched_var);
			}
		}*/
	}
}
