package org.polymodel.polyhedralIR.polyIRCG.generator.modules;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.MPICBody;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.MPICCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.MPICExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.MPICFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.MPICStatement;

import com.google.inject.AbstractModule;

public class MPICModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseCodeUnit.class).to(MPICCodeUnit.class);
		bind(BaseExpression.class).to(MPICExpression.class);
		bind(BaseBody.class).to(MPICBody.class);
		bind(BaseFunction.class).to(MPICFunction.class);
		bind(BaseStatement.class).to(MPICStatement.class);
	}

	
}
