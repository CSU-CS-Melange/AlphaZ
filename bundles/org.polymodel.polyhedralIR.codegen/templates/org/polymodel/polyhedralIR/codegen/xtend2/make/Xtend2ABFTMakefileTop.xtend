package org.polymodel.polyhedralIR.codegen.xtend2.make

import com.google.inject.Inject
import org.polymodel.polyhedralIR.AffineSystem
import java.util.Map
import java.util.List

class Xtend2ABFTMakefileTop {
	@Inject extension ABFTMakefile extensions
	
    def Map<String, String> generate(AffineSystem system, List<AffineSystem> systems) {
		extensions.generate(system, systems, false, false);
    }
    
}