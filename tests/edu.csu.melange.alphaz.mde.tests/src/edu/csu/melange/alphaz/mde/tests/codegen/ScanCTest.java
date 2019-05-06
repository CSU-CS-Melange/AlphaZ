package edu.csu.melange.alphaz.mde.tests.codegen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ScanC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ScanCodeGenInfo;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.TransformationsForScanC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.recurrence.ScanInformations;
import org.polymodel.polyhedralIR.recurrence.ScanInformations.VectorInformation;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class ScanCTest extends TestCase {
	
	private static final String outDirPrefix = "./test-out/scanC/";
	private static final String outScanPrefix = "./test-out/scheduledC/";
	
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;

//	public static void main(String[] args) {
//		try {
//			CodeGenOptions options = CodeGenOptions.scheduledCDefault();
////			testMssScan(options);
////			testMSS(options);
////			testHmmer(options);
////			testMutalDep(options);
////			testFib(options);
//			options.flattenArrays = true;
////			testScanFive(options);
////			testLexiScan(options);
////			testConvolution(options);
////			testPolynomial(options);
//			testArray(options);
////			testLexiScanTri(options);
////			testLexiScanSim(options);
////			testConvolutionCom(options);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	CodeGenOptions options = null;
	
	protected void setUp() {
		options = CodeGenOptions.scheduledCDefault();
	}
	
//	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
//	public void test() throws IOException{
////		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
//		if (options == null) {
//			System.out.println("setup didnt work!");
//		} else {
//			System.out.println("setup worked!");
//		}
////		testMssScan(options);
////		testMSS(options);
////		testHmmer(options);
////		testMutalDep(options);
////		testFib(options);
//		options.flattenArrays = true;
////		testScanFive(options);
////		testLexiScan(options);
////		testConvolution(options);
////		testPolynomial(options);
//		testArray(options);
////		testLexiScanTri(options);
////		testLexiScanSim(options);
////		testConvolutionCom(options);
//	}
	
	@Test public void testMssScan(){
		options.flattenArrays = false;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/mssScan.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
/*		String oriOutDir = outScanPrefix + "/mss";
		String oriSystemName = "MSS";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);*/
		
		String outDir = outDirPrefix+"/mssScan";
		String systemName = "MssScan";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();
		
		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var_x = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var_x);
		
		//get the coefficient matrix
		VariableDeclaration coe_var = system.getVariableDeclaration("A");
		VariableExpression var_exp = _fact.createVariableExpression(coe_var);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);	//identity for +/max
		IntegerExpression int2 = _fact.createIntegerExpression(1);  //identity for +
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp.copy();
		coef_matrix[0][1] = var_exp.copy();
		coef_matrix[1][0] = int1.copy();
		coef_matrix[1][1] = int2.copy();
		
		
		Domain matrix_dom = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		
		scan_info.addCoefficientMatrix(matrix_dom, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init_x = _fact.createVariableExpression(coe_var);
		init_exp.add(init_x);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, "{i|i==0}");
		scan_info.addUpdatingVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList_x = new LinkedList<VectorInformation>();
		VectorInformation vec_x = scan_info.createVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		vecList_x.add(vec_x);
		targetInitDomainMap.put("X", vecList_x);
		
		scan_info.addInitialDoamin(targetInitDomainMap);
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> dir = new Vector<Long>();
		dir.add(1L);
		directions.add(dir);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.MAX);
		scan_info.addOTimes(OP.ADD);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
	
	@Test public void testMSS(){
		options.flattenArrays = false;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/mss.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
/*		String oriOutDir = outScanPrefix + "/mss";
		String oriSystemName = "MSS";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);*/
		
		String outDir = outDirPrefix+"/mss";
		String systemName = "MSS";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();
		
		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var_x = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var_x);
		VariableDeclaration scan_var_t = system.getVariableDeclaration("T");
		scan_info.addTarget(scan_var_t);
		
		//get the coefficient matrix
		VariableDeclaration coe_var = system.getVariableDeclaration("A");
		VariableExpression var_exp = _fact.createVariableExpression(coe_var);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);	//identity for +/max
		IntegerExpression int2 = _fact.createIntegerExpression(1);  //identity for +
		
		Expression[][] coef_matrix = new Expression[3][3];
		coef_matrix[0][0] = var_exp.copy();
		coef_matrix[0][1] = int1.copy();
		coef_matrix[0][2] = var_exp.copy();
		coef_matrix[1][0] = var_exp.copy();
		coef_matrix[1][1] = int2.copy();
		coef_matrix[1][2] = var_exp.copy();
		coef_matrix[2][0] = int1.copy();
		coef_matrix[2][1] = int1.copy();
		coef_matrix[2][2] = int2.copy();
		
		
		Domain matrix_dom = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		
		scan_info.addCoefficientMatrix(matrix_dom, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(3);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init_x = _fact.createVariableExpression(coe_var);
		init_exp.add(init_x);
		VariableExpression init_t = _fact.createVariableExpression(coe_var);
		init_exp.add(init_t);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, "{i|i==0}");
		scan_info.addUpdatingVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		scan_info.addUpdatingVector(scan_var_t, cur_dep.copy(), 1, init_domain.copy());
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList_x = new LinkedList<VectorInformation>();
		VectorInformation vec_x = scan_info.createVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		vecList_x.add(vec_x);
		targetInitDomainMap.put("X", vecList_x);
		List<VectorInformation> vecList_t = new LinkedList<VectorInformation>();
		VectorInformation vec_t = scan_info.createVector(scan_var_t, cur_dep.copy(), 1, init_domain.copy());
		vecList_t.add(vec_t);
		targetInitDomainMap.put("T", vecList_t);
		
		scan_info.addInitialDoamin(targetInitDomainMap);
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> dir = new Vector<Long>();
		dir.add(1L);
		directions.add(dir);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.MAX);
		scan_info.addOTimes(OP.ADD);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[3][3];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 0;
		optimization_matrix[0][2] = 3;
		optimization_matrix[1][0] = 3;
		optimization_matrix[1][1] = 1;
		optimization_matrix[1][2] = 3;
		optimization_matrix[2][0] = 0;
		optimization_matrix[2][1] = 0;
		optimization_matrix[2][2] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
	
	@Test public void testHmmer(){
		options.flattenArrays = false;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/hmmer.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
/*		String oriOutDir = outScanPrefix + "/hmmer";
		String oriSystemName = "HMMER";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);*/
		
		String outDir = outDirPrefix+"/hmmer";
		String systemName = "HMMER";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();
		
		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("C");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("B");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);
		IntegerExpression int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp2;
		coef_matrix[0][1] = var_exp1;
		coef_matrix[1][0] = int1.copy();
		coef_matrix[1][1] = int2.copy();
		
		
		Domain matrix_dom = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		
		scan_info.addCoefficientMatrix(matrix_dom, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init = _fact.createVariableExpression(coe_var1);
		init_exp.add(init);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, "{i|i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep.copy(), 1, init_domain.copy());
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec = scan_info.createVector(scan_var, cur_dep.copy(), 1, init_domain.copy());
		vecList.add(vec);
		targetInitDomainMap.put("C", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> dir = new Vector<Long>();
		dir.add(1L);
		directions.add(dir);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.MAX);
		scan_info.addOTimes(OP.ADD);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
	
	@Test public void testMutalDep(){
		options.flattenArrays = false;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/MutalDep.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
		String oriOutDir = outScanPrefix + "/MutalDep";
		String oriSystemName = "MutalDep";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		/*String outDir = outDirPrefix+"/MutalDep";
		String systemName = "MutalDep";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var_x = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var_x);
		VariableDeclaration scan_var_y = system.getVariableDeclaration("Y");
		scan_info.addTarget(scan_var_y);
		
		//get the coefficient matrix
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("B");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		VariableDeclaration coe_c1_var = system.getVariableDeclaration("a1");
		VariableExpression var_c1_exp = _fact.createVariableExpression(coe_c1_var);
		
		VariableDeclaration coe_c2_var = system.getVariableDeclaration("a2");
		VariableExpression var_c2_exp = _fact.createVariableExpression(coe_c2_var);

		VariableDeclaration coe_c3_var = system.getVariableDeclaration("a3");
		VariableExpression var_c3_exp = _fact.createVariableExpression(coe_c3_var);
		
		VariableDeclaration coe_c4_var = system.getVariableDeclaration("a4");
		VariableExpression var_c4_exp = _fact.createVariableExpression(coe_c4_var);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);
		IntegerExpression int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[3][3];
		coef_matrix[0][0] = var_c1_exp;
		coef_matrix[0][1] = var_c2_exp;
		coef_matrix[0][2] = var_exp1;
		coef_matrix[1][0] = var_c3_exp;
		coef_matrix[1][1] = var_c4_exp;
		coef_matrix[1][2] = var_exp2;
		coef_matrix[2][0] = int1.copy();
		coef_matrix[2][1] = int1.copy();
		coef_matrix[2][2] = int2.copy();
		
		
		Domain matrix_dom = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		
		scan_info.addCoefficientMatrix(matrix_dom, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(3);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init1 = _fact.createVariableExpression(coe_var1);
		init_exp.add(init1);
		VariableExpression init2 = _fact.createVariableExpression(coe_var2);
		init_exp.add(init2);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, "{i|i==0}");
		scan_info.addUpdatingVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		scan_info.addUpdatingVector(scan_var_y, cur_dep.copy(), 1, init_domain.copy());
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList_x = new LinkedList<VectorInformation>();
		VectorInformation vec_x = scan_info.createVector(scan_var_x, cur_dep.copy(), 1, init_domain.copy());
		vecList_x.add(vec_x);
		targetInitDomainMap.put("X", vecList_x);
		List<VectorInformation> vecList_y = new LinkedList<VectorInformation>();
		VectorInformation vec_y = scan_info.createVector(scan_var_y, cur_dep.copy(), 1, init_domain.copy());
		vecList_y.add(vec_y);
		targetInitDomainMap.put("Y", vecList_y);
		scan_info.addInitialDoamin(targetInitDomainMap);
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> vec = new Vector<Integer>();
		vec.add(1);
		directions.add(vec);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[3][3];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[0][2] = 3;
		optimization_matrix[1][0] = 3;
		optimization_matrix[1][1] = 3;
		optimization_matrix[1][2] = 3;
		optimization_matrix[2][0] = 0;
		optimization_matrix[2][1] = 0;
		optimization_matrix[2][2] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);*/
	}
	
	@Test public void testLexiScanTri() {
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/LexiScanTri.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
		String oriOutDir = outScanPrefix+"/lexi_scan_tri";
		String oriSystemName = "LexiScanTri";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		/*String outDir = outDirPrefix+"/lexi_scan_tri";
		String systemName = "LexiScanTri";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("B");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);
		IntegerExpression int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp1;
		coef_matrix[0][1] = var_exp2;
		coef_matrix[1][0] = int1;
		coef_matrix[1][1] = int2;
		
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i,j| j==0 && 1 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//add the second matrix
		//get the coef matrix for domain j==0 && i >= 1
		VariableDeclaration coe_matrix_var1 = system.getVariableDeclaration("A");
		VariableExpression coe_matrix_exp1 = _fact.createVariableExpression(coe_matrix_var1);
		
		VariableDeclaration coe_matrix_var2 = system.getVariableDeclaration("B");
		VariableExpression coe_matrix_exp2 = _fact.createVariableExpression(coe_matrix_var2);
		
		IntegerExpression coe_matrix_int1 = _fact.createIntegerExpression(0);
		IntegerExpression coe_matrix_int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix2 = new Expression[2][2];
		coef_matrix2[0][0] = coe_matrix_exp1;
		coef_matrix2[0][1] = coe_matrix_exp2;
		coef_matrix2[1][0] = coe_matrix_int1;
		coef_matrix2[1][1] = coe_matrix_int2;
		
		
		Domain matrix_dom2 = PolyhedralIRUtility.parseDomain(param, "{i,j| 0<= i <= N && 1 <= j <= i}");
		scan_info.addCoefficientMatrix(matrix_dom2, coef_matrix2);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init = _fact.createVariableExpression(coe_var1);
		init_exp.add(init);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i,j-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, " {i, j|i==0 && j==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep, 1, init_domain);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec = scan_info.createVector(scan_var, cur_dep, 1, init_domain.copy());
		vecList.add(vec);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i, j| 1 <= i <= N && 0 <= j <= i}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> vec1 = new Vector<Integer>();
		vec1.add(0);
		vec1.add(1);
		Vector<Integer> vec2 = new Vector<Integer>();
		vec2.add(1);
		vec2.add(0);
		directions.add(vec1);
		directions.add(vec2);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
		*/
	}
	
	
	@Test public void testArray(){
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/array.ab");
		System.out.println("The original program:" + program.toString());
		alphaz.mde.Analysis.CheckProgram(program);
		
		String outDir = outDirPrefix+"/array";
		String systemName = "Array";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var0 = system.getVariableDeclaration("A");
		VariableExpression var_exp0 = _fact.createVariableExpression(coe_var0);
		
		IntegerExpression int0 = _fact.createIntegerExpression(0);
		IntegerExpression int1 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = int1.copy();	coef_matrix[0][1] = var_exp0;
		coef_matrix[1][0] = int0.copy(); 	coef_matrix[1][1] = int1.copy(); 
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		init_exp.add(int0.copy());
		init_exp.add(int1.copy());
		scan_info.addInitialExpression(init_exp);
		
		//get the updating vector
		AffineFunction cur_dep1 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain1 = PolyhedralIRUtility.parseDomain(param, " {i | i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep1, 1, init_domain1);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec1 = scan_info.createVector(scan_var, cur_dep1.copy(), 1, init_domain1.copy());
		vecList.add(vec1);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> dir1 = new Vector<Long>();
		dir1.add(1L);
		directions.add(dir1);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
	
	@Test public void testPolynomial(){
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/poly.ab");
		System.out.println("The original program:" + program.toString());
		alphaz.mde.Analysis.CheckProgram(program);
		
		
		String oriOutDir = outScanPrefix+"/poly";
		String oriSystemName = "Poly";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		//tm.setMemoryMap(tm.getMemorySpace("C"), system.getVariableDeclaration("C"), 
		//		PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->i,j)"), null);

//		tm.getSpaceTimeMap(system.getVariableDeclaration("temp_C")).setMapping(
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->0,k,i,j)"));
//		tm.getSpaceTimeMap(system.getVariableDeclaration("C")).setMapping(
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->1,k,i,j)"));
//		
//		tm.setStatementOrder(system.getEquation("temp_C"), system.getEquation("C"));
//		tm.setStatementOrder(system.getEquation("C"), system.getEquation("temp_C"));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		
		//test the scan code generator
		
		/*String outDir = outDirPrefix+"/poly";
		String systemName = "Poly";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var0 = system.getVariableDeclaration("c");
		VariableExpression var_exp0 = _fact.createVariableExpression(coe_var0);
		
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		IntegerExpression int0 = _fact.createIntegerExpression(0);
		IntegerExpression int1 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp0;	coef_matrix[0][1] = var_exp1;
		coef_matrix[1][0] = int0.copy(); 	coef_matrix[1][1] = int1.copy(); 
		
		Domain matrix_dom1 = PolyhedraVector<Integer> vec2 = new Vector<Integer>();
		vec2.add(1);
		vec2.add(0);lIRUserFactory.eINSTANCE.parseDomain(param, "{i | 1 <= i <= N}");
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		init_exp.add(int0.copy());
		init_exp.add(int1.copy());
		scan_info.addInitialExpression(init_exp);
		
		//get the updating vector
		AffineFunction cur_dep1 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain1 = PolyhedralIRUtility.parseDomain(param, " {i | i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep1, 1, init_domain1);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec1 = scan_info.createVector(scan_var, cur_dep1.copy(), 1, init_domain1.copy());
		vecList.add(vec1);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 1 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> dir1 = new Vector<Integer>();
		dir1.add(1);
		directions.add(dir1);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);*/
	}
	
	@Test public void testConvolution(){
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/convolution.ab");
		System.out.println("The original program:" + program.toString());
		alphaz.mde.Analysis.CheckProgram(program);
		
		String oriOutDir = outScanPrefix+"/convolution";
		String oriSystemName = "Convolution";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		
		/*String outDir = outDirPrefix+"/convolution";
		String systemName = "Convolution";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var0 = system.getVariableDeclaration("a0");
		VariableExpression var_exp0 = _fact.createVariableExpression(coe_var0);
		
		VariableDeclaration coe_var1 = system.getVariableDeclaration("a1");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("a2");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		VariableDeclaration coe_var3 = system.getVariableDeclaration("a3");
		VariableExpression var_exp3 = _fact.createVariableExpression(coe_var3);
		
		IntegerExpression int0 = _fact.createIntegerExpression(0);
		IntegerExpression int1 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[4][4];
		coef_matrix[0][0] = var_exp0;	coef_matrix[0][1] = var_exp1;	coef_matrix[0][2] = var_exp2;	coef_matrix[0][3] = var_exp3;
		coef_matrix[1][0] = int1.copy(); 	coef_matrix[1][1] = int0.copy(); 	coef_matrix[1][2] = int0.copy();	coef_matrix[1][3] = int0.copy();
		coef_matrix[2][0] = int0.copy(); 	coef_matrix[2][1] = int1.copy(); 	coef_matrix[2][2] = int0.copy();	coef_matrix[2][3] = int0.copy();
		coef_matrix[3][0] = int0.copy(); 	coef_matrix[3][1] =	int0.copy(); 	coef_matrix[3][2] = int0.copy(); 	coef_matrix[3][3] = int1.copy();
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i | 3 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(4);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		init_exp.add(int0.copy());
		init_exp.add(int1.copy());
		scan_info.addInitialExpression(init_exp);
		
		//get the updating vector
		AffineFunction cur_dep1 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain1 = PolyhedralIRUtility.parseDomain(param, " {i | i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep1, 1, init_domain1);
		AffineFunction cur_dep2 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-2)");
		Domain init_domain2 = PolyhedralIRUtility.parseDomain(param, " {i | i==1}");
		scan_info.addUpdatingVector(scan_var, cur_dep2, 2, init_domain2);
		AffineFunction cur_dep3 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-3)");
		Domain init_domain3 = PolyhedralIRUtility.parseDomain(param, " {i | i==2}");
		scan_info.addUpdatingVector(scan_var, cur_dep3, 3, init_domain3);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec1 = scan_info.createVector(scan_var, cur_dep1.copy(), 1, init_domain1.copy());
		vecList.add(vec1);
		VectorInformation vec2 = scan_info.createVector(scan_var, cur_dep2.copy(), 2, init_domain2.copy());
		vecList.add(vec2);
		VectorInformation vec3 = scan_info.createVector(scan_var, cur_dep3.copy(), 3, init_domain3.copy());
		vecList.add(vec3);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 3 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> dir1 = new Vector<Integer>();
		dir1.add(1);
		directions.add(dir1);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization_matrix
		int[][] optimization_matrix = new int[4][4];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[0][2] = 3;
		optimization_matrix[0][3] = 3;
		optimization_matrix[1][0] = 3;
		optimization_matrix[1][1] = 3;
		optimization_matrix[1][2] = 3;
		optimization_matrix[1][3] = 3;
		optimization_matrix[2][0] = 3;
		optimization_matrix[2][1] = 3;
		optimization_matrix[2][2] = 3;
		optimization_matrix[2][3] = 3;
		optimization_matrix[3][0] = 0;
		optimization_matrix[3][1] = 0;
		optimization_matrix[3][2] = 0;
		optimization_matrix[3][3] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		scan_info.ScanInfoPrint();
		
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);*/
	}
	
	@Test public void testConvolutionCom(){
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/convolutionCom.ab");
		System.out.println("The original program:" + program.toString());
		alphaz.mde.Analysis.CheckProgram(program);
		
		String oriOutDir = outScanPrefix+"/convolution_com";
		String oriSystemName = "ConvolutionCom";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		
		/*String outDir = outDirPrefix+"/convolution_com";
		String systemName = "ConvolutionCom";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var0 = system.getVariableDeclaration("a0");
		VariableExpression var_exp0 = _fact.createVariableExpression(coe_var0);
		
		VariableDeclaration coe_var1 = system.getVariableDeclaration("a1");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("a2");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		VariableDeclaration coe_var3 = system.getVariableDeclaration("a3");
		VariableExpression var_exp3 = _fact.createVariableExpression(coe_var3);
		
		VariableDeclaration coe_var4 = system.getVariableDeclaration("a4");
		VariableExpression var_exp4 = _fact.createVariableExpression(coe_var4);
		
		IntegerExpression int0 = _fact.createIntegerExpression(0);
		IntegerExpression int1 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[5][5];
		coef_matrix[0][0] = var_exp0;	coef_matrix[0][1] = var_exp1;	coef_matrix[0][2] = var_exp2;	coef_matrix[0][3] = var_exp3; coef_matrix[0][4] = var_exp4;
		coef_matrix[1][0] = int1.copy(); 	coef_matrix[1][1] = int0.copy(); 	coef_matrix[1][2] = int0.copy();	coef_matrix[1][3] = int0.copy();	coef_matrix[1][4] = int0.copy();
		coef_matrix[2][0] = int0.copy(); 	coef_matrix[2][1] = int1.copy(); 	coef_matrix[2][2] = int0.copy();	coef_matrix[2][3] = int0.copy();	coef_matrix[2][4] = int0.copy();
		coef_matrix[3][0] = int0.copy(); 	coef_matrix[3][1] =	int0.copy(); 	coef_matrix[3][2] = int1.copy(); 	coef_matrix[3][3] = int0.copy();	coef_matrix[3][4] = int0.copy();
		coef_matrix[4][0] = int0.copy(); 	coef_matrix[4][1] =	int0.copy(); 	coef_matrix[4][2] = int0.copy(); 	coef_matrix[4][3] = int0.copy();	coef_matrix[4][4] = int1.copy();
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i | 4 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(5);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		init_exp.add(int0.copy());
		init_exp.add(int1.copy());
		scan_info.addInitialExpression(init_exp);
		
		//get the updating vector
		AffineFunction cur_dep1 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain1 = PolyhedralIRUtility.parseDomain(param, " {i | i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep1, 1, init_domain1);
		AffineFunction cur_dep2 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-2)");
		Domain init_domain2 = PolyhedralIRUtility.parseDomain(param, " {i | i==1}");
		scan_info.addUpdatingVector(scan_var, cur_dep2, 2, init_domain2);
		AffineFunction cur_dep3 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-3)");
		Domain init_domain3 = PolyhedralIRUtility.parseDomain(param, " {i | i==2}");
		scan_info.addUpdatingVector(scan_var, cur_dep3, 3, init_domain3);
		AffineFunction cur_dep4 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-4)");
		Domain init_domain4 = PolyhedralIRUtility.parseDomain(param, " {i | i==3}");
		scan_info.addUpdatingVector(scan_var, cur_dep4, 4, init_domain4);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec1 = scan_info.createVector(scan_var, cur_dep1.copy(), 1, init_domain1.copy());
		vecList.add(vec1);
		VectorInformation vec2 = scan_info.createVector(scan_var, cur_dep2.copy(), 2, init_domain2.copy());
		vecList.add(vec2);
		VectorInformation vec3 = scan_info.createVector(scan_var, cur_dep3.copy(), 3, init_domain3.copy());
		vecList.add(vec3);
		VectorInformation vec4 = scan_info.createVector(scan_var, cur_dep4.copy(), 4, init_domain4.copy());
		vecList.add(vec4);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 4 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> dir1 = new Vector<Integer>();
		dir1.add(1);
		directions.add(dir1);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization_matrix
		int[][] optimization_matrix = new int[5][5];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[0][2] = 3;
		optimization_matrix[0][3] = 3;
		optimization_matrix[0][4] = 3;
		optimization_matrix[1][0] = 3;
		optimization_matrix[1][1] = 3;
		optimization_matrix[1][2] = 3;
		optimization_matrix[1][3] = 3;
		optimization_matrix[1][4] = 3;
		optimization_matrix[2][0] = 3;
		optimization_matrix[2][1] = 3;
		optimization_matrix[2][2] = 3;
		optimization_matrix[2][3] = 3;
		optimization_matrix[2][4] = 3;
		optimization_matrix[3][0] = 3;
		optimization_matrix[3][1] = 3;
		optimization_matrix[3][2] = 3;
		optimization_matrix[3][3] = 3;
		optimization_matrix[3][4] = 3;
		optimization_matrix[4][0] = 0;
		optimization_matrix[4][1] = 0;
		optimization_matrix[4][2] = 0;
		optimization_matrix[4][3] = 0;
		optimization_matrix[4][4] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		scan_info.ScanInfoPrint();
		
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);*/
	}

	//fibonacci test case
	@Test public void testFib() {
		options.flattenArrays = false;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/Fib.ab");
		System.out.println("The original program:" + program.toString());
		//alphaz.mde.Analysis.CheckProgram(program);
		
		String outDir = outDirPrefix+"fib";
		String systemName = "Fib";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("fib");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		IntegerExpression int0 = _fact.createIntegerExpression(0);
		IntegerExpression int1 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[3][3];
		coef_matrix[0][0] = int1.copy();	coef_matrix[0][1] = int1.copy();	coef_matrix[0][2] = int0.copy();
		coef_matrix[1][0] = int1.copy(); 	coef_matrix[1][1] = int0.copy(); 	coef_matrix[1][2] = int0.copy();
		coef_matrix[2][0] = int0.copy(); 	coef_matrix[2][1] = int0.copy(); 	coef_matrix[2][2] = int1.copy();
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i | 2 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//set the matrix size
		scan_info.addSize(3);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		init_exp.add(int0.copy());
		init_exp.add(int1.copy());
		scan_info.addInitialExpression(init_exp);
		
		//get the updating vector
		AffineFunction cur_dep1 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-1)");
		Domain init_domain1 = PolyhedralIRUtility.parseDomain(param, " {i | i==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep1, 1, init_domain1);
		AffineFunction cur_dep2 = PolyhedralIRUtility.parseAffineFunction(param, "(i->i-2)");
		Domain init_domain2 = PolyhedralIRUtility.parseDomain(param, " {i | i==1}");
		scan_info.addUpdatingVector(scan_var, cur_dep2, 2, init_domain2);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec1 = scan_info.createVector(scan_var, cur_dep1.copy(), 1, init_domain1.copy());
		vecList.add(vec1);
		VectorInformation vec2 = scan_info.createVector(scan_var, cur_dep2.copy(), 2, init_domain2.copy());
		vecList.add(vec2);
		targetInitDomainMap.put("fib", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i | 2 <= i <= N}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> dir1 = new Vector<Long>();
		dir1.add(1L);
		directions.add(dir1);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix
		int[][] optimization_matrix = new int[3][3];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[0][2] = 3;
		optimization_matrix[1][0] = 3;
		optimization_matrix[1][1] = 3;
		optimization_matrix[1][2] = 3;
		optimization_matrix[2][0] = 0;
		optimization_matrix[2][1] = 0;
		optimization_matrix[2][2] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
	
	@Test public void testLexiScan() {
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/LexiScan.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
		String oriOutDir = outScanPrefix+"/lexi_scan";
		String oriSystemName = "LexiScan";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);
		
		/*String outDir = outDirPrefix+"/lexi_scan";
		String systemName = "LexiScan";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("B");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);
		IntegerExpression int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp1;
		coef_matrix[0][1] = var_exp2;
		coef_matrix[1][0] = int1;
		coef_matrix[1][1] = int2;
		
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i,j| j==0 && 1 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//add the second matrix
		//get the coef matrix for domain j==0 && i >= 1
		VariableDeclaration coe_matrix_var1 = system.getVariableDeclaration("C");
		VariableExpression coe_matrix_exp1 = _fact.createVariableExpression(coe_matrix_var1);
		
		VariableDeclaration coe_matrix_var2 = system.getVariableDeclaration("B");
		VariableExpression coe_matrix_exp2 = _fact.createVariableExpression(coe_matrix_var2);
		
		IntegerExpression coe_matrix_int1 = _fact.createIntegerExpression(0);
		IntegerExpression coe_matrix_int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix2 = new Expression[2][2];
		coef_matrix2[0][0] = coe_matrix_exp1;
		coef_matrix2[0][1] = coe_matrix_exp2;
		coef_matrix2[1][0] = coe_matrix_int1;
		coef_matrix2[1][1] = coe_matrix_int2;
		
		
		Domain matrix_dom2 = PolyhedralIRUtility.parseDomain(param, "{i,j| 0<= i <= N && 1 <= j <= M}");
		scan_info.addCoefficientMatrix(matrix_dom2, coef_matrix2);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init = _fact.createVariableExpression(coe_var1);
		init_exp.add(init);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i,j-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, " {i, j|i==0 && j==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep, 1, init_domain);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec = scan_info.createVector(scan_var, cur_dep, 1, init_domain.copy());
		vecList.add(vec);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i, j| 0 < i <= N && 0 <= j <= M} || {i, j|i==0 && 0 < j <= M}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Integer>> directions = new LinkedList<Vector<Integer>>();
		Vector<Integer> vec1 = new Vector<Integer>();
		vec1.add(0);
		vec1.add(1);
		Vector<Integer> vec2 = new Vector<Integer>();
		vec2.add(1);
		vec2.add(0);
		directions.add(vec1);
		directions.add(vec2);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);*/
		
	/*	TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(program.getSystem(systemName));
		tm.setMemoryMap(tm.getMemorySpace("M"), system.getVariableDeclaration("M"), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i, j, k -> j, k)"), null);
		tm.getSpaceTimeMap(system.getVariableDeclaration("X")).setMapping(
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i, 0, 0)"));
		
		tm.getSpaceTimeMap(system.getVariableDeclaration("Y")).setMapping(
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i->i, 0, 0)"));

//		tm.getSpaceTimeMap(system.getVariableDeclaration("temp_C")).setMapping(
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->0,k,i,j)"));
//		tm.getSpaceTimeMap(system.getVariableDeclaration("C")).setMapping(
//				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->1,k,i,j)"));
//		
//		tm.setStatementOrder(system.getEquation("temp_C"), system.getEquation("C"));
//		tm.setStatementOrder(system.getEquation("C"), system.getEquation("temp_C"));
		
		system.setTargetMapping(tm);
		
		ScheduledC.generate(system, options, outDir);

		WrapperGeneratorForC.generate(system, options, outDir);
		
		PolyIRCodeGen.generateMakefile(system, outDir);*/
	}
	
	@Test public void testLexiScanSim() {
		options.flattenArrays = true;
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodegenTest/LexiScanSim.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		
		/*String oriOutDir = outScanPrefix+"/lexi_scan_sim";
		String oriSystemName = "LexiScanSim";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);*/
		
		String outDir = outDirPrefix+"/lexi_scan_sim";
		String systemName = "LexiScanSim";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();

		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration scan_var = system.getVariableDeclaration("X");
		scan_info.addTarget(scan_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var1 = system.getVariableDeclaration("A");
		VariableExpression var_exp1 = _fact.createVariableExpression(coe_var1);
		
		VariableDeclaration coe_var2 = system.getVariableDeclaration("B");
		VariableExpression var_exp2 = _fact.createVariableExpression(coe_var2);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);
		IntegerExpression int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = var_exp1;
		coef_matrix[0][1] = var_exp2;
		coef_matrix[1][0] = int1;
		coef_matrix[1][1] = int2;
		
		
		Domain matrix_dom1 = PolyhedralIRUtility.parseDomain(param, "{i,j| j==0 && 1 <= i <= N}");
		
		
		scan_info.addCoefficientMatrix(matrix_dom1, coef_matrix);
		
		//add the second matrix
		//get the coef matrix for domain j==0 && i >= 1
		VariableDeclaration coe_matrix_var1 = system.getVariableDeclaration("A");
		VariableExpression coe_matrix_exp1 = _fact.createVariableExpression(coe_matrix_var1);
		
		VariableDeclaration coe_matrix_var2 = system.getVariableDeclaration("B");
		VariableExpression coe_matrix_exp2 = _fact.createVariableExpression(coe_matrix_var2);
		
		IntegerExpression coe_matrix_int1 = _fact.createIntegerExpression(0);
		IntegerExpression coe_matrix_int2 = _fact.createIntegerExpression(1);
		
		Expression[][] coef_matrix2 = new Expression[2][2];
		coef_matrix2[0][0] = coe_matrix_exp1;
		coef_matrix2[0][1] = coe_matrix_exp2;
		coef_matrix2[1][0] = coe_matrix_int1;
		coef_matrix2[1][1] = coe_matrix_int2;
		
		
		Domain matrix_dom2 = PolyhedralIRUtility.parseDomain(param, "{i,j| 0<= i <= N && 1 <= j <= M}");
		scan_info.addCoefficientMatrix(matrix_dom2, coef_matrix2);
		
		//set the matrix size
		scan_info.addSize(2);
		
		//get initial variable expression
		List<Expression> init_exp = new LinkedList<Expression>();
		VariableExpression init = _fact.createVariableExpression(coe_var1);
		init_exp.add(init);
		scan_info.addInitialExpression(init_exp);
		
		
		//get the updating vector
		AffineFunction cur_dep = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i,j-1)");
		Domain init_domain = PolyhedralIRUtility.parseDomain(param, " {i, j|i==0 && j==0}");
		scan_info.addUpdatingVector(scan_var, cur_dep, 1, init_domain);
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList = new LinkedList<VectorInformation>();
		VectorInformation vec = scan_info.createVector(scan_var, cur_dep, 1, init_domain.copy());
		vecList.add(vec);
		targetInitDomainMap.put("X", vecList);
		scan_info.addInitialDoamin(targetInitDomainMap);
		//Map<VariableDeclaration, Map<Integer,Domain> > = new HashMap<VariableDeclaration, Map<Integer, Domain>>();
		
		//create the scan domain
		Domain scan_domain = PolyhedralIRUtility.parseDomain(param, "{i, j| 0 < i <= N && 0 <= j <= M} || {i, j|i==0 && 0 < j <= M}");
		scan_info.addScanDomain(scan_domain);
		
		//add the direction list
		List<Vector<Long>> directions = new LinkedList<Vector<Long>>();
		Vector<Long> vec1 = new Vector<Long>();
		vec1.add(0L);
		vec1.add(1L);
		Vector<Long> vec2 = new Vector<Long>();
		vec2.add(1L);
		vec2.add(0L);
		directions.add(vec1);
		directions.add(vec2);
		scan_info.addDirections(directions);
		
		//set the operator
		scan_info.addOPlus(OP.ADD);
		scan_info.addOTimes(OP.MUL);
		
		//construct the optimization matrix for lexiscan
		int[][] optimization_matrix = new int[2][2];
		optimization_matrix[0][0] = 3;
		optimization_matrix[0][1] = 3;
		optimization_matrix[1][0] = 0;
		optimization_matrix[1][1] = 1;
		
		scan_info.addOptimizationMatrix(optimization_matrix);
		
		scan_info.ScanInfoPrint();
		
		//transformation test
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForScanC(system, scan_info);
		
		//code generation part
		ScanC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
}
