package org.polymodel.polyhedralIR.targetMapping.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;
import org.javatuples.Septet;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.transformation.ParametricTiling;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;

/**
 * .cs script generator for the target mapping of programs after parametric tiling with outlining
 * 
 * @author giooss
 */
public class TargetMappingGeneratorParamTilingOutlining {
	
	/**
	 * Data-structure to store the critical informations about a tile group for the TargetMapping after parametric tiling with outlining
	 * 
	 * @author giooss
	 */
	public static class TileGroupSpecification {
		// Information required by the tiling transformation
		public Map<String, AffineFunction> _mCobPreprocessing;
		
		// Information about the TM after transformation
		public Map<String, AffineFunction> _mLocalSpaceTimeMap;						// STMapping for the local variable in the subsystems
		public Map<String, Pair<AffineFunction, List<Integer>>> _mLocalMemoryMap;	// Memory mapping for the local variable in the subsystems
		
		public AffineFunction _blockSpaceTimeMap;									// STMapping for the blocks in the main system
		public AffineFunction _blockSpaceTimeMapMemAllocUse = null;					// By default, copy of _blockSpaceTimeMap
		public AffineFunction _blockSpaceTimeMapMemFreeUse = null;					// By default, copy of _blockSpaceTimeMap
		
		public Map<String, Pair<AffineFunction, List<Integer>>> _mBlockMemoryMap;	// Memory mapping for the variable in the main system
		
		public TileGroupSpecification() {
		}
		
		public Map<String,AffineFunction> conversionToAlignInfoElement() {
			return this._mCobPreprocessing;
		}
		
	} // PreTilingTargetMapping
	
	/**
	 * Convert the full tile group specification to the alignmentInfo needed by the tiling transformation
	 * 
	 * @param lTGS
	 * @return
	 */
	public List<Map<String,AffineFunction>> conversionToAlignInfo(List<TileGroupSpecification> lTGS) {
		List<Map<String,AffineFunction>> alignInfo = new BasicEList<Map<String,AffineFunction>>();
		for (TileGroupSpecification tgs : lTGS)
			alignInfo.add(tgs.conversionToAlignInfoElement());
		return alignInfo;
	}
	
	
	// --------------------------------------------------------------------------------------------------------------------------------------------
	static boolean boolOptimAlwaysTriggered_DEBUG = false;		// TODO DEBUG (true => optim always triggered)
	
	/**
	 * Pretty printer (to .cs) of the output target mapping
	 * 
	 * @param tiledProg
	 * @param pttm
	 * @return
	 */
	public static String scriptGeneratorParamTilingOutlining(Program tiledProg, List<TileGroupSpecification> pttm, String nameMainSyst,
			Septet<List<List<Map<String,VariableDeclaration>>>,
				Map<String,List<Pair<long[][],VariableDeclaration>>>,
				Map<String,List<Pair<long[][],List<Expression>>>>,
				Map<String,List<AffineFunction>>,
				List<List<String>>,
				Map<String,Pair<FastISLMap,String>>,
				List<List<Pair<String, Boolean>>> > qDataStructSaved) {
		// Recovering the information about the tiling transformation
		// => 1st element: llVarDeclSubSyst (Tile group / Kind of tile / mapping old var to corresponding local variable declaration
		// => 2nd element: mStrVarDeclCase (Main syst / correspondance orig var => gather var)
		// => 3rd element: mInternalCaseExpr (Main syst / correspondance gather var => outputs useEq)
		// => 4th element: mlAlignOut (info about post-processing)
		// 5th element: List of subsystem name, classified by tile group
		List<List<Map<String,VariableDeclaration>>> llVarDeclSubSyst = qDataStructSaved.getValue0();
		Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase = qDataStructSaved.getValue1();
		Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr = qDataStructSaved.getValue2();
		Map<String,List<AffineFunction>> mlAlignOut = qDataStructSaved.getValue3();
		List<List<String>> llSubSystName = qDataStructSaved.getValue4();
		Map<String,Pair<FastISLMap,String>> mTempRed = qDataStructSaved.getValue5();
		List<List<Pair<String, Boolean>>> lNAlignmentInfo = qDataStructSaved.getValue6();
		
		tempRedManagement(pttm, mTempRed, lNAlignmentInfo);
		
		// Mapping gather var => output vars
		Map<String,List<String>> mStrVarGatherVarOutMain = getmappingGatherOutMainVar(mStrVarDeclCase, mInternalCaseExpr);
		
		List<Variable> lParamMainSyst = tiledProg.getSystem(nameMainSyst).getParameters().getParams();
		int nParamBlocked = (lParamMainSyst.size()-1)/2;
		List<Variable> lnParam = lParamMainSyst.subList(0, nParamBlocked);
		blockingParameters(pttm, lnParam);		// For blocked information: \vec{p} => \vec{p_b}
		
		for (TileGroupSpecification tgs : pttm) {
			if (tgs._blockSpaceTimeMapMemAllocUse==null)
				tgs._blockSpaceTimeMapMemAllocUse = tgs._blockSpaceTimeMap.copy();
			if (tgs._blockSpaceTimeMapMemFreeUse==null)
				tgs._blockSpaceTimeMapMemFreeUse = tgs._blockSpaceTimeMap.copy();
		}
		
		/* DEBUG
		System.out.println("mStrVarGatherVarOutMain =");
		for (String strVarGather : mStrVarGatherVarOutMain.keySet()) {
			System.out.println("	* " + strVarGather + " -> " + mStrVarGatherVarOutMain.get(strVarGather).toString());
		}
		//*/
		
		String strRes = "\n# Start Auto-generated part of the script\n";
		
		// --- SubSystem generation ---
		strRes = "\n# ================================== SubSystem generation ==================================\n";
		for (int numSubSyst=0; numSubSyst<tiledProg.getSystems().size(); numSubSyst++) {
			AffineSystem subSyst = tiledProg.getSystems().get(numSubSyst);
			
			String nameSubSyst = subSyst.getName();
			if (nameSubSyst.equals(nameMainSyst))		// Not a subsystem but the main system
				continue;
			
			// Recover the tile group of the current Subsystem
			Pair<Integer,Integer> pNumGroupKind = recoverTileGroupKindGroupIndices(nameSubSyst,llSubSystName);
			int numTileGroup = pNumGroupKind.getValue0();
			int numKindTile = pNumGroupKind.getValue1();
			TileGroupSpecification tgs = pttm.get(numTileGroup);
			
			strRes += "subSystem = \"" + nameSubSyst + "\";\n";
			
			// Spacetime map for the local variables of the subsystem (not the output)
			int nDimSTMap = -1;
			Map<String,VariableDeclaration> mOrigVarNameVarLoc = llVarDeclSubSyst.get(numTileGroup).get(numKindTile);
			for (String nameOrigVar : mOrigVarNameVarLoc.keySet()) {
				String nameVarLocSubsyst = mOrigVarNameVarLoc.get(nameOrigVar).getName();
				
				String nameOrigVarMinBl = nameOrigVar.substring(0, nameOrigVar.length()- ParametricTiling.suffixBlVar.length());
				AffineFunction locMapping = tgs._mLocalSpaceTimeMap.get(nameOrigVarMinBl);
				
				String nLocMappingStr;
				if (locMapping.getDimRHS()==0) {
					String locMappingStr = locMapping.toString();
					nLocMappingStr = locMappingStr.replace(')','0');
					nLocMappingStr += ")";
				} else {
					String locMappingStr = locMapping.toString();
					nLocMappingStr = locMappingStr.replace(')',',');
					nLocMappingStr += " 0)";
				}
				//String nLocMappingStr = locMappingStr.substring(0, locMappingStr.indexOf("->"));
				//nLocMappingStr += "-> 0,";
				//nLocMappingStr += locMappingStr.substring(locMappingStr.indexOf("->")+2, locMappingStr.length());
				
				strRes += "	setSpaceTimeMap(prog, subSystem, \"" + nameVarLocSubsyst + "\", \"" + nLocMappingStr + "\" );\n";
				
				if (nDimSTMap==-1)
					nDimSTMap = locMapping.getDimRHS();
			}

			// Spacetime map for the output variables of the subsystem
			List<AffineFunction> lRemappingInOutputs = mlAlignOut.get(nameSubSyst);
			for (int i=0; i<lRemappingInOutputs.size(); i++) {
				String nameOutputVar = subSyst.getOutputs().get(i).getName();
				AffineFunction affFuncRemaining = lRemappingInOutputs.get(i);
				
				String naffFuncRemainingStr;
				if (affFuncRemaining.getDimRHS()==0) {
					String locMappingStr = affFuncRemaining.toString();
					naffFuncRemainingStr = locMappingStr.replace(')','1');
					naffFuncRemainingStr += ")";
				} else {
					String locMappingStr = affFuncRemaining.toString();
					naffFuncRemainingStr = locMappingStr.replace(')',',');
					naffFuncRemainingStr += " 1)";
				}
				//String naffFuncRemainingStr = affFuncRemainingStr.substring(0, affFuncRemainingStr.indexOf("->"));
				//naffFuncRemainingStr += "-> 1,";
				//naffFuncRemainingStr += affFuncRemainingStr.substring(affFuncRemainingStr.indexOf("->")+2, affFuncRemainingStr.length());
				
				strRes += "	setSpaceTimeMap(prog, subSystem, \"" + nameOutputVar + "\", \"" +  naffFuncRemainingStr + "\" );\n";
				
				if (nDimSTMap==-1)
					nDimSTMap = affFuncRemaining.getDimRHS();
			}
			
			strRes += "	setOrderingDimensions(prog, subSystem, " + nDimSTMap + ");\n";
			
			// Statement ordering, so that the copy for the outputs are always after the equations for the local variables
			//for (String nameOrigVar : mOrigVarNameVarLoc.keySet()) {
			//	VariableDeclaration varDeclLocSubSyst = mOrigVarNameVarLoc.get(nameOrigVar);
			//	for (VariableDeclaration varDeclOutSubSyst : subSyst.getOutputs()) {
			//		strRes += "	setStatementOrdering(prog, subSystem, \"" + varDeclLocSubSyst.getName()
			//				+ "\", \"" + varDeclOutSubSyst.getName() + "\");\n";
			//	}
			//}
			
			// Memory Map for the local variable of the subsystem
			for (String nameOrigVar : mOrigVarNameVarLoc.keySet()) {
				VariableDeclaration varDeclLocSubSyst = mOrigVarNameVarLoc.get(nameOrigVar);
				String nameOrigVarMinBl = nameOrigVar.substring(0, nameOrigVar.length()- ParametricTiling.suffixBlVar.length());
				
				if (!tgs._mLocalMemoryMap.containsKey(nameOrigVarMinBl))
					continue;
				
				Pair<AffineFunction, List<Integer>> pInfoLocMemMapping = tgs._mLocalMemoryMap.get(nameOrigVarMinBl);
				
				AffineFunction memMappingFunc = pInfoLocMemMapping.getValue0();
				String strListModulos = "";
				for (Integer mod : pInfoLocMemMapping.getValue1()) {
					if (!strListModulos.isEmpty())
						strListModulos += ", ";
					strListModulos += mod.toString();
				}
				strRes += "setMemoryMap(prog, subSystem, \"" + varDeclLocSubSyst.getName() + "\", \"" + varDeclLocSubSyst.getName() + "\", \""
							+ memMappingFunc.toString() + "\", \"" + strListModulos + "\");\n";
			}
			
			// Separator
			strRes += "\n#================================================================\n#================================================================\n";
		}
		
		// ------------------------------
		// --- Main System generation ---
		// ------------------------------
		AffineSystem mainSyst = tiledProg.getSystem(nameMainSyst);
		strRes += "system = \"" + nameMainSyst + "\";\n\n\n";
		
		// Get the number of local indexes of the common Space-Time Mapping of the main system
		int nIndLocSTMGeneral = 0;
		for (TileGroupSpecification tgs : pttm) {
			int numDimTiled = tgs._blockSpaceTimeMap.getDimRHS();
			nIndLocSTMGeneral = Math.max(nIndLocSTMGeneral, numDimTiled);
		}
		
		// UseEquation management
		for (UseEquation uEq : mainSyst.getUseEquations()) {
			String subSystName = uEq.getSubSystem().getName();
			
			// Label
			strRes += "label = \"" + uEq.getLabel() +"\";\n\n";
			
			Pair<Integer,Integer> pNumGroupKind = recoverTileGroupKindGroupIndices(subSystName,llSubSystName);
			int numTileGroup = pNumGroupKind.getValue0();
			TileGroupSpecification tgs = pttm.get(numTileGroup);
			
			// Constants
			AffineFunction affFuncBl = tgs._blockSpaceTimeMap;
			AffineFunction affFuncBlReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBl.toString());
			String affFuncBlock = affFuncBlReparsed.toString();
			affFuncBlock = affFuncBlock.replace(')', ',');
			
			AffineFunction affFuncBlAlloc = tgs._blockSpaceTimeMapMemAllocUse;
			AffineFunction affFuncBlAllocReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBlAlloc.toString());
			String affFuncBlockAlloc = affFuncBlAllocReparsed.toString();
			affFuncBlockAlloc = affFuncBlockAlloc.replace(')', ',');
			
