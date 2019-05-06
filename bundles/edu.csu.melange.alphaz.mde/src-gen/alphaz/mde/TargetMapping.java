package alphaz.mde;

/*PROTECTED REGION ID(TargetMapping_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.util.PolymodelRegexParser;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExpressionFactory;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.SubSystemCodeGenUtilityForC;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
/*PROTECTED REGION END*/
/**
Commands for specifying Target Mapping.
**/
public class TargetMapping {

	/**
	Specifies a space time mapping of a variable at a certain level. By default (when there is no value for level), the space-time map is set up for the first level of targetMapping.
	**/
	public static void setSpaceTimeMap(  Program program , String system , int level , String varList , AffineFunction stMap ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMap) ENABLED START*/
		String[] vars = Utility.stringListToArray(varList);
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		if(tm.getSpaceTimeLevel(level) == null){
			throw new RuntimeException("The Space Time specification is not specified for this level, please call CreateSpaceTimeLevel command first!");
		}
		//add vars
		for (String var : vars) {
			final VariableDeclaration varDecl = program.getSystem(system).getVariableDeclaration(var);
			if(varDecl != null){
				tm.getSpaceTimeLevel(level).getSpaceTimeMaps().put(varDecl.getName(), TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDecl, stMap));
			}else if(program.getSystem(system).getUseEquation(var) != null){
				tm.getSpaceTimeLevel(level).getSpaceTimeMaps().put(var, TargetMappingUserFactory.createUseEquationSpaceTimeMap(var, stMap, program.getSystem(system).getUseEquation(var)));
			}else{
				throw new RuntimeException("No such variable or use equation whose name is " + var);
			}
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMap( Program program, String system, int level, String varList,  String stMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMap_0) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMap);
		setSpaceTimeMap(program, system, level, varList, function);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMap( Program program, String system, String varList,  String stMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMap_1) ENABLED START*/
		setSpaceTimeMap(program, system, 0, varList, stMap);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMap( Program program, String system, String varList,  String bodySTMap, String initSTMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMap_2) ENABLED START*/
	    AffineSystem syst = program.getSystem(system);

	    String[] varNames = Utility.stringListToArray(varList);
	    for (String varName : varNames) {
	      Long identityValue = getIdentityValue(
	          ((ReduceExpression)syst.getEquation(varName).getExpression()).getOP(),
	          syst.getEquation(varName).getExpression().getExpressionType());
	      setSpaceTimeMapEQWithReduction(program, varName, syst, bodySTMap, initSTMap, identityValue);
	    }
	    /*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMap( Program program, String system, String varList,  String bodySTMap, String initSTMap, String intValue) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMap_3) ENABLED START*/
	    /*
	     * 1. First add new dummy variable/equation for the init of the result variable of the reduction.
	     *    TODO need to fix the the way we create init expression. it should be automatic
	     * 2. Then set stmap of result equation to stmap of reduction body
	     * 3. set stmap of init the stmap of init
	     * 4. set the memory space of result var and init to same
	     * 5. set the statement order of init and result
	     */
	    AffineSystem syst = program.getSystem(system);

	    String[] varNames = Utility.stringListToArray(varList);
	    for (String varName : varNames) {
	      setSpaceTimeMapEQWithReduction(program,  varName, syst, bodySTMap, initSTMap, Long.parseLong(intValue));
//	      String initVarName = varName+"_Alpha_Init";
//	      VariableDeclaration var = syst.getVariableDeclaration(varName);
//	      VariableDeclaration varDeclLoc = _polyIR.createVariableDeclaration(initVarName, var.getType(), var.getDomain().copy());
	//
//	      //ExpressionFactory.eINSTANCE.createFromString(Double.class, initValue);
	//
//	      IntegerExpression expr = ExpressionFactory.eINSTANCE.createIntegerExpression();
//	      expr.setValue(Long.parseLong(initValue));
//	      Long identityValue = getIdentityValue(
//	          ((ReduceExpression)syst.getEquation(varName).getExpression()).getOP(),
//	          syst.getEquation(varName).getExpression().getExpressionType());
//	      DependenceExpression dexpr = ExpressionFactory.eINSTANCE.createDependenceExpression();
//	      dexpr.setExpr(expr);
//	      // create projection function (z -> )
//	      AffineFunction function = PolyhedralIRUtility.createProjection(varDeclLoc.getDomain(), Collections.<Variable>emptyList());
////	      AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), "(i,j->)");
//	      dexpr.setDep(function);
	//
//	      // Adding the new equation to the system
//	      syst.getLocals().add(varDeclLoc);
//	      StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc , dexpr);
//	      syst.getEquations().add(eqLocal);
//	      // Update the context/expression domain of the new system
	//
//	      setSpaceTimeMap(program, system, 0, varName, bodySTMap);
//	      setSpaceTimeMap(program, system, 0, initVarName, initSTMap);
//	      setMemorySpace(program, system, varName, initVarName);
//	      setStatementOrdering(program, system, initVarName, varName);
	    }
	    ContextDomainCalculator.computeContextDomain(syst);
		/*PROTECTED REGION END*/
	}

	/*PROTECTED REGION ID(TargetMapping_custom_funcs) ENABLED START*/
	 
	  
	  
	  /* @generated NOT
	   *
	   */
	  private static void setSpaceTimeMapEQWithReduction(Program program, String varName, AffineSystem syst,
	      String bodySTMap, String initSTMap, Long identityValue) {
	    String initVarName = varName+"_Alpha_Init";

	    VariableDeclaration var = syst.getVariableDeclaration(varName);
	    VariableDeclaration varDeclLoc = PolyhedralIRUserFactory.
	        eINSTANCE.createVariableDeclaration(initVarName,
	            var.getType(), var.getDomain().copy());

	    //ExpressionFactory.eINSTANCE.createFromString(Double.class, initValue);

	    IntegerExpression expr = ExpressionFactory.eINSTANCE.createIntegerExpression();
	    expr.setValue(identityValue);

	    DependenceExpression dexpr = ExpressionFactory.eINSTANCE.createDependenceExpression();
	    dexpr.setExpr(expr);
	    // create projection function (z -> )
	    AffineFunction function = PolyhedralIRUtility.createProjection(varDeclLoc.getDomain(), Collections.<Variable>emptyList());
//	    AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), "(i,j->)");
	    dexpr.setDep(function);

	    // Adding the new equation to the system
	    syst.getLocals().add(varDeclLoc);
	    StandardEquation eqLocal = PolyhedralIRUserFactory.
	        eINSTANCE.createStandardEquation(varDeclLoc , dexpr);
	    syst.getEquations().add(eqLocal);
	    // Update the context/expression domain of the new system

	    setSpaceTimeMap(program, syst.getName(), 0, varName, bodySTMap);
	    setSpaceTimeMap(program, syst.getName(), 0, initVarName, initSTMap);
	    setMemorySpace(program, syst.getName(), varName, initVarName);
	    setStatementOrdering(program, syst.getName(), initVarName, varName);

	  }

	  /* @generated NOT
	   * Auto
	   */
	  private static long getIdentityValue(OP op, Type expressionType) {
	    switch (op) {
	    case ADD:
	    case OR:
	      return  0;
	    case MUL:
	    case AND:
	      return  1;
	    case MAX:
	      //When unsigned, 0 is the minimum
	      if (expressionType.getSigned() == SIGNED.UNSIGNED) {
	        return 0;
	      //Otherwise, use symbolic value MIN_INT
	      } else {
	        return Long.MIN_VALUE;
//	        IntMin min = IntegerExpressionUserFactory.intMin();
//	        IntExpressionBuilder.
//	        min.setSigned(true);
//	        min.setWidth(getExpressionType().getWidth());
//	        return min;
	      }
	    case MIN:
	      return Long.MAX_VALUE;
//	      IntMax max = IntegerExpressionUserFactory.intMax();
//	      max.setSigned(getExpressionType().getSigned() == SIGNED.SIGNED);
//	      max.setWidth(getExpressionType().getWidth());
//	      return max;
	    default:
	      throw new RuntimeException("Reduction with operator " + op + " is currently not supported.");
	  }
	  }
	/*PROTECTED REGION END*/

	/**
	Specifies a memory map for a variable. Some variables may share the same meory map and memory space, then they can be set up using one command by providing a list of variables. 
	**/
	public static void setMemoryMap(  Program program , String system , String varList , String memorySpace , AffineFunction memoryMap , String modFactors ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemoryMap) ENABLED START*/
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		String[] vars = Utility.stringListToArray(varList);
		for (String var : vars) {
			VariableDeclaration varDecl = program.getSystem(system).getVariableDeclaration(var);
			//Mod factors
			List<IntExpression> modExprs = null;
			if (modFactors != null) {
				modExprs = new LinkedList<IntExpression>();
				for (String expr : modFactors.split(",")) {
					//FIXME only affine expressions are parsed
					modExprs.add(PolymodelRegexParser.parseAffineExpression(expr, varDecl.getDomain().getIndices(), varDecl.getDomain().getParams()));
				}
			}
			MemorySpace mspace = tm.getMemorySpace(memorySpace);
			tm.getMemorySpaces().add(mspace);
			tm.getMemoryMaps().put(varDecl, TargetMappingUserFactory.createMemoryMap(varDecl, memoryMap, modExprs, mspace));
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList, String memorySpace,  String memoryMap, String modFactor) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemoryMap_0) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), memoryMap);
		setMemoryMap(program, system, varList, memorySpace, function, modFactor);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList, AffineFunction memoryMap, String modFactors) {
		setMemoryMap( program, system, varList, null , memoryMap, modFactors);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList, AffineFunction memoryMap) {
		setMemoryMap( program, system, varList, null , memoryMap, null );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList, String memorySpace, AffineFunction memoryMap) {
		setMemoryMap( program, system, varList, memorySpace, memoryMap, null );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList, String memorySpace,  String memoryMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemoryMap_4) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), memoryMap);
		setMemoryMap(program, system, varList, memorySpace, function, null);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setMemoryMap( Program program, String system, String varList,  String memoryMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemoryMap_5) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), memoryMap);
		setMemoryMap(program, system, varList, function, null);
		/*PROTECTED REGION END*/
	}


	/**
	Specifies the memory space for a variable. Normally, each variable has a separate memory space. However, some variables may share the same memory space, and this can be set up once by providing a list of variable.
	**/
	public static void setMemorySpace(  Program program , String system , String space , String varList ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemorySpace) ENABLED START*/
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		String[] vars = Utility.stringListToArray(varList);
		MemorySpace mspace = tm.getMemorySpace(space);
		//set the memory map of all the variables to the same memory space
		for (String var : vars) {
			VariableDeclaration variable = program.getSystem(system).getVariableDeclaration(var);
			if(tm.getMemoryMaps().get(variable) != null){
				tm.getMemoryMaps().get(variable).setSpace(mspace);
			}else{
				tm.getMemoryMaps().put(variable, TargetMappingUserFactory.createIdentityMemoryMap(variable, mspace));
			}
		}
		/*PROTECTED REGION END*/
	}


	/**
	Specifies the ordering of the statements (alphabets variables) in the generated code. This is similar to adding an additional ordering dimensions to the last dimension of space-time mapping, and providing ordering information.
AlphaZ provides an alternative to such specification by allowing the user to specify partial orderings between statements.
A total order is deduced at the time of code generation.
	**/
	public static void setStatementOrdering(  Program program , String system , String predecessor , String successor ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setStatementOrdering) ENABLED START*/
		if (program.getSystem(system) == null) {
			throw new RuntimeException("Provided system: " + system + " does not exist in program: " + program.getFilename());
		} else if (program.getSystem(system).getEquation(predecessor) == null) {
			throw new RuntimeException("Equation for " + predecessor + " does not exist in system: " + system + ". Note: variable names are case sensitive.");
		}  else if (program.getSystem(system).getEquation(successor) == null) {
			throw new RuntimeException("Equation for " + successor + " does not exist in system: " + system + ". Note: variable names are case sensitive.");
		}
		StatementPartialOrder partial = TargetMappingUserFactory.createStatementOrder(program.getSystem(system).getEquation(predecessor), 
				program.getSystem(system).getEquation(successor));
		program.getSystem(system).getTargetMapping().getStatementOrderings().add(partial);
		/*PROTECTED REGION END*/
	}


	/**
	Lists all SpaceTime maps that have been specified for a system.
	**/
	public static void listSpaceTimeMaps(  Program prog , String system , int level ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.listSpaceTimeMaps) ENABLED START*/
		System.out.println("===The SpaceTime Maps===");
		for (SpaceTimeMap stMap : prog.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getSpaceTimeMaps().values()) {
			if(prog.getSystem(system).getVariableDeclaration(stMap.getLabel()) != null){	//skip input variables
				if(prog.getSystem(system).getVariableDeclaration(stMap.getLabel()).isInput()) continue;
			}
			System.out.println(stMap);
		}

		System.out.println("===The ordering dimensions===");
		System.out.println(prog.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getOrderingDimensions());
