package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import org.junit.Assert;
import org.junit.Test;
import org.polymodel.polyhedralIR.Program;

/*
 * The bug was reported by Harini.
 */

public class ReductionOneDimensionArrayNotation {

//	/**
//	 * @param args
//	 * @throws IOException 
//	 */
//	public static void main(String[] args) throws IOException {
//		test("alphabets/bug-30092014/ReductionOneDimArrayNotation.ab", "oneDim");
//	}
	
	@Test(timeout=10000) // no more than 10s 
	public void test() {
		test("alphabets/bug-30092014/ReductionOneDimArrayNotation.ab", "oneDim");
	}
	
	private static void test(String filename, String system) {

		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		Assert.assertNotNull("The program object is null.", program);
	}
}
