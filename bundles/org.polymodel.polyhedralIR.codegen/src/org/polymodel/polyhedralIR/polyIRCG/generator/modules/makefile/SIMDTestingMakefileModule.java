package org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile;

import org.polymodel.polyhedralIR.codegen.xtend2.make.BaseMakefile;
import org.polymodel.polyhedralIR.codegen.xtend2.make.SIMDTestingMakefile;

import com.google.inject.AbstractModule;

public class SIMDTestingMakefileModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseMakefile.class).to(SIMDTestingMakefile.class);
	}

	
}
