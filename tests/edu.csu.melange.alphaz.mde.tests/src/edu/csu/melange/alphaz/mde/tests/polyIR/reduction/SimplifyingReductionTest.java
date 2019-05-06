package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.reduction.SimplifyingReduction;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class SimplifyingReductionTest {


	@Test	
	public void testSRExample1() throws IOException {
		test("alphabets/SRexamples/SRExample.ab", "SREx", "(i,j,k->i-1,j,k)", "0,0,0");
	}

	@Test
	public void testSRExample2() throws IOException {
		test("alphabets/SRexamples/SRExample.ab", "SREx2", "(i,j->i+1,j)", "2,0,0");
	}

	@Test
	public void testSRExample3() throws IOException {
		test("alphabets/SRexamples/SRExample.ab", "SREx3", "(i,j,k->i-1,j,k)", "3,0,0");
	}

	@Test
	public void testUnafold() throws IOException {			// TODO: bug !!!
		test("alphabets/SRexamples/unafold_beforeSR.ab", "fillMatrices1_unafold", "(i,j,ip,jp->i+1,j-1,ip,jp)", "0,10,0");
	}
	
	public void test(String filename, String systemName, String reuse, String nodeId) throws IOException {
		SimplifyingReduction.DEBUG = true;
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		AffineSystem system = program.getSystem(systemName);
		System.out.println(UniquenessAndCompletenessCheck.validate(system).toString(VERBOSITY.MAX));
		System.out.println(AShow.toSimplifiedString(system));

		SimplifyingReduction.simplify((ReduceExpression)ExpressionFinder.getExpression(program, nodeId), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), reuse));
		System.out.println(UniquenessAndCompletenessCheck.validate(system).toString(VERBOSITY.MAX));
//		Normalize.normalize(system);
		System.out.println(AShow.toSimplifiedString(system));
	}
	
}
