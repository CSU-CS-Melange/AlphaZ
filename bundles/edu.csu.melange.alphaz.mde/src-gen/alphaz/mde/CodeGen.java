package alphaz.mde;

/*PROTECTED REGION ID(CodeGen_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.util.PolymodelRegexParser;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.PCOT.PCOTC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile.MPICTestingMakefileModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile.SIMDMakefileModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile.SIMDTestingMakefileModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile.TestingMakefileModule;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
/*PROTECTED REGION END*/
/**
Code generators from alphabets to other languages.
**/
public class CodeGen {

	/**
	Generates scheduledC code for a system using the TargetMapping specified for the system.
Detailed options can be given through optional argument.
	**/
	public static void generateScheduledCode(  Program program , String system , CodeGenOptions options , String outDir , Boolean genVerifier ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateScheduledCode) ENABLED START*/
		if(genVerifier){
			generateVerificationCode(program, system, outDir);
			//generateWriteC(program , system , options , outDir+"-verifier");
			// temporary solution need to add an option Xtend name generator
			File afile = new File(outDir+"/" + system + ".c");
			afile.renameTo(new File(outDir+"/" + system + "_verify.c"));
		}
//		//generate the code for the system and all the used system
//		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(system));
//		for(AffineSystem sys : systems){
//			ScheduledC.generate(sys, options, outDir);
//		}
		ScheduledC.generate(program.getSystem(system), options, outDir);
		
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateScheduledCode( Program program, String system, String outDir) {
		generateScheduledCode( program, system, getDefaultCodeGenOptions(program, system) , outDir, false );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateScheduledCode( Program program, String system, String outDir, Boolean genVerifier) {
		generateScheduledCode( program, system, getDefaultCodeGenOptions(program, system) , outDir, genVerifier);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateScheduledCode( Program program, String system) {
		generateScheduledCode( program, system, getDefaultCodeGenOptions(program, system) , "./" , false );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateScheduledCode( Program program, String system, Boolean genVerifier) {
		generateScheduledCode( program, system, getDefaultCodeGenOptions(program, system) , "./" , genVerifier);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateScheduledCode( Program program, String system, CodeGenOptions options, String outDir) {
		generateScheduledCode( program, system, options, outDir, false );
	}
	


	/**
	Generates WriteC code for a system.
TargetMapping is ignored except for MemoryMapping given for output variables.
Detailed options can be given through optional argument.
	**/
	public static void generateWriteC(  Program program , String system , CodeGenOptions options , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateWriteC) ENABLED START*/
		WriteC.generate(program.getSystem(system), options, outDir);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateWriteC( Program program, String system, String outDir) {
		generateWriteC( program, system, CodeGenOptions.writeCDefault() , outDir);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateWriteC( Program program, String system) {
		generateWriteC( program, system, CodeGenOptions.writeCDefault() , "./" );
	}
	


	/**
	Generates a wrapper code for the given sytem using the specified TargetMapping.
	**/
	public static void generateWrapper(  Program program , String system , CodeGenOptions options , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateWrapper) ENABLED START*/
		WrapperGeneratorForC.generate(program.getSystem(system), options, outDir);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateWrapper( Program program, String system, String outDir) {
		generateWrapper( program, system, getDefaultCodeGenOptions(program, system) , outDir);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateWrapper( Program program, String system) {
		generateWrapper( program, system, getDefaultCodeGenOptions(program, system) , "./" );
	}
	
	/**
	Generates code for verifying generated program. The code is generated using demand-driven code generator (WriteC).
	**/
	public static void generateVerificationCode(  Program program , String systemName , String outDir ) {
		generateVerificationCode(program, systemName, CodeGenOptions.writeCDefault(), outDir);
	}

	/**
	Generates code for verifying generated program. The code is generated using demand-driven code generator (WriteC).
	**/
	public static void generateVerificationCode(  Program program , String systemName , CodeGenOptions options, String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateVerificationCode) ENABLED START*/
		options.funcPostfix += "_verify";
		String verifySystemName = systemName + "_verify";
		AffineSystem system = program.getSystem(systemName);
		system.setName(verifySystemName);
		generateWriteC(program, verifySystemName, options, outDir);
		system.setName(systemName);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateVerificationCode( Program program, String system) {
		generateVerificationCode( program, system, "./" );
	}
	


	/**
	Generates Makefile to compile generated code + wrapper.
	**/
	public static void generateMakefile(  Program program , String system , CodeGenOptions CodeGenOptions , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateMakefile) ENABLED START*/
		try {
			boolean tiledWavefront = false;
			for (TilingSpecification ts : program.getSystem(system).getTargetMapping().getSpaceTimeLevels().get(0).getTilingSpecifications()) {
				for(SubTilingSpecification subtile : ts.getSubTiles()){
					if (subtile.getTilingType() == TILING_TYPE.OMPWAVEFRONT) {
						tiledWavefront = true;
						break;
						//PolyIRCodeGen.generateOMPMakefile(program.getSystem(system), outDir);
						//PolyIRCodeGen.generateMakefile(new OpenMPMakefileModule(), program.getSystem(system), true, outDir);
						//return;
					}
				}
				if(tiledWavefront)	break;
			}
			//check vectorization
			boolean tiledVec = false;
			if(CodeGenOptions != null && CodeGenOptions instanceof TiledCodeGenOptions){
				if(((TiledCodeGenOptions)CodeGenOptions).multiPassWavefront){
					tiledWavefront = true;
				}
				if(((TiledCodeGenOptions)CodeGenOptions).vec){
					tiledVec = true;
				}
			}
			
			if(tiledVec && tiledWavefront){
				PolyIRCodeGen.generateOMPMakefile(new SIMDMakefileModule(), program.getSystem(system), outDir);
				return;
			}else if(tiledVec && !tiledWavefront){
				PolyIRCodeGen.generateMakefile(new SIMDMakefileModule(), program.getSystem(system), outDir);
				return;
			}else if(!tiledVec && tiledWavefront){
				PolyIRCodeGen.generateOMPMakefile(program.getSystem(system), outDir);
				return;
			}
			
			if(program.getSystem(system).getTargetMapping().getSpaceTimeLevels().get(0).getParallelizationSpecifications().size() > 0){
				PolyIRCodeGen.generateOMPMakefile(program.getSystem(system), outDir);
				//PolyIRCodeGen.generateMakefile(new OpenMPMakefileModule(), program.getSystem(system), true, outDir);
				return;
			}
			
			PolyIRCodeGen.generateMakefile(program.getSystem(system), outDir);
		} catch (Exception e) {
			PolyIRCodeGen.generateMakefile(program.getSystem(system), outDir);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateMakefile( Program program, String system) {
		generateMakefile( program, system, null , "./" );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateMakefile( Program program, String system, String outDir) {
		generateMakefile( program, system, null , outDir);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateMakefile( Program program, String system, CodeGenOptions CodeGenOptions) {
		generateMakefile( program, system, CodeGenOptions, "./" );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateMakefileInternal(  Program program , String system , CodeGenOptions CodeGenOptions , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateMakefileInternal) ENABLED START*/
		for (TilingSpecification ts : program.getSystem(system).getTargetMapping().getSpaceTimeLevels().get(0).getTilingSpecifications()) {
			for(SubTilingSpecification subtile : ts.getSubTiles()){
				if (subtile.getTilingType() == TILING_TYPE.MPIC) {
					PolyIRCodeGen.generateMakefile(new MPICTestingMakefileModule(), program.getSystem(system), false, outDir);
					
					return;
				}
			}
		}
		if(CodeGenOptions != null && CodeGenOptions instanceof TiledCodeGenOptions && ((TiledCodeGenOptions)CodeGenOptions).vec){
			PolyIRCodeGen.generateMakefile(new SIMDTestingMakefileModule(), program.getSystem(system), false, outDir);
			return;
		}
		PolyIRCodeGen.generateMakefile(new TestingMakefileModule(), program.getSystem(system), false, outDir);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateMakefileInternal( Program program, String system, String outDir) {
		generateMakefileInternal( program, system, null , outDir);
	}
	


	/**
	Creates instance of CodeGenOptions for WriteC using default values.
	**/
	public static CodeGenOptions createCGOptionForWriteC( ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createCGOptionForWriteC) ENABLED START*/
		return CodeGenOptions.writeCDefault();
		/*PROTECTED REGION END*/
	}


	/**
	Creates instance of CodeGenOptions for ScheduledC using default values.
	**/
	public static CodeGenOptions createCGOptionForScheduledC( ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createCGOptionForScheduledC) ENABLED START*/
		return CodeGenOptions.scheduledCDefault();
		/*PROTECTED REGION END*/
	}


	/**
	Creates instance of CodeGenOptions for Hybrid ScheduledC for GPU using dimToInsertChecks to insert checks.
	**/
	public static CodeGenOptions createCGOptionForHybridScheduledCGPU(  int dimToInsertChecks ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createCGOptionForHybridScheduledCGPU) ENABLED START*/
		return CodeGenOptions.scheduledCHybridGPUDefault(dimToInsertChecks);
		/*PROTECTED REGION END*/
	}


	/**
	Creates instance of CodeGenOptions for Hybrid ScheduledC using dimToInsertChecks to insert checks.
	**/
	public static CodeGenOptions createCGOptionForHybridScheduledC(  int dimToInsertChecks ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createCGOptionForHybridScheduledC) ENABLED START*/
		return CodeGenOptions.scheduledCHybridDefault(dimToInsertChecks);
		/*PROTECTED REGION END*/
	}


	/**
	Specifies true/false (1/0) values for if the multi-dimensional arrays allocated should be flattened to 1D or not.
	**/
	public static void setCGOptionFlattenArrays(  CodeGenOptions CGoptions , int flatten ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setCGOptionFlattenArrays) ENABLED START*/
		CGoptions.flattenArrays = flatten != 0;
		/*PROTECTED REGION END*/
	}


	/**
	Options to skip Normalize before generating code with the ScheduleC code generator.
This is an option added as an workaround to scalability problems with Normalize, and will be removed in the future.
Not normalizing may lead to significantly inefficient code.
	**/
	public static void setCGOptionDisableNormalize_depreciated(  CodeGenOptions options ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setCGOptionDisableNormalize_depreciated) ENABLED START*/
		//TODO
		throw new UnsupportedOperationException();
		/*PROTECTED REGION END*/
	}


	/**
	Creates instance of CodeGenOptions for ScheduledC using default values for tiling.
	**/
	public static TiledCodeGenOptions createTiledCGOptionForScheduledC( ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createTiledCGOptionForScheduledC) ENABLED START*/
		return TiledCodeGenOptions.scheduledCDefault();
		/*PROTECTED REGION END*/
	}


	/**
	Creates instance of CodeGenOptions for PCOTC using default values for tiling.
	**/
	public static TiledCodeGenOptions createCGOptionsForPCOT( ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.createCGOptionsForPCOT) ENABLED START*/
		return TiledCodeGenOptions.pcotCDefault();
		/*PROTECTED REGION END*/
	}


	/**
	Applies optimizations to the tiled code generated using full-tile splitting of a selected statement group.
Statement group is selected with heuristics that may not be accurate.
	**/
	public static void setTiledCGOptionOptimize(  TiledCodeGenOptions options , int optimize ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setTiledCGOptionOptimize) ENABLED START*/
		options.optimized = optimize != 0;
		/*PROTECTED REGION END*/
	}


	/**
	Returns CodeGenOptions appropriate for the given system.
	**/
	public static CodeGenOptions getDefaultCodeGenOptions(  Program prog , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.getDefaultCodeGenOptions) ENABLED START*/
		if (prog.getSystem(system).getTargetMapping().isTiled()) {
			return TiledCodeGenOptions.scheduledCDefault();
		} else {
			return CodeGenOptions.scheduledCDefault();
		}
		/*PROTECTED REGION END*/
	}


