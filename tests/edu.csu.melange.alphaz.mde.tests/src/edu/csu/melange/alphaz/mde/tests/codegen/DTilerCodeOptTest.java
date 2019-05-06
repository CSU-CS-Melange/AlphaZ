package edu.csu.melange.alphaz.mde.tests.codegen;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile.SIMDMakefileModule;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;

public class DTilerCodeOptTest {
	private static String outDirPrefix = "./test-out/DTilerOpt/";
	
	
	@Test
	public void testDTiler() throws IOException{
		//testJacobi1DFloat("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d_float.ab");
		testJacobi1D("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab");
		//testJacobi2D("alphabets/EnerySavingExamples/jacobi_2d/jacobi_2d.ab");
		//testJacobi2D9P("alphabets/EnerySavingExamples/jacobi_2d_9p/jacobi_2d_9p.ab");
		//testHeat2D("alphabets/EnerySavingExamples/heat_2d/heat_2d.ab");
		//testHeat3D("alphabets/EnerySavingExamples/heat_3d/heat_3d.ab");
		//Commenting out since this fails
//		testWave2D("alphabets/EnerySavingExamples/wave_2d/wave_2d.ab");
		//testWave3D("alphabets/EnerySavingExamples/wave_3d/wave_3d.ab");
		//testJacobi3D27p("alphabets/EnerySavingExamples/jacobi_3d_27p/jacobi_3d_27p.ab");
		//testBlur2D("alphabets/EnerySavingExamples/blur_2d/blur_2d.ab");
		//testSeidel2D("alphabets/EnerySavingExamples/Seidel_2D_5p/Seidel_2D_5p.ab");
	}
	
	private void testJacobi1DFloat(String file) throws IOException{
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		//options.flattenArrays = setting.flattenArrays;
		//options.optimized = setting.tilingOptimized;
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
	
		String oriOutDir = outDirPrefix + "/jacobi_1d_float_writeC";
		String systemName = "jacobi_1d"; 
		AffineSystem system = program.getSystem(systemName);
		
		WriteC.generate(system, options, oriOutDir);
		//ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
	}
	
	private void testJacobi1D(String file) throws IOException{
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		//options.flattenArrays = setting.flattenArrays;
		//options.optimized = setting.tilingOptimized;
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
	
		String oriOutDir = outDirPrefix + "/jacobi_1d_dtiler_buffered_aligned_vecj1_seq";
		String systemName = "jacobi_1d"; 
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i->t,t+i)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap);
				
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i->t,t+i)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmap2);
		
	//	tm.getSpaceTimeLevel(0).getOrderingDimensions().add(1);
		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i->t,i)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i->i)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmap2);
	
		//set the tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 1, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 1, TILING_TYPE.SEQUENTIAL);
		dtiler.getSubTiles().add(subtile);

		
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);
		
		system.setTargetMapping(tm);
		
		
		options.vectorizable = true;
		options.unrollAndJam = true;
		options.optimized = true;
		//int[] unrollDims = {1, 2};
		//int[] unrollFactors = {1, 1};
		int[] unrollFactors = {1};
		//options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		options.vec = true;
		//options.dataType = "double";
		options.simdSet = "AVX";
		//options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.buffering = false;
		options.pointer = true;
		//get the stencil domain
