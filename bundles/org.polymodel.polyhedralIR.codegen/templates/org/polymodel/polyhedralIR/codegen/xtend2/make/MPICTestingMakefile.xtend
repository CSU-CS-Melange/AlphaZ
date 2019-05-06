package org.polymodel.polyhedralIR.codegen.xtend2.make

import java.util.List

class MPICTestingMakefile extends TestingMakefile {
	
	override cc() {
		'''mpicc'''
	}
	
	override includes() {
		'''«super.includes» -I$(MPI_INCLUDE_DIR)'''
	}
	
	override makefile(CharSequence name, List<CharSequence> names, CharSequence verifyName, boolean omp) '''
		ifndef MPI_INCLUDE_DIR
			MPI_INCLUDE_DIR=/usr/include/openmpi-x86_64/
		endif
		«super.makefile(name, names, verifyName, omp)»
	'''
	
}