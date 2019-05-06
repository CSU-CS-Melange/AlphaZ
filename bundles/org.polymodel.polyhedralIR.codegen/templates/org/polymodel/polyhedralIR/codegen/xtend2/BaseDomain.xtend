package org.polymodel.polyhedralIR.codegen.xtend2

import org.polymodel.polyhedralIR.Domain
import org.polymodel.algebra.IntConstraintSystem
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT
import org.polymodel.polyhedralIR.ParameterDomain
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations

class BaseDomain {
	
	/**
	 * Prints the constraints without the parameter context as a simplification.
	 */
	def printConstraints(Domain dom, ParameterDomain params) {
		val context = params.copy as Domain;
		for (String i : dom.indexNames)
			context.addDimension(i)
		dom.printConstraints(context)
	}
	/**
	 * Prints the constraints after simplify in context with the given context.
	 */
	def printConstraints(Domain dom, Domain context) {
		val simplified = dom.copy
		simplified.simplifyInContext(context);
		simplified.PMdomain.printConstraints
	}
	
	def printConstraints(Domain dom) {
		dom.PMdomain.printConstraints
	}
	
	def printConstraints(org.polymodel.Domain dom) {
		'''«dom.polyhedra.join(" || ", [poly|poly.printConstraints])»'''
	}
	
	def printConstraints(IntConstraintSystem system) {
		'''(«IF system.constraints.size > 0»«system.constraints.join( " && ", [c|c.toString(OUTPUT_FORMAT::C)])»«ELSE»1«ENDIF»)'''
	}
	
}