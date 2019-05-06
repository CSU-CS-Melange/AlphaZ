package org.polymodel.polyhedralIR.codegen.xtend2.make

class SIMDMakefile extends BaseMakefile {

	override libraries() {
		'''«super.libraries» -mavx'''
	}

}