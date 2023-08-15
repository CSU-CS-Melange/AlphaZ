package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions
import org.polymodel.polyhedralIR.Expression
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ExpressionPrinterForScheduledC

class ABFTScheduledCExpression extends ScheduledCExpression {
	
	public static ABFTCodeGenOptions options;
	
	override CharSequence print(Expression expr, CodeUnit cu, Function func) {
		return ExpressionPrinterForScheduledC::print(expr, func.entryPoint)
	}
	
}