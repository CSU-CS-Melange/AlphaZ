package org.polymodel.polyhedralIR.transformation;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Function;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.FindUniformizationVector;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;

/**
 * Uniformize implemented in this class is what is called pipelining.
 * 
 * The implementation takes an uniformization vector u, and blindly applies
 * the transformation without verifying the vector.
 * 
 * The implementation follows the transformation described by Roychowdhury.
 * 
 * Conditions:
 *  - I - A must be rank 1; i.e., affine in only one dimension
 *  - u must no be in the column space of A
 *  - A = A^2 must hold
 * 
 * @see FindUniformizationVector
 * 
 * @author yuki
 *
 */
public class UniformizeWithPipelining {
	
	private static final PolyhedralIRUserFactory polyFact = PolyhedralIRUserFactory.eINSTANCE;
	private static final String PROPAGATION_VARIABLE_PREFIX = "_uni";
	

	public static boolean DEBUG = false;
	private static final String DEBUG_OUT_HEADER = "[Pipelining] ";
	
	private void debug(String message) {
		if (DEBUG) System.out.println(DEBUG_OUT_HEADER + message);
	}

	
	public static void apply(AffineSystem system, PRDG prdg, int[] u, PRDGEdge ... edges) {
		apply(system, prdg, u, Arrays.asList(edges));
	}
	public static void apply(AffineSystem system, PRDG prdg, int[] u, List<PRDGEdge> edges) {
		UniformizeWithPipelining uwp = new UniformizeWithPipelining(system, prdg, u, edges);
		uwp.transform();
	}
	
	protected final AffineSystem targetSystem;
	protected final PRDG prdg;
	protected final Collection<PRDGEdge> targetEdges;
	protected final VariableDeclaration targetVariable;
	protected final int[] u;
	protected final int[] uReverse;

	protected List<Long> baseConstantPart;
	protected AffineFunction baseDependence;
	protected Domain identityDomain;
	protected AffineFunction propagationDirectionA;
	protected AffineFunction propagationDirectionB;
	protected Domain propagationDomainA;
	protected Domain propagationDomainB;
	protected Domain propagationVariableDomainA;
	protected Domain propagationVariableDomainB;
	protected VariableDeclaration propagationVariableA;
	protected VariableDeclaration propagationVariableB;
	
	protected Map<AffineFunction, DependenceReplacement> replacementDependences;

	/**
	 * Assumes:
	 *   - targetEdges all share a common linear part
	 * 
	 * @param system
	 * @param prdg
	 * @param u
	 * @param targetEdges
	 */
	protected UniformizeWithPipelining(AffineSystem system, PRDG prdg, int[] u, Collection<PRDGEdge> targetEdges) {
		targetSystem = system;
		this.prdg = prdg;
		this.targetEdges = targetEdges;

		if (targetEdges.size() == 0) throw new IllegalArgumentException("No edges to uniformize are given to UniformizeWithPipelining.");

		PRDGEdge edge1 = targetEdges.iterator().next();
		targetVariable = system.getVariableDeclaration(edge1.getDestination().getName());
		
		for (PRDGEdge edge : targetEdges) {
			if (!edge.getDestination().getName().contentEquals(targetVariable.getName())) {
				throw new IllegalArgumentException("Target edges given to uniformize do not depend on the same variable.");
			}
		}
		
		//accept both vector sizes, one with parameters and the other without
		if (u.length == edge1.getDomain().getNbIndices() + edge1.getDomain().getNbParams()) {
			this.u = new int[edge1.getDomain().getNbIndices()];
			for (int i = edge1.getDomain().getNbParams(); i < u.length; i++) {
				this.u[i-edge1.getDomain().getNbParams()] = u[i];
			}
		} else {
			if (u.length != edge1.getDomain().getNbIndices()) {
				throw new IllegalArgumentException("The uniformization vector must match the number of dimensions in size.");
			}
			this.u = u;
		}
		this.uReverse = new int[this.u.length];
		for (int i = 0; i < this.u.length; i++) {
			uReverse[i] = -this.u[i];
		}
	}
	
	private void transform() {
		if (DEBUG) {
			debug("Pipelining " + targetVariable.getName() + " with u"+toStringList(u));
			for (PRDGEdge edge : targetEdges ) {
				debug("Target Edge: " + edge);
			}
		}
		
		findDomains();

		{
			debug("identityDomain: " + identityDomain);
			debug("propagationDirectionA: " + propagationDirectionA);
			debug("propagationDirectionB: " + propagationDirectionB);
			debug("propagationDomainA: " + propagationDomainA);
			debug("propagationDomainB: " + propagationDomainB);
		}
		
		addPropagationVariables();
		
		computeReplacementDependences();
		
		//Finally, use visitor to replace all dependences that can be replaced to identity on the propagation.
		ReplaceDependences rd = new ReplaceDependences();
		for (PRDGEdge edge : targetEdges) {
			targetSystem.getEquation(edge.getSource().getName()).accept(rd);
		}
	}
	
