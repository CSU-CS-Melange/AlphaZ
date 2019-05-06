package org.polymodel.polyhedralIR.polyIRCG.generator.modules;


import org.polymodel.polyhedralIR.codegen.xtend2.MPIC.CAnnotationForMPIC;
import org.polymodel.scop.cgenerator2.template.Xtend2_Annotation;

import com.google.inject.AbstractModule;

public class CGeneratorForMPIC extends AbstractModule {

	@Override
	protected void configure() {
		bind(Xtend2_Annotation.class).to(CAnnotationForMPIC.class);
	}

}
