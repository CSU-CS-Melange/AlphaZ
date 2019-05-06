package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.ReduceDimensionVariable;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;

public class ReduceDimensionVariableTest {
	
	public static void reduceDimVarTest(String progFile, String varDeclName) {
		Program prog;
		try {
			prog = AlphabetsToPolyhedralIR.readAlphabets(progFile).getProgram();
		} catch (IOException e) {
			throw new RuntimeException("prog not parsed ||| " + e.getMessage());
		}
		AffineSystem syst = prog.getSystems().get(0);
		
		ReduceDimensionVariable.reduceDimVariable(syst, syst.getVariableDeclaration(varDeclName));
		
		// Print the result
		System.out.println("*************************************************");
		System.out.println(syst.toString());
	}
	
	@Test
	public void testReduceDimVar1() {
		reduceDimVarTest("alphabets/ReduceDimensionVariableExamples/RedDimVarEx1.ab", "Out");
	}
	
	/* ----------------------------------------------------------------------------- */
	
	public static void reduceAlignDimVarTest(String progFile, String varDeclName) {
		Program prog;
		try {
			prog = AlphabetsToPolyhedralIR.readAlphabets(progFile).getProgram();
		} catch (IOException e) {
			throw new RuntimeException("prog not parsed ||| " + e.getMessage());
		}
		AffineSystem syst = prog.getSystems().get(0);
		
		ReduceDimensionVariable.reduceAndAlignDimVariable(syst, syst.getVariableDeclaration(varDeclName));
		
		// Print the result
		System.out.println("*************************************************");
		System.out.println(syst.toString());
	}
	
	@Test
	public void testRedAlignDimVar1() {
		reduceAlignDimVarTest("alphabets/ReduceDimensionVariableExamples/RedDimVarEx1.ab", "Out");
	}
	
	
} // ReduceDimensionVariableTest
