package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.ExtractMultiArgExpressions;

public class ExtractMultiArgExpressionTest {

	@Test
	public void testIterativeGaussian() {
		// test("alphabets/RecurEquationExamples/IterativeGaussian.ab");   // TODO: no file here
	}
	
	@Test
	public void testSobel() {
		test("alphabets/ConvolutionExamples/sobel.normalized.ab");
	}
	
	private static void test(String filename) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(filename);

//		alphaz.mde.Basic.AShow(prog);
		
//		InlineConstants.apply(prog.getSystems().get(0));
//		Normalize.normalize(prog);
		
		ExtractMultiArgExpressions.apply(prog);

		alphaz.mde.Basic.AShow(prog);
	}
}
