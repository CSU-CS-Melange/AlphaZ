package edu.csu.melange.alphaz.mde.tests.core;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.PrintAST;

public class PolyhedralIRtoAlphabetTest {
	
	static boolean aff = false;
	
	private void DoubleTranslation_test(String file) throws IOException {
		System.out.println("*** Test for the program : " + file);
		
		// Back...
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		if (aff)
			System.out.println(PrintAST.print(program));
		
		// ... and forth
		String alph = PolyhedralIRToAlphabets.toString(program);
		System.out.println(alph);
		System.out.println();
		
	}

	@Test
	public void testDoubleTranslation() throws IOException {
		DoubleTranslation_test("testcases/matrix_product/matrix_product.ab");
		
		DoubleTranslation_test("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/ScanReduce_SubSyst.ab");
	}
	
	
}
