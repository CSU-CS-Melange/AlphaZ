package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.VariableComparator;
import org.polymodel.prdg.PRDGNode;

/**
 * This class implements algorithms to extract State Vector Update form
 * for representing recurrences. The SVU-form (proposed by Kogge and Stone,
 * and then used for scan detection by Yun, with extensions to semi-rings)
 * represents recurrence equations as a pair of vector and matrix.
 * 
 * The vector represents recurrence variables; variables where a new value
 * is computed as a function of its previous values. The matrix represents
 * the "function" used to compute the new value of the recurrence variables.
 * 
 * For example, a recurrence equation
 *   x[i] = x[i-1] + 0.5*x[i-2] + A[i]
 * is represented as the following.
 * 
 * vector v: (x[i-1], x[i-2], 1)
 * matrix M: 1  0.5 A[i]
 *           1  0   0
 *           0  0   1
 * The matrix may contain arbitrary expression involving other variables.
 *         
 * The "new" vector, (x[i], x[i-1], 1),
 * is computed as:
 *   v' = M.v
 * which corresponds to the following system
 *   x[i]   = x[i-1] + x[i-2] + A[i]
 *   x[i-1] = x[i-1]
 *        1 = 1
 * 
 * In a recurrence with one recurrence variable, the update function is 
 * essentially represented in the first row of the matrix. Other rows are
 * there to give the matrix vector product view of the computation.
 *      
 * @see P. M. Kogge and H. S. Stone, "A parallel algorithm for the efficient solution of a general class of recurrence", 1973
 * @see Y. Zou and S. Rajopadhye, "Scan detection and parallelization in "inherently sequential" nested loop programs", 2012
 * 
 * @author tyuki
 *
 */
public class MatrixFormTransformation {

	public static boolean DEBUG = false;
	
	private static void debug(Object content) {
		if (DEBUG)
			System.out.println("[MatrixForm] " + content);
	}

	private AffineSystem system;
	private StateVectorUpdateForm scan;
	protected List<VariableDeclaration> sccNodes;
	
	protected MatrixFormTransformation(AffineSystem s, List<PRDGNode> scc, Domain scanDomain){
		scan = new StateVectorUpdateForm();
		scan.scanDomain = scanDomain;
		system = s;

		
		sccNodes = new ArrayList<VariableDeclaration>(scc.size());

		//Initialize basic info
		for (PRDGNode node : scc) {
			sccNodes.add(s.getVariableDeclaration(node.getName()));
		}
	}
	
	/**
	 * Attempts to extract SVU-form corresponding to the recurrence in the given SCC.
	 * Main entry point for the analysis.
	 * 
	 * @param system
	 * @param scc
	 * @param scanDomain
	 * @return null if not successful
	 */
	public static StateVectorUpdateForm extract(AffineSystem system, List<PRDGNode> scc, Domain scanDomain) {
		MatrixFormTransformation mft = new MatrixFormTransformation(system, scc, scanDomain);
		return mft.performExtraction();
	}
	
	/**
	 * Main function calling sequence of methods to perform the analysis.
	 * 
	 * @return
	 */
	private StateVectorUpdateForm performExtraction() {		
		//fails if consistent semiring and scan direction were not found
		if (!extractRecurrenceVariables())
			return null;
		
		scan.constructUpdateVector();
		
		if (DEBUG) {
			StringBuffer recVars = new StringBuffer();
			for (RecurrenceVariable var : scan.recurrenceVariables) {
				if (recVars.length() > 0)
					recVars.append(", ");
				recVars.append(var.toString());
			}
			
			debug("Identified a scan");
			debug("   semiring : " + scan.semiring);
			debug("   direction: " + scan.scanDirection);
			debug("   rec. vars: " + recVars);
		}

		//Support for lex scan not ported
//		lexScan();
		
		extractCoefficientMatrix();
		extractInitializations();
		
		return scan;
		
	}
	
	/**
	 * Visits the "main" branch of equations that define nodes within the given SCC and collects
	 * recurrence variables.
	 * 
	 * @return
	 */
	private boolean extractRecurrenceVariables() {
		Map<VariableDeclaration, RecurrenceVariable> varToRecVar = new TreeMap<>(VariableComparator.INSTANCE);
		
		scan.recurrenceVariables = new LinkedList<RecurrenceVariable>();
		
		Set<Semiring> semirings = new TreeSet<Semiring>(SemiringComparator.INSTANCE);
		List<Long> scanDirection = null;
	
		for (VariableDeclaration var : sccNodes) {
			CaseExpression varExpr;
			//assertion check
			{
				StandardEquation eq = system.getEquation(var.getName());
				if (!(eq.getExpression() instanceof CaseExpression)){
					throw new RuntimeException("[MatrixForm] Top-level expressions of scan variables must be CaseExpression.");
				}
				varExpr = (CaseExpression)eq.getExpression();
			}

			Expression mainBranch = null;
			for (Expression expr : varExpr.getExprs()){
				if (!expr.getContextDomain().intersection(scan.scanDomain).isEmpty()){
					mainBranch = expr;
					break;
				}
			}

			//not sure if not finding mainBranch is an expected behavior
			//FIXME
			if (mainBranch == null)
				continue;
			
			//extract the dependence functions from the current branch
			debug("Checking Branch of " + var.getName() + ": " + PolyhedralIRToAlphabets.toSimplifiedString(mainBranch));
			
			ReccurenceVariableUsageCollector collector = new ReccurenceVariableUsageCollector();
			mainBranch.accept(collector);
			Semiring semiring = collector.findSemiring();
			if (semiring == null) {
				debug("Extraction failed: valid semiring was not found)");
				return false;
			}
			semirings.add(semiring);

			
			for (Entry<VariableExpression, AffineFunction> usage : collector.usages.entrySet()) {
				AffineFunction dep = usage.getValue();
				if (!dep.isUniform()) {
					debug("Extraction failed: not all dependences were uniform");
					return false;
				}
				Pair<List<Long>, Long> pVec = ScanUtilities.getPrimitiveVector(ScanUtilities.getDepVector(dep));
				VariableDeclaration recVar = usage.getKey().getVarDecl();
				if (!varToRecVar.containsKey(recVar)) {
					RecurrenceVariable rVar = new RecurrenceVariable(recVar);
					varToRecVar.put(recVar, rVar);
					scan.recurrenceVariables.add(rVar);
				}
				varToRecVar.get(recVar).addUsage(var, pVec.getValue(), mainBranch);
				
				//check primitive vector
				if (scanDirection == null) {
					scanDirection = pVec.getKey();
				} else {
					if (!ScanUtilities.isEquivalent(scanDirection, pVec.getKey())) {
						debug("Extraction failed: not all recurrences share the same primitive vector");
						return false;
					}
				}
			} 
		}
		
		if (sccNodes.size() > 1)
			debug("Verifying consistency among scan variables");
		
		if (semirings.size() > 1) {
			debug("Extraction failed: not all scan variables share the same semiring");
			return false;
		}
		
		scan.semiring = semirings.iterator().next();
		scan.scanDirection = scanDirection;
		
		Collections.sort(scan.recurrenceVariables, RecurrenceVariableComparator.INSTANCE);
		
		return true;
		
		
	}

	/**
	 * Extracts the coefficient matrix for the main scan.
	 * The coefficient matrix is an (N+1)x(N+1) matrix where N is the sum of 
	 * max distances of all scan variables. (+1 is for constant field)
	 * 
	 *  
	 * @see computeMaxDistancePerScanVariable
	 * 
	 * @return
	 */
	private List<List<Expression>> extractCoefficientMatrix() {
		List<List<Expression>> matrix = new LinkedList<List<Expression>>();
		
		final int N;
		{
			int tempN = 0;
			for (RecurrenceVariable recVar : scan.recurrenceVariables) {
				tempN += recVar.getMaxGCD();
			}
			N = tempN;
		}
		
		//Extract the coefficient for each variable
		for (RecurrenceVariable lhsVar : scan.recurrenceVariables) {
//			BranchInfo currentBranch = varToBranch.get(lhsVar);
			
			debug("Computing coefficients for variable: " + lhsVar.getName());
			
			List<Expression> coefVector = new ArrayList<Expression>(N+1);
			
			for (RecurrenceVariable rhsVar : scan.recurrenceVariables) {
				long max_gcd = rhsVar.getMaxGCD();
				for(long k = 1; k <= max_gcd; k++){
					Expression useExpr = rhsVar.getUseExpression(lhsVar.variable);
					if (useExpr != null) {
						AffineFunction recurrence = ScanUtilities.retrieveDependence(scan.scanDomain, scan.scanDirection, -k);
						debug(" coefficient for reccurence " + rhsVar.getName() + recurrence + " [gcd " + k + "]: ");
						Expression expr = CoefficientExtractor.extractVariableCoefficient(useExpr, rhsVar.variable, recurrence, sccNodes, scan.semiring);
						coefVector.add(expr);
						debug("   " + PolyhedralIRToAlphabets.toSimplifiedString(expr));
					} else {
						IntegerExpression zeroExpr = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						coefVector.add(zeroExpr);
						debug("   coefficient for gcd " + k + ": " + PolyhedralIRToAlphabets.toSimplifiedString(zeroExpr));
					}
				}
			}

			Expression constantCoef = CoefficientExtractor.extractConstantCoefficient(lhsVar.getUseExpression(lhsVar.variable), sccNodes, scan.semiring);
			coefVector.add(constantCoef);
			debug("   coefficient for constant: "+ PolyhedralIRToAlphabets.toSimplifiedString(constantCoef));
			matrix.add(coefVector);

			//construct the rows to shift the other values 
			for(int k = 1; k < lhsVar.getMaxGCD(); k++){
				int pos = matrix.size();
				List<Expression> shiftVector = new ArrayList<Expression>(N+1);
				//all the coefficient are set to 0 expression except the current position variable
				for(int j = 1; j <= N+1; j++){
					if(j != pos){
						IntegerExpression expr = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						shiftVector.add(expr);
					}else{
						IntegerExpression expr = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
						shiftVector.add(expr);
					}
				}
				matrix.add(shiftVector);
			}	
		}
		
		//create coefficient for the last constant row
		//all the coefficients are 0 except the last element
		{
			List<Expression> shiftVector = new ArrayList<Expression>(N+1);
			for(int i = 0; i < N; i++){
				IntegerExpression expr = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
				shiftVector.add(expr);
			}
			IntegerExpression expr = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
			shiftVector.add(expr);
			matrix.add(shiftVector);
		}
		
		scan.coefMatrix = matrix;
		
		return matrix;
		
	}
	
