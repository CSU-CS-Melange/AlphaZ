package org.polymodel.polyhedralIR.codegen.xtend2.make


class SIMDTestingMakefile extends TestingMakefile {
	
	override cflagsOthers() {
		'''«super.cflagsOthers» -mavx'''
	}
	
}