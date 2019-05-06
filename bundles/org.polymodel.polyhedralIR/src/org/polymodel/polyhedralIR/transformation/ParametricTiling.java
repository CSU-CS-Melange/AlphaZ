package org.polymodel.polyhedralIR.transformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.matrix.impl.PolymodelMatrixOperation;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.CARTOperations;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

/**
 * Class gathering all the transformations which transform all the indexes i of an Alpha program into a couple <\alpha,ii>
 * 		such that i = \alpha.D.b+ii, b being a tile size parameter (common to every dimensions) and
 *    D being the (integer) aspect ratio between the dimensions.
 * 
 * The output program will be still polyhedral.
 * 
 * Note: A (old) standalone version of this file (in Java and C++) is available at "compsys-tools.ens-lyon.fr"
 * 
 * @author giooss
 */
public class ParametricTiling {
	
	// Factories
	private static PolymodelDefaultFactory _polyFact = PolymodelComponent.INSTANCE.getFactory();
	private static PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	private static DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
	
	// DEBUG - tracking of the visitors
	private final static boolean _noisyTracking = false;
	public static long _starttime;
	
	private final static boolean _debugShowSteps = true;	// DEBUG TODO
	
	public static void printInfoDebug(String stepName) {
		Runtime runtime = Runtime.getRuntime();
		long mem = runtime.totalMemory() / 1048576;
		long currentTime = System.currentTimeMillis() - _starttime;
		if (_debugShowSteps)
			System.out.println("*** " + stepName + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	
	
	// Main functions
 	public static void parametricTiling(AffineSystem syst, String nameBlockSizeParam, Map<String,List<Integer>> scaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValue) {
		
		// Preprocessing
		LowerDependences.lowerDependences(syst);			
		ExpressionDomainCalculator.computeExpressionDomain(syst);
		
		Variable blSizeParam = _dimMana.getParameter(syst.getParameters().getNParams()*2, nameBlockSizeParam);
		syst.accept(new ParametricTilingVisitor(syst, blSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValue, null));
		
		// We recompute the expression and context domain (for consistency)
//		ExpressionDomainCalculator.computeExpressionDomain(syst);
//		ContextDomainCalculator.computeContextDomain(syst.getContainerProgram());
	}
	
	public static void parametricTiling(Program prog, String nameBlockSizeParam, Map<String, Map<String,List<Integer>>> lscaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValue) {
		
		for (AffineSystem syst : prog.getSystems()) {
			String systName = syst.getName();
			
			Map<String,List<Integer>> scaleInputs;
			if (lscaleInputs.containsKey(systName))
				scaleInputs = lscaleInputs.get(systName);
			else
				scaleInputs = new HashMap<String,List<Integer>>();
			
			LowerDependences.lowerDependences(syst);			// Preprocessing
			Variable blSizeParam = _dimMana.getParameter(syst.getParameters().getNParams()*2, nameBlockSizeParam);
			syst.accept(new ParametricTilingVisitor(syst, blSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValue, null));
			
			// Tracking
			if (_noisyTracking)
				System.out.println("!!! TRACKING - END !!!");
			
			/*
			System.out.println("******************* DEBUG (ParametricTiling::parametricTiling static function)");
			System.out.println(syst.toString());
			//*/
		}
		
		// We recompute the expression and context domain (for consistency)
		//ExpressionDomainCalculator.computeExpressionDomain(prog);
		//ContextDomainCalculator.computeContextDomain(prog);
	}
	
	public static void parametricTiling_noOutlining(Program prog, String nameBlockSizeParam, Map<String, Map<String,List<Integer>>> lscaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValues) {
		
		for (AffineSystem syst : prog.getSystems()) {
			String systName = syst.getName();
			
			Map<String,List<Integer>> scaleInputs;
			if (lscaleInputs.containsKey(systName))
				scaleInputs = lscaleInputs.get(systName);
			else
				scaleInputs = new HashMap<String,List<Integer>>();
			
			Variable blSizeParam = _dimMana.getParameter(syst.getParameters().getNParams()*2, nameBlockSizeParam);
			syst.accept(new ParametricTilingVisitor_NoOutlining(syst, blSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValues));
			
			/*
			System.out.println("******************* DEBUG (ParametricTiling::parametricTiling static function)");
			System.out.println(syst.toString());
			//*/
		}
	}
	

	public static void parametricTiling_Outlining_noSubSystem(AffineSystem syst, String nameBlockSizeParam, Map<String,List<Integer>> scaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValue, List<Map<String,AffineFunction>> alignmentInfo) {
		_starttime = System.currentTimeMillis();
		printInfoDebug("START");
		
		// I/ Pre-processing
		//		=> using alignment informations to place the variable which will be grouped together in the same space
		// Invariant: we assume that each variable are present only one in alignmentInfo
		for (Map<String,AffineFunction> groupAlign : alignmentInfo)
			for (String coBInfoStr : groupAlign.keySet())
				ChangeOfBasis.CoB(syst, coBInfoStr, groupAlign.get(coBInfoStr), true);	// WARNING: changes the signature of the system...
		
		// II/ CARTing
		//NormalizeVisitor.normalize(syst);
		//NormalizeVisitor.lowerDependence(syst);
		NormalizeVisitor.normalize(syst);
		NormalizeVisitor.lowerDependence(syst);			// Preprocessing
		ContextDomainCalculator.computeContextDomain(syst);
		
		/* DEBUG
		System.out.println("****** DEBUG - System before CARTing / after lowerDep ******");
		System.out.println(syst.toString());
		System.out.println("******************************************");
		//*/
		printInfoDebug("Preprocessing pre-CART");
		
		
		Variable blSizeParam = _dimMana.getParameter(syst.getParameters().getNParams()*2, nameBlockSizeParam);
		ParametricTilingVisitor visitor = new ParametricTilingVisitor(syst, blSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValue, alignmentInfo);
		syst.accept(visitor);
		
		printInfoDebug("CART with outlining prep");
		
		return;
	}
	
	public static void parametricTiling_Subsystem(Program prog, String nameBlockSizeParam, Map<String,List<Integer>> scaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValue, List<Map<String,AffineFunction>> alignmentInfo) {
		// We assume for now that there is only one affine system in "prog"  (to be changed later)
		//		=> no useEquation in the input system
		AffineSystem syst = prog.getSystems().get(0);
		parametricTiling_Subsystem(syst, nameBlockSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValue, alignmentInfo);
	}
	
	public static void parametricTiling_Subsystem(AffineSystem syst, String nameBlockSizeParam, Map<String,List<Integer>> scaleInputs,
			boolean areParamDivisible, int minblSizeParam, List<Integer> minParamValue, List<Map<String,AffineFunction>> alignmentInfo) {
		_starttime = System.currentTimeMillis();
		printInfoDebug("START");
		
		// I/ Pre-processing
		//		=> using alignment informations to place the variable which will be grouped together in the same space
		// Invariant: we assume that each variable are present only one in alignmentInfo
		for (Map<String,AffineFunction> groupAlign : alignmentInfo)
			for (String coBInfoStr : groupAlign.keySet())
				ChangeOfBasis.CoB(syst, coBInfoStr, groupAlign.get(coBInfoStr), true);	// WARNING: changes the signature of the system...
		
		
		// II/ CARTing
		//NormalizeVisitor.normalize(syst);
		NormalizeVisitor.lowerDependence(syst);			// Preprocessing
		ContextDomainCalculator.computeContextDomain(syst);
		
		/* DEBUG
		System.out.println("****** DEBUG - System before CARTing / after lowerDep ******");
		System.out.println(AShow.toString(syst));
		System.out.println("******************************************");
		//*/
		printInfoDebug("Preprocessing pre-CART");
		
		
		Variable blSizeParam = _dimMana.getParameter(syst.getParameters().getNParams()*2, nameBlockSizeParam);
		ParametricTilingVisitor visitor = new ParametricTilingVisitor(syst, blSizeParam, scaleInputs, areParamDivisible, minblSizeParam, minParamValue, alignmentInfo);
		syst.accept(visitor);
		
		printInfoDebug("CART with outlining prep");
		
		
		/* DEBUG
		System.out.println("****** DEBUG - System after CARTing ******");
		System.out.println(AShow.toString(syst));
		//System.out.println(syst.toString());
		System.out.println("******************************************");
		//*/
		
		/* DEBUG
		System.out.println("AlignmentInfo = " + alignmentInfo);
		System.out.println("nAlignmentInfo = " + visitor._nAlignmentInfo);
		System.out.println("AlignmentRedInfo = " + visitor._alignmentRedInfo);
		System.out.println();
		//*/
		
		// III/ Forming the subsystems
		ParametricTilingOutlining.outlineAfterCart(syst.getContainerProgram(), syst, visitor._nAlignmentInfo, visitor._alignmentRedInfo);
	}
	
	
	
	/* ------------------------- VISITOR ON THE ALPHA PROGRAM -------------------------------------------- */
	public static String suffixBlVar = "_bl";							// Suffix for variable name
	
	private static class ParametricTilingVisitor_NoOutlining extends PolyhedralIRDepthFirstVisitorImpl {
		
		/* The modifications done by this visitor are the following:
		- VariableDeclaration: change the name of the variable (by adding suffixBlocked at the end of the name),
				and get the "blocked definition domain" of the variable
		- Inside the Expressions:
		    * We add a dummy dep "Id@A" in front of every occurrence of input variable "A", to make the aspect ration of "Id@A" the identity,
		        then we tile it (using the "DependenceExpression" rule)
			* The domains of RestrictExpression are replaced by their blocked counter-part
			* "DependenceExpression" are managed in the following way:
				+ A case is introduced, in which the subcase are RestrictExpression (corresponding to the different parts of the piecewise blocked dependence function)
				+ The expressions itself is copied, with the different values of the dependence for every parts
			* "ReductionExpression" are managed in the following way:
				+ We introduce a sum of reduction (with the reduction operator between), where each reduction correspond to a part of the piecewise blocked projection function
				+ The reduction expression is duplicated and has a restriction in front of it, corresponding to the conditions from the piecewise function.
		 */
		
		private String suffixBlVar = "_bl";						// Suffix for variable name
		private String suffixBlParam = "b";						// Suffix for blocked parameter
		private String suffixLocParam = "l";					// Suffix for local parameter
		private String suffixBlInd = "Bl";						// Suffix for blocked index
		private String suffixLocInd = "Loc";					// Suffix for local index
		private String suffixTempUseEqOutputVar = "_blTemp";	// Suffix for the temporary output that might be introduced by the transformation on useEquation
		
		
		// RESTRICTION:
		//	- For now, we assume only one blocked parameter "_blSizeParam"
		//	- The aspect ratio of expressions is the smallest one possible which does not introduce modulo
		//	- We assume that the user give an aspect ratio for each variable. If no aspect ratio is given, we take "Id"
		//	- The aspect ratio of parameters is "Id" for now...
		
		private AffineSystem _syst;												// Considered affine system
		private Variable _blSizeParam;											// blockSizeParameter
		private Map<String,String> _mapScalBlockVar;							// Mapping for variables
		private Map<Variable, Map<Variable,Variable> > _mapScalBlockLocParam;	// Mapping for parameters
		private EList<Variable> _listBlockedParam;								// List of the blocked parameters
		private EList<Variable> _listLocalParam;								// List of the local parameters
		private EList<Variable> _listBlLocParam;								// List of blocked then local parameters
		private ParameterDomain _blockedParamDom;								// ParameterDomain of the blocked system
		private Map<String,List<Integer>> _scaleDimVar;							// Indicate if a given dimension of a variable has a scale
		private boolean _paramDiv;												// Do we assume that the parameters are divisible?
		private int _minblSizeParam;											// Minimum value allowed for the variable _blSizeParam
		private List<Integer> _minParamValues;
		
		private List<Integer> _ratioSubExpr;									// Ratio of the expression we just have visited
		private Expression _subExprToBeReplaced;								// Expression replacing the expression we just have visited
		
		private List<StandardEquation> _extraStEq;								// Standard Equations to be added (cf CART of useEquations)
		private List<UseEquation> _extraUseEq;									// Use Equations to be added (cf CART of useEquations)
		
		
		private List<VariableDeclaration> _lVarDeclBlInput;
		private List<VariableDeclaration> _lVarDeclBlOutput;
		private List<VariableDeclaration> _lVarDeclBlLocal;
		
		
 		public ParametricTilingVisitor_NoOutlining(AffineSystem syst, Variable blSizeParam, Map<String,List<Integer>> scaleInputs, boolean paramDiv,
 				int minB, List<Integer> minParamValues) {
			this._syst = syst;
 			this._blSizeParam = blSizeParam;
			this._mapScalBlockVar = new HashMap<String, String>();
			this._mapScalBlockLocParam = new HashMap<Variable, Map<Variable,Variable> >();
			this._listBlockedParam = new BasicEList<Variable>();
			this._listLocalParam = new BasicEList<Variable>();
			this._listBlLocParam = new BasicEList<Variable>();
			this._scaleDimVar = scaleInputs;
			this._paramDiv = paramDiv;
			this._minblSizeParam = minB;
			this._minParamValues = minParamValues;
			
			this._extraStEq = new BasicEList<StandardEquation>();
			this._extraUseEq = new BasicEList<UseEquation>();
			
			this._lVarDeclBlInput = new BasicEList<VariableDeclaration>();
			this._lVarDeclBlOutput = new BasicEList<VariableDeclaration>();
			this._lVarDeclBlLocal = new BasicEList<VariableDeclaration>();
		}
 		
 		
 		// --- Non-equational modifications ---
		@Override
		public void outAffineSystem(AffineSystem s) {
			s.getEquations().addAll(_extraStEq);
			s.getUseEquations().addAll(_extraUseEq);
			
			s.getInputs().clear(); s.getInputs().addAll(_lVarDeclBlInput);
			s.getOutputs().clear(); s.getOutputs().addAll(_lVarDeclBlOutput);
			s.getLocals().clear(); s.getLocals().addAll(_lVarDeclBlLocal);
		}
 		
 		@Override
		public void visitParameterDomain(ParameterDomain p) {
			List<Variable> scalParams = p.getParams();
			
			// === Creation of the blocked/local parameters
			for (int i=0; i<scalParams.size(); i++) {
				String blockParamName = scalParams.get(i).getName() + suffixBlParam;
				Variable blParam = _dimMana.getParameter(i, blockParamName);
				_listBlockedParam.add(blParam);
				
				String locParamName = scalParams.get(i).getName() + suffixLocParam;
				Variable locParam = _dimMana.getParameter(i+scalParams.size(), locParamName);
				_listLocalParam.add(locParam);
				
				Map<Variable,Variable> pairParam = new HashMap<Variable,Variable>();
				pairParam.put(blParam, locParam);
				_mapScalBlockLocParam.put(scalParams.get(i), pairParam);
			}
			_listBlLocParam.addAll(_listBlockedParam);
			_listBlLocParam.addAll(_listLocalParam);

			
			// === Transforming the constraints on the parameters
			_blockedParamDom = CARTOperations.getTiledParameterDomain(p, _listBlockedParam, _listLocalParam, _blSizeParam, _paramDiv,
					_minblSizeParam, _minParamValues);
			_syst.setParameters(_blockedParamDom);
			
		}
		
		@Override
		public void visitVariableDeclaration(VariableDeclaration varDecl) {
			String nameVar = varDecl.getName();
			Domain domVar = varDecl.getDomain();
			
			// Creating the new name
			String nameVarBlocked = nameVar + suffixBlVar;
			_mapScalBlockVar.put(nameVar, nameVarBlocked);
			
			// Creating the new indexes
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			for (int i=0; i<domVar.getIndices().size(); i++) {
				Variable ind = domVar.getIndices().get(i);
				String blockIndName = ind.getName() + suffixBlInd;
				blockInd.add(_dimMana.getDimension(i, blockIndName));
				
				String localIndName = ind.getName() + suffixLocInd;
				localInd.add(_dimMana.getDimension(i+domVar.getIndices().size(), localIndName));
			}
			
			// Getting the aspect-ratio
			List<Integer> ratio = getRatioVariable(_scaleDimVar, nameVar, domVar.getNIndices());
			
			// Computing the new domain and creating the variable declaration
			FastISLDomain domVarBlocked = CARTOperations.getTiledDomain(domVar, blockInd, localInd, _listBlockedParam, _listLocalParam, ratio, _blSizeParam,
					_paramDiv, _minblSizeParam, _minParamValues);
			domVarBlocked.simplify();
			VariableDeclaration varDeclBl = _polyIRFact.createVariableDeclaration(nameVarBlocked, varDecl.getType(), domVarBlocked);
			
			// Update of the system with the new variable declaration
			if (_syst.isInput(varDecl)) {
				_lVarDeclBlInput.add(varDeclBl);
			}
			if (_syst.isLocal(varDecl)) {
				_lVarDeclBlLocal.add(varDeclBl);
			}
			if (_syst.isOutput(varDecl)) {
				_lVarDeclBlOutput.add(varDeclBl);
			}
		}
		
		@Override
		public void outStandardEquation(StandardEquation stEq) {
			String nameVarEq = stEq.getVariable().getName();
			
			// Getting the aspect ratio
			List<Integer> ratioVar = getRatioVariable(_scaleDimVar, stEq.getVariable().getName(), stEq.getVariable().getDomain().getNIndices());
			List<Integer> ratioSubExpr = _ratioSubExpr;
			assert(ratioVar.size()==ratioSubExpr.size());
			
			/* DEBUG
			System.out.println("DEBUG:");
			System.out.print("	- RatioVar = [");
			for (int i=0; i<ratioVar.size(); i++)
				System.out.print(ratioVar.get(i) + " ");
			System.out.println("]");

			System.out.print("	- RatioSubExpr = [");
			for (int i=0; i<ratioSubExpr.size(); i++)
				System.out.print(ratioSubExpr.get(i) + " ");
			System.out.println("]");
			//*/
			
			
			boolean isRatioEqual = true;
			for (int i=0; i<ratioVar.size(); i++)
				if (ratioVar.get(i)!=ratioSubExpr.get(i))
					isRatioEqual = false;
			
			
			// Updating the Standard Equation
			String nameBlockVar = _mapScalBlockVar.get(nameVarEq);
			VariableDeclaration varDeclBlocked = null;
			if (stEq.getVariable().isLocal())
				for (VariableDeclaration varDeclLoc : _lVarDeclBlLocal)
					if (varDeclLoc.getName()==nameBlockVar) {
						varDeclBlocked = varDeclLoc;
						break;
					}
			if (stEq.getVariable().isOutput())
				for (VariableDeclaration varDeclOut : _lVarDeclBlOutput)
					if (varDeclOut.getName()==nameBlockVar) {
						varDeclBlocked = varDeclOut;
						break;
					}
			stEq.setVariable(varDeclBlocked);
			
			if (isRatioEqual)			// If the ratio are the same => no problem
				stEq.setExpression(_subExprToBeReplaced);
			else {						// If the ratio are different, we need to introduce a Id function
				
				// Modulo condition here?
				for (int i=0; i<ratioVar.size(); i++)
					if (!divides(ratioSubExpr.get(i), ratioVar.get(i)))
						throw new RuntimeException("Ratio not compatible: Fails for dimension " + i + " in the equation " + nameVarEq
								+ " / ratioExpr = " + ratioSubExpr.get(i) + " and ratioVar = " + ratioVar.get(i));
				
				// No modulo => we CART the Id function
				List<Variable> blockInd = new BasicEList<Variable>();
				List<Variable> localInd = new BasicEList<Variable>();
				List<String> lIndNames = stEq.getVariable().getDomain().getIndexNames();
				for (int i=0; i<stEq.getVariable().getDomain().getNIndices(); i++) {
					blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
					localInd.add(_dimMana.getDimension(i+stEq.getVariable().getDomain().getNIndices(), lIndNames.get(i) + suffixLocInd));
				}
				AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(stEq.getVariable().getDomain());
				
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						ratioVar, ratioSubExpr, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					if (!domCond.isEmpty()) {
						DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), _subExprToBeReplaced.copy());
						lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					}
				}
				stEq.setExpression(_polyIRFact.createCaseExpression(lRestrExpr));
			}
		}
		