	/**
	 * Finds domains related to propagation and stores them as member variables.
	 *  - identityDomain: the set of points where the propagation variable is initialized 
	 *     by identity dependence on the original variable.
	 *  - propagationDomainA: the set of points where values can be propagated along u
	 *     and intersected with the union of dependence domains of all edges to be uniformized.
	 *  - propagationVariableDomainA: union of identity domain and propagationDomainA;
	 *     in other word, the set of points where propagation variable along u is defined.
	 *  - propagationDomainB/propagationVariableDomainB the same set of points for propagating along uReverse
	 * 
	 */
	protected void findDomains() {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);

		Domain targetDom = targetVariable.getDomain();
		
		//Linear part is assumed to be common for all edges
		Function linearPart = targetEdges.iterator().next().getFunction().getMapping().linearPartAsFunction();
		AbstractRelation linearPartRelation = linearPart.buildRelation(manager);
		
		//base constant part is the common contant part among all edges
		baseConstantPart = selectBaseConstantPart();
		baseDependence = PolyhedralIRUtility.createUniformFunction(targetDom, baseConstantPart);
		
		//Base of the propagation variable is the pre-image of the original variable domain
		// by the base dependence; where values are defined.
		Domain propagationVariableBase = targetDom.preimage(baseDependence);
		for (PRDGEdge edge : targetEdges) {
			propagationVariableBase = propagationVariableBase.union(polyFact.createDomain(EcoreUtil.copy(edge.getDomain())));
		}
		propagationVariableBase.simplify();
		
		//intersection of identity relation and the linear part is where the propagation variable is initialized
		// by base dependence on the original variable
		//I -> I
		AbstractRelation identity = PolyhedralIRUtility.createIdentityFunction(propagationVariableBase).getPMmapping().buildRelation(manager);
		
		//I -> Qz = I; z in D; 
		identityDomain = polyFact.createDomain(identity.intersection(linearPartRelation).getDomain());
		identityDomain.simplify();
		
		if (identityDomain.isEmpty()) {
			throw new RuntimeException("[Pipelining] Identity domain is empty. Incorrect uniformization vector.");
		}

		propagationDirectionA = PolyhedralIRUtility.createUniformFunction(targetDom, u);
		propagationDirectionB = PolyhedralIRUtility.createUniformFunction(targetDom, uReverse);
		
		propagationVariableDomainA = createPropagationVariableDomain(propagationVariableBase, identityDomain, u);
		propagationDomainA = propagationVariableDomainA.difference(identityDomain);
		propagationVariableDomainB = createPropagationVariableDomain(propagationVariableBase, identityDomain, uReverse);
		//Exclude A from B
		propagationVariableDomainB = propagationVariableDomainB.difference(propagationDomainA);
		propagationDomainB = propagationVariableDomainB.difference(identityDomain);
		
