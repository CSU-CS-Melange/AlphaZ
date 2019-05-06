package edu.csu.melange.alphaz.mde.tests.polyIR.equivalence;

/**
 * This test is commented out since support for equivalence is dropped in the port.
 * 
 *
 */
public class TestTemplateAlgorithm {
	
//	// DEBUG STEP 1
//	
//	void testTemplateAutomatonConstruction(AffineSystem syst, AffineSystem systTempl, Map<String, String> mapInOutputs, String output1, String output2) {
//		EquivalenceProblem prob = EquivalenceUserFactory.createTemplateEquivalenceProblem_String(syst, systTempl, mapInOutputs);
//		VariableDeclaration varDecl1 = syst.getVariableDeclaration(output1);
//		VariableDeclaration varDecl2 = systTempl.getVariableDeclaration(output2);
//		
//		// Main function to be tested
//		List<EquivAutoBuilderOutput> lautBuildOutput = prob.buildListEquivalenceAutomaton(varDecl1, varDecl2);
//		
//		// Printing-out the result
//		for (EquivAutoBuilderOutput out : lautBuildOutput) {
//			PresburgerAutomaton auto = out.getEquivalenceAutomaton();
//			FastISLDomain dom = out.getFailureStateApproxInfo();		// Note: might be null
//			
//			System.out.println("==========================================================================");
//			System.out.println(auto.toDot());
//			System.out.println();
//			System.out.print("		=> dom = ");
//			if (dom==null || dom.getIslSet()==null)
//				System.out.println("null");
//			else
//				System.out.println(dom.getIslSet().toString());
//			System.out.println();
//		}
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplate_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/equiv.ab");
//		
//		AffineSystem syst1 = program.getSystem("syst1");
//		AffineSystem syst2 = program.getSystem("syst2");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("I", "I1");
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateSimple_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimple.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateNMatch_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimpleNMatch.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateUnroll_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimpleUnroll.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "O1");
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateReduction_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateReduction.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "OT");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "O", "OT");
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateCholesky_St1() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholesky.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Lloc", "L1");
//		
//		testTemplateAutomatonConstruction(syst1, syst2, mapInOutputs, "Lloc", "L1");
//		
//		return;
//	}
//	
//	
//	/* ------------------------------------------------------------------------------------------- */
//	
//	// DEBUG STEP 2 & 3
//	void testTemplateConstraintExtraction(AffineSystem syst, AffineSystem systTempl, Map<String, String> mapInOutputs,
//			String output1, String output2, boolean preprocess) {
//		// Preprocess
//		if (preprocess) {
//			PreprocessTemplate.preprocessSystemForTemplateReco(syst);
//			PreprocessTemplate.preprocessSystemForTemplateReco(systTempl);
//		}
//		
//		System.out.println("*** syst=\n" + syst.toString());
//		System.out.println();
//		System.out.println("*** systTempl=\n" + systTempl.toString());
//		System.out.println("-------------------------------------------------------------------------------");
//		
//		
//		EquivalenceProblem prob = EquivalenceUserFactory.createTemplateEquivalenceProblem_String(syst, systTempl, mapInOutputs);
//		VariableDeclaration varDecl1 = syst.getVariableDeclaration(output1);
//		VariableDeclaration varDecl2 = systTempl.getVariableDeclaration(output2);
//		
//		if ((varDecl1==null) || (varDecl2==null))
//			throw new RuntimeException("varDecl1 or varDecl2 are set to null (output not found)");
//		
//		// Main function to be tested
//		Pair<Boolean,Map<VariableDeclaration,Expression>> result = TemplateAlgorithm.templateAlgorithm(prob, varDecl1, varDecl2, syst.getContainerProgram());
//		
//		// Printing-out the result
//		System.out.println();
//		System.out.println("-------------------------------------------------------------------------------");
//		System.out.println("Is Matching = " + result.getValue0());
//		System.out.println("Matched expressions:");
//		for (VariableDeclaration varDecl : result.getValue1().keySet()) {
//			Expression expr = result.getValue1().get(varDecl);
//			System.out.println("	* " + varDecl.getName() + "  ==> " + PolyhedralIRToAlphabets.toString(expr));
//			System.out.println();
//		}
//	}
//	
//	@Test
//	public void testTemplateSimple_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimple.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "O", "O1", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateNMatch_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimpleNMatch.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "O", "O1", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateUnroll_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSimpleUnroll.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "O1");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "O", "O1", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateReduction_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateReduction.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "OT");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "O", "OT", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateMatMult_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateMatMult.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("O", "OT");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "O", "OT", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateCholesky_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholesky.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Lloc", "L1");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "Lloc", "L1", false);		// Note: if true, trans closure does not end
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateCholeskyTileLbl1_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholeskyLblTile1.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("L_bl_out0", "X");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "L_bl_out0", "X", false);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateCholeskyComm_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholeskyComm.ab");
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Lloc", "L1");
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "Lloc", "L1", false);		// Note: if true, trans closure does not end
//		
//		return;
//	}
//	
//	// Test for debug
//	
//	@Test
//	public void testTemplateCholeskyTileTR0_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholeskyTR0Tile0.ab");
//		
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("cholesky__TempRed0_Tile_0");
//		AffineSystem syst2 = program.getSystem("template");
//		
//		PreprocessTemplate.reduceDimOutput(syst1);
//		
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("_TempRed0_out0", "yT");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "_TempRed0_out0", "yT", true);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateCholeskyTileTR0_2_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholeskyTR0Tile0_2.ab");
//		
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("cholesky__TempRed0_Tile_0");
//		AffineSystem syst2 = program.getSystem("template");
//		
//		PreprocessTemplate.reduceDimOutput(syst1);
//		
//		/* DEBUG GET ROOT OP
//		GetRootOperation visitor = new GetRootOperation(syst1);
//		syst1.getEquation(syst1.getOutputs().get(0).getName()).accept(visitor);
//		System.out.println(visitor._operation);
//		//*/
//		
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("OutVar_0", "CT");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "OutVar_0", "CT", true);
//		
//		return;
//	}
//	
//	// TODO: recheck the result of this one
//	@Test
//	public void testTemplateCholeskyTileLbl2_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateCholeskyLblTile2.ab");
//
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("systProg");
//		AffineSystem syst2 = program.getSystem("template");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("L_bl_out0", "L");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "L_bl_out0", "L", true);
//		
//		return;
//	}
//	
//	// Do not match, because of a conflict on "L" for the diagonal elements
//	//		=> improvement of ParamTiling_Outlining (at the level of _inputInfos) to be done
//	@Test
//	public void testTemplateSdpmiTileLinv0_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSdpmi_LinvTile0.ab");
//
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("sdpmi_Linv_bl_Tile_0");
//		AffineSystem syst2 = program.getSystem("Linv");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Linv_bl_out0", "C");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "Linv_bl_out0", "C", true);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateSdpmiTileLinv1_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSdpmi_LinvTile1.ab");
//
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("sdpmi_Linv_bl_Tile_1");
//		AffineSystem syst2 = program.getSystem("sum_reductionLow");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Linv_bl_out0", "C");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "Linv_bl_out0", "C", true);
//		
//		return;
//	}
//	
//	@Test
//	public void testTemplateSdpmiTileLinv0Bis_St23() {
//		Program program = Basic.ReadAlphabets("../org.polymodel.equivalence/example/template/templateSpdmiLinvT0.ab");
//
//		ManageUnarySubstraction.manageUnarySubstraction(program);
//		
//		AffineSystem syst1 = program.getSystem("sdpmi_Linv_bl_Tile_0");
//		AffineSystem syst2 = program.getSystem("Linv_distr");
//		Map<String,String> mapInOutputs = new HashMap<String,String>();
//		mapInOutputs.put("Linv_bl_out0", "C");
//		
//		ExpressionDomainCalculator.computeExpressionDomain(syst1);
//		ExpressionDomainCalculator.computeExpressionDomain(syst2);
//		
//		testTemplateConstraintExtraction(syst1, syst2, mapInOutputs, "Linv_bl_out0", "C", true);
//		
//		return;
//	}
//	
//	
//	/* ------------------------------------------------------------------------------------------- */
//	void testSemanticTiling(String progName, List<String> subsystToSkip, List<Map<String,AffineFunction>> alignInfoInput) {
//		Program prog = Basic.ReadAlphabets(progName);
//		
//		long starttime = System.currentTimeMillis();
//		List<Triplet<String, Domain,InfoRecoTemplate>> outputSemTiling = SemanticTiling.semanticTiling(prog, subsystToSkip, alignInfoInput);
//		
//		// Print-out result
//		System.out.println("**************************************************************************");
//		System.out.println("**************************************************************************");
//		System.out.println("**************************************************************************");
//		for (Triplet<String, Domain,InfoRecoTemplate> tNameDomInfo : outputSemTiling) {
//			System.out.println("[[[[ "+ tNameDomInfo.getValue0() + " on Domain " + tNameDomInfo.getValue1().toString());
//			System.out.println(tNameDomInfo.getValue2().toString());
//			System.out.println("]]]]\n");
//		}
//		long totalTime = System.currentTimeMillis() - starttime;
//		
//		// Print-out stats
//		System.out.println("~> Time taken by the tiling transformation + post-processing  = " + (SemanticTiling._currenttimeTilingDone - starttime) );
//		System.out.println("~> Number of subsystems = " + SemanticTiling._numSubsyst);
//		System.out.println();
//		System.out.println("~> Num Comparison done = " + SemanticTiling._nComparisonDone);
//		System.out.println("~> Num Automata checked = " + TemplateAlgorithm._numAutomatonChecked);
//		System.out.println("~> Num State checked = " + TemplateAlgorithm._numStateChecked);
//		System.out.println("~> Num Sub Equiv problem = " + TemplateAlgorithm._numSubEquivProblem);
//		System.out.println("~> Total time = " + totalTime + " ms");
//		System.out.println();
//		
//		int nTemplateDetected = 0;
//		for (Triplet<String, Domain,InfoRecoTemplate> tNameDomInfo : outputSemTiling) {
//			InfoRecoTemplate irt = tNameDomInfo.getValue2();
//			nTemplateDetected += irt.getNbTemplate();
//		}
//		System.out.println("~> Num Template detected = " + nTemplateDetected);
//		
//		return;
//	}
//	
//	@Test
//	public void testMatmul() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		testSemanticTiling("testcases/matrix_product_withReduce/matrix_product_withReduce.ab", subSystemToSkip, null);
//	}
//	
//	@Test
//	public void testCholesky() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		subSystemToSkip.add("cholesky_L_bl_Tile_0");						// transitive closure takes too much time
//		subSystemToSkip.add("cholesky_L_bl_Tile_2");						// transitive closure of first automaton takes ~ 5 mins
//		
//		testSemanticTiling("../edu.csu.melange.alphaz.polybench/polybench-alpha-4.0/linear-algebra/solvers/cholesky/cholesky.ab",
//				subSystemToSkip, null);
//	}
//
//	@Test
//	public void testSDPMI() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		subSystemToSkip.add("sdpmi_L_bl_Tile_2");		// L^T takes too much times (build too much automatons)
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/sdpmi.ab", subSystemToSkip, null);
//	}
//	
//	@Test
//	public void testSilvesterEquation() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		subSystemToSkip.add("silvester_X_bl_Tile_0");			// Too much time (for all operations)
//		subSystemToSkip.add("silvester_X_bl_Tile_1");			// Too much time
//		subSystemToSkip.add("silvester_X_bl_Tile_2");			// Too much time
//		subSystemToSkip.add("silvester_X_bl_Tile_3");			// Too much time
//		subSystemToSkip.add("silvester__TempRed1_Tile_0");		// Bug here
//		
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/silvester.ab", subSystemToSkip, null);
//	}
//	
//	/*@Test
//	public void testAPP() {								// WARNING: the tiling is not legal !!!
//		List<String> subSystemToSkip = new BasicEList<String>();
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/APP.ab", subSystemToSkip, null);
//	}*/
//	
//	@Test
//	public void testAPP2() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//
//		subSystemToSkip.add("APP_temp1Maxj_bl_Tile_3");			// subproblem takes too much time
//		
//		// ====> 6 tile groups:
//		//	- O
//		//	- crossBot
//		//	- crossUp
//		//	- temp1Maxi
//		//	- crossLeft / temp1Maxj
//		//	- crossMid/crossRight/temp2Mini/temp2Minj
//		ParameterDomain paramDom = PolyhedralIRUtility.parseParameterDomain("{N | N>2}");
//		
//		List<Map<String,AffineFunction>> alignInfo = new BasicEList<Map<String,AffineFunction>>();
//		
//		Map<String,AffineFunction> mVarDeclO = new HashMap<String, AffineFunction>();
//		mVarDeclO.put("O", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i,j,N-1)"));
//		alignInfo.add(mVarDeclO);
//		
//		Map<String,AffineFunction> mVarDeclCrossBot = new HashMap<String, AffineFunction>();
//		mVarDeclCrossBot.put("crossBottom", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		alignInfo.add(mVarDeclCrossBot);
//		
//		Map<String,AffineFunction> mVarDeclCrossUp = new HashMap<String, AffineFunction>();
//		mVarDeclCrossUp.put("crossUp", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		alignInfo.add(mVarDeclCrossUp);
//		
//		Map<String,AffineFunction> mVarDecltemp1Maxi = new HashMap<String, AffineFunction>();
//		mVarDecltemp1Maxi.put("temp1Maxi", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		alignInfo.add(mVarDecltemp1Maxi);
//		
//		Map<String,AffineFunction> mVarDeclCrossLeft = new HashMap<String, AffineFunction>();
//		mVarDeclCrossLeft.put("crossLeft", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		mVarDeclCrossLeft.put("temp1Maxj", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		alignInfo.add(mVarDeclCrossLeft);
//		
//		Map<String,AffineFunction> mVarDeclCrossMid = new HashMap<String, AffineFunction>();
//		mVarDeclCrossMid.put("crossMiddle", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		mVarDeclCrossMid.put("crossRight", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		mVarDeclCrossMid.put("temp2Mini", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		mVarDeclCrossMid.put("temp2Minj", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j,k->i,j,k)"));
//		alignInfo.add(mVarDeclCrossMid);
//		
//		
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/APP2.ab", subSystemToSkip, alignInfo);
//	}
//	
//	@Test
//	public void testOSP() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		
//		ParameterDomain paramDom = PolyhedralIRUtility.parseParameterDomain("{N | 2<=N }");
//		
//		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
//		Map<String,AffineFunction> mVarDeclOutput = new HashMap<String, AffineFunction>();
//		mVarDeclOutput.put("FTable", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i-1,j-1)"));
//		alignmentInfo.add(mVarDeclOutput);
//		
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/ReductionOSP.ab", subSystemToSkip, alignmentInfo);
//	}
//	
//	// TODO: improve detection rate...
//	@Test
//	public void testMcCaskill() {
//		List<String> subSystemToSkip = new BasicEList<String>();
//		subSystemToSkip.add("fmcc_Qb_bl_Tile_0");
//		subSystemToSkip.add("fmcc_Qb_bl_Tile_3");
//		subSystemToSkip.add("fmcc__TempRed6_Tile_0");		// Bug in setting the value of a context domain? oO
//		
//		
//		/*
//		ParameterDomain paramDom = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
//		
//		List<Map<String,AffineFunction>> alignInfo = new BasicEList<Map<String,AffineFunction>>();
//		
//		Map<String,AffineFunction> mVarDeclCrossLeft = new HashMap<String, AffineFunction>();
//		mVarDeclCrossLeft.put("Q", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i,j)"));
//		alignInfo.add(mVarDeclCrossLeft);
//		
//		Map<String,AffineFunction> mVarDeclCrossMid = new HashMap<String, AffineFunction>();
//		mVarDeclCrossMid.put("Qb", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i,j)"));
//		//mVarDeclCrossMid.put("QbTemp", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i,j)"));
//		mVarDeclCrossMid.put("Qm2", PolyhedralIRUtility.parseAffineFunction(paramDom, "(i,j->i,j)"));
//		alignInfo.add(mVarDeclCrossMid);
//		//*/
//		
//		testSemanticTiling("../org.polymodel.equivalence/example/applications/fmcc_adapted.ab", subSystemToSkip, null);//alignInfo);
//	}
	
	
	// TODO piRNA_adapted selections
	
} // TestTemplateAlgorithm
