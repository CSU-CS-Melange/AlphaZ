package org.polymodel.polyhedralIR.codegen.xtend2.make

import com.google.inject.Inject
import org.polymodel.polyhedralIR.AffineSystem
import java.util.Map
import java.util.List

class Xtend2MakefileTop {
	
	@Inject extension BaseMakefile extensions
	
    def Map<String, String> generate(AffineSystem system, List<AffineSystem> systems, boolean omp) {
    	extensions.generate(system, systems, omp);
    }
    
}