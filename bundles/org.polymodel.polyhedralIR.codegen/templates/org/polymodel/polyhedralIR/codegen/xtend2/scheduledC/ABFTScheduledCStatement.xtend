package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices
import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression

class ABFTScheduledCStatement extends BaseStatement {
	
	public static ABFTCodeGenOptions options;
	
	@Inject extension BaseExpression expression
	@Inject extension BaseIndices indices
	
	override dispatch statementDefine(EquationAsStatement stmt) {
		val abftProtectedVar = options.weightsVar.split('_').get(1)
		val stmtCode = '''«stmt.writeAccess» = «stmt.rhs.print(stmt.variable.codeunit, stmt.containerLoop.function)»'''
		if (!stmt.varDecl.varID.name.equals(abftProtectedVar)) {
			return '''#define «stmt.name»(«stmt.accessFunction.getMacroIndices») «stmtCode»'''
		}
		val indices = stmt.accessFunction.expressions.map[it.toString].toList
		val injectionCondition = if (options.numDims == 1) {
			'''(«indices.get(0)»==T_INJ && «indices.get(1)»==I_INJ)'''
		} else if (options.numDims == 2) {
			'''(«indices.get(0)»==T_INJ && «indices.get(1)»==I_INJ && «indices.get(2)»==J_INJ)'''
		} else if (options.numDims == 3) {
			'''(«indices.get(0)»==T_INJ && «indices.get(1)»==I_INJ && «indices.get(2)»==J_INJ && «indices.get(3)»==K_INJ)'''
		}
		
		'''#define «stmt.name»(«stmt.accessFunction.getMacroIndices») do { «stmtCode»; if «injectionCondition» {inject(Y);}; } while (0)'''
	}
	
}