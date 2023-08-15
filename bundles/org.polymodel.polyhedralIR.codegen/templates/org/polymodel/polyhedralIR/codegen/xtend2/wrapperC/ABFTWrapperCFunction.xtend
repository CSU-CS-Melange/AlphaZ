package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions

import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import java.util.Map
import java.util.HashMap
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification

class ABFTWrapperCFunction extends WrapperCFunction {
	
	public static ABFTCodeGenOptions options;
	
	@Inject extension BaseDomain domainExtensions
	@Inject extension BaseIndices indices
	@Inject extension BaseMemoryAllocation memory
	@Inject extension BaseBody body
	
	
	override code(Function func) {
		val dType = options.dataType
		val ret = '''
			«IF options.numDims == 1»
			void init(long, long, long, long, «dType»*, «dType»*, «dType»*);
			void conv(long, long, «dType»*, «dType»*, «dType»*);
			«ELSEIF options.numDims == 2»
			void init(long, long, long, long, long, long, long, «dType»**, «dType»**, «dType»**);
			void conv(long, long, long, long, «dType»**, «dType»**, «dType»**);
			«ELSEIF options.numDims == 3»
			void init(long, long, long, long, long, long, long, long, long, long, «dType»***, «dType»***, «dType»***);
			void conv(long, long, long, long,  long, long, «dType»***, «dType»***, «dType»***);
			«ENDIF»
			
			double ERR_DETECTION_THRESHOLD;
			
			«super.code(func)»
		'''
		return ret
	}
	
	def Map<String,Double> parseKernel(String[] kernel) {
		val numDims = kernel.get(0).split(',').size - 2
		val ret = new HashMap<String,Double>
		for (point : kernel) {
			val key = (1..<1+numDims).map[point.split(',').get(it)].join(',')
			val value = Double.parseDouble(point.split(',').get(1+numDims))
			ret.put(key, value)
		}
		ret
	}
	
	def List<Long> computeRadius(Map<String,Double> kernel) {

		
		val numDims = kernel.keySet.get(0).split(',').size
		val radius = (0..<numDims).map[new ArrayList<Long>].toList
		
		for (key : kernel.keySet) {
			val pieces = key.split(',').map[Long.parseLong(it)].toList
			for (i : 0..<pieces.size) {
				radius.get(i).add(pieces.get(i))
			}
			
		}
		val ret = radius.map[it.reduce(v0,v1|Math.max(v0,v1))].toList
		ret
	}
	
	def Map<String,Double> shiftKernel(Map<String,Double> kernel, List<Long> radius) {
		val ret = new HashMap<String,Double>
		val numDims = kernel.keySet.get(0).split(',').size
		for (key : kernel.keySet) {
			val shiftedKey = (0..<numDims).map[Long.parseLong(key.split(',').get(it)) + radius.get(it)].join(',')
			ret.put(shiftedKey, kernel.get(key))
		}
		ret
	} 
	
	
	
