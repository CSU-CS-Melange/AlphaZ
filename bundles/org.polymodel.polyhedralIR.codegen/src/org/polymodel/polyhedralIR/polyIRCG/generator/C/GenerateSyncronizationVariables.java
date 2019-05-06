package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;


/*
 * Inserts Acquire and Update statements which implements dynamic checks for 
 * the dependences that must be satisfied at runtime dynamically.
 * 
 * We only look at the use equations.
 * We assume that visiting the CART generated use-equations is enough to determine
 * statements and their schedule.
 * But I have a doubt about this approach, we may have to look at statements to 
 * make sure deps between output of use-eq and input
 * 
 * We generate acquire statements per input variable of use-equation? or 
 * per use-equation??
 * I think the second option is the current implementation
 * 
 * If we find a dep that cause inter-processor communication, then theoretically 
 * We should check dynamically only within that domain. But to reduce control overhead,
 * caused by taking difference between domains, we simply check for whole domain
 * 
 * The ordering dim to insert checks is the number of dims in the ext domain of
 * use equations. 
 * 
 */
public class GenerateSyncronizationVariables  extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	static String acquirePrefix = "__Acquire_";
	static String updatePrefix = "__Update_";
	static String acquireFunctionName = "acquire_function";
	static String updateFunctionName = "update_function";
	static String checkFunctionName = "check_function";
	
	private AffineSystem system;
	
	private StandardEquation currentSEquation;
	
	private Set<Integer> parallelDimentions;
	
	private Domain currentDomainofExp;
	private Domain currentDynamicDomainofExp;
	private Domain currentDynamicDomainofCaseExp;
//	private Expression currentMainExpression;
//	private Expression currentCaseExpression;
	
	private List<Expression> checkExprs; 
	
	private boolean isCaseExp = false;
	private boolean isUseExp = false;
	
	ExternalFunctionDeclaration externalFunctionAcquire;
	ExternalFunctionDeclaration externalFunctionUpdate;
	ExternalFunctionDeclaration externalFunctionCheck;
	
	TargetMapping tm;
	SpaceTimeLevel stlevel;
	
	Domain updateStatementDomain;
	
	int orderingDimOfChecks=0;
	//number of dims in the RHS of the target mapping 
	int nDims;
	
	//TergetMapping of subsystem call of curent use equation
	SpaceTimeMap currentSTMap;
	
//	//keep track of subsystem inputs
//	List<VariableDeclaration> subSystemInputs;
//	//current input id of the Subsystem
//	int inputId;
	
	public GenerateSyncronizationVariables(AffineSystem system) {
		this.system = system;
		this.checkExprs = new ArrayList<Expression>();
		tm = system.getTargetMapping();
		stlevel = tm.getSpaceTimeLevel(0);
		
		parallelDimentions = new TreeSet<Integer>();
	
		for (ParallelizationSpecification ps : stlevel.getParallelizationSpecifications()) {
			parallelDimentions.addAll(ps.getParallelDims());
		}
		
		externalFunctionAcquire = PolyhedralIRUserFactory.eINSTANCE.createExternalFunctionDeclaration(acquireFunctionName, 
				PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER), 
				Collections.<org.polymodel.polyhedralIR.Type>emptyList());
//				Collections.singletonList(PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER)));
		system.getContainerProgram().getExternalFunctionDeclarations().add(externalFunctionAcquire);
		externalFunctionUpdate = PolyhedralIRUserFactory.eINSTANCE.createExternalFunctionDeclaration(updateFunctionName, 
				PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER),
				Collections.nCopies(stlevel.getNumberOfDimensions(), 
						PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER)));
		externalFunctionCheck = PolyhedralIRUserFactory.eINSTANCE.createExternalFunctionDeclaration(checkFunctionName, 
				PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER),
				Collections.nCopies(stlevel.getNumberOfDimensions(), 
						PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER)));
