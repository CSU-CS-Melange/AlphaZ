package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.SystemCallAnalysis;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.PreprocessForTemporaryBuffer;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler.SIMDPreprocessForFullTile;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.transformation.reduction.SerializeReduction;
import org.polymodel.polyhedralIR.util.AShow;


public class ScheduledC extends CodeGeneratorTemplateForC {
	
	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	
	protected final AffineSystem system;
	protected final CodeGenOptions options;

	protected List<VariableDeclaration> COBignoreList = new LinkedList<VariableDeclaration>();
	protected List<Variable> tileSizes = null;

	public static boolean DEBUG = false;
	
	/**
	 * Static method for public access to ScheduledC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(system);
		
		if (options.isHybridSchedule) {
			systemCodeGenenration(system, options, outDir);
			CodeGenOptions newOptions = options.copy();
			newOptions.isHybridSchedule = false;
			systems.remove(system);
			for(AffineSystem sys : systems){
				systemCodeGenenration(sys, newOptions, outDir);
			}
		} else {
//			systemCodeGenenration(system, options, outDir);
			for(AffineSystem sys : systems){
				systemCodeGenenration(sys, options, outDir);
			}
		}
	}
	
	/**
	 * Static method for public access to ScheduledC code generator for the whole program
	 * It generates one file for each system
	 * @param program
	 * @param options
	 * @param outDir
	 */
	public static void generate(Program program, CodeGenOptions options, String outDir){
		for(AffineSystem sys: program.getSystems()){
			systemCodeGenenration(sys, options, outDir);
		}
	}
	
	/**
	 * Static method for public access to ScheduledC code generator for one system
	 * It generates one file for each system
	 * @param program
	 * @param options
	 * @param outDir
	 */
	public static void systemCodeGenenration(AffineSystem system, CodeGenOptions options, String outDir){
		ScheduledC scheduledC = new ScheduledC(system, options);
		scheduledC.generate(options, outDir);
	}
	
