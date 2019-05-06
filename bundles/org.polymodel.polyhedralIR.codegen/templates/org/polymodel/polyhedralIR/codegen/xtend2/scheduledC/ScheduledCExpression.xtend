package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression
import org.polymodel.polyhedralIR.Expression
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ExpressionPrinterForScheduledC

class ScheduledCExpression extends BaseExpression {
	
	override CharSequence print(Expression expr, CodeUnit cu, Function func) {
		return ExpressionPrinterForScheduledC::print(expr, func.entryPoint)
	}
	
}