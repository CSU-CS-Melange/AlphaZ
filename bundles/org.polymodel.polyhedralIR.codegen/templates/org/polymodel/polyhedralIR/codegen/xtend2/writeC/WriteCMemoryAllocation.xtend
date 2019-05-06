package org.polymodel.polyhedralIR.codegen.xtend2.writeC

import org.polymodel.polyhedralIR.DATATYPE
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*

class WriteCMemoryAllocation extends BaseMemoryAllocation {
	
	//Initialize the flags
	override malloc(AbstractVariable v) {
		if (!v.ofType(DATATYPE::CHAR)) {
			return super.malloc(v)
		}
		
		
		
//		var vol = v.getVolumeExpression(0,v.domain.NIndices).toCString
//		var varName = if (v.MDallocation) {
//			'''«LINEARIZED_ARRAY_PREFIX»«v.name»'''
//		} else {
//			'''«v.name»'''
//		}
//		var init = if (v.scalar) {
//			'''«varName» = 'N';'''
//		} else {
//			'''memset(«varName», 'N', («vol»));'''
//		}
		'''
		«super.malloc(v)»
		«v.reset(true)»
		'''
	}
	
	override reset(AbstractVariable v, boolean isVariableInit) {
		resestDispatch(v, isVariableInit)
	}
	
	def dispatch resestDispatch(AbstractVariable v, boolean isVariableInit) {
		''''''
	}
	def dispatch resestDispatch(CodeGenVariable v, boolean isVariableInit) {
		
		if (v.ofType(DATATYPE::CHAR)) {
			var isWhile = v.codeunit.system.whileInfo != null;
			var timeIndexName = if (isWhile) {
				v.codeunit.system.whileInfo.timeDomain.indexNames.get(0);
			} else ""
			var historyOfTime = if (isWhile) {
				v.getModFactor(0).toCString;
			} else ""
			var isOutputVar = v.codeunit.system.isOutput(v.codeunit.system.getVariableDeclaration(
				if (v.name.startsWith(FLAG_PREFIX)) v.name.substring(FLAG_PREFIX.length) else v.name
			));
			
			
			var startingIndex = if (isWhile && !isVariableInit) {
				/*
				 * Check whether the original variable is an output. If it is an 
				 * output, then we reset the whole volume of variable.
				 * If it is a local variable, then we have to reset only the 
				 * slice of current time stamp. Therefore, startingIndex = 1.
				 * In addition we also 
				*/
				if (isOutputVar) {
					0
				} else {
					1
				}
			} else {
				0
			}
			
			if (isWhile && !isVariableInit) {
				if (v.name.endsWith("__Wsplit")) {
					return ''''''
				}
			}
				
				
			var vol = v.getVolumeExpression(startingIndex,v.domain.NIndices).toCString
			var varName = if (v.MDallocation) {
				'''«LINEARIZED_ARRAY_PREFIX»«v.name»'''
			} else {
				'''«v.name»'''
			}
			var init = if (v.scalar) {
				'''«varName» = 'N';'''
			} else {
				'''memset(«varName»«if (!isVariableInit && isWhile) {'''+(((«timeIndexName»)%(«historyOfTime»))*(«vol»))'''}», 'N', («vol»));'''
			}
			'''«init»'''
		} else {
			''''''
		}
	}
}