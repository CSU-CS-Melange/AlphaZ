package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.transformation.reduction.MergeReductions;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class MergeReductionTest {

	@Test(timeout=10000) // no more than 10s
	public void test() throws IOException{
		test("alphabets/SRexamples/MRExample.ab", "MREx", "0,0,0");
	}
	
	
	private static void test(String filename, String system, String nodeID) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		Expression expr = ExpressionFinder.getExpression(program, nodeID);
		
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
		MergeReductions.apply((BinaryExpression)expr);
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
	}
	
}
