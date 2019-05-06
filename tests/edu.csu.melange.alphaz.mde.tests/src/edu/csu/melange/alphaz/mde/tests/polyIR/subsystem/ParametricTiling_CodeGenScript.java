package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.javatuples.Pair;
import org.javatuples.Septet;
import org.junit.Test;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.SystemCallAnalysis;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.wrapper.WrapperGeneratorForC;
import org.polymodel.polyhedralIR.targetMapping.util.TargetMappingGeneratorParamTilingOutlining;
import org.polymodel.polyhedralIR.targetMapping.util.TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification;
import org.polymodel.polyhedralIR.transformation.NormalizeVisitor;
import org.polymodel.polyhedralIR.transformation.ParametricTiling;
import org.polymodel.polyhedralIR.transformation.ParametricTilingOutlining;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import alphaz.mde.CodeGen;

public class ParametricTiling_CodeGenScript {
	// Generation of the .cs after CARTing
	@Test
	public void customTestCARTOutlining_GenCS_J1D() {
		System.out.println("*** Kernel - Jacobi 1D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// AlignmentInfo => we fill it with Id function + one tile group per variable...
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		// Local variable: temp
		VariableDeclaration varDeclTemp = syst.getVariableDeclaration("temp");
		Map<String,AffineFunction> mVarDeclTemp = new HashMap<String, AffineFunction>();
		mVarDeclTemp.put(varDeclTemp.getName(), PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i+t)"));
		alignmentInfo.add(mVarDeclTemp);
		
		for (VariableDeclaration varDeclOut : syst.getOutputs()) {
			Map<String,AffineFunction> mVarDeclOutput = new HashMap<String, AffineFunction>();
			mVarDeclOutput.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
			alignmentInfo.add(mVarDeclOutput);
		}
		
		// Getting the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		System.out.println(AShow.toString(program));
		
//			System.out.print(UniquenessAndCompletenessCheck.validate(program).toString());
//			System.out.println("	=> Check Program Done " + (System.currentTimeMillis()-startTime) + " ms");
		
//			System.out.println();
		
		Septet<List<List<Map<String,VariableDeclaration>>>,
			Map<String,List<Pair<long[][],VariableDeclaration>>>,
			Map<String,List<Pair<long[][],List<Expression>>>>,
			Map<String,List<AffineFunction>>,
			List<List<String>>,
			Map<String,Pair<FastISLMap,String>>,
			List<List<Pair<String, Boolean>>> > qDataStructSaved = ParametricTilingOutlining._dataStructSaved;
		
		// 1st element: llVarDeclSubSyst (Tile group / Kind of tile / mapping old var to corresponding local variable declaration
		// 2nd element: mStrVarDeclCase (Main syst / correspondance orig var => gather var)
		// 3rd element: mInternalCaseExpr (Main syst / correspondance gather var => outputs useEq)
		// 4th element: mlAlignOut (info about post-processing)
		// 5th element: List of subsystem name, classified by tile group
		// 6th element: Map associating the name of a "TempRed/SG" variable, with the projection function and the father variable
		// 7th element: nlAlignmentInfo (tile group / kind of tile / name of variable + boolean which is true iff it's a TempRedSG)
		
		List<List<Map<String,VariableDeclaration>>> llVarDeclSubSyst = qDataStructSaved.getValue0();
		Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase = qDataStructSaved.getValue1();
		Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr = qDataStructSaved.getValue2();
		Map<String,List<AffineFunction>> mlAlignOut = qDataStructSaved.getValue3();
		List<List<String>> llSubSystName = qDataStructSaved.getValue4();
		Map<String,Pair<FastISLMap,String>> mTempRed = qDataStructSaved.getValue5();
		List<List<Pair<String, Boolean>>> lNAlignmentInfo = qDataStructSaved.getValue6();
		
		System.out.println("---- DATA STRUCT SAVED ----");
		System.out.println("*** llVarDeclSubSyst = ");
		for (List<Map<String,VariableDeclaration>> lVarDeclSubsyst : llVarDeclSubSyst)
		for (Map<String,VariableDeclaration> mVarDeclSubsyst : lVarDeclSubsyst) {
			System.out.println(" * " + mVarDeclSubsyst.toString());
		}
		System.out.println();
		System.out.println("*** mStrVarDeclCase = ");
		for (String str : mStrVarDeclCase.keySet()) {
			System.out.println("	* strVar = " + str);
			List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mStrVarDeclCase.get(str);
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl) {
				System.out.println("		-> " + pMatVarDecl.getValue1().toString());
			}
		}
		System.out.println();
		System.out.println("*** mInternalCaseExpr = ");
		for (String str : mInternalCaseExpr.keySet()) {
			System.out.println("	* strVar = " + str);
			List<Pair<long[][],List<Expression>>> lpMatVarDecl = mInternalCaseExpr.get(str);
			for (Pair<long[][],List<Expression>> pMatVarDecl : lpMatVarDecl) {
				System.out.print("		-> " + MatrixOperations.toString(pMatVarDecl.getValue0()));
				for (Expression expr : pMatVarDecl.getValue1())
				System.out.println("			~> " + PolyhedralIRToAlphabets.toString(expr));
			}
		}
		
		System.out.println();
		System.out.println("*** mlAlignOut = ");			// First inputs, then outputs
		for (String subSystName : mlAlignOut.keySet()) {
			System.out.println("	* Subsystem " + subSystName);
			List<AffineFunction> lAlignOut = mlAlignOut.get(subSystName);
			for (AffineFunction func : lAlignOut)
				System.out.println("		-> " + func.toString());
		}
		System.out.println();
		System.out.println("*** llSubSystName = ");			// First inputs, then outputs
		for (List<String> lSubSystName : llSubSystName) {
			System.out.println("	* " + lSubSystName);
		}
		System.out.println("*** mTempRed = ");
		for (String nameTempRed : mTempRed.keySet()) {
			Pair<FastISLMap, String> pInfoTempRed = mTempRed.get(nameTempRed);
			System.out.println("	* " + nameTempRed + " -> " + pInfoTempRed.getValue0() + " | " + pInfoTempRed.getValue1());
		}
		System.out.println("*** lNAlignmentInfo = ");
		for (List<Pair<String,Boolean>> nAlignInfo : lNAlignmentInfo) {
			System.out.println("	*");
			for (Pair<String,Boolean> pAlignInfo : nAlignInfo)
				System.out.println("		- " + pAlignInfo.getValue0() + " | " + pAlignInfo.getValue1());
		}
	}
	
