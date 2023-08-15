package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC

import com.google.inject.Inject
import org.polymodel.algebra.Variable
import org.polymodel.polyhedralIR.ParameterDomain
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import org.polymodel.polyhedralIR.polyIRCG.Body
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable
import org.polymodel.polyhedralIR.polyIRCG.Function

import static org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants.*
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenUtilityForC.*

import static extension org.polymodel.polyhedralIR.codegen.xtend2.Indexed.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization
import org.polymodel.polyhedralIR.VariableDeclaration
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification
import org.polymodel.polyhedralIR.DATATYPE

class WrapperCFunction extends BaseFunction {
	
	@Inject extension BaseDomain domainExtensions
	@Inject extension BaseIndices indices
	@Inject extension BaseMemoryAllocation memory
	@Inject extension BaseBody body
	
	
	/**
	 * The main function is totally different from other code generators.
	 * Assumes there is only one function for wrapper; the main
	 * 
	 * There are some special conventions:
	 *  - Function with entryPoint = true actually contains information about the function the wrapper is going to call	
	 */
	override code(Function func) '''
		//function prototypes
		«func.mainFunctionPrototype»
		«func.verifyPrototype»
		
		int main(int argc, char** argv) {
			«func.checkNumberOfArgs»
			
			«func.readParameters»
			
			«func.parameterCheck»
			
			«func.tilingHandling»
			
			«func.malloc»

			//Initialization of rand
			srand((unsigned)time(NULL));
			 
			//Input Initialization
			«func.bodies.filter(b|b instanceof InputInitialization).join("", [b|(b as InputInitialization).inputInitialization])»
			
			//Timing
			struct timeval time;
			double elapsed_time;
			
			//Call the main computation
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
			
			«func.mainFunctionCall»
		
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;

			// timing information
			printf("Execution time : %lf sec.\n", elapsed_time);
			
			#ifdef «TIMING_FLAG»
				FILE * fp = fopen( "trace.dat","a+");
				if (fp == NULL) {
						printf("I couldn't open trace.dat for writing.\n");
						exit(EXIT_FAILURE);
				}
				fprintf(fp, "«func.paramDomain.params.join("\\t", [p|"%ld"])»\t%lf\n",«func.paramDomain.params.join(",", [p|p.name])»,elapsed_time);
				fclose(fp);
			#endif
			
			//Verification Run
			#ifdef «VERIFY_FLAG»
				#ifdef «TIMING_FLAG»
					gettimeofday(&time, NULL);
					elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
				#endif
		    	«func.verifyFunctionCall»
		    	#ifdef «TIMING_FLAG»
		    		gettimeofday(&time, NULL);
					elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;
					
					FILE * fp«VERIFY_POSTFIX» = fopen( "trace«VERIFY_POSTFIX».dat","a+");
					if (fp«VERIFY_POSTFIX» == NULL) {
							printf("I couldn't open trace«VERIFY_POSTFIX».dat for writing.\n");
							exit(EXIT_FAILURE);
					}
					fprintf(fp«VERIFY_POSTFIX», "«func.paramDomain.params.join("\\t", [p|"%ld"])»\t%lf\n",«func.paramDomain.params.join(",", [p|p.name])»,elapsed_time);
					fclose(fp«VERIFY_POSTFIX»);
				#endif
			#endif
		    	
			#ifdef «CHECKING_FLAG»
		    	//Print Outputs
				«func.bodies.filter(b|b instanceof OutputPrinting).join("", [b|(b as OutputPrinting).printOutput])»
			#elif «VERIFY_FLAG»
				//Compare outputs for verification
				«func.bodies.filter(b|b instanceof OutputVerification).join("", [b|(b as OutputVerification).verifyOutput])»
		    #endif
		    
			«func.mfree»
			
			return EXIT_SUCCESS;
		}
	'''

	
	def protected ParameterDomain getParamDomain(Function func) {
		func.codeunit.system.parameters
	}
	