	protected ScheduledC(AffineSystem system, CodeGenOptions options) {
		super(system.getContainerProgram());
		this.system = program.getSystem(system.getName());
		this.options = options;

		//verify the space time map specification, check whether it is only one level
		if(!VerifyTargetMappingLevel(system)){
			throw new RuntimeException("The target mapping for spacetime map can not have more than one level");
		}
	}
	
	
	/**
	 * current schedule C only handles space time map with one level 
	 * @return
	 */
	protected boolean VerifyTargetMappingLevel(AffineSystem system){
		EList<SpaceTimeLevel> stlevels = system.getTargetMapping().getSpaceTimeLevels();
		if(stlevels.size() > 1){
			return false;
		}
		return true;
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.SCHEDULED_C;
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		//add tile sizes as parameters
		if (system.getTargetMapping().isTiled() || 
				((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassSequential) ||
				((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassWavefront)) {
			//TOBE FIXED
			tileSizes = addTileSizesAsParameters(this.system, (TiledCodeGenOptions)options);
			
			if(((TiledCodeGenOptions)options).vec){
				preCheckForDTilerVecOptions(this.system, (TiledCodeGenOptions)options);
			}
		}
		
//		final List<Equation> torder = system.getTargetMapping().getStatementTotalOrder();
//		EList<Equation> equations = new BasicEList<Equation>();
//		equations.addAll(system.getEquations());
//		equations.addAll(system.getUseEquations());
//		//Reflect statement ordering
//		ECollections.sort(equations, new Comparator<Equation>() {
//						@Override
//			public int compare(Equation o1,Equation o2) {
//				return torder.indexOf(o1) - torder.indexOf(o2);
//			}
//			
//		});
	}

	/**
	 * Finds equations (after NormalizeReductions) with scheduled reduction body.
	 * 
	 * @return
	 */
	private List<StandardEquation> findReductionsWithScheduledBody() {
		List<StandardEquation> res = new LinkedList<StandardEquation>();
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		
		for (StandardEquation eq : system.getEquations()) {
			if (eq.getExpression() instanceof ReduceExpression) {
				//SpaceTimeMap stMap = system.getTargetMapping().getSpaceTimeMap(eq.getVariable());
				SpaceTimeMap stMap = stlevel.getSpaceTimeMaps().get(eq.getVariable().getName());
				final int varDims = eq.getVariable().getDomain().getNIndices();
				final int bodyDims = ((ReduceExpression) eq.getExpression()).getProjection().getDimLHS();
				final int schLHS = stMap.getMapping().getDimLHS();
				
				if (varDims == bodyDims) {
					throw new RuntimeException("Reduction body and answer space has same dimensionality.");
				}
				//body specified
				if (bodyDims == schLHS) {
					res.add(eq);
				}
			}
		}
		
		return res;
	}

	/**
	 * post processing after serialization of reduction
	 * remove the old variable, update the targetMapping
	 */
	private void postProcessingForSerializeReduction(VariableDeclaration var, VariableDeclaration serVar, ReduceExpression orieq){
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		
		//ReduceExpression eq = (ReduceExpression)system.getEquation(var.getName());
		/*update the target mamping*/
		SpaceTimeMap stMap = stlevel.getSpaceTimeMaps().get(var.getName());
		//set the space time map for the new variable
		//the schedule for the new variable is the same as the schedule before
		stlevel.getSpaceTimeMaps().put(serVar.getName(), TargetMappingUserFactory.createStandardEquationSpaceTimeMap(serVar, stMap.getMapping().copy()));
		
		MemoryMap mMap = system.getTargetMapping().getMemoryMaps().get(var);
		List<IntExpression> modfactors = new LinkedList<IntExpression>();
		for(int i = 0; i < mMap.getModFactors().size(); i++){
			modfactors.add(EcoreUtil.copy(mMap.getModFactors().get(i)));
		}
		//The memory map for the new variable is the projection function compose the memory map of the old variable
		system.getTargetMapping().getMemoryMaps().put(serVar,
				TargetMappingUserFactory.createMemoryMap(
						serVar, mMap.getMapping().copy().compose(orieq.getProjection()), modfactors, mMap.getSpace()));
		
		//set up the space time map for the new equation with old variable name
		StandardEquation eq = system.getEquation(var.getName());
		DependenceExpression dep= (DependenceExpression)eq.getExpression();
		SpaceTimeMap newStMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, stMap.getMapping().compose(dep.getDep().copy()));
		stlevel.getSpaceTimeMaps().removeKey(stMap);	//remove old mapping
		stlevel.getSpaceTimeMaps().put(var.getName(), newStMap);	//set the new mapping
	}
	
	
	/**
	 * get the list of variables used 
	 * @return
	 */
	private EList<VariableDeclaration> getSubSystemOutputs(){
		EList<VariableDeclaration> outputVars = new UniqueEList<VariableDeclaration>();
		for(UseEquation u: system.getUseEquations()){
			outputVars.addAll(u.getOutputs());
		}
		return outputVars;
	}
	
	/**
	 * update the target mapping for the output variables
	 */
	private void preProcessingForUseEquation(String label){
		SpaceTimeMap stMap = system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(label);
		UseEquation use = system.getUseEquation(label);
		for(VariableDeclaration var: use.getOutputs()){
			//construct the COB function for the use equation
			AffineFunction fOutput = FunctionOperations.addLastDimensions(stMap.getMapping(), var.getDomain().getNIndices()-use.getExtensionDomain().getNIndices());
			//update the target mapping
			if(system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()) != null){
				AffineFunction origFunc = system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()).getMapping();
				AffineFunction newFunc = fOutput.compose(origFunc);
				system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()).setMapping(newFunc);
				system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()).setInverseOfMapping(newFunc.inverseInContext(var.getDomain(), null));
			}else{
				//create the new space time map
				SpaceTimeMap map = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, fOutput);
				system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().put(var.getName(), map);
			}
		}
	}
	
	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();

		//get a copy of the original target mapping
		TargetMapping tm = system.getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		
		EList<VariableDeclaration> subSystemOutputVars = getSubSystemOutputs();
		
		/* 
		 * if Hybrid scheduling is enabled, add a new dimension to the target mapping
		 * so that we can order acquire (or update) and copy equations of the sub systems.
		 */
		if (options.isHybridSchedule) {
			GenerateSyncronizationVariables.generateSyncronizationVariables(system);
			
			System.out.println("ASHOW:\n" + AShow.toString(program));
			//Check program
			ValidatorOutput output = UniquenessAndCompletenessCheck.validate(system);
			System.out.println(output.toString(org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY.MAX));
			
			
			
			
//			if (stlevel.getNumberOfParallelDimensions()==0) {
//				System.out.println("Warning: Parallel dimensions are not specified. Therefore");
//			}
			
			
			//It was incorrect to add checks right after the processor dims. 
			// Therefore we no longer need  nParallelDims
//			int nParallelDims = stlevel.getNumberOfParallelDimensions();
			int orderingDimForChecks = options.dimToAddChecks;
			
			/*
			 * add ordering dimension to equations including subsystem call of use equations
			 */
			for (Entry<String, SpaceTimeMap> stMapEntry : stlevel.getSpaceTimeMaps()) {
				String varName = stMapEntry.getKey();
				VariableDeclaration var = system.getVariableDeclaration(varName);
				if (var != null && (var.isInput() || subSystemOutputVars.contains(var))) {
					continue;
				}
				
//				//We already added the ordering dimension when we added the statements
//				if (var.getName().startsWith("__Update_") 
//						|| var.getName().startsWith("__Acquire_")) {
//					continue;
//				}
				
				SpaceTimeMap stMap = stMapEntry.getValue();
//				AffineFunction newMapping = addOrderingDimension(nParallelDims,
				
				AffineFunction mapping = stMap.getMapping();
				int numDims = mapping.getDimRHS();
				int orderingDimValue = 1;
				List<AffineExpression> exps = new ArrayList<AffineExpression>();
				if (var!= null && var.getName().startsWith("__Update_")) {
					orderingDimValue = 2;
					//set all the dims after orderingDimOfChecks to 0
					for (int i=0; i < numDims; i++) {
						if (i<orderingDimForChecks) {
							exps.add(mapping.getExpressions().get(i));
						} else {
							exps.add(IntExpressionBuilder.constant(0).toAffine());
						}
					}
					
					AffineFunction newMapping = PolyhedralIRUserFactory.eINSTANCE
							.createAffineFunction(mapping.getParams(), 
												  mapping.getIndices(), 
												  exps);
					stMap.setMapping(newMapping);
					
				} else if (var!= null && var.getName().startsWith("__Acquire_")) {
					orderingDimValue = 0;
					//set all the dims after orderingDimOfChecks to 0
					for (int i=0; i < numDims; i++) {
						if (i<orderingDimForChecks) {
							exps.add(mapping.getExpressions().get(i));
						} else {
							exps.add(IntExpressionBuilder.constant(0).toAffine());
						}
					}
					AffineFunction newMapping = PolyhedralIRUserFactory.eINSTANCE
							.createAffineFunction(mapping.getParams(), 
												  mapping.getIndices(), 
												  exps);
					stMap.setMapping(newMapping);
				}
				
				AffineFunction newMapping = addOrderingDimension(
						orderingDimForChecks, orderingDimValue,
						stMap.getMapping());
				stMap.setMapping(newMapping);
				stMap.setInverseOfMapping(newMapping.inverseInContext(
					var == null ? system.getUseEquation(varName).getExtensionDomain() 
							: system.getVariableDeclaration(varName).getDomain(), null));
			}
			/*
			 * add ordering dimension to memory allocation and copy of use equations
			 */
			for (UseEquationOptimization ueOpt : tm.getUseEquationOptimizations()) {
				AffineFunction allocMap = addOrderingDimension(orderingDimForChecks, 
						1, ueOpt.getMemoryAllocationSpaceTimeMap());
				ueOpt.setMemoryAllocationSpaceTimeMap(allocMap);
				AffineFunction copyMap = addOrderingDimension(orderingDimForChecks, 
						1, ueOpt.getValueCopySpaceTimeMap());
				ueOpt.setValueCopySpaceTimeMap(copyMap);
				AffineFunction freeMap = addOrderingDimension(orderingDimForChecks, 
						1, ueOpt.getMemoryFreeSpaceTimeMap());
				ueOpt.setMemoryFreeSpaceTimeMap(freeMap);
			}
			
			int nOrdDims = stlevel.getNumberOfOrderingDimensions();
			List<Integer> orderingDims = stlevel.getOrderingDimensions();

			// Update ordering dimensions and add the new ordering dimension to the list
			for (int d =0; d<nOrdDims; d++) {
				// Since ordering dimensions must be >= nParallaelDims, we can 
				// simply increment all current ordering dims by 1
				if (orderingDims.get(d)>=orderingDimForChecks) {					
					orderingDims.set(d, orderingDims.get(d)+1);
				}
			}
			orderingDims.add(orderingDimForChecks);
			
			//this (potentially) reduces control overhead of generated code
			System.out.println("Normalizing the preprocessed program..");
			Normalize.normalize(system);
			
			
			System.out.println("After preprocessing");
			System.out.println(AShow.toSimplifiedString(system));
			System.out.println("Targetmapping");
			System.out.println(stlevel.getSpaceTimeMaps());
			System.out.println("Memorymapping");
			System.out.println(tm.getMemoryMaps());
			
			
		}
		
		
		
		//find scheduled reduction bodies
		//TODO: currently we only handle reductions in standard equations
		//TODO: This needs to be extended to handle reduction bodies inside the subsystems
		List<StandardEquation> scheduledReductionBodies = findReductionsWithScheduledBody();
		//serialize the reduction
		for (StandardEquation eq : scheduledReductionBodies) {
			ReduceExpression re_copy = EcoreUtil.copy((ReduceExpression)eq.getExpression());
			String serVar = SerializeReduction.transform((ReduceExpression)eq.getExpression(), 
					stlevel.getSpaceTimeMaps().get(eq.getVariable().getName()).getMapping());
			postProcessingForSerializeReduction(eq.getVariable(), system.getVariableDeclaration(serVar), re_copy);
		}
		
		
		
		EList<SpaceTimeMap> varSpacetimes = new BasicEList<SpaceTimeMap>();
		EList<SpaceTimeMap> useSpacetimes = new BasicEList<SpaceTimeMap>();
		//get the space time map for variableDeclaration and use equation separately
		for(SpaceTimeMap stmap: stlevel.getSpaceTimeMaps().values()){
			if(system.getVariableDeclaration(stmap.getLabel())!=null){
				varSpacetimes.add(stmap);
			}else if(system.getUseEquation(stmap.getLabel())!= null){
				useSpacetimes.add(stmap);
			}else{
				throw new RuntimeException(stmap.getLabel() + " is not a variable or useEquation in the system!");
			}
		}
		
		//CoB to reflect STmap
		//reflect the STmap for the standardEquations first
		for(SpaceTimeMap stmap: varSpacetimes){
			VariableDeclaration var = system.getVariableDeclaration(stmap.getLabel());
			if( COBignoreList.contains(var)) continue;
			if(subSystemOutputVars.contains(var)) continue;
			if (scheduledReductionBodies.contains(var)) continue;
			//skip inputs
			if (var.isInput()) continue;
			if(!stmap.getMapping().isIdentity()){
				ChangeOfBasis.CoB(system, stmap.getLabel(), stmap.getMapping(), true);
			}
		}

		//reflect the STmap for the useEquations 
		for(SpaceTimeMap stmap: useSpacetimes){
			preProcessingForUseEquation(stmap.getLabel());
			if(!stmap.getMapping().isIdentity()){
				ChangeOfBasis.CoB(system, stmap.getLabel(), stmap.getMapping(), true);
			}
		}
		