	@Test
	public void customTestCARTOutlining_GenCS_J2D() {
		System.out.println("*** Kernel - Jacobi 2D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_2d/jacobi_2d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// AlignmentInfo => we fill it with Id function + one tile group per variable...
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		// Local variable: temp
		VariableDeclaration varDeclTemp = syst.getVariableDeclaration("temp");
		Map<String,AffineFunction> mVarDeclTemp = new HashMap<String, AffineFunction>();
		mVarDeclTemp.put(varDeclTemp.getName(), PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i+t,j+t)"));
		alignmentInfo.add(mVarDeclTemp);
		
		for (VariableDeclaration varDeclOut : syst.getOutputs()) {
			Map<String,AffineFunction> mVarDeclOutput = new HashMap<String, AffineFunction>();
			mVarDeclOutput.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
			alignmentInfo.add(mVarDeclOutput);
		}
		
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		System.out.println(AShow.toString(program));
		
//			System.out.print(UniquenessAndCompletenessCheck.validate(program).toString());
//			System.out.println("	=> Check Program Done " + (System.currentTimeMillis()-startTime) + " ms");
		
//			System.out.println();
		
		// Data structure saved pretty printer
		Septet<List<List<Map<String,VariableDeclaration>>>,
			Map<String,List<Pair<long[][],VariableDeclaration>>>,
			Map<String,List<Pair<long[][],List<Expression>>>>,
			Map<String,List<AffineFunction>>,
			List<List<String>>,
			Map<String,Pair<FastISLMap,String>>,
			List<List<Pair<String, Boolean>>> > qDataStructSaved = ParametricTilingOutlining._dataStructSaved;
		
		// 1st element: llVarDeclSubSyst (Tile group / Kind of tile / mapping old var to corresponding local variable declaration
		// 2nd element: mStrVarDeclCase (Main syst / correspondance orig var => gather var)
		// 3rd element: mInternalCaseExpr (Main syst / correspondance gather var => outputs useEq)
		// 4th element: mlAlignOut (info about post-processing)
		// 5th element: List of subsystem name, classified by tile group
		// 6th element: Map associating the name of a "TempRed/SG" variable, with the projection function and the father variable
		// 7th element: nlAlignmentInfo (tile group / kind of tile / name of variable + boolean which is true iff it's a TempRedSG)
		
		List<List<Map<String,VariableDeclaration>>> llVarDeclSubSyst = qDataStructSaved.getValue0();
		Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase = qDataStructSaved.getValue1();
		Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr = qDataStructSaved.getValue2();
		Map<String,List<AffineFunction>> mlAlignOut = qDataStructSaved.getValue3();
		List<List<String>> llSubSystName = qDataStructSaved.getValue4();
		Map<String,Pair<FastISLMap,String>> mTempRed = qDataStructSaved.getValue5();
		List<List<Pair<String,Boolean>>> lNAlignmentInfo = qDataStructSaved.getValue6();
		
		System.out.println("---- DATA STRUCT SAVED ----");
		System.out.println("*** llVarDeclSubSyst = ");
		for (List<Map<String,VariableDeclaration>> lVarDeclSubsyst : llVarDeclSubSyst)
		for (Map<String,VariableDeclaration> mVarDeclSubsyst : lVarDeclSubsyst) {
			System.out.println(" * " + mVarDeclSubsyst.toString());
		}
		System.out.println();
		System.out.println("*** mStrVarDeclCase = ");
		for (String str : mStrVarDeclCase.keySet()) {
			System.out.println("	* strVar = " + str);
			List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mStrVarDeclCase.get(str);
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl) {
				System.out.println("		-> " + pMatVarDecl.getValue1().toString());
			}
		}
		System.out.println();
		System.out.println("*** mInternalCaseExpr = ");
		for (String str : mInternalCaseExpr.keySet()) {
			System.out.println("	* strVar = " + str);
			List<Pair<long[][],List<Expression>>> lpMatVarDecl = mInternalCaseExpr.get(str);
			for (Pair<long[][],List<Expression>> pMatVarDecl : lpMatVarDecl) {
				System.out.print("		-> " + MatrixOperations.toString(pMatVarDecl.getValue0()));
				for (Expression expr : pMatVarDecl.getValue1())
				System.out.println("			~> " + PolyhedralIRToAlphabets.toString(expr));
			}
		}
		
		System.out.println();
		System.out.println("*** mlAlignOut = ");
		for (String subSystName : mlAlignOut.keySet()) {
			System.out.println("	* Subsystem " + subSystName);
			List<AffineFunction> lAlignOut = mlAlignOut.get(subSystName);
			for (AffineFunction func : lAlignOut)
				System.out.println("		-> " + func.toString());
		}
		System.out.println();
		System.out.println("*** llSubSystName = ");			// First inputs, then outputs
		for (List<String> lSubSystName : llSubSystName) {
			System.out.println("	* " + lSubSystName);
		}
		System.out.println("*** mTempRed = ");
		for (String nameTempRed : mTempRed.keySet()) {
			Pair<FastISLMap, String> pInfoTempRed = mTempRed.get(nameTempRed);
			System.out.println("	* " + nameTempRed + " -> " + pInfoTempRed.getValue0() + " | " + pInfoTempRed.getValue1());
		}
		System.out.println("*** lNAlignmentInfo = ");
		for (List<Pair<String,Boolean>> nAlignInfo : lNAlignmentInfo) {
			System.out.println("	*");
			for (Pair<String,Boolean> pAlignInfo : nAlignInfo)
				System.out.println("		- " + pAlignInfo.getValue0() + " | " + pAlignInfo.getValue1());
		}
	}
	
