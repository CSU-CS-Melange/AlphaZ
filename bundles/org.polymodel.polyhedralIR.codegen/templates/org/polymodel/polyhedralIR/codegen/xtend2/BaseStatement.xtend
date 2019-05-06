package org.polymodel.polyhedralIR.codegen.xtend2

import org.polymodel.polyhedralIR.polyIRCG.BasicStatement
import java.util.List
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement
import org.polymodel.algebra.factory.IntExpressionBuilder
import com.google.inject.Inject
import org.polymodel.polyhedralIR.polyIRCG.Statement
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement
import org.polymodel.algebra.IntExpression
import org.polymodel.algebra.Variable
import java.util.ArrayList
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement
import org.polymodel.polyhedralIR.codegen.xtend2.simd.SIMDCExpression

class BaseStatement {
	
	@Inject extension BaseExpression expression
	@Inject extension BaseIndices indices
	
	def dispatch statementDefine(BasicStatement stmt) {
		'''#define «stmt.name»(«stmt.domain.macroIndices») «stmt.statement»'''
	}
	
	def dispatch statementDefine(EquationAsStatement stmt) {
		'''#define «stmt.name»(«stmt.accessFunction.getMacroIndices») «stmt.writeAccess» = «stmt.rhs.print(stmt.variable.codeunit, stmt.containerLoop.function)»'''
	}
	
	def dispatch statementDefine(CustomProviderStatement stmt) {
		'''#define «stmt.name»(«stmt.domain.macroIndices») «stmt.macroBodyProvider.getBody(stmt.domain.indices.toExpr)»'''
	}
	
	def private List<IntExpression> toExpr(List<Variable> vars) {
		var exprs = new ArrayList<IntExpression>();
		
		for (Variable v : vars) {
			exprs.add(IntExpressionBuilder::affine(IntExpressionBuilder::term(v)));
		}
		
		return exprs
	}
	
	def writeAccess(EquationAsStatement stmt) {
		if (!stmt.variable.scalar) {
			'''«stmt.variable.name»(«stmt.accessFunction.expressions.join(",", [e|e.toCString])»)'''
		} else if (stmt.containerLoop.function.locals.contains(stmt.variable)) {
			'''«stmt.variable.name»'''
		//non local scalars are de-referenced
		} else {
			'''*«stmt.variable.name»'''
		}
	}
	

	def statementUndefine(Statement stmt) {
		'''#undef «stmt.name»'''
	}
	
}