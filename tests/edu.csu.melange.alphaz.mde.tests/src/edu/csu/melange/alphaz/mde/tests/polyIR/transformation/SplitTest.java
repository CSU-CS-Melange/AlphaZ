package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Split;
import org.polymodel.polyhedralIR.util.AShow;

public class SplitTest {
	
	private static void test(String filename, String systemName, String targetVar, String newDomain) throws IOException {

			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem system = program.getSystem(systemName);
			VariableDeclaration var = system.getVariableDeclaration(targetVar);
			Domain newdom = PolyhedralIRUtility.parseDomain(system.getParameters(), newDomain);

			System.out.println("Split Test");
//			System.out.println(AShow.toSimplifiedString(program.getSystem(systemName)));
//			System.out.println(program.getSystem(systemName));
			System.out.println(AShow.toString(program.getSystem(systemName)));
			Split.transform(system, var, newdom);
			Normalize.normalize(program);
			System.out.println(AShow.toString(program.getSystem(systemName)));
			System.out.println(AShow.toSimplifiedString(program.getSystem(systemName)));
			
	}
	
	@Test
	public void test() throws IOException {
		test("testcases/matrix_product/matrix_product.ab", "matrix_product", "temp_C", "{i,j,k|k==0}");
	}
}
