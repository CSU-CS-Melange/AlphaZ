package org.polymodel.polyhedralIR.codegen.xtend2.scanC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit

class ScanCCodeUnit extends BaseCodeUnit {
	
	override commonIncludes(CodeUnit unit) '''
		«super.commonIncludes(unit)»
		#include <omp.h>
	'''
	
	override commonMacroDefs(CodeUnit unit) '''
		«super.commonMacroDefs(unit)»
		//Newton Raphson Macros
		#define MAX_ITER 100
		#define eps 1e-10
	'''
	
	override commonMacroUndefs(CodeUnit unit) '''
		«super.commonMacroUndefs(unit)»
		#undef MAX_ITER
		#undef eps
	'''
	
}