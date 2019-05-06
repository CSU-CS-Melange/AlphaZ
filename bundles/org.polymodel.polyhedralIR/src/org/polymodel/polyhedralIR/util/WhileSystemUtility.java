package org.polymodel.polyhedralIR.util;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.Function;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Split;
import org.polymodel.polyhedralIR.transformation.reduction.PermutationCaseReduce;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;


/*
 * Utility methods to compute history needed for the time dimension.
 */
public class WhileSystemUtility {
	
	//Temporary local variable name postfix for while systems
	public static final String WHILE_LOCAL_VAR_POSTFIX = "__Wlocal";
	public static final String WHILE_LOCAL_MAIN_VAR_POSTFIX = WHILE_LOCAL_VAR_POSTFIX+"__Main";
	public static final String WHILE_LOCAL_VAR_SPLIT_POSTFIX = "__Wsplit";
	
	/*
	 * Given a variable and a system, computes the number of time slices 
	 * that is required to be stored for the variable as an AffineExpression 
	 */
	public static AffineExpression analyzeHistory(VariableDeclaration variable, AffineSystem system) {
		PRDG prdg = PRDGBuilder.build(system); //TODO I need to improve this, not to create prdg every time
		
		PRDGNode prdgNode = prdg.getNode(variable.getName());
		
		//Domain of the variable
		Domain D_v = variable.getDomain();
		//Union of min domains for all dependences
		org.polymodel.Domain D_u;

		if (prdgNode.getSources().size()>0) {
			D_u = PolyhedralIRUtility.createEmptyDomain(
					variable.getDomain().getParams(), 
					Collections.singletonList(variable.getDomain().getIndices().
							get(0))).getPMdomain();
		
		} else {
			D_u = PolyhedralIRUserFactory._polyFact.createDomain(
						 Collections.singletonList(variable.getDomain().getIndices().get(0)), 
						 variable.getDomain().getParams(),
						 IntExpressionBuilder.constraintSystem(constraint(
								 affine(term(variable.getDomain().getIndices().get(0))), 
								 affine(term(0)), ComparisonOperator.EQ)));
		}
		
		for (PRDGEdge prdgEdge : prdgNode.getSources()) {
			//check whether the access function on time/while dimension is a constant. Then we skip analysis
			if (prdgEdge.getFunction().getMapping().getExpression(0).isConstant() == FuzzyBoolean.YES) {
				continue;
			}
			
			org.polymodel.Domain tt = analyzeHistory(prdgEdge, D_v);
			
			D_u = D_u.union(tt);
		}
		
		org.polymodel.Domain DlexMin = D_u.lexMin();
		Domain DlexMinPolyIR = PolyhedralIRUserFactory.eINSTANCE.createDomain(DlexMin);		
		DlexMinPolyIR.simplify();
		
		IntExpression lowerbound = DlexMinPolyIR.getLowerBound(0);
		
		//get the absolute value + 1
		AffineExpression affineLowerbound = IntExpressionBuilder.add(1, 
				IntExpressionBuilder.prod(lowerbound, 
						IntExpressionBuilder.constant(-1))).toAffine();
		
		return affineLowerbound; 
	}
	
	/*
	 * Given an PRDGEdge corresponding to read of a variable and domain of 
	 * the variable, computes the time slices that is required for this
	 * variable to be saved as an Domain object
	 */
	public static org.polymodel.Domain analyzeHistory(PRDGEdge prdgEdge, Domain D_v) {
		//(t,zz) -> (t-g(zz), hh(zz)) // we need to extract g(zz) and hh(zz) first for each dependence of "variable". Notation: repeated same letter means, multidimensional
		
		Function mapping = prdgEdge.getFunction().getMapping();
		List<IntExpression> mappingIntExpressions = new ArrayList<>(
				EcoreUtil.copyAll(prdgEdge.getFunction().
						getMapping().getExpressions()));//TODO check whether order of elements is preserved
		
		IntExpression whileDimention = mappingIntExpressions.remove(0); //To be used to extract g(zz)
		
		List<AffineExpression> mappingAffineExpressions = new ArrayList<AffineExpression>();
		for (IntExpression ie : mappingIntExpressions){
			mappingAffineExpressions.add(IntExpressionBuilder.affine(ie));
		}
		
		// (t,zz) -> hh(zz) //(t,i,j->i-1,j+1)
		AffineFunction hhzz = PolyhedralIRUserFactory.eINSTANCE.
				createAffineFunction(mapping.getParameters(), mapping.getIndices(), 
						mappingAffineExpressions);
		
		AffineExpression whileDimensionAffine = whileDimention.toAffine();
		List<AffineTerm> affineTermsOfgzz = new ArrayList<AffineTerm>();
		for (AffineTerm at : whileDimensionAffine.getTerms()) {
			if (mapping.getIndices().get(0).equals(at.getVariable())) {
				continue;
			}
			affineTermsOfgzz.add(at);
		}
		
		whileDimensionAffine = IntExpressionBuilder.affine(affineTermsOfgzz);
		
		//Removing the while dimension from the output variables.
		List<Variable> vl = new ArrayList<Variable>(mapping.getIndices());
		vl.remove(0);
		
		List<AffineExpression> mappingAffineWhileExpressions = new ArrayList<AffineExpression>();
		mappingAffineWhileExpressions.add(whileDimensionAffine);
		
		// (t,zz->zz)
		AffineFunction hhzzp = PolyhedralIRUtility.createProjection(D_v, vl);
		Domain D_j = D_v.image(hhzz).intersection(D_v.image(hhzzp));
		
		// (zz -> g(zz)) //(i,j->-1)
		AffineFunction gzz = 
				PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(
						mapping.getParameters(), 
						vl, 
						mappingAffineWhileExpressions);
		
		//We need to find the lex min of this
		org.polymodel.Domain tt = D_j.image(gzz).polyhedralHull().getPMdomain().lexMin();
		tt.simplify();
		
		return tt;
	}
	