		@Override
		public void visitUseEquation(UseEquation useEq) {
			
			// TODO: managing the aspect ratio
			
			// *** Extension domain ***
			Domain extDomScal = useEq.getExtensionDomain();
			List<Variable> blockIndDom = new BasicEList<Variable>();
			List<Variable> localIndDom = new BasicEList<Variable>();
			List<String> lIndNames = extDomScal.getIndexNames();
			for (int i=0; i<extDomScal.getNIndices(); i++) {
				blockIndDom.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localIndDom.add(_dimMana.getDimension(i+extDomScal.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			List<Integer> scaleDom = new BasicEList<Integer>();
			for (int i=0; i<extDomScal.getNIndices(); i++)
				scaleDom.add(1);
			Domain extDomTiled = CARTOperations.getTiledDomain(extDomScal, blockIndDom, localIndDom,
					_listBlockedParam, _listLocalParam, scaleDom, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			
			// *** Input expression ***
			List<Expression> newInputs = new BasicEList<Expression>();
			for (Expression exprInput : useEq.getInputs()) {
				visitExpression(exprInput);
				newInputs.add(_subExprToBeReplaced);
			}
			
			
			// *** Output variables ***
			List<VariableDeclaration> newOutputs = new BasicEList<VariableDeclaration>();
			for (VariableDeclaration varOut : useEq.getOutputs())
				newOutputs.add(_syst.getVariableDeclaration(_mapScalBlockVar.get(varOut.getName())));
			
			
			// *** Parameter expression ***
			AffineFunction funcParam = useEq.getParameters();
			List<Integer> scaleFuncAnt = new BasicEList<Integer>();
			for (int i=0; i<funcParam.getNIndices(); i++)
				scaleFuncAnt.add(1);
			List<Integer> scaleFunIm = new BasicEList<Integer>();
			for (int i=0; i<funcParam.getDimRHS(); i++)
				scaleFunIm.add(1);
			Map<FastISLDomain, FastISLMap> mfunc = CARTOperations.getTiledFunction(funcParam, blockIndDom, localIndDom, _listBlockedParam, _listLocalParam,
					scaleFuncAnt, scaleFunIm, _blSizeParam, _paramDiv, _minblSizeParam);
			
			if (mfunc.size()==1) {			// Only one case for the parameter domain
				useEq.setExtensionDomain(extDomTiled);
				for (Domain dom : mfunc.keySet()) {
					AffineFunction mappingMFunc = mfunc.get(dom);
					
					Matrix matMapping = mappingMFunc.getPMmapping().toMatrix();
					long[][] longMatMapping = matMapping.toLongArray();
					long[][] nlongMatMapping = MatrixOperations.rowBind(longMatMapping, 1);
					nlongMatMapping[nlongMatMapping.length-1][mappingMFunc.getNParams()] = 1;	// TODO: bug here... :/ (position of the "i")
					
					Matrix nMatMapping = PolymodelMatrixOperation.toMatrix(nlongMatMapping);
					List<IntExpression> exprFunc = nMatMapping.toFunction(mappingMFunc.getParams(), mappingMFunc.getIndices());
					DomainDimensions dimDom = _polyFact.createDomainDimensions(mappingMFunc.getIndices(), mappingMFunc.getParams());
					AffineFunction nMappingMFunc = _polyIRFact.createAffineFunction(_polyFact.createFunction(dimDom, exprFunc));
					
					useEq.setParameters(nMappingMFunc);
				}
				useEq.getOutputs().clear(); useEq.getOutputs().addAll(newOutputs);
				useEq.getInputs().clear(); useEq.getInputs().addAll(newInputs);
			} else {						// Several case for the parameter domain
				
				// Modifications to be done:
				// IF [ mfunc = (D_k , paramExpr_k) , 0<=k<Ncase ] AND [the outputs of the use equations are O_l , 0<=l<Noutput] THEN
				//		- introduce for each (k,l) Obl_k_l defined on $D_{O_l} \cap D_k$
				//		- create l equations Obl_l = case ... D_k : Obl_k,l ... esac
				//		- create k useEquations use (\Delta \cap D_k) subsyst[paramExpr_k] (inputsExpr) returns (... Obl_k,l ... );
				// And do not forget to remove the current useEquation from the system
				int nDomKey=0;
				List<List<VariableDeclaration>> llOutputUeq = new BasicEList<List<VariableDeclaration>>();
				List<Domain> listKey = new BasicEList<Domain>();
				for (Domain domKey : mfunc.keySet()) {
					listKey.add(domKey);
					
					// TODO: transformation of domKey needed ?
					
					List<VariableDeclaration> lOutputUeq = new BasicEList<VariableDeclaration>();
					for (VariableDeclaration varOutput : useEq.getOutputs()) {
						
						VariableDeclaration nVarDecl = _polyIRFact.createVariableDeclaration(
								varOutput.getName() + suffixTempUseEqOutputVar + "_" + nDomKey, varOutput.getType(),
								varOutput.getDomain().intersection(domKey));
						lOutputUeq.add(nVarDecl);
					}
					llOutputUeq.add(lOutputUeq);
					nDomKey++;
				}
				
				List<StandardEquation> lStEq = new BasicEList<StandardEquation>();
				for (int l=0; l<useEq.getOutputs().size();l++) {
					List<Expression> lRestrExpr = new BasicEList<Expression>();
					for (int k=0; k<mfunc.size(); k++) {
						RestrictExpression restrExpr = _polyIRFact.createRestrictExpression(listKey.get(l),
								_polyIRFact.createVariableExpression(llOutputUeq.get(k).get(l)));
						lRestrExpr.add(restrExpr);
					}
					CaseExpression caseExpr = _polyIRFact.createCaseExpression(lRestrExpr);
					StandardEquation stEq = _polyIRFact.createStandardEquation(newOutputs.get(l), caseExpr);
					
					lStEq.add(stEq);
				}
				
				List<UseEquation> lUseEq = new BasicEList<UseEquation>();
				for (int k=0; k<mfunc.size(); k++) {
					// We need to add "b" at the end of the parameter mapping
					AffineFunction mappingMFunc = mfunc.get(listKey.get(k));
					
					Matrix matMapping = mappingMFunc.getPMmapping().toMatrix();
					long[][] longMatMapping = matMapping.toLongArray();
					long[][] nlongMatMapping = MatrixOperations.rowBind(longMatMapping, 1);
					nlongMatMapping[nlongMatMapping.length-1][_listBlockedParam.size()*2+1] = 1;
					
					Matrix nMatMapping = PolymodelMatrixOperation.toMatrix(nlongMatMapping);
					List<IntExpression> exprFunc = nMatMapping.toFunction(mappingMFunc.getParams(), mappingMFunc.getIndices());
					DomainDimensions dimDom = _polyFact.createDomainDimensions(mappingMFunc.getIndices(), mappingMFunc.getParams());
					AffineFunction nMappingMFunc = _polyIRFact.createAffineFunction(_polyFact.createFunction(dimDom, exprFunc));
					
					UseEquation nUseEq = _polyIRFact.createUseEquation(extDomTiled.intersection(listKey.get(k)), useEq.getSubSystem(),
							nMappingMFunc, newInputs, llOutputUeq.get(k));
					lUseEq.add(nUseEq);
				}
				
				// Updates
				for (List<VariableDeclaration> lVarDeclTemp : llOutputUeq)
					_syst.getLocals().addAll(lVarDeclTemp);
				
				_extraStEq.addAll(lStEq);
				
				UseEquation nUseEq0 = lUseEq.get(0); lUseEq.remove(0);
				useEq.setExtensionDomain(nUseEq0.getExtensionDomain());
				useEq.setParameters(nUseEq0.getParameters());
				useEq.getOutputs().clear(); useEq.getOutputs().addAll(nUseEq0.getOutputs());
				useEq.getInputs().clear(); useEq.getInputs().addAll(nUseEq0.getInputs());
				
				_extraUseEq.addAll(lUseEq);
			}
		}
		
		
		// --- Modification of the AST needed ---
		@Override
		public void visitVariableExpression(VariableExpression varExpr) {
			VariableDeclaration varDeclScal = varExpr.getVarDecl();
			String nameBlockedVar = _mapScalBlockVar.get(varDeclScal.getName());
			
			VariableDeclaration varDeclBlocked = null;
			if (varDeclScal.isInput())
				for (VariableDeclaration varDeclIn : _lVarDeclBlInput)
					if (varDeclIn.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclIn;
						break;
					}
			if (varDeclScal.isLocal())
				for (VariableDeclaration varDeclLoc : _lVarDeclBlLocal)
					if (varDeclLoc.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclLoc;
						break;
					}
			if (varDeclScal.isOutput())
				for (VariableDeclaration varDeclOut : _lVarDeclBlOutput)
					if (varDeclOut.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclOut;
						break;
					}
			
			_subExprToBeReplaced = _polyIRFact.createVariableExpression(varDeclBlocked);
			_ratioSubExpr = getRatioVariable(_scaleDimVar, varDeclScal.getName(), varExpr.getExpressionDomain().getNIndices());
			
			/* DEBUG
			System.out.print("Variable " + varDeclScal.getName() + " -> ratio = [");
			for (int i=0; i<_ratioSubExpr.size(); i++)
				System.out.print(_ratioSubExpr.get(i) + " ");
			System.out.println("]");
			//*/
			
		}
		
		@Override
		public void outRestrictExpression(RestrictExpression restExpr) {
			Domain scalRestrDom = restExpr.getRestrictDomain();
			
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = scalRestrDom.getIndexNames();
			for (int i=0; i<scalRestrDom.getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+scalRestrDom.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			FastISLDomain domRestr = CARTOperations.getTiledDomain(scalRestrDom, blockInd, localInd, _listBlockedParam, _listLocalParam, _ratioSubExpr, _blSizeParam,
					_paramDiv, _minblSizeParam, _minParamValues);
			
			_subExprToBeReplaced = _polyIRFact.createRestrictExpression(domRestr, _subExprToBeReplaced);
			// _ratioSubExpr do not change
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void outDependenceExpression(DependenceExpression depExpr) {
			
			// *** Getting the informations on the dependences
			AffineFunction dep = depExpr.getDep();
			Matrix affFuncMat = dep.getPMmapping().toMatrix();
			long[][] paramPart = new long[affFuncMat.getNbRows()][dep.getNParams()];
			long[][] linPart = new long[affFuncMat.getNbRows()][dep.getNIndices()];
			for (int i=0; i<affFuncMat.getNbRows(); i++) {
				MatrixRow matRowi = affFuncMat.getRows().get(i);
				for (int j=0; j<dep.getNParams(); j++)
					paramPart[i][j] = matRowi.get(j);
				for (int j=0; j<dep.getNIndices(); j++)
					linPart[i][j] = matRowi.get(j+dep.getNParams());
			}
			
			
			// *** Determining the ratio of the dependence expression
			List<Integer> ratioSExpr = _ratioSubExpr;
			
			// Parameters conditions: (\forall i j) ratioSExpr(i) | paramPart[i][j]
			for (int i=0; i<ratioSExpr.size(); i++)
				for (int j=0; j<paramPart[0].length; j++)
					if (!divides(ratioSExpr.get(i),(int)paramPart[i][j]))
						throw new RuntimeException("Ratio not compatible (parameters): Fails for dimension " + i + " for the dependence " + dep
								+ " / ratioSExpr = " + ratioSExpr.get(i));
			
			// Getting ratioExpr:
			//	(\forall j) ratioExpr[j] = ppcm_i ( ratioSExpr[i] / gcd(ratioSExpr[i],Q_i,j) )
			List<Integer> ratioExpr = new BasicEList<Integer>();
			if (linPart.length==0) {		// Dependence to nothing (i -> )
				for (int i=0; i<dep.getNIndices(); i++)
					ratioExpr.add(1);
			} else {
				for (int j=0; j<linPart[0].length; j++) {
					int temp = 1;
					for (int i=0; i<linPart.length; i++) {
						int delta = ratioSExpr.get(i) / gcd(ratioSExpr.get(i), (int) linPart[i][j]);
						temp = scm(temp, delta);
					}
					ratioExpr.add(temp);
				}
			}

			/* DEBUG
			System.out.print("Dependence expression" + depExpr.getDep().toString() + "-> ratio = [");
			for (int i=0; i<ratioExpr.size(); i++)
				System.out.print(ratioExpr.get(i) + " ");
			System.out.println("]");
			//*/
			
			
			// *** Applying CART
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = depExpr.getExpressionDomain().getIndexNames();
			for (int i=0; i<depExpr.getExpressionDomain().getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+depExpr.getExpressionDomain().getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			
			Map<FastISLDomain, FastISLMap> mapAffFuncTiled = CARTOperations.getTiledFunction(depExpr.getDep(), blockInd, localInd, _listBlockedParam, _listLocalParam,
					ratioExpr, ratioSExpr, _blSizeParam, _paramDiv, _minblSizeParam);
			
			// *** Creating the new expression
			List<RestrictExpression> lRestrExpr = new BasicEList<RestrictExpression>();
			for (Domain domCond : mapAffFuncTiled.keySet()) {
				if (!domCond.isEmpty()) {
					DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(mapAffFuncTiled.get(domCond), _subExprToBeReplaced.copy());
					lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
				}
			}
			if (lRestrExpr.size()==0) {		// Everything was empty (corner case)
				for (Domain domCond : mapAffFuncTiled.keySet()) {
					DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(mapAffFuncTiled.get(domCond), _subExprToBeReplaced.copy());
					lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					break;
				}
			}
			if (lRestrExpr.size()==1) {		// No need for a case
				_subExprToBeReplaced = lRestrExpr.get(0).getExpr();
			} else {
				_subExprToBeReplaced = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			_ratioSubExpr = ratioExpr;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void outReduceExpression(ReduceExpression redExpr) {
			OP operator = redExpr.getOP();
			AffineFunction projFunc = redExpr.getProjection();
			
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = projFunc.getIndexNames();
			for (int i=0; i<projFunc.getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+projFunc.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			// Aspect ratio of a reduction expression can be set to "Id"
			List<Integer> scaleIm = new BasicEList<Integer>();
			for (int i=0; i<redExpr.getProjection().getDimRHS(); i++)
				scaleIm.add(1);
			Map<FastISLDomain, FastISLMap> projFuncTiled = CARTOperations.getTiledFunction(projFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
					_ratioSubExpr, scaleIm, _blSizeParam, _paramDiv, _minblSizeParam);
			
			
			// Build D_univ, the universe of Im(\pi)
			/* TODO: cf fix below...
			long[][] blockedConstr = new long[2*projFunc.getDimRHS()][3+_listBlLocParam.size()+2*projFunc.getDimRHS()];
			for (int i=0; i<projFunc.getDimRHS(); i++) {
				blockedConstr[i][0] = 1;
				blockedConstr[i][1+_listBlLocParam.size()+blockInd.size()+i] = 1;
			}
			for (int i=0; i<projFunc.getDimRHS(); i++) {
				blockedConstr[i+projFunc.getDimRHS()][0] = 1;
				blockedConstr[i+projFunc.getDimRHS()][1+_listBlLocParam.size()] = _ratioSubExpr.get(i);
				blockedConstr[i+projFunc.getDimRHS()][1+_listBlLocParam.size()+blockInd.size()+i] = -1;
				blockedConstr[i+projFunc.getDimRHS()][blockedConstr[0].length-1] = -1;
			}
			Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
			//*/
			
			// We build the new expression:
			// case
			//		red(op, \pi_1, D1: Expr)
			//		(D_univ - \pi_1(D1)): 0
			// esac + case
			//		red(op, \pi_2, D2: Expr)
			//		(D_univ - \pi_2(D2)): 0
			// esac + ...
			// ... + case
			//		red(op, \pi_n, Dn:Expr)
			//		(D_univ - \pi_n(Dn)): 0
			// esac
			List<Expression> lRedExpr = new BasicEList<Expression>();		// List of the "red(op, \pi_i, Di: Expr)"
			for (Domain restrDom : projFuncTiled.keySet()) {
				if (!restrDom.isEmpty()) {
					
					/*  CURRENT FIX => DO NOT WORK BECAUSE OF INTERSECTIOn
					List<Expression> lTempExpr = new BasicEList<Expression>();
					lTempExpr.add(_polyIRFact.createReduceExpression(operator, projFuncTiled.get(restrDom),
							_polyIRFact.createRestrictExpression(restrDom, _subExprToBeReplaced.copy()) ));
					
					Domain tempDom = restrDom.image(projFuncTiled.get(restrDom));
					IntConstraintSystem tempSyst = blockedConstrMat.toDomain(tempDom.getParams(), tempDom.getIndices());
					Domain univDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(
							_polyFact.createDomain(tempDom.getPMdomain().getDimensions().copy(), tempSyst.copy()));
					Domain restrictDomain = univDom.difference(tempDom);
					
					// TODO DEBUG
					System.out.println(univDom.toString());
					System.out.println(tempDom.toString());
					System.out.println(restrictDomain.toString());
					System.out.println();
					// TODO: bug ISL for the difference... :/
					// TODO: spaces do not match... :/
					
					
					lTempExpr.add(_polyIRFact.createRestrictExpression(restrictDomain,
							_polyIRFact.createIntegerExpression(0) ));
					Expression cRedExpr = _polyIRFact.createCaseExpression(lTempExpr);
					lRedExpr.add(cRedExpr);
					//*/
					
					//* OLD CODE WARNING / TODO: bug if one reduction is empty (cf fix on top)
					lRedExpr.add(_polyIRFact.createReduceExpression(operator, projFuncTiled.get(restrDom),
							_polyIRFact.createRestrictExpression(restrDom, _subExprToBeReplaced.copy()) ));
					//*/
					
					// TODO: Matrix mult => need to add
					// Cholesky => case needed
					// Both combination => might consider dimensions per dimensions? (to avoid doing the difference)
				}
			}
			Expression returnedExpr = lRedExpr.get(0);
			for (int i=1; i<lRedExpr.size(); i++)
				returnedExpr = _polyIRFact.createBinaryExpression(operator, returnedExpr, lRedExpr.get(i));
			
			// Update request for the top
			_subExprToBeReplaced = returnedExpr;
			_ratioSubExpr = scaleIm;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void outIndexExpression(IndexExpression iexpr) {
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = iexpr.getExpressionDomain().getIndexNames();
			for (int i=0; i<iexpr.getExpressionDomain().getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+iexpr.getExpressionDomain().getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			List<Integer> scale = new BasicEList<Integer>();						// Scale: assuming it is identity
			for (int i=0; i<iexpr.getFunction().getNIndices(); i++)
				scale.add(1);
			List<Integer> scaleIm = new BasicEList<Integer>();						// ScaleIm: assuming it is identity
			for (int i=0; i< iexpr.getFunction().getDimRHS(); i++)
				scaleIm.add(1);
			Map<FastISLDomain, FastISLMap> mapAffFuncTiled = CARTOperations.getTiledFunction(iexpr.getFunction(), blockInd, localInd, _listBlockedParam, _listLocalParam,
					scale, scaleIm, _blSizeParam, _paramDiv, _minblSizeParam);
			
			// *** Creating the new expression
			List<Expression> lRestrExpr = new BasicEList<Expression>();
			for (Domain domCond : mapAffFuncTiled.keySet()) {
				// "affFuncIndTiled" contains "\alpha, ii".
				//		=> We need to transform this expression into "\alpha.b+ii"
				AffineFunction affFuncIndTiled = mapAffFuncTiled.get(domCond);
				
				List<AffineExpression> lexprAffFuncBl = new BasicEList<AffineExpression>();
				lexprAffFuncBl.add(affFuncIndTiled.getExpressions().get(0));
				AffineFunction affFuncIndBlock = _polyIRFact.createAffineFunction(affFuncIndTiled.getParams(),
						affFuncIndTiled.getIndices(), lexprAffFuncBl);
				IndexExpression subcaseIndexExprBl = _polyIRFact.createIndexExpression(affFuncIndBlock);
				
				List<AffineExpression> lexprAffFuncLoc = new BasicEList<AffineExpression>();
				lexprAffFuncLoc.add(affFuncIndTiled.getExpressions().get(1));
				AffineFunction affFuncIndLocal =  _polyIRFact.createAffineFunction(affFuncIndTiled.getParams(),
						affFuncIndTiled.getIndices(), lexprAffFuncLoc);
				IndexExpression subcaseIndexExprLoc = _polyIRFact.createIndexExpression(affFuncIndLocal);
				
				List<AffineExpression> lexprAffFuncbSize = new BasicEList<AffineExpression>();
				lexprAffFuncbSize.add(IntExpressionBuilder.affine(_blSizeParam));
				AffineFunction affFuncIndbSize =  _polyIRFact.createAffineFunction(affFuncIndTiled.getParams(),
						affFuncIndTiled.getIndices(), lexprAffFuncbSize);
				IndexExpression subcaseIndexExprbSize = _polyIRFact.createIndexExpression(affFuncIndbSize);
				
				// Forming the expression "scIndExpBl * scIndExpbSize + scIndExpLoc"
				BinaryExpression subcaseBinMult = _polyIRFact.createBinaryExpression(OP.MUL, subcaseIndexExprBl, subcaseIndexExprbSize);
				BinaryExpression subcaseIndexExpr = _polyIRFact.createBinaryExpression(OP.ADD, subcaseBinMult, subcaseIndexExprLoc);
				
				lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseIndexExpr));
			}
			_subExprToBeReplaced = _polyIRFact.createCaseExpression(lRestrExpr);
		}
		
		// --- Simple propagation, with aspect-ratio management ---
		@Override
		public void visitCaseExpression(CaseExpression cexpr) {
			inCaseExpression(cexpr);
			
			// Getting the subexpressions
			List<Expression> lSubExpr = new BasicEList<Expression>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : cexpr.getExprs()) {
				expr.accept(this);
				
				/* DEBUG
				System.out.println(PolyhedralIRToAlphabets.toString(_subExprToBeReplaced));
				System.out.println();
				System.out.println();
				//*/
				
				lSubExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			/* DEBUG
			System.out.println("*** CASE -> lratio = [[[");
			for (int i=0; i<lratio.size(); i++) {
				System.out.print("           [ ");
				for (int j=0; j<lratio.get(i).size(); j++)
					System.out.print(lratio.get(i).get(j) + " ");
				System.out.println("]");
				
			}
			System.out.println("]]]]");
			//*/
			
			
			// Determining the new aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp,lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			// Managing the translation
			List<Expression> lnExpr = new BasicEList<Expression>();
			for (int i=0; i<lSubExpr.size(); i++) {
				Expression sExpr = lSubExpr.get(i);
				List<Integer> ratioSExpr = lratio.get(i);
				
				// Is the aspect ratio the same?
				boolean isRatioSame = true;
				for (int k=0; k<nratio.size(); k++)
					if (nratio.get(k)!=ratioSExpr.get(k))
						isRatioSame = false;
				
				if (isRatioSame)
					lnExpr.add(sExpr);
				else {
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					List<Variable> blockInd = new BasicEList<Variable>();
					List<Variable> localInd = new BasicEList<Variable>();
					List<String> lIndNames = cexpr.getExpressionDomain().getIndexNames();
					for (int j=0; j<cexpr.getExpressionDomain().getNIndices(); j++) {
						blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
						localInd.add(_dimMana.getDimension(j+cexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
					}
					AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(cexpr.getExpressionDomain());
					
					Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
							nratio, ratioSExpr, _blSizeParam, _paramDiv, _minblSizeParam);
					
					// We build the case expression resulting from CARTing the Id Function
					List<Expression> lRestrExpr = new BasicEList<Expression>();
					for (Domain domCond : idCart.keySet()) {
						if (!domCond.isEmpty()) {
							DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), sExpr.copy());
							lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
						}
					}
					if (lRestrExpr.size()==0) {	// Border case if everything was empty
						for (Domain domCond : idCart.keySet()) {
							DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), sExpr.copy());
							lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
							break;
						}
					}
					lnExpr.add(_polyIRFact.createCaseExpression(lRestrExpr));
				}
			}
			
			outCaseExpression(cexpr);
			_subExprToBeReplaced = _polyIRFact.createCaseExpression(lnExpr);
			_ratioSubExpr = nratio;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void visitIfExpression(IfExpression iexpr) {
			inIfExpression(iexpr);
			
			iexpr.getCond().accept(this);
			Expression condExpr = _subExprToBeReplaced;
			List<Integer> ratioCond = _ratioSubExpr;
			
			iexpr.getThen().accept(this);
			Expression thenExpr = _subExprToBeReplaced;
			List<Integer> ratioThen = _ratioSubExpr;
			
			iexpr.getElse().accept(this);
			Expression elseExpr = _subExprToBeReplaced;
			List<Integer> ratioElse = _ratioSubExpr;
			
			outIfExpression(iexpr);
			
			// Getting the new ratio for this expression
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<ratioCond.size(); i++)
				nratio.add(scm(scm(ratioCond.get(i), ratioThen.get(i)),ratioElse.get(i)));
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = iexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<iexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+iexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(iexpr.getExpressionDomain());
			
			// (i) Cond expression
			Expression nCondExpr;
			
			boolean isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioCond.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nCondExpr = condExpr;
			else {
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioCond, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), condExpr.copy());
					lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
				}
				nCondExpr = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			// (ii) Then expression
			Expression nThenExpr;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioThen.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nThenExpr = thenExpr;
			else {
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioThen, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), thenExpr.copy());
					lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
				}
				nThenExpr = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			// (iii) Else expression
			Expression nElseExpr;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioElse.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nElseExpr = elseExpr;
			else {
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioElse, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), elseExpr.copy());
					lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
				}
				nElseExpr = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			// Propagation
			_subExprToBeReplaced = _polyIRFact.createIfExpression(nCondExpr, nThenExpr, nElseExpr);
			_ratioSubExpr = nratio;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void outUnaryExpression(UnaryExpression u) {
			_subExprToBeReplaced = _polyIRFact.createUnaryExpression(u.getOperator(), _subExprToBeReplaced);
			// No change for _ratioSubExpr
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression bexpr) {
			inBinaryExpression(bexpr);
			
			bexpr.getLexp().accept(this);
			Expression lExpr = _subExprToBeReplaced;
			List<Integer> ratioLExpr = _ratioSubExpr;
			
			bexpr.getRexp().accept(this);
			Expression rExpr = _subExprToBeReplaced;
			List<Integer> ratioRExpr = _ratioSubExpr;
			
			outBinaryExpression(bexpr);
			
			// Getting the new aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<ratioLExpr.size(); i++)
				nratio.add(scm(ratioLExpr.get(i),ratioRExpr.get(i)));
			
			/* DEBUG
			System.out.println("RatioBinExpression (op: " + bexpr.getOperator().toString() + ")");
			System.out.print("    - LeftExpr : [ ");
			for (int k : ratioLExpr)
				System.out.print(k + " ");
			System.out.println("]");
			System.out.print("    - RightExpr : [ ");
			for (int k : ratioRExpr)
				System.out.print(k + " ");
			System.out.println("]");
			System.out.print("    -> nRatio : [ ");
			for (int k : nratio)
				System.out.print(k + " ");
			System.out.println("]");
			//*/
			
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = bexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<bexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+bexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(bexpr.getExpressionDomain());
			
			
			// (i) Left expression
			Expression nlExpr;
			
			boolean isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioLExpr.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nlExpr = lExpr;
			else {
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioLExpr, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					if (!domCond.isEmpty()) {
						DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), lExpr.copy());
						lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					}
				}
				nlExpr = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			// (ii) Right expression
			Expression nrExpr;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioRExpr.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nrExpr = rExpr;
			else {
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioRExpr, _blSizeParam, _paramDiv, _minblSizeParam);
				
				// We build the case expression resulting from CARTing the Id Function
				List<Expression> lRestrExpr = new BasicEList<Expression>();
				for (Domain domCond : idCart.keySet()) {
					if (!domCond.isEmpty()) {
						DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), rExpr.copy());
						lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					}
				}
				nrExpr = _polyIRFact.createCaseExpression(lRestrExpr);
			}
			
			// Propagation
			_subExprToBeReplaced = _polyIRFact.createBinaryExpression(bexpr.getOperator(), nlExpr, nrExpr);
			_ratioSubExpr = nratio;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression mexpr) {
			inMultiArgExpression(mexpr);
			
			List<Expression> lnExpr = new BasicEList<Expression>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : mexpr.getExprs()) {
				expr.accept(this);
				lnExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			outMultiArgExpression(mexpr);
			
			// New aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp, lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = mexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<mexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+mexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(mexpr.getExpressionDomain());
			
			List<Expression> lnnExpr = new BasicEList<Expression>();
			for (int k=0; k<lnExpr.size(); k++) {
				Expression expr = lnExpr.get(k);
				List<Integer> ratioExpr = lratio.get(k);
				Expression nExpr;
				
				boolean isRatioSame = true;
				for (int l=0; l<nratio.size(); l++)
					if (nratio.get(l)!=ratioExpr.get(l))
						isRatioSame = false;
				if (isRatioSame)
					nExpr = expr;
				else {
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
							nratio, ratioExpr, _blSizeParam, _paramDiv, _minblSizeParam);
					
					// We build the case expression resulting from CARTing the Id Function
					List<Expression> lRestrExpr = new BasicEList<Expression>();
					for (Domain domCond : idCart.keySet()) {
						DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), expr.copy());
						lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					}
					nExpr = _polyIRFact.createCaseExpression(lRestrExpr);
				}
				
				lnnExpr.add(nExpr);
			}
			
			_subExprToBeReplaced = _polyIRFact.createMultiArgExpression(mexpr.getOperator(), lnnExpr);
			_ratioSubExpr = nratio;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall eExpr) {
			inExternalFunctionCall(eExpr);
			
			List<Expression> lnExpr = new BasicEList<Expression>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : eExpr.getExprs()) {
				expr.accept(this);
				lnExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			outExternalFunctionCall(eExpr);
			
			// New aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp, lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			/* DEBUG
			System.out.print("External Function -> ratio = [");
			for (int i=0; i<nratio.size(); i++)
				System.out.print(nratio.get(i) + " ");
			System.out.println("]");
			//*/
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = eExpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<eExpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+eExpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(eExpr.getExpressionDomain());
			
			List<Expression> lnnExpr = new BasicEList<Expression>();
			for (int k=0; k<lnExpr.size(); k++) {
				Expression expr = lnExpr.get(k);
				List<Integer> ratioExpr = lratio.get(k);
				Expression nExpr;
				
				boolean isRatioSame = true;
				for (int l=0; l<nratio.size(); l++)
					if (nratio.get(l)!=ratioExpr.get(l))
						isRatioSame = false;
				if (isRatioSame)
					nExpr = expr;
				else {
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					Map<FastISLDomain, FastISLMap> idCart = CARTOperations.getTiledFunction(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
							nratio, ratioExpr, _blSizeParam, _paramDiv, _minblSizeParam);
					
					// We build the case expression resulting from CARTing the Id Function
					List<Expression> lRestrExpr = new BasicEList<Expression>();
					for (Domain domCond : idCart.keySet()) {
						DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(idCart.get(domCond), expr.copy());
						lRestrExpr.add(_polyIRFact.createRestrictExpression(domCond, subcaseDepExpr));
					}
					nExpr = _polyIRFact.createCaseExpression(lRestrExpr);
				}
				
				lnnExpr.add(nExpr);
			}
			
			_subExprToBeReplaced = _polyIRFact.createExternalFunctionCall(eExpr.getExFunc(), lnnExpr);
			_ratioSubExpr = nratio;
			
			// Local normalization
			_subExprToBeReplaced = NormalizeExpression.normalizeExpression(_subExprToBeReplaced);
			
		}
		
		@Override
		public void outBooleanExpression(BooleanExpression b) {
			List<Integer> ratio = new BasicEList<Integer>();
			for (int i=0; i<b.getExpressionDomain().getNIndices();i++)
				ratio.add(1);
			
			_subExprToBeReplaced = b.copy();
			_ratioSubExpr = ratio;
		}
		
		@Override
		public void outIntegerExpression(IntegerExpression i) {
			List<Integer> ratio = new BasicEList<Integer>();
			for (int k=0; k<i.getExpressionDomain().getNIndices();k++)
				ratio.add(1);
			
			_subExprToBeReplaced = i.copy();
			_ratioSubExpr = ratio;
		}
		
		@Override
		public void outRealExpression(RealExpression r) {
			List<Integer> ratio = new BasicEList<Integer>();
			for (int k=0; k<r.getExpressionDomain().getNIndices();k++)
				ratio.add(1);
			
			_subExprToBeReplaced = r.copy();
			_ratioSubExpr = ratio;
		}
		
	} // ParametricTilingVisitor_NoOutlining
	
	private static class ParametricTilingVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		/* The modifications done by this visitor are the following:
		- We are placing the dependences at the bottom of the expressions (at the level of variables) and "Id@" at
		- VariableDeclaration: change the name of the variable (by adding suffixBlocked at the end of the name),
				and get the "blocked definition domain" of the variable
		- DependenceExpression: block the affine function, and create a "map"
		- Inside the Expressions:
		    * We add a dummy dep "Id@A" in front of every occurrence of input variable "A", to make the aspect ration of "Id@A" the identity,
		        then we tile it (using the "DependenceExpression" rule)
			* The domains of RestrictExpression are replaced by their blocked counter-part
			* "DependenceExpression" are managed in the following way:
				+ A case is introduced, in which the subcase are RestrictExpression (corresponding to the different parts of the piecewise blocked dependence function)
				+ The expressions itself is copied, with the different values of the dependence for every parts
			* "ReductionExpression" are managed in the following way:
				+ We introduce a sum of reduction (with the reduction operator between), where each reduction correspond to a part of the piecewise blocked projection function
				+ The reduction expression is duplicated and has a restriction in front of it, corresponding to the conditions from the piecewise function.
		*/
		
		
		private String suffixBlParam = "b";						// Suffix for blocked parameter
		private String suffixLocParam = "l";					// Suffix for local parameter
		private String suffixBlInd = "Bl";						// Suffix for blocked index
		private String suffixLocInd = "Loc";					// Suffix for local index
		private String suffixTempUseEqOutputVar = "_blTemp";	// Suffix for the temporary output that might be introduced by the transformation on useEquation
		
		private String suffixNameTempRed = "_TempRed";			// Suffix for the temporary variables introduced for reductions
		private int counterNameTempRed = 0;						// To have different names
		
		// RESTRICTION:
		//	- For now, we assume only one blocked parameter "_blSizeParam"
		//	- The aspect ratio of expressions is the smallest one possible which does not introduce modulo
		//	- We assume that the user give an aspect ratio for each variable. If no aspect ratio is given, we take "Id"
		//	- The aspect ratio of parameters is "Id" for now...
		
		private AffineSystem _syst;												// Considered affine system
		private Variable _blSizeParam;											// blockSizeParameter
		private Map<String,String> _mapScalBlockVar;							// Mapping for variables
		private Map<Variable, Map<Variable,Variable> > _mapScalBlockLocParam;	// Mapping for parameters
		private EList<Variable> _listBlockedParam;								// List of the blocked parameters
		private EList<Variable> _listLocalParam;								// List of the local parameters
		private EList<Variable> _listBlLocParam;								// List of blocked then local parameters
		private EList<Variable> _listLocalBlSizeParam;							// List of local variables + block size param
		private ParameterDomain _blockedParamDom;								// ParameterDomain of the blocked system
		private Map<String,List<Integer>> _scaleDimVar;							// Indicate if a given dimension of a variable has a scale
		private boolean _paramDiv;												// Do we assume that the parameters are divisible?
		private int _minblSizeParam;											// Minimum value allowed for the variable _blSizeParam
		private List<Integer> _minParamValues;									// Minimum values allowed for the blocked paraneters
		
		private List<Integer> _ratioSubExpr;									// Ratio of the expression we just have visited
		private List<Triplet<FastISLDomain,FastISLDomain,
					Expression>> _subExprToBeReplaced;							// Expression replacing the expression we just have visited (not a leaf)
																				//			=> the Pair is composed of 2 Domain: on the blocked indexes and on the local indexes
		private Expression _subExprToBeReplaced_Leaf;							// Expression replacing the expression-leaf we just have visited
		
		private List<StandardEquation> _extraStEq;								// Standard Equations to be added (cf CART of useEquations/reductions)
		private List<UseEquation> _extraUseEq;									// Use Equations to be added (cf CART of useEquations)
		
		
		private List<VariableDeclaration> _lVarDeclBlInput;
		private List<VariableDeclaration> _lVarDeclBlOutput;
		private List<VariableDeclaration> _lVarDeclBlLocal;
		
		private List<Map<String,AffineFunction>> _alignmentInfo;				// Alignment info of the variable/partitioning into tiles
																				// If "null", then do not care about this (no outlining afterward)
		public List<List<String>> _nAlignmentInfo;
		public Map<String,Pair<FastISLMap,String>> _alignmentRedInfo = new HashMap<String, Pair<FastISLMap,String>>();
					// _alignmentRedInfo: for each "TempRed" variable, gives:
					//		- the projection function
					//		- the "father" variable (variable in which equation originate "tempRed"
		
 		public ParametricTilingVisitor(AffineSystem syst, Variable blSizeParam, Map<String,List<Integer>> scaleInputs, boolean paramDiv, int minB,
 				List<Integer> minParamValue, List<Map<String,AffineFunction>> alignmentInfo) {
 			this._syst = syst;
 			this._blSizeParam = blSizeParam;
			this._mapScalBlockVar = new HashMap<String, String>();
			this._mapScalBlockLocParam = new HashMap<Variable, Map<Variable,Variable> >();
			this._listBlockedParam = new BasicEList<Variable>();
			this._listLocalParam = new BasicEList<Variable>();
			this._listBlLocParam = new BasicEList<Variable>();
			this._listLocalBlSizeParam = new BasicEList<Variable>();
			this._scaleDimVar = scaleInputs;
			this._paramDiv = paramDiv;
			this._minblSizeParam = minB;
			this._minParamValues = minParamValue;
			
			this._extraStEq = new BasicEList<StandardEquation>();
			this._extraUseEq = new BasicEList<UseEquation>();
			
			this._lVarDeclBlInput = new BasicEList<VariableDeclaration>();
			this._lVarDeclBlOutput = new BasicEList<VariableDeclaration>();
			this._lVarDeclBlLocal = new BasicEList<VariableDeclaration>();
			
			this._alignmentInfo = alignmentInfo;
			this._nAlignmentInfo = new BasicEList<List<String>>();
			if (_alignmentInfo!=null)
				for (int k=0; k<_alignmentInfo.size(); k++)
					_nAlignmentInfo.add(new BasicEList<String>());
			
		}
 		
 		
 		// --- Non-equational modifications ---
		@Override
		public void outAffineSystem(AffineSystem s) {
			s.getEquations().addAll(_extraStEq);
			s.getUseEquations().addAll(_extraUseEq);
			
			s.getInputs().clear(); s.getInputs().addAll(_lVarDeclBlInput);
			s.getOutputs().clear(); s.getOutputs().addAll(_lVarDeclBlOutput);
			s.getLocals().clear(); s.getLocals().addAll(_lVarDeclBlLocal);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outAffineSystem !!!!!!!!!!!!!!!!!!!!!!");
		}
 		
 		@Override
		public void visitParameterDomain(ParameterDomain p) {
			List<Variable> scalParams = p.getParams();
			
			// === Creation of the blocked/local parameters
			for (int i=0; i<scalParams.size(); i++) {
				String blockParamName = scalParams.get(i).getName() + suffixBlParam;
				Variable blParam = _dimMana.getParameter(i, blockParamName);
				_listBlockedParam.add(blParam);
				
				String locParamName = scalParams.get(i).getName() + suffixLocParam;
				Variable locParam = _dimMana.getParameter(i+scalParams.size(), locParamName);
				_listLocalParam.add(locParam);
				_listLocalBlSizeParam.add(locParam);
				
				Map<Variable,Variable> pairParam = new HashMap<Variable,Variable>();
				pairParam.put(blParam, locParam);
				_mapScalBlockLocParam.put(scalParams.get(i), pairParam);
			}
			_listBlLocParam.addAll(_listBlockedParam);
			_listBlLocParam.addAll(_listLocalParam);
			_listBlLocParam.add(_blSizeParam);
			_listLocalBlSizeParam.add(_blSizeParam);
			
			// === Transforming the constraints on the parameters
			_blockedParamDom = CARTOperations.getTiledParameterDomain(p, _listBlockedParam, _listLocalParam, _blSizeParam, _paramDiv,
					_minblSizeParam, _minParamValues);
			_syst.setParameters(_blockedParamDom);
			
		}
		
		@Override
		public void visitVariableDeclaration(VariableDeclaration varDecl) {
			String nameVar = varDecl.getName();
			Domain domVar = varDecl.getDomain();
			
			// Creating the new name
			String nameVarBlocked = nameVar + suffixBlVar;
			_mapScalBlockVar.put(nameVar, nameVarBlocked);
			
			// Creating the new indexes
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			for (int i=0; i<domVar.getIndices().size(); i++) {
				Variable ind = domVar.getIndices().get(i);
				String blockIndName = ind.getName() + suffixBlInd;
				blockInd.add(_dimMana.getDimension(i, blockIndName));
				
				String localIndName = ind.getName() + suffixLocInd;
				localInd.add(_dimMana.getDimension(i+domVar.getIndices().size(), localIndName));
			}
			
			// Getting the aspect-ratio
			List<Integer> ratio = getRatioVariable(_scaleDimVar, nameVar, domVar.getNIndices());
			
			// Computing the new domain and creating the variable declaration
			FastISLDomain domVarBlocked = CARTOperations.getTiledDomain(domVar, blockInd, localInd, _listBlockedParam, _listLocalParam, ratio, _blSizeParam,
					_paramDiv, _minblSizeParam, _minParamValues);
			//domVarBlocked.simplify();
			
			// Add the parameter constraints
			FastISLDomain paramDomExt = _polyIRFact.createFastISLDomain(_blockedParamDom.copy().getPMdomain());
			for (int i=0; i<domVarBlocked.getNIndices(); i++)
				paramDomExt.addDimension(domVarBlocked.getIndexNames().get(i));
			FastISLDomain domVarBlockedParam = (FastISLDomain) domVarBlocked.intersection(paramDomExt);
			domVarBlockedParam.simplify();
			
			VariableDeclaration varDeclBl = _polyIRFact.createVariableDeclaration(nameVarBlocked, varDecl.getType(), domVarBlockedParam);
			
			// Update of the system with the new variable declaration
			if (_syst.isInput(varDecl)) {
				_lVarDeclBlInput.add(varDeclBl);
			}
			if (_syst.isLocal(varDecl)) {
				_lVarDeclBlLocal.add(varDeclBl);
			}
			if (_syst.isOutput(varDecl)) {
				_lVarDeclBlOutput.add(varDeclBl);
			}
		}
		
		@Override
		public void outStandardEquation(StandardEquation stEq) {
			String nameVarEq = stEq.getVariable().getName();
			Domain domVar = stEq.getVariable().getDomain();
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outStandardEquation (Eq: " + nameVarEq + ")");
			
			
			// Getting the aspect ratio
			List<Integer> ratioVar = getRatioVariable(_scaleDimVar, stEq.getVariable().getName(), stEq.getVariable().getDomain().getNIndices());
			List<Integer> ratioSubExpr = _ratioSubExpr;
			assert(ratioVar.size()==ratioSubExpr.size());
			
			/* DEBUG
			System.out.println("DEBUG:");
			System.out.print("	- RatioVar = [");
			for (int i=0; i<ratioVar.size(); i++)
				System.out.print(ratioVar.get(i) + " ");
			System.out.println("]");

			System.out.print("	- RatioSubExpr = [");
			for (int i=0; i<ratioSubExpr.size(); i++)
				System.out.print(ratioSubExpr.get(i) + " ");
			System.out.println("]");
			//*/
			
			
			boolean isRatioEqual = true;
			for (int i=0; i<ratioVar.size(); i++)
				if (ratioVar.get(i)!=ratioSubExpr.get(i))
					isRatioEqual = false;
			
			
			// Updating the Standard Equation
			String nameBlockVar = _mapScalBlockVar.get(nameVarEq);
			VariableDeclaration varDeclBlocked = null;
			if (stEq.getVariable().isLocal())
				for (VariableDeclaration varDeclLoc : _lVarDeclBlLocal)
					if (varDeclLoc.getName()==nameBlockVar) {
						varDeclBlocked = varDeclLoc;
						break;
					}
			if (stEq.getVariable().isOutput())
				for (VariableDeclaration varDeclOut : _lVarDeclBlOutput)
					if (varDeclOut.getName()==nameBlockVar) {
						varDeclBlocked = varDeclOut;
						break;
					}
			stEq.setVariable(varDeclBlocked);
			
			
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = domVar.getIndexNames();
			for (int i=0; i<domVar.getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+domVar.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> lexprEquationInfo;
			if (isRatioEqual)			// If the ratio are the same => no problem
				lexprEquationInfo = _subExprToBeReplaced;
			else {						// If the ratio are different, we need to introduce a Id function
				
				// Modulo condition here?
				for (int i=0; i<ratioVar.size(); i++)
					if (!divides(ratioSubExpr.get(i), ratioVar.get(i)))
						throw new RuntimeException("Ratio not compatible: Fails for dimension " + i + " in the equation " + nameVarEq
								+ " / ratioExpr = " + ratioSubExpr.get(i) + " and ratioVar = " + ratioVar.get(i));
				
				// No modulo => we CART the Id function
				
				AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(stEq.getVariable().getDomain());
				
				
				lexprEquationInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd,
						_listBlockedParam, _listLocalParam,
						ratioVar, ratioSubExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tSubExpr : _subExprToBeReplaced) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart,tSubExpr);
						if (!tRes.getValue1().isEmpty())
							lexprEquationInfo.add(tRes);
					}
			}
			
			
			// Intersecting with the domain of nameVarEq
			List<Pair<FastISLDomain,FastISLDomain>> lpDomBlLocVar = CARTOperations.getTiledDomainSplit(domVar, blockInd, localInd, _listBlockedParam,
					_listLocalParam, ratioVar, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> lexprEquInfoVar = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,Expression> tInfo : lexprEquationInfo)
				for (Pair<FastISLDomain,FastISLDomain> pDomVar : lpDomBlLocVar) {
					FastISLDomain interDomBl = (FastISLDomain) tInfo.getValue0().intersection(pDomVar.getValue0());
					
					if (!interDomBl.isEmpty()) {
						FastISLDomain interDomLoc = (FastISLDomain) tInfo.getValue1().intersection(pDomVar.getValue1());
						
						if (!interDomLoc.isEmpty())
							lexprEquInfoVar.add(Triplet.with(interDomBl, interDomLoc, tInfo.getValue2()));
					}
				}
			
			// Tracking
			if (_noisyTracking)
				System.out.println("	* outStandardEquation  - Coalesced Block start");
			

			/* DEBUG
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Equation - lexprEquationInfo");
			for (Triplet<Domain,Domain,Expression> tBlLocSExpr : lexprEquationInfo)
				System.out.println("	* " + tBlLocSExpr.getValue0().toString() + "  " + tBlLocSExpr.getValue1().toString() +
						"\n				" + PolyhedralIRToAlphabets.toString(tBlLocSExpr.getValue2()));
			//*/
			
			List<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>> lexprEquationNestedInfo = coalescedBlocks(lexprEquInfoVar);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("	* outStandardEquation  - Coalesced Block end");
			
			/* DEBUG
			System.out.println("\n\nCoalesced Blocks:");
			for (Pair<Domain,List<Pair<Domain,Expression>>> pTemp1 : lexprEquationNestedInfo) {
				System.out.println(" * " + pTemp1.getValue0().toString());
				for (Pair<Domain,Expression> pTemp2 : pTemp1.getValue1())
					System.out.println("		- " + pTemp2.getValue0().toString() + "  " + PolyhedralIRToAlphabets.toString(pTemp2.getValue1()));
			}
			System.out.println("\n\nDone.");
			//*/
			EList<Variable> lIndFull = new BasicEList<Variable>();
			lIndFull.addAll(blockInd); lIndFull.addAll(localInd);
			
			List<Expression> lRestrExpr = new BasicEList<Expression>();
			for (Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>> pdomBllpDomLocExpr : lexprEquationNestedInfo) {
				List<Expression> lRestrSubExpr = new BasicEList<Expression>();
				for (Pair<FastISLDomain,Expression> pDomLocExpr : pdomBllpDomLocExpr.getValue1()) {
					FastISLDomain domBlTrans = translateToFullDimension(pDomLocExpr.getValue0(), _listBlLocParam, lIndFull, false);
					lRestrSubExpr.add(_polyIRFact.createRestrictExpression(domBlTrans, pDomLocExpr.getValue1().copy()));
				}
				FastISLDomain domLocTrans = translateToFullDimension(pdomBllpDomLocExpr.getValue0(), _listBlLocParam, lIndFull, true);
				lRestrExpr.add(_polyIRFact.createRestrictExpression(domLocTrans, _polyIRFact.createCaseExpression(lRestrSubExpr)));
			}
			stEq.setExpression(_polyIRFact.createCaseExpression(lRestrExpr));
			
			
			// Update _nAlignmentInfo
			if (_alignmentInfo!=null)
			for (int k=0; k<_alignmentInfo.size(); k++) {
				if (_alignmentInfo.get(k).containsKey(nameVarEq)) {
					_nAlignmentInfo.get(k).add(nameBlockVar);
					break;
				}
			}
		}
		
		@Override
		public void visitUseEquation(UseEquation useEq) {
			throw new UnsupportedOperationException("Outlining-CARTing use equation is not supported yet");
			
			// TODO: lower dependences transformation to do !!!
			/*
			
			// *** Extension domain ***
			Domain extDomScal = useEq.getExtensionDomain();
			List<Variable> blockIndDom = new BasicEList<Variable>();
			List<Variable> localIndDom = new BasicEList<Variable>();
			List<String> lIndNames = extDomScal.getIndexNames();
			for (int i=0; i<extDomScal.getNIndices(); i++) {
				blockIndDom.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localIndDom.add(_dimMana.getDimension(i+extDomScal.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			List<Integer> scaleDom = new BasicEList<Integer>();
			for (int i=0; i<extDomScal.getNIndices(); i++)
				scaleDom.add(1);
			Domain extDomTiled = CARTOperations.getTiledDomain(extDomScal, blockIndDom, localIndDom,
					_listBlockedParam, _listLocalParam, scaleDom, _blSizeParam, _paramDiv, _minblSizeParam);
			
			
			// *** Input expression ***
			List<Expression> newInputs = new BasicEList<Expression>();
			for (Expression exprInput : useEq.getInputs()) {
				visitExpression(exprInput);
				newInputs.add(_subExprToBeReplaced);
			}
			
			
			// *** Output variables ***
			List<VariableDeclaration> newOutputs = new BasicEList<VariableDeclaration>();
			for (VariableDeclaration varOut : useEq.getOutputs())
				newOutputs.add(_syst.getVariableDeclaration(_mapScalBlockVar.get(varOut.getName())));
			
			
			// *** Parameter expression ***
			AffineFunction funcParam = useEq.getParameters();
			List<Integer> scaleFuncAnt = new BasicEList<Integer>();
			for (int i=0; i<funcParam.getNIndices(); i++)
				scaleFuncAnt.add(1);
			List<Integer> scaleFunIm = new BasicEList<Integer>();
			for (int i=0; i<funcParam.getDimRHS(); i++)
				scaleFunIm.add(1);
			Map<Domain,AffineFunction> mfunc = CARTOperations.getTiledFunction(funcParam, blockIndDom, localIndDom, _listBlockedParam, _listLocalParam,
					scaleFuncAnt, scaleFunIm, _blSizeParam, _paramDiv, _minblSizeParam);
			
			if (mfunc.size()==1) {			// Only one case for the parameter domain
				useEq.setExtensionDomain(extDomTiled);
				for (Domain dom : mfunc.keySet()) {
					AffineFunction mappingMFunc = mfunc.get(dom);
					
					Matrix matMapping = mappingMFunc.getPMmapping().toMatrix();
					long[][] longMatMapping = matMapping.toLongArray();
					long[][] nlongMatMapping = MatrixOperations.rowBind(longMatMapping, 1);
					nlongMatMapping[nlongMatMapping.length-1][mappingMFunc.getNParams()] = 1;	// TODO: bug here... :/ (position of the "i")
					
					Matrix nMatMapping = PolymodelMatrixOperation.toMatrix(nlongMatMapping);
					List<IntExpression> exprFunc = nMatMapping.toFunction(mappingMFunc.getParams(), mappingMFunc.getIndices());
					DomainDimensions dimDom = _polyFact.createDomainDimensions(mappingMFunc.getIndices(), mappingMFunc.getParams());
					AffineFunction nMappingMFunc = _polyIRFact.createAffineFunction(_polyFact.createFunction(dimDom, exprFunc));
					
					useEq.setParameters(nMappingMFunc);
				}
				useEq.getOutputs().clear(); useEq.getOutputs().addAll(newOutputs);
				useEq.getInputs().clear(); useEq.getInputs().addAll(newInputs);
			} else {						// Several case for the parameter domain
				
				// Modifications to be done:
				// IF [ mfunc = (D_k , paramExpr_k) , 0<=k<Ncase ] AND [the outputs of the use equations are O_l , 0<=l<Noutput] THEN
				//		- introduce for each (k,l) Obl_k_l defined on $D_{O_l} \cap D_k$
				//		- create l equations Obl_l = case ... D_k : Obl_k,l ... esac
				//		- create k useEquations use (\Delta \cap D_k) subsyst[paramExpr_k] (inputsExpr) returns (... Obl_k,l ... );
				// And do not forget to remove the current useEquation from the system
				int nDomKey=0;
				List<List<VariableDeclaration>> llOutputUeq = new BasicEList<List<VariableDeclaration>>();
				List<Domain> listKey = new BasicEList<Domain>();
				for (Domain domKey : mfunc.keySet()) {
					listKey.add(domKey);
					
					// TODO: transformation of domKey needed ?
					
					List<VariableDeclaration> lOutputUeq = new BasicEList<VariableDeclaration>();
					for (VariableDeclaration varOutput : useEq.getOutputs()) {
						
						VariableDeclaration nVarDecl = _polyIRFact.createVariableDeclaration(
								varOutput.getName() + suffixTempUseEqOutputVar + "_" + nDomKey, varOutput.getType(),
								varOutput.getDomain().intersection(domKey));
						lOutputUeq.add(nVarDecl);
					}
					llOutputUeq.add(lOutputUeq);
					nDomKey++;
				}
				
				List<StandardEquation> lStEq = new BasicEList<StandardEquation>();
				for (int l=0; l<useEq.getOutputs().size();l++) {
					List<Expression> lRestrExpr = new BasicEList<Expression>();
					for (int k=0; k<mfunc.size(); k++) {
						RestrictExpression restrExpr = _polyIRFact.createRestrictExpression(listKey.get(l),
								_polyIRFact.createVariableExpression(llOutputUeq.get(k).get(l)));
						lRestrExpr.add(restrExpr);
					}
					CaseExpression caseExpr = _polyIRFact.createCaseExpression(lRestrExpr);
					StandardEquation stEq = _polyIRFact.createStandardEquation(newOutputs.get(l), caseExpr);
					
					lStEq.add(stEq);
				}
				
				List<UseEquation> lUseEq = new BasicEList<UseEquation>();
				for (int k=0; k<mfunc.size(); k++) {
					// We need to add "b" at the end of the parameter mapping
					AffineFunction mappingMFunc = mfunc.get(listKey.get(k));
					
					Matrix matMapping = mappingMFunc.getPMmapping().toMatrix();
					long[][] longMatMapping = matMapping.toLongArray();
					long[][] nlongMatMapping = MatrixOperations.rowBind(longMatMapping, 1);
					nlongMatMapping[nlongMatMapping.length-1][_listBlockedParam.size()*2+1] = 1;
					
					Matrix nMatMapping = PolymodelMatrixOperation.toMatrix(nlongMatMapping);
					List<IntExpression> exprFunc = nMatMapping.toFunction(mappingMFunc.getParams(), mappingMFunc.getIndices());
					DomainDimensions dimDom = _polyFact.createDomainDimensions(mappingMFunc.getIndices(), mappingMFunc.getParams());
					AffineFunction nMappingMFunc = _polyIRFact.createAffineFunction(_polyFact.createFunction(dimDom, exprFunc));
					
					UseEquation nUseEq = _polyIRFact.createUseEquation(extDomTiled.intersection(listKey.get(k)), useEq.getSubSystem(),
							nMappingMFunc, newInputs, llOutputUeq.get(k));
					lUseEq.add(nUseEq);
				}
				
				// Updates
				for (List<VariableDeclaration> lVarDeclTemp : llOutputUeq)
					_syst.getLocals().addAll(lVarDeclTemp);
				
				_extraStEq.addAll(lStEq);
				
				UseEquation nUseEq0 = lUseEq.get(0); lUseEq.remove(0);
				useEq.setExtensionDomain(nUseEq0.getExtensionDomain());
				useEq.setParameters(nUseEq0.getParameters());
				useEq.getOutputs().clear(); useEq.getOutputs().addAll(nUseEq0.getOutputs());
				useEq.getInputs().clear(); useEq.getInputs().addAll(nUseEq0.getInputs());
				
				_extraUseEq.addAll(lUseEq);
			}
			//*/
		}
		
		
		
		// --- Leaves (must have a dependence in front of them => we assume that we did the "LowerDependences" before)
		@Override
		public void visitVariableExpression(VariableExpression varExpr) {
			VariableDeclaration varDeclScal = varExpr.getVarDecl();
			String nameBlockedVar = _mapScalBlockVar.get(varDeclScal.getName());
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitVariableExpression (Var: " + varDeclScal.getName() + ")");
			
			VariableDeclaration varDeclBlocked = null;
			if (varDeclScal.isInput())
				for (VariableDeclaration varDeclIn : _lVarDeclBlInput)
					if (varDeclIn.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclIn;
						break;
					}
			if (varDeclScal.isLocal())
				for (VariableDeclaration varDeclLoc : _lVarDeclBlLocal)
					if (varDeclLoc.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclLoc;
						break;
					}
			if (varDeclScal.isOutput())
				for (VariableDeclaration varDeclOut : _lVarDeclBlOutput)
					if (varDeclOut.getName()==nameBlockedVar) {
						varDeclBlocked = varDeclOut;
						break;
					}
			
			_subExprToBeReplaced_Leaf = _polyIRFact.createVariableExpression(varDeclBlocked);
			_subExprToBeReplaced = null;
			_ratioSubExpr = getRatioVariable(_scaleDimVar, varDeclScal.getName(), varDeclScal.getDomain().getNIndices());
			
			/* DEBUG
			System.out.print("Variable " + varDeclScal.getName() + " -> ratio = [");
			for (int i=0; i<_subExprToBeReplaced_Leaf.size(); i++)
				System.out.print(_subExprToBeReplaced_Leaf.get(i) + " ");
			System.out.println("]");
			//*/
			
		}
		
		@Override
		public void outIndexExpression(IndexExpression iexpr) {
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outIndexExpression");
			
			
			List<Integer> scale = new BasicEList<Integer>();						// Scale: assuming it is identity
			for (int i=0; i<iexpr.getFunction().getNIndices(); i++)
				scale.add(1);
			
			int nIndScal = iexpr.getFunction().getNIndices();
			int nParamScal = iexpr.getFunction().getNParams();
			
			EList<Variable> blocklocInd = new BasicEList<Variable>();
			EList<Variable> blockInd = new BasicEList<Variable>();
			EList<Variable> locInd = new BasicEList<Variable>();
			
			List<String> lIndNames = iexpr.getFunction().getIndexNames();
			for (int i=0; i<nIndScal; i++) {
				Variable varTemp = _dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd);
				blocklocInd.add(varTemp);
				blockInd.add(varTemp);
			}
			for (int i=0; i<nIndScal; i++) {
				Variable varTemp = _dimMana.getDimension(i+nIndScal, lIndNames.get(i) + suffixLocInd);
				blocklocInd.add(varTemp);
				locInd.add(varTemp);
			}
			
			// *** If the function behind "iexpr" is "f", we create the expression ( [f(blocked indexes)] * [b] ) + [f(local indexes)]
			Matrix matFuncIndExpr = iexpr.getFunction().getPMmapping().toMatrix();
			
			List<MatrixRow> lnMatRowBl = new BasicEList<MatrixRow>();
			List<MatrixRow> lnMatRowLoc = new BasicEList<MatrixRow>();
			for (MatrixRow matR : matFuncIndExpr.getRows()) {
				MatrixRow nmatRBl = _polyFact.createMatrixRow(2*nParamScal+2*nIndScal+2);
				MatrixRow nmatRLoc = _polyFact.createMatrixRow(2*nParamScal+2*nIndScal+2);
				
				for (int i=0; i<nParamScal; i++) {
					nmatRBl.set(i, matR.get(i));
					nmatRLoc.set(i+nParamScal, matR.get(i));
				}
				for (int i=0; i<nIndScal; i++) {
					nmatRBl.set(i+2*nParamScal+1, matR.get(nParamScal+i));
					nmatRLoc.set(i+2*nParamScal+nIndScal+1, matR.get(nParamScal+i));
				}
				nmatRBl.set(2*nIndScal+2*nParamScal+1, matR.get(nParamScal+nIndScal));
				nmatRLoc.set(2*nIndScal+2*nParamScal+1, matR.get(nParamScal+nIndScal));
				
				lnMatRowBl.add(nmatRBl);
				lnMatRowLoc.add(nmatRLoc);
			}
			
			// Creating [f(blocked indexes)]
			matFuncIndExpr.getRows().clear();
			matFuncIndExpr.getRows().addAll(lnMatRowBl);
			List<IntExpression> lFunBl = matFuncIndExpr.toFunction(_listBlLocParam, blocklocInd);
			List<AffineExpression> lFunBlAffExpr = new BasicEList<AffineExpression>();
			for (IntExpression funBl : lFunBl)
				lFunBlAffExpr.add((AffineExpression) funBl);
			FastISLMap affFuncBl = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_listBlLocParam, blocklocInd, lFunBlAffExpr).getPMmapping());
			IndexExpression subcaseIndexExprBl = _polyIRFact.createIndexExpression(affFuncBl);
			

			// Creating [f(local indexes)]
			Matrix matLoc = _polyFact.createMatrix(1, 2*nParamScal+2*nIndScal+2);
			matLoc.getRows().clear();
			matLoc.getRows().addAll(lnMatRowLoc);
			List<IntExpression> lFunLoc = matLoc.toFunction(_listBlLocParam, blocklocInd);
			List<AffineExpression> lFunLocAffExpr = new BasicEList<AffineExpression>();
			for (IntExpression funLoc : lFunLoc)
				lFunLocAffExpr.add((AffineExpression) funLoc);
			FastISLMap affFuncLoc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_listBlLocParam, blocklocInd, lFunLocAffExpr).getPMmapping());
			IndexExpression subcaseIndexExprLoc = _polyIRFact.createIndexExpression(affFuncLoc);
			
			// Creating [b]
			List<AffineExpression> lexprAffFuncbSize = new BasicEList<AffineExpression>();
			lexprAffFuncbSize.add(IntExpressionBuilder.affine(_blSizeParam));
			FastISLMap affFuncIndbSize =  _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_listBlLocParam,
					blocklocInd, lexprAffFuncbSize).getPMmapping());
			IndexExpression subcaseIndexExprbSize = _polyIRFact.createIndexExpression(affFuncIndbSize);
			
			// Combining all
			BinaryExpression subcaseBinMult = _polyIRFact.createBinaryExpression(OP.MUL, subcaseIndexExprBl, subcaseIndexExprbSize);
			Expression subcaseIndexExpr = _polyIRFact.createBinaryExpression(OP.ADD, subcaseBinMult, subcaseIndexExprLoc);
			
			
			
			// *** Creating _subExprToBeReplace (as universe + as the tile itself)
			FastISLDomain domBl = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(_listBlockedParam, blockInd).getPMdomain());
			
			Matrix domLocMat = _polyFact.createMatrix(2*nIndScal, nParamScal+nIndScal+3);
			for (int k=0; k<nIndScal; k++) {
				domLocMat.set(k, 0, 1);
				domLocMat.set(k, 2+nParamScal+k, 1);
			}
			for (int k=0; k<nIndScal; k++) {
				domLocMat.set(k+nIndScal, 0, 1);
				domLocMat.set(k+nIndScal, 1+nParamScal, 1);		// scale = 1
				domLocMat.set(k+nIndScal, 2+nParamScal+k, -1);
				domLocMat.set(k+nIndScal, domLocMat.getNbCols()-1, -1);
			}
			List<IntConstraintSystem> lsyst = new BasicEList<IntConstraintSystem>();
			lsyst.add(domLocMat.toDomain(_listLocalBlSizeParam, locInd));
			FastISLDomain domLoc = _polyIRFact.createFastISLDomain(_polyIRFact.createDomain(_listLocalBlSizeParam, locInd, lsyst).getPMdomain());
			
			
			_subExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			_subExprToBeReplaced.add(Triplet.with(domBl, domLoc, subcaseIndexExpr));
			
			_ratioSubExpr = scale;
			_subExprToBeReplaced_Leaf = null;	// To be sure it does not go into a dependence... :/
		}
		
		@Override
		public void outBooleanExpression(BooleanExpression b) {
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outBooleanExpression (value: " + b.isValue() + ")");
			
			
			List<Integer> ratio = new BasicEList<Integer>();
			for (int i=0; i<b.getExpressionDomain().getNIndices();i++)
				ratio.add(1);
			
			_subExprToBeReplaced_Leaf = b.copy();
			_subExprToBeReplaced = null;
			_ratioSubExpr = ratio;
		}
		
		@Override
		public void outIntegerExpression(IntegerExpression i) {
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outIntegerExpression (value: " + i.getValue() + ")");
			
			List<Integer> ratio = new BasicEList<Integer>();
			for (int k=0; k<i.getExpressionDomain().getNIndices();k++)
				ratio.add(1);
			
			_subExprToBeReplaced_Leaf = i.copy();
			_subExprToBeReplaced = null;
			_ratioSubExpr = ratio;
		}
		
		@Override
		public void outRealExpression(RealExpression r) {
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outRealExpression (value: " + r.getValue() + ")");
			
			
			List<Integer> ratio = new BasicEList<Integer>();
			for (int k=0; k<r.getExpressionDomain().getNIndices();k++)
				ratio.add(1);
			
			_subExprToBeReplaced_Leaf = r.copy();
			_subExprToBeReplaced = null;
			_ratioSubExpr = ratio;
		}
		
		
		// --- Dependence expression: must have a leaf after it
		@Override
		public void outDependenceExpression(DependenceExpression depExpr) {
			// *** Getting the informations on the dependences
			AffineFunction dep = depExpr.getDep();
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outDependenceExpression (dep = " + dep.toString() + ")");
			
			
			Triplet<long[][], long[][],long[]> tDep = FunctionOperations.getMatrixRepresentation(dep);
			long[][] paramPart = tDep.getValue0();
			long[][] linPart = tDep.getValue1();
			
			// *** Determining the ratio of the dependence expression
			List<Integer> ratioSExpr = _ratioSubExpr;
			
			// Parameters conditions: (\forall i j) ratioSExpr(i) | paramPart[i][j]
			for (int i=0; i<ratioSExpr.size(); i++)
				for (int j=0; j<paramPart[0].length; j++)
					if (!divides(ratioSExpr.get(i),(int)paramPart[i][j]))
						throw new RuntimeException("Ratio not compatible (parameters): Fails for dimension " + i + " for the dependence " + dep
								+ " / ratioSExpr = " + ratioSExpr.get(i));
			
			// Getting ratioExpr:
			//	(\forall j) ratioExpr[j] = ppcm_i ( ratioSExpr[i] / gcd(ratioSExpr[i],Q_i,j) )
			List<Integer> ratioExpr = new BasicEList<Integer>();
			if (linPart.length==0) {		// Dependence to nothing (i -> )
				for (int i=0; i<dep.getNIndices(); i++)
					ratioExpr.add(1);
			} else {
				for (int j=0; j<linPart[0].length; j++) {
					int temp = 1;
					for (int i=0; i<linPart.length; i++) {
						int delta = ratioSExpr.get(i) / gcd(ratioSExpr.get(i), (int) linPart[i][j]);
						temp = scm(temp, delta);
					}
					ratioExpr.add(temp);
				}
			}

			/* DEBUG
			System.out.print("Dependence expression" + depExpr.getDep().toString() + "-> ratio = [");
			for (int i=0; i<ratioExpr.size(); i++)
				System.out.print(ratioExpr.get(i) + " ");
			System.out.println("]");
			//*/
			
			
			// *** Applying CART
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = depExpr.getDep().getIndexNames();
			for (int i=0; i<depExpr.getDep().getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+depExpr.getDep().getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> ltAffFuncTiled = CARTOperations.getTiledFunctionSplit(depExpr.getDep(), blockInd, localInd, _listBlockedParam, _listLocalParam,
					ratioExpr, ratioSExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			
			// *** Creating the new expression (with separation of the blocked/local indexes)
			_subExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain, Expression>>();
			
			for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tBlLocAffFunc : ltAffFuncTiled) {
				DependenceExpression subcaseDepExpr = _polyIRFact.createDependenceExpression(tBlLocAffFunc.getValue2(), _subExprToBeReplaced_Leaf.copy());
				_subExprToBeReplaced.add(Triplet.with(tBlLocAffFunc.getValue0(), tBlLocAffFunc.getValue1(), (Expression)subcaseDepExpr));
			}
			
			_ratioSubExpr = ratioExpr;
			
			/* DEBUG
			System.out.println("@@@ DepExpr = " + PolyhedralIRToAlphabets.toString(depExpr));
			System.out.println("@@@@ ratio = " + _ratioSubExpr);
			for (Triplet<Domain,Domain,Expression> tDLocBlSExpr : _subExprToBeReplaced)
				System.out.println("	* " + tDLocBlSExpr.getValue0().toString() + ", " + tDLocBlSExpr.getValue1().toString() + ",\n\t\t\t" + PolyhedralIRToAlphabets.toString(tDLocBlSExpr.getValue2()));
			System.out.println();
			//*/
		}
		
		
		// --- Work needed
		@Override
		public void outRestrictExpression(RestrictExpression restExpr) {
			Domain scalRestrDom = restExpr.getRestrictDomain();
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outRestrictExpression (dom = " + scalRestrDom.toString() + ")");
			
			
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = scalRestrDom.getIndexNames();
			for (int i=0; i<scalRestrDom.getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+scalRestrDom.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			
			List<Pair<FastISLDomain,FastISLDomain>> lpdomRestr = CARTOperations.getTiledDomainSplit(scalRestrDom, blockInd, localInd,
					_listBlockedParam, _listLocalParam, _ratioSubExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,FastISLDomain> pdomRestr : lpdomRestr)
				for (Triplet<FastISLDomain,FastISLDomain,Expression> tdomSubExpr : _subExprToBeReplaced) {
					FastISLDomain domBlockTemp = (FastISLDomain) pdomRestr.getValue0().intersection(tdomSubExpr.getValue0());
					
					if (!domBlockTemp.isEmpty()) {
						FastISLDomain domLocalTemp = (FastISLDomain) pdomRestr.getValue1().intersection(tdomSubExpr.getValue1());
						if (!domLocalTemp.isEmpty())
							nSubExprToBeReplaced.add(Triplet.with(domBlockTemp, domLocalTemp, tdomSubExpr.getValue2().copy()));
					}
				}
			
			_subExprToBeReplaced = nSubExprToBeReplaced;
			// _ratioSubExpr do not change
			
			/* DEBUG
			//System.out.println("********** ***************");
			//for (Pair<Domain,Domain> pDomRestr : lpdomRestr)
			//	System.out.println("	~~~ " + pDomRestr.toString());
			//System.out.println();
			for (Triplet<Domain,Domain,Expression> tDLocBlSExpr : _subExprToBeReplaced)
				System.out.println("	* " + tDLocBlSExpr.getValue0().toString() + ", " + tDLocBlSExpr.getValue1().toString() + ",\n\t\t\t" + PolyhedralIRToAlphabets.toString(tDLocBlSExpr.getValue2()));
			//*/
		}
		
		@Override
		public void outReduceExpression(ReduceExpression redExpr) {
			AffineFunction projFunc = redExpr.getProjection();
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outReduceExpression (projFunc = " + projFunc.toString() + ")");
			
			
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = projFunc.getIndexNames();
			for (int i=0; i<projFunc.getNIndices(); i++) {
				blockInd.add(_dimMana.getDimension(i, lIndNames.get(i) + suffixBlInd));
				localInd.add(_dimMana.getDimension(i+projFunc.getNIndices(), lIndNames.get(i) + suffixLocInd));
			}
			List<Variable> lIndFull = new BasicEList<Variable>();
			lIndFull.addAll(blockInd); lIndFull.addAll(localInd);
			List<Variable> lIndFullTemp = lIndFull.subList(0, blockInd.size()+projFunc.getDimRHS());
			
			
			// We already did a normalization of projection function during "LowerDependences"
			//		=> projFunc must be canonical
			// Thus, we can take the same "projected" ration than "_ratioSubExpr"
			List<Integer> scaleIm = new BasicEList<Integer>();
			for (int i=0; i<projFunc.getDimRHS(); i++)
				scaleIm.add(_ratioSubExpr.get(i));
			
			
			// Under these ratio, CARTing is trivial and end up in only one case
			List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> projFuncTiled = CARTOperations.getTiledFunctionSplit(projFunc, blockInd, localInd,
					_listBlockedParam, _listLocalParam, _ratioSubExpr, scaleIm, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			if (projFuncTiled.size()!=1)
				throw new RuntimeException("ParametricTiling => CARTing of dependence function: we did not have a canonic projection function"
						+ "while CARTing, which ends up into several cases");
			
			
			// =====> We have red(+, (\alpha_1, \alpha_2, ii_1, ii_2 -> \alpha_1, ii_1), case ... Dbl_k \inter Dloc_k : SExpr_k; ... esac)
			//	We do the following things:
			//		- Introduce a new local variable TempRed[number]
			//		- TempRed[\alpha_1,\alpha_2,ii_1] = case ... Dbl_k \inter \Pi_{ii_2}(Dloc_k) : red(+, [ii_2], SExpr_k); ... esac;
			//		- _subExprToBeReplaced = red(+, [\alpha_2], TempRed[\alpha_1,\alpha_2,ii_1]);
			// Erratum: the expression inside is a bit more complicated than placed (summation of reductions), however do not explode combinatorially
			
			// Building \pi_{ii_2} (used inside the reduction inside TempRed)
			
			int dimImProjIi2 = projFunc.getNIndices()+projFunc.getDimRHS();
			long[][] QprojIi2 = new long[dimImProjIi2][2*projFunc.getNIndices()];
			for (int i=0; i<QprojIi2.length ;i++)
				QprojIi2[i][i]= 1;
			FastISLMap projIi2 = _polyIRFact.createFastISLMap(FunctionOperations.createAffineFunctionFromMatrix(new long[dimImProjIi2][2*projFunc.getNParams()+1],
					QprojIi2, new long[dimImProjIi2], projFuncTiled.get(0).getValue2().getParams(), projFuncTiled.get(0).getValue2().getIndices()).getPMmapping());
			
			List<Variable> projTargIi2Local = projFuncTiled.get(0).getValue1().getIndices().subList(0, projFunc.getDimRHS());
			FastISLMap projIi2Local = _polyIRFact.createFastISLMap(PolyhedralIRUtility.createProjection(projFuncTiled.get(0).getValue1(), projTargIi2Local).getPMmapping());
			
			
			// Computing the list of the <Dbl_k , \pi_{ii_2}(Dloc_k)>
			List<Pair<FastISLDomain,FastISLDomain>> lCaseTemp = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
			for (Triplet<FastISLDomain,FastISLDomain, Expression> tBlLocSExpr : _subExprToBeReplaced)
				lCaseTemp.add(Pair.with(tBlLocSExpr.getValue0(), (FastISLDomain) tBlLocSExpr.getValue1().image(projIi2Local)));
			
			
			// Creating the new local variable (varTempRed)
			while (_syst.containsVariable(suffixNameTempRed+counterNameTempRed))
				counterNameTempRed++;
			String nameTempRed = suffixNameTempRed+counterNameTempRed;
			counterNameTempRed++;
			
			// OLD
			FastISLDomain domTempRedTemp = CARTOperations.getTiledDomain(redExpr.getExpr().getContextDomain(),
					blockInd, localInd, _listBlockedParam, _listLocalParam, _ratioSubExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			FastISLDomain domTempRed = (FastISLDomain) domTempRedTemp.image(projIi2);
			// END OLD
			
			/* NEW (with decomposition of domTempRedTemp)
			List<Pair<Domain,Domain>> lpDomTempRedTemp = CARTOperations.getTiledDomainSplit(redExpr.getExpr().getContextDomain(),
					blockInd, localInd, _listBlockedParam, _listLocalParam, _ratioSubExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			List<Pair<Domain,Domain>> lpDomTempRed = new BasicEList<Pair<Domain,Domain>>();
			for (Pair<Domain,Domain> pDomTempRedTemp : lpDomTempRedTemp)
				lpDomTempRed.add(Pair.with(pDomTempRedTemp.getValue0(), pDomTempRedTemp.getValue1().image(projIi2Local)));
			
			Domain domTempRed = translateToFullDimension(lpDomTempRed.get(0).getValue0(), _syst.getParameters().getParams(), lIndFullTemp);
			domTempRed = domTempRed.intersection(translateToFullDimension(lpDomTempRed.get(0).getValue1(), _syst.getParameters().getParams(), lIndFullTemp));
			
			for (int k=1; k<lpDomTempRed.size(); k++) {
				Domain domTempTemp = translateToFullDimension(lpDomTempRed.get(k).getValue0(), _syst.getParameters().getParams(), lIndFullTemp);
				domTempTemp = domTempTemp.intersection(translateToFullDimension(lpDomTempRed.get(k).getValue1(), _syst.getParameters().getParams(), lIndFullTemp));
				domTempRed = domTempRed.union(domTempTemp);
			}
			// END NEW */
			
			
			// DEBUG
			//System.out.println("domTempRed = " + domTempRed.toString());
			
			
			// Adding the parameter dimensions
			FastISLDomain paramDomExt = _polyIRFact.createFastISLDomain(_blockedParamDom.copy().getPMdomain());
			for (int i=0; i<domTempRed.getNIndices(); i++)
				paramDomExt.addDimension(domTempRed.getIndexNames().get(i));
			FastISLDomain domTempRedParam = (FastISLDomain) domTempRed.intersection(paramDomExt);
			domTempRedParam.simplify();
			
			VariableDeclaration varTempRed = _polyIRFact.createVariableDeclaration(nameTempRed, redExpr.getExpressionType(), domTempRedParam);
			_lVarDeclBlLocal.add(varTempRed);
			
			
			// Getting the improved data structure
			List<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>> lImprovedSubExpr = coalescedBlocks(_subExprToBeReplaced);
			
			/* DEBUG
			System.out.println("\n\nCoalesced Blocks (reduce):");
			for (Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>> pTemp1 : lImprovedSubExpr) {
				System.out.println(" * " + pTemp1.getValue0().toString());
				for (Pair<FastISLDomain,Expression> pTemp2 : pTemp1.getValue1())
					System.out.println("		- " + pTemp2.getValue0().toString() + "  " + PolyhedralIRToAlphabets.toString(pTemp2.getValue1()));
			}
			System.out.println("\n\nDone.");
			//*/
			
			
			// Creating the Equation for varTempRed
			List<RestrictExpression> lCaseEqTempRed = new BasicEList<RestrictExpression>();
			for (int k=0; k<lImprovedSubExpr.size(); k++) {
				Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>> pdomBlLocSExpr = lImprovedSubExpr.get(k);
				
				List<Expression> lCaseLocRestrSExpr = new BasicEList<Expression>();
				for (Pair<FastISLDomain,Expression> pDomLocSExpr : pdomBlLocSExpr.getValue1()) {
					FastISLDomain domLocFull = translateToFullDimension(pDomLocSExpr.getValue0(), _listBlLocParam, lIndFull, false);
					lCaseLocRestrSExpr.add(_polyIRFact.createRestrictExpression(domLocFull, pDomLocSExpr.getValue1().copy()));
				}
				CaseExpression caseLocTempRed = _polyIRFact.createCaseExpression(lCaseLocRestrSExpr);
				
				ReduceExpression redCaseTempRed = _polyIRFact.createReduceExpression(redExpr.getOP(), projIi2.copy(), caseLocTempRed);
				FastISLDomain domBlFull = translateToFullDimension(pdomBlLocSExpr.getValue0(), _listBlLocParam, lIndFullTemp, true);
				
				
				// Get the domain of the reduction variable, and remove the local indexes/parameter constraints
				FastISLDomain domTempRedBl = removeLocalParamIndexes(domTempRed, domTempRed.getNIndices()-domTempRedTemp.getNIndices()/2); // OLD
				// NEW: Domain domTempRedBl = removeLocalParamIndexes(domTempRed, domTempRed.getNIndices()-lpDomTempRedTemp.get(0).getValue0().getNIndices());
				FastISLDomain domBlFullInter = (FastISLDomain) domTempRedBl.intersection(domBlFull);
				//domBlFullInter.simplify();
				
				// FIXME: Issue if we simplify here. Not simplifying is enough.
				//			=> How to coalesce intelligently without having issues there?
				
				for (int l=0; l<domBlFullInter.getPMdomain().getPolyhedra().size(); l++) {
					// FIXME: can probably be improved
					
					IntConstraintSystem syst = domBlFullInter.getPMdomain().getPolyhedra().get(l);
					FastISLDomain domTemp = _polyIRFact.createFastISLDomain(
							_polyIRFact.createDomain(domBlFullInter.getParams(), domBlFullInter.getIndices(), syst.copy()).getPMdomain());
					lCaseEqTempRed.add(_polyIRFact.createRestrictExpression(domTemp, redCaseTempRed.copy()));
				}
			}
			
			
			CaseExpression cExprTempRed = _polyIRFact.createCaseExpression(lCaseEqTempRed);
			StandardEquation eqTempRed = _polyIRFact.createStandardEquation(varTempRed, cExprTempRed);
			
			_extraStEq.add(eqTempRed);
			
			
			
			// Building \pi_{alpha_2}
			List<Variable> projTargAlpha2 = new BasicEList<Variable>();
			for (int k=0; k<projFunc.getDimRHS(); k++)
				projTargAlpha2.add(varTempRed.getDomain().getIndices().get(k));
			for (int k=0; k<projFunc.getDimRHS(); k++)
				projTargAlpha2.add(varTempRed.getDomain().getIndices().get(projFunc.getNIndices()+k));
			FastISLMap projAlpha2 = _polyIRFact.createFastISLMap(PolyhedralIRUtility.createProjection(varTempRed.getDomain(), projTargAlpha2).getPMmapping());
			
//			int dimImProjAlpha2 = 2*projFunc.getDimRHS();
//			long[][] QprojAlpha2 = new long[dimImProjAlpha2][dimImProjIi2];
//			for (int k=0; k<projFunc.getDimRHS(); k++)
//				QprojAlpha2[k][k]=1;
//			for (int k=0; k<projFunc.getDimRHS(); k++)
//				QprojAlpha2[projFunc.getDimRHS()+k][projFunc.getNIndices()+k]=1;
//			
//			AffineFunction projAlpha2 = FunctionOperations.createAffineFunctionFromMatrix(new long[dimImProjAlpha2][2*projFunc.getNParams()+1],
//					QprojAlpha2, new long[dimImProjAlpha2], projFuncTiled.get(0).getValue2().getParams(), lCaseTemp.get(0).getValue0().getIndices());
			
			// Building _subExprToBeReplaced
			Expression exprSubExprToBeReplaced = _polyIRFact.createReduceExpression(redExpr.getOP(), projAlpha2,
					_polyIRFact.createVariableExpression(varTempRed));
			
			List<Variable> blockIndIm = new BasicEList<Variable>();
			List<Variable> localIndIm = new BasicEList<Variable>();
			List<String> lIndNamesIm = redExpr.getContextDomain().getIndexNames();
			for (int i=0; i<lIndNamesIm.size(); i++) {
				blockIndIm.add(_dimMana.getDimension(i, lIndNamesIm.get(i) + suffixBlInd));
				localIndIm.add(_dimMana.getDimension(i+lIndNamesIm.size(), lIndNamesIm.get(i) + suffixLocInd));
			}
			List<Pair<FastISLDomain,FastISLDomain>> domCARTRedExpr = CARTOperations.getTiledDomainSplit(redExpr.getContextDomain(),
					blockIndIm, localIndIm, _listBlockedParam, _listLocalParam, scaleIm, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
			
			List<Triplet<FastISLDomain,FastISLDomain, Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain, Expression>>();
			for (int k=0; k<domCARTRedExpr.size(); k++)
				nSubExprToBeReplaced.add(Triplet.with(domCARTRedExpr.get(k).getValue0(),
						domCARTRedExpr.get(k).getValue1(),
						exprSubExprToBeReplaced.copy()));
			
			
			// Update request for the top
			_subExprToBeReplaced = nSubExprToBeReplaced;
			_ratioSubExpr = scaleIm;
			
			
			// Update _nAlignmentInfo
			String nameVarEq = ((StandardEquation) redExpr.getContainerEquation()).getVariable().getName();
			if (_alignmentInfo!=null)
			for (int k=0; k<_alignmentInfo.size(); k++) {
				if (_alignmentInfo.get(k).containsKey(nameVarEq)) {
					_nAlignmentInfo.get(k).add(nameTempRed);
					break;
				}
			}
			
			_alignmentRedInfo.put(nameTempRed, Pair.with(projAlpha2, ( (StandardEquation) redExpr.getContainerEquation() ).getVariable().getName()+suffixBlVar));
			
			// Local normalization: not needed... :/
		}
		
		// --- Simple propagation, with aspect-ratio management ---
		@Override
		public void visitCaseExpression(CaseExpression cexpr) {
			inCaseExpression(cexpr);
			
			// Getting the subexpressions  (visiting the AST below the CaseExpression)
			List<List<Triplet<FastISLDomain,FastISLDomain, Expression>>> lInfoSubExpr = new BasicEList<List<Triplet<FastISLDomain,FastISLDomain, Expression>>>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : cexpr.getExprs()) {
				// Tracking
				if (_noisyTracking)
					System.out.println("TRACKING:::visitCaseExpression - enterring new branch");
				
				
				expr.accept(this);
				lInfoSubExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitCaseExpression - branches done");
			
			
			
			/* DEBUG
			System.out.println("*** CASE -> lratio = [[[");
			for (int i=0; i<lratio.size(); i++) {
				System.out.print("           [ ");
				for (int j=0; j<lratio.get(i).size(); j++)
					System.out.print(lratio.get(i).get(j) + " ");
				System.out.println("]");
			}
			System.out.println("]]]");
			//*/
			
			/* DEBUG
			System.out.println("%%%%%%%%%%%%%%%% lInfoSubExpr (case) ");
			for (int k=0; k<lInfoSubExpr.size(); k++) {
				System.out.println(" * [" + k + "] =");
				for (Triplet<Domain,Domain,Expression> tDLocBlSExpr : lInfoSubExpr.get(k))
					System.out.println("	* " + tDLocBlSExpr.getValue0().toString() + ", " + tDLocBlSExpr.getValue1().toString() + ",\n\t\t\t" + PolyhedralIRToAlphabets.toString(tDLocBlSExpr.getValue2()));
			}
			System.out.println();
			//*/
			
			
			// Determining the new aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp,lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			
			// We add the new affine function to each aspect ratio, and get the new informations
			List<Triplet<FastISLDomain,FastISLDomain, Expression>> nlInfoSubExpr = new BasicEList<Triplet<FastISLDomain,FastISLDomain, Expression>>();
			for (int i=0; i<lInfoSubExpr.size(); i++) {
				List<Triplet<FastISLDomain,FastISLDomain, Expression>> infoSubExpr = lInfoSubExpr.get(i);
				List<Integer> ratioSExpr = lratio.get(i);
				
				// Is the aspect ratio the same?
				boolean isRatioSame = true;
				for (int k=0; k<nratio.size(); k++)
					if (nratio.get(k)!=ratioSExpr.get(k))
						isRatioSame = false;
				
				if (isRatioSame)
					nlInfoSubExpr.addAll(infoSubExpr);
				else {
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					List<Variable> blockInd = new BasicEList<Variable>();
					List<Variable> localInd = new BasicEList<Variable>();
					List<String> lIndNames = cexpr.getExpressionDomain().getIndexNames();
					for (int j=0; j<cexpr.getExpressionDomain().getNIndices(); j++) {
						blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
						localInd.add(_dimMana.getDimension(j+cexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
					}
					AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(cexpr.getExpressionDomain());
					
					List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd,
							_listBlockedParam, _listLocalParam, nratio, ratioSExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
					
					
					
					// We just have to compute idCart^{-1} of each Triplet<Domain,Domain,Expression>... (~ cross-product)
					for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tPartialFunc : idCart)
						for (Triplet<FastISLDomain,FastISLDomain,Expression> tInfoSubExpr : infoSubExpr) {
							Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tPartialFunc,tInfoSubExpr);
							if (!tRes.getValue1().isEmpty())
								nlInfoSubExpr.add(tRes);
						}
				}
			}
			
			outCaseExpression(cexpr);
			_subExprToBeReplaced = nlInfoSubExpr;
			_ratioSubExpr = nratio;
		}
		
		@Override
		public void visitIfExpression(IfExpression iexpr) {
			inIfExpression(iexpr);
			
			iexpr.getCond().accept(this);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> condExprInfo = _subExprToBeReplaced;
			List<Integer> ratioCond = _ratioSubExpr;
			
			iexpr.getThen().accept(this);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> thenExprInfo = _subExprToBeReplaced;
			List<Integer> ratioThen = _ratioSubExpr;
			
			iexpr.getElse().accept(this);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> elseExprInfo = _subExprToBeReplaced;
			List<Integer> ratioElse = _ratioSubExpr;
			
			outIfExpression(iexpr);
			

			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitIfExpression - branches done");
			
			
			// Getting the new ratio for this expression
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<ratioCond.size(); i++)
				nratio.add(scm(scm(ratioCond.get(i), ratioThen.get(i)),ratioElse.get(i)));
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = iexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<iexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+iexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(iexpr.getExpressionDomain());
			
			// (i) Cond expression
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nCondExprInfo;
			
			boolean isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioCond.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nCondExprInfo = condExprInfo;
			else {
				nCondExprInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				List<Triplet<FastISLDomain,FastISLDomain, FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd,
						_listBlockedParam, _listLocalParam,
						nratio, ratioCond, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				
				for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tCondExprInfo : condExprInfo) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tCondExprInfo);
						if (!tRes.getValue1().isEmpty())
							nCondExprInfo.add(tRes);
					}
			}
			
			// (ii) Then expression
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nThenExprInfo;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioThen.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nThenExprInfo = thenExprInfo;
			else {
				nThenExprInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				List<Triplet<FastISLDomain,FastISLDomain, FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd,
						_listBlockedParam, _listLocalParam, nratio, ratioThen, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				
				for (Triplet<FastISLDomain,FastISLDomain, FastISLMap> tIdCart : idCart)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tThenExprInfo : thenExprInfo) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tThenExprInfo);
						if (!tRes.getValue1().isEmpty())
							nThenExprInfo.add(tRes);
					}
			}
			
			// (iii) Else expression
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nElseExprInfo;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioElse.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nElseExprInfo = elseExprInfo;
			else {
				nElseExprInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				List<Triplet<FastISLDomain,FastISLDomain, FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioElse, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				
				for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tElseExprInfo : elseExprInfo) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tElseExprInfo);
						if (!tRes.getValue1().isEmpty())
							nElseExprInfo.add(tRes);
					}
			}
			
			// Propagation: cross product between the 3 contributions
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,Expression> cExprInfo : nCondExprInfo)
				for (Triplet<FastISLDomain,FastISLDomain,Expression> tExprInfo: nThenExprInfo)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> eExprInfo: nElseExprInfo) {
						FastISLDomain nDomBlock = (FastISLDomain) cExprInfo.getValue0().intersection(tExprInfo.getValue0()).intersection(eExprInfo.getValue0());
						if (!nDomBlock.isEmpty()) {
							FastISLDomain nDomLocal = (FastISLDomain) cExprInfo.getValue1().intersection(tExprInfo.getValue1()).intersection(eExprInfo.getValue1());
							if (!nDomLocal.isEmpty())
								nSubExprToBeReplaced.add(Triplet.with(nDomBlock, nDomLocal,
										(Expression) _polyIRFact.createIfExpression(cExprInfo.getValue2(), tExprInfo.getValue2(), eExprInfo.getValue2())));
						}
					}
			
			_subExprToBeReplaced = nSubExprToBeReplaced;
			_ratioSubExpr = nratio;
		}
		
		@Override
		public void outUnaryExpression(UnaryExpression u) {
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::outUnaryExpression");
			
			
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> lnInfoExpr = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,Expression> tInfoSubExpr : _subExprToBeReplaced)
				lnInfoExpr.add(Triplet.with(tInfoSubExpr.getValue0(), tInfoSubExpr.getValue1(), (Expression)_polyIRFact.createUnaryExpression(u.getOperator(), tInfoSubExpr.getValue2())));
			
			// No change for _ratioSubExpr
			_subExprToBeReplaced = lnInfoExpr;
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression bexpr) {
			inBinaryExpression(bexpr);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitBinaryExpression - entering left branch");
			
			bexpr.getLexp().accept(this);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> lExprInfo = _subExprToBeReplaced;
			List<Integer> ratioLExpr = _ratioSubExpr;
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitBinaryExpression - entering right branch");
			
			bexpr.getRexp().accept(this);
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> rExprInfo = _subExprToBeReplaced;
			List<Integer> ratioRExpr = _ratioSubExpr;
			
			outBinaryExpression(bexpr);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitBinaryExpression - branches done");
			
			// Getting the new aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<ratioLExpr.size(); i++)
				nratio.add(scm(ratioLExpr.get(i),ratioRExpr.get(i)));
			
			/* DEBUG
			System.out.println("RatioBinExpression (op: " + bexpr.getOperator().toString() + ")");
			System.out.print("    - LeftExpr : [ ");
			for (int k : ratioLExpr)
				System.out.print(k + " ");
			System.out.println("]");
			System.out.print("    - RightExpr : [ ");
			for (int k : ratioRExpr)
				System.out.print(k + " ");
			System.out.println("]");
			System.out.print("    -> nRatio : [ ");
			for (int k : nratio)
				System.out.print(k + " ");
			System.out.println("]");
			//*/
			
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = bexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<bexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+bexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(bexpr.getExpressionDomain());
			
			
			// (i) Left expression
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nlExpr;
			
			boolean isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioLExpr.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nlExpr = lExprInfo;
			else {
				nlExpr = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				List<Triplet<FastISLDomain, FastISLDomain, FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioLExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				
				for (Triplet<FastISLDomain,FastISLDomain,Expression> tSubExprInfo : lExprInfo)
					for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tSubExprInfo);
						if (!tRes.getValue1().isEmpty())
							nlExpr.add(tRes);
					}
			}
			
			// (ii) Right expression
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nrExpr;
			
			isRatioSame = true;
			for (int k=0; k<nratio.size(); k++)
				if (nratio.get(k)!=ratioRExpr.get(k))
					isRatioSame = false;
			if (isRatioSame)
				nrExpr = rExprInfo;
			else {
				nrExpr = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
				
				// To make the aspect ratio compatible, we need to add an identity function and CART it
				List<Triplet<FastISLDomain, FastISLDomain, FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
						nratio, ratioRExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
				
				for (Triplet<FastISLDomain,FastISLDomain,Expression> tSubExprInfo : rExprInfo)
					for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart) {
						Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tSubExprInfo);
						if (!tRes.getValue1().isEmpty())
							nrExpr.add(tRes);
					}
			}
			
			// Propagation: cross product
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,Expression> lExpr : nlExpr)
				for (Triplet<FastISLDomain,FastISLDomain,Expression> rExpr : nrExpr) {
					FastISLDomain domBlockRes = (FastISLDomain) lExpr.getValue0().intersection(rExpr.getValue0());
					
					if (!domBlockRes.isEmpty()) {
						FastISLDomain domLocalRes = (FastISLDomain) lExpr.getValue1().intersection(rExpr.getValue1());
						if (!domLocalRes.isEmpty())
							nSubExprToBeReplaced.add(Triplet.with(domBlockRes, domLocalRes,
									(Expression) _polyIRFact.createBinaryExpression(bexpr.getOperator(),
											lExpr.getValue2().copy(), rExpr.getValue2().copy())));
					}
				}
			
			_subExprToBeReplaced = nSubExprToBeReplaced;
			_ratioSubExpr = nratio;
		}
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression mexpr) {
			inMultiArgExpression(mexpr);
			
			List<List<Triplet<FastISLDomain,FastISLDomain,Expression>>> lnExpr = new BasicEList<List<Triplet<FastISLDomain,FastISLDomain,Expression>>>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : mexpr.getExprs()) {
				expr.accept(this);
				lnExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			outMultiArgExpression(mexpr);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitMultiArgExpression - branches done");
			
			// New aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp, lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = mexpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<mexpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+mexpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(mexpr.getExpressionDomain());
			
			
			List<List<Triplet<FastISLDomain,FastISLDomain,Expression>>> lnnExpr = new BasicEList<List<Triplet<FastISLDomain,FastISLDomain,Expression>>>();
			for (int k=0; k<lnExpr.size(); k++) {
				List<Triplet<FastISLDomain,FastISLDomain,Expression>> subExprInfo = lnExpr.get(k);
				List<Integer> ratioExpr = lratio.get(k);
				List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprInfo;
				
				boolean isRatioSame = true;
				for (int l=0; l<nratio.size(); l++)
					if (nratio.get(l)!=ratioExpr.get(l))
						isRatioSame = false;
				if (isRatioSame)
					nSubExprInfo = subExprInfo;
				else {
					nSubExprInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
					
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
							nratio, ratioExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
					
					for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart)
						for (Triplet<FastISLDomain,FastISLDomain,Expression> tSubExprInfo : subExprInfo) {
							Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tSubExprInfo);
							if (!tRes.getValue1().isEmpty())
								nSubExprInfo.add(tRes);
						}
				}
				lnnExpr.add(nSubExprInfo);
			}
			
			
			// *** Cross product
			List<Triplet<FastISLDomain,FastISLDomain,List<Expression>>> lResBeforeMultiArg = new BasicEList<Triplet<FastISLDomain,FastISLDomain,List<Expression>>>();
			
			// (k=0)
			for (Triplet<FastISLDomain,FastISLDomain,Expression> tLnnExpr0 : lnnExpr.get(0)) {
				List<Expression> lExprTemp = new BasicEList<Expression>();
				lExprTemp.add(tLnnExpr0.getValue2());
				lResBeforeMultiArg.add(Triplet.with(tLnnExpr0.getValue0(),tLnnExpr0.getValue1(), lExprTemp));
			}
			
			// (k>0)
			for (int k=1; k<lnExpr.size(); k++) {
				List<Triplet<FastISLDomain,FastISLDomain,List<Expression>>> nlResBeforeMultiArg = new BasicEList<Triplet<FastISLDomain,FastISLDomain,List<Expression>>>();
				
				for (Triplet<FastISLDomain,FastISLDomain,List<Expression>> tlResBeforeMultiArg : lResBeforeMultiArg)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tLnnExprk : lnnExpr.get(k)) {
						FastISLDomain domBlock = (FastISLDomain) tlResBeforeMultiArg.getValue0().intersection(tLnnExprk.getValue0());
						if (!domBlock.isEmpty()) {
							FastISLDomain domLocal = (FastISLDomain) tlResBeforeMultiArg.getValue1().intersection(tLnnExprk.getValue1());
							if (!domLocal.isEmpty()) {
								List<Expression> lTemp = new BasicEList<Expression>();
								for (Expression exprTemp : tlResBeforeMultiArg.getValue2())
									lTemp.add(exprTemp.copy());
								lTemp.add(tLnnExprk.getValue2().copy());
								nlResBeforeMultiArg.add(Triplet.with(domBlock, domLocal, lTemp));
							}
						}
					}
				
				lResBeforeMultiArg = nlResBeforeMultiArg;
			}
			
			// (Creating the multi-arg expression)
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,List<Expression>> tResBeforeMultiArg : lResBeforeMultiArg) {
				nSubExprToBeReplaced.add(Triplet.with(tResBeforeMultiArg.getValue0(), tResBeforeMultiArg.getValue1(),
						(Expression) _polyIRFact.createMultiArgExpression(mexpr.getOperator(), tResBeforeMultiArg.getValue2())));
			}
			
			_subExprToBeReplaced = nSubExprToBeReplaced;
			_ratioSubExpr = nratio;
		}
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall eExpr) {
			inExternalFunctionCall(eExpr);
			
			List<List<Triplet<FastISLDomain,FastISLDomain,Expression>>> lnExpr = new BasicEList<List<Triplet<FastISLDomain,FastISLDomain,Expression>>>();
			List<List<Integer>> lratio = new BasicEList<List<Integer>>();
			for (Expression expr : eExpr.getExprs()) {
				expr.accept(this);
				lnExpr.add(_subExprToBeReplaced);
				lratio.add(_ratioSubExpr);
			}
			
			outExternalFunctionCall(eExpr);
			
			// Tracking
			if (_noisyTracking)
				System.out.println("TRACKING:::visitExternalFunctionCall - branches done");
			
			
			// New aspect ratio
			List<Integer> nratio = new BasicEList<Integer>();
			for (int i=0; i<lratio.get(0).size(); i++) {
				int temp = 1;
				for (int k=0; k<lratio.size(); k++)
					temp = scm(temp, lratio.get(k).get(i));
				nratio.add(temp);
			}
			
			/* DEBUG
			System.out.print("External Function -> ratio = [");
			for (int i=0; i<nratio.size(); i++)
				System.out.print(nratio.get(i) + " ");
			System.out.println("]");
			//*/
			
			// Managing the potential ratio conflicts by adding a Id dependence and CARTing it
			List<Variable> blockInd = new BasicEList<Variable>();
			List<Variable> localInd = new BasicEList<Variable>();
			List<String> lIndNames = eExpr.getExpressionDomain().getIndexNames();
			for (int j=0; j<eExpr.getExpressionDomain().getNIndices(); j++) {
				blockInd.add(_dimMana.getDimension(j, lIndNames.get(j) + suffixBlInd));
				localInd.add(_dimMana.getDimension(j+eExpr.getExpressionDomain().getNIndices(), lIndNames.get(j) + suffixLocInd));
			}
			AffineFunction iDFunc = PolyhedralIRUtility.createIdentityFunction(eExpr.getExpressionDomain());
			
			List<List<Triplet<FastISLDomain,FastISLDomain,Expression>>> lnnExpr = new BasicEList<List<Triplet<FastISLDomain,FastISLDomain,Expression>>>();
			for (int k=0; k<lnExpr.size(); k++) {
				List<Triplet<FastISLDomain,FastISLDomain,Expression>> exprInfo = lnExpr.get(k);
				List<Integer> ratioExpr = lratio.get(k);
				List<Triplet<FastISLDomain,FastISLDomain,Expression>> nExprInfo;
				
				boolean isRatioSame = true;
				for (int l=0; l<nratio.size(); l++)
					if (nratio.get(l)!=ratioExpr.get(l))
						isRatioSame = false;
				if (isRatioSame)
					nExprInfo = exprInfo;
				else {
					nExprInfo = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
					
					// To make the aspect ratio compatible, we need to add an identity function and CART it
					List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> idCart = CARTOperations.getTiledFunctionSplit(iDFunc, blockInd, localInd, _listBlockedParam, _listLocalParam,
							nratio, ratioExpr, _blSizeParam, _paramDiv, _minblSizeParam, _minParamValues);
					
					for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tIdCart : idCart)
						for (Triplet<FastISLDomain,FastISLDomain,Expression> tSubExprInfo : exprInfo) {
							Triplet<FastISLDomain,FastISLDomain,Expression> tRes = computeIdFuncPreImageInfoSubExpr(tIdCart, tSubExprInfo);
							if (!tRes.getValue1().isEmpty())
								nExprInfo.add(tRes);
						}
				}
				lnnExpr.add(nExprInfo);
			}
			
			// *** Cross product
			List<Triplet<FastISLDomain,FastISLDomain,List<Expression>>> lResBeforeExtFunc = new BasicEList<Triplet<FastISLDomain,FastISLDomain,List<Expression>>>();
			
			// (k=0)
			for (Triplet<FastISLDomain,FastISLDomain,Expression> tLnnExpr0 : lnnExpr.get(0)) {
				List<Expression> lExprTemp = new BasicEList<Expression>();
				lExprTemp.add(tLnnExpr0.getValue2());
				lResBeforeExtFunc.add(Triplet.with(tLnnExpr0.getValue0(),tLnnExpr0.getValue1(), lExprTemp));
			}
			
			// (k>0)
			for (int k=1; k<lnExpr.size(); k++) {
				List<Triplet<FastISLDomain,FastISLDomain,List<Expression>>> nlResBeforeExtFunc = new BasicEList<Triplet<FastISLDomain,FastISLDomain,List<Expression>>>();
				
				for (Triplet<FastISLDomain,FastISLDomain,List<Expression>> tlResBeforeExtFunc : lResBeforeExtFunc)
					for (Triplet<FastISLDomain,FastISLDomain,Expression> tLnnExprk : lnnExpr.get(k)) {
						FastISLDomain domBlock = (FastISLDomain) tlResBeforeExtFunc.getValue0().intersection(tLnnExprk.getValue0());
						if (!domBlock.isEmpty()) {
							FastISLDomain domLocal = (FastISLDomain) tlResBeforeExtFunc.getValue1().intersection(tLnnExprk.getValue1());
							if (!domLocal.isEmpty()) {
								List<Expression> lTemp = new BasicEList<Expression>();
								for (Expression exprTemp : tlResBeforeExtFunc.getValue2())
									lTemp.add(exprTemp.copy());
								lTemp.add(tLnnExprk.getValue2().copy());
								nlResBeforeExtFunc.add(Triplet.with(domBlock, domLocal, lTemp));
							}
						}
					}
				
				lResBeforeExtFunc = nlResBeforeExtFunc;
			}
			
			// (Creating the multi-arg expression)
			List<Triplet<FastISLDomain,FastISLDomain,Expression>> nSubExprToBeReplaced = new BasicEList<Triplet<FastISLDomain,FastISLDomain,Expression>>();
			for (Triplet<FastISLDomain,FastISLDomain,List<Expression>> tResBeforeMultiArg : lResBeforeExtFunc) {
				nSubExprToBeReplaced.add(Triplet.with(tResBeforeMultiArg.getValue0(), tResBeforeMultiArg.getValue1(),
						(Expression) _polyIRFact.createExternalFunctionCall(eExpr.getExFunc(), tResBeforeMultiArg.getValue2())));
			}
			_subExprToBeReplaced = nSubExprToBeReplaced;
			
			_ratioSubExpr = nratio;
			
		}
		
		// Auxilliary function
		
		/**
		 * Remove the constraints with a local parameter/index contribution while keeping the dimensions
		 * @param fullDom
		 * @param nIndScal
		 * @return
		 */
		private static FastISLDomain removeLocalParamIndexes(FastISLDomain fullDom, int nIndScal) {
			int nParamScal = (fullDom.getNParams()-1)/2;
			int nParamBl = (fullDom.getNParams()-1)/2;
			int nIndBl = fullDom.getNIndices()-nIndScal;
			
			// Remove the constraints on the local parameter and indexes while keeping all dimensions
			JNIISLSet set = fullDom.getIslSet().copy();
			set = set.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_param, nParamBl, nParamScal+1);
			set = set.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_set, nIndBl, nIndScal);
			return _polyIRFact.createFastISLDomain(fullDom.getDomDims(), set);
		}
		
		
	} // ParametricTilingVisitor
	
	/**
	 * Find the aspect ratio of a variable inside the user-provided mapping. If a variable is not specified, take a ratio = Id
	 * @param mVarScale
	 * @param varName
	 * @param dimVar
	 * @return
	 */
	private static List<Integer> getRatioVariable(Map<String,List<Integer>> mVarScale, String varName, int dimVar) {
		List<Integer> ratio = new BasicEList<Integer>();
		if (mVarScale.containsKey(varName)) {
			ratio = mVarScale.get(varName);
		} else
			for (int i=0; i<dimVar; i++)
				ratio.add(1);
		return ratio;
	}
	
	/**
	 * Check if a divides b
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean divides(int a, int b) {
		return (b % a == 0);
	}
	
	/**
	 * Computes the greatest common divisor of a and b
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd(int a, int b) {
		// Invariant: a,b>=0 and a>=b
		if (a<0)
			a = -a;
		if (b<0)
			b = -b;
		if (a<b)
			gcd(b,a);
		
		// Main cases
		if (b==0)
			return a;
		return gcd(b, a%b);
	}
	
	/**
	 * Computes the smallest common multiplicator of a and b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int scm(int a, int b) {
		int gcdAB = gcd(a,b);
		int aDivGcd = a/gcdAB;
		int bDivGcd = b/gcdAB;
		return (aDivGcd*bDivGcd*gcdAB);
	}
	
	/**
	 * Translate domains on only block/local params into domains on the full dimensions/parameters
	 * 
	 * @param domPart
	 * @param lParamFull
	 * @param lIndFull
	 * @return
	 */
	private static FastISLDomain translateToFullDimension(FastISLDomain domPart, List<Variable> lParamFull, List<Variable> lIndFull, boolean isBlockDom) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(lIndFull, lParamFull);
		
		JNIISLSet islSet = domPart.getIslSet().copy();
		
		int nParam = islSet.getNbDims(JNIISLDimType.isl_dim_param);
		int nDim = islSet.getNbDims(JNIISLDimType.isl_dim_set);
		if (isBlockDom) {
			islSet = islSet.addDims(JNIISLDimType.isl_dim_param, lParamFull.size()-nParam);
			
			for (int i=nParam; i<lParamFull.size(); i++)
				islSet = islSet.setDimName(JNIISLDimType.isl_dim_param, i, lParamFull.get(i).getName());
			
			islSet = islSet.addDims(JNIISLDimType.isl_dim_set, lIndFull.size()-nDim);
		} else {
			islSet = islSet.insertDims(JNIISLDimType.isl_dim_param, 0, lParamFull.size()-nParam);
			
			for (int i=0; i<lParamFull.size()-nParam; i++)
				islSet = islSet.setDimName(JNIISLDimType.isl_dim_param, i, lParamFull.get(i).getName());
			
			islSet = islSet.insertDims(JNIISLDimType.isl_dim_set, 0, lIndFull.size()-nDim);
		}
		
		FastISLDomain dom1 =  _polyIRFact.createFastISLDomain(domDims, islSet);
		return dom1;
		
		
		
		/* OLD CODE
		List<IntConstraintSystem> lsystPart = domPart.getPMdomain().getPolyhedra();
		List<IntConstraintSystem> lsystPartCopy = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem syst : lsystPart)
			lsystPartCopy.add(syst.copy());				// Note: the individual copy of the IntConstraintSystem is needed.
		// Note: for this method to work, we need to have the same index name in the constraints of domPart and lIndFull
		FastISLDomain dom2 = _polyIRFact.createFastISLDomain(_polyFact.createDomain(lIndFull, lParamFull, lsystPartCopy));
		//*/
	}
	
	// Main operations => moved to org.polymodel.polyhdralIR.transformation.helper.CARTOperations
	
	/**
	 * Auxiliary method to commute a CARTed ID function with a list of triplet corresponding to a subexpression
	 * 
	 * @param tPartialFunc
	 * @param tInfoSubExpr
	 * @return
	 */
	private static Triplet<FastISLDomain,FastISLDomain,Expression> computeIdFuncPreImageInfoSubExpr(Triplet<FastISLDomain,FastISLDomain,FastISLMap> tPartialFunc,
			Triplet<FastISLDomain,FastISLDomain,Expression> tInfoSubExpr) {
		
		// 1) Cut "tPartialFunc.getValue2()" in 2 parts (other part is replaced by Id)
		JNIISLBasicMap bMap1 = tPartialFunc.getValue2().getIslMap().copy();
		JNIISLBasicMap bMap2 = bMap1.copy();
		
		int nDimsOut = bMap1.getNbDims(JNIISLDimType.isl_dim_out);
		int nHalfDims = nDimsOut/2;
		
		bMap1 = bMap1.projectOut(JNIISLDimType.isl_dim_out, nHalfDims, nDimsOut-nHalfDims);
		bMap2 = bMap2.projectOut(JNIISLDimType.isl_dim_out, 0, nHalfDims);
		
		FastISLMap affFuncTemp1 = _polyIRFact.createFastISLMap(tPartialFunc.getValue0().getDomDims(), bMap1,
				tPartialFunc.getValue2().getLabelIn(), tPartialFunc.getValue2().getLabelOut());
		FastISLMap affFuncTemp2 = _polyIRFact.createFastISLMap(tPartialFunc.getValue0().getDomDims(), bMap2,
				tPartialFunc.getValue2().getLabelIn(), tPartialFunc.getValue2().getLabelOut());
		
		/* OLD CODE
		List<AffineExpression> lAffFuncExpr = tPartialFunc.getValue2().getExpressions();
		List<AffineExpression> lExprPartFunc1 = new BasicEList<AffineExpression>();
		List<AffineExpression> lExprPartFunc2 = new BasicEList<AffineExpression>();
		for (int k=0; 2*k<lAffFuncExpr.size(); k++) {
			lExprPartFunc1.add(lAffFuncExpr.get(k));
		}
		for (int k=lAffFuncExpr.size()/2; k<lAffFuncExpr.size(); k++) {
			lExprPartFunc2.add(lAffFuncExpr.get(k));
		}
		
		FastISLMap affFuncTemp1 =_polyIRFact.createFastISLMap(
				_polyIRFact.createAffineFunction(tPartialFunc.getValue0().getParams(), tPartialFunc.getValue0().getIndices(), lExprPartFunc1).getPMmapping());
		FastISLMap affFuncTemp2 = _polyIRFact.createFastISLMap(
				_polyIRFact.createAffineFunction(tPartialFunc.getValue1().getParams(), tPartialFunc.getValue1().getIndices(), lExprPartFunc2).getPMmapping());
		*/
		
		
		
		// 2) Compute the preimages of "tInfoSubExpr.getValue0()" and "tInfoSubExpr.getValue1()"
		//  Then, intersect it with the (Domain,Domain) from tPartialFunc
		// Optim: the first Domain is always the universe !
		FastISLDomain domBlockTemp = (FastISLDomain) tInfoSubExpr.getValue0().preimage(affFuncTemp1);
		FastISLDomain domBlockLoc = (FastISLDomain) tInfoSubExpr.getValue1().preimage(affFuncTemp2).intersection(tPartialFunc.getValue1());
		
		return Triplet.with(domBlockTemp,domBlockLoc,
				(Expression) _polyIRFact.createDependenceExpression(tPartialFunc.getValue2().copy(), tInfoSubExpr.getValue2().copy()));
	}
	
	/**
	 * Auxiliary method to gather computation according to their block indexes
	 * 
	 * @param infoSubExpr
	 * @return
	 */
	private static List<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>> coalescedBlocks(List<Triplet<FastISLDomain,FastISLDomain,Expression>> infoSubExpr) {
		List<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>> lCoalescedInfoSubExpr = new BasicEList<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>>();
		
		// First triplet
		Triplet<FastISLDomain,FastISLDomain,Expression> tFirstInfoSubExpr = infoSubExpr.get(0);
		List<Pair<FastISLDomain,Expression>> lpDomExprFirst = new BasicEList<Pair<FastISLDomain,Expression>>();
		lpDomExprFirst.add(Pair.with(tFirstInfoSubExpr.getValue1(),tFirstInfoSubExpr.getValue2()));
		lCoalescedInfoSubExpr.add(Pair.with(tFirstInfoSubExpr.getValue0(), lpDomExprFirst));
		
		// We add the information of each triplet one by one to lCoalescedInfoSubExpr
		for (int k=1; k<infoSubExpr.size(); k++) {
			Triplet<FastISLDomain,FastISLDomain,Expression> tkInfoSubExpr = infoSubExpr.get(k);
			
			/* DEBUG
			System.out.println(" ~~~~ New triplet: " + tkInfoSubExpr);
			System.out.println(" ~~~~ Current lCoalescedInfoSubExpr = ");
			for (Pair<Domain,List<Pair<Domain,Expression>>> pTemp1 : lCoalescedInfoSubExpr) {
				System.out.println(" * " + pTemp1.getValue0().toString());
				for (Pair<Domain,Expression> pTemp2 : pTemp1.getValue1())
					System.out.println("		- " + pTemp2.getValue0().toString() + "  " + PolyhedralIRToAlphabets.toString(pTemp2.getValue1()));
			}
			System.out.println();
			//*/
			
			List<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>> nlCoalescedInfoSubExpr = new BasicEList<Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>>>();
			FastISLDomain domBl = (FastISLDomain) tkInfoSubExpr.getValue0().copy();	//  Set of points covered
			
			for (Pair<FastISLDomain,List<Pair<FastISLDomain,Expression>>> pDomBlLocExpr : lCoalescedInfoSubExpr) {
				FastISLDomain domInter = (FastISLDomain) pDomBlLocExpr.getValue0().intersection(tkInfoSubExpr.getValue0());
				if (domInter.isEmpty())		// No change to this list
					nlCoalescedInfoSubExpr.add(pDomBlLocExpr);
				else {
					// Because all the case are disjoint, the local domains must be also disjoint... => we can directly add the triplet to the list of pair					
					List<Pair<FastISLDomain,Expression>> lDomLocalExprInter = new BasicEList<Pair<FastISLDomain,Expression>>();
					lDomLocalExprInter.addAll(pDomBlLocExpr.getValue1());
					lDomLocalExprInter.add(Pair.with(tkInfoSubExpr.getValue1(), tkInfoSubExpr.getValue2().copy()));
					nlCoalescedInfoSubExpr.add(Pair.with(domInter,lDomLocalExprInter));
					
					// Rest of the pair which does not intersect: we add a new entry for each polyhedron inside domDiff
					FastISLDomain domDiff = (FastISLDomain) pDomBlLocExpr.getValue0().difference(domInter);
					
					
					List<JNIISLBasicSet> lbSet = domDiff.getIslSet().getBasicSets();
					for (int l=0; l<lbSet.size(); l++) {
						JNIISLBasicSet bSet = lbSet.get(l).copy();
						FastISLDomain domPolyDiff = _polyIRFact.createFastISLDomain(tkInfoSubExpr.getValue0().getDomDims(), bSet.toSet());
						
						List<Pair<FastISLDomain,Expression>> lDomLocalExprDiff = new BasicEList<Pair<FastISLDomain,Expression>>();
						lDomLocalExprDiff.addAll(pDomBlLocExpr.getValue1());
						
						if (!domPolyDiff.isEmpty())
							nlCoalescedInfoSubExpr.add(Pair.with(domPolyDiff,lDomLocalExprDiff));
					}
					
					/* OLD CODE
					for (int l=0; l<domDiff.getPMdomain().getPolyhedra().size(); l++) {
						IntConstraintSystem syst = domDiff.getPMdomain().getPolyhedra().get(l);
						
						List<Pair<FastISLDomain,Expression>> lDomLocalExprDiff = new BasicEList<Pair<FastISLDomain,Expression>>();
						lDomLocalExprDiff.addAll(pDomBlLocExpr.getValue1());
						
						List<IntConstraintSystem> lsystDiff = new BasicEList<IntConstraintSystem>();
						lsystDiff.add(syst.copy());
						
						FastISLDomain domPolyDiff = _polyIRFact.createFastISLDomain(_polyFact.createDomain(tkInfoSubExpr.getValue0().getIndices(),
								tkInfoSubExpr.getValue0().getParams(),lsystDiff));
						
						if (!domPolyDiff.isEmpty())
							nlCoalescedInfoSubExpr.add(Pair.with(domPolyDiff,lDomLocalExprDiff));
					}
					*/
					
					// Update of domBl
					domBl = (FastISLDomain) domBl.difference(domInter);
					domBl.simplify();
				}
			}

			
			
			
			// If domBl is still not empty, create a new entry for itself
			if (!domBl.isEmpty()) {
				for (int l=0; l<domBl.getPMdomain().getPolyhedra().size();l++) {
					IntConstraintSystem syst = domBl.getPMdomain().getPolyhedra().get(l);
					
					List<Pair<FastISLDomain,Expression>> lDomLocalExprRest = new BasicEList<Pair<FastISLDomain,Expression>>();
					lDomLocalExprRest.add(Pair.with(tkInfoSubExpr.getValue1(),tkInfoSubExpr.getValue2()));
					
					List<IntConstraintSystem> lsystRest = new BasicEList<IntConstraintSystem>();
					lsystRest.add(syst.copy());
					FastISLDomain domPolyRest = _polyIRFact.createFastISLDomain(
							(org.polymodel.Domain)_polyFact.createDomain(tkInfoSubExpr.getValue0().getIndices(), tkInfoSubExpr.getValue0().getParams(), lsystRest));
					
					nlCoalescedInfoSubExpr.add(Pair.with(domPolyRest,lDomLocalExprRest));
				}
			}
			
			lCoalescedInfoSubExpr = nlCoalescedInfoSubExpr;	// Pushing the update
		}
		
		return lCoalescedInfoSubExpr;
	}
	
} // ParametricTiling
