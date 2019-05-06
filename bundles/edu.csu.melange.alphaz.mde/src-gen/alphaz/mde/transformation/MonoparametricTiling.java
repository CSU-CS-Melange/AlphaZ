package alphaz.mde.transformation;

/*PROTECTED REGION ID(MonoparametricTiling_imports) ENABLED START*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.TilingInformations;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.ParametricTiling;
/*PROTECTED REGION END*/
/**
Commands which parametrize the monoparametric tiling transformation, plus the transformation itself
**/
public class MonoparametricTiling {

	/**
	Perform a monoparametric tiling transformation without outlining (the result is a single system in which all the dimensions are doubled).
By default, the ratio taken is 1^k (square), the minimum values of the blocked parameters are 0
    and each variables of the system are tiled independently, with no change of basis as a preprocessing.
	**/
	public static void monoparametricTiling_noOutlining(  Program prog , String systName , String nameBlockSizeParam , Boolean areParamDivisible , int minblSizeParam ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.monoparametricTiling_noOutlining) ENABLED START*/
		AffineSystem syst = prog.getSystem(systName);
		
		if (syst.getTilingInfo()==null) {
			syst.setTilingInfo(PolyhedralIRFactory.eINSTANCE.createTilingInformations());
		}
		// No CoB as preprocessing => we ignore CoBPreprocess
		// No outlining => we ignore the tile groups
		Map<String,EList<Integer>> lscaleInputs = syst.getTilingInfo().getRatios();
		Map<String,List<Integer>> lscaleInputsWithList = new HashMap<String, List<Integer>>();
		if (lscaleInputs==null)
			lscaleInputsWithList = new HashMap<String, List<Integer>>();
		else {
			for (String str : lscaleInputs.keySet()) {
				List<Integer> nListRatio = new BasicEList<Integer>();
				nListRatio.addAll(lscaleInputs.get(str));
				lscaleInputsWithList.put(str, nListRatio);
			}
		}
		Map<String,Map<String,List<Integer>>> mlscaleInputs = new HashMap<String,Map<String,List<Integer>>>();
		mlscaleInputs.put(systName, lscaleInputsWithList);
		
		List<Integer> minParamValues = new BasicEList<Integer>();
		if (syst.getTilingInfo().getMinParamValues()==null) {
			for (int k=0; k<syst.getParameters().getNParams(); k++)
				minParamValues.add(1);
		} else {
			for (int k=0; k<syst.getParameters().getNParams(); k++) {
				String nameParam = syst.getParameters().getParams().get(k).getName();
				
				Integer val = syst.getTilingInfo().getMinParamValues().get(nameParam);
				if (val==null)
					minParamValues.add(1);
				else
					minParamValues.add(val);
			}
		}
		
		ParametricTiling.parametricTiling_noOutlining(prog, nameBlockSizeParam, mlscaleInputs, areParamDivisible, minblSizeParam, minParamValues);
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Perform a monoparametric tiling transformation without outlining (the result is a single system in which all the dimensions are doubled).
By default, the ratio taken is 1^k (square), the minimum values of the blocked parameters are 0
    and each variables of the system are tiled independently, with no change of basis as a preprocessing.

The equations of the produced system are double-nested case expression, the first level corresponding to the constraints on the blocked indices
    and the second level to the constraints on the local indices.
	**/
	public static void monoparametricTiling_Outlining_noSubsystem(  Program prog , String systName , String nameBlockSizeParam , Boolean areParamDivisible , int minblSizeParam ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.monoparametricTiling_Outlining_noSubsystem) ENABLED START*/
		AffineSystem syst = prog.getSystem(systName);
		
		if (syst.getTilingInfo()==null) {
			syst.setTilingInfo(PolyhedralIRFactory.eINSTANCE.createTilingInformations());
		}
		
		// Getting lscaleInputs
		Map<String,EList<Integer>> lscaleInputs = syst.getTilingInfo().getRatios();
		Map<String,List<Integer>> lscaleInputsWithList = new HashMap<String, List<Integer>>();
		if (lscaleInputs==null)
			lscaleInputsWithList = new HashMap<String, List<Integer>>();
		else {
			for (String str : lscaleInputs.keySet()) {
				List<Integer> nListRatio = new BasicEList<Integer>();
				nListRatio.addAll(lscaleInputs.get(str));
				lscaleInputsWithList.put(str, nListRatio);
			}
		}
		
		// Getting minParamValues
		List<Integer> minParamValues = new BasicEList<Integer>();
		if (syst.getTilingInfo().getMinParamValues()==null) {
			for (int k=0; k<syst.getParameters().getNParams(); k++)
				minParamValues.add(1);
		} else {
			for (int k=0; k<syst.getParameters().getNParams(); k++) {
				String nameParam = syst.getParameters().getParams().get(k).getName();
				
				Integer val = syst.getTilingInfo().getMinParamValues().get(nameParam);
				if (val==null)
					minParamValues.add(1);
				else
					minParamValues.add(val);
			}
		}
		
