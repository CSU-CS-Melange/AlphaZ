package edu.csu.melange.alphaz.mde.tests.codegen;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ReductionC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ScanCodeGenInfo;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.TransformationsForScanC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.recurrence.ScanInformations;
import org.polymodel.polyhedralIR.recurrence.ScanInformations.VectorInformation;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;

public class ReductionCTest {
	
	private static String outDirPrefix = "./test-out/reductionC/";
	private static String outScheduleCPrefix = "./test-out/ScheduleC/";
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;

	public static void main(String[] args) {
		try {
			CodeGenOptions options = CodeGenOptions.scheduledCDefault();
			testMSS(options);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		testMSS(options);
	}
	private static void testMSS(CodeGenOptions options) throws IOException{
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/scanCodeGenTest/mssReduction.ab");
		alphaz.mde.Analysis.CheckProgram(program);
		alphaz.mde.Basic.Show(program);
		
/*		String oriOutDir = outScheduleCPrefix + "/mss";
		String oriSystemName = "MssReduction";
		AffineSystem oriSystem = program.getSystem(oriSystemName);
		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(program.getSystem(oriSystemName));
		
		tm.setSpaceTimeMap(oriSystem.getVariableDeclaration("m"), 
				PolyhedralIRUtility.parseAffineFunction(oriSystem.getParameters(), "(->N+1)"));
		
		oriSystem.setTargetMapping(tm);
		
		ScheduledC.generate(oriSystem, options, oriOutDir);

		WrapperGeneratorForC.generate(oriSystem, options, oriOutDir);
		
		PolyIRCodeGen.generateMakefile(oriSystem, oriOutDir);*/
		
		String outDir = outDirPrefix+"/mssReduction";
		String systemName = "MssReduction";
		AffineSystem sys = program.getSystem(systemName);
		AffineSystem system = EcoreUtil.copy(sys);
		
		ParameterDomain param = system.getParameters();
		
		//construct the information for test
		ScanInformations scan_info = new ScanInformations();
		//get the scan variable
		VariableDeclaration reduct_var = system.getVariableDeclaration("m");
		scan_info.addTarget(reduct_var);
		
		//tempary using variables
		VariableDeclaration temp_var = system.getVariableDeclaration("T");
		VariableExpression temp_exp = _fact.createVariableExpression(temp_var);
		
		//get the coefficient matrix
		VariableDeclaration coe_var = system.getVariableDeclaration("X");
		VariableExpression var_exp = _fact.createVariableExpression(coe_var);
		
		IntegerExpression int1 = _fact.createIntegerExpression(0);	//identity for +/max
		IntegerExpression int2 = _fact.createIntegerExpression(1);  //identity for +
		
		Expression[][] coef_matrix = new Expression[2][2];
		coef_matrix[0][0] = int2.copy();
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
		scan_info.addUpdatingVector(temp_var, cur_dep.copy(), 1, init_domain.copy());
		
		//create initial domain
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		List<VectorInformation> vecList_temp = new LinkedList<VectorInformation>();
		VectorInformation vec_temp = scan_info.createVector(temp_var, cur_dep.copy(), 1, init_domain.copy());
		vecList_temp.add(vec_temp);
		targetInitDomainMap.put("T", vecList_temp);
		
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
		ScanCodeGenInfo codeGeninfo = TransformationsForScanC.transformationsForReductionC(system, scan_info);
		
		//code generation part
		ReductionC.generate(codeGeninfo.getMainBodySystem(), options, outDir, codeGeninfo);

		TargetMapping tm =  TargetMappingUserFactory.createIdentityTargetMapping(codeGeninfo.getMainBodySystem());
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(
				codeGeninfo.getMainBodySystem().getVariableDeclaration("m"),
				PolyhedralIRUtility.parseAffineFunction(codeGeninfo.getMainBodySystem().getParameters(), "(->N+1)"));
		stlevel.getSpaceTimeMaps().put(stMap.getLabel(), stMap);
		codeGeninfo.getMainBodySystem().setTargetMapping(tm);
		
		WrapperGeneratorForC.generate(codeGeninfo.getMainBodySystem(), options, outDir);
		
		PolyIRCodeGen.generateMakefile(codeGeninfo.getMainBodySystem(), outDir);
	}
}
