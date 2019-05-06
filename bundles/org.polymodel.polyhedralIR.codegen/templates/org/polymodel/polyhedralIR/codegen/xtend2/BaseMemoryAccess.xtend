package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*

class BaseMemoryAccess {
	
	@Inject extension BaseIndices indices
	
	def dispatch memoryMacroDef(BasicVariable v) {
			
	}
	
	def dispatch memoryMacroDef(CodeGenVariable v) {
		if (v.codeunit.system.whileInfo == null) {
			//Scalars do not have a macro
			if (!v.scalar) {
				'''#define «v.name»(«indices.getMacroIndices(v)») «v.name»«v.arrayIndexing»'''
				
			}
//			//Flattend to 1D array
//			if (v.flattened) {
//				'''#define «v.name»(«indices.getMacroIndices(v)») «v.name»«v.arrayIndexing1D»'''
//			//Multi dimensional case		
//			} else {
//				'''#define «v.name»(«indices.getMacroIndices(v)») «v.name»«v.arrayIndexingMD»'''
//			}	
//		}
		} else {
			'''#define «v.name»(«indices.getMacroIndices(v)») «v.name»«v.arrayIndexing»'''
		}
	}
	
	def dispatch arrayIndexing(AbstractVariable v) {
	
	}
	
	def dispatch arrayIndexing(CodeGenVariable v) {
		if (!v.scalar)
			'''«v.accessExpression.accessExpressions.join("[", "][", "]", [e|e.toCString])»'''
	}

	def dispatch memoryMacroUndef(BasicVariable v) {
			
	}
	
	def dispatch memoryMacroUndef(CodeGenVariable v) {
		if (!v.scalar) '''#undef «v.name»'''
	}
	
//	//rule for generating array accesses in flattened case
//	def arrayIndexing1D(CodeGenVariable v) {
//		//no access when scalar
//		if (!v.scalar) { '''[«v.arrayIndexingExpression1D.toCString»]''' }
//	}
//	
//	//rule for generating array accesses in non-flattened case
//	def arrayIndexingMD(CodeGenVariable v) {
//		if (!v.scalar) {
//			v.domain.indices.indexed.join("[", "][", "]", [i|v.indexingExpression(i.index0).toCString])
//		}
//	}
//	
//	//Generate expression for accessing flattened array
//	//Next two private methods are helper methods for this call
//	//This is done with Xtend so that IntExpression is constructed
//	// instead of String in the case if done in Xpand
//	//By constructing IntExpression, the resulting expression can be simplified
//	def IntExpression arrayIndexingExpression1D(CodeGenVariable v) {
//		return IntExpressionBuilder::sum(v.arrayIndexingExpression1DHelper().reverse).simplify
//	}
//	
//	def private List<IntExpression> arrayIndexingExpression1DHelper(CodeGenVariable v) {
//		val list = new ArrayList<IntExpression>()
//		
//		for (i : v.domain.indices.indexed)
//			list.add(v.indexingExpression(i.index0).mult(v.getVolumeExpression(i.index0+1)))
//		
//		return list
//	}
//
//	def private IntExpression mult(IntExpression A, IntExpression B) {
//		return IntExpressionBuilder::prod(A, B)
//	}
////	var.accessExpression.getIndexingExpression(dim);
//
//	def private IntExpression indexingExpression(CodeGenVariable v, int dim) {
//		return v.accessExpression.getIndexingExpression(dim)
//	}
//	
//	def private IntExpression getVolumeExpression(CodeGenVariable v, int startingDim) {
//		v.getVolumeExpression(startingDim, v.domain.NIndices)
//	}
	
}