		//when propagation domain is empty, set the corresponding variable domain to be empty as well
		if (propagationDomainA.isEmpty()) {
			propagationVariableDomainA = propagationVariableDomainA.intersection(
					PolyhedralIRUtility.createEmptyDomain(propagationDomainA.getParams(), propagationDomainA.getIndices()));
		}
		if (propagationDomainB.isEmpty()) {
			propagationVariableDomainB = propagationVariableDomainB.intersection(
					PolyhedralIRUtility.createEmptyDomain(propagationDomainB.getParams(), propagationDomainB.getIndices()));
		}
	}
	
	/**
	 * Find the base constant part where each element of the constant part
	 *  is selected to have the minimum absolute value among all edges.
	 * If an element is both positive and negative in different edges, then
	 *  that element is set to 0.
	 * This allows multiple edges to share the same propagation variable
	 *  with uniform dependences (instead of just identity, 
	 *  which would be the case with single edge).
	 * 
	 * @return
	 */
	private List<Long> selectBaseConstantPart() {
		List<Long> base = null;
		for (PRDGEdge edge : targetEdges) {
			List<Long> constants = edge.getFunction().getMapping().constantPart();
			if (base == null) {
				base = constants;
			} else {
				for (int i = 0; i < constants.size(); i++) {
					if (base.get(i) != constants.get(i)) {
						//difference in sign (one being 0 is ok, since it would be set to 0 anyway)
						if (Long.signum(base.get(i)) != Long.signum(constants.get(i))) {
							base.set(i, 0l);
						} else if (Math.abs(base.get(i)) > Math.abs(constants.get(i))) {
							base.set(i, constants.get(i));
						}
					}
				}
			}
		}
		return base;
	}
	
	/**
	 * Creates domain of the propagation variables. There are two propagation variable for each pipelining.
	 * One is propagated along the given vector (u), and the other is propagated in the opposite direction (uReverse).
	 * The domain of these variables are computed by creating a relation of the following form:
	 *   z - > z' where z is in the identityDomain (initialization) and vec.z <= vec.z'
	 * and then taking the range of the relation, intersected with the base domain of dependence (where uniformized values are required).
	 * 
	 * The set of points z' such that vec.z = vec.z' is the identityDomain and vec.z < vec.z' is the propagation domain.
	 * 
	 * @param baseDomain
	 * @param identityDomain
	 * @param vec
	 * @return
	 */
	private static Domain createPropagationVariableDomain(Domain baseDomain, Domain identityDomain, int[] vec) {
		PolymodelDefaultFactory fact = PolymodelComponent.INSTANCE.getFactory(PolyhedralIRModule.INSTANCE);
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);

		List<InputDimension> inputs = manager.getInputsDimensionsFor(baseDomain.getIndices());
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(baseDomain.getIndices());
		RelationDimensions relDims = fact.createRelationDimensions(inputs, outputs, baseDomain.getParams());
		
		BasicRelation br = fact.createBasicRelation(constraintSystem(), constraintSystem(), constraintSystem(createPropagationDirectionConstraint(relDims, vec)));
		AbstractRelation rel = fact.createRelation(relDims, br);
		rel = rel.intersectDomain(identityDomain.getPMdomain());
		
		Domain res = polyFact.createDomain(rel.intersectRange(baseDomain.getPMdomain()).getRange());
		res.simplify();
		return res;
	}
	
	/**
	 * Given a vector dir, creates a constraint of the following form:
	 * dir.z <= dir.z' where z and z' are respectively the input and output dimensions
	 * of the given relation dimension.
	 * 
	 * @param relDims
	 * @param dir
	 * @return
	 */
	private static IntConstraint createPropagationDirectionConstraint(RelationDimensions relDims, int[] dir) {
		AffineExpression lhs = affine();
		AffineExpression rhs = affine();
		
		for (int d = 0; d < dir.length; d++) {
			if (dir[d] != 0) {
				lhs.getTerms().add(term(dir[d], relDims.getInputs().get(d)));
				rhs.getTerms().add(term(dir[d], relDims.getOutputs().get(d)));
			}
		}
		
		return constraint(lhs, rhs, ComparisonOperator.LE);
	}

	
	/**
	 * Finds a variable name that do not have conflict with existing variables.
	 * The name takes the form of "base + count + postfix",
	 * and count is incremented by 1 if the same variable already exists. 
	 * 
	 * @param base
	 * @param postfix
	 * @return
	 */
	private String findAvailableVariableName(final String base, final String postfix) {
		int count = 1;
		String propVarName = base + count + postfix;
		while (targetSystem.containsVariable(propVarName)) {
			count++;
			propVarName = base + count + postfix;
		}
		return propVarName;
	}
	
	/**
	 * Creates the equation of the propagation variable. If the forA boolean flag is set,
	 * then it creates the equation for propagation variable A, and for B otherwise.
	 * 
	 * @param forA
	 * @return
	 */
	protected StandardEquation createPropagationEquation(boolean forA) {
		//Construct and add equation for propagation variable
		//branches of case
		List<Expression> exprs = new ArrayList<Expression>(3);

		//case identity
		exprs.add(polyFact.createRestrictExpression(identityDomain.copy(), 
					polyFact.createDependenceExpression(baseDependence.copy(),
							polyFact.createVariableExpression(targetVariable))));
		
		//case direction A
		if (forA && !propagationDomainA.isEmpty()) {
			//note that the use of dirB as dependence is correct; propagation is dataflow
			exprs.add(polyFact.createRestrictExpression(propagationDomainA,
						polyFact.createDependenceExpression(propagationDirectionB, 
						polyFact.createVariableExpression(propagationVariableA))));
		}
		//case direction B
		if (!forA && !propagationDomainB.isEmpty()) {
			//note that the use of dirA as dependence is correct; propagation is dataflow
			exprs.add(polyFact.createRestrictExpression(propagationDomainB,
						polyFact.createDependenceExpression(propagationDirectionA, 
						polyFact.createVariableExpression(propagationVariableB))));
		}
		
		Expression expr = polyFact.createCaseExpression(exprs);
		if (forA) {
			return polyFact.createStandardEquation(propagationVariableA, expr);
		} else {
			return polyFact.createStandardEquation(propagationVariableB, expr);
		}
	}
	
	/**
	 * Creates propagation variables based on the computed domains.
	 * 
	 */
	protected void addPropagationVariables() {
		//Variable Declaration - same type, same domain, add prefix to name
		final String propVarNameBase = targetVariable.getName() + PROPAGATION_VARIABLE_PREFIX;
		
		if (!propagationDomainA.isEmpty()) {
			String propVarNameA = findAvailableVariableName(propVarNameBase, "A");
			propagationVariableA = polyFact.createVariableDeclaration(propVarNameA, targetVariable.getType(), propagationVariableDomainA);
			targetSystem.getLocals().add(propagationVariableA);
			targetSystem.getEquations().add(createPropagationEquation(true));
		}

		if (!propagationDomainB.isEmpty()) {
			String propVarNameB = findAvailableVariableName(propVarNameBase, "B");
			propagationVariableB = polyFact.createVariableDeclaration(propVarNameB, targetVariable.getType(), propagationVariableDomainB);
			targetSystem.getLocals().add(propagationVariableB);
			targetSystem.getEquations().add(createPropagationEquation(false));
		}
	}
	
	private void computeReplacementDependences() {
		replacementDependences = new TreeMap<AffineFunction, DependenceReplacement>(
				new Comparator<AffineFunction>() {
					@Override
					public int compare(AffineFunction arg0, AffineFunction arg1) {
						return arg0.toString().compareTo(arg1.toString());
					}
				});
		
		//for each edge
		for (PRDGEdge edge : targetEdges) {
			AffineFunction f = polyFact.createAffineFunction(EcoreUtil.copy(edge.getFunction().getMapping()));
			//if the same function is already handled, skip
			if (replacementDependences.containsKey(f)) continue;
			
			//else compute the difference between the base constant part
			List<Long> constantPart = f.getPMmapping().constantPart();
			for (int i = 0 ; i < constantPart.size(); i++) {
				constantPart.set(i, constantPart.get(i) - baseConstantPart.get(i));
			}
			AffineFunction dep = PolyhedralIRUtility.createUniformFunction(f.getParams(), f.getIndices(), constantPart);
			replacementDependences.put(f, new DependenceReplacement(f, dep));
			
		}
		
	}
	
	protected class DependenceReplacement {
		protected final AffineFunction replaceTarget;
		protected final AffineFunction replacement;
		protected final Domain propagationWithA;
		protected final Domain propagationWithB;
		
		public DependenceReplacement(AffineFunction replaceTarget, AffineFunction replacement) {
			this.replaceTarget = replaceTarget;
			this.replacement = replacement;
			propagationWithA = propagationVariableDomainA.preimage(replacement);
			propagationWithB = propagationVariableDomainB.preimage(replacement);
		}
	}
	
	/**
	 * Visitor to replace all compatible dependences to the propagation variable.
	 * 
	 * @author yuki
	 *
	 */
	protected class ReplaceDependences extends PolyhedralIRDepthFirstVisitorImpl {
		
		@Override
		public void visitDependenceExpression(DependenceExpression d) {
			//check if child is variable
			if (!(d.getExpr() instanceof VariableExpression)) {
				super.visitDependenceExpression(d);
				return;
			}
			
			VariableExpression v = (VariableExpression)d.getExpr();
			//check if variable is the target
			if (!v.getVarDecl().equals(targetVariable)) {
				return;
			}
			
			//finally check if the target has compatible dependence
			if (replacementDependences.containsKey(d.getDep())) {
				//then replace this node with variable expression of the propagation variable
				final VariableExpression vE;
				DependenceReplacement replacement = replacementDependences.get(d.getDep());
				if (!d.getContextDomain().intersection(replacement.propagationWithA).isEmpty()) {
					vE = polyFact.createVariableExpression(propagationVariableA);
				} else {
					vE = polyFact.createVariableExpression(propagationVariableB);
				}
				final DependenceExpression dE = polyFact.createDependenceExpression(replacement.replacement.copy(), vE);
				EcoreUtil.replace(d, dE);
				return;
			}
		}
	}
	

	
	private String toStringList(int[] vec) {
		StringBuffer sb = new StringBuffer("[");
		
		for (int e : vec) {
			if (sb.length() > 1) sb.append(",");
			sb.append(e);
		}
		sb.append("]");
		
		return sb.toString();
	}
}
