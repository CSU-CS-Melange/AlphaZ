package edu.csu.melange.alphaz.mde.tests.polyIR.analysis;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.convolution.ConvolutionSystem;
import org.polymodel.polyhedralIR.convolution.ConvolutionSystemDetection;

public class ConvolutionSystemDetectionTests {

	@Test
	public void testFIR() throws IOException {
		test("alphabets/ConvolutionExamples/FIR-multiarg.ab", "FIR", "a");
	}
	
	@Test
	public void testSobel() throws IOException {
		test("alphabets/ConvolutionExamples/sobel.normalized.ab", "sobel", "");
	}
	
	@Test
	public void testDeriche() throws IOException {
		test("alphabets/ConvolutionExamples/deriche.normalized.ab", "deriche", "a, b");
	}
	
	@Test
	public void testIterativeGaussian() throws IOException {
		test("alphabets/ConvolutionExamples/IterativeGaussian.ab", "IterativeGaussian", "a, b");
	}
	
	private static void test(String filename, String systemName, String coefs) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		//System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(program));
		System.out.println(UniquenessAndCompletenessCheck.validate(program));
		AffineSystem system = program.getSystem(systemName);
		
		ConvolutionSystemDetection.DEBUG = true;
		ConvolutionSystem cs = ConvolutionSystemDetection.detect(system, coefs);
		
		System.out.println(cs.toDotStringDetailed());
		
 	}
}
