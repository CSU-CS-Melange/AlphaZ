package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;

public class SubSystemCodeGenTest {
	private static String outDirPrefix = "./test-out/scheduledCWithSubSystemV2/";
	
	
	@Test
	public void testCodeGenForsubSystem() throws IOException{
		
		testBlockedCholesky("alphabets/SubSystemExamples/BlockCholesky.ab");
		//testBlockedCholeskyDefault("alphabets/SubSystemExamples/BlockCholesky.ab");
		//testMatrixMult("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
//		testSquareBlockedMatrixProduct("alphabets/SubSystemExamples/SquareBlockedMM.ab");
		//testSquareBlockMatrixProduct("alphabets/SubSystemExamples/SquareBlockMM.ab");
		//testStripMM("alphabets/SubSystemExamples/StripMM.ab");
		//testMMStripSub("alphabets/SubSystemExamples/MMStripSub.ab");
		//testForwardSubStitutionWithSubSys("alphabets/SubSystemExamples/FSSubSys.ab");
		//testForwardSubStitutionWithSubSysV2("alphabets/SubSystemExamples/Fwd_dp.ab");
		//testMatrixMultiHierarchy("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		//testForwardSubstitutionBlocked("alphabets/SubSystemExamples/FSBlock.ab");
		//testForwardSubstitutionBlockedWithReuse("alphabets/SubSystemExamples/FSBlock.ab");
	}
	

	private void testMatrixMult(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		//alphaz.mde.Basic.PrintAST(program);
		
		
		String outDir = outDirPrefix+"/matrix_product_subsystem_default_parallel";
		String systemName = "mat_product";
		AffineSystem system = program.getSystem(systemName);
		//set the target mapping for system
		String label = "UseEquation_C";
		
		TargetMapping mat_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
	
//		mat_product_tm.getMemoryMaps().get(system.getVariableDeclaration("B")).setMapping(
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j->j,i)"));
//		
		
//		UseEquationOptimization opt = TargetMappingUserFactory.createUseEquationOptimization(label, 0, true, 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
//				"A",  PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->0,0)"), 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp)"), 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->0,0)"));
//	
		//set the optimizations for the input and output for the use equation
//		mat_product_tm.getUseEquationOptimizations().add(opt);
		
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,8)")));
		
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,5)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,9)")));
		
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false, 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->)"), "UseEquation_C_output_0", 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,7)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,10)")));
		
