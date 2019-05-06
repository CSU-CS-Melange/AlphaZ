// *******************************************************************************
// Copyright (C) 2008 Sanjay Rajopadhye. All rights reserved
// Author: DaeGon Kim 
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, If not, see 
// http://www.gnu.org/licenses/, or write to the Free Software 
// Foundation, Inc., 51 Franklin Street, Fifth Floor,
// Boston, MA  02110-1301, USA.
// *******************************************************************************

package org.polymodel.polyhedralIR.polyIRCG.generator.C;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;


/**
 * Creates Functions to be generated in the generated code for Schedule C generation.
 * Creates a function per system, and the visitor is restricted to visit one system at a time.
 * 
 * @author yuki
 *
 */
public class StatementVisitorForScheduledC extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;

	//Input
	protected final CodeUnit unit;
	protected final TargetMapping targetMapping;
	protected final CodeGenOptions options;
	
	//local
	protected Function entryFunction;
	
	protected CLoop mainLoop;
	
	protected VariableInitialization initialVariables;
	
	protected ComputeReductionNumber reductionNumbers;
	
	protected GetVariablesInExpression expressionVars;
	
	protected Map<Equation, List<Statement>> statementEquationMap;
	
	protected Map<Equation, List<Statement>> permutedStatementEquationMap;
	
	protected int mainLoopStatementCount;
	
	private static Boolean DEBUG = false;

	
	protected StatementVisitorForScheduledC(CodeUnit unit, TargetMapping mapping, CodeGenOptions options) {
		this.unit = unit;
		this.targetMapping = mapping;
		this.options = options;
		this.expressionVars =  new GetVariablesInExpression(mapping);
	}
	
	protected void inAffineMainLoopConstruction(AffineSystem a) {

		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);
		//Create a loop that evaluate all equations, and later visitors will fill in the loop
		//when tiled
		//Current hacking for multipass code generator, enabled through tiled code generation options, this has to be merged to target mapping eventually
		if (targetMapping.isTiled() || (options instanceof TiledCodeGenOptions && ((TiledCodeGenOptions)options).multiPassSequential) 
				|| (options instanceof TiledCodeGenOptions && ((TiledCodeGenOptions)options).multiPassWavefront)) {
			TiledCLoop tiledLoop = _fact.createTiledCLoop(a.getParameters(), stlevel.getNumberOfOrderingDimensions());
			
			List<Integer> orderingDimensions = stlevel.getOrderingDimensions();
			tiledLoop.getOrderingDimensions().addAll(stlevel.getOrderingDimensions());
			//save the tiling informations for the loop
			for(TilingSpecification tile: stlevel.getTilingSpecifications()){
				List<Integer> orderingPrefix = tile.getOrderingPrefix();
				List<SubTileSpecification> subtiles = new LinkedList<SubTileSpecification>();
				int levels = tile.getLevels();
				for(int i = 1; i <= levels; i++){
					SubTilingSpecification subtile = tile.getSubTile(i);
					if(subtile == null){
						throw new RuntimeException("subtile at level " + i +" is not specified for tile band with prefix " + 
								tile.getOrderingPrefix().toString() + " [" + tile.getStartDim() + "," + tile.getEndDim() + "].");
					}
					int start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getStartDim(), true);
					int end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getEndDim(), false);
					subtiles.add(_fact.createSubTileSpecification(subtile.getLevel(), start, end, subtile.getTileSizes(), subtile.getTilingType()));
				}
				int band_start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, tile.getStartDim(), true);
				int band_end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, tile.getEndDim(), false);
				tiledLoop.getTiles().add(_fact.createTileSpecification(levels, tile.getOrderingPrefix(), band_start, band_end, subtiles));
			}
			
			//tiledLoop.setType(targetMapping.getTiling().getType());
			//optimize?
			if (options instanceof TiledCodeGenOptions && ((TiledCodeGenOptions)options).optimized) {
				tiledLoop.setOptimize(true);
			}
			//set tile sizes
			//for (int ts : targetMapping.getTiling().getTilesizes()) {
			//	tiledLoop.getTileSizes().add(ts); FIXME
			//}
			
			mainLoop = tiledLoop;
		}else if(targetMapping.isParallelized()){
			ParallelizedCLoop parallelLoop = _fact.createParallelizedCLoop(a.getParameters(), stlevel.getNumberOfOrderingDimensions());
			
			parallelLoop.getParallelizedDims().addAll(targetMapping.getSpaceTimeLevel(0).getParallelizationSpecifications());
			
			parallelLoop.getOrderingDims().addAll(targetMapping.getSpaceTimeLevel(0).getOrderingDimensions());
			
			mainLoop = parallelLoop;
		}else {
			mainLoop = _fact.createCLoop(a.getParameters(), stlevel.getNumberOfOrderingDimensions());
		}

	}
	
	@Override
	public void inAffineSystem(AffineSystem a) {
		reductionNumbers = new ComputeReductionNumber();
		a.accept(reductionNumbers);
		
		entryFunction = _fact.createFunction(a.getName(), "void");
		//This is the entry point for executing this system
		entryFunction.setEntryPoint(true);
		
		//Register all variables
		for (VariableDeclaration var : a.getInputs()) {
			AbstractVariable v = unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (entryFunction.getInputs().contains(v)) continue;
			entryFunction.getInputs().add(v);
		}
		for (VariableDeclaration var : a.getOutputs()) {
			AbstractVariable v = unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (entryFunction.getInputs().contains(v)) continue;
			if (entryFunction.getOutputs().contains(v)) continue;
			entryFunction.getOutputs().add(v);
		}
		//make sure no duplicates due to multiple equations mapped to the same space
		for (VariableDeclaration var : a.getLocals()) {
			AbstractVariable v = unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (entryFunction.getInputs().contains(v)) continue;
			if (entryFunction.getOutputs().contains(v)) continue;
			if (entryFunction.getLocals().contains(v)) continue;
			entryFunction.getLocals().add(v);
		}
		
		//Add parameter checking
		entryFunction.getBodies().add(_fact.createParameterCheck(a.getParameters()));
		
		initialVariables = _fact.createVariableInitialization(entryFunction);
		//Add malloc
		entryFunction.getBodies().add(initialVariables);
		
		//Extension point for code generators based on scheduled C
		inAffineMainLoopConstruction(a);
		
		//mainLoop needs to be contained by a function for later steps to work
		entryFunction.getBodies().add(mainLoop);
		
		//initial the list of the statement equation list
		statementEquationMap = new HashMap<Equation, List<Statement>>();
		permutedStatementEquationMap = new HashMap<Equation, List<Statement>>();
		
		//initialize the statement count
		mainLoopStatementCount = 0;
		
		//Add free
		entryFunction.getBodies().add(_fact.createVariableFinalization(entryFunction));
		
		unit.getFunctions().add(entryFunction);	
	}
	
	@Override
	public void outAffineSystem(AffineSystem a) {
		//reflect the statement order
		final List<Equation> torder = targetMapping.getStatementTotalOrder();

		
		//add the statement to the main loop according to the order
		for(Equation eq: torder){
			mainLoop.getStatements().addAll(statementEquationMap.get(eq));
		}
//		
//		if (mainLoop instanceof TiledCLoop) {
//			TiledCLoop tiledLoop = (TiledCLoop)mainLoop;
//			//for now, tile all the dimensions
////			for (int i = tiledLoop.getTileSizes().size(); i < tiledLoop.getMaxDimension(); i++) {
////				tiledLoop.getTileSizes().add(0);
////			}
//		}
	}
	
	@Override
	public void inStandardEquation(StandardEquation s) {
		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);
		//Find CodeGenVariable for this equation
		CodeGenVariable var = mainLoop.getFunction().getCodeunit().findCGVariable(
				targetMapping.getMemoryMaps().get(s.getVariable()).getSpace().getName());
		AffineFunction access = stlevel.getAccessFunction(s.getVariable());

		List<Statement> statements = new BasicEList<Statement>();

		//When case is used
		if (s.getExpression() instanceof CaseExpression) {
			CaseExpression caseExpr = (CaseExpression)s.getExpression();
			//Execute different branches as different statements
			for (Expression expr : caseExpr.getExprs()) {
				// mainLoop.getStatements().size()
				Statement stmt = _fact.createStatement(s.getVariable(),
						CodeGenUtility.createStatementName(unit, mainLoopStatementCount), expr.getContextDomain().copy(), var, access, expr);
				statements.add(stmt);
				mainLoopStatementCount++;
				//mainLoop.getStatements().add(stmt);
			}
		} else {
			Statement stmt = _fact.createStatement(s.getVariable(),
					CodeGenUtility.createStatementName(unit,mainLoopStatementCount), s.getExpression().getContextDomain().copy(), var, access, s.getExpression());
			//mainLoop.getStatements().add(stmt);
			statements.add(stmt);
			
			mainLoopStatementCount++;
		}
		statementEquationMap.put(s, statements);
	}
	
	@Override
	public void outReduceExpression(ReduceExpression r) {
		if (r.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("todo: implement this method for UseEquation");
		
		Type type = r.getExpressionType();
		
		String name = CodeGenConstantsForC.getReductionFunctionName((StandardEquation) r.getContainerEquation(), reductionNumbers.getReductionNumber(r));
		
		Function function = _fact.createFunction(name, type);
		
		//get the list of variable that is used in the computation for reduction
		List<VariableDeclaration> vars = expressionVars.getVars(r.getExpr().copy());
		List<CodeGenVariable> codeGenVars = new LinkedList<CodeGenVariable>();
		//for each variable add the corresponding code gen variable
		for(VariableDeclaration t_var : vars){
			String space_name = targetMapping.getMemoryMaps().get(t_var).getSpace().getName();
			CodeGenVariable v = unit.findCGVariable(space_name);
			if(!codeGenVars.contains(v))	codeGenVars.add(v);
		}
		function.getInputs().addAll(codeGenVars);

		//Create domain to scan
		Domain[] scanDoms = CodeGenUtility.createReductionScanningDomain(r);
		ParameterDomain extendedParam = (ParameterDomain)scanDoms[0];
		Domain scanDom = scanDoms[1];

		//Add the parameters to function parameters
		for (int i = r.getContextDomain().getNParams(); i < extendedParam.getNParams(); i++) {
			function.getParameters().add(_fact.createBasicVariable(extendedParam.getParams().get(i).toString(), "int"));
		}
		
		//Loop to scan the constructed slice of the reduction
		CLoop loop = _fact.createCLoop(extendedParam, 0);
		//Reduction body
		String expr = ExpressionPrinterForScheduledC.print(r.getExpr(), false);
		//Make it accumulation
		expr = CodeGenUtilityForC.createAccumulation(r.getOP(), r.getExpressionType(), CodeGenConstantsForC.REDUCE_VAR_NAME, expr);
		loop.getStatements().add(_fact.createStatement(
				CodeGenUtility.createStatementName(unit, 0), scanDom, expr));

		//Create a body to initialize variable used during reduction
		Body reduceVar = _fact.createBody(r.getExpressionType() + " "+CodeGenConstantsForC.REDUCE_VAR_NAME+" = " + r.getIdentityValue()+";");
		//Body for returning the result
		Body returnStatement = _fact.createBody("return "+CodeGenConstantsForC.REDUCE_VAR_NAME+";");
		
		//Set all bodies to the function
		function.getBodies().add(reduceVar);
		function.getBodies().add(loop);
		function.getBodies().add(returnStatement);
		
		unit.getFunctions().add(function);
	}
	
	@Override
	public void inUseEquation(UseEquation u){
		List<Statement> statements = new LinkedList<Statement>();	// the set of new statement associated with the use equation
		//get the space time map
		SpaceTimeMap oriStMap = targetMapping.getSpaceTimeLevel(0).getSpaceTimeMaps().get(u.getLabel());
		Domain origExtDomain = u.getExtensionDomain().copy().image(oriStMap.getInverseOfMapping());
		ParameterDomain paramDom = u.getExtensionDomain().copy().toParameterDomain();
		List<Map<CodeGenVariable, AffineFunction>> codeGenVarAccessPair = new LinkedList<Map<CodeGenVariable, AffineFunction>>();
//		List<Map<CodeGenVariable, EList<IntExpression>>> codeGenVarModPair = new LinkedList<Map<CodeGenVariable, EList<IntExpression>>>();
		List<List<IntExpression>> modList = new LinkedList<List<IntExpression>>();
		//for each input of the use equation get the optimization flag
		//currently assume that every input/ouput should have an optimization specification
		for(int i = 0; i < (u.getInputs().size() + u.getOutputs().size()); i++){
			//check whether current is handling the input or output
			boolean isInput = false;
			int num = i - u.getInputs().size();
			if(i < u.getInputs().size()){
				isInput = true;
				num = i;
			}
			UseEquationOptimization opt = targetMapping.getUseEquationOptimization(u.getLabel(), num, isInput);	//get the optimization flag for the currrent use equation
			MemorySpace var_mspace = targetMapping.getMemorySpace(opt.getMemorySpaceNameforTemporaryVariable());
			modList.add(Collections.<IntExpression>emptyList());
			if(var_mspace.getMemoryMaps().size() <= 0){	//if a new variable has to be created
				//create memory space for the temporary variable
				MemorySpace space = targetMapping.getMemorySpace(opt.getMemorySpaceNameforTemporaryVariable());
				//get the variable declaration for the new temporary variable and set up corresponding targetmappin
				VariableDeclaration var = SubSystemCodeGenUtilityForC.createTemporaryVariable(u, isInput, num, paramDom, targetMapping, space);
				
				if(DEBUG){
					System.out.println("Variable " + var.getName() + " is created!");
				}
				//create a code generation variable for the temporary variable
				CodeGenVariable v = _fact.createCVariable(space, options.flattenArrays, false);
				
				codeGenVarAccessPair.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(v, null));
				unit.getVariables().add(v);
				entryFunction.getSpecialLocals().add(v);
				initialVariables.getSpecialLocals().add(v);
				
				if(!org.polymodel.polyhedralIR.codegen.xtend2.Utility.isScalar(v)){	//create memory allocation statement for non scalar variables
					//Add the special variable to parallelized loop
					/*if(mainLoop instanceof ParallelizedCLoop){
						((ParallelizedCLoop)mainLoop).getSubsystemVariables().put(var, opt.getMemoryAllocationSpaceTimeMap().copy());
					}*/
					addMemoryAllocationForSubSystem(u, isInput, num, var, opt, paramDom, origExtDomain, statements);
				}
				addValueCopyForSubSystem(u, isInput, num, var, opt, paramDom, origExtDomain, statements);
				if(!org.polymodel.polyhedralIR.codegen.xtend2.Utility.isScalar(v)){
					addMemoryFreeForSubSystem(u, isInput, num, var, opt, paramDom, origExtDomain, statements);
				}
			}else{
				//check the form of the corresponding expression is dep@variable or variable for input expression
				//add the variable into as the code gen variable in the funciton call
				AffineFunction access_func = SubSystemCodeGenUtilityForC.extractSubarrayAccessFunction(u, isInput, num, targetMapping);
				if(access_func == null){
					throw new RuntimeException("The " + num+"d input expression can not be completely optimized!");
				}
				
				String spacename = null;
				List<IntExpression> modFactors;
				if(isInput){
					DependenceExpression exp = (DependenceExpression)u.getInputs().get(num);
					spacename = targetMapping.getMemoryMaps().get(((VariableExpression)exp.getExpr()).getVarDecl()).getSpace().getName();
					modFactors = new LinkedList<IntExpression>(EcoreUtil.copyAll(targetMapping.getMemoryMaps().get(((VariableExpression)exp.getExpr()).getVarDecl()).getModFactors()));
				}else{
					spacename = targetMapping.getMemoryMaps().get(u.getOutputs().get(num)).getSpace().getName();
					modFactors = new LinkedList<IntExpression>(EcoreUtil.copyAll(targetMapping.getMemoryMaps().get(u.getOutputs().get(num)).getModFactors()));
				}
				
				//get the code generation variable
				CodeGenVariable v = unit.findCGVariable(spacename);
				Map<CodeGenVariable, AffineFunction> accessMap = new HashMap<CodeGenVariable, AffineFunction>();
				accessMap.put(v, access_func);
				modList.set(modList.size()-1, modFactors);
				codeGenVarAccessPair.add(accessMap);
			}
		}
		
		addSystemCallForSubSystem(u, codeGenVarAccessPair, statements, modList);
		
		statementEquationMap.put(u, statements);
	}
	

	/**
	 * Add memory allocation function for the nth input/output and statements that calls the function into the subsystem 
	 * @param u: the corresponding use equation
	 * @param isInput: is handling input or output 
	 * @param num: the num th input/output
	 * @param var
	 * @param opt
	 * @param paramDom
	 * @param origExtDomain
	 * @param statements
	 */
	public void addMemoryAllocationForSubSystem(UseEquation u, boolean isInput, int num, VariableDeclaration var, UseEquationOptimization opt, ParameterDomain paramDom, Domain origExtDomain, List<Statement> statements){
		//get the memory allocation function name
		String mem_allocate_func_name = SubSystemCodeGenUtilityForC.getUseEquationMemoryAllocationFunctionName(u, isInput, num);
		String mem_allocate_func_call = SubSystemCodeGenUtilityForC.createFunctionCallStatement(mem_allocate_func_name, paramDom.getParamNames(), null);
		//get the domain for the statement
		Domain mem_allocate_func_dom = SubSystemCodeGenUtilityForC.createSpecialStatementDomain(origExtDomain.copy(), opt.getMemoryAllocationSpaceTimeMap(), u.getExtensionDomain().copy());
		Statement mem_allocate_func_stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, mainLoopStatementCount), mem_allocate_func_dom,
						SubSystemCodeGenUtilityForC.createSpecialAssignmentStatement(var.getName(), mem_allocate_func_call));
		if(mainLoop instanceof ParallelizedCLoop){
			((ParallelizedCLoop)mainLoop).getSubsystemVariables().put(mem_allocate_func_stmt.getName(), var);
		}
		mainLoopStatementCount++;
		statements.add(mem_allocate_func_stmt);
		if(DEBUG)
			System.out.println("The domain for the memory allocation function: " + mem_allocate_func_dom);
		
		//create a function for the memory allocation
		Function mem_allocate_func = SubSystemCodeGenUtilityForC.createMemoryAllocationFunction(u, isInput, num, var, options);
		unit.getFunctions().add(mem_allocate_func);
	}
	
	/**
	 * Add value copy function for the nth input/output and statement that calls the function into the subsystem
	 * @param u
	 * @param isInput
	 * @param num
	 * @param var
	 * @param opt
	 * @param paramDom
	 * @param origExtDomain
	 * @param statements
	 */
	public void addValueCopyForSubSystem(UseEquation u, boolean isInput, int num, VariableDeclaration var, UseEquationOptimization opt, ParameterDomain paramDom, Domain origExtDomain, List<Statement> statements){
		CodeGenVariable v = unit.findCGVariable(var.getName());
		
		//create value copy statement
		String value_copy_func_name = SubSystemCodeGenUtilityForC.getUseEquationValueCopyFunctionName(u, isInput, num);
		//get the list of variables that is used in the value copy statement 
		List<Map<CodeGenVariable, AffineFunction>> variables = new LinkedList<Map<CodeGenVariable, AffineFunction>>();
		Function value_copy_func= null;
		if(isInput){
			List<VariableDeclaration> vars = expressionVars.getVars(u.getInputs().get(num).copy());
			for(VariableDeclaration t_var : vars){
				variables.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(t_var, null, targetMapping, unit));
			}
			value_copy_func = SubSystemCodeGenUtilityForC.createValueCopyFunctionForInput(paramDom, u, num, var, vars, targetMapping, options, unit);
			variables.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(v, null));
		}else{
			variables.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(v, null));
			variables.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(u.getOutputs().get(num), null, targetMapping, unit));
			value_copy_func = SubSystemCodeGenUtilityForC.createValueCopyFunctionForOutput(paramDom, u, num, var, targetMapping, options, unit);
		}
				
		String value_copy_func_call = SubSystemCodeGenUtilityForC.createFunctionCallStatement(value_copy_func_name, paramDom.getParamNames(), variables);	//statement string
		Domain value_copy_func_call_dom = SubSystemCodeGenUtilityForC.createSpecialStatementDomain(origExtDomain.copy(), opt.getValueCopySpaceTimeMap(), u.getExtensionDomain().copy());
		Statement value_copy_func_call_stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, mainLoopStatementCount), value_copy_func_call_dom, value_copy_func_call);
		mainLoopStatementCount++;
		statements.add(value_copy_func_call_stmt);
				
		unit.getFunctions().add(value_copy_func);
		if(DEBUG)
			System.out.println("The domain for the value copy function: " + value_copy_func_call_dom);
	}
	
	public void addMemoryFreeForSubSystem(UseEquation u, boolean isInput, int num, VariableDeclaration var, UseEquationOptimization opt, ParameterDomain paramDom, Domain origExtDomain, List<Statement> statements){
		CodeGenVariable v = unit.findCGVariable(var.getName());
		
		//create the memory free statement
		String mem_free_func_name = SubSystemCodeGenUtilityForC.getUseEquatonMemoryFreeFunctionName(u, isInput, num);
		Domain mem_free_func_dom = SubSystemCodeGenUtilityForC.createSpecialStatementDomain(origExtDomain.copy(), opt.getMemoryFreeSpaceTimeMap(), u.getExtensionDomain().copy());
		List<Map<CodeGenVariable, AffineFunction>> freeVars = new LinkedList<Map<CodeGenVariable, AffineFunction>>();
		freeVars.add(SubSystemCodeGenUtilityForC.createCodeVarAccessMap(v, null));
		String mem_free_func_call = SubSystemCodeGenUtilityForC.createFunctionCallStatement(mem_free_func_name, paramDom.getParamNames(),freeVars);
		Statement mem_free_func_call_stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, mainLoopStatementCount), mem_free_func_dom, mem_free_func_call);
		mainLoopStatementCount++;
		statements.add(mem_free_func_call_stmt);
		if(DEBUG)
			System.out.println("The domain for the mem free function domain: " + mem_free_func_dom);
		
		//add the function for the memory 
		Function mem_free_func = SubSystemCodeGenUtilityForC.createMemoryFreeFunction(u, isInput, num, v);
		unit.getFunctions().add(mem_free_func);
	}

	public void addSystemCallForSubSystem(UseEquation u, List<Map<CodeGenVariable, AffineFunction>> codeGenVarAccessPair, List<Statement> statements){
		addSystemCallForSubSystem(u, codeGenVarAccessPair, statements, Collections.<List<IntExpression>>emptyList());
	}
	/*public void addSystemCallForSubSystem(UseEquation u, List<Map<CodeGenVariable, AffineFunction>> codeGenVarAccessPair, List<Statement> statements){
		//add the subsystem call statement
		List<String> parameters = new LinkedList<String>();
		for(int i = 0; i < u.getParameters().getExpressions().size(); i++){
			parameters.add(u.getParameters().getExpressions().get(i).toString());
		}
				
		String subSystemCall = SubSystemCodeGenUtilityForC.createFunctionCallStatement(u.getSubSystem().getName(), parameters, codeGenVarAccessPair);
				
		Statement subSystem_call_stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, mainLoopStatementCount), u.getExtensionDomain().copy(), subSystemCall);
		mainLoopStatementCount++;
		statements.add(subSystem_call_stmt);
	}*/
	
	private void addSystemCallForSubSystem(UseEquation u,
			List<Map<CodeGenVariable, AffineFunction>> codeGenVarAccessPair,
			List<Statement> statements, List<List<IntExpression>> modList) {
		//add the subsystem call statement
		List<String> parameters = new LinkedList<String>();
		for(int i = 0; i < u.getParameters().getExpressions().size(); i++){
			parameters.add(u.getParameters().getExpressions().get(i).toString());
		}
				
		String subSystemCall = SubSystemCodeGenUtilityForC.createFunctionCallStatement(u.getSubSystem().getName(), parameters, codeGenVarAccessPair, modList);
				
		Statement subSystem_call_stmt = _fact.createStatement(CodeGenUtility.createStatementName(unit, mainLoopStatementCount), u.getExtensionDomain().copy(), subSystemCall);
		mainLoopStatementCount++;
		statements.add(subSystem_call_stmt);
		
	}
}