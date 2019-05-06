package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.PCOT.PCOTBody;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ScheduledCExpression;

public class PCOTCModule extends ScheduledCModule {

	@Override
	protected void configure() {
		bind(BaseExpression.class).to(ScheduledCExpression.class);
		bind(BaseBody.class).to(PCOTBody.class);
	}
}
