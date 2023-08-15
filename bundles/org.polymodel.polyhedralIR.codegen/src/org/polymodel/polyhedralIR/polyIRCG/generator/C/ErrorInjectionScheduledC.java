package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.List;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.analysis.SystemCallAnalysis;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.scheduledC.ABFTScheduledCStatement;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;

public class ErrorInjectionScheduledC extends ScheduledC {

	protected ErrorInjectionScheduledC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
	}

	public static void systemCodeGenenration(AffineSystem system, ABFTCodeGenOptions options, String outDir){
		ErrorInjectionScheduledC errorInjectionScheduledC = new ErrorInjectionScheduledC(system, options);
		
		// Attach the options of the module xtend template classes
		ABFTScheduledCCodeUnit.options = options;
		ABFTScheduledCFunction.options = options;
		ABFTScheduledCStatement.options = options;
		ABFTScheduledCExpression.options = options;
		
		errorInjectionScheduledC.generate(options, outDir);
	}

	public static void generate(AffineSystem system, ABFTCodeGenOptions options, String outDir) {
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(system);
		
		for(AffineSystem sys : systems){
			systemCodeGenenration(sys, options, outDir);
		}
	}
	
	protected CODEGEN getCodeGen() {
		return CODEGEN.ABFT_SCHEDULED_C;
	}
}
