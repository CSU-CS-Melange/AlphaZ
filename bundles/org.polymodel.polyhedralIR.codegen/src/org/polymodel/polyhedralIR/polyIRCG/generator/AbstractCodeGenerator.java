package org.polymodel.polyhedralIR.polyIRCG.generator;

import java.util.List;

import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;


public abstract class AbstractCodeGenerator {
	
	protected final Program program;
	protected final CODEGEN codegen;
	protected final Program originalProgram;


	protected AbstractCodeGenerator(Program program) {
		this.originalProgram = program;
		this.program = program.copy();
		ContextDomainCalculator.computeContextDomain(this.program);
		codegen = getCodeGen();
	}
	
	/**
	 * Specify the CODEGEN to be used by PolyIRCodeGen, 
	 * which specifies the templates to use for code generation.
	 * 
	 * @return
	 */
	protected abstract CODEGEN getCodeGen();
	
	
	/**
	 * This method is called right after the constructor is called.
	 * 
	 */
	abstract protected void initialize();
	
	/**
	 * Generates to the specified output directory.
	 * 
	 */
	protected abstract void generate(CodeGenOptions option, String outDir);
	
	/**
	 * Internal function called during the generation step.
	 * Applies necessary pre-processing before generating code
	 * 
	 * @param system
	 */
	abstract protected void generationPreProcessing();
	
	/**
	 * 
	 * @return
	 */
	abstract protected List<CodeUnit> getCodeUnits();
	
    /**
     * Any post processing after generating the code
     * 
     * @param system
     * @throws alphabetsException
     */
    abstract protected void generationPostProcessing();
}
