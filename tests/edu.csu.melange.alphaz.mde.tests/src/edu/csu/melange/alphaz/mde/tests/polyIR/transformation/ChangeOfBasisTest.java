package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;

public class ChangeOfBasisTest {
	

	private void test(String filename, String systemName, String varName, String function, boolean force) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		AffineSystem system = program.getSystem(systemName);
		alphaz.mde.Analysis.CheckProgram(program);
		
		VariableDeclaration var = system.getVariableDeclaration(varName);
		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), function);
		
		System.out.println("********Program before change of basis!***********");
		System.out.println(program);
		
		//Apply the change of basis to the system 
		ChangeOfBasis.CoB(system, varName, func, force);
		
		System.out.println("********Program after change of basis!************");
		System.out.println(program);
		
	}

	@Test
	public void testNonForceCoB() throws IOException {
		try {
			test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab", "dot_product", "vect1", "(i->i+1)", false);	//test the input
			System.out.println("Failure: should have throw an error");
		} catch (RuntimeException e) {
			System.out.println("Success");
		}
		
		try {
			test("alphabets/SubSystemExamples/MMStripSub.ab", "MM", "C", "(i,j->i,i+j)", false);	//test the output
			System.out.println("Failure: should have throw an error");
		} catch (RuntimeException e) {
			System.out.println("Success");
		}
	}
	
	@Test
	public void testInputForceCoB() throws IOException{
		test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab", "dot_product", "vect1", "(i->i+1)", true);
		test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab", "dot_product", "vect1", "(i->i,1)", true);
		test("alphabets/SubSystemExamples/MMStripSub.ab", "MM", "A", "(i,j->i,i+j)", true);	
	}
	
	@Test
	public void testOutputForceCoB() throws IOException{
		test("alphabets/SubSystemExamples/MMStripSub.ab", "MM", "C", "(i,j->i,i+j)", true);	//test the output
		test("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab", "dot_product", "Res", "(->1)", true);
		test("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab", "vector_product", "Res", "(->1)", true);
	}
	
	@Test 
	public void testCoB() throws IOException{
		test("testcases/matrix_product/matrix_product.ab", "matrix_product", "temp_C","(i,j,k->i+j+k,k,j+k)", true);
	}

}
