package org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper;


import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCCompilationUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.ABFTWrapperCFunction;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;


public class ABFTWrapperGeneratorForC extends WrapperGeneratorForC {

	protected ABFTWrapperGeneratorForC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
	}
	
	public static void generate(AffineSystem system, ABFTCodeGenOptions options, String outDir) {
		ABFTWrapperGeneratorForC wrapper = new ABFTWrapperGeneratorForC(system, options);
		
		// Attach the options of the module xtend template classes
		ABFTWrapperCCompilationUnit.options = options;
		ABFTWrapperCCodeUnit.options = options;
		ABFTWrapperCFunction.options = options;
		
		wrapper.generate(options, outDir);
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.ABFT_WRAPPER_C;
	}
	
}
