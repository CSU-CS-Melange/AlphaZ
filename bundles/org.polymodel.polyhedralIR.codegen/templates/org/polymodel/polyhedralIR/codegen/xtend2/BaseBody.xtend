package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import java.util.HashMap
import org.polymodel.polyhedralIR.polyIRCG.BasicBody
import org.polymodel.polyhedralIR.polyIRCG.Body
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset
import org.polymodel.polyhedralIR.polyIRCG.Loop
import org.polymodel.polyhedralIR.polyIRCG.PackStruct
import org.polymodel.polyhedralIR.polyIRCG.StructManagement
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization
import org.polymodel.scop.cgenerator2.CGenerator
import org.polymodel.scop.cgenerator2.MacroBodyProvider

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*

class BaseBody {
	
	@Inject extension BaseStatement stmtExtensions
	@Inject extension BaseDomain domainExtensions
	@Inject extension BaseMemoryAllocation mallocs
	
	def dispatch code(Body body) {
		
	}
	
	def dispatch code(BasicBody body) {
		body.string
	}
	
	def dispatch code(ParameterCheck body) '''
		///Parameter checking
		if (!(«body.parameterDomain.printConstraints»)) {
			printf("The value of parameters are not valid.\n");
			exit(-1);
		}
	'''
	
	// Variable init is copy of global variables given as function arguments into globals
	// and then to allocate memory, which is in another extension as it commonly is modified 
	def dispatch code(VariableInitialization b) {
		val globals = (b.inputs + b.outputs).filter[v|v.global]
		
	'''
		«IF globals.length > 0»
			//Copy to global
			«FOR v : globals»
				«IF v.isScalar»
					«/* scalar is only for inputs */»
					«IF b.inputs.contains(v)»
						«v.name» = *«TEMP_LOCAL_PREFIX»«v.name»;
					«ENDIF»
				«ELSE»
					«v.name» = «TEMP_LOCAL_PREFIX»«v.name»;
				«ENDIF»
			«ENDFOR»
			
		«ENDIF»
		«b.malloc»
	'''
	}
	
	
	def dispatch code(FlagVariableReset b) '''
		«b.reset»
	'''
	
	def dispatch code(VariableFinalization b) '''
		«b.mfree»
	'''
	
	def dispatch code(Loop body) '''
		«body.statements.join("\n", [s|s.statementDefine])»
		{
			//Domain
			«FOR stmt : body.statements»
				//«stmt.domain»
			«ENDFOR»
			«body.generateLoopNest»
		}
		«body.statements.join("\n", [s|s.statementUndefine])»
	'''
	
	def dispatch code(TiledCLoop body) '''
		«IF body.getOptimizedPointLoop() != null && body.getOptimizedPointLoop().statements.size() > 0»
			«body.getOptimizedPointLoop().statements.join("\n", [s|s.statementDefine])»
		«ENDIF»
		«body.statements.join("\n", [s|s.statementDefine])»
		{
			//Domain
			«FOR stmt : body.statements»
				//«stmt.domain»
			«ENDFOR»
			«body.generateLoopNest»
		}
		«body.statements.join("\n", [s|s.statementUndefine])»
		«IF body.getOptimizedPointLoop() != null && body.getOptimizedPointLoop().statements.size() > 0»
			«body.getOptimizedPointLoop().statements.join("\n", [s|s.statementUndefine])»
		«ENDIF»
	'''
	
	def generateLoopNest(Loop l) '''
		«val scop = l.generateScop»
		«IF l.declareIterators && l.iteratorNames.size > 0»
			int «l.iteratorNames.join(",", [n|n])»;
		«ENDIF»
		«var stmtBody = new HashMap<String, MacroBodyProvider>()»
		«FOR s : l.statements.filter(s|s.inlined)»
			«stmtBody.put(s.name, s.macroBodyProvider)»
		«ENDFOR»
		«CGenerator::generate(scop, stmtBody)»
	'''
	
	def name(StructManagement psm) {
		'''«psm.instance.name»'''
	}
	
	def dispatch code(PackStruct pps) {
		'''
			«pps.instance.typeString» «pps.name»;
			«FOR p : pps.struct.members»
				«pps.name».«p.name» = «p.name»;
			«ENDFOR»
		'''
	}
	
	def dispatch code(CustomPackStruct cpps) {
		'''
			«cpps.instance.typeString» «cpps.name»;
			«FOR p : cpps.struct.members»
				«cpps.name».«p.name» = «cpps.initValues.get(p.name)»;
			«ENDFOR»
		'''
		
	}
	
/*
 * If there are more than one array then icc cannot distinguish whether there are aliasing
 * In order to hint the compiler we use "restrict" keyword in the declaration 
 */
	def dispatch code(UnpackStruct pps) {
		'''
			«val addRestrict = pps.struct.members.filter[m|!m.scalar].size>1»
			«IF addRestrict»
				«FOR p : pps.struct.members»
					«p.asParameterType»«IF !p.scalar» restrict«ENDIF» «p.name» = «pps.name».«p.name»;
				«ENDFOR»
			«ELSE»
				«FOR p : pps.struct.members»
					«p.asParameterType» «p.name» = «pps.name».«p.name»;
				«ENDFOR»
			«ENDIF»
		'''
	}
	
}