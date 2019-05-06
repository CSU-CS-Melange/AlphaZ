package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs
import org.polymodel.polyhedralIR.polyIRCG.Struct

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*

class BaseCodeUnit {

	@Inject extension BaseFunction function
	@Inject extension BaseMemoryAccess memory
	

	def generate(CodeUnit unit) '''
		«unit.commonIncludes»
		
		«unit.externalFunctionInclude»
		
		«unit.commonMacroDefs»
		
		«unit.commonFuncDefs»
		
		«unit.headerDefs»
		
		«FOR param : unit.compileTimeParameters»
			«param.compileTimeParameterDef»
		«ENDFOR»
		
		«unit.globalVariablesDeclaration»
		
		«unit.subsystemFunctionDeclaration»
		
		«unit.localFunctionDeclaration»
		
		«unit.memoryMacroDefs»
		
		«FOR func : unit.functions.filter(f|!f.inlined)»
			«func.code»
		«ENDFOR»
		
		«unit.memoryMacroUndefs»
		
		«FOR param : unit.compileTimeParameters»
			«param.compileTimeParameterUndef»
		«ENDFOR»
		
		«unit.commonMacroUndefs»
	'''

	def commonIncludes(CodeUnit unit) '''
		// This file is generated from test alphabets program by code generator in alphaz
		// To compile this code, use -lm option for math library.
		
		// Includes
		#include <stdio.h>
		#include <stdlib.h>
		#include <stdbool.h>
		#include <math.h>
		#include <string.h>
		#include <limits.h>
		#include <float.h>
	'''
	
	def externalFunctionInclude(CodeUnit unit) {
		if (unit.compilationUnit.program.externalFunctionDeclarations.size > 0) {
			'''#include "«EXTERNAL_FUNCTION_HEADER_NAME»"'''	
		} else {
			''''''
		}
	}
	
	def commonMacroDefs(CodeUnit unit) '''
		// Common Macros
		#define max(x, y)   ((x)>(y) ? (x) : (y))
		#define MAX(x, y)	((x)>(y) ? (x) : (y))
		#define min(x, y)   ((x)>(y) ? (y) : (x))
		#define MIN(x, y)	((x)>(y) ? (y) : (x))
		#define CEILD(n,d)  (int)ceil(((double)(n))/((double)(d)))
		#define ceild(n,d)  (int)ceil(((double)(n))/((double)(d)))
		#define FLOORD(n,d) (int)floor(((double)(n))/((double)(d)))
		#define floord(n,d) (int)floor(((double)(n))/((double)(d)))
		#define CDIV(x,y)    CEILD((x),(y))
		#define div(x,y)    CDIV((x),(y))
		#define FDIV(x,y)    FLOORD((x),(y))
		#define LB_SHIFT(b,s)  ((int)ceild(b,s) * s)
		#define MOD(i,j)   ((i)%(j))
		#define mallocCheck(v,s,d) if ((v) == NULL) { printf("Failed to allocate memory for %s : size=%lu\n", "sizeof(d)*(s)", sizeof(d)*(s)); exit(-1); }
	'''
	
	def commonMacroUndefs(CodeUnit unit) '''
		//Common Macro undefs
		#undef max
		#undef MAX
		#undef min
		#undef MIN
		#undef CEILD
		#undef ceild
		#undef FLOORD
		#undef floord
		#undef CDIV
		#undef FDIV
		#undef LB_SHIFT
		#undef MOD
	'''
	
	def commonFuncDefs(CodeUnit unit) '''
		// Common functions for min and max
		//functions for integer max
		inline int __max_int(int x, int y){
			return ((x)>(y) ? (x) : (y));
		}
		
		inline short __max_short(short x, short y){
			return ((x)>(y) ? (x) : (y));
		}
		
		inline long __max_long(long x, long y){
			return ((x)>(y) ? (x) : (y));
		}
		
		inline unsigned int __max_unsigned_int(unsigned int x, unsigned int y){
			return ((x)>(y) ? (x) : (y));
		}
		
		inline unsigned short __max_unsigned_short(unsigned short x, unsigned short y){
			return ((x)>(y) ? (x) : (y));
		}
		
		//function for float max
		inline float __max_float(float x, float y){
			return ((x)>(y) ? (x) : (y));
		}
		
		//function for double max
		inline double __max_double(double x, double y){
			return ((x)>(y) ? (x) : (y));
		}
		
		//function for integer min
		inline int __min_int(int x, int y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline short __min_short(short x, short y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline long __min_long(long x, long y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline unsigned int __min_unsigned_int(unsigned int x, unsigned int y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline unsigned short __min_unsigned_short(unsigned short x, unsigned short y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline unsigned long __min_unsigned_long(unsigned long x, unsigned long y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline float __min_float(float x, float y){
			return ((x)>(y) ? (y) : (x));
		}
		
		inline double __min_double(double x, double y){
			return ((x)>(y) ? (y) : (x));
		}
	'''
	
	def globalVariablesDeclaration(CodeUnit unit) '''
		«IF unit.variables.exists(v|v.global)»
			///Global Variables
		«ENDIF»
		«FOR v : unit.variables.filter(v|v.global)»
			«IF v.scalar»
				static «v.typeString» «v.name»;
			«ELSE»
				static «v.pointerType» «v.name»;
			«ENDIF»
		«ENDFOR»
	'''
	
	def subsystemFunctionDeclaration(CodeUnit unit) '''
		«IF (unit.subsystemFunctions.size()>0)»
			//SubSystem Function Declarations
		«ENDIF»
		«FOR f : unit.subsystemFunctions»
			«function.prototype(f)»;
		«ENDFOR»
	'''
	
	def localFunctionDeclaration(CodeUnit unit) '''
		«IF (unit.functions.exists(f|!f.entryPoint))»
			//Local Function Declarations
		«ENDIF»
		«FOR f : unit.functions.filter(f|!f.entryPoint && !f.inlined)»
			«f.signature.prototype»;
		«ENDFOR»
	'''
	
	
	
	def memoryMacroDefs(CodeUnit unit) '''
		//Memory Macros
		«FOR v : unit.variables»
		«v.memoryMacroDef»
		«ENDFOR»	
	'''
	
	def memoryMacroUndefs(CodeUnit unit) '''
		//Memory Macros
		«FOR v : unit.variables»
		«v.memoryMacroUndef»
		«ENDFOR»	
	'''
	
	def compileTimeParameterDef(CompileTimeParameter param) {
		
	}
	
	def compileTimeParameterUndef(CompileTimeParameter param) {
		
	}
	
	def String filename(CodeUnit unit) {
		'''«unit.system.name».c'''.toString
	}
	
	
	def headerDefs(CodeUnit unit) {
		'''
			«FOR h : unit.headers»
				«h.header»
			«ENDFOR»
		'''
	}
	
	def dispatch header(CodeUnitHeader header) {
		
	}
	
	def dispatch header(DeclareStructs header) {
		'''
			«FOR ps : header.structs»
				«ps.structDef»
			«ENDFOR»	
		'''
	}
	
	def structDef(Struct s) {
		'''
			«s.name» {
				«FOR p : s.members»
					«p.asParameterType» «p.name»;
				«ENDFOR»
			};
		'''
	}
	
	
}