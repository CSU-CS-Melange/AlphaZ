package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.scanC.ScanCBody;
import org.polymodel.polyhedralIR.codegen.xtend2.scanC.ScanCCodeUnit;

import com.google.inject.AbstractModule;

public class ScanCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseCodeUnit.class).to(ScanCCodeUnit.class);
		bind(BaseBody.class).to(ScanCBody.class);
	}

}
