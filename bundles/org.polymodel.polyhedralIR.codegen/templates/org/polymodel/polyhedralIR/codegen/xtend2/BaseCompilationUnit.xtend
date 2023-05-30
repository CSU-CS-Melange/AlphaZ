package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import org.polymodel.polyhedralIR.Program
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit
import java.util.TreeMap
import java.util.Map
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration
import org.polymodel.polyhedralIR.Type
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants.*
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

class BaseCompilationUnit {
	
	@Inject extension BaseCodeUnit extensions
	
	def String externalFunctionHeader(Program p) {
		if (p.externalFunctionDeclarations.size > 0) {
			"//External Functions\n" + p.externalFunctionDeclarations.join("\n", [ex|ex.externalFunctionDeclaration + ";"])
		}
	}

	def externalFunctionDeclaration(ExternalFunctionDeclaration exFunc) {
		'''«exFunc.output» «exFunc.name»(«exFunc.inputs.join(",", [t|t.name])»)'''
	}
	
	def name(Type type){
		type.toString
	}
	
    def Map<String,String> generate (CompilationUnit unit)  {
    	val files = new TreeMap<String,String>();
    	
    	files.put(EXTERNAL_FUNCTION_HEADER_NAME, unit.program.externalFunctionHeader)

    	for( cu : unit.units)
			files.put(cu.filename, cu.generate.toString)
			
		return files    	
	 }
	 
	 
}