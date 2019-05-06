package org.polymodel.polyhedralIR.transformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Septet;
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
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
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
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class ParametricTilingOutlining {
	
	private static PolymodelDefaultFactory _polyFact = PolymodelComponent.INSTANCE.getFactory();
	private static PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	private static DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
	
	private final static boolean _timing = true;		// TODO
	
	// Option outputs refined => modify the outputs and data which are communicated between the subsystems
	//		- if "True", each subsystems (after outlining) will return the data needed, separated according to the tile which ask
	//				(might introduce redundancies of copies)
	//		- if "False", each subsystems (after outlining) will have one output per data needed outside (and a block)
	//				In other words, the data returned by a subsystem is not differentiated according to the subsystem which uses it
	public static boolean _optionOutputsRefined = true;
	
	// Option Homogenization => "completes" the domains of the output of the subsystems, such that the domain is the same
	//			across every kind of tiles (a.k.a. cuts) for a given variable. This allows the domain of the corresponding "gathering" variable
	//			in the main system to be a single polyhedron, instead of a union of (potentially numerous) polyhedra (which increases a lot
	//			the computation time and the size of the program)
	public static boolean _optionHomogenization = true;
	
	
	// Option Reduce the dimension of the input and output variables => Reduce the dimensions of the input and output variables
	//				and align it with the "\vec{0}" point (in order to ease code generation)
	public static boolean _optionPostprocessReduceDimInOutputVariable = false;
	
	
	// Option Save some information (for example which variable of a subsystem corresponds to which original variable)
	//		in a separate data structure for later
	public static boolean _optionSaveInformations = false;
	public static Septet<List<List<Map<String,VariableDeclaration>>>,
			Map<String,List<Pair<long[][],VariableDeclaration>>>,
			Map<String,List<Pair<long[][],List<Expression>>>>,
			Map<String,List<AffineFunction>>,
			List<List<String>>,
			Map<String,Pair<FastISLMap,String>>,
			List<List<Pair<String, Boolean>>>> _dataStructSaved = Septet.with(null, null, null, null, null, null, null);
	// 1st element: llVarDeclSubSyst (Tile group / Kind of tile / mapping old var to corresponding local variable declaration
	// 2nd element: mStrVarDeclCase (Main syst / correspondance orig var => gather var)
	// 3rd element: mInternalCaseExpr (Main syst / correspondance gather var => outputs useEq)
	// 4th element: mlAlignOut (info about post-processing)
	// 5th element: List of subsystem name, classified by tile group
	// 6th element: Map associating the name of a "TempRed/SG" variable, with the projection function and the father variable
	// 7th element: nlAlignmentInfo (tile group / kind of tile / name of variable + boolean which is true iff it's a TempRedSG)
	
	// TODO: data structure (global right now... should try to find a cleaner solution... :/ )
	
	
	
	/**
	 * Main transformation function, should be called only after doing the ParametricTiling-CART with prep outlining transformation
	 * @param prog
	 * @param syst
	 * @param llTileGroups
	 * @param mProjFuncRedTemp
	 */
	public static void outlineAfterCart(Program prog, AffineSystem syst, 
			List<List<String>> llTileGroups, Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp) {
		// *** STEP 1: preparing for the outlining
		List<List<Pair<String, Boolean>>> lNAlignmentInfo;
		if (mProjFuncRedTemp.isEmpty()) {		// No reduction in the system
			
			// Adapt the dependences of the program to make them as close of Id as possible
			// Example: if iBl=jBl=0 and we have a dependence L[jBl,jBl,...] => transform it into L[iBl,jBl,...]
			//		Useful to reduce the number of inputs
			makeDepCloseToId(syst);
			
			LowerDepPartialContextDom.preprocessBeforeOutlining(syst, mProjFuncRedTemp, true);
			if (_timing)
				ParametricTiling.printInfoDebug("Preprocessing outlining - Lower Dependence");
			
			// Translation of llTileGroups into the new one
			lNAlignmentInfo = new BasicEList<List<Pair<String,Boolean>>>();
			for (List<String> lTileGroups : llTileGroups) {
				List<Pair<String, Boolean>> lpVarBool = new BasicEList<Pair<String,Boolean>>();
				for (String varName : lTileGroups) {
					lpVarBool.add(Pair.with(varName, false));
				}
				lNAlignmentInfo.add(lpVarBool);
			}
			if (_timing)
				ParametricTiling.printInfoDebug("Preprocessing outlining - no reduction => no update of the tilegroup info");
		} else {								// Reduction to be managed in the system
			LowerDepPartialContextDom.preprocessBeforeOutlining(syst, mProjFuncRedTemp, false);
			if (_timing)
				ParametricTiling.printInfoDebug("Preprocessing outlining - Lower Dependence");

			// Adapt the dependences of the program to make them as close of Id as possible
			// Example: if iBl=jBl=0 and we have a dependence L[jBl,jBl,...] => transform it into L[iBl,jBl,...]
			//		Useful to reduce the number of inputs
			makeDepCloseToId(syst);
			
			// DEBUG
			//System.out.println(AShow.toString(prog));
			//System.out.println("**************************************************");
			
			// Boolean of lNAlignmentInfo = is a TempRed in a normal tile group? (thus, if there more dimensions?)
			lNAlignmentInfo = tempRedTileGroups(syst, llTileGroups, mProjFuncRedTemp);
			if (_timing)
				ParametricTiling.printInfoDebug("Preprocessing outlining - Update of the tilegroup info");
			
			// DEBUG
			//System.out.println(lNAlignmentInfo.toString());
			//System.out.println(AShow.toString(prog));
			//System.out.println("**************************************************");
			
			// Note: at this point, the whole program is normalized, except potentially the expressions under some reductions
			//	which might be of the form:
			//		red(op, \pi_on_block_indexes, IdDep@(case
			//				D_{alpha,1} : TempRed_SG;
			//				D_{alpha,2} : TempRed;
			//			esac) )
			//	=> need to normalize that (i.e., bring the case expression "up")
			
			/* DEBUG
			System.out.println("************************************************");
			System.out.println(AShow.toString(syst));
			System.out.println();
			System.out.println(UniquenessAndCompletenessCheck.validate(syst));
			System.out.println("************************************************");
			//*/
			
			CustomCommutationCaseReduction.normalizeAfterTempRed(syst);
			
			/* DEBUG
			System.out.println("************************************************");
			System.out.println(AShow.toString(syst));
			System.out.println();
			System.out.println(UniquenessAndCompletenessCheck.validate(syst));
			System.out.println("************************************************");
			//*/
			
			quickEliminationEmptyBranches(syst);
			
			// DEBUG
			//System.out.println("************************************************");
			//System.out.println(AShow.toString(syst));
			//System.out.println("************************************************");
			
			// Second normalization + computing the context domain at the dependence level
			LowerDepPartialContextDom.preprocessBeforeOutlining(syst, mProjFuncRedTemp, true);
		}
		
		/* DEBUG
		System.out.println("************************************************");
		System.out.println(PolyhedralIRToAlphabets.toString(syst));
		System.out.println(UniquenessAndCompletenessCheck.validate(syst));
		System.out.println("************************************************");
		//*/
		
		
		// *** STEP 2: Outlining transformation
		if (_timing)
			ParametricTiling.printInfoDebug("*** Outlining - 0) Starting... ");
		getSubsystemAfterCART(prog, syst, lNAlignmentInfo, mProjFuncRedTemp);
		if (_timing)
			ParametricTiling.printInfoDebug("Transformation done");
	}
	
	/* ----------------------------------------- PREPROCESSING -------------------------------------------- */
	public static Map<Expression,FastISLDomain> mContextDomainVarExpr = new HashMap<Expression,FastISLDomain>();	// Context domain of the variable expression found
	
	private static class LowerDepPartialContextDom extends PolyhedralIRDepthFirstVisitorImpl {
		// Pre-processing of the outlining step, combining in one visitor:
		//		- the LowerDependence transformation
		//		- Collecting the information on the context domain of the variable expressions (only if "computeContextDomain==true")
		
		// WARNING: This transformation should be applied only after the CART (with outlining preparation) transformation
		
		public static void preprocessBeforeOutlining(AffineSystem syst,  Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp,
				boolean computeContextDomain) {
			syst.accept(new LowerDepPartialContextDom(mProjFuncRedTemp,computeContextDomain));
		}
		
		public LowerDepPartialContextDom(Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp, boolean computeContextDomain) {
			_mProjFuncRedTemp = mProjFuncRedTemp;
			_computeContextDomain = computeContextDomain;
		}
		
		private static boolean _computeContextDomain;
		
		private static Map<String,Pair<FastISLMap,String>> _mProjFuncRedTemp;
		private static boolean _reductionAlreadyEncountered;
		private static FastISLDomain _currentContext;
		private static FastISLMap _currentDep;
		private static Expression _sExprToBeReplaced;
		
		private static boolean _pruneBranch = false;		// only when _computeContextDomain is enabled
		
		@Override
		public void visitStandardEquation(StandardEquation stEq) {
			if (_computeContextDomain) {
				_currentContext = (FastISLDomain) stEq.getVariable().getDomain();
				_pruneBranch = false;
			}
			_currentDep = _polyIRFact.createFastISLMap(PolyhedralIRUtility.createIdentityFunction(stEq.getVariable().getDomain()).getPMmapping());
			_reductionAlreadyEncountered = false;
			
			stEq.getExpression().accept(this);
			
			if (_pruneBranch) {
				stEq.setExpression(_polyIRFact.createCaseExpression(new BasicEList<Expression>()));		// pruned => should not happen
			} else {
				stEq.setExpression(_sExprToBeReplaced);
			}
			
		}
		
		// *** Computation
		@Override
		public void visitRestrictExpression(RestrictExpression restExpr) {
			// Done to select only the needed polyhedra (-dron ???)
			if (_computeContextDomain) {
				_currentContext =(FastISLDomain) _currentContext.intersection(restExpr.getRestrictDomain());
				_currentContext.simplify();
			}
			Domain nDomRestr = restExpr.getRestrictDomain().preimage(_currentDep);
			
			restExpr.getExpr().accept(this);
			
			_sExprToBeReplaced = _polyIRFact.createRestrictExpression(nDomRestr, _sExprToBeReplaced);
		}
		
		@Override
		public void visitDependenceExpression(DependenceExpression depExpr) {
			_currentDep = (FastISLMap) depExpr.getDep().compose(_currentDep);
			
			// No change of _currentContext (the dependence will be removed)
			
			depExpr.getExpr().accept(this);
			
			// No change of _sExprToBeReplaced : the dependence is removed
		}
		
		@Override
		public void visitReduceExpression(ReduceExpression redExpr) {
			// dep @ red(op, f, expr) -> red(op, f1, dep1@expr)
			FastISLMap projFunc = (FastISLMap) redExpr.getProjection();
			FastISLMap depG = _currentDep;
			
			// QUESTION for f1 => Are we currently considering a dependence whose projection function is:
			//  1) (\alpha_1,\alpha_2,ii_1,ii_2 -> \alpha_1,\alpha_2,ii_1) ?
			//		=> Inside the equation of a "TempRed" which should be inside _mProjFuncRedTemp
			//		=> Should return "(\alpha_1,\alpha_2,ii_1,ii_2 -> \alpha_1,\alpha_2,ii_1)" as a projection function
			//  2) (\alpha_1,\alpha_2,ii_1 -> \alpha_1,ii_1) ?
			//		=> Not inside a "TempRed"
			//		=> Should return "(\alpha_1,\alpha_2,ii_1 -> \alpha_1,ii_1)" as a projection function
			// ===> In both cases, we can take "f1 = f" safely... :)
			
			
			// Criterion: Check if the variable of the current equation is inside _mProjFuncRedTemp
			//		=> If no, second case (and we are in the first reduction encountered in this equation)
			//		=> If yes, check that there were no reduction encountered before
			//			=> If no reduction encountered before, first case
			//			=> Else, second case
			//	Note: we cannot have more that 2 reductions in the same equation
			
			boolean isThatAReductionOnBlockedDim;	// 2) = true
			
			String nameVarEq = ( (StandardEquation) redExpr.getContainerEquation()).getVariable().getName();
			if (_mProjFuncRedTemp.containsKey(nameVarEq) && !_reductionAlreadyEncountered) {
				isThatAReductionOnBlockedDim = false;
			} else
				isThatAReductionOnBlockedDim = true;
			
			// In both cases, we can keep the same projection function => f=f1 !!
			FastISLMap f1 = (FastISLMap) projFunc.copy();
			
			// Define f' as "Id-like" projection function
			//int qDim = projFunc.getNIndices() + depG.getNIndices() - depG.getDimRHS();
			//long[][] linF1 = new long[depG.getDimRHS()][qDim];
			//for (int i=0; i<linF1.length; i++)
			//	linF1[i][i] = 1;
			//List<Variable> lIndsf1 = new BasicEList<Variable>();
			//for (int i=0; i<qDim; i++)
			//	lIndsf1.add(_dimMana.getDimension(i));
			//AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[depG.getDimRHS()][0],
			//		linF1, new long[depG.getDimRHS()], depG.getParams(), lIndsf1);
			
			// Define g' = f_{right inverse} o g o f'
			AffineFunction fRInv = FunctionOperations.computeRightInverse(projFunc);
			FastISLMap gf1 = (FastISLMap) depG.compose(f1);
			AffineFunction g1 = fRInv.compose(gf1);		// g1
			
			// Subtility in the algorithm: in g1, the projected dimensions are set to "0"...
			//			... and we want the actual projected indexes here
			// ===> Hand modify g1 into g1New by correcting these 0
			FastISLMap g1New;
			if (isThatAReductionOnBlockedDim) {
				// Need to rewrite the dimensions corresponding to \alpha_2
				List<AffineExpression> lAffExprG1 = g1.getExpressions();
				
				List<AffineExpression> lExprG1 = new BasicEList<AffineExpression>();
				int sizeAlpha1 = projFunc.getDimRHS()/2;
				int sizeAlpha2 = projFunc.getNIndices() - projFunc.getDimRHS();
				for (int k=0; k<sizeAlpha1; k++)
					lExprG1.add(lAffExprG1.get(k));
				for (int k=0; k<sizeAlpha2; k++)
					lExprG1.add(IntExpressionBuilder.affine(g1.getIndices().get(sizeAlpha1+k)));
				for (int k=0; k<sizeAlpha1; k++)
					lExprG1.add(lAffExprG1.get(sizeAlpha1+sizeAlpha2+k));
				
				g1New = _polyIRFact.createFastISLMap(PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(g1.getParams(), g1.getIndices(), lExprG1).getPMmapping());
			} else {
				// Need to rewrite the dimensions corresponding to ii_2
				List<AffineExpression> lAffExprG1 = g1.getExpressions();
				
				List<AffineExpression> lExprG1 = new BasicEList<AffineExpression>();
				int sizeAlpha1 = projFunc.getDimRHS() - projFunc.getNIndices()/2;
				int sizeAlpha2 = projFunc.getNIndices()/2 - sizeAlpha1;
				for (int k=0; k<projFunc.getDimRHS(); k++)
					lExprG1.add(lAffExprG1.get(k));
				for (int k=0; k<sizeAlpha2; k++)
					lExprG1.add(IntExpressionBuilder.affine(g1.getIndices().get(projFunc.getDimRHS()+k)));
				
				g1New = _polyIRFact.createFastISLMap(PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(g1.getParams(), g1.getIndices(), lExprG1).getPMmapping());
			}
			_currentDep = g1New;
			
			if (_computeContextDomain)
				_currentContext = (FastISLDomain) _currentContext.preimage(f1);
			
			boolean OldRedAlreadyEncountered = _reductionAlreadyEncountered;
			_reductionAlreadyEncountered = true;
			redExpr.getExpr().accept(this);
			_reductionAlreadyEncountered = OldRedAlreadyEncountered;
			
			_sExprToBeReplaced = _polyIRFact.createReduceExpression(redExpr.getOP(), f1, _sExprToBeReplaced);
		}
		
		
		// *** Propagation (no real algorithmic part here, except prunning)
		@Override
		public void visitCaseExpression(CaseExpression caseExpr) {
			FastISLMap origCurrentDep = (FastISLMap) _currentDep.copy();
			
			FastISLDomain origCurrentContext = null;
			if (_computeContextDomain)
				origCurrentContext = (FastISLDomain) _currentContext.copy();
			
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : caseExpr.getExprs()) {
				sExpr.accept(this);
				
				if (!_pruneBranch)
					lSExprToBeReplaced.add(_sExprToBeReplaced);
				
				// Reinitializing the top-down recursion
				_pruneBranch = false;
				_currentDep = (FastISLMap) origCurrentDep.copy();
				if (_computeContextDomain)
					_currentContext = origCurrentContext;
			}
			
			if (lSExprToBeReplaced.isEmpty())
				_pruneBranch = true;
			_sExprToBeReplaced = _polyIRFact.createCaseExpression(lSExprToBeReplaced);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression binExpr) {
			FastISLMap origCurrentDep = (FastISLMap) _currentDep.copy();
			
			FastISLDomain origCurrentContext = null;
			if (_computeContextDomain)
				origCurrentContext = (FastISLDomain) _currentContext.copy();
			
			binExpr.getLexp().accept(this);
			Expression sExprLeft = _sExprToBeReplaced;

			// Reinitializing the top-down recursion
			_currentDep = origCurrentDep;
			if (_computeContextDomain)
				_currentContext = origCurrentContext;
			
			binExpr.getRexp().accept(this);
			Expression sExprRight = _sExprToBeReplaced;
			
			_sExprToBeReplaced = _polyIRFact.createBinaryExpression(binExpr.getOperator(), sExprLeft, sExprRight);
		};
		
		@Override
		public void visitUnaryExpression(UnaryExpression unExpr) {
			// No change at _currentContext/_currentDep
			unExpr.getExpr().accept(this);
			
			_sExprToBeReplaced = _polyIRFact.createUnaryExpression(unExpr.getOperator(), _sExprToBeReplaced);
		}
		
		@Override
		public void visitIfExpression(IfExpression ifExpr) {
			FastISLMap origCurrentDep = (FastISLMap) _currentDep.copy();
			FastISLDomain origCurrentContext = null;
			if (_computeContextDomain)
				origCurrentContext = (FastISLDomain) _currentContext.copy();
			
			ifExpr.getCond().accept(this);
			Expression sExprCond = _sExprToBeReplaced;
			_currentDep = origCurrentDep;
			if (_computeContextDomain)
				_currentContext = origCurrentContext;
			
			ifExpr.getThen().accept(this);
			Expression sExprThen = _sExprToBeReplaced;
			_currentDep = origCurrentDep;
			if (_computeContextDomain)
				_currentContext = origCurrentContext;
			
			ifExpr.getElse().accept(this);
			Expression sExprElse = _sExprToBeReplaced;
			_currentDep = origCurrentDep;
			if (_computeContextDomain)
				_currentContext = origCurrentContext;
			
			_sExprToBeReplaced = _polyIRFact.createIfExpression(sExprCond, sExprThen, sExprElse);
		};
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression multExpr) {
			FastISLMap origCurrentDep = (FastISLMap) _currentDep.copy();
			FastISLDomain origCurrentContext = null;
			if (_computeContextDomain)
				origCurrentContext = (FastISLDomain) _currentContext.copy();
			
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : multExpr.getExprs()) {
				sExpr.accept(this);
				lSExprToBeReplaced.add(_sExprToBeReplaced);
				
				// Reinitializing the top-down recursion
				_currentDep = origCurrentDep;
				if (_computeContextDomain)
					_currentContext = origCurrentContext;
			}
			
			_sExprToBeReplaced = _polyIRFact.createMultiArgExpression(multExpr.getOperator(), lSExprToBeReplaced);
		};
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall extFunc) {
			FastISLMap origCurrentDep = (FastISLMap) _currentDep.copy();
			FastISLDomain origCurrentContext = null;
			if (_computeContextDomain)
				origCurrentContext = (FastISLDomain) _currentContext.copy();
			
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : extFunc.getExprs()) {
				sExpr.accept(this);
				lSExprToBeReplaced.add(_sExprToBeReplaced);
				
				// Reinitializing the top-down recursion
				_currentDep = origCurrentDep;
				if (_computeContextDomain)
					_currentContext = origCurrentContext;
			}
			
			_sExprToBeReplaced = _polyIRFact.createExternalFunctionCall(extFunc.getExFunc(), lSExprToBeReplaced);
		};
		
		
		// *** Leaves
		@Override
		public void visitVariableExpression(VariableExpression varExpr) {
			Expression varExprCopy = varExpr.copy();
			
			if (_computeContextDomain) {
				FastISLDomain domContextTemp = (FastISLDomain) _currentContext.image(_currentDep);
				FastISLDomain domContext = (FastISLDomain) varExpr.getVarDecl().getDomain().intersection(domContextTemp);
				
				// If domContext is empty, prune the branch... :/
				if (domContext.isEmpty()) {
					_pruneBranch = true;
				}
				
				mContextDomainVarExpr.put(varExprCopy, domContext);
			}
			
			_sExprToBeReplaced = _polyIRFact.createDependenceExpression(_currentDep, varExprCopy);
		}
		
		@Override
		public void visitIndexExpression(IndexExpression indExpr) {
			AffineFunction nFunc = indExpr.getFunction().compose(_currentDep);
			_sExprToBeReplaced = _polyIRFact.createIndexExpression(nFunc);
		}
		
		@Override
		public void visitBooleanExpression(BooleanExpression boolExpr) {
			_sExprToBeReplaced = _polyIRFact.createDependenceExpression(_currentDep, boolExpr.copy());
		};
		
		@Override
		public void visitIntegerExpression(IntegerExpression intExpr) {
			_sExprToBeReplaced = _polyIRFact.createDependenceExpression(_currentDep, intExpr.copy());
		};

		@Override
		public void visitRealExpression(RealExpression realExpr) {
			_sExprToBeReplaced = _polyIRFact.createDependenceExpression(_currentDep, realExpr.copy());
		};
		
	} // LowerDepPartialContextDom
	
	/* ----------------------------------------- MANAGING TEMPRED ----------------------------------------- */
	private static final boolean _debugTempRedTileGroups = false;
	
	/**
	 * Managing the new variables of the reduction (TempRed) in the alignment info. In particular, we need to
	 * determine which tiles of TempRed should go with its main variable, and do the split to isolate the other
	 * tiles of TempRed in a separate and new tile group.
	 * 
	 * @param syst
	 * @param llTileGroups
	 * @param mProjFuncRedTemp
	 * 
	 * @return
	 */
	public static List<List<Pair<String, Boolean>>> tempRedTileGroups(AffineSystem syst, List<List<String>> llTileGroups,
			Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp) {
		
		// Prebuild the new alignment info for the non-tempRed variable
		List<List<Pair<String, Boolean>>> newAlignmentInfo = new BasicEList<List<Pair<String,Boolean>>>();
		for (List<String> lTileGroups : llTileGroups) {
			List<Pair<String, Boolean>> lpVarBool = new BasicEList<Pair<String,Boolean>>();
			for (String varName : lTileGroups) {
				if (!mProjFuncRedTemp.containsKey(varName))
					lpVarBool.add(Pair.with(varName, false));
			}
			newAlignmentInfo.add(lpVarBool);
		}
		
		
		// *** Step 0: preparing the order of "tempRed" we will consider
		//		=> To manage the case where a reduction is after a reduction
		//		=> Each of the "tempRed" will be considered independently later...
		
		Map<String,Boolean> tempRedWasConsidered = new HashMap<String, Boolean>();
		for (String tempRedName : mProjFuncRedTemp.keySet())
			tempRedWasConsidered.put(tempRedName,false);
		
		List<String> lOrderTempRed = new BasicEList<String>();	// Order of the template we will consider
		for (String tempRedName : mProjFuncRedTemp.keySet()) {
			if (!tempRedWasConsidered.get(tempRedName)) {
				
				// We have a new TempRed => let us see if there is other TempRed on top of it
				//	and let us continue the chain of TempRed until:
				//		- We reach a non-tempRed variable => append the chain at the end of lOrderTempRed
				//		- We reach a tempRed which is already considered => append the chain at the end of lOrderTempRed
				Stack<String> lTempRedOnTop = new Stack<String>();
				lTempRedOnTop.push(tempRedName);
				
				String previousVarName = mProjFuncRedTemp.get(tempRedName).getValue1();
				while(mProjFuncRedTemp.containsKey(previousVarName)
						&& !tempRedWasConsidered.get(previousVarName)) {
					lTempRedOnTop.push(previousVarName);
					previousVarName = mProjFuncRedTemp.get(previousVarName).getValue1();
				}
				while (!lTempRedOnTop.isEmpty())		// Append the chain at the end of lOrderTempRed
					lOrderTempRed.add(lTempRedOnTop.pop());
			}
		}
		
		// DEBUG
		if (_debugTempRedTileGroups)
			System.out.println("lOrderTempRed = " + lOrderTempRed.toString());
		
		
		// NOW, we can consider each "tempRed" independently, without problem
		for (int nOrderTempRed=0; nOrderTempRed<lOrderTempRed.size(); nOrderTempRed++) {
			String tempRedName = lOrderTempRed.get(nOrderTempRed);
			
			// Equation from which tempRedName is coming from
			String topTempRedVarName = mProjFuncRedTemp.get(tempRedName).getValue1();
			
			// DEBUG
			if (_debugTempRedTileGroups)
				System.out.println("\nCurrent tempRed = " + tempRedName + " | topTempRedVarName = " + topTempRedVarName);
			
			
			// We get the group of tile associated with it
			List<String> tileGroupTopTempRedVar = null;
			for (List<String> lTileGroups : llTileGroups)
				if (lTileGroups.contains(topTempRedVarName))
					tileGroupTopTempRedVar = lTileGroups;
			if (tileGroupTopTempRedVar==null)
				throw new RuntimeException("tempRedTileGroups : TempRed = " + tempRedName + " / topVar = " + topTempRedVarName + " does NOT have a tile group !!!");
			
			int sizeOfAlpha = mProjFuncRedTemp.get(tempRedName).getValue0().getDimRHS()/2;		// Number of original indexes
			int sizeOfGamma = mProjFuncRedTemp.get(tempRedName).getValue0().getNIndices()-2*sizeOfAlpha;	// Number of projected dimensions
			int nParam = mProjFuncRedTemp.get(tempRedName).getValue0().getNParams();
			
			// DEBUG
			if (_debugTempRedTileGroups) {
				System.out.println("	sizeOfAlpha = " + sizeOfAlpha);
				System.out.println("	sizeOfGamma = " + sizeOfGamma);
				System.out.println("	nParam = " + nParam);
			}
			
			// *** Step 1: We consider tempRedName, and analyze its dependences going back to the tile group
			//		"tileGroupTopTempRedVar"
			GetAllDependencesGoingBack visitorGetAllDependences = new GetAllDependencesGoingBack(tileGroupTopTempRedVar);
			syst.getEquation(tempRedName).accept(visitorGetAllDependences);
			List<Pair<DependenceExpression,FastISLDomain>> depBackGroupTopTempRed = visitorGetAllDependences._lDepFound;
			
			// DEBUG
			if (_debugTempRedTileGroups) {
				System.out.println("	List of dependences going back for " + tempRedName + " =");
				for (int i=0; i<depBackGroupTopTempRed.size(); i++)
					System.out.println("		=> " + PolyhedralIRToAlphabets.toString(depBackGroupTopTempRed.get(i).getValue0())
							+ " / context = " + depBackGroupTopTempRed.get(i).getValue1());
			}
			
			// We need domGlobalCut = {\alpha,\gamma | (\alpha,\gamma)\in D_context && f(\alpha,\gamma)=\alpha}
			FastISLDomain domGlobalCut = null;
			for (Pair<DependenceExpression,FastISLDomain> pDepExprContext : depBackGroupTopTempRed) {
				
				// Getting the context domain of depExpr
				//		=> We want the restriction domain of the first case of "tempRedName"
				FastISLDomain contextDep = pDepExprContext.getValue1();
				
				// Building {\alpha,\gamma | f(\alpha,\gamma) = \alpha }
				FastISLMap dep = (FastISLMap) pDepExprContext.getValue0().getDep();
				long[][] funcMat = dep.toLongMatrix();
				long[][] matDomainDep = new long[sizeOfAlpha][2+nParam+ 2*sizeOfAlpha+sizeOfGamma];
				for (int i=0; i<matDomainDep.length; i++) {
					// First columns = 0 ===> equality
					for (int j=0; j<nParam; j++)
						matDomainDep[i][j+1] = funcMat[i][j];														// Parameters
					for (int j=0; j<sizeOfAlpha; j++)
						matDomainDep[i][j+1+nParam] = funcMat[i][j+nParam];										// Indexes: alpha
					matDomainDep[i][i+1+nParam] -= 1;
					for (int j=0; j<sizeOfGamma; j++)
						matDomainDep[i][j+1+nParam+sizeOfAlpha] = funcMat[i][j+nParam+sizeOfAlpha];			// Indexes: gamma
					// Indexes: local index => none
					matDomainDep[i][matDomainDep[0].length-1] = funcMat[i][funcMat[0].length-1];			// Constant
				}
				List<long[][]> lMatDomConstrDep = new BasicEList<long[][]>();  lMatDomConstrDep.add(matDomainDep);
				FastISLDomain domainConstrDep = _polyIRFact.createFastISLDomainMatLong(contextDep.getDomDims(), lMatDomConstrDep);
				
				/* DEBUG
				System.out.print("funcMat =\n" + MatrixOperations.toString(funcMat));
				System.out.print("matDomainDep =\n" + MatrixOperations.toString(matDomainDep));
				System.out.println("domainConstrDep = " + domainConstrDep.toString());
				System.out.println("contextDep = " + contextDep.toString());
				System.out.println();
				//*/
				
				// Intersecting contextDep and domainConstrDep
				FastISLDomain domCut = (FastISLDomain) contextDep.intersection(domainConstrDep);
				
				// Simplifying & checking for emptiness
				domCut.simplify();
				if (!domCut.isEmpty()) {
					if (domGlobalCut==null)
						domGlobalCut = domCut;
					else
						domGlobalCut = (FastISLDomain) domGlobalCut.union(domCut);
				}
			}	// END of the loop on pDepExprContext
			
			if (domGlobalCut!=null)
				domGlobalCut.simplify();	// Note: only contains constraints on blocks + works on ""(\alpha,\gamma,ii)""
			
			if (_debugTempRedTileGroups) {
				if (domGlobalCut==null)
					System.out.println("	For " + tempRedName + " => domGlobalCut = null");
				else
					System.out.println("	For " + tempRedName + " => domGlobalCut = " + domGlobalCut.toString());
			}
			
			// *** Step 2: splitting TempRed according to domGlobalCut
			
			// Case where all the TempRed should be in a different tile group
			if (domGlobalCut==null) {
				// DEBUG
				if (_debugTempRedTileGroups)
					System.out.println("	domGlobalCut is null => all " + tempRedName + " is going into a new group!");
				
				// No split needed / all the TempRed can be computed separately
				List<Pair<String,Boolean>> lNewTileGroup = new BasicEList<Pair<String,Boolean>>();
				lNewTileGroup.add(Pair.with(tempRedName, false));
				newAlignmentInfo.add(lNewTileGroup);
				
				continue;
			}
			
			
			
			// Case where all the TempRed should be in the same tile group
			if (syst.getVariableDeclaration(tempRedName).getDomain().difference(domGlobalCut).isEmpty()) {
				// DEBUG
				if (_debugTempRedTileGroups)
					System.out.println("	domGlobalCut is all the domain => all " + tempRedName +
						" is going into the same group than " + topTempRedVarName + " !");
				
				// No split needed / all the TempRed must be in the same tile group than the topVar
				for (List<Pair<String,Boolean>> lpVarIsRed : newAlignmentInfo) {
					boolean doesContainTopTempRed = false;
					for (Pair<String,Boolean> pVarIsRed : lpVarIsRed)
						if (pVarIsRed.getValue0()==topTempRedVarName) {
							doesContainTopTempRed = true;
							break;
						}
					if (doesContainTopTempRed) {
						lpVarIsRed.add(Pair.with(tempRedName, true));
						break;
					}
				}
				
				continue;
			}
			
			if (_debugTempRedTileGroups)
				System.out.println("	domGlobalCut is part of the domain => split !");
			
			// Case where we need to split TempRed according to the blocks which remains/stay in the same tile group
			String newNameTempRedSame = tempRedName + "_SameGroup";
			customSplit(syst, syst.getVariableDeclaration(tempRedName), domGlobalCut, newNameTempRedSame, sizeOfAlpha+sizeOfGamma);
			// customSplit needed to avoid introducing domains with block and local variables
			
			// Normalization: done afterward
			
			// Update of mProjFuncRedTemp
			Pair<FastISLMap,String> pOrig = mProjFuncRedTemp.get(tempRedName);
			mProjFuncRedTemp.put(newNameTempRedSame, Pair.with( (FastISLMap) pOrig.getValue0().copy(), pOrig.getValue1()));
			
			// Update of the alignmentInfo
			for (List<Pair<String,Boolean>> lpVarIsRed : newAlignmentInfo) {
				boolean doesContainTopTempRed = false;
				for (Pair<String,Boolean> pVarIsRed : lpVarIsRed)
					if (pVarIsRed.getValue0().equals(topTempRedVarName)) {
						doesContainTopTempRed = true;
						break;
					}
				if (doesContainTopTempRed) {
					lpVarIsRed.add(Pair.with(newNameTempRedSame, true));
					break;
				}
			}
			
			List<Pair<String,Boolean>> lNewTileGroup = new BasicEList<Pair<String,Boolean>>();
			lNewTileGroup.add(Pair.with(tempRedName, false));
			newAlignmentInfo.add(lNewTileGroup);
			
		}	// END of the loop on nOrderTempRed
		
		return newAlignmentInfo;
	}
	
	/**
	 * Custom Split transformation (to avoid mixing blocked and local constraints)
	 * 
	 * @param syst
	 * @param varDecl
	 * @param domSplit
	 * @param newVarName
	 */
	private static void customSplit(AffineSystem syst, VariableDeclaration targetVar, FastISLDomain domSplit, String newVarName, int numBlockDim) {
		// INVARIANT: domSplit is a domain which contains only constraints on the blocked indexes...
		
		// Check for duplicate variable
		if (syst.containsVariable(newVarName))
			throw new RuntimeException("Variable : " + newVarName + " already exists.");
		// Check dimensionality of the given domain
		if (domSplit.getDim() != targetVar.getDomain().getDim())
			throw new RuntimeException("Dimension of the given domain does not match the original domain.");
		
		// Get the block part of the domain
		FastISLDomain targetVarDomain = (FastISLDomain) targetVar.getDomain();
		
		JNIISLSet setTargetVarDom = targetVarDomain.getIslSet().copy();
		setTargetVarDom = setTargetVarDom.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_set,
				numBlockDim, targetVarDomain.getNIndices()-numBlockDim);
		int nBlockedParam = (targetVarDomain.getNParams()-1)/2;
		setTargetVarDom = setTargetVarDom.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_param, nBlockedParam, nBlockedParam+1);
		
		FastISLDomain blTargetVarDomain = _polyIRFact.createFastISLDomain(targetVarDomain.getDomDims(), setTargetVarDom);
		
		// Compute the 2 parts
		FastISLDomain splitDom = (FastISLDomain) blTargetVarDomain.intersection(domSplit);
		FastISLDomain stayDom = (FastISLDomain) blTargetVarDomain.difference(domSplit);
		
		// ASSERTION: splitDom and stayDom are not empty (checked beforehand in the calling function / no split needed)
		
		// DEBUG
		//System.out.println("domSplit = " + domSplit.toString());
		//System.out.println("blTargetVarDomain = " + blTargetVarDomain.toString());
		//System.out.println("splitDom = " + splitDom.toString());
		//System.out.println("stayDom = " + stayDom.toString());
		
		// Create new variable declaration & add it (+ manage equation)
		VariableDeclaration newVar = _polyIRFact.createVariableDeclaration(newVarName, targetVar.getType(), (FastISLDomain) targetVar.getDomain().intersection(domSplit));
		if (syst.isInput(targetVar))
			syst.getInputs().add(newVar);
		else {
			// If its not input, equation should be copied as well
			StandardEquation newEq = _polyIRFact.createStandardEquation(newVar, syst.getEquation(targetVar.getName()).getExpression().copy());
			syst.getEquations().add(newEq);
			
			if (targetVar.isOutput()) {
				syst.getOutputs().add(newVar);
			} else if (targetVar.isLocal()) {
				syst.getLocals().add(newVar);
			} else {
				throw new RuntimeException("Target variable is not any of input/output/local");
			}
		}
		
		// Change the domain of target variable to the domain after cut
		targetVar.setDomain((FastISLDomain) targetVar.getDomain().difference(domSplit));
		
		// Create expression to be substituted to targetVar (in a bottom-up fashion to avoid infinite recursion)
		List<Expression> tempCaseExprs = new LinkedList<Expression>();
		tempCaseExprs.add(_polyIRFact.createRestrictExpression((FastISLDomain) stayDom.copy(), _polyIRFact.createVariableExpression(targetVar)));
		tempCaseExprs.add(_polyIRFact.createRestrictExpression((FastISLDomain) splitDom.copy(), _polyIRFact.createVariableExpression(newVar)));
		CaseExpression tempEqCase = _polyIRFact.createCaseExpression(tempCaseExprs);
		
		
		// Substitute the occurrences of targetVar by tempEqCase (with a bottom-up visitor)
		BottomUpVariableSubstitute visitor = new BottomUpVariableSubstitute(targetVar, tempEqCase);
		syst.accept(visitor);
	}
	
	private static class BottomUpVariableSubstitute extends PolyhedralIRDepthFirstVisitorImpl {
		
		private VariableDeclaration _targetVar;
		private Expression _exprToSubstitute;
		
		private Expression _sExprToBeReplaced = null;
		
		public BottomUpVariableSubstitute(VariableDeclaration targetVar, Expression expr) {
			_targetVar = targetVar;
			_exprToSubstitute = expr;
		}
		
		// Interesting part
		@Override
		public void outVariableExpression(VariableExpression varExpr) {
			if (varExpr.getVarDecl().getName().equals(_targetVar.getName())) {
				_sExprToBeReplaced = _exprToSubstitute.copy();
			} else
				_sExprToBeReplaced = varExpr;
		}
		
		// *** Propagation (to manage _sExprToBeReplaced)
		@Override
		public void outStandardEquation(StandardEquation stEq) {
			stEq.setExpression(_sExprToBeReplaced);
		}
		
		@Override
		public void outUseEquation(UseEquation uEq) {
			throw new RuntimeException("UseEquation not managed for this transformation");
			// This extension is simple, other extensions which come before this one are not (at all)
		}
		
		// Leaves
		@Override
		public void visitIndexExpression(IndexExpression indExpr) {
			_sExprToBeReplaced = indExpr;
		}
		
		@Override
		public void visitBooleanExpression(BooleanExpression boolExpr) {
			_sExprToBeReplaced = boolExpr;
		};
		
		@Override
		public void visitIntegerExpression(IntegerExpression intExpr) {
			_sExprToBeReplaced = intExpr;
		};

		@Override
		public void visitRealExpression(RealExpression realExpr) {
			_sExprToBeReplaced = realExpr;
		};
		
		// Propagation
		public void visitCaseExpression(CaseExpression caseExpr) {
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : caseExpr.getExprs()) {
				sExpr.accept(this);
				lSExprToBeReplaced.add(_sExprToBeReplaced);
			}
			
			_sExprToBeReplaced = _polyIRFact.createCaseExpression(lSExprToBeReplaced);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression binExpr) {
			binExpr.getLexp().accept(this);
			Expression sExprLeft = _sExprToBeReplaced;
			
			binExpr.getRexp().accept(this);
			Expression sExprRight = _sExprToBeReplaced;
			
			_sExprToBeReplaced = _polyIRFact.createBinaryExpression(binExpr.getOperator(), sExprLeft, sExprRight);
		};
		
		@Override
		public void visitUnaryExpression(UnaryExpression unExpr) {
			unExpr.getExpr().accept(this);
			_sExprToBeReplaced = _polyIRFact.createUnaryExpression(unExpr.getOperator(), _sExprToBeReplaced);
		}
		
		@Override
		public void visitIfExpression(IfExpression ifExpr) {
			ifExpr.getCond().accept(this);
			Expression sExprCond = _sExprToBeReplaced;
			
			ifExpr.getThen().accept(this);
			Expression sExprThen = _sExprToBeReplaced;
			
			ifExpr.getElse().accept(this);
			Expression sExprElse = _sExprToBeReplaced;
			
			_sExprToBeReplaced = _polyIRFact.createIfExpression(sExprCond, sExprThen, sExprElse);
		};
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression multExpr) {
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : multExpr.getExprs()) {
				sExpr.accept(this);
				lSExprToBeReplaced.add(_sExprToBeReplaced);
			}
			
			_sExprToBeReplaced = _polyIRFact.createMultiArgExpression(multExpr.getOperator(), lSExprToBeReplaced);
		};
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall extFunc) {
			List<Expression> lSExprToBeReplaced = new BasicEList<Expression>();
			for (Expression sExpr : extFunc.getExprs()) {
				sExpr.accept(this);
				lSExprToBeReplaced.add(_sExprToBeReplaced);
			}
			
			_sExprToBeReplaced = _polyIRFact.createExternalFunctionCall(extFunc.getExFunc(), lSExprToBeReplaced);
		};
		
		@Override
		public void visitRestrictExpression(RestrictExpression restExpr) {
			restExpr.getExpr().accept(this);
			_sExprToBeReplaced = _polyIRFact.createRestrictExpression(restExpr.getRestrictDomain(), _sExprToBeReplaced);
		}
		
		@Override
		public void visitDependenceExpression(DependenceExpression depExpr) {
			depExpr.getExpr().accept(this);
			_sExprToBeReplaced = _polyIRFact.createDependenceExpression(depExpr.getDep(), _sExprToBeReplaced);
		}
		
		@Override
		public void visitReduceExpression(ReduceExpression redExpr) {
			redExpr.getExpr().accept(this);
			_sExprToBeReplaced = _polyIRFact.createReduceExpression(redExpr.getOP(), redExpr.getProjection(), _sExprToBeReplaced);
		}
		
	} // BottomUpVariableSubstitute
	
	private static class CustomCommutationCaseReduction extends PolyhedralIRDepthFirstVisitorImpl {
		
		/**
		 * Put the restriction/case on BLOCKED indexes potentially introduced by the split on TempRed on the top
		 * 
		 * This new blocked indexes MUST come from behind a reduction expression on the blocked indexes
		 * 
		 * @param syst
		 */
		public static void normalizeAfterTempRed(AffineSystem syst) {
			CustomCommutationCaseReduction visitor = new CustomCommutationCaseReduction(syst.getParameters());
			syst.accept(visitor);
		}
		
		private ParameterDomain _paramDom;
		private boolean _isFirstRestrictionEncountered = true;		// True if we are not yet at the first restrict encounter (top down)
													// False if such restriction was passed...
		private List<Pair<FastISLDomain,Expression>> _sExprToBePropagated;
				// First Domain: restrict domain on the blocked indexes (to be propagated up) / Second Domain: Expression
				// If only a single one : <null, SExpr> / if multiple, correspond to a case
		private FastISLDomain _univDom;			// First restrict domain encountered (blocked domain of the branch of the case considered)
		
		
		// Constructor
		public CustomCommutationCaseReduction(ParameterDomain paramDom) {
			_paramDom = paramDom;
			_isFirstRestrictionEncountered = true;
			_sExprToBePropagated = null;
		}
		
		@Override
		public void outStandardEquation(StandardEquation stEq) {
			/* DEBUG
			System.out.println("_sExprToBePropagated (" + stEq.getVariable().getName() + ") = ");
			for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
				if (pDomExpr.getValue0()==null)
					System.out.println("[[ null, " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
				else
					System.out.println("[[ " + pDomExpr.getValue0().toString() + " , " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
			//*/
			
			List<Expression> lExprCase = new BasicEList<Expression>();
			for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated) {
				assert(pDomExpr.getValue0()!=null);
				lExprCase.add(_polyIRFact.createRestrictExpression(pDomExpr.getValue0(), pDomExpr.getValue1()));
			}
			stEq.setExpression(_polyIRFact.createCaseExpression(lExprCase));
		}
		
		
		// Initial commutation: case (of cardinality 2 + restriction on block domain) / reduce
		@Override
		public void visitReduceExpression(ReduceExpression redExpr) {
			
			// We distinguish the case between reduction on blocks and reductions on local indexes
			FastISLMap projFuncRedExpr = (FastISLMap) redExpr.getProjection().copy();
			
			// Projection is canonic => last expression is a index
			AffineExpression lastExprProjFunc = projFuncRedExpr.getExpressions().get(projFuncRedExpr.getDimRHS()-1);
			assert(lastExprProjFunc.getTerms().size()==1);
			Variable varExprLast = lastExprProjFunc.getTerms().get(0).getVariable();
			boolean isReductionOnLocal = !projFuncRedExpr.getIndexNames().get(projFuncRedExpr.getNIndices()-1).equals(varExprLast.getName());
			
			if (isReductionOnLocal) {
				
				// We continue the propagation below (in case of nested reductions)
				redExpr.getExpr().accept(this);
				
				List<Pair<FastISLDomain,Expression>> nSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
				for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
					nSExprToBePropagated.add(Pair.with(pDomExpr.getValue0(),
							(Expression) _polyIRFact.createReduceExpression(redExpr.getOP(), projFuncRedExpr.copy(), pDomExpr.getValue1())));
				_sExprToBePropagated = nSExprToBePropagated;
				return;
			}
			
			// The reduction is a reduction on block indexes, right before a "TempRed"
			//		=> we check if we have a split first...
			
			boolean isThereASplit = false;
			
			Expression depSubExpr = redExpr.getExpr();
			if (depSubExpr instanceof DependenceExpression) {					// If dependence, must be identity
				assert( ((DependenceExpression) depSubExpr).getDep().isIdentity());
				depSubExpr = ((DependenceExpression) depSubExpr).getExpr();
				//		=> We can skip it...
			}
			
			if (depSubExpr instanceof CaseExpression && ((CaseExpression) depSubExpr).getExprs().size()>1)
				isThereASplit=true;
			
			if (!isThereASplit) {
				// No split was done => do not modify
				List<Pair<FastISLDomain,Expression>> lSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
				lSExprToBePropagated.add(Pair.with((FastISLDomain) _univDom, (Expression) redExpr));
				_sExprToBePropagated = lSExprToBePropagated;
			} else {
				// We found a split
				CaseExpression cExpr = (CaseExpression) depSubExpr;
				
				
				// ASSERTION: Inside the case, we have only 2 branches, each branches are restrictions,
				//			whose domains are on the blocked indexes (and are the domains to pull up)
				if (cExpr.getExprs().size()!=2)
					throw new RuntimeException("CustomCommutationCaseReduction : case below reduction is not of the expected form"
							+ "/ we have " + cExpr.getExprs().size() + " branches");
				
				RestrictExpression restExpr1 = (RestrictExpression) cExpr.getExprs().get(0);
				RestrictExpression restExpr2 = (RestrictExpression) cExpr.getExprs().get(1);
				
				FastISLDomain blDomRestExpr1 = (FastISLDomain) restExpr1.getRestrictDomain();
				FastISLDomain blDomRestExpr2 = (FastISLDomain) restExpr2.getRestrictDomain();
				
				FastISLDomain projBlDomRestExpr1 = (FastISLDomain) blDomRestExpr1.image( (FastISLMap) redExpr.getProjection());
				FastISLDomain projBlDomRestExpr2 = (FastISLDomain) blDomRestExpr2.image( (FastISLMap) redExpr.getProjection());
				
				// Intersect with the universe
				projBlDomRestExpr1 = (FastISLDomain) projBlDomRestExpr1.intersection(_univDom);
				projBlDomRestExpr2 = (FastISLDomain) projBlDomRestExpr2.intersection(_univDom);
				
				// DEBUG
				//System.out.println("projBlDomRestExpr1 = " + projBlDomRestExpr1.toString());
				//System.out.println("projBlDomRestExpr2 = " + projBlDomRestExpr2.toString());
				
				
				// Forming the new _sExprToBePropagated
				List<Pair<FastISLDomain,Expression>> lSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
				
				//		- Intersection
				FastISLDomain intersectionProjBlDomRest = (FastISLDomain) projBlDomRestExpr1.intersection(projBlDomRestExpr2);
				intersectionProjBlDomRest.simplify();
				if (!intersectionProjBlDomRest.isEmpty()) {
					
					// First branch of the case
					ReduceExpression redExpr1 = _polyIRFact.createReduceExpression(redExpr.getOP(),
							redExpr.getProjection().copy(), restExpr1.getExpr().copy());
					ReduceExpression redExpr2 = _polyIRFact.createReduceExpression(redExpr.getOP(),
							redExpr.getProjection().copy(), restExpr2.getExpr().copy());
					
					
					// We check on which domain each reduction is defined (for the blocks from intersectionProjBlDomRest)
					ExpressionDomainCalculator.computeExpressionDomain(_paramDom, redExpr1);
					ExpressionDomainCalculator.computeExpressionDomain(_paramDom, redExpr2);
					FastISLDomain exprDomRedExpr1 = _polyIRFact.createFastISLDomain(redExpr1.getExpressionDomain().getPMdomain());
					FastISLDomain exprDomRedExpr2 = _polyIRFact.createFastISLDomain(redExpr2.getExpressionDomain().getPMdomain());
					
					FastISLDomain exprDomRestExpr1Inter = (FastISLDomain) exprDomRedExpr1.intersection(intersectionProjBlDomRest);
					FastISLDomain exprDomRestExpr2Inter = (FastISLDomain) exprDomRedExpr2.intersection(intersectionProjBlDomRest);
					
					// Check the differences
					FastISLDomain exprDom1minus2 = (FastISLDomain) exprDomRestExpr1Inter.difference(exprDomRestExpr2Inter);
					exprDom1minus2.simplify();
					FastISLDomain exprDom2minus1 = (FastISLDomain) exprDomRestExpr2Inter.difference(exprDomRestExpr1Inter);
					exprDom2minus1.simplify();
					
					/* DEBUG
					System.out.println("exprDomRedExpr1 = " + exprDomRedExpr1.toString());
					System.out.println("exprDomRedExpr2 = " + exprDomRedExpr2.toString());
					System.out.println("exprDomRestExpr1Inter = " + exprDomRestExpr1Inter.toString());
					System.out.println("exprDomRestExpr2Inter = " + exprDomRestExpr2Inter.toString());
					System.out.println("exprDom1minus2 = " + exprDom1minus2.toString());
					System.out.println("		=> isEmpty = " + exprDom1minus2.isEmpty());
					System.out.println("exprDom2minus1 = " + exprDom2minus1.toString());
					System.out.println("		=> isEmpty = " + exprDom2minus1.isEmpty());
					System.out.println("Intersection = " + exprDomRestExpr1Inter.intersection(exprDomRestExpr2Inter));
					System.out.println();
					//*/
					
					boolean differenceAreNotEmpty = false;
					List<Expression> lExprCase = new BasicEList<Expression>();
					
					int nBlockIndexesUpperRed = redExpr.getProjection().getDimRHS()/2;
					
					if (!exprDom1minus2.isEmpty()) {
						differenceAreNotEmpty = true;
						
						// Remove the constraints on the block indexes
						JNIISLSet setExprDom1minus2Loc = exprDom1minus2.getIslSet().copy().eliminate(JNIISLDimType.isl_dim_set,
								0, nBlockIndexesUpperRed);
						FastISLDomain domExprDom1minus2Loc = _polyIRFact.createFastISLDomain(exprDom1minus2.getDomDims(), setExprDom1minus2Loc);
						lExprCase.add(_polyIRFact.createRestrictExpression(domExprDom1minus2Loc, redExpr1.copy()));
					}
					if (!exprDom2minus1.isEmpty()) {
						differenceAreNotEmpty = true;
						
						// Remove the constraints on the block indexes
						JNIISLSet setExprDom2minus1Loc = exprDom2minus1.getIslSet().copy().eliminate(JNIISLDimType.isl_dim_set,
								0, nBlockIndexesUpperRed);
						FastISLDomain domExprDom2minus1Loc = _polyIRFact.createFastISLDomain(exprDom2minus1.getDomDims(), setExprDom2minus1Loc);
						lExprCase.add(_polyIRFact.createRestrictExpression(domExprDom2minus1Loc, redExpr2.copy()));
					}
					
					Expression sExprInter = _polyIRFact.createBinaryExpression(redExpr.getOP(), redExpr1, redExpr2);
					if (differenceAreNotEmpty) {
						lExprCase.add(sExprInter);
						Expression nCaseExpr = _polyIRFact.createCaseExpression(lExprCase);
						lSExprToBePropagated.add(Pair.with(intersectionProjBlDomRest, nCaseExpr));
					} else {
						lSExprToBePropagated.add(Pair.with(intersectionProjBlDomRest, sExprInter));
					}
				}
				
				//		- 1 but not 2
				FastISLDomain diff1over2ProjBlDomRest = (FastISLDomain) projBlDomRestExpr1.difference(projBlDomRestExpr2);
				diff1over2ProjBlDomRest.simplify();
				if (!diff1over2ProjBlDomRest.isEmpty()) {
					// We manage the union of polyhedra
					for (int k=0; k<diff1over2ProjBlDomRest.getPMdomain().getPolyhedra().size(); k++) {
						IntConstraintSystem syst= diff1over2ProjBlDomRest.getPMdomain().getPolyhedra().get(k);
						FastISLDomain nDomDifference1over2 = _polyIRFact.createFastISLDomain(_polyIRFact.createDomain(diff1over2ProjBlDomRest.getParams(),
								diff1over2ProjBlDomRest.getIndices(), syst).getPMdomain());
						Expression redExpr1 = _polyIRFact.createReduceExpression(redExpr.getOP(),
								redExpr.getProjection().copy(), restExpr1.getExpr().copy());
						
						lSExprToBePropagated.add(Pair.with(nDomDifference1over2, redExpr1));
					}
				}
				
				//		- 2 but not 1
				FastISLDomain diff2over1ProjBlDomRest = (FastISLDomain) projBlDomRestExpr2.difference(projBlDomRestExpr1);
				diff2over1ProjBlDomRest.simplify();
				if (!diff2over1ProjBlDomRest.isEmpty()) {
					// We manage the union of polyhedra
					for (int k=0; k<diff2over1ProjBlDomRest.getPMdomain().getPolyhedra().size(); k++) {
						IntConstraintSystem syst= diff2over1ProjBlDomRest.getPMdomain().getPolyhedra().get(k);
						FastISLDomain nDomDifference2over1 = _polyIRFact.createFastISLDomain(_polyIRFact.createDomain(diff2over1ProjBlDomRest.getParams(),
								diff2over1ProjBlDomRest.getIndices(), syst).getPMdomain());
						Expression redExpr2 = _polyIRFact.createReduceExpression(redExpr.getOP(),
								redExpr.getProjection().copy(), restExpr2.getExpr().copy());
						
						lSExprToBePropagated.add(Pair.with(nDomDifference2over1, redExpr2));
					}
				}
				
				// Note: lSExprToBePropagated cannot be empty (or, if it is, the context domain of this part of the progam is empty,
				//			which should be impossible)
				_sExprToBePropagated = lSExprToBePropagated;
				
				/* DEBUG
				System.out.println("_sExprToBePropagated (" + ((StandardEquation)redExpr.getContainerEquation()).getVariable().getName() + ") = ");
				for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
					if (pDomExpr.getValue0()==null)
						System.out.println("[[ null, " + pDomExpr.getValue1().toString() + " ]]");
					else
						System.out.println("[[ " + pDomExpr.getValue0().toString() + " , " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
				//*/
				
			}
		}
		
		// Manage the top-most restriction (just below the case expression)
		@Override
		public void visitRestrictExpression(RestrictExpression restExpr) {
			
			boolean oldIsFirstRestEncountered = _isFirstRestrictionEncountered;
			_isFirstRestrictionEncountered = false;
			
			if (oldIsFirstRestEncountered)
				_univDom = (FastISLDomain) restExpr.getRestrictDomain();
			// Note: there is no issue on the indexes of this domain, because the dependences are at the bottom of the AST
			//		and the leaves (variable/constants) are all under a single dependence
			
			restExpr.getExpr().accept(this);

			List<Pair<FastISLDomain,Expression>> nSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			if (oldIsFirstRestEncountered) {
				
				/* DEBUG
				System.out.println("_sExprToBePropagated (first restrict - " + restExpr.getRestrictDomain().toString() + ") = ");
				for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
					if (pDomExpr.getValue0()==null)
						System.out.println("[[ null, " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
					else
						System.out.println("[[ " + pDomExpr.getValue0().toString() + " , " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
				System.out.println();
				//*/
				
				
				_isFirstRestrictionEncountered = true;	// Restore
				// ASSUMPTION: current restriction in on the block indexes
				//		=> Merge with _sExprToBePropagated
//				FastISLDomain blDom = (FastISLDomain) restExpr.getRestrictDomain();
				
				for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated) {
//					if (pDomExpr.getValue0()==null) {	// Should not happen
//						nSExprToBePropagated.add(Pair.with( (FastISLDomain) blDom.copy(), pDomExpr.getValue1()));
//					} else {
//						FastISLDomain domBlInter = (FastISLDomain) blDom.intersection(pDomExpr.getValue0());
//						domBlInter.simplify();
//						if (!domBlInter.isEmpty())
//							nSExprToBePropagated.add(Pair.with(domBlInter, pDomExpr.getValue1()));
//					}
					nSExprToBePropagated.add(Pair.with(pDomExpr.getValue0(), pDomExpr.getValue1()));
				}
			} else {
				// Just propagate up
				for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
					nSExprToBePropagated.add(Pair.with(pDomExpr.getValue0(),
							(Expression) _polyIRFact.createRestrictExpression(
									(FastISLDomain) restExpr.getRestrictDomain().copy(), pDomExpr.getValue1())
							));
			}
			_sExprToBePropagated = nSExprToBePropagated;
		}
		
		// *** Propagation
		
		// Leaves
		// These one cannot be accessed
		@Override
		public void visitVariableExpression(VariableExpression varExpr) {
			_sExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			_sExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(), (Expression) varExpr));
		}
		
		@Override
		public void visitIntegerExpression(IntegerExpression intExpr) {
			_sExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			_sExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(), (Expression) intExpr));
		}
		
		@Override
		public void visitRealExpression(RealExpression realExpr) {
			_sExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			_sExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(), (Expression) realExpr));
		}
		
		@Override
		public void visitBooleanExpression(BooleanExpression boolExpr) {
			_sExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			_sExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(), (Expression) boolExpr));
		}
		
		// Might be accessed
		@Override
		public void visitIndexExpression(IndexExpression indExpr) {
			_sExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			_sExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(), (Expression) indExpr));
		}
		
		
		// Branching
		@Override
		public void outDependenceExpression(DependenceExpression depExpr) {
			// By construction, should only appear on top of VariableExpression OR ConstantExpression => _sExprToBePropagated must be of size 1
			// OR on the top of a tempRed which was splitted => already managed in the "reduce" case...
			if (_sExprToBePropagated.size()!=1)
				throw new RuntimeException("Misplaced dependence => _sExprToBePropagated is of size!=1");
			
			List<Pair<FastISLDomain,Expression>> nSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			nSExprToBePropagated.add(Pair.with((FastISLDomain) _univDom.copy(),
					(Expression) _polyIRFact.createDependenceExpression(depExpr.getDep(), _sExprToBePropagated.get(0).getValue1())));
			_sExprToBePropagated = nSExprToBePropagated;
		}
		
		@Override
		public void outUnaryExpression(UnaryExpression uExpr) {
			List<Pair<FastISLDomain,Expression>> nSExprToBePropagated = new BasicEList<Pair<FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
				nSExprToBePropagated.add(Pair.with(pDomExpr.getValue0(), (Expression) _polyIRFact.createUnaryExpression(uExpr.getOperator(), pDomExpr.getValue1())));
			_sExprToBePropagated = nSExprToBePropagated;
		}
		
		@Override
		public void visitCaseExpression(CaseExpression cExpr) {
			if (_isFirstRestrictionEncountered) {	// Is the very first case (on the blocks)
				List<Pair<FastISLDomain,Expression>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,Expression>>();
				for (Expression expr : cExpr.getExprs()) {
					expr.accept(this);
					
					// "null" case automatically managed (if a sExprToBeProp is of size one with a "null",
					//	then it is defined over the universe, and the case only have one argument)
					//		(works because almost normal form)
					lpDomExprTemp.addAll(_sExprToBePropagated);
					
					// No need to reinitialize _sExprToBePropagated (will be given a values on the leaves)
				}
				
				_sExprToBePropagated = lpDomExprTemp;
			} else {
				// The case expression in not the last (thus the corresponding restricts are on local indexes)
				// (indeed, the blocked case are always at the top and right under a reduction)
				//		=> We have to form a case expression from the cross product
				
				// Get all _sExprToBePropagated for each subexpression
				
				//	FastISLDOmain = blocked constraint / List<Expression> = value of the case behind this constraint
				List<Pair<FastISLDomain,List<Expression>>> lpDomExprTempAccumulation = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
				for (Expression expr : cExpr.getExprs()) {
					expr.accept(this);
					
					/* DEBUG
					System.out.println("_sExprToBePropagated (case - branch #" + cExpr.getExprs().indexOf(expr) + ") = ");
					for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated)
						System.out.println("[[ " + pDomExpr.getValue0().toString() + " , " + PolyhedralIRToAlphabets.toString(pDomExpr.getValue1()) + " ]]");
					System.out.println();
					//*/
					
					
					// Initialization (first iteration)
					if (lpDomExprTempAccumulation.size()==0) {
						for (Pair<FastISLDomain,Expression> pDomExpr : _sExprToBePropagated) {
							List<Expression> lnExpr = new BasicEList<Expression>();
							lnExpr.add(pDomExpr.getValue1());
							lpDomExprTempAccumulation.add(Pair.with(pDomExpr.getValue0(),lnExpr));
						}
						continue;
					}
					
					// If not first iteration
					// INVARIANT: the union of the blocked domains of lpDomExprTempAccumulation and _sExprToBePropagated are _univDom
					//			=> Because the system was normalized before hand, thus all branches of a case are accessible,
					//					and this is also the case for the reductions it contains
					// INVARIANT: the different blocked domains are disjoint
					List<Pair<FastISLDomain,List<Expression>>> nlpDomExprTempAccumulation = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
					for (Pair<FastISLDomain,Expression> pnDomExpr: _sExprToBePropagated) {
						FastISLDomain nDomContrib = pnDomExpr.getValue0();
						Expression nExprContrib = pnDomExpr.getValue1();
						
						for (Pair<FastISLDomain,List<Expression>> oldDomExpr : lpDomExprTempAccumulation) {

							// Intersect with lpDomExprTempAccumulation
							FastISLDomain interDom = (FastISLDomain) nDomContrib.intersection(oldDomExpr.getValue0());
							
							if (!interDom.isEmpty()) {
								List<Expression> lnExpr = new BasicEList<Expression>();
								for (Expression exprTemp : oldDomExpr.getValue1())
									lnExpr.add(exprTemp.copy());
								lnExpr.add(nExprContrib);
								
								nlpDomExprTempAccumulation.add(Pair.with(interDom,lnExpr));
							}
						}
					}
					
					// Update
					lpDomExprTempAccumulation = nlpDomExprTempAccumulation;
					
				}	// END For on expr of the CaseExpression
				
				// We form the case Expression
				List<Pair<FastISLDomain,Expression>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,Expression>>();
				for (int k=0; k<lpDomExprTempAccumulation.size(); k++) {
					Pair<FastISLDomain,List<Expression>> pDomExpr = lpDomExprTempAccumulation.get(k);
					lpDomExprTemp.add(Pair.with(pDomExpr.getValue0(), (Expression) _polyIRFact.createCaseExpression(pDomExpr.getValue1())));
				}
				
				_sExprToBePropagated = lpDomExprTemp;
			}
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression bExpr) {
			bExpr.getLexp().accept(this);
			List<Pair<FastISLDomain,Expression>> sExprToBePropagatedLeft = _sExprToBePropagated;
			
			bExpr.getRexp().accept(this);
			List<Pair<FastISLDomain,Expression>> sExprToBePropagatedRight = _sExprToBePropagated;
			
			// Cross product
			List<Pair<FastISLDomain,Expression>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,Expression> pDomExprL : sExprToBePropagatedLeft) {
				
				//if (pDomExprL.getValue0()==null) {
				//	for (Pair<FastISLDomain,Expression> pDomExprR : sExprToBePropagatedRight)
				//		lpDomExprTemp.add(Pair.with(pDomExprR.getValue0(), (Expression) _polyIRFact.createBinaryExpression(bExpr.getOperator(),
				//				pDomExprL.getValue1().copy(), pDomExprR.getValue1().copy())));
				//} else {
					for (Pair<FastISLDomain,Expression> pDomExprR : sExprToBePropagatedRight) {
				//		if (pDomExprR.getValue0()==null) {
				//			lpDomExprTemp.add(Pair.with(pDomExprL.getValue0(), (Expression) _polyIRFact.createBinaryExpression(bExpr.getOperator(),
				//					pDomExprL.getValue1().copy(), pDomExprR.getValue1().copy())));
				//		} else {
							FastISLDomain domInter = (FastISLDomain) pDomExprL.getValue0().intersection(pDomExprR.getValue0());
							if (!domInter.isEmpty())
								lpDomExprTemp.add(Pair.with(domInter, (Expression) _polyIRFact.createBinaryExpression(bExpr.getOperator(),
											pDomExprL.getValue1().copy(), pDomExprR.getValue1().copy())));
				//		}
					}
				//}
				
				
			}
			
			_sExprToBePropagated = lpDomExprTemp;
		}
		
		@Override
		public void visitIfExpression(IfExpression ifExpr) {
			ifExpr.getCond().accept(this);
			List<Pair<FastISLDomain,Expression>> sExprToBePropagatedCond = _sExprToBePropagated;
			
			ifExpr.getThen().accept(this);
			List<Pair<FastISLDomain,Expression>> sExprToBePropagatedThen = _sExprToBePropagated;

			ifExpr.getElse().accept(this);
			List<Pair<FastISLDomain,Expression>> sExprToBePropagatedElse = _sExprToBePropagated;
			
			
			List<Pair<FastISLDomain,Expression>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,Expression> pDomExprCond : sExprToBePropagatedCond)
			for (Pair<FastISLDomain,Expression> pDomExprThen : sExprToBePropagatedThen)
			for (Pair<FastISLDomain,Expression> pDomExprElse : sExprToBePropagatedElse) {
				
				FastISLDomain interDom = pDomExprCond.getValue0();
				interDom = (FastISLDomain) interDom.intersection(pDomExprThen.getValue0());
				interDom = (FastISLDomain) interDom.intersection(pDomExprElse.getValue0());
				
				/*if (pDomExprThen.getValue0()!=null) {
					if (interDom==null)
						interDom = pDomExprThen.getValue0();
					else
						interDom = (FastISLDomain) interDom.intersection(pDomExprThen.getValue0());
				}
				if (pDomExprElse.getValue0()!=null) {
					if (interDom==null)
						interDom = pDomExprElse.getValue0();
					else
						interDom = (FastISLDomain) interDom.intersection(pDomExprElse.getValue0());
				}
				*/
				if (!interDom.isEmpty())
					lpDomExprTemp.add(Pair.with(interDom, (Expression) _polyIRFact.createIfExpression(
							pDomExprCond.getValue1(), pDomExprThen.getValue1(), pDomExprElse.getValue1())));
			}
			
			_sExprToBePropagated = lpDomExprTemp;
		}
		
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression mExpr) {
			List<List<Pair<FastISLDomain,Expression>>> lSExprToBePropagated = new BasicEList<List<Pair<FastISLDomain,Expression>>>();
			for (Expression subExpr : mExpr.getExprs()) {
				subExpr.accept(this);
				lSExprToBePropagated.add(_sExprToBePropagated);
			}
			
			List<Pair<FastISLDomain,List<Expression>>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
			for (Pair<FastISLDomain,Expression> pDomExpr : lSExprToBePropagated.get(0)) {
				List<Expression> lExpr = new BasicEList<Expression>();
				lExpr.add(pDomExpr.getValue1());
				lpDomExprTemp.add(Pair.with(pDomExpr.getValue0(), lExpr));
			}
			for (int i=1; i<mExpr.getExprs().size(); i++) {
				// Merge lpDomExprTemp with lSExprToBePRopagated.get(i)
				List<Pair<FastISLDomain,Expression>> lpDomExpri = lSExprToBePropagated.get(i);
				
				List<Pair<FastISLDomain,List<Expression>>> nlpDomExprTemp = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
				for (Pair<FastISLDomain,List<Expression>> pDomExprTemp : lpDomExprTemp)
				for (Pair<FastISLDomain,Expression> pDomExpri : lpDomExpri) {
					
					FastISLDomain domInter;
					//if (pDomExprTemp.getValue0()==null)
					//	domInter = (FastISLDomain) pDomExpri.getValue0().copy();
					//else {
					//	if (pDomExpri.getValue0()==null)
					//		domInter = (FastISLDomain) pDomExprTemp.getValue0().copy();
					//	else
							domInter = (FastISLDomain) pDomExpri.getValue0().intersection(pDomExprTemp.getValue0());
					//}
					if (!domInter.isEmpty()) {
						List<Expression> lnExpr = new BasicEList<Expression>();
						lnExpr.addAll(pDomExprTemp.getValue1());
						lnExpr.add(pDomExpri.getValue1().copy());
						
						nlpDomExprTemp.add(Pair.with(domInter, lnExpr));
					}
				}
				
				lpDomExprTemp = nlpDomExprTemp;
			}
			
			List<Pair<FastISLDomain,Expression>> lpDomExprRet = new BasicEList<Pair<FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,List<Expression>> pDomExprTemp : lpDomExprTemp) {
				lpDomExprRet.add(Pair.with(pDomExprTemp.getValue0(),
						(Expression) _polyIRFact.createMultiArgExpression(mExpr.getOperator(), pDomExprTemp.getValue1())));
			}
			
			_sExprToBePropagated = lpDomExprRet;
		}
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall efExpr) {
			List<List<Pair<FastISLDomain,Expression>>> lSExprToBePropagated = new BasicEList<List<Pair<FastISLDomain,Expression>>>();
			for (Expression subExpr : efExpr.getExprs()) {
				subExpr.accept(this);
				lSExprToBePropagated.add(_sExprToBePropagated);
			}
			
			List<Pair<FastISLDomain,List<Expression>>> lpDomExprTemp = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
			for (Pair<FastISLDomain,Expression> pDomExpr : lSExprToBePropagated.get(0)) {
				List<Expression> lExpr = new BasicEList<Expression>();
				lExpr.add(pDomExpr.getValue1());
				lpDomExprTemp.add(Pair.with(pDomExpr.getValue0(), lExpr));
			}
			for (int i=1; i<efExpr.getExprs().size(); i++) {
				// Merge lpDomExprTemp with lSExprToBePRopagated.get(i)
				List<Pair<FastISLDomain,Expression>> lpDomExpri = lSExprToBePropagated.get(i);
				
				List<Pair<FastISLDomain,List<Expression>>> nlpDomExprTemp = new BasicEList<Pair<FastISLDomain,List<Expression>>>();
				for (Pair<FastISLDomain,List<Expression>> pDomExprTemp : lpDomExprTemp)
				for (Pair<FastISLDomain,Expression> pDomExpri : lpDomExpri) {
					
					FastISLDomain domInter;
//					if (pDomExprTemp.getValue0()==null)
//						domInter = (FastISLDomain) pDomExpri.getValue0().copy();
//					else {
//						if (pDomExpri.getValue0()==null)
//							domInter = (FastISLDomain) pDomExprTemp.getValue0().copy();
//						else
							domInter = (FastISLDomain) pDomExpri.getValue0().intersection(pDomExprTemp.getValue0());
//					}
					
				    if (!domInter.isEmpty()) {
				    	List<Expression> lnExpr = new BasicEList<Expression>();
						lnExpr.addAll(pDomExprTemp.getValue1());
						lnExpr.add(pDomExpri.getValue1().copy());
						
						nlpDomExprTemp.add(Pair.with(domInter, lnExpr));
				    }
				}
				
				lpDomExprTemp = nlpDomExprTemp;
			}
			
			List<Pair<FastISLDomain,Expression>> lpDomExprRet = new BasicEList<Pair<FastISLDomain,Expression>>();
			for (Pair<FastISLDomain,List<Expression>> pDomExprTemp : lpDomExprTemp) {
				lpDomExprRet.add(Pair.with(pDomExprTemp.getValue0(),
						(Expression) _polyIRFact.createExternalFunctionCall(efExpr.getExFunc(), pDomExprTemp.getValue1())));
			}
			
			_sExprToBePropagated = lpDomExprRet;
		}
		
		
	} // CustomCommutationCaseReduction
	
	/**
	 * Sub-class to collect all the needed information about dependences going back
	 **/
	private static class GetAllDependencesGoingBack extends PolyhedralIRDepthFirstVisitorImpl {
		
		private List<String> _lTileGroupTop;
		private FastISLDomain _currentBlockedRestrDom;
		private boolean _wasFirstCaseAlreadyEncountered;
		public List<Pair<DependenceExpression,FastISLDomain>> _lDepFound;
		
		
		public GetAllDependencesGoingBack(List<String> lTileGroupTop) {
			_lTileGroupTop = lTileGroupTop;
			_lDepFound = new BasicEList<Pair<DependenceExpression,FastISLDomain>>();
			_currentBlockedRestrDom = null;
			_wasFirstCaseAlreadyEncountered = false;
		}
		
		// Note: we are after lower dependence => each dependences are right after a variable expression or a constant
		//		Moreover all variable expression have a dependence in front of them
		
		@Override
		public void visitCaseExpression(CaseExpression caseExpr) {
			if (!_wasFirstCaseAlreadyEncountered) {
				_wasFirstCaseAlreadyEncountered = true;
				
				for (Expression expr : caseExpr.getExprs()) {
					RestrictExpression restrExpr = (RestrictExpression) expr;
					_currentBlockedRestrDom = (FastISLDomain) restrExpr.getRestrictDomain();
					restrExpr.getExpr().accept(this);
					_currentBlockedRestrDom = null;
				}
				
				_wasFirstCaseAlreadyEncountered = false;
				
			} else {
				for (Expression expr : caseExpr.getExprs())
					expr.accept(this);
			}
		}
		
		@Override
		public void visitDependenceExpression(DependenceExpression depExpr) {
			if (depExpr.getExpr() instanceof VariableExpression) {
				VariableExpression varExpr = (VariableExpression) depExpr.getExpr();
				
				if (_lTileGroupTop.contains(varExpr.getVarDecl().getName()))
					_lDepFound.add(Pair.with(depExpr,_currentBlockedRestrDom));
			}
		}
		
	} // GetAllDependencesGoingBack
	
	/**
	 * Because of the split done to manage the tempRed, we might introduce empty branches
	 * 		=> We can manage them by just looking at the blocked restriction (level 2 of each equation)
	 * 		and eliminate them with empty context domain
	 * 
	 * @param syst
	 */
	private static void quickEliminationEmptyBranches(AffineSystem syst) {
		for (StandardEquation stEq : syst.getEquations()) {
			FastISLDomain contextInit = (FastISLDomain) stEq.getVariable().getDomain();
			Expression exprStEq = stEq.getExpression();
			
			if (!(exprStEq instanceof CaseExpression))
				throw new RuntimeException("quickEliminationEmptyBranches : equation " + stEq.getVariable().getName()
						+ " do not have a case in the first branch");
			CaseExpression cExpr = (CaseExpression) exprStEq;
			
			List<Expression> lnSubExpr = new BasicEList<Expression>();
			for (Expression subExpr : cExpr.getExprs()) {
				if (!(subExpr instanceof RestrictExpression))
					throw new RuntimeException("quickEliminationEmptyBranches : equation " + stEq.getVariable().getName() +
							" have a branch with no restriction");
				RestrictExpression restrExpr = (RestrictExpression) subExpr;
				
				if (!contextInit.intersection((FastISLDomain) restrExpr.getRestrictDomain().copy()).isEmpty())
					lnSubExpr.add(subExpr.copy());
			}
			
			if (lnSubExpr.size()==0)
				throw new RuntimeException("New case expression is empty !!!");
			
			cExpr.getExprs().clear();
			cExpr.getExprs().addAll(lnSubExpr);
		}
		
		return;
	}
	
	/**
	 *  Adapt the dependences of the program to make them as close of Id as possible
	 *  Example: if iBl=jBl=0 and we have a dependence L[jBl,jBl,...] => transform it into L[iBl,jBl,...]
	 * 		=> Useful to reduce the number of inputs of a subsystem which will be detected later...
	 * 
	 * @param syst
	 */
	private static void makeDepCloseToId(AffineSystem syst) {
		
		for (StandardEquation stEq : syst.getEquations()) {
			CaseExpression rhsStEq = (CaseExpression) stEq.getExpression();			// Invariant
			
			for (Expression subCaseExpr : rhsStEq.getExprs()) {
				RestrictExpression restExprBl = (RestrictExpression) subCaseExpr;	// Invariant
				
				// Context of the branch of this case
				FastISLDomain contextBl = (FastISLDomain) restExprBl.getRestrictDomain();
				
				Expression branchExpr = restExprBl.getExpr();
				branchExpr.accept(new CustomUniformizeInContext(contextBl));
			}
		}
	}
	
	private static class CustomUniformizeInContext extends PolyhedralIRDepthFirstVisitorImpl {
		org.polymodel.Domain _context;
		boolean _isUnderReduce = false;
		
		public CustomUniformizeInContext(FastISLDomain contextBl) {
			_context = contextBl.getPMdomain();
		}
		
		@Override
		public void visitDependenceExpression(DependenceExpression depExpr) {
			FastISLMap depFunc = (FastISLMap) depExpr.getDep();
			org.polymodel.Function func = depFunc.getPMmapping();
			
			org.polymodel.Function nFunc;
			if (_isUnderReduce)
				nFunc = func.uniformizeInContext(_context);
			else {
				// We just get the first half of the function (not under reduction => can just take half of the function)
				// 		Ex of what happens if we do not do that: (i,j,k,il,jl,kl -> 0,j,0,jl when k==0 gives an issue)
				int halfDimRhs = func.getExpressions().size()/2;
				List<IntExpression> lBlFunc = new BasicEList<IntExpression>();
				for (int k=0; k<halfDimRhs; k++)
					lBlFunc.add(func.getExpressions().get(k).copy());
				org.polymodel.Function blFunc = _polyFact.createFunction(func.getDimensions(), lBlFunc);
				
				org.polymodel.Function nBlFunc = blFunc.uniformizeInContext(_context);
				
				List<IntExpression> nLFunc = new BasicEList<IntExpression>();
				nLFunc.addAll(nBlFunc.getExpressions());
				for (int k=0; k<halfDimRhs; k++)
					nLFunc.add(func.getExpressions().get(k+halfDimRhs).copy());
				
				nFunc = _polyFact.createFunction(func.getDimensions(), nLFunc);
			}
			
			FastISLMap nDepFunc = _polyIRFact.createFastISLMap(nFunc);
			depExpr.setDep(nDepFunc);
		}
		
		@Override
		public void visitReduceExpression(ReduceExpression redExpr) {
			org.polymodel.Domain oldContext = _context;
			
			_context = _context.image(redExpr.getProjection().getPMmapping().buildRelation(_dimMana).reverse(_dimMana));
			boolean oldIsUnderReduce = _isUnderReduce;
			
			_isUnderReduce = true;
			redExpr.getExpr().accept(this);
			_isUnderReduce = oldIsUnderReduce;
			
			_context = oldContext;
		}
		
	} // CustomUniformizeInContext
	
	
	/* ----------------------------------------- OUTLINING ----------------------------------------- */
	public static void getSubsystemAfterCART(Program prog, AffineSystem syst, List<List<Pair<String, Boolean>>> lNAlignmentInfo,
			Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp) {
		
		/* DEBUG
		System.out.println("*********************************************");
		System.out.println(AShow.toString(syst));
		System.out.println(UniquenessAndCompletenessCheck.validate(prog));
		System.out.println("*********************************************");
		//*/
		if (_optionSaveInformations) {
			_dataStructSaved = _dataStructSaved.setAt5(mProjFuncRedTemp);
			_dataStructSaved = _dataStructSaved.setAt6(lNAlignmentInfo);
		}
		
		// STEP 1: getting the cuts
		List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts = computeCuts(syst, lNAlignmentInfo, mProjFuncRedTemp);
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 1) cut get");
		/* DEBUG
		System.out.println("llCuts = ");
		for (List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts : llCuts) {
			System.out.println("	-> Tile group number " + llCuts.indexOf(lCuts));
			for (Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut : lCuts) {
				System.out.println("		* " + cut.toString());
			}
		}
		//*/
		
		// STEP 1B: getting the parameter domain of each cut
		List<List<Pair<ParameterDomain,Boolean>>> llpParamDomLoc = computeParameterDomain(syst, llCuts, lNAlignmentInfo, mProjFuncRedTemp);
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 1B) paramDom");
		/* DEBUG
		System.out.println("OrigParamDom = " + syst.getParameters().toString());
		System.out.println("llpParamDomLoc =");
		for (List<Pair<ParameterDomain,Boolean>> lpParamDom : llpParamDomLoc)
		for (Pair<ParameterDomain,Boolean> pParamDom : lpParamDom)
			System.out.println("	" + pParamDom.toString());
		//*/
		
		// STEP 2A: Building the variables declarations for the main/subsystem
		List<List<Map<String,VariableDeclaration>>> llVarDeclSubsyst = createVariableDeclaration(syst, llCuts, llpParamDomLoc,
					mProjFuncRedTemp, lNAlignmentInfo);
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 2A) variableDeclaration");
		/* DEBUG
		System.out.println("llVarDeclSubsyst =");
		for (List<Map<String,VariableDeclaration>> lVarDeclSubsyst : llVarDeclSubsyst)
		for (Map<String,VariableDeclaration> mVarDeclSubsyst : lVarDeclSubsyst) {
			System.out.println(" * " + mVarDeclSubsyst.toString());
		}
		//*/
		
		// STEP 2B: for each cut, build the subsystem
		List<List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> >> llSubSyst =
				buildSubSystemNoOutput(syst, llCuts, lNAlignmentInfo, mProjFuncRedTemp, llpParamDomLoc, llVarDeclSubsyst);
		/* DEBUG
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("*********************** llSubSyst = ");
		for (List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> > lSubSyst : llSubSyst) {
			for (Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> pSubSyst : lSubSyst) {
				System.out.println(pSubSyst.getValue0().toString());
				System.out.println("InputInfos:");
				for (Triplet<String,long[][],VariableDeclaration> tInputInfo : pSubSyst.getValue1()) {
					System.out.println("	***** " + tInputInfo.getValue0());
					System.out.print("		* " + MatrixOperations.toString(tInputInfo.getValue1()));
					System.out.println("		* " + tInputInfo.getValue2());
					System.out.println();
				}
				System.out.println("----------------------------------");
			}
			System.out.println("----------------------------------");
		}
		System.out.println();
		//*/
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 2B) Building the subsystems (minus output)");
		
		if (_optionSaveInformations) {
			List<List<String>> llNameSubSyst = new BasicEList<List<String>>();
			for (int k=0; k<llSubSyst.size(); k++) {
				List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> > lSubSyst = llSubSyst.get(k);
				
				List<String> lNameSubSyst = new BasicEList<String>();
				for (int l=0; l<lSubSyst.size(); l++) {
					Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> pSubSyst = lSubSyst.get(l);
					lNameSubSyst.add(pSubSyst.getValue0().getName());
				}
				llNameSubSyst.add(lNameSubSyst);
			}
			_dataStructSaved = _dataStructSaved.setAt4(llNameSubSyst);
		}
		
		/* DEBUG
		System.out.println("_outputInfos = ");
		for (String strVar : _outputInfos.keySet()) {
			List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(strVar);
			
			System.out.println("	* " + strVar + " -> ");
			for (Pair<long[][],FastISLDomain> pMatDom : lOutputInfos)
				if (pMatDom.getValue0()==null)
					System.out.println("			- [[null]]\n			- " + pMatDom.getValue1().toString());
				else
					System.out.println("			- " + MatrixOperations.toString(pMatDom.getValue0()) +
				"			- " + pMatDom.getValue1().toString());
		}
		//*/
		
		// STEP 2C: for each subsystem, add the outputs (using _outputInfos)
		List<List<List<Pair<String,long[][]>>>> lllOutputOrder = buildSubSystemOutput(syst, llSubSyst, llCuts, llVarDeclSubsyst, llpParamDomLoc);
		
		/* DEBUG
		System.out.println("*********************** llSubSyst = ");
		for (List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>> lSubSyst : llSubSyst) {
			for (Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> subSyst : lSubSyst) {
				System.out.println(subSyst.getValue0().toString());
			}
			System.out.println("----------------------------------");
		}
		System.out.println();
		System.out.println("*********************** lllOutputOrder = ");
		for (List<List<Pair<String,long[][]>>> llOutputOrder : lllOutputOrder) {
			for (List<Pair<String,long[][]>> lOutputOrder : llOutputOrder) {
				for (Pair<String,long[][]> pOutputOrder : lOutputOrder)
				System.out.println("	- " + pOutputOrder.getValue0() + "\n	" + MatrixOperations.toString(pOutputOrder.getValue1()));
				System.out.println("----------------------------------");
			}
		}
		System.out.println();
		//*/
		/*
		System.out.println("_outputInfos = ");
		for (String strVar : _outputInfos.keySet()) {
			List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(strVar);
			
			System.out.println("	* " + strVar + " -> ");
			for (Pair<long[][],FastISLDomain> pMatDom : lOutputInfos)
				if (pMatDom.getValue0()==null)
					System.out.println("			- [[null]]\n			- " + pMatDom.getValue1().toString());
				else
					System.out.println("			- " + MatrixOperations.toString(pMatDom.getValue0()) +
				"			- " + pMatDom.getValue1().toString());
		}
		System.out.println();
		//*/
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 2C) Building the outputs of subsystems");
		
		
		// STEP 3: Building the main system
		buildMainSystem(syst, llSubSyst, llpParamDomLoc, llVarDeclSubsyst, llCuts, lNAlignmentInfo, mProjFuncRedTemp, lllOutputOrder);
		if (_timing)
			ParametricTiling.printInfoDebug("Outlining - 3) Building the main system");
		
		// Commit all subsystem in the main program
		for (List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> > lSubSyst : llSubSyst)
			for (Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> pSubSyst: lSubSyst)
				prog.getSystems().add(pSubSyst.getValue0());
		
		/* DEBUG
		System.out.println("**************************************************************");
		System.out.println(AShow.toString(prog));
		System.out.println("**************************************************************");
		//*/
		
		
		// Post-processing: reduce dimensions of the input/output of the subsystem + align them
		if (_optionSaveInformations)
			_dataStructSaved = _dataStructSaved.setAt0(llVarDeclSubsyst);
		
		if (_optionPostprocessReduceDimInOutputVariable) {
			Map<String,List<AffineFunction>> mlAlignOut = new HashMap<String, List<AffineFunction>>();
			for (int k=0; k<prog.getSystems().size(); k++) {
				AffineSystem subSyst = prog.getSystems().get(k);
				if (subSyst.getName().equals(syst.getName()))	// Not the main system
					continue;
				
				// DEBUG
				//System.out.println();
				//System.out.println("subSyst = " + subSyst.getName());
				
				
				ReduceDimensionVariable.reduceAndAlignDimInputs(subSyst);	// We do not care about the mapping for the inputs of a subsystem
				
				for (VariableDeclaration varDecl : subSyst.getInputs()) {
					if (varDecl.getDomain().getNIndices()==0) {
						// If scalar, need to keep the parameter constraints
						List<IntConstraintSystem> lConstrSyst = new BasicEList<IntConstraintSystem>();
						for (IntConstraintSystem constrSyst : subSyst.getParameters().getPMdomain().getPolyhedra())
							lConstrSyst.add(constrSyst.copy());
						varDecl.setDomain(_polyIRFact.createDomain(subSyst.getParameters().getParams(), new BasicEList<Variable>(), lConstrSyst));
					}
				}
				
				List<AffineFunction> lAlignOut = ReduceDimensionVariable.reduceAndAlignDimOutputs(subSyst);
				// First elements of lAlignOut corresponds to the inputs - following elements corresponds to the outputs
				
				mlAlignOut.put(subSyst.getName(), lAlignOut);
			}
			if (_optionSaveInformations)
				_dataStructSaved = _dataStructSaved.setAt3(mlAlignOut);
		}
		
		return;
	}
	
	/**
	 * Step 1: getting the cuts/kind of systems, and where they occurs
	 * 
	 * Input: lNAligmentInfo:
	 * 		- First List = "tile group"
	 * 		- Second List/Pair: (ordered) list of variables of the tile group + is it a TempRed which has more dimensions than the rest?
	 * 
	 * Output: llpCuts
	 * 		- First List = "tile group"
	 * 		- Second List = "cuts"
	 * 			- First Domain: domain of the cut
	 * 			- List<String,Integer>: Variables of the tile group which have a contribution to the cut
	 * 						+ which branch of the original case has been used
	 * 			- Integer: number of outlined dims
	 * 
	 * @param syst
	 * @param lNAlignmentInfo
	 * @return
	 */
	private static List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> computeCuts(AffineSystem syst,
			List<List<Pair<String, Boolean>>> lNAlignmentInfo, Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp) {
		List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts =
				new BasicEList<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>>();
		
		// For each tile group
		for (List<Pair<String,Boolean>> nAlignmentInfo : lNAlignmentInfo) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts =
						new BasicEList<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>();
			
			// 1) We look at the equations of the variables of the tile group (of the form "case D1_alpha: ... ; D2_alpha: ...; ... esac;")
			//		and we extract the restriction domain on the blocked indexes D1_alpha, D2_alpha, ...
			List<List<FastISLDomain>> lRestrictDomain = new BasicEList<List<FastISLDomain>>(); // Outermost List: contrib variable / innermost List: branches
			for (Pair<String,Boolean> pVarInCut : nAlignmentInfo) {
				String nameVarInCut = pVarInCut.getValue0();
				
				List<FastISLDomain> lTemp = new BasicEList<FastISLDomain>();
				StandardEquation stEqVarInCut = syst.getEquation(nameVarInCut);
				CaseExpression cExprBlVarInCut = (CaseExpression) stEqVarInCut.getExpression();		// Invariant
				List<Expression> lrExprBlVarInCut = cExprBlVarInCut.getExprs();
				for (Expression rExprBlVarInCut : lrExprBlVarInCut) {
					if (mProjFuncRedTemp.containsKey(nameVarInCut) && pVarInCut.getValue1()) {
						// TempRed_SG => need to project the corresponding domain in the dimensions \alpha_1, ii_1
						//	(we get rid of the dimensions \alpha_2)
						//		NOTE: the domain of lRestrictDomain works on {\alpha_1,ii_1| ...}
						Domain origRestrDom = ((RestrictExpression) rExprBlVarInCut).getRestrictDomain();
						
						FastISLMap projFunc = mProjFuncRedTemp.get(nameVarInCut).getValue0();
						int sizeAlpha1 = projFunc.getDimRHS()/2;
						int sizeAlpha2 = projFunc.getNIndices()-projFunc.getDimRHS();
						
						List<AffineExpression> projExprs = new BasicEList<AffineExpression>();
						for (int i=0; i<sizeAlpha1; i++)
							projExprs.add(IntExpressionBuilder.affine(origRestrDom.getIndices().get(i)));
						for (int i=0; i<sizeAlpha1; i++)
							projExprs.add(IntExpressionBuilder.affine(origRestrDom.getIndices().get(i+sizeAlpha1+sizeAlpha2)));
						
						FastISLMap proj = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(
								origRestrDom.getParams(), origRestrDom.getIndices(), projExprs).getPMmapping());
						lTemp.add( (FastISLDomain) origRestrDom.image(proj));
					} else
						lTemp.add( (FastISLDomain) ((RestrictExpression) rExprBlVarInCut).getRestrictDomain());
				}
				
				lRestrictDomain.add(lTemp);
			}
			
			// Invariant: first element of nAlignInfo is either a normal variable, or a reduction with no extra dimensions
			int nBlockedIndTG;
			if (mProjFuncRedTemp.containsKey(nAlignmentInfo.get(0).getValue0()) && !nAlignmentInfo.get(0).getValue1()) {		// Reduction with no extra values
				FastISLMap projFunc = mProjFuncRedTemp.get(nAlignmentInfo.get(0).getValue0()).getValue0();
				nBlockedIndTG = projFunc.getNIndices() - projFunc.getDimRHS()/2;
			} else {
				nBlockedIndTG = lRestrictDomain.get(0).get(0).getNIndices()/2;
			}
			
			
			/* DEBUG
			System.out.println("lRestrictDomain =");
			for (List<FastISLDomain> lDom: lRestrictDomain) {
				for (FastISLDomain dom : lDom)
					System.out.println("	- " + dom.toString());
				System.out.println("	-------");
			}
			//*/
			
			// Note: while doing the projection of the restriction domain of a TempRed_SG, we might end up with intersecting domains
			//	from 2 branches (ex: if "i=j<k" and "i=j=k" when k is the projected dim)
			//		=> Cleanest solution: check for intersection inside lRestrictDomain for the same TempRed_SG variable
			//				& introduce the intersection/diff (with a list of branch)
			//		=> Better solution: let the rest of the algo do that naturally, and merge/fix it at the end
			
			// 2) Getting the universe of tiles
			//		=> Putting the "rest of the tiles" at the end of each list of lRestrictDomain
			//		=> Selecting this one corresponds to not taking this variable
			FastISLDomain univDom = lRestrictDomain.get(0).get(0);
			List<FastISLDomain> lDomVar = new BasicEList<FastISLDomain>();
			for (List<FastISLDomain> cutsVark : lRestrictDomain) {
				FastISLDomain domTemp = cutsVark.get(0);
				for (int k=1; k<cutsVark.size(); k++)
					domTemp = (FastISLDomain) domTemp.union(cutsVark.get(k));
				domTemp.simplify();
				univDom = (FastISLDomain) univDom.union(domTemp);
				lDomVar.add(domTemp);
			}
			univDom.simplify();
			
			for (int k=0; k<lRestrictDomain.size(); k++) {
				FastISLDomain diff = (FastISLDomain) univDom.difference(lDomVar.get(k));
				lRestrictDomain.get(k).add(diff);	// Corresponding to "not taking this variable"
			}
			
			/* DEBUG
			System.out.println("univDom = " + univDom.toString());
			System.out.println("lRestrictDomain =");
			for (List<FastISLDomain> lrestDomain : lRestrictDomain)
				System.out.println("	-> " + lrestDomain.toString());
			//*/
			
			
			// 3) Cross product on lCutAlignment (intersection of union => union of intersections)
			//		 (List<Pair<String,Integer> > = which variable/branch is taken)
			List<Pair<FastISLDomain,List<Pair<String,Integer>>>> lBlcuts = new BasicEList<Pair<FastISLDomain,List<Pair<String,Integer>>>>();
			
			// Initialization on the first variable of the tile group
			List<FastISLDomain> cutAlignment0 = lRestrictDomain.get(0);
			for (int k=0; k<cutAlignment0.size(); k++) {
				List<Pair<String,Integer>> lk = new BasicEList<Pair<String,Integer>>();
				lk.add(Pair.with(nAlignmentInfo.get(0).getValue0(),k));
				lBlcuts.add(Pair.with(cutAlignment0.get(k),lk));
			}
			
			for (int k=1; k<lRestrictDomain.size(); k++) {			// Cross product with the other variables of the tile group
				List<Pair<FastISLDomain,List<Pair<String,Integer>>>> nlBlcuts = new BasicEList<Pair<FastISLDomain,List<Pair<String,Integer>>>>();
				
				for (Pair<FastISLDomain,List<Pair<String,Integer>>> oBlcuts : lBlcuts)
					for (int l=0; l<lRestrictDomain.get(k).size(); l++) {
						FastISLDomain interBlCut = (FastISLDomain) oBlcuts.getValue0().intersection(lRestrictDomain.get(k).get(l));
						if (!interBlCut.isEmpty()) {
							List<Pair<String,Integer>> lindexes = new BasicEList<Pair<String,Integer>>();
							lindexes.addAll(oBlcuts.getValue1());
							lindexes.add(Pair.with(nAlignmentInfo.get(k).getValue0(), l));
							nlBlcuts.add(Pair.with(interBlCut, lindexes));
						}
					}
				lBlcuts = nlBlcuts;
			}
			
			/* DEBUG
			System.out.println("-- lBlcuts = ");
			for (int i=0; i<lBlcuts.size(); i++) {		// For all cuts
				Pair<FastISLDomain,List<Pair<String,Integer>>> pBlCuts = lBlcuts.get(i);
				System.out.println("	=> Cut #" + i + " (" + pBlCuts.getValue0().toString() + ")");
				for (int j=0; j<pBlCuts.getValue1().size(); j++) {
					Pair<String,Integer> pContrib = pBlCuts.getValue1().get(j);
					System.out.println("			-> Contrib " + j + " [ " + pContrib.getValue0() + " | " + pContrib.getValue1() + " ]");
				}
			}
			//*/
			
			// 4) Building lCuts from lBlcuts (removing the universe when it occurs)
			List<Triplet<FastISLDomain,List<Pair<String,Integer>>,Integer>> lCutsRedund =
					new BasicEList<Triplet<FastISLDomain,List<Pair<String,Integer>>,Integer>>();
			for (Pair<FastISLDomain,List<Pair<String,Integer>>> blCuts : lBlcuts) {
				blCuts.getValue0().simplify();		// In case of Union (if intersection with an universe somewhere)
				if (blCuts.getValue0().getPMdomain().getPolyhedra().size()>1)
					throw new RuntimeException("Issue with the cut derivation => we have a non-simplified union of domain here...");
				List<Pair<String,Integer>> lIntCase = blCuts.getValue1();
				List<Pair<String,Integer>> lvarNameCut = new BasicEList<Pair<String,Integer>>();			// Variables which contribute to the cut
				for (int k=0; k<lIntCase.size(); k++)
					if (lIntCase.get(k).getValue1()!=lRestrictDomain.get(k).size()-1)		// If the kth variable has a contribution to the tile
						lvarNameCut.add(lIntCase.get(k));
				
				if (lvarNameCut.isEmpty())
					continue;		// Nobody is contributing to this tile/cut => skip this cut
				
				lCutsRedund.add(Triplet.with(blCuts.getValue0(), lvarNameCut, nBlockedIndTG));
			}
			
			/* DEBUG
			System.out.println("lCutsRedund = ");
			for (Triplet<FastISLDomain,List<Pair<String,Integer>>,Integer> cut : lCutsRedund) {
				System.out.println("		* " + cut.toString());
			}
			//*/
			
			// 4B) Managing the potential overlapping due to the projection of the restriction domain of the TempRed_SG
			//		(for the details, cf comment right before 2) )
			for (Triplet<FastISLDomain,List<Pair<String,Integer>>,Integer> contrib : lCutsRedund) {		// For all new contrib...
				
				// Recursion: we check if the new contrib interfere with the current lCuts
				List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> nlCuts =			// Result after inserting the new contrib
						new BasicEList<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>();
				
				FastISLDomain contribNotInteresected = contrib.getValue0();
				for (Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> currentCut : lCuts) {
					FastISLDomain interContrib = (FastISLDomain) contribNotInteresected.intersection(currentCut.getValue0());
					
					// Does contrib affect currentCut?
					if (!interContrib.isEmpty()) {
						List<Pair<String,List<Integer>>> lContribCurrentCut = currentCut.getValue1();
						List<Pair<String,Integer>> lContribContrib = contrib.getValue1();
						// We merge lContribCurrentCut and lContribContrib
						
						// ""List<Pair<String,List<Integer>>> lpVarNameNumLBranch = lContribCurrentCut.copy();""
						List<Pair<String,List<Integer>>> lpVarNameNumLBranch = new BasicEList<Pair<String,List<Integer>>>();
						for (int k=0; k<lContribCurrentCut.size(); k++) {
							List<Integer> nlNumLBranch = new BasicEList<Integer>();
							nlNumLBranch.addAll(lContribCurrentCut.get(k).getValue1());
							lpVarNameNumLBranch.add(Pair.with(lContribCurrentCut.get(k).getValue0(), nlNumLBranch));
						}
						
						for (Pair<String,Integer> pVarNumLBranchContrib : lContribContrib) {
							String varNameContrib = pVarNumLBranchContrib.getValue0();
							
							for (Pair<String,List<Integer>> pVarNameLBranchCurrentCut : lpVarNameNumLBranch) {
								if (pVarNameLBranchCurrentCut.getValue0().equals(varNameContrib)) {
									// Check for redundancies
									if (!pVarNameLBranchCurrentCut.getValue1().contains(pVarNumLBranchContrib.getValue1()))
										pVarNameLBranchCurrentCut.getValue1().add(pVarNumLBranchContrib.getValue1());
								}
							}
						}
						
						nlCuts.add(Triplet.with(interContrib, lpVarNameNumLBranch, contrib.getValue2()));
						
						// Update contribNotIntersected
						contribNotInteresected = (FastISLDomain) contribNotInteresected.difference(interContrib);
					} else {
						nlCuts.add(currentCut);
					}
				}
				
				// Add the rest of the contrib which is not intersected to nlCuts
				if (!contribNotInteresected.isEmpty()) {
					List<Pair<String,List<Integer>>> nlvarNameCut = new BasicEList<Pair<String,List<Integer>>>();
					for (Pair<String,Integer> pVarNameNumBranch : contrib.getValue1()) {
						List<Integer> lNumBranch = new BasicEList<Integer>();
						lNumBranch.add(pVarNameNumBranch.getValue1());
						nlvarNameCut.add(Pair.with(pVarNameNumBranch.getValue0(),lNumBranch));
					}
					nlCuts.add(Triplet.with(contribNotInteresected,nlvarNameCut,contrib.getValue2()));
				}
				
				lCuts = nlCuts;
			}
			
			// INVARIANT: the only variables which MIGHT have multiple element in their list of branch contributing are TempRed_SG
			
			llCuts.add(lCuts);
		}
		
		return llCuts;
	}
	
	/**
	 * Step 1B: getting the parameter domain for each tile group - cuts
	 * 		=> Because we might have index/reduce expression, we have 2 potential parameter domain returned:
	 * 		=> false: only the local parameters (for the systems without index expressions)
	 * 		=> true: all parameters (same parameter domain than original, for the systems with index expressions)
	 * 
	 * @param syst
	 * @return
	 */
	private static List<List<Pair<ParameterDomain,Boolean>>> computeParameterDomain(AffineSystem syst,
			List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts,
			List<List<Pair<String, Boolean>>> lNAlignmentInfo, Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp) {
		
		// 0) Before that, determine if there is an indexExpression in the corresponding cut
		Map<String, List<Boolean>> mIsThereAnIndexExpression = new HashMap<String, List<Boolean>>();
					// isThereAnIndexExpression for each branch of the case of each variable
		
		IndexExpressionVisitor indExprvisit = new IndexExpressionVisitor();
		for (StandardEquation stEq : syst.getEquations()) {
			List<Boolean> lBool = new BasicEList<Boolean>();
			
			CaseExpression cExpr = (CaseExpression) stEq.getExpression();
			
			for (int k=0; k<cExpr.getExprs().size(); k++) {
				Expression expr = cExpr.getExprs().get(k);
				expr.accept(indExprvisit);
				
				lBool.add(indExprvisit._isthereIndexRedExpression);
				indExprvisit._isthereIndexRedExpression = false;
			}
			
			mIsThereAnIndexExpression.put(stEq.getVariable().getName(), lBool);
		}
		
		
		// For each tilegroup/cut we have:
		List<List<Pair<ParameterDomain,Boolean>>> llpParamDom = new BasicEList<List<Pair<ParameterDomain,Boolean>>>();
		
		for (int numTileGroup=0; numTileGroup<llCuts.size(); numTileGroup++) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(numTileGroup);
			List<Pair<String, Boolean>> nAlignmentInfo = lNAlignmentInfo.get(numTileGroup);
			
			List<Pair<ParameterDomain,Boolean>> lpParamDom = new BasicEList<Pair<ParameterDomain,Boolean>>();
			for (Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut : lCuts) {
				
				// Is there an index expression?
				List<Pair<String,List<Integer>>> lcontributors = cut.getValue1();
				boolean indexExpressionInThisCut = false;
				for (Pair<String,List<Integer>> contrib : lcontributors) {
					for (int lBranchContrib : contrib.getValue1())
						if (mIsThereAnIndexExpression.get(contrib.getValue0()).get(lBranchContrib)) {
							indexExpressionInThisCut = true;
							break;
						}
				}
				
				if (!indexExpressionInThisCut) {
					// 1) Getting the parameter domain if no index + reduce expression => only local parameters + b
					List<Matrix> lMatSystParamDom = syst.getParameters().getPMdomain().toMatrices();	// Contains only parameters
					EList<Variable> nlParams = new BasicEList<Variable>();
					int nParamScal = (syst.getParameters().getNParams()-1)/2;			// Half of the original parameters (minus "b") are scalar
					for (int x=0; x<nParamScal+1; x++)
						nlParams.add(_dimMana.getParameter(x, syst.getParameters().getParamNames().get(x+nParamScal)));
					DomainDimensions domDimParamDom = _polyFact.createDomainDimensions(new BasicEList<Variable>(), nlParams);
					
					List<IntConstraintSystem> nlsyst = new BasicEList<IntConstraintSystem>();
					for (Matrix mat : lMatSystParamDom) {
						List<MatrixRow> rowLocalConstr = new BasicEList<MatrixRow>();
						for (int x=0; x<mat.getNbRows(); x++) {
							boolean isLocalConstraint = true;
							
							for (int y=0; y<nParamScal; y++)
								if (mat.get(x,y+1)!=0)
									isLocalConstraint = false;
							
							if (isLocalConstraint) {
								MatrixRow mRow = _polyFact.createMatrixRow(nParamScal+3);
								mRow.set(0, mat.get(x, 0));	// Eq/Ineq
								for (int y=nParamScal+1; y<mat.getNbCols(); y++)  // Param + const
									mRow.set(y-nParamScal,mat.get(x,y));
								rowLocalConstr.add(mRow);
							}
						}
						
						mat.getRows().clear();
						mat.getRows().addAll(rowLocalConstr);
						nlsyst.add(mat.toDomain(nlParams, new BasicEList<Variable>()));
					}

					ParameterDomain paramDomNoIndex = _polyIRFact.createParameterDomain(_polyFact.createDomain(domDimParamDom, nlsyst));
					lpParamDom.add(Pair.with(paramDomNoIndex, false));
					
					
				} else {
					// 2) Getting the parameter domain if index or reduce expression
					//		=> blocked parameters + local parameters + b + blocked indexes (with no constraints on these blocked indexes)
					List<Matrix> lMatSystParamDom = syst.getParameters().getPMdomain().toMatrices();	// Contains only parameters
					
					int nIndBlock = cut.getValue2();
					List<String> lBlockedIndNames = new BasicEList<String>();
					for (int i=0; i<nIndBlock; i++)
						lBlockedIndNames.add(syst.getVariableDeclaration(nAlignmentInfo.get(0).getValue0()).getDomain().getIndexNames().get(i));
					
					EList<Variable> nlParamsIndex = new BasicEList<Variable>();
					for (int x=0; x<syst.getParameters().getNParams(); x++)					// blocked + local params + b
						nlParamsIndex.add(_dimMana.getParameter(x, syst.getParameters().getParamNames().get(x)));
					for (int x=0; x<nIndBlock; x++)					// blocked indices
						nlParamsIndex.add(_dimMana.getParameter(x+syst.getParameters().getNParams(), lBlockedIndNames.get(x)));
					DomainDimensions domDimParamDomIndex = _polyFact.createDomainDimensions(new BasicEList<Variable>(), nlParamsIndex);
					
					// To avoid a warning, we add the constraints of the cut at the same time
					//		(constraints on the blocked parameters/indexes)
					FastISLDomain domCut = cut.getValue0();
					assert(domCut.getPMdomain().getPolyhedra().size()==1);			// ASSUMPTION: By construction of the cuts
					
					Matrix matCut = domCut.toMatrix().get(0);
					// Order of columns in matCut: eq/ineq - Nb - Nl - b - \alpha - ii - const
					//								  *      *    0    0      *     0      *
					//		where * = something / 0 = nothing
					//			=> Can copy everything, except local indexes (ii)
					
					List<IntConstraintSystem> nlsystIndex = new BasicEList<IntConstraintSystem>();
					for (Matrix mat : lMatSystParamDom) {
						List<MatrixRow> rowLocalConstr = new BasicEList<MatrixRow>();
						for (int x=0; x<mat.getNbRows(); x++) {
							MatrixRow mRow = _polyFact.createMatrixRow(syst.getParameters().getNParams()+nIndBlock+2);
							for (int y=0; y<mat.getNbCols()-1; y++)		// Everything except constant
								mRow.set(y, mat.get(x,y));
							// No constraints on the blocked indexes
							mRow.set(mRow.getSize()-1, mat.get(x,mat.getNbCols()-1));		// Constants
							rowLocalConstr.add(mRow);
						}
						
						// No need to do a selection here, because there should not be any local constraints in the cut domain
						
						// Copy of the constraints of the cut
						for (int x=0; x<matCut.getNbRows(); x++) {
							MatrixRow mRow = _polyFact.createMatrixRow(syst.getParameters().getNParams()+nIndBlock+2);
							for (int y=0; y<mRow.getSize()-1; y++)		// Everything except constant
								mRow.set(y, matCut.get(x,y));
							mRow.set(mRow.getSize()-1, matCut.get(x, matCut.getNbCols()-1));	// Constants
							rowLocalConstr.add(mRow);
						}
						
						mat.getRows().clear();
						mat.getRows().addAll(rowLocalConstr);
						nlsystIndex.add(mat.toDomain(nlParamsIndex, new BasicEList<Variable>()));
					}
					
					ParameterDomain paramDomIndex = _polyIRFact.createParameterDomain(_polyFact.createDomain(domDimParamDomIndex, nlsystIndex));
					lpParamDom.add(Pair.with(paramDomIndex, true));
				}
			}
			llpParamDom.add(lpParamDom);
		}
		
		return llpParamDom;
	}
	
	/**
	 * Visitor to know if we have an index or a reduction expression inside this branch
	 * 	(in which case, we need the blocked indexes and parameters in the parameter domain)
	 */
	private static class IndexExpressionVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		public boolean _isthereIndexRedExpression = false;
		
		public IndexExpressionVisitor() { }
		
		@Override
		public void visitIndexExpression(IndexExpression indExpr) {
			_isthereIndexRedExpression = true;
		}
		
		@Override
		public void visitReduceExpression(ReduceExpression redExpr) {
			_isthereIndexRedExpression = true;
		}
	}
	
	/**
	 * Step 2A: creating the VariableDeclaration for the subsystems and main systems
	 * 	(output of useEquations (temporary, because we do not know them yet) and local/output of main)
	 * @return
	 */
	private static List<List<Map<String,VariableDeclaration>>> createVariableDeclaration(
			AffineSystem syst, List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts, List<List<Pair<ParameterDomain,Boolean>>> llpParamDom,
			Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp, List<List<Pair<String, Boolean>>> lNAlignmentInfo) {
		
		List<List<Map<String,VariableDeclaration>>> llSubSystVarDecl = new BasicEList<List<Map<String,VariableDeclaration>>>();
		
		// For each tile group...
		for (int nTileGroup=0; nTileGroup<llCuts.size(); nTileGroup++) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(nTileGroup);
			List<Pair<ParameterDomain,Boolean>> lpParamDom = llpParamDom.get(nTileGroup);
			List<Pair<String,Boolean>> alignmentInfo = lNAlignmentInfo.get(nTileGroup);
			
			List<Map<String,VariableDeclaration>> lSubSystVarDecl = new BasicEList<Map<String,VariableDeclaration>>();
			
			// For each cuts...
			for (int numCut=0; numCut<lCuts.size(); numCut++) {
				Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut = lCuts.get(numCut);
				Pair<ParameterDomain,Boolean> pParamDom = lpParamDom.get(numCut);
				
				Map<String,VariableDeclaration> mSubSystVarDecl = new HashMap<String, VariableDeclaration>();
				
				FastISLDomain domCut = cut.getValue0();
				
				for (Pair<String,List<Integer>> pVarNameNumBranch : cut.getValue1()) {
					String varName = pVarNameNumBranch.getValue0();
					
					// 1) Getting the tile shape
					FastISLDomain domBeforeParamConstr;
					if (mProjFuncRedTemp.containsKey(varName)) {
						
						boolean isTempRed = false;
						boolean wasfound = false;
						for (Pair<String,Boolean> pStrBool : alignmentInfo)
							if (pStrBool.getValue0().equals(varName)) {
								isTempRed = pStrBool.getValue1();
								wasfound = true;
							}
						if (!wasfound)
							throw new RuntimeException("Variable " + varName + "was not found in alignmentInfo");
						
						if (isTempRed) {
							FastISLDomain domCutTemp = (FastISLDomain) domCut.preimage(mProjFuncRedTemp.get(varName).getValue0());
							domBeforeParamConstr = (FastISLDomain) ((FastISLDomain) syst.getVariableDeclaration(varName).getDomain()).intersection(domCutTemp);
						} else
							domBeforeParamConstr = (FastISLDomain) ((FastISLDomain) syst.getVariableDeclaration(varName).getDomain()).intersection(domCut);
					} else {
						domBeforeParamConstr = (FastISLDomain) ((FastISLDomain) syst.getVariableDeclaration(varName).getDomain()).intersection(domCut);
					}
					
					FastISLDomain domInterVarName = _polyIRFact.createFastISLDomain(DomainOperations.copyParameterConstraints(
							domBeforeParamConstr,
							syst.getParameters()).getPMdomain());		// Getting the tile shape
					
					// DEBUG
					//System.out.println("domInterVarName = " + domInterVarName.toString());
					
					
					// 2) Main system
					//VariableDeclaration varDeclMain = _polyIRFact.createVariableDeclaration(varName + "_" + numCut,
					//		syst.getVariableDeclaration(varName).getType(),
					//		domInterVarName.copy());				// Domain:  we assume TEMPORARLY that the whole tile is needed
					//mMainSystVarDecl.put(varName, varDeclMain);
					
					// DEBUG
					//System.out.println("varDeclMain = " + varDeclMain.toString());
					
					
					// 3) Subsystem (corresponding to the local/output)
					//			=> TEMPORARLY, we assume that the whole tile is needed (might not be legal, but we will correct that later)
					//  (same hypothesis than before / this will be managed with the outputs)
					int nIndOutlined = cut.getValue2();
					
					FastISLDomain domVarDeclLocSubSyst;
					if (pParamDom.getValue1()) {		// Full param dom
						List<Matrix> lMatInterVarName = domInterVarName.toMatrix();
						
						EList<Variable> lnIndices = new BasicEList<Variable>();
						for (int i=0; i<domInterVarName.getNIndices()-nIndOutlined; i++)
							lnIndices.add(_dimMana.getDimension(i, domInterVarName.getIndexNames().get(i+nIndOutlined)));
						
						List<IntConstraintSystem> lnSyst = new BasicEList<IntConstraintSystem>();
						for (Matrix matInterVarName : lMatInterVarName)
							lnSyst.add(matInterVarName.toDomain(pParamDom.getValue0().getParams(), lnIndices));
						domVarDeclLocSubSyst = _polyIRFact.createFastISLDomain(_polyIRFact.createDomain(pParamDom.getValue0().getParams(), lnIndices, lnSyst).getPMdomain());
					} else {							// param dom only containts local parameters + b
						domVarDeclLocSubSyst = removeBlockedParamIndexes(domInterVarName, domInterVarName.getNIndices()-nIndOutlined, pParamDom);
					}
					domVarDeclLocSubSyst.simplify();
					VariableDeclaration varDeclLocSubSyst = _polyIRFact.createVariableDeclaration(varName + "_loc",
							syst.getVariableDeclaration(varName).getType(),
							domVarDeclLocSubSyst);
					
					mSubSystVarDecl.put(varName, varDeclLocSubSyst);
				}
				lSubSystVarDecl.add(mSubSystVarDecl);
			}	// END loop over the cuts
			llSubSystVarDecl.add(lSubSystVarDecl);
		}
		return llSubSystVarDecl;
	}
	
	/**
	 * Auxiliary function to remove the first "nIndScal" dimensions of a domain
	 * + change the parameters indexes ONLY in the case of small parameter domain
	 * 
	 * @param fullDom
	 * @return
	 */
	private static FastISLDomain removeBlockedParamIndexes(FastISLDomain fullDom, int nIndScal, Pair<ParameterDomain,Boolean> pParamDom) {
		int nBlockDim = fullDom.getNIndices()-nIndScal;
		ParameterDomain paramDom = pParamDom.getValue0();
		
		if (fullDom.getIslSet().getBasicSets().size()==0) {
			EList<Variable> lnIndices = new BasicEList<Variable>();
			for (int i=nBlockDim; i<fullDom.getNIndices(); i++)
				lnIndices.add(_dimMana.getDimension(i, fullDom.getIndexNames().get(i)));
			
			Domain emptyDom = PolyhedralIRUtility.createEmptyDomain(pParamDom.getValue0().getParams(), lnIndices);
			
			return _polyIRFact.createFastISLDomain(emptyDom.getPMdomain());	// TODO: issue here ?
		}
		
		FastISLDomain nDomRestr;
		if (pParamDom.getValue1()) {		// Full parameter
			JNIISLSet set = fullDom.getIslSet().copy();
			int nParam = set.getNbDims(JNIISLDimType.isl_dim_param);
			
			JNIISLSet nSet = set.moveDims(JNIISLDimType.isl_dim_param, nParam, JNIISLDimType.isl_dim_set, 0, nBlockDim);
			nSet = nSet.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_param, nParam, nSet.getNbDims(JNIISLDimType.isl_dim_param)-nParam);
			
			EList<Variable> lnIndices = new BasicEList<Variable>();
			for (int i=nBlockDim; i<fullDom.getNIndices(); i++)
				lnIndices.add(_dimMana.getDimension(i-nBlockDim, fullDom.getIndexNames().get(i)));
			DomainDimensions domDims = _polyFact.createDomainDimensions(lnIndices, paramDom.getParams());
			
			nDomRestr = _polyIRFact.createFastISLDomain(domDims, nSet);
		} else {							// Half parameters (aka, no reductions)
			
			// Sanity check
			if (nBlockDim!=fullDom.getNIndices()/2)
				throw new RuntimeException("This case should not happen: half parameter domain and non full blocked dims (= TempRed_SG)");
			
			JNIISLSet set = fullDom.getIslSet().copy();
			
			// Remove the constraints on the blocked/local parameters
			int nParamBl = (fullDom.getNParams()-1)/2;
			JNIISLSet tempSet = set.projectOut(JNIISLDimType.isl_dim_param, 0, nParamBl);
			JNIISLSet finalSet = tempSet.projectOut(JNIISLDimType.isl_dim_set, 0, nBlockDim);
			
			EList<Variable> lnIndices = new BasicEList<Variable>();
			for (int i=nBlockDim; i<fullDom.getNIndices(); i++)
				lnIndices.add(_dimMana.getDimension(i-nBlockDim, fullDom.getIndexNames().get(i)));
			DomainDimensions domDims = _polyFact.createDomainDimensions(lnIndices, paramDom.getParams());
			
			nDomRestr = _polyIRFact.createFastISLDomain(domDims, finalSet);
		}
		
		return nDomRestr;
	}
	
	/**
	 * Step 2B: first pass of the sub-system building
	 * 		=> Build the variables declaration of variables computed by this tile
	 * 		=> Parse the original equations to build the equations of the subsystem (minus the output)
	 * 
	 * @param syst
	 * @param lNAlignmentInfo
	 * @param mProjFuncRedTemp
	 * @param lpParamDomLoc_Full
	 */
	private static List<List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> >> buildSubSystemNoOutput(AffineSystem syst,
			List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts,
			List<List<Pair<String, Boolean>>> lNAlignmentInfo, Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp,
			List<List<Pair<ParameterDomain,Boolean>>> llpParamDom, List<List<Map<String,VariableDeclaration>>> llVarDeclSubsyst) {
		
		_outputInfos = new HashMap<String,List<Pair<long[][],FastISLDomain>>>();
		
		List<VariableDeclaration> systVarDecl = new BasicEList<VariableDeclaration>();
		systVarDecl.addAll(syst.getInputs());
		systVarDecl.addAll(syst.getLocals());
		systVarDecl.addAll(syst.getOutputs());
		
		List<String> lInputName = new BasicEList<String>();
		for (VariableDeclaration varDecl : syst.getInputs())
			lInputName.add(varDecl.getName());
		
		List<List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>>> llSubSyst =
				new BasicEList<List< Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> >>();
		
		// For each tile group...
		for (int nTileGroup=0; nTileGroup<llCuts.size(); nTileGroup++) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(nTileGroup);
			List<Pair<ParameterDomain,Boolean>> lpParamDom = llpParamDom.get(nTileGroup);
			List<Map<String,VariableDeclaration>> lVarDeclSubsyst = llVarDeclSubsyst.get(nTileGroup);
			
			List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>> lSubSyst =
					new BasicEList<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>>();
			
			// For each cuts...
			for (int numCut=0; numCut<lCuts.size(); numCut++) {
				Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut = lCuts.get(numCut);
				Pair<ParameterDomain,Boolean> pParamDom = lpParamDom.get(numCut);
				Map<String,VariableDeclaration> mVarDeclSubsyst = lVarDeclSubsyst.get(numCut);
				
				
				// Variables contributing to the cut
				List<String> lvarName = new BasicEList<String>();
				for (Pair<String,List<Integer>> contrib : cut.getValue1())
					lvarName.add(contrib.getValue0());
				
				// Number of blocked indexes to eliminate in the cut
				int nIndBlockedCut = cut.getValue2();
				
				
				// ~~~ Visit the expressions
				//		=> gather the informations about inputs/outputs of tiles
				//		=> suppress the block dimensions inside the expressions
				
				OutliningParametricTilingVisitor visitor = new OutliningParametricTilingVisitor(lvarName, mVarDeclSubsyst,
						pParamDom.getValue1(), pParamDom.getValue0(),
						nIndBlockedCut, llCuts, lNAlignmentInfo, mProjFuncRedTemp, systVarDecl,
						lInputName);
				
				List<StandardEquation> lExprSubSystem = new BasicEList<StandardEquation>();
				for (int k=0; k<cut.getValue1().size(); k++) {
					String varName = lvarName.get(k);
					List<Integer> lBranches = cut.getValue1().get(k).getValue1();
					
					List<Expression> lExprBuilt = new BasicEList<Expression>();
					for (int l=0; l<lBranches.size(); l++) {
						Expression visitedExpr = ( (RestrictExpression)
								((CaseExpression) syst.getEquation(varName).getExpression()).getExprs().get(lBranches.get(l)) ).getExpr();
						
						// Is it a tempRed_SG?
						if (mProjFuncRedTemp.containsKey(varName)) {
							// TempRed_SG => still blocked indexes remaining => |\alpha_1| + |\alpha_2| > nIndBlockedCut
							FastISLMap projFunc = mProjFuncRedTemp.get(varName).getValue0();
							int sizeAlpha1Alpha2 = projFunc.getNIndices() - (projFunc.getDimRHS()/2);
							visitor._areAllCurrentBlockedIndOutlined = (sizeAlpha1Alpha2==nIndBlockedCut);
							
							/*if (!visitor._areAllCurrentBlockedIndOutlined) {
								//	INVARIANT: After CART + outlining prep + comutation case/reduction, we have a restriction (or a case/restriction)
								//		below each reduction in the TempRed / TempRed_SG equations
								Expression subExprReduce = ((ReduceExpression) visitedExpr).getExpr();
								if (subExprReduce instanceof CaseExpression) {
									assert(((CaseExpression) subExprReduce).getExprs().size()==1);
									subExprReduce = ((CaseExpression) subExprReduce).getExprs().get(0);
								}
								visitor._tempRedSG_ContextBelowReduction = (FastISLDomain)
										((RestrictExpression) subExprReduce).getRestrictDomain();
							}*/
							
						} else {		// Not even a tempRed
							visitor._areAllCurrentBlockedIndOutlined = true;
						}
						
						// Domain of the current cut
						visitor._currentBlockedDom = (FastISLDomain) cut.getValue0().copy();
						visitor._nameCurrentVar = varName;
						
						if (OutliningParametricTilingVisitor._noisyVisitor)
							System.out.println("\n ***** CurrentEquation varName = " + varName);
						
						visitedExpr.accept(visitor);
						
						Expression copyExpr = visitor._subExprDimRed;
						
						lExprBuilt.add(copyExpr);
					}
					
					if (lExprBuilt.size()==1) {
						lExprSubSystem.add(_polyIRFact.createStandardEquation(mVarDeclSubsyst.get(varName), lExprBuilt.get(0)));
					} else {
						List<RestrictExpression> lRestrExprBuilt = new BasicEList<RestrictExpression>();
						for (int l=0; l<lExprBuilt.size(); l++) {
							FastISLDomain restrDom = (FastISLDomain) ( (RestrictExpression)
									((CaseExpression) syst.getEquation(varName).getExpression()).getExprs().get(lBranches.get(l)) ).getRestrictDomain().copy();
							// Remark: if we are here, we are currently considering a TempRed_SG => the parametric domain is full
							
							// We move the first nOutlinedDim dimensions into the parameters to adapt restrDom
							JNIISLSet setRestrDom = restrDom.getIslSet();
							setRestrDom = setRestrDom.moveDims(JNIISLDimType.isl_dim_param, setRestrDom.getNbDims(JNIISLDimType.isl_dim_param),
									JNIISLDimType.isl_dim_set, 0, cut.getValue2());
							for (int x=0; x<pParamDom.getValue0().getNParams(); x++)
								setRestrDom = setRestrDom.setDimName(JNIISLDimType.isl_dim_param, x, pParamDom.getValue0().getParams().get(x).getName());
							
							DomainDimensions domDimsRestrDom = _polyFact.createDomainDimensions(
									mVarDeclSubsyst.get(varName).getDomain().getIndices(), pParamDom.getValue0().getParams());
							FastISLDomain nRestrDom = _polyIRFact.createFastISLDomain(domDimsRestrDom, setRestrDom);
							
							lRestrExprBuilt.add(_polyIRFact.createRestrictExpression(nRestrDom, lExprBuilt.get(l)));
						}
						CaseExpression caseExpr = _polyIRFact.createCaseExpression(lRestrExprBuilt);
						lExprSubSystem.add(_polyIRFact.createStandardEquation(mVarDeclSubsyst.get(varName), caseExpr));
					}
				}
				
				/* DEBUG
				System.out.println("lExprSubSystem =");
				for (StandardEquation stEq : lExprSubSystem)
					System.out.println(PolyhedralIRToAlphabets.toString(stEq));
				//*/
				
				// Recovering the infos about input
				List<Triplet<String,long[][],VariableDeclaration>> inputInfos = visitor.getInputInformations();
				
				
				List<VariableDeclaration> lInputs = new BasicEList<VariableDeclaration>();
				for (Triplet<String,long[][],VariableDeclaration> tStrMatVarDecl : inputInfos)
					lInputs.add(tStrMatVarDecl.getValue2());
				
				
				// ~~~ Subsystem
				List<VariableDeclaration> lLocalSubSystemVarDecl = new BasicEList<VariableDeclaration>();
				for (String varName : lvarName)
					lLocalSubSystemVarDecl.add(mVarDeclSubsyst.get(varName));
				String nameSubSyst = syst.getName() + "_" + lvarName.get(0) + "_Tile_" + numCut;
				AffineSystem subSyst = _polyIRFact.createAffineSystem(nameSubSyst, (ParameterDomain) pParamDom.getValue0().copy());
				subSyst.getEquations().addAll(lExprSubSystem);						// Equations
				subSyst.getInputs().addAll(lInputs);								// Input variables
				subSyst.getLocals().addAll(lLocalSubSystemVarDecl);					// Local variables: currently all (and full tile)
				// Local/output precise variable management => cf later (in 3) )
				
				
				// Store the created subsystem
				lSubSyst.add(Pair.with(subSyst,visitor.getInputInformations()));
			}
			llSubSyst.add(lSubSyst);
		}
		
		return llSubSyst;
	}
	
	// Collected informations on the outputs of subsystems, global to all built subsystems
	//		 Use half parameter domain by default
	// Information: String = name of the variable + long[][] = corresponding block => FastISLDomain: domain of the output
	private static Map<String,List<Pair<long[][],FastISLDomain>>> _outputInfos;
	
	/**
	 * Step 2C: second pass of the sub-system building
	 * 			=> Getting the outputs (once that we have all the needed informations)
	 * 
	 * @param subsyst
	 * @param lNAlignmentInfo
	 * @param llCuts
	 */
	private static List<List<List<Pair<String,long[][]>>>> buildSubSystemOutput(AffineSystem syst,
			List<List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>>> llSubsyst,
			List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts, List<List<Map<String,VariableDeclaration>>> llVarDeclSubsyst,
			List<List<Pair<ParameterDomain,Boolean>>> llpParamDom) {
		
		// *** Simplification of _outputInfos
		EList<Variable> lParamHalf = null;
		for (String varName : _outputInfos.keySet()) {
			List<Pair<long[][],FastISLDomain>> lOutputVar = _outputInfos.get(varName);
			for (Pair<long[][],FastISLDomain> pMatOutDom : lOutputVar)
				pMatOutDom.getValue1().simplify();
			
			if (lParamHalf==null)
				lParamHalf = _outputInfos.get(varName).get(0).getValue1().getParams();
		}
		if (lParamHalf==null) {		// _outputInfos is null
			List<Variable> origParam = syst.getParameters().getParams();
			int nParamScal = (origParam.size()-1)/2;
			
			lParamHalf = new BasicEList<Variable>();
			for (int i=0; i<nParamScal; i++)
				lParamHalf.add(_dimMana.getParameter(i, origParam.get(i+nParamScal).getName()));
			lParamHalf.add(_dimMana.getParameter(nParamScal,origParam.get(origParam.size()).getName()));
		}
		
		/* DEBUG
		System.out.println("_outputInfos = ");
		for (String strVar : _outputInfos.keySet()) {
			List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(strVar);
			
			System.out.println("	* " + strVar + " -> ");
			for (Pair<long[][],FastISLDomain> pMatDom : lOutputInfos)
				if (pMatDom.getValue0()==null)
					System.out.println("			* [[null]]\n			- " + pMatDom.getValue1().toString());
				else
					System.out.println("			* " + MatrixOperations.toString(pMatDom.getValue0()) +
				"			- " + pMatDom.getValue1().toString());
		}
		//*/
		
		// lParamHalf = [Nl,b]
		// At this point, _outputInfos is simplified... :)
		
		
		// *** Adding the outputs domains to _outputInfos
		for (VariableDeclaration varDecl : syst.getOutputs()) {
			String nameOutput = varDecl.getName();
			FastISLDomain domOutputInit = (FastISLDomain) varDecl.getDomain();
			
			// domOutputInit has [N_b, N_l, b] as parameters and [i_b,i_l] as indexes
			//		=> Need to translate it into local parameters [N_l,b] to insert it into _outputInfos
			//		=> Need also to remove the i_b
			int nParamScal = (domOutputInit.getNParams()-1)/2;
			int nIndScal = domOutputInit.getNIndices()/2;
			EList<Variable> lnInds = new BasicEList<Variable>();
			for (int i=0; i<nIndScal; i++)
				lnInds.add(_dimMana.getDimension(i, domOutputInit.getIndexNames().get(i+nIndScal)));
			
			JNIISLSet setOut = domOutputInit.getIslSet().copy();
			setOut = setOut.projectOut(JNIISLDimType.isl_dim_param, 0, nParamScal);
			setOut = setOut.projectOut(JNIISLDimType.isl_dim_set, 0, nIndScal);
			setOut = setOut.simplify();
			FastISLDomain domOutputParamTrans = _polyIRFact.createFastISLDomain(_polyFact.createDomainDimensions(lnInds, lParamHalf), setOut);
			
			// DEBUG
			//System.out.println("domOutputParamTrans = " + domOutputParamTrans.toString());
			
			// Commit, as a different output
			List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(nameOutput);
			
			if (lOutputInfos==null) {
				List<Pair<long[][],FastISLDomain>> nlPMatDom = new BasicEList<Pair<long[][],FastISLDomain>>();
				long[][] matId = new long[nIndScal][nParamScal+nIndScal+1];
				for (int i=0; i<nIndScal; i++)
					matId[i][nParamScal+i] = 1;
				nlPMatDom.add(Pair.with(matId, domOutputParamTrans));
				_outputInfos.put(nameOutput, nlPMatDom);
			} else {
				// We add the fact that this data is required by the output of the program
				//		by associating with a matrix which is not already used inside lOutputInfos
				//		(because this matrix will not be used at all later)
				//		and by placing it at the END of lOutputInfos (placement information will be used during step 3)
				
				// Getting the matrix: empty matrix, except the element (0,0) which is "max(other (0,0) coeff of matrices) + 1"
				long coeffMax = 0;
				for (Pair<long[][],FastISLDomain> pMatDom : lOutputInfos) {
					if (pMatDom.getValue0().length>0)
						coeffMax = Math.max(coeffMax, pMatDom.getValue0()[0][0]);
				}
				long[][] matUnused = new long[nIndScal][nParamScal+nIndScal+1];
				if (nIndScal>0)
					matUnused[0][0] = coeffMax+1;
				else {
					matUnused = new long[1][nParamScal+nIndScal+1];
					matUnused[0][0] = coeffMax+1;
				}
				lOutputInfos.add(Pair.with(matUnused, domOutputParamTrans));		// "matrix=Id" => asked by output of the program
			}
		}
		
		/* DEBUG
		System.out.println("_outputInfos = ");
		for (String strVar : _outputInfos.keySet()) {
			List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(strVar);
			
			System.out.println("	* " + strVar + " -> ");
			for (Pair<long[][],FastISLDomain> pMatDom : lOutputInfos)
				if (pMatDom.getValue0()==null)
					System.out.println("			- [[null]]\n			- " + pMatDom.getValue1().toString());
				else
					System.out.println("			- " + MatrixOperations.toString(pMatDom.getValue0()) +
				"			- " + pMatDom.getValue1().toString() + "\n			(" + pMatDom.getValue1().getIslSet().toString() + " )");
		}
		//*/
		
		
		if (!_optionOutputsRefined) {
			// We modify _outputInfos (which will automatically correct lllOutputOrder later)
			
			for (String varName : _outputInfos.keySet()) {
				List<Pair<long[][],FastISLDomain>> lOutputInfos = _outputInfos.get(varName);
				
				// If there is several outputs corresponding to one variable, we merge them
				if (lOutputInfos.size()>1) {
					// We compute the union of the different contributions and discard the informations about where it goes
					
					FastISLDomain outsetVar = lOutputInfos.get(0).getValue1();
					for (int i=1; i<lOutputInfos.size(); i++)
						outsetVar = (FastISLDomain) outsetVar.union(lOutputInfos.get(i).getValue1());
					outsetVar.simplify();
					
					int nIndScal = outsetVar.getNIndices()/2;
					int nParamScal = (outsetVar.getNParams()-1)/2;
					
					long[][] matId = new long[nIndScal][nParamScal+nIndScal+1];
					for (int i=0; i<nIndScal; i++)
						matId[i][nParamScal+i] = 1;
					
					List<Pair<long[][],FastISLDomain>> nlOutputInfos = new BasicEList<Pair<long[][],FastISLDomain>>();
					nlOutputInfos.add(Pair.with(matId,outsetVar));
					_outputInfos.put(varName, nlOutputInfos);
				}
			}
		}
		
		List<List<List<Pair<String,long[][]>>>> lllOutputOrder = new BasicEList<List<List<Pair<String,long[][]>>>>();
		
		// For all tile group...
		for (int numTileGroup=0; numTileGroup<llCuts.size(); numTileGroup++) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(numTileGroup);
			List<Map<String,VariableDeclaration>> lVarDeclSubsyst = llVarDeclSubsyst.get(numTileGroup);
			List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>> lSubsyst = llSubsyst.get(numTileGroup);
			List<Pair<ParameterDomain,Boolean>> lpParamDom = llpParamDom.get(numTileGroup);
			
			List<List<Pair<String,long[][]>>> llOutputOrder = new BasicEList<List<Pair<String,long[][]>>>();
			
			// For all cuts/kind of tiles...
			for (int numCut=0; numCut<lCuts.size(); numCut++) {
				Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut = lCuts.get(numCut);
				Map<String,VariableDeclaration> mVarDeclSubsyst = lVarDeclSubsyst.get(numCut);
				AffineSystem subSyst = lSubsyst.get(numCut).getValue0();
				Pair<ParameterDomain,Boolean> pParamDom = lpParamDom.get(numCut);
				
				List<Pair<String,long[][]>> lOutputOrder = new BasicEList<Pair<String,long[][]>>();
				
				// For each local variable which is not an output of the subsystem,
				//		create a new variable according to the _outputInfos
				for (Pair<String,List<Integer>> contrib : cut.getValue1()) {
					String varName = contrib.getValue0();
					VariableDeclaration varDeclLocal = mVarDeclSubsyst.get(varName);
					
					// First case: the variable is the output of the system => we need all of it
					// We retrieve the output info
					List<Pair<long[][],FastISLDomain>> lDomNeeded = _outputInfos.get(varName);
					if (lDomNeeded==null)	// The variable is not needed anywhere outside its tile => no change
						continue;
					
					for (Pair<long[][],FastISLDomain> pDomNeeded : lDomNeeded) {
						FastISLDomain domNeeded = pDomNeeded.getValue1();
						
						// Even if domNeeded is using half parameter and domLocalVar is using full parameter
						//			Invariant: the name of the parameter for half parameters are the same than full parameter
						//			=> Can just copy the constraints !!!
						FastISLDomain domNeededParamTrans;		// Set of point whose values are needed outside of the tile
						if (pParamDom.getValue1()) {
							domNeededParamTrans = _polyIRFact.createFastISLDomain(
									PolyhedralIRUtility.parseDomain(pParamDom.getValue0(), domNeeded.toString()).getPMdomain());
						} else {		// Already half parameters
							domNeededParamTrans = (FastISLDomain) domNeeded.copy();
						}
						// At this point, domNeededParamTrans shares the same parameter than subsyst
						
						
						// REMARK: domNeededParamTrans is common for every system, whatever the local domain (domLocalVar) is
						//		=> We can use this one for our output variable domain
						
						// Does the _outputinformation intersect with the current domain ??
						FastISLDomain domLocalVar = (FastISLDomain) varDeclLocal.getDomain();
						FastISLDomain domOutputVar = (FastISLDomain) domLocalVar.intersection(domNeededParamTrans);
						domOutputVar.simplify();
						
						/* DEBUG
						System.out.println("CurrentVar = " + varName);
						System.out.println("	=> domLocalVar =" + domLocalVar);
						System.out.println("	=> domNeededParamTrans =" + domNeededParamTrans);
						System.out.println("	=> domOutputVar =" + domOutputVar);
						System.out.println();
						//*/
						
						// We make such that the domain of the output of the system is always domNeededParamTrans
						//		(because homogenization)
						String varDeclOutName = varName + "_out";
						int count=0;
						while (subSyst.containsVariable(varDeclOutName + count))
							count++;
						varDeclOutName += count;
						VariableDeclaration varDeclOut = _polyIRFact.createVariableDeclaration(varDeclOutName, varDeclLocal.getType(), domNeededParamTrans);
						
						if (domOutputVar.isEmpty())	{		// This variable is not needed in this kind of tile
							// By doing nothing, there is no problem with the fusion (because of convexity of original polyhedron)
							continue;
						}
						
						if (_optionHomogenization) {
							// Getting the "0" constant expression
							Expression constExpr;
							if (varDeclLocal.getType().getTypeID()==DATATYPE.BOOL)
								constExpr = _polyIRFact.createBooleanExpression(false);
							else
								if (varDeclLocal.getType().getTypeID()==DATATYPE.INTEGER)
									constExpr = _polyIRFact.createIntegerExpression(0);
								else if (varDeclLocal.getType().getTypeID()==DATATYPE.FLOATING_POINT)
									constExpr = _polyIRFact.createRealExpression(0);
								else
									throw new RuntimeException("Unknown type : " + varDeclLocal.getType().toString());
							
							// All the defined local variable must become an output
							//			BUT it might not be defined on all the domain for every tile
							
							// Full domain = domNeededParamTrans
							// CopyEquation (from varDeclLocal to varDeclOut, with "0" on the rest)
							FastISLDomain domZeroExpr = (FastISLDomain) domNeededParamTrans.difference(domLocalVar);
							
							Expression exprCopyEquation;
							if (domZeroExpr.isEmpty()) {
								exprCopyEquation = _polyIRFact.createVariableExpression(varDeclLocal);
							} else {
								List<Expression> lCaseExpr = new BasicEList<Expression>();
								
								FastISLMap depConstrExpr = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(varDeclLocal.getDomain().getParams(),
										varDeclLocal.getDomain().getIndices(), new BasicEList<AffineExpression>()).getPMmapping());
								DependenceExpression depExpr = _polyIRFact.createDependenceExpression(depConstrExpr, constExpr);
								lCaseExpr.add(_polyIRFact.createRestrictExpression(domZeroExpr, depExpr));
								
								lCaseExpr.add(_polyIRFact.createRestrictExpression(domOutputVar, _polyIRFact.createVariableExpression(varDeclLocal)));
								exprCopyEquation = _polyIRFact.createCaseExpression(lCaseExpr);
							}
							StandardEquation copyEquation = _polyIRFact.createStandardEquation(varDeclOut, exprCopyEquation);
							
							// Commit
							subSyst.getOutputs().add(varDeclOut);
							subSyst.getEquations().add(copyEquation);
						} else {
							// --- No homogenization ---
							
							// We arrange the domain of varDeclOut to match the one of varDeclLocal
							varDeclOut = _polyIRFact.createVariableDeclaration(varDeclOutName, varDeclLocal.getType(),
									varDeclLocal.getDomain().copy());
							Expression exprCopyEquation = _polyIRFact.createVariableExpression(varDeclLocal);
							StandardEquation copyEquation = _polyIRFact.createStandardEquation(varDeclOut, exprCopyEquation);
							
							// Commit
							subSyst.getOutputs().add(varDeclOut);
							subSyst.getEquations().add(copyEquation);
						}
						
						
						lOutputOrder.add(Pair.with(contrib.getValue0(), pDomNeeded.getValue0()));
					}
					
				}
				llOutputOrder.add(lOutputOrder);
			}
			lllOutputOrder.add(llOutputOrder);
		}
		
		return lllOutputOrder;
	}
	
	/**
	 * Step 3: Building the main system
	 */
	private static void buildMainSystem(AffineSystem syst, List<List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>>> llSubSyst,
			List<List<Pair<ParameterDomain,Boolean>>> llpParamDomLoc,
			List<List<Map<String,VariableDeclaration>>> llVarDeclSubsyst,
			List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts, List<List<Pair<String, Boolean>>> lNAlignmentInfo,
			Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp, List<List<List<Pair<String,long[][]>>>> lllOutputOrder) {
		
		// *** Step 1: updating the variableDeclaration of syst
		
		// We keep all the current input/output variable declaration of the main system (to keep the signature of the system)
		// Plan of this step:
		//		(i) Getting the local variable declaration corresponding to the output of the useEquations
		//				==> llVarDeclMain
		//		(ii) Getting the local variable declaration corresponding to the case expressions (per kind of output)
		//				==> mStrVarDeclCase
		//				==> copyOuput : extra standard equations to make the outputs match
		
		// (i) Output of useEquation
		List<List<Map<String,List<Pair<long[][],VariableDeclaration>>>>> llVarDeclMain =			// Output of (i)
				new BasicEList<List<Map<String,List<Pair<long[][],VariableDeclaration>>>>>();
		int countVarNameOutUseEq = 0; 	// For the variable name
		for (int numTileGroup=0; numTileGroup<lllOutputOrder.size(); numTileGroup++) {
			List<List<Pair<String,long[][]>>> llOutputOrder = lllOutputOrder.get(numTileGroup);
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCut = llCuts.get(numTileGroup);
			List<Map<String,VariableDeclaration>> lVarDeclSubsyst = llVarDeclSubsyst.get(numTileGroup);
			List<Pair<ParameterDomain,Boolean>> lpParamDomLoc = llpParamDomLoc.get(numTileGroup);
			
			List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain =
					new BasicEList<Map<String,List<Pair<long[][],VariableDeclaration>>>>();
			
			for (int numCut=0; numCut<llOutputOrder.size(); numCut++) {
				List<Pair<String,long[][]>> lOutputOrder = llOutputOrder.get(numCut);
				Map<String,VariableDeclaration> mVarDeclSubsyst = lVarDeclSubsyst.get(numCut);
				Pair<ParameterDomain,Boolean> pParamDomLoc = lpParamDomLoc.get(numCut);
				
				FastISLDomain domCut = lCut.get(numCut).getValue0();
				int numOutlinedDim = lCut.get(numCut).getValue2();				// Number of dimension currently outlined in this subsystem
				Map<String, List<Pair<long[][],VariableDeclaration>>> mVarDeclMain =
						new HashMap<String, List<Pair<long[][],VariableDeclaration>>>();
				
				for (Pair<String,long[][]> pStrMat : lOutputOrder) {
					String str = pStrMat.getValue0();
					long[][] matOutputOrder = pStrMat.getValue1();
					
					
					FastISLDomain domOutputInfoStr = null;
					if (_optionHomogenization) {
						// We search the entry in _outputInfos corresponding to matOutputOrder
						List<Pair<long[][], FastISLDomain>> lpMatDomOutInfo = _outputInfos.get(str);
						for (Pair<long[][], FastISLDomain> pMatDomOutInfo : lpMatDomOutInfo)
							if (MatrixOperations.isEqual(pMatDomOutInfo.getValue0(),matOutputOrder)) {
								domOutputInfoStr = pMatDomOutInfo.getValue1();
								break;
							}
						if (domOutputInfoStr==null)
							throw new RuntimeException("DomOutputInfo: not find in _outputInfo");
					} else {
						// --- No homogenization ---
						// We get the value of domOutputInfoStr from the local variable domain
						// 			(cf llVarDeclSubsyst)
						Domain domVarDeclSS = mVarDeclSubsyst.get(str).getDomain().copy();
						if (domVarDeclSS instanceof FastISLDomain)
							domOutputInfoStr = (FastISLDomain) domVarDeclSS;
						else
							domOutputInfoStr = _polyIRFact.createFastISLDomain(domVarDeclSS.getPMdomain());
					}
					
					// We get the local domain of the needed variableDeclaration
					//		=> Works on "half-parameter" parameter domain
					JNIISLSet setOutputInfoStr = domOutputInfoStr.getIslSet().copy();
					
					if (_optionHomogenization) {
						int nParamLoc = (syst.getParameters().getNParams()-1)/2;
						setOutputInfoStr = setOutputInfoStr.insertDims(JNIISLDimType.isl_dim_param, 0, nParamLoc);
						for (int i=0; i<syst.getParameters().getNParams(); i++)
							setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_param, i,
									syst.getParameters().getParams().get(i).getName());
						
						setOutputInfoStr = setOutputInfoStr.insertDims(JNIISLDimType.isl_dim_set, 0, numOutlinedDim);
						for (int i=0; i<numOutlinedDim; i++)
							setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_set, i, domCut.getIndices().get(i).getName());
					} else {
						int nParamLoc = (syst.getParameters().getNParams()-1)/2;
						if (setOutputInfoStr.getNbDims(JNIISLDimType.isl_dim_param)>nParamLoc+1) {
							// setOutputInfoStr is full dimensional (with extra indexes)
							setOutputInfoStr = setOutputInfoStr.moveDims(JNIISLDimType.isl_dim_set, 0, JNIISLDimType.isl_dim_param,
									syst.getParameters().getNParams(), numOutlinedDim);
							for (int i=0; i<syst.getParameters().getNParams(); i++)
								setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_param, i,
										syst.getParameters().getParams().get(i).getName());
							for (int i=0; i<numOutlinedDim; i++)
								setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_set, i, domCut.getIndices().get(i).getName());
						} else {	// setOutputInfoStr have half of the parameters
							
							setOutputInfoStr = setOutputInfoStr.insertDims(JNIISLDimType.isl_dim_param, 0, nParamLoc);
							for (int i=0; i<syst.getParameters().getNParams(); i++)
								setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_param, i,
										syst.getParameters().getParams().get(i).getName());
							
							setOutputInfoStr = setOutputInfoStr.insertDims(JNIISLDimType.isl_dim_set, 0, numOutlinedDim);
							for (int i=0; i<numOutlinedDim; i++)
								setOutputInfoStr = setOutputInfoStr.setDimName(JNIISLDimType.isl_dim_set, i, domCut.getIndices().get(i).getName());
						}
						
						
					}
					
					DomainDimensions domDimOutInfoStrNParam = _polyFact.createDomainDimensions(domCut.getIndices(), syst.getParameters().getParams());
					FastISLDomain domOutputInfoStrNParam = _polyIRFact.createFastISLDomain(domDimOutInfoStrNParam, setOutputInfoStr);
					
					
					
					/*FastISLDomain domOutputInfoStrCopy = (FastISLDomain) domOutputInfoStr.copy();
					for (int i=0; i<numOutlinedDim; i++)
						domOutputInfoStrCopy.addDimension(domCut.getIndexNames().get(i));
					
					List<AffineExpression> lAffExpr = new BasicEList<AffineExpression>();
					for (int i=0; i<numOutlinedDim; i++)
						lAffExpr.add(IntExpressionBuilder.affine(domOutputInfoStrCopy.getIndices().get(i+domOutputInfoStr.getNIndices())));
					for (int i=0; i<domOutputInfoStr.getNIndices(); i++)
						lAffExpr.add(IntExpressionBuilder.affine(domOutputInfoStrCopy.getIndices().get(i)));
					
					FastISLMap projFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(domOutputInfoStr.getParams(),
							domOutputInfoStrCopy.getIndices(), lAffExpr).getPMmapping());
					FastISLDomain domOutputInfoStrExtended = (FastISLDomain) domOutputInfoStrCopy.image(projFunc);
					
					// Conversion to full parameters
					FastISLDomain domOutputInfoStrNParam = _polyIRFact.createFastISLDomain(
							PolyhedralIRUtility.parseDomain(syst.getParameters(), domOutputInfoStrExtended.toString()).getPMdomain());
					*/
					
					FastISLDomain nVarDeclLocalDom = (FastISLDomain) domCut.intersection(domOutputInfoStrNParam);
					
					String varDeclName = str + "_" + numCut + "_" + countVarNameOutUseEq;
					countVarNameOutUseEq++;
					VariableDeclaration nVarDeclLocal = _polyIRFact.createVariableDeclaration(varDeclName,
							syst.getVariableDeclaration(str).getType(), nVarDeclLocalDom);
					
					// Commit
					if (mVarDeclMain.containsKey(str))
						mVarDeclMain.get(str).add(Pair.with(matOutputOrder, nVarDeclLocal));
					else {
						List<Pair<long[][],VariableDeclaration>> nlMatVarDecl = new BasicEList<Pair<long[][],VariableDeclaration>>();
						nlMatVarDecl.add(Pair.with(matOutputOrder, nVarDeclLocal));
						mVarDeclMain.put(str, nlMatVarDecl);
					}
				}
				lVarDeclMain.add(mVarDeclMain);
			}
			llVarDeclMain.add(lVarDeclMain);
		}
		
		
		// (ii) VarDecl of caseExpression
		//	=> IF HOMOGENIZATION: Because of the homogenization done on the domain of the outputs (cf step 2C), can be simplified to
		//			(something) \times _outputInfos.get(VariableName)
		Map<String,List<Pair<long[][],VariableDeclaration>>> mStrVarDeclCase = new HashMap<String,List<Pair<long[][],VariableDeclaration>>>();
		Map<VariableDeclaration,VariableDeclaration> copyOutput = new HashMap<VariableDeclaration, VariableDeclaration>();
		for (String strCase : _outputInfos.keySet()) {
			
			// If strCase is an input => Do nothing
			if (syst.isInput(syst.getVariableDeclaration(strCase)))
				continue;
			
			
			// Find the variable declaration
			VariableDeclaration varDeclStrCase = syst.getVariableDeclaration(strCase);
			
			int numBlockedInd;
			if (mProjFuncRedTemp.containsKey(strCase)) {
				FastISLMap projFunc = mProjFuncRedTemp.get(strCase).getValue0();
				numBlockedInd = projFunc.getNIndices() - projFunc.getDimRHS()/2;
			} else
				numBlockedInd = varDeclStrCase.getDomain().getNIndices()/2;
			
			// Getting the domain of the local VariableDeclaration
			//		=> because of the homogenization, we can use _outputInfos for the constraints of the local indexes
			//		=> blocked constraints: extract the constraints from the current domain
			List<Pair<long[][],FastISLDomain>> localConstraints = _outputInfos.get(strCase);
			
			// For each outputs corresponding to the variable strCase...
			for (Pair<long[][],FastISLDomain> pMatDom : localConstraints) {
				
				// We create the new variable declaration corresponding to the caseExpression here
				
				// (i) Computing the domain of the new variable declaration...
				FastISLDomain nDomVarDeclCase;
				if (_optionHomogenization) {
					
					// We gather the union of all the contributions to the corresponding outputs...
					FastISLDomain oldDomVarDeclCase = null;
					for (int numTileGroup=0; numTileGroup<lllOutputOrder.size(); numTileGroup++) {
						List<List<Pair<String,long[][]>>> llOutputOrder = lllOutputOrder.get(numTileGroup);
						List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(numTileGroup);
						
						for (int numCut=0; numCut<llOutputOrder.size(); numCut++) {
							List<Pair<String,long[][]>> lOutputOrder = llOutputOrder.get(numCut);
							FastISLDomain domCut = lCuts.get(numCut).getValue0();
							
							// Should we add domCut?
							for (Pair<String,long[][]> pMatStr : lOutputOrder) {
								if (pMatStr.getValue0().equals(strCase)) {
									if (MatrixOperations.isEqual(pMatStr.getValue1(),pMatDom.getValue0())) {
										
										// We add this contribution :)
										if (oldDomVarDeclCase==null)
											oldDomVarDeclCase = (FastISLDomain) domCut.copy();
										else
											oldDomVarDeclCase = (FastISLDomain) oldDomVarDeclCase.union(domCut);
									}
								}
							}
							
							
						}
					}
					
					if (oldDomVarDeclCase==null)
						throw new RuntimeException("Variable " + strCase + " should not figure inside _outputInfos");
					
					// ... Then, we project this domain on its blocked dimensions, then simplify it
					JNIISLSet setNDomVarDeclCaseBl = oldDomVarDeclCase.getIslSet().copy();
					setNDomVarDeclCaseBl = setNDomVarDeclCaseBl.projectOut(JNIISLDimType.isl_dim_set, numBlockedInd,	
							oldDomVarDeclCase.getNIndices()-numBlockedInd);
					int nParamBl = (oldDomVarDeclCase.getNParams()-1)/2;
					setNDomVarDeclCaseBl = setNDomVarDeclCaseBl.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_param, nParamBl, nParamBl+1);
					
					List<Variable> lDimDomVarDeclCaseBl = oldDomVarDeclCase.getIndices().subList(0, numBlockedInd);
					DomainDimensions domDimsDomVarDeclCaseBl = _polyFact.createDomainDimensions(lDimDomVarDeclCaseBl, oldDomVarDeclCase.getParams());
					FastISLDomain nDomVarDeclCaseBlNoLoc = _polyIRFact.createFastISLDomain(domDimsDomVarDeclCaseBl, setNDomVarDeclCaseBl);
	
					nDomVarDeclCaseBlNoLoc.simplify();
					// Contains the blocked constraints of the caseVariable domain. This works because of the homogenization.
					
					
					// We do the cross product between nDomVarDeclCaseBl and localConstraints
					FastISLDomain localConstraintsNParam = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.parseDomain(syst.getParameters(),
							pMatDom.getValue1().toString()).getPMdomain());
					// Contains the local constraints on the caseVariable domain
					
					// DEBUG
					//System.out.println("nDomVarDeclCaseBlNoLoc = " + nDomVarDeclCaseBlNoLoc.toString());
					//System.out.println("localConstraintsNParam = " + localConstraintsNParam.toString());
					
					// Getting the domain of the caseVariable (at last)
					nDomVarDeclCase = crossProduct(nDomVarDeclCaseBlNoLoc, localConstraintsNParam);
					nDomVarDeclCase.simplify();
					
					// DEBUG
					//System.out.println("nDomVarDeclCase = " + nDomVarDeclCase.toString());
				} else {
					// --- No homogenization ---
					//		=> nDomVarDeclCase is simply the union of all the contributions (coming from llVarDeclMain)
					FastISLDomain domVarDeclAccumul = null;
					
					// For all tile groups...
					for (List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain : llVarDeclMain) {
						// For all cuts...
						for (Map<String,List<Pair<long[][],VariableDeclaration>>> mVarDeclMain : lVarDeclMain) {
							if (mVarDeclMain.containsKey(strCase)) {
								FastISLDomain newContrib = (FastISLDomain) mVarDeclMain.get(strCase).get(0).getValue1().getDomain().copy();
								if (domVarDeclAccumul==null)
									domVarDeclAccumul = newContrib;
								else
									domVarDeclAccumul = (FastISLDomain) domVarDeclAccumul.union(newContrib);	
							}
						}
					}
					
					nDomVarDeclCase = domVarDeclAccumul;
				}
				
				// (ii) Creating the variableDeclaration itself
				String varDeclCaseName = strCase + "_loc_" + localConstraints.indexOf(pMatDom);
				VariableDeclaration varDeclCaseLoc = _polyIRFact.createVariableDeclaration(varDeclCaseName, varDeclStrCase.getType(), nDomVarDeclCase);
				
				// If output, do not change the signature of the system because of the homogenization, we need a final copy
				// DIRTY TRICK: the local variable declaration corresponding to a use of the output is the last one (by construction,
				//		because it was added afterward in step 2C) => use that...
				if (syst.getOutputs().contains(varDeclStrCase)) {
					copyOutput.put(varDeclStrCase, varDeclCaseLoc);
					// Create a copy equation
					/*if (copyOutput.containsKey(varDeclStrCase)) {
						List<VariableDeclaration> lVarDecl = copyOutput.get(varDeclStrCase);
						lVarDecl.add(varDeclCaseLoc);
					} else {
						List<VariableDeclaration> lVarDecl = new BasicEList<VariableDeclaration>();
						lVarDecl.add(varDeclCaseLoc);
						copyOutput.put(varDeclStrCase, lVarDecl);
					}
					*/
				}
				
				
				// Commit
				if (mStrVarDeclCase.containsKey(strCase))
					mStrVarDeclCase.get(strCase).add(Pair.with(pMatDom.getValue0(),varDeclCaseLoc));
				else {
					List<Pair<long[][],VariableDeclaration>> nlMatVarDecl = new BasicEList<Pair<long[][],VariableDeclaration>>();
					nlMatVarDecl.add(Pair.with(pMatDom.getValue0(),varDeclCaseLoc));
					mStrVarDeclCase.put(strCase, nlMatVarDecl);
				}
				
			}
		}
		
		
		
		
		// Completing with outputs which might not be inside _outputInformation (because not accessed)
		//		=> Never happen by definition of _outputInfo ? oO
		//for (VariableDeclaration varDeclOut : syst.getOutputs()) {
		//	if (!mStrVarDeclCase.containsKey(varDeclOut.getName()))
		//		mStrVarDeclCase.put(varDeclOut.getName(), varDeclOut);
		//}
		
		// (iii) Commit all local declarations inside the main system
		syst.getLocals().clear();
		for (List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain : llVarDeclMain)
			for (Map<String,List<Pair<long[][],VariableDeclaration>>> mVarDeclMain : lVarDeclMain)
				for (List<Pair<long[][],VariableDeclaration>> lMatVarDecl : mVarDeclMain.values())
					for (Pair<long[][],VariableDeclaration> pMatVarDecl : lMatVarDecl)
						syst.getLocals().add(pMatVarDecl.getValue1());
		for (List<Pair<long[][],VariableDeclaration>> lpMatVarDecl : mStrVarDeclCase.values())
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl)
				syst.getLocals().add(pMatVarDecl.getValue1());
		
		
		// AT THIS POINT:
		// In syst:
		//		- all variable declarations are ready (only the equations are remaining)
		// In term of information passing through:
		//		- llVarDeclMain contains the outputs declaration of the use equations
		//		- mStrVarDeclCase contains the outputs declaration of the copy equations
		//		- copyOutput contains extra standard equations
		
		/* DEBUG
		System.out.println("* llVarDeclMain = ");
		for (List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain : llVarDeclMain)
			for (Map<String,List<Pair<long[][],VariableDeclaration>>> mVarDeclMain : lVarDeclMain) {
				for (String strVar : mVarDeclMain.keySet()) {
					System.out.println("	* strVar = " + strVar);
					List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mVarDeclMain.get(strVar);
					
					for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl) {
						System.out.print("		-> " + MatrixOperations.toString(pMatVarDecl.getValue0()));
						System.out.println("		-> " + pMatVarDecl.getValue1().toString());
					}
				}
				System.out.println("--------------------------------------------------------");
			}
		System.out.println();
		System.out.println("* mStrVarDeclCase = ");
		for (String str : mStrVarDeclCase.keySet()) {
			System.out.println("	* strVar = " + str);
			List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mStrVarDeclCase.get(str);
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl) {
				System.out.print("		-> " + MatrixOperations.toString(pMatVarDecl.getValue0()));
				System.out.println("		-> " + pMatVarDecl.getValue1().toString());
			}
		}
		//*/
		
		if (_optionSaveInformations)
			_dataStructSaved = _dataStructSaved.setAt1(mStrVarDeclCase);
		
		
		// *** Step 2: building the useEquations
		List<UseEquation> lUseEquation = new BasicEList<UseEquation>();
		for (int numTileGroup=0; numTileGroup<llCuts.size(); numTileGroup++) {
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCut = llCuts.get(numTileGroup);
			List<Pair<ParameterDomain,Boolean>> lpParamDomLoc = llpParamDomLoc.get(numTileGroup);
			List<Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>>> lSubSyst = llSubSyst.get(numTileGroup);
			List<List<Pair<String,long[][]>>> llOutputOrder = lllOutputOrder.get(numTileGroup);
			List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain = llVarDeclMain.get(numTileGroup);
			
			for (int numCut=0; numCut<lCut.size(); numCut++) {
				Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> tCut = lCut.get(numCut);
				Pair<ParameterDomain,Boolean> pparamDom = lpParamDomLoc.get(numCut);
				List<Pair<String,long[][]>> lOutputOrder = llOutputOrder.get(numCut);							// Order of the outputs of the subsystem
				Map<String,List<Pair<long[][],VariableDeclaration>>> mVarDeclOutput = lVarDeclMain.get(numCut);	// VarDecl for output of useEquation
				
				Pair<AffineSystem,List<Triplet<String,long[][],VariableDeclaration>>> pSubSyst = lSubSyst.get(numCut);
				AffineSystem subSyst = pSubSyst.getValue0();
				List<Triplet<String,long[][],VariableDeclaration>> inputInfo = pSubSyst.getValue1();
				
				// (i) Extension domain
				FastISLDomain extDomWithLocal = tCut.getValue0();
				
				// projFuncExtDom : project on the tCut.getValue2() first dimensions
				List<AffineExpression> lAffExprProjFuncExtDom = new BasicEList<AffineExpression>();
				for (int i=0; i<tCut.getValue2(); i++)
					lAffExprProjFuncExtDom.add(IntExpressionBuilder.affine(extDomWithLocal.getIndices().get(i)));
				FastISLMap projFuncExtDom = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(extDomWithLocal.getParams(),
						extDomWithLocal.getIndices(), lAffExprProjFuncExtDom).getPMmapping());		// TODO: optimizable
				FastISLDomain extDom = (FastISLDomain) extDomWithLocal.image(projFuncExtDom);
				
				
				// (ii) Parameters
				List<AffineExpression> lExprParamMapping = new BasicEList<AffineExpression>();
				if (pparamDom.getValue1()) {	// Full parameters
					// Mapping: same than the current parameter domain + indexes of the extension domain
					for (int i=0; i<extDom.getNParams(); i++)
						lExprParamMapping.add(IntExpressionBuilder.affine(extDom.getParams().get(i)));
					for (int i=0; i<extDom.getNIndices(); i++)
						lExprParamMapping.add(IntExpressionBuilder.affine(extDom.getIndices().get(i)));
				} else {						// Only local parameters + b
					int nParamScal = (tCut.getValue0().getNParams()-1)/2;
					for (int i=0; i<nParamScal+1; i++)
						lExprParamMapping.add(IntExpressionBuilder.affine(extDom.getParams().get(i+nParamScal)));
				}
				FastISLMap paramMapping = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(syst.getParameters().getParams(),
						extDom.getIndices(), lExprParamMapping).getPMmapping());
				
				// (iii) Inputs
				List<Expression> lInputExpr = new BasicEList<Expression>();
				for (Triplet<String,long[][],VariableDeclaration> tinput : inputInfo) {
					String nameVarMain = tinput.getValue0();
					long[][] blockAccessed = tinput.getValue1();
					
					
					VariableDeclaration varDeclMain;
					if (syst.isInput(syst.getVariableDeclaration(nameVarMain)))
						varDeclMain = syst.getVariableDeclaration(nameVarMain);
					else {
						List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mStrVarDeclCase.get(nameVarMain);
						
						// We search for the pair whose matrix correspond to blockAccessed
						VariableDeclaration varDeclSearch = null;
						if (!_optionOutputsRefined) {			// We ignore the classification per dependences (ie, the pMatVarDecl.getValue0() )
							if (lpMatVarDecl.size()!=1)
								throw new RuntimeException("We should have only one caseVariable per variable name");
							varDeclSearch = lpMatVarDecl.get(0).getValue1();
						} else {
							for (int k=0; k<lpMatVarDecl.size(); k++) {
								Pair<long[][],VariableDeclaration> pMatVarDecl = lpMatVarDecl.get(k);
								if (MatrixOperations.isEqual(blockAccessed, pMatVarDecl.getValue0())) {
									varDeclSearch = pMatVarDecl.getValue1();
									break;
								}
							}
							
							if (varDeclSearch==null)
								throw new RuntimeException("No variable declaration found for this value of blockAccessed");
						}
						
						
						varDeclMain = varDeclSearch;
					}
					
					// blockAccessed: contain the blocked parameter + blocked indexes contributions
					//			=> Need to add the local parameters
					//		=> In the main system: do not need to adapt according to the parameter domain of the subsystem
					
					// lIndsDepInput: start with indexes of the extension domain
					//		rest of the indexes = domain of the varDecl of the subsystem
					EList<Variable> lIndsDepInput = new BasicEList<Variable>();
					lIndsDepInput.addAll(extDom.getIndices());
					int nDimOutlined = extDom.getNIndices();
					
					FastISLDomain domLocalSubSystem = (FastISLDomain) tinput.getValue2().getDomain();
					int nLocalIndexes = domLocalSubSystem.getNIndices();
					for (int k=0; k<nLocalIndexes; k++)
						lIndsDepInput.add(_dimMana.getDimension(nDimOutlined+k, domLocalSubSystem.getIndexNames().get(k)));
					
					// matLongDepInput =
					//	[ Nb  Nl  b  | \alpha (\gamma) ii | const]
					//
					//  [  *1  0   0 |   *2         0     |   *3 ]
					//  [  0  0   0  |   0         Id     |   0  ]
					//
					// where blockAccessed is:
					//  [ Nb \alpha const]
					//
					//  [ *1   *2    *3  ]
					long[][] matLongDepInput =
							new long[varDeclMain.getDomain().getNIndices()][syst.getParameters().getNParams()+lIndsDepInput.size()+1];
					int nParamScal = (syst.getParameters().getNParams()-1)/2;
					for (int i=0; i<blockAccessed.length; i++) {
						
						// Blocked parameters
						for (int j=0; j<nParamScal; j++)
							matLongDepInput[i][j] = blockAccessed[i][j];
						
						// Outlined indexes
						for (int j=0; j<nDimOutlined; j++)
							matLongDepInput[i][syst.getParameters().getNParams()+j] = blockAccessed[i][nParamScal+j];
						
						// Constants
						matLongDepInput[i][matLongDepInput[0].length-1] = blockAccessed[i][blockAccessed[0].length-1];
					}
					for (int i=0; i<nLocalIndexes; i++)
						matLongDepInput[blockAccessed.length+i][syst.getParameters().getNParams()+nDimOutlined+i] = 1;
					
					Matrix matDepInput = _polyFact.createMatrix(matLongDepInput);
					
					List<IntExpression> lIntExprDepInput = matDepInput.toFunction(syst.getParameters().getParams(), lIndsDepInput);
					List<AffineExpression> lAffExprDepInput = new BasicEList<AffineExpression>();
					for (IntExpression intExpr : lIntExprDepInput)
						lAffExprDepInput.add((AffineExpression) intExpr);
					
					FastISLMap depInput = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(syst.getParameters().getParams(),
							lIndsDepInput, lAffExprDepInput).getPMmapping());
					
					DependenceExpression inputExpr = _polyIRFact.createDependenceExpression(depInput,
							_polyIRFact.createVariableExpression(varDeclMain));
					
					lInputExpr.add(inputExpr);
				}
				
				// (iv) Outputs
				List<VariableDeclaration> lOutputUseEq = new BasicEList<VariableDeclaration>();
				for (int k=0; k<lOutputOrder.size(); k++) {
					Pair<String,long[][]> outVarStr = lOutputOrder.get(k);
					long[][] matToBeMatched = outVarStr.getValue1();
					
					List<Pair<long[][],VariableDeclaration>> lpVarDeclOutput = mVarDeclOutput.get(outVarStr.getValue0());
					
					// We have to find the output corresponding to matToBeMatched inside lpVarDeclOutput
					VariableDeclaration varDeclOut = null;
					for (Pair<long[][],VariableDeclaration> pVarDeclOutput : lpVarDeclOutput)
						if (MatrixOperations.isEqual(matToBeMatched, pVarDeclOutput.getValue0())) {
							varDeclOut = pVarDeclOutput.getValue1();
							break;
						}
					if (varDeclOut==null)
						throw new RuntimeException("Output variabledeclaration not found inside lpVarDeclOutput...");
					
					lOutputUseEq.add(varDeclOut);
				}
				
				UseEquation uEq = _polyIRFact.createUseEquation(extDom, subSyst, paramMapping,
						lInputExpr, lOutputUseEq);
				lUseEquation.add(uEq);
			}
		}
		
		// AT THIS POINT:
		//	- lUseEquation contain the list of useEquation to be added to the main system
		
		
		
		// *** Step 3: building the case Equations
		
		// Store all the branches of the case expressions
		Map<String,List<Pair<long[][],List<Expression>>>> mInternalCaseExpr = new HashMap<String,List<Pair<long[][],List<Expression>>>>();
		
		// Track down the contributions
		for (int numTileGroup=0; numTileGroup<lllOutputOrder.size(); numTileGroup++) {
			List<List<Pair<String,long[][]>>> llOutputOrder = lllOutputOrder.get(numTileGroup);
			List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts = llCuts.get(numTileGroup);
			List<Map<String,List<Pair<long[][],VariableDeclaration>>>> lVarDeclMain = llVarDeclMain.get(numTileGroup);
			
			for (int numCut=0; numCut<llOutputOrder.size(); numCut++) {
				List<Pair<String,long[][]>> lOutputOrder = llOutputOrder.get(numCut);
				Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> tCuts = lCuts.get(numCut);
				Map<String,List<Pair<long[][],VariableDeclaration>>> mVarDeclMain = lVarDeclMain.get(numCut);
				
				for (Pair<String,long[][]> pStrOutMat : lOutputOrder) {
					String strOut = pStrOutMat.getValue0();
					long[][] matOut = pStrOutMat.getValue1();
					
					// For each output of subsystem, add the output to the corresponding caseExpression
					List<Pair<long[][],VariableDeclaration>> lpMatVarDecl = mVarDeclMain.get(strOut);
					
					VariableDeclaration varDeclRestrExpr = null;
					for (Pair<long[][],VariableDeclaration> pMatVarDecl : lpMatVarDecl)
						if (MatrixOperations.isEqual(matOut, pMatVarDecl.getValue0())) {
							varDeclRestrExpr = pMatVarDecl.getValue1();
							break;
						}
					if (varDeclRestrExpr==null)
						throw new RuntimeException("mVarDeclMain : the corresponding output variable was not found");
					
					Expression restExpr = _polyIRFact.createRestrictExpression(tCuts.getValue0().copy(),
							_polyIRFact.createVariableExpression(varDeclRestrExpr));
					
					// Update mInternalCaseExpr
					if (!mInternalCaseExpr.containsKey(strOut)) {	// New entry for this variable
						List<Expression> nLExpr = new BasicEList<Expression>();
						nLExpr.add(restExpr);
						
						List<Pair<long[][],List<Expression>>> nlpMatLExpr = new BasicEList<Pair<long[][],List<Expression>>>();
						nlpMatLExpr.add(Pair.with(matOut,nLExpr));
						
						mInternalCaseExpr.put(strOut, nlpMatLExpr);
					} else {
						List<Pair<long[][],List<Expression>>> lPMatLRestrExpr = mInternalCaseExpr.get(strOut);
						
						// We search lPMatLRestrExpr to find the pair corresponding to matOut
						List<Expression> lExprSearched = null;
						for (Pair<long[][],List<Expression>> pMatLExpr : lPMatLRestrExpr)
							if (MatrixOperations.isEqual(matOut, pMatLExpr.getValue0())) {
								lExprSearched = pMatLExpr.getValue1();
								break;
							}
						
						if (lExprSearched==null) {		// New entry for this matrix
							List<Expression> nlExpr = new BasicEList<Expression>();
							nlExpr.add(restExpr);
							lPMatLRestrExpr.add(Pair.with(matOut,nlExpr));
						} else
							lExprSearched.add(restExpr);
					}
				}
			}
		}
		
		// Building the equation with the case expression
		List<StandardEquation> lCaseEquation = new BasicEList<StandardEquation>();
		for (String strVar : mInternalCaseExpr.keySet()) {
			List<Pair<long[][],VariableDeclaration>> lMatVarDecl = mStrVarDeclCase.get(strVar);
			for (Pair<long[][],VariableDeclaration> pMatVarDecl : lMatVarDecl) {
				
				List<Pair<long[][],List<Expression>>> lpMatLExpr = mInternalCaseExpr.get(strVar);
				
				// Search in lpMatLExpr corresponding to pMatVarDecl.getValue0
				List<Expression> lExpr = null;
				for (Pair<long[][],List<Expression>> pMatLExpr : lpMatLExpr)
					if (MatrixOperations.isEqual(pMatLExpr.getValue0(),pMatVarDecl.getValue0())) {
						lExpr = pMatLExpr.getValue1();
						break;
					}
				if (lExpr==null)
					throw new RuntimeException("mVarDeclMain : the corresponding output variable was not found");
					
				
				lCaseEquation.add(_polyIRFact.createStandardEquation(pMatVarDecl.getValue1(),
						_polyIRFact.createCaseExpression(lExpr)));
			}
		}
		
		if (_optionSaveInformations)
			_dataStructSaved = _dataStructSaved.setAt2(mInternalCaseExpr);
		
		// *** Final commit of all the equations inside the main system
		syst.getEquations().clear();
		syst.getEquations().addAll(lCaseEquation);
		for (VariableDeclaration varDeclEquation : copyOutput.keySet()) {
			StandardEquation stEqCopy = _polyIRFact.createStandardEquation(varDeclEquation,
					_polyIRFact.createVariableExpression(copyOutput.get(varDeclEquation)));
			syst.getEquations().add(stEqCopy);
		}
		
		/*for (VariableDeclaration varDeclEquation : copyOutput.keySet()) {
			List<VariableDeclaration> lVarDecl = copyOutput.get(varDeclEquation);
			Expression exprEq;
			if (lVarDecl.size()==1) {
				exprEq = _polyIRFact.createVariableExpression(lVarDecl.get(0));
			} else {
				List<VariableExpression> lVarEq = new BasicEList<VariableExpression>();
				for (VariableDeclaration varDecl : lVarDecl)
					lVarEq.add(_polyIRFact.createVariableExpression(varDecl));
				exprEq = _polyIRFact.createCaseExpression(lVarEq);
			}
			
			StandardEquation stEqCopy = _polyIRFact.createStandardEquation(varDeclEquation, exprEq);
			syst.getEquations().add(stEqCopy);
		}
		*/
		
		syst.getUseEquations().addAll(lUseEquation);
	}
	
	
	/**
	 * Computes dom1 * dom2, dom1 and dom2 having the same parameter domain
	 * 
	 * @param dom1
	 * @param dom2
	 * @return
	 */
	public static FastISLDomain crossProduct(FastISLDomain dom1, FastISLDomain dom2) {
		FastISLDomain dom1Copy = (FastISLDomain) dom1.copy();
		for (int i=0; i<dom2.getNIndices(); i++)
			dom1Copy.addDimension(dom2.getIndexNames().get(i));
		
		// Dom2: extend by dim(dom1) first, then switch the indexes of dom1 and dom2
		FastISLDomain dom2CopyTemp = (FastISLDomain) dom2.copy();
		for (int i=0; i<dom1.getNIndices(); i++)
			dom2CopyTemp.addDimension(dom1.getIndexNames().get(i));
		
		List<Variable> projFuncInd = new BasicEList<Variable>();
		projFuncInd.addAll(dom2.getIndices());
		for (int i=0; i<dom1.getNIndices(); i++)
			projFuncInd.add(_dimMana.getDimension(i+dom2.getNIndices(), dom1.getIndexNames().get(i)));
		
		List<AffineExpression> lExprProjFunc = new BasicEList<AffineExpression>();
		for (int i=0; i<dom1.getNIndices(); i++)
			lExprProjFunc.add(IntExpressionBuilder.affine(projFuncInd.get(i+dom2.getNIndices())));
		for (int i=0; i<dom2.getNIndices(); i++)
			lExprProjFunc.add(IntExpressionBuilder.affine(projFuncInd.get(i)));
		FastISLMap projFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(dom2.getParams(), projFuncInd, lExprProjFunc).getPMmapping());
		FastISLDomain dom2Ext = (FastISLDomain) dom2CopyTemp.image(projFunc);
		
		return (FastISLDomain) dom1Copy.intersection(dom2Ext);
	}
	
	// *** Expression visitor part ***
	// - Get the list of inputs of a tile
	// - Start gathering informations about outputs
	// - Remove the block dimensions from everywhere
	private static class OutliningParametricTilingVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		
		private static final boolean _noisyVisitor = false;		// DEBUG
		
		private List<String> _currentVariablesOutlined;
		private Map<String,VariableDeclaration> _currentTileLocalVariable;		// Map between the old name (after CART) and the corresponding
																				//			local variable (build for the subsystem)
		
		private int _nBlockDim;								// Number of blocked dim to be outlined (common the tile group)
		public boolean _areAllCurrentBlockedIndOutlined;
		public String _nameCurrentVar;
		public FastISLDomain _currentBlockedDom;					// Domain of the current cut
		
		private boolean _isThereIndexExpression;			// To know which kind of parameter domain we have (true => full / false => half)
		private ParameterDomain _paramDom;					// ParameterDomain of the current cut
		
		private List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> _llCuts;
		private List<List<Pair<String, Boolean>>> _nAlignmentInfo;
		private Map<String,Pair<FastISLMap,String>> _mProjFuncRedTemp;
		private List<VariableDeclaration> _systVarDecl;
		private List<String> _systInputName;
		
		// -- Local informations
		private int _inputVarCounter;
		private List<Triplet<String,long[][],VariableDeclaration>> _inputInformations;	// 2 first entry is to identify the CARTed var + the block accessed (param+lin+const part)
																						// last entry is the corresponding input VariableDeclaration in the subsystem
		
		private Expression _subExprDimRed;	// expression for the subsystem
											// Cannot modify the AST itself, not to loose the context domain & might be used for other tiles
		
		// Constructor
		public OutliningParametricTilingVisitor(List<String> currentVarOutlined, Map<String,VariableDeclaration> mNewLocalVar,
				boolean isThereIndexExpression, ParameterDomain paramDom, int nBlockDim,
				List<List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>>> llCuts,
				List<List<Pair<String, Boolean>>> nlAlignmentInfo,
				Map<String,Pair<FastISLMap,String>> mProjFuncRedTemp, List<VariableDeclaration> systVarDecl,
				List<String> systInputName) {
			this._currentVariablesOutlined = currentVarOutlined;
			this._currentTileLocalVariable = mNewLocalVar;
			
			this._nBlockDim = nBlockDim;
			// areAllCurrentBlockedIndOutlied + currentBlockDom to be updated everytime
			
			this._isThereIndexExpression = isThereIndexExpression;
			this._paramDom = paramDom;
			
			this._llCuts = llCuts;
			this._nAlignmentInfo = nlAlignmentInfo;
			this._mProjFuncRedTemp = mProjFuncRedTemp;
			this._systVarDecl = systVarDecl;
			this._systInputName = systInputName;
			
			this._inputInformations = new BasicEList<Triplet<String,long[][],VariableDeclaration>>();
			this._inputVarCounter = 0;
		}
		
		// Getters
		public List<Triplet<String,long[][],VariableDeclaration>> getInputInformations() {
			return _inputInformations;
		}
		
		// Visitor (change the number of dim/params)
		@Override
		public void visitDependenceExpression(DependenceExpression depExpr) {
			// ASSUMPTION: After "LowerDependence", we must have either a constant, a variable or an index expression inside depExpr
			
			if (_noisyVisitor)
				System.out.println("\n* Enterring Dependence Expression: " + PolyhedralIRToAlphabets.toString(depExpr));
			
			
			DependenceExpression returnedDepExpr = null;	// Returned DependenceExpression
			
			// ====================================================================
			// ======== First (easy) cases: constants and index expression ========
			// ====================================================================
			boolean nonVariableExpression = false;
			
			// 1) Building the expressions (the dependence will be computed later)
			if (depExpr.getExpr() instanceof IndexExpression) {
				assert(depExpr.getDep().isIdentity());		// Guaranty by LowerDependence
				
				depExpr.getExpr().accept(this);		// Recursion
				returnedDepExpr = _polyIRFact.createDependenceExpression(depExpr.getDep().copy(),_subExprDimRed);
				nonVariableExpression = true;
			}
			
			// Constant expressions
			if (depExpr.getExpr() instanceof IntegerExpression) {
				returnedDepExpr = _polyIRFact.createDependenceExpression(depExpr.getDep().copy(),
						_polyIRFact.createIntegerExpression(((IntegerExpression) depExpr.getExpr()).getValue()));
				nonVariableExpression = true;
			}
			if (depExpr.getExpr() instanceof RealExpression) {
				returnedDepExpr = _polyIRFact.createDependenceExpression(depExpr.getDep().copy(),
						_polyIRFact.createRealExpression(((RealExpression) depExpr.getExpr()).getValue()));
				nonVariableExpression = true;
			}
			if (depExpr.getExpr() instanceof BooleanExpression) {
				returnedDepExpr = _polyIRFact.createDependenceExpression(depExpr.getDep().copy(),
						_polyIRFact.createBooleanExpression(((BooleanExpression) depExpr.getExpr()).isValue()));
				nonVariableExpression = true;
			}
			
			// 2) Building the dependence
			if (nonVariableExpression) {
				// Constants: the dependence is of the form (... ->)
				// Index expression: the dependence is Id (cf LowerDependence, was fused with the IndexExpression)
				//		=> In both cases, it is easy to outline the first _nBlockDim indexes
				FastISLMap nDepFunc;				// New dependence function
				FastISLMap depFunc = (FastISLMap) depExpr.getDep();
				if (depExpr.getExpr() instanceof IndexExpression) {
					// depFunc is an identity function
					
					List<Variable> nlInds = new BasicEList<Variable>();
					for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
						nlInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
					
					/* OLD CODE
					List<AffineExpression> nlExpr = new BasicEList<AffineExpression>();
					for (int i=0; i<nlInds.size(); i++)
						nlExpr.add(IntExpressionBuilder.affine(nlInds.get(i)));
					nDepFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_paramDom.getParams(), nlInds, nlExpr).getPMmapping());
					//*/
					List<String> lStrExpr = new BasicEList<String>();
					for (int i=0; i<nlInds.size(); i++)
						lStrExpr.add(nlInds.get(i).getName());
					nDepFunc = _polyIRFact.createFastISLMap(_paramDom.getParams(), nlInds, lStrExpr);
					
				} else {					// Constant expression
					// depFunc is a (...->) function
					
					List<Variable> nlInds = new BasicEList<Variable>();
					for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
						nlInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
					
					/* OLD CODE
					List<AffineExpression> nlExpr = new BasicEList<AffineExpression>();
					nDepFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_paramDom.getParams(), nlInds, nlExpr).getPMmapping());
					//*/
					List<String> lStrExpr = new BasicEList<String>();
					nDepFunc = _polyIRFact.createFastISLMap(_paramDom.getParams(), nlInds, lStrExpr);
				}
				
				returnedDepExpr.setDep(nDepFunc);
				_subExprDimRed = returnedDepExpr;
				return;
			}
			
			// =======================================================================
			// ======== Complicated case: VariableExpression after dependence ========
			// =======================================================================
			assert(depExpr.getExpr() instanceof VariableExpression);
			
			VariableExpression varExpr = (VariableExpression) depExpr.getExpr();
			String varCalledName = varExpr.getVarDecl().getName();
			
			// Special case: If the variable is an input ?
			boolean isInput = _systInputName.contains(varCalledName);
			//			=> Even if _outputInformation will be updated, do not change anything to the algorithm
			
			
			// 0) Collecting the informations about varCalledName. In particular:
			//		- The number of blocked dimensions outlined in its corresponding tile group (nBlockDimIm)
			//		- If he have more blocked dimensions in this variable than _nblockDim (isATempRedSG)
			//				=> This only happens for a "tempRed_SameGroup" inside its own tile group
			int nBlockDimIm = -1;
			for (List<Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer>> lCuts : _llCuts) {
				for (Triplet<FastISLDomain,List<Pair<String,List<Integer>>>,Integer> cut : lCuts) {
					List<Pair<String,List<Integer>>> lContribs = cut.getValue1();
					for (Pair<String,List<Integer>> contrib : lContribs)
						if (contrib.getValue0().equals(varCalledName)) {
							nBlockDimIm = cut.getValue2();
							break;
						}
					if (nBlockDimIm!=-1)
						break;
				}
				if (nBlockDimIm!=-1)
					break;
			}
			if (nBlockDimIm==-1) {
				if (!isInput)
					throw new RuntimeException("Variable " + varCalledName + " not input and not found in the llCuts");
				else
					nBlockDimIm = depExpr.getDep().getDimRHS()/2;
			}
			
			if (_noisyVisitor)
				System.out.println("	-> nBlockDimIm = " + nBlockDimIm);
			
			
			boolean isATempRedSG = false;		// Is the variable of the dependence function a "TempRed_SG" ?
			boolean wasFound = false;
			for (List<Pair<String,Boolean>> alignInfo : _nAlignmentInfo) {
				for (Pair<String,Boolean> alignInfoForVar : alignInfo) {
					if (alignInfoForVar.getValue0().equals(varCalledName)) {
						isATempRedSG = alignInfoForVar.getValue1();
						wasFound = true;
						break;
					}
				}
				if (wasFound)
					break;
			}
			if (!wasFound) {
				if (!isInput)
					throw new RuntimeException("Variable " + varCalledName + " not found in nAlignmentInfo");
				else
					isATempRedSG = false;
			}
			if (_noisyVisitor)
				System.out.println("	-> VarExprisATempRedSG = " + isATempRedSG);
			
			
			// We have in total 6 cases of dependences, depending the nature of the current variable and the variable of the dependence:
			//		- Normal => Normal
			//		- Normal => TempRed  (must be Id dep)
			//		- Normal => TempRedSG (must be Id dep / local)
			//		- TempRedSG => Normal
			//		- TempRedSG => TempRed (must be Id dep)
			//		- TempRedSG => TempRedSG (must be Id dep / local)
			
			// (TempRed being a "Normal" variable of its own tile group, i.e. all tiled dimensions are outlined,
			//				just that its number of blocked variable is not the half..)
			// (local = stay in the same tile of the tile group: no need to update the input/output informations)
			
			
			
			// *** First situation: if "isATempRed_SG" is true, because there is only one dependence pointing to it (before a potential split),
			//		which was built during the "preparation of outlining" step (inside the reduction on the blocked indexes) and is "Id".
			//			=> Therefore, this case is simple.
			//		Moreover, because TempRed_SameGroup is inside the same tile, we do not need to update the input/output informations
			// (correspond to "Normal/TempRedSG => TempRedSG")
			if (isATempRedSG) {
				if (_noisyVisitor)
					System.out.println("	=> First situation: Normal/TempRedSG => TempRedSG");
				
				FastISLMap depFunc = (FastISLMap) depExpr.getDep();
				assert(depFunc.isIdentity());
				
				List<Variable> nlInds = new BasicEList<Variable>();
				for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
					nlInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
				
				/* OLD CODE
				List<AffineExpression> nlExpr = new BasicEList<AffineExpression>();
				for (int i=0; i<nlInds.size(); i++)
					nlExpr.add(IntExpressionBuilder.affine(nlInds.get(i)));
				FastISLMap nDepFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_paramDom.getParams(), nlInds, nlExpr).getPMmapping());
				*/
				List<String> nlStrExpr = new BasicEList<String>();
				for (int i=0; i<nlInds.size(); i++)
					nlStrExpr.add(nlInds.get(i).getName());
				FastISLMap nDepFunc = _polyIRFact.createFastISLMap(_paramDom.getParams(), nlInds, nlStrExpr);
				
				
				// VariableDeclaration: just search inside the current tile group
				VariableDeclaration nVarDecl = _currentTileLocalVariable.get(varCalledName);
				returnedDepExpr = _polyIRFact.createDependenceExpression(nDepFunc, _polyIRFact.createVariableExpression(nVarDecl));
				
				_subExprDimRed = returnedDepExpr;
				return;
			}
			
			// *** Second situation, aka "normal case", aka "what always happens when we do not have reductions"
			//		=> All the blocked indexes of both sides are outlined
			//	(correspond to "Normal => Normal/TempRed", because we can merge this last case with the Normal case in the way we treat them)
			if (_areAllCurrentBlockedIndOutlined) {
				if (_noisyVisitor)
					System.out.println("	=> Second situation");
				
				returnedDepExpr = tempCase2DependenceExpression(depExpr);
				_subExprDimRed = returnedDepExpr;
				return;
			} else {
				if (_noisyVisitor)
					System.out.println("	=> Third situation");
				
				// *** Third situation, aka "complicated case", aka "what makes the whole algorithm complicated"
				//		=> Inside a "TempRedSG", using normal variable
				//	(correspond to "TempRedSG => Normal/TempRed")
				_subExprDimRed = tempCase3DependenceExpression(depExpr);
				return;
			}
		}
		
		/**
		 * Second situation: aka "normal case", aka "what always happens when we do not have reductions"
		 * 		(correspond to "Normal => Normal/TempRed", because we can merge this last case with the Normal case in the way we treat them)
		 * If "Normal => Normal": all blocked indexes of both sides are outlined
		 * If "Normal => TempRed": we have an Id dependence
		 * In both cases, we still need to track down the input/output informations
		 * 
		 * @return
		 */
		private DependenceExpression tempCase2DependenceExpression(DependenceExpression depExpr) {
			FastISLMap depFunc = (FastISLMap) depExpr.getDep();
			VariableExpression varExpr = (VariableExpression) depExpr.getExpr();
			
			
			// === STEP 1: Getting the input/output information and figuring our the new VariableExpression
			boolean dependenceGoingOutside = false;				// If "true", the dependence is going outside of the current tile
			
			// If we are accessing a variable which is not inside the tile group	=> Going outside (trivialy)
			if (!_currentVariablesOutlined.contains(varExpr.getVarDecl().getName()))
				dependenceGoingOutside = true;
			
			// The other situation is if we access a different block inside the current tile group => need to examine the dependence
			// We use this opportunity to decompose the dependence matrix into the interesting subblocks
			FastISLMap nDepFunc = null;
			Quartet<String, long[][], FastISLDomain, FastISLDomain> accessInformation;
																			// long[][]: block coordinate, String: name of variable,
																			//	Domain: local domain (input THEN output localDomain)
			int nDimProjOutput;												// Number of dimension we need to project between the input and the output informations
			if (_mProjFuncRedTemp.containsKey(varExpr.getVarDecl().getName())) {	// If "Normal => TempRed" situation
				if (_noisyVisitor)
					System.out.println("	=> Situation: Normal => TempRed (not SG)");
				
				assert(depFunc.isIdentity());
				assert(_isThereIndexExpression);
				// nBlockDimIm = _nBlockDim	(because we stay in the same tile group)
				
				// nDimProjOutput = |\alpha_2|, corresponding to the blocked indexes which are not projected for the inputs
				FastISLMap projFunc = _mProjFuncRedTemp.get(varExpr.getVarDecl().getName()).getValue0();
				nDimProjOutput = projFunc.getNIndices() - projFunc.getDimRHS();
				
				// In this case, dependenceGoingOutside = true
				// We can very quickly get the blocked matrix and the new dependence, because depFunc=Id
				int nBlockedParam = (_paramDom.getNParams()-_nBlockDim-1)/2;
				
				// blockedContrib contains coefficients for [N_b, \alpha, const]
				long[][] blockedContrib = new long[_nBlockDim][nBlockedParam+_nBlockDim+1];	// Params + blocked inds + consts
				for (int i=0; i<_nBlockDim; i++)
					blockedContrib[i][nBlockedParam+i] = 1;
				
				// contextDomVarExpr: changing the parameters
				FastISLDomain contextDomVarExpr = mContextDomainVarExpr.get(varExpr);
				
				// We shift the first blocked dimensions to the parameters (while making the names match)
				JNIISLSet nislSetContextDomVarExpr = contextDomVarExpr.getIslSet().copy().
						moveDims(JNIISLDimType.isl_dim_param, contextDomVarExpr.getNParams(), JNIISLDimType.isl_dim_set, 0, _nBlockDim);
				for (int i=contextDomVarExpr.getNParams(); i<nislSetContextDomVarExpr.getNbDims(JNIISLDimType.isl_dim_param); i++)
					nislSetContextDomVarExpr = nislSetContextDomVarExpr.setDimName(JNIISLDimType.isl_dim_param, i, _paramDom.getParams().get(i).getName());
				
				List<Variable> nLocalDomInds = new BasicEList<Variable>();
				for (int i=_nBlockDim; i<contextDomVarExpr.getNIndices(); i++)
					nLocalDomInds.add(_dimMana.getDimension(i-_nBlockDim, contextDomVarExpr.getIndices().get(i).getName()));
				DomainDimensions domDimLocalDomain = _polyFact.createDomainDimensions(nLocalDomInds, _paramDom.getParams());
				
				FastISLDomain localDomain = _polyIRFact.createFastISLDomain(domDimLocalDomain, nislSetContextDomVarExpr);
				
				// Because depFunc=Id and nBlockDimIm = _nBlockDim, then localDomainIn = localDomainOut
				JNIISLSet locDomOutSet = localDomain.getIslSet().copy();
				locDomOutSet = locDomOutSet.projectOut(JNIISLDimType.isl_dim_set, 0, nDimProjOutput);
				
				List<Variable> nLocalDomOutInds = new BasicEList<Variable>();
				for (int i=nDimProjOutput; i<localDomain.getNIndices(); i++)
					nLocalDomOutInds.add(_dimMana.getDimension(i-nDimProjOutput, localDomain.getIndices().get(i).getName()));
				DomainDimensions domDimsLocalDomOut = _polyFact.createDomainDimensions(nLocalDomOutInds, _paramDom.getParams());
				
				FastISLDomain localDomainOut = _polyIRFact.createFastISLDomain(domDimsLocalDomOut, locDomOutSet);
				
				accessInformation = Quartet.with(varExpr.getVarDecl().getName(), blockedContrib, localDomain, (FastISLDomain) localDomainOut);
				// For later: be careful that we still have some blocked indexes (which are not outlined,the one from the reduction) in "localDomain"
				
				// Getting the new dependence function
				List<Variable> lnInds = new BasicEList<Variable>();
				for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
					lnInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
				List<String> lStrExprDepFunc = new BasicEList<String>();
				for (int i=_nBlockDim; i<depFunc.getDimRHS(); i++)
					lStrExprDepFunc.add(lnInds.get(i-_nBlockDim).getName());
				nDepFunc = _polyIRFact.createFastISLMap(_paramDom.getParams(), lnInds, lStrExprDepFunc);
				
				
			} else {																// If "Normal => Normal" situation
				if (_noisyVisitor)
					System.out.println("	=> Situation: Normal => Normal");
				nDimProjOutput = 0;
				
				// We have a clean separation between the blocked and local indexes
				int nBlockDimIm = depFunc.getDimRHS()/2;		// Number of blocked indexes of variable - Only works in this situation
				
				// Number of blocked params
				int nBlockedParam = (_isThereIndexExpression)?
						((_paramDom.getNParams()-_nBlockDim-1)/2) : (_paramDom.getNParams()-1);
				long[][] matDepFunc = depFunc.toLongMatrix();
				
				// blockedContrib contains coefficients for [N_b, \alpha, const]
				long[][] blockedContrib = new long[nBlockDimIm][nBlockedParam+_nBlockDim+1];
				for (int i=0; i<nBlockDimIm; i++) {
					// The first half of the dependence function corresponds to the blocked indexes
					for (int j=0; j<nBlockedParam; j++)
						blockedContrib[i][j] = matDepFunc[i][j];
					for (int j=0; j<_nBlockDim; j++)
						blockedContrib[i][nBlockedParam+j] = matDepFunc[i][j+depFunc.getNParams()];
					blockedContrib[i][blockedContrib[0].length-1] = matDepFunc[i][matDepFunc[0].length-1];
				}
				
				
				// Determining dependenceGoingOutside => stays false only if it is "Id" function
				if (!dependenceGoingOutside) {			// Already true if the variable is not in the tile group
					for (int i=0; i<blockedContrib.length; i++) {
						for (int j=0; j<nBlockedParam; j++)
							if (blockedContrib[i][j]!=0) {
								dependenceGoingOutside = true;
								break;
							}
						if (dependenceGoingOutside)
							break;
						for (int j=0; j<_nBlockDim; j++)
							if (i!=j) {
								if (blockedContrib[i][j+nBlockedParam]!=0) {
									dependenceGoingOutside = true;
									break;
								}
							} else {
								if (blockedContrib[i][j+nBlockedParam]!=1) {
									dependenceGoingOutside = true;
									break;
								}
							}
						if (blockedContrib[i][blockedContrib[0].length-1]!=0)
							dependenceGoingOutside = true;
						if (dependenceGoingOutside)
							break;
					}
				}
				
				// Determining the domain of the access
				FastISLDomain contextDomVarExpr = mContextDomainVarExpr.get(varExpr);
				// In contextDomVarExpr, the parameters are Nb,Nl,b and the number of block var are the same than
				//		varExpr.getVarDecl() (<=> output, and different from the current equation/subsystem)
				
				// To get the domain of the output information: blocked indexes are fine
				// To get the domain of the input variable: Need to take the preimage of the _nBlockDim first blocked indexes
				//		of contextDomVarExpr by the first dimensions of the dependence function
				
				// Output:
				//		- if FullParamDom: need to shift the nBlockDimIm first blocked dimensions into the parameters
				//		- if !FullParamDom: need to remove the nBlockDimIm first blocked dimensions
				//				+ need to remove the "Nb"
				FastISLDomain localOutputDomain;
				if (_isThereIndexExpression) {
					JNIISLSet locOutDomain = contextDomVarExpr.getIslSet().copy();
					int nParamTemp = locOutDomain.getNbDims(JNIISLDimType.isl_dim_param);
					locOutDomain = locOutDomain.moveDims(JNIISLDimType.isl_dim_param, nParamTemp, JNIISLDimType.isl_dim_set, 0, nBlockDimIm);
					
					//for (int i=nParamTemp; i<nParamTemp+nBlockDimIm; i++)
					//	locOutDomain = locOutDomain.setDimName(JNIISLDimType.isl_dim_param, i, contextDomVarExpr.getIndices().get(i-nParamTemp).getName());
					
					List<Variable> lIndsOutDom = new BasicEList<Variable>();
					for (int i=nBlockDimIm; i<contextDomVarExpr.getNIndices(); i++)
						lIndsOutDom.add(_dimMana.getDimension(i-nBlockDimIm, contextDomVarExpr.getIndices().get(i).getName()));
					
					List<Variable> lParamsOutDom = new BasicEList<Variable>();
					lParamsOutDom.addAll(_paramDom.getParams().subList(0, _paramDom.getNParams()- _nBlockDim));
					//lParamsOutDom.addAll(_paramDom.getParams());
					for (int i=0; i<nBlockDimIm; i++)
						lParamsOutDom.add(_dimMana.getParameter(i+_paramDom.getNParams(), contextDomVarExpr.getIndices().get(i).getName()));
					
					DomainDimensions domDimOutDomain = _polyFact.createDomainDimensions(lIndsOutDom, lParamsOutDom);
					
					localOutputDomain = _polyIRFact.createFastISLDomain(domDimOutDomain, locOutDomain);
				} else {
					JNIISLSet locOutDomain = contextDomVarExpr.getIslSet().copy();
					locOutDomain = locOutDomain.projectOut(JNIISLDimType.isl_dim_param, 0, nBlockedParam);
					locOutDomain = locOutDomain.projectOut(JNIISLDimType.isl_dim_set, 0, nBlockDimIm);
					
					List<Variable> lIndsOutDom = new BasicEList<Variable>();
					for (int i=nBlockDimIm; i<contextDomVarExpr.getNIndices(); i++)
						lIndsOutDom.add(_dimMana.getDimension(i-nBlockDimIm, contextDomVarExpr.getIndices().get(i).getName()));
					
					DomainDimensions domDimOutDomain = _polyFact.createDomainDimensions(lIndsOutDom, _paramDom.getParams());
					
					localOutputDomain = _polyIRFact.createFastISLDomain(domDimOutDomain, locOutDomain);
				}
				
				// Input:
				//	Create \phi = (depBl,Id) (where depFunc = (depBl, depLoc) ) and compute contDomIm = \phi^{-1}(contDom)
				//		- if FullParamDom: shift _nBlockDim first blocked dimensions of contDomIm into the parameters
				//		- if !FullParamDom: need to remove the "Nb" and the first _nBlockDim dimensions of contDomIn
				//					=> Get exactly localOutputDomain
				FastISLDomain localInputDomain;
				
				if (_isThereIndexExpression) {
					JNIISLBasicMap depMap = depFunc.getIslMap().copy();
					
					// phi = (iBl, iLoc_Im -> depBl, iLoc_Im)
					depMap = depMap.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_out, nBlockDimIm, nBlockDimIm);
					
					if (nBlockDimIm<_nBlockDim)
						depMap = depMap.projectOut(JNIISLDimType.isl_dim_in, _nBlockDim+nBlockDimIm, _nBlockDim-nBlockDimIm);
					if (nBlockDimIm>_nBlockDim)
						depMap = depMap.insertDims(JNIISLDimType.isl_dim_in, depMap.getNbDims(JNIISLDimType.isl_dim_in), nBlockDimIm-_nBlockDim);
					// We have (_nBlockDim+nBlockDimIm) inputs dimensions to depMap now
					
					for (int i=0; i<nBlockDimIm; i++) {
						JNIISLConstraint constr = JNIISLConstraint.buildEquality(depMap.getSpace().copy());
						constr = constr.setCoefficient(JNIISLDimType.isl_dim_out, i+nBlockDimIm, 1);
						constr = constr.setCoefficient(JNIISLDimType.isl_dim_in, i+_nBlockDim, -1);
						
						depMap = depMap.addConstraint(constr);
					}
					
					List<Variable> lIndPhi;
					if (nBlockDimIm<=_nBlockDim)
						lIndPhi = depFunc.getIndices().subList(0, _nBlockDim+nBlockDimIm);
					else {
						lIndPhi = new BasicEList<Variable>();
						for (int k=0; k<depFunc.getNIndices(); k++)
							lIndPhi.add(depFunc.getIndices().get(k));
						for (int k=depFunc.getIndices().size(); k<_nBlockDim+nBlockDimIm; k++)
							lIndPhi.add(_dimMana.getDimension(k));
					}
					DomainDimensions domDimPhi = _polyFact.createDomainDimensions(lIndPhi, depFunc.getParams());
					FastISLMap phi = _polyIRFact.createFastISLMap(domDimPhi, depMap, depFunc.getLabelIn(), depFunc.getLabelOut());
					FastISLDomain contDomIm = (FastISLDomain) contextDomVarExpr.preimage(phi);
					
					JNIISLSet setContDomIm = contDomIm.getIslSet().copy();
					setContDomIm = setContDomIm.moveDims(JNIISLDimType.isl_dim_param, setContDomIm.getNbDims(JNIISLDimType.isl_dim_param),
							JNIISLDimType.isl_dim_set, 0, _nBlockDim);
					for (int i=contDomIm.getNParams(); i<setContDomIm.getNbDims(JNIISLDimType.isl_dim_param); i++)
						setContDomIm = setContDomIm.setDimName(JNIISLDimType.isl_dim_param, i, _paramDom.getParams().get(i).getName());
					
					List<Variable> lIndsInDomain = new BasicEList<Variable>();
					for (int i=_nBlockDim; i<contDomIm.getNIndices(); i++)
						lIndsInDomain.add(_dimMana.getDimension(i-_nBlockDim, contDomIm.getIndices().get(i).getName()));
					
					DomainDimensions domDimInDomain = _polyFact.createDomainDimensions(lIndsInDomain, _paramDom.getParams());
					localInputDomain = _polyIRFact.createFastISLDomain(domDimInDomain, setContDomIm);
				} else {
					localInputDomain = (FastISLDomain) localOutputDomain.copy();
				}
				
				/* DEBUG
				System.out.println("contextDomVar.islSet = " + contextDomVarExpr.getIslSet().toString());
				System.out.println("contextDomVar.params = " + contextDomVarExpr.getParams().toString());
				System.out.println("contextDomVar.inds = " + contextDomVarExpr.getIndices().toString());
				System.out.println("contextDomVar = " + contextDomVarExpr.toString());
				System.out.println();
				System.out.println("localInputDomain.islSet = " + localInputDomain.getIslSet().toString());
				System.out.println("localInputDomain.params = " + localInputDomain.getParams().toString());
				System.out.println("localInputDomain.inds = " + localInputDomain.getIndices().toString());
				System.out.println("localInputDomain = " + localInputDomain.toString());
				System.out.println();
				System.out.println("localOutputDomain.islSet = " + localOutputDomain.getIslSet().toString());
				System.out.println("localOutputDomain.params = " + localOutputDomain.getParams().toString());
				System.out.println("localOutputDomain.inds = " + localOutputDomain.getIndices().toString());
				System.out.println("localOutputDomain = " + localOutputDomain.toString());
				//*/
				
				accessInformation = Quartet.with(varExpr.getVarDecl().getName(), blockedContrib, localInputDomain, localOutputDomain);
				
				// Getting the new dependence function
				EList<Variable> lnInds = new BasicEList<Variable>();
				for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
					lnInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
				
				long[][] matNDepFunc;
				if (_isThereIndexExpression) {
					if (matDepFunc.length==0)
						matNDepFunc = new long[0][0];
					else
						matNDepFunc = new long[matDepFunc.length-nBlockDimIm][matDepFunc[0].length];
					for (int i=0; i<matNDepFunc.length; i++)
						for (int j=0; j<matNDepFunc[0].length; j++)
							matNDepFunc[i][j] = matDepFunc[i+nBlockDimIm][j];		// A simple removal of the first columns is enough
				} else {
					matNDepFunc = new long[matDepFunc.length-nBlockDimIm][_paramDom.getNParams()+depFunc.getNIndices()-_nBlockDim+1];
					
					// We need to remove the part for N_b and \alpha
					for (int i=0; i<matNDepFunc.length; i++) {
						for (int j=0; j<_paramDom.getNParams(); j++)												// Local param + b
							matNDepFunc[i][j] = matDepFunc[i+nBlockDimIm][j+nBlockedParam];
						for (int j=0; j<depFunc.getNIndices()-_nBlockDim; j++)
							matNDepFunc[i][_paramDom.getNParams()+j] = matDepFunc[i+nBlockDimIm][depFunc.getNParams()+_nBlockDim+j];
						matNDepFunc[i][matNDepFunc[0].length-1] = matDepFunc[i+nBlockDimIm][matDepFunc[0].length-1];	// Constant
					}
				}
				nDepFunc = _polyIRFact.createFastISLMapMatLong(_paramDom.getParams(), lnInds, matNDepFunc);
			}
			
			
			// === STEP 2: Updating the input/output informations using accessInformation
			VariableDeclaration nVarDecl;
			if (dependenceGoingOutside)
				nVarDecl = updateInOutputInfo(accessInformation, nDimProjOutput);
			else
				nVarDecl = _currentTileLocalVariable.get(varExpr.getVarDecl().getName());
			
			// === STEP 3: Creating the current dependenceExpression & returning it
			return _polyIRFact.createDependenceExpression(nDepFunc, _polyIRFact.createVariableExpression(nVarDecl));
		}
		
		/**
		 * Update the input and output informations. Returns the corresponding input variableDeclaration
		 * 
		 * nDimProjOutput = number of dimensions we (still) need to project the output
		 * 
		 * @param accessInformation
		 */
		private VariableDeclaration updateInOutputInfo(Quartet<String, long[][], FastISLDomain, FastISLDomain> accessInformation, int nDimProjOutput) {	
			if (_noisyVisitor) {
				System.out.println("accessInformation = [[[");
				System.out.println("	-> " + accessInformation.getValue0());
				System.out.print("	-> " + MatrixOperations.toString(accessInformation.getValue1()));
				System.out.println("	-> " + accessInformation.getValue2().toString());
				System.out.println("	-> " + accessInformation.getValue3().toString());
				System.out.println("]]]  -    nDimProjOutput = " + nDimProjOutput);
			}
			
			VariableDeclaration varRet;
			
			// PART 1: Input Informations
			
			// We look at _inputInformations to see if the input was already created
			Triplet<String,long[][],VariableDeclaration> tInput = searchInputInformations(accessInformation.getValue0(),
					accessInformation.getValue1());
			boolean tripletFound = (tInput!=null);
			
			// Two cases, depending if we need to update or to create a new triplet
			FastISLDomain nDomInput;
			if (tripletFound) {
				varRet = tInput.getValue2();
				FastISLDomain oldDomInput = (FastISLDomain) varRet.getDomain();
				
				nDomInput = (FastISLDomain) oldDomInput.union(accessInformation.getValue2());
				nDomInput.simplify();
				
				varRet.setDomain(nDomInput);
			} else {
				// We create a new triplet (with a new VariableDeclaration for this input)
				nDomInput = accessInformation.getValue2();
				
				Type typeVarRet = null;
				for (VariableDeclaration varDecl : _systVarDecl)
					if (varDecl.getName().equals(accessInformation.getValue0())) {
						typeVarRet = varDecl.getType();
						break;
					}
				if (typeVarRet==null)
					throw new RuntimeException("VariableDeclaration " + accessInformation.getValue0() + " not found !!!");
				
				varRet = _polyIRFact.createVariableDeclaration(accessInformation.getValue0()+ "_" + _inputVarCounter, typeVarRet, nDomInput);
				_inputVarCounter++;
				_inputInformations.add(Triplet.with(accessInformation.getValue0(), accessInformation.getValue1(), varRet));
			}
			
			// PART 2: Output information
			FastISLDomain domOutputNContrib = accessInformation.getValue3();
			
			// Computing the output domain we need to add
			FastISLDomain domOutput;
			//if (nDimProjOutput==0) {
			if (_isThereIndexExpression) {// && nDimProjOutput==0) {
				// Translate parameter into half parameter domain
				int nParamScal = (_paramDom.getNParams()-_nBlockDim-1)/2;
				if (domOutputNContrib.getNParams()==nParamScal+1) {
					domOutput = domOutputNContrib;
				} else {
					EList<Variable> lnInds = domOutputNContrib.getIndices();
					EList<Variable> lnParam = new BasicEList<Variable>();
					for (int i=0; i<nParamScal+1; i++)						// Get N_l and b
						lnParam.add(_dimMana.getParameter(i, _paramDom.getParamNames().get(i+nParamScal)));
					
					DomainDimensions domDims = _polyFact.createDomainDimensions(lnInds, lnParam);
					
					JNIISLSet nDomInputIslSet = domOutputNContrib.getIslSet().copy();
					
					nDomInputIslSet = nDomInputIslSet.projectOut(JNIISLDimType.isl_dim_param, 0, nParamScal);		// Remove Nb
					nDomInputIslSet = nDomInputIslSet.projectOut(JNIISLDimType.isl_dim_param, nParamScal+1,			// Remove the indexes after (Nl,b)
							nDomInputIslSet.getNbDims(JNIISLDimType.isl_dim_param)-nParamScal-1);
					
					domOutput = _polyIRFact.createFastISLDomain(domDims, nDomInputIslSet);
				}
			} else {
				domOutput = domOutputNContrib;
			}
			/*} else {
				assert(nDimProjOutput>0);
				// Only happens in a TempRedSG => we have a full parameter domain originally here
				//		However, the target variable might be an "half-parameter" one (no reduction, etc etc)
				
				// Note: the domain only have local indexes: we can always have the half parameter form
				// (i.e. by removing completly the blocked indexes/parameters, and we have a clean separation)
				//				=> Constraint selection needed
				assert(_isThereIndexExpression);
				
				EList<Variable> lnInds = new BasicEList<Variable>();
				for (int i=nDimProjOutput; i<domOutputNContrib.getNIndices(); i++)
					lnInds.add(_dimMana.getDimension(i-nDimProjOutput, domOutputNContrib.getIndexNames().get(i)));
				
				EList<Variable> lnParam = new BasicEList<Variable>();
				int nParamScal = (_paramDom.getNParams()-_nBlockDim-1)/2;
				for (int i=0; i<nParamScal+1; i++)						// Get N_l and b
					lnParam.add(_dimMana.getParameter(i, _paramDom.getParamNames().get(i+nParamScal)));
				
				List<Matrix> lnMat = new BasicEList<Matrix>();
				List<Matrix> lMat = domOutputNContrib.toMatrix();
				for (Matrix matDomInput : lMat) {
					List<MatrixRow> lMatRowLocal = new BasicEList<MatrixRow>();
					
					for (MatrixRow mRow : matDomInput.getRows()) {
						boolean useBlockedParamInd = false;

						// Check if it uses blocked parameter/local
						for (int i=0; i<nParamScal; i++)
							if (mRow.get(i+1)!=0)
								useBlockedParamInd = true;
						for (int i=0; i<_nBlockDim+nDimProjOutput; i++)
							if (mRow.get(1+_paramDom.getNParams()-_nBlockDim+i)!=0)
								useBlockedParamInd = true;
						
						if (!useBlockedParamInd) {
							MatrixRow nmRow = _polyFact.createMatrixRow(3+nParamScal+domOutputNContrib.getNIndices()-nDimProjOutput);
							
							nmRow.set(0, mRow.get(0));										// Ineq/Eq
							for (int i=0; i<nParamScal+1; i++)								// Local params + b
								nmRow.set(i+1, mRow.get(i+1+nParamScal));
							for (int i=0; i<domOutputNContrib.getNIndices()-nDimProjOutput; i++)	// Local indexes
								nmRow.set(i+nParamScal+2, mRow.get(1+_paramDom.getNParams()+nDimProjOutput+i));
							nmRow.set(nmRow.getSize()-1, mRow.get(mRow.getSize()-1));			// Constant
							lMatRowLocal.add(nmRow);
						}
					}
					
					Matrix matNDomInput = _polyFact.createMatrix(lMatRowLocal.size(), lMatRowLocal.get(0).getSize());
					matNDomInput.getRows().clear();
					matNDomInput.getRows().addAll(lMatRowLocal);
					
					lnMat.add(matNDomInput);
				}
				
				domOutput = _polyIRFact.createFastISLDomain(lnParam, lnInds, lnMat);
			}*/
			
			// Does "nameVar" already occurs?
			List<Pair<long[][],FastISLDomain>> domOutputInit = _outputInfos.get(accessInformation.getValue0());
			
			if (domOutputInit==null) {		// New entry for the variable
				if (_noisyVisitor)
					System.out.println("[output] nDomOutput = " + domOutput);
				List<Pair<long[][],FastISLDomain>> nlOutputInfos = new BasicEList<Pair<long[][],FastISLDomain>>();
				nlOutputInfos.add(Pair.with(accessInformation.getValue1(),domOutput));
				_outputInfos.put(accessInformation.getValue0(), nlOutputInfos);
			} else {							// Entry already here
				if (_noisyVisitor)
					System.out.println("[output] domOutput = " + domOutput.toString());
				
				// Search if we already have an output corresponding to the matrix
				long[][] matSearched = accessInformation.getValue1();
				boolean pairFound = false;
				for (int k=0; k<domOutputInit.size(); k++) {
					Pair<long[][], FastISLDomain> pMatDom = domOutputInit.get(k);
					long[][] matCandidate = pMatDom.getValue0();
					
					// We compare the 2 matrices
					boolean matched = MatrixOperations.isEqual(matCandidate, matSearched);
					if (matched==true) {
						pairFound = true;
						
						// We do the union and update the entry
						FastISLDomain initDomOut = pMatDom.getValue1();
						FastISLDomain nDomOutput = (FastISLDomain) initDomOut.union(domOutput);
						Pair<long[][],FastISLDomain> npMatDom = Pair.with(pMatDom.getValue0(), nDomOutput);
						domOutputInit.remove(k);
						domOutputInit.add(npMatDom);
						
						if (_noisyVisitor)
							System.out.println("[output] nDomOutput = " + nDomOutput.toString());
						
						break;
					}
				}
				
				if (!pairFound) {			// New entry for the block of this variable
					domOutputInit.add(Pair.with(matSearched,domOutput));
					
					if (_noisyVisitor)
						System.out.println("[output] nDomOutput = " + domOutput.toString());
				}
			}
			
			// We return the new/found input variableDeclaration
			return varRet;
		}
		
		/**
		 * Function to seach a Triplet in _inputInformations
		 * Return "null" if no corresponding Triplet is found
		 * 
		 * @param varNameCandidate
		 * @param matCandidate
		 * @return
		 */
		private Triplet<String,long[][],VariableDeclaration> searchInputInformations(String varNameCandidate, long[][] matCandidate) {
			Triplet<String,long[][],VariableDeclaration> tInput = null;
			for (Triplet<String,long[][],VariableDeclaration> tVarInput : _inputInformations)
				if (tVarInput.getValue0().equals(varNameCandidate)) {	// If same variable
					if (MatrixOperations.isEqual(matCandidate, tVarInput.getValue1())) {		// Triplet found !!!
						tInput = tVarInput;
						break;
					}
				}
			return tInput;
		}
		
		/**
		 * Third situation, aka "complicated case", aka "what makes the whole algorithm complicated"
		 * 		Inside a "TempRedSG", using normal variable
		 * 		(correspond to "TempRedSG => Normal/TempRed")
		 * 
		 * @return
		 */
		private Expression tempCase3DependenceExpression(DependenceExpression depExpr) {
			FastISLMap depFunc = (FastISLMap) depExpr.getDep();
			VariableExpression varExpr = (VariableExpression) depExpr.getExpr();
			
			assert(_isThereIndexExpression);		// We are inside a TempRedSG => we have a reduction !!!
			
			// === STEP 1: Getting the input/output information and figuring our the new VariableExpression
			boolean dependenceGoingOutside = false;				// If "true", the dependence is going outside of the current tile
			
			// If we are accessing a variable which is not inside the tile group	=> Going outside (trivialy)
			if (!_currentVariablesOutlined.contains(varExpr.getVarDecl().getName()))
				dependenceGoingOutside = true;
			
			// The other situation is if we access a different block inside the current tile group => need to examine the dependence
			// We use this opportunity to decompose the dependence matrix into the interesting subblocks
			FastISLMap nDepFunc = null;
			Quartet<String, long[][], FastISLDomain, FastISLDomain> accessInformation;
									// long[][]: block coordinate, String: name of variable, Domain: local domain input, then output
			int nDimProjOutput;												// Number of dimension we need to project between the input and the output informations
			if (_mProjFuncRedTemp.containsKey(varExpr.getVarDecl().getName())) {	// If "TempRedSG => TempRed" situation
				if (_noisyVisitor)
					System.out.println("	=> Situation: TempRedSG => TempRed (not SG)");
				
				assert(depFunc.isIdentity());
				
				// nDimProjOutput = |\alpha_2| + |\alpha'_2|, corresponding to the blocked indexes which are not projected for the inputs
				FastISLMap projFuncVarExpr = _mProjFuncRedTemp.get(varExpr.getVarDecl().getName()).getValue0();
				int alpha2ProjFuncVarExpr = projFuncVarExpr.getNIndices() - projFuncVarExpr.getDimRHS();
				FastISLMap projFuncTempRedSG = _mProjFuncRedTemp.get(_nameCurrentVar).getValue0();
				int alpha2ProjFuncTempRedSG = projFuncTempRedSG.getNIndices() - projFuncTempRedSG.getDimRHS();
				
				nDimProjOutput = alpha2ProjFuncVarExpr + alpha2ProjFuncTempRedSG;
				
				
				// In this case, dependenceGoingOutside = true
				// We can very quickly get the blocked matrix and the new dependence, because depFunc=Id
				int nBlockedParam = (_paramDom.getNParams()-_nBlockDim-1)/2;
				
				// blockedContrib contains coefficients for [N_b, \alpha, const]
				long[][] blockedContrib = new long[_nBlockDim][nBlockedParam+_nBlockDim+1];	// Params + blocked inds + consts
				for (int i=0; i<_nBlockDim; i++)
					blockedContrib[i][nBlockedParam+i] = 1;
				
				FastISLDomain contextDomVarExpr = mContextDomainVarExpr.get(varExpr);
				
				List<String> lStrExprProjLocalIndex = new BasicEList<String>();
				for (int i=_nBlockDim; i<contextDomVarExpr.getNIndices(); i++)
					lStrExprProjLocalIndex.add(contextDomVarExpr.getIndices().get(i).getName());
				FastISLMap projLocalIndex = _polyIRFact.createFastISLMap(_paramDom.getParams(), contextDomVarExpr.getIndices(), lStrExprProjLocalIndex);
				
				FastISLDomain localDomain = (FastISLDomain) contextDomVarExpr.image(projLocalIndex);
				
				accessInformation = Quartet.with(varExpr.getVarDecl().getName(), blockedContrib, localDomain, (FastISLDomain) localDomain.copy());
				// For later: be careful that we still have some blocked indexes (which are not outlined,the one from the reduction) in "localDomain"
				
				// Getting the new dependence function
				List<Variable> lnInds = new BasicEList<Variable>();
				for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
					lnInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
				
				List<String> lStrExprDepFunc = new BasicEList<String>();
				for (int i=_nBlockDim; i<depFunc.getDimRHS(); i++)
					lStrExprDepFunc.add(lnInds.get(i-_nBlockDim).getName());
				nDepFunc = _polyIRFact.createFastISLMap(_paramDom.getParams(), lnInds, lStrExprDepFunc);
				
				// === STEP 2: Updating the input/output informations using accessInformation
				VariableDeclaration nVarDecl;
				if (dependenceGoingOutside)
					nVarDecl = updateInOutputInfo(accessInformation, nDimProjOutput);
				else
					nVarDecl = _currentTileLocalVariable.get(varExpr.getVarDecl().getName());
				
				// === STEP 3: Creating the current dependenceExpression & returning it
				return _polyIRFact.createDependenceExpression(nDepFunc, _polyIRFact.createVariableExpression(nVarDecl));
				
			} else {																// If "TempRedSG => Normal" situation
				if (_noisyVisitor)
					System.out.println("	=> Situation: TempRedSG => Normal");
				
				// Getting the projection function associated to TempRedSG (aka the current variable of the equation)
				//		This function is of the shape (\alpha_1, \alpha_2, ii_1 -> \alpha_1, ii_1), thus we can get the number of dim projected
				FastISLMap projFuncTempRedSG = _mProjFuncRedTemp.get(_nameCurrentVar).getValue0();
				int alpha2ProjFuncTempRedSG = projFuncTempRedSG.getNIndices() - projFuncTempRedSG.getDimRHS();		// = |\alpha_2|
				nDimProjOutput = alpha2ProjFuncTempRedSG;
				
				Matrix matDepFunc = depFunc.toMatrix();
				
				// If the dependence is using a local variable, AND the local block might be reachable, we need to split
				//		(between the variable defined inside the block and a new input)
				//			=> We determine if a split is needed and (if yes) the split domain
				boolean splitNeeded = false;
				FastISLDomain splitDom = null;
				FastISLDomain domUniv = null;
				
				if (_currentVariablesOutlined.contains(varExpr.getVarDecl().getName())) {
					// We check if the current tile is reachable through this dependence
					//	   => We need to compute splitDom = {\alpha,\gamma | \phi_{bl}(\alpha,\gamma) = \alpha} \inter \phi_{bl}^{-1}(Contextdom)
					//				where phi is the dependence function and \gamma are the blocked indexes which are projected...
					
					
					// Building depBlock = \phi_{bl}, i.e., the blocked part of the dependence
					List<Variable> lnIndPhiBl = new BasicEList<Variable>();
					for (int i=0; i<depFunc.getNIndices()/2; i++)			// Because we are under a dependence
						lnIndPhiBl.add(depFunc.getIndices().get(i));
					DomainDimensions domDimsDepBlock = _polyFact.createDomainDimensions(lnIndPhiBl, depFunc.getParams());
					
					JNIISLBasicMap depFuncMapBlock = depFunc.getIslMap().copy();
					depFuncMapBlock = depFuncMapBlock.projectOut(JNIISLDimType.isl_dim_out,
							depFunc.getIslMap().getNbDims(JNIISLDimType.isl_dim_out)/2, depFunc.getIslMap().getNbDims(JNIISLDimType.isl_dim_out)/2);
					depFuncMapBlock = depFuncMapBlock.projectOut(JNIISLDimType.isl_dim_in,
							depFunc.getIslMap().getNbDims(JNIISLDimType.isl_dim_in)/2, depFunc.getIslMap().getNbDims(JNIISLDimType.isl_dim_in)/2);
					FastISLMap depBlock = _polyIRFact.createFastISLMap(domDimsDepBlock, depFuncMapBlock, depFunc.getLabelIn(), depFunc.getLabelOut());
					
					// DEBUG
					//System.out.println("depBlock = " + depBlock.toString());
					
					
					// * Computing \phi_{bl}^{-1}(Contextdom)
					FastISLDomain contextDom = mContextDomainVarExpr.get(varExpr);
					
					// We remove the local indexes of contextDom to make it coherent with depBlock
					JNIISLSet contDomSet = contextDom.getIslSet().copy();
					contDomSet = contDomSet.projectOut(JNIISLDimType.isl_dim_set, contextDom.getNIndices()/2, contextDom.getNIndices()/2);
					DomainDimensions domDimsContextDomBlock = _polyFact.createDomainDimensions(
							contextDom.getIndices().subList(0, contextDom.getNIndices()/2), contextDom.getParams());
					FastISLDomain contextDomBlock = _polyIRFact.createFastISLDomain(domDimsContextDomBlock, contDomSet);
					
					// DEBUG
					//System.out.println("contextDom = " + contextDom.toString());
					//System.out.println("	=> contextDomBlock = " + contextDomBlock.toString());
					
					FastISLDomain depBlockInvContextDom = (FastISLDomain) contextDomBlock.preimage(depBlock);
					// Note: depBlockInvContextDom only have blocked indexes
					
					// DEBUG
					//System.out.println("depBlockInvContextDom = " + depBlockInvContextDom.toString());
					
					// * Computing {\alpha,\gamma | \phi_{bl}(\alpha,\gamma) = \alpha} and adding to the current domain
					long[][] lMatdepBlock = depBlock.toLongMatrix();
					
					// We add a 0 column at the start of lMatdepBlock (corresponding to the equality)
					// lMatdepBlock => [param | \alpha | \gamma | Const] => We need to add a -Id to the \alpha contribution
					long[][] lnMatPhiBlAlphaGammaEqAlpha = new long[lMatdepBlock.length][lMatdepBlock[0].length+1];
					for (int i=0; i<lnMatPhiBlAlphaGammaEqAlpha.length; i++) {
						for (int j=0; j<lMatdepBlock[0].length; j++)
							lnMatPhiBlAlphaGammaEqAlpha[i][j+1] = lMatdepBlock[i][j];
						lnMatPhiBlAlphaGammaEqAlpha[i][1+depBlock.getNParams()+i] -= 1;
					}
					List<long[][]> listMatPhiBlAlphaGammaEqAlpha = new BasicEList<long[][]>();
					listMatPhiBlAlphaGammaEqAlpha.add(lnMatPhiBlAlphaGammaEqAlpha);
					FastISLDomain phiBlAlphaGammaEqAlpha = _polyIRFact.createFastISLDomainMatLong(depBlockInvContextDom.getDomDims(),
							listMatPhiBlAlphaGammaEqAlpha);
					
					// DEBUG
					//System.out.println("phiBlAlphaGammaEqAlpha = " + phiBlAlphaGammaEqAlpha.toString());
					
					splitDom = (FastISLDomain) depBlockInvContextDom.intersection(phiBlAlphaGammaEqAlpha);
					
					
					// === Start computation of domUniv
					
					// Universe is computed as the intersection of the currentCut (adapted to fit TempRed_SG)
					//		and the domain of TempRedSG
					// TODO: is _tempRedSG_ContextBelowReduction needed? (for the local indexes of the context)
					
					// 1) Contrib from the current cut
					JNIISLSet islDomCut = _currentBlockedDom.getIslSet().copy();
					
					// We remove the local indexes
					islDomCut = islDomCut.projectOut(JNIISLDimType.isl_dim_set, _nBlockDim,
							islDomCut.getNbDims(JNIISLDimType.isl_dim_set)-_nBlockDim);
					
					// We add the blocked indexes (extra to the TempRed_SG compared to the rest of the variable of the tile group)
					islDomCut = islDomCut.addDims(JNIISLDimType.isl_dim_set, alpha2ProjFuncTempRedSG);
					
					// Parameters are fine ("Nb,Nl,b", identical to splitDom)
					FastISLDomain domCutTempRedSG = _polyIRFact.createFastISLDomain(splitDom.getDomDims(), islDomCut);
					
					
					// 2) Contrib from the variable declaration of TempRed_SG
					
					// Get the context from the variableDeclaration of TempRed_SG itself
					FastISLDomain domTempRedSGCurrent = null;
					for (VariableDeclaration varDecl : _systVarDecl)
						if (varDecl.getName().equals(_nameCurrentVar)) {
							domTempRedSGCurrent = (FastISLDomain) varDecl.getDomain();
							break;
						}
					if (domTempRedSGCurrent==null)
						throw new RuntimeException("VariableDeclaration " + _nameCurrentVar + " not found in _systVarDecl");
					
					// We remove the local contribution (\alpha_1, \alpha_2, ii_1 ===> \alpha_1, \alpha_2)
					JNIISLSet islSetTempRedSGCurrent = domTempRedSGCurrent.getIslSet().copy();
					islSetTempRedSGCurrent = islSetTempRedSGCurrent.projectOut(JNIISLDimType.isl_dim_set,
							projFuncTempRedSG.getNIndices()-projFuncTempRedSG.getDimRHS()/2, projFuncTempRedSG.getDimRHS()/2);
					FastISLDomain domBlTempRedSGCurrent = _polyIRFact.createFastISLDomain(splitDom.getDomDims(), islSetTempRedSGCurrent);
					
					// Parameter domain contrib seems not needed
					
					// Intersection
					domUniv = (FastISLDomain) domBlTempRedSGCurrent.intersection(domCutTempRedSG);
					
					// === End computation of domUniv
					
					// TODO: issue here
					
					splitDom = (FastISLDomain) splitDom.intersection(domUniv);
					
					// Doing the intersection to get splitDom
					splitNeeded = !splitDom.isEmpty();
				}
				
				// DEBUG
				if (_noisyVisitor) {
					System.out.println("	-> splitNeeded = " + splitNeeded);
					System.out.println("	-> (domUniv = " + domUniv + " )");
					System.out.println("	-> (splitDom = " + splitDom + " )");
					if (splitNeeded)
						System.out.println("	-> splitDom = " + splitDom);
				}
				
				
				if (splitNeeded) {
					
					// === Complementary of splitDom in the universe
					FastISLDomain complSplitDom = (FastISLDomain) domUniv.difference(splitDom);
					complSplitDom.simplify();
					
					boolean complEmpty = complSplitDom.isEmpty();
					
					if (_noisyVisitor) {
						System.out.println("	-> complSplitDom = " + complSplitDom);
						System.out.println("	-> complEmpty = " + complEmpty);
					}
					
					
					// === LocalDependence: need to outline all blocked indexes
					EList<Variable> nlIndsDepFuncLoc = new BasicEList<Variable>();
					for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
						nlIndsDepFuncLoc.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
					
					JNIISLBasicMap bmapDepFunc = depFunc.getIslMap().copy();
					bmapDepFunc = bmapDepFunc.projectOut(JNIISLDimType.isl_dim_out, 0, depFunc.getDimRHS()/2);
					bmapDepFunc = bmapDepFunc.moveDims(JNIISLDimType.isl_dim_param, bmapDepFunc.getNbDims(JNIISLDimType.isl_dim_param),
							JNIISLDimType.isl_dim_in, 0, _nBlockDim);
					
					JNIISLMap mapDepFunc = bmapDepFunc.toMap();
					for (int k=0; k<mapDepFunc.getNbDims(JNIISLDimType.isl_dim_param); k++)
						mapDepFunc = mapDepFunc.setDimName(JNIISLDimType.isl_dim_param, k, _paramDom.getParams().get(k).getName());
					bmapDepFunc = mapDepFunc.getBasicMaps().get(0);
					
					DomainDimensions domDimsDepFuncLoc = _polyFact.createDomainDimensions(nlIndsDepFuncLoc, _paramDom.getParams());
					
					FastISLMap depFuncLoc = _polyIRFact.createFastISLMap(domDimsDepFuncLoc, bmapDepFunc,
							depFunc.getLabelIn(), depFunc.getLabelOut());
					
					// Getting the local VariableDeclaration
					VariableDeclaration varDeclLoc = _currentTileLocalVariable.get(varExpr.getVarDecl().getName());
					
					// === OutsideDependence: no outline at all + update the input/output information
					if (complEmpty) {			// No split needed (all internal)
						// === STEP 3: Creating the current dependenceExpression & returning it
						DependenceExpression nDepExpr = _polyIRFact.createDependenceExpression(
								depFuncLoc,_polyIRFact.createVariableExpression(varDeclLoc));
						return nDepExpr;
					}
					else {						// Split needed (external AND internal)
						// Getting the input VariableDeclaration
						int nBlockedParam = (_paramDom.getNParams()-_nBlockDim-1)/2;				// reduction => we have the full parameters domain
						int nBlockDimIm = 0;		// Because \alpha_2 might happens at any level of the dependence => not possible to outline this part
						
						long[][] blockedContrib = new long[nBlockDimIm][nBlockedParam+_nBlockDim+1];
						// No over choince that having a 0-row matrix for blockedContrib (no outlining possible for the input of the useEquation)
						
						FastISLDomain contextDomVarExpr = mContextDomainVarExpr.get(varExpr);
						
						// --- Output Domain
						//			=> We remove the blocked parameters and indexes
						JNIISLSet contDomVarExprSetOut = contextDomVarExpr.getIslSet().copy();
						contDomVarExprSetOut = contDomVarExprSetOut.projectOut(JNIISLDimType.isl_dim_set, 0, depFunc.getDimRHS()/2);
						contDomVarExprSetOut = contDomVarExprSetOut.projectOut(JNIISLDimType.isl_dim_param, 0, nBlockedParam);
						
						List<Variable> lParamDomDimsOut = _paramDom.getParams().subList(nBlockedParam,2*nBlockedParam+1);
						List<Variable> lIndDomDimsOut = new BasicEList<Variable>();
						for (int i=0; i<depFunc.getDimRHS()/2; i++)
							lIndDomDimsOut.add(_dimMana.getDimension(i,contextDomVarExpr.getIndices().get(depFunc.getDimRHS()/2+i).getName()));
						DomainDimensions domDimsOut = _polyFact.createDomainDimensions(lIndDomDimsOut, lParamDomDimsOut);
						
						FastISLDomain localOutputDomain = _polyIRFact.createFastISLDomain(domDimsOut, contDomVarExprSetOut);
						
						
						// --- Input Domain
						JNIISLSet contDomVarExprSetIn = contextDomVarExpr.getIslSet().copy();
						contDomVarExprSetIn = contDomVarExprSetIn.moveDims(JNIISLDimType.isl_dim_param, contDomVarExprSetIn.getNbDims(JNIISLDimType.isl_dim_param),
								JNIISLDimType.isl_dim_set, 0, nBlockDimIm);
						for (int i=contextDomVarExpr.getNParams(); i<contDomVarExprSetIn.getNbDims(JNIISLDimType.isl_dim_param); i++)
							contDomVarExprSetIn = contDomVarExprSetIn.setDimName(JNIISLDimType.isl_dim_param, i, _paramDom.getParams().get(i).getName());
						
						EList<Variable> nlIndsContextDomVarExprNParam = new BasicEList<Variable>();
						for (int i=nBlockDimIm; i<contextDomVarExpr.getNIndices(); i++)
							nlIndsContextDomVarExprNParam.add(_dimMana.getDimension(i-nBlockDimIm, contextDomVarExpr.getIndexNames().get(i)));
						DomainDimensions domDimLocDom = _polyFact.createDomainDimensions(nlIndsContextDomVarExprNParam, _paramDom.getParams());
						
						FastISLDomain localInputDomain = _polyIRFact.createFastISLDomain(domDimLocDom, contDomVarExprSetIn);
						
						
						// -- AccessInfo
						accessInformation = Quartet.with(varExpr.getVarDecl().getName(), blockedContrib, localInputDomain, localOutputDomain);
						
						VariableDeclaration varDeclIn = updateInOutputInfo(accessInformation, depFunc.getDimRHS()/2);
						
						// === STEP 3: Creating the current dependenceExpression & returning it
						
						JNIISLBasicMap depFuncbMap = depFunc.getIslMap().copy();
						int nParamDepFuncBMap = depFuncbMap.getNbDims(JNIISLDimType.isl_dim_param);
						depFuncbMap = depFuncbMap.moveDims(JNIISLDimType.isl_dim_param,
								nParamDepFuncBMap, JNIISLDimType.isl_dim_in, 0, _nBlockDim);
						// Rename the variables
						JNIISLMap depFuncMap = depFuncbMap.toMap();
						for (int k=0; k<_nBlockDim; k++)
							depFuncMap = depFuncMap.setDimName(JNIISLDimType.isl_dim_param, nParamDepFuncBMap+k,
									_paramDom.getParams().get(nParamDepFuncBMap+k).getName());
						JNIISLBasicMap depFuncBMapParamAligned = depFuncMap.getBasicMaps().get(0);	// only one by construction
						
						DomainDimensions depFuncInDomDim = _polyFact.createDomainDimensions(nlIndsDepFuncLoc, _paramDom.getParams());
						FastISLMap depFuncIn = _polyIRFact.createFastISLMap(depFuncInDomDim,
								depFuncBMapParamAligned, depFunc.getLabelIn(), depFunc.getLabelOut());
						
						
						// splitDom/complSplitDom are on ALL blocked parameters
						//		=> need to adapt them before using them in the restrict expression
						//		- add local indexes
						//		- remove the outlined block indexes (transform them into parameters + rename OR move them ???)
						
						// TODO TEMP !!!
						FastISLDomain splitDomRestrict = splitDom;
						FastISLDomain complSplitDomRestrict = complSplitDom;
						
						
						
						List<Expression> lExprCase = new BasicEList<Expression>();
						lExprCase.add(_polyIRFact.createRestrictExpression(splitDomRestrict,
								_polyIRFact.createDependenceExpression(depFuncLoc, _polyIRFact.createVariableExpression(varDeclLoc))));
						lExprCase.add(_polyIRFact.createRestrictExpression(complSplitDomRestrict,
								_polyIRFact.createDependenceExpression(depFuncIn, _polyIRFact.createVariableExpression(varDeclIn))));
						return _polyIRFact.createCaseExpression(lExprCase);
					}
					
				} else {	// No Split needed (all external)
					int nBlockedParam = (_paramDom.getNParams()-_nBlockDim-1)/2;	// reduction => we have the full parameters domain
					int nBlockDimIm = 0;		// Because \alpha_2 might happens at any level of the dependence => not possible to outline this part
					// Indexes which are blocked in var: /2 works
					
					long[][] blockedContrib = new long[nBlockDimIm][nBlockedParam+_nBlockDim+1];
							// No lines for blockedContrib (because parametrised by \alpha_2)
					
					FastISLDomain contextDomVarExpr = mContextDomainVarExpr.get(varExpr);	// No need to project
					
					// --- Output domain
					JNIISLSet contDomVarExprSet = contextDomVarExpr.getIslSet().copy();
					contDomVarExprSet = contDomVarExprSet.projectOut(JNIISLDimType.isl_dim_param, 0, nBlockedParam);
					contDomVarExprSet = contDomVarExprSet.projectOut(JNIISLDimType.isl_dim_set, 0, depFunc.getDimRHS()/2);
					
					List<Variable> lIndsOutDom = new BasicEList<Variable>();
					for (int i=depFunc.getDimRHS()/2; i<contextDomVarExpr.getNIndices(); i++)
						lIndsOutDom.add(_dimMana.getDimension(i-(depFunc.getDimRHS()/2), contextDomVarExpr.getIndices().get(i).getName()));
					List<Variable> lParamsOutDom = new BasicEList<Variable>();
					for (int i=0; i<nBlockedParam+1; i++)
						lParamsOutDom.add(_dimMana.getParameter(i, _paramDom.getParams().get(i+nBlockedParam).getName()));
					DomainDimensions domDimOutDomain = _polyFact.createDomainDimensions(lIndsOutDom, lParamsOutDom);
					
					FastISLDomain localOutputDomain = _polyIRFact.createFastISLDomain(domDimOutDomain, contDomVarExprSet);
					
					
					// --- Input domain
					
					// We take the preimage of the context domain by (dep_Bl, Id)
					//JNIISLBasicMap depMap = depFunc.getIslMap().copy();
					
					
					// No need to do that because the full dependence (including the parameters) stays in the program...
					// phi = (iBl, iLoc_Im -> depBl, iLoc_Im)  (the image domain must match the dimensions of contextDomVarExpr)
					/*int nScalOutDimDep = depFunc.getDimRHS()/2;
					depMap = depMap.dropConstraintsInvolvingDims(JNIISLDimType.isl_dim_out, nScalOutDimDep, nScalOutDimDep);
					
					for (int i=0; i<nScalOutDimDep; i++) {
						JNIISLConstraint constr = JNIISLConstraint.buildEquality(depMap.getSpace().copy());
						constr = constr.setCoefficient(JNIISLDimType.isl_dim_out, i+nScalOutDimDep, 1);
						constr = constr.setCoefficient(JNIISLDimType.isl_dim_in, i+depFunc.getNIndices()/2, -1);
						depMap = depMap.addConstraint(constr);
					}
					
					FastISLMap phi = _polyIRFact.createFastISLMap(depFunc.getDomDims(), depMap, depFunc.getLabelIn(), depFunc.getLabelOut());
					FastISLDomain contDomIm = (FastISLDomain) contextDomVarExpr.preimage(phi);
					*/
					
					// Moving the blocked indexes as parameters
					JNIISLSet setContDomIm = contextDomVarExpr.getIslSet().copy();
					setContDomIm = setContDomIm.insertDims(JNIISLDimType.isl_dim_param, setContDomIm.getNbDims(JNIISLDimType.isl_dim_param), _nBlockDim);
					for (int i=contextDomVarExpr.getNParams(); i<setContDomIm.getNbDims(JNIISLDimType.isl_dim_param); i++)
						setContDomIm = setContDomIm.setDimName(JNIISLDimType.isl_dim_param, i, _paramDom.getParams().get(i).getName());
					for (int i=0; i<_nBlockDim; i++)
						setContDomIm = setContDomIm.setDimName(JNIISLDimType.isl_dim_set, i, contextDomVarExpr.getIndices().get(i).getName() + "_");
					
					List<Variable> lIndsInDomain = new BasicEList<Variable>();
					for (int i=0; i<contextDomVarExpr.getNIndices(); i++)
						lIndsInDomain.add(_dimMana.getDimension(i, contextDomVarExpr.getIndices().get(i).getName() + ((i<_nBlockDim)?"_":"")));
					
					DomainDimensions domDimInDomain = _polyFact.createDomainDimensions(lIndsInDomain, _paramDom.getParams());
					FastISLDomain localInputDomain = _polyIRFact.createFastISLDomain(domDimInDomain, setContDomIm);
					
					// --- Access info
					accessInformation = Quartet.with(varExpr.getVarDecl().getName(), blockedContrib, localInputDomain, localOutputDomain);
					
					
					// Building the new dependence function (with new parameters)
					EList<Variable> lnInds = new BasicEList<Variable>();
					for (int i=_nBlockDim; i<depFunc.getNIndices(); i++)
						lnInds.add(_dimMana.getDimension(i-_nBlockDim, depFunc.getIndexNames().get(i)));
					
					Matrix matNDepFunc = matDepFunc;		// Full parameter domain => a simple copy is enough
					
					List<IntExpression> lIntExprDepFunc = matNDepFunc.toFunction(_paramDom.getParams(), lnInds);
					List<AffineExpression> lExprDepFunc = new BasicEList<AffineExpression>();
					for (IntExpression intExpr : lIntExprDepFunc)
						lExprDepFunc.add((AffineExpression) intExpr);
					nDepFunc = _polyIRFact.createFastISLMap(_polyIRFact.createAffineFunction(_paramDom.getParams(), lnInds, lExprDepFunc).getPMmapping());
					
					
					// === STEP 2: Updating the input/output informations using accessInformation
					VariableDeclaration nVarDecl;
					//if (dependenceGoingOutside)
						nVarDecl = updateInOutputInfo(accessInformation, nDimProjOutput);
					//else
					//	nVarDecl = _currentTileLocalVariable.get(varExpr.getVarDecl().getName());
					
					// === STEP 3: Creating the current dependenceExpression & returning it
					return _polyIRFact.createDependenceExpression(nDepFunc, _polyIRFact.createVariableExpression(nVarDecl));
				}
			}
		}
		
		@Override
		public void visitIndexExpression(IndexExpression indExpr) {
			FastISLMap indAffFunc = (FastISLMap) indExpr.getFunction();
			
			EList<Variable> nIndLoc = new BasicEList<Variable>();
			for (int i=0; i<indAffFunc.getNIndices()-_nBlockDim; i++)
				nIndLoc.add(_dimMana.getDimension(i, indAffFunc.getIndexNames().get(i+_nBlockDim)));
			DomainDimensions domDims = _polyFact.createDomainDimensions(nIndLoc, _paramDom.getParams());
			
			int nParamIslMap = indAffFunc.getIslMap().getNbDims(JNIISLDimType.isl_dim_param);
			JNIISLBasicMap nIslbMap = indAffFunc.getIslMap().copy().moveDims(JNIISLDimType.isl_dim_param, nParamIslMap,
					JNIISLDimType.isl_dim_in, 0, _nBlockDim);
			
			// We can reuse the same mapping/matrix. Indeed:
			//	Order of the original matrix: paramBl - paramLoc - b || indBl - indLoc || Const
			//	Order of the matrix we want: paramBl - paramLoc - b - indBlOrig || indBl(if remaining) - indLoc || Const
			
			FastISLMap redIndAffFunc = _polyIRFact.createFastISLMap(domDims, nIslbMap, indAffFunc.getLabelIn(), indAffFunc.getLabelOut());
			_subExprDimRed = _polyIRFact.createIndexExpression(redIndAffFunc);
		}
		
		@Override
		public void outRestrictExpression(RestrictExpression restrExpr) {
			FastISLDomain domRest = (FastISLDomain) restrExpr.getRestrictDomain();
			FastISLDomain nDomRestr = removeBlockedParamIndexes(domRest, domRest.getNIndices()-_nBlockDim, Pair.with(_paramDom, _isThereIndexExpression));
			
			_subExprDimRed = _polyIRFact.createRestrictExpression(nDomRestr, _subExprDimRed);
		}
		
		@Override
		public void outReduceExpression(ReduceExpression redExpr) {
			FastISLMap projFunc = (FastISLMap) redExpr.getProjection();
			
			// We need to remove the _nBlockDim first dims of projFunc
			JNIISLBasicMap nIslbMap = projFunc.getIslMap().copy().projectOut(JNIISLDimType.isl_dim_out, 0, _nBlockDim);
			nIslbMap = nIslbMap.moveDims(JNIISLDimType.isl_dim_param, projFunc.getNParams(), JNIISLDimType.isl_dim_in, 0, _nBlockDim);
			
			JNIISLMap nIslMap = nIslbMap.toMap();
			for (int i=projFunc.getNParams(); i<nIslMap.getNbDims(JNIISLDimType.isl_dim_param); i++)
				nIslMap = nIslMap.setDimName(JNIISLDimType.isl_dim_param, i, _paramDom.getParams().get(i).getName());
			
			List<Variable> lInds = new BasicEList<Variable>();
			lInds.addAll(projFunc.getIndices().subList(_nBlockDim, projFunc.getNIndices()));
			DomainDimensions domDims = _polyFact.createDomainDimensions(lInds, _paramDom.getParams());
			
			FastISLMap nProjFunc = _polyIRFact.createFastISLMap(domDims, nIslMap.getBasicMapAt(0), projFunc.getLabelIn(), projFunc.getLabelOut());
			
			_subExprDimRed = _polyIRFact.createReduceExpression(redExpr.getOP(), nProjFunc, _subExprDimRed);
		}
		
		// ==== Other cases : copy to build _subExprDimRed
		@Override
		public void visitCaseExpression(CaseExpression cExpr) {
			List<Expression> lExpr = new BasicEList<Expression>();
			for (Expression sExpr : cExpr.getExprs()) {
				sExpr.accept(this);
				lExpr.add(_subExprDimRed);
			}
			_subExprDimRed = _polyIRFact.createCaseExpression(lExpr);
		}
		
		@Override
		public void visitIfExpression(IfExpression iExpr) {
			iExpr.getCond().accept(this);
			Expression exprCond = _subExprDimRed;
			iExpr.getThen().accept(this);
			Expression exprThen = _subExprDimRed;
			iExpr.getElse().accept(this);
			Expression exprElse = _subExprDimRed;
			_subExprDimRed = _polyIRFact.createIfExpression(exprCond, exprThen, exprElse);
		}
		
		@Override
		public void outUnaryExpression(UnaryExpression uExpr) {
			_subExprDimRed = _polyIRFact.createUnaryExpression(uExpr.getOperator(), _subExprDimRed);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression bExpr) {
			bExpr.getLexp().accept(this);
			Expression lExpr = _subExprDimRed;
			bExpr.getRexp().accept(this);
			Expression rExpr = _subExprDimRed;
			_subExprDimRed = _polyIRFact.createBinaryExpression(bExpr.getOperator(), lExpr, rExpr);
		}
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression mExpr) {
			List<Expression> lExpr = new BasicEList<Expression>();
			for (Expression expr : mExpr.getExprs()) {
				expr.accept(this);
				lExpr.add(_subExprDimRed);
			}
			_subExprDimRed = _polyIRFact.createMultiArgExpression(mExpr.getOperator(), lExpr);
		}
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall eExpr) {
			List<Expression> lExpr = new BasicEList<Expression>();
			for (Expression expr : eExpr.getExprs()) {
				expr.accept(this);
				lExpr.add(_subExprDimRed);
			}
			_subExprDimRed = _polyIRFact.createExternalFunctionCall(eExpr.getExFunc(), lExpr);
		}
		
		
	} // OutliningParametricTilingVisitor
	
	
} // ParametricTilingOutlining
