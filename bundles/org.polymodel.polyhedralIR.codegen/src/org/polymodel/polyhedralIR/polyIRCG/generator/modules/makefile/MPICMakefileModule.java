package org.polymodel.polyhedralIR.polyIRCG.generator.modules.makefile;

import org.polymodel.polyhedralIR.codegen.xtend2.make.BaseMakefile;
import org.polymodel.polyhedralIR.codegen.xtend2.make.MPICMakefile;

import com.google.inject.AbstractModule;

public class MPICMakefileModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseMakefile.class).to(MPICMakefile.class);
	}

}
