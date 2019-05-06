package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.DimensionsManager;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;
import org.polymodel.util.PolymodelException;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;

/**
 * Serializes a reduction
 * 
 * @author yuki
 *
 */
public class SerializeReduction {

	private static PolyhedralIRUserFactory fact = PolyhedralIRUserFactory.eINSTANCE;
	
//	protected static final String FREE_INDICES_POSTFIX = "p";
	private final static boolean DEBUG = false;
	
	/**
	 * Given a reduction, and a schedule for its body, serializes the reduction according to the schedule.
	 * Returns the name of the serialized equation.
	 * 
	 * Basic idea :
	 * There are two things that needs to be derived.
	 *  1. The dependence function between iteration points of the body of reduction so that 
	 *    the dependence can be uniformized.
	 *  2. The dependence function between the use and the result of reduction so that the 
	 *    reduce expression in the original program can be replaced.
	 *    
	 * An ILP problem is constructed to find these dependencies, which returns a Quast after calling ISL.
	 * 
	 * For the uniformization dependence, 
	 * 
	 * 
	 * @param re
	 * @param schedule
	 */
	public static String transform(ReduceExpression re, AffineFunction schedule) {
		String varName;
		if (re.getContainerEquation() instanceof StandardEquation){
			varName = ((StandardEquation)re.getContainerEquation()).getVariable().getName();
		} else {
			varName = ((UseEquation)re.getContainerEquation()).getOutputs().get(0).getName();
		}
		return transform(re, schedule, "_ser"+varName);
	}
	
	public static String transform(ReduceExpression re, AffineFunction schedule, String serName) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		try {
			if (!(schedule.getPMmapping().buildRelation(manager).isBijective())) {
				throw new RuntimeException("The schedule given to SerializeReduction must be bijective (until completion is implemented).");
			}
//			ProblemInstance problem = constructProblem(re, schedule);
				
			
			AffineSystem syst;
			VariableDeclaration oriVarDec;
			if (re.getContainerEquation() instanceof StandardEquation){
				syst = ((StandardEquation)re.getContainerEquation()).getContainerSystem();
				oriVarDec = ((StandardEquation)re.getContainerEquation()).getVariable();
			}
			else{
				syst = ((UseEquation)re.getContainerEquation()).getContainerSystem();
				oriVarDec = ((UseEquation)re.getContainerEquation()).getOutputs().get(0);
			}
			
			ParameterDomain param = syst.getParameters();
			Domain origDomain = re.getExpr().getContextDomain();
			AffineFunction proj = re.getProjection().copy();
			Constraint projConstraint = new Constraint(re.getProjection(), re.getProjection(), ComparisonOperator.EQ);
			Constraint schedConstraint = new Constraint(schedule, schedule, ComparisonOperator.GT);
			Map<Domain, AffineFunction> serQuast = DomainOperations.findDependencies(param, origDomain, origDomain, projConstraint, schedConstraint);//findDependencies(problem.origParamDomain, problem.origDomain, problem.probDomWithSC);
			Map<Domain, AffineFunction> depQuast = DomainOperations.findDependencies(param, origDomain.copy().image(schedule), origDomain.copy().image(schedule), projConstraint, null);//findDependencies(problem.origParamDomain, problem.origDomain, problem.problemDomain);
			
			if (DEBUG) {
				System.out.println("===Domain===");
				System.out.println(origDomain);
				System.out.println("===Proj Constraint===");
				System.out.println(projConstraint);
				System.out.println("===Sched Constraint===");
				System.out.println(schedConstraint);
				System.out.println("===Ser Quast===");
				for (Domain dom : serQuast.keySet()) {
					System.out.println(dom + " : " + serQuast.get(dom));
				}
				System.out.println("===Dep Quast===");
				for (Domain dom : depQuast.keySet()) {
					System.out.println(dom + " : " + depQuast.get(dom));
				}
			}
			
			
			//Create new variable using the context domain of reduction expression
			String newVarName = serName;
			while (syst.containsVariable(newVarName)) {
				newVarName = "_"+newVarName;
			}
			VariableDeclaration var = fact.createVariableDeclaration(newVarName, re.getExpressionType(), re.getExpr().getContextDomain().copy());
			syst.getLocals().add(var);
			
			//Iterate over the quast and construct the equation for computing reduction body with serialized dependence
			List<Expression> exprs = new LinkedList<Expression>();
			for (Domain dom : serQuast.keySet()) {
				Expression expr;
				//When the domain is for bottom, use the original expression as is 
				if (serQuast.get(dom) == null) {
					expr = re.getExpr().copy();
				//Otherwise, combine the expression with accumulation variable
				} else {
					expr = re.getExpr().copy();
					DependenceExpression dep = fact.createDependenceExpression(serQuast.get(dom), fact.createVariableExpression(var)); 
					expr = fact.createBinaryExpression(re.getOP(), dep, expr);
				}
				//Put the expression in side the domain of this quast node
				exprs.add(fact.createRestrictExpression(dom, expr));
			}
			
			//Create case expression using the expressions created above
			CaseExpression caseExpr = fact.createCaseExpression(exprs);
			//then put it inside an equation for defining the new variable
			StandardEquation eq = fact.createStandardEquation(var, caseExpr);
			syst.getEquations().add(eq);
			//replace the original reduction with variable expression to the new variable composed with the projection
			List<Expression> depExprs = new LinkedList<Expression>();
//			List<AffineFunction>  depFunc= new LinkedList<AffineFunction>();
			for (Domain dom : depQuast.keySet()) {
				AffineFunction serif = schedule.copy().inverseInContext(re.getContextDomain(), null).compose(depQuast.get(dom));
				DependenceExpression depExpr = fact.createDependenceExpression(serif, fact.createVariableExpression(var));
				AffineFunction invFunc = re.getProjection().inverseInContext(dom.image(serif), null);
				DependenceExpression invDep = fact.createDependenceExpression(invFunc, depExpr);
				depExprs.add(invDep);
			}
			CaseExpression depCase = fact.createCaseExpression(depExprs);
		
//		AffineFunction func = fact.createAffineFunction(((ISLMap)re.getProjection().getPMmapping()).reverse());
//		DependenceExpression newExpr = fact.createDependenceExpression(re.getProjection().inverseInContext(re.getExpr().getContextDomain(), null), depCase);
		
			if (depCase.getExprs().size() == 1) {
				EcoreUpdater.update(re, depCase.getExprs().get(0));
			} else {
				EcoreUpdater.update(re, depCase);
			}
			
			
			//update the target mapping after seralize reduction
			//TODO: SHOULD OFFER THIS AS OPTIONS
			
			//VariableDeclaration varDec = syst.getVariableDeclaration(serName);
			
			//set the space time map for the newly construct reduction to be identity
			//syst.getTargetMapping().setSpaceTimeMap(varDec, schedule.copy());
			//set the memory map for the new variable to reuse the memory space of the old variables
			//get the original memory space
//			MemorySpace ms = syst.getTargetMapping().getMemorySpace(oriVarDec);
//			if(ms == null){
//				ms = TargetMappingUserFactory.createIdentityMemorySpace(oriVarDec);
//			}
//			//get the memory mapping function for the new variable
//			AffineFunction memMap = ms.getMemoryMap(oriVarDec).getMapping().compose(proj);
//			
//			syst.getTargetMapping().setMemoryMap(ms, varDec, memMap, null);
			
			/*
			 * set the target mapping for the old reduction variables
			 * the schedule for the old reduction variables should be the last value computed by the reduction + 1
			 * 
			 */
			//get the time stamp for the value copied back
//			AffineFunction lastFunc = schedule.compose(depFunc.get(0));
//			//move the time along the innermost dimension
//			int dim = lastFunc.getDimRHS();
//			List<String> index = new LinkedList<String>();
//			for(int i = 0; i < dim; i++){
//				String ind = "i"+i;
//				index.add(ind);
//			}
//			List<String> affine_exprs = new LinkedList<String>();
//			for(int i = 0; i < dim - 1; i++){
//				affine_exprs.add(index.get(i));
//			}
//			String exp = index.get(dim - 1) + "+ 1";
//			affine_exprs.add(exp);
//			AffineFunction uniformFunction = PolyhedralIRUtility.parseAffineFunction(param, index, affine_exprs);
//			AffineFunction oriSpaceTime = uniformFunction.compose(lastFunc);
//			
//			
//			//get the original variable declaration
//			//AffineFunction oriSpaceTime = schedule.compose(lastFunc.get(0));
//			syst.getTargetMapping().setSpaceTimeMap(oriVarDec, oriSpaceTime);
			
			//get the time stamp when the last value is computed
			//syst.getTargetMapping().
		} catch (PolymodelException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return serName;
	}
	
//	protected static Map<Domain, AffineFunction> findDependencies(ParameterDomain origPramDomain, Domain origDomain, Domain problem) {
//		
//		Map<Domain, AffineFunction> quast = new HashMap<Domain, AffineFunction>();
//		
//		Domain result = fact.createDomain(((ISLSet)problem.getPMdomain()).lexMax());
//		
//		//get list of parameter/index
//		EList<String> names = result.getParamNames();
//		names.addAll(result.getIndexNames());
//		
//		//Domain for bottom
//		Domain bottom = origDomain.copy();
//		
//		//Iterate over each polyhedron
//		List<Matrix> matrices = result.getPMdomain().toMatrices();
//		for (Matrix mat : matrices) {
//			//Separate the constraints to those that express the function, and those that express the domain
//			List<String> depFunc = new Vector<String>(result.getNIndices());
//			// initialize dependence expr vector with empty string, since which element to store the expression determines the dimension
//			for (int i=0; i < result.getNIndices(); i++) {
//				depFunc.add("");
//			}
//			List<String> domain = new LinkedList<String>();
//			for (MatrixRow row : mat.getRows()) {
//				//Equality has a chance that it is about the dependence
//				if (row.get(0) == 0) {
//					//Check the dimensions corresponding to the new indices
//					// these dimensions are non-zero for dependence equalities only (I think)
//					boolean wasDep = false;
//					//offset by one for eq/ineq
//					for (int d = result.getNParams()+1; d < result.getDim()+1; d++) {
//						//Dependence expression for dimension d if the column is non-zero
//						if (row.get(d) != 0) {
//							//Need to negate the other terms if the coefficient on this term is positive
//							boolean negate = row.get(d) > 0;
//							if (Math.abs(row.get(d)) != 1) {
//								throw new RuntimeException("Unexpected coefficient for dimension :" + d);
//							}
//							StringBuffer expr = new StringBuffer();
//							//constant part
//							long cpart = row.get(row.getSize()-1);
//							//Other expressions
//							boolean first = true;
//							for (int dp = 0; dp < result.getNParams(); dp++) {
//								//offset by 1 for eq/ineq
//								long coef = row.get(dp+1);
//								if (coef != 0) {
//									if (negate) {
//										coef = -coef;
//									}
//									if (!first) {
//										expr.append("+");
//									}
//									first = false;
//									expr.append(coef+""+result.getParams().get(dp));
//								}
//							}
//							//add constant to the end
//							if (negate && cpart != 0) {
//								expr .append("-"+cpart);
//							} else if (cpart != 0) {
//								expr .append("+"+cpart);
//							}
//							depFunc.set(d-1-result.getNParams(), expr.toString());
//							wasDep = true;
//							break;
//						}
//					}
//					if (!wasDep) {
//						domain.add(row.toConstraint(names));
//					}
//				} else {
//					domain.add(row.toConstraint(names));
//				}
//			}
//			Domain dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(origPramDomain,origDomain.getIndexNames(), domain);
//			AffineFunction dep = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(origPramDomain, origDomain.getIndexNames(), depFunc);
//			quast.put(dom, dep);
//			bottom = bottom.difference(dom);
//		}
//		
//		//If bottom is not empty, add it with null dependence
//		if (!bottom.isEmpty()) {
//			quast.put(bottom, null);
//		}
//		
//		return quast;
//	}
//	
//	protected static class ProblemInstance {
//		private Domain origDomain;
//		private ParameterDomain origParamDomain;
////		private AffineFunction identityToNewName;
//		private Domain problemDomain;
//		private Domain probDomWithSC;
//	}
//	
//	protected static ProblemInstance constructProblem(ReduceExpression re, AffineFunction schedule) {
//		ProblemInstance pi = new ProblemInstance();
//		
//		pi.origDomain = re.getExpr().getContextDomain();
//		pi.origParamDomain = re.getContainerEquation().getContainerSystem().getParameters();
//		
//		pi.problemDomain = DomainOperations.extendParameterDomain(re.getExpr().getContextDomain(), re.getExpr().getContextDomain());
//		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(pi.origParamDomain, pi.problemDomain, new Constraint(re.getProjection(), re.getProjection(), Operator.EQ));
//		pi.probDomWithSC = pi.problemDomain.copy();
//		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(pi.origParamDomain, pi.probDomWithSC, new Constraint(schedule, schedule, Operator.GT));
//		
//		return pi;
//		
//		//OLD code kept until new one is fully functional
////		//Convert the context domain to parameter domain
////		ParameterDomain exDom = re.getExpr().getContextDomain().toParameterDomain();
////		
////		//Add new indices as for free variables
////		for (int i = 0; i < re.getExpr().getContextDomain().getNIndices(); i++) {
////			exDom.addDimension(re.getExpr().getContextDomain().getIndices().get(i)+FREE_INDICES_POSTFIX);
////		}
////		
////		//Copy the context domain and add parameters to create the domain for free variables
////		Domain freeDom = re.getExpr().getContextDomain().copy();
////		//First change the name
////		for (IVariable iv : freeDom.getIndices()) {
////			IndexDimension id = ((IndexDimension)iv);
////			id.setName(id.getName()+FREE_INDICES_POSTFIX);
////		}
////		//Create identity function with new names, and then compose with the projection to rename projection function
////		pi.identityToNewName = fact.createIdentityFunction(freeDom);
////		AffineFunction proj = re.getProjection().compose(pi.identityToNewName);
////		//Then add parameters
////		for (int i = exDom.getNParams() - freeDom.getNIndices(); i < exDom.getNParams(); i++) {
////			freeDom.addParameterDimension(exDom.getParams().get(i).toString());
////		}
////
////		//Take the intersection to get the domain with all constraints for the space
////		pi.problemDomain = exDom.intersection(freeDom);
////
////		//Now add equalities for mapping added parameters to new indices for conflicting indices
////		//Projection Constraints for original index names (now parameters) and new names
////		List<String> origProjConsts = re.getProjection().getPMmapping().getFunctions(FORMAT.ALPHABETS);
////		List<String> newProjConsts = proj.getPMmapping().getFunctions(FORMAT.ALPHABETS);
////		List<String> projEqualities = new LinkedList<String>();
////		for (int i = 0; i < proj.getDimRHS(); i++) {
////			projEqualities.add(origProjConsts.get(i) + "==" + newProjConsts.get(i));
////		}
////		pi.problemDomain = fact.createDomain(exDom, pi.problemDomain.getIndexNames(), projEqualities).intersection(pi.problemDomain);
////		
////		//Then add constraints s.t. schedule applied on the parameters are strictly after that applied to the indices
////		// union of domains to handle multi-dimensional schedules
////		List<List<String>> constraints = new LinkedList<List<String>>();
////		List<List<String>> indicesU = new LinkedList<List<String>>();
////		//Create schedule with new indices names
////		AffineFunction schedNI = schedule.compose(pi.identityToNewName);
////		for (int d = 0; d < schedule.getDimRHS(); d++) {
////			//Indices are the same for each union
////			indicesU.add(pi.problemDomain.getIndexNames());
////			//Schedule applied to the parameters
////			List<String> schedConstsParam = schedule.getPMmapping().getFunctions(FORMAT.ALPHABETS);
////			//Schedule applied to the new indices
////			List<String> schedConstsNI    = schedNI.getPMmapping().getFunctions(FORMAT.ALPHABETS);
////			
////			//Schedule constraints for this dimension
////			List<String> schedConsts = new LinkedList<String>();
////			for (int i = 0; i < schedNI.getDimRHS(); i++) {
////				//On the dimension to check, schedule applied to the parameters should be strictly greater
////				if (i == d) {
////					schedConsts.add(schedConstsParam.get(i)+">"+schedConstsNI.get(i));
////					break;
////				//Other (previous) dimensions must be equal are equal
////				} else {
////					schedConsts.add(schedConstsParam.get(i)+"=="+schedConstsNI.get(i));
////				}
////			}
////			//Add equalities for projection
////			schedConsts.addAll(projEqualities);
////			constraints.add(schedConsts);
////		}
////		//Finally, create the union for MD schedule constraints, and then intersect with the constraints on problem domain.
////		if (constraints.size() == 0) {
////			pi.probDomWithSC = pi.problemDomain.copy();
////		} else {
////			pi.probDomWithSC =  fact.createDomainUnion(exDom, indicesU, constraints).intersection(pi.problemDomain);
////		}
////		
////		System.out.println(pi.probDomWithSC);
////		Domain test = DomainOperations.extendParameterDomain(re.getExpr().getContextDomain(), re.getExpr().getContextDomain());
////		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(pi.origParamDomain, test, re.getProjection(), re.getProjection(), Operator.GT);
////		System.out.println(test);
//		
////		return pi;
//	}
	
}