	def inputInitialization_OLD(InputInitialization b) {
		var accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])
		var macroIndex = b.specialVar.varDecl.domain.macroIndices
		var macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])  
		var macroName = b.statements.get(0).name
		val varName = b.specialVar.varDecl.varID.name
		val patchVarAccess = b.specialVar.getMemoryAccessExpressions.join("][", [e|e.toString])
		val patchSize = options.patchSize.split(',').map[Integer.parseInt(it)]
		val kernel = options.kernel.split(';')
		'''
			«IF varName.equals(options.weightsVar)»
			{
				#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(accessIndex, false)» = «options.patchVar»[«patchVarAccess»])
				
				FILE *kernel_file = fopen("kernel.in.txt", "w");
				fprintf(kernel_file, "«options.cT»\n");
				fprintf(kernel_file, "«options.cJx»\n");
				«FOR row : kernel»
				fprintf(kernel_file, "«row»\n");
				«ENDFOR»
				fclose(kernel_file);
				
				«options.dataType» patch[«patchSize.join('][')»];
				int status = system("/Users/ln/git/virtual-islpy/bin/python /Users/ln/bin/patchlib.py");
				FILE *file = fopen("patch.block", "rb");
				fread(patch, sizeof(«options.dataType»), «patchSize.reduce(p0,p1|p0*p1)», file);
				fclose(file);
				
				remove("kernel.in.txt");
				remove("patch.block");
			«ELSE»
			{
				#if defined («RANDOM_FLAG»)
					#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(accessIndex, false)» = rand()«IF options.dataType.equals("int")» % 10«ENDIF») 
				#elif defined («CHECKING_FLAG») || defined («VERIFY_FLAG»)
					«b.userInput(macroName, macroIndexB, macroIndex, accessIndex)»
				#else
					#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(macroIndex, false)» = 1)   //Default value
				#endif
			«ENDIF»
			
				«b.generateLoopNest»
				#undef «macroName»
			}
		'''
	}
	
	def override inputInitialization(InputInitialization b) {
		var accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])
		var macroIndex = b.specialVar.varDecl.domain.macroIndices
		var macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])  
		var macroName = b.statements.get(0).name
		val varName = b.specialVar.varDecl.varID.name
		val varAccess = b.specialVar.getMemoryAccessExpressions.join("][", [e|e.toString])
		'''
			«IF varName.equals(options.weightsVar)»
			{
				«IF options.numDims == 1»
				«weightVarComputation1d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess)»
				«ELSEIF options.numDims == 2»
				«weightVarComputation2d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess)»
				«ELSEIF options.numDims == 3»
				«weightVarComputation3d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess)»
				«ENDIF»
				
				#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(accessIndex, false)» = «options.patchVar»[«varAccess»])
			«ELSE»
			{
				#if defined («RANDOM_FLAG»)
					#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(accessIndex, false)» = rand()«IF options.dataType.equals("int")» % 10«ENDIF») 
				#elif defined («CHECKING_FLAG») || defined («VERIFY_FLAG»)
					«b.userInput(macroName, macroIndexB, macroIndex, accessIndex)»
				#else
					#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(macroIndex, false)» = 1)   //Default value
				#endif
			«ENDIF»
			
				«b.generateLoopNest»
				#undef «macroName»
				«IF varName.equals(options.weightsVar)»
				#undef swap
				#undef kernel
				
				«IF options.numDims == 1»
				«free1d»
				«ELSEIF options.numDims == 2»
				«free2d»
				«ELSEIF options.numDims == 3»
				«free3d»
				«ENDIF»
				«ENDIF»
			}
		'''
	}
	
	def weightVarComputation3d(InputInitialization b, String accessIndex, CharSequence macroIndex, 
			String macroIndexB, String macroName, String varName, String varAccess) {
		val dType = options.dataType
		val kernel = options.kernel.split(';')
		val kernelMap = parseKernel(kernel)
		val radius = computeRadius(kernelMap)
		val shiftedKernelMap = shiftKernel(kernelMap, radius)
		val ret = '''
			long _P0 = «options.cT»;
			long _N0 = «options.cJx.split(',').get(0)»;
			long _K0 = «radius.get(0)»;
			long _PK0 = _P0*_K0;
			long _P1 = «options.cT»;
			long _N1 = «options.cJx.split(',').get(1)»;
			long _K1 = «radius.get(1)»;
			long _PK1 = _P1*_K1;
			long _P2 = «options.cT»;
			long _N2 = «options.cJx.split(',').get(2)»;
			long _K2 = «radius.get(2)»;
			long _PK2 = _P2*_K2;
			
			int padded_kernel_L0 = (2*(_PK0)+1);
			int padded_kernel_L1 = (2*(_PK1)+1);
			int padded_kernel_L2 = (2*(_PK2)+1);
			int patch_L0 = _N0+2*_PK0;
			int patch_L1 = _N1+2*_PK1;
			int patch_L2 = _N2+2*_PK2;
			
			«dType»* _lin_kernel = («dType»*)malloc(sizeof(«dType»)*((2*_K0+1) * (2*_K1+1) * (2*_K2+1)));
			mallocCheck(_lin_kernel, ((2*_K0+1) * (2*_K1+1) * (2*_K2+1)), «dType»);
			«dType»*** kernel = («dType»***)malloc(sizeof(«dType»**)*(2*_K0+1));
			mallocCheck(kernel, (2*_K0+1), «dType»**);
			for (mz1=0;mz1 < 2*_K0+1; mz1++) {
				kernel[mz1] = («dType»**)malloc(sizeof(«dType»*)*(2*_K1+1));
				mallocCheck(kernel[mz1], (2*_K1+1), «dType»*);
				for (mz2=0;mz2 < 2*_K1+1; mz2++) {
					kernel[mz1][mz2] = &_lin_kernel[(mz1*((2*_K1+1) * (2*_K2+1))) + (mz2*(2*_K2+1))];
				}
			}
			«dType»* _lin_padded_kernel = («dType»*)malloc(sizeof(«dType»)*((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)));
			mallocCheck(_lin_padded_kernel, ((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)), «dType»);
			«dType»*** padded_kernel = («dType»***)malloc(sizeof(«dType»**)*(2*_PK0+1));
			mallocCheck(padded_kernel, (2*_PK0+1), «dType»**);
			for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
				padded_kernel[mz1] = («dType»**)malloc(sizeof(«dType»*)*(2*_PK1+1));
				mallocCheck(padded_kernel[mz1], (2*_PK1+1), «dType»*);
				for (mz2=0;mz2 < 2*_PK1+1; mz2++) {
					padded_kernel[mz1][mz2] = &_lin_padded_kernel[(mz1*((2*_PK1+1) * (2*_PK2+1))) + (mz2*(2*_PK2+1))];
				}
			}
			«dType»* _lin_padded_kernel_cp = («dType»*)malloc(sizeof(«dType»)*((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)));
			mallocCheck(_lin_padded_kernel_cp, ((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)), «dType»);
			«dType»*** padded_kernel_cp = («dType»***)malloc(sizeof(«dType»**)*(2*_PK0+1));
			mallocCheck(padded_kernel_cp, (2*_PK0+1), «dType»**);
			for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
				padded_kernel_cp[mz1] = («dType»**)malloc(sizeof(«dType»*)*(2*_PK1+1));
				mallocCheck(padded_kernel_cp[mz1], (2*_PK1+1), «dType»*);
				for (mz2=0;mz2 < 2*_PK1+1; mz2++) {
					padded_kernel_cp[mz1][mz2] = &_lin_padded_kernel_cp[(mz1*((2*_PK1+1) * (2*_PK2+1))) + (mz2*(2*_PK2+1))];
				}
			}
			«dType»* _lin_patch = («dType»*)malloc(sizeof(«dType»)*((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)));
			mallocCheck(_lin_patch, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)), «dType»);
			«dType»*** patch = («dType»***)malloc(sizeof(«dType»**)*(_N0+2*_PK0+0));
			mallocCheck(patch, (_N0+2*_PK0+0), «dType»**);
			for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
				patch[mz1] = («dType»**)malloc(sizeof(«dType»*)*(_N1+2*_PK1+0));
				mallocCheck(patch[mz1], (_N1+2*_PK1+0), «dType»*);
				for (mz2=0;mz2 < _N1+2*_PK1+0; mz2++) {
					patch[mz1][mz2] = &_lin_patch[(mz1*((_N1+2*_PK1+0) * (_N2+2*_PK2+0))) + (mz2*(_N2+2*_PK2+0))];
				}
			}
			«dType»* _lin_patch_cp = («dType»*)malloc(sizeof(«dType»)*((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)));
			mallocCheck(_lin_patch_cp, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)), «dType»);
			«dType»*** patch_cp = («dType»***)malloc(sizeof(«dType»**)*(_N0+2*_PK0+0));
			mallocCheck(patch_cp, (_N0+2*_PK0+0), «dType»**);
			for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
				patch_cp[mz1] = («dType»**)malloc(sizeof(«dType»*)*(_N1+2*_PK1+0));
				mallocCheck(patch_cp[mz1], (_N1+2*_PK1+0), «dType»*);
				for (mz2=0;mz2 < _N1+2*_PK1+0; mz2++) {
					patch_cp[mz1][mz2] = &_lin_patch_cp[(mz1*((_N1+2*_PK1+0) * (_N2+2*_PK2+0))) + (mz2*(_N2+2*_PK2+0))];
				}
			}
			«dType»*** _tmp;
						
			#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)
			#define kernel(«accessIndex») kernel[«varAccess»]
			
			«FOR key : shiftedKernelMap.keySet»
			kernel(«key») = «shiftedKernelMap.get(key)»;
			«ENDFOR»
			
			// initialize the buffers with appropriate padding
			init(_P0, _N0, _N1, _N2, _K0, _K1, _K2, _PK0, _PK1, _PK2, kernel, padded_kernel, «options.patchVar»);
			
			// precompute the self-convolution of the kernel _P0=«options.cT» times
			for (int p=1; p<_P0; p++) {
			    conv(_K0, _K1, _K2, padded_kernel_L0, padded_kernel_L1, padded_kernel_L2, kernel, padded_kernel, padded_kernel_cp);
			    swap(padded_kernel, padded_kernel_cp);
			}
			conv(_PK0, _PK1, _PK2, patch_L0, patch_L1, patch_L2, padded_kernel, «options.patchVar», «options.patchVar»_cp);
			swap(«options.patchVar», «options.patchVar»_cp);
			
		'''
		return ret
	}
	
	def weightVarComputation2d(InputInitialization b, String accessIndex, CharSequence macroIndex, 
			String macroIndexB, String macroName, String varName, String varAccess) {
		val dType = options.dataType
		val kernel = options.kernel.split(';')
		val kernelMap = parseKernel(kernel)
		val radius = computeRadius(kernelMap)
		val shiftedKernelMap = shiftKernel(kernelMap, radius)
		val ret = '''
			long _P0 = «options.cT»;
			long _N0 = «options.cJx.split(',').get(0)»;
			long _K0 = «radius.get(0)»;
			long _PK0 = _P0*_K0;
			long _P1 = «options.cT»;
			long _N1 = «options.cJx.split(',').get(1)»;
			long _K1 = «radius.get(1)»;
			long _PK1 = _P1*_K1;
			
			int padded_kernel_L0 = (2*(_PK0)+1);
			int padded_kernel_L1 = (2*(_PK1)+1);
			int patch_L0 = _N0+2*_PK0;
			int patch_L1 = _N1+2*_PK1;
			
			«dType»* _lin_kernel = («dType»*)malloc(sizeof(«dType»)*((2*_K0+1) * (2*_K1+1)));
			mallocCheck(_lin_kernel, ((2*_K0+1) * (2*_K1+1)), «dType»);
			«dType»** kernel = («dType»**)malloc(sizeof(«dType»*)*(2*_K0+1));
			mallocCheck(kernel, (2*_K0+1), «dType»*);
			for (mz1=0;mz1 < 2*_K0+1; mz1++) {
				kernel[mz1] = &_lin_kernel[(mz1*(2*_K1+1))];
			}
			«dType»* _lin_padded_kernel = («dType»*)malloc(sizeof(«dType»)*((2*_PK0+1) * (2*_PK1+1)));
			mallocCheck(_lin_padded_kernel, ((2*_PK0+1) * (2*_PK1+1)), «dType»);
			«dType»** padded_kernel = («dType»**)malloc(sizeof(«dType»*)*(2*_PK0+1));
			mallocCheck(padded_kernel, (2*_PK0+1), «dType»*);
			for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
				padded_kernel[mz1] = &_lin_padded_kernel[(mz1*(2*_PK1+1))];
			}
			«dType»* _lin_padded_kernel_cp = («dType»*)malloc(sizeof(«dType»)*((2*_PK0+1) * (2*_PK1+1)));
			mallocCheck(_lin_padded_kernel_cp, ((2*_PK0+1) * (2*_PK1+1)), «dType»);
			«dType»** padded_kernel_cp = («dType»**)malloc(sizeof(«dType»*)*(2*_PK0+1));
			mallocCheck(padded_kernel_cp, (2*_PK0+1), «dType»*);
			for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
				padded_kernel_cp[mz1] = &_lin_padded_kernel_cp[(mz1*(2*_PK1+1))];
			}
			«dType»* _lin_patch = («dType»*)malloc(sizeof(«dType»)*((_N0+2*_PK0+0) * (_N1+2*_PK1+0)));
			mallocCheck(_lin_patch, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0)), «dType»);
			«dType»** patch = («dType»**)malloc(sizeof(«dType»*)*(_N0+2*_PK0+0));
			mallocCheck(patch, (_N0+2*_PK0+0), «dType»*);
			for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
				patch[mz1] = &_lin_patch[(mz1*(_N1+2*_PK1+0))];
			}
			«dType»* _lin_patch_cp = («dType»*)malloc(sizeof(«dType»)*((_N0+2*_PK0+0) * (_N1+2*_PK1+0)));
			mallocCheck(_lin_patch_cp, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0)), «dType»);
			«dType»** patch_cp = («dType»**)malloc(sizeof(«dType»*)*(_N0+2*_PK0+0));
			mallocCheck(patch_cp, (_N0+2*_PK0+0), «dType»*);
			for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
				patch_cp[mz1] = &_lin_patch_cp[(mz1*(_N1+2*_PK1+0))];
			}
			«dType»** _tmp;
						
			#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)
			#define kernel(«accessIndex») kernel[«varAccess»]
			
			«FOR key : shiftedKernelMap.keySet»
			kernel(«key») = «shiftedKernelMap.get(key)»;
			«ENDFOR»
			
			// initialize the buffers with appropriate padding
			init(_P0, _N0, _N1, _K0, _K1, _PK0, _PK1, kernel, padded_kernel, «options.patchVar»);
			
			// precompute the self-convolution of the kernel _P0=«options.cT» times
			for (int p=1; p<_P0; p++) {
			    conv(_K0, _K1, padded_kernel_L0, padded_kernel_L1, kernel, padded_kernel, padded_kernel_cp);
			    swap(padded_kernel, padded_kernel_cp);
			}
			conv(_PK0, _PK1, patch_L0, patch_L1, padded_kernel, «options.patchVar», «options.patchVar»_cp);
			swap(«options.patchVar», «options.patchVar»_cp);
			
		'''
		return ret
	}
	
	def weightVarComputation1d(InputInitialization b, String accessIndex, CharSequence macroIndex, 
			String macroIndexB, String macroName, String varName, String varAccess) {
		val dType = options.dataType
		val kernel = options.kernel.split(';')
		val kernelMap = parseKernel(kernel)
		val radius = computeRadius(kernelMap)
		val shiftedKernelMap = shiftKernel(kernelMap, radius)
		val ret = '''
			long _P0 = «options.cT»;
			long _N0 = «options.cJx.split(',').get(0)»;
			long _K0 = «radius.get(0)»;
			long _PK0 = _P0*_K0;
			
			int padded_kernel_L0 = 2*(_PK0)+1;
			int patch_L0 = _N0+2*_PK0;
			
			«dType»* kernel = («dType»*)malloc(sizeof(«dType»)*(2*_K0+1));
			mallocCheck(kernel, (2*_K0+1), «dType»);
			«dType»* padded_kernel = («dType»*)malloc(sizeof(«dType»)*(2*_PK0+1));
			mallocCheck(padded_kernel, (2*_PK0+1), «dType»);
			«dType»* padded_kernel_cp = («dType»*)malloc(sizeof(«dType»)*(2*_PK0+1));
			mallocCheck(padded_kernel_cp, (2*_PK0+1), «dType»);
			«dType»* patch = («dType»*)malloc(sizeof(«dType»)*(_N0+2*_PK0+0));
			mallocCheck(patch, (_N0+2*_PK0+0), «dType»);
			«dType»* patch_cp = («dType»*)malloc(sizeof(«dType»)*(_N0+2*_PK0+0));
			mallocCheck(patch_cp, (_N0+2*_PK0+0), «dType»);
			«dType»* _tmp;
			
			#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)
			#define kernel(«accessIndex») kernel[«varAccess»]
			
			«FOR key : shiftedKernelMap.keySet»
			kernel(«key») = «shiftedKernelMap.get(key)»;
			«ENDFOR»
			
			// initialize the buffers with appropriate padding
			init(_P0, _N0, _K0, _PK0, kernel, padded_kernel, «options.patchVar»);
			
			// precompute the self-convolution of the kernel _P0=«options.cT» times
			for (int p=1; p<_P0; p++) {
			    conv(_K0, padded_kernel_L0, kernel, padded_kernel, padded_kernel_cp);
			    swap(padded_kernel, padded_kernel_cp);
			}
			conv(_PK0, patch_L0, padded_kernel, «options.patchVar», «options.patchVar»_cp);
			swap(«options.patchVar», «options.patchVar»_cp);
		'''
		return ret
	}
	
	def free1d() '''
		//Memory Free
		free(kernel);
		free(padded_kernel);
		free(patch);
	'''
	
	def free2d() '''
		//Memory Free
		free(_lin_kernel);
		free(kernel);
		free(_lin_padded_kernel);
		free(padded_kernel);
		free(_lin_patch);
		free(patch);
	'''
	
	def free3d() '''
		//Memory Free
		free(_lin_kernel);
		for (mz1=0;mz1 < 2*_K0+1; mz1++) {
			free(kernel[mz1]);
		}
		free(kernel);
		free(_lin_padded_kernel);
		for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
			free(padded_kernel[mz1]);
		}
		free(padded_kernel);
		free(_lin_padded_kernel_cp);
		for (mz1=0;mz1 < 2*_PK0+1; mz1++) {
			free(padded_kernel_cp[mz1]);
		}
		free(padded_kernel_cp);
		free(_lin_patch);
		for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
			free(patch[mz1]);
		}
		free(patch);
		free(_lin_patch_cp);
		for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {
			free(patch_cp[mz1]);
		}
		free(patch_cp);
		
	'''
	
	def override printOutput(OutputPrinting b) {
		val varName = b.specialVar.varDecl.varID.name
		// only print invariant variable outputs
		if (!varName.startsWith('Inv_')) {
			return ''''''
		}
		val varType = b.specialVar.varDecl.type
		val bCPrintfSpecifier = if (varType.typeID.getName.equals("FLOATING_POINT")) '%E' else varType.CPrintfSpecifier
		val accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])
		val macroIndex = b.specialVar.varDecl.domain.macroIndices
		val macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])
		val macroName = b.statements.get(0).name
		
		val macroCodeNoPrompt = '''printf("«bCPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»);'''
		val macroCode = '''«b.specialVar.varDecl.printIndex(macroIndexB)»printf("«bCPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»);'''
		val printCondition = '''(fabsf(var_«b.specialVar.varDecl.varAccess(accessIndex, true)»)>ERR_DETECTION_THRESHOLD)'''
		'''
		{
			// Set error detection threshold
			const char* threshold = getenv("THRESHOLD");
			if (threshold==NULL) {
				ERR_DETECTION_THRESHOLD = 1e-06;
			} else {
				ERR_DETECTION_THRESHOLD = atof(threshold);
			}
			
			#ifdef «NO_PROMT_FLAG»
				#define «macroName»(«macroIndex») do { if «printCondition» { «macroCodeNoPrompt» }} while(0)
			#else
				#define «macroName»(«macroIndex») do { if «printCondition» { «macroCode» }} while(0)
			#endif
			«b.generateLoopNest»
			#undef «macroName»
		}
		'''

	}
}