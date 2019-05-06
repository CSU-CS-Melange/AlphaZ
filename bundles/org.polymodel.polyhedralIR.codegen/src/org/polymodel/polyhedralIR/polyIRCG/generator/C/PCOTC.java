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
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.transformation.reduction.SerializeReduction;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;

/*
 * Generated Polyhedral Cache oblivious tiled code.
 * 
 * 1. Find legal tiling hyper-planes
 * 2. Do a CoB
 * 3. Find Memory allocation
 * 4. Generate code
 */
public class PCOTC extends ScheduledC {
	
	/**
	 * Static method for public access to PCOTC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		systemCodeGenenration(system, options, outDir);
	}
	
//	/**
//	 * Static method for public access to PCOTC code generator for the whole program
//	 * It generates one file for each system
//	 * @param program
//	 * @param options
//	 * @param outDir
//	 */
	/*
	public static void generate(Program program, CodeGenOptions options, String outDir){
		for(AffineSystem sys: program.getSystems()){
			systemCodeGenenration(sys, options, outDir);
		}
	}*/
	
	/**
	 * Static method for public access to PCOTC code generator for one system
	 * It generates one file for each system
	 * @param program
	 * @param options
	 * @param outDir
	 */
	public static void systemCodeGenenration(AffineSystem system, CodeGenOptions options, String outDir){
		PCOTC pcotC = new PCOTC(system, options);
		pcotC.generate(options, outDir);
	}
	
	protected PCOTC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.PCOT_C;
	}
	
	@Override
	protected void initialize() {
		setTargetMapping();
		
		super.initialize();
		
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

	/**
	 * To be implemented by Nirmal to update 
	 * 1. space time maps
	 * 2. memory maps
	 * 3. tiling config (which dimensions to be tiled)
	 */
	private void setTargetMapping() {
		//TODO
		
	}

	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();
	}
	
	/*@Override
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
		
		res.add(unit);
	
		return res;
	}*/
	
	protected StatementVisitorForPCOTC getStatementVisitor(CodeUnit unit) {
		return new StatementVisitorForPCOTC(unit, system.getTargetMapping(), options);
	}

}
