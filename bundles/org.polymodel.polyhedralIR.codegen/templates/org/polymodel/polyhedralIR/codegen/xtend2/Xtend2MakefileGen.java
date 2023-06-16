package org.polymodel.polyhedralIR.codegen.xtend2;

import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.codegen.xtend2.make.Xtend2MakefileTop;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

public class Xtend2MakefileGen {

	public static Map<String, String> generate(AffineSystem system, List<AffineSystem> systems, boolean omp) {
		return generate(system, systems, omp, false);
	}

	public static Map<String, String> generate(AffineSystem system, List<AffineSystem> systems, boolean omp, boolean withVerification) {
		Xtend2MakefileTop instance = Guice.createInjector().getInstance(Xtend2MakefileTop.class);

		return instance.generate(system, systems, omp, withVerification);
	}

	public static Map<String, String> generate(AbstractModule module, AffineSystem system, List<AffineSystem> systems, boolean omp) {
		return generate(module, system, systems, omp, false);
	}

	public static Map<String, String> generate(AbstractModule module, AffineSystem system, List<AffineSystem> systems, boolean omp, boolean withVerification) {
		Xtend2MakefileTop instance = Guice.createInjector(module).getInstance(Xtend2MakefileTop.class);

		return instance.generate(system, systems, omp, withVerification);
	}
}
