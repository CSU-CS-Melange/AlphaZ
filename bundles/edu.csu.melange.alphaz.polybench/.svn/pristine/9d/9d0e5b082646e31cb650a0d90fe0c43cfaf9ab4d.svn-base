package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;

public class TestWriteC {
	
	public static final String OUTDIR = "./test-out/WRITE_C/";
	public static final String DATAMINING = "alphabets/datamining/";
	
	@Test
	public void testDataMining() {
		test(DATAMINING, "correlation");
		test(DATAMINING, "covariance");
	}
	
	private void test(String basePath, String testName) {
		generateWriteC(basePath + testName + "/" + testName + ".ab", testName);
	}

	private void generateWriteC(String file, String systemName) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		String outDir = OUTDIR + systemName;
		
		alphaz.mde.CodeGen.generateWriteC(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, outDir);
	}

}
