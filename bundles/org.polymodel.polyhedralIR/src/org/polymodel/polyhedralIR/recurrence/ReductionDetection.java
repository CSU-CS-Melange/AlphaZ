package org.polymodel.polyhedralIR.recurrence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.recurrence.helper.RedirectDependenceToReduction;
import org.polymodel.polyhedralIR.recurrence.helper.SimpleExpressionEquivalence;
import org.polymodel.polyhedralIR.transformation.InlineConstants;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables;
import org.polymodel.polyhedralIR.transformation.Simplify;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

public class ReductionDetection {
	
	public static boolean DEBUG = false;

	private static final DimensionsManager manager   = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(ISLPolymodelModule.INSTANCE);
	private static final PolymodelDefaultFactory fact = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	private static final PolyhedralIRUserFactory polyFact = PolyhedralIRUserFactory.eINSTANCE;

	public static void detect(AffineSystem system) {
		ReductionDetection rd = new ReductionDetection(system);
		rd.analyze();
		
	}
	
	private static void debug(Object msg) {
		if (DEBUG) {
			System.out.println("[ReductionDetection] " + msg);
		}
	}
	
	private AffineSystem system;
	
	protected ReductionDetection(AffineSystem system) {
		this.system = system;
	}
	
	//propagate constants and simplify to reduce number of statements (in case of C extracted alpha)
	private void preprocessing() {
		InlineConstants.apply(system);
		Normalize.normalize(system);
		Simplify.simplify(system);
		Normalize.normalize(system);
	}
	
	private void analyze() {
		//preprocess
		preprocessing();

		//Build PRDG and find SCCs
		PRDG prdg = PRDGBuilder.build(system);
		
		List<ReductionCandidate> candidates = new LinkedList<ReductionCandidate>();
		for (PRDGNode node: prdg.getNodes()) {
			for (PRDGEdge source: node.getSources()) {
				if (source.getSource() == node) {
					debug("Analyzing node: "+node.getName());
					ReductionCandidate cand = analyzeCandidateSCC(node);
					if (cand != null)
						candidates.add(cand);
					break;
				}
			}
		}
				
		//For each candidate found, check Alpha expression to make sure it is a reduction
		List<DetectedReduction> reductions = new LinkedList<DetectedReduction>();
		for (ReductionCandidate cand : candidates) {
			DetectedReduction red = checkExpressions(cand);
			if (red != null) {
				reductions.add(red);
			}
		}
		
		for (DetectedReduction red : reductions) {
			addReductionToSystem(red);
		}
		
		RemoveUnusedVariables.apply(system);

		System.out.println(AShow.toSimplifiedString(this.system));
	}
	
