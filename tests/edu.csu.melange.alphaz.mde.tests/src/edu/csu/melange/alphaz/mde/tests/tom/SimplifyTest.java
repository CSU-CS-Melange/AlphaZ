package edu.csu.melange.alphaz.mde.tests.tom;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.Simplify;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class SimplifyTest {
	
	@Test
	public void test() throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/simplify_test.ab");
//		PolyhedralIRReader.saveAsXML(program, "alphabets/simplify_test.poly");
//		program = PolyhedralIRReader.loadModel("alphabets/simplify_test.poly");
		
		Simplify.simplify(program);
		
		System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(program));
	}
	
}
