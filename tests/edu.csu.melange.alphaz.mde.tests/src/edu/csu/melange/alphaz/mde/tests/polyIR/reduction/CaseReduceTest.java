package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.reduction.PermutationCaseReduce;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;


public class CaseReduceTest {
	
	@Test
	public void main() {
		try {
			Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SRexamples/CRExample.ab");
			
			
//			int systemNum = 0;
//			AffineSystem system =  program.getSystems().get(systemNum);
//			System.out.println(PolyhedralIRToAlphabets.toString(system));
//			PermutationCaseReduce.caseReduce(system);
//			System.out.println(PolyhedralIRToAlphabets.toString(system));

			int systemNum = 0;
			for (AffineSystem system : program.getSystems()) {
				systemNum++;
				System.out.println("CaseReduce Test" + (systemNum));
				
				System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
				PermutationCaseReduce.caseReduce(system);
				System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
				
			}
			
//			System.out.println("Sending program to Corequation for printing and validity analysis.");
//			State.connect("alphabets.corequations.com");
//			
//			ProgramProxy pproxy = PolyhedralIRToAlphaZAST.convert(program);
			
//			System.out.println(pproxy.aShow());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			State.disconnect();
		}
	}
	
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SRexamples/CRExample.ab");
		
		
//		int systemNum = 0;
//		AffineSystem system =  program.getSystems().get(systemNum);
//		System.out.println(PolyhedralIRToAlphabets.toString(system));
//		PermutationCaseReduce.caseReduce(system);
//		System.out.println(PolyhedralIRToAlphabets.toString(system));

		int systemNum = 0;
		for (AffineSystem system : program.getSystems()) {
			systemNum++;
			System.out.println("CaseReduce Test" + (systemNum));
			
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
			PermutationCaseReduce.caseReduce(system);
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
			
		}
		
//		System.out.println("Sending program to Corequation for printing and validity analysis.");
//		State.connect("alphabets.corequations.com");
//		
//		ProgramProxy pproxy = PolyhedralIRToAlphaZAST.convert(program);
		
//		System.out.println(pproxy.aShow());
	}
}
