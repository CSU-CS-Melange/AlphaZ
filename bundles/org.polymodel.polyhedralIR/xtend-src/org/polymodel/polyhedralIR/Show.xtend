package org.polymodel.polyhedralIR

import org.polymodel.algebra.IntConstraintSystem
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT
import static extension org.polymodel.polyhedralIR.ShowUtility.*
import java.util.List

class Show {
	
	def String toString(PolyhedralIRVisitable o) {
		o.print(false).toString;
	}
	
	def String toSimplifiedString(PolyhedralIRVisitable o) {
		o.print(true).toString;
	}
	
	def protected dispatch CharSequence print(Program o, boolean simplify) '''
		«o.externalFunctionDeclarations.join("\n", [e|e.print(simplify)])»
		
		«o.systems.join("\n\n", [e|e.print(simplify)])»
	'''
	
	def protected dispatch CharSequence print(ExternalFunctionDeclaration o, boolean simplify) '''
		«o.output.print(simplify)» «o.name»(«o.inputs.join(",", [i|i.print(simplify)])»);
	'''
	
	def protected dispatch CharSequence print(Type o, boolean simplify) '''«o.CName»'''
	
	def protected dispatch CharSequence print(AffineSystem o, boolean simplify) '''
		affine «o.name» «o.parameters»
			«IF o.inputs.size > 0»
				input
					«o.inputs.join("\n", [i|i.print(simplify)])»
			«ENDIF»
			«IF o.outputs.size > 0»
				output
					«o.outputs.join("\n", [i|i.print(simplify)])»
			«ENDIF»
			«IF o.locals.size > 0»
				local
					«o.locals.join("\n", [i|i.print(simplify)])»
			«ENDIF»
			let
				«o.equations.join("\n", [i|i.print(simplify)])»
				«o.useEquations.join("\n", [i|i.print(simplify)])»
		.
	'''
	
	def protected dispatch CharSequence print(Domain o, boolean simplify) '''
		«val indices = o.indices.join(",", [i|i.name])»
		«simplifyDomain(o, simplify).print(indices)»
	'''
	def protected dispatch CharSequence print(ParameterDomain o, boolean simplify) '''
		«val indices = (o.params+o.indices).join(",", [i|i.name])»
		«o.PMdomain.polyhedra.print(indices)»
	'''
	
	def protected print(List<IntConstraintSystem> ics, String indices) {
		if (ics.empty) {
			'''{«indices»|}'''
		} else {
			ics.join(" || ", [i|"{"+indices+"|"+i.toString(OUTPUT_FORMAT::ALPHABETS)+"}"])
		}
	}
	
	
	def protected dispatch CharSequence print(VariableDeclaration o, boolean simplify) '''
		«o.type.print(simplify)» «o.varID.print(simplify)» «o.domain.print(simplify)»;
	'''
	def protected dispatch CharSequence print(VariableIdentifier o, boolean simplify) '''«o.name»'''
	
}