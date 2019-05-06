package org.polymodel.polyhedralIR.polyIRCG.generator.C.scan;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sum;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ScanCodeGenInfo.scanOutput;
import org.polymodel.polyhedralIR.recurrence.ScanInformations;
import org.polymodel.polyhedralIR.recurrence.ScanInformations.MatrixInformation;
import org.polymodel.polyhedralIR.recurrence.ScanInformations.VectorInformation;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;



public class TransformationsForScanC extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	private static boolean DEBUG = true;
	
	private AffineSystem reductionBodySystem;
	private AffineSystem scanBodySystem;
	private AffineSystem mainBodySystem;
	private AffineSystem _currentSystem;
	private ScanInformations scan_information;
	private ScanCodeGenInfo codeGenInfo;
	private static boolean isReduction = false;
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;
	
	//definition for the bastraction matrix
	private static final int Z = 0;
	private static final int I = 1;
	private static final int C = 2;
	private static final int V = 3;
	
	public TransformationsForScanC(AffineSystem system, ScanInformations scan_info){
		reductionBodySystem = system;
		scanBodySystem = EcoreUtil.copy(system);
		mainBodySystem = EcoreUtil.copy(system);
		scan_information = scan_info;
		
		Program pro = PolyhedralIRUserFactory.eINSTANCE.createProgram();
		pro.getSystems().add(reductionBodySystem);
		pro.getSystems().add(scanBodySystem);
		pro.getSystems().add(mainBodySystem);
		
		//construct the output information
		codeGenInfo = new ScanCodeGenInfo();
		codeGenInfo.setOPlus(scan_information.getOPlus());
		codeGenInfo.setOtimes(scan_information.getOTimes());
		codeGenInfo.setInitVector(scan_information.getInitialExpression());
		codeGenInfo.setDomain(scan_information.getScanDomain());
		codeGenInfo.setSize(scan_information.getMatrixSize());
	}
	
	public static ScanCodeGenInfo transformationsForReductionC(AffineSystem system, ScanInformations scan_info){
		TransformationsForScanC trans = new TransformationsForScanC(system, scan_info);
		isReduction = true;
		trans.ReductionTransformation();
		trans.MainBodyTransformation();
		
		return trans.getScanCodeGenInfo();
	}
	
	public static ScanCodeGenInfo transformationsForScanC(AffineSystem system, ScanInformations scan_info){
		TransformationsForScanC trans = new TransformationsForScanC(system, scan_info);
		trans.ReductionTransformation();
		trans.MainBodyTransformation();
		trans.ScanTransformation();
		
		
		return trans.getScanCodeGenInfo();
	}
	
	protected ScanCodeGenInfo getScanCodeGenInfo(){
		return codeGenInfo;
	}
	
	/**
	 * Adds begin and end to the parameter domain with the LB and UB of the first dimension of the bounding domain as its LB of begin and UB of end.
	 * 
	 * @param origParam
	 * @param boundingDom
	 * @return
	 */
	protected ParameterDomain addBeginAndEndToParameterDomain(ParameterDomain origParam, Domain boundingDom) {
		if(DEBUG){
			System.out.println("The original parameter domain:" + origParam);
			System.out.println("The bounding domain:" + boundingDom);
		}
		
		ParameterDomain newParam = origParam.copy().toParameterDomain();
		newParam.addParameterDimension("begin");
		newParam.addParameterDimension("end");
		
		//get the two variable objects
		Variable beginVar = newParam.getParams().get(newParam.getNParams()-2);
		Variable endVar = newParam.getParams().get(newParam.getNParams()-1);
		
		//add the constraints for begin and end
		IntConstraint beginC = constraint(boundingDom.getBounds(0).get(0), affine(term(beginVar)), ComparisonOperator.LE);
		IntConstraint endC = constraint(affine(term(endVar)), sum(boundingDom.getBounds(0).get(1), constant(1)), ComparisonOperator.LE);
		newParam.getPMdomain().addConstraint(beginC);
		newParam.getPMdomain().addConstraint(endC);
		
		return newParam;
	}
	
	/**
	 * Extends the parameter domain of the given domain with the given parameter domain.
	 * The parameters in the new parameters must be a superset of the original parameter domain.
	 * The two domains will have parameters and indices added, and then intersected.
	 * 
	 * @param origDomain
	 * @param newParam
	 * @return
	 */
	protected Domain extendParameterDomainOfDomain(Domain origDomain, ParameterDomain newParam) {
		Domain dom = origDomain.copy();
		Domain pdom = newParam.copy();
		
		//add the missing parameter indices to the domain
		for (int i = dom.getNParams(); i < newParam.getNParams(); i++) {
			dom.addParameterDimension(newParam.getParamNames().get(i));
		}
		
		//add the missing indices to the parameter domain
		for (int i = 0; i < origDomain.getNIndices(); i++) {
			pdom.addDimension(origDomain.getIndexNames().get(i));
		}
		
		//then intersect
		return dom.intersection(pdom);
	}
	
	/**
	 * Adds two constraints to the domain such that;
	 * 
	 * begin <= var < end
	 * 
	 * where begin and end are assumed to be the last two parameter dimensions.
	 * 
	 * @param domain
	 * @param var
	 * @return
	 */
	protected void constraintByBeginAndEnd(Domain domain, Variable var) {
		assert(domain.getNParams() >= 2);
		
		Variable beginVar = domain.getParams().get(domain.getNParams()-2);
		Variable endVar = domain.getParams().get(domain.getNParams()-1);

		assert(beginVar.getName().contentEquals("begin"));
		assert(endVar.getName().contentEquals("end"));

		IntConstraint beginC = constraint(affine(term(beginVar)), affine(term(var)), ComparisonOperator.LE);
		IntConstraint endC = constraint(affine(term(var)), affine(term(endVar)), ComparisonOperator.LT);
		
		domain.getPMdomain().addConstraint(beginC);
		domain.getPMdomain().addConstraint(endC);
	}
	
	
	protected void ReductionTransformation(){
		if(DEBUG){
			System.out.println("System before transformation");
			System.out.println(reductionBodySystem.toString());
		}
		
		_currentSystem = reductionBodySystem;
		Domain ori_domain = scan_information.getScanDomain();
		ParameterDomain oriParamDom = reductionBodySystem.getParameters();
//		//construct the new parameter domain with start and end
//		List<String> names = new LinkedList<String>();
//		names.addAll(oriParamDom.getParamNames());
//		//new parameters
//		names.add("begin");	
//		names.add("end");
		
		Domain boundingDom = ori_domain.boundingBox();
		if(DEBUG){
			System.out.println("The original parameter domain:" + oriParamDom);
			System.out.println("The original domain:" + ori_domain);
		}
		//Replacing the code below with something that do not use strings
//		List<List<String>> paramConstraints = oriParamDom.getPMdomain().getConstraintList(FORMAT.C);
//		
//		for(List<String> paramConstraint : paramConstraints){
//			//add new constraints
//			paramConstraint.add("begin < end");
//			//add constraints for start
//			String start_str = boundingDom.getBounds(0).get(0) + "<= begin";
//			paramConstraint.add(start_str);
//			String end_str = "end <= " + boundingDom.getBounds(0).get(1) + "+1";
//			paramConstraint.add(end_str);
//		}
//		
//		List<List<String>> paraNames = new LinkedList<List<String>>();
//		paraNames.add(names);
//		
//		System.out.println(paraNames.toString());
//		System.out.println(paramConstraints.toString());
//		ParameterDomain paraDom =  PolyhedralIRUtility.parseParameterDomainUnion(paraNames, paramConstraints);
		
		ParameterDomain paraDom = addBeginAndEndToParameterDomain(oriParamDom, boundingDom);
		
		if(DEBUG){
			System.out.println("The new Parameter domain:" + paraDom);
		}
		reductionBodySystem.setParameters(paraDom);
		
		//clear the system
		reductionBodySystem.getEquations().clear();
		//modify the input variable with new parameter domain
		List<VariableDeclaration> inputs = reductionBodySystem.getInputs();
		List<VariableDeclaration> inputList = new LinkedList<VariableDeclaration>();
		for(VariableDeclaration var : inputs){
//			Domain cur_dom = var.getDomain();
//			//List<String> varConstraints = getDomainConstraints(cur_dom);
//			//Domain new_dom = _fact.createDomain(paraDom, cur_dom.getIndexNames(), varConstraints);
//			Domain new_dom = createDomainWithDomain(paraDom, cur_dom.getIndexNames(), cur_dom);
			
			Domain new_dom = extendParameterDomainOfDomain(var.getDomain(), paraDom);
			VariableDeclaration new_var = _fact.createVariableDeclaration(var.getName(), var.getType(), new_dom);
			inputList.add(new_var);
		}
		
		//add the new variable declaraion
		reductionBodySystem.getInputs().clear();
		reductionBodySystem.getInputs().addAll(inputList);
		
		//create output variables for the system
		int size = scan_information.getMatrixSize();
		Type type = scan_information.getTargetList().get(0).getType();
		
		
		//create output scalar variables
		reductionBodySystem.getOutputs().clear();
		Domain scalar_domain = PolyhedralIRUtility.parseDomain(paraDom, "{|}");
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				String var_name = "MResult" + i + j;
				VariableDeclaration var = PolyhedralIRUserFactory.eINSTANCE.createVariableDeclaration(var_name, type, scalar_domain.copy());
				reductionBodySystem.getOutputs().add(var);
			}
		}
		
		//create reduction domain
		if(DEBUG){
			System.out.println("The original domain: " + ori_domain);
		}
