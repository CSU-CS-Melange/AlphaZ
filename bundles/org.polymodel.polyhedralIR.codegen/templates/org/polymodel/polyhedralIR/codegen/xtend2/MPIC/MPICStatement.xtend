package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPICUtility
import org.polymodel.algebra.factory.IntExpressionBuilder

class MPICStatement extends BaseStatement {
	
	/**
	 * Write accesses also need to be translated by the chunkOrigin
	 * 
	 */
	override writeAccess(EquationAsStatement stmt) {
		if (stmt.varDecl.local && !stmt.variable.scalar) {
			val tm = stmt.containerLoop.function.codeunit.system.targetMapping
			val F = MPICUtility::getAccessFunctionForDistributedVariable(tm, stmt.varDecl);
			'''«stmt.variable.name»(«F.expressions.join(",", [e|e.toCString])»)'''
		} else {
			super.writeAccess(stmt)
		}
	}
	
}