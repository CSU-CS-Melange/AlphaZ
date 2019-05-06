package org.polymodel.polyhedralIR.codegen.xtend2

import org.polymodel.polyhedralIR.DATATYPE
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Indexed.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*

/**
 * Memory allocation and freeing are defined in this extension.
 */
class BaseMemoryAllocation {
		
	def variableWithMaxDim(Iterable<AbstractVariable> vars) {
		return vars.filter(CodeGenVariable).reduce(a,b|if (a.domain.NIndices > b.domain.NIndices) {a} else {b});
	}
	
	def reset(FlagVariableReset b) {
	'''
		«b.locals.filter(CodeGenVariable).filter[e|e.type == DATATYPE::CHAR].join("\n", [e|e.reset(false)])»
«««		«b.outputs.join("\n", [e|e.reset])»
	'''
	}
	
	def dispatch ofType(AbstractVariable t, DATATYPE dt) {
		
	}
	def dispatch ofType(CodeGenVariable v, DATATYPE dt) {
		v.type.typeID == dt
	}
	def dispatch ofType(BasicVariable v, DATATYPE dt) {
		v.type == dt.getName
	}
	
	def reset(AbstractVariable v, boolean isVariableInit) {
		''''''
	}
	
	// Variable init is copy of global variables given as function arguments into globals
	// and then to allocate memory 
	def malloc(VariableInitialization b) '''
		//Memory Allocation
		«val maxDim = b.locals.variableWithMaxDim»
		«IF maxDim != null»«declareMalloLoopIterators(maxDim.domain.NIndices)»«ENDIF»
		
		«b.locals.join("\n", [e|e.malloc+""])»
		«b.specialLocals.join("\n", [e|e.malloc(false)])»
	'''
	
	def declareMalloLoopIterators(int dim) {
		if (dim <= 0) return ''''''
		
		var decl = '''int '''
		var i = 0;
		while(i < dim) {
			if (i > 0) decl = '''«decl», '''
			i = i+1
			decl = '''«decl»«MALLOC_LOOP_INDEX»«i»'''
		}
		
		return '''«decl»;'''
	}
	
	def mfree(VariableFinalization b) '''
		«IF b.outputs.exists(e|e.global && e.isScalar)»
			//Copy scalars to output
			«FOR s : b.outputs.filter(e|e.global && e.isScalar)»
				*«TEMP_LOCAL_PREFIX»«s.name» = «s.name»;
			«ENDFOR»
		«ENDIF»
		
		//Memory Free
		«b.locals.join("\n", [e|e.mfree+""])»
		«b.specialLocals.join("\n", [e|e.mfree(true)])»
	'''
	
	def dispatch malloc(VRegister reg)'''
		«reg.getRegTypeString()» «reg.name»;
	'''
	
	def scalarAllocation(CodeGenVariable v, String varNamePostfix) {
		if (v.global) {
			''''''
		} else {
			'''«v.typeString» «v.name»«varNamePostfix»;'''
		}
	}
	
	def scalarAllocation(CodeGenVariable v) {
		return v.scalarAllocation("")
	}
		
	def malloc(AbstractVariable v) {
		v.malloc("", true)
	}
	
	def CharSequence malloc(AbstractVariable v, boolean allocate){
		v.malloc("", allocate)
	}
	
	/**
	 * verNamePostfix is used to add verify postfix
	 */
	def malloc(AbstractVariable v, String varNamePostfix) {
		v.malloc(varNamePostfix, true);
//		if (v.domain.NIndices == 0) {
//			return v.scalarAllocation(varNamePostfix)
//		}
		//linearlized volume
//		var vol = v.getVolumeExpression(0,v.domain.NIndices).toCString
		
		//allocates the linearlized version for multi-dimensional arrays
//		var varName = if (v.isMDallocation) {
//			'''«LINEARIZED_ARRAY_PREFIX»«v.name»«varNamePostfix»'''
//		} else {
//			'''«v.name»«varNamePostfix»'''
//		}
		
		//use single pointer for linearlized array
//		var typeDecl = if (v.isMDallocation) {
//			'''«v.type.CName»* '''
//		} else if (!v.global && !v.isMDallocation) {
//			'''«v.pointerType» '''
//		} else {
//			''''''
//		}  
//		'''
//			«malloc(typeDecl, varName, v.type.CName, vol)»
//			«IF v.isMDallocation»«v.mallocMD(varNamePostfix)»«ENDIF»
//		'''
	}
	