//		List<List<String>> redConstraints = ori_domain.getPMdomain().getConstraintList(FORMAT.C);;
//	
//		//add one more constraints
//		List<String> ids = ori_domain.getIndexNames();
//		//construct start <= i < end
//		for(List<String> redConstraint : redConstraints){
//			String str = "begin <=" + ids.get(0) + "< end";
//			redConstraint.add(str);
//		}
//		Domain reductionDomain = createDomainWithConstraints(paraDom, ids, redConstraints);
		
		Domain reductionDomain = ori_domain.copy();
		reductionDomain.addParameterDimension("begin");
		reductionDomain.addParameterDimension("end");
		{
			//get the two variable objects
			Variable beginVar = paraDom.getParams().get(paraDom.getNParams()-2);
			Variable endVar = paraDom.getParams().get(paraDom.getNParams()-1);
			IntConstraint beginC = constraint(affine(term(beginVar)), affine(term(reductionDomain.getIndices().get(0))), ComparisonOperator.LE);
			IntConstraint endC = constraint(affine(term(reductionDomain.getIndices().get(0))), affine(term(endVar)), ComparisonOperator.LT);
			reductionDomain.getPMdomain().addConstraint(beginC);
			reductionDomain.getPMdomain().addConstraint(endC);
		}
		
		if(DEBUG){
			System.out.println("Reduction Domain:" + reductionDomain);
		}
		
		//create local variables
		reductionBodySystem.getLocals().clear();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				String var_name = "Matrix"+i+j;
				VariableDeclaration var = PolyhedralIRUserFactory.eINSTANCE.createVariableDeclaration(var_name, type, reductionDomain.copy());
				reductionBodySystem.getLocals().add(var);
			}
		}
		
		//create equations for each local variables
		AffineFunction schedule = PolyhedralIRUtility.createIdentityFunction(reductionDomain);
		//Constraint projConstraint = null;
		Constraint schedConstraint = new Constraint(schedule, schedule, ComparisonOperator.GT);
		Map<Domain, AffineFunction> serQuast = DomainOperations.findDependencies(paraDom, reductionDomain, reductionDomain, new LinkedList<Constraint>(), schedConstraint);
	
		
		if(DEBUG){
			System.out.println("The quast information");
			Set<Map.Entry<Domain,AffineFunction>> s = serQuast.entrySet();
			Iterator<Map.Entry<Domain,AffineFunction>> it= s.iterator();
			
			while(it.hasNext()){
				Map.Entry<Domain,AffineFunction> m = it.next();
		        Domain key=(Domain)m.getKey();
		        AffineFunction value=(AffineFunction)m.getValue();
		        System.out.println("Domain :"+key+"  Map :"+value);
		    }
		}
		
		//find the dependences for constant expression
		Domain scalarDom = PolyhedralIRUtility.parseDomain(paraDom, "{|}");
		Map<Domain, AffineFunction> scalarQuast = DomainOperations.findDependencies(paraDom, reductionDomain, scalarDom, new LinkedList<Constraint>(), null);
		AffineFunction scalarDep = null;
		Set<Map.Entry<Domain,AffineFunction>> s = scalarQuast.entrySet();
		Iterator<Map.Entry<Domain,AffineFunction>> it= s.iterator();
		while(it.hasNext()){
			Map.Entry<Domain,AffineFunction> m = it.next();
		    Domain key=(Domain)m.getKey();
		    AffineFunction value=(AffineFunction)m.getValue();
		    if(DEBUG){
		    	System.out.println("Domain: " + key + " Dependence: " + value);
		    }
		    if(!key.intersection(reductionDomain).isEmpty() && value != null){
		    	scalarDep = value;
		    }
		}

		List<MatrixInformation> matrices = scan_information.getCoefficientMatrixList();
		List<MatrixInformation> matrix_list = new LinkedList<MatrixInformation>();
		for(int i = 0; i < matrices.size(); i++){
			Domain matrix_dom = matrices.get(i).getMatrixDomain().copy();
			Expression[][] coef_matrix = matrices.get(i).getCoefficientMatrix().clone();
			
//			//add start < i < end into the constraints
//			List<List<String>> matrix_cons = matrix_dom.getPMdomain().getConstraintList(FORMAT.C);
//			List<String> matrix_ids = matrix_dom.getIndexNames();
//			
//			for(List<String> matrix_con : matrix_cons){
//				String outer_con = "begin <=" + matrix_ids.get(0) + "< end";
//				matrix_con.add(outer_con);
//			}
//			
//			Domain new_matrix_dom = createDomainWithConstraints(paraDom, matrix_ids, matrix_cons);
			Domain new_matrix_dom = matrix_dom.copy();
			//FIXME: couldn't tell if adding new parameter dimensions were necessary from code
			new_matrix_dom.addParameterDimension("begin");
			new_matrix_dom.addParameterDimension("end");
			{
				//get the two variable objects
				Variable beginVar = paraDom.getParams().get(paraDom.getNParams()-2);
				Variable endVar = paraDom.getParams().get(paraDom.getNParams()-1);
				IntConstraint beginC = constraint(affine(term(beginVar)), affine(term(new_matrix_dom.getIndices().get(0))), ComparisonOperator.LE);
				IntConstraint endC = constraint(affine(term(new_matrix_dom.getIndices().get(0))), affine(term(endVar)), ComparisonOperator.LT);
				new_matrix_dom.getPMdomain().addConstraint(beginC);
				new_matrix_dom.getPMdomain().addConstraint(endC);
			}
			
			//put the expression of the coef_matrix into the current system
			for(int j = 0; j < size; j++){
				for(int k = 0; k < size; k++){
					coef_matrix[i][j].accept(this);
				}
			}
			
			
			MatrixInformation matrix_info = scan_information.createMatrixInformation(new_matrix_dom, coef_matrix);
			matrix_list.add(matrix_info);
		}
		
		int[][] optimization_matrix = scan_information.getOptimizationMatrix();
		
		//get the equations
		List<StandardEquation> matrixEquat = new LinkedList<StandardEquation>();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				//get the variable name 
				String var_name = "Matrix" + i + j;	
				VariableDeclaration var = reductionBodySystem.getVariableDeclaration(var_name);
				
				//construct the expression according to the optimization matrix
				if(optimization_matrix[i][j] == I || optimization_matrix[i][j] == Z){
					//if it's value is a constant and never change, get one matrix
					Expression[][] refer_matrix = matrix_list.get(0).getCoefficientMatrix();
					Expression cnst_exp = refer_matrix[i][j].copy();
					
					//construct the right hand side expression
					DependenceExpression cnst_dep_exp = _fact.createDependenceExpression(scalarDep.copy(), cnst_exp);
					
					//construct the standard equation
					StandardEquation cnst_equation = PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(var, cnst_dep_exp);
					matrixEquat.add(cnst_equation);
					
					
					continue;
				}
				
				
				//if it's value is not a constant
				List<Expression> branches = new LinkedList<Expression>();
				
				if(DEBUG){
					System.out.println("Start Constructing equation for variable " + var.getName());
				}
				
				s = serQuast.entrySet();
				it = s.iterator();
				
				while(it.hasNext()){
					Map.Entry<Domain,AffineFunction> m = it.next();
					Domain dom = (Domain)m.getKey();
					AffineFunction dep = (AffineFunction)m.getValue();
					//System.out.println("entry now is Domain: " + dom + " Dependence:" + dep);
					if(!dom.isEmpty()){
						if(dep == null){	//initial branch
							//create a case expression for each domain
							List<Expression> subBranches = new LinkedList<Expression>();
							for(int k = 0; k < matrix_list.size(); k++){
								Expression[][] matrix = matrix_list.get(k).getCoefficientMatrix();
								Domain matrix_dom = matrix_list.get(k).getMatrixDomain();
								Expression exp = matrix[i][j].copy();
								Expression usedExp = exp.copy();
								
								boolean isConstant = false;
								if(exp instanceof IntegerExpression){
									isConstant = true;
								}else{
									if(exp instanceof VariableExpression){
										VariableDeclaration coe_var = ((VariableExpression) exp).getVarDecl();
										if(coe_var.getDomain().getNIndices() == 0){
											isConstant = true;
										}
									}
								}
								if(isConstant){
									DependenceExpression dep_exp = _fact.createDependenceExpression(scalarDep.copy(), exp);
									usedExp = dep_exp.copy();
								}
								
								RestrictExpression restExp = _fact.createRestrictExpression(matrix_dom.copy(), usedExp);
								subBranches.add(restExp);
							}
							
							//create the case expression
							CaseExpression subCaseExp = _fact.createCaseExpression(subBranches);
							RestrictExpression restExp = _fact.createRestrictExpression(dom.copy(), subCaseExp);
							//System.out.println("initial branch:" + PolyhedralIRToAlphabets.toSimplifiedString(restExp));
							branches.add(restExp);
						}else{	//other branch
							//create a case expression for each matrix
							List<Expression> subBranches = new LinkedList<Expression>();
							for(int l = 0; l < matrix_list.size(); l++){
								List<Expression> sub_exp = new LinkedList<Expression>();
								Expression[][] matrix = matrix_list.get(l).getCoefficientMatrix();
								Domain matrix_dom = matrix_list.get(l).getMatrixDomain();
								//construct the otimes expression
								for(int k = 0; k < size; k++){//construct the expression
									Expression exp = matrix[i][k].copy();
									String temp_var_name = "Matrix" +k+j;
									VariableDeclaration temp_var = reductionBodySystem.getVariableDeclaration(temp_var_name);
									VariableExpression var_exp = PolyhedralIRUserFactory.eINSTANCE.createVariableExpression(temp_var);
									DependenceExpression dep_exp = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep.copy(), var_exp.copy());
									
									boolean isConstant = false;
									if(exp instanceof IntegerExpression){
										isConstant = true;
									}else if(exp instanceof VariableExpression){
										//String coe_var_name = ((VariableExpression) exp).getVarDecl().getName();
										VariableDeclaration coe_var = ((VariableExpression) exp).getVarDecl();
										if(coe_var.getDomain().getIndices().size() == 0){
											isConstant = true;
										}
			
									}
									Expression bin_exp = null;
									if(isConstant){
										DependenceExpression coe_dep_exp = _fact.createDependenceExpression(scalarDep.copy(), exp);
										bin_exp = createBinaryExpressionForScanOtimes(scan_information.getOTimes(), coe_dep_exp, dep_exp);
									}else{
										bin_exp = createBinaryExpressionForScanOtimes(scan_information.getOTimes(), exp, dep_exp);
									}
									sub_exp.add(bin_exp);
								}
								
								//construct the oplus expression
								Expression finalExp = null;
								
								if(sub_exp.size()==0){
									IntegerExpression tmp_exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
									finalExp = tmp_exp.copy();
								}else if(sub_exp.size()==1){
									finalExp = sub_exp.get(0);
								}else{
									Expression tmp_exp = createBinaryExpressionForScanOplus(scan_information.getOPlus(), sub_exp.get(0), sub_exp.get(1));
									for(int k = 2; k < sub_exp.size(); k++){
										Expression bin_tmp_exp = createBinaryExpressionForScanOplus(scan_information.getOPlus(), tmp_exp.copy(), sub_exp.get(k));
										tmp_exp = bin_tmp_exp;
									}
									finalExp = tmp_exp.copy();
								}
							
								RestrictExpression restExp = _fact.createRestrictExpression(matrix_dom.copy(), finalExp);
								subBranches.add(restExp);
							//	System.out.println("initial branch:" + PolyhedralIRToAlphabets.toSimplifiedString(restExp));
							}
							
							//create the case expression
							CaseExpression subCaseExp = _fact.createCaseExpression(subBranches);
							//create the restrice expression
							RestrictExpression restExp = _fact.createRestrictExpression(dom.copy(), subCaseExp);
							branches.add(restExp);
						}
					}
				}
				
				CaseExpression caseExp = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(branches);
				StandardEquation equation = PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(var, caseExp);
				
				matrixEquat.add(equation);
			}
		}
		
		//add the equations into the system
		for(StandardEquation eq : matrixEquat){
			eq.accept(this);
			reductionBodySystem.getEquations().add(eq);
		}
		
		
		
		//add the new variable assignment expression
		org.polymodel.Domain max = (reductionDomain.getPMdomain()).lexMax();
		Domain ToDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(max);
		Domain FromDom = PolyhedralIRUtility.parseDomain(paraDom, "{|}");
		if(DEBUG){
			System.out.println("From domain: " + FromDom);
			System.out.println("To domain:" + ToDom);
		}
		Map<Domain, AffineFunction> ori_quast = DomainOperations.findDependencies(paraDom, FromDom, ToDom, new LinkedList<Constraint>(), null);
		AffineFunction assignDep = null;
		s = ori_quast.entrySet();
		it = s.iterator();
		while(it.hasNext()){
			Map.Entry m =(Map.Entry)it.next();
		    Domain key=(Domain)m.getKey();
		    AffineFunction value=(AffineFunction)m.getValue();
		    if(DEBUG){
		    	System.out.println("key: " + key + " Dependence: " + value);
		    }
		    if(!key.intersection(FromDom).isEmpty() && value != null){
		    	assignDep = value;
		    	break;
		    }
		}
		
	
		//construct the assignment function 
		List<StandardEquation> assignEquatList = new LinkedList<StandardEquation>();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				String target_var_name = "MResult"+i+j;
				VariableDeclaration target_var = reductionBodySystem.getVariableDeclaration(target_var_name);
				String assign_var_name = "Matrix"+i+j;
				VariableDeclaration assign_var = reductionBodySystem.getVariableDeclaration(assign_var_name);
				VariableExpression assign_var_exp = PolyhedralIRUserFactory.eINSTANCE.createVariableExpression(assign_var);
				DependenceExpression dep_var_exp = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(assignDep.copy(), assign_var_exp.copy());
				
				StandardEquation equation =  PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(target_var, dep_var_exp);
				assignEquatList.add(equation);
			}
		}
		
		//add all the assignment equation
		for(StandardEquation eq : assignEquatList){
			reductionBodySystem.getEquations().add(eq);
		}
		
		//change the name
		String new_name = reductionBodySystem.getName() + "_reductionBody";
		reductionBodySystem.setName(new_name);
		
		List<StandardEquation> equationList = reductionBodySystem.getEquations();
		//substitute the constant equation into other equations
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(optimization_matrix[i][j] == I || optimization_matrix[i][j] == Z){
					String target_var_name = "Matrix" + i + j;
					StandardEquation substituteEqu = reductionBodySystem.getEquation(target_var_name);
					
					//for each equation in the system do substitution
					for(StandardEquation targetEqu : equationList){
						if(targetEqu.equals(substituteEqu)){
							continue;
						}
						Inline.transform(targetEqu, substituteEqu, true);
					}
				}
			}
		}
		
		//remove unused variables
		RemoveUnusedVariables.apply(reductionBodySystem);
	
		Normalize.normalize(reductionBodySystem);
		codeGenInfo.setReductionBodySystem(reductionBodySystem);
		//if(DEBUG){
			System.out.println("System after transformation");
			System.out.println(reductionBodySystem.toString());
			System.out.println(UniquenessAndCompletenessCheck.validate(reductionBodySystem));
		//}
	}
	
	//rewrite the main system
	protected void MainBodyTransformation(){
		if(DEBUG){
			System.out.println("System before transformation");
			System.out.println(mainBodySystem.toString());
		}
		
		_currentSystem = mainBodySystem;
		
		ParameterDomain paraDom = mainBodySystem.getParameters();
		
		//add the initial value as input of the system
		List<VectorInformation> updating_vector = scan_information.getUpdatingVector();
		Domain scalarDom = PolyhedralIRUtility.parseDomain(paraDom, "{|}");
		
		for(VectorInformation vec : updating_vector){
			String var_name = "Init_" + vec.getVar().getName() + vec.getGCD();
			VariableDeclaration init_var = _fact.createVariableDeclaration(var_name, vec.getVar().getType(), scalarDom.copy());
			mainBodySystem.getInputs().add(init_var);
		}
		
		//get some parameters
		ParameterDomain paramDom = mainBodySystem.getParameters();
		
		//construct new equations
		List<StandardEquation> equationList = new LinkedList<StandardEquation>();
		for(StandardEquation eq : mainBodySystem.getEquations()){
			if(!(eq.getExpression() instanceof CaseExpression)){
				equationList.add(eq);
				continue;
			}
			VariableDeclaration cur_target = eq.getVariable();
			String cur_target_name = cur_target.getName();
			
			//find dependence for constant expression
			Domain targetDom = cur_target.getDomain();
			
			//construct the function
			if(DEBUG){
				System.out.println("parameter domain: " + paramDom);
				System.out.println("Target Domain: " + targetDom);
				System.out.println("Scalar Domain: " + scalarDom);
			}
			
			Map<Domain, AffineFunction> scalarQuast = DomainOperations.findDependencies(paramDom, targetDom, scalarDom, new LinkedList<Constraint>(), null);
			AffineFunction scalarDep = null;
			Set<Map.Entry<Domain,AffineFunction>> s = scalarQuast.entrySet();
			Iterator<Map.Entry<Domain,AffineFunction>> it= s.iterator();
			while(it.hasNext()){
				Map.Entry<Domain,AffineFunction> m = it.next();
			    Domain key=(Domain)m.getKey();
			    AffineFunction value=(AffineFunction)m.getValue();
			    if(DEBUG){
			    	System.out.println("key: " + key + " dependence: " + value);
			    }
			    if(!key.intersection(targetDom).isEmpty() && value != null){
			    	scalarDep = value;
			    	break;
			    }
			}
			
			//construct new branches
			List<VectorInformation> curTargetVector = new LinkedList<VectorInformation>();
			List<Expression> branches = new LinkedList<Expression>();
			for(VectorInformation vec : updating_vector){
				if(vec.getVar().getName().equals(cur_target_name)){
					curTargetVector.add(vec);
					//construct the current branches
					String var_name = "Init_" + cur_target_name + vec.getGCD();
					VariableDeclaration var = mainBodySystem.getVariableDeclaration(var_name);
					VariableExpression  varExp = _fact.createVariableExpression(var);
					DependenceExpression depExp = _fact.createDependenceExpression(scalarDep.copy(), varExp);
					
					RestrictExpression restExp = _fact.createRestrictExpression(vec.getDomian().copy(), depExp);
					branches.add(restExp);
				}
			}
			
			//construct the rest branches
			/*
			 * For each branch of the case expression peel out the initial domain
			 * keep the rest branches
			 */
			StandardEquation targetEquation = EcoreUtil.copy(eq);
			CaseExpression targetCaseExp = (CaseExpression)eq.getExpression();
			for(Expression exp : targetCaseExp.getExprs()){
				Domain expDom = exp.getContextDomain();
				for(VectorInformation vec : curTargetVector){
					expDom = expDom.difference(vec.getDomian().copy());
				}
				if(!expDom.isEmpty()){//add the new branch
					RestrictExpression restExp = _fact.createRestrictExpression(expDom.copy(), exp.copy());
					branches.add(restExp);
				}
				
			}
			
			//construct the new equations
			CaseExpression caseExp = _fact.createCaseExpression(branches);
			StandardEquation equation = _fact.createStandardEquation(cur_target, caseExp);
			
			equationList.add(equation);
		}
		
		//add the new equations
		mainBodySystem.getEquations().clear();
		mainBodySystem.getEquations().addAll(equationList);
		Normalize.normalize(mainBodySystem);
		
		codeGenInfo.setMainBodySystem(mainBodySystem);
		
		//construct the corresponding updating vector
		List<VectorInformation> vector_info = scan_information.getUpdatingVector();
		List<VariableDeclaration> inputVector = new LinkedList<VariableDeclaration>();
		for(int i = 0; i < vector_info.size(); i++){
			String var_name = "Init_" + vector_info.get(i).getVar().getName() + vector_info.get(i).getGCD();
			VariableDeclaration var = mainBodySystem.getVariableDeclaration(var_name);
			inputVector.add(var);
		}
		
		codeGenInfo.setInputVector(inputVector);
		
		//if it is a reduction body
		if(isReduction){
			List<VariableDeclaration> outputVector = new LinkedList<VariableDeclaration>();
			List<VariableDeclaration> targetList = scan_information.getTargetList();
			for(int i = 0; i < targetList.size(); i++){
				String var_name = targetList.get(i).getVarID().getName();
				VariableDeclaration var = mainBodySystem.getVariableDeclaration(var_name);
				outputVector.add(var);
			}
			codeGenInfo.setOutputVector(outputVector);
			
			String new_name = scanBodySystem.getName() + "_scanBody";
			scanBodySystem.setName(new_name);
			codeGenInfo.setScanBodySystem(scanBodySystem);
		}
		
		//if(DEBUG){
			System.out.println("System after transformation");
			System.out.println(mainBodySystem.toString());
			System.out.println(UniquenessAndCompletenessCheck.validate(mainBodySystem));
		//}
	}
	
	protected void ScanTransformation(){
		//Add input variables
		if(DEBUG){
			System.out.println("System before transformation");
			System.out.println(scanBodySystem.toString());
		}
		
		_currentSystem = scanBodySystem;
		//construct the new parameter domain
		ParameterDomain oriParaDom = scanBodySystem.getParameters();
		Domain ori_domain = scan_information.getScanDomain();
		Domain boundingDom = ori_domain.boundingBox();
//		List<String> paraNames = oriParaDom.getParamNames();
//		paraNames.add("begin");
//		paraNames.add("end");
//		List<List<String>> names = new LinkedList<List<String>>();
//		names.add(paraNames);
//		List<List<String>> paramConstraints = oriParaDom.getPMdomain().getConstraintList(FORMAT.C);
//		
//		//add new constraints start >= lb start < end and end <= ub
//		for(List<String> paramConstraint: paramConstraints){
//			String lb_con_str = boundingDom.getBounds(0).get(0) + "<= begin";
//			paramConstraint.add(lb_con_str);
//			paramConstraint.add("begin < end");
//			String ub_con_str = "end <=" + boundingDom.getBounds(0).get(1) + "+1";
//			paramConstraint.add(ub_con_str);
//		}
//		
//		ParameterDomain paramDom = PolyhedralIRUtility.parseParameterDomainUnion(names, paramConstraints);
		
		ParameterDomain paramDom = addBeginAndEndToParameterDomain(oriParaDom, boundingDom);
		
		//construct the inputs variable declaration with new parameter domain
		List<VariableDeclaration> inputs = scanBodySystem.getInputs();
		List<VariableDeclaration> inputList = new LinkedList<VariableDeclaration>();
		for(VariableDeclaration var: inputs){
//			Domain cur_dom = var.getDomain();
//			Domain new_dom = createDomainWithDomain(paramDom, cur_dom.getIndexNames(), cur_dom);
			Domain new_dom = extendParameterDomainOfDomain(var.getDomain(), paramDom);
			VariableDeclaration new_var = _fact.createVariableDeclaration(var.getName(), var.getType(), new_dom);
			inputList.add(new_var);
		}
		
		//add input initialization variables
		List<VectorInformation> updating_vector = scan_information.getUpdatingVector();
		Domain initDom = PolyhedralIRUtility.parseDomain(paramDom, "{|}");
		for(VectorInformation vec : updating_vector){
			String var_name = "ScanInit_" + vec.getVar().getName() + vec.getGCD();
			VariableDeclaration init_var = _fact.createVariableDeclaration(var_name, vec.getVar().getType(), initDom.copy());
			inputList.add(init_var);
		}
		
		Domain scan_dom = scan_information.getScanDomain();
		//construct the local variable declaration with new parameter domain
		List<VariableDeclaration> locals = scanBodySystem.getLocals();
		List<VariableDeclaration> localList = new LinkedList<VariableDeclaration>();
		for(VariableDeclaration var : locals){
//			Domain cur_dom = var.getDomain();
//			List<List<String>> domConstraints = scan_dom.getPMdomain().getConstraintList(FORMAT.C);
//			//List<String> domConstraints = getDomainConstraints(scan_dom.copy());
//			List<String> varNames = scan_dom.getIndexNames();
//			//add one more constraints
//			for(List<String> domConstraint : domConstraints){
//				String lb_cons = "begin <=" + varNames.get(0);
//				domConstraint.add(lb_cons);
//				String ub_cons = varNames.get(0) + "< end";
//				domConstraint.add(ub_cons);
//			}
			//Domain new_dom = createDomainWithDomain(paramDom, cur_dom.getIndexNames(), cur_dom);
//			Domain new_dom = createDomainWithConstraints(paramDom, scan_dom.getIndexNames(), domConstraints);
			Domain new_dom = extendParameterDomainOfDomain(var.getDomain(), paramDom);
			constraintByBeginAndEnd(new_dom, new_dom.getIndices().get(0));
			VariableDeclaration new_var = _fact.createVariableDeclaration(var.getName(), var.getType(), new_dom);
			localList.add(new_var);
		}
	
		//construct the domain variable declaration for output with start <= i < end and also the initial domain
		List<VariableDeclaration> outputs = scanBodySystem.getOutputs();
		List<VariableDeclaration> outputList = new LinkedList<VariableDeclaration>(); 
		for(VariableDeclaration var : outputs){
//			Domain cur_dom = var.getDomain();
//			List<List<String>> domConstraints = scan_dom.getPMdomain().getConstraintList(FORMAT.C);
//			//List<String> domConstraints = getDomainConstraints(scan_dom.copy());
//			List<String> varNames = scan_dom.getIndexNames();
//			//add one more constraints
//			for(List<String> domConstraint : domConstraints){
//				String lb_cons = "begin <=" + varNames.get(0);
//				domConstraint.add(lb_cons);
//				String ub_cons = varNames.get(0) + "< end";
//				domConstraint.add(ub_cons);
//			}
			//construct the new domain
			//Domain new_dom = _fact.createDomain(paramDom, scan_dom.getIndexNames(), domConstraints);
			Domain new_dom = extendParameterDomainOfDomain(var.getDomain(), paramDom);
			constraintByBeginAndEnd(new_dom, new_dom.getIndices().get(0));
//			Domain new_dom = createDomainWithConstraints(paramDom, scan_dom.getIndexNames(), domConstraints);
			VariableDeclaration new_var = _fact.createVariableDeclaration(var.getName(), var.getType(), new_dom);
			outputList.add(new_var);
		}

		
		//construct the new equations 
		List<StandardEquation> equationList = new LinkedList<StandardEquation>();
		for(StandardEquation eq : scanBodySystem.getEquations()){
			VariableDeclaration cur_target = findVariableDeclaration(outputList, eq.getVariable().getName());
			if(cur_target == null){
				cur_target = findVariableDeclaration(localList, eq.getVariable().getName());
			}
			if(cur_target == null){
				System.out.println("No such target variable: " + eq.getVariable().getName());
				return;
			}
	
			Type type = cur_target.getType();
			
			//find dependence for constant expression
			Domain scalarDom = PolyhedralIRUtility.parseDomain(paramDom, "{|}");
			Domain targetDom = cur_target.getDomain();
			if(DEBUG){
				System.out.println("parameter domain: " + paramDom);
				System.out.println("Target Domain: " + targetDom);
				System.out.println("Scalar Domain: " + scalarDom);
			}
			
			Map<Domain, AffineFunction> scalarQuast = DomainOperations.findDependencies(paramDom, targetDom, scalarDom, new LinkedList<Constraint>(), null);
			AffineFunction scalarDep = null;
			Set s = scalarQuast.entrySet();
			Iterator it= s.iterator();
			while(it.hasNext()){
				Map.Entry m =(Map.Entry)it.next();
			    Domain key=(Domain)m.getKey();
			    AffineFunction value=(AffineFunction)m.getValue();
			    if(DEBUG){
			    	System.out.println("key: " + key + " dependence: " + value);
			    }
			    if(!key.intersection(targetDom).isEmpty() && value != null){
			    	scalarDep = value;
			    	break;
			    }
			}
			
			if(DEBUG){
				System.out.println("The scalar dependence:" + scalarDep);
			}
			
			//construct the initial value branch for the target variable
			//construct the initial branch for current target
			Domain domain = cur_target.getDomain().copy();
			List<Expression> branches = new LinkedList<Expression>();
			
			List<VectorInformation> curVectorList = new LinkedList<VectorInformation>();
			List<Integer> IndexList = new LinkedList<Integer>();
			
			for(int i = 0; i < updating_vector.size(); i++){
				VectorInformation vec = updating_vector.get(i);
				if(vec.getVar().getName().equals(cur_target.getName())){
					curVectorList.add(vec);
					IndexList.add(i);
				}
			}
			
			int m = curVectorList.size(); //number of initial branches needs to be constructed
			int size = scan_information.getMatrixSize();
			
			//get the list of matrix information
			//construct new matrix domain with begin and end
			//construct new coefficient 
			List<MatrixInformation> matrices = scan_information.getCoefficientMatrixList();
			List<MatrixInformation> matrix_list = new LinkedList<MatrixInformation>();
			for(int i = 0; i < matrices.size(); i++){
				Domain matrix_dom = matrices.get(i).getMatrixDomain().copy();
				Expression[][] coef_matrix = matrices.get(i).getCoefficientMatrix().clone();
				
				//add start < i < end into the constraints
//				List<List<String>> matrix_cons = matrix_dom.getPMdomain().getConstraintList(FORMAT.C);
//				List<String> matrix_ids = matrix_dom.getIndexNames();
//				
//				for(List<String> matrix_con : matrix_cons){
//					String outer_con = "begin <=" + matrix_ids.get(0) + "< end";
//					matrix_con.add(outer_con);
//				}
//				
//				Domain new_matrix_dom = createDomainWithConstraints(paramDom, matrix_ids, matrix_cons);
				Domain new_matrix_dom = extendParameterDomainOfDomain(matrix_dom, paramDom);
				constraintByBeginAndEnd(new_matrix_dom, new_matrix_dom.getIndices().get(0));
				
				//put the expression of the coef_matrix into the current system
				for(int j = 0; j < size; j++){
					for(int k = 0; k < size; k++){
						coef_matrix[i][j].accept(this);
					}
				}
				
				MatrixInformation matrix_info = scan_information.createMatrixInformation(new_matrix_dom, coef_matrix);
				matrix_list.add(matrix_info);
			}
			
			//build up the expressions
			List<Domain> initDomains = new LinkedList<Domain>();
			Domain init_dom = PolyhedralIRUtility.createEmptyDomain(domain.getParams(), domain.getIndices());
			for(int i = 0; i < m; i++){
				int index = IndexList.get(i);
				Domain branchDomain = _fact.createDomain((domain.getPMdomain()).lexMin());
				
				List<Expression> subCaseBranches = new LinkedList<Expression>();
				for(int k = 0; k < matrix_list.size(); k++){
					Expression[][] matrix = matrix_list.get(k).getCoefficientMatrix();
					Domain matrix_domain = matrix_list.get(k).getMatrixDomain();
					
					//construct the otimes sub expressions
					List<Expression> sub_exp = new LinkedList<Expression>();
					OP otimes = scan_information.getOTimes();
					
					//construct the expression
					for(int j = 0; j < updating_vector.size(); j++){
						VectorInformation vecTemp = updating_vector.get(j);
						int gcd = vecTemp.getGCD();
						if(gcd < (i + 1)){	//this is the value already computed
							Domain toDomain = initDomains.get(gcd-1);
							List<String> iter_space = targetDom.getIndexNames();	//all the target has the same domain
							int dim = targetDom.getNIndices();
							
							String dep_str = "(";
							for(int l = 0; l < dim-1; l++){
								dep_str += iter_space.get(l) + ",";
							}
							
							dep_str += iter_space.get(dim-1) + "->";
							for(int l = 0; l < dim - 1; l++){
								dep_str += toDomain.getBounds(l).get(0) + ",";
							}
							
							dep_str += toDomain.getBounds(dim-1).get(0) + ")";
							
							AffineFunction dep = PolyhedralIRUtility.parseAffineFunction(paramDom, dep_str);
							
							if(DEBUG){
								System.out.println("The new dependence function:" + dep);
								System.out.println("current target" + cur_target.getName());
							}
						
							VariableDeclaration cur_var = findVariableDeclaration(outputList, vecTemp.getVar().getName()); 
							VariableExpression varExp = _fact.createVariableExpression(cur_var);
							DependenceExpression depExp = _fact.createDependenceExpression(dep.copy(), varExp.copy());
							Expression coeExp = matrix[index][j].copy();
							Expression binExp = null;
							boolean isConstant = false;
							if(coeExp instanceof IntegerExpression){
								isConstant = true;
							}else if(coeExp instanceof VariableExpression){
								VariableDeclaration coe_var = ((VariableExpression) coeExp).getVarDecl();
								if(coe_var.getDomain().getIndices().size() == 0){
									isConstant = true;
								}
							}
							if(isConstant){
								DependenceExpression coeDepExp = _fact.createDependenceExpression(scalarDep.copy(), coeExp.copy());
								binExp = createBinaryExpressionForScanOtimes(otimes, coeDepExp, depExp);
							}else{
								binExp = createBinaryExpressionForScanOtimes(otimes, coeExp, depExp);
							}
							
							sub_exp.add(binExp);
						}else{//use the input initial value
							String var_name = "ScanInit_" + vecTemp.getVar().getName() + vecTemp.getGCD();
							VariableDeclaration var = findVariableDeclaration(inputList, var_name);
							VariableExpression varExp = _fact.createVariableExpression(var);
							
							DependenceExpression depExp = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(scalarDep.copy(), varExp.copy());
							
							Expression coeExp = matrix[index][j].copy();
							Expression binExp = null;
	
							boolean isConstant = false;
							if(coeExp instanceof IntegerExpression){
								isConstant = true;
							}else if(coeExp instanceof VariableExpression){
								VariableDeclaration coe_var = ((VariableExpression) coeExp).getVarDecl();
								if(coe_var.getDomain().getIndices().size() == 0){
									isConstant = true;
								}
							}
							if(isConstant){
								DependenceExpression coeDepExp = _fact.createDependenceExpression(scalarDep.copy(), coeExp.copy());
								binExp = createBinaryExpressionForScanOtimes(otimes, coeDepExp, depExp);
							}else{
								binExp = createBinaryExpressionForScanOtimes(otimes, coeExp, depExp);
							}
						
							sub_exp.add(binExp);
						}
					}
					
					//add the constant part
					Expression coeExp = matrix[index][size-1].copy();
					boolean isConstant = false;
					if(coeExp instanceof IntegerExpression){
						isConstant = true;
					}else if(coeExp instanceof VariableExpression){
						VariableDeclaration coe_var = ((VariableExpression) coeExp).getVarDecl();
						if(coe_var.getDomain().getIndices().size() == 0){
							isConstant = true;
						}
					}
					
					if(isConstant){
						DependenceExpression coeDepExp = _fact.createDependenceExpression(scalarDep, coeExp);
						sub_exp.add(coeDepExp);
					}else{
						sub_exp.add(coeExp);
					}
					
					System.out.println("sub expression number:" + sub_exp.size());
					//construct final oplus expression
					Expression finalExp = null;
					OP oplus = scan_information.getOPlus();
					if(sub_exp.size()==0){
						IntegerExpression tmp_exp = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						finalExp = tmp_exp.copy();
					}else if(sub_exp.size()==1){
						finalExp = sub_exp.get(0);
					}else{
						Expression tmp_exp = createBinaryExpressionForScanOplus(oplus, sub_exp.get(0), sub_exp.get(1));
						for(int l = 2; l < sub_exp.size(); l++){
							Expression bin_tmp_exp = createBinaryExpressionForScanOplus(oplus, tmp_exp.copy(), sub_exp.get(l));
							tmp_exp = bin_tmp_exp;
						}
						finalExp = tmp_exp.copy();
					}
					
					
					RestrictExpression restExp = _fact.createRestrictExpression(matrix_domain.copy(), finalExp);
					subCaseBranches.add(restExp);
				}
				
				//construct the sub case expression
				CaseExpression subCaseExp = _fact.createCaseExpression(subCaseBranches);
				RestrictExpression restExp = _fact.createRestrictExpression(branchDomain.copy(), subCaseExp);
				
				branches.add(restExp);
				initDomains.add(branchDomain);
				init_dom = init_dom.union(branchDomain);
				domain = domain.difference(branchDomain);
			}
			
			if(DEBUG){
				System.out.println("The init domain is :" + init_dom);
			}
			CaseExpression rexp = (CaseExpression)eq.getExpression();
			for(Expression exp : rexp.getExprs()){
				Domain expDom = exp.getContextDomain();
				//System.out.println("Expression context domain: " + expDom);
				for(VectorInformation vec : curVectorList){
					expDom = expDom.difference(vec.getDomian());
				}
				//System.out.println("Domain after peel out the initital domain: " + expDom);
				if(!expDom.isEmpty()){	//modify the branch
					Domain dom = expDom.copy();
//					List<String> ids = dom.getIndexNames();
//					List<List<String>> cons = dom.getPMdomain().getConstraintList(FORMAT.C);
//					//add constraints start < i < end
//					for(List<String> con : cons){
//						String str = "begin <= " + ids.get(0) + "< end";
//						con.add(str);
//					}
					//construct the domain
					//Domain branchDom = _fact.createDomain(paramDom, ids, cons);
//					Domain branchDom = createDomainWithConstraints(paramDom, ids, cons);
					Domain branchDom = extendParameterDomainOfDomain(dom, paramDom);
					constraintByBeginAndEnd(branchDom, branchDom.getIndices().get(0));
					branchDom = branchDom.difference(init_dom);
					if(DEBUG){
						System.out.println("Branch Domain: " + branchDom);
					}
					RestrictExpression rest = _fact.createRestrictExpression(branchDom.copy(), exp.copy());
					branches.add(rest);
				}
			}
			
			//create the new caseExpression
			CaseExpression caseExp = _fact.createCaseExpression(branches);
			//create the standard equations
			StandardEquation eqation = _fact.createStandardEquation(cur_target, caseExp);
			equationList.add(eqation);
				
		}
		
		//construct the 
		//start modifying the program
		scanBodySystem.setParameters(paramDom);
		//add variables
		scanBodySystem.getInputs().clear();
		scanBodySystem.getInputs().addAll(inputList);
		
		scanBodySystem.getLocals().clear();
		scanBodySystem.getLocals().addAll(localList);
		
		scanBodySystem.getOutputs().clear();
		scanBodySystem.getOutputs().addAll(outputList);

		//add the equations
		List<StandardEquation> systemEquationList = new LinkedList<StandardEquation>();
		for(StandardEquation eq : equationList){
			eq.accept(this);
			systemEquationList.add(eq);
		}

		
		scanBodySystem.getEquations().clear();
		scanBodySystem.getEquations().addAll(systemEquationList);
		
		
		String new_name = scanBodySystem.getName() + "_scanBody";
		scanBodySystem.setName(new_name);
		codeGenInfo.setScanBodySystem(scanBodySystem);
		
		Normalize.normalize(scanBodySystem);
		
		//if(DEBUG){
			System.out.println("System after transformation");
			System.out.println(scanBodySystem.toString());
			System.out.println(UniquenessAndCompletenessCheck.validate(scanBodySystem));
		//}
		
		
		
		//construct the corresponding updating vector
		List<VectorInformation> vector_info = scan_information.getUpdatingVector();
		List<VariableDeclaration> updating = new LinkedList<VariableDeclaration>();
		for(int i = 0; i < vector_info.size(); i++){
			String var_name = "ScanInit_" + vector_info.get(i).getVar().getName() + vector_info.get(i).getGCD();
			VariableDeclaration var = scanBodySystem.getVariableDeclaration(var_name);
			updating.add(var);
		}
		
		codeGenInfo.setOutputVector(updating);
		
		//construct the initialization vector
		List<scanOutput> initScanOutput = new LinkedList<scanOutput>();
		for(int i = 0; i < vector_info.size(); i++){
			VariableDeclaration var = vector_info.get(i).getVar();
			
			//construct the affine function
			Domain tmp_dom = vector_info.get(i).getDomian().copy();
			List<String> iter_index = tmp_dom.getIndexNames();
			int dim = tmp_dom.getNIndices();
			
			String dep_str = "(";
			for(int j = 0; j < dim -1; j++){
				dep_str += iter_index.get(j) + ",";
			}
			dep_str += iter_index.get(dim-1) + "->";
			
			for(int j = 0; j < dim -1; j++){
				dep_str += tmp_dom.getBounds(j).get(0) + ",";
			}
			
			dep_str += tmp_dom.getBounds(dim - 1).get(0) + ")";
			
			AffineFunction dep =  PolyhedralIRUtility.parseAffineFunction(paramDom, dep_str);
			
			scanOutput out = codeGenInfo.newScanOutput(var, dep);
			initScanOutput.add(out);
		}
		
		codeGenInfo.setInitScanOutVec(initScanOutput);
		
		//construct the corresponding output vector information
		Map<String, Integer> targetMaxGcdMap = new HashMap<String, Integer>();
		List<VariableDeclaration> target = scan_information.getTargetList();
		for(int i = 0; i < target.size(); i++){
			int max_gcd = -1;
			String var = target.get(i).getName();
			for(int j = 0; j < vector_info.size(); j++){
				String var_name = vector_info.get(j).getVar().getName();
				if(var_name.equals(var)){
					int gcd = vector_info.get(j).getGCD();
					if(gcd > max_gcd){
						max_gcd = gcd;
					}
				}
			}
			
			targetMaxGcdMap.put(var, max_gcd);
		}
	
		Map<String, Map<Integer, AffineFunction>> map = new HashMap<String, Map<Integer, AffineFunction>>();
		for(int i = 0; i < target.size(); i++){
			//get the scan domain for the target
			String var_name = target.get(i).getName();
			VariableDeclaration var = scanBodySystem.getVariableDeclaration(var_name);
			Domain var_domain = var.getDomain().copy();
			
			//get the max gcd number of lex max(the output)
			Map<Integer, AffineFunction> list_map = new HashMap<Integer, AffineFunction>();
			int max_gcd = targetMaxGcdMap.get(var_name);
			Domain start_dom = var_domain.copy();
			for(int j = 0; j < max_gcd; j++){
				//get the leximax of the domain
				Domain outDom = _fact.createDomain((start_dom.getPMdomain()).lexMax());
				
				//
				
//				List<String> iter_index = var_domain.getIndexNames();
//				int dim = var_domain.getNIndices();
//				
//				String dep_str = "(";
//				for(int l = 0; l < dim-1; l++){
//					dep_str += iter_index.get(l) + ",";
//				}
//				
//				dep_str += iter_index.get(dim-1) + "->";
//				for(int l = 0; l < dim - 1; l++){
//					dep_str += outDom.getBounds(l).get(0) + ",";
//				}
//				
//				dep_str += outDom.getBounds(dim-1).get(0) + ")";
				
				List<AffineExpression> exprs = new ArrayList<AffineExpression>(var_domain.getNIndices());
				for (int l = 0; l < var_domain.getNIndices(); l++) {
					exprs.add(outDom.getBounds(l).get(0).toAffine());
				}
				
				
				AffineFunction dep = _fact.createAffineFunction(paramDom.getParams(), var_domain.getIndices(), exprs);
				list_map.put(j+1, dep);
				start_dom = start_dom.difference(outDom);
			}
			map.put(var_name, list_map);
		}
		
		List<scanOutput> scan_out = new LinkedList<scanOutput>();
		//construct the output of the scan
		for(int i = 0; i < vector_info.size(); i++){
			VariableDeclaration var = vector_info.get(i).getVar();
			String var_name = var.getName();
			Map<Integer, AffineFunction> list_map = map.get(var_name);
			int gcd = vector_info.get(i).getGCD();
			AffineFunction func = list_map.get(gcd);
			
			scanOutput out = codeGenInfo.newScanOutput(var, func);
			scan_out.add(out);
		}
		
		codeGenInfo.setScanOutput(scan_out);
	}

	private Expression createBinaryExpressionForScanOtimes(OP op, Expression left, Expression right){
		Expression exp = null;
		IntegerExpression leftInt = null;
		IntegerExpression rightInt = null;
		if(left instanceof DependenceExpression){
			if(((DependenceExpression) left).getExpr() instanceof IntegerExpression){
				leftInt = (IntegerExpression)((DependenceExpression) left).getExpr();
			}
		}
		
		if(right instanceof DependenceExpression){
			if(((DependenceExpression) right).getExpr() instanceof IntegerExpression){
				rightInt = (IntegerExpression)((DependenceExpression) right).getExpr();
			}
		}
		
		if(leftInt != null){
			long value = leftInt.getValue();
			if(value == 1){
				exp = right.copy();
			}else if(value == 0){
				exp = left.copy();
			}else{
				if(rightInt != null){
					long rvalue = rightInt.getValue();
					if(rvalue == 1){
						exp = left.copy();
					}else if(rvalue == 0){
						exp = right.copy();
					}else{
						exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
					}
				}else{
					exp =  _fact.createBinaryExpression(op, left.copy(), right.copy());
				}
			}
		}else{
			if(rightInt !=null){
				long rvalue = rightInt.getValue();
				if(rvalue == 1){
					exp = left.copy();
				}else if(rvalue == 0){
					exp = right.copy();
				}else{
					exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
				}
			}else{
				exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
			}
		}
		
		return exp;
	}
	
	private Expression createBinaryExpressionForScanOplus(OP op, Expression left, Expression right){
		Expression exp = null;
		IntegerExpression leftInt = null;
		IntegerExpression rightInt = null;
		if(left instanceof DependenceExpression){
			if(((DependenceExpression) left).getExpr() instanceof IntegerExpression){
				leftInt = (IntegerExpression)((DependenceExpression) left).getExpr();
			}
		}
		
		if(right instanceof DependenceExpression){
			if(((DependenceExpression) right).getExpr() instanceof IntegerExpression){
				rightInt = (IntegerExpression)((DependenceExpression) right).getExpr();
			}
		}
		
		if(leftInt != null){
			long value = leftInt.getValue();
			if(value == 0){
				exp = right.copy();
			}else{
				if(rightInt != null){
					long rvalue = rightInt.getValue();
					if(rvalue == 0){
						exp = left.copy();
					}else{
						exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
					}
				}
			}
		}else{
			if(rightInt !=null){
				long rvalue = rightInt.getValue();
				if(rvalue == 0){
					exp = left.copy();
				}else{
					exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
				}
			}else{
				exp = _fact.createBinaryExpression(op, left.copy(), right.copy());
			}
		}
		
		return exp;
	}
	
