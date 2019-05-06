package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ScheduledCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ScheduledCExpression;

import com.google.inject.AbstractModule;

public class ScheduledCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseExpression.class).to(ScheduledCExpression.class);
		bind(BaseCodeUnit.class).to(ScheduledCCodeUnit.class);
	}

}
