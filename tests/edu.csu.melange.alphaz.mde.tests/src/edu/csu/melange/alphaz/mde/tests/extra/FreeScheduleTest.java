package edu.csu.melange.alphaz.mde.tests.extra;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.transformation.FreeScheduler;
import org.polymodel.polyhedralIR.util.AShow;

public class FreeScheduleTest {
	
	@Test
	public void testFreeScheduler() throws IOException  {
		freeSchedulerTest("testcases/matrix_product/matrix_product.ab");
	}
	
	@Test
	public void testFreeSchedulerSubSyst() throws IOException {
		freeSchedulerTest("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
	}
	
	
	private void freeSchedulerTest(String file) throws IOException {
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		Program freeSch = FreeScheduler.FreeScheduler(prog);
		
		System.out.println(AShow.toSimplifiedString(prog));
		System.out.println(AShow.toString(freeSch));
		
		System.out.println(UniquenessAndCompletenessCheck.validate(prog));
		System.out.println(UniquenessAndCompletenessCheck.validate(freeSch));
	}


}
