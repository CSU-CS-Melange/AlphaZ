package org.polymodel.polyhedralIR.codegen.xtend2.simd

import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.ExpressionPrinterForSIMD

class SIMDCExpression extends BaseExpression {
	
	def CharSequence printSIMD(SIMDExpression expr) {
		return ExpressionPrinterForSIMD::print(expr);
	}
	
}