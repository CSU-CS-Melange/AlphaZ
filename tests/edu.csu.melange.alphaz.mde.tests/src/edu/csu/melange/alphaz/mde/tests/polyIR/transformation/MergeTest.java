package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.transformation.Merge;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.util.AShow;

public class MergeTest {
	
	private static void test(String filename, String systemName, String targetVar1, String targetVar2) throws IOException {

			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem system = program.getSystem(systemName);
			VariableDeclaration var1 = system.getVariableDeclaration(targetVar1);
			VariableDeclaration var2 = system.getVariableDeclaration(targetVar2);

			System.out.println("*** Merge Test");
			System.out.println(AShow.toString(program.getSystem(systemName)));
			
			Merge.transform(system, var1, var2);
			Normalize.normalize(program);
			
			System.out.println();
			System.out.println(AShow.toString(program.getSystem(systemName)));
			
	}
	
	
	@Test
	public void testMerge() throws IOException {
		test("alphabets/others/MergeTest.ab", "MergeTest", "loc1", "loc2");
	}
	
} // MergeTest