	/**
	code generator for a scan subsystem ( a subsystem that contains only scan computations)
	**/
	public static void generateScanC(  Program program , String systemName , CodeGenOptions options , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateScanC) ENABLED START*/
		//TODO
		AffineSystem system = program.getSystem(systemName);
		//List<ScanInformations> gen_infos = ScanDetection.scanDetection(system);
		//return ScanC.generate(systemName, options, outDir, gen_infos.get(0));
		throw new UnsupportedOperationException();
		/*PROTECTED REGION END*/
	}


	/**
	CPU code generator for Polyhedral Cache Oblivious Tiling
	**/
	public static void generatePCOTCode(  Program program , String system , TiledCodeGenOptions options , String outDir , Boolean genVerifier ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generatePCOTCode) ENABLED START*/
		PCOTC.generate(program.getSystem(system), options, outDir);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generatePCOTCode( Program program, String system, String outDir) {
		generatePCOTCode( program, system, createCGOptionsForPCOT() , outDir, false );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generatePCOTCode( Program program, String system, String outDir, Boolean genVerifier) {
		generatePCOTCode( program, system, createCGOptionsForPCOT() , outDir, genVerifier);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generatePCOTCode( Program program, String system) {
		generatePCOTCode( program, system, createCGOptionsForPCOT() , "./" , false );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generatePCOTCode( Program program, String system, Boolean genVerifier) {
		generatePCOTCode( program, system, createCGOptionsForPCOT() , "./" , genVerifier);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generatePCOTCode( Program program, String system, TiledCodeGenOptions options, String outDir) {
		generatePCOTCode( program, system, options, outDir, false );
	}
	


	/**
	generate code using the flattened multi-pass tiling and parallelization strategy
	**/
	public static void generateFMPPCode(  Program program , String systemName , String TilingType , TiledCodeGenOptions CodeGenOptions , String outDir ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.generateFMPPCode) ENABLED START*/
		if(TilingType.equals("sequential")){
			CodeGenOptions.multiPassSequential = true;
			CodeGenOptions.multiPassWavefront = false;
		}else if(TilingType.equals("omp")){
			CodeGenOptions.multiPassWavefront = true;
			CodeGenOptions.multiPassSequential = false;
		}else{
			throw new RuntimeException("Unrecognized Tiling Type! Tiling type has to be either sequential or omp.");
		}
		ScheduledC.generate(program.getSystem(systemName), CodeGenOptions, outDir);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void generateFMPPCode( Program program, String systemName, String TilingType, String outDir) {
		generateFMPPCode( program, systemName, TilingType, TiledCodeGenOptions.scheduledCDefault() , outDir);
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateFMPPCode( Program program, String systemName, String TilingType) {
		generateFMPPCode( program, systemName, TilingType, TiledCodeGenOptions.scheduledCDefault() , "./" );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void generateFMPPCode( Program program, String systemName) {
		generateFMPPCode( program, systemName, "sequential" , TiledCodeGenOptions.scheduledCDefault() , "./" );
	}
	


	/**
	Turn on the vectorization option for TiledC. Right now it is only open for DTiler -- Where only 1 level of tiling is applied and all dimensions are tiled.
Four types of vectorization strategy is supported: naive, opt nobuff -- optimized vectorization strategy without temporary buffering, all aligned -- optimized vectorization strategy with temporary buffering and all vectors aligned, mostly aligned -- optimized vectorization strategy with temporary buffering and mostly aligned strategy. The default strategy is set to be "opt nobuff".
Register block size only corresponds to the data dimensions of stencil computations, the default register block size is set to unroll the innermost vectorized dimension 4 times. 
	**/
	public static void setVecOptionForTiledC(  TiledCodeGenOptions options , String vecSet , String vecStrategy , String registerBlockSize ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setVecOptionForTiledC) ENABLED START*/
		//parse the vectorization strategy first
		options.vec = true;
		options.optimized = true;
		options.vectorizable = true;
		options.simdSet = vecSet;
		options.unrollAndJam = true;
		if(vecStrategy.contentEquals("naive")){
			options.strategy = 1;
			options.buffering = false;
			options.pointer = false;
			options.rotate = false;
		}else if(vecStrategy.contentEquals("opt nobuff")){
			options.strategy = 3;
			options.buffering = false;
			options.pointer = true;
			options.rotate = true;
		}else if(vecStrategy.contentEquals("all aligned")){
			options.strategy = 2;
			options.buffering = true;
			options.pointer = true;
			options.rotate = true;
		}else if(vecStrategy.contentEquals("mostly aligned")){
			options.strategy = 3;
			options.buffering = true;
			options.pointer = true;
			options.rotate = true;
		}else{
			throw new RuntimeException("Unrecognized vectorization strategy! Only strategy naive, opt nobuff, all algined and mostly aligned are supported.");
		}
		//parse the register block size 
		//this has to be checked later before code generation
		if(!registerBlockSize.contentEquals("")){
			String[] factors = registerBlockSize.split(",");
			int[] unrollFactors = new int[factors.length];
			for(int i = 0; i < factors.length; i++){
				unrollFactors[i] = Integer.parseInt(factors[i]);
			}
			options.unrollFactors = unrollFactors;
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setVecOptionForTiledC( TiledCodeGenOptions options) {
		setVecOptionForTiledC( options, "AVX" , "opt nobuff" , "" );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setVecOptionForTiledC( TiledCodeGenOptions options, String vecStrategy) {
		setVecOptionForTiledC( options, "AVX" , vecStrategy, "" );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void setVecOptionForTiledC( TiledCodeGenOptions options, String vecStrategy, String registerBlockSize) {
		setVecOptionForTiledC( options, "AVX" , vecStrategy, registerBlockSize);
	}
	


	/**
	Set the variables for vectorization. All the variable statement must occur under the same innermost loop nest. 
	**/
	public static void setVecVarsForTiledC(  Program program , String systemName , TiledCodeGenOptions options , String vars ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setVecVarsForTiledC) ENABLED START*/
		if(options.vecVar == null){
			options.vecVar = new LinkedList<String>();
		}
		
		String[] vecVars = Utility.stringListToArray(vars);
		for(int i = 0; i < vecVars.length; i++){
			options.vecVar.add(vecVars[i]);
		}
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void setVecVarForTiledC(  Program program , String systemName , TiledCodeGenOptions options , String var , String domain ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.setVecVarForTiledC) ENABLED START*/
		if(options.var_dom_map == null){
			options.var_dom_map = new HashMap<String, Domain>();
		}
		if(options.vecVar == null){
			options.vecVar = new LinkedList<String>();
		}
		
		if(domain.contentEquals("")){
			options.vecVar.add(var);
		}
		Domain dom = PolyhedralIRUtility.parseDomain(program.getSystem(systemName).getParameters(), domain);
		options.var_dom_map.put(var, dom);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void setVecVarForTiledC( Program program, String systemName, TiledCodeGenOptions options, String var) {
		setVecVarForTiledC( program, systemName, options, var, "" );
	}
	


	/**
	Generates code with recursion depth as an input parameter.
	**/
	public static TiledCodeGenOptions addRecursionDepthForPCOT(  TiledCodeGenOptions options ) {
		/*PROTECTED REGION ID(alphaz.mde.codegen.addRecursionDepthForPCOT) ENABLED START*/
		options.recursion_depth = true;
		return options;
		/*PROTECTED REGION END*/
	}

}//end CodeGen
