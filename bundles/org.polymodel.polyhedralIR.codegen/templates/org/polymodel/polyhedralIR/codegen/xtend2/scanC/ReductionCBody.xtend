package org.polymodel.polyhedralIR.codegen.xtend2.scanC

import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody
import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation

class ReductionCBody extends ScanCBody {
	
	@Inject extension BaseMemoryAllocation malloc
	
	override dispatch code(ScanBody b) '''
		//Get the number of threads
		int «b.nthreadVariableName»;
		#pragma omp parallel
		{
			#pragma omp single
			{
				«b.nthreadVariableName» = omp_get_num_threads();
			}
		}
		
		
		//declare memory for global variables used in the middle phrase
		«FOR v : b.localScanReductionVariables»
			«v.malloc»
		«ENDFOR»
		
		//index array to save the results
		int *index = (int *)malloc((«b.nthreadVariableName»)*sizeof(int));
		
		//PUT THE INITIAL VALUE BACK
		«b.scanReductionBody.initValueCopy»
		
		#pragma omp parallel
		{
			//GET THE THREAD NUMBER
			int «b.threadNumVariableName» = omp_get_thread_num();
			
			//COMPUTE THE INDEX VALUE OF EACH THREAD
			double blocksize;
			double «b.boundComputationFunction.constantTerm.name»;
			int «b.volumeFunction.unknown.name»;
		
			
			//compute the blocksize
			blocksize = (double)«b.originDomainVolume.function.name»(«b.originDomainVolume.functionParameters»);
			blocksize = blocksize/(double)(«b.nthreadVariableName»);
			
			int «b.boundComputationFunction.lb.name» = «b.domain.getBounds(0).get(0)»;
			int «b.boundComputationFunction.ub.name» = «b.domain.getBounds(0).get(1)»;
			int «b.boundComputationFunction.initialValue.getName()» = («b.boundComputationFunction.ub.name» - «b.boundComputationFunction.lb.name»)/(«b.nthreadVariableName»+1)*(«b.threadNumVariableName»);
			
			constantTerm = blocksize*(«b.threadNumVariableName»);
			index[«b.threadNumVariableName»] = «b.boundComputationFunction.function.name»(«b.boundComputationFunction.functionParameters»);
			#pragma omp barrier
			int «b.beginVariableName», «b.endVariableName»;
			
			//Compute the initialization vector
			«FOR v : b.scanReductionBody.initTempVariables»
				«v.malloc»
			«ENDFOR»
			
			//initialize the inidices	
			if («b.threadNumVariableName» == 0) {
				«b.beginVariableName» = «b.boundComputationFunction.lb.name»;
			} else {
				«b.beginVariableName» = index[«b.threadNumVariableName»];
			}
			
			if («b.threadNumVariableName» == («b.nthreadVariableName»-1)) {
				«b.endVariableName» = «b.boundComputationFunction.ub.name»;
			} else {
			    «b.endVariableName» = index[«b.threadNumVariableName» + 1];
			}
			
			«FOR v : b.localReductionVariables»
				«v.malloc»
			«ENDFOR»
			
			//CALL THE REDUCTION FUNCTION
			«b.localReductionFunction.name»(«b.localReductionFunction.functionParameters»);
				
			//THE REDUCTION SCAN PHASE
			«b.scanReductionBody.preProcessLoop.code»
			
		
			#pragma omp barrier
			#pragma omp single
			{
				«FOR v :b.scanReductionBody.matrixTempVariables»
					«v.malloc»
				«ENDFOR»
				
				«b.scanReductionBody.matrixInitLoop.code»
				
				«b.scanReductionBody.scanLoop.code»
				
				«b.scanReductionBody.postProcessLoop.code»
				
				«FOR v : b.scanReductionBody.matrixTempVariables»
					«v.mfree»
				«ENDFOR»
			}
			
			#pragma omp barrier
			
			«FOR  v : b.localReductionVariables»
				«v.mfree»
			«ENDFOR»
		}
		
		//free the variables
		«FOR v : b.localScanReductionVariables»
			«v.mfree»
		«ENDFOR»
	'''
}