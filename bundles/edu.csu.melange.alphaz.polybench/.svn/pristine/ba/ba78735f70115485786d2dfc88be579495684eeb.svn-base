package edu.csu.melange.alphaz.polybench.test;

import org.junit.Test;
import org.polymodel.gecos.bridge.alphabets.modules.CtoAlphabets;

import edu.csu.melange.alphaz.polybench.PolyBench;
import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;

public class PolyBenchCtoAlphabets {

	public String CSRC_ROOT = "./csrc/";
	
	private String getBenchPath(POLYBENCH bench) {
		return CSRC_ROOT + bench.getCategory() + "/" + bench.getName() + "/" + bench.getName() + ".c";
	}
	
	@Test
	public void datamining() {
		for (POLYBENCH bench : PolyBench.getBench(PolyBench.DATAMINING)) {
			CtoAlphabets ctoAb = new CtoAlphabets(getBenchPath(bench));
			System.out.println(ctoAb.compute());
		}
	}
}
