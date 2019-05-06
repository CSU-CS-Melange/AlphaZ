package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCFunction
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable
import org.polymodel.polyhedralIR.polyIRCG.Function

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.*

class WrapperForMPICFunction extends WrapperCFunction {
	
	override code(Function func) '''
		//function prototypes
		«func.mainFunctionPrototype»
		
		//main
		int main(int argc, char** argv) {
			MPI_Init(&argc, &argv);
			int «pid»;
			MPI_Comm_rank(MPI_COMM_WORLD,&«pid»);
		
			«func.checkNumberOfArgs»
			
			«func.readParameters»
			
			«func.parameterCheck»
			
			«func.tilingHandling»
			
			«func.malloc»

			//Input Initialization
			«func.bodies.filter(b|b instanceof InputInitialization).join("", [b|(b as InputInitialization).inputInitialization])»
			
			//Broadcast
			«FOR v : func.inputs.filter(CodeGenVariable)»
				//broad case is not implemented right now
«««				//«val varName = if (v.MDallocation) {'''«LINEARIZED_ARRAY_PREFIX»«v.name»'''} else {v.name}»
«««				//MPI_Bcast(«varName», «v.getVolumeExpression(0, v.domain.NIndices).toCString», «v.MPITypeString», 0, MPI_COMM_WORLD);
			«ENDFOR»
			
			//Timing
			struct timeval time;
			double elapsed_time;
			
			//Call the main computation
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
			
			«func.mainFunctionCall»
		
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;

			//output and verification is only done in a processor
			if (pid == 0) {
				// timing information
				printf("Execution time : %lf sec.\n", elapsed_time);
				
				
				//Verification Run
				#ifdef «VERIFY_FLAG»
			    	«func.verifyFunctionCall»
				#endif
			    	
				#ifdef «CHECKING_FLAG»
			    	//Print Outputs
					«func.bodies.filter(b|b instanceof OutputPrinting).join("", [b|(b as OutputPrinting).printOutput])»
				#elif «VERIFY_FLAG»
					//Compare outputs for verification
					«func.bodies.filter(b|b instanceof OutputVerification).join("", [b|(b as OutputVerification).verifyOutput])»
			    #endif
		    }
		    
			«func.mfree»
			
			MPI_Finalize();
		}
	'''
	
}