//		List<String> vecVars = new LinkedList<String>();
//		vecVars.add("temp_B");
//		options.vecVar = vecVars;
		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i| 1<=i<N-1 && 1<=t<TSTEPS}");
		//AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i->t,t+i)");
		//dom = dom.image(func);
		Map<String, Domain> var_dom_map = new HashMap<String, Domain>();
		var_dom_map.put("temp_B", dom);
		options.var_dom_map = var_dom_map;
		
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		//PolyIRCodeGen.generateOMPMakefile(system, oriOutDir);
		PolyIRCodeGen.generateOMPMakefile(new SIMDMakefileModule(), system, oriOutDir);
	}
	
	private void testJacobi2D9P(String file)throws IOException{
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//set the output directory
		String outDir = outDirPrefix + "/jacobi_2d_9p_dtiler_test";
		String systemName = "jacobi_2d_9p";
		AffineSystem system = program.getSystem(systemName);
				
		//create identity target mapping
		TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		//set memory map
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap_temp_B = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,i,j)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap_temp_B);
		MemoryMap mmapB = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmapB);
		
		//set space time map
		
		SpaceTimeMap stmap_temp_B = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap_temp_B);
								
		SpaceTimeMap stmapB = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmapB);
				
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(3); 
						
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile1 = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile1);
//		SubTilingSpecification subtile2 = TargetMappingUserFactory.createSubTilingSpecification(2, 0, 2, TILING_TYPE.SEQUENTIAL);
//		dtiler.getSubTiles().add(subtile2);
						
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);
						
		system.setTargetMapping(tm);
			
		options.unrollAndJam = true;
		//options.noPeeling = true;
		int[] unrollDims = {1, 2, 3};
		int[] unrollFactors = {1, 2, 3};
		//int[] peelDims = {0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		//options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = true;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.buffering = true;
		options.pointer = true;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j| 1<=i<N-1 && 1<=j<M-1 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)");
//		dom = dom.image(func);
//		options.vecDom = dom;
		
		//WriteC.generate(system, options, outDir);
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testJacobi2D(String file)throws IOException{
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//set the output directory
		String outDir = outDirPrefix + "/jacobi_2d_dtiler_test";
		String systemName = "jacobi_2d";
		AffineSystem system = program.getSystem(systemName);
				
		//create identity target mapping
		TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		//set memory map
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap_temp_B = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,i,j)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap_temp_B);
		MemoryMap mmapB = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmapB);
		
		//set space time map
		
		SpaceTimeMap stmap_temp_B = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap_temp_B);
								
		SpaceTimeMap stmapB = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmapB);
				
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(3); 
						
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile1 = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile1);
//		SubTilingSpecification subtile2 = TargetMappingUserFactory.createSubTilingSpecification(2, 0, 2, TILING_TYPE.SEQUENTIAL);
//		dtiler.getSubTiles().add(subtile2);
						
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);
						
		system.setTargetMapping(tm);
			
		options.unrollAndJam = true;
		int[] unrollDims = {1, 2, 3};
		int[] unrollFactors = {1, 1, 3};
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		options.optimized = true;
		options.vec = true;
		options.simdSet = "AVX";
		options.strategy = 1;
		options.rotate = true;
		options.buffering = true;
		options.pointer = true;
		List<String> var = new LinkedList<String>();
		var.add("temp_B");
		options.vecVar = var;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j| 1<=i<N-1 && 1<=j<M-1 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)");
//		dom = dom.image(func);
//		options.vecDom = dom;
		
		//WriteC.generate(system, options, outDir);
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		//PolyIRCodeGen.generateMakefile(system, outDir);
		//PolyIRCodeGen.generateOMPMakefile(system, outDir);
		PolyIRCodeGen.generateOMPMakefile(new SIMDMakefileModule(), system, outDir);
	}
	
	private void testHeat2D(String file) throws IOException{
		//options.flattenArrays = setting.flattenArrays;
		//options.optimized = setting.tilingOptimized;
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
	
		//generate tiled code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		
		String oriOutDir = outDirPrefix + "/heat_2d_dtiler_opt_pointer_veci1j1_wavefront";
		String systemName = "heat_2d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j ->t,t+i,t+j)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap);
				
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmap2);
				
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
		//set the memory map

		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,i,j)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmap2);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
								
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);
				
		system.setTargetMapping(tm);				
		
		options.unrollAndJam = true;
		//options.noPeeling = true;
		int[] unrollDims = {1, 2, 3};
		int[] unrollFactors = {1, 1, 1};
		//int[] peelDims = {0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		//options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = true;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.pointer = true;
		options.buffering = false;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j| 1<=i<N-1 && 1<=j<M-1 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)");