	private ReductionCandidate analyzeCandidateSCC(PRDGNode node) {
		debug("Candidate SCC: " + node);
		
		if (node.getDestinations().size() < 2) return null;

		PRDGEdge selfEdge = null;
		List<PRDGEdge> initEdges = new LinkedList<PRDGEdge>();
		List<PRDGEdge> accumulationEdges = new LinkedList<PRDGEdge>();
		
		//Find self edge
		for (PRDGEdge edge : node.getDestinations()) {
			debug(edge);
			if (edge.getDestination().equals(node)) {
				if (selfEdge != null) {
					debug("Multiple self-edges not supported");
					return null;
				}
				selfEdge = edge;
			}
		}
		
		if (selfEdge == null) {
			debug("Self edge not found");
			return null;
		}
		if (!selfEdge.getFunction().getMapping().isUniform()) {
			debug("Self edge is not uniform");
			return null;
		}
		
		//Compute projection function
		final Function projection;
		{
			List<Long> cpart = selfEdge.getFunction().getMapping().constantPart();
			DomainDimensions dims = selfEdge.getDomain().getDimensions().copy();
			int projectedDims = 0;
			for (long c : cpart) {
				if (c != 0) {
					projectedDims++;
				}
			}
			
			if (projectedDims == cpart.size()) {
				debug("All dimensions projected.");
				return null;
			}
			
			List<IntExpression> exprs = new ArrayList<IntExpression>(cpart.size() - projectedDims);
			for (int i = 0; i < dims.getIndices().size(); i++) {
				if (cpart.get(i) == 0)
					exprs.add(IntExpressionBuilder.affine(IntExpressionBuilder.term(dims.getIndices().get(i))));
			}
				
			projection = fact.createFunction(dims, exprs);
		}
		
		//check the consumers
		{
			Domain range = null;
			for (PRDGEdge edge : node.getSources()) {
				//skip self edge
				if (edge == selfEdge) continue;
				
				Domain edgeRange = edge.getDomain().image(edge.getFunction().getMapping().buildRelation(manager));
				
				if (range == null) {
					range = edgeRange;
				} else {
					range = range.union(edgeRange);
				}
			}
			

			Domain rangeEqs  = range.affineHull();
			//project with the kernel of projection and bring back to the original space
			Function projKer = projection.nullspace();
			Domain projRange = rangeEqs.image(projKer.buildRelation(manager)).image(projKer.buildRelation(manager).reverse(manager));
			if (!rangeEqs.equivalence(projRange)) {
				debug("Intermediate values of the accumulation are used.");
				return null;
			}
		}
		
		for (PRDGEdge edge : node.getDestinations()) {
			//non-self edge
			if (!edge.getDestination().equals(node)) {
				//not overlapping with self edge
				if (!edge.getDomain().difference(selfEdge.getDomain()).isEmpty()) {
					initEdges.add(edge);
				} else if (edge.getDomain().equivalence(selfEdge.getDomain())) {
					accumulationEdges.add(edge);
				} else {
					debug("Niether init or accumulation edge: " + edge);
					return null;
				}
			}
		}
				
		if (initEdges.size() > 1) {
			debug("Multiple init edges not supported: " + initEdges);
			return null;
		}
		
		Domain initDomain;
		Domain accumDomain = null;
		{
			PRDGNode initDst = initEdges.get(0).getDestination();
			initDomain = initEdges.get(0).getDomain();
			
			Function f = initEdges.get(0).getFunction().getMapping();
			for (PRDGEdge edge : accumulationEdges) {
				if (!initDst.equals(edge.getDestination())) {
					debug("Destinations of init and accumulation do not match.");
					return null;
				}
				if (!f.equivalence(edge.getFunction().getMapping())) {
					debug("Functions of init and accumulation do not match.");
					return null;
				}
				if (accumDomain == null) {
					accumDomain = edge.getDomain();
				} else {
					accumDomain = accumDomain.union(edge.getDomain());
				}
			}
		}
		
		return new ReductionCandidate(node, initDomain, accumDomain, projection);
	}
	
