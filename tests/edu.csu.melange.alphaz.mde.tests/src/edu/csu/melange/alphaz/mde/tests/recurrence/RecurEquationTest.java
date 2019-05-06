package edu.csu.melange.alphaz.mde.tests.recurrence;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.recurrence.ScanDetection;
import org.polymodel.polyhedralIR.recurrence.ScanInformations;

public class RecurEquationTest {
	
	@Ignore("Input .ab is not available") @Test
	public void testCubeLexiScan()  {
		test("alphabets/RecurEquationExamples/cubeLexiScan.ab", "cubeLexiScan");
	}
	
	@Ignore("Input .ab is not available") @Test
	public void testPyramid()  {
		test("alphabets/RecurEquationExamples/pyramid.ab", "pyramidLexiScan");
	}
	
	@Ignore("Input .ab is not available") @Test
	public void testTriLexiScan()  {
		test("alphabets/RecurEquationExamples/triLexiScan.ab", "triLexiScan");
	}
	

	@Test
	public void testLexiScan()  {
		test("alphabets/LexiScan.ab", "LexiScan");
	}
	

	@Test
	public void testLexiScanMultiRecur()  {
		test("alphabets/LexiScanMultiRecur.ab", "LexiScan");
	}

	@Test
	public void testTwoRecur()  {
		test("alphabets/RecurEquationExamples/twoRecur.ab", "TwoRecur");
	}
	
	@Test
	public void testMutalDep()  {
		test("alphabets/RecurEquationExamples/mutalDep.ab", "MutalDep");
	}
	
	@Test
	public void testHMM()  {
		test("alphabets/RecurEquationExamples/hmm.ab", "HMM");
	}
	
	private static void test(String programName, String systemName) {
		//try{
			Program program = alphaz.mde.Basic.ReadAlphabets(programName);
			//System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(program));
			System.out.println(UniquenessAndCompletenessCheck.validate(program));
			AffineSystem system = program.getSystem(systemName);
			
			AffineSystem system_copy = EcoreUtil.copy(system);
			//List<ScanInformation> scan_info = ScanDetection.scanDetection(system_copy);
			List<ScanInformations> scan_info = ScanDetection.scanDetection(system_copy);
		/*}catch(IOException e){
			e.printStackTrace();
		}*/
		
	}

}