	def dispatch malloc(AbstractVariable v, String varNamePostfix, boolean allocate){
		'''/** malloc not imlemented for the given type **/'''
	}
	def dispatch malloc(CodeGenVariable v, String varNamePostfix, boolean allocate){
		if(v.domain.NIndices == 0){
			return v.scalarAllocation(varNamePostfix)
		}
		
		if(!allocate){	//variable declaration for specialized local variable
			var varName = '''«v.name»«varNamePostfix»'''
			var typeDecl = '''«v.pointerType» '''
			'''
				«variableDeclaration(typeDecl, varName)»
			'''
		}else{	//allocate memory for the variables
			if(v.isMDallocation){
				//linearize the memory allocation
				'''
					«v.mallocLinearlized(varNamePostfix)»
				'''
			}else{
				//linearize the memory allocation
				'''
					«v.malloc1D(varNamePostfix)»
				'''
			}
		}
	}
	
	def mallocLinearlized(CodeGenVariable v, String varNamePostfix){
		var varName = '''«LINEARIZED_ARRAY_PREFIX»«v.name»«varNamePostfix»'''
		var typeDecl = '''«v.type.CName»* '''
		
		//linearlized volume
		var vol = v.getVolumeExpression(0,v.domain.NIndices).toCString
		
		'''
			«malloc(typeDecl, varName, v.type.CName, vol, v.isAligned)»
			«IF v.isMDallocation»«v.mallocMD(varNamePostfix)»«ENDIF»
		'''
	}
	
	def malloc1D(CodeGenVariable v, String varNamePostfix){
		var varName = '''«v.name»«varNamePostfix»'''
		var typeDecl = if(!v.global){
			'''«v.pointerType» '''
		}else{
			''''''
		}
		
		var vol = v.getVolumeExpression(0,v.domain.NIndices).toCString
		
		'''
			«malloc(typeDecl, varName, v.type.CName, vol, v.isAligned)»
		'''
	}
	
	def protected variableDeclaration(CharSequence varDecl, CharSequence varName){
		'''
			«varDecl»«varName»;
		'''
	}
	
	/**
	 * Helper to do all malloc and mallocCheck in a consistent manner
	 */
//	def protected malloc(CharSequence varDecl, CharSequence varName, CharSequence type, CharSequence vol) {
//		'''
//			«varDecl»«varName» = («type»*)malloc(sizeof(«type»)*(«vol»));
//			mallocCheck(«varName», («vol»), «type»);
//		'''
//	}
	
	/**
	 * Helper to do all malloc and mallocCheck in a consistent manner
	 */
	def protected malloc(CharSequence varDecl, CharSequence varName, CharSequence type, CharSequence vol, boolean aligned) {
		'''
			«IF aligned»
			«varDecl»«varName» = («type»*)_mm_malloc(sizeof(«type»)*(«vol»), 64);
			«ELSE»
			«varDecl»«varName» = («type»*)malloc(sizeof(«type»)*(«vol»));
			«ENDIF»
			mallocCheck(«varName», («vol»), «type»);
		'''
	}
	
	//short hand for above
	def private malloc(CharSequence varName, CharSequence type, CharSequence vol) {
		malloc("", varName, type, vol, false);
	}
	
	def private mallocMD(CodeGenVariable v, String varNamePostfix) {
		if (v.domain.NIndices < 2) {
			throw new RuntimeException("Variables with 1D or less should not be allocated as MD arrays.")
		}
		var typeDecl = if (!v.global) { '''«v.pointerType» ''' } else { '''''' }
		var pointerType = v.getMDPointer(v.domain.NIndices - 1);
		var vol = v.getVolumeExpression(0,1).toCString
		var varName = '''«v.name»«varNamePostfix»'''
		'''
			«malloc(typeDecl, varName, pointerType, vol, false)»
			«v.mallocMDrecurse(varNamePostfix, 1)»
		'''
	}
	