//		dom = dom.image(func);
//		options.vecDom = dom;
			
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
	}
	
	private void testHeat3D(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
				
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
						
		String oriOutDir = outDirPrefix + "/heat_3d_dtiler_opt_pointer_veci1j4k2_wavefront";
		String systemName = "heat_3d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
				
		//set memory map
		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap_temp_B = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,i,j,k)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap_temp_B);
		MemoryMap mmapB = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->i,j,k)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmapB);
						
		//set space time map
		SpaceTimeMap stmap_temp_B = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap_temp_B);
												
		SpaceTimeMap stmapB = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmapB);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 3, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 3, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
										
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);

		system.setTargetMapping(tm);
		
		options.vectorizable = true;
		options.unrollAndJam = true;
		//options.noPeeling = true;
		int[] unrollDims = {1, 2, 3, 4};
		int[] unrollFactors = {1, 1, 4, 2};
		//int[] peelDims = {0, 0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		//options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = true;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.buffering = false;
		options.pointer = true;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j, k| 1<=i<N-1 && 1<=j<M-1 && 1<=k<K-1 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)");
//		dom = dom.image(func);
//		options.vecDom = dom;
										 
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
	}
	
	private void testJacobi3D27p(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
				
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
						
		String oriOutDir = outDirPrefix + "/jacobi_3d_27p_dtiler_opt_buffered_wavefront";
		String systemName = "jacobi_3d_27p";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
				
		//set memory map
		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap_temp_B = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,i,j,k)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap_temp_B);
		MemoryMap mmapB = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->i,j,k)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmapB);
						
		//set space time map
		SpaceTimeMap stmap_temp_B = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap_temp_B);
												
		SpaceTimeMap stmapB = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)"));
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmapB);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 3, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 3, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
										
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);

		system.setTargetMapping(tm);
		
		options.unrollAndJam = false;
		options.vectorizable = true;
		//options.noPeeling = true;
		int[] unrollDims = {1, 2, 3, 4};
		int[] unrollFactors = {1, 4, 1, 1};
		//int[] peelDims = {0, 0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		//options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = false;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = false;
		options.buffering = true;
		options.pointer = false;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j, k| 1<=i<N-1 && 1<=j<M-1 && 1<=k<K-1 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,t+i,t+j,t+k)");
//		dom = dom.image(func);
//		options.vecDom = dom;
										 
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
	}
	
	private void testWave2D(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
				
		String oriOutDir = outDirPrefix + "/wave_2d_dtiler_opt_buffered_wavefront";
		String systemName = "wave_2d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j ->t, 3t+i, 3t+j)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap);
						
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t, 3t+i, 3t+j)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmap2);
						
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);

		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,i,j)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmap2);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
		
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);

		system.setTargetMapping(tm);
		
		options.vectorizable = true;
		options.unrollAndJam = false;
	//	options.noPeeling = true;
		int[] unrollDims = {1, 2, 3};
		int[] unrollFactors = {1, 4, 4};
	//	int[] peelDims = {0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
	//	options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = false;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = false;
		options.buffering = true;
		options.pointer = false;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j| 3<=i<N-3 && 3<=j<M-3 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,3t+i,3t+j)");
//		dom = dom.image(func);
//		options.vecDom = dom;
								 
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
		
	}
	
	private void testWave3D(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
				
		String oriOutDir = outDirPrefix + "/wave_3d_dtiler_opt_pointer_veci1j1k2_wavefront";
		String systemName = "wave_3d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,2t+i,2t+j,2t+k)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap);
						
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,2t+i,2t+j,2t+k)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmap2);
						
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);

		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("3");
		modExprs.add("0");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_B").getDomain().getParams(),
				system.getVariableDeclaration("temp_B").getDomain().getIndices(), modExprs);
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,i,j,k)"), modFactors, tm.getMemorySpace("temp_B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->i,j,k)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmap2);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 3, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 3, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
		
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);

		system.setTargetMapping(tm);
		
		options.unrollAndJam = true;
//		options.noPeeling = false;
		int[] unrollDims = {1, 2, 3, 4};
		int[] unrollFactors = {1, 1, 1, 2};
//		int[] peelDims = {0, 0, 0, 0};	//peel the loop
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
//		options.peelDims =  peelDims;
		options.optimized = true;
		options.vec = true;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.buffering = false;
		options.pointer = true;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t,i,j,k| 2<=i<N-2 && 2<=j<M-2 && 2<=k<K-2 && 2<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j,k->t,2t+i,2t+j,2t+k)");