//		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false, 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->)"), "C", 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->0,0)"), 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp)"), 
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->0,0)")));
		
		
		//set the target Mapping for the subsystem call
		mat_product_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("UseEquation_C", TargetMappingUserFactory.createUseEquationSpaceTimeMap("UseEquation_C",
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp->ip,jp,6)"), system.getUseEquation("UseEquation_C")));
		
		//set up the ordering dimension
		mat_product_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(2);
		//setup parallel dimension
		List<Integer> prefix = new LinkedList<Integer>();
		
		mat_product_tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(TargetMappingUserFactory.createParallelizationSpecification(prefix, 0));
		
		system.setTargetMapping(mat_product_tm);
		
		//set target mapping for system2
		String systemName2 = "dot_product";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping dot_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		//set up memory map
		MemorySpace mspace = dot_product_tm.getMemorySpace("RSpace");
		MemoryMap mmap_1 = TargetMappingUserFactory.createMemoryMap(system2.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i->)"), null, mspace);
		dot_product_tm.getMemoryMaps().put(system2.getVariableDeclaration("temp"), mmap_1);
		
		MemoryMap mmap_2 = TargetMappingUserFactory.createMemoryMap(system2.getVariableDeclaration("Res"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(->)"), null, mspace);
		dot_product_tm.getMemoryMaps().put(system2.getVariableDeclaration("Res"), mmap_2);
		
		SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system2.getVariableDeclaration("Res"), PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(->N)"));
		dot_product_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(stMap.getLabel(), stMap);
		/*dot_product_tm.setSpaceTimeMap(0, system2.getVariableDeclaration("Res"), PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(->N)"));
		dot_product_tm.setStatementOrder(system2.getEquation("temp"), system2.getEquation("Res"));*/
		system2.setTargetMapping(dot_product_tm);
		
		ScheduledC.generate(program, options, outDir);
		//ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testMatrixMultiHierarchy(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		
		//alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/hierarchy_matrix_product";
		String systemName = "mat_product";
		AffineSystem system = program.getSystem(systemName);
		//set the targetMapping for this system
		TargetMapping mat_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		String tlabel = "UseEquation_C";
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(tlabel, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(jp->)"), 
				"A",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->)")));
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(tlabel, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->)"), 
				"UseEquation_C_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,5)")));
		mat_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(tlabel, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->)"), 
				"UseEquation_C_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,6)")));
		mat_product_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(tlabel, TargetMappingUserFactory.createUseEquationSpaceTimeMap(tlabel,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip->ip,3)"), system.getUseEquation(tlabel)));
		
		
		system.setTargetMapping(mat_product_tm);
		
		//set the targetMapping for system2
		String systemName2 = "mat_vect_product";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping mat_vec_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		String label = "UseEquation_res";
		mat_vec_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_res_input_0",PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,5)")));
		mat_vec_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip,jp,k->k)"), 
				"vect",PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->)")));
		mat_vec_product_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_res_output_0",PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,6)")));
		
		mat_vec_product_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(ip->ip,3)"), system2.getUseEquation(label)));
		system2.setTargetMapping(mat_vec_product_tm);
		
		//set the targetMapping for system3
		String systemName3 = "vector_product";
		AffineSystem system3 = program.getSystem(systemName3);
		TargetMapping vector_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system3);
		SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system3.getVariableDeclaration("Res"), PolyhedralIRUtility.parseAffineFunction(system3.getParameters(), "(->N)"));
		vector_product_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(stMap.getLabel(), stMap);
		system3.setTargetMapping(vector_product_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testStripMM(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		//alphaz.mde.Basic.PrintAST(program);
		
		String outDir = outDirPrefix+"/strip_matrix_product";
		String systemName = "StripMM";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_C";
		//set the targetmapping for the systme
		TargetMapping stripMM_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,0)")));
		
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,1)")));
		
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,2)")));
		
		//set the target Mapping for the subsystem call
		stripMM_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,2)"), system.getUseEquation(label)));
		
		system.setTargetMapping(stripMM_tm);
		
		String systemName2 = "MM";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping MM_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(MM_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
		//set target mapping for system2
	}
	
	private void testMMStripSub(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		//alphaz.mde.Basic.PrintAST(program);
		
		String outDir = outDirPrefix+"/strip_matrix_product_v2";
		String systemName = "StripBlockMM";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_C";
		//set TargetMapping for the system
		TargetMapping stripMM_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,0)")));
		
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,1)")));
		
		stripMM_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_C_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,2)")));
		
		//set the target Mapping for the subsystem call
		stripMM_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,jj,2)"), system.getUseEquation(label)));
		
		system.setTargetMapping(stripMM_tm);
		
		String systemName2 = "MM";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping MM_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(MM_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testForwardSubStitutionWithSubSys(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		//alphaz.mde.Basic.PrintAST(program);
		//alphaz.mde.Basic.Show(program);
		String outDir = outDirPrefix+"/forwardSubstitution";
		String systemName = "FSBlock";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_preX";
		//set TargetMapping for the system
		TargetMapping fs_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_preX_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,8)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_preX_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,9)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_preX_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,6)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,10)")));
		
		//set the target Mapping for the subsystem call
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,5)"), system.getUseEquation(label)));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("x", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("x"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,7)")));
		
		//fs_block_tm.getStatementOrderings().add(TargetMappingUserFactory.createStatementOrder(system.getUseEquation("UseEquation_preX"), system.getEquation("x")));
		system.setTargetMapping(fs_block_tm);
		
		String systemName2 = "DotProd";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping dot_prod_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(dot_prod_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testForwardSubStitutionWithSubSysV2(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/forwardSubstitutionV2";
		String systemName = "Fwd_dp";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_temp";
		//set TargetMapping for the system
		TargetMapping fs_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_temp_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,8)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_temp_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,9)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_temp_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,6)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,10)")));
		
		//set the target Mapping for the subsystem call
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,5)"), system.getUseEquation(label)));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("X", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("X"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i,7)")));
		
		
		system.setTargetMapping(fs_block_tm);
		
		String systemName2 = "dotProd";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping dot_prod_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(dot_prod_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testForwardSubstitutionBlocked(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/forwardSubstitutionBlocked";
		String systemName = "FSBlock";
		AffineSystem system = program.getSystem(systemName);
		
		String label1 = "UseEquation_AccVec";
		String label2 = "UseEquation_XX";
		
		//set TargetMapping for the top level system
		TargetMapping fs_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
				
		//set the TargetMapping for the use equation AccVec
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,7)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,8)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,6)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,9)")));
		
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label1, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label1,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,0,jj,5)"), system.getUseEquation(label1)));
		
		//set the TargetMapping for the use equation XX
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,7)")));
		
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,8)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,6)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,9)")));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label2, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label2,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,2,0,5)"), system.getUseEquation(label2)));
		
		
		//set the TargetMapping for the rest of the equations
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("AccSum", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("AccSum"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i->ii,1,i,0)")));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("sum", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("sum"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i->ii,1,i,1)")));
		
		
		system.setTargetMapping(fs_block_tm);
		
		//set the target mapping for subsystem blockMVM
		String subSystemName1 = "blockMVM";
		AffineSystem subsystem1 = program.getSystem(subSystemName1);
		TargetMapping blockMVM_tm = TargetMappingUserFactory.createIdentityTargetMapping(subsystem1);
		subsystem1.setTargetMapping(blockMVM_tm);
		
		String subSystemName2 = "diagSolve";
		AffineSystem subsystem2 = program.getSystem(subSystemName2);
		TargetMapping diag_solve_tim = TargetMappingUserFactory.createIdentityTargetMapping(subsystem2);
		subsystem2.setTargetMapping(diag_solve_tim);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
		
	}
	
	
	private void testForwardSubstitutionBlockedWithReuse(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/forwardSubstitutionBlocked";
		String systemName = "FSBlock";
		AffineSystem system = program.getSystem(systemName);
		
		String label1 = "UseEquation_AccVec";
		String label2 = "UseEquation_XX";
		
		//set TargetMapping for the top level system
		TargetMapping fs_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
				
		//set the TargetMapping for the use equation AccVec
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,1,jj,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,0,0)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,0,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,1,jj,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,0,1)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label1, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_AccVec_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->0,0,0,0,2)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,1,jj,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->2,0,0,0,2)")));
		
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label1, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label1,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->1,ii,1,jj,2)"), system.getUseEquation(label1)));
		
		//set the TargetMapping for the use equation XX
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->0,0,0,0,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->1,ii,3,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->2,0,0,0,3)")));
		
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->0,0,0,0,4)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->1,ii,3,0,1)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->2,0,0,0,4)")));
		
		fs_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label2, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"UseEquation_XX_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->0,0,0,0,5)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->1,ii,3,0,3)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->2,0,0,0,5)")));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label2, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label2,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->1,ii,3,0,2)"), system.getUseEquation(label2)));
		
		
		//set the TargetMapping for the rest of the equations
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("AccSum", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("AccSum"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i->1,ii,2,i,0)")));
		
		fs_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("sum", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("sum"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i->1,ii,2,i,1)")));
		
		
		system.setTargetMapping(fs_block_tm);
		
		//set the target mapping for subsystem blockMVM
		String subSystemName1 = "blockMVM";
		AffineSystem subsystem1 = program.getSystem(subSystemName1);
		TargetMapping blockMVM_tm = TargetMappingUserFactory.createIdentityTargetMapping(subsystem1);
		subsystem1.setTargetMapping(blockMVM_tm);
		
		String subSystemName2 = "diagSolve";
		AffineSystem subsystem2 = program.getSystem(subSystemName2);
		TargetMapping diag_solve_tim = TargetMappingUserFactory.createIdentityTargetMapping(subsystem2);
		subsystem2.setTargetMapping(diag_solve_tim);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testSquareBlockMatrixProduct(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
//		alphaz.mde.Basic.PrintAST(program);
		
		//alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/SqureBlockMM_noextra_sequential";
		String systemName = "BlockMM";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_CC";
//		//set TargetMapping for the system
		TargetMapping matrix_square_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"A",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)")));
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"B",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)")));
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ip,jp,k->k)"), 
				"CC",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)")));
		
