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

class ABFTWrapperCFunction extends WrapperCFunction {
	
	public static ABFTCodeGenOptions options;
	
	@Inject extension BaseDomain domainExtensions
	@Inject extension BaseIndices indices
	@Inject extension BaseMemoryAllocation memory
	@Inject extension BaseBody body
	
	def override inputInitialization(InputInitialization b) {
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
	
		def override printOutput(OutputPrinting b) {
			val varType = b.specialVar.varDecl.type
			val bCPrintfSpecifier = if (varType.typeID.getName.equals("FLOATING_POINT")) '%E' else varType.CPrintfSpecifier
			val accessIndex = b.specialVar.getMemoryAccessExpressions.join(",", [e|e.toString])
			val accessIndexWithoutTime = "0,"+b.specialVar.getMemoryAccessExpressions.filter[e|!e.toString.equals("t")].join(",", [e|e.toString])
			val macroIndex = b.specialVar.varDecl.domain.macroIndices
			val macroIndexWithoutTime = b.specialVar.varDecl.domain.indices.getMacroIndicesExceptTime
			val macroIndexB = b.specialVar.varDecl.domain.indices.join(",", [e|"(long) "+e.toString])
			val macroIndexBWithoutTime = "(long) 0,"+b.specialVar.varDecl.domain.indices.filter[e|!e.toString.equals("t")].join(",", [e|"(long) "+e.toString])
			val macroName = b.statements.get(0).name
			'''
			{
				#ifdef «NO_PROMT_FLAG»
					#define «macroName»(«macroIndex») printf("«bCPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»)
				#else
					#define «macroName»(«macroIndex») «b.specialVar.varDecl.printIndex(macroIndexB)»printf("«bCPrintfSpecifier»\n",var_«b.specialVar.varDecl.varAccess(accessIndex, true)»)
				#endif
				«b.generateLoopNest»
				#undef «macroName»
			}
			'''
	
	}
}