package edu.csu.melange.alphaz.mde.tests.polyIR.equivalence;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;


/**
 * This test is commented out since support for equivalence is dropped in the port.
 * 
 *
 */
public class TestPresburgerAutomatonConstruction {
	
//	/**
//	 * Test of the construction of the automaton.
//	 * 
//	 * @param syst1
//	 * @param syst2
//	 * @param mapInOutputs
//	 * @param output1
//	 * @param output2
//	 */
//	void testAutomatonConstruction(AffineSystem syst1, AffineSystem syst2, Map<String, String> mapInOutputs, String output1, String output2) {
//		
//		EquivalenceProblem prob = EquivalenceUserFactory.createEquivalenceProblem_String(syst1, syst2, mapInOutputs, true);
//		VariableDeclaration varDecl1 = syst1.getVariableDeclaration(output1);
//		VariableDeclaration varDecl2 = syst2.getVariableDeclaration(output2);
//		
//		PresburgerAutomaton aut = prob.buildEquivalenceAutomaton(varDecl1, varDecl2);
//		System.out.println(aut.toDot());
//		
//		return;
//	}
//	
//	@Test
//	public void test() {
//		try {
//			Program program = AlphabetsToPolyhedralIR.readAlphabets("example/equiv.ab").getProgram();
//			
//			AffineSystem syst1 = program.getSystem("syst1");
//			AffineSystem syst2 = program.getSystem("syst2");
//			Map<String,String> mapInOutputs = new HashMap<String,String>();
//			mapInOutputs.put("I", "I1");
//			mapInOutputs.put("O", "O1");
//			
//			testAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//			
//			return;
//		} catch (IOException e) {
//			throw new RuntimeException("ReadAlphabets failed...");
//		}
//	}
//	
//	@Test
//	public void testReductionSimple() {
//		
//		try {
//			Program program = AlphabetsToPolyhedralIR.readAlphabets("example/equivReductionSimple.ab").getProgram();
//			
//			AffineSystem syst1 = program.getSystem("syst1");
//			AffineSystem syst2 = program.getSystem("syst2");
//			Map<String,String> mapInOutputs = new HashMap<String,String>();
//			mapInOutputs.put("I", "I1");
//			mapInOutputs.put("O", "O1");
//			
//			testAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//			
//			return;
//		} catch (IOException e) {
//			throw new RuntimeException("ReadAlphabets failed...");
//		}
//	}
//	
//	@Test
//	public void testReductionComplicated() {
//		
//		try {
//			Program program = AlphabetsToPolyhedralIR.readAlphabets("example/equivReductionComplicated.ab").getProgram();
//			
//			AffineSystem syst1 = program.getSystem("syst1");
//			AffineSystem syst2 = program.getSystem("syst2");
//			Map<String,String> mapInOutputs = new HashMap<String,String>();
//			mapInOutputs.put("I", "I1");
//			mapInOutputs.put("O", "O1");
//			
//			testAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//			
//			return;
//		} catch (IOException e) {
//			throw new RuntimeException("ReadAlphabets failed...");
//		}
//	}
//	
//	@Test
//	public void testSumReductions() {
//
//		try {
//			Program program = AlphabetsToPolyhedralIR.readAlphabets("example/equivSumReductions.ab").getProgram();
//			
//			AffineSystem syst1 = program.getSystem("syst1");
//			AffineSystem syst2 = program.getSystem("syst2");
//			Map<String,String> mapInOutputs = new HashMap<String,String>();
//			mapInOutputs.put("I", "I1");
//			mapInOutputs.put("O", "O1");
//			
//			testAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//			
//			return;
//		} catch (IOException e) {
//			throw new RuntimeException("ReadAlphabets failed...");
//		}
//		
//		
//	}
	
} // TestPresburgerAutomatonConstruction
