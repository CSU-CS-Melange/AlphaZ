package edu.csu.melange.alphaz.polybench.alpha;

import org.polymodel.polyhedralIR.Program;

import alphaz.mde.Basic;

public class PBATestWriteC extends PBATestCase {
	
	private static final String WRITEC_OUTDIR = "writeC-out/";

	@Override
	protected void test(String filename) {
		System.out.println("Testing: " + filename);
		Program prog = Basic.ReadAlphabets(filename);
		
		alphaz.mde.CodeGen.generateWriteC(prog, prog.getSystems().get(0).getName(), WRITEC_OUTDIR);
	}

}