	private void extractInitializations() {
		for (RecurrenceVariable var : scan.recurrenceVariables) {
			Expression mainBranch = var.getUseExpression(var.variable);
			CaseExpression parentCaseExpr = (CaseExpression)mainBranch.eContainer();

			var.initializations = new ArrayList<>(parentCaseExpr.getExprs().size()-1); 
					
			for (Expression expr : parentCaseExpr.getExprs()) {
				if (expr.equals(mainBranch)) continue;
				
				Expression mainExpr = expr;
				while (mainExpr instanceof RestrictExpression) {
					mainExpr = ((RestrictExpression)mainExpr).getExpr();
				}
				
				var.initializations.add(new Pair<>(expr.getContextDomain().copy(), mainExpr));
			}
		}
	}
	

	/**
	 * Get the initialization domain for the main scan for one variable
	 * @param cur_scan_domain
	 * @param mainDir
	 * @param max_distance
	 * @return
	 */
	private static Domain getVariableInitDomain(Domain cur_scan_domain, List<Long> mainDir, Long max_distance){
		//construct the dependence function with max distance
		List<Long> dep = new Vector<Long>();
		for(int i = 0; i < mainDir.size(); i++){
			dep.add(mainDir.get(i)*max_distance);
		}
		
		//create affine function z->z+max_distance*mainDir
		AffineFunction dep_func = PolyhedralIRUtility.createUniformFunction(cur_scan_domain, dep);
		
		Domain init_domain = cur_scan_domain.image(dep_func).difference(cur_scan_domain);
		
		return init_domain;
		
	}	
	
	
	private void lexScan() {
		Domain lexScanDom = scan.scanDomain.copy();
		
		if (sccNodes.size() > 1) {
			System.err.println("Lex. Scan detection for multi-node SCC is not implemented.");
			return;
		}
		
		RecurrenceVariable var = scan.recurrenceVariables.get(0);
		
		//detect the lexiscan information
		Domain initial_domain = getVariableInitDomain(scan.scanDomain, scan.scanDirection, var.getMaxGCD());
		Domain current_scan_domain = scan.scanDomain.copy();
		
		boolean newDirExtracted = true;
		
		List<RecurrenceVariable> cur_target_list = new LinkedList<>();
		cur_target_list.add(var);
		
		//merge the branch with the detected branch unit no more branch can be merged
//		while(newDirExtracted){
////			List<BranchInfo> branch_for_merge = extractMergedBranches(s, directions, current_scan_domain,  initial_domain, var, varMaxDistanceMap.get(var), ori_varExpMap.get(var), current_serm);
//			if(branch_for_merge.size() > 0){
//				newDirExtracted = true;
//			}else{
//				newDirExtracted = false;
//			}
//			
//			directions.add(getCommonDirection(branch_for_merge));
//			//construct Matrix Information for each branch
//			for(int i = 0; i < branch_for_merge.size(); i++){
//				Expression[][] current_branch_matrix = constructInitCoefficientMatrix(var,  varMaxDistanceMap.get(var),branch_for_merge.get(i));
//				info.addCoefficientMatrix(branch_for_merge.get(i).exp.getContextDomain().copy(), current_branch_matrix);
//				info.addSize(current_branch_matrix.length);
//			}
//			
//			//construct the new scan domain and initialization domain
//			for(int i = 0; i < branch_for_merge.size(); i++){
//				current_scan_domain = current_scan_domain.union(branch_for_merge.get(i).exp.getContextDomain().copy());
//				initial_domain = initial_domain.difference(branch_for_merge.get(i).exp.getContextDomain().copy());
//			}
//		}
//		
//		scan_dom = current_scan_domain.copy();
	}

//	/**
//	 * Get the initialization domain for the main scan for one variable
//	 * @param cur_scan_domain
//	 * @param mainDir
//	 * @param max_distance
//	 * @return
//	 */
//	private Domain getVariableInitDomain(){
//		List<Long> mainDir = scan.getMainDirection();
//		long maxDistance;
//		
//		//construct the dependence function with max distance
//		List<Long> dep = new Vector<Long>();
//		for(int i = 0; i < mainDir.size(); i++){
//			dep.add(mainDir.get(i)*max_distance);
//		}
//		
//		//create affine function z->z+max_distance*mainDir
//		AffineFunction dep_func = PolyhedralIRUtility.createUniformFunction(cur_scan_domain, dep);
//		
//		Domain init_domain = cur_scan_domain.image(dep_func).difference(cur_scan_domain);
//		
//		return init_domain;
//		
//	}	
	
	
	/**
	 * 
	 * Similar to the BranchInfo collection method in the old implementation.
	 * The purpose of branch info was to keep track of the dependences and branches
	 * of cases using recurrence variables. This class substitutes
	 * the old implementation with following changes:
	 *  - Various info regarding the usages of recurrence variables are now stored
	 *  within RecurrenceVariable instances. The old implementation used a number
	 *  of maps to store the same level of information, the new implementation encapsulates
	 *  them within a class.
	 *  - Semiring detection is redesigned completely  
	 * 
	 * @author tyuki
	 *
	 */
	protected class ReccurenceVariableUsageCollector extends PolyhedralIRInheritedDepthFirstVisitorImpl {
		
		protected Stack<Expression> operators = new Stack<Expression>();
		protected Map<VariableExpression, AffineFunction> usages = new HashMap<>();
		protected Map<Expression, Integer> recVarOperandCountPerBranch = new HashMap<>();
		
		private Set<OP> otimesCandidates = new HashSet<>();
		private Set<OP> oplusCandidates  = new HashSet<>();
		
		public ReccurenceVariableUsageCollector() {
		}
		
		@Override
		public void inVariableExpression(VariableExpression v) {
			//assumes normalized program
			if (sccNodes.contains(v.getVarDecl())){
				//Collect dependences and semiring
				AffineFunction dep;
				{
					Expression parentExpr = (Expression)v.eContainer();
					if (parentExpr instanceof DependenceExpression){
						dep = ((DependenceExpression) parentExpr).getDep().copy();
					} else {
						dep = PolyhedralIRUtility.createIdentityFunction(parentExpr.getExpressionDomain().copy());
					}
					
				}
				
				usages.put(v, dep);
				
				for (Expression op : operators) {
					recVarOperandCountPerBranch.put(op, 1 + recVarOperandCountPerBranch.get(op));
				}
			}
		}
		
		protected Semiring findSemiring() {
			debug("oplus  Candidates: " + oplusCandidates);
			debug("otimes Candidates: " + otimesCandidates);
			
			if (otimesCandidates.size() > 1 || oplusCandidates.size() > 1)
				return null;
			
			//otimes = operation between recurrence and non-recurrence 
			//oplus  = operation between recurrence variables
			OP otimes = null;
			OP oplus = null;
			
			if (otimesCandidates.size() > 0) {
				otimes = otimesCandidates.iterator().next();
			}
			
			if (oplusCandidates.size() > 0) { 
				oplus = oplusCandidates.iterator().next();
			}
			
			return Semiring.findPossibleSemiring(oplus, otimes);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression b) {
			operators.push(b);
			
			recVarOperandCountPerBranch.put(b, 0);
			b.getLexp().accept(this);
			int lcount = recVarOperandCountPerBranch.get(b);
			
			recVarOperandCountPerBranch.put(b, 0);
			b.getRexp().accept(this);
			int rcount = recVarOperandCountPerBranch.get(b);
			

			debug("======================================");
			debug("  " + PolyhedralIRToAlphabets.toSimplifiedString(b));
			debug("  reccurence var count: " + lcount + " " + rcount);
			
			if (lcount > 0 && rcount > 0) {
				oplusCandidates.add(b.getOperator());
			}
			if (lcount + rcount == 1) {
				otimesCandidates.add(b.getOperator());
			}
			
			operators.pop();
		}
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression m) {
			operators.push(m);
			
			List<Integer> counts = new ArrayList<Integer>(m.getExprs().size());
			
			for (Expression expr : m.getExprs()) {
				recVarOperandCountPerBranch.put(m, 0);
				expr.accept(this);
				counts.add(recVarOperandCountPerBranch.get(m));
			}
			
			int sum = 0;
			for (int c : counts) {
				if (c> 0) {
					sum++;
				}
			}
			
			if (sum == 1) {
				otimesCandidates.add(m.getOperator());
			}

			//failure case
			if (sum > 1) {
				otimesCandidates.add(m.getOperator());
				oplusCandidates.add(m.getOperator());
			}
			
			
			operators.pop();
		}

