package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.WrapperForMPICCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.WrapperForMPICFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCCompilationUnit;

import com.google.inject.AbstractModule;

public class WrapperForMPICModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseCompilationUnit.class).to(WrapperCCompilationUnit.class);
		bind(BaseCodeUnit.class).to(WrapperForMPICCodeUnit.class);
		bind(BaseFunction.class).to(WrapperForMPICFunction.class);
	}

}
