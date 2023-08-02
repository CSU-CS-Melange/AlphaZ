package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCFunction;

import com.google.inject.AbstractModule;

public class ABFTWrapperCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseCompilationUnit.class).to(ABFTWrapperCCompilationUnit.class);
		bind(BaseCodeUnit.class).to(ABFTWrapperCCodeUnit.class);
		bind(BaseFunction.class).to(ABFTWrapperCFunction.class);
	}

}