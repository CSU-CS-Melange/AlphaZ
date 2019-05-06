package edu.csu.melange.alphaz.mde.tests.core;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.util.PrintAST;

public class PrintAST_Test {

	private void printASTtest(String file) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(file);
			System.out.println(PrintAST.print(program));
	}

	@Test
	public void testPrintAST() throws IOException {
		printASTtest("testcases/matrix_product/matrix_product.ab");
		printASTtest("alphabets/testProgram.ab");
		printASTtest("alphabets/NormalizeExamples/Fib.ab");
		printASTtest("alphabets/NormalizeExamples/Fib2.ab");
		printASTtest("alphabets/NormalizeExamples/identityfunc.ab");
		printASTtest("alphabets/NormalizeExamples/identityfunc2.ab");
		printASTtest("alphabets/NormalizeExamples/reduceExp.ab");
		printASTtest("alphabets/NormalizeExamples/unarytest.ab");
		
		// Invalid
//		printASTtest("alphabets/NormalizeExamples/caseExp.ab"); //invalid
//		printASTtest("alphabets/NormalizeExamples/IfExpTest.ab"); //invalid
//		printASTtest("alphabets/NormalizeExamples/normalizetest.ab"); //invalid
//		printASTtest("alphabets/NormalizeExamples/restrict.ab");  //invalid
	}
	
	@Test
	public void testPrintAST_SubSyst() throws IOException {
		printASTtest("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		printASTtest("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
	}
	
	
}
