package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.*

class MPICCodeUnit extends BaseCodeUnit {
	
	override commonIncludes(CodeUnit unit) '''
		«super.commonIncludes(unit)»
		#include <mpi.h>
	'''
	
	override commonMacroDefs(CodeUnit unit) '''
		«super.commonMacroDefs(unit)»
		#define «BUFFERING_FACTOR» 2
	'''
	
	override commonMacroUndefs(CodeUnit unit) '''
		«super.commonMacroUndefs(unit)»
		#undef «BUFFERING_FACTOR»
	'''
	
}