package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ScheduledCExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCStatement;

import com.google.inject.AbstractModule;

public class ABFTScheduledCModule  extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(BaseFunction.class).to(ABFTScheduledCFunction.class);
		bind(BaseStatement.class).to(ABFTScheduledCStatement.class);
		bind(BaseCodeUnit.class).to(ABFTScheduledCCodeUnit.class);
		bind(BaseExpression.class).to(ScheduledCExpression.class);
	}
}