			AffineFunction affFuncBlFree = tgs._blockSpaceTimeMapMemFreeUse;
			AffineFunction affFuncBlFreeReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBlFree.toString());
			String affFuncBlockFree = affFuncBlFreeReparsed.toString();
			affFuncBlockFree = affFuncBlockFree.replace(')', ',');
			
			String strZeroLoc = "";
			for (int i=0; i<nIndLocSTMGeneral; i++) {
				if (!strZeroLoc.isEmpty())
					strZeroLoc += ",";
				strZeroLoc += "0";
			}
			strRes += "	mem_alloc = \"" + affFuncBlockAlloc + "0," + strZeroLoc + ")\";\n";
			strRes += "	input_copy = \"" + affFuncBlock + "1," + strZeroLoc + ")\";\n";
			strRes += "	sub_sys_call = \"" + affFuncBlock + "2," + strZeroLoc + ")\";\n";
			strRes += "	output_copy = \"" + affFuncBlock + "3," + strZeroLoc + ")\";\n";
			strRes += "	mem_free = \"" + affFuncBlockFree + "4," + strZeroLoc + ")\";\n";
			
			// Space-time mapping for the useEquation
			strRes += "	setSpaceTimeMap(prog, system, label, sub_sys_call);\n";
			
			// Determining if we trigger the optimization or not for each input of the subsystem
			List<Boolean> lOptimTriggeredInput = new BasicEList<Boolean>();
			for (int i=0; i<uEq.getInputs().size(); i++) {
				
				// BY DEFAULT - DEBUG
				if (boolOptimAlwaysTriggered_DEBUG)
					lOptimTriggeredInput.add(true);
				else {
					Expression inExpr = uEq.getInputs().get(i);
					AffineFunction depInExpr = PolyhedralIRUtility.createIdentityFunction(inExpr.getExpressionDomain());
					while (inExpr instanceof DependenceExpression) {
						depInExpr = ((DependenceExpression) inExpr).getDep().compose(depInExpr);
						inExpr = ((DependenceExpression) inExpr).getExpr();
					}
					
					if (!(inExpr instanceof VariableExpression))
						throw new RuntimeException("Expression inExpr = " + inExpr.toString() + " is not a variableExpression");
					VariableDeclaration varDeclInExpr = ((VariableExpression) inExpr).getVarDecl();
					
					// We determine if we want to optimize the memory access here or not...
					//	Note: varDeclInExpr can be either an input, or a gather variable
					AffineFunction memMapBl;
					if (mainSyst.isInput(varDeclInExpr)){
						memMapBl = PolyhedralIRUtility.createIdentityFunction(varDeclInExpr.getDomain());	// Input: Id memory allocation
					} else {
						String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, varDeclInExpr.getName());
						String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
						
						int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
						TileGroupSpecification tgsVarOrig = pttm.get(tileGroupNum);
						memMapBl = tgsVarOrig._mBlockMemoryMap.get(nameVarOrigMinBl).getValue0();
						
					}
					
					// DEBUG
					//System.out.println("uEq (subsyst: " + uEq.getSubSystem().getName() + ") - Input " + i + " => dep = " + depInExpr);
					
					boolean optimTriggered = optimInputUseEquation(varDeclInExpr, depInExpr, memMapBl, uEq, i);
					
					// DEBUG
					//System.out.println("	=> optimTriggered = " + optimTriggered + "\n");
					
					lOptimTriggeredInput.add(optimTriggered);
				}
			}
			
			for (int i=0; i<uEq.getInputs().size(); i++) {
				strRes += "	setSpaceTimeMapForUseEquationOptimization(prog, system, label, 0, " + i + ", mem_alloc, input_copy, mem_free);\n";
			}
			for (int i=0; i<uEq.getOutputs().size(); i++)
				strRes += "	setSpaceTimeMapForUseEquationOptimization(prog, system, label, 1, " + i + ", mem_alloc, output_copy, mem_free);\n";
			strRes += "\n";
			
			// Memory mapping for the useEquation
			for (int i=0; i<uEq.getInputs().size(); i++) {
				boolean optimTriggered = lOptimTriggeredInput.get(i);
				
				Expression inExpr = uEq.getInputs().get(i);
				while (inExpr instanceof DependenceExpression) {
					inExpr = ((DependenceExpression) inExpr).getExpr();
				}
				
				if (!(inExpr instanceof VariableExpression))
					throw new RuntimeException("Expression inExpr = " + inExpr.toString() + " is not a variableExpression");
				VariableDeclaration varDeclInExpr = ((VariableExpression) inExpr).getVarDecl();
				String memspaceName = varDeclInExpr.getName();
				
				// Note: this line only if optimization
				if (optimTriggered)
					strRes += "	setMemorySpaceForUseEquationOptimization(prog, system, label, 0, " + i + ", \"" + memspaceName + "\");\n";
//				else {
					//String nMemspaceName = uEq.getLabel() + "_In" + i;
					//strRes += "	setMemorySpaceForUseEquationOptimization(prog, system, label, 0, " + i + ", \"" + nMemspaceName + "\");\n";
//				}
			}
			
			for (int i=0; i<uEq.getOutputs().size(); i++) {
				VariableDeclaration varDeclOut = uEq.getOutputs().get(i);
				String memspaceName = getCorrespondingGatherVariableName(varDeclOut, mStrVarGatherVarOutMain);
				strRes += "	setMemorySpaceForUseEquationOptimization(prog, system, label, 1, " + i + ", \"" + memspaceName + "\");\n";
			}
			strRes += "\n#-------------\n";
		}
		
		// Target mapping for the output equations
		for (int i=0; i<mainSyst.getOutputs().size(); i++) {
			VariableDeclaration outvarDecl = mainSyst.getOutputs().get(i);
			String outvarName = outvarDecl.getName();
			
			// Getting the tile group for outvarName
			String outvarNameMinusBl = outvarName.substring(0, outvarName.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, outvarNameMinusBl);
			
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			AffineFunction blockSpaceTimeMap = tgs._blockSpaceTimeMap;
			List<String> lIndLocMapStr = findFreshLocalIndicesMapStr(blockSpaceTimeMap, blockSpaceTimeMap.getNIndices());
			
			String mapStr = "(";
			for (int k=0; k<blockSpaceTimeMap.getNIndices(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getIndices().get(k).getName();
				else
					mapStr += ", " + blockSpaceTimeMap.getIndices().get(k).getName();
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			
			mapStr += " -> ";
			
			for (int k=0; k<blockSpaceTimeMap.getDimRHS(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					mapStr += ", " + blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			if (blockSpaceTimeMap.getDimRHS()==0)
				mapStr += "6";
			else
				mapStr += ", 6";
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			if (lIndLocMapStr.size()==0)
				mapStr += ",";
			
			for (int k=lIndLocMapStr.size(); k<nIndLocSTMGeneral; k++)
				if (k==0)
					mapStr += " 0";
				else
					mapStr += ", 0";
			mapStr += ")";
			
			strRes += "setSpaceTimeMap(prog, system, \"" + outvarName + "\", \"" + mapStr + "\");\n";
		}
		
		// Target mapping for the gathering equations
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {

			// Getting the tile group for outvarName
			String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, nameVarGather);
			String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
			
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			AffineFunction blockSpaceTimeMap = tgs._blockSpaceTimeMap;
			List<String> lIndLocMapStr = findFreshLocalIndicesMapStr(blockSpaceTimeMap, blockSpaceTimeMap.getNIndices());
			
			String mapStr = "(";
			for (int k=0; k<blockSpaceTimeMap.getNIndices(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getIndices().get(k).getName();
				else
					mapStr += ", " + blockSpaceTimeMap.getIndices().get(k).getName();
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			
			mapStr += " -> ";
			
			for (int k=0; k<blockSpaceTimeMap.getDimRHS(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					mapStr += ", " + blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			if (blockSpaceTimeMap.getDimRHS()==0)
				mapStr += "5";
			else
				mapStr += ", 5";
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			if (lIndLocMapStr.size()==0)
				mapStr += ",";
			
			for (int k=lIndLocMapStr.size(); k<nIndLocSTMGeneral; k++)
				if (k==0)
					mapStr += " 0";
				else
					mapStr += ", 0";
			mapStr += ")";
			
			strRes += "setSpaceTimeMap(prog, system, \"" + nameVarGather + "\", \"" + mapStr+ "\");\n";
		}
		
		strRes += "\n#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		
		// Memory mapping
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {
			List<String> lVarOutUse = mStrVarGatherVarOutMain.get(nameVarGather);
			String strListVarOut = nameVarGather;
			for (String nameVarOutUse : lVarOutUse)
				strListVarOut += ", " + nameVarOutUse;
			strRes += "setMemorySpace(prog, system, \"" + nameVarGather + "\", \"" + strListVarOut + "\");\n";
		}
		/*for (VariableDeclaration outVarDecl : mainSyst.getOutputs()) {
			StandardEquation stEq = mainSyst.getEquation(outVarDecl.getName());
			Expression expr = stEq.getExpression();
			if (expr instanceof DependenceExpression)
				expr = ((DependenceExpression) expr).getExpr();
			String nameVarGather = ((VariableExpression) expr).getVarDecl().getName();
			strRes += "setMemorySpace(prog, system, \"" + nameVarGather + "\", \"" + outVarDecl.getName() + "\");\n";
		}
		//*/
		strRes += "\n";
		
		
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {
			List<String> lVarOut = mStrVarGatherVarOutMain.get(nameVarGather);
			
			// Getting the tile group for outvarName
			String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, nameVarGather);
			String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
			
			// Getting the map with the specifications
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			Map<String, Pair<AffineFunction, List<Integer>>> mBlockMemMap = tgs._mBlockMemoryMap;
			
			// Getting the name of the original variable
			Pair<AffineFunction, List<Integer>> pMemMapModFactor = mBlockMemMap.get(nameVarOrigMinBl);
			
			if (pMemMapModFactor==null) {
				// Not specified => take Id with [0...0] as modFactors
				VariableDeclaration varDeclGather = mainSyst.getVariableDeclaration(nameVarGather);
				
				UseEquation uEqVarOut0 = getUseEquationContainingOutput(mainSyst, lVarOut.get(0));
				int nDimBl = uEqVarOut0.getExtensionDomain().getNIndices();  // Number of blocked dimension in the variable varDeclGather
				
				List<Variable> lIndMapping = varDeclGather.getDomain().getIndices().subList(0, nDimBl);
				AffineFunction mapping = PolyhedralIRUtility.createIdentityFunction(varDeclGather.getDomain().getParams(), lIndMapping);
				
				List<Integer> modFactors = new BasicEList<Integer>();
				for (int k=0; k<mapping.getNIndices(); k++)
					modFactors.add(0);
				pMemMapModFactor = Pair.with(mapping,modFactors);
			}
			
			
			String modFactorStr = "";
			List<Integer> modFactor = pMemMapModFactor.getValue1();
			for (int k=0; k<modFactor.size(); k++)
				if (k==0)
					modFactorStr += modFactor.get(k);
				else
					modFactorStr += ", " + modFactor.get(k);
			for (int k=0; k<mainSyst.getVariableDeclaration(lVarOut.get(0)).getDomain().getNIndices()-pMemMapModFactor.getValue0().getIndices().size(); k++)			// Add the local indices
				modFactorStr += ", 0";
			strRes += "modfactor = \"" + modFactorStr + "\";\n";
			
			
			
			AffineFunction memMapBlock = pMemMapModFactor.getValue0();
			
			// -- strMemMapVarGather
			String strMemMapVarGather = "(";
			for (int k=0; k<memMapBlock.getIndices().size(); k++)
				if (k==0)
					strMemMapVarGather += memMapBlock.getIndices().get(k).getName();
				else
					strMemMapVarGather += ", " + memMapBlock.getIndices().get(k).getName();
			VariableDeclaration varDeclGather = mainSyst.getVariableDeclaration(nameVarGather);
			EList<String> freshLocalIndices = findFreshLocalIndicesMapStr(memMapBlock, varDeclGather.getDomain().getNIndices()-memMapBlock.getIndices().size());
			for (int k=memMapBlock.getIndices().size(); k<varDeclGather.getDomain().getNIndices(); k++)
				strMemMapVarGather += ", " + freshLocalIndices.get(k-memMapBlock.getIndices().size());
			
			strMemMapVarGather += " -> ";
			for (int k=0; k<memMapBlock.getDimRHS(); k++)
				if (k==0)
					strMemMapVarGather += memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					strMemMapVarGather += ", " + memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			
			UseEquation useEqlVarOut0 = getUseEquationContainingOutput(mainSyst,lVarOut.get(0));
			int positionOut = useEqlVarOut0.getOutputs().indexOf(mainSyst.getVariableDeclaration(lVarOut.get(0)));
			String subSystNameVarOut0 = useEqlVarOut0.getSubSystem().getName();
			
			List<AffineFunction> lAlignInOut = mlAlignOut.get(subSystNameVarOut0);
			AffineFunction alignAffFunc = lAlignInOut.get(positionOut);
			
			Domain context = PolyhedralIRUtility.createUniverseDomain(alignAffFunc.getParams(), alignAffFunc.getIndices());
			AffineFunction invAlignAffFunc = alignAffFunc.inverseInContext(context, freshLocalIndices);
			
			for (int k=0; k<invAlignAffFunc.getDimRHS(); k++)
				strMemMapVarGather += ", " + invAlignAffFunc.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			
			strMemMapVarGather += ")";
			
			strRes += "setMemoryMap(prog, system, \"" + nameVarGather + "\", \"" + nameVarGather + "\", \""+ strMemMapVarGather + "\", modfactor);\n"; 
			
			// -- strMemMapVarOut
			String strMemMapVarOut = "(";
			for (int k=0; k<memMapBlock.getIndices().size(); k++)
				if (k==0)
					strMemMapVarOut += memMapBlock.getIndices().get(k).getName();
				else
					strMemMapVarOut += ", " + memMapBlock.getIndices().get(k).getName();
			VariableDeclaration varDeclOut0 = mainSyst.getVariableDeclaration(lVarOut.get(0));
			List<String> freshLocalIndOut = findFreshLocalIndicesMapStr(memMapBlock, varDeclOut0.getDomain().getNIndices()-memMapBlock.getIndices().size());
			for (int k=memMapBlock.getIndices().size(); k<varDeclOut0.getDomain().getNIndices(); k++)
				strMemMapVarOut += ", " + freshLocalIndOut.get(k-memMapBlock.getIndices().size());
			
			strMemMapVarOut += " -> ";
			for (int k=0; k<memMapBlock.getDimRHS(); k++)
				if (k==0)
					strMemMapVarOut += memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					strMemMapVarOut += ", " + memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			for (int k=memMapBlock.getIndices().size(); k<varDeclOut0.getDomain().getNIndices(); k++)
				strMemMapVarOut += ", " + freshLocalIndOut.get(k-memMapBlock.getIndices().size());
			strMemMapVarOut += ")";
			
			for (String strVarOut : lVarOut) {
				strRes += "setMemoryMap(prog, system, \"" + strVarOut + "\", \"" + nameVarGather + "\", \"" + strMemMapVarOut + "\", modfactor);\n"; 
			}
			
			strRes += "\n";
			
			
		}
		
		return strRes;
	}
	
	public static void setTargetMappingParamTilingOutlining(Program tiledProg, List<TileGroupSpecification> pttm, String nameMainSyst,
			Septet<List<List<Map<String,VariableDeclaration>>>,
				Map<String,List<Pair<long[][],VariableDeclaration>>>,
				Map<String,List<Pair<long[][],List<Expression>>>>,
				Map<String,List<AffineFunction>>,
				List<List<String>>,
				Map<String,Pair<FastISLMap,String>>,
				List<List<Pair<String, Boolean>>> > qDataStructSaved) {
		
		// Recovering the information about the tiling transformation
		// => 1st element: llVarDeclSubSyst (Tile group / Kind of tile / mapping old var to corresponding local variable declaration
		// => 2nd element: mStrVarDeclCase (Main syst / correspondance orig var => gather var)
		// => 3rd element: mInternalCaseExpr (Main syst / correspondance gather var => outputs useEq)
		// => 4th element: mlAlignOut (info about post-processing)
		// 5th element: List of subsystem name, classified by tile group
		List<List<Map<String,VariableDeclaration>>> llVarDeclSubSyst = qDataStructSaved.getValue0();
		Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase = qDataStructSaved.getValue1();
		Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr = qDataStructSaved.getValue2();
		Map<String,List<AffineFunction>> mlAlignOut = qDataStructSaved.getValue3();
		List<List<String>> llSubSystName = qDataStructSaved.getValue4();
		Map<String,Pair<FastISLMap,String>> mTempRed = qDataStructSaved.getValue5();
		List<List<Pair<String, Boolean>>> lNAlignmentInfo = qDataStructSaved.getValue6();

		tempRedManagement(pttm, mTempRed, lNAlignmentInfo);
		
		// Mapping gather var => output vars
		Map<String,List<String>> mStrVarGatherVarOutMain = getmappingGatherOutMainVar(mStrVarDeclCase, mInternalCaseExpr);
		
		List<Variable> lParamMainSyst = tiledProg.getSystem(nameMainSyst).getParameters().getParams();
		int nParamBlocked = (lParamMainSyst.size()-1)/2;
		List<Variable> lnParam = lParamMainSyst.subList(0, nParamBlocked);
		blockingParameters(pttm, lnParam);		// For blocked information: \vec{p} => \vec{p_b}
		
		for (TileGroupSpecification tgs : pttm) {
			if (tgs._blockSpaceTimeMapMemAllocUse==null)
				tgs._blockSpaceTimeMapMemAllocUse = tgs._blockSpaceTimeMap.copy();
			if (tgs._blockSpaceTimeMapMemFreeUse==null)
				tgs._blockSpaceTimeMapMemFreeUse = tgs._blockSpaceTimeMap.copy();
		}
		
		/* DEBUG
		System.out.println("mStrVarGatherVarOutMain =");
		for (String strVarGather : mStrVarGatherVarOutMain.keySet()) {
			System.out.println("	* " + strVarGather + " -> " + mStrVarGatherVarOutMain.get(strVarGather).toString());
		}
		//*/
		
		// --- SubSystem generation
		for (int numSubSyst=0; numSubSyst<tiledProg.getSystems().size(); numSubSyst++) {
			AffineSystem subSyst = tiledProg.getSystems().get(numSubSyst);
			
			String nameSubSyst = subSyst.getName();
			if (nameSubSyst.equals(nameMainSyst))		// Not a subsystem but the main system
				continue;
			
			// Recover the tile group of the current Subsystem
			Pair<Integer,Integer> pNumGroupKind = recoverTileGroupKindGroupIndices(nameSubSyst,llSubSystName);
			int numTileGroup = pNumGroupKind.getValue0();
			int numKindTile = pNumGroupKind.getValue1();
			TileGroupSpecification tgs = pttm.get(numTileGroup);
			
			// Get the target mapping of the subsystem
			TargetMapping tmSubSyst = subSyst.getTargetMapping();
			
			
			// Spacetime map for the local variables of the subsystem (not the output)
			int nDimSTMap = -1;
			Map<String,VariableDeclaration> mOrigVarNameVarLoc = llVarDeclSubSyst.get(numTileGroup).get(numKindTile);
			for (String nameOrigVar : mOrigVarNameVarLoc.keySet()) {
				String nameVarLocSubsyst = mOrigVarNameVarLoc.get(nameOrigVar).getName();
				
				String nameOrigVarMinBl = nameOrigVar.substring(0, nameOrigVar.length()- ParametricTiling.suffixBlVar.length());
				AffineFunction locMapping = tgs._mLocalSpaceTimeMap.get(nameOrigVarMinBl);
				
				String nLocMappingStr;
				if (locMapping.getDimRHS()==0) {
					String locMappingStr = locMapping.toString();
					nLocMappingStr = locMappingStr.replace(')','0');
					nLocMappingStr += ")";
				} else {
					String locMappingStr = locMapping.toString();
					nLocMappingStr = locMappingStr.replace(')',',');
					nLocMappingStr += " 0)";
				}
				//substring(0, locMappingStr.indexOf("->"));
				//nLocMappingStr += "-> 0,";
				//nLocMappingStr += locMappingStr.substring(locMappingStr.indexOf("->")+2, locMappingStr.length());
				
				// setSpaceTimeMap(prog, subSystem, \"" + nameVarLocSubsyst + "\", \"" + locMapping.toString() + "\" );\n
				AffineFunction locMappingReparsed = PolyhedralIRUtility.parseAffineFunction(subSyst.getParameters(), nLocMappingStr);
				SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(
						subSyst.getVariableDeclaration(nameVarLocSubsyst), locMappingReparsed);
				
				
				tmSubSyst.getSpaceTimeLevel(0).getSpaceTimeMaps().put(nameVarLocSubsyst, stmap);
				
				if (nDimSTMap==-1)
					nDimSTMap = locMapping.getDimRHS();
			}
			
			// Spacetime map for the output variables of the subsystem
			List<AffineFunction> lRemappingInOutputs = mlAlignOut.get(nameSubSyst);
			for (int i=0; i<lRemappingInOutputs.size(); i++) {
				String nameOutputVar = subSyst.getOutputs().get(i).getName();
				AffineFunction affFuncRemaining = lRemappingInOutputs.get(i);
				
				String naffFuncRemainingStr;
				if (affFuncRemaining.getDimRHS()==0) {
					String locMappingStr = affFuncRemaining.toString();
					naffFuncRemainingStr = locMappingStr.replace(')','1');
					naffFuncRemainingStr += ")";
				} else {
					String locMappingStr = affFuncRemaining.toString();
					naffFuncRemainingStr = locMappingStr.replace(')',',');
					naffFuncRemainingStr += " 1)";
				}
				//String naffFuncRemainingStr = affFuncRemainingStr.substring(0, affFuncRemainingStr.indexOf("->"));
				//naffFuncRemainingStr += "-> 1,";
				//naffFuncRemainingStr += affFuncRemainingStr.substring(affFuncRemainingStr.indexOf("->")+2, affFuncRemainingStr.length());
				
				
				// setSpaceTimeMap(prog, subSystem, \"" + nameOutputVar + "\", \"" +  affFuncRemaining.toString() + "\" );\n
				SpaceTimeMap stmap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(
						subSyst.getVariableDeclaration(nameOutputVar), PolyhedralIRUtility.parseAffineFunction(subSyst.getParameters(),naffFuncRemainingStr));
				tmSubSyst.getSpaceTimeLevel(0).getSpaceTimeMaps().put(nameOutputVar, stmap);
				
				if (nDimSTMap==-1)
					nDimSTMap = affFuncRemaining.getDimRHS();
			}
			
			tmSubSyst.getSpaceTimeLevel(0).getOrderingDimensions().add(nDimSTMap);	// Last dimension is ordering dim
			
			// Statement ordering, so that the copy for the outputs are always after the equations for the local variables
			// setStatementOrdering(prog, subSystem, \"" + strlistLocVar + "\", \"" + strlistOutVar + "\");\n\n
			/*for (String nameOrigVar : mOrigVarNameVarLoc.keySet())
				for (VariableDeclaration varDeclOutSubSyst : subSyst.getOutputs()) {
					VariableDeclaration varDeclLocSubSyst = mOrigVarNameVarLoc.get(nameOrigVar);
					
					StatementPartialOrder partial = TargetMappingUserFactory.createStatementOrder(subSyst.getEquation(varDeclLocSubSyst.getName()),
							subSyst.getEquation(varDeclOutSubSyst.getName()));
					tmSubSyst.getStatementOrderings().add(partial);
				}*/
			
			// Memory Map for the local variable of the subsystem
			for (String nameOrigVar : mOrigVarNameVarLoc.keySet()) {
				VariableDeclaration varDeclLocSubSyst = mOrigVarNameVarLoc.get(nameOrigVar);
				
				String nameOrigVarMinBl = nameOrigVar.substring(0, nameOrigVar.length()- ParametricTiling.suffixBlVar.length());
				Pair<AffineFunction, List<Integer>> pInfoLocMemMapping = tgs._mLocalMemoryMap.get(nameOrigVarMinBl);
				if (pInfoLocMemMapping==null)
					continue;
				
				AffineFunction memMappingFunc = pInfoLocMemMapping.getValue0();
				AffineFunction memMappingFuncReparsed = PolyhedralIRUtility.parseAffineFunction(subSyst.getParameters(), memMappingFunc.toString());
				
				List<IntExpression> modExprs = new BasicEList<IntExpression>();
				for (Integer mod : pInfoLocMemMapping.getValue1()) {
					modExprs.add(IntExpressionBuilder.constant(mod));
				}
				// setMemoryMap(prog, subSystem, \"" + varDeclLocSubSyst.getName() + "\", \"" + varDeclLocSubSyst.getName() + "\", \""
				//						+ memMappingFunc.toString() + "\", \"" + strListModulos + "\");\n
				MemorySpace mspace = tmSubSyst.getMemorySpace(varDeclLocSubSyst.getName());
				tmSubSyst.getMemorySpaces().add(mspace);
				tmSubSyst.getMemoryMaps().put(varDeclLocSubSyst,
						TargetMappingUserFactory.createMemoryMap(varDeclLocSubSyst, memMappingFuncReparsed, modExprs, mspace));
			}

			// DEBUG
			//System.out.println("SubSyst = " + subSyst.getName());
			//targetMappingPrettyPrinter(tmSubSyst);
		}
		
		
		// -------------------------------------------------------------------------------------------------------------------
		
		
		// --- Main System generation ---
		AffineSystem mainSyst = tiledProg.getSystem(nameMainSyst);
		TargetMapping tmMainSyst = mainSyst.getTargetMapping();
		
		// Get the number of local indexes of the common Space-Time Mapping of the main system
		int nIndLocSTMGeneral = 0;
		for (TileGroupSpecification tgs : pttm) {
			int numDimTiled = tgs._blockSpaceTimeMap.getDimRHS();
			nIndLocSTMGeneral = Math.max(nIndLocSTMGeneral, numDimTiled);
		}
		
		// UseEquation management
		for (UseEquation uEq : mainSyst.getUseEquations()) {
			String subSystName = uEq.getSubSystem().getName();
			
			Pair<Integer,Integer> pNumGroupKind = recoverTileGroupKindGroupIndices(subSystName,llSubSystName);
			int numTileGroup = pNumGroupKind.getValue0();
			TileGroupSpecification tgs = pttm.get(numTileGroup);
			
			// Constants
			AffineFunction affFuncBl = tgs._blockSpaceTimeMap;
			AffineFunction affFuncBlReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBl.toString());
			String affFuncBlock = affFuncBlReparsed.toString();
			affFuncBlock = affFuncBlock.replace(')', ',');
			
			AffineFunction affFuncBlAlloc = tgs._blockSpaceTimeMapMemAllocUse;
			AffineFunction affFuncBlAllocReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBlAlloc.toString());
			String affFuncBlockAlloc = affFuncBlAllocReparsed.toString();
			affFuncBlockAlloc = affFuncBlockAlloc.replace(')', ',');
			
			AffineFunction affFuncBlFree = tgs._blockSpaceTimeMapMemFreeUse;
			AffineFunction affFuncBlFreeReparsed = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), affFuncBlFree.toString());
			String affFuncBlockFree = affFuncBlFreeReparsed.toString();
			affFuncBlockFree = affFuncBlockFree.replace(')', ',');
			
			String strZeroLoc = "";
			for (int i=0; i<nIndLocSTMGeneral; i++) {
				if (!strZeroLoc.isEmpty())
					strZeroLoc += ",";
				strZeroLoc += "0";
			}
			String memAllocStr = affFuncBlockAlloc + "0," + strZeroLoc + ")";
			String inputCopyStr = affFuncBlock + "1," + strZeroLoc + ")";
			String subSystCallStr = affFuncBlock + "2," + strZeroLoc + ")";
			String outputCopyStr = affFuncBlock + "3," + strZeroLoc + ")";
			String memFreeStr = affFuncBlockFree + "4," + strZeroLoc + ")";
			
			AffineFunction memAllocFunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), memAllocStr);
			AffineFunction inputCopyFunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), inputCopyStr);
			AffineFunction subSystCallFunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), subSystCallStr);
			AffineFunction outputCopyFunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), outputCopyStr);
			AffineFunction memFreeFunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), memFreeStr);
			
			// Space-time mapping for the useEquation
			// setSpaceTimeMap(prog, system, label, sub_sys_call);\n
			SpaceTimeMap stmap = TargetMappingUserFactory.createUseEquationSpaceTimeMap(uEq.getLabel(), subSystCallFunc.copy(), uEq);
			tmMainSyst.getSpaceTimeLevel(0).getSpaceTimeMaps().put(uEq.getLabel(), stmap);
			
			// Determining if we trigger the optimization or not for each input of the subsystem
			List<Boolean> lOptimTriggeredInput = new BasicEList<Boolean>();
			for (int i=0; i<uEq.getInputs().size(); i++) {
				
				// BY DEFAULT DEBUG
				if (boolOptimAlwaysTriggered_DEBUG)
					lOptimTriggeredInput.add(true);
				else {
					Expression inExpr = uEq.getInputs().get(i);
					AffineFunction depInExpr = PolyhedralIRUtility.createIdentityFunction(inExpr.getExpressionDomain());
					while (inExpr instanceof DependenceExpression) {
						depInExpr = ((DependenceExpression) inExpr).getDep().compose(depInExpr);
						inExpr = ((DependenceExpression) inExpr).getExpr();
					}
					
					if (!(inExpr instanceof VariableExpression))
						throw new RuntimeException("Expression inExpr = " + inExpr.toString() + " is not a variableExpression");
					VariableDeclaration varDeclInExpr = ((VariableExpression) inExpr).getVarDecl();
					
					// We determine if we want to optimize the memory access here or not...
					//	Note: varDeclInExpr can be either an input, or a gather variable
					AffineFunction memMapBl;
					if (mainSyst.isInput(varDeclInExpr)){
						memMapBl = PolyhedralIRUtility.createIdentityFunction(varDeclInExpr.getDomain());	// Input: Id memory allocation
					} else {
						String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, varDeclInExpr.getName());
						String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
						
						int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
						TileGroupSpecification tgsVarOrig = pttm.get(tileGroupNum);
						memMapBl = tgsVarOrig._mBlockMemoryMap.get(nameVarOrigMinBl).getValue0();
						
					}
					
					boolean optimTriggered = optimInputUseEquation(varDeclInExpr, depInExpr, memMapBl, uEq, i);
					
					lOptimTriggeredInput.add(optimTriggered);
				}
			}
			
			
			
			for (int i=0; i<uEq.getInputs().size(); i++) {
				if (tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true)==null) {
					String spaceName = uEq.getLabel() + "_" + "input" + "_" + i;//SubSystemCodeGenUtilityForC.getUseEquationVariableName(uEq, true, i);
					UseEquationOptimization uEqOptim = TargetMappingUserFactory.createUseEquationOptimization(
							uEq.getLabel(), i, true, null, spaceName, memAllocFunc.copy(), inputCopyFunc.copy(), memFreeFunc.copy());
					tmMainSyst.getUseEquationOptimizations().add(uEqOptim);
				} else {
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true).setMemoryAllocationSpaceTimeMap(memAllocFunc.copy());
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true).setValueCopySpaceTimeMap(inputCopyFunc.copy());
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true).setMemoryFreeSpaceTimeMap(memFreeFunc.copy());
				}
			}
			for (int i=0; i<uEq.getOutputs().size(); i++) {
				// setSpaceTimeMapForUseEquationOptimization(prog, system, label, 1, " + i + ", mem_alloc, output_copy, mem_free);\n
				if (tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false)==null) {
					String spaceName = uEq.getLabel() + "_" + "output" + "_" + i;//SubSystemCodeGenUtilityForC.getUseEquationVariableName(uEq, true, i);
					UseEquationOptimization uEqOptim = TargetMappingUserFactory.createUseEquationOptimization(
							uEq.getLabel(), i, false, null, spaceName, memAllocFunc.copy(), outputCopyFunc.copy(), memFreeFunc.copy());
					tmMainSyst.getUseEquationOptimizations().add(uEqOptim);
				} else {
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false).setMemoryAllocationSpaceTimeMap(memAllocFunc.copy());
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false).setValueCopySpaceTimeMap(outputCopyFunc.copy());
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false).setMemoryFreeSpaceTimeMap(memFreeFunc.copy());
				}
			}
			
			// Memory mapping for the useEquation
			for (int i=0; i<uEq.getInputs().size(); i++) {
				boolean optimTriggered = lOptimTriggeredInput.get(i);
				
				Expression inExpr = uEq.getInputs().get(i);
				while (inExpr instanceof DependenceExpression) {
					inExpr = ((DependenceExpression) inExpr).getExpr();
				}
				
				if (!(inExpr instanceof VariableExpression))
					throw new RuntimeException("Expression inExpr = " + inExpr.toString() + " is not a variableExpression");
				VariableDeclaration varDeclInExpr = ((VariableExpression) inExpr).getVarDecl();
				String memspaceName = varDeclInExpr.getName();
				
				// Note: this line only if optimization
				if (optimTriggered) {
					// setMemorySpaceForUseEquationOptimization(prog, system, label, 0, " + i + ", \"" + memspaceName + "\");\n
					if(tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true) == null){
						UseEquationOptimization uEqOptim = TargetMappingUserFactory.createUseEquationOptimization(
								uEq.getLabel(), i, true, null, memspaceName, null, null, null);
						tmMainSyst.getUseEquationOptimizations().add(uEqOptim);
					}else{
						tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true).setMemorySpaceNameforTemporaryVariable(memspaceName);
					}
				} else {
//					String nMemspaceName = uEq.getLabel() + "_In" + i;
					
					// setMemorySpaceForUseEquationOptimization(prog, system, label, 0, " + i + ", \"" + memspaceName + "\");\n
//					if(tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true) == null){
//						UseEquationOptimization uEqOptim = TargetMappingUserFactory.createUseEquationOptimization(
//								uEq.getLabel(), i, true, null, memspaceName, null, null, null);
//						tmMainSyst.getUseEquationOptimizations().add(uEqOptim);
//					}else{
//						tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, true).setMemorySpaceNameforTemporaryVariable(nMemspaceName);
//					}
					
				}
			}
			for (int i=0; i<uEq.getOutputs().size(); i++) {
				VariableDeclaration varDeclOut = uEq.getOutputs().get(i);
				String memspaceName = getCorrespondingGatherVariableName(varDeclOut, mStrVarGatherVarOutMain);
				
				// setMemorySpaceForUseEquationOptimization(prog, system, label, 1, " + i + ", \"" + memspaceName + "\");\n
				if(tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false) == null){
					UseEquationOptimization uEqOptim = TargetMappingUserFactory.createUseEquationOptimization(
							uEq.getLabel(), i, false, null, memspaceName, null, null, null);
					tmMainSyst.getUseEquationOptimizations().add(uEqOptim);
				}else{
					tmMainSyst.getUseEquationOptimization(uEq.getLabel(), i, false).setMemorySpaceNameforTemporaryVariable(memspaceName);
				}
			}
		}
		
		// Target mapping for the output equations
		for (int i=0; i<mainSyst.getOutputs().size(); i++) {
			VariableDeclaration outvarDecl = mainSyst.getOutputs().get(i);
			String outvarName = outvarDecl.getName();
			
			// Getting the tile group for outvarName
			String outvarNameMinusBl = outvarName.substring(0, outvarName.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, outvarNameMinusBl);
			
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			AffineFunction blockSpaceTimeMap = tgs._blockSpaceTimeMap;
			List<String> lIndLocMapStr = findFreshLocalIndicesMapStr(blockSpaceTimeMap, blockSpaceTimeMap.getNIndices());
			
			String mapStr = "(";
			for (int k=0; k<blockSpaceTimeMap.getNIndices(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getIndices().get(k).getName();
				else
					mapStr += ", " + blockSpaceTimeMap.getIndices().get(k).getName();
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			mapStr += " -> ";
			for (int k=0; k<blockSpaceTimeMap.getDimRHS(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					mapStr += ", " + blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			if (blockSpaceTimeMap.getDimRHS()==0)
				mapStr += "6";
			else
				mapStr += ", 6";
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			if (lIndLocMapStr.size()==0)
				mapStr += ",";
			
			for (int k=lIndLocMapStr.size(); k<nIndLocSTMGeneral; k++)
				if (k==0)
					mapStr += " 0";
				else
					mapStr += ", 0";
			mapStr += ")";
			
			AffineFunction stMapfunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), mapStr);
			
			// setSpaceTimeMap(prog, system, \"" + outvarName + "\", \"" + mapStr + "\");\n
			tmMainSyst.getSpaceTimeLevel(0).getSpaceTimeMaps().put(
					outvarName, TargetMappingUserFactory.createStandardEquationSpaceTimeMap(outvarDecl, stMapfunc));
		}
		
		// Target mapping for the gathering equations
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {

			// Getting the tile group for outvarName
			String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, nameVarGather);
			String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
			
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			AffineFunction blockSpaceTimeMap = tgs._blockSpaceTimeMap;
			List<String> lIndLocMapStr = findFreshLocalIndicesMapStr(blockSpaceTimeMap, blockSpaceTimeMap.getNIndices());
			
			String mapStr = "(";
			for (int k=0; k<blockSpaceTimeMap.getNIndices(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getIndices().get(k).getName();
				else
					mapStr += ", " + blockSpaceTimeMap.getIndices().get(k).getName();
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			
			mapStr += " -> ";
			
			for (int k=0; k<blockSpaceTimeMap.getDimRHS(); k++)
				if (k==0)
					mapStr += blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					mapStr += ", " + blockSpaceTimeMap.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			if (blockSpaceTimeMap.getDimRHS()==0)
				mapStr += "5";
			else
				mapStr += ", 5";
			for (int k=0; k<lIndLocMapStr.size(); k++)
				mapStr += ", " + lIndLocMapStr.get(k);
			if (lIndLocMapStr.size()==0)
				mapStr += ",";
			
			for (int k=lIndLocMapStr.size(); k<nIndLocSTMGeneral; k++)
				if (k==0)
					mapStr += " 0";
				else
					mapStr += ", 0";
			mapStr += ")";
			
			AffineFunction stMapfunc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), mapStr);
			
			// setSpaceTimeMap(prog, system, \"" + nameVarGather + "\", \"" + mapStr+ "\");\n
			tmMainSyst.getSpaceTimeLevel(0).getSpaceTimeMaps().put(
					nameVarGather, TargetMappingUserFactory.createStandardEquationSpaceTimeMap(
							mainSyst.getVariableDeclaration(nameVarGather), stMapfunc));
		}
		
		// Memory mapping
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {
			List<String> lVarOutUse = mStrVarGatherVarOutMain.get(nameVarGather);
			
			// setMemorySpace(prog, system, \"" + nameVarGather + "\", \"" + strListVarOut + "\");\n
			MemorySpace mspace = tmMainSyst.getMemorySpace(nameVarGather);
			for (String nameVarOutUse : lVarOutUse) {
				VariableDeclaration varDeclOutUse = mainSyst.getVariableDeclaration(nameVarOutUse);
				if (tmMainSyst.getMemoryMaps().get(varDeclOutUse) != null) {
					tmMainSyst.getMemoryMaps().get(varDeclOutUse).setSpace(mspace);
				} else {
					tmMainSyst.getMemoryMaps().put(varDeclOutUse, TargetMappingUserFactory.createIdentityMemoryMap(varDeclOutUse, mspace));
				}
			}
		}
		
		/* The memory mapping of the output might not correspond to the contracted memory mapping of the gathering var
		for (VariableDeclaration outVarDecl : mainSyst.getOutputs()) {
			StandardEquation stEq = mainSyst.getEquation(outVarDecl.getName());
			Expression expr = stEq.getExpression();
			if (expr instanceof DependenceExpression)
				expr = ((DependenceExpression) expr).getExpr();
			String nameVarGather = ((VariableExpression) expr).getVarDecl().getName();
			
			// setMemorySpace(prog, system, \"" + nameVarGather + "\", \"" + outVarDecl.getName() + "\");\n
			MemorySpace mspace = tmMainSyst.getMemorySpace(nameVarGather);
			if (tmMainSyst.getMemoryMaps().get(outVarDecl) != null) {
				tmMainSyst.getMemoryMaps().get(outVarDecl).setSpace(mspace);
			} else {
				tmMainSyst.getMemoryMaps().put(outVarDecl, TargetMappingUserFactory.createIdentityMemoryMap(outVarDecl, mspace));
			}
		}
		*/
		
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {
			List<String> lVarOut = mStrVarGatherVarOutMain.get(nameVarGather);
			
			// Getting the tile group for outvarName
			String nameVarOrig = searchOriginalVariableName(mStrVarDeclCase, nameVarGather);
			String nameVarOrigMinBl = nameVarOrig.substring(0, nameVarOrig.length()-ParametricTiling.suffixBlVar.length());
			int tileGroupNum = getTileGroupFromPttm(pttm, nameVarOrigMinBl);
			
			// Getting the map with the specifications
			TileGroupSpecification tgs = pttm.get(tileGroupNum);
			Map<String, Pair<AffineFunction, List<Integer>>> mBlockMemMap = tgs._mBlockMemoryMap;
			
			// Getting the name of the original variable
			Pair<AffineFunction, List<Integer>> pMemMapModFactor = mBlockMemMap.get(nameVarOrigMinBl);
			if (pMemMapModFactor==null) {
				// Not specified => take Id with [0...0] as modFactors
				VariableDeclaration varDeclGather = mainSyst.getVariableDeclaration(nameVarGather);
				
				UseEquation uEqVarOut0 = getUseEquationContainingOutput(mainSyst, lVarOut.get(0));
				int nDimBl = uEqVarOut0.getExtensionDomain().getNIndices();  // Number of blocked dimension in the variable varDeclGather
				
				List<Variable> lIndMapping = varDeclGather.getDomain().getIndices().subList(0, nDimBl);
				AffineFunction mapping = PolyhedralIRUtility.createIdentityFunction(varDeclGather.getDomain().getParams(), lIndMapping);
				
				List<Integer> modFactors = new BasicEList<Integer>();
				for (int k=0; k<mapping.getNIndices(); k++)
					modFactors.add(0);
				pMemMapModFactor = Pair.with(mapping,modFactors);
			}
			
			List<IntExpression> modExprs = new BasicEList<IntExpression>();
			for (Integer mod : pMemMapModFactor.getValue1()) {
				modExprs.add(IntExpressionBuilder.constant(mod));
			}
			for (int k=0; k<mainSyst.getVariableDeclaration(lVarOut.get(0)).getDomain().getNIndices()-pMemMapModFactor.getValue0().getIndices().size(); k++)
				modExprs.add(IntExpressionBuilder.constant(0));				// Add the local indices
			
			AffineFunction memMapBlock = pMemMapModFactor.getValue0();
			
			// -- strMemMapVarGather
			String strMemMapVarGather = "(";
			for (int k=0; k<memMapBlock.getIndices().size(); k++)
				if (k==0)
					strMemMapVarGather += memMapBlock.getIndices().get(k).getName();
				else
					strMemMapVarGather += ", " + memMapBlock.getIndices().get(k).getName();
			VariableDeclaration varDeclGather = mainSyst.getVariableDeclaration(nameVarGather);
			EList<String> freshLocalIndices = findFreshLocalIndicesMapStr(memMapBlock, varDeclGather.getDomain().getNIndices()-memMapBlock.getIndices().size());
			for (int k=memMapBlock.getIndices().size(); k<varDeclGather.getDomain().getNIndices(); k++)
				strMemMapVarGather += ", " + freshLocalIndices.get(k-memMapBlock.getIndices().size());
			
			strMemMapVarGather += " -> ";
			for (int k=0; k<memMapBlock.getDimRHS(); k++)
				if (k==0)
					strMemMapVarGather += memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					strMemMapVarGather += ", " + memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			
			UseEquation useEqlVarOut0 = getUseEquationContainingOutput(mainSyst,lVarOut.get(0));
			int positionOut = useEqlVarOut0.getOutputs().indexOf(mainSyst.getVariableDeclaration(lVarOut.get(0)));
			String subSystNameVarOut0 = useEqlVarOut0.getSubSystem().getName();
			
			List<AffineFunction> lAlignInOut = mlAlignOut.get(subSystNameVarOut0);
			AffineFunction alignAffFunc = lAlignInOut.get(positionOut);
			
			Domain context = PolyhedralIRUtility.createUniverseDomain(alignAffFunc.getParams(), alignAffFunc.getIndices());
			AffineFunction invAlignAffFunc = alignAffFunc.inverseInContext(context, freshLocalIndices);
			
			for (int k=0; k<invAlignAffFunc.getDimRHS(); k++)
				strMemMapVarGather += ", " + invAlignAffFunc.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			
			strMemMapVarGather += ")";
			AffineFunction funcMemMapVarGather = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), strMemMapVarGather);
			
			// -- strMemMapVarOut
			String strMemMapVarOut = "(";
			for (int k=0; k<memMapBlock.getIndices().size(); k++)
				if (k==0)
					strMemMapVarOut += memMapBlock.getIndices().get(k).getName();
				else
					strMemMapVarOut += ", " + memMapBlock.getIndices().get(k).getName();
			VariableDeclaration varDeclOut0 = mainSyst.getVariableDeclaration(lVarOut.get(0));
			List<String> freshLocalIndOut = findFreshLocalIndicesMapStr(memMapBlock, varDeclOut0.getDomain().getNIndices()-memMapBlock.getIndices().size());
			for (int k=memMapBlock.getIndices().size(); k<varDeclOut0.getDomain().getNIndices(); k++)
				strMemMapVarOut += ", " + freshLocalIndOut.get(k-memMapBlock.getIndices().size());
			
			strMemMapVarOut += " -> ";
			for (int k=0; k<memMapBlock.getDimRHS(); k++)
				if (k==0)
					strMemMapVarOut += memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
				else
					strMemMapVarOut += ", " + memMapBlock.getExpressions().get(k).toString(OUTPUT_FORMAT.ALPHABETS);
			for (int k=memMapBlock.getIndices().size(); k<varDeclOut0.getDomain().getNIndices(); k++)
				strMemMapVarOut += ", " + freshLocalIndOut.get(k-memMapBlock.getIndices().size());
			strMemMapVarOut += ")";
			AffineFunction funcMemMapVarOut = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(), strMemMapVarOut);
			
			// setMemoryMap(prog, system, \"" + nameVarGather + "\", \"" + nameVarGather + "\", \""+ strMemMapVarGather + "\", modfactor);\n
			MemorySpace mspace = tmMainSyst.getMemorySpace(nameVarGather);
			tmMainSyst.getMemorySpaces().add(mspace);
			tmMainSyst.getMemoryMaps().put(varDeclGather,
					TargetMappingUserFactory.createMemoryMap(varDeclGather, funcMemMapVarGather.copy(), modExprs, mspace));
			
			for (String strVarOut : lVarOut) {
				// setMemoryMap(prog, system, \"" + strVarOut + "\", \"" + nameVarGather + "\", \"" + strMemMapVarOut + "\", modfactor);\n
				VariableDeclaration varDeclOut = mainSyst.getVariableDeclaration(strVarOut);
				List<IntExpression> lModExprsCopy = new BasicEList<IntExpression>();
				for (IntExpression iExpr : modExprs)
					lModExprsCopy.add(iExpr.copy());
				tmMainSyst.getMemoryMaps().put(varDeclOut,
						TargetMappingUserFactory.createMemoryMap(varDeclOut, funcMemMapVarOut.copy(), lModExprsCopy, mspace));
			}
		}
		
		
		/* Memory mapping for the output variables of useEquation
		//		=> use mapping of the corresponding gather variable, composed with the inverse of the mlAlignOut
		for (UseEquation uEq : mainSyst.getUseEquations()) {
			for (int i=0; i<uEq.getOutputs().size(); i++) {
				VariableDeclaration varDeclOutUseEq = uEq.getOutputs().get(i);
				
				// Getting the memory mapping of the gather variable
				boolean found = false;
				String nameVarGather = null;
				for (String strVarGather : mStrVarGatherVarOutMain.keySet()) {
					List<String> lStrVarOut = mStrVarGatherVarOutMain.get(strVarGather);
					if (lStrVarOut.contains(varDeclOutUseEq.getName())) {
						nameVarGather = strVarGather;
						found = true;
						break;
					}
				}
				if (!found)
					throw new RuntimeException("Variable " + varDeclOutUseEq.getName() + " (output of a useEquation) "
							+ "does not have a corresponding gather variable");
				MemoryMap memMappingGather = tmMainSyst.getMemoryMaps().get(mainSyst.getVariableDeclaration(nameVarGather));
				
				// Getting the Cob of normalization
				List<AffineFunction> lAlignOut = mlAlignOut.get(uEq.getSubSystem().getName());
				AffineFunction alignOut = lAlignOut.get(i);
				
				//AffineFunction alignOutInv = alignOut.inverse();
				JNIISLBasicMap bMapAlignOut;
				if (alignOut instanceof FastISLMap)
					bMapAlignOut = ((FastISLMap) alignOut).getIslMap().copy();
				else
					bMapAlignOut = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(alignOut.getPMmapping()).getIslMap();
				JNIISLMap mapAlignOut = bMapAlignOut.toMap();
				int nBlock = memMappingGather.getMapping().getNIndices() - mapAlignOut.getNbDims(JNIISLDimType.isl_dim_out);
				
				mapAlignOut = mapAlignOut.insertDims(JNIISLDimType.isl_dim_in, 0, nBlock);
				mapAlignOut = mapAlignOut.insertDims(JNIISLDimType.isl_dim_out, 0, nBlock);
				for (int k=0; k<nBlock; k++) {
					JNIISLConstraint constr = JNIISLConstraint.buildEquality(mapAlignOut.getSpace());
					constr = constr.setCoefficient(JNIISLDimType.isl_dim_in, k, -1);
					constr = constr.setCoefficient(JNIISLDimType.isl_dim_out, k, 1);
					
					mapAlignOut = mapAlignOut.addConstraint(constr);
				}
				
				// DEBUG
				//System.out.println("varDeclOutUseEq = " + varDeclOutUseEq);
				//System.out.println("uEq = " + PolyhedralIRToAlphabets.toString(uEq));
				//System.out.println("alignOut = " + alignOut.toString());
				//System.out.println("nBlock = " + nBlock);
				//System.out.println("mapAlignOut = " + mapAlignOut.toString());
				//System.out.println("memMappingGather.getMapping() = " + memMappingGather.getMapping().toString());
				
				FastISLMap alignOutWithBlockedDim = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(mapAlignOut.getBasicMapAt(0));
				AffineFunction affMapping = memMappingGather.getMapping().compose(alignOutWithBlockedDim);
				
				// DEBUG
				//System.out.println("	=> affMapping = " + affMapping);
				//System.out.println();
				
				List<IntExpression> lModFactorCopy = new BasicEList<IntExpression>();
				for (IntExpression modFact : memMappingGather.getModFactors())
					lModFactorCopy.add(modFact.copy());
				
				tmMainSyst.getMemoryMaps().put(varDeclOutUseEq,
						TargetMappingUserFactory.createMemoryMap(varDeclOutUseEq, affMapping, lModFactorCopy, memMappingGather.getSpace()));
			}
		}
		//*/
		
		// DEBUG
		//System.out.println("MAIN SYST:");
		//targetMappingPrettyPrinter(tmMainSyst);
		
		return;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------
	// Auxilliary functions	
	
	/**
	 * Transform the parameters of the elements of pttm corresponding to the information about tiles (i.e., block STMap + Mem map)
	 * 	More precisely, the parameter transformation is replacing "N" by "Nb"
	 * 
	 * @param pttm
	 * @param nlParam
	 */
	private static void blockingParameters(List<TileGroupSpecification> pttm, List<Variable> nlParam) {
		for (TileGroupSpecification tgs : pttm) {
			AffineFunction blockSTMap = tgs._blockSpaceTimeMap.copy();
			AffineFunction blockSTMapRenamedParam = renameParameters(blockSTMap, nlParam);
			tgs._blockSpaceTimeMap = blockSTMapRenamedParam;
			
			AffineFunction blockSTMapMemAlloc = tgs._blockSpaceTimeMapMemAllocUse.copy();
			AffineFunction blockSTMapMemAllocRenamedParam = renameParameters(blockSTMapMemAlloc, nlParam);
			tgs._blockSpaceTimeMapMemAllocUse = blockSTMapMemAllocRenamedParam;
			
			AffineFunction blockSTMapFree = tgs._blockSpaceTimeMapMemFreeUse.copy();
			AffineFunction blockSTMapFreeRenamedParam = renameParameters(blockSTMapFree, nlParam);
			tgs._blockSpaceTimeMapMemFreeUse = blockSTMapFreeRenamedParam;
			
			Map<String, Pair<AffineFunction, List<Integer>>> mBlockMemoryMap = tgs._mBlockMemoryMap;
			Map<String, Pair<AffineFunction, List<Integer>>> nmBlockMemoryMap = new HashMap<String, Pair<AffineFunction,List<Integer>>>();
			for (String strKey : mBlockMemoryMap.keySet()) {
				Pair<AffineFunction, List<Integer>> pAffFuncLInts = mBlockMemoryMap.get(strKey);
				List<Integer> lInts = pAffFuncLInts.getValue1();
				
				AffineFunction affFunc = pAffFuncLInts.getValue0();
				AffineFunction nAffFunc = renameParameters(affFunc,nlParam);
				
				nmBlockMemoryMap.put(strKey, Pair.with(nAffFunc,lInts));
			}
		}
	}
	
	/**
	 * Rename the parameter of an AffineFunction into nlParam
	 * 
	 * @param affFunc
	 * @param nlParam
	 * @return
	 */
	private static AffineFunction renameParameters(AffineFunction affFunc, List<Variable> nlParam) {
		Matrix mat = affFunc.getPMmapping().toMatrix();
		EList<Variable> enlParam = new BasicEList<Variable>();
		enlParam.addAll(nlParam);
		List<IntExpression> lIntExpr = mat.toFunction(enlParam, affFunc.getIndices());
		
		List<AffineExpression> lAffExpr = new BasicEList<AffineExpression>();
		for (IntExpression intExpr : lIntExpr)
			lAffExpr.add(IntExpressionBuilder.affine(intExpr));
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(nlParam, affFunc.getIndices(), lAffExpr);
		
	}
	
	
	/**
	 * Recover the index of the tile group and the index of the kind of tile inside this tile group, of a given subsystem
	 * 
	 * @param nameSubSyst
	 * @param llSubSystName
	 * @return
	 */
	private static Pair<Integer,Integer> recoverTileGroupKindGroupIndices(String nameSubSyst, List<List<String>> llSubSystName) {
		// Recover the tile group of the current Subsystem
		int numTileGroup = -1;
		int numKindTile = -1;
		for (int k=0; k<llSubSystName.size(); k++) {
			List<String> lSubSystName = llSubSystName.get(k);
			boolean contain = false;
			for (int l=0; l<lSubSystName.size(); l++) {
				String subSystNameList = lSubSystName.get(l);
				if (subSystNameList.equals(nameSubSyst)) {
					contain = true;
					numKindTile = l;
					break;
				}
			}
			if (contain) {
				numTileGroup = k;
				break;
			}
		}
		if (numTileGroup==-1)
			throw new RuntimeException("SubSystem " + nameSubSyst + " was not found inside llSubSystName");
		
		return Pair.with(numTileGroup, numKindTile);
	}
	
	
	/**
	 * Build the map which associate each gather variable to their corresponding output-of-useEq variables
	 * 
	 * @param mStrVarDeclCase
	 * @param mInternalCaseExpr
	 * @return
	 */
	private static Map<String,List<String>> getmappingGatherOutMainVar(Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase ,
			Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr) {
		Map<String,List<String>> retMap = new HashMap<String, List<String>>();
		
		for (String partitionedVarName : mInternalCaseExpr.keySet()) {			// Original partitioned name
			List<Pair<long[][],List<Expression>>> lpMatLExpr = mInternalCaseExpr.get(partitionedVarName);
			List<Pair<long[][],VariableDeclaration>> lGatherVar = mStrVarDeclCase.get(partitionedVarName);
			
			for (Pair<long[][],List<Expression>> pMatLExpr : lpMatLExpr) {
				List<String> lnameOutVar = new BasicEList<String>();
				long[][] matOutput = pMatLExpr.getValue0();
				String gatherVarName = findInLGatherVar(lGatherVar,matOutput);
				
				List<Expression> lExpr = pMatLExpr.getValue1();
				
				for (Expression expr : lExpr) {
					RestrictExpression restExpr = (RestrictExpression) expr;
					Expression subRestExpr = restExpr.getExpr();
					
					while (subRestExpr instanceof DependenceExpression)
						subRestExpr = ((DependenceExpression) subRestExpr).getExpr();
					
					VariableExpression varExpr = (VariableExpression) subRestExpr;
					
					lnameOutVar.add(varExpr.getVarDecl().getName());
				}
				retMap.put(gatherVarName, lnameOutVar);
			}
		}
		
		return retMap;
	}
	
	/**
	 * Given an output variable, retrieve the corresponding gather variable
	 * @param varDeclOut
	 * @param mStrVarGatherVarOutMain
	 * @return
	 */
	private static String getCorrespondingGatherVariableName(VariableDeclaration varDeclOut, Map<String,List<String>> mStrVarGatherVarOutMain) {
		for (String nameVarGather : mStrVarGatherVarOutMain.keySet()) {
			List<String> lNameVarOut = mStrVarGatherVarOutMain.get(nameVarGather);
			
			boolean found = false;
			for (String nameVarOut : lNameVarOut) {
				if (nameVarOut.equals(varDeclOut.getName())) {
					found = true;
					break;
				}
			}
			if (found)
				return nameVarGather;
		}
		throw new RuntimeException("varDeclOut name was not found in mStrVarGatherVarOutMain");
	}
	
	
	/**
	 * Search function insider lGatherVar, matOutput being the key
	 * 
	 * @param lGatherVar
	 * @param matOutput
	 * @return
	 */
	private static String findInLGatherVar(List<Pair<long[][],VariableDeclaration>> lGatherVar, long[][] matOutput) {
		boolean found = false;
		String retStr = "";
		
		for (Pair<long[][],VariableDeclaration> pMatVar : lGatherVar) {
			if (MatrixOperations.isEqual(pMatVar.getValue0(), matOutput)) {
				found = true;
				retStr = pMatVar.getValue1().getName();
				break;
			}
		}
		if (!found)
			throw new RuntimeException("lGatherVar : variable corresponding to the matrix matOutput not found");
		return retStr;
	}
	
	/**
	 * Get the index of the tile group of a variable
	 * 
	 * @param pttm
	 * @param outvarName
	 * @return
	 */
	private static int getTileGroupFromPttm(List<TileGroupSpecification> pttm, String outvarName) {
		for (int k=0; k<pttm.size(); k++) {
			TileGroupSpecification tgs = pttm.get(k);
			if (tgs._mCobPreprocessing.containsKey(outvarName))
				return k;
		}
		throw new RuntimeException("Variable " + outvarName + " is not in a tile group of pttm");
	}
	
	/**
	 * Produce a number of fresh indices names, which does not interfere with the indices names of the provided affineFunction
	 * @param blockSpaceTimeMap
	 * @param nFreshVar
	 * @return
	 */
	private static EList<String> findFreshLocalIndicesMapStr(AffineFunction blockSpaceTimeMap, int nFreshVar) {
		EList<String> lStrRet = new BasicEList<String>();
		
		List<String> lVarNameCurrentFunc = blockSpaceTimeMap.getIndexNames();
		lVarNameCurrentFunc.addAll(blockSpaceTimeMap.getParamNames());
		
		for (int k=0; k<nFreshVar; k++) {
			String nameVar = "x_" + k;
			
			while (lVarNameCurrentFunc.contains(nameVar)) {
				nameVar += "l";
			}
			lStrRet.add(nameVar);
		}
		return lStrRet;
	}
	
	/**
	 * Given a name of a gather variable, retrieve the name of the original variable (during the partitioning)
	 * 
	 * @param mStrVarDeclCase
	 * @param nameVarGather
	 * @return
	 */
	private static String searchOriginalVariableName(Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase, String nameVarGather) {
		for (String strOrigVarName : mStrVarDeclCase.keySet()) {
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : mStrVarDeclCase.get(strOrigVarName)) {
				if (pMatVarDecl.getValue1().getName().equals(nameVarGather))
					return strOrigVarName;
			}
		}
		
		throw new RuntimeException("Gather variable " + nameVarGather + " not found in mStrVarDeclCase");
	}
	
	/**
	 * Search function: given the name of an output variable of a useEquation, retrieve the useEquation
	 * @param mainSyst
	 * @param nameOutUseEquation
	 * @return
	 */
	private static UseEquation getUseEquationContainingOutput(AffineSystem mainSyst, String nameOutUseEquation) {
		for (UseEquation uEq : mainSyst.getUseEquations()) {
			for (VariableDeclaration varDeclOutUseEq : uEq.getOutputs())
				if (varDeclOutUseEq.getName().equals(nameOutUseEquation))
					return uEq;
		}
		throw new RuntimeException("The variable " + nameOutUseEquation + " is not an output of a useEquation in the system " + mainSyst.getName());
	}
	
	/* ---------------------------------------------------------------------------- */
	
	/**
	 * Pretty-printer for the target mapping
	 * @param tm
	 */
	public static void targetMappingPrettyPrinter(TargetMapping tm) {
		System.out.println("[[[[");
		
		// Memory infos
		System.out.println("MemoryInfos:");
		System.out.println("	- memorySpaces:");
		for (MemorySpace mSpace : tm.getMemorySpaces())
			System.out.println("		* " + mSpace.getName() + " (type: " + mSpace.getType() + "/ zeroAlign : "
					+ mSpace.isZeroAligned() + " )"); // - domain = " + mSpace.getDomain());
		System.out.println("	- memoryMaps:");
		for (VariableDeclaration varDecl : tm.getMemoryMaps().keySet()) {
			MemoryMap mMap = tm.getMemoryMaps().get(varDecl);
			if (mMap==null)
				System.out.println("		* NULL");
			else
				System.out.println("		* " + varDecl.getName() + " ==> " + mMap.getVariable().getName() + " : "
					+ mMap.getMapping().toString() + " mod " + mMap.getModFactors().toString() + "  IN " + mMap.getSpace().getName());
		}
		
		// Spacetime mappings
		System.out.println("Space-Time Infos:");				// FIXME: We assume that there is only one level
		SpaceTimeLevel stLevel = tm.getSpaceTimeLevels().get(0);
		for (String varName : stLevel.getSpaceTimeMaps().keySet()) {
			SpaceTimeMap stMap = stLevel.getSpaceTimeMaps().get(varName);
			System.out.println("	* " + varName + " -> " + stMap.getMapping());
		}
		// FIXME: we ignore here the ordering dims/tiling/vectorialization/unrolling/parallelisation specifications for now
		
		
		// Statement partial ordering
		System.out.println("Statement Partial Ordering Infos:");
		for (StatementPartialOrder spo : tm.getStatementOrderings()) {
			Equation eqPred = spo.getPredecessor();
			String labelEqPred;
			if (eqPred instanceof StandardEquation)
				labelEqPred = ((StandardEquation) eqPred).getVariable().getName();
			else
				labelEqPred = ((UseEquation) eqPred).getLabel();
			
			Equation eqSucc = spo.getSuccessor();
			String labelEqSucc;
			if (eqSucc instanceof StandardEquation)
				labelEqSucc = ((StandardEquation) eqSucc).getVariable().getName();
			else
				labelEqSucc = ((UseEquation) eqSucc).getLabel();
			System.out.println("	* " + labelEqPred + " BEFORE " + labelEqSucc);
		}
		
		System.out.println("UseEquation optim:");
		for (UseEquationOptimization uEqOptim : tm.getUseEquationOptimizations()) {
			System.out.println("	* " + uEqOptim.getLabel() + " [ " + uEqOptim.isInput() + " | " + uEqOptim.getNum() + " ]");
			System.out.println("		-> " + uEqOptim.getMemoryAllocationSpaceTimeMap()
					+ "  IN " + uEqOptim.getMemorySpaceNameforTemporaryVariable());
			System.out.println("		-> memAlloc " + uEqOptim.getMemoryAllocationSpaceTimeMap()
					+ " | valueCopy = " + uEqOptim.getValueCopySpaceTimeMap()
					+ " | memFree = " + uEqOptim.getMemoryFreeSpaceTimeMap());
		}
		System.out.println("]]]]");
	}
	
	/* ---------------------------------------------------------------------------- */
	
	/**
	 * Management of the new TempRed / TempRed_SG variables
	 * @param pttm
	 * @param mTempRed
	 * @param lNAlignmentInfo
	 */
	private static void tempRedManagement(List<TileGroupSpecification> pttm,
			Map<String,Pair<FastISLMap,String>> mTempRed, List<List<Pair<String, Boolean>>> lNAlignmentInfo) {
		
		// We extend pttm to introduce the new tile groups (from TempRed)
		for (int k=pttm.size(); k<lNAlignmentInfo.size(); k++) {
			List<Pair<String, Boolean>> nAlignmentInfo = lNAlignmentInfo.get(k);
			
			TileGroupSpecification tgsTempRed = new TileGroupSpecification();
			for (Pair<String,Boolean> pVarTileGroup : nAlignmentInfo)
				tgsTempRed._mCobPreprocessing.put(pVarTileGroup.getValue0(), null);
			
			
			
			// TODO: fill the informations related to the new tile groups
			
		}
		
		// TODO: extend pttm to introduce the new tile groups, based on lNAlignmentInfo
		
		
		
		for (String nameTempRed : mTempRed.keySet()) {		// We update pttm by adding the informations of nameTempRed
			
			// First: find the correct pttm + add it
			Pair<Integer,Boolean> pNumTG_IsTempRedSG = searchInLNAlignmentInfo(nameTempRed, lNAlignmentInfo);
			int numTileGroup = pNumTG_IsTempRedSG.getValue0();
			boolean isTempRedSG = pNumTG_IsTempRedSG.getValue1();
			
			TileGroupSpecification tgs = pttm.get(numTileGroup);
			tgs._mCobPreprocessing.put(nameTempRed, null);				// We don't care about the CoB preprocessing
			
			if (isTempRedSG)
				tempRedSGManag(nameTempRed, tgs, mTempRed);
			else
				tempRedNotSGManag(nameTempRed, tgs, mTempRed);
		}
	}
	
	/**
	 * Management for the TempRed_SG (subFunction of tempRedManagement)
	 * 
	 * @param nameTempRed
	 * @param tgs
	 * @param mTempRed
	 */
	private static void tempRedSGManag(String nameTempRed, TileGroupSpecification tgs, Map<String,Pair<FastISLMap,String>> mTempRed) {
		
		// Getting the father variable
		Pair<FastISLMap,String> pProjFuncVarFather = mTempRed.get(nameTempRed);
		FastISLMap projFunc = pProjFuncVarFather.getValue0();
		String nameVarFather = pProjFuncVarFather.getValue1();			// Name of the variable which contained the reduction
		
		// --- Local informations
		// * Schedule: (k_b,i_l) -> (0, k_b, ...)
		//			+ modify the rest of the schedule to be (1, \vec{0}, ...)
		
		// Getting the cardinality of k_b
		int cardKb = projFunc.getNIndices() - projFunc.getDimRHS();
		
		// Schedule
		Map<String,AffineFunction> mLocalSTMap = tgs._mLocalSpaceTimeMap;
		for (String varInTileGroup : mLocalSTMap.keySet()) {
			AffineFunction oldSchedule = mLocalSTMap.get(varInTileGroup);
			
			long[][] oldScheduleMat;
			if (oldSchedule instanceof FastISLMap)
				oldScheduleMat = ((FastISLMap) oldSchedule).toMatrix().toLongArray();
			else
				oldScheduleMat = oldSchedule.getPMmapping().toMatrix().toLongArray();
			
			// We add the dimensions (0, k_b) at the beginning of the matrix
			long[][] newScheduleMat = new long[1+cardKb+oldScheduleMat.length][oldScheduleMat[0].length];
			newScheduleMat[0][newScheduleMat[0].length-1] = 1;
			for (int i=0; i<oldScheduleMat.length; i++)
				for (int j=0; j<oldScheduleMat[0].length; j++)
					newScheduleMat[1+cardKb+i][j] = oldScheduleMat[i][j];
			
			AffineFunction nSchedule = PolyhedralIRUserFactory.eINSTANCE.createFastISLMapMatLong(oldSchedule.getParams(),
					oldSchedule.getIndices(), newScheduleMat);
			mLocalSTMap.put(varInTileGroup, nSchedule);
		}
		
		AffineFunction scheduleFather = mLocalSTMap.get(nameVarFather);
		long[][] scheduleFatherMat;
		if (scheduleFather instanceof FastISLMap)
			scheduleFatherMat = ((FastISLMap) scheduleFather).toMatrix().toLongArray();
		else
			scheduleFatherMat = scheduleFather.getPMmapping().toMatrix().toLongArray();
		
		int nParamScheduleFather = scheduleFather.getNParams();
		long[][] newScheduleMat = new long[1+cardKb+scheduleFatherMat.length][scheduleFatherMat[0].length+cardKb];	// (k_b,i_l) -> (0, k_b, ...)
		for (int i=0; i<cardKb; i++)
			newScheduleMat[1+i][nParamScheduleFather+i] = 1;
		for (int i=0; i<scheduleFatherMat.length; i++) {
			for (int j=0; j<nParamScheduleFather; j++)
				newScheduleMat[1+cardKb+i][j] = scheduleFatherMat[i][j];
			for (int j=0; j<scheduleFather.getNIndices(); j++)
				newScheduleMat[1+cardKb+i][nParamScheduleFather+cardKb+j] = scheduleFatherMat[i][nParamScheduleFather+j];
		}
		
		List<Variable> lIndsNSchedule = new BasicEList<Variable>();
		for (int k=0; k<newScheduleMat[0].length; k++)
			lIndsNSchedule.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k));
		AffineFunction nSchedule = PolyhedralIRUserFactory.eINSTANCE.createFastISLMapMatLong(scheduleFather.getParams(),
				lIndsNSchedule, newScheduleMat);
		mLocalSTMap.put(nameTempRed, nSchedule);
		
		// * Mem mapping: (k_b, i_l) -> (k_b, ...)
		Map<String,Pair<AffineFunction,List<Integer>>> mLocalMemMap = tgs._mLocalMemoryMap;
		
		Pair<AffineFunction,List<Integer>> pmemMapModuloFather = mLocalMemMap.get(nameVarFather);
		AffineFunction memMapFather = pmemMapModuloFather.getValue0();
		List<Integer> lModsFather = pmemMapModuloFather.getValue1();
		
		long[][] memMapFatherMat;
		if (memMapFather instanceof FastISLMap)
			memMapFatherMat = ((FastISLMap) memMapFather).toMatrix().toLongArray();
		else
			memMapFatherMat = memMapFather.getPMmapping().toMatrix().toLongArray();
		int nParamMemMapFather = memMapFather.getNParams();
		
		long[][] memMapMat = new long[memMapFatherMat.length+cardKb][memMapFatherMat[0].length+cardKb];
		for (int i=0; i<cardKb; i++)
			memMapMat[i][i] = 1;
		for (int i=0; i<memMapFatherMat.length; i++) {
			for (int j=0; j<nParamMemMapFather; j++)							// Params
				memMapMat[i+cardKb][j] = memMapFatherMat[i][j];
			for (int j=0; j<memMapFather.getNIndices(); j++)					// Inds
				memMapMat[i+cardKb][nParamMemMapFather+cardKb+j] = memMapFatherMat[i][nParamMemMapFather+j];
		}
		List<Variable> lIndsNMemMap = new BasicEList<Variable>();
		for (int k=0; k<memMapMat[0].length; k++)
			lIndsNMemMap.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k));
		AffineFunction nMemMap = PolyhedralIRUserFactory.eINSTANCE.createFastISLMapMatLong(memMapFather.getParams(), lIndsNMemMap, memMapMat);
		
		List<Integer> nlMods = new BasicEList<Integer>();
		for (int i=0; i<cardKb; i++)
			nlMods.add(0);
		nlMods.addAll(lModsFather);
		
		mLocalMemMap.put(nameTempRed, Pair.with(nMemMap, nlMods));
		
		
		// --- Block informations - Memory map
		//		* (i_b -> ... )
		Map<String,Pair<AffineFunction,List<Integer>>> mBlockMemMap = tgs._mBlockMemoryMap;
		Pair<AffineFunction,List<Integer>> pInfoBlockMemMapFather = mBlockMemMap.get(nameVarFather);
		
		List<Integer> nlModsBlock = new BasicEList<Integer>();
		nlModsBlock.addAll(pInfoBlockMemMapFather.getValue1());
		
		mBlockMemMap.put(nameTempRed, Pair.with(pInfoBlockMemMapFather.getValue0().copy(), nlModsBlock));
		
		return;
	}
	
	/**
	 * Management for the TempRed (subFunction of tempRedManagement)
	 * 
	 * @param nameTempRed
	 * @param tgs
	 * @param mTempRed
	 */
	private static void tempRedNotSGManag(String nameTempRed, TileGroupSpecification tgs, Map<String,Pair<FastISLMap,String>> mTempRed) {
		
		// Getting the father variable
		Pair<FastISLMap,String> pProjFuncVarFather = mTempRed.get(nameTempRed);
		FastISLMap projFunc = pProjFuncVarFather.getValue0();
		String nameVarFather = pProjFuncVarFather.getValue1();			// Name of the variable which contained the reduction
		
		
		
		
		// TODO
		
		
		
		
	}
	
	/**
	 * Search function inside lNAlignmentInfo
	 * 
	 * @param nameTempRed
	 * @param lNAlignmentInfo
	 * @return
	 */
	private static Pair<Integer,Boolean> searchInLNAlignmentInfo(String nameTempRed, List<List<Pair<String, Boolean>>> lNAlignmentInfo) {
		for (int k=0; k<lNAlignmentInfo.size(); k++) {
			List<Pair<String,Boolean>> nAlignInfo = lNAlignmentInfo.get(k);
			for (Pair<String,Boolean> pStrBool : nAlignInfo) {
				if (pStrBool.getValue0().equals(nameTempRed))
					return Pair.with(k, pStrBool.getValue1());
			}
		}
		throw new RuntimeException("Variable " + nameTempRed + " not found in lNAlignmentInfo");
	}
	
	/**
	 * Determine if we can use the optimization of the code gen for a given input of a useEquation
	 * 		(ie, if we can send the values to the function just through a pointer, without having to do memory copies)
	 * 
	 * Cf "extractSubarrayAccessFunction" in "SubSystemCodeGenUtilityForC" for the place where it might bug...
	 * 
	 * @param varDeclInExpr
	 * @param depInExpr
	 * @param memMapBl
	 * @return
	 */
	private static boolean optimInputUseEquation(VariableDeclaration varDeclInExpr, AffineFunction depInExpr, AffineFunction memMapBl,
			UseEquation uEq, int numInput) {
		AffineFunction memMapBlWithLocInd = FunctionOperations.addLastDimensions(memMapBl, depInExpr.getDimRHS()-memMapBl.getDimRHS());
		
		JNIISLBasicMap bMapMemMapBlWithLocInd;
		if (memMapBlWithLocInd instanceof FastISLMap) {
			bMapMemMapBlWithLocInd = ((FastISLMap) memMapBlWithLocInd).getIslMap().copy();
		} else {
			bMapMemMapBlWithLocInd = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(memMapBlWithLocInd.getPMmapping()).getIslMap();
		}
		
		JNIISLBasicMap bMapDepInExpr;
		if (depInExpr instanceof FastISLMap) {
			bMapDepInExpr = ((FastISLMap) depInExpr).getIslMap().copy();
		} else {
			bMapDepInExpr = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(depInExpr.getPMmapping()).getIslMap();
		}
		
		// bMapMemMapBlWithLocInd only got the parameters of the original program
		//		=> we make it coherent with the parameters of bMapDepInExpr
		JNIISLMap mapMemMapBlWithLocInd = bMapMemMapBlWithLocInd.toMap();
		
		if (mapMemMapBlWithLocInd.getNbDims(JNIISLDimType.isl_dim_param)!=bMapDepInExpr.getNbDims(JNIISLDimType.isl_dim_param))
			mapMemMapBlWithLocInd = mapMemMapBlWithLocInd.addDims(JNIISLDimType.isl_dim_param, mapMemMapBlWithLocInd.getNbDims(JNIISLDimType.isl_dim_param)+1);
		for (int i=0; i<mapMemMapBlWithLocInd.getNbDims(JNIISLDimType.isl_dim_param); i++)
			mapMemMapBlWithLocInd = mapMemMapBlWithLocInd.setDimName(JNIISLDimType.isl_dim_param, i, bMapDepInExpr.getDimName(JNIISLDimType.isl_dim_param, i));
		
		// DEBUG
		//System.out.println("varDeclInExpr = " + varDeclInExpr.toString());
		//System.out.println("mapMemMapBlWithLocInd = " + mapMemMapBlWithLocInd.toString());
		//System.out.println("bMapDepInExpr = " + bMapDepInExpr.toString());
		
		JNIISLBasicMap bMapDepFuncInUseEquationCG = bMapDepInExpr.applyRange(mapMemMapBlWithLocInd.getBasicMaps().get(0));
		AffineFunction depFuncInUseEquationCG = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(bMapDepFuncInUseEquationCG);
		
		// DEBUG
		//System.out.println("depFuncInUseEquationCG = " + depFuncInUseEquationCG.toString());
		
		
		int nLocalIndexes = uEq.getSubSystem().getInputs().get(numInput).getDomain().getNIndices();
		int nDimExtDom = uEq.getExtensionDomain().getNIndices();
		
		if (depFuncInUseEquationCG.getDimRHS()==0)
			return true;
		
		long[][] indMatDepFuncInUseEqCG = FunctionOperations.getMatrixRepresentation(depFuncInUseEquationCG).getValue1();
		
		// We check the first nDimExtDom rows, and verify that there is only "0" after the nDimExtDom first columns
		boolean optimizationEnabled = true;
		for (int i=0; i<indMatDepFuncInUseEqCG.length-nLocalIndexes; i++) {
			for (int j=indMatDepFuncInUseEqCG[0].length-nDimExtDom; j<indMatDepFuncInUseEqCG[0].length; j++) {
				if (indMatDepFuncInUseEqCG[i][j]!=0)
					optimizationEnabled = false;
			}
		}
		
		// DEBUG
		//System.out.println("optimizationEnabled => " + optimizationEnabled +"\n");
		
		return optimizationEnabled;
	}
	
	
	
} // TargetMappingGeneratorParamTilingOutlining