	/* -------------------------------------------------------------------- */
	
	@Test
	public void generateCSScriptCARTOutlining_MatMult() {
		System.out.println("*** Kernel - Matmult No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/linear-algebra/blas/gemm/gemm_noRed.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Tile Group
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mCobPreprocessTemp.put("Cout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,Q)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("Cout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(0); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		List<Integer> modFactorCOut = new BasicEList<Integer>(); modFactorCOut.add(0); modFactorCOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorCOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorCOut);
		mLocMemMapTemp.put("Cout", pMemFuncModFactorCOut);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->k,i,j)");					// i and j are parallel dims
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->k,i,j)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->k,i,j)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		List<Integer> modFactorTempBlCout = new BasicEList<Integer>(); modFactorTempBlCout.add(0); modFactorTempBlCout.add(0); modFactorTempBlCout.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBlCout =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTempBlCout);
		mBlMemMapTemp.put("Cout", pMemFuncModFactorBlCout);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		NormalizeVisitor.normalize(syst);
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				syst.getName(), ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				syst.getName(), ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	@Test
	public void generateCSScriptCARTOutlining_J1D() {
		System.out.println("*** Kernel - Jacobi 1D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->i+t,t)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->i+t,t)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->i+t,t)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"), modFactorTempBl);
//		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0);
//		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
//				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->i-t)"), modFactorTempBl);		// FIXME: Best, but fails
		
		
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	@Test
	public void generateCSScriptCARTOutlining_SW3D() {
		System.out.println("*** Kernel - Smith-Waterman 3D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/SW3D.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x,y,z)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x,y,z)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(0); modFactorTemp.add(0); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x,y)"), modFactorTemp);	// Valid because of the schedule
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x+y+z,y,z)");	// Second & third dim parallel
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x+y+z,y,z)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x+y+z,y,z)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(x,y,z->x,y,z)"), modFactorTempBl);
		
		
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "score"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->)"));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("score", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>();
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->)"), modFactorOut);
		mLocMemMapOut.put("score", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->NX,0,0)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->NX,0,0)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->NX,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>();
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(->)"), modFactorOutLoc);
		mBlMemMapOut.put("score", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"SW3D", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"SW3D", ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	
	// TODO: code gen takes a long time
	@Test
	public void generateCSScriptCARTOutlining_J2D() {
		System.out.println("*** Kernel - Jacobi 2D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 10;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_2d/jacobi_2d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i+t,j+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t+i+j,t,i)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t+i+j,t,i)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t+i+j,t,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T+i+j,T,i)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T+i+j,T,i)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T+i+j,T,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	@Test
	public void generateCSScriptCARTOutlining_CholeskyNoRed() {
		System.out.println("*** Kernel - Cholesky No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/testcases/cholesky/cholesky_noReduce.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: L, Temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
			
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,j)"));
		mCobPreprocessTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));			// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorL = new BasicEList<Integer>(); modFactorL.add(0); modFactorL.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorL =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorL);
		mLocMemMapTemp.put("L", pMemFuncModFactorL);
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("Temp", pMemFuncModFactor1);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i+j,j,k)");				// Wavefront
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i+j,j,k)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i+j,j,k)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("Temp", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorLBl = new BasicEList<Integer>(); modFactorLBl.add(0); modFactorLBl.add(0); modFactorLBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorLBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorLBl);
		mBlMemMapTemp.put("L", pMemFuncModFactorLBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		System.out.println(program.toString());
		//System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
		
	}
	
	
	// NOTE: Tiling is not legal, but the generated .cs is used as a base for the modified .ab file
	@Test
	public void generateCSScriptCARTOutlining_OSP() {
		System.out.println("*** Kernel - OSP No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSP/OSPNoRed.ab");
		String nameMainSyst = "ReductionOSP";
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1,j-1,j-1)"));
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1,j-1,k-1)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("FTable", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("temp", pMemFuncModFactor2);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 1, N-j, k)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 0, 0, 0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 2, 0, 0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("FTable", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorTemp2Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG TODO
		System.out.println(program.toString());
		System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		
	}
	
	// TODO: memory issues + takes a long time
	@Test
	public void generateCSScriptCARTOutlining_OSPGTK() {
		System.out.println("*** Kernel - OSPGTK-hand ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSPGKT-hand_Simpl.ab");
		String nameMainSyst = "OSPGKT_hand";
		
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsCacc = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		// Change of Basis - preprocessing
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1, j-1, N )"));
		mCobPreprocessTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1, 2N-j, N-k)"));
		tgsCacc._mCobPreprocessing = mCobPreprocessTemp;
		
		// Local space time map information
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsCacc._mLocalSpaceTimeMap = mLocSTMTemp;
		
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("C", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("Cacc", pMemFuncModFactor2);
		tgsCacc._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsCacc._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 1, j, k)");
		tgsCacc._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 0, 0, 0)");
		tgsCacc._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 2, 0, 0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("C", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("Cacc", pMemFuncModFactorTemp2Bl);
		tgsCacc._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsCacc);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		//System.out.println(program.toString());
		//System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	
	
	
	/* --------------------------------------------------------------------- */
	/* -------------------- BENCHMARK HYBRID SCHEDULING -------------------- */
	/* --------------------------------------------------------------------- */
	@Test
	public void generateCSScriptCARTOutlining_J1D_Hybrid() {
		System.out.println("*** Kernel - Jacobi 1D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,1,i)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,2,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(2); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i-t)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,1,i)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,0,0)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,2,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	@Test
	public void generateCSScriptCARTOutlining_J1D_Seq() {
		System.out.println("*** Kernel - Jacobi 1D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(2); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i-t)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,i)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,i)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	@Test
	public void generateCSScriptCARTOutlining_J1D_Wave() {
		System.out.println("*** Kernel - Jacobi 1D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(2);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t+i,i)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t+i,i)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t+i,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(2); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i->t,i-t)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->T+i,i)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i->i)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_1d", ParametricTilingOutlining._dataStructSaved);
		
		String outDir = "./out-dir/" + syst.getName() + "/";
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			/*
			System.out.println("------------------- TARGET MAPPING ------------------------");
			TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			System.out.println("------------------------------------------");
			System.out.println(sys.getName());
			//*/
			
			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), outDir);
		}
		CodeGenOptions cgOption;
		if (syst.getTargetMapping().isTiled()) {
			cgOption =  TiledCodeGenOptions.scheduledCDefault();
		} else {
			cgOption = CodeGenOptions.scheduledCDefault();
		}
		WrapperGeneratorForC.generate(syst, cgOption, outDir);
		CodeGen.generateMakefile(program, syst.getName(), outDir);
		
		System.out.println("\n\n\n WORKED!");
	}
	
	
	
	// TODO [[[ code gen takes a long time
	@Test
	public void generateCSScriptCARTOutlining_J2D_Hybrid() {
		System.out.println("*** Kernel - Jacobi 2D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 10;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_2d/jacobi_2d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i+t,j+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,1,i,j)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,0,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,1,i,j)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,0,0,0)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	@Test
	public void generateCSScriptCARTOutlining_J2D_Hybrid2D() {
		System.out.println("*** Kernel - Jacobi 2D ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 10;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/stencils/jacobi_2d/jacobi_2d.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** First tile group: temporary variable "temp"
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i+t,j+t)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp = new BasicEList<Integer>(); modFactorTemp.add(2); modFactorTemp.add(0); modFactorTemp.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTemp);
		mLocMemMapTemp.put("temp", pMemFuncModFactor);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,1,j)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,2,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTempBl = new BasicEList<Integer>(); modFactorTempBl.add(0); modFactorTempBl.add(0); modFactorTempBl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorBl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(t,i,j->t,i,j)"), modFactorTempBl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorBl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		// *** Second tile group: output variable "out"
		TileGroupSpecification tgsOut = new TileGroupSpecification();

		Map<String,AffineFunction> mCobPreprocessOut = new HashMap<String, AffineFunction>();
		VariableDeclaration varDeclOut = syst.getOutputs().get(0);
		mCobPreprocessOut.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
		tgsOut._mCobPreprocessing = mCobPreprocessOut;
		
		Map<String,AffineFunction> mLocSTMOut = new HashMap<String, AffineFunction>();
		mLocSTMOut.put("Aout", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"));
		tgsOut._mLocalSpaceTimeMap = mLocSTMOut;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorOut = new BasicEList<Integer>(); modFactorOut.add(0); modFactorOut.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOut =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOut);
		mLocMemMapOut.put("Aout", pMemFuncModFactorOut);
		tgsOut._mLocalMemoryMap = mLocMemMapOut;
		
		tgsOut._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,i,1,j)");
		tgsOut._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,i,0,0)");
		tgsOut._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->T,i,2,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapOut = new HashMap<String, Pair<AffineFunction,List<Integer>> >();	// Output: no mem map
		List<Integer> modFactorOutLoc = new BasicEList<Integer>(); modFactorOutLoc.add(0); modFactorOutLoc.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorOutLoc =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j)"), modFactorOutLoc);
		mBlMemMapOut.put("Aout", pMemFuncModFactorOutLoc);
		tgsOut._mBlockMemoryMap = mBlMemMapOut;
		
		pttm.add(tgsOut);
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"jacobi_2d", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	// TODO ]]]
	
	
	@Test
	public void generateCSScriptCARTOutlining_CholeskyNoRed_Hybrid() {
		System.out.println("*** Kernel - Cholesky No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/testcases/cholesky/cholesky_noReduce.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: L, Temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,j)"));
		mCobPreprocessTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));			// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("Temp", pMemFuncModFactor1);
		List<Integer> modFactorTemp3 = new BasicEList<Integer>(); modFactorTemp3.add(0); modFactorTemp3.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp3);
		mLocMemMapTemp.put("L", pMemFuncModFactor3);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,1,j,k)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,0,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("Temp", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp3Bl = new BasicEList<Integer>(); modFactorTemp3Bl.add(0); modFactorTemp3Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp3Bl);
		mBlMemMapTemp.put("L", pMemFuncModFactor3Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		System.out.println(program.toString());
		System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
		
	}
	
	@Test
	public void generateCSScriptCARTOutlining_CholeskyNoRed_ikj_Hybrid() {
		System.out.println("*** Kernel - Cholesky No Red ikj ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/testcases/cholesky/cholesky_noReduce.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: L, Temp1, Temp2
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,j)"));
		mCobPreprocessTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));			// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("Temp", pMemFuncModFactor1);
		List<Integer> modFactorTemp3 = new BasicEList<Integer>(); modFactorTemp3.add(0); modFactorTemp3.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp3);
		mLocMemMapTemp.put("L", pMemFuncModFactor3);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,1,k,j)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,0,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("Temp", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp3Bl = new BasicEList<Integer>(); modFactorTemp3Bl.add(0); modFactorTemp3Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp3Bl);
		mBlMemMapTemp.put("L", pMemFuncModFactor3Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		System.out.println(program.toString());
		System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
		
	}
	
	@Test
	public void generateCSScriptCARTOutlining_CholeskyNoRed_Hybrid2D() {
		System.out.println("*** Kernel - Cholesky No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/testcases/cholesky/cholesky_noReduce.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: L, Temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,j)"));
		mCobPreprocessTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));			// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("Temp", pMemFuncModFactor1);
		List<Integer> modFactorTemp3 = new BasicEList<Integer>(); modFactorTemp3.add(0); modFactorTemp3.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp3);
		mLocMemMapTemp.put("L", pMemFuncModFactor3);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,j,1,k)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,j,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,j,2,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("Temp", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp3Bl = new BasicEList<Integer>(); modFactorTemp3Bl.add(0); modFactorTemp3Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp3Bl);
		mBlMemMapTemp.put("L", pMemFuncModFactor3Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		//System.out.println(program.toString());
		//System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
		
	}
	
	@Test
	public void generateCSScriptCARTOutlining_CholeskyNoRed_Hybrid1DKfirst() {
		System.out.println("*** Kernel - Cholesky No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/testcases/cholesky/cholesky_noReduce.ab");
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: L, Temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,j)"));
		mCobPreprocessTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("Temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("L", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));			// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("Temp", pMemFuncModFactor1);
		List<Integer> modFactorTemp3 = new BasicEList<Integer>(); modFactorTemp3.add(0); modFactorTemp3.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp3);
		mLocMemMapTemp.put("L", pMemFuncModFactor3);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> k,1,i,j)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> k,0,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> k,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("Temp", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp3Bl = new BasicEList<Integer>(); modFactorTemp3Bl.add(0); modFactorTemp3Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor3Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp3Bl);
		mBlMemMapTemp.put("L", pMemFuncModFactor3Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				"cholesky", ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
		
	}
	
	
	// TODO [[[ takes a long time
	@Test
	public void generateCSScriptCARTOutlining_OSPGTK_Hybrid1D() {
		System.out.println("*** Kernel - OSPGTK-hand ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSPGKT-hand_Simpl.ab");
		String nameMainSyst = "OSPGKT_hand";
		
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsCacc = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		// Change of Basis - preprocessing
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1, j-1, N )"));
		mCobPreprocessTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1, 2N-j, N-k)"));
		tgsCacc._mCobPreprocessing = mCobPreprocessTemp;
		
		// Local space time map information
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsCacc._mLocalSpaceTimeMap = mLocSTMTemp;
		
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("C", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("Cacc", pMemFuncModFactor2);
		tgsCacc._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsCacc._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 1, j, k)");
		tgsCacc._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 0, 0, 0)");
		tgsCacc._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 2, 0, 0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("C", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("Cacc", pMemFuncModFactorTemp2Bl);
		tgsCacc._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsCacc);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		//System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	@Test
	public void generateCSScriptCARTOutlining_OSPGTK_Hybrid1D_ikj() {
		System.out.println("*** Kernel - OSPGTK-hand ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSPGKT-hand_Simpl.ab");
		String nameMainSyst = "OSPGKT_hand";
		
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsCacc = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		// Change of Basis - preprocessing
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1, j-1, N )"));
		mCobPreprocessTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1, 2N-j, N-k)"));
		tgsCacc._mCobPreprocessing = mCobPreprocessTemp;
		
		// Local space time map information
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		tgsCacc._mLocalSpaceTimeMap = mLocSTMTemp;
		
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("C", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("Cacc", pMemFuncModFactor2);
		tgsCacc._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsCacc._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 1, j, k)");
		tgsCacc._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 0, j, k)");
		tgsCacc._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 2, j, k)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("C", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("Cacc", pMemFuncModFactorTemp2Bl);
		tgsCacc._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsCacc);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		System.out.println(program.toString());
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	@Test
	public void generateCSScriptCARTOutlining_OSPGTK_Hybrid2D() {
		System.out.println("*** Kernel - OSPGTK-hand ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSPGKT-hand_Simpl.ab");
		String nameMainSyst = "OSPGKT_hand";
		
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsCacc = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		// Change of Basis - preprocessing
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1, j-1, N )"));
		mCobPreprocessTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1, 2N-j, N-k)"));
		tgsCacc._mCobPreprocessing = mCobPreprocessTemp;
		
		// Local space time map information
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("Cacc", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsCacc._mLocalSpaceTimeMap = mLocSTMTemp;
		
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("C", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("Cacc", pMemFuncModFactor2);
		tgsCacc._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsCacc._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, j, 1, k)");
		tgsCacc._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, j, 0, k)");
		tgsCacc._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, j, 2, k)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("C", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("Cacc", pMemFuncModFactorTemp2Bl);
		tgsCacc._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsCacc);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	// TODO ]]]]
	
	
	@Test
	public void generateCSScriptCARTOutlining_LTMI_Hybrid1D_ikj() {
		System.out.println("*** Kernel - LTMI No Red Hybrid ikj ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 4;
		
		long startTime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/LTMI_noRed.ab");
		String systName = program.getSystems().get(0).getName();
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: C, temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i,j,i)"));
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("C", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));		// Note: after CoB !
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("C", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("temp", pMemFuncModFactor2);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,1,k,j)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,0,0,0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i,2,0,0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("C", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorTemp2Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// DEBUG
		//System.out.println(program.toString());
		//System.out.println(UniquenessAndCompletenessCheck.validate(program));
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				systName, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				systName, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	// The following 2 tilings are not legal, but the .cs generated is a good based for the hand-modified, legal tiling
	@Test
	public void generateCSScriptCARTOutlining_OSP_Hybrid1D() {
		System.out.println("*** Kernel - OSP No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSP/OSPNoRed.ab");
		String nameMainSyst = "ReductionOSP";
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1,j-1,j-1)"));
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1,j-1,k-1)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,k,j)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("FTable", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("temp", pMemFuncModFactor2);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 1, N-j,k)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 0, 0, 0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, 2, 0, 0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("FTable", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorTemp2Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	@Test
	public void generateCSScriptCARTOutlining_OSP_Hybrid2D() {
		System.out.println("*** Kernel - OSP No Red ***");

		Map<String,List<Integer>> lscaleInputs = new HashMap<String,List<Integer>>();
		boolean paramDiv = true;
		int minB = 6;
		
		long startTime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("../edu.csu.melange.alphaz.mde.tests/alphabets/SubSystemExamples/Benchmark_CART/OSP/OSPNoRed.ab");
		String nameMainSyst = "ReductionOSP";
		System.out.println("	=> Parsing Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		AffineSystem syst = program.getSystems().get(0);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		for (int i=0; i<syst.getParameters().getNParams(); i++)		// We assume there is only one system in each Polybench kernels
			lParamMin.add(3);
		
		
		
		
		// --- Tile Group Specification
		List<TileGroupSpecification> pttm = new BasicEList<TileGroupSpecification>();
		
		// *** Single tile group: FTable, temp
		TileGroupSpecification tgsTemp = new TargetMappingGeneratorParamTilingOutlining.TileGroupSpecification();
		
		Map<String,AffineFunction> mCobPreprocessTemp = new HashMap<String, AffineFunction>();
		mCobPreprocessTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j->i-1,j-1,j-1)"));
		mCobPreprocessTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i-1,j-1,k-1)"));
		tgsTemp._mCobPreprocessing = mCobPreprocessTemp;
		
		Map<String,AffineFunction> mLocSTMTemp = new HashMap<String, AffineFunction>();
		mLocSTMTemp.put("FTable", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		mLocSTMTemp.put("temp", PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"));
		tgsTemp._mLocalSpaceTimeMap = mLocSTMTemp;
		
		Map<String,Pair<AffineFunction,List<Integer>>> mLocMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1 = new BasicEList<Integer>(); modFactorTemp1.add(0); modFactorTemp1.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor1 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp1);
		mLocMemMapTemp.put("FTable", pMemFuncModFactor1);
		List<Integer> modFactorTemp2 = new BasicEList<Integer>(); modFactorTemp2.add(0); modFactorTemp2.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactor2 =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j)"), modFactorTemp2);
		mLocMemMapTemp.put("temp", pMemFuncModFactor2);
		tgsTemp._mLocalMemoryMap = mLocMemMapTemp;
		
		tgsTemp._blockSpaceTimeMap = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, N-j, 1, k)");
		tgsTemp._blockSpaceTimeMapMemAllocUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, N-j, 0, 0)");
		tgsTemp._blockSpaceTimeMapMemFreeUse = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k -> i, N-j, 0, 0)");
		
		Map<String,Pair<AffineFunction,List<Integer>>> mBlMemMapTemp = new HashMap<String, Pair<AffineFunction,List<Integer>> >();
		List<Integer> modFactorTemp1Bl = new BasicEList<Integer>(); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0); modFactorTemp1Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp1Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp1Bl);
		mBlMemMapTemp.put("FTable", pMemFuncModFactorTemp1Bl);
		List<Integer> modFactorTemp2Bl = new BasicEList<Integer>(); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0); modFactorTemp2Bl.add(0);
		Pair<AffineFunction,List<Integer>> pMemFuncModFactorTemp2Bl =
				Pair.with(PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(i,j,k->i,j,k)"), modFactorTemp2Bl);
		mBlMemMapTemp.put("temp", pMemFuncModFactorTemp2Bl);
		tgsTemp._mBlockMemoryMap = mBlMemMapTemp;
		
		pttm.add(tgsTemp);
		
		
		
		
		// *** Recovering the alignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : pttm)
			alignmentInfo.add(tgs.conversionToAlignInfoElement());
		
		// Option to tell the transformation that we want to get the informations....
		ParametricTilingOutlining._optionSaveInformations = true;
		ParametricTilingOutlining._optionPostprocessReduceDimInOutputVariable = true;
		
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lParamMin, alignmentInfo);
		System.out.println("	=> Monoparametric-Outline Tiling Done " + (System.currentTimeMillis()-startTime) + " ms");
		
		
		// Generating the script !
		String genCSScript = TargetMappingGeneratorParamTilingOutlining.scriptGeneratorParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		//* Pretty-printer
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(genCSScript);
		//*/
		
		//*
		TargetMappingGeneratorParamTilingOutlining.setTargetMappingParamTilingOutlining(program, pttm,
				nameMainSyst, ParametricTilingOutlining._dataStructSaved);
		
		List<AffineSystem> systems = SystemCallAnalysis.getUsedSystems(program.getSystem(syst.getName()));
		for (AffineSystem sys : systems) {
			//System.out.println("------------------- TARGET MAPPING ------------------------");
			//TargetMappingGeneratorParamTilingOutlining.targetMappingPrettyPrinter(sys.getTargetMapping());
			//System.out.println("------------------------------------------");
			//System.out.println(sys.getName());

			ScheduledC.generate(sys, CodeGenOptions.scheduledCDefault(), "./out-dir/" + syst.getName() + "/");
		}
		
		System.out.println("\n\n\n WORKED!");
		//*/
	}
	
	
} // ParametricTiling_CodeGenScript