	def protected checkNumberOfArgs(Function f) '''
		//Check number of args
		if (argc <= «f.paramDomain.dim») {
			printf("Number of argument is smaller than expected.\n");
			printf("Expecting «f.paramDomain.params.join(",", [p|p.name])»\n");
			exit(0);
		}
	''' 
	//better error handling
	def protected readParameters(Function f) ''' 
		char *end = 0;
		char *val = 0;
		//Read Parameters
		«FOR p : f.paramDomain.params.indexed»
		//Initialisation of «p.value.name»
		errno = 0;
		end = 0;
		val = argv[«p.index1»];
		long «p.value.name» = strtol(val,&end,10);
		if ((errno == ERANGE && («p.value.name» == LONG_MAX || «p.value.name» == LONG_MIN)) || (errno != 0 && «p.value.name» == 0)) {
			perror("strtol");
			exit(EXIT_FAILURE);
		}
		if (end == val) {
			fprintf(stderr, "No digits were found for «p.value.name»\n");
			exit(EXIT_FAILURE);
		}
		if (*end != '\0'){
			printf("For parameter «p.value.name»: Converted part: %ld, non-convertible part: %s\n", «p.value.name», end);
			exit(EXIT_FAILURE);
		}
		
		«ENDFOR»
	'''
	
	def protected parameterCheck(Function f) '''
		///Parameter checking
		if (!(«f.paramDomain.printConstraints»)) {
			printf("The value of parameters are not valid.\n");
			exit(-1);
		}
	'''
	
	def protected mainFunctionName(Function f) {
		f.codeunit.system.name.nameEsc
	}
	
	def protected mainFunctionParameters(Function f) {
		f.paramDomain.params + f.codeunit.variables.filter(e|e.isInput(f) || e.isOutput(f))
	}
	
	def protected dispatch asParameter(Variable v) {
		'''«v.name»'''
	}
	def protected dispatch asParameter(CVariable v) {
		if (v.scalar) {
			'''&«v.name»'''
		} else {
			'''«v.name»'''
		}
	}
	
	//parameters are long
	def protected dispatch asParameterType(Variable v) {
		'''long'''
	}
	
	def protected dispatch asParameterType(CVariable v) {
		'''«v.pointerType»'''
	}
	
	//for verify
	def protected dispatch asVerifyParameter(Variable v) {
		v.asParameter
	}
	def protected dispatch asVerifyParameter(CVariable v) {
		if (v.isOutput(v.codeunit.functions.findLast(f|f.entryPoint))) {
			if (v.scalar) {
				'''&«v.name»«VERIFY_POSTFIX»'''
			} else {
				'''«v.name»«VERIFY_POSTFIX»'''
			}
		} else {
			v.asParameter
		}
	}
	
	def protected mainFunctionPrototype(Function f) {
		'''void «f.mainFunctionName»(«f.mainFunctionParameters.join(", ", [p|p.asParameterType])»);'''
	}
	
	def protected verifyPrototype(Function f) {
		'''void «f.mainFunctionName»«VERIFY_POSTFIX»(«f.mainFunctionParameters.join(", ", [p|p.asParameterType])»);'''
	}
	
	def protected mainFunctionCall(Function f) {
		'''«f.mainFunctionName»(«f.mainFunctionParameters.join(", ", [p|p.asParameter])»);'''
	}
	
	def protected verifyFunctionCall(Function f) {
		'''«f.mainFunctionName»«VERIFY_POSTFIX»(«f.mainFunctionParameters.join(", ", [p|p.asVerifyParameter])»);'''
	}
	
	//macroIndexB: printf("C(%ld,%ld,%ld)=",i,j,k) when S0((c1),(c2),(Q+1)); instead of testing if i,j,k are parameters just transform then to long (just for the prompt)
	def protected inputInitialization(InputInitialization b) '''
		«var accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])»
		«var macroIndex = b.specialVar.varDecl.domain.macroIndices»
		«var macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])»  
		«var macroName = b.statements.get(0).name»
		{
			#if defined («RANDOM_FLAG»)
				#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(accessIndex, false)» = rand()) 
			#elif defined («CHECKING_FLAG») || defined («VERIFY_FLAG»)
				«b.userInput(macroName, macroIndexB, macroIndex, accessIndex)»
			#else
				#define «macroName»(«macroIndex») («b.specialVar.varDecl.varAccess(macroIndex, false)» = 1)   //Default value
			#endif
			
			
			«b.generateLoopNest»
			#undef «macroName»
		}
	'''
	
	//This rule creates a macro definition that reads a value of a variable using scanf.
	def userInput(InputInitialization b, CharSequence macroName, CharSequence macroNameB, CharSequence macroIndex, CharSequence accessIndex) '''
		#ifdef «NO_PROMT_FLAG»
			#define «macroName»(«macroIndex») scanf("«b.specialVar.varDecl.type.CScanfSpecifier»", &«b.specialVar.varDecl.varAccess(accessIndex, false)»)«b.specialVar.varDecl.type.CScanfPostProcess»
		#else
			#define «macroName»(«macroIndex») «b.specialVar.varDecl.printIndex(macroNameB)» scanf("«b.specialVar.varDecl.type.CScanfSpecifier»", &«b.specialVar.varDecl.varAccess(accessIndex, false)»)«b.specialVar.varDecl.type.CScanfPostProcess»
		#endif
	'''
	