//		for(SpaceTimeMap stmap : stlevel.getSpaceTimeMaps().values()){
//			//check whether the stmap is specified for a variable or use equation
//			if(system.getVariableDeclaration(stmap.getLabel()) != null){
//				VariableDeclaration var = system.getVariableDeclaration(stmap.getLabel());
//				//skip variables in ignore list, the output variables of the use equation or the variable for a reduce expression
//				if (COBignoreList.contains(var)) continue;
//				if(subSystemOutputVars.contains(var)) continue;
//				if (scheduledReductionBodies.contains(var)) continue;
//				//skip inputs
//				if (var.isInput()) continue;
//				if(!stmap.getMapping().isIdentity()){
//					ChangeOfBasis.CoB(system, stmap.getLabel(), stmap.getMapping(), true);
//				}
//			}
//		}
	
		//this (potentially) reduces control overhead of generated code
		Normalize.normalize(system);
		
		/*if (options.isHybridSchedule) {
			System.out.println("generationPreProcessing");	
			
			GenerateSyncronizationVariables.generateSyncronizationVariables(system, options.dimToAddChecks);
			
			System.out.println("ASHOW:\n" + AShow.toString(program));
			//Check program
			ValidatorOutput output = UniquenessAndCompletenessCheck.validate(system);
			System.out.println(output.toString(org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY.MAX));
			
			//this (potentially) reduces control overhead of generated code
			System.out.println("Normalizing the preprocessed program..");
			Normalize.normalize(system);
			
			
			System.out.println("After preprocessing");
			System.out.println(AShow.toSimplifiedString(system));
			System.out.println("Targetmapping");
			System.out.println(stlevel.getSpaceTimeMaps());
			System.out.println("Memorymapping");
			System.out.println(tm.getMemoryMaps());
		}*/
	}

	/*
	 * An ordering dimension is added just after processor dimensions
	 * and the value of the ordering dimension is set to 1. For acquire and 
	 * update, the value of ordering dimension will be 0 and 2 respectively.
	 */
	private AffineFunction addOrderingDimension(int orderingDimforCheck,
			int orderingDimValue, AffineFunction mapping) {
		List<AffineExpression> exprsWithOrderingDim = new ArrayList<AffineExpression> ();
		List<AffineExpression> exprs = mapping.getExpressions();

		//TODO why not simply insert the new exp at nParallelDims?
		for (int i=0; i<=exprs.size(); i++) {
			if (i<orderingDimforCheck) {
				exprsWithOrderingDim.add(exprs.get(i));
			} else if (i == orderingDimforCheck) {
				exprsWithOrderingDim.add(IntExpressionBuilder.constant(orderingDimValue).toAffine());
			} else {
				exprsWithOrderingDim.add(exprs.get(i-1));
			}
		}
		AffineFunction newMapping = PolyhedralIRUserFactory.eINSTANCE
				.createAffineFunction(mapping.getParams(), 
									  mapping.getIndices(), 
									  exprsWithOrderingDim);
		return newMapping;
	}
	
	protected void addSubsystemCalls(CodeUnit cu){
		//get the list of used subsystems
		List<AffineSystem> subsystems = SystemCallAnalysis.getUsedSystems(system);
		if(subsystems.contains(system)){
			subsystems.remove(system);
		}
		
		//create function calls for each subsystem
		for(AffineSystem subsystem: subsystems){
			FunctionSignature systemcall = PolyIRCGUserFactory.INSTANCE.createFunctionSignature(subsystem.getName(), "void");
			//get the target mapping of the subsystem
			TargetMapping subsystem_map = subsystem.getTargetMapping();
			clearUnusedMemorySpace(subsystem_map);
			CodeUnit unit = _fact.createCodeUnit(subsystem);
			//reflect TargetMapping for the input and ouput variables
			for(MemorySpace ms : subsystem_map.getMemorySpaces()){
				CVariable v = _fact.createCVariable(ms.getName(), ms.getType(), 
						SubSystemCodeGenUtilityForC.getSpaceDomainforSystemCallDeclaration(ms, subsystem_map), options.flattenArrays, false);
				unit.getVariables().add(v);
			}
			
			//create function parameter for system parameters
			for(Variable var: subsystem.getParameters().getParams()){
				if (var.toString().matches("ts\\d+")) {
					systemcall.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(var.toString(), "int"));
				} else {
					systemcall.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(var.toString(), "long"));
				}
			}
			
			//Register input variables
			for (VariableDeclaration var : subsystem.getInputs()) {
				AbstractVariable v = unit.findVariable(subsystem_map.getMemoryMaps().get(var).getSpace().getName());
				systemcall.getParameters().add(v);
			}
			//register output variables
			for (VariableDeclaration var : subsystem.getOutputs()) {
				AbstractVariable v = unit.findVariable(subsystem_map.getMemoryMaps().get(var).getSpace().getName());
				systemcall.getParameters().add(v);
			}
			
			cu.getSubsystemFunctions().add(systemcall);
		}
	}
	
	@Override
	protected List<CodeUnit> getCodeUnits() {
		clearUnusedMemorySpace(system.getTargetMapping());
		
		List<CodeUnit> res = new Vector<CodeUnit>(1);
		CodeUnit unit = _fact.createCodeUnit(system);
		
		//reflect TargetMapping for the input and ouput variables
		for(MemorySpace ms : system.getTargetMapping().getMemorySpaces()){
			CVariable v = _fact.createCVariable(ms,  options.flattenArrays, false);
			unit.getVariables().add(v);
		}
		
		system.accept(getStatementVisitor(unit));
		
		addSubsystemCalls(unit);
		
		if(options instanceof TiledCodeGenOptions){
			if(((TiledCodeGenOptions)options).buffering){
				PreprocessForTemporaryBuffer.process(unit, system.getTargetMapping(), (TiledCodeGenOptions)options);
			}else{
				if(((TiledCodeGenOptions)options).optimized && ((TiledCodeGenOptions)options).vec){
					Function main = unit.getFunctions().get(0);
					//FIXME hack to get SIMD working
					SIMDFunction f = PolyIRCGSIMDUserFactory.INSTANCE.createSIMDFunction(main.getName(), main.getReturnType());
					f.getBodies().addAll(main.getBodies());
					f.getInputs().addAll(main.getInputs());
					f.getOutputs().addAll(main.getOutputs());
					f.getLocals().addAll(main.getLocals());
					f.getSpecialLocals().addAll(main.getSpecialLocals());
					f.setEntryPoint(true);
					
					
					unit.getFunctions().remove(0);
					unit.getFunctions().add(0,f);
					
					SIMDPreprocessForFullTile.vectorization(unit, system.getTargetMapping(), (TiledCodeGenOptions)options);
				}
			}
			
		}
		
		res.add(unit);
	
		return res;
	}
	
	protected StatementVisitorForScheduledC getStatementVisitor(CodeUnit unit) {
		return new StatementVisitorForScheduledC(unit, system.getTargetMapping(), options);
	}
}
