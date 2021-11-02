package edu.csu.melange.alphaz.polybench.test;


import java.io.IOException;

import org.junit.Test;

import edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework;
import edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.TEST_SETTING;
import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;

public class CodeGenReferenceTest {
	
	private static final String REFDATA_ROOT = "./ref-data";

	protected static final String[][] DATAMINING_TESTS = new String[][] {
		createTestEntry(POLYBENCH.CORRELATION, "100 100"),
//		createTestEntry(POLYBENCH.COVARIANCE, "100 100"),
	};
	

	protected static final String[][] MEDLEY_TESTS = new String[][] {
		createTestEntry(POLYBENCH.FLOYD_WARSHALL, "100"),
//		createTestEntry(POLYBENCH.REG_DETECT, "100 50 6"),
	};

	@Test
	public void testWriteC() throws IOException, InterruptedException {
//		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, DATAMINING_TESTS);
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, MEDLEY_TESTS);
	}
	
	public static String[] createTestEntry(POLYBENCH bench, String inputArgs) {
		final String inputSize = inputArgs.replaceAll("\\s+", "x");
		return createTestEntry(bench, inputArgs, bench.getName()+".tm", bench.getName()+".in."+inputSize, bench.getName()+".out."+inputSize, 1);
	};

	
	public static String[] createTestEntry(POLYBENCH bench, String inputArgs, String TMfilename, String inputFilename, String outputFilename, int numP) {
		final String progDir = String.format("%s/%s/%s/", PolyBench.VARIATION.REF.path, bench.getCategory(), bench.getName());
		final String dataDir = String.format("%s/%s/%s/", REFDATA_ROOT, bench.getCategory(), bench.getName());
		
		//TM input file
		final String TMfile;
		if (TMfilename == null) TMfile = null;
		else TMfile = dataDir+TMfilename;
		
		final String inputFile;
		if (inputFilename == null) inputFile = null;
		else inputFile = dataDir + inputFilename;
		
		final String outputFile;
		if (outputFilename == null) outputFile = null;
		else outputFile = dataDir + outputFilename;
		
		return new String[] {
				progDir + bench.getName() + ".ab", //file path 
				bench.getName(), //system name
				inputArgs,
				TMfile, 
				inputFile,
				outputFile,
				Integer.toString(numP)
			}; 
	}
}
