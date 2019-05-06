package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit

class Xtend2CodeGenTop {
	
	@Inject extension BaseCompilationUnit extensions
	
    def generate (CompilationUnit unit) {
    	extensions.generate(unit)
    }
}