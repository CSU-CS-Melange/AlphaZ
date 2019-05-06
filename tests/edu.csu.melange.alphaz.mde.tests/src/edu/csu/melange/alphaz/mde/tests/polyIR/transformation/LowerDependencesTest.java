package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.transformation.LowerDependences;
import org.polymodel.polyhedralIR.util.AShow;

/**
 * Test for the LowerDependences transformation
 * 
 * @author Guillaume
 */
public class LowerDependencesTest {
	
	public static void testLowDep(String filename) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(filename);
		
		for (AffineSystem syst : prog.getSystems())
			for (StandardEquation stEq : syst.getEquations())
				stEq.setExpression(LowerDependences.lowerDependences(stEq.getExpression()));
		
		System.out.println();
		System.out.println("*****************************************");
		System.out.println(AShow.toString(prog));
	}
	
	@Test
	public void testLowerDependences() {
		testLowDep("alphabets/NormalizeExamples/Fib.ab");
		testLowDep("alphabets/NormalizeExamples/PermutationDepReduction1.ab");
		testLowDep("alphabets/NormalizeExamples/PermutationDepReduction2.ab");
	}
	
	
} // LowerDependencesTest
