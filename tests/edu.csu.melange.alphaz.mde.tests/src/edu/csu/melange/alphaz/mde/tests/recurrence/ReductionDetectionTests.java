package edu.csu.melange.alphaz.mde.tests.recurrence;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.recurrence.bis.ReductionDetection;

public class ReductionDetectionTests {


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
		ReductionDetection.DEBUG = true;
		
		ReductionDetection.detect(system_copy);
		
 	}
	
	

}
