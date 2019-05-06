package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.util.AShow;

public class InlineTest {
	
	private static void testInline(String filename, String systemName, String targetEq, String substEq)throws IOException{
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);

		StandardEquation tEq = program.getSystem(systemName).getEquation(targetEq);
		StandardEquation sEq  = program.getSystem(systemName).getEquation(substEq);
		AffineSystem system = program.getSystem(systemName);
		System.out.println(AShow.toString(program.getSystem(systemName)));
		Inline.transform(tEq, sEq, true);
		//Normalize.normalize(program);
		System.out.println(AShow.toString(program.getSystem(systemName)));
		
	}
	
	private static void test(String filename, String systemName, String targetEq, String substEq, int num) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);

			StandardEquation tEq = program.getSystem(systemName).getEquation(targetEq);
			StandardEquation sEq  = program.getSystem(systemName).getEquation(substEq);

			System.out.println("Substitute Test");
	//		System.out.println(AShow.toSimplifiedString(program.getSystem(systemName)));
//			System.out.println(program.getSystem(systemName));
			AffineSystem system = program.getSystem(systemName);
			System.out.println(AShow.toString(program.getSystem(systemName)));
			Inline.transform(tEq, sEq, num, true);
//			Normalize.normalize(program);
			System.out.println(AShow.toString(program.getSystem(systemName)));
			
	}
	
	private static void testInlineAll(String filename, String systemName, String substEq) throws IOException{
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem system = program.getSystem(systemName);
			
			System.out.println(AShow.toString(system));
			StandardEquation sEq = system.getEquation(substEq);
			//System.out.println("Test for inlineAll do not force substitution with self dependence");
			//Inline.transformAll(system, sEq, false);
			//System.out.println(AShow.toString(system));
			System.out.println("Test for inlineAll force to substitute all once");
			Inline.transformAll(system, sEq, true);
			System.out.println(AShow.toString(system));
		
	}
	
	@Test
	public void main () throws IOException {
		testInline("testcases/matrix_product/matrix_product.ab", "matrix_product", "C", "temp_C");
		test("testcases/fibonacci/fibonacci.ab", "fibonacci", "V", "V", 2);
		test("alphabets/NormalizeExamples/Fib.ab", "Fib", "fib", "fib", 3);
		testInlineAll("testcases/fibonacci/fibonacci.ab", "fibonacci", "V");
		testInline("testcases/fibonacci/fibonacci.ab", "fibonacci", "V", "V");
	}
}
