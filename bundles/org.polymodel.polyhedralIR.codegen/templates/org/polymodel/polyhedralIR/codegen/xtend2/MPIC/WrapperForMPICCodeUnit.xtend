package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit

class WrapperForMPICCodeUnit extends WrapperCCodeUnit {
	
	override commonIncludes(CodeUnit unit) '''
		«super.commonIncludes(unit)»
		#include <mpi.h>
	'''
	
}