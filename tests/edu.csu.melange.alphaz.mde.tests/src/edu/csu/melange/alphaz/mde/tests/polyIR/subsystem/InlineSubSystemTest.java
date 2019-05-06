package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.transformation.InlineSubSystem;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class InlineSubSystemTest {
	
	// Warning: first index of a list is 0
	private static Program parseAndInline(String filename, String systemName, int num) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			return parseAndInline(program, systemName, num);
	}
	
	private static Program parseAndInline(Program program, String systemName, int num) {
			UseEquation uEq = program.getSystem(systemName).getUseEquations().get(num);
			
			/*System.out.println("Original AST : ");
			System.out.println(PrintAST.print(program));
			System.out.println();//*/
			
			System.out.println("UseEquation inlined : ");
			System.out.println("\t" + PolyhedralIRToAlphabets.toString(uEq));
			System.out.println();
			
			InlineSubSystem.inline(uEq);
			
			System.out.println(" * Result = ");
			System.out.println(PolyhedralIRToAlphabets.toString(program.getSystem(systemName)));
			//System.out.println(PrintAST.print(program));
			//System.out.println(UniquenessAndCompletenessCheck.validate(program));
			return program;
	}
	
	@Test(timeout=10000) // no more than 10s
	public void test () throws IOException {
		parseAndInline("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab", "mat_product", 0);
		
		Program progTemp = parseAndInline("alphabets/SubSystemExamples/Sum_SubSyst.ab", "Toy", 0);
		parseAndInline(progTemp, "Toy", 0);
		
		
	}
	
} // InlineSubSystemTest
