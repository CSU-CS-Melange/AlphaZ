package edu.csu.melange.alphaz.mde.tests.polyIR;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;

public class PRDGBuilderTest extends TestCase {
	
	@Test
	public void test() throws IOException {
		PRDGbuilderTest("alphabets/OneDimSimple.ab");
		PRDGbuilderTest("testcases/matrix_product/matrix_product.ab");
		PRDGbuilderTest("testcases/matrix_product_withReduce/matrix_product_withReduce.ab");
		PRDGbuilderTest("alphabets/SubSystemExamples/Matrix_product_SubSyst.ab");
		PRDGbuilderTest("alphabets/SubSystemExamples/Fwd_dp.ab");
		PRDGbuilderTest("alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
	}
	
	
	
	
	private void PRDGbuilderTest(String file) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(file);
		
		//AlphaZPRDG rdg = new AlphaZPRDG("nested_reductions");
		for (AffineSystem system : program.getSystems()) {
			System.out.println("PRDG for " + system.getName());
			PRDG prdg = PRDGBuilder.build(system, false);
			System.out.println("NODES");
			for (PRDGNode node : prdg.getNodes()) {
				System.out.println(node);
			}
			System.out.println("EDGES");
			for (PRDGEdge edge : prdg.getEdges()) {
				System.out.println(edge);
			}
			System.out.println("HEDGES");
			for (PRDGSubSystemHyperEdge hedge : prdg.getHedges())
				System.out.println(hedge);
			System.out.println();
			alphaz.mde.Analysis.ExportPRDG(prdg, "test-out/PRDG/matrix_product_with_reduce/matrix_product_with_reduce.dot");
//			System.out.println(GraphComponent.getINSTANCE().getGraphAnalysisService().topologicalSort( PRDGAdapterComponent.INSTANCE.build(prdg)));
		}
	}
}
