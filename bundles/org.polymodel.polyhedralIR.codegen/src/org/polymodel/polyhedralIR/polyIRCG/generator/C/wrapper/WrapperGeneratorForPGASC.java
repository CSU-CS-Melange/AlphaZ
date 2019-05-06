package org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;

public class WrapperGeneratorForPGASC extends WrapperGeneratorForC {

	protected WrapperGeneratorForPGASC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.numP);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.numTilesPerChunk);
	}

	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		WrapperGeneratorForPGASC wrapper = new WrapperGeneratorForPGASC(system, options);
		wrapper.generate(options, outDir);
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.WRAPPER_PGASC;
	}
}
