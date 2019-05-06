package org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile;

import org.polymodel.polyhedralIR.codegen.xtend2.make.BaseMakefile;
import org.polymodel.polyhedralIR.codegen.xtend2.make.SIMDMakefile;

import com.google.inject.AbstractModule;

public class SIMDMakefileModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseMakefile.class).to(SIMDMakefile.class);
	}

}
