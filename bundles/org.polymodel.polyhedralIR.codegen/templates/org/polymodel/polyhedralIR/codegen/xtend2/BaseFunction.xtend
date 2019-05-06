package org.polymodel.polyhedralIR.codegen.xtend2

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature
import org.polymodel.polyhedralIR.polyIRCG.Loop

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*

class BaseFunction {
	
	@Inject extension BaseBody extensions
	
	def String nameEsc(FunctionSignature fs) {
		return fs.name.nameEsc;
	}
	
	//Escape function names to fit C
	def String nameEsc(String fname) {
		//- is not allowed
		var name = fname.replaceAll("\\-", "_");
		
		//cannot start with number
		if (name.matches("\\d.+")) {
			return "_" + name;
		} else {
			return name;
		}
	}	

	def prototype(FunctionSignature fs) {
		'''«fs.returnType» «fs.nameEsc»(«fs.parameters.join(", ", [p|p.asParameterType])»)'''
	}
	
	//Expand the full signature, but treat global inputs and outputs specially so that they get prefix to their name
	def functionSignature(Function f) {
		f.signature.fullSignature((f.inputs + f.outputs).filter(v|v.global))
	}
	
	//When expanding function signature, adds a prefix to all global variables coming in, since they will be copied to a global variable
	def fullSignature(FunctionSignature fs, Iterable<AbstractVariable> globals) {
		'''«fs.returnType» «fs.nameEsc»(«fs.parameters.join(", ", [v|v.functionParam(globals)])»)'''
	}
	
	def private functionParam(AbstractVariable p, Iterable<AbstractVariable> globals) {
		'''«p.asParameterType» «IF globals.exists([v|v.name.matches(p.name)])»«TEMP_LOCAL_PREFIX»«ENDIF»«p.name»'''
	}
	
	def code(Function func) {
		if (!func.inlined) {
			'''
				«func.functionSignature»{
					«func.functionBody»
				}
			'''
		} else {
			func.functionBody
		}
	}
	
	def functionBody(Function func) {
		var state = new StateOfLoop(true, false);
		var isWhile = func.codeunit.system.whileInfo != null;
		var timeIndexName="";
		if (isWhile) timeIndexName = func.codeunit.system.whileInfo.timeDomain.indexNames.get(0);
		var lexMinD = if (isWhile) func.codeunit.system.whileInfo.timeDomain.PMdomain.lexMin;
		var lexMinPolyIRD = if (isWhile) PolyhedralIRUserFactory.eINSTANCE.createDomain(lexMinD);
		var lexminOfTime = if (isWhile) lexMinPolyIRD.getLowerBound(0).toString; 
		
		'''		
		«FOR body : func.bodies»
			«IF (isWhile && func.entryPoint && (body instanceof Loop || body instanceof FlagVariableReset) && state.firstLoop == true)»
				// infinite time loop with index «timeIndexName»
				int «timeIndexName»;
				for («timeIndexName»=«lexminOfTime»; ; «timeIndexName»++) {	
			«ENDIF»
			«IF (isWhile && func.entryPoint && !(body instanceof Loop || body instanceof FlagVariableReset) && state.firstLoop == false && state.lastLoop == false)»
					// Evaluate condition 
						if («timeIndexName»>=(«lexminOfTime»)+(«func.numberOfTimeIterationsForFirstConditionCheck»)-1) { 
							eval_isCond(«func.codeunit.system.parameters.params.join(", ", [v|v.name])», «timeIndexName»);
							if (isCond(«timeIndexName») == false) {
								printf("Breaking time: %d\n", «timeIndexName»);
								break;
							}	
						}
					}
				«state.setLastLoop = true»
			«ENDIF»
			«body.code»
			«IF (isWhile && func.entryPoint && (body instanceof Loop || body instanceof FlagVariableReset) && state.firstLoop == true)»
				«state.setFirstLoop = false»
			«ENDIF»
		«ENDFOR»
		'''
	}
}

/*
 * Used to keep track of the start of loop generation and end of loop generation 
 * so that for while systems we can generate a infinite loop containing all the 
 * loops generated as the body of the infinite loop
 */
class StateOfLoop {
    @Accessors
    var boolean firstLoop
    @Accessors
	var boolean lastLoop

    new(boolean firstLoop, boolean lastLoop){
        this.firstLoop = firstLoop
        this.lastLoop = lastLoop
    }
}