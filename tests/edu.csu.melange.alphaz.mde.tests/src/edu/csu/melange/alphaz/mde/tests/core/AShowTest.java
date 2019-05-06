package edu.csu.melange.alphaz.mde.tests.core;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.util.AShow;

public class AShowTest {
	

	//@Test
	//public void testSobel() throws IOException {
		// TODO scripts/sobel.ab does not exist anymore
		//parseAndPrint("scripts/sobel.ab");
	//}
	
	@Test
	public void testMatrixProduct() throws IOException {
		parseAndPrint("testcases/matrix_product/matrix_product.ab");
	}
	
	@Test
	public void testNormalizeExCaseExpr() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/caseExp.ab");
	}
	
	@Test
	public void testNormalizeExFib() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/Fib.ab");
	}
	
	@Test
	public void testNormalizeExFib2() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/Fib2.ab");
	}
	
	@Test
	public void testNormalizeExIdentity() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/identityfunc.ab");
	}
	
	@Test
	public void testNormalizeExIdentity2() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/identityfunc2.ab");
	}

	@Test
	public void testNormalizeExIfExpr() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/IfExpTest.ab");
	}
	

	@Test
	public void testNormalizeExReduceExpr() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/reduceExp.ab");
	}

	@Test
	public void testNormalizeExRestrictExpr() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/restrict.ab");
	}

	@Test
	public void testNormalizeExUnaryExpr() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/unarytest.ab");
	}
	
	@Test
	public void testNormalizeExNormalize() throws IOException {
		parseAndPrint("alphabets/NormalizeExamples/normalizetest.ab");
	}
	
	@Test
	public void testSubSyst() throws IOException {
		parseAndPrint("alphabets/SubSystemExamples/square_product_SubSyst.ab");
		parseAndPrint("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		parseAndPrint("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
		parseAndPrint("alphabets/SubSystemExamples/ScanReduce_SubSyst.ab");
		parseAndPrint("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
	}
	

	@Test
	public void testGecosFIR() throws IOException {
		parseAndPrint("alphabets/gecos_out/fir_scop_0.ab");
	}
	
	
	public static void parseAndPrint(String file) throws IOException {
		System.out.println("*** Testing: " + file);
		
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		System.out.println(AShow.toSimplifiedString(program));
	}


}
