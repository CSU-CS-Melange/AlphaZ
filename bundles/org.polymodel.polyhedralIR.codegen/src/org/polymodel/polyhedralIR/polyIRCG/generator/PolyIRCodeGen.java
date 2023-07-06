package org.polymodel.polyhedralIR.polyIRCG.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.analysis.SystemCallAnalysis;
import org.polymodel.polyhedralIR.codegen.xtend2.Xtend2CodeGen;
import org.polymodel.polyhedralIR.codegen.xtend2.Xtend2MakefileGen;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.ABFTWrapperCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.MPICModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.PCOTCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.ReductionCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.ScanCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.ScheduledCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.WrapperCModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.WrapperForMPICModule;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.WriteCModule;

import com.google.inject.AbstractModule;

public class PolyIRCodeGen {
	
	public static boolean VERBOSE = false;
	
	//keep track of options used in a static way to allow Xpand to use it
	protected static CodeGenOptions currentOptions;
	protected static AbstractCodeGenerator currentCodegen;
	
	public static CodeGenOptions getCodeGenOptions() {
		return currentOptions;
	}
	
	public static AbstractCodeGenerator getCodeGenerator() {
		return currentCodegen;
	}

	public static enum CODEGEN {
		WRITE_C(new WriteCModule()),
		SCHEDULED_C(new ScheduledCModule()),
		PGAS_C(new WriteCModule()),
		WRAPPER_C(new WrapperCModule()),
		ABFT_WRAPPER_C(new ABFTWrapperCModule()),
		WRAPPER_PGASC(new WrapperCModule()),
		SCAN_C(new ScanCModule()),
		REDUCTION_C(new ReductionCModule()),
		MPI_C(new MPICModule()),
		WRAPPER_MPIC(new WrapperForMPICModule()),
		PCOT_C(new PCOTCModule()),
		;
		
		public final AbstractModule module;
		
		private CODEGEN(AbstractModule module) {
			assert(module != null);
			this.module = module;
		}
	}
	
	public static void generate(AbstractCodeGenerator cg, CodeGenOptions options, CompilationUnit code, String outDir) {
		File dir = new File(outDir);
		if (!dir.exists() && !dir.mkdirs()) {
			throw new RuntimeException("Failed to create output directory : " + outDir);
		}

		currentOptions = options;
		currentCodegen = cg;

		Map<String, String> codes = Xtend2CodeGen.generate(cg.getCodeGen().module, code);
		for (String file : codes.keySet()) {
			if (VERBOSE) {
				System.out.println("================================");
				System.out.println(file);
				System.out.println(codes.get(file));
			}
			//external function headers are not overwritten
			if (file.contentEquals(CodeGenConstantsForC.EXTERNAL_FUNCTION_HEADER_NAME)) {
				writeFile(dir, file, codes.get(file), false);
			} else {
				writeFile(dir, file, codes.get(file));
			}
		}
		
		
		
	}
	private static void writeFile(File dir, String filename, String content, boolean overwrite) {
		if (content == null) return;
		
		try {
			File file = new File(dir.getAbsolutePath()+"/"+filename);
			
			//skip if overwrite not allowed
			if (file.exists() && !overwrite) return;
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeFile(File dir, String filename, String content) {
		writeFile(dir, filename, content, true);
	}
	
	/**
	 * Generates a Makefile for testing the generated code.
	 * 
	 * @param system
	 * @param outDir
	 */
//	public static void generateMakefile(AbstractModule module, AffineSystem system, String outDir) {
//		File dir = new File(outDir);
//		if (!dir.exists() && !dir.mkdirs()) {
//			throw new RuntimeException("Failed to create output directory : " + outDir);
//		}
//		
//		Map<String, String> codes;
//		if (module != null) {
//			codes = Xtend2MakefileGen.generate(module, system);
//		} else {
//			codes = Xtend2MakefileGen.generate(system);
//		}
//		for (String file : codes.keySet()) {
//			writeFile(dir, file, codes.get(file));
//		}
//	}
//	public static void generateMakefile(AffineSystem system, String outDir) {
//		generateMakefile(null, system, outDir);
//	}
	
	//for test now
	public static void generateMakefile(AbstractModule module, AffineSystem system, boolean omp, String outDir){
		generateMakefile(module, system, omp, outDir, false);
	}
	public static void generateMakefile(AbstractModule module, AffineSystem system, boolean omp, String outDir, boolean withVerification){
		File dir = new File(outDir);
		if (!dir.exists() && !dir.mkdirs()) {
			throw new RuntimeException("Failed to create output directory : " + outDir);
		}
		
		//find the used system for the current system
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(system);
		Map<String, String> codes;
		if (module != null) {
			codes = Xtend2MakefileGen.generate(module, system, systems, omp, withVerification);
		} else {
			codes = Xtend2MakefileGen.generate(system, systems, omp, withVerification);
		}
		for (String file : codes.keySet()) {
			writeFile(dir, file, codes.get(file));
		}
	}

	public static void generateMakefile(AbstractModule module, AffineSystem system, String outDir){
		generateMakefile(module, system, false, outDir);
	}
	
	public static void generateMakefile(AffineSystem system, String outDir){
		generateMakefile(null, system, false, outDir);
	}
	
	public static void generateMakefile(AffineSystem system, String outDir, boolean withVerification){
		generateMakefile(null, system, false, outDir, withVerification);
	}

	public static void generateOMPMakefile(AbstractModule module, AffineSystem system, String outDir){
		generateMakefile(module, system, true, outDir);
	}
	
	public static void generateOMPMakefile(AffineSystem system, String outDir){
		generateMakefile(null, system, true, outDir);
	}
}
