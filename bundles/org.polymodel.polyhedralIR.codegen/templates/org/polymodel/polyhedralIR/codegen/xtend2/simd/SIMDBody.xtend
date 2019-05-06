package org.polymodel.polyhedralIR.codegen.xtend2.simd

import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDLoop
import org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization

class SIMDBody extends BaseBody {
	
	@Inject extension BaseStatement stmtExtensions
	@Inject extension BaseMemoryAllocation mallocs
	
	//SIMD Register initialization of 
	def dispatch code(VRegisterInitialization body)'''
		«body.malloc»
	'''
	
	def malloc(VRegisterInitialization b) '''
		//Memory Declaration for SIMD registers
		«b.locals.join("\n", [e|e.malloc])»
	'''
	
	def dispatch code(SIMDLoop body) '''
		«body.statements.join("\n", [s|s.statementDefine])»
		«body.simdStatements.join("\n", [s|s.statementDefine])»
		{
			//Domain
			«FOR stmt : body.statements»
				//«stmt.domain»
			«ENDFOR»
			«body.generateLoopNest»
		}
		«body.statements.join("\n", [s|s.statementUndefine])»
		«body.simdStatements.join("\n", [s|s.statementUndefine])»
	'''
	
	def dispatch code(TiledSIMDCLoop body) '''
		«IF body.getOptimizedPointLoop() != null && body.getOptimizedPointLoop().statements.size() > 0»
			«body.getOptimizedPointLoop().statements.join("\n", [s|s.statementDefine])»
		«ENDIF»
		«body.statements.join("\n", [s|s.statementDefine])»
		«body.simdStatements.join("\n", [s|s.statementDefine])»
		{
			//Domain
			«FOR stmt : body.statements»
				//«stmt.domain»
			«ENDFOR»
			«body.generateLoopNest»
		}
		«body.statements.join("\n", [s|s.statementUndefine])»
		«body.simdStatements.join("\n", [s|s.statementUndefine])»
		«IF body.getOptimizedPointLoop() != null && body.getOptimizedPointLoop().statements.size() > 0»
			«body.getOptimizedPointLoop().statements.join("\n", [s|s.statementUndefine])»
		«ENDIF»
	'''
}