package edu.csu.melange.alphaz.mde.tests.regression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.Assert;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.DistributedCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.SubSystemCodeGenUtilityForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPIC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForMPIC;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;

import alphaz.mde.Utility;
import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;
public class CodeGenTestingFramework {

	public static boolean GENERATION_ONLY = false;
	public static boolean SKIP_WRAPPER_GEN = false;
	public static boolean DEBUG = false;
	
	public static enum TEST_SETTING {
		WRITE_C(CODEGEN.WRITE_C, false, null, false),
		WRITE_C_FLATTEN(CODEGEN.WRITE_C, true, null, false),

		SCHEDULED_C(CODEGEN.SCHEDULED_C, false, null, false),
		SCHEDULED_C_PARALLEL(CODEGEN.SCHEDULED_C, false, null, false),
		SCHEDULED_C_SUBSYSTEM(CODEGEN.SCHEDULED_C, false, null, false),
		SCHEDULED_C_TILING_SEQ(CODEGEN.SCHEDULED_C, false, TILING_TYPE.SEQUENTIAL, false),
		SCHEDULED_C_TILING_SEQ_OPT(CODEGEN.SCHEDULED_C, false, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_TILING_OMPWF(CODEGEN.SCHEDULED_C, false, TILING_TYPE.OMPWAVEFRONT, false),
		SCHEDULED_C_TILING_OMPWF_OPT(CODEGEN.SCHEDULED_C, false, TILING_TYPE.OMPWAVEFRONT, true),

		SCHEDULED_C_FLATTEN(CODEGEN.SCHEDULED_C, true, null, false),
		SCHEDULED_C_FLATTEN_PARALLEL(CODEGEN.SCHEDULED_C, true, null, false),
		SCHEDULED_C_FLATTEN_SUBSYSTEM(CODEGEN.SCHEDULED_C, true, null, false),
		SCHEDULED_C_FLATTEN_TILING_SEQ(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, false),
		SCHEDULED_C_FLATTEN_TILING_SEQ_OPT(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_FLATTEN_TILING_OMPWF(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, false),
		SCHEDULED_C_FLATTEN_TILING_OMPWF_OPT(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, true),
		
		SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_NAIVE(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_OPTNOBUFF(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALLALIGNED(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALMOST(CODEGEN.SCHEDULED_C, true, TILING_TYPE.SEQUENTIAL, true),
		SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_NAIVE(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, true),
		SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_OPTNOBUFF(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, true),
		SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALLALIGNED(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, true),
		SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALMOST(CODEGEN.SCHEDULED_C, true, TILING_TYPE.OMPWAVEFRONT, true),
		
		SCHEDULED_C_MULTIPASS_TILING_SEQ(CODEGEN.SCHEDULED_C, false, TILING_TYPE.SEQUENTIAL, false),
		SCHEDULED_C_MULTIPASS_TILING_OMPWF(CODEGEN.SCHEDULED_C, false, TILING_TYPE.OMPWAVEFRONT, false),
		
		MPI_C(CODEGEN.MPI_C, false, TILING_TYPE.MPIC, false),
		;
		
		public final CODEGEN codegen;
		public final boolean flattenArrays;
		public final TILING_TYPE tiling;
		public final boolean tilingOptimized;
		
		private TEST_SETTING(CODEGEN codegen, boolean flattenArrays, TILING_TYPE tiling, boolean tilingOptimized) {
			this.codegen = codegen;
			this.flattenArrays = flattenArrays;
			this.tiling = tiling;
			this.tilingOptimized = tilingOptimized;
		}
	}

	protected static final String TEST_CODE_DIR  = "regression/codegen/codes/";
	
	public static void run(TEST_SETTING setting, String[][] tests) throws IOException, InterruptedException {
		for (String[] test : tests) {
			run(setting, test);
		}
	}

	public static void run(TEST_SETTING setting, String[] test) throws IOException, InterruptedException {
		if (test.length != 7) {
			throw new RuntimeException("Invalid length for test cases.");
		}
		int numP = 1;
		if (test[6] != null) {
			numP = Integer.parseInt(test[6]);
		}
		codegenTest(setting, test[0], test[1], test[2], test[3], test[4], test[5], numP);
	}

	public static void codegenTest(TEST_SETTING setting, String filename, String systemName, String inputArg, String tmFile, String inputData, String expectedOutput, int numP) throws IOException, InterruptedException {
		//try {
			System.out.println(String.format("Testing %s : %s %s ", setting, systemName, inputArg));
			Program prog = alphaz.mde.Basic.ReadAlphabets(filename);
			AffineSystem system = prog.getSystem(systemName);
			alphaz.mde.Analysis.CheckProgram(prog);
			
			//read TargetMapping for all the system in the program 
			if(tmFile != null){
				if((setting != TEST_SETTING.SCHEDULED_C_FLATTEN_SUBSYSTEM) && (setting != TEST_SETTING.SCHEDULED_C_SUBSYSTEM) ){
					system.setTargetMapping(readTMfile(system, setting, new File(tmFile), false));
				}else{	//read targetmapping for each system in the program
					for(AffineSystem sys : prog.getSystems()){
						sys.setTargetMapping(readTMfile(sys, setting, new File(tmFile), true));
					}
				}
			}
			
			if(DEBUG){
				System.out.println("================Target Mapping=====================");
				System.out.println("==============MemoryMap===========");
				for(MemoryMap mMap : system.getTargetMapping().getMemoryMaps().values()){
					System.out.println(mMap);
				}
				System.out.println("==============SpaceTimeMap=========");
				for(SpaceTimeMap stMap : system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().values()){
					System.out.println(stMap);
				}
				System.out.println("Testing System:");
				System.out.println(system);
			}
			
			
			String outDir = TEST_CODE_DIR + setting.name() + "/" + system.getName();
			
			boolean vec = false;
			switch (setting) {
				case WRITE_C:
				case WRITE_C_FLATTEN:
					{
						CodeGenOptions options = CodeGenOptions.writeCDefault();
						options.flattenArrays = setting.flattenArrays;
						WriteC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN){
							WrapperGeneratorForC.generate(system, options, outDir);
						}
					}
					break;
				case SCHEDULED_C:
				case SCHEDULED_C_PARALLEL:
				case SCHEDULED_C_FLATTEN_PARALLEL:
				case SCHEDULED_C_FLATTEN:
				case SCHEDULED_C_SUBSYSTEM:
				case SCHEDULED_C_FLATTEN_SUBSYSTEM:
					{
						CodeGenOptions options = CodeGenOptions.scheduledCDefault();
						options.flattenArrays = setting.flattenArrays;
						ScheduledC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForC.generate(system, options, outDir);
					}
					break;
				case SCHEDULED_C_TILING_SEQ:
				case SCHEDULED_C_TILING_SEQ_OPT:
				case SCHEDULED_C_FLATTEN_TILING_SEQ:
				case SCHEDULED_C_FLATTEN_TILING_SEQ_OPT:
				case SCHEDULED_C_TILING_OMPWF:
				case SCHEDULED_C_TILING_OMPWF_OPT:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF_OPT:
					{
						TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
						options.flattenArrays = setting.flattenArrays;
						options.optimized = setting.tilingOptimized;
						ScheduledC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForC.generate(system, options, outDir);
					}
					break;
				case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_NAIVE:
				case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_OPTNOBUFF:
				case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALLALIGNED:
				case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALMOST:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_NAIVE:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_OPTNOBUFF:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALLALIGNED:
				case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALMOST:
					{	
						TiledCodeGenOptions options = readVecOptions(system, setting, new File(tmFile), false);
						ScheduledC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForC.generate(system, options, outDir);
						vec = true;
						alphaz.mde.CodeGen.generateMakefileInternal(prog, system.getName(), options, outDir);
					}
					break;
				case SCHEDULED_C_MULTIPASS_TILING_SEQ:
					{	
						TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
						options.flattenArrays = setting.flattenArrays;
						options.multiPassSequential = true;
						options.multiPassWavefront = false;
						ScheduledC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForC.generate(system, options, outDir);
					}
				break;
				case SCHEDULED_C_MULTIPASS_TILING_OMPWF:
					{	
						TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
						options.flattenArrays = setting.flattenArrays;
						options.multiPassSequential = false;
						options.multiPassWavefront = true;
						ScheduledC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForC.generate(system, options, outDir);
					}
					break;
//				case PGAS_C:
//					{
//						system.getTargetMapping().getTiling().setType(TILING_TYPE.PGAS);
//						DistributedCodeGenOptions options = DistributedCodeGenOptions.PGASCDefault();
//						options.optimized = true;
//						{
////							options.nonParametrized = true;
////							options.setTileSizePrefix("TILE_SIZE");
//						}
//						PGASC.generate(system, options, outDir);
//						WrapperGeneratorForPGASC.generate(system,options, outDir);
//					}
//					break;
				case MPI_C:
					{
						DistributedCodeGenOptions options = DistributedCodeGenOptions.PGASCDefault();
						options.flattenArrays = setting.flattenArrays;
						options.optimized = setting.tilingOptimized;
//						system.getTargetMapping().getTiling().setType(setting.tiling);
						MPIC.generate(system, options, outDir);
						if (!SKIP_WRAPPER_GEN)
							WrapperGeneratorForMPIC.generate(system, options, outDir);
					}
					break;
				default:
					throw new RuntimeException("Unhandled code generator : " + setting);
			}
			
			if(!vec)
				alphaz.mde.CodeGen.generateMakefileInternal(prog, system.getName(), outDir);
//			alphaz.mde.CodeGen.generateMakefile(prog, system.getName(), outDir);
			
			if (GENERATION_ONLY) return;
			
			copyExternalVerifyFile(filename, systemName, outDir);
			copyExternalFunctionHeader(filename, outDir);

			File inFile = null;
			if (inputData != null) inFile = new File(inputData);
			
			try {
			    Thread.sleep(20000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			
			if(vec){
				execFrameworkForVec(new File(outDir), system.getName()+".verify", inputArg);
			}else{
				if (setting.tiling == TILING_TYPE.MPIC) {
					execFrameworkForMPI(new File(outDir), system.getName()+".check", inputArg, inFile, new File(expectedOutput), numP);
				} else {
					execFramework(new File(outDir), system.getName()+".check", inputArg, inFile, new File(expectedOutput));
				}
			}
			//clean up
//			execCommand(String.format("rm -rf %s", outDir));
		/*} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	protected static void copyExternalFunctionHeader(String abFilename, String outDir) {
		File file = new File(abFilename);
		
		File dir = file.getParentFile();
		if (dir == null || !dir.isDirectory()) {
			throw new RuntimeException("Unexpected case.");
		}
		
		for (String child : dir.list()) {
			if (child.contentEquals(CodeGenConstantsForC.EXTERNAL_FUNCTION_HEADER_NAME)) {
				File exH = new File(dir+"/"+child);
				String cmd = String.format("cp %s %s", exH, outDir);
				try {
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			}
		}
	}
	
	protected static void copyExternalVerifyFile(String abFilename, String systemName, String outDir) {
		File file = new File(abFilename);
		
		File dir = file.getParentFile();
		if (dir == null || !dir.isDirectory()) {
			throw new RuntimeException("Unexpected case.");
		}
		
		String verifyFilename = systemName + CodeGenConstantsForC.VERIFY_POSTFIX + ".c";
		for (String child : dir.list()) {
			if (child.contentEquals(verifyFilename)) {
				File exH = new File(dir+"/"+child);
				String cmd = String.format("cp %s %s", exH, outDir);
				try {
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			}
		}
	}

	protected static void execFrameworkForVec(File codeDir, String execName, String inputArg) throws IOException, InterruptedException {
		//try {
			final String PATH = "PATH="+System.getenv("PATH");
		
			//System.out.println(String.format("make -f %s/Makefile clean", codeDir.getAbsolutePath()));
			//make
			execCommand(String.format("make -f %s/Makefile clean", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath()});
			execCommand(String.format("make -f %s/Makefile verify", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});
			execCommand(String.format("make -f %s/Makefile plain", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});

			execCommand(String.format("%s/%s %s", codeDir.getAbsolutePath(), execName, inputArg));
	}

	protected static void execFramework(File codeDir, String execName, String inputArg, File inputData, File expectedOutput) throws IOException, InterruptedException {
		//try {
			final String PATH = "PATH="+System.getenv("PATH");
			
			//make
			execCommand(String.format("make -f %s/Makefile clean", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath()});
			execCommand(String.format("make -f %s/Makefile check-noprompt", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});
			execCommand(String.format("make -f %s/Makefile plain", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});

			//run generated code through bash, since redirects don't work through Runtime
			File tempbsh = new File("temp.bsh");
			tempbsh.deleteOnExit();
			FileWriter fw = new FileWriter(tempbsh);
			if (inputData != null) {
				String cmd = String.format("%s/%s %s < %s > %s/test.out", codeDir.getAbsolutePath(), execName, inputArg, inputData.getAbsolutePath(), codeDir.getAbsolutePath());
				fw.write(cmd);
//				System.out.println(cmd);
//				System.out.println(String.format("diff %s/test.out %s", codeDir.getAbsolutePath(), expectedOutput.getAbsolutePath()));
			} else {
				String cmd = String.format("%s/%s %s > %s/test.out", codeDir.getAbsolutePath(), execName, inputArg, codeDir.getAbsolutePath());
				fw.write(cmd);
//				System.out.println(cmd);
			}
			fw.close();
			execCommand("bash temp.bsh");
			//take diff
			String result = execCommand(String.format("diff %s/test.out %s", codeDir.getAbsolutePath(), expectedOutput.getAbsolutePath()));
			Assert.assertTrue("The actual output does not match the expected output of the program!", result.startsWith("1d0< Execution time"));
		/*} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	protected static void execFrameworkForMPI(File codeDir, String execName, String inputArg, File inputData, File expectedOutput, int numP) throws IOException, InterruptedException {
		//try {
			final String PATH = "PATH=/usr/bin/:/usr/libexec/gcc/x86_64-redhat-linux/4.5.1/:/usr/lib64/openmpi/bin/";
			//make
			execCommand(String.format("make -f %s/Makefile clean", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath()});
			execCommand(String.format("make -f %s/Makefile check-noprompt", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});
			execCommand(String.format("make -f %s/Makefile plain", codeDir.getAbsolutePath()), new String[]{"ALPHAZ_MAKE_DIR="+codeDir.getAbsolutePath(), PATH});

			//run generated code through bash, since redirects don't work through Runtime
			File tempbsh = new File("temp.bsh");
//			tempbsh.deleteOnExit();
			FileWriter fw = new FileWriter(tempbsh);
			if (inputData != null) {
				String cmd = String.format("mpirun -n %d %s/%s %s < %s > %s/test.out", numP, codeDir.getAbsolutePath(), execName, inputArg, inputData.getAbsolutePath(), codeDir.getAbsolutePath());
				fw.write(cmd);
//				System.out.println(cmd);
//				System.out.println(String.format("diff %s/test.out %s", codeDir.getAbsolutePath(), expectedOutput.getAbsolutePath()));
			} else {
				String cmd = String.format("mpirun -n %d %s/%s %s > %s/test.out", numP, codeDir.getAbsolutePath(), execName, inputArg, codeDir.getAbsolutePath());
				fw.write(cmd);
//				System.out.println(cmd);
			}
			fw.close();
			execCommand("bash temp.bsh");
			//take diff
			execCommand(String.format("diff %s/test.out %s", codeDir.getAbsolutePath(), expectedOutput.getAbsolutePath()));
		/*} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	protected static String execCommand(String command) throws IOException, InterruptedException {
		return execCommand(command, null);
	}
	
	protected static String execCommand(String command, String[] env) throws IOException, InterruptedException {
		//System.out.println(command);
		StringBuilder sb = new StringBuilder();
		Process process = Runtime.getRuntime().exec(command, env);
		process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while (br.ready()) {
			String line = br.readLine();
			if (line.matches("^(gcc|rm -f).+")) continue;
			System.out.println(line);
			sb.append(line);
		}
		br.close();
		BufferedReader be = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while (be.ready()) {
			String line = be.readLine();
			System.err.println(line);
			sb.append(line);
		}
		be.close();
		
		return sb.toString();
	}
	
	protected static TiledCodeGenOptions readVecOptions(AffineSystem system, TEST_SETTING setting, File tmFile, boolean isMultiTargetMappingFile) throws IOException{
		TiledCodeGenOptions options = TiledCodeGenOptions.scheduledCDefault();
		
		switch(setting){
			case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_NAIVE:
			case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_NAIVE:
			{
				options.vec = true;
				options.vectorizable = true;
				options.buffering = false;
				options.pointer = false;
				options.simdSet = "AVX";
				options.optimized = true;
				options.rotate = false;
				options.strategy = 1;
				options.unrollAndJam = true;
				break;
			}
			case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_OPTNOBUFF:
			case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_OPTNOBUFF:
			{
				options.vec = true;
				options.vectorizable = true;
				options.buffering = false;
				options.pointer = true;
				options.simdSet = "AVX";
				options.optimized = true;
				options.rotate = true;
				options.strategy = 3;
				options.unrollAndJam = true;
				break;
			}
			case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALLALIGNED:
			case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALLALIGNED:
			{
				options.vec = true;
				options.vectorizable = true;
				options.buffering = true;
				options.pointer = true;
				options.simdSet = "AVX";
				options.optimized = true;
				options.rotate = true;
				options.strategy = 2;
				options.unrollAndJam = true;
				break;
			}
			case SCHEDULED_C_FLATTEN_TILING_SEQ_VEC_ALMOST:
			case SCHEDULED_C_FLATTEN_TILING_OMPWF_VEC_ALMOST:
			{
				options.vec = true;
				options.vectorizable = true;
				options.buffering = true;
				options.pointer = true;
				options.simdSet = "AVX";
				options.optimized = true;
				options.rotate = true;
				options.strategy = 3;
				options.unrollAndJam = true;
				break;
			}
			default:
				throw new RuntimeException("Unhandled vectroization code generator : " + setting);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmFile)));
		if(isMultiTargetMappingFile){//reach the specificaiton for the corresponing system
			while(br.ready()){
				String line = br.readLine();
				line = line.replace("\\r|\\n", "");
				//skip empty lines
				if (line.length() == 0) continue;
				//skip comments
				if (line.matches("^#.*")) continue;
				String[] cols = line.split("\\t");
				if(cols[0].toUpperCase().contentEquals("SYS") && cols[1].contentEquals(system.getName())) break;
			}
		}
		while(br.ready()){	//read the corresponding options
			String line = br.readLine();
			line = line.replace("\\r|\\n", "");
			//skip empty lines
			if (line.length() == 0) continue;
			//skip comments
			if (line.matches("^#.*")) continue;
			String[] cols = line.split("\\t");
			//skip 
			if (cols.length < 2) {
				System.err.println("Invalid tm spec : "+line);
				continue;
			}
			//parse the vectorization options
			if(cols[0].toUpperCase().contentEquals("VC")){	
				//parse the vectorization variable
				List<String> vecVars = new LinkedList<String>();	
				for(String var: cols[1].split(",")){
					vecVars.add(var);
				}
				options.vecVar = vecVars;
				//parse the register block size
				String[] regblocksize = cols[2].split(",");
				int[] regsize = new int[regblocksize.length];
				for(int i = 0; i < regblocksize.length; i++){
					regsize[i] = Integer.parseInt(regblocksize[i]);
				}
				options.unrollFactors = regsize;
			}else{
				//parsing left for different feature specification: unrolling, vectorization, parallelization
				//System.err.println("Invalid tm spec : "+line);
				continue;
			}
		}
		
		
		return options;
	}
	
	
	protected static TargetMapping readTMfile(AffineSystem system, TEST_SETTING setting, File tmFile, boolean isMultiTargetMappingFile) throws IOException{
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmFile)));
		if(isMultiTargetMappingFile){//reach the specificaiton for the corresponing system
			while(br.ready()){
				String line = br.readLine();
				line = line.replace("\\r|\\n", "");
				//skip empty lines
				if (line.length() == 0) continue;
				//skip comments
				if (line.matches("^#.*")) continue;
				String[] cols = line.split("\\t");
				if(cols[0].toUpperCase().contentEquals("SYS") && cols[1].contentEquals(system.getName())) break;
			}
		}
		
		while(br.ready()){	//read the corresponding target mapping
			String line = br.readLine();
			line = line.replace("\\r|\\n", "");
			//skip empty lines
			if (line.length() == 0) continue;
			//skip comments
			if (line.matches("^#.*")) continue;
			String[] cols = line.split("\\t");
			//skip 
			if (cols.length < 2) {
				System.err.println("Invalid tm spec : "+line);
				continue;
			}
			//parse the spacetime map
			if(cols[0].toUpperCase().contentEquals("ST")){	//ST level var mapping
				AffineFunction mapping = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[3]);
				SpaceTimeMap stmap = null;
				if(system.getEquation(cols[2]) != null){
					VariableDeclaration var = system.getVariableDeclaration(cols[2]);
					stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, mapping);
				}else{
					UseEquation eq = system.getUseEquation(cols[2]);
					stmap = TargetMappingUserFactory.createUseEquationSpaceTimeMap(cols[2], mapping, eq);
				}
				stlevel.getSpaceTimeMaps().put(cols[2], stmap);
			}else if(cols[0].toUpperCase().contentEquals("M")){	//parse the memory map, M var space mapping mods
				VariableDeclaration var = system.getVariableDeclaration(cols[1]);
				MemorySpace space = tm.getMemorySpace(cols[2]);
				//parse the mapping function
				AffineFunction mapping = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[3]);	
				//parse the mod factor
				EList<IntExpression> modFactors = null;
				if (cols.length >= 5 && cols[4] != null) {
					List<String> modExprs = new LinkedList<String>();
					for (String expr : cols[4].split(",")) {
						modExprs.add(expr);
					}
					modFactors = TargetMappingUserFactory.createModFactor(var.getDomain().getParams(),var.getDomain().getIndices(), modExprs);
				}
				MemoryMap mmap = TargetMappingUserFactory.createMemoryMap(var, mapping, modFactors, space);
				tm.getMemoryMaps().put(var, mmap);
				//parse statement ordering, SO varPred varSucc
			} else if(cols[0].toUpperCase().contentEquals("SO")){
				tm.getStatementOrderings().add(TargetMappingUserFactory.createStatementOrder(system.getEquation(cols[1]), system.getEquation(cols[2])));
				//parse ordering dimension, OD level dim
			} else if(cols[0].toUpperCase().contentEquals("OD")){
				tm.getSpaceTimeLevel(Integer.parseInt(cols[1])).getOrderingDimensions().add(Integer.parseInt(cols[2]));
			} else if(cols[0].toUpperCase().contentEquals("TILE")){
				if (cols[1] == null) continue;

				final int level = Integer.parseInt(cols[1]);
				final int start = Integer.parseInt(cols[2]);
				final int end = Integer.parseInt(cols[3]);
				

				TilingSpecification dtiler = TargetMappingUserFactory.createTilingSpecification("tile1", new LinkedList<Integer>(), start, end, 1);
				SubTilingSpecification subtile = TargetMappingUserFactory.createSubTilingSpecification(1, start, end, setting.tiling);
				dtiler.getSubTiles().add(subtile);
				tm.getSpaceTimeLevel(level).getTilingSpecifications().add(dtiler);
//				tm.getSpaceTimeLevel(level).getTilingSpecifications().add(
//						TargetMappingUserFactory.createTilingSpecification(prefix, start, end, setting.tiling));
			} else if(cols[0].toUpperCase().contentEquals("PAR")){
				if (cols[1] == null) continue;
				
				final int level = Integer.parseInt(cols[1]);
				
				List<Integer> prefix = Utility.parseIntegerArray(cols[2]);
				if((prefix.size() == 1) && (prefix.get(0).equals(-1))){
					prefix.clear();
				}
				List<Integer> dims = Utility.parseIntegerArray(cols[3]);
				tm.getSpaceTimeLevel(level).getParallelizationSpecifications().add(TargetMappingUserFactory.createParallelizationSpecification(prefix, dims));
			}else if(cols[0].toUpperCase().contentEquals("USE_ST")){
				boolean isInput = true;
				if(Integer.parseInt(cols[2]) == 0){
					isInput = true;
				}else{
					isInput = false;
				}
				
				int num = Integer.parseInt(cols[3]);
				AffineFunction stMapForMemoryAllocation = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[4]);
				AffineFunction stMapForValueCopy = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[5]);
				AffineFunction stMapForMemoryFree = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[6]);
				
				String spaceName = SubSystemCodeGenUtilityForC.getUseEquationVariableName(system.getUseEquation(cols[1]), isInput, num);
				if(tm.getUseEquationOptimization(cols[1], num, isInput) == null){
					tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(cols[1], num, isInput, null, spaceName, stMapForMemoryAllocation, stMapForValueCopy, stMapForMemoryFree));
				}else{
					tm.getUseEquationOptimization(cols[1], num, isInput).setMemoryAllocationSpaceTimeMap(stMapForMemoryAllocation);
					tm.getUseEquationOptimization(cols[1], num, isInput).setValueCopySpaceTimeMap(stMapForValueCopy);
					tm.getUseEquationOptimization(cols[1], num, isInput).setMemoryFreeSpaceTimeMap(stMapForMemoryFree);
				}
			}else if(cols[0].toUpperCase().contentEquals("USE_M")){
				boolean isInput = true;
				if(Integer.parseInt(cols[2]) == 0){
					isInput = true;
				}else{
					isInput = false;
				}
				
				int num = Integer.parseInt(cols[3]);
				
				if(tm.getUseEquationOptimization(cols[1], num, isInput) == null){
					tm.getUseEquationOptimizations().add(TargetMappingUserFactory.createUseEquationOptimization(cols[1], num, isInput, null, cols[4], null, null, null));
				}else{
					tm.getUseEquationOptimization(cols[1], num, isInput).setMemorySpaceNameforTemporaryVariable(cols[4]);
				}
			}else if(cols[0].toUpperCase().contentEquals("SYS")){	//stop sign for multi targetMapping file
				break;
			}else{
				//parsing left for different feature specification: unrolling, vectorization, parallelization
				//System.err.println("Invalid tm spec : "+line);
				continue;
			}
		}
		return tm;
	}
	/*protected static TargetMapping readTMfile(AffineSystem system, File tmFile) throws IOException {
		TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(system);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmFile)));
		while (br.ready()) {
			String line = br.readLine();
			line = line.replaceAll("\\r|\\n", "");
			//skip empty lines
			if (line.length() == 0) continue;
			//skip comments
			if (line.matches("^#.*")) continue;
			String[] cols = line.split("\\t");
			//skip 
			if (cols.length < 2) {
				System.err.println("Invalid tm spec : "+line);
				continue;
			}
			//sched/mem is specified in the first col
			//# ST var stMap 
			if (cols[0].toUpperCase().contentEquals("ST")) {
				tm.setSpaceTimeMap(system.getVariableDeclaration(cols[1]), PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[2]));
			//dim type
			} else if (cols[0].toUpperCase().contentEquals("DIM_TYPE")) {
				if (cols.length != 4) continue;

				String var = cols[1];
				int dim = Integer.parseInt(cols[2]);
				DIM_TYPE type = DIM_TYPE.getByName(cols[3]);
				
				tm.setDimensionType(system.getVariableDeclaration(var), dim, type);
			//# M var memSpace memAlloc
			} else if (cols[0].toUpperCase().contentEquals("M")) {
				AffineFunction mmap = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), cols[3]);
				
				EList<IntExpression> modFactors = null;
				if (cols.length >= 5 && cols[4] != null) {
					List<String> modExprs = new LinkedList<String>();
					for (String expr : cols[4].split(",")) {
						modExprs.add(expr);
					}
					modFactors = TargetMappingUserFactory.createModFactor(mmap.getParams(), mmap.getIndices(), modExprs);
				}
				tm.setMemoryMap(tm.getMemorySpace(cols[2]), system.getVariableDeclaration(cols[1]), 
						mmap, modFactors);
			//# SO varPred varSucc 
			} else if (cols[0].toUpperCase().contentEquals("SO")) {
				tm.setStatementOrder(system.getEquation(cols[1]), system.getEquation(cols[2]));
			//tiling
			} else if (cols[0].toUpperCase().contentEquals("TILE")) {
				if (cols[1] == null) continue;
				
				tm.getTiling().setType(TILING_TYPE.OM_PWAVEFRONT);
				//int num = Integer.parseInt(cols[1]);
				//for (int i = 0; i < num; i++) {
				//	tm.getTiling().getTilesizes().add(DTilingOptions.PARAMETRIC);
				//}
			} else if (cols[0].toUpperCase().contentEquals("COMMUNICATION")) {
				if (cols.length < 3) continue;
				if (cols[1] == null) continue;
				if (cols[2] == null) continue;
				
				String var = cols[1];
				String[] depthsStr = cols[2].split(",");
				int depths[] = new int[depthsStr.length];
				for (int i = 0; i < depthsStr.length; i++) {
					depths[i] = Integer.parseInt(depthsStr[i]);
				}
				
				VariableDeclaration varDecl = system.getVariableDeclaration(var);
				tm.getCommunicationMapping().getVariables().add(TargetMappingUserFactory.createCommunicatedVariable(varDecl, depths));
			}else {
				System.err.println("Invalid tm spec : "+line);
				continue;
			}
			
			
			
		}
		
		return tm;
	}*/
	
	public static final String TESTCASES_ROOT = "testcases";
	public static final String STENCIL_ROOT = "stencils";
	public static final String CODEGEN_TEST_DATA_DIR = "codegen";
	
	public static String[] createStencilTestEntry(String name, String inputArgs, String TMfilename){
		final String progDir = String.format("%s/%s/", STENCIL_ROOT, name);
		final String dataDir = String.format("%s/%s/%s/", STENCIL_ROOT, name, CODEGEN_TEST_DATA_DIR);
		
		//TM input file
		final String TMfile;
		if (TMfilename == null) TMfile = null;
		else TMfile = dataDir+name+"."+TMfilename+".tm";
		
		return new String[] {
				progDir + name + ".ab", //file path 
				name, //system name
				inputArgs,
				TMfile, 
				null,
				null,
				Integer.toString(1)
			}; 
	}
	
	public static String[] createTestEntry(String name, String inputArgs, String TMfilename, String inputFilename, String outputFilename, int numP) {
		final String progDir = String.format("%s/%s/", TESTCASES_ROOT, name);
		final String dataDir = String.format("%s/%s/%s/", TESTCASES_ROOT, name, CODEGEN_TEST_DATA_DIR);
		
		//TM input file
		final String TMfile;
		if (TMfilename == null) TMfile = null;
		else TMfile = dataDir+TMfilename;
		
		final String inputFile;
		if (inputFilename == null) inputFile = null;
		else inputFile = dataDir + inputFilename;
		
		final String outputFile;
		if (outputFilename == null) outputFile = null;
		else outputFile = dataDir + outputFilename;
		
		return new String[] {
				progDir + name + ".ab", //file path 
				name, //system name
				inputArgs,
				TMfile, 
				inputFile,
				outputFile,
				Integer.toString(numP)
			}; 
	}
	
	public static String[] createTestEntry(String name, String inputArgs, String TMfilename, String inputFilename, String outputFilename) {
		return createTestEntry(name, inputArgs, TMfilename, inputFilename, outputFilename, 1);
	}

	public static String[] createTestEntry(String name, String inputArgs, String TMname, String sizeName, int numP) {
		return createTestEntry(name, inputArgs, name+"."+TMname+".tm", name+".in."+sizeName, name+".out."+sizeName, numP);
	}
	public static String[] createTestEntry(String name, String inputArgs, String TMname, String sizeName) {
		return createTestEntry(name, inputArgs, TMname, sizeName, 1);
	}
	public static String[] createTestEntryWithDefaultNames(String name, String inputArgs) {
		final String inputSize = inputArgs.replaceAll("\\s+", "x");
		return createTestEntry(name, inputArgs, name+".tm", name+".in."+inputSize, name+".out."+inputSize, 1);
	}
	public static String[] createTestEntryWithDefaultNames(String name, String inputArgs, String TMname) {
		final String inputSize = inputArgs.replaceAll("\\s+", "x");
		return createTestEntry(name, inputArgs, name+"."+TMname+".tm", name+".in."+inputSize, name+".out."+inputSize, 1);
	}
}
