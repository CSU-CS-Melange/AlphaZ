package org.polymodel.polyhedralIR.codegen.xtend2

import java.util.List
import org.polymodel.algebra.Variable
import org.polymodel.polyhedralIR.AffineFunction
import org.polymodel.polyhedralIR.Domain
import org.polymodel.polyhedralIR.VariableDeclaration
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable

class BaseIndices {
	
	
	//Get string for calling macros
	def dispatch CharSequence getMacroIndices(AbstractVariable v) {
		''''''
	}
	
	def dispatch CharSequence getMacroIndices(CodeGenVariable v) {
		v.domain.indices.getMacroIndicesL
	}
	def CharSequence getMacroIndices(Domain dom) {
		dom.indices.getMacroIndicesL
	}
	def CharSequence getMacroIndices(AffineFunction func) {
		func.indices.getMacroIndicesL
	}
	def CharSequence getMacroIndices(VariableDeclaration v) {
		v.domain.indices.getMacroIndicesL
	}
	
	def getMacroIndicesL(List<Variable> indices) {
		if (indices.size > 0) {
			'''«indices.join(",", [i|i.toString])»'''
		}
	}
	
	def getMacroIndicesExceptTime(List<Variable> indices) {
		if (indices.size > 1) {
			'''«indices.filter[i|!i.toString.equals("t")].join(",", [i|i.toString])»'''
		}
	}
	
}