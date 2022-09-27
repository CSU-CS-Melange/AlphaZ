package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit

class ScheduledCCodeUnit extends BaseCodeUnit {

	override commonMacroDefs(CodeUnit unit) '''
		«super.commonMacroDefs(unit)»
		// Reduction Operators
		#define RADD(x,y)    ((x)+=(y))
		#define RMUL(x,y)    ((x)*=(y))
		#define RMAX(x,y)    ((x)=MAX((x),(y)))
		#define RMIN(x,y)    ((x)=MIN((x),(y)))
	'''
	
	override commonMacroUndefs(CodeUnit unit) '''
		«super.commonMacroUndefs(unit)»
		#undef RADD
		#undef RMUL
		#undef RMAX
		#undef RMIN
	'''
	
	/*
	 * Louis omit these for Macosx
	override commonIncludes(CodeUnit unit) '''
		«super.commonIncludes(unit)»
		#include <omp.h>
		#include <immintrin.h>
		#include <malloc.h>
	'''
	 */
}