		//Check to make catch unwanted expressions
		@Override
		public void inExpression(Expression e) {
			throw new RuntimeException("Unhandled: " + e);
		}
		@Override
		public void inRestrictExpression(RestrictExpression r) {}
		@Override
		public void inDependenceExpression(DependenceExpression d) {}
		@Override
		public void inConstantExpression(ConstantExpression c) {}
		
	}

	/*
	 * Detection of lexicographical scan along some directions
	 * Merge the initial branch with the detected branch
	 */
//	private void lexScan() {
//		//only supports multi-dimensional scan over one variable
//		if (scan.scanVariables.size() > 1) return;
//
//		VariableDeclaration var = scan.scanVariables.get(0);
//		BranchInfo branch = varToBranch.get(var);
//		CaseExpression cur_case = (CaseExpression)varToExpression.get(var);
//		List<Expression> branches = cur_case.getExprs();
//		List<List<Long>> directions = new LinkedList<List<Long>>();
//		Domain domain = scan.scanDomain.copy();
		
//		//get the basic inner most direction
//		AffineFunction baseFunction = branch.varFuncGcdMap.get(var).get(1L);
//		List<Long> vec = ScanUtilities.getDepVector(baseFunction);
//		directions.add(vec);
//		
//		long max_gcd = branch.varMaxGcdMap.get(var);
//		int dim = domain.getDim();
//
//		for(int i = 1; i < dim; i++){
//			for(int j = 0; j < max_gcd; j++){
//				//get the init domain now
//				Domain init_dom = domain.image(baseFunction).difference(domain);
//				domain = domain.union(init_dom);
//				debug("Current Initial Domain:" + init_dom);
//				
//				boolean modified = true;
//				while(modified){
//					modified = false;
//					List<Expression> merged_branches = new LinkedList<Expression>();
//					for(Expression exp : branches){
//						if(!exp.getContextDomain().intersection(init_dom).isEmpty()){
//							
//							BranchInfoCollector collector = new BranchInfoCollector(exp);
//							
//							//test the branch
//							exp.accept(collector);
//							
//							debug("Init branch: " + PolyhedralIRToAlphabets.toSimplifiedString(exp));
//							debug("Recurrence times for init branch:" + collector.count);
//							
//							if(collector.count == 0){
//								continue;
//							}
//
//							//check the semiring
//							if (!collector.hasUniqueSemiring()) {
//								debug("Extraction failed: semirings found were not unique (or semirings were not found)");
//								return;
//							}
//							
//							semiring = collector.semirings.iterator().next();
//							
//							
//							Set<AffineFunction> function_list = collector.varToFunction.get(var);
//							//separate the uniform function and non uniform functions
//							List<AffineFunction> uniform_list = new LinkedList<AffineFunction>();
//							List<AffineFunction> affine_list = new LinkedList<AffineFunction>();
//							
//							for(AffineFunction af : function_list){
//								if(af.isUniform()){
//									uniform_list.add(af.copy());
//								}else{
//									affine_list.add(af.copy());
//								}
//							}
//							
//							//the affine function list
//							debug("AffineList for init branch: " + PolyhedralIRToAlphabets.toSimplifiedString(exp));
//							debug(function_list);
//							
//							//check is all the uniform dependence has the same direction as the inner most direction
//							for(AffineFunction af : uniform_list){
//								//System.out.println("Test for function: " + af);
//								List<Long> depVec = ScanUtilities.getDepVector(af);
//								
//								long gcd_tmp = ScanUtilities.getGCD(depVec);
//								
//								List<Long> baseDep = new Vector<Long>();
//								//get the basic dependence vector
//								for(int k = 0; k < depVec.size(); k++){
//									baseDep.add(depVec.get(k)/gcd_tmp);
//								}
//								
//								//System.out.println("vec: " + vec.toString());
//								//System.out.println("baseDep:" + baseDep.toString());
//								if(!vec.equals(baseDep)){
//									validate = false;
//									break;
//								}
//							}
//							
//							//not one the same direction
//							if(!validate){
//								continue;
//							}
//							
//							//check is all the non-uniform dependece can be used to extract the same direction
//							List<Long> newVec = null;
//							List<Long> dimVec = null;
//							boolean newDirExtraction = true;
//							//find basic vector
//							AffineFunction af_first = affine_list.get(0);
//							List<List<Long>> tmp_directions = new LinkedList<List<Long>>();
//							for(int k = 0; k < directions.size(); k++){
//								tmp_directions.add(directions.get(k));
//								List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af_first, tmp_directions);
//								if(newDirect != null){
//									newVec = newDirect;
//									if(k < directions.size() - 1){
//										dimVec = directions.get(k+1);
//										newDirExtraction = false;
//									}
//									if(!newDirExtraction){
//										if(!newVec.equals(dimVec)){
//											System.out.println("NewDirection extraction failed!");
//											validate = false;
//										}
//									}
//									
//									break;
//								}
//							}
//							
//							if(!validate){
//								continue;
//							}
//							
//							if(newVec == null){
//								validate = false;
//								continue;
//							}
//							
//							for(int k = 1; k < affine_list.size(); k++){
//								AffineFunction af = affine_list.get(k);
//								List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af, tmp_directions);
//								if(newDirect == null){
//									System.out.println("New Direction extraction failed!!");
//									validate = false;
//									break;
//								}else{
//									if(!newVec.equals(newDirect)){
//										System.out.println("New Direction extraction failed!");
//										validate = false;
//										break;
//									}
//								}
//							}
//							
//							
//							if(validate){	//start extraction new matrix
//								modified = true;
//								if(newDirExtraction){
//									directions.add(newVec);
//								}
//								debug("new direction extracted: " + newVec.toString());
//								merged_branches.add(exp);
//								for(AffineFunction depFunc : function_list){
//									Expression e_tmp = exp.copy();
//									//System.out.println("The mapping for the affine function is " + cur_GcdFuncMap.get(k).getPMmapping());
//									//AffineFunction cur_af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_GcdFuncMap.get(k).getPMmapping());
//									//System.out.println("The affine function now is " + cur_GcdFuncMap.get(cur_af));
//									Expression exp_tmp = ExtractVarCoe(e_tmp, var, depFunc, semiring, scan.scanVariables);
//									//coeVec.add(exp_tmp);
//									debug("Coef for variable " + var.getName() +  " recurrence function: " + depFunc + " is " + PolyhedralIRToAlphabets.toSimplifiedString(exp_tmp));
//								}
//							}
//						}
//					}
//					
//					for(Expression exp : merged_branches){
//						scanDomain = scanDomain.union(exp.getContextDomain());
//						branches.remove(exp);
//					}
//				}
//			}
//		}
//	}
	