	private DetectedReduction checkExpressions(ReductionCandidate cand) {
		StandardEquation eq = system.getEquation(cand.node.getName());
		
		if (!(eq.getExpression() instanceof CaseExpression)) {
			debug("First expression is assumed to be CaseExpression.");
			return null;
		}
		
		CaseExpression caseExpr = (CaseExpression)eq.getExpression();
		
		if (caseExpr.getExprs().size() != 2) {
			debug("Case is assumed to have exactly two branches.");
			return null;
		}
		
		//Find two expressions corresponding to init and accumulation
		RestrictExpression initExpr = null;
		RestrictExpression accumExpr = null;
		{
			if ((!(caseExpr.getExprs().get(0) instanceof RestrictExpression)) || (!(caseExpr.getExprs().get(1) instanceof RestrictExpression))) {
				debug("Branches of the case are assumed to be RestrictExpression.");
				return null;
			}
			RestrictExpression branch1 = (RestrictExpression)caseExpr.getExprs().get(0);
			RestrictExpression branch2 = (RestrictExpression)caseExpr.getExprs().get(1);
			
			if (branch1.getExpr().getContextDomain().getPMdomain().equivalence(cand.initializationDomain)) {
				initExpr = branch1;
			}
			if (branch2.getExpr().getContextDomain().getPMdomain().equivalence(cand.initializationDomain)) {
				initExpr = branch2;
			}
			if (branch1.getExpr().getContextDomain().getPMdomain().equivalence(cand.accumulationDomain)) {
				accumExpr = branch1;
			}
			if (branch2.getExpr().getContextDomain().getPMdomain().equivalence(cand.accumulationDomain)) {
				accumExpr = branch2;
			}
			if (initExpr == null || accumExpr == null) {
				debug("Branches of the case did not match init/accum domains.");
				return null;
			}
		}
		
		OP operator;
		Expression reduceExpr;
		try {
			BinaryExpression binExpr = (BinaryExpression)accumExpr.getExpr();
			operator = binExpr.getOperator();
			boolean selfRef = ((VariableExpression)((DependenceExpression)binExpr.getLexp()).getExpr()).getVarDecl().getName().contentEquals(cand.node.getName());
			
			if (!selfRef) {
				debug("Self reference must be the left expression of the first binary expression.");
				return null;
			}
			if (!(operator.isAssociative() && operator.isCommutative())) {
				debug("Operator " + operator + " is not associative and commutative.");
				return null;
			}
			if (!SimpleExpressionEquivalence.check(initExpr.getExpr(), binExpr.getRexp())) {
				debug("Equivalence check on reduction expression failed.");
				return null;
			}

			reduceExpr = binExpr.getRexp().copy();
		} catch (ClassCastException ce) {
			debug(ce.getMessage());
			debug("Pattern did not match expected template.");
			return null;
		}

		return new DetectedReduction(cand, operator, reduceExpr);
		
	}
	
	private void addReductionToSystem(DetectedReduction reduction) {
		StandardEquation orig = system.getEquation(reduction.node.getName());
		AffineFunction projection = polyFact.createAffineFunction(EcoreUtil.copy(reduction.projection));
		
		org.polymodel.polyhedralIR.Domain reduceVarDomain = orig.getVariable().getDomain().image(projection);
		VariableDeclaration reductionVar = polyFact.createVariableDeclaration(reduction.node.getName()+"_reduce", orig.getVariable().getType(), reduceVarDomain);
	
		system.getLocals().add(reductionVar);
		
		StandardEquation reductionEq = polyFact.createStandardEquation(reductionVar, 
				polyFact.createReduceExpression(reduction.operator, 
						polyFact.createAffineFunction(reduction.projection), reduction.reduceExpression));
		
		system.getEquations().add(reductionEq);

		RedirectDependenceToReduction.apply(system, reductionVar, orig.getVariable(), projection);
		
	}
	
	private class ReductionCandidate {
		private final PRDGNode node;
		private final Domain initializationDomain;
		private final Domain accumulationDomain;
		private final Function projection;
		
		private ReductionCandidate(PRDGNode node, Domain init, Domain accum, Function proj) {
			this.node = node;
			initializationDomain = init;
			accumulationDomain = accum;
			projection = proj;
		}
		
		@Override
		public String toString() {
			return node.getName() + " " + projection + " init: " + initializationDomain + " accum:" + accumulationDomain;
		}
	}
	
	private class DetectedReduction {
		private final PRDGNode node;
		private final Domain initializationDomain;
		private final Domain accumulationDomain;
		private final Function projection;
		private final OP operator;
		private final Expression reduceExpression;
		
		public DetectedReduction(ReductionCandidate cand, OP op, Expression reduceExpr) {
			node = cand.node;
			initializationDomain = cand.initializationDomain;
			accumulationDomain = cand.accumulationDomain;
			projection = cand.projection;
			operator = op;
			reduceExpression = reduceExpr;
		}

		@Override
		public String toString() {
			return node.getName() + " reduce(" + operator + ", "+ projection + ", " + PolyhedralIRToAlphabets.toString(reduceExpression)+")";
		}
	}
}
