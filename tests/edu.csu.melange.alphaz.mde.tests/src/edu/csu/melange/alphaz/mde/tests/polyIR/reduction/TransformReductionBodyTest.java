package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.reduction.TransformReductionBody;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class TransformReductionBodyTest {
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		test("alphabets/SRexamples/TRBExample.ab", "TRBEx", "0,0,0", "(i,j->i,i+j)");
		test("alphabets/SRexamples/TRBExample.ab", "TRBEx", "0,1,0", "(i,j->j,i)");		
	}
	
	public static void test(String filename, String system, String nodeID, String Tstr) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		Expression expr = ExpressionFinder.getExpression(program, nodeID);
		
		ParameterDomain param;
		if (expr.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
		AffineFunction T = PolyhedralIRUtility.parseAffineFunction(param, Tstr);
		TransformReductionBody.apply((ReduceExpression)expr, T);
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
		Normalize.normalize(program);
		System.out.println(AShow.toSimplifiedString(program.getSystem(system)));
	}
}
