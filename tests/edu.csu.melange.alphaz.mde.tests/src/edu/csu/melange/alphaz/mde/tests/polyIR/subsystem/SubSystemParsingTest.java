package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.PrintAST;

/**
 * Class that regroups the following tests for subsystem:
 *   - Parsing of subsystem
 *   - Pretty printing (PrintAST + Ashow + PolyhedralIRtoAlphabets)
 * 
 * @author Guillaume
 */
public class SubSystemParsingTest {
	
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
	
	private void printASTtest(String file) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		System.out.println(PrintAST.print(program));
	}
	
	private void AShowTest(String file) throws IOException {
		System.out.println("*** Testing of : " + file);
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		System.out.println(AShow.toSimplifiedString(program));
	}

	/* ---------------------------------------------  */
	
	@Test
	public void testDoubleTranslation() throws IOException {
		DoubleTranslation_test("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		DoubleTranslation_test("alphabets/SubSystemExamples/ScanReduce_SubSyst.ab");
	}
	
	@Test
	public void testPrintAST_SubSyst() throws IOException {
		printASTtest("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
	}
	
	@Test
	public void testAShow_SubSyst() throws IOException {
//		AShowTest("alphabets/GPUWithSubSystems/Matrix_product.ab");			// TODO: file do not exist
		AShowTest("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		AShowTest("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		AShowTest("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
		AShowTest("alphabets/SubSystemExamples/ScanReduce_SubSyst.ab");
		AShowTest("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
	}
	
} // SubSystemParsingTest
