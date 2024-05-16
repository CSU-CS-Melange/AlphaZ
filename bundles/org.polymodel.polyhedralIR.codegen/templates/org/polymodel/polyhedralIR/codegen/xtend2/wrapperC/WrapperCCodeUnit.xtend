package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import static org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants.*
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices
import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAccess
import org.polymodel.polyhedralIR.AffineFunction
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable

class WrapperCCodeUnit extends BaseCodeUnit {
	
	@Inject extension BaseIndices indices
	@Inject extension BaseMemoryAccess access
	
	override commonIncludes(CodeUnit unit) '''
		«super.commonIncludes(unit)»
		#include <time.h>
		#include <sys/time.h>
		#include <sys/errno.h>
	'''
	
	override commonMacroDefs(CodeUnit unit) '''
		«super.commonMacroDefs(unit)»
		#define «EPSILON_NAME» «EPSILON_DEFAULT»
	'''
	
	override commonMacroUndefs(CodeUnit unit) '''
		«super.commonMacroUndefs(unit)»
		#undef «EPSILON_NAME»
	'''
	
	override commonFuncDefs(CodeUnit unit)'''
	'''
	
	override memoryMacroDefs(CodeUnit unit) '''
		«super.memoryMacroDefs(unit)»
		«/* macros for verification variables */»
		«FOR f : unit.functions»
			«FOR v : f.outputs»
				«val verifyName = v.name+VERIFY_POSTFIX»
				#define «verifyName»(«indices.getMacroIndices(v)») «verifyName»«v.arrayIndexing»
«««				#define «verifyName»(«v.macroIndices») «verifyName»«v.arrayIndexing»	
«««				«IF v.flattened»
«««					#define «verifyName»(«v.macroIndices») «verifyName»«v.arrayIndexing1D»	
«««				«ELSE»
«««					#define «verifyName»(«v.macroIndices») «verifyName»«v.arrayIndexingMD»
«««				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR varDecl : unit.system.outputs»
			«val memSpace = unit.system.targetMapping.getMemoryMaps().get(varDecl).getSpace() »
			«val codeGenVar = unit.findCGVariable(memSpace.name) »
			«val microIndices = indices.getMacroIndices(codeGenVar)»
			«val access = getMemSpaceAccess(codeGenVar)»
«««				«val access = unit.system.targetMapping.getMemoryMaps().get(varDecl).mapping.iterToMemSpace»
«««			«val memSpace = unit.system.targetMapping.getMemorySpace(varDecl)»
«««			«val access = memSpace.getMemoryMap(varDecl).mapping.iterToMemSpace»
«««			#define var_«varDecl.name»(«varDecl.macroIndices») «memSpace.name»«access»
«««			#define var_«varDecl.name»«VERIFY_POSTFIX»(«varDecl.macroIndices») «memSpace.name»«VERIFY_POSTFIX»«access»
			#define var_«varDecl.name»(«microIndices») «memSpace.name»«access»
			#define var_«varDecl.name»«VERIFY_POSTFIX»(«microIndices») «memSpace.name»«VERIFY_POSTFIX»«access»
		«ENDFOR»
	'''
	
	def protected getMemSpaceAccess(CodeGenVariable v) {
		//scalar case
		if(v.domain.NIndices == 0){
			''''''
		}else{
			'''(«indices.getMacroIndices(v)»)'''
		}
	}
	
	def protected iterToMemSpace(AffineFunction f) {
		//scalar case
		if (f.dimRHS == 0) {
			''''''
		} else {
			'''(«f.expressions.join(",", [e|e.toCString])»)'''
		}
	}
	
	override memoryMacroUndefs(CodeUnit unit) {
		super.memoryMacroUndefs(unit)
		
	}
	override externalFunctionInclude(CodeUnit unit) ''''''
	
	
	override String filename(CodeUnit unit) {
		'''«unit.system.name»-wrapper.c'''.toString
	}
	
}