	def private CharSequence mallocMDrecurse(CodeGenVariable v, String varNamePostfix, int dim) {
		var ite = '''«MALLOC_LOOP_INDEX»«dim»'''
		var UB = v.getVolumeExpression(dim-1, dim).toCString
		var access = '''«v.name»«varNamePostfix»«getMDmallocAccess(dim)»'''
		var pointerType = v.getMDPointer(v.domain.NIndices - dim - 1);
		
		//for recursing step
		var vol = v.getVolumeExpression(dim,dim+1).toCString
		//for final step
		var accessLin = v.getMallocAccessToLinearized(varNamePostfix)
		'''
			for («ite»=0;«ite» < «UB»; «ite»++) {
				«IF dim+1 < v.domain.NIndices»
					«malloc(access, pointerType, vol)»
					«v.mallocMDrecurse(varNamePostfix, dim+1)»
				«ELSE»
					«access» = &«accessLin»;
				«ENDIF»
			}
		'''
	}

	def private getMDmallocAccess(int dim) {
		var access = ''''''
		var i = 1;
		while (i <= dim) {
			access = '''«access»[«MALLOC_LOOP_INDEX»«i»]'''
			i = i+1;
		}
		return access
	}

	def private getMallocAccessToLinearized(CodeGenVariable v, String varNamePostfix) {
		var access = v.domain.indices.subList(0, v.domain.NIndices-1).indexed.join(
			" + ", [e|'''(«MALLOC_LOOP_INDEX»«e.index1»*(«v.getVolumeExpression(e.index1,v.domain.NIndices).toCString»))''']);
		'''«LINEARIZED_ARRAY_PREFIX»«v.name»«varNamePostfix»[«access»]'''
	}

	def private getMDPointer(CodeGenVariable v, int dim) {
		var pointers = ''''''
		var i = 1;
		while (i <= dim) {
			pointers = '''«pointers»*'''
			i = i+1;
		}
		'''«v.type.CName»«pointers»'''
	}
	
	def private getFirstMDmallocAccess(int dim) {
		var access = ''''''
		var i = 1;
		while (i <= dim) {
			access = '''«access»[0]'''
			i = i+1;
		}
		return access
	}
	
	def mfree(AbstractVariable v) {
		v.mfree("", false);
	}
	
	def mfree(AbstractVariable v, String varNamePostfix){
		v.mfree(varNamePostfix, false);
	}
	
	def mfree(AbstractVariable v, boolean isSpecial){
		v.mfree("", isSpecial);
	}
	
	def dispatch mfree(AbstractVariable v, String varNamePostfix, boolean isSpecial) {
		'''/** mfree not implemented for AbstractVariable **/'''
	}
	
	def dispatch mfree(CodeGenVariable v, String varNamePostfix, boolean isSpecial) {
		//no free for scalars
		if (v.domain.NIndices == 0) {
			return ''''''
		}
		
		//multi-dimensional special variable
		if(isSpecial && v.MDallocation){'''
			free(«v.name»«varNamePostfix»«getFirstMDmallocAccess(v.domain.NIndices - 1)»);
			«v.mfreeMD(varNamePostfix)»
		'''
		//multi-dimensional
		}else if(v.MDallocation) {'''
			«IF v.isAligned»_mm_free«ELSE»free«ENDIF»(«LINEARIZED_ARRAY_PREFIX»«v.name»«varNamePostfix»);
			«v.mfreeMD(varNamePostfix)»
		'''
		//flattenned case
		} else {
			if(v.isAligned){
				'''_mm_free(«v.name»«varNamePostfix»);''' 
			}else{
				'''free(«v.name»«varNamePostfix»);''' 
			}
		}
	}
	
	def private mfreeMD(CodeGenVariable v, String varNamePostfix) {
		'''
			«IF 2 < v.domain.NIndices»«v.mfreeMDrecurse(varNamePostfix, 1)»«ENDIF»
			free(«v.name»«varNamePostfix»);
		'''
	}
	
	def private mfreeMDrecurse(CodeGenVariable v,String varNamePostfix, int dim) {
		var ite = '''«MALLOC_LOOP_INDEX»«dim»'''
		var UB = v.getVolumeExpression(dim-1, dim).toCString
		var access = '''«v.name»«varNamePostfix»«getMDmallocAccess(dim)»'''
		
		'''
			for («ite»=0;«ite» < «UB»; «ite»++) {
				«IF dim+2 < v.domain.NIndices»
					«v.mfreeMDrecurse(varNamePostfix, dim+1)»
				«ENDIF»
				free(«access»);
			}
		'''
	}
}