	def protected printIndex(VariableDeclaration v, CharSequence macroIndex) {
		if (v.domain.NIndices > 0) {
			'''printf("«v.name»(«v.domain.indices.join(",", [e|"%ld"])»)=",«macroIndex»);'''
		} else {
			'''printf("«v.name»=");'''
		}
	}
	
	def protected varAccess(VariableDeclaration v, CharSequence macroIndex, boolean isSpecial) {
		if (v.output && macroIndex == null) {
			varAccess(v.name, " ", isSpecial);
		} else {
			varAccess(v.name, macroIndex, isSpecial);
		}
	}
	def protected varAccess(CharSequence vName, CharSequence macroIndex, boolean isSpecial) {
		'''«vName»«IF macroIndex != null && macroIndex.length > 0»(«macroIndex»)«ENDIF»«IF (macroIndex == null || macroIndex.length == 0) && isSpecial»()«ENDIF»''';
	}
	
//	def private printIndex(CodeGenVariable v, CharSequence macroIndex) {
//		if (v.domain.NIndices > 0) {
//			'''printf("«v.name»(«v.domain.indices.join(",", [e|"%d"])»)=",«macroIndex»);'''
//		} else {
//			'''printf("«v.name»=");'''
//		}
//	}
		
	def protected printOutput(OutputPrinting b) '''
		«var accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])»
		«var accessIndexWithoutTime = "0,"+b.specialVar.getMemoryAccessExpressions.filter[e|!e.toString.equals("t")].join(",", [e|e.toString])»
		«var macroIndex = b.specialVar.varDecl.domain.macroIndices»
		«var macroIndexWithoutTime = b.specialVar.varDecl.domain.indices.getMacroIndicesExceptTime»

		«var macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])»
		«var macroIndexBWithoutTime = "(long) 0,"+b.specialVar.varDecl.domain.indices.filter[e|!e.toString.equals("t")].join(",", [e|"(long) "+e.toString])»
		«var macroName = b.statements.get(0).name»
		{
			#ifdef «NO_PROMT_FLAG»
				#define «macroName»(«macroIndex») printf("«b.specialVar.varDecl.type.CPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»)
			#else
				#define «macroName»(«macroIndex») «b.specialVar.varDecl.printIndex(macroIndexB)»printf("«b.specialVar.varDecl.type.CPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»)
			#endif
			«b.generateLoopNest»
			#undef «macroName»
		}
	'''
	
