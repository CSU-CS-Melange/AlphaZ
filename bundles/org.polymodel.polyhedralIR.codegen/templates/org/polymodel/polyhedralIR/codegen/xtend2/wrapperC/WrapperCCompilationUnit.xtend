package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCompilationUnit
import org.polymodel.polyhedralIR.Program

class WrapperCCompilationUnit extends BaseCompilationUnit {
	
	override externalFunctionHeader(Program p) {
		//return null so that external functions are suppressed
	}
		
}