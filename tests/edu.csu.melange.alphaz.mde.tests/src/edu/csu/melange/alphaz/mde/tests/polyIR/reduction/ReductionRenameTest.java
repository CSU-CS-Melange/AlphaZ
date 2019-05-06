package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import org.junit.Assert;
import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;

/*
 * The bug was reported by Tian.
 */

public class ReductionRenameTest {

//	/**
//	 * @param args
//	 * @throws IOException 
//	 */
//	public static void main(String[] args) throws IOException {
//		test("alphabets/bug-28102015/reduction_bug.ab", "fillMatrices1_unafold");
//	}
	
	@Test(timeout=10000) // no more than 10s 
	public void test() {
		test("alphabets/bug-28102015/reduction_bug.ab", "fillMatrices1_unafold");
	}
	
	private static void test(String filename, String system) {

		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		WriteC.generate(program.getSystem(system), CodeGenOptions.writeCDefault(), "alphabets/bug-28102015/fillMatrices1_unafold/");
		
		// This test results in a JVM crash. which will stop running further tests.
		// If this tests passes, that means we have reach this point, therefore the assertTrues
		Assert.assertTrue(true);
	}
}
