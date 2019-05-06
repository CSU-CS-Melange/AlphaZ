package org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGeneratorTemplateForC;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;
import org.polymodel.polyhedralIR.util.WhileSystemUtility;


/**
 * Generates Wrapper code for an AffineSystem.
 * Allocates memory for input and output variables, and generates code for setting inputs and printing outputs.
 * It also produces code to check against another implementation of the same system for verification.
 * SpaceTimeMap given for any variable is ignored in this code generator.
 * 
 * @author yuki
 *
 */
public class WrapperGeneratorForC extends CodeGeneratorTemplateForC {
	
	protected final AffineSystem system;
	protected final CodeGenOptions options;
	
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		WrapperGeneratorForC wrapper = new WrapperGeneratorForC(system, options);
		wrapper.generate(options, outDir);
	}

	/**
	 * generate wrapper for a program generates a wrapper for each system in the program for now
	 * @param program
	 * @param options
	 * @param outDir
	 */
	public static void generate(Program program, CodeGenOptions options, String outDir){
		for(AffineSystem sys : program.getSystems()){
			generate(sys, options, outDir);
		}
	}
	
	protected WrapperGeneratorForC(AffineSystem system, CodeGenOptions options) {
		super(system.getContainerProgram());
		//Need to get it from program, since program is copied in the super class constructor
		this.system = program.getSystem(system.getName());
		this.options = options;
	}
	
	@Override
	protected void initialize() {
		if (system.getWhileInfo() != null) {
			for (VariableDeclaration var : system.getOutputs()) {
				/*
				 * Remove the time dimension(s) from the output variables 
				 */
				WhileSystemUtility.removeTimeDimensions(var, system.getWhileInfo().getTimeDomain());
			}
			
			for (Entry<VariableDeclaration, MemoryMap> e : system.getTargetMapping().getMemoryMaps()) {
				if (e.getKey().isOutput()) {
					removeTimeDimensionsFromMemoryMap(e.getValue());
				}
			}
		}
		
		super.initialize();
	
		if(system.getTargetMapping().isTiled() || ((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassSequential) ||
				((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassWavefront)){
			addTileSizesAsParameters(system, (TiledCodeGenOptions)options);
		}
		
		if ((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).pcot) {
			SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
			boolean isParallel = false;
			for(TilingSpecification tile: stlevel.getTilingSpecifications()){
				int levels = tile.getLevels();
				for(int i = 1; i <= levels; i++){
					SubTilingSpecification subtile = tile.getSubTile(i);
					if(subtile == null){
						throw new RuntimeException("subtile at level " + i +" is not specified for tile band with prefix " + 
								tile.getOrderingPrefix().toString() + " [" + tile.getStartDim() + "," + tile.getEndDim() + "].");
					}
					isParallel |= subtile.getTilingType().compareTo(TILING_TYPE.OMPWAVEFRONT) == 0;
				}
			}
			
			if (isParallel) {
				List<String> params = new ArrayList<String>();
				params.add("rec_depth");
				ExtendParameterDomain.addParameters(system, params);
			}
		}
		
		//Set SpaceTimeMap for all input and output variables tobe identity, since it should be ignored in the Wrapper generation
		TargetMapping tm = system.getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		for (VariableDeclaration var : system.getInputs()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
		}
		for (VariableDeclaration var : system.getOutputs()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
		}
		for (VariableDeclaration var : system.getLocals()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
		}
	}

	private void removeTimeDimensionsFromMemoryMap(MemoryMap mm) {
		AffineFunction af = mm.getMapping();
		int numTimeDims = system.getWhileInfo().getTimeDomain().getNIndices();
		List<Variable> indices = af.getIndices();
		List<AffineExpression> exprs = af.getExpressions();
		
		for (int t = 0; t < numTimeDims; t++) {
			indices.remove(0);
			exprs.remove(0);
		}
		
		AffineFunction newAf = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(af.getParams(), indices, exprs);
		mm.setMapping(newAf);		
	}

	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.WRAPPER_C;
	}

	@Override
	protected List<CodeUnit> getCodeUnits() {
		clearUnusedMemorySpace(system.getTargetMapping());
		
		List<CodeUnit> res = new Vector<CodeUnit>(1);
		
		CodeUnit cu = _fact.createCodeUnit(system);
		
		//Create main function
		Function function = _fact.createFunction("main", "int");
		function.setEntryPoint(true);
		
		//Create variables based on TargetMapping
		TargetMapping tm = system.getTargetMapping();
		for(MemorySpace ms : tm.getMemorySpaces()){
			CodeGenVariable v = _fact.createCVariable(ms, options.flattenArrays, false);
			cu.getVariables().add(v);
		}
		
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		//All Inputs/Outputs of the target system becomes Inputs/Outputs
		for (VariableDeclaration var : system.getInputs()) {
			function.getInputs().add(cu.findVariable(var.getName()));
			CLoop initLoop = _fact.createInputInitialization( system.getParameters(), var, stlevel.getAccessFunction(var));
			initLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(cu, 0), var.getDomain().copy(), "init_"+var.getName()));
			function.getBodies().add(initLoop);
		}
		
		for (VariableDeclaration var : system.getOutputs()) {
			//function.getOutputs().add(cu.findVariable(system.getTargetMapping().getMemorySpace(var).getName()));
			function.getOutputs().add(cu.findVariable(tm.getMemoryMaps().get(var).getSpace().getName()));
			CLoop printLoop = _fact.createOutputPrinting( system.getParameters(), var, stlevel.getAccessFunction(var));
			CLoop verifyLoop = _fact.createOutputVerification( system.getParameters(), var, stlevel.getAccessFunction(var));
			
			printLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(cu, 0), var.getDomain().copy(), ""));
			verifyLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(cu, 0), var.getDomain().copy(), ""));
			
			function.getBodies().add(printLoop);
			function.getBodies().add(verifyLoop);
		}
		
		cu.getFunctions().add(function);
		
		res.add(cu);
		
		return res;
	}
	
	/* (non-Javadoc)
	 * @see org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGeneratorTemplateForC#generationPreProcessing()
	 */
	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();
	}
}