//		//set the target Mapping for the subsystem call
		matrix_square_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0)"), system.getUseEquation(label)));
		
		matrix_square_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("C"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,1,i,j)")));
		
		system.setTargetMapping(matrix_square_block_tm);
		
		String systemName2 = "MM";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping matrix_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(matrix_product_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	private void testSquareBlockedMatrixProduct(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		//alphaz.mde.Basic.PrintAST(program);
		String outDir = outDirPrefix+"/SqureBlockedMM_default_mkl";
		String systemName = "BlockMM";
		AffineSystem system = program.getSystem(systemName);
		
		String label = "UseEquation_CC";
		//set TargetMapping for the system
		TargetMapping matrix_square_block_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_CC_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_CC_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,2,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,3,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,9,0,0)")));
		
		matrix_square_block_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_CC_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,4,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,6,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,10,0,0)")));
		
//		//set the target Mapping for the subsystem call
		matrix_square_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,5,0,0)"), system.getUseEquation(label)));
		
		matrix_square_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_CC", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("temp_CC"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->ii,jj,0,kk,7,i,j)")));
		
		matrix_square_block_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("C"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,1,i,j,0,0)")));
		
		//set up the memory map
		MemorySpace cspace = matrix_square_block_tm.getMemorySpace("CC");
		MemoryMap mmap_1 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("CC"),
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->i,j)"), null, cspace);
		matrix_square_block_tm.getMemoryMaps().put(system.getVariableDeclaration("CC"), mmap_1);
		
		MemorySpace mspace = matrix_square_block_tm.getMemorySpace("C");
		MemoryMap mmap_2 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("temp_CC"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->ii,jj,i,j)"), null, mspace);
		matrix_square_block_tm.getMemoryMaps().put(system.getVariableDeclaration("temp_CC"), mmap_2);
		
		MemoryMap mmap_3 = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("C"),
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,i,j)"), null, mspace);
		matrix_square_block_tm.getMemoryMaps().put(system.getVariableDeclaration("C"), mmap_3);
		
		//set up the parallelization dimension
		matrix_square_block_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(2);
		
