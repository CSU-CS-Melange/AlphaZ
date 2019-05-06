package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.reduction.SplitReductionBody;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class SplitReductionBodyTest {
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		test("alphabets/SRexamples/SRBExample.ab", "SRBEx", "0,0,0", "{i,j,k|2k>=N}");
	}
	
	private static void test(String filename, String system, String nodeID, String domStr) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		Expression expr = ExpressionFinder.getExpression(program, nodeID);
		
		ParameterDomain param;
		if (expr.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
		Domain newDom = PolyhedralIRUtility.parseDomain(param, domStr);
		SplitReductionBody.apply((ReduceExpression)expr, newDom);
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
	}

}
