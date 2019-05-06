package org.polymodel.polyhedralIR.recurrence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.isl.ISLSet;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.recurrence.ScanInformations.VectorInformation;
import org.polymodel.polyhedralIR.recurrence.SermringUtilities.Sermring;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import fr.irisa.cairn.graph.INode;

public class MatrixFormTransformation extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	private List<VariableDeclaration> target_list;
	private Sermring current_serm;
	private Domain scan_dom;
	private HashMap<VariableDeclaration, Expression> ori_varExpMap;
	private HashMap<VariableDeclaration, EList<AffineFunction>> cur_varFuncMap;
	private List<Vector<Long>> directions;
	private HashMap<VariableDeclaration, BranchInfo> varBranchInfoMap;
	private static boolean DEBUG = true;
	
	protected MatrixFormTransformation(){
		target_list = new BasicEList<VariableDeclaration>();
		current_serm = null;
		scan_dom = null;
		ori_varExpMap = new HashMap<VariableDeclaration, Expression>();
		cur_varFuncMap = new HashMap<VariableDeclaration, EList<AffineFunction>>();
		varBranchInfoMap = new HashMap<VariableDeclaration, BranchInfo>();
		directions = new LinkedList<Vector<Long>>();
	}
	
	public ScanInformations TransformToMatrixForm(AffineSystem s, Set<INode> scc_node, Domain start_dom){
		ScanInformations info = new ScanInformations();
		//get the target_list
		Iterator it = scc_node.iterator();
		while (it.hasNext()) {
			PRDGNode org = ((IPRDGNodeAdapter)it.next()).getAdaptedNode();
			target_list.add(s.getVariableDeclaration(org.getName()));
		}
		//set the target list
		info.addTarget(target_list);
				
		//get the definition expression for each variable
		for (StandardEquation eq : s.getEquations()) {
			if(target_list.contains(eq.getVariable())){
				if(eq.getExpression() instanceof CaseExpression){
					ori_varExpMap.put(eq.getVariable(), eq.getExpression());
				}
			}
		}
				
		if(ori_varExpMap.size() == 0){
			return null;
		}
		
		//init the current variable function mapping 
		for(int i = 0; i < target_list.size(); i++){
			cur_varFuncMap.put(target_list.get(i), new BasicEList<AffineFunction>());
		}
		
		//detect the main scan branch
		varBranchInfoMap = ExtractMainScanBranch(s, start_dom, target_list, ori_varExpMap);
		if(varBranchInfoMap == null || varBranchInfoMap.size() == 0){
			System.out.println("Scan Extraction failed!\n");
			return null;
		}
		
		//get the main direction
		Vector<Long> mainDir = getMainDirection(target_list, varBranchInfoMap);
		directions.add(mainDir);
		
		//get the sermring
		current_serm = getScanSermring(target_list, varBranchInfoMap);
				
		info.addOPlus(current_serm.op1);
		info.addOTimes(current_serm.op2);
		
		//get the variable maxVarDistanceMap
		HashMap<VariableDeclaration, Long> varMaxDistanceMap = getVarMaxDistance(target_list, varBranchInfoMap);
		
		Domain main_scan_domain = start_dom.copy();
		//construct the coefficient matrixinformation for the main Scan
		Expression[][] main_scan_matrix = constructScanCoefficientMatrix(target_list, varBranchInfoMap, varMaxDistanceMap);
		info.addCoefficientMatrix( main_scan_domain, main_scan_matrix);
		
		//set the matrix size
		info.addSize(main_scan_matrix.length);
		
		scan_dom = main_scan_domain.copy();
		//detect the lexiscan information
		//TODO: Current implementation is restricted to only one scan variable, needs to be extended to support multiple scan variables
		/* * Detection of lexicalgraphical scan along some directions
		 * Merge the possible initial branch with the detected branch
		 */
		if(target_list.size() == 1){
			VariableDeclaration var = target_list.get(0);
			Domain initial_domain = getVariableInitDomain(main_scan_domain, directions.get(0), varMaxDistanceMap.get(var));
			Domain current_scan_domain = main_scan_domain.copy();
			
			boolean newDirExtracted = true;
			
			List<VariableDeclaration> cur_target_list = new LinkedList<VariableDeclaration>();
			cur_target_list.add(var);
			
			//merge the branch with the detected branch unit no more branch can be merged
			while(newDirExtracted){
				List<BranchInfo> branch_for_merge = extractMergedBranches(s, directions, current_scan_domain,  initial_domain, var, varMaxDistanceMap.get(var), ori_varExpMap.get(var), current_serm);
				if(branch_for_merge.size() > 0){
					newDirExtracted = true;
				}else{
					newDirExtracted = false;
				}
				
				directions.add(getCommonDirection(branch_for_merge));
				//construct Matrix Information for each branch
				for(int i = 0; i < branch_for_merge.size(); i++){
					Expression[][] current_branch_matrix = constructInitCoefficientMatrix(var,  varMaxDistanceMap.get(var),branch_for_merge.get(i));
					info.addCoefficientMatrix(branch_for_merge.get(i).exp.getContextDomain().copy(), current_branch_matrix);
					info.addSize(current_branch_matrix.length);
				}
				
				//construct the new scan domain and initialization domain
				for(int i = 0; i < branch_for_merge.size(); i++){
					current_scan_domain = current_scan_domain.union(branch_for_merge.get(i).exp.getContextDomain().copy());
					initial_domain = initial_domain.difference(branch_for_merge.get(i).exp.getContextDomain().copy());
				}
			}
			
			scan_dom = current_scan_domain.copy();
		}
		
		//construct the updating vector
		info.addUpdatingVector(constructUpdatingVector(directions, main_scan_domain.copy(), target_list, varMaxDistanceMap));
		info.addScanDomain(scan_dom);
//		
//		//add initializaton information
		info.addInitialExpression(creatInitExpression(scan_dom, target_list, ori_varExpMap, varMaxDistanceMap, directions.get(0)));
		info.addInitialDoamin(createInitDomain(scan_dom, target_list, varMaxDistanceMap, directions.get(0)));
		
		info.ScanInfoPrint();
		
		return info;
		
	}
	
	private static Map<String, List<VectorInformation>>  createInitDomain(Domain scan_domain, List<VariableDeclaration> target_variables,HashMap<VariableDeclaration, Long> varMaxDistanceMap, Vector<Long> main_dir){
		Map<String, List<VectorInformation>> targetInitDomainMap = new HashMap<String, List<VectorInformation>>();
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration var = target_variables.get(i);
			List<VectorInformation> vecList = new LinkedList<VectorInformation>();
			ScanInformations info_obj = new ScanInformations();
			
			long max_gcd = varMaxDistanceMap.get(var);
			Domain cur_domain = scan_domain.copy();
			for(int j = 1; j <= max_gcd; j++){
				List<Long> dep_vector = new Vector();
				for(int k = 0; k < main_dir.size(); k++){
					dep_vector.add(k, main_dir.get(k)*j*(-1));
				}
				//create the uniform vector 
				AffineFunction dep_fun = PolyhedralIRUtility.createUniformFunction(scan_domain, dep_vector);
				//create the updating vector
				//moving the domain along opposite direction of the current vector
				Domain vector_domain = cur_domain.image(dep_fun).difference(cur_domain);
				cur_domain = cur_domain.union(vector_domain);
				
				VectorInformation vector = info_obj.createVector(var, dep_fun, j, vector_domain);
				vecList.add(vector);
			}
			targetInitDomainMap.put(var.getName(), vecList);
		}
		
				
		return targetInitDomainMap;
	}
	
	private static List<Expression> creatInitExpression(Domain scan_domain, List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, Expression> var_exp_map, HashMap<VariableDeclaration, Long> varMaxDistanceMap, Vector<Long> main_dir){
		List<Expression> init_exp_list = new LinkedList<Expression>();
		
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration var = target_variables.get(i);
			List<Expression> exprs = ((CaseExpression) var_exp_map.get(var)).getExprs();
			List<VectorInformation> vecList = new LinkedList<VectorInformation>();
			ScanInformations scan_info = new ScanInformations();
			
			//create a base vector
			AffineFunction base_fun = PolyhedralIRUtility.createUniformFunction(scan_domain, main_dir);
			Domain cur_domain = scan_domain.copy();
			for(int j = 1; j <= varMaxDistanceMap.get(var); j++){
				Domain init_domain = cur_domain.image(base_fun).difference(cur_domain);
				init_domain = init_domain.intersection(var.getDomain());
				cur_domain = cur_domain.union(init_domain);
				
				for(Expression exp: exprs){
					if(!exp.getContextDomain().intersection(init_domain).isEmpty()){
						Expression cur_exp = exp.copy();
						Expression init_exp = cur_exp.copy();
						if(init_exp instanceof RestrictExpression){
							init_exp = ((RestrictExpression)cur_exp).getExpr();
						}
						
						init_exp_list.add(init_exp);
						break;
					}
				}
			}
		}
		
		return init_exp_list;
	}
	
	/**
	 * Get the initialization domain for the main scan for one variable
	 * @param cur_scan_domain
	 * @param mainDir
	 * @param max_distance
	 * @return
	 */
	private static Domain getVariableInitDomain(Domain cur_scan_domain, Vector<Long> mainDir, Long max_distance){
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
	
	private static List<BranchInfo> extractMergedBranches(AffineSystem s, List<Vector<Long>> dirs, Domain cur_scan_domain, Domain cur_init_domain, VariableDeclaration var, Long max_distance, Expression cur_var_exp, Sermring cur_serm){
		List<BranchInfo> branch_for_merge = new LinkedList<BranchInfo>();
		
		List<VariableDeclaration> target_variables = new LinkedList<VariableDeclaration>();
		target_variables.add(var);
		//create the base moving vector
		List<Long> base_dir = new Vector();
		for(int i = 0; i < dirs.get(0).size(); i++){	//reverse the direction
			base_dir.add(dirs.get(0).get(i)*(-1));
		}
		AffineFunction base_func = PolyhedralIRUtility.createUniformFunction(cur_scan_domain, base_dir);
		
		//get the current expression
		CaseExpression cur_case = (CaseExpression)cur_var_exp;
		List<Expression> branches = cur_case.getExprs();
		
		Domain cur_domain = cur_scan_domain.copy();
		Vector<Long> newVec = null;
		for(int i = 0; i < max_distance; i++){
			Domain init_dom = cur_domain.image(base_func).difference(cur_domain).intersection(var.getDomain());
			cur_domain = cur_domain.union(init_dom);
			if(DEBUG){
				System.out.println("Current Initial Domain:" + init_dom);
			}
			
			for(Expression exp : branches){	//check all the branches
				//extract the current branch information
				BranchInformationExtraction branch_extractor = new BranchInformationExtraction(target_variables);
				branch_extractor.InformationExtraction(exp);
					
				boolean validate = true;
				//check the sermring, only one sermring is allowed in the current scan detection
				//TODO: this can be possiblly extended to support multiple sermring for each matrix
				validate = SermringUtilities.CheckSermring(branch_extractor.getSermringList(), cur_serm);
					
				if(!validate){
					continue;
				}
					
				BranchInfo branch_info = new BranchInfo();
				branch_info.exp = exp.copy();
				
				List<AffineFunction> function_list = branch_extractor.getVariableFunctionMap().get(var);
				//seperate the uniform function and non uniform functions
				List<AffineFunction> uniform_list = new LinkedList<AffineFunction>();
				List<AffineFunction> affine_list = new LinkedList<AffineFunction>();
					
				for(AffineFunction af : function_list){
					if(af.isUniform()){
						uniform_list.add(af.copy());
					}else{
						affine_list.add(af.copy());
					}
				}
				
				//check all the uniform dependence must have the same direction as the main direction
				if(uniform_list.size() > 0){
					Vector<Long> uniform_dir = ExtractUniDirection(var, uniform_list, branch_info);
					if(!ScanUtilities.VectorEqual(uniform_dir, dirs.get(0))){
						validate = false;
					}
				}
				
				//check is all the non-uniform dependence can be used to extract the same direction	
				if(affine_list.size() > 0){
					AffineFunction af_first = affine_list.get(0);
					Vector<Long> newDirect = NewDirectionExtraction(s.getParameters(), cur_domain.copy(), exp.getContextDomain().copy(), af_first, dirs);
					if(newDirect != null){
						if(newVec == null){
							newVec = newDirect;
						}else{
							if(!ScanUtilities.VectorEqual(newVec, newDirect)){
								System.out.println("New direction extraction failed!");
								validate = false;
							}
						}
					}
				}else{
					validate = false;
				}
					
				if(!validate){
					continue;
				}
					
				if(newVec == null){
					validate = false;
					continue;
				}
					
				for(int k = 1; k < affine_list.size(); k++){
					AffineFunction af = affine_list.get(k);
					Vector<Long> new_direct_extracted = NewDirectionExtraction(s.getParameters(), cur_domain.copy(), exp.getContextDomain().copy(), af, dirs);
					if(new_direct_extracted == null){
						System.out.println("New Direction extraction failed!!");
						validate = false;
						break;
					}else{
						if(!newVec.equals(new_direct_extracted)){
							System.out.println("New Direction extraction failed!");
							validate = false;
							break;
						}
					}
				}
					
				if(validate){	//save the branch informations
						if(DEBUG){
							System.out.println("new direction extracted: " + newVec.toString());
						}
						//save the branch information
						HashMap<Long, AffineFunction> affine_gcd_map = new HashMap<Long, AffineFunction>();
						for(int k = 1; k < affine_list.size(); i++){
							affine_gcd_map.put(Long.valueOf(k)*(-1), affine_list.get(k));
						}
						if(branch_info.varFuncGcdMap.get(var) == null || branch_info.varFuncGcdMap.get(var).size() == 0){
							branch_info.varFuncGcdMap.put(var, new HashMap<Long, AffineFunction>());
						}
						branch_info.varFuncGcdMap.get(var).putAll(affine_gcd_map);
						branch_info.branch_varMaxGcdMap.put(var, Long.valueOf(i));
						branch_info.baseDir = newVec;
						branch_for_merge.add(branch_info);
				}
			}
			
		}
		
		
		
		return branch_for_merge;
	}
	
	/**
	 * Construct the coefficient matrix for the scan with current branch informations
	 * @param target_variables
	 * @param branch_map
	 * @param varMaxDistanceMap
	 * @return
	 */
	private static Expression[][] constructScanCoefficientMatrix(List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, BranchInfo> branch_map, HashMap<VariableDeclaration, Long> varMaxDistanceMap){
		//compute the matrix size
		int nrow = 1;
		for(int i = 0; i < target_variables.size(); i++){
			nrow += varMaxDistanceMap.get(target_variables.get(i));
		}
		int ncol = nrow;
		Expression[][] matrix = new Expression[nrow][ncol];
		
		//Extract the coefficient for ech variable
		int cur_row = -1;
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration cur_var = target_variables.get(i);
			BranchInfo cur_branch = branch_map.get(cur_var);
			Expression cur_exp  = cur_branch.exp;
			Sermring cur_serm = cur_branch.branch_serm;
			cur_row++;
			if(DEBUG){
				System.out.println("get the coefficient for variable " + cur_var.getName());
			}
					
			//sort the dependence function according to the gcds
			Vector<Expression> coeVec = new Vector<Expression>();
			int cur_col = -1;
			for(int j = 0; j < target_variables.size(); j++){
				VariableDeclaration var_tmp_target = target_variables.get(j);
						
				long max_gcd = varMaxDistanceMap.get(var_tmp_target);
						
				Map<Long, AffineFunction> cur_GcdFuncMap = cur_branch.varFuncGcdMap.get(var_tmp_target);
						
				for(int k = 1; k <= max_gcd; k++){
					cur_col++;
					if(cur_GcdFuncMap.get(Long.valueOf(k)) == null){
						IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						matrix[cur_row][cur_col] = exp;
						//System.out.println("Coef for " +  var_tmp_target.getName() + " and recurrence function with gcd: " + k + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
					}else{
						Expression e_tmp = cur_exp.copy();
						Expression exp_tmp = ExtractVarCoe(e_tmp, var_tmp_target, cur_GcdFuncMap.get(Long.valueOf(k)), cur_serm, target_variables);
						matrix[cur_row][cur_col] = exp_tmp;
						//System.out.println("Coef for variable " + var_tmp_target.getName() +  " recurrence function: " + cur_GcdFuncMap.get(Long.valueOf(k)) + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
					}
				}
			}
			//extract coefficient for constant
			Expression e_tmp2 = cur_exp.copy();
			Expression con_exp = ExtractConstantCoe(e_tmp2, cur_serm, target_variables);
			matrix[cur_row][ncol-1] = con_exp.copy();
			//System.out.println("Coef for constant is :"+ PolyhedralIRToAlphabets.toSimplifiedString(con_exp));
			long cur_var_gcd = varMaxDistanceMap.get(cur_var);
			
			//construct the rows to shift the other values 
			for(int k = 1; k < cur_var_gcd; k++){
				cur_row++;
				//get the current shifted value position
				int pos = 0;
				for(int j = 0; j < i; j++){
					pos += varMaxDistanceMap.get(target_variables.get(j));
				}
				pos += k-1;
				//all the coefficent are set to 0 expression except the current position variable
				for(int j = 0; j < ncol; j++){
					if(j != pos){
						IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						matrix[cur_row][j] = exp.copy();
					}else{
						IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
						matrix[cur_row][j] = exp.copy();
					}
				}
			}		
		}
		
		//create coefficient for the last constant row
		//all the coefficients are 0 except the last element
		cur_row++;
		for(int i = 0; i < ncol-1; i++){
			IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
			matrix[cur_row][i] = exp.copy();
		}
		IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
		matrix[cur_row][ncol-1] = exp.copy();
		
		return matrix;
	}
	
	/**
	 * Extract the coefficient matrix for the merged initialization branch
	 * @param var
	 * @param max_distance
	 * @param branch
	 * @return
	 */
	private static Expression[][] constructInitCoefficientMatrix(VariableDeclaration var, Long max_distance, BranchInfo branch){
		int nrow = 0;
		int ncol = 0;
		
		nrow += max_distance + 1;
		ncol = nrow;
		
		Expression[][] matrix = new Expression[nrow][ncol];
		
		int cur_row = 0;
		long cur_dis = branch.branch_varMaxGcdMap.get(var);
		Map<Long, AffineFunction> cur_GcdFuncMap = branch.varFuncGcdMap.get(var);
		List<VariableDeclaration> target_variables = new LinkedList<VariableDeclaration>();
		Sermring cur_serm = branch.branch_serm;
		
		int cur_col = -1;
		for(int i = 1; i <= cur_dis; i++){	//get coefficient for the non-uniform dependence
			cur_col ++;
			long cur_var = Long.valueOf(i)*(-1);
			if(cur_GcdFuncMap.get(Long.valueOf(cur_var)) == null){
				IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
				matrix[cur_row][cur_col] = exp;
				//System.out.println("Coef for " +  var_tmp_target.getName() + " and recurrence function with gcd: " + k + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
			}else{
				Expression e_tmp = branch.exp.copy();
				Expression exp_tmp = ExtractVarCoe(e_tmp, var, cur_GcdFuncMap.get(cur_var), cur_serm, target_variables);
				matrix[cur_row][cur_col] = exp_tmp;
				//System.out.println("Coef for variable " + var_tmp_target.getName() +  " recurrence function: " + cur_GcdFuncMap.get(Long.valueOf(k)) + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
			}
		}
		//get coefficient for the uniform dependence
		for(int i = 1; i <= (max_distance - cur_dis); i ++){
			cur_col ++;
			if(cur_GcdFuncMap.get(Long.valueOf(i)) == null){
				IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
				matrix[cur_row][cur_col] = exp;
				//System.out.println("Coef for " +  var_tmp_target.getName() + " and recurrence function with gcd: " + k + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
			}else{
				Expression e_tmp = branch.exp.copy();
				Expression exp_tmp = ExtractVarCoe(e_tmp, var, cur_GcdFuncMap.get(Long.valueOf(i)), cur_serm, target_variables);
				matrix[cur_row][cur_col] = exp_tmp;
				//System.out.println("Coef for variable " + var_tmp_target.getName() +  " recurrence function: " + cur_GcdFuncMap.get(Long.valueOf(k)) + " is " + PolyhedralIRToAlphabets.toSimplifiedString(matrix[cur_row][k-1]));
			}
		}
		
		//extract coefficient for constant
		Expression e_tmp2 = branch.exp.copy();
		Expression con_exp = ExtractConstantCoe(e_tmp2, cur_serm, target_variables);
		matrix[cur_row][ncol-1] = con_exp.copy();
		
		//construct the rest matrix
		//construct the rows to shift the other values 
		for(int k = 0; k < max_distance-1; k++){
			cur_row++;
			//all the coefficent are set to 0 expression except the current position variable
			for(int j = 0; j < ncol; j++){
				if(j != k){
					IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
					matrix[cur_row][j] = exp.copy();
				}else{
					IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
					matrix[cur_row][j] = exp.copy();
				}
			}
		}		
		
		//construct the last row of the matrix
		//all the coefficients are 0 except the last element
		cur_row++;
		for(int i = 0; i < ncol-1; i++){
			IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
			matrix[cur_row][i] = exp.copy();
		}
		IntegerExpression exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
		matrix[cur_row][ncol-1] = exp.copy();
		
		return matrix;
	}
	
	/**
	 * Get the maximum distance for the uniform dependence for each variable along the main direction
	 * (i->i-2) (i->i-4) the maximum distance is 4
	 * @param target_variables
	 * @param branch_map
	 * @return
	 */
	private static HashMap<VariableDeclaration, Long> getVarMaxDistance(List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, BranchInfo> branch_map){
		HashMap<VariableDeclaration, Long> varMaxDistance = new HashMap<VariableDeclaration, Long>();
		
		//get the maximum distance for each variable
		for(int i = 0; i < target_variables.size(); i++){
			long max_gcd = 0;
			VariableDeclaration cur_var = target_variables.get(i);
			for(int j = 0; j < target_variables.size(); j++){
				BranchInfo cur_branch = branch_map.get(target_variables.get(j));
				long gcd = cur_branch.branch_varMaxGcdMap.get(cur_var);
				if(gcd > max_gcd)	max_gcd = gcd;
			}
			varMaxDistance.put(cur_var, max_gcd);
		}
		
		return varMaxDistance;
	}
	
	/**
	 * Construct the updating vector
	 * The updating vector is in the form like (x-1, x-2, x-3, y-1, y-2, 1)
	 * All the elements involves the same scan variable is close to each other, then move on to the next scan variable, the last element is the constant
	 * @param dirs
	 * @param domain
	 * @param target_variables
	 * @param varMaxGcdMap
	 * @return
	 */
	private static List<VectorInformation> constructUpdatingVector(List<Vector<Long>> dirs, Domain domain, List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, Long> varMaxGcdMap){
		List<VectorInformation> updating_vector = new LinkedList<VectorInformation>();
		ScanInformations info_obj = new ScanInformations();
		
		//construct the affine function for each variable for all vector within distance
		Vector<Long> main_dir = dirs.get(0);
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration var = target_variables.get(i);
			long max_gcd = varMaxGcdMap.get(var);
			Domain variable_domain = domain.copy();
			for(int j = 1; j <= max_gcd; j++){
				List<Long> dep_vector = new Vector();
				for(int k = 0; k < main_dir.size(); k++){
					dep_vector.add(k, main_dir.get(k)*j*(-1));
				}
				//create the uniform vector 
				AffineFunction dep_fun = PolyhedralIRUtility.createUniformFunction(domain, dep_vector);
				//create the updating vector
				//moving the domain along opposite direction of the current vector
				Domain temp_domain = variable_domain.image(dep_fun);
				Domain vector_domain = temp_domain.difference(variable_domain);
				variable_domain = temp_domain.union(variable_domain);
					
				VectorInformation vector = info_obj.createVector(var, dep_fun, j, vector_domain);
				updating_vector.add(vector);
			}
		}
		
		return updating_vector;
	}
	
	/**
	 * All the branches must have the same sermring
	 * @param target_variables
	 * @param branch_map
	 * @return
	 */
	private static Sermring getScanSermring(List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, BranchInfo> branch_map){
		Sermring scan_serm = null;
		
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration var = target_variables.get(i);
			Sermring serm = branch_map.get(var).branch_serm;
			if(scan_serm == null){
				scan_serm = serm;
			}else{
				if(!SermringUtilities.CheckSermring(scan_serm, serm)){
					return null;
				}
			}
		}
		return scan_serm;
	}
	
	/**
	 * All the main branches must have the same base direction
	 * @param target_variables
	 * @param branch_map
	 * @return
	 */
	private static Vector<Long> getMainDirection(List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, BranchInfo> branch_map){
		Vector<Long> dir = null;
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration var = target_variables.get(i);
			Vector<Long> branch_dir = branch_map.get(var).baseDir;
			if(dir == null){
				dir = branch_dir;
			}else{
				if(!ScanUtilities.VectorEqual(branch_dir, dir)){
					return null;
				}
			}
		}
		
		return dir;
	}
	
	private static Vector<Long> getCommonDirection(List<BranchInfo> branch_info){
		Vector<Long> dir = null;
		for(int i = 0; i < branch_info.size(); i++){
			Vector<Long> branch_dir = branch_info.get(i).baseDir;
			if(dir == null){
				dir = branch_dir;
			}else{
				if(!ScanUtilities.VectorEqual(branch_dir, dir)){
					return null;
				}
			}
		}
		
		return dir;
	}
	
	/**
	 * Extract the informations for the branches that involves with the main scan for each variable
	 * The information includes the list of uniform dependence, the serming extracted for the current branch and the base uniform direction
	 * @param s
	 * @param domain
	 * @param target_variables
	 * @param var_exp_map
	 * @return
	 */
	private static HashMap<VariableDeclaration, BranchInfo> ExtractMainScanBranch(AffineSystem s, Domain domain, List<VariableDeclaration> target_variables, HashMap<VariableDeclaration, Expression> var_exp_map){
		HashMap<VariableDeclaration, BranchInfo> mainScanBranchInfoMap = new HashMap<VariableDeclaration, BranchInfo>();
		Sermring scan_serm = null;
		//get the uniform recurrence branch for each recurrence variable
		for(int i = 0; i < target_variables.size(); i++){
			VariableDeclaration cur_var = target_variables.get(i);
			CaseExpression cur_case = (CaseExpression)var_exp_map.get(cur_var);
			if (cur_case == null)
				continue;
					
			for(Expression e: cur_case.getExprs()){
				if (e.getContextDomain().getNIndices() != domain.getNIndices())
					continue;
				
				if(!e.getContextDomain().intersection(domain).isEmpty()){//the correct branch
					BranchInfo braInfo = new BranchInfo();
					braInfo.exp = e.copy();
					
					//extract the current branch information
					BranchInformationExtraction branch_extractor = new BranchInformationExtraction(target_variables);
					branch_extractor.InformationExtraction(e);
					
					boolean validate = true;
					
					//check scan direction 
					Vector<Long> dir = null;
					for(int j = 0; j < target_variables.size(); j++){
						VariableDeclaration var_tmp = target_variables.get(j);
						List<AffineFunction> list_tmp = branch_extractor.getVariableFunctionMap().get(var_tmp);
						if(list_tmp.size() > 0){
							Vector<Long> cur_dir = ExtractUniDirection(var_tmp, list_tmp, braInfo);
							if(cur_dir == null){
								validate = false;
								break;
							}
							
							if(dir == null){
								dir = cur_dir;
							}else{
								if(!ScanUtilities.VectorEqual(dir, cur_dir)){
									validate = false;
									break;
								}
							}
						}
					}
					
					braInfo.baseDir = dir;
					
					//check sermring list
					if(scan_serm == null){
						scan_serm = SermringUtilities.GetSermring(branch_extractor.getSermringList());
						if(scan_serm == null){
							validate = false;
						}
					}else{
						validate = SermringUtilities.CheckSermring(branch_extractor.getSermringList(), scan_serm);
					}
					
					if(!validate){
						return null;
					}
					
					if(DEBUG){
						System.out.println("branch " + PolyhedralIRToAlphabets.toSimplifiedString(e) + "is a valid scan");
						braInfo.branchInfoPrinter();
					}
					
					braInfo.branch_serm = scan_serm;
					
					mainScanBranchInfoMap.put(cur_var, braInfo);
					
					break;
				}
			}
		}
		
		return mainScanBranchInfoMap;
	}
	
	/**
	 * Extract out one base direction among all the affine functions
	 * The affine functions has to be uniform
	 * (i,j->i-1, j-1) (i,j->i-2,j-2) the base vector extracted is (1, 1)
	 * @param v
	 * @param affine_list
	 * @param braInfo
	 * @return
	 */
	private static Vector<Long> ExtractUniDirection(VariableDeclaration v, List<AffineFunction> affine_list, BranchInfo braInfo){
		if(DEBUG){
			System.out.println("The list of uniform affine function for extraction");
			for(int i = 0; i < affine_list.size(); i++){
				System.out.println(affine_list.get(i));
			}
		}
		
		Vector<Long> depVec = null;
		Vector<Long> baseDep = new Vector<Long>();
		Map<Long,AffineFunction> varMap = new HashMap<Long, AffineFunction>();
		AffineFunction af = null;
		long gcd_tmp = 0;
		long max_gcd = 0;
		
	
		boolean OneDir = true;
		
		af = affine_list.get(0);
		if(!af.isUniform()){
			return null;
		}
		
		depVec = ScanUtilities.GetDepVector(af);
		
		//System.out.println("The dependence vector:" + depVec);
		gcd_tmp = ScanUtilities.GetGcd(depVec);
		varMap.put(gcd_tmp, af);
		System.out.println("the gcd for dependence vector: " + depVec + " is " + gcd_tmp);
		max_gcd = gcd_tmp;
	
		//get the basic dependence vector
		for(int i = 0; i < depVec.size(); i++){
			baseDep.add(depVec.get(i)/gcd_tmp);
		}
		
		//get the uniform dependence
		for(int i = 1; i < affine_list.size(); i++){
			af = affine_list.get(i);
			if(!af.isUniform()){
				return null;
			}
			depVec = ScanUtilities.GetDepVector(af);
			gcd_tmp = ScanUtilities.GetGcd(depVec);
			//System.out.println("the gcd for affine function " +  af + " dependence vector: " + depVec + " is " + gcd_tmp);
			varMap.put(gcd_tmp, af);
			if(gcd_tmp > max_gcd){
				max_gcd = gcd_tmp;
			}
			
			List<Long> tmpDep = new Vector<Long>();
			for(int j = 0; j < depVec.size(); j++){
				tmpDep.add(depVec.get(j)/gcd_tmp);
			}
			
			if(!tmpDep.equals(baseDep)){
				OneDir = false;
			}
		}
		
		if(OneDir){
			braInfo.varFuncGcdMap.put(v, varMap);
			braInfo.branch_varMaxGcdMap.put(v, max_gcd);
		}
		
		return baseDep;
	}
	
	
	/**
	 * Extract a new direction e with Scan domain Ds, init domain Dg and affine function f, with a set of directions e_i
	 * construct a pip problem that for any point z in Dg, z -e = f(z) - sum (u_i*e_i), f(z) in Ds
	 * compute the lexmax for the domain with {u, z, e}
	 * @param param_dom
	 * @param scan_dom
	 * @param init_dom
	 * @param dep
	 * @param directions
	 * @return
	 */
	private static Vector<Long> NewDirectionExtraction(ParameterDomain param_dom, Domain scan_dom, Domain init_dom, AffineFunction dep, List<Vector<Long>> directions){
		Domain paramDom = extendedDomainWithAffineFunction(param_dom, init_dom, scan_dom, dep);
		
		int nIndices = scan_dom.getNIndices();
		//construct the empty domain for u and v
		String dom_str = "{";
		for(int i = 0; i < directions.size(); i++){
			dom_str += "u" + i + ",";
		}
		//the new indices
		for(int i = 0; i < nIndices; i++){
			dom_str += "i"+i + ",";
		}
		for(int i = 0; i < nIndices-1; i++){
			dom_str += "v" + i + ",";
		}
		dom_str += "v" + (nIndices-1) + "|}";
		if(DEBUG){
			System.out.println("The original init domain:" + init_dom);
			System.out.println("The original scan domain:" + scan_dom);
			System.out.println("The new parameter domain:" + paramDom);
			System.out.println("The directions:" + directions.toString());
		}
		//create the empty domain
		Domain empty_domain = PolyhedralIRUtility.parseDomain(param_dom, dom_str);
		if(DEBUG){
			System.out.println("Empty domain: " + empty_domain);
		}
		//extends the domain
		Domain extendedDomain = DomainOperations.extendParameterDomain(empty_domain, paramDom);
		if(DEBUG){
			System.out.println("The extended Domain:" + extendedDomain);
		}
		
		//get different index num
		int nParams = param_dom.getNParams();
		int nInitIndices = init_dom.getNIndices();
		int nScanIndices = scan_dom.getNIndices();
		int nMu = directions.size();
		int nNewIndices = nInitIndices;
		int nDirectionDim = nInitIndices;
		
		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
		
		
		//add the original constraint and the constraint for u
		List<Matrix> oriMatrices = extendedDomain.getPMdomain().toMatrices();
		for(Matrix mat : oriMatrices){
			for(MatrixRow row : mat.getRows()){
				//add the original constraint
				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
			}
		}
		
		if(DEBUG){
			System.out.println("The original constraint");
			for(IntConstraint str: constraints){
				System.out.println(str);
			}
		}
		
		//get the basic matix row
		MatrixRow basicRow = extendedDomain.getPMdomain().toMatrices().get(0).getRows().get(0);
		
		//add constraints for the min
		List<Matrix> matrices = scan_dom.getPMdomain().toMatrices();
		for(Matrix mat : matrices){
			for(MatrixRow matrow : mat.getRows()){
				MatrixRow row = EcoreUtil.copy(basicRow);
				int basic = 0;
				int oriBasic = 0;
				row.set(basic, matrow.get(oriBasic));
				basic += 1;
				oriBasic += 1;
				//set the param
				for(int j = 0; j < nParams; j++){
					row.set(basic+j, matrow.get(oriBasic+j));
				}
				basic += nParams;
				oriBasic += nParams;
				//set the i_p
				for(int j = 0; j < nInitIndices; j++){
					row.set(basic+j, 0);
				}
				basic += nInitIndices;
				//set the i_t_p and u
				for(int j = 0; j < nScanIndices+nMu; j++){
					row.set(basic+j, 0);
				}
				for(int j = 0; j < nScanIndices; j++){
					long coef = matrow.get(oriBasic+j);
					if(coef != 0){
						row.set(basic + j, coef);
						for(int k = 0; k < nMu; k++){
							long cur_coef = row.get(basic+nScanIndices+k);
							cur_coef -= coef*directions.get(k).get(j);
							row.set(basic+nScanIndices+k, cur_coef);
						}
					}
				}
				oriBasic += nScanIndices;
				basic += (nScanIndices + nMu);
				//set new indices and v
				for(int j = 0; j < nNewIndices +nDirectionDim; j++){
					row.set(basic + j, 0);
				}
				basic += nNewIndices + nDirectionDim;
				//set the constant coef
				row.set(basic, matrow.get(oriBasic));
				
				constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
			}
		}
		
		if(DEBUG){
			System.out.println("Constrains after add constraints for min");
			for(IntConstraint str : constraints){
				System.out.println(str);
			}
		}
		//add constraints for the new indices
		for(int i = 0; i < nNewIndices; i++){
			MatrixRow row = EcoreUtil.copy(basicRow);
			//set the equality
			int basic = 0;
			row.set(basic, 0);
			basic += 1;
			//set the parameters
			for(int j = 0; j < nParams; j++){
				row.set(basic+j, 0);
			}
			basic += nParams;
			//set the init indices as 0
			for(int j = 0; j < nInitIndices; j++){
				row.set(basic + j, 0);
			}
			basic += nInitIndices;
			//set the scan indices
			for(int j = 0; j < nScanIndices; j++){
				if(i == j){
					row.set(basic+j, 1);
				}else{
					row.set(basic+j, 0);
				}
			}
			basic += nScanIndices;
			//set the u indices
			for(int j = 0; j < nMu; j++){
				row.set(basic+j, -directions.get(j).get(i));
			}
			basic += nMu;
			//set the new indices
			for(int j = 0; j < nNewIndices; j++){
				if(i == j){
					row.set(basic+j, -1);
				}else{
					row.set(0, 0);
				}
			}
			basic += nNewIndices;
			//set the v indices
			for(int j = 0; j < nDirectionDim; j++){
				row.set(basic + j, 0);
			}
			basic += nDirectionDim;
			//set the constant
			row.set(basic, 0);
			
			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
		}
		
		if(DEBUG){
			System.out.println("Constraints after add constraints for new indices");
			for(IntConstraint str : constraints){
				System.out.println(str);
			}
		}
		
		//add constraints for v
		for(int i = 0; i < nDirectionDim; i++){
			MatrixRow row = EcoreUtil.copy(basicRow);
			int basic = 0;
			//set the constraint as equality
			row.set(basic, 0);
			basic += 1;
			for(int j = 0; j < nParams; j++){
				row.set(basic + j, 0);
			}
			basic += nParams;
			//set constraint for vi=i-i' 
			//set constraint for i
			for(int j = 0; j < nInitIndices; j++){
				if(i == j){
					row.set(basic + j, 1);
				}else{
					row.set(basic + j, 0);
				}
			}
			basic += nInitIndices;
			//set constraint for indice of scan dom
			for(int j = 0; j < nScanIndices; j++ ){
				row.set(basic + j, 0);
			}
			basic += nScanIndices;
			//set constraint for u
			for(int j = 0; j < nMu; j++){
				row.set(basic + j, 0);
			}
			basic += nMu;
			//set constraint for i'
			for(int j = 0; j < nNewIndices; j++){
				if(i == j){
					row.set(basic + j, -1);
				}else{
					row.set(basic + j, 0);
				}
			}
			basic += nNewIndices;
			//set costraint for v
			for(int j = 0; j < nDirectionDim; j++){
				if(i == j){
					row.set(basic + j, -1);
				}else{
					row.set(basic + j, 0);
				}
			}
			basic += nDirectionDim;
			row.set(basic, 0);
			
			constraints.add(row.toConstraint(extendedDomain.getParams(), extendedDomain.getIndices()));
		}
		
		if(DEBUG){
			System.out.println("The new constraint set:");
			for(int i = 0; i < constraints.size(); i++){
				System.out.println(constraints.get(i));
			}
		}
		//construct the domain for the problem
		List<List<IntConstraint>> cons = new LinkedList<List<IntConstraint>>();
		cons.add(constraints);
		Domain pipDom = PolyhedralIRUserFactory.eINSTANCE.createDomainFromConstraints(extendedDomain.getParams(), extendedDomain.getIndices(), cons);
		if(DEBUG){
			System.out.println("The constructed domain for pip: " + pipDom);
		}
		//get the lexi max of the domain
		org.polymodel.Domain lexmax = ((ISLSet)pipDom.getPMdomain()).lexMax();
		if(DEBUG){
			System.out.println("The lexmax of the domain: " + lexmax);
		}
		
		Vector<Long> direct = new Vector<Long>();
		Vector<Long> dirSet = new Vector<Long>();
		for(int i = 0; i < nDirectionDim; i++){
			direct.add(0L);
			dirSet.add(-1L);
		}
		//get the new direction if it exist an equality for v where it is uniform
		List<Matrix> maxMatrices = lexmax.toMatrices();
		for(Matrix mat : maxMatrices){
			for(MatrixRow row : mat.getRows()){
				if(row.get(0) == 0){	//check equality
					int nNonDirect = nParams + nInitIndices + nScanIndices + nMu + nNewIndices + 1;
					boolean validate = true;
					for(int i = 1; i < nNonDirect; i++){
						if(row.get(i) != 0){
							validate = false;
							break;
						}
					}
					if(validate){
						int index = -1;
						for(int i = 0; i < nDirectionDim; i++){
							if(row.get(nNonDirect + i) != 0){
								index = i;
								break;
							}
						}
						if(index == -1){
							validate = false;
						}
						if(validate){
							for(int i = 0; i < nDirectionDim; i++){
								if(i != index){
									if(row.get(nNonDirect + i) != 0){
										validate = false;
										break;
									}
								}
							}
						}
						
						if(validate){//get the direction
							long constant = -row.get(nNonDirect + nDirectionDim);
							long dir_coef = row.get(nNonDirect + index);
							long coef = (long)(constant/dir_coef);
							dirSet.set(index, 0L);
							direct.set(index, coef);
						}
					}
				}
			}
		}
		
		for(int i = 0; i < nDirectionDim; i++){
			if(dirSet.get(i) == -1){
				System.out.println("Direction extraction failed!");
				return null;
			}
		}
		if(DEBUG){
			System.out.println("The new direction:" + direct.toString());
		}
		return direct;
	}
	
	public static void main(String[] argc) {
		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		Domain start = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=(i,j)<N}");
		Domain end = PolyhedralIRUtility.parseDomain(param, "{x,y|0<=(x,y)<N}");
		System.out.println(extendedDomainWithAffineFunction(param, start, end, PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i-1,j)")));
	}
	
	private static Domain extendedDomainWithAffineFunction(ParameterDomain param_dom, Domain start_dom, Domain end_dom, AffineFunction dep){
		int nParams = param_dom.getNParams();
		int nStartIndices = start_dom.getNIndices();
		int nEndIndices = end_dom.getNIndices();
		
		if(DEBUG){
			System.out.println("The start domain: " + start_dom);
			System.out.println("The end domain:" + end_dom);
			System.out.println("The affine function:" + dep);
		}

		//1. Extend start domain with end_dom so that all constraints in end_dom becomes parameter
		//2. Then constraint the new parameters with the expression in the given function 
		
		Domain exDom = DomainOperations.extendParameterDomain(start_dom, end_dom);
		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(param_dom, exDom, 
				new Constraint(PolyhedralIRUtility.createIdentityFunction(start_dom), dep, ComparisonOperator.EQ));
		
		return exDom;
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
	}
	
	
	private static Expression ExtractVarCoe(Expression exp, VariableDeclaration target, AffineFunction af, Sermring s, List<VariableDeclaration> recur_list){
		
		CoeficientExtraction Coe = new CoeficientExtraction(target, af, s, recur_list);

		return Coe.VarCoe(exp);
	}
	
	private static Expression ExtractConstantCoe(Expression exp, Sermring s, List<VariableDeclaration> recur_list){
		CoeficientExtraction Coe = new CoeficientExtraction(s, recur_list);

		return Coe.ConstantCoe(exp);
	}
	
	
	
	private static class BranchInfo{
		private Expression exp;
		private Map<VariableDeclaration, Map<Long, AffineFunction>> varFuncGcdMap;
		private Map<VariableDeclaration, Long> branch_varMaxGcdMap;
		private Vector<Long> baseDir;
		private Sermring branch_serm;
		
		public BranchInfo(){
			exp = null;
			branch_serm = null;
			varFuncGcdMap = new HashMap<VariableDeclaration, Map<Long, AffineFunction>>();
			branch_varMaxGcdMap = new HashMap<VariableDeclaration, Long>();
			baseDir = new Vector();
		}
		
		public void branchInfoPrinter(){
			System.out.println("The information for branch: " + PolyhedralIRToAlphabets.toSimplifiedString(exp));
			System.out.println("Variable Function Gcd list");
			
			Iterator iterator1= varFuncGcdMap.entrySet().iterator();
			 
	        for (Map.Entry entry : varFuncGcdMap.entrySet()) {
	        	System.out.println("variable : " + entry.getKey());
	        	HashMap<Long, AffineFunction> temp = (HashMap<Long, AffineFunction>)entry.getValue();
	        	Iterator iterator2=temp.entrySet().iterator();
	        	
	        	for (Map.Entry entry1 : temp.entrySet()) {
	        		System.out.println("gcd : " + entry1.getKey() + " affine function: " + (AffineFunction)entry1.getValue());
	        	}
	        }
		}
	}
}
