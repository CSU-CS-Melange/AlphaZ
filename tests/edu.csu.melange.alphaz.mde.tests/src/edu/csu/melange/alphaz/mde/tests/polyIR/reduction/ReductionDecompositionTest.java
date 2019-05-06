package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.reduction.PermutationCaseReduce;
import org.polymodel.polyhedralIR.transformation.reduction.ReductionDecomposition;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class ReductionDecompositionTest {
	
	@Test(timeout=10000) // no more than 10s
	public void test() throws IOException{
		//ReductionDecomposition("DEx", "X", "(j->)", "(i,j->j)"); to try
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SRexamples/DecomposeExample.ab");
		
		int systemNum = 0;
		AffineSystem system =  program.getSystems().get(systemNum);
		System.out.println(PolyhedralIRToAlphabets.toString(system));
		ReductionDecomposition.transform((ReduceExpression)((StandardEquation) system.getEquations().get(0)).getExpression(), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(j->)"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j->j)"));
		PermutationCaseReduce.caseReduce(system);
		System.out.println(PolyhedralIRToAlphabets.toString(system));

//		int systemNum = 0;
//		for (AffineSystem system : program.getSystems()) {
//			systemNum++;
//			System.out.println("CaseReduce Test" + (systemNum));
//			
//			System.out.println(PolyhedralIRToAlphabets.toString(system));
//			PermutationCaseReduce.caseReduce(system);
//			System.out.println(PolyhedralIRToAlphabets.toString(system));
//			
//		}
//		System.out.println("Sending program to Corequation for printing and validity analysis.");
//		State.connect("alphabets.corequations.com");
//		
//		ProgramProxy pproxy = PolyhedralIRToAlphaZAST.convert(program);
//		System.out.println(pproxy.aShow());
	}

}