//	private List<Long> DirectionExtraction(AffineSystem s, Domain domain, Domain init_dom, List<AffineFunction> function_list, List<Long> baseDirec, List<List<Long>> directions){
//		//seperate the uniform function and non uniform functions
//		List<AffineFunction> uniform_list = new LinkedList<AffineFunction>();
//		List<AffineFunction> affine_list = new LinkedList<AffineFunction>();
//		
//		for(AffineFunction af : function_list){
//			if(af.isUniform()){
//				uniform_list.add(af.copy());
//			}else{
//				affine_list.add(af.copy());
//			}
//		}
//		
//		debug("check the list of affine function");
//		debug(function_list);
//		
//		
//		//check is all the uniform dependence has the same direction as the inner most direction
//		for(AffineFunction af : uniform_list){
//			//System.out.println("Test for function: " + af);
//			List<Long> depVec = ScanUtilities.getDepVector(af);
//			
//			long gcd_tmp = ScanUtilities.getGCD(depVec);
//			
//			List<Long> baseDep = new Vector<Long>();
//			//get the basic dependence vector
//			for(int k = 0; k < depVec.size(); k++){
//				baseDep.add(depVec.get(k)/gcd_tmp);
//			}
//			
//			//System.out.println("vec: " + vec.toString());
//			//System.out.println("baseDep:" + baseDep.toString());
//			if(!baseDirec.equals(baseDep)){
//				return null;
//			}
//		}
//		
//		//check is all the non-uniform dependece can be used to extract the same direction
//		List<Long> newVec = null;
//		List<Long> dimVec = null;
//		boolean newDirExtraction = true;
//		//find basic vector
//		AffineFunction af_first = affine_list.get(0);
//		List<List<Long>> tmp_directions = new LinkedList<List<Long>>();
//		for(int k = 0; k < directions.size(); k++){
//			tmp_directions.add(directions.get(k));
//			List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af_first, tmp_directions);
//			if(newDirect != null){
//				newVec = newDirect;
//				if(k < directions.size() - 1){
//					dimVec = directions.get(k+1);
//					newDirExtraction = false;
//				}
//				if(!newDirExtraction){
//					if(!newVec.equals(dimVec)){
//						return null;
//					}
//				}
//			}
//		}
//		
//		if(newVec == null){
//			return null;
//		}
//		
//		for(int k = 1; k < affine_list.size(); k++){
//			AffineFunction af = affine_list.get(k);
//			List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af, tmp_directions);
//			if(newDirect == null){
//				System.out.println("New Direction extraction failed!!");
//				return null;
//			}else{
//				if(!newVec.equals(newDirect)){
//					System.out.println("New Direction extraction failed!");
//					return null;
//				}
//			}
//		}
//		
//		return newVec;
//	}
//	
//	private List<Long> NewDirectionExtraction(ParameterDomain param_dom, Domain scan_dom, Domain init_dom, AffineFunction dep, List<List<Long>> directions){
//		Domain paramDom = extendedDomainWithAffineFunction(param_dom, init_dom, scan_dom, dep);
//		
//		int nIndices = scan_dom.getNIndices();
//		//construct the empty domain for u and v
//		String dom_str = "{";
//		for(int i = 0; i < directions.size(); i++){
//			dom_str += "u" + i + ",";
//		}
//		//the new indices
//		for(int i = 0; i < nIndices; i++){
//			dom_str += "i"+i + ",";
//		}
//		for(int i = 0; i < nIndices-1; i++){
//			dom_str += "v" + i + ",";
//		}
//		dom_str += "v" + (nIndices-1) + "|}";
//
//		debug("The original init domain:" + init_dom);
//		debug("The original scan domain:" + scan_dom);
//		debug("The new parameter domain:" + paramDom);
//		debug("The directions:" + directions.toString());
//
//		//create the empty domain
//		Domain empty_domain = PolyhedralIRUtility.parseDomain(param_dom, dom_str);
//		debug("Empty domain: " + empty_domain);
//
//		//extends the domain
//		Domain extendedDomain = DomainOperations.extendParameterDomain(empty_domain, paramDom);
//		debug("The extended Domain:" + extendedDomain);
//		
//		//get different index num
//		int nParams = param_dom.getNParams();
//		int nInitIndices = init_dom.getNIndices();
//		int nScanIndices = scan_dom.getNIndices();
//		int nMu = directions.size();
//		int nNewIndices = nInitIndices;
//		int nDirectionDim = nInitIndices;
//		
//		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
//		
//		
//		//add the original constraint and the constraint for u
//		List<Matrix> oriMatrices = extendedDomain.getPMdomain().toMatrices();
//		for(Matrix mat : oriMatrices){
//			for(MatrixRow row : mat.getRows()){
//				//add the original constraint
//				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
//			}
//		}
//		
//		debug("The original constraint");
//		debug(constraints);
//		
//		//get the basic matrix row
//		MatrixRow basicRow = extendedDomain.getPMdomain().toMatrices().get(0).getRows().get(0);
//		
//		//add constraints for the min
//		List<Matrix> matrices = scan_dom.getPMdomain().toMatrices();
//		for(Matrix mat : matrices){
//			for(MatrixRow matrow : mat.getRows()){
//				MatrixRow row = EcoreUtil.copy(basicRow);
//				int basic = 0;
//				int oriBasic = 0;
//				row.set(basic, matrow.get(oriBasic));
//				basic += 1;
//				oriBasic += 1;
//				//set the param
//				for(int j = 0; j < nParams; j++){
//					row.set(basic+j, matrow.get(oriBasic+j));
//				}
//				basic += nParams;
//				oriBasic += nParams;
//				//set the i_p
//				for(int j = 0; j < nInitIndices; j++){
//					row.set(basic+j, 0);
//				}
//				basic += nInitIndices;
//				//set the i_t_p and u
//				for(int j = 0; j < nScanIndices+nMu; j++){
//					row.set(basic+j, 0);
//				}
//				for(int j = 0; j < nScanIndices; j++){
//					long coef = matrow.get(oriBasic+j);
//					if(coef != 0){
//						row.set(basic + j, coef);
//						for(int k = 0; k < nMu; k++){
//							long cur_coef = row.get(basic+nScanIndices+k);
//							cur_coef -= coef*directions.get(k).get(j);
//							row.set(basic+nScanIndices+k, cur_coef);
//						}
//					}
//				}
//				oriBasic += nScanIndices;
//				basic += (nScanIndices + nMu);
//				//set new indices and v
//				for(int j = 0; j < nNewIndices +nDirectionDim; j++){
//					row.set(basic + j, 0);
//				}
//				basic += nNewIndices + nDirectionDim;
//				//set the constant coef
//				row.set(basic, matrow.get(oriBasic));
//				
//				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
//			}
//		}
//		
//		debug("Constrains after add constraints for min");
//		debug(constraints);
//
//		//add constraints for the new indices
//		for(int i = 0; i < nNewIndices; i++){
//			MatrixRow row = EcoreUtil.copy(basicRow);
//			//set the equality
//			int basic = 0;
//			row.set(basic, 0);
//			basic += 1;
//			//set the parameters
//			for(int j = 0; j < nParams; j++){
//				row.set(basic+j, 0);
//			}
//			basic += nParams;
//			//set the init indices as 0
//			for(int j = 0; j < nInitIndices; j++){
//				row.set(basic + j, 0);
//			}
//			basic += nInitIndices;
//			//set the scan indices
//			for(int j = 0; j < nScanIndices; j++){
//				if(i == j){
//					row.set(basic+j, 1);
//				}else{
//					row.set(basic+j, 0);
//				}
//			}
//			basic += nScanIndices;
//			//set the u indices
//			for(int j = 0; j < nMu; j++){
//				row.set(basic+j, -directions.get(j).get(i));
//			}
//			basic += nMu;
//			//set the new indices
//			for(int j = 0; j < nNewIndices; j++){
//				if(i == j){
//					row.set(basic+j, -1);
//				}else{
//					row.set(0, 0);
//				}
//			}
//			basic += nNewIndices;
//			//set the v indices
//			for(int j = 0; j < nDirectionDim; j++){
//				row.set(basic + j, 0);
//			}
//			basic += nDirectionDim;
//			//set the constant
//			row.set(basic, 0);
//			
//			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
//		}
//		
//		debug("Constraints after add constraints for new indices");
//		debug(constraints);
//		
//		//add constraints for v
//		for(int i = 0; i < nDirectionDim; i++){
//			MatrixRow row = EcoreUtil.copy(basicRow);
//			int basic = 0;
//			//set the constraint as equality
//			row.set(basic, 0);
//			basic += 1;
//			for(int j = 0; j < nParams; j++){
//				row.set(basic + j, 0);
//			}
//			basic += nParams;
//			//set constraint for vi=i-i' 
//			//set constraint for i
//			for(int j = 0; j < nInitIndices; j++){
//				if(i == j){
//					row.set(basic + j, 1);
//				}else{
//					row.set(basic + j, 0);
//				}
//			}
//			basic += nInitIndices;
//			//set constraint for indice of scan dom
//			for(int j = 0; j < nScanIndices; j++ ){
//				row.set(basic + j, 0);
//			}
//			basic += nScanIndices;
//			//set constraint for u
//			for(int j = 0; j < nMu; j++){
//				row.set(basic + j, 0);
//			}
//			basic += nMu;
//			//set constraint for i'
//			for(int j = 0; j < nNewIndices; j++){
//				if(i == j){
//					row.set(basic + j, -1);
//				}else{
//					row.set(basic + j, 0);
//				}
//			}
//			basic += nNewIndices;
//			//set costraint for v
//			for(int j = 0; j < nDirectionDim; j++){
//				if(i == j){
//					row.set(basic + j, -1);
//				}else{
//					row.set(basic + j, 0);
//				}
//			}
//			basic += nDirectionDim;
//			row.set(basic, 0);
//			
//			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
//		}
//		
//		debug("The new constraint set:");
//		debug(constraints);
//
//		//construct the domain for the problem
//		List<List<IntConstraint>> cons = new LinkedList<List<IntConstraint>>();
//		cons.add(constraints);
//		Domain pipDom = PolyhedralIRUserFactory.eINSTANCE.createDomainFromConstraints(extendedDomain.getParams(), extendedDomain.getIndices(), cons);
//		
//		debug("The constructed domain for pip: " + pipDom);
//
//		//get the lexi max of the domain
//		org.polymodel.Domain lexmax = ((ISLSet)pipDom.getPMdomain()).lexMax();
//		
//		debug("The lexmax of the domain: " + lexmax);
//		
//		List<Long> direct = new Vector<Long>();
//		List<Long> dirSet = new Vector<Long>();
//		for(int i = 0; i < nDirectionDim; i++){
//			direct.add(0L);
//			dirSet.add(-1L);
//		}
//		//get the new direction if it exist an equality for v where it is uniform
//		List<Matrix> maxMatrices = lexmax.toMatrices();
//		for(Matrix mat : maxMatrices){
//			for(MatrixRow row : mat.getRows()){
//				if(row.get(0) == 0){	//check equality
//					int nNonDirect = nParams + nInitIndices + nScanIndices + nMu + nNewIndices + 1;
//					boolean validate = true;
//					for(int i = 1; i < nNonDirect; i++){
//						if(row.get(i) != 0){
//							validate = false;
//							break;
//						}
//					}
//					if(validate){
//						int index = -1;
//						for(int i = 0; i < nDirectionDim; i++){
//							if(row.get(nNonDirect + i) != 0){
//								index = i;
//								break;
//							}
//						}
//						if(index == -1){
//							validate = false;
//						}
//						if(validate){
//							for(int i = 0; i < nDirectionDim; i++){
//								if(i != index){
//									if(row.get(nNonDirect + i) != 0){
//										validate = false;
//										break;
//									}
//								}
//							}
//						}
//						
//						if(validate){//get the direaction
//							long constant = -row.get(nNonDirect + nDirectionDim);
//							long dir_coef = row.get(nNonDirect + index);
//							long coef = (long)(constant/dir_coef);
//							dirSet.set(index, 0L);
//							direct.set(index, coef);
//						}
//					}
//				}
//			}
//		}
//		
//		for(int i = 0; i < nDirectionDim; i++){
//			if(dirSet.get(i) == -1){
//				System.out.println("Direction extraction failed!");
//				return null;
//			}
//		}
//		debug("The new direction:" + direct.toString());
//
//		return direct;
//	}
//	
//	public static void main(String[] argc) {
//		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
//		Domain start = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=(i,j)<N}");
//		Domain end = PolyhedralIRUtility.parseDomain(param, "{x,y|0<=(x,y)<N}");
//		System.out.println(extendedDomainWithAffineFunction(param, start, end, PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i-1,j)")));
//	}
//	
//	private static Domain extendedDomainWithAffineFunction(ParameterDomain param_dom, Domain start_dom, Domain end_dom, AffineFunction dep){
//		int nParams = param_dom.getNParams();
//		int nStartIndices = start_dom.getNIndices();
//		int nEndIndices = end_dom.getNIndices();
//		
//		debug("The start domain: " + start_dom);
//		debug("The end domain:" + end_dom);
//		debug("The affine function:" + dep);
//		
//		//1. Extend start domain with end_dom so that all constraints in end_dom becomes parameter
//		//2. Then constraint the new parameters with the expression in the given function 
//		
//		Domain exDom = DomainOperations.extendParameterDomain(start_dom, end_dom);
//		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(param_dom, exDom, 
//				new Constraint(PolyhedralIRUtility.createIdentityFunction(start_dom), dep, ComparisonOperator.EQ));
//		
//		return exDom;
//		start_dom.g
		
		
		
