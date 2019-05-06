package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;

public class CoBUseEquationTest {
	
	public static void test(String filename, String systemName, int numUseEq, String affFunc) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem syst = program.getSystem(systemName);
			UseEquation ueq = syst.getUseEquations().get(numUseEq);
			AffineFunction func = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), affFunc);
			
			System.out.println("** Before transformation");
			System.out.println(syst);
			
			//ChangeOfBasisUseEq.transform(syst, ueq, func);
			ChangeOfBasis.CoB(syst, ueq.getLabel(), func, true);
			Normalize.normalize(syst);
			
			System.out.println();
			System.out.println();
			System.out.println("** After transformation");
			System.out.println(syst);
	}
	
	
	@Test
	public void testCoBUseEq() throws IOException {
		test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab","mat_product",0,"(i,j->i,i+j)");
		test("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab","mat_product",0,"(i->-i, 1)");
	}
	
} // CoBUseEquationTest