	/*
	 * Given a variable and a system, computed the maximum constant value 
	 * referral for the time index
	 */
	static AffineExpression analyzeConstant(VariableDeclaration variable, AffineSystem system) {
		PRDG prdg = PRDGBuilder.build(system); //TODO I need to improve this, not to create prdg every time
		
		PRDGNode prdgNode = prdg.getNode(variable.getName());
		
		IntExpression constant = IntExpressionBuilder.constant(-1); 
		
		for (PRDGEdge prdgEdge : prdgNode.getDestinations()) {
			if (prdgEdge.getFunction().getMapping().getExpression(0).
					isConstant() == FuzzyBoolean.YES) {
				constant = IntExpressionBuilder.max(constant, 
						prdgEdge.getFunction().getMapping().getExpression(0));
			}
		}
		
		return constant.toAffine();
	}
	
	/*
	 * Given a domain and a dimension, check whether the given dimension
	 * is bounded
	 */
	static boolean isBounded(Domain dom, int dim) {
		
		boolean isBounded = true;
		
		if (dom.getIndices().size() < dim) {
			throw new RuntimeException("Cannot take projection of " + dom + 
					" to " + dim + "th dimension.");
		}
		
		//Take projection to the specified domain
		List<String> projExpr = new LinkedList<String>();
		projExpr.add(dom.getIndices().get(dim).toString());
		AffineFunction projection = PolyhedralIRUtility.
				parseAffineFunction(dom.getParams(), dom.getIndices(), projExpr);
		Domain projDom = dom.image(projection);

		//The only index left is the target
		Variable target = projDom.getIndices().get(0);

		//Iterate over all systems and collect bounds
		for (IntConstraintSystem ics : projDom.getPMdomain().getPolyhedra()) {
			IntExpression lb = ics.getLB(target);
			IntExpression ub = ics.getUB(target);
			if (lb == null || ub == null) {
				isBounded = false;
			}
		}

		return isBounded;
	}
	
	/*
	 * Given a system, for all the variables with constant referrals on time 
	 * dimension(s) are split. Domain ^ t < constant and Domain ^ t >= constant  
	 */
	public static void splitVariablesForWhileSystems(AffineSystem system) {
		AffineExpression constant;;
		AffineExpression negativeConstant = IntExpressionBuilder.constant(-1).toAffine();
		List<VariableDeclaration> vars = 
				new ArrayList<VariableDeclaration>(system.getOutputs().size()+
						system.getLocals().size());
		vars.addAll(system.getLocals());
		
		for (VariableDeclaration var : vars) {
			constant = analyzeConstant(var, system);
			
			/*
			 * We split a variable if it has referred with constant in its time index
			 */
			if (!constant.toString().equals(negativeConstant.toString())) {
				String constraitAsString = var.getDomain().
						getIndices().get(0).getName() + "<=" + constant;
				List<String> constraintList = new ArrayList<String>();
				constraintList.add(constraitAsString);
				Domain constantD = PolyhedralIRUtility.parseDomain(
						var.getDomain().getParams(), var.getDomain().getIndices(), 
						constraintList);
				Split.transform(system, var, constantD, var.getName()+
					WHILE_LOCAL_VAR_SPLIT_POSTFIX); // newname is set to oldname__Wsplit
			}
		}
		
//	 	TODO to be removed after fixing codegen for writeC reduction body 
		{
			Normalize.normalize(system);
			PermutationCaseReduce.caseReduce(system);
		}
	}
	
