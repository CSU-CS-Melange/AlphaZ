package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.transformation.SplitUnion;

public class SplitUnionTest {
	
	@Test
	public void test() throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/others/UnionTest.ab");
		SplitUnion.split(((StandardEquation) program.getSystems().get(0).getEquations().get(0)).getExpression());
		System.out.println(program);
	}
}
