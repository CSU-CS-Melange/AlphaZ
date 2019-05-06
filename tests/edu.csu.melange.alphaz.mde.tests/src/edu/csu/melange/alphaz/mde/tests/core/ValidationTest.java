package edu.csu.melange.alphaz.mde.tests.core;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;

import edu.csu.melange.alphaz.mde.tests.TESTCASE;


public class ValidationTest {
	
	@Test
	public void TestTestcases() throws IOException {
		for (TESTCASE testcase : TESTCASE.values()) {
			test(testcase.getFilePath(), true);
		}
	}

	@Test
	public void TestValidationExamples() throws IOException {
//		test("alphabets/ValidationExamples/symmat.ab");			// File not found
		test("alphabets/ValidationExamples/Cholesky_2.ab");
		test("alphabets/ValidationExamples/Cholesky.ab");
		test("alphabets/ValidationExamples/InputVariableDefined.ab");
		test("alphabets/ValidationExamples/UnusedVariableExample.ab");
		test("alphabets/ValidationExamples/OneDTwoD1.ab");
		test("alphabets/ValidationExamples/OneDTwoD2.ab");
		test("alphabets/ValidationExamples/OneDTwoD3.ab");
		test("alphabets/ValidationExamples/OneDTwoD4.ab");
		test("alphabets/ValidationExamples/OneDTwoD5.ab");
		
	}
	
	@Test
	public void TestValidationSubSystemExamples() throws IOException {
		
		// Valid tests
		test("alphabets/SubSystemExamples/square_product_SubSyst.ab");
//		test("alphabets/SubSystemExamples/ScanReduce_SubSyst.ab"); // should have a warning for "dummy" (not used)
		test("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
		test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
		test("alphabets/SubSystemExamples/Sum_SubSyst.ab");
		
		// Note (for ScanReduce_Subsyst): modify the example when "_" will be introduced in the syntax.
		
		// Validator tests
		test("alphabets/ValidationExamples/ValidationSubSystems/cyclicCall_SubSyst.ab");
		test("alphabets/ValidationExamples/ValidationSubSystems/BadHierMatProduct_SubSyst.ab", false);	// Domain def error in the last system
	}
	
	@Test
	public void TestNormalizeExamples() throws IOException {
		// Valid
		test("alphabets/NormalizeExamples/caseExp.ab");
		test("alphabets/NormalizeExamples/Fib.ab");
		test("alphabets/NormalizeExamples/Fib2.ab");
		test("alphabets/NormalizeExamples/IfExpTest.ab");
		test("alphabets/NormalizeExamples/restrict.ab");
		test("alphabets/NormalizeExamples/unarytest.ab");
		
		// Invalid
		test("alphabets/NormalizeExamples/identityfunc.ab", false);
		test("alphabets/NormalizeExamples/identityfunc2.ab", false);
		test("alphabets/NormalizeExamples/normalizetest.ab", false);
		test("alphabets/NormalizeExamples/reduceExp.ab", false);
	}
	
//	test("alphabets/gecos_out/toto_scop0.ab");
//	test("alphabets/gecos_out/gauss_C99_I32_scop0.ab");
//	test("alphabets/gecos_out/matrix_product_scop0.ab");
//	test("alphabets/OneDimSimple.ab");
	
	public static void test(String filename) throws IOException {
		test(filename, true);
	}
		
	private static void test(String filename, boolean expected) throws IOException {
		System.out.println("Testing:" + filename);
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);	
		ValidatorOutput output = UniquenessAndCompletenessCheck.validate(program);
		System.out.println(output.toString(VERBOSITY.MAX));
		//Please don't use Java assert as you explicitly need to enable them in java
		// But use JUnit assert instead. i.e. the following assert does not get executed by default
		// and 3 out of 4 test cases actually fails but does not get reported
		//assert(output.isValid() == expected);
		// using JUnit assert
		Assert.assertEquals(expected, output.isValid());
		
		
//		Normalize.normalize(program);
//		output = UniquenessAndCompletenessCheck.validate(program);
//		System.out.println(output.toString(verbosity));
	}
	
}
