package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.transformation.reduction.NormalizeReduction;

public class NormalizeReductionTest {
	
	@Test(timeout=10000) // no more than 10s
	public void test() throws IOException{
		test("alphabets/SRexamples/NRExample.ab");
	}
	
	private static void test(String filename) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		UniquenessAndCompletenessCheck.validate(program);
		System.out.println(program);
		NormalizeReduction.apply(program);
//		NormalizeReduction.apply((ReduceExpression)ExpressionFinder.getExpression(program, "(0,0,0,1)"));
		System.out.println(program);
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString(VERBOSITY.MAX));
//		System.out.println(PrintAST.print(program));
	}
}