// these two methods should not be necessary
//	private Domain createDomainWithConstraints(ParameterDomain paramDom, List<String> indices, List<List<String>> constraints){
//		Domain domain = PolyhedralIRUtility.parseDomainFromString(paramDom, indices, constraints.get(0));
//		for(int i = 1; i < constraints.size(); i++){
//			Domain tmp_dom = PolyhedralIRUtility.parseDomainFromString(paramDom, indices, constraints.get(i));
//			domain = domain.union(tmp_dom);
//		}
//		
//		domain.simplify();
//		
//		return domain;
//	}
//	private Domain createDomainWithDomain(ParameterDomain paramDom, List<String> indices, Domain originalDomain){
//		List<List<String>> constraints = originalDomain.getPMdomain().getConstraintList(FORMAT.C);
//		Domain domain = createDomainWithConstraints(paramDom, indices, constraints);
//		return domain;
//	}
	
	
	//computes the min of the domain with certain direction
	private Domain getMinWithDirections(ParameterDomain paramDom, Domain target_dom, Domain domain, List<Vector<Integer>> directions){
		if(DEBUG){
			System.out.println("Target Domain: " + target_dom);
			System.out.println("Original domain:" + domain);
		}
		List<String> emptyConstraints = new LinkedList<String>();
		emptyConstraints.add("1==0");
		
		//trying to find a leagal previous slice
		//move along the opposite way of each direction
		//get the domain union
		Domain dom = domain.copy();
		Domain init_dom = PolyhedralIRUtility.parseDomainFromString(paramDom, domain.getIndexNames(), emptyConstraints);
		for(int i = 0; i < directions.size(); i++){
			Vector<Integer> vec = directions.get(i);
			int[] dir = new int[vec.size()];
			//get the opposite direction
			for(int j = 0; j < vec.size(); j++){
				dir[j] = -vec.get(j);
			}
			AffineFunction af = PolyhedralIRUtility.createUniformFunction(domain, dir);
			Domain diff_dom = dom.image(af).difference(dom);
			Domain tmp_dom = diff_dom.difference(target_dom);
			if(!tmp_dom.isEmpty()){
				//get the max of the next slice
				Domain t_init = tmp_dom.copy();
				for(int j = 0; j < i; j++){
					Vector<Integer> t_vec = directions.get(i);
					int[] t_dir = new int[vec.size()];
					for(int k = 0; k < vec.size(); k++){
						t_dir[k] = vec.get(k);
					}
					AffineFunction t_af = PolyhedralIRUtility.createUniformFunction(domain, t_dir);
					t_init = t_init.difference(t_init.image(t_af));
				}
				init_dom = init_dom.union(t_init);
			}
		}
		
		if(DEBUG){
			System.out.println("get the initial domain:" + init_dom);
		}
		
		return init_dom;
	}
	
	//find the corresponding variable declaration in a list
	public VariableDeclaration findVariableDeclaration(List<VariableDeclaration> varList, String name){
		for(VariableDeclaration var : varList){
			if(var.getName().equals(name)){
				return var;
			}
		}
		
		return null;
	}

	//the override function changes the reference of an expression to the current system
	@Override
	public void inVariableExpression(VariableExpression v) {
		inExpression(v);
		
		VariableDeclaration var = v.getVarDecl();
	
		VariableDeclaration cur_var = _currentSystem.getVariableDeclaration(var.getName());
		
		v.setVarDecl(cur_var);
		
	}
	
	//override the dependence expression to change the paramters of the dependence
	@Override
	public void inDependenceExpression(DependenceExpression d){
		inExpression(d);
		
		ParameterDomain param = _currentSystem.getParameters();
		AffineFunction cur_af = d.getDep();
		String funct = cur_af.toString();
		AffineFunction af = PolyhedralIRUtility.parseAffineFunction(param, funct);
		d.setDep(af);
	}
	
	private class InitBranchInfo{
		private Expression exp;
		private Domain dom;
		
		public InitBranchInfo(Expression _exp, Domain _dom){
			exp = _exp;
			dom = _dom;
		}
		
		public Expression getExpression(){
			return exp;
		}
		
		public Domain getDomain(){
			return dom;
		}
	}
	
	
	//override the restrict expression with domian
	@Override
	public void inRestrictExpression(RestrictExpression r){
		inExpression(r);
		
		ParameterDomain param = _currentSystem.getParameters();
		Domain dom = r.getRestrictDomain();
		
		//FIXME: not sure if this is whats supposed to happen; is this code supposed to extend the restrict domains so that its parameters now have begin/end?
		Domain newDom = extendParameterDomainOfDomain(dom, param);
//		Domain newDom = createDomainWithDomain(param, dom.getIndexNames(), dom);
		//Domain newDom = _fact.createDomain(param, dom.getIndexNames(), domConstraints);
		
		r.setRestrictDomain(newDom);
	}
	
	//override the variables of the standard equations
	@Override
	public void inStandardEquation(StandardEquation s) {
		defaultIn(s);
		
		VariableDeclaration cur_var = s.getVariable();
		VariableDeclaration var = _currentSystem.getVariableDeclaration(cur_var.getName());
		s.setVariable(var);
	}
	
}