//		dom = dom.image(func);
//		options.vecDom = dom;
								 
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
		
	}
	
	private void testBlur2D(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
				
		String oriOutDir = outDirPrefix + "/blur_2d_dtiler_opt_pointer_veci3j5_wavefront";
		String systemName = "blur_2d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap_s0 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s0"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s0", stmap_s0);
		
		SpaceTimeMap stmap_s1 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s1"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s1", stmap_s1);
		
		SpaceTimeMap stmap_s2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s2"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s2", stmap_s2);
		
		SpaceTimeMap stmap_s4 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s4"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s4", stmap_s4);
		
		SpaceTimeMap stmap_s5 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s5"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s5", stmap_s5);
		
		SpaceTimeMap stmap_s8 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("s8"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("s8", stmap_s8);
		
		SpaceTimeMap stmap_f = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("f"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(->0, 0, 0)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("f", stmap_f);
		
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_U"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j ->t, 2t+i, 2t+j)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_U", stmap);
						
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("U"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t, 2t+i, 2t+j)"));
						
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("U", stmap2);
						
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);

		//mod factor
		List<String> modExprs = new LinkedList<String>();
		modExprs.add("2");
		modExprs.add("0");
		modExprs.add("0");
		List<IntExpression> modFactors = new LinkedList<IntExpression>();
		modFactors = TargetMappingUserFactory.createModFactor(system.getVariableDeclaration("temp_U").getDomain().getParams(),
				system.getVariableDeclaration("temp_U").getDomain().getIndices(), modExprs);
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_U"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,i,j)"), modFactors, tm.getMemorySpace("temp_U"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_U"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("U"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("U"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("U"), mmap2);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
		
		tm.getSpaceTimeLevel(0).getTilingSpecifications().add(dtiler);

		system.setTargetMapping(tm);
		
		options.vectorizable = true;
		options.unrollAndJam = true;
		int[] unrollDims = {1, 2, 3};
		int[] unrollFactors = {1, 3, 5};
		options.unrollDims = unrollDims;
		options.unrollFactors = unrollFactors;
		options.optimized = true;
		options.vec = true;
//		options.dataType = "double";
//		options.vecDim = 4;
		options.simdSet = "AVX";
//		options.simdWidth = 256;
		options.strategy = 3;
		options.rotate = true;
		options.buffering = true;
		options.pointer = true;
//		Domain dom = PolyhedralIRUtility.parseDomain(system.getParameters().getParamNames(), "{t, i, j| 2<=i<N-2 && 2<=j<M-2 && 1<=t<TSTEPS}");
//		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,2t+i,2t+j)");
//		dom = dom.image(func);
//		options.vecDom = dom;
								 
		//WriteC.generate(system, options, oriOutDir);
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
		
	}
	
	private void testSeidel2D(String file) throws IOException{
		//Read the program
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//generate wavefront scheduleC code
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		
		String oriOutDir = outDirPrefix + "/seidel_2d_npass_wavefront";
		String systemName = "seidel_2d";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(system);
		//set the space time map
		SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j ->t,t+i,t+j)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B", stmap);
				
		SpaceTimeMap stmap2 = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->t,t+i,t+j)"));
				
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", stmap2);
				
		//set the ordering dimension
		//tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
		//set the memory map
		
		MemoryMap mmap1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("temp_B"), mmap1);
		MemoryMap mmap2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(t,i,j->i,j)"), null, tm.getMemorySpace("B"));
		tm.getMemoryMaps().put(system.getVariableDeclaration("B"), mmap2);
		
		//tiling specification
		TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), 0, 2, 1);
		SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, 0, 2, TILING_TYPE.OMPWAVEFRONT);
		dtiler.getSubTiles().add(subtile);
				
		system.setTargetMapping(tm);
				
		options.multiPassWavefront = true;
				
		ScheduledC.generate(system, options, oriOutDir);
		WrapperGeneratorForC.generate(system, options, oriOutDir);
		PolyIRCodeGen.generateMakefile(system, oriOutDir);
	}
}