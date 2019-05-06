package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.codegen.xtend2.writeC.WriteCExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.writeC.WriteCMemoryAllocation;

import com.google.inject.AbstractModule;

public class WriteCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseExpression.class).to(WriteCExpression.class);
		bind(BaseMemoryAllocation.class).to(WriteCMemoryAllocation.class);
	}

}
