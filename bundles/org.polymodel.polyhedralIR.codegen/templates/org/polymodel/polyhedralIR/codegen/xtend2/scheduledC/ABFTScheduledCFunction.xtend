package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions
import org.polymodel.polyhedralIR.polyIRCG.Function

class ABFTScheduledCFunction extends BaseFunction {
	
	public static ABFTCodeGenOptions options;
	
	def isMainSystemFunction(Function func) {
		func.getCodeunit().getSystem().getName() == func.getName()
	}
	
	def override code(Function func) {
		val x = 123

		'''
			«func.functionSignature»{
				«IF isMainSystemFunction(func)»
				// Error injection configuration
				const char* ti = getenv("T_INJ");
				const char* ii = getenv("I_INJ");
				«IF options.numDims == 2»
				const char* ji = getenv("J_INJ");
				«ELSEIF options.numDims == 3»
				const char* ki = getenv("K_INJ");
				«ENDIF»
				const char* bit = getenv("BIT");
				const char* seed = getenv("SEED");
				if (ti==NULL) printf("T_INJ is not set\n");
				if (ii==NULL) printf("I_INJ is not set\n");
				«IF options.numDims == 2»
				if (ji==NULL) printf("J_INJ is not set\n");
				«ELSEIF options.numDims == 3»
				if (ki==NULL) printf("K_INJ is not set\n");
				«ENDIF»
				if (bit==NULL) printf("bit is not set\n");
				T_INJ = atoi(ti);
				I_INJ = atoi(ii);
				«IF options.numDims == 2»
				J_INJ = atoi(ji);
				«ELSEIF options.numDims == 3»
				K_INJ = atoi(ki);
				«ENDIF»
				BIT = atoi(bit);
				if (seed==NULL) {
					SEED = 0;
				} else {
					SEED = atoi(seed);
				}
			«ENDIF»
				
				«func.functionBody»
			}
		'''

	}
}