//		System.out.println("++++The parallel dimensions++++");
//		for(ParallelizationSpecification parallel : prog.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getParallelizationSpecifications()){
//			System.out.println("The ordering prefix: " + parallel.getOrderingPrefix() + " The parallel dimensions: " + parallel.getParallelDims());
//		}
//		System.out.println("++++The tililng specification++++");
//		for(TilingSpecification tile: prog.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getTilingSpecifications()){
//			System.out.println("The ordering prefix: " + tile.getOrderingPrefix() + "The tile band: (start)" + tile.getStartDim() + "(end) " + tile.getEndDim() + 
//					"TILINGTYPE: " + tile.getTilingType().toString() + "TILESIZETYPE: " + tile.getTileSizeType().toString());
//		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void listSpaceTimeMaps( Program prog, String system) {
		listSpaceTimeMaps( prog, system, 0 );
	}
	


	/**
	Lists all memory mappings specified for a system.
	**/
	public static void listMemoryMaps(  Program prog , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.listMemoryMaps) ENABLED START*/
		System.out.println("===Memory Maps===");
		for (MemorySpace space : prog.getSystem(system).getTargetMapping().getMemorySpaces()) {
			for (MemoryMap mMap : space.getMemoryMaps()) {
				System.out.println(mMap);
			}
		}
		/*PROTECTED REGION END*/
	}


	/**
	Applies schedules found by a scheduler (such as Farkas scheduler) to target mapping.
	**/
	public static void setSchedule(  Program prog , String system , List<ScheduledStatement> schedules ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSchedule) ENABLED START*/
		AffineSystem s = prog.getSystem(system);
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = s.getTargetMapping();
		for (ScheduledStatement stmt : schedules) {
			//convert to function
			List<AffineExpression> affine = new ArrayList<AffineExpression>(stmt.getSchedule().size());
			for (IntExpression ie : stmt.getSchedule()) {
				affine.add(ie.toAffine());
			}
			
			AffineFunction f = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(stmt.getStatement().getDomain().getParams(),
					stmt.getStatement().getDomain().getIndices(),
					affine);
			VariableDeclaration var = s.getVariableDeclaration(stmt.getStatement().getName());
			if(var != null){
				SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, f);
				tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(var.getName(), stMap);
			}else if(s.getUseEquation(stmt.getStatement().getName()) != null){
				UseEquation eq = s.getUseEquation(stmt.getStatement().getName());
				SpaceTimeMap stMap = TargetMappingUserFactory.createUseEquationSpaceTimeMap(eq.getLabel(), f, eq);
				tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(eq.getLabel(), stMap);
			}else{
				throw new RuntimeException("There is no corresponding equation in the system to the statement " + stmt.getStatement().getName());
			}
		}
		/*PROTECTED REGION END*/
	}


	/**
	Specify the parallel dimensions for a system. The nth dimension (specified by parallelDims, start with zero) with the specified ordering prefix to be parallel.
	**/
	public static void setParallel(  Program program , String system , int level , String orderingPrefix , String parallelDims ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setParallel) ENABLED START*/
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		List<Integer> prefix = Utility.parseIntegerArray(orderingPrefix);
		List<Integer> dims = Utility.parseIntegerArray(parallelDims);
		ParallelizationSpecification parallel = TargetMappingUserFactory.createParallelizationSpecification(prefix, dims);
		tm.getSpaceTimeLevel(level).getParallelizationSpecifications().add(parallel);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setParallel( Program program, String system, String orderingPrefix, String parallelDims) {
		setParallel( program, system, 0 , orderingPrefix, parallelDims);
	}
	


	/**
	Create a spacetimelevel data stucture for level (level)
	**/
	public static void CreateSpaceTimeLevel(  Program program , String system , int level ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.CreateSpaceTimeLevel) ENABLED START*/
		int curLevel = program.getSystem(system).getTargetMapping().getSpaceTimeLevels().size();
		if(level > curLevel){
			throw new RuntimeException("Can not jump from level " + (curLevel - 1) + " to " + level);
		}
		
		AffineSystem affineSystem = program.getSystem(system);
		if(level == curLevel){
			List<VariableDeclaration> vars = new LinkedList<VariableDeclaration>();
			vars.addAll(affineSystem.getInputs());
			vars.addAll(affineSystem.getLocals());
			vars.addAll(affineSystem.getOutputs());
			
			List<UseEquation> uses = program.getSystem(system).getUseEquations();
			program.getSystem(system).getTargetMapping().getSpaceTimeLevels().add(TargetMappingUserFactory.createIdentitySpaceTimeLevel(vars, uses));
		}
		/*PROTECTED REGION END*/
	}


	/**
	specify which dimension is the ordering dimension for each level of the targetMapping. Dimension starts with zero. If no value is specified for the targetMapping level, it is the first level by default. 
	**/
	public static void setOrderingDimensions(  Program program , String system , int level , String dims ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setOrderingDimensions) ENABLED START*/
		List<Integer> dimensions = Utility.parseIntegerArray(dims);
		program.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getOrderingDimensions().addAll(dimensions);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setOrderingDimensions( Program program, String system, int level,  int dim) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setOrderingDimensions_0) ENABLED START*/
		program.getSystem(system).getTargetMapping().getSpaceTimeLevel(level).getOrderingDimensions().add(dim);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setOrderingDimensions( Program program, String system, String dims) {
		setOrderingDimensions( program, system, 0 , dims);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setOrderingDimensions( Program program, String system,  int dim) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setOrderingDimensions_2) ENABLED START*/
		setOrderingDimensions(program, system, 0, dim);
		/*PROTECTED REGION END*/
	}


	/**
	set space time map for the memory allocation statement for the input/output of the use equation.
isInput -- 0: for nTh input of the use equaiton
isInput -- 1: for nTh output of the use equation
	**/
	public static void setSpaceTimeMapForMemoryAllocation(  Program program , String system , String label , int isInput , int num , AffineFunction stMap ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForMemoryAllocation) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		if(affineSystem.getUseEquation(label) == null){
			throw new RuntimeException("No use equation " + label + " is defined!");
		}
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		boolean input = true;
		if(isInput == 1)	input = false;
		if(tm.getUseEquationOptimization(label, num, input) == null){
			String spaceName = SubSystemCodeGenUtilityForC.getUseEquationVariableName(affineSystem.getUseEquation(label), input, num);
			tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, num, input, null, spaceName, stMap, null, null));
		}else{
			tm.getUseEquationOptimization(label, num, input).setMemoryAllocationSpaceTimeMap(stMap);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMapForMemoryAllocation( Program program, String system, String label, int isInput, int num,  String stMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForMemoryAllocation_0) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMap);
		setSpaceTimeMapForMemoryAllocation(program, system, label, isInput, num, function);
		/*PROTECTED REGION END*/
	}


	/**
	set the space time map for the value copy statement for input/output of a use equation
	**/
	public static void setSpaceTimeMapForValueCopy(  Program program , String system , String label , int isInput , int num , AffineFunction stMap ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForValueCopy) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		if(affineSystem.getUseEquation(label) == null){
			throw new RuntimeException("No use equation " + label + " is defined!");
		}
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		boolean input = true;
		if(isInput == 1)	input = false;
		if(tm.getUseEquationOptimization(label, num, input) == null){
			String spaceName = SubSystemCodeGenUtilityForC.getUseEquationVariableName(affineSystem.getUseEquation(label), input, num);
			tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, num, input, null, spaceName, null, stMap, null));
		}else{
			tm.getUseEquationOptimization(label, num, input).setValueCopySpaceTimeMap(stMap);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMapForValueCopy( Program program, String system, String label, int isInput, int num,  String stMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForValueCopy_0) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMap);
		setSpaceTimeMapForValueCopy(program, system, label, isInput, num, function);
		/*PROTECTED REGION END*/
	}


	/**
	set the space time map for the memory free statement for the input/ouput of a useEquation.
isInput -- 0, for the input of the useEquation
isInput -- 1, for the output of the useEquation
	**/
	public static void setSpaceTimeMapForMemoryFree(  Program program , String system , String label , int isInput , int num , AffineFunction stMap ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForMemoryFree) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		if(affineSystem.getUseEquation(label) == null){
			throw new RuntimeException("No use equation " + label + " is defined!");
		}
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		boolean input = true;
		if(isInput == 1)	input = false;
		if(tm.getUseEquationOptimization(label, num, input) == null){
			String spaceName = SubSystemCodeGenUtilityForC.getUseEquationVariableName(affineSystem.getUseEquation(label), input, num);
			tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, num, input, null, spaceName, null, null, stMap));
		}else{
			tm.getUseEquationOptimization(label, num, input).setMemoryFreeSpaceTimeMap(stMap);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMapForMemoryFree( Program program, String system, String label, int isInput, int num,  String stMap) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForMemoryFree_0) ENABLED START*/
		AffineFunction function = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMap);
		setSpaceTimeMapForMemoryFree(program, system, label, isInput, num, function);
		/*PROTECTED REGION END*/
	}


	/**
	set the space time map for the memory allocation, value copy, memory allocation statement for the input/output of the useEuqation.
isInput -- 0: for the input of the useEquation
isInput -- 1: for the output of the useEquation
	**/
	public static void setSpaceTimeMapForUseEquationOptimization(  Program program , String system , String label , int isInput , int num , AffineFunction stMapForMemoryAllocation , AffineFunction stMapForValueCopy , AffineFunction stMapForMemoryFree ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForUseEquationOptimization) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		if(affineSystem.getUseEquation(label) == null){
			throw new RuntimeException("No use equation " + label + " is defined!");
		}
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		boolean input = true;
		if(isInput == 1)	input = false;
		if(tm.getUseEquationOptimization(label, num, input) == null){
			String spaceName = SubSystemCodeGenUtilityForC.getUseEquationVariableName(affineSystem.getUseEquation(label), input, num);
			tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, num, input, null, spaceName, stMapForMemoryAllocation, stMapForValueCopy, stMapForMemoryFree));
		}else{
			tm.getUseEquationOptimization(label, num, input).setMemoryAllocationSpaceTimeMap(stMapForMemoryAllocation);
			tm.getUseEquationOptimization(label, num, input).setValueCopySpaceTimeMap(stMapForValueCopy);
			tm.getUseEquationOptimization(label, num, input).setMemoryFreeSpaceTimeMap(stMapForMemoryFree);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setSpaceTimeMapForUseEquationOptimization( Program program, String system, String label, int isInput, int num,  String stMapForMemoryAllocation, String stMapForValueCopy, String stMapForMemoryFree) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSpaceTimeMapForUseEquationOptimization_0) ENABLED START*/
		AffineFunction mAllocationFunction = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMapForMemoryAllocation);
		AffineFunction vCopyFunction = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMapForValueCopy);
		AffineFunction mFreeFunction = PolyhedralIRUtility.parseAffineFunction(program.getSystem(system).getParameters(), stMapForMemoryFree);
		setSpaceTimeMapForUseEquationOptimization(program, system, label, isInput, num, mAllocationFunction, vCopyFunction, mFreeFunction);
		/*PROTECTED REGION END*/
	}


	/**
	set memory space for the input/ouput of the useEquation
	**/
	public static void setMemorySpaceForUseEquationOptimization(  Program program , String system , String label , int isInput , int num , String spaceName ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setMemorySpaceForUseEquationOptimization) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		if(affineSystem.getUseEquation(label) == null){
			throw new RuntimeException("No use equation " + label + " is defined!");
		}
		final org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = program.getSystem(system).getTargetMapping();
		boolean input = true;
		if(isInput == 1)	input = false;
		if(tm.getUseEquationOptimization(label, num, input) == null){
			tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, num, input, null, spaceName, null, null, null));
		}else{
			tm.getUseEquationOptimization(label, num, input).setMemorySpaceNameforTemporaryVariable(spaceName);
		}
		/*PROTECTED REGION END*/
	}


	/**
	configure a band of continuous dimensions for tiling.
	**/
	public static void setBandForTiling(  Program program , String system , String bandName , int levels , String orderingPrefix , int startDim , int endDim ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setBandForTiling) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		SpaceTimeLevel tm_level = affineSystem.getTargetMapping().getSpaceTimeLevel(0);
		if(startDim == -1 && endDim == -1 && orderingPrefix.contentEquals("")){	//set dimension to be the whole program dim
			startDim = 0;
			endDim = tm_level.getNumberOfDimensions()-1;
		}
		if(startDim < 0){
			throw new RuntimeException("The starting dimension must be greater or equal to 0.");
		}else if(endDim >= tm_level.getNumberOfDimensions()){
			throw new RuntimeException("The last dimension " + endDim + " is more than the total number of dimensions " + tm_level.getNumberOfDimensions());
		}
		List<Integer> prefix = Utility.parseIntegerArray(orderingPrefix);
		tm_level.getTilingSpecifications().add(TargetMappingUserFactory.createTilingSpecification(bandName, prefix, startDim, endDim, levels));
		/*PROTECTED REGION END*/
	}

	/**
	set up tiling band with empty ordering prefix
	**/
	public static void setBandForTiling( Program program, String system, String bandName, int levels, int startDim, int endDim) {
		setBandForTiling( program, system, bandName, levels, "" , startDim, endDim);
	}
	


	/**
	Configure the subtiling specification for a band. The band is identified by the name. There are two types of tiling type: sequential and openmp wavefront. Represented with "sequential" and "wavefront" separately.
	**/
	public static void setSubTilingWithinBand(  Program program , String system , String bandName , int level , int startDim , int endDim , String tilingType ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setSubTilingWithinBand) ENABLED START*/
		AffineSystem affineSystem = program.getSystem(system);
		SpaceTimeLevel tm_level = affineSystem.getTargetMapping().getSpaceTimeLevel(0);
		TilingSpecification tile = tm_level.getTilingSpecification(bandName);
		if(startDim == -1 && endDim == -1){
			startDim = tile.getStartDim();
			endDim = tile.getEndDim();
		}else if(startDim == -1 || endDim == -1){
			throw new RuntimeException("the start dimension and end dimension must be greater or equal to 0.");
		}
		
		TILING_TYPE type = TILING_TYPE.SEQUENTIAL;
		if(tilingType.contentEquals("openmp")){
			type = TILING_TYPE.OMPWAVEFRONT;
		}else if(tilingType.contentEquals("sequential")){
			type = TILING_TYPE.SEQUENTIAL;
		}else{
			throw new RuntimeException("Unknown tiling type! Tiling type must be either openmp or sequential.");
		}
		
		tile.getSubTiles().add(TargetMappingUserFactory.createSubTilingSpecification(level, startDim, endDim, type));
		/*PROTECTED REGION END*/
	}

	/**
	Tile all the dimensions in the band for the current level
	**/
	public static void setSubTilingWithinBand( Program program, String system, String bandName, int level, String tilingType) {
		setSubTilingWithinBand( program, system, bandName, level, -1 , -1 , tilingType);
	}
	


	/**
	Set up the default configuration for dtiler: apply parametric one level tiling to all the dimensions from [start to end].
	**/
	public static void setDefaultDTilerConfiguration(  Program program , String system , int startDim , int endDim , String tilingType ) {
		/*PROTECTED REGION ID(alphaz.mde.targetmapping.setDefaultDTilerConfiguration) ENABLED START*/
		//default name for dtiler band
		String bandName = "dtiler_band_"+ startDim + "_"+endDim;
		//configure the band
		setBandForTiling(program, system, bandName, 1, startDim, endDim);
		//configure the one level sub band with all the dimensions
		setSubTilingWithinBand(program, system, bandName, 1, tilingType);
		/*PROTECTED REGION END*/
	}

	/**
	Default configuration for DTiler for the whole program: apply parametric one level tiling to all the dimensions of the given system in the program.
	**/
	public static void setDefaultDTilerConfiguration( Program program, String system, String tilingType) {
		setDefaultDTilerConfiguration( program, system, -1 , -1 , tilingType);
	}
	

}//end TargetMapping
