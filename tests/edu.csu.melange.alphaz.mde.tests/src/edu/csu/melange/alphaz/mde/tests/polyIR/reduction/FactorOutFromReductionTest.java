package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import org.junit.Assert;
import org.junit.Test;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.reduction.FactorOutFromReduction;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.ExpressionFinder;
import org.polymodel.polyhedralIR.util.PrintAST;

public class FactorOutFromReductionTest {
	
	@Test(timeout=10000) // no more than 10s
	public void test1() {
		String result = test("alphabets/SRexamples/FactorizeExample.ab", 
				"FactorizeExample", "0,0,0,0,0");
		String expected = "affine FactorizeExample {N|N>=1}\n"
						+ "input\n"
						+ "int A {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "int B {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "output\n"
						+ "int X {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "local\n"
						+ "let\n"
						+ "X[i] = (reduce(max, (i,j->i), B[j]) + A);\n"
						+".";
		Assert.assertTrue("The generated program is not equivalant to the "
				+ "expected program. Please note that equivalnce here means "
				+ "simple string comparison.\n result: \n" + result 
				+ "\n expected: \n" + expected, result.equals(expected));
	}
	
	@Test(timeout=10000) // no more than 10s 
	public void test2() {
		String result = test("alphabets/SRexamples/FactorizeExample.ab", 
				"FactorizeExample2", "1,0,0,0,0,1");
		String expected = "affine FactorizeExample2 {N|N>=1}\n"
						+ "input\n"
						+ "int A {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "int B {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "int C {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "output\n"
						+ "int X {i|i>=0 && N>=i+1 && N>=1};\n"
						+ "local\n"
						+ "let\n"
						+ "X[i] = (reduce(max, (i,j->i), (C[j] + B[j])) + A);\n"
						+ ".";
		Assert.assertTrue("The generated program is not equivalant to the "
				+ "expected program. Please note that equivalnce here means "
				+ "simple string comparison.\n result: \n" + result 
				+ "\n expected: \n" + expected, result.equals(expected));
	}
	
	
	@Test(expected=RuntimeException.class) // no more than 10s
	public void test3() {
		test("alphabets/SRexamples/FactorizeExample.ab", "FactorizeExample3", 
				"2,0,0,0,1,0"); 
	}
	
	private static String test(String filename, String systemName, String targetExprID) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);

		Expression expr = ExpressionFinder.getExpression(program, targetExprID);

		System.out.println(AShow.toString(program.getSystem(systemName)));
		System.out.println(PrintAST.print(program));
		FactorOutFromReduction.apply(expr);
		Normalize.normalize(program);
		System.out.println(AShow.toString(program.getSystem(systemName)));
		return AShow.toString(program.getSystem(systemName));
	}
}
