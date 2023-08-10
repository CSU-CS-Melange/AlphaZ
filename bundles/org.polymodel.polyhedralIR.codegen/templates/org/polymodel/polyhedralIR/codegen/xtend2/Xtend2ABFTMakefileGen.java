package org.polymodel.polyhedralIR.codegen.xtend2;

import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.codegen.xtend2.make.Xtend2ABFTMakefileTop;

import com.google.inject.Guice;

public class Xtend2ABFTMakefileGen {
	
	public static Map<String, String> generate(AffineSystem system, List<AffineSystem> systems) {
		Xtend2ABFTMakefileTop instance = Guice.createInjector().getInstance(Xtend2ABFTMakefileTop.class);

		return instance.generate(system, systems);
	}
}
