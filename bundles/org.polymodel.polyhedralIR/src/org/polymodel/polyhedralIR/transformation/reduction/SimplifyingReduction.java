package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.SplitUnion;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class SimplifyingReduction extends PolyhedralIRDepthFirstVisitorImpl {

	public static boolean DEBUG = false;
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected final ReduceExpression reduce;
	protected final AffineFunction reuseDependence;
	

	public static void simplify(ReduceExpression reduce, AffineFunction reuseDep) {
		for (ReduceExpression expr : handleUnions(reduce)) {
			SimplifyingReduction sr = new SimplifyingReduction(expr, reuseDep);
			sr.simplify();
		}
	}
	
	protected SimplifyingReduction(ReduceExpression reduce, AffineFunction reuseDep) {
		this.reduce = reduce;
		this.reuseDependence = reuseDep;
		
		//Basic tests
		//check if the context domain is a single polyhedron
		if (reduce.getExpr().getContextDomain().getPMdomain().getPolyhedra().size() > 1) {
			throw new RuntimeException("The context domain of the reduction body is not a single polyhedron.");
		}
		//check that the answer is stored in a variable for reuse
		if (!(reduce.eContainer() instanceof StandardEquation)) {
			throw new RuntimeException("ReduceExpression to simplify is not a direct expression of an equation.");
		}
		//check that the answer of the reduction has same dimensionality as the reuse dependence provided
		if (reduce.getExpr().getExpressionDomain().getDim() != reuseDep.getDimLHS()) {
			throw new RuntimeException("Given reuse dependence does not match the dimensionality of the body of reduction.");
		}
		//check that reuse dependence is uniform
		if (!reuseDependence.isUniform()) {
			throw new RuntimeException("Given reuse dependence is not uniform.");
		}
	}

	
	private static AffineFunction negateUniformDependence(AffineFunction dep) {

		List<Integer> constantpart = dep.getConstantPart();
		int[] constants = new int[constantpart.size()];
		for (int i = 0; i < constants.length; i++) {
			constants[i] = -1*constantpart.get(i);
		}
		
		return PolyhedralIRUtility.createUniformFunction(dep.getParams(), dep.getIndices(), constants);
	}
	
//	private static AffineFunction augmentFunctionWithReduceDimensions(AffineFunction f, ReduceExpression reduce) {
//
//		// add the reduction dimensions to the reuse dep
//		AffineFunction fAug = f.copy();
//		AffineFunction proj = reduce.getProjection();
//		int nparam = proj.getParams().size();
//		for (int i = proj.getDimRHS() - nparam + 1; i < proj.getDimLHS() - nparam; i++) {
//			IVariable copy = reduce.getProjection().getIndices().get(i).copy();
//			fAug.getPMmapping().getIndices().add(copy);
//			fAug.getPMmapping().getFunctions().add(IntegerExpressionUserFactory.linexp(IntegerExpressionUserFactory.term(copy)));
//		}
//		
//		return fAug;
//	}
	
	private static AffineFunction constructDependenceFunctionInAnswerSpace(AffineFunction reuseDep, ReduceExpression reduce) {
		
		List<Integer> constants = reuseDep.getConstantPart();
		List<Integer> depVector = FunctionOperations.applyFunction(constants, reduce.getProjection());
		
		int[] array = new int[depVector.size()];
		for (int i = 0; i < depVector.size(); i++) {
			array[i] = depVector.get(i);
		}
		
		return PolyhedralIRUtility.createUniformFunction(reduce.getContextDomain(), array);
	
//		for (AffineFunction func : quast.values()) {
//			//any one solution with general function works
//			if (func.getDimRHS() == reduce.getExpr().getContextDomain().getNIndices()) {
//				return rX.compose(func);
//			}
//		}
//		throw new RuntimeException("No solution for mapping points in the answer space to reduction space found.");
	}

	protected void simplify() {
		if (reduce.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement that for Subsystems");
		
		// negate reuse dependence to get reuse direction as function
		AffineFunction reuseDirection = negateUniformDependence(reuseDependence);
		// add the reduction dimensions to the reuse dep augmented
		//AffineFunction reuseDirProjected = constructDependenceFunctionInAnswerSpace(reuseDirection, reduce);
		AffineFunction reuseDepProjected = constructDependenceFunctionInAnswerSpace(reuseDependence, reduce);
		
		// Original context domain of the expression (body of reduction) 
		Domain origDE = reduce.getExpr().getContextDomain().copy();

		// TODO more checks to do

		// check reuse vector is not in kernel of projection
		Domain probDom = DomainOperations.extendDomainWithMapping(origDE, reuseDirection);
		DomainOperations.addConstraintsRelatingTwoSetsOfIndices(probDom, new Constraint(reduce.getProjection(), reduce.getProjection(), ComparisonOperator.EQ));
		if (!probDom.isEmpty()) {
			throw new RuntimeException("Given reuse vector is not in the kernel of projection.");
		}
		
		
		// Find Dadd Dsub Dint
		// Transform the original domain by reuse vector to get E'
		Domain DEp = origDE.image(reuseDirection);

		// Dadd = proj (DE - DE')
		Domain Dadd = origDE.difference(DEp).image(reduce.getProjection());

		// Dsub = proj (DE' - DE)
		Domain Dsub = DEp.difference(origDE).image(reduce.getProjection());

		// Dint = proj (DE ^ DE')
		Domain Dint = origDE.intersection(DEp).image(reduce.getProjection());

		// Debugging outputs
		if (DEBUG) {
			// System.out.print("Reuse vector:");
			// MatrixOperations.printVector(_reuseVector);
			// System.out.print("Accumulation space:");
			// MatrixOperations.printMatrix(accum);
			System.out.println("ReuseDirection: " + reuseDirection);
			System.out.println("ReuseDep: " + reuseDependence);
			System.out.println("ReuseDepProjected: " + reuseDepProjected);
			System.out.println("DE   : " + PolyhedralIRToAlphabets.toSimplifiedString(origDE));
			System.out.println("DEP  : " + PolyhedralIRToAlphabets.toSimplifiedString(DEp));
			System.out.println("Dadd : " + PolyhedralIRToAlphabets.toSimplifiedString(Dadd));
			System.out.println("Dsub : " + PolyhedralIRToAlphabets.toSimplifiedString(Dsub));
			System.out.println("Dint : " + PolyhedralIRToAlphabets.toSimplifiedString(Dint));
		}
		
		if (Dint.isEmpty()) {
			throw new RuntimeException("Initialization domain is empty; input reuse vector is invalid.");
		}


		/*** Creating New AST Nodes ***/
		// Create Expressions
		// Xadd = reduce(op, proj, (DE - DE') : origExpr)
		ReduceExpression Xadd;
		{
			Domain DXadd = origDE.difference(DEp);
			RestrictExpression addRes = _fact.createRestrictExpression(DXadd, reduce.getExpr().copy());
			Xadd = _fact.createReduceExpression(reduce.getOP(), reduce.getProjection().copy(), addRes);
			if (DEBUG) {
				System.out.println("DXadd : " + DXadd);
			}
		}
		
		// Xsub = reduce(op, proj, preimage(proj, Dint) : (DE' - DE) : E')
		ReduceExpression Xsub;
		{
			Domain DXsub = DEp.difference(origDE);
			Domain DintInv = Dint.preimage(reduce.getProjection());
			DXsub = DXsub.intersection(DintInv);
			DependenceExpression depEP = _fact.createDependenceExpression(reuseDependence, reduce.getExpr().copy());
			RestrictExpression subRes = _fact.createRestrictExpression(DXsub, depEP);
			RestrictExpression invRes = _fact.createRestrictExpression(DintInv, subRes);
			Xsub = _fact.createReduceExpression(reduce.getOP(), reduce.getProjection().copy(), invRes);
			if (DEBUG) {
				System.out.println("DXsub   : " + DXsub);
				System.out.println("DintInv : " + DintInv);
			}
		}

		// reuseDependence X.(z->z-rx)
		DependenceExpression Xreuse = _fact.createDependenceExpression(reuseDepProjected, _fact.createVariableExpression(((StandardEquation)reduce.getContainerEquation()).getVariable()));
		// TODO: check what happens for UseEquation
		
		// Create Cases
		List<Expression> exprs = new LinkedList<Expression>();
		// Dadd-Dinit : Xadd
		// Domain
		Domain DaddOnly = Dadd.difference(Dint);
		// Exp
		if (!DaddOnly.isEmpty()) {
			RestrictExpression addOnly = _fact.createRestrictExpression(DaddOnly, Xadd.copy());
			exprs.add(addOnly);
		}

		// Dinit - (Dadd U Dsub) : Xdep
		// Domain
		Domain addUsub = Dadd.union(Dsub);
		Domain DreuseOnly = Dint.difference(addUsub);
		// Exp
		if (!DreuseOnly.isEmpty()) {
			RestrictExpression reuseOnly = _fact.createRestrictExpression(DreuseOnly, Xreuse.copy());
			exprs.add(reuseOnly);
		}

		// Dadd ^ (Dinit - Dsub) : Xadd + Xdep
		// Domain
		Domain intDsub = Dint.difference(Dsub);
		Domain Dadd_reuse = Dadd.intersection(intDsub);
		// Exp
		if (!Dadd_reuse.isEmpty()) {
			Expression add_reuse_exp = _fact.createBinaryExpression(reduce.getOP(), Xadd.copy(), Xreuse.copy());
			RestrictExpression add_reuse = _fact.createRestrictExpression(Dadd_reuse, add_reuse_exp);
			exprs.add(add_reuse);
			if (DEBUG) {
				System.out.println("add_reuse : " + Dadd_reuse);
			}
		}

		// Dsub ^ (Dinit - Dadd) : Xdep - Xsub
		// Domain
		Domain intDadd = Dint.difference(Dadd);
		Domain Dsub_reuse = Dsub.intersection(intDadd);
		// check for empty Dsub_reuse
		if (!Dsub_reuse.isEmpty()) {
			// check if inverse OP is defined
			 if (!reduce.getOP().hasInverse()) {
				 throw new RuntimeException("The subtract domain must be empty when the reduction operator does not have an inverse operator.");
			 }
			Expression sub_reuse_exp = _fact.createBinaryExpression(reduce.getOP().getInverseOP(), Xreuse.copy(), Xsub.copy());
			RestrictExpression sub_reuse = _fact.createRestrictExpression(Dsub_reuse, sub_reuse_exp);
			exprs.add(sub_reuse);
		}

		// Dadd ^ Dinit ^ Dsub : Xadd + Xdep - Xsub
		// Domain
		Domain Dadd_reuse_sub = Dadd.intersection(Dsub).intersection(Dint);
		// Exp
		if (!Dadd_reuse_sub.isEmpty()) {
			// check if inverse OP is defined
			 if (!reduce.getOP().hasInverse()) {
				 AffineSystem syst;
				 if (reduce.getContainerEquation() instanceof StandardEquation)
					syst = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem();
				 else
					syst = ((UseEquation) reduce.getContainerEquation()).getContainerSystem();
				 
				 System.out.println(AShow.toSimplifiedString(syst));
				 throw new RuntimeException("The subtract domain must be empty when the reduction operator does not have an inverse operator.");
			 }
			Expression sub_red_exp = _fact.createBinaryExpression(reduce.getOP().getInverseOP(), Xreuse.copy(), Xsub.copy());
			Expression add_red_exp = _fact.createBinaryExpression(reduce.getOP(), Xadd.copy(), sub_red_exp);
			RestrictExpression add_reuse_sub = _fact.createRestrictExpression(Dadd_reuse_sub, add_red_exp);

			exprs.add(add_reuse_sub);
		}

		// Replace the parents expression with case
		CaseExpression caseExp = _fact.createCaseExpression(exprs);
		EcoreUtil.replace(reduce, caseExp);

	}
	
	private static List<ReduceExpression> handleUnions(ReduceExpression reduce) {
		List<ReduceExpression> exprs = new LinkedList<ReduceExpression>();
		
		//already a single polyhedron
		if (reduce.getExpr().getContextDomain().getPMdomain().getPolyhedra().size() == 1) {
			exprs.add(reduce);
		} else {
			AffineSystem system;
			if (reduce.getContainerEquation() instanceof StandardEquation)
				system = ((StandardEquation) reduce.getContainerEquation()).getContainerSystem();
			else
				system = ((UseEquation) reduce.getContainerEquation()).getContainerSystem();
			Expression newExpr = SplitUnion.split(reduce.getExpr());
//			if (newExpr instanceof CaseExpression) {
//				for (Expression expA : ((CaseExpression) newExpr).getExprs()) {
//					for (Expression expB : ((CaseExpression) newExpr).getExprs()) {
//						if (expA.equals(expB)) continue;
//					}
//				}
//			}
			if (newExpr.getContainerEquation() instanceof UseEquation)
				throw new RuntimeException("TODO: implement this for UseEquation");
			
			StandardEquation parentEq = (StandardEquation) newExpr.getContainerEquation();
			Normalize.normalize(system);
			PermutationCaseReduce.caseReduce(parentEq);
			List<StandardEquation> newEqs = NormalizeReduction.apply(parentEq);
			
			int count = 1;
			for (StandardEquation eq : newEqs) {
				String suffix = "_SR" + count;
				eq.getVariable().getVarID().setName(parentEq.getVariable().getName()+suffix);
				count++;
				exprs.add((ReduceExpression)eq.getExpression());
			}
		}
		
		return exprs;
	}
	
	
}
