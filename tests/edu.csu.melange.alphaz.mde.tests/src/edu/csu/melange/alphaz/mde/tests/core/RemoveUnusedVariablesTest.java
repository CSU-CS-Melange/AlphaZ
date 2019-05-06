package edu.csu.melange.alphaz.mde.tests.core;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables;

public class RemoveUnusedVariablesTest {
	
	public static void testUnusedVariables(String filename) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		System.out.println(RemoveUnusedVariables.apply(program));
		System.out.println(program);
	}
	
	@Test
	public void test() {
		testUnusedVariables("testcases/matrix_product/matrix_product.ab");
		testUnusedVariables("alphabets/ValidationExamples/UnusedVariableExample.ab");
	}
	
}
