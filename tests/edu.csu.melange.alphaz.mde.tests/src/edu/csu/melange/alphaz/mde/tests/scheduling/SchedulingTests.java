package edu.csu.melange.alphaz.mde.tests.scheduling;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.MonodimensionnalScheduler;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.SimpleSchedulePrototypeDomainBuilder;
import org.polymodel.prdg.scheduling.farkas.FarkasSchedulingDomainBuilder;
import org.polymodel.prdg.scheduling.observers.FarkasLatexPrinter;

public class SchedulingTests {
	@Test
	public void testFarkas1D() throws SchedulingException {		// TODO: Bug everywhere !!
//		testFarkas1D("matrix_product");
//		testFarkas1D("jacobi_1d");
//		testFarkas1D("smith_waterman");
	}

	@Test
	public void testFarkas() {
		testFarkasMD("matrix_product");
		testFarkasMD("matrix_product_withReduce");
		testFarkasMD("jacobi_1d");
		testFarkasMD("jacobi_1d_imper");
		testFarkasMD("jacobi_2d");
		testFarkasMD("jacobi_2d_imper");
		testFarkasMD("cholesky");
		testFarkasMD("cholesky_withReduce");
		testFarkasMD("lud");
		testFarkasMD("fibonacci");
		testFarkasMD("smith_waterman");
	}

	@Test
	public void testPluto() {
		testPluto("matrix_product");
		testPluto("matrix_product_withReduce");
		testPluto("jacobi_1d");
		testPluto("jacobi_1d_imper");
		testPluto("jacobi_2d");
		testPluto("jacobi_2d_imper");
		testPluto("cholesky");
		testPluto("cholesky_withReduce");
		testPluto("lud");
		testPluto("fibonacci");
		testPluto("smith_waterman");
	}
	
	private void testFarkasMD(String testName) {
		System.out.println(testName);
		Program program = alphaz.mde.Basic.ReadAlphabets("testcases/"+testName+"/"+testName+".ab");
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(program, testName, 1);
		alphaz.mde.Analysis.FarkasMDScheduler(prdg);
	}
	private void testPluto(String testName) {
		System.out.println(testName);
		Program program = alphaz.mde.Basic.ReadAlphabets("testcases/"+testName+"/"+testName+".ab");
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(program, testName, 1);
		alphaz.mde.Analysis.PlutoScheduler(prdg);
	}
	private void testFarkas1D(String testName) throws SchedulingException {
		
		System.out.println(testName);
		Program program = alphaz.mde.Basic.ReadAlphabets("testcases/"+testName+"/"+testName+".ab");
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(program, testName, 1);
		prdg = alphaz.mde.Analysis.revertPRDGEdges(prdg);

		System.out.println(prdg);
		
		MonodimensionnalScheduler scheduler = new MonodimensionnalScheduler(
				new FarkasSchedulingDomainBuilder(
						new SimpleSchedulePrototypeDomainBuilder()));
		scheduler.setLb(0);
		
		
		// Observers
		FarkasLatexPrinter printer = new FarkasLatexPrinter();
		scheduler.addObserver(printer);
		// Schedule
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(prdg);
			printer.print("./test-out/latex/farkas_1D_" + testName + ".tex");
//			printScheduledStatements(stmts);
//			return stmts;
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
//			return new ArrayList<ScheduledStatement>();
			throw se;
		}
	}
}
