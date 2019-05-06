package edu.csu.melange.alphaz.mde.tests.regression;

import java.io.IOException;

import org.junit.Test;

import edu.csu.melange.alphaz.mde.tests.regression.CodeGenTestingFramework.TEST_SETTING;

public class TutorialExampleTests {
	
	protected static final String TEST_TMFILE_DIR  = "regression/tutorial/targetmapping/";
	protected static final String TEST_INPUT_DIR  = "regression/tutorial/inputs/";
	protected static final String TEST_OUTPUT_DIR = "regression/tutorial/outputs/";
	
	protected static final String SR_DIR = "tutorialExamples/SimplifyingReductions/";
	protected static final String[][] SIMPLIFYING_REDUCTIONS = new String[][]{
		new String[] {SR_DIR+"PrefixSum.ab", "PrefixSum", "10", null, TEST_INPUT_DIR+"PrefixSum.10", TEST_OUTPUT_DIR+"PrefixSum.10"},
		new String[] {SR_DIR+"PrefixSum.out.ab", "PrefixSum", "10", null, TEST_INPUT_DIR+"PrefixSum.10", TEST_OUTPUT_DIR+"PrefixSum.10"},

		new String[] {SR_DIR+"MMLikeExample.ab", "MMLikeExample", "10", null, TEST_INPUT_DIR+"MMLikeExample.10", TEST_OUTPUT_DIR+"MMLikeExample.10"},
		new String[] {SR_DIR+"MMLikeExample.out.ab", "MMLikeExample", "10", null, TEST_INPUT_DIR+"MMLikeExample.10", TEST_OUTPUT_DIR+"MMLikeExample.10"},

		new String[] {SR_DIR+"MotivatingExample.ab", "MotivatingExample", "10", null, TEST_INPUT_DIR+"MotivatingExample.10", TEST_OUTPUT_DIR+"MotivatingExample.10"},
		new String[] {SR_DIR+"MotivatingExample.out.ab", "MotivatingExample", "10", null, TEST_INPUT_DIR+"MotivatingExample.10", TEST_OUTPUT_DIR+"MotivatingExample.10"},

		new String[] {SR_DIR+"FinalExample.ab", "FinalExample", "10", null, TEST_INPUT_DIR+"FinalExample.10", TEST_OUTPUT_DIR+"FinalExample.10"},
		new String[] {SR_DIR+"FinalExample.out.ab", "FinalExample", "10", null, TEST_INPUT_DIR+"FinalExample.10", TEST_OUTPUT_DIR+"FinalExample.10"},
	};
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, SIMPLIFYING_REDUCTIONS);
	}
	
	@Test
	public void test() throws IOException, InterruptedException {
		CodeGenTestingFramework.run(TEST_SETTING.WRITE_C, SIMPLIFYING_REDUCTIONS);
	}
}
