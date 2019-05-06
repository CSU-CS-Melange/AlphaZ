package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression
import org.polymodel.polyhedralIR.Expression
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.ExpressionPrinterForMPIC

class MPICExpression extends BaseExpression {
	
	override CharSequence print(Expression expr, CodeUnit cu, Function func) {
		return ExpressionPrinterForMPIC::print(expr, func.entryPoint)
	}
}