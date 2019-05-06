package org.polymodel.polyhedralIR.codegen.xtend2.simd

import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement

/**
 * SIMDStatement is conflicting with the type, so this class is named SIMDStatementGen
 * 
 */
class SIMDStatementGen extends BaseStatement {
	
	@Inject extension SIMDCExpression expression
	@Inject extension BaseIndices indices
	
		def statementDefine(SIMDStatement stmt){
		'''#define «stmt.name»(«stmt.domain.getMacroIndices») «stmt.simdExp.printSIMD()»'''
	}
		
}