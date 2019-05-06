package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCFunction;

import com.google.inject.AbstractModule;

public class WrapperCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseCompilationUnit.class).to(WrapperCCompilationUnit.class);
		bind(BaseCodeUnit.class).to(WrapperCCodeUnit.class);
		bind(BaseFunction.class).to(WrapperCFunction.class);
	}

}