//		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
//		//get the constraints for start domain
//		List<List<IntConstraint>> startCons;
//		
//		for (IntConstraintSystem poly : start_dom.getPMdomain().getPolyhedra()) {
//			List<IntConstraint> constraintsCopy = new ArrayList<IntConstraint>(poly.getConstraints().size());
//			for (IntConstraint ic : poly.getConstraints()) {
//				constraintsCopy.add(ic.copy());
//			}
//			startCons.add(constraintsCopy);
//		}
//		
////		List<List<IntConstraint>> startCon = start_dom.getPMdomain().getConstraintList(FORMAT.C);
////		for(int i = 0; i < startCons.size(); i++){
////			List<IntConstraint> tmp_cons = startCons.get(i);
////			for(int j = 0; j < tmp_cons.size(); j++){
////				constraints.add(tmp_cons.get(j));
////			}
////		}
//		
//		List<String> old_index = end_dom.getIndexNames();
//		List<String> new_index = new LinkedList<String>();
//		for(int i = 0; i < nEndIndices; i++){
//			String index = old_index.get(i) + "_t";
//			new_index.add(index);
//		}
//		
////		EList<String> names = end_dom.getParamNames();
////		names.addAll(new_index);
//		
//		//get the constraints for end domain with new index name
//		List<Matrix> matrices = end_dom.getPMdomain().toMatrices();
//		for(Matrix mat : matrices){
//			for(MatrixRow row : mat.getRows()){
//				constraints.add(row.toConstraint(end_dom.getParams(), end_dom.getIndices()));
//			}
//		}
//		
//		//save the constraints
//		List<IntConstraint> finalCons = new LinkedList<IntConstraint>();
//		for(IntConstraint con : constraints){
//			finalCons.add(con);
//		}
//		
//		//get the nid names
//		List<String> newIds = new LinkedList<String>();
//		newIds.addAll(start_dom.getIndexNames());
//		newIds.addAll(new_index);
////		PolyhedralIRUserFactory.eINSTANCE.createD
//		Domain combinedDom = PolyhedralIRUtility.parseDomainFromString(param_dom, newIds, constraints);
//		if(DEBUG){
//			System.out.println("Combined domain: " + combinedDom);
//		}
//		//construct the constrains for the affine mapping
//		//get the names
//		EList<String> nNames = combinedDom.getParamNames();
//		nNames.addAll(combinedDom.getIndexNames());
//		
//		//get a basice matrix row
//		MatrixRow basicRow = combinedDom.getPMdomain().toMatrices().get(0).getRows().get(0);
//		
//		//get Affine function matrix
//		Matrix funcMat = dep.getPMmapping().toMatrix();
//		EList<MatrixRow> mat_rows = funcMat.getRows();
//		for(int i = 0; i < mat_rows.size(); i++){
//			MatrixRow row = EcoreUtil.copy(basicRow);
//			MatrixRow funcRow = mat_rows.get(i);
//			//set the constraint as equality
//			int cbasic = 0;
//			int basic = 0;
//			row.set(cbasic, 0);
//			cbasic += 1;
//			//set the constraints for parameters
//			for(int j = 0; j < nParams; j++){
//				row.set(cbasic + j, funcRow.get(basic+j));
//			}
//			cbasic += nParams;
//			basic += nParams;
//			//set the constraints for i
//			for(int j = 0; j < nStartIndices; j++){
//				row.set(cbasic+j, funcRow.get(basic+j));
//			}
//			cbasic += nStartIndices;
//			basic += nParams;
//			
//			//set the constraints for i_t
//			for(int j = 0; j < nEndIndices; j++){
//				if(i == j){
//					row.set(cbasic+j,-1);
//				}else{
//					row.set(cbasic+j, 0);
//				}
//			}
//			cbasic += nEndIndices;
//			
//			//set the constraints for constant
//			row.set(cbasic, funcRow.get(basic));
//			
//			//get the constraint
//			finalCons.add(row.toConstraint(nNames));
//		}
//		List<List<String>> tmpcons = new LinkedList<List<String>>();
//		tmpcons.add(finalCons);
//		Domain finalDom = PolyhedralIRUtility.parseDomain(combinedDom.getParams(), combinedDom.getIndices(), tmpcons);
		
//		if(DEBUG){
//			System.out.println("The final combined affine Domain: " + finalDom);
//		}
//		
//		return finalDom;
//	}
	
