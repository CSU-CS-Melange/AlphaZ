package edu.csu.melange.alphaz.mde.tests.core;

import junit.framework.TestCase;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;

public class CoBTest extends TestCase {
	
	@Test
	public void testCoB() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("testcases/matrix_product/matrix_product.ab");
		String systemName = "matrix_product";
		AffineSystem system = prog.getSystem(systemName);
		System.out.println(system);
		alphaz.mde.Transformation.CoB(prog, systemName, "temp_C", "(i,j,k->i,j,k+1)");
		System.out.println(system);
	}
	
	@Test(expected=RuntimeException.class)
	public void testCoBSubSystem() {
		try {
			Program prog = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Sum_SubSyst.ab");
			String systemName = "Toy";
			AffineSystem system = prog.getSystem(systemName);
			System.out.println(system);
			
			alphaz.mde.Transformation.CoB(prog, systemName, "X", "(i->i-1)");
			System.out.println(system);
			
			System.out.println("FAILS!");
		} catch (RuntimeException e) {
			System.out.println("WORKS!");
		}
		
	}

}
