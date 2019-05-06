/**
 * 
 */
package edu.csu.melange.alphaz.mde.tests.bugreported;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;

/**
 * @author lrabiet
 *
 */
public class SubsystemsWriteC {

	private String testedFiles[] = {"alphabets/SubSystemExamples/SquareBlockedMM.ab"};
	
	// Should generate a warning and not generate code.
	// I'm not sure whether we should use RuntimeException as the expected 
	// exception since this will pass he test even if some other 
	// runtimeException is thrown. But anyway I added it.
	@Test (expected=RuntimeException.class)
	public void test() {
		CodeGenOptions options = CodeGenOptions.writeCDefault();
		Program program = null;
		String outDir = "./";
		
		for (String filename : testedFiles){
			program = alphaz.mde.Basic.ReadAlphabets(filename);
			outDir = "output" + filename;
			String systemName = "BlockMM";
			
			alphaz.mde.Analysis.CheckProgram(program);
			
			AffineSystem system = program.getSystem(systemName);
			WriteC.generate(system, options, outDir);
			WrapperGeneratorForC.generate(system, options, outDir);
			PolyIRCodeGen.generateMakefile(system, outDir);
		}
	}

}