//				Collections.singletonList(PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER)));
	}

	public static AffineSystem generateSyncronizationVariables(AffineSystem system) {
		GenerateSyncronizationVariables gsv = 
				new GenerateSyncronizationVariables(system);
		gsv.process();
		return gsv.system;
	}
	
	private void process() {
		system.getContainerProgram().getExternalFunctionDeclarations().add(externalFunctionAcquire);
		system.getContainerProgram().getExternalFunctionDeclarations().add(externalFunctionUpdate);
		system.getContainerProgram().getExternalFunctionDeclarations().add(externalFunctionCheck);
		
		EcoreUtil.copy(system).accept(this);
	}

	@Override
	public void outAffineSystem(AffineSystem a) {
		// Add the equation for update variable.
		if (updateStatementDomain != null) {
			// Create a variable for the update 
			VariableDeclaration var = PolyhedralIRUserFactory.eINSTANCE
					.createVariableDeclaration(updatePrefix, 
							PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER), 
							updateStatementDomain);
			
			List<Variable> aexps = updateStatementDomain.getIndices();
			List<Expression> idxExprs = new ArrayList<Expression>();
			// Create arguments for the update function call
			for (int i = 0; i < orderingDimOfChecks; i++) {
				AffineExpression aExp = IntExpressionBuilder.affine(aexps.get(i));
				AffineFunction indexFunc = PolyhedralIRUserFactory
						.eINSTANCE.createAffineFunction(
								system.getParameters().getParams(), 
								aexps, 
								Collections.singletonList(aExp));
				IndexExpression ie = PolyhedralIRUserFactory.eINSTANCE.createIndexExpression(indexFunc);
				idxExprs.add(ie);
			}
			
			// Create the update external function call, using the arguments 
			// computed above
			ExternalFunctionCall updateFunctionCallExp = PolyhedralIRUserFactory
					.eINSTANCE.createExternalFunctionCall(
							externalFunctionUpdate, 
							idxExprs);
			// Create an equation for the update variable wich is defined by the 
			// external function call we just created
			StandardEquation se = PolyhedralIRUserFactory.eINSTANCE.
					createStandardEquation(var, updateFunctionCallExp);
			system.getLocals().add(var);
			
			currentSEquation=se;
			
			// Set the target mapping for the update variable. The value of the 
			// ordering dimension is set to 2.
			setTargetMapping(false);
			
			//setting the memory map of update variable to z -> processor dimensions
			List<Integer> parallelDims = new ArrayList<Integer>();
			
			for (ParallelizationSpecification ps : stlevel.getParallelizationSpecifications()) {
				parallelDims.addAll(ps.getParallelDims());
			}
			
			List<Variable> exprs = new ArrayList<Variable>();
			for (int pIndx : parallelDims) {
				exprs.add(var.getDomain().getIndices().get(pIndx));
			}
			MemorySpace space = tm.getMemorySpace(var.getName());
			
			MemoryMap map = TargetMappingUserFactory.createMemoryMap(var, 
					PolyhedralIRUtility.createProjection(var.getDomain(), exprs), 
					null, space);
			tm.getMemoryMaps().put(var, map);

			system.getEquations().add(se);
		}
	}
	
	@Override
	public void visitUseEquation(UseEquation u) {
		
		if (orderingDimOfChecks < u.getExtensionDomain().getNIndices()) {
			orderingDimOfChecks = u.getExtensionDomain().getNIndices();
		} else if (orderingDimOfChecks > u.getExtensionDomain().getNIndices()) {
			//Skip the use equation corresponds to output of the main system
			//They do not have the same number of extension domain dimensions
			return;
		}
		
		currentSTMap = stlevel.getSpaceTimeMaps().get(u.getLabel());
		
		isUseExp = true;
		
		System.out.println(u.getLabel() + " :Ordering DIm: " + orderingDimOfChecks);
		
		currentSEquation = null;
		currentDomainofExp = u.getExtensionDomain();
		
		checkExprs.clear();

		//Reset the dynamic domain for use equation. The dynamic domain for 
		//all the inputs will be accumulated to this variable
		currentDynamicDomainofCaseExp=PolyhedralIRUtility.createEmptyDomain(
				currentDomainofExp.getParams(), 
				currentDomainofExp.getIndices());
		
//		subSystemInputs = u.getSubSystem().getInputs();
//		
//		inputId = 0;
		for (Expression e : u.getInputs()) {
			e.accept(this);
//			inputId++;
		}
		
		if (!checkExprs.isEmpty()) {
			ExternalFunctionCall acquireFunctionCallExp = PolyhedralIRUserFactory
					.eINSTANCE.createExternalFunctionCall(
							externalFunctionAcquire, 
							checkExprs);
			//We do not use the dynamic domain "currentDynamicDomainofCaseExp"
			//as the domain of checkVar. to reduce the control overhead
			VariableDeclaration var = PolyhedralIRUserFactory.eINSTANCE
					.createVariableDeclaration(acquirePrefix+u.getLabel(), 
							PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.INTEGER), 
							EcoreUtil.copy(currentDomainofExp));
			StandardEquation newSE = PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(var, acquireFunctionCallExp);
			currentSEquation = newSE;
			system.getEquations().add(newSE);
			system.getLocals().add(var);
			setTargetMapping(true);
		}
		
		if (updateStatementDomain == null) {
			updateStatementDomain = PolyhedralIRUtility.createEmptyDomain(
					currentDomainofExp.getParams(), 
					currentDomainofExp.getIndices());
		}
		
		updateStatementDomain.setPMdomain(
				updateStatementDomain.getPMdomain().union(
						EcoreUtil.copy(currentDomainofExp.getPMdomain())));		
		
		isUseExp = false;
	}

	@Override
	public void visitDependenceExpression(DependenceExpression d) {
		if (!isUseExp) {
			// Since we only interested in use equations
			return;
		}
		
		Expression e = d.getExpr();
		if (e instanceof VariableExpression) {//We assume expression of all the dependence expressions are Variable expressions 
			VariableExpression varExp = (VariableExpression)e;
			if (varExp.getVarDecl().isInput()) {
				//We do not need to wait for input variables
				return;
			}
			
			AffineFunction dep = d.getDep();
			
			boolean isEmpty = updateDynamicDomain(dep);
			
			if (isEmpty) {
				return;
			}
			
			if (isUseExp) {
				/*if (dep.getDimLHS()>stlevel.getNumberOfDimensions()) { //TODO O
					List<AffineExpression> exprs = dep.getExpressions().subList(
							0, stlevel.getNumberOfDimensions());
					for (int i = dep.getExpressions().size()-dep.getNIndices()
							+stlevel.getNumberOfDimensions(); i<stlevel.getNumberOfDimensions(); i++) {
						
						exprs.set(i, IntExpressionBuilder.constant(0).toAffine());
					}
					
					dep = PolyhedralIRUserFactory.eINSTANCE
							.createAffineFunction(dep.getParams(), 
									dep.getIndices().subList(0, stlevel.getNumberOfDimensions()), 
									exprs);
				}*/
				
				if (dep.getDimRHS() > orderingDimOfChecks 
						|| dep.getNIndices() > orderingDimOfChecks) {
					List<AffineExpression> exprs = dep.getExpressions().subList(
							0, orderingDimOfChecks);
//					for (int i = dep.getExpressions().size()-dep.getNIndices()
//							+stlevel.getNumberOfDimensions(); i<stlevel.getNumberOfDimensions(); i++) {
//						
//						exprs.set(i, IntExpressionBuilder.constant(0).toAffine());
//					}
					
					dep = PolyhedralIRUserFactory.eINSTANCE
							.createAffineFunction(dep.getParams(), 
									dep.getIndices().subList(0, orderingDimOfChecks), 
									exprs);
				}
				
			}
			List<AffineExpression> aexps = dep.getExpressions();
			List<Expression> idxExprs = new ArrayList<Expression>();
			for (int i = 0; i < orderingDimOfChecks; i++) {
				AffineExpression aExp = aexps.get(i);
				AffineFunction indexFunc = PolyhedralIRUserFactory
						.eINSTANCE.createAffineFunction(
								system.getParameters().getParams(), 
								dep.getIndices(), 
								Collections.singletonList(aExp));
				IndexExpression ie = PolyhedralIRUserFactory.eINSTANCE.createIndexExpression(indexFunc);
				idxExprs.add(ie);
			}
			

			ExternalFunctionCall checkFunctionExp = PolyhedralIRUserFactory
					.eINSTANCE.createExternalFunctionCall(
							externalFunctionCheck, 
							idxExprs);
			checkExprs.add(checkFunctionExp);
			
			if (!isUseExp) {
				updateCurrentEquation(d.eContainer());
			}
		} // else ignore
	}

	/*
	 * Set target mapping for acquire and update variables
	 */
	private void setTargetMapping(boolean isAcquire) {
		String syncVarName = currentSEquation.getVariable().getName();
		VariableDeclaration var = system.getVariableDeclaration(syncVarName);
		MemorySpace space = tm.getMemorySpace(syncVarName);
		
		MemoryMap map = TargetMappingUserFactory.createMemoryMap(var, 
				PolyhedralIRUtility.createProjection(var.getDomain(), 
						Collections.<Variable>emptyList()), 
				null, space);
		tm.getMemoryMaps().put(var, map);
		SpaceTimeMap stMap = TargetMappingUserFactory
				.createIdentityStandardEquationSpaceTimeMap(var);
		
		//We choose the same target mapping as for the use equation subsystem call
		//currentSTMap
		
		AffineFunction targetMapping = currentSTMap.getMapping().copy();
		List<AffineExpression> exprs = targetMapping.getExpressions();
		
/*		if (isAcquire){
//			exprs.set(stlevel.getNumberOfParallelDimensions(), 
			exprs.add(orderingDimOfChecks, IntExpressionBuilder.constant(0).toAffine());
		} else{
//			exprs.set(stlevel.getNumberOfParallelDimensions(), 
			exprs.add(orderingDimOfChecks, IntExpressionBuilder.constant(2).toAffine());
		}
*/		
		//set all the dims after orderingDimOfChecks to 0
//		for (int i=orderingDimOfChecks; i <stlevel.getNumberOfDimensions(); i++) {
//			exprs.set(i, IntExpressionBuilder.constant(0).toAffine());
//		}
		
		AffineFunction newTargetMapping = PolyhedralIRUserFactory.eINSTANCE
				.createAffineFunction(targetMapping.getParams(), 
									  targetMapping.getIndices(), 
									  exprs);
		stMap.setMapping(newTargetMapping);
		stMap.setInverseOfMapping(newTargetMapping.inverseInContext(var.getDomain(), null));
		stlevel.getSpaceTimeMaps().put(syncVarName, stMap);	
		
		
		
//		AffineFunction tmWithZeros = PolyhedralIRUserFactory.eINSTANCE
//				.createAffineFunction(targetMapping.getParams(), 
//									  targetMapping.getIndices(), 
//									  exprs);
		
		//TODO why change of basis?? I do not remember why I need this
//		ChangeOfBasis.CoB(system, stMap.getLabel(), stMap.getMapping(), true);
//		ChangeOfBasis.CoB(system, stMap.getLabel(), tmWithZeros, true);
	}
	
	private boolean updateDynamicDomain(AffineFunction f) {
		List<Variable> indices = f.getIndices();
//		org.polymodel.Domain pDomain = EcoreUtil.copy(currentDomainofExp.getPMdomain());
		Domain pDomain = currentDomainofExp.copy();
		for (Integer d : parallelDimentions) {
			if (d >= indices.size()) {
				throw new RuntimeException("processor dimention " + d + 
						" is greater than the number of indeces " + indices);
			}
			IntExpression exp = f.getPMmapping().getExpression(d);
			IntConstraint c = IntExpressionBuilder.eq(indices.get(d), exp);
			pDomain.getPMdomain().addConstraint(c);
		}
		
//		org.polymodel.Domain newDomainD = currentDomainofExp.getPMdomain().intersection(pDomain.complement());
		Domain newDomainD = currentDomainofExp.difference(pDomain);
//		Domain newDomainD = currentDomainofExp.intersection(pDomain.getPMdomain().complement());

		boolean isEmpty = false;
		if (isCaseExp || isUseExp) {
			currentDynamicDomainofCaseExp.setPMdomain(
					currentDynamicDomainofCaseExp.getPMdomain().
					union(projectOutAfterDim(orderingDimOfChecks, newDomainD).getPMdomain()));
			if (newDomainD.isEmpty()) {
				isEmpty = true;
			}
		} else {
			currentDynamicDomainofExp.setPMdomain(
					currentDynamicDomainofExp.getPMdomain().
					union(projectOutAfterDim(orderingDimOfChecks, newDomainD).getPMdomain()));
			if (newDomainD.isEmpty()) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}
	
	/*
	 * if the object is the immediate  rhs of a equation then update the 
	 * expression of the equation
	 */
	private void updateCurrentEquation(Object object) {
		if (object instanceof StandardEquation) {
			ExternalFunctionCall acquireFunctionCallExp = PolyhedralIRUserFactory
					.eINSTANCE.createExternalFunctionCall(
							externalFunctionAcquire, 
							checkExprs);
			currentSEquation.setExpression(acquireFunctionCallExp);
		}
	}
	
	private Domain projectOutAfterDim(int orderingDimOfChecks,
			Domain contextDomain) {
		//create projection function
		List<Variable> indeces = contextDomain.getIndices().subList(0, orderingDimOfChecks);
		
		AffineFunction proj = PolyhedralIRUtility.createProjection(contextDomain, indeces);
		
		return contextDomain.image(proj);
	}

	public int getOrderingDimOfChecks() {
		return orderingDimOfChecks;
	}

	@Override
	public void visitStandardEquation(StandardEquation s) {
		//Ignore. 
		//We only consider use equations. Because of the program with 
		//subsystems are generated using CART we believe that union of all the 
		//ext domains cover the union of all the domains of variables
	}
	
	/*@Override
	public void visitStandardEquation(StandardEquation s) {
		StandardEquation newSE = EcoreUtil.copy(s);
		currentSEquation = newSE;
		VariableDeclaration newVar = EcoreUtil.copy(currentSEquation.getVariable());
		newVar.getVarID().setName(acquirePrefix+newVar.getVarID().getName());
		currentSEquation.setVariable(newVar);
		
		currentMainExpression = currentSEquation.getExpression();
		
		//number of dimensions.
		nDims = s.getExpression().getContextDomain().getNIndices();
		
		//We project out all the dimensions after ordering dim
		currentDomainofExp = s.getExpression().getContextDomain();
//		currentDomainofExp = projectOutAfterDim(orderingDimOfChecks, 
//				s.getExpression().getContextDomain());
		currentDynamicDomainofExp = projectOutAfterDim(orderingDimOfChecks,
				PolyhedralIRUtility.createEmptyDomain(
				s.getVariable().getDomain().getParams(), 
				s.getVariable().getDomain().getIndices()));
		
		checkExprs.clear();
		
		s.getExpression().accept(this);
		
		if (!currentDynamicDomainofExp.isEmpty()) {
			system.getEquations().add(currentSEquation);
			system.getLocals().add(currentSEquation.getVariable());
			Domain cdd = currentDynamicDomainofExp.copy();
			for (int d = orderingDimOfChecks+1; d<nDims; d++) {
				cdd.addDimension(currentDomainofExp.getIndices().get(d).getName());
				IntConstraint ic = IntExpressionBuilder.eq(
						cdd.getIndices().get(d), 
						IntExpressionBuilder.constant(0));
				cdd.getPMdomain().addConstraint(ic);
			}
			
			cdd.simplify();
			
			currentSEquation.getVariable().setDomain(cdd);
//			currentSEquation.getVariable().setDomain(currentDynamicDomainofExp);
			setTargetMapping(true);
		}
	}*/
	
	
	/*@Override
	public void visitCaseExpression(CaseExpression c) {
		isCaseExp = true;
		List<Expression> exprs = c.getExprs();
		CaseExpression ce = (CaseExpression)currentMainExpression;
		for (int i=0; i<exprs.size(); i++) {
			Expression e = exprs.get(i);
			currentDomainofExp = e.getContextDomain();
			currentDynamicDomainofCaseExp = projectOutAfterDim(orderingDimOfChecks, 
					PolyhedralIRUtility.createEmptyDomain(
					c.getContextDomain().getParams(), 
					c.getContextDomain().getIndices()));
			currentCaseExpression = ce.getExprs().get(i);
			
			checkExprs.clear(); 
			
			e.accept(this);
			
			if (checkExprs.isEmpty()) {
				continue;
			}
			
			ExternalFunctionCall acquireFunctionCallExp = PolyhedralIRUserFactory
					.eINSTANCE.createExternalFunctionCall(
							externalFunctionAcquire, 
							checkExprs);
			
			if (currentCaseExpression instanceof RestrictExpression) {
				RestrictExpression re = (RestrictExpression)currentCaseExpression;
				re.setExpr(acquireFunctionCallExp);
			} else {
				ce.getExprs().remove(i);
				ce.getExprs().add(i, acquireFunctionCallExp);
			}
			//Not sure why we need following
			currentDynamicDomainofExp.setPMdomain(currentDynamicDomainofExp.
					getPMdomain().union(EcoreUtil.copy(
							projectOutAfterDim(orderingDimOfChecks, currentDomainofExp).getPMdomain())));
		}
		isCaseExp = false;
	}*/
	
	
	
	/*@Override
	public void visitRestrictExpression(RestrictExpression r) {
		r.getExpr().accept(this);
		updateCurrentEquation(r.eContainer());
	}

	@Override
	public void visitBinaryExpression(BinaryExpression b) {
		b.getLexp().accept(this);
		b.getRexp().accept(this);
		updateCurrentEquation(b.eContainer());
	}

	@Override
	public void visitIfExpression(IfExpression i) {
		throw new UnsupportedOperationException("Visitor for acquire statements"
				+ " does not support if statements!");
	}

	@Override
	public void visitReduceExpression(ReduceExpression r) {
		throw new UnsupportedOperationException("Visitor for acquire statements"
				+ " does not support reductions statements!");
	}

	@Override
	public void visitMultiArgExpression(MultiArgExpression m) {
		for (Expression exp : m.getExprs()) {
			exp.accept(this);
		}
		updateCurrentEquation(m.eContainer());
	}

	@Override
	public void visitExternalFunctionCall(ExternalFunctionCall e) {
		for (Expression exp : e.getExprs()) {
			exp.accept(this);
		}
		updateCurrentEquation(e.eContainer());
	}

	@Override
	public void visitUnaryExpression(UnaryExpression u) {
		u.getExpr().accept(this);
		updateCurrentEquation(u.eContainer());
	}
*/	

}
