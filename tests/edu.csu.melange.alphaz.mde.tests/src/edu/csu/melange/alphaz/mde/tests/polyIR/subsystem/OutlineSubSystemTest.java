package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.OutlineSubSystem;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;

public class OutlineSubSystemTest {
	
	// ---- Auxillary methods - Test Outline V1
	private static Program parseAndOutline(String filename, String systemName, int[] stEq, int[] useEq) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			return parseAndOutline(program, systemName, stEq, useEq);
	}
	
	private static Program parseAndOutline(Program program, String systemName, int[] stEqTab, int[] useEqTab) {
			AffineSystem syst = program.getSystem(systemName);
			List<Equation> lEq = new BasicEList<Equation>();
			for (int k=0; k<stEqTab.length; k++)
				lEq.add(syst.getEquations().get(stEqTab[k]));
			for (int k=0; k<useEqTab.length; k++)
				lEq.add(syst.getUseEquations().get(useEqTab[k]));
			
			
			/*System.out.println("Original AST : ");
			System.out.println(PrintAST.print(program));
			System.out.println();//*/
			
			System.out.println("Equation outlined : ");
			for (Equation eq: lEq)
				System.out.println("\t" + PolyhedralIRToAlphabets.toString(eq));
			System.out.println();
			
			OutlineSubSystem.outline(program, syst, lEq);
			
			System.out.println(" * Result = ");
			System.out.println(PolyhedralIRToAlphabets.toString(program));
			//System.out.println(PrintAST.print(program));
			
			return program;
	}
	
	// ---- Auxillary methods - Test Outline V1.5
	
	private static Program parseAndOutlineV1_5(String filename, String systemName, int[] stEqTab, int[] useEqTab, List<String> lexprStr, List<String> freeIndsExpr) throws IOException {
			Program program = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem syst = program.getSystem(systemName);
			List<Equation> lEq = new BasicEList<Equation>();
			for (int k=0; k<stEqTab.length; k++)
				lEq.add(syst.getEquations().get(stEqTab[k]));
			for (int k=0; k<useEqTab.length; k++)
				lEq.add(syst.getUseEquations().get(useEqTab[k]));
			
			/*System.out.println("Original AST : ");
			System.out.println(PrintAST.print(program));
			System.out.println();//*/
			List<Expression> lExpr = new BasicEList<Expression>();
			for (int k=0; k<lexprStr.size(); k++) {
				String strExpr = lexprStr.get(k);
				String freeIndsList = freeIndsExpr.get(k);
				String[] freeIndsTab = freeIndsList.split("\\s*,\\s*");
				List<String> freeInds = new BasicEList<String>();
				for (int l=0; l<freeIndsTab.length; l++)
					freeInds.add(freeIndsTab[l]);
				lExpr.add(AlphabetsToPolyhedralIR.readExpression(strExpr, syst, freeInds));
			}
			
			// Pretty-printing
			System.out.println("Equation outlined : ");
			for (Equation eq: lEq)
				System.out.println("\t" + PolyhedralIRToAlphabets.toString(eq));
			System.out.println();
			
			OutlineSubSystem.outline(program, syst, lEq, lExpr);
			
			System.out.println(" * Result = ");
			System.out.println(PolyhedralIRToAlphabets.toString(program));
			//System.out.println(PrintAST.print(program));
			
			return program;
	}
	
	
	// ------ Tests
	
	@Test
	public void test_V1() throws IOException {
		//*
		int[] stEq1 = {1};
		int[] useEq1 = {0,1};
		parseAndOutline("alphabets/SubSystemExamples/OutliningExamples/outlineNoExtensionDomain.ab",
				"outlineNoExtensionDomain", stEq1, useEq1);//*/
		
		/*
		int[] stEq2 = {1};
		int[] useEq2 = {};
		parseAndOutline("alphabets/SubSystemExamples/OutliningExamples/outlineNoExtensionDomain.ab",
				"outlineNoExtensionDomain", stEq2, useEq2);//*/
	}
	
	@Test
	public void test_V1_5() throws IOException {
		int[] stEq1 = {0,2};
		int[] useEq1 = {0};
		List<String> lexprStr = new BasicEList<String>();
		List<String> freeIndsExpr = new BasicEList<String>();
		lexprStr.add("(i,j->j)@inA");
		freeIndsExpr.add("i,j");
		parseAndOutlineV1_5("alphabets/SubSystemExamples/OutliningExamples/outlineNoExtensionDomain.ab",
				"outlineNoExtensionDomain", stEq1, useEq1, lexprStr, freeIndsExpr);
		
	}
	
	
	
} // OutlineSubSystemTest