//	/**
//	 * Returns true if all the dependences are uniform and are uni-directional.
//	 * 
//	 * @param v
//	 * @param dependences
//	 * @param branchInfo
//	 * @return
//	 */
//	private  List<Long> extractDirection(VariableDeclaration v, Set<AffineFunction> dependences, BranchInfo branchInfo){
//		
//		debug("List of dependences given to extractDirection");
//		debug(dependences);
//		
//		List<Long> baseDep = null;
//		Map<Long,AffineFunction> varMap = new HashMap<Long, AffineFunction>();
//		long max_gcd = -1;
//		boolean uniDirectional = true;
//		
//		for (AffineFunction dep : dependences) {
//			//first iteration
//			{
//				if (!dep.isUniform()) {
//					return null;
//				}		
//				List<Long> depVec = ScanUtilities.getDepVector(dep);
//				long gcd_tmp = ScanUtilities.getGCD(depVec);
//				debug("GCD for dependence vector: " + depVec + " is " + gcd_tmp);
//				varMap.put(gcd_tmp, dep);
//
//				if (gcd_tmp > max_gcd){
//					max_gcd = gcd_tmp;
//				}
//			
//				//get the basic dependence vector
//				if (baseDep == null) {
//					baseDep = new Vector<Long>();
//					for(long val : depVec) {
//						baseDep.add(val/gcd_tmp);
//					}
//				//from 2nd iteration and onwards, check for equivalence
//				} else {
//					List<Long> tmpDep = new Vector<Long>();
//					for(long val : depVec) {
//						tmpDep.add(val/gcd_tmp);
//					}
//
//					if(!tmpDep.equals(baseDep)){
//						uniDirectional = false;
//					}
//				}
//			}
//		}
//
//			
//		if(uniDirectional){
//			branchInfo.varFuncGcdMap.put(v, varMap);
//			branchInfo.varMaxGcdMap.put(v, max_gcd);
//		}
//		
//		return baseDep;
//	}
	
	

	//	/**
	//	 * Construct the updating vector
	//	 * The updating vector is in the form like (x-1, x-2, x-3, y-1, y-2, 1)
	//	 * All the elements involves the same scan variable is close to each other, then move on to the next scan variable, the last element is the constant
	//	 * @param dirs
	//	 * @param domain
	//	 * @param target_variables
	//	 * @param varMaxGcdMap
	//	 * @return
	//	 */
	//	private List<VectorInformation> constructUpdatingVector(){
	//		List<VectorInformation> updating_vector = new LinkedList<VectorInformation>();
	//		ScanInformations info_obj = new ScanInformations();
	//		
	//		//construct the affine function for each variable for all vector within distance
	//		Vector<Long> main_dir = dirs.get(0);
	//		for(int i = 0; i < target_variables.size(); i++){
	//			VariableDeclaration var = target_variables.get(i);
	//			long max_gcd = varMaxGcdMap.get(var);
	//			Domain variable_domain = domain.copy();
	//			for(int j = 1; j <= max_gcd; j++){
	//				List<Long> dep_vector = new Vector();
	//				for(int k = 0; k < main_dir.size(); k++){
	//					dep_vector.add(k, main_dir.get(k)*j*(-1));
	//				}
	//				//create the uniform vector 
	//				AffineFunction dep_fun = PolyhedralIRUtility.createUniformFunction(domain, dep_vector);
	//				//create the updating vector
	//				//moving the domain along opposite direction of the current vector
	//				Domain temp_domain = variable_domain.image(dep_fun);
	//				Domain vector_domain = temp_domain.difference(variable_domain);
	//				variable_domain = temp_domain.union(variable_domain);
	//				
	//				//FIXME VectorInformation vector = info_obj.createVector(var, dep_fun, j, vector_domain);
	//				//updating_vector.add(vector);
	//			}
	//		}
	//		
	//		return updating_vector;
	//	}
		
		
		/*
		 * Detection of lexicographical scan along some directions
		 * Merge the initial branch with the detected branch
		 */
	//	private void lexScan() {
	//		//only supports multi-dimensional scan over one variable
	//		if (scan.scanVariables.size() > 1) return;
	//
	//		VariableDeclaration var = scan.scanVariables.get(0);
	//		BranchInfo branch = varToBranch.get(var);
	//		CaseExpression cur_case = (CaseExpression)varToExpression.get(var);
	//		List<Expression> branches = cur_case.getExprs();
	//		List<List<Long>> directions = new LinkedList<List<Long>>();
	//		Domain domain = scan.scanDomain.copy();
			
	//		//get the basic inner most direction
	//		AffineFunction baseFunction = branch.varFuncGcdMap.get(var).get(1L);
	//		List<Long> vec = ScanUtilities.getDepVector(baseFunction);
	//		directions.add(vec);
	//		
	//		long max_gcd = branch.varMaxGcdMap.get(var);
	//		int dim = domain.getDim();
	//
	//		for(int i = 1; i < dim; i++){
	//			for(int j = 0; j < max_gcd; j++){
	//				//get the init domain now
	//				Domain init_dom = domain.image(baseFunction).difference(domain);
	//				domain = domain.union(init_dom);
	//				debug("Current Initial Domain:" + init_dom);
	//				
	//				boolean modified = true;
	//				while(modified){
	//					modified = false;
	//					List<Expression> merged_branches = new LinkedList<Expression>();
	//					for(Expression exp : branches){
	//						if(!exp.getContextDomain().intersection(init_dom).isEmpty()){
	//							
	//							BranchInfoCollector collector = new BranchInfoCollector(exp);
	//							
	//							//test the branch
	//							exp.accept(collector);
	//							
	//							debug("Init branch: " + PolyhedralIRToAlphabets.toSimplifiedString(exp));
	//							debug("Recurrence times for init branch:" + collector.count);
	//							
	//							if(collector.count == 0){
	//								continue;
	//							}
	//
	//							//check the semiring
	//							if (!collector.hasUniqueSemiring()) {
	//								debug("Extraction failed: semirings found were not unique (or semirings were not found)");
	//								return;
	//							}
	//							
	//							semiring = collector.semirings.iterator().next();
	//							
	//							
	//							Set<AffineFunction> function_list = collector.varToFunction.get(var);
	//							//separate the uniform function and non uniform functions
	//							List<AffineFunction> uniform_list = new LinkedList<AffineFunction>();
	//							List<AffineFunction> affine_list = new LinkedList<AffineFunction>();
	//							
	//							for(AffineFunction af : function_list){
	//								if(af.isUniform()){
	//									uniform_list.add(af.copy());
	//								}else{
	//									affine_list.add(af.copy());
	//								}
	//							}
	//							
	//							//the affine function list
	//							debug("AffineList for init branch: " + PolyhedralIRToAlphabets.toSimplifiedString(exp));
	//							debug(function_list);
	//							
	//							//check is all the uniform dependence has the same direction as the inner most direction
	//							for(AffineFunction af : uniform_list){
	//								//System.out.println("Test for function: " + af);
	//								List<Long> depVec = ScanUtilities.getDepVector(af);
	//								
	//								long gcd_tmp = ScanUtilities.getGCD(depVec);
	//								
	//								List<Long> baseDep = new Vector<Long>();
	//								//get the basic dependence vector
	//								for(int k = 0; k < depVec.size(); k++){
	//									baseDep.add(depVec.get(k)/gcd_tmp);
	//								}
	//								
	//								//System.out.println("vec: " + vec.toString());
	//								//System.out.println("baseDep:" + baseDep.toString());
	//								if(!vec.equals(baseDep)){
	//									validate = false;
	//									break;
	//								}
	//							}
	//							
	//							//not one the same direction
	//							if(!validate){
	//								continue;
	//							}
	//							
	//							//check is all the non-uniform dependece can be used to extract the same direction
	//							List<Long> newVec = null;
	//							List<Long> dimVec = null;
	//							boolean newDirExtraction = true;
	//							//find basic vector
	//							AffineFunction af_first = affine_list.get(0);
	//							List<List<Long>> tmp_directions = new LinkedList<List<Long>>();
	//							for(int k = 0; k < directions.size(); k++){
	//								tmp_directions.add(directions.get(k));
	//								List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af_first, tmp_directions);
	//								if(newDirect != null){
	//									newVec = newDirect;
	//									if(k < directions.size() - 1){
	//										dimVec = directions.get(k+1);
	//										newDirExtraction = false;
	//									}
	//									if(!newDirExtraction){
	//										if(!newVec.equals(dimVec)){
	//											System.out.println("NewDirection extraction failed!");
	//											validate = false;
	//										}
	//									}
	//									
	//									break;
	//								}
	//							}
	//							
	//							if(!validate){
	//								continue;
	//							}
	//							
	//							if(newVec == null){
	//								validate = false;
	//								continue;
	//							}
	//							
	//							for(int k = 1; k < affine_list.size(); k++){
	//								AffineFunction af = affine_list.get(k);
	//								List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af, tmp_directions);
	//								if(newDirect == null){
	//									System.out.println("New Direction extraction failed!!");
	//									validate = false;
	//									break;
	//								}else{
	//									if(!newVec.equals(newDirect)){
	//										System.out.println("New Direction extraction failed!");
	//										validate = false;
	//										break;
	//									}
	//								}
	//							}
	//							
	//							
	//							if(validate){	//start extraction new matrix
	//								modified = true;
	//								if(newDirExtraction){
	//									directions.add(newVec);
	//								}
	//								debug("new direction extracted: " + newVec.toString());
	//								merged_branches.add(exp);
	//								for(AffineFunction depFunc : function_list){
	//									Expression e_tmp = exp.copy();
	//									//System.out.println("The mapping for the affine function is " + cur_GcdFuncMap.get(k).getPMmapping());
	//									//AffineFunction cur_af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_GcdFuncMap.get(k).getPMmapping());
	//									//System.out.println("The affine function now is " + cur_GcdFuncMap.get(cur_af));
	//									Expression exp_tmp = ExtractVarCoe(e_tmp, var, depFunc, semiring, scan.scanVariables);
	//									//coeVec.add(exp_tmp);
	//									debug("Coef for variable " + var.getName() +  " recurrence function: " + depFunc + " is " + PolyhedralIRToAlphabets.toSimplifiedString(exp_tmp));
	//								}
	//							}
	//						}
	//					}
	//					
	//					for(Expression exp : merged_branches){
	//						scanDomain = scanDomain.union(exp.getContextDomain());
	//						branches.remove(exp);
	//					}
	//				}
	//			}
	//		}
	//	}
		
	//	private List<Long> DirectionExtraction(AffineSystem s, Domain domain, Domain init_dom, List<AffineFunction> function_list, List<Long> baseDirec, List<List<Long>> directions){
	//		//seperate the uniform function and non uniform functions
	//		List<AffineFunction> uniform_list = new LinkedList<AffineFunction>();
	//		List<AffineFunction> affine_list = new LinkedList<AffineFunction>();
	//		
	//		for(AffineFunction af : function_list){
	//			if(af.isUniform()){
	//				uniform_list.add(af.copy());
	//			}else{
	//				affine_list.add(af.copy());
	//			}
	//		}
	//		
	//		debug("check the list of affine function");
	//		debug(function_list);
	//		
	//		
	//		//check is all the uniform dependence has the same direction as the inner most direction
	//		for(AffineFunction af : uniform_list){
	//			//System.out.println("Test for function: " + af);
	//			List<Long> depVec = ScanUtilities.getDepVector(af);
	//			
	//			long gcd_tmp = ScanUtilities.getGCD(depVec);
	//			
	//			List<Long> baseDep = new Vector<Long>();
	//			//get the basic dependence vector
	//			for(int k = 0; k < depVec.size(); k++){
	//				baseDep.add(depVec.get(k)/gcd_tmp);
	//			}
	//			
	//			//System.out.println("vec: " + vec.toString());
	//			//System.out.println("baseDep:" + baseDep.toString());
	//			if(!baseDirec.equals(baseDep)){
	//				return null;
	//			}
	//		}
	//		
	//		//check is all the non-uniform dependece can be used to extract the same direction
	//		List<Long> newVec = null;
	//		List<Long> dimVec = null;
	//		boolean newDirExtraction = true;
	//		//find basic vector
	//		AffineFunction af_first = affine_list.get(0);
	//		List<List<Long>> tmp_directions = new LinkedList<List<Long>>();
	//		for(int k = 0; k < directions.size(); k++){
	//			tmp_directions.add(directions.get(k));
	//			List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af_first, tmp_directions);
	//			if(newDirect != null){
	//				newVec = newDirect;
	//				if(k < directions.size() - 1){
	//					dimVec = directions.get(k+1);
	//					newDirExtraction = false;
	//				}
	//				if(!newDirExtraction){
	//					if(!newVec.equals(dimVec)){
	//						return null;
	//					}
	//				}
	//			}
	//		}
	//		
	//		if(newVec == null){
	//			return null;
	//		}
	//		
	//		for(int k = 1; k < affine_list.size(); k++){
	//			AffineFunction af = affine_list.get(k);
	//			List<Long> newDirect = NewDirectionExtraction(s.getParameters(), domain.copy(), init_dom, af, tmp_directions);
	//			if(newDirect == null){
	//				System.out.println("New Direction extraction failed!!");
	//				return null;
	//			}else{
	//				if(!newVec.equals(newDirect)){
	//					System.out.println("New Direction extraction failed!");
	//					return null;
	//				}
	//			}
	//		}
	//		
	//		return newVec;
	//	}
	//	
	//	private List<Long> NewDirectionExtraction(ParameterDomain param_dom, Domain scan_dom, Domain init_dom, AffineFunction dep, List<List<Long>> directions){
	//		Domain paramDom = extendedDomainWithAffineFunction(param_dom, init_dom, scan_dom, dep);
	//		
	//		int nIndices = scan_dom.getNIndices();
	//		//construct the empty domain for u and v
	//		String dom_str = "{";
	//		for(int i = 0; i < directions.size(); i++){
	//			dom_str += "u" + i + ",";
	//		}
	//		//the new indices
	//		for(int i = 0; i < nIndices; i++){
	//			dom_str += "i"+i + ",";
	//		}
	//		for(int i = 0; i < nIndices-1; i++){
	//			dom_str += "v" + i + ",";
	//		}
	//		dom_str += "v" + (nIndices-1) + "|}";
	//
	//		debug("The original init domain:" + init_dom);
	//		debug("The original scan domain:" + scan_dom);
	//		debug("The new parameter domain:" + paramDom);
	//		debug("The directions:" + directions.toString());
	//
	//		//create the empty domain
	//		Domain empty_domain = PolyhedralIRUtility.parseDomain(param_dom, dom_str);
	//		debug("Empty domain: " + empty_domain);
	//
	//		//extends the domain
	//		Domain extendedDomain = DomainOperations.extendParameterDomain(empty_domain, paramDom);
	//		debug("The extended Domain:" + extendedDomain);
	//		
	//		//get different index num
	//		int nParams = param_dom.getNParams();
	//		int nInitIndices = init_dom.getNIndices();
	//		int nScanIndices = scan_dom.getNIndices();
	//		int nMu = directions.size();
	//		int nNewIndices = nInitIndices;
	//		int nDirectionDim = nInitIndices;
	//		
	//		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
	//		
	//		
	//		//add the original constraint and the constraint for u
	//		List<Matrix> oriMatrices = extendedDomain.getPMdomain().toMatrices();
	//		for(Matrix mat : oriMatrices){
	//			for(MatrixRow row : mat.getRows()){
	//				//add the original constraint
	//				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
	//			}
	//		}
	//		
	//		debug("The original constraint");
	//		debug(constraints);
	//		
	//		//get the basic matrix row
	//		MatrixRow basicRow = extendedDomain.getPMdomain().toMatrices().get(0).getRows().get(0);
	//		
	//		//add constraints for the min
	//		List<Matrix> matrices = scan_dom.getPMdomain().toMatrices();
	//		for(Matrix mat : matrices){
	//			for(MatrixRow matrow : mat.getRows()){
	//				MatrixRow row = EcoreUtil.copy(basicRow);
	//				int basic = 0;
	//				int oriBasic = 0;
	//				row.set(basic, matrow.get(oriBasic));
	//				basic += 1;
	//				oriBasic += 1;
	//				//set the param
	//				for(int j = 0; j < nParams; j++){
	//					row.set(basic+j, matrow.get(oriBasic+j));
	//				}
	//				basic += nParams;
	//				oriBasic += nParams;
	//				//set the i_p
	//				for(int j = 0; j < nInitIndices; j++){
	//					row.set(basic+j, 0);
	//				}
	//				basic += nInitIndices;
	//				//set the i_t_p and u
	//				for(int j = 0; j < nScanIndices+nMu; j++){
	//					row.set(basic+j, 0);
	//				}
	//				for(int j = 0; j < nScanIndices; j++){
	//					long coef = matrow.get(oriBasic+j);
	//					if(coef != 0){
	//						row.set(basic + j, coef);
	//						for(int k = 0; k < nMu; k++){
	//							long cur_coef = row.get(basic+nScanIndices+k);
	//							cur_coef -= coef*directions.get(k).get(j);
	//							row.set(basic+nScanIndices+k, cur_coef);
	//						}
	//					}
	//				}
	//				oriBasic += nScanIndices;
	//				basic += (nScanIndices + nMu);
	//				//set new indices and v
	//				for(int j = 0; j < nNewIndices +nDirectionDim; j++){
	//					row.set(basic + j, 0);
	//				}
	//				basic += nNewIndices + nDirectionDim;
	//				//set the constant coef
	//				row.set(basic, matrow.get(oriBasic));
	//				
	//				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
	//			}
	//		}
	//		
	//		debug("Constrains after add constraints for min");
	//		debug(constraints);
	//
	//		//add constraints for the new indices
	//		for(int i = 0; i < nNewIndices; i++){
	//			MatrixRow row = EcoreUtil.copy(basicRow);
	//			//set the equality
	//			int basic = 0;
	//			row.set(basic, 0);
	//			basic += 1;
	//			//set the parameters
	//			for(int j = 0; j < nParams; j++){
	//				row.set(basic+j, 0);
	//			}
	//			basic += nParams;
	//			//set the init indices as 0
	//			for(int j = 0; j < nInitIndices; j++){
	//				row.set(basic + j, 0);
	//			}
	//			basic += nInitIndices;
	//			//set the scan indices
	//			for(int j = 0; j < nScanIndices; j++){
	//				if(i == j){
	//					row.set(basic+j, 1);
	//				}else{
	//					row.set(basic+j, 0);
	//				}
	//			}
	//			basic += nScanIndices;
	//			//set the u indices
	//			for(int j = 0; j < nMu; j++){
	//				row.set(basic+j, -directions.get(j).get(i));
	//			}
	//			basic += nMu;
	//			//set the new indices
	//			for(int j = 0; j < nNewIndices; j++){
	//				if(i == j){
	//					row.set(basic+j, -1);
	//				}else{
	//					row.set(0, 0);
	//				}
	//			}
	//			basic += nNewIndices;
	//			//set the v indices
	//			for(int j = 0; j < nDirectionDim; j++){
	//				row.set(basic + j, 0);
	//			}
	//			basic += nDirectionDim;
	//			//set the constant
	//			row.set(basic, 0);
	//			
	//			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
	//		}
	//		
	//		debug("Constraints after add constraints for new indices");
	//		debug(constraints);
	//		
	//		//add constraints for v
	//		for(int i = 0; i < nDirectionDim; i++){
	//			MatrixRow row = EcoreUtil.copy(basicRow);
	//			int basic = 0;
	//			//set the constraint as equality
	//			row.set(basic, 0);
	//			basic += 1;
	//			for(int j = 0; j < nParams; j++){
	//				row.set(basic + j, 0);
	//			}
	//			basic += nParams;
	//			//set constraint for vi=i-i' 
	//			//set constraint for i
	//			for(int j = 0; j < nInitIndices; j++){
	//				if(i == j){
	//					row.set(basic + j, 1);
	//				}else{
	//					row.set(basic + j, 0);
	//				}
	//			}
	//			basic += nInitIndices;
	//			//set constraint for indice of scan dom
	//			for(int j = 0; j < nScanIndices; j++ ){
	//				row.set(basic + j, 0);
	//			}
	//			basic += nScanIndices;
	//			//set constraint for u
	//			for(int j = 0; j < nMu; j++){
	//				row.set(basic + j, 0);
	//			}
	//			basic += nMu;
	//			//set constraint for i'
	//			for(int j = 0; j < nNewIndices; j++){
	//				if(i == j){
	//					row.set(basic + j, -1);
	//				}else{
	//					row.set(basic + j, 0);
	//				}
	//			}
	//			basic += nNewIndices;
	//			//set costraint for v
	//			for(int j = 0; j < nDirectionDim; j++){
	//				if(i == j){
	//					row.set(basic + j, -1);
	//				}else{
	//					row.set(basic + j, 0);
	//				}
	//			}
	//			basic += nDirectionDim;
	//			row.set(basic, 0);
	//			
	//			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
	//		}
	//		
	//		debug("The new constraint set:");
	//		debug(constraints);
	//
	//		//construct the domain for the problem
	//		List<List<IntConstraint>> cons = new LinkedList<List<IntConstraint>>();
	//		cons.add(constraints);
	//		Domain pipDom = PolyhedralIRUserFactory.eINSTANCE.createDomainFromConstraints(extendedDomain.getParams(), extendedDomain.getIndices(), cons);
	//		
	//		debug("The constructed domain for pip: " + pipDom);
	//
	//		//get the lexi max of the domain
	//		org.polymodel.Domain lexmax = ((ISLSet)pipDom.getPMdomain()).lexMax();
	//		
	//		debug("The lexmax of the domain: " + lexmax);
	//		
	//		List<Long> direct = new Vector<Long>();
	//		List<Long> dirSet = new Vector<Long>();
	//		for(int i = 0; i < nDirectionDim; i++){
	//			direct.add(0L);
	//			dirSet.add(-1L);
	//		}
	//		//get the new direction if it exist an equality for v where it is uniform
	//		List<Matrix> maxMatrices = lexmax.toMatrices();
	//		for(Matrix mat : maxMatrices){
	//			for(MatrixRow row : mat.getRows()){
	//				if(row.get(0) == 0){	//check equality
	//					int nNonDirect = nParams + nInitIndices + nScanIndices + nMu + nNewIndices + 1;
	//					boolean validate = true;
	//					for(int i = 1; i < nNonDirect; i++){
	//						if(row.get(i) != 0){
	//							validate = false;
	//							break;
	//						}
	//					}
	//					if(validate){
	//						int index = -1;
	//						for(int i = 0; i < nDirectionDim; i++){
	//							if(row.get(nNonDirect + i) != 0){
	//								index = i;
	//								break;
	//							}
	//						}
	//						if(index == -1){
	//							validate = false;
	//						}
	//						if(validate){
	//							for(int i = 0; i < nDirectionDim; i++){
	//								if(i != index){
	//									if(row.get(nNonDirect + i) != 0){
	//										validate = false;
	//										break;
	//									}
	//								}
	//							}
	//						}
	//						
	//						if(validate){//get the direaction
	//							long constant = -row.get(nNonDirect + nDirectionDim);
	//							long dir_coef = row.get(nNonDirect + index);
	//							long coef = (long)(constant/dir_coef);
	//							dirSet.set(index, 0L);
	//							direct.set(index, coef);
	//						}
	//					}
	//				}
	//			}
	//		}
	//		
	//		for(int i = 0; i < nDirectionDim; i++){
	//			if(dirSet.get(i) == -1){
	//				System.out.println("Direction extraction failed!");
	//				return null;
	//			}
	//		}
	//		debug("The new direction:" + direct.toString());
	//
	//		return direct;
	//	}
	//	
	//	public static void main(String[] argc) {
	//		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
	//		Domain start = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=(i,j)<N}");
	//		Domain end = PolyhedralIRUtility.parseDomain(param, "{x,y|0<=(x,y)<N}");
	//		System.out.println(extendedDomainWithAffineFunction(param, start, end, PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i-1,j)")));
	//	}
	//	
	//	private static Domain extendedDomainWithAffineFunction(ParameterDomain param_dom, Domain start_dom, Domain end_dom, AffineFunction dep){
	//		int nParams = param_dom.getNParams();
	//		int nStartIndices = start_dom.getNIndices();
	//		int nEndIndices = end_dom.getNIndices();
	//		
	//		debug("The start domain: " + start_dom);
	//		debug("The end domain:" + end_dom);
	//		debug("The affine function:" + dep);
	//		
	//		//1. Extend start domain with end_dom so that all constraints in end_dom becomes parameter
	//		//2. Then constraint the new parameters with the expression in the given function 
	//		
	//		Domain exDom = DomainOperations.extendParameterDomain(start_dom, end_dom);
	//		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(param_dom, exDom, 
	//				new Constraint(PolyhedralIRUtility.createIdentityFunction(start_dom), dep, ComparisonOperator.EQ));
	//		
	//		return exDom;
	//		start_dom.g
			
			
			
	//		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
	//		//get the constraints for start domain
	//		List<List<IntConstraint>> startCons;
	//		
	//		for (IntConstraintSystem poly : start_dom.getPMdomain().getPolyhedra()) {
	//			List<IntConstraint> constraintsCopy = new ArrayList<IntConstraint>(poly.getConstraints().size());
	//			for (IntConstraint ic : poly.getConstraints()) {
	//				constraintsCopy.add(ic.copy());
	//			}
	//			startCons.add(constraintsCopy);
	//		}
	//		
	////		List<List<IntConstraint>> startCon = start_dom.getPMdomain().getConstraintList(FORMAT.C);
	////		for(int i = 0; i < startCons.size(); i++){
	////			List<IntConstraint> tmp_cons = startCons.get(i);
	////			for(int j = 0; j < tmp_cons.size(); j++){
	////				constraints.add(tmp_cons.get(j));
	////			}
	////		}
	//		
	//		List<String> old_index = end_dom.getIndexNames();
	//		List<String> new_index = new LinkedList<String>();
	//		for(int i = 0; i < nEndIndices; i++){
	//			String index = old_index.get(i) + "_t";
	//			new_index.add(index);
	//		}
	//		
	////		EList<String> names = end_dom.getParamNames();
	////		names.addAll(new_index);
	//		
	//		//get the constraints for end domain with new index name
	//		List<Matrix> matrices = end_dom.getPMdomain().toMatrices();
	//		for(Matrix mat : matrices){
	//			for(MatrixRow row : mat.getRows()){
	//				constraints.add(row.toConstraint(end_dom.getParams(), end_dom.getIndices()));
	//			}
	//		}
	//		
	//		//save the constraints
	//		List<IntConstraint> finalCons = new LinkedList<IntConstraint>();
	//		for(IntConstraint con : constraints){
	//			finalCons.add(con);
	//		}
	//		
	//		//get the nid names
	//		List<String> newIds = new LinkedList<String>();
	//		newIds.addAll(start_dom.getIndexNames());
	//		newIds.addAll(new_index);
	////		PolyhedralIRUserFactory.eINSTANCE.createD
	//		Domain combinedDom = PolyhedralIRUtility.parseDomainFromString(param_dom, newIds, constraints);
	//		if(DEBUG){
	//			System.out.println("Combined domain: " + combinedDom);
	//		}
	//		//construct the constrains for the affine mapping
	//		//get the names
	//		EList<String> nNames = combinedDom.getParamNames();
	//		nNames.addAll(combinedDom.getIndexNames());
	//		
	//		//get a basice matrix row
	//		MatrixRow basicRow = combinedDom.getPMdomain().toMatrices().get(0).getRows().get(0);
	//		
	//		//get Affine function matrix
	//		Matrix funcMat = dep.getPMmapping().toMatrix();
	//		EList<MatrixRow> mat_rows = funcMat.getRows();
	//		for(int i = 0; i < mat_rows.size(); i++){
	//			MatrixRow row = EcoreUtil.copy(basicRow);
	//			MatrixRow funcRow = mat_rows.get(i);
	//			//set the constraint as equality
	//			int cbasic = 0;
	//			int basic = 0;
	//			row.set(cbasic, 0);
	//			cbasic += 1;
	//			//set the constraints for parameters
	//			for(int j = 0; j < nParams; j++){
	//				row.set(cbasic + j, funcRow.get(basic+j));
	//			}
	//			cbasic += nParams;
	//			basic += nParams;
	//			//set the constraints for i
	//			for(int j = 0; j < nStartIndices; j++){
	//				row.set(cbasic+j, funcRow.get(basic+j));
	//			}
	//			cbasic += nStartIndices;
	//			basic += nParams;
	//			
	//			//set the constraints for i_t
	//			for(int j = 0; j < nEndIndices; j++){
	//				if(i == j){
	//					row.set(cbasic+j,-1);
	//				}else{
	//					row.set(cbasic+j, 0);
	//				}
	//			}
	//			cbasic += nEndIndices;
	//			
	//			//set the constraints for constant
	//			row.set(cbasic, funcRow.get(basic));
	//			
	//			//get the constraint
	//			finalCons.add(row.toConstraint(nNames));
	//		}
	//		List<List<String>> tmpcons = new LinkedList<List<String>>();
	//		tmpcons.add(finalCons);
	//		Domain finalDom = PolyhedralIRUtility.parseDomain(combinedDom.getParams(), combinedDom.getIndices(), tmpcons);
			
	//		if(DEBUG){
	//			System.out.println("The final combined affine Domain: " + finalDom);
	//		}
	//		
	//		return finalDom;
	//	}
		
	//	/**
	//	 * Returns true if all the dependences are uniform and are uni-directional.
	//	 * 
	//	 * @param v
	//	 * @param dependences
	//	 * @param branchInfo
	//	 * @return
	//	 */
	//	private  List<Long> extractDirection(VariableDeclaration v, Set<AffineFunction> dependences, BranchInfo branchInfo){
	//		
	//		debug("List of dependences given to extractDirection");
	//		debug(dependences);
	//		
	//		List<Long> baseDep = null;
	//		Map<Long,AffineFunction> varMap = new HashMap<Long, AffineFunction>();
	//		long max_gcd = -1;
	//		boolean uniDirectional = true;
	//		
	//		for (AffineFunction dep : dependences) {
	//			//first iteration
	//			{
	//				if (!dep.isUniform()) {
	//					return null;
	//				}		
	//				List<Long> depVec = ScanUtilities.getDepVector(dep);
	//				long gcd_tmp = ScanUtilities.getGCD(depVec);
	//				debug("GCD for dependence vector: " + depVec + " is " + gcd_tmp);
	//				varMap.put(gcd_tmp, dep);
	//
	//				if (gcd_tmp > max_gcd){
	//					max_gcd = gcd_tmp;
	//				}
	//			
	//				//get the basic dependence vector
	//				if (baseDep == null) {
	//					baseDep = new Vector<Long>();
	//					for(long val : depVec) {
	//						baseDep.add(val/gcd_tmp);
	//					}
	//				//from 2nd iteration and onwards, check for equivalence
	//				} else {
	//					List<Long> tmpDep = new Vector<Long>();
	//					for(long val : depVec) {
	//						tmpDep.add(val/gcd_tmp);
	//					}
	//
	//					if(!tmpDep.equals(baseDep)){
	//						uniDirectional = false;
	//					}
	//				}
	//			}
	//		}
	//
	//			
	//		if(uniDirectional){
	//			branchInfo.varFuncGcdMap.put(v, varMap);
	//			branchInfo.varMaxGcdMap.put(v, max_gcd);
	//		}
	//		
	//		return baseDep;
	//	}
		
			
}
