package org.polymodel.scop.cgenerator2.template

import org.polymodel.scop.ScopRoot
import com.google.inject.Inject
import org.polymodel.scop.AbstractScopNode
import org.polymodel.scop.ScopBlock
import org.polymodel.scop.ScopFor
import org.polymodel.algebra.Variable
import org.polymodel.algebra.IntExpression
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT
import org.polymodel.scop.ScopGuard
import org.polymodel.algebra.IntConstraintSystem
import org.polymodel.scop.ScopAssignment
import org.polymodel.scop.ScopStatementMacro
import org.polymodel.algebra.IntConstraint
import org.polymodel.scop.cgenerator2.CGenerator
import org.polymodel.scop.annotation.TileLoopAnnotation

class Xtend2_CGenerator {
	
	@Inject extension Xtend2_Annotation annotation
	
	def generate(ScopRoot root) '''
		«FOR statement : root.statements»«statement.generate»«ENDFOR»
	'''
	
	def CharSequence generate(AbstractScopNode node) '''
		«FOR ann : node.scopAnnotations»
			«annotation.annotationBeforeStatement(ann)»
		«ENDFOR»
		«node.statementBody»
		«FOR ann : node.scopAnnotations»
			«annotation.annotationAfterStatement(ann)»
		«ENDFOR»
	'''
	
	def dispatch statementBody(ScopBlock s) '''
	{
		«FOR sbs : s.statements»«sbs.generate»«ENDFOR»
	}
	'''
	
	def dispatch statementBody(ScopFor s) '''
«««		«IF s.scopAnnotations.exists([e|e instanceof TileLoopAnnotation])»
«««			«val tla = s.scopAnnotations.findFirst([e|e instanceof TileLoopAnnotation]) as TileLoopAnnotation»
«««			«IF tla.offset != null»
«««				for(«s.iterator»=ceild((«s.LB.toCString») - («tla.offset.toCString»), «tla.tileSize.toCString»)*«tla.tileSize.toCString» + «tla.offset.toCString»;«s.iterator.toCString» <= «s.UB.toCString»;«s.iterator»+=«s.stride.toCString»)
«««			«ELSE»
«««				for(«s.iterator»=ceild(«s.LB.toCString», «tla.tileSize.toCString»)*«tla.tileSize.toCString»;«s.iterator.toCString» <= «s.UB.toCString»;«s.iterator»+=«s.stride.toCString»)
«««			«ENDIF»
«««			for(«s.iterator»=ceild(«s.LB.toCString», «tla.tileSize.toCString»)*«tla.tileSize.toCString»;«s.iterator.toCString» <= «s.UB.toCString»;«s.iterator»+=«s.stride.toCString»)
«««		«ELSE»
		for(«s.iterator»=«s.LB.toCString»;«s.iterator.toCString» <= «s.UB.toCString»;«s.iterator.toCString»+=«s.stride.toCString»)
«««		«ENDIF»
		 «IF s.body != null»«s.body.generate»«ENDIF»
	'''
	
	
	def dispatch toCString(Variable v) '''«v.getName»'''
	def dispatch toCString(IntExpression ie) '''«ie.simplify.toString(OUTPUT_FORMAT::C)»'''
	def dispatch toCString(IntConstraint ic) '''«ic.simplify.toString(OUTPUT_FORMAT::C)»'''


	def dispatch statementBody(ScopGuard s) '''
		«IF s.constraintSystems.size>0»
			if («s.constraintSystems.join(" || ", [cs|cs.simplify.printConstraintSystem])») {
				«s.thenBody.generate»
			}«IF s.elseBody != null» else {
				«s.elseBody.generate»
			}«ENDIF»
		«ELSE»
			«s.thenBody.generate»
		«ENDIF»
	'''
	
	def printConstraintSystem(IntConstraintSystem ics) 
		'''(«ics.constraints.join(" && ", [c|c.toCString])»)'''
	
	
	def dispatch statementBody(ScopAssignment s) 
		'''«s.LHS.toCString» = «s.RHS.toCString»;'''
	
	
	def dispatch statementBody(ScopStatementMacro s) {
		if (CGenerator::isInlined(s.name)) {
			'''«CGenerator::getMacroBody(s.name, s.macroParams)»;'''
		} else {
			'''«s.name»(«s.macroParams.join(",", [mp|"("+mp.toCString+")"])»);'''
		}
	}
	
}