	def protected verifyOutput(OutputVerification b) {
		
		var accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])
		var macroIndex = b.specialVar.varDecl.domain.macroIndices
		//FIXME temp fix for accessing scalar outputs in verify code
		if (macroIndex == null && b.specialVar.varDecl.output) {
			macroIndex = " "
		}
		var macroName = b.statements.get(0).name
		var isRelative=false
		var absf = "abs"
		var constPostFix = ""
		if (b.specialVar.varDecl.type.typeID==DATATYPE.FLOATING_POINT && b.specialVar.varDecl.type.width == 32){
			isRelative=true
			absf = "fabsf"
			constPostFix=".0f"
		} else if (b.specialVar.varDecl.type.typeID==DATATYPE.FLOATING_POINT && b.specialVar.varDecl.type.width == 64){
			isRelative=true
			absf = "fabs"
			constPostFix=".0"
		}
		//Scalar case
		if (b.specialVar.varDecl.domain.NIndices == 0) {
			if (isRelative) {
			'''
			if («absf»(1«constPostFix» - var_«(b.specialVar.varDecl.name+VERIFY_POSTFIX).varAccess(accessIndex, true)»/var_«b.specialVar.varDecl.varAccess(accessIndex, true)») > «EPSILON_NAME») {
				printf("TEST for «b.specialVar.varDecl.name» FAILED result: %f expected: %f\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)», var_«(b.specialVar.varDecl.name+VERIFY_POSTFIX).varAccess(accessIndex, true)»);
			} else {
				printf("TEST for «b.specialVar.varDecl.name» PASSED\n");
			}
			'''
			} else {
				'''
			if (var_«(b.specialVar.varDecl.name+VERIFY_POSTFIX).varAccess(accessIndex, true)»!=var_«b.specialVar.varDecl.varAccess(accessIndex, true)») {
				printf("TEST for «b.specialVar.varDecl.name» FAILED\n");
			} else {
				printf("TEST for «b.specialVar.varDecl.name» PASSED\n");
			}
			'''
			}
		} else {
			if (isRelative) {
			'''
				{
					//Error Counter
					int _errors_ = 0;
					#define «macroName»(«macroIndex») if («absf»(1«constPostFix» - var_«(b.specialVar.varDecl.name+VERIFY_POSTFIX).varAccess(accessIndex, true)»/var_«b.specialVar.varDecl.varAccess(accessIndex, true)») > «EPSILON_NAME») _errors_++;
					«b.generateLoopNest»
					#undef «macroName»
					if(_errors_ == 0){
						printf("TEST for «b.specialVar.varDecl.name» PASSED\n");
					}else{
						printf("TEST for «b.specialVar.varDecl.name» FAILED. #Errors: %d\n", _errors_);
					}
				}
			'''
			} else {
				'''
				{
					//Error Counter
					int _errors_ = 0;
					#define «macroName»(«macroIndex») if (var_«(b.specialVar.varDecl.name+VERIFY_POSTFIX).varAccess(accessIndex, true)»!=var_«b.specialVar.varDecl.varAccess(accessIndex, true)») _errors_++;
					«b.generateLoopNest»
					#undef «macroName»
					if(_errors_ == 0){
						printf("TEST for «b.specialVar.varDecl.name» PASSED\n");
					}else{
						printf("TEST for «b.specialVar.varDecl.name» FAILED. #Errors: %d\n", _errors_);
					}
				}
			'''
			}
		}
	}
	
	def protected tilingHandling(Function f) {
//			
//		«REM»	«IF codeunit.system.targetMapping.tiling.tilesizes.size > 0»
//			«LET codeunit.system.targetMapping.tiling.tilesizes AS tilesizes»
//			//Check number of args again for tile sizes
//			if (argc <= «getParamDomain().getDim() + tilesizes.size ») {
//				printf("Number of argument is smaller than expected.\n");
//				printf("Expecting «FOREACH getParamDomain().getParams() AS var SEPARATOR ', '»«var»«ENDFOREACH
//									», «FOREACH tilesizes AS ts ITERATOR it SEPARATOR ', '»«"WRAPPER_TILESIZE_PREFIX".getCGConstant()»«it.counter1»«ENDFOREACH»\n");
//				exit(0);
//			}
//			
//			//Tile sizes
//			«FOREACH tilesizes AS ts ITERATOR it»
//			long «"WRAPPER_TILESIZE_PREFIX".getCGConstant()»«it.counter1» = atol(argv[«getParamDomain().getParams().size+it.counter1»]);
//			«ENDFOREACH»
//			«ENDLET»
//			«ENDIF»«ENDREM»
//		
//			«LET inputs.union(outputs).getVariableWithMaxDim() AS maxDim»
//			«IF maxDim.domain.getNIndices() > 0»
//			//Loop indices for malloc
//			int «FOREACH maxDim.domain.getIndices() AS i ITERATOR it SEPARATOR ', '
//				»«"MALLOC_LOOP_INDEX".getCGConstant()+it.counter1»«ENDFOREACH»;«ENDIF»
//			«ENDLET»
	}
	
	def protected malloc(Function f) '''
		//Memory Allocation
		«val maxDim = f.codeunit.variables.variableWithMaxDim»
		«declareMalloLoopIterators(maxDim.domain.NIndices)»
		«FOR v : f.inputs + f.outputs»
			«v.malloc»
		«ENDFOR»
		#ifdef «VERIFY_FLAG»
			«FOR v : f.outputs»
				«v.malloc(VERIFY_POSTFIX)»
			«ENDFOR»
		#endif
	'''
	
	def protected mfree(Function f) '''
		//Memory Free
		«FOR v : f.inputs + f.outputs»
			«v.mfree»
		«ENDFOR»
		#ifdef «VERIFY_FLAG»
			«FOR v : f.outputs»
				«v.mfree(VERIFY_POSTFIX)»
			«ENDFOR»
		#endif
	'''
	
//			
//			//MFLOPS computation
//			{
//				double totalFLOP = 0.0;
//			«PROTECT CSTART "/***" CEND "***/" ID this.codeunit.system.name+"_MLOPS"»
//				//add code to compute the total number of FLOP here
//			«ENDPROTECT»
//				//only computes and prints MFLOPS when code is added above
//				if (totalFLOP > 0.0) {
//					double mflop = totalFLOP * 0.001;
//					double mflops = mflop / elapsed_time;
//					printf("MFLOPS : %lf\n", mflops);
//				}
//			}
//		
}