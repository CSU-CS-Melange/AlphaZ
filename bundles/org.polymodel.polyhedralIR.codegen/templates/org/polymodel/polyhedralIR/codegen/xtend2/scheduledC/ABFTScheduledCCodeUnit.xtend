package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit
import com.google.inject.Inject

class ABFTScheduledCCodeUnit extends BaseCodeUnit {
	
	@Inject extension ABFTScheduledCFunction function
	
	public static ABFTCodeGenOptions options;
	
	override generate(CodeUnit unit) {
		val numSpatialDims = options.numDims
		val dataType = options.dataType
		'''
			«unit.commonIncludes»
			
			«IF isVerification(unit)»
				«unit.externalFunctionIncludeDeclarationsOnly»
			«ELSE»
				«unit.externalFunctionInclude»
			«ENDIF»
			
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
			
			// Error injection configuration variables
			«injectionSiteVariableDeclarations»
			
			// Error injection functions
			void flip(«options.dataType» *val) {
				int *bits;
				bits = (int*)val;
				*bits ^= 1 << BIT;
			}
			
			void inject(«dataType»«(0..<1+numSpatialDims).map['*'].join('')» Y) {
				«IF options.numDims == 1»
				«dataType» *val = &Y(T_INJ, I_INJ);
				«ELSEIF options.numDims == 2»
				«dataType» *val = &Y(T_INJ, I_INJ, J_INJ);
				«ELSEIF options.numDims == 3»
				«dataType» *val = &Y(T_INJ, I_INJ, J_INJ, K_INJ);
				«ENDIF»
				flip(val);
			}
			
			«FOR func : unit.functions.filter(f|!f.inlined)»
				«func.code»
			«ENDFOR»
			
			«unit.memoryMacroUndefs»
			
			«FOR param : unit.compileTimeParameters»
				«param.compileTimeParameterUndef»
			«ENDFOR»
			
			«unit.commonMacroUndefs»
		'''
	}
	
	def injectionSiteVariableDeclarations() {
		'''
		int T_INJ;
		int I_INJ;
		«IF options.numDims == 2»
		int J_INJ;
		«ELSEIF options.numDims == 3»
		int K_INJ;
		«ENDIF»
		int BIT;
		int SEED;
		'''
	}
	
	
}