//		List<Integer> prefix = new LinkedList<Integer>();
//		List<Integer> dims = new LinkedList<Integer>();
//		dims.add(0);
//		dims.add(1);
//		
//		matrix_square_block_tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(
//				TargetMappingUserFactory.createParallelizationSpecification(prefix, dims));
		
		system.setTargetMapping(matrix_square_block_tm);
		
		String systemName2 = "MM";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping matrix_product_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		system2.setTargetMapping(matrix_product_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
	}
	
	
	public void testBlockedCholesky(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		String outDir = outDirPrefix+"/BlockCholesky_parallel";
		String systemName = "BlockCholesky";
		AffineSystem system = program.getSystem(systemName);
		
		//set up target Mapping for BlockCholesky system
		TargetMapping blocked_cholesky_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		String label = "UseEquation_Ldiag";
		
//		System.out.println("system="+systemName+";");
//		System.out.println("label="+label+";");
		UseEquationOptimization ueo = TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"A",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)"));
		blocked_cholesky_tm.getUseEquationOptimizations().add(ueo);
//		System.out.println("setSpaceTimeMapForUseEquationOptimization(prog, system, label, "+  +", 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)"););
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"L",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,1,0,0,0,0)"), system.getUseEquation(label)));
		
		label = "UseEquation_MxMTOuts";
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"L",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"L",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"MxMTOuts",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,3,kk,0,0,0)"), system.getUseEquation(label)));
		
		label = "UseEquation_Lrest";
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"L",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"A",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"L",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,0,kk,8,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,1,0,0,0,0)"), system.getUseEquation(label)));
		
		//set up schedule for other variable in the system
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("L", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("L"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,2,i,j,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("Temp_MxMTouts", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("Temp_MxMTouts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->ii,jj-1,3,kk,1,i,j)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("Temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("Temp"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,0,i,j,0,0)")));
		
		//set up memory map for variable
		MemoryMap mmap_MxMTOuts = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("MxMTOuts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->i,j)"), null, blocked_cholesky_tm.getMemorySpace("MxMTOuts"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("MxMTOuts"), mmap_MxMTOuts);
		
		MemoryMap mmap_MxMTOuts_temp = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Temp_MxMTouts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->i,j)"), null, blocked_cholesky_tm.getMemorySpace("Temp_MxMTouts"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Temp_MxMTouts"), mmap_MxMTOuts_temp);
		
		MemoryMap mmap = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Temp"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,i,j)"), null, blocked_cholesky_tm.getMemorySpace("A"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Temp"), mmap);
		
		MemorySpace mspace = blocked_cholesky_tm.getMemorySpace("L");
		MemoryMap mmap_lrest = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Lrest"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,i,j)"), null, mspace);
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Lrest"), mmap_lrest);
		
		MemoryMap mmap_ldiag = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Ldiag"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i,j->ii,ii,i,j)"), null, mspace);
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Ldiag"), mmap_ldiag);
		
		//set up ordering dimension
		blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(2);
		blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(4);
		
		//set up parallelization dimension
		List<Integer> prefix = new LinkedList<Integer>();
		List<Integer> dims = new LinkedList<Integer>();
		dims.add(1);
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(
				TargetMappingUserFactory.createParallelizationSpecification(prefix, dims));
		
		system.setTargetMapping(blocked_cholesky_tm);
		
		printScript(blocked_cholesky_tm);
		
	
		//set up target mapping for baseCholeskySquare
		String systemName2 = "baseCholeskySquare";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping base_cholesky_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		
		//set up space time map
		base_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("L", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system2.getVariableDeclaration("L"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->i,j,1)")));
		
		base_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system2.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->i,j,0)")));
		//set up memory map
		MemoryMap mmap_1 = TargetMappingUserFactory.createMemoryMap(system2.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->)"), null, base_cholesky_tm.getMemorySpace("temp"));
		base_cholesky_tm.getMemoryMaps().put(system2.getVariableDeclaration("temp"), mmap_1);
		
		system2.setTargetMapping(base_cholesky_tm);
		
		printScript(base_cholesky_tm);
		
		//set up target mapping for baseMxMT
		String systemName3 = "baseMxMT";
		AffineSystem system3 = program.getSystem(systemName3);
		TargetMapping base_mxmt_tm = TargetMappingUserFactory.createIdentityTargetMapping(system3);
		
		base_mxmt_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system3.getVariableDeclaration("C"), 
				PolyhedralIRUtility.parseAffineFunction(system3.getParameters(), "(i,j->i,j)")));
		
		
		system3.setTargetMapping(base_mxmt_tm);
		printScript(base_mxmt_tm);
		
		//set up target mapping for baseTriInv
		String systemName4 = "baseTriInv";
		AffineSystem system4 = program.getSystem(systemName4);
		TargetMapping base_tri_tm = TargetMappingUserFactory.createIdentityTargetMapping(system4);
		
		base_tri_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system4.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->i,j,0)")));
		base_tri_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system4.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->i,j,1)")));
		
		MemoryMap mmap_2 = TargetMappingUserFactory.createMemoryMap(system4.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->)"), null, base_tri_tm.getMemorySpace("temp"));
		base_tri_tm.getMemoryMaps().put(system4.getVariableDeclaration("temp"), mmap_2);
		
		system4.setTargetMapping(base_tri_tm);
		printScript(base_tri_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
		
	}
	
	public static void printScript(TargetMapping blocked_cholesky_tm) {
		String sysName = blocked_cholesky_tm.getContainerSystem().getName();
		StringBuilder sb = new StringBuilder();
		sb.append("system=\"").append(sysName).append("\";\n");
		for (UseEquationOptimization ueo :  blocked_cholesky_tm.getUseEquationOptimizations()) {
			String label = ueo.getLabel();
			sb.append("label=\"").append(label).append("\";\n");
			sb.append("setSpaceTimeMapForUseEquationOptimization(prog,system,label,")
			  .append(ueo.isInput()?0:1).append(",").append(ueo.getNum()).append(",\"")
			  .append(ueo.getMemoryAllocationSpaceTimeMap().toString())
			  .append("\",\"").append(ueo.getValueCopySpaceTimeMap()).append("\",\"")
			  .append(ueo.getMemoryFreeSpaceTimeMap()).append("\");\n");
			sb.append("setMemorySpaceForUseEquationOptimization(prog,system,label,")
			  .append(ueo.isInput()?0:1).append(",").append(ueo.getNum()).append(",\"")
			  .append(ueo.getMemorySpaceNameforTemporaryVariable()).append("\");\n");
			
			
//			opt.setLabel(label);
//			opt.setNum(num);
//			opt.setInput(isInput);
//			opt.setMemoryMappingForTemporaryVariable(memoryMapping);
//			opt.setMemorySpaceNameforTemporaryVariable(spaceName);
		}
		
		for (Entry<String, SpaceTimeMap> stentry : 
			blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps()) {
			sb.append("setSpaceTimeMap(prog, system, \"").append(stentry.getKey())
			  .append("\",\"").append(stentry.getValue().getMapping()).append("\");\n");
		}
		
		for (Entry<VariableDeclaration, MemoryMap> mmEntry : 
			blocked_cholesky_tm.getMemoryMaps()) {
			VariableDeclaration v = mmEntry.getKey();
			MemoryMap mm = mmEntry.getValue();
			sb.append("setMemoryMap(prog,system,\"").append(v.getName()).append("\",\"")
			  .append(mm.getSpace().getName()).append("\",\"").append(mm.getMapping())
			  .append("\");\n");
		}
		
		if (!blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions().isEmpty()) {
			sb.append("setOrderingDimensions(prog,system,\"");
			for (Integer d : blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions()) {
				sb.append(d).append(",");
			}
			sb.delete(sb.length()-1, sb.length());
			sb.append("\");\n");
		}
		
		if (!blocked_cholesky_tm.getSpaceTimeLevel(0).getParallelizationSpecifications().isEmpty()) {
			for (ParallelizationSpecification ps : blocked_cholesky_tm.getSpaceTimeLevel(0).getParallelizationSpecifications()) {
				sb.append("setParallel(prog, system, \"");
				for (int o : ps.getOrderingPrefix()) {
					sb.append(o).append(",");
				}
				if (!ps.getOrderingPrefix().isEmpty()) {
					sb.delete(sb.length()-1, sb.length());
				}
				
				sb.append("\",\"");
				
				for (int d : ps.getParallelDims()) {
					sb.append(d).append(",");
				}
				if (!ps.getParallelDims().isEmpty()) {
					sb.delete(sb.length()-1, sb.length());
				}
				sb.append("\");\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}


	private void testBlockedCholeskyDefault(String file) throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		alphaz.mde.Analysis.CheckProgram(program);
		
		String outDir = outDirPrefix+"/BlockCholesky_default_parallel";
		String systemName = "BlockCholesky";
		AffineSystem system = program.getSystem(systemName);
		
		//set up target Mapping for BlockCholesky system
		TargetMapping blocked_cholesky_tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		String label = "UseEquation_Ldiag";
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_Ldiag_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,1,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,2,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,5,0,0,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_Ldiag_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,1,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,4,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,5,0,0,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii->ii,ii,3,0,0,0,0)"), system.getUseEquation(label)));
		
		label = "UseEquation_MxMTOuts";
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_MxMTOuts_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,2,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,5,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_MxMTOuts_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,2,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,5,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_MxMTOuts_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,1,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,4,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,5,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj-1,7,kk,3,0,0)"), system.getUseEquation(label)));
		
		label = "UseEquation_Lrest";
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_Lrest_input_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,1,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,2,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,5,0,0,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 1, true,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_Lrest_input_1",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,1,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,2,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,5,0,0,0,0)")));
		
		blocked_cholesky_tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(label, 0, false,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk->ii,jj,kk)"), 
				"UseEquation_Lrest_output_0",PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,1,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,4,0,0,0,0)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,5,0,0,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(label, TargetMappingUserFactory.createUseEquationSpaceTimeMap(label,
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj->ii,jj,3,0,0,0,0)"), system.getUseEquation(label)));
		
		//set up schedule for other variable in the system
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("L", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("L"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,6,i,j,0,0)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("Temp_MxMTouts", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("Temp_MxMTouts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->ii,jj-1,7,kk,6,i,j)")));
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("Temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system.getVariableDeclaration("Temp"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,0,jj,0,i,j,0,0)")));
		
		//set up memory map for variable
		MemoryMap mmap_MxMTOuts = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("MxMTOuts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->i,j)"), null, blocked_cholesky_tm.getMemorySpace("MxMTOuts"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("MxMTOuts"), mmap_MxMTOuts);
		
		MemoryMap mmap_MxMTOuts_temp = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Temp_MxMTouts"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,kk,i,j->i,j)"), null, blocked_cholesky_tm.getMemorySpace("Temp_MxMTouts"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Temp_MxMTouts"), mmap_MxMTOuts_temp);
		
		MemoryMap mmap = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Temp"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,i,j)"), null, blocked_cholesky_tm.getMemorySpace("A"));
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Temp"), mmap);
		
		MemorySpace mspace = blocked_cholesky_tm.getMemorySpace("L");
		MemoryMap mmap_lrest = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Lrest"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,jj,i,j->ii,jj,i,j)"), null, mspace);
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Lrest"), mmap_lrest);
		
		MemoryMap mmap_ldiag = TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration("Ldiag"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(ii,i,j->ii,ii,i,j)"), null, mspace);
		blocked_cholesky_tm.getMemoryMaps().put(system.getVariableDeclaration("Ldiag"), mmap_ldiag);
		
		//set up ordering dimension
		blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(2);
		blocked_cholesky_tm.getSpaceTimeLevel(0).getOrderingDimensions().add(4);
		
		//set up parallelization dimension
		List<Integer> prefix = new LinkedList<Integer>();
		List<Integer> dims = new LinkedList<Integer>();
		dims.add(1);
		
		blocked_cholesky_tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(
				TargetMappingUserFactory.createParallelizationSpecification(prefix, dims));
		
		system.setTargetMapping(blocked_cholesky_tm);
	
		//set up target mapping for baseCholeskySquare
		String systemName2 = "baseCholeskySquare";
		AffineSystem system2 = program.getSystem(systemName2);
		TargetMapping base_cholesky_tm = TargetMappingUserFactory.createIdentityTargetMapping(system2);
		
		//set up space time map
		base_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("L", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system2.getVariableDeclaration("L"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->i,j,1)")));
		
		base_cholesky_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system2.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->i,j,0)")));
		//set up memory map
		MemoryMap mmap_1 = TargetMappingUserFactory.createMemoryMap(system2.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system2.getParameters(), "(i,j->)"), null, base_cholesky_tm.getMemorySpace("temp"));
		base_cholesky_tm.getMemoryMaps().put(system2.getVariableDeclaration("temp"), mmap_1);
		
		system2.setTargetMapping(base_cholesky_tm);
		
		//set up target mapping for baseMxMT
		String systemName3 = "baseMxMT";
		AffineSystem system3 = program.getSystem(systemName3);
		TargetMapping base_mxmt_tm = TargetMappingUserFactory.createIdentityTargetMapping(system3);
		
		base_mxmt_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system3.getVariableDeclaration("C"), 
				PolyhedralIRUtility.parseAffineFunction(system3.getParameters(), "(i,j->i,j)")));
		
		
		system3.setTargetMapping(base_mxmt_tm);
		
		//set up target mapping for baseTriInv
		String systemName4 = "baseTriInv";
		AffineSystem system4 = program.getSystem(systemName4);
		TargetMapping base_tri_tm = TargetMappingUserFactory.createIdentityTargetMapping(system4);
		
		base_tri_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system4.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->i,j,0)")));
		base_tri_tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B", TargetMappingUserFactory.createStandardEquationSpaceTimeMap(system4.getVariableDeclaration("B"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->i,j,1)")));
		
		MemoryMap mmap_2 = TargetMappingUserFactory.createMemoryMap(system4.getVariableDeclaration("temp"), 
				PolyhedralIRUtility.parseAffineFunction(system4.getParameters(), "(i,j->)"), null, base_tri_tm.getMemorySpace("temp"));
		base_tri_tm.getMemoryMaps().put(system4.getVariableDeclaration("temp"), mmap_2);
		
		system4.setTargetMapping(base_tri_tm);
		
		ScheduledC.generate(program, options, outDir);
		WrapperGeneratorForC.generate(system, options, outDir);
		PolyIRCodeGen.generateMakefile(system, outDir);
		
	}
}