	/*
	 * For all the variables with a history, add a modulo memory map 
	 */
	public static void updateTargetMappingForWhileSystems(AffineSystem system) {
		if (system.getWhileInfo() != null) {
			AffineExpression history;
			
			TargetMapping tm = system.getTargetMapping();
			for (Map.Entry<VariableDeclaration,MemoryMap> entry : tm.getMemoryMaps()) {
	 			VariableDeclaration variable = entry.getKey();
				if (variable.isInput()) {
					continue;
				}
				
				if (isBounded(variable.getDomain(), 0)) {//check whether 0th or time dimension is bounded
					continue;
				}
				
				if (variable.getType().getTypeID().getValue()==DATATYPE.CHAR.getValue()) { //TODO better way is to check whether this is flag variable rather than checking for type CHAR
					history = analyzeHistory(
							system.getVariableDeclaration(
									variable.getName().startsWith("_flag_")
									?variable.getName().
									substring(6, variable.getName().length())
									: variable.getName()), 
									system); //remove _flag_
				} else {
					history = analyzeHistory(variable, system);
				}
				
				MemoryMap memoryMap = entry.getValue();
				memoryMap.getModFactors().remove(0);
				memoryMap.getModFactors().add(0, history);
			}
		}
	}
	
	/*
	 * Remove the time dimensions of the domain of the variable
	 */
	public static void removeTimeDimensions(VariableDeclaration var, Domain timeDomain) {
		Domain varD = var.getDomain();
		List<Variable> indices = (List<Variable>) EcoreUtil.copyAll(varD.getIndices());
		
		for (int i = 0; i< timeDomain.getNIndices(); i++) {
			indices.remove(0);
		}
		
		AffineFunction projectionFunction = PolyhedralIRUtility.createProjection(varD, indices);
		Domain domainWithOutTime  = varD.image(projectionFunction);
		
		/*
		 * Above domainWithOutTime has indices names starting from t, i, ... 
		 * But we do not need t as the first dimension since that is 
		 * the one we just removed and this will make issues in the 
		 * generated code. Therefore, we need to change the names of 
		 * indices. For that we create a domain {i,j,... | 0==0} and get 
		 * the intersection of this domain with newDomain. 
		 * This will change the indices to i,j,...  
		*/
		Domain trueDomain = 
				PolyhedralIRUserFactory.eINSTANCE.createDomain(var.getDomain().getParams(), 
						indices, 
						IntExpressionBuilder.constraintSystem(
							IntExpressionBuilder.eq(
								IntExpressionBuilder.affine(
										IntExpressionBuilder.term(0)), 
								IntExpressionBuilder.affine(
										IntExpressionBuilder.term(0)))));
		domainWithOutTime = trueDomain.intersection(domainWithOutTime);
		
		var.setDomain(domainWithOutTime);
	}
	
	/*
	 * Compute the history of termination condition of the while system
	 * 
	 * This is used to check the 1st time iteration to check the condition
	 */
	public static AffineExpression historyOfCondition(AffineSystem a) {
		PRDG prdg = PRDGBuilder.build(a); //TODO I need to improve this, not to create prdg every time

		org.polymodel.Domain D_u = PolyhedralIRUtility.createEmptyDomain(
				a.getParameters().getParams(), 
				a.getWhileInfo().getTimeDomain().getIndices()).getPMdomain();
		
		for (PRDGEdge prdgEdge : prdg.getEdges()) {
			PRDGNode srcNode = prdgEdge.getSource();
			if (!srcNode.getName().startsWith("isCond")) {
				continue;
			}
			PRDGNode destNode = prdgEdge.getDestination();
			if (a.getVariableDeclaration(destNode.getName()) == null) {
				continue;
			}
			org.polymodel.Domain history = 
					WhileSystemUtility.analyzeHistory(
							prdgEdge, 
							PolyhedralIRUserFactory.eINSTANCE.createDomain(
									EcoreUtil.copy(destNode.getDomain())));
			D_u = D_u.union(history);
		}
		
		org.polymodel.Domain DlexMin = D_u.lexMin();
		Domain DlexMinPolyIR = PolyhedralIRUserFactory.eINSTANCE.createDomain(DlexMin);		
		DlexMinPolyIR.simplify();
		
		IntExpression lowerbound = DlexMinPolyIR.getLowerBound(0);
		AffineExpression affineLowerbound = 
				IntExpressionBuilder.add(
						1, 
						IntExpressionBuilder.prod(lowerbound, 
								IntExpressionBuilder.constant(-1))).toAffine();
		return affineLowerbound;
	}
}
