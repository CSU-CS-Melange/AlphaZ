package edu.csu.melange.alphaz.mde.tests.recurrence;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.recurrence.ScanDetection;
import org.polymodel.polyhedralIR.recurrence.bis.StateVectorUpdateForm;
import org.polymodel.polyhedralIR.recurrence.ScanInformations;

public class ScanDetectionTests {

	@Test
	public void testOneRecur() {
		test("alphabets/RecurEquationExamples/oneRecur.ab", "CaseExpr");
	}
	

	@Test
	public void testTwoRecur() {
		test("alphabets/RecurEquationExamples/twoRecur.ab", "TwoRecur");
	}
	
	@Test
	public void testMulDimRecur() throws IOException {
		test("alphabets/RecurEquationExamples/MulDimRecur.ab", "MulDimRecur");
	}
	
	@Test
	public void testMutalDep() throws IOException {
		test("alphabets/RecurEquationExamples/mutalDep.ab", "MutalDep");
	}
	
	@Test
	public void testHMM() throws IOException {
		test("alphabets/RecurEquationExamples/hmm.ab", "HMM");
	}

	@Test
	public void testSobel() throws IOException {
		test("alphabets/ConvolutionExamples/sobel.normalized.ab", "sobel");
	}
	
	@Test
	public void testIterativeGaussian() throws IOException {
		test("alphabets/ConvolutionExamples/IterativeGaussian.ab", "IterativeGaussian");
	}
	
	@Test
	public void testIIR() throws IOException {
		test("alphabets/RecurEquationExamples/IIR.ab", "IIR");
	}
	
	@Test
	public void testFIR() throws IOException {
		test("alphabets/RecurEquationExamples/FIR.ab", "FIR");
	}
	
	private static void test(String filename, String systemName) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		//System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(program));
		System.out.println(UniquenessAndCompletenessCheck.validate(program));
		AffineSystem system = program.getSystem(systemName);
		
		AffineSystem system_copy = EcoreUtil.copy(system);
		//List<ScanInformation> scan_info = ScanDetection.scanDetection(system_copy);
		ScanDetection.DEBUG = true;
		org.polymodel.polyhedralIR.recurrence.bis.ScanDetection.DEBUG = true;
//		org.polymodel.polyhedralIR.recurrence.bis.MatrixFormTransformation.DEBUG = true;
//		org.polymodel.polyhedralIR.recurrence.bis.CoefficientExtractor.DEBUG = true;
		
		List<ScanInformations> scan_info = ScanDetection.scanDetection(system_copy);
		List<StateVectorUpdateForm> scanInfo = org.polymodel.polyhedralIR.recurrence.bis.ScanDetection.detect(EcoreUtil.copy(system));
 	}
}
