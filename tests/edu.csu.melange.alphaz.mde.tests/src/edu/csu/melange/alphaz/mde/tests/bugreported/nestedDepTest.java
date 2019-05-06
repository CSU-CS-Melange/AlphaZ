package edu.csu.melange.alphaz.mde.tests.bugreported;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;

public class nestedDepTest {
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		Program program1 = alphaz.mde.Basic.ReadAlphabets("alphabets/bug-16062013/bug.ab");
		System.out.println(program1);
		Program program2 = alphaz.mde.Basic.ReadAlphabets("alphabets/bug-16062013/AssertNoNewbug.ab");
		System.out.println(program2);

	}
}
