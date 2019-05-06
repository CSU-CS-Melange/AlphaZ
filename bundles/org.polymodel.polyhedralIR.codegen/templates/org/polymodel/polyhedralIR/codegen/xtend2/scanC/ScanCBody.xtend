package org.polymodel.polyhedralIR.codegen.xtend2.scanC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import com.google.inject.Inject
import org.polymodel.polyhedralIR.polyIRCG.Function

class ScanCBody extends BaseBody {
	
	@Inject extension BaseMemoryAllocation malloc
	
	def protected functionParameters(Function f){
		f.signature.parameters.join(", ", [p|p.asParameter])
	}
	def protected functionParameters(OriginDomainVolume b){
		b.function.functionParameters
	}
	def protected functionParameters(VolumeFunction b){
		b.function.functionParameters
	}
	def protected functionParameters(VolumeFunctionDerivative b){
		b.function.functionParameters
	}
	def protected functionParameters(BoundComputation b){
		b.function.functionParameters
	}
	
	def dispatch code(OriginDomainVolume b) '''
		int volume = 0;
		
		//volume function(Modify by hand)
		volume =  100;
		
		return volume;
	'''
	
	def dispatch code(VolumeFunction b) '''
		int volume = 0;
		
		//volume function(Modify by hand)
		volume = «b.unknown.name»*«b.unknown.name» + 10;
		
		return volume;
	'''
	
	def dispatch code(VolumeFunctionDerivative b) '''
		int volume = 0;
		
		//derivative of the volume function(Modify by hand)
		volume = 2*«b.unknown.name»;
		
		return volume;
	'''
	
	def dispatch code(BoundComputation b) '''
		double fx, df, dx;
		double xn = 0.0;
		
		//find the init value
		double «b.volumeFunction.unknown.name»;
		«/* 
		int i;
		for(i = «lb.getName()»; i < «ub.getName()»; i++){
			«i» = (double)i;
			double val = «volumeFunction.name»(«FOREACH volumeFunction.signature.parameters AS par SEPARATOR ','»«par.getName()»«ENDFOREACH») - «ConstantTerm.getName()»;
			
			if(val == 0.0){
				return «i»;//find root
			}
	
	        if(val > 0.0){
	        	xn = (double)(2*«i»-1)/2.0;
	        	break;
	        	}
		}
		«ENDLET»
		
		#ifdef DEBUG
			printf("the initial root is %.5f:", xn);
		#endif
	   
	    x = xn;
	     */»
		x = «b.initialValue.name»;
		double val = «b.volumeFunction.function.name»(«b.volumeFunction.functionParameters») - «b.constantTerm.name»;
		if(val == 0.0) {
			return x;
		}
		
		//compute the root
		int iter;
		for (iter = 0; iter < MAX_ITER; iter++) {
			fx = «b.volumeFunction.function.name»(«b.volumeFunction.functionParameters») -  «b.constantTerm.name»;
			df = «b.volumeFunctionDerivative.function.name»(«b.volumeFunctionDerivative.functionParameters»);
			
			dx = -fx/df;
			x += dx;
			
			#ifdef DEBUG
				printf("root at iter %d: %.5f\n", iter, x);
			#endif
			
			if(fabs(dx)<eps){
				#ifdef DEBUG
					printf("found root %.5f after %d attempts\n", x, iter);
				#endif
				break;
			}
		}
		
		return (int)(x + 0.5);
	'''
	
	def dispatch code(ScanBody b) '''
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
		«b.scanReductionBody.initValueCopy.code»
		
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
			blocksize = blocksize/(double)(«b.nthreadVariableName»+1);
			
			int «b.boundComputationFunction.lb.name» = «b.domain.getBounds(0).get(0)»;
			int «b.boundComputationFunction.ub.name» = «b.domain.getBounds(0).get(1)»;
			int «b.boundComputationFunction.initialValue.getName()» = («b.boundComputationFunction.ub.name» - «b.boundComputationFunction.lb.name»)/(«b.nthreadVariableName»+1)*(«b.threadNumVariableName»+1);
			
			constantTerm = blocksize*(«b.threadNumVariableName»+1);
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
				«b.beginVariableName» = index[«b.threadNumVariableName» - 1];
			}
			
			«/*REM
			if(«threadNumVariableName» == «nthreadVariableName» - 1){
				«endVariableName» = «boundComputationFunction.ub.getName()» + 1;
			}else{
				«endVariableName» = index[«threadNumVariableName»];
			}
			«ENDREM*/»
			«b.endVariableName» = index[«b.threadNumVariableName»];
			
			if («b.threadNumVariableName»==0) {
				//INITIALIZE THE INITIALIZATION VALUE
				«b.scanReductionBody.assignmentLoop.code»
				
				//CALL THE SCAN FUNCTION
				«b.localScanFunction.name»(«b.localScanFunction.functionParameters»);
				
				//GET THE NEW INITIALIZATION VALUE
				«b.scanReductionBody.initValueUpdate.code»
			} else {
				«FOR v : b.localReductionVariables»
					«v.malloc»
				«ENDFOR»
			
				//CALL THE REDUCTION FUNCTION
				«b.localReductionFunction.name»(«b.localReductionFunction.functionParameters»);
				
				//THE REDUCTION SCAN PHASE
				«b.scanReductionBody.preProcessLoop.code»
			}
			
			
			«/*REM»
			«FOREACH localReductionVariables AS var»
				«EXPAND template::c::genericC::malloc FOR var»
			«ENDFOREACH»
			
			//CALL THE REDUCTION FUNCTION
			«localReductionFunction.name»(«FOREACH localReductionFunction.signature.parameters AS  par SEPARATOR ','»«par.asParameter()»«ENDFOREACH»);«ENDREM»
			«REM»
			//THE REDUCTION SCAN PHASE
			«EXPAND template::c::genericC::body FOR scanReductionBody.preProcessLoop»
			«ENDREM*/»
			
			#pragma omp barrier
			#pragma omp single
			{
				«FOR v : b.scanReductionBody.matrixTempVariables »
					«v.malloc»
				«ENDFOR»
				
				«b.scanReductionBody.scanLoop.code»
				
				«FOR v : b.scanReductionBody.matrixTempVariables»
					«v.mfree»
				«ENDFOR»
			}
			
			#pragma omp barrier
			«/*REM»
			//Compute the initialization vector
			«FOREACH scanReductionBody.initTempVariables AS var»
				«EXPAND template::c::genericC::malloc FOR var»
			«ENDFOREACH»	
			«ENDREM*/»
			
			//get the new index value
			«b.beginVariableName» = index[«b.threadNumVariableName»];
			«b.endVariableName» = index[«b.threadNumVariableName»+1];
			if («b.threadNumVariableName»== «b.nthreadVariableName» - 1) {
				«b.endVariableName» = «b.boundComputationFunction.ub.name» + 1;
			}
			
			if («b.threadNumVariableName»==0) {
				«b.scanReductionBody.assignmentLoop.code»
			} else {
				«b.scanReductionBody.postProcessLoop.code»
			}
			
			//CALL THE SCAN FUNCTION
			«b.localScanFunction.name»(«b.localScanFunction.functionParameters»);
			
			«FOR v :  b.localReductionVariables»
				«v.mfree»
			«ENDFOR»
		}
		
		//free the variables
		«FOR v : b.localScanReductionVariables»
			«v.mfree»
		«ENDFOR»
	'''
	
}