package edu.csu.melange.alphaz.mde.tests.core;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.LowerDependences;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.NormalizeVisitor;
import org.polymodel.polyhedralIR.util.AShow;

//public class NormalizeTest extends TestCase {
public class NormalizeTest{

	private static void normalizeTest(String file) {

		try {
			System.out.println("Testing : " + file);
			Program program = alphaz.mde.Basic.ReadAlphabets(file);

//			System.out.println(program);
			Normalize.normalize(program);
			//Normalize.normalize(program);
			
//			System.out.println(program);
			System.out.println(AShow.toSimplifiedString(program));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		
	}
	
	@Test(timeout=20000)
	public void testNormalize() {
		normalizeTest("alphabets/testProgram.ab");
		normalizeTest("alphabets/NormalizeExamples/Fib.ab");
		normalizeTest("alphabets/NormalizeExamples/Fib2.ab");
		normalizeTest("alphabets/NormalizeExamples/identityfunc.ab");
		normalizeTest("alphabets/NormalizeExamples/identityfunc2.ab");
		normalizeTest("alphabets/NormalizeExamples/reduceExp.ab");			// system not valid, but works
		normalizeTest("alphabets/NormalizeExamples/unarytest.ab");
		normalizeTest("alphabets/NormalizeExamples/ada.ab");
		normalizeTest("alphabets/NormalizeExamples/normalizeVisitorTest.ab");
		
		// Invalid
//		normalizeTest("alphabets/NormalizeExamples/caseExp.ab"); //invalid
//		normalizeTest("alphabets/NormalizeExamples/IfExpTest.ab"); //invalid
//		normalizeTest("alphabets/NormalizeExamples/normalizetest.ab"); //invalid
//		normalizeTest("alphabets/NormalizeExamples/restrict.ab"); //invalid
	}
	
	
	/* ----------------------------------------------------------------------- */
	private static void normalizeVisitorTest(String file) {
		System.out.println("Testing : " + file);
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		
		if (program==null)
			throw new RuntimeException("Program was not parsed");
		
		NormalizeVisitor.normalize(program);
		
//		System.out.println(program);
		System.out.println(AShow.toSimplifiedString(program));
	
	}
	
	@Test
	public void testVisitor() {
		// Works
		normalizeVisitorTest("alphabets/testProgram.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/Fib.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/Fib2.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/identityfunc.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/identityfunc2.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/reduceExp.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/unarytest.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/ada.ab");
		normalizeVisitorTest("alphabets/NormalizeExamples/normalizeVisitorTest.ab");
		
		// Time taken should be faster than old implementation
	}
	

	/* ----------------------------------------------------------------------- */
	private static void lowerDependenceTest(String file) {
		System.out.println("Testing : " + file);
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		if (program==null)
			throw new RuntimeException("Program was not parsed");
		
		AffineSystem syst = program.getSystems().get(0);
		LowerDependences.lowerDependences(syst);
		
//		System.out.println(program);
		System.out.println(AShow.toString(syst));
	
	}
	
	@Test
	public void testLowerDependence() {
		lowerDependenceTest("alphabets/NormalizeExamples/Osp_normalize.ab");
		// TODO: does not work, and no idea why the rule is never taken... :/
	}
	
	/* ----------------------------------------------------------------------- */
	private static void lowerDependenceVisitorTest(String file) {
		System.out.println("Testing : " + file);
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		if (program==null)
			throw new RuntimeException("Program was not parsed");
		
		AffineSystem syst = program.getSystems().get(0);
		NormalizeVisitor.lowerDependence(syst);
		
//		System.out.println(program);
		System.out.println(AShow.toString(syst));
	
	}
	
	@Test
	public void testLowerDependenceVisitor() {
		lowerDependenceVisitorTest("alphabets/NormalizeExamples/Osp_normalize.ab");
	}
	
	
}