		// Getting the alignment info from the tile groups and CoBPreprocess
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String, List<String>> mTileGroups = syst.getTilingInfo().getTileGroups();
		if (mTileGroups==null || mTileGroups.size()==0) {
			// By default, 1 tile group per variables (all vars tiled independently)
			for (VariableDeclaration varDeclLoc : syst.getLocals()) {
				Map<String,AffineFunction> mVarDeclLocal = new HashMap<String, AffineFunction>();
				mVarDeclLocal.put(varDeclLoc.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclLoc.getDomain()));
				alignmentInfo.add(mVarDeclLocal);
			}
			for (VariableDeclaration varDeclOut : syst.getOutputs()) {
				Map<String,AffineFunction> mVarDeclOutput = new HashMap<String, AffineFunction>();
				mVarDeclOutput.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
				alignmentInfo.add(mVarDeclOutput);
			}
		} else {
			for (List<String> lVarInTG : mTileGroups.values()) {
				Map<String,AffineFunction> mVarDeclTG = new HashMap<String, AffineFunction>();
				
				for (String strVar : lVarInTG) {
					AffineFunction cobPreprocess = syst.getTilingInfo().getCobPreprocess().get(strVar);
					if (cobPreprocess==null)
						mVarDeclTG.put(strVar, PolyhedralIRUtility.createIdentityFunction(
								syst.getVariableDeclaration(strVar).getDomain()));
					else
						mVarDeclTG.put(strVar, cobPreprocess);
				}
				
				alignmentInfo.add(mVarDeclTG);
			}
		}
		ParametricTiling.parametricTiling_Outlining_noSubSystem(syst, nameBlockSizeParam, lscaleInputsWithList,
				areParamDivisible, minblSizeParam, minParamValues, alignmentInfo);
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Perform a monoparametric tiling transformation with outlining (produces a subsystem for each kind of tiles in the program).
By default, the ratio taken is 1^k (square), the minimum values of the blocked parameters are 0
    and each variables of the system are tiled independently, with no change of basis as a preprocessing.
	**/
	public static void monoparametricTiling_Outlining(  Program prog , String systName , String nameBlockSizeParam , Boolean areParamDivisible , int minblSizeParam ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.monoparametricTiling_Outlining) ENABLED START*/
		AffineSystem syst = prog.getSystem(systName);
		
		if (syst.getTilingInfo()==null) {
			syst.setTilingInfo(PolyhedralIRFactory.eINSTANCE.createTilingInformations());
		}
		
		// Getting lscaleInputs
		Map<String,EList<Integer>> lscaleInputs = syst.getTilingInfo().getRatios();
		Map<String,List<Integer>> lscaleInputsWithList = new HashMap<String, List<Integer>>();
		if (lscaleInputs==null)
			lscaleInputsWithList = new HashMap<String, List<Integer>>();
		else {
			for (String str : lscaleInputs.keySet()) {
				List<Integer> nListRatio = new BasicEList<Integer>();
				nListRatio.addAll(lscaleInputs.get(str));
				lscaleInputsWithList.put(str, nListRatio);
			}
		}
		
		// Getting minParamValues
		List<Integer> minParamValues = new BasicEList<Integer>();
		if (syst.getTilingInfo().getMinParamValues()==null) {
			for (int k=0; k<syst.getParameters().getNParams(); k++)
				minParamValues.add(1);
		} else {
			for (int k=0; k<syst.getParameters().getNParams(); k++) {
				String nameParam = syst.getParameters().getParams().get(k).getName();
				
				Integer val = syst.getTilingInfo().getMinParamValues().get(nameParam);
				if (val==null)
					minParamValues.add(1);
				else
					minParamValues.add(val);
			}
		}
		
		// Getting the alignment info from the tile groups and CoBPreprocess
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String, List<String>> mTileGroups = syst.getTilingInfo().getTileGroups();
		if (mTileGroups==null || mTileGroups.size()==0) {
			// By default, 1 tile group per variables (all vars tiled independently)
			for (VariableDeclaration varDeclLoc : syst.getLocals()) {
				Map<String,AffineFunction> mVarDeclLocal = new HashMap<String, AffineFunction>();
				mVarDeclLocal.put(varDeclLoc.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclLoc.getDomain()));
				alignmentInfo.add(mVarDeclLocal);
			}
			for (VariableDeclaration varDeclOut : syst.getOutputs()) {
				Map<String,AffineFunction> mVarDeclOutput = new HashMap<String, AffineFunction>();
				mVarDeclOutput.put(varDeclOut.getName(), PolyhedralIRUtility.createIdentityFunction(varDeclOut.getDomain()));
				alignmentInfo.add(mVarDeclOutput);
			}
		} else {
			for (List<String> lVarInTG : mTileGroups.values()) {
				Map<String,AffineFunction> mVarDeclTG = new HashMap<String, AffineFunction>();
				
				for (String strVar : lVarInTG) {
					AffineFunction cobPreprocess = syst.getTilingInfo().getCobPreprocess().get(strVar);
					if (cobPreprocess==null)
						mVarDeclTG.put(strVar, PolyhedralIRUtility.createIdentityFunction(
								syst.getVariableDeclaration(strVar).getDomain()));
					else
						mVarDeclTG.put(strVar, cobPreprocess);
				}
				
				alignmentInfo.add(mVarDeclTG);
			}
		}
		
		ParametricTiling.parametricTiling_Subsystem(syst, nameBlockSizeParam, lscaleInputsWithList, areParamDivisible,
				minblSizeParam, minParamValues, alignmentInfo);
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Specify the ratio of a variable, before the tiling transformation. The default ratio taken for a variable is 1^k (square ratio)
	**/
	public static void setRatio(  Program prog , String syst , String varName , String lRatios ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.setRatio) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		TilingInformations tilingInfo = affSyst.getTilingInfo();
		
		if (tilingInfo==null) {
			tilingInfo = PolyhedralIRFactory.eINSTANCE.createTilingInformations();
			affSyst.setTilingInfo(tilingInfo);
		}
		
		EList<Integer> lIntRatios = new BasicEList<Integer>();
		if (lRatios != null) {
			for (String expr : lRatios.split(",")) {
				int intExpr = Integer.parseInt(expr);
				lIntRatios.add(intExpr);
			}
		}
		
		if (tilingInfo.getRatios()==null) {
			// Start building a new lRatio
			Map<String, EList<Integer>> nRatios = new HashMap<String, EList<Integer>>();
			nRatios.put(varName,lIntRatios);
			tilingInfo.setRatios(nRatios);
		} else
			tilingInfo.getRatios().put(varName, lIntRatios);
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Set the minimum blocked parameter values, before the tiling transformation.
The default value is "0" for every parameters.
	**/
	public static void setMinParamValues(  Program prog , String syst , String paramName , int minValue ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.setMinParamValues) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		TilingInformations tilingInfo = affSyst.getTilingInfo();
		
		if (tilingInfo==null) {
			tilingInfo = PolyhedralIRFactory.eINSTANCE.createTilingInformations();
			affSyst.setTilingInfo(tilingInfo);
		}
		
		if (tilingInfo.getMinParamValues()==null) {
			Map<String,Integer> nMinParamValues = new HashMap<String, Integer>();
			nMinParamValues.put(paramName, minValue);
			tilingInfo.setMinParamValues(nMinParamValues);
		} else
			tilingInfo.getMinParamValues().put(paramName, minValue);
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Set the tile group of a variable (through a common name), before a tiling.
By default, each variable is alone in its tile group (which has the same name than the variable name)
	**/
	public static void setTileGroup(  Program prog , String syst , String varName , String tileGroupName ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.setTileGroup) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		TilingInformations tilingInfo = affSyst.getTilingInfo();
		
		if (tilingInfo==null) {
			tilingInfo = PolyhedralIRFactory.eINSTANCE.createTilingInformations();
			affSyst.setTilingInfo(tilingInfo);
		}
		
		if (tilingInfo.getTileGroups()==null) {
			Map<String, List<String>> nTileGroups = new HashMap<String, List<String>>();
			
			List<String> nVarOfTileGroup = new BasicEList<String>();
			nVarOfTileGroup.add(varName);
			
			nTileGroups.put(tileGroupName, nVarOfTileGroup);
			tilingInfo.setTileGroups(nTileGroups);
		} else {
			List<String> lVarOfTileGroup = tilingInfo.getTileGroups().get(tileGroupName);
			
			if (lVarOfTileGroup==null) {
				List<String> nVarOfTileGroup = new BasicEList<String>();
				nVarOfTileGroup.add(varName);
				
				tilingInfo.getTileGroups().put(tileGroupName, nVarOfTileGroup);
			} else
				lVarOfTileGroup.add(varName);
		}
		
		return;
		/*PROTECTED REGION END*/
	}


	/**
	Set the Change of Basis transformation that need to be performed before tiling (usually to make the rectangular tiling legal).
By default, this function is Id (i.e., no CoB is performed before the tiling)
	**/
	public static void setCoBPreprocess(  Program prog , String syst , String varName , String cobAffFunc ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.monoparametrictiling.setCoBPreprocess) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		TilingInformations tilingInfo = affSyst.getTilingInfo();
		
		if (tilingInfo==null) {
			tilingInfo = PolyhedralIRFactory.eINSTANCE.createTilingInformations();
			affSyst.setTilingInfo(tilingInfo);
		}
		
		AffineFunction affFuncCob = PolyhedralIRUtility.parseAffineFunction(affSyst.getParameters(), cobAffFunc);
		
		if (tilingInfo.getCobPreprocess()==null) {
			Map<String,AffineFunction> nCobPreprocess = new HashMap<String,AffineFunction>();
			nCobPreprocess.put(varName, affFuncCob);
			tilingInfo.setCobPreprocess(nCobPreprocess);
		} else
			tilingInfo.getCobPreprocess().put(varName, affFuncCob);
		
		return;
		/*PROTECTED REGION END*/
	}

}//end MonoparametricTiling
