//package edu.csu.melange.alphaz.mde.tests.verifier;
//
//import java.io.IOException;
//
//import org.junit.Test;
//import org.polymodel.polyhedralIR.AffineSystem;
//import org.polymodel.polyhedralIR.Program;
//import org.polymodel.polyhedralIR.analysis.Verifier;
//import org.polymodel.polyhedralIR.analysis.verifier.IVerifierMessage.VERBOSITY;
//import org.polymodel.polyhedralIR.analysis.verifier.VerifierOutput;
//import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
//import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
//import org.polymodel.polyhedralIR.targetMapping.DIM_TYPE;
//import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
//import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
//import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
//import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
//import org.polymodel.polyhedralIR.transformation.reduction.NormalizeReduction;
//
//import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;
//
//
//public class VerifierTest {
//
//
//	@Test
//	public void testValidCases() {
//		System.out.println("*****************Valid Test cases******************");
//		
//		/*test_Cholesky();
//		test_MCM();
//		test_FS();
//		test_MM();
//		test_Tiling();*/
//	}
//	
//	@Test
//	public void testInvalidCases() {
//		System.out.println("*****************Invalid Test cases******************");
//		
//		//testInvalid_LUD();
//		//testInvalid_FS();
//		//testInvalid_Cholesky();
//		//testInvalid_MCM();
//		//testInvalid_Jacobi2D();
//		testInvalid_Jacobi1D();
//	}
//	
//	private static void test_Tiling() {
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MM.ab");
//			AffineSystem affineSystem = program.getSystem("MM_serialized");
//			
//			TargetMapping target_map = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("Acc_C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->i,j,k)"));		
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,j,Q+1)"));
//
//			MemorySpace memory_space = target_map.getMemorySpace("Acc"); 
//			target_map.setMemoryMap(memory_space, affineSystem.getVariableDeclaration("Acc_C"),
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->i,j)"), null);
//		
//			TilingSpecification tiling_spec = target_map.getTiling();
//			tiling_spec.setType(TILING_TYPE.SEQUENTIAL);
//			
//			affineSystem.setTargetMapping(target_map);
//			
//			
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//	}
//	
//	public static void test_FS() {
//		
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_serialized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,0)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("SR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,k->k,i)"));
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_serialized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,0)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("SR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,k->k,i)"));
//
//			MemorySpace memory_space = tm.getMemorySpace("SR_x"); 
//			tm.setMemoryMap(memory_space, affineSystem.getVariableDeclaration("SR_x"),
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,k->i)"), null);
//
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,1,0)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("x"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,k->i,0,k)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_x"), 1, DIM_TYPE.ORDERING);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,1,0)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("x"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,k->i,0,k)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_x"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_x"), 2, DIM_TYPE.PARALLEL);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//		
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("x"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,0)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_x"), 1, DIM_TYPE.ORDERING);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//	}
//	
//	public static void test_Cholesky() {
//		
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/Cholesky.ab");
//			AffineSystem affineSystem = program.getSystem("Cholesky_normalized2");
//			NormalizeReduction.apply(affineSystem);
//			
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,1,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 2, DIM_TYPE.PARALLEL);
//						
//			affineSystem.setTargetMapping(tm);
//				
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//		
//		
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/Cholesky.ab");
//			AffineSystem affineSystem = program.getSystem("Cholesky_normalized");
//			NormalizeReduction.apply(affineSystem);
//			
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,1,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 2, DIM_TYPE.PARALLEL);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L_1"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L_1"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L_1"), 2, DIM_TYPE.PARALLEL);
//			
//			affineSystem.setTargetMapping(tm);
//				
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//	}
//	
//	public static void test_MCM() {
//		
//		//try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MCM.ab");
//			AffineSystem affineSystem = program.getSystem("MCM_serialized");
//			NormalizeReduction.apply(affineSystem);
//			
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j-i,i,j)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("SR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->j-i,i,k)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("min_cost"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(->N-1,1,N+1)"));
//			
//	
//			tm.setMemoryMap(tm.getMemorySpace("SR_pM"), affineSystem.getVariableDeclaration("SR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(),"(i,j,k->i,j)"), null);
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		/*} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//	}
//	
//	private static void test_MM() {
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MM.ab");
//			AffineSystem affineSystem = program.getSystem("MM_serialized");
//			
//			TargetMapping target_map = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("Acc_C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->i,j,k)"));		
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,j,Q+1)"));
//
//			MemorySpace memory_space = target_map.getMemorySpace("Acc"); 
//			target_map.setMemoryMap(memory_space, affineSystem.getVariableDeclaration("Acc_C"),
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->i,j)"), null);
//			
//			
//			affineSystem.setTargetMapping(target_map);
//			
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MM.ab");
//			AffineSystem affineSystem = program.getSystem("MM_serialized");
//			
//			TargetMapping target_map = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("Acc_C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->i,j,k)"));		
//
//			target_map.setSpaceTimeMap(affineSystem.getVariableDeclaration("C"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,j,Q)"));
//
//			target_map.setStatementOrder(affineSystem.getEquation("Acc_C"), affineSystem.getEquation("C"));
//			
//			MemorySpace memory_space = target_map.getMemorySpace("Acc_C"); 
//			target_map.setMemoryMap(memory_space, affineSystem.getVariableDeclaration("Acc_C"),
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->)"), null);
//			
//			affineSystem.setTargetMapping(target_map);
//			
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void testInvalid_FS() {
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/FS.ab");
//			AffineSystem affineSystem = program.getSystem("FS_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i->i,0)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_x"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_x"), 1, DIM_TYPE.PARALLEL);
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void testInvalid_Cholesky() {
//		
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/Cholesky.ab");
//			AffineSystem affineSystem = program.getSystem("Cholesky_reduce");
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/Cholesky.ab");
//			AffineSystem affineSystem = program.getSystem("Cholesky_normalized2");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 2, DIM_TYPE.PARALLEL);
//
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void testInvalid_LUD() {
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/LUD.ab");
//			AffineSystem affineSystem = program.getSystem("LUD_normalized");
//			NormalizeReduction.apply(affineSystem);
//			
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i,1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 2, DIM_TYPE.PARALLEL);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 3, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("U"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,1,j,1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("U"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("U"), 2, DIM_TYPE.PARALLEL);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("U"), 3, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i,0)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 2, DIM_TYPE.PARALLEL);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 3, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_U"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,1,j,0)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_U"), 1, DIM_TYPE.ORDERING);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_U"), 2, DIM_TYPE.PARALLEL);
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_U"), 3, DIM_TYPE.ORDERING);
//			
//			affineSystem.setTargetMapping(tm);
//				
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/LUD.ab");
//			AffineSystem affineSystem = program.getSystem("LUD_normalized");
//			NormalizeReduction.apply(affineSystem);
//			
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_L"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_U"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,1,j)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("NR_U"), 1, DIM_TYPE.ORDERING);
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("L"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j,0,i+1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("L"), 1, DIM_TYPE.ORDERING);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("U"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->i,1,j+1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("U"), 1, DIM_TYPE.ORDERING);
//						
//			affineSystem.setTargetMapping(tm);
//				
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void testInvalid_MCM() {
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MCM.ab");
//			AffineSystem affineSystem = program.getSystem("MCM_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j-i,i,j-1)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->j-i,i,k)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("min_cost"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(->N-1,1,N+1)"));
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MCM.ab");
//			AffineSystem affineSystem = program.getSystem("MCM_serialized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j-i,i,j)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("pM"), 0, DIM_TYPE.PARALLEL);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("SR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->j-i,i,k)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("SR_pM"), 0, DIM_TYPE.PARALLEL);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("min_cost"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(->N-1,1,N+1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("min_cost"), 0, DIM_TYPE.PARALLEL);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MCM.ab");
//			AffineSystem affineSystem = program.getSystem("MCM_serialized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j-i,i,j)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("pM"), 2, DIM_TYPE.PARALLEL);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("SR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->j-i,i,k)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("SR_pM"), 2, DIM_TYPE.PARALLEL);
//			
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("min_cost"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(->N-1,1,N+1)"));
//			tm.setDimensionType(affineSystem.getVariableDeclaration("min_cost"), 2, DIM_TYPE.PARALLEL);
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("alphabets/VerifierExamples/MCM.ab");
//			AffineSystem affineSystem = program.getSystem("MCM_normalized");
//			NormalizeReduction.apply(affineSystem);
//
//			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(affineSystem);
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j->j-i,i,j)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("NR_pM"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(i,j,k->j-i,i,k)"));
//
//			tm.setSpaceTimeMap(affineSystem.getVariableDeclaration("min_cost"), 
//					PolyhedralIRUtility.parseAffineFunction(affineSystem.getParameters(), "(->N-1,1,N)"));
//			
//			affineSystem.setTargetMapping(tm);
//
//			VerifierOutput output = Verifier.verify(affineSystem, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testInvalid_Jacobi1D() {
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("testcases/jacobi_1d/jacobi_1d.ab");
//			String systemName = "jacobi_1d";
//			AffineSystem system = program.getSystem(systemName);
//			//alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "temp_B", "(t,i->t,i)");
//			//alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "B", "(t,i,j->0,i,j)");
//			alphaz.mde.TargetMapping.setMemoryMap(program, systemName, "temp_B", "temp_B", "(t,i->i)");
//			alphaz.mde.TargetMapping.setMemoryMap(program, systemName, "B", "B", "(t,i->t, i)");
//			alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "temp_B", "(t,i->t,i)");
//			alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "B", "(t,i->t,i)");
//			VerifierOutput output = Verifier.verify(system, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test
//	public void testInvalid_Jacobi2D() {
//		try {
//			Program	program = alphaz.mde.Basic.ReadAlphabets("testcases/jacobi_2d/jacobi_2d.ab");
//			String systemName = "jacobi_2d";
//			AffineSystem system = program.getSystem(systemName);
//			alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "temp_B", "(t,i,j->t,i,j)");
//			alphaz.mde.TargetMapping.setSpaceTimeMap(program, systemName, "B", "(t,i,j->0,i,j)");
//			alphaz.mde.TargetMapping.setMemoryMap(program, systemName, "temp_B, B", "B", "(t,i,j->i,j)");
////			temp_B[t,i,j] = case
////					{|t == 0} : A[i,j];
////					{|t > 0 && 1<=(i,j)<N-1}  : (temp_B[t-1,i-1,j] + temp_B[t-1,i,j-1] + temp_B[t-1,i,j] + temp_B[t-1,i,j+1] + temp_B[t-1,i+1,j])*0.2;
////					{|t > 0 && 0==i } || {|t > 0 && 0==j } || {|t > 0 && i==N-1 } || {|t > 0 && j==N-1 } : temp_B[t-1,i,j];  
////				esac; 
////
////B[t,i,j] = temp_B[t-1,i,j]; 
//			VerifierOutput output = Verifier.verify(system, VERBOSITY.NONE);
//			System.out.println(output.toString(VERBOSITY.MAX));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//
//}