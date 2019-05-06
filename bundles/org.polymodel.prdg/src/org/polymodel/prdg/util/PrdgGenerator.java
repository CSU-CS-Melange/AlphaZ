package org.polymodel.prdg.util;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.prdg.factory.PRDGUserFactory.createPRDG;
import static org.polymodel.prdg.factory.PRDGUserFactory.createPRDGEdge;
import static org.polymodel.prdg.factory.PRDGUserFactory.createPRDGNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

/**
 * A random PRDG generator for test purpose. May generate inconsistent PRDG.
 * Generated dependencies are uniform.
 * 
 * @author Antoine Floc'h - Initial contribution and API
 * 
 */
public class PrdgGenerator {
	private PolymodelDefaultFactory factory;
	private DimensionsManager dimensionsManager;

	private int maxDependencyDepth;

	public PrdgGenerator(PolymodelDefaultFactory factory, int maxDependencyDepth) {
		this.factory = factory;
		this.maxDependencyDepth = maxDependencyDepth;
	}

	/**
	 * Generate a PRDG
	 * 
	 * @param n
	 *            number of nodes
	 * @param e
	 *            number of edges
	 * @param dims
	 *            number indices
	 * @param parameters
	 *            number of parameters
	 * @return
	 */
	public PRDG generate(int n, int e, int dims, int parameters) {

		PRDG prdg = createPRDG();

		List<Variable> dimsVariables = new ArrayList<Variable>();
		List<Variable> paramVariables = new ArrayList<Variable>();
		for (int i = 0; i < dims; i++) {
			dimsVariables.add(dimensionsManager.getDimension(i));
		}
		for (int i = 0; i < parameters; i++) {
			Variable p = IntExpressionBuilder.var("P" + i);
			dimensionsManager.getParameters().add(p);
			paramVariables.add(p);
		}

		for (int i = 0; i < n; i++) {
			Domain domain = generateStatementDomain(dimsVariables,
					paramVariables);
			PRDGNode node = createPRDGNode("s" + i, domain);
			prdg.getNodes().add(node);
		}

		for (int i = 0; i < e; i++) {
			int source = (int) (Math.random() * n);
			int ref = (int) (Math.random() * n);
			PRDGEdge dep = generateUniformDependency(prdg.getNodes()
					.get(source), prdg.getNodes().get(ref));
			prdg.getEdges().add(dep);
		}
		return prdg;
	}

	private PRDGEdge generateUniformDependency(PRDGNode source,
			PRDGNode reference) {
		// Create a random uniform dependence function

		DomainDimensions sourceDims = source.getDomain().getDimensions();
		Map<OutputDimension, IntExpression> map = new LinkedHashMap<OutputDimension, IntExpression>();
		for (Variable idx : sourceDims.getIndices()) {
			int d = (int) (Math.random() * maxDependencyDepth);
			int sign = (int) (Math.random() * 2);
			d = sign < 2 ? -d : d;
			IntExpression uniformDepExp = affine(term(idx), term(d));
			map.put(dimensionsManager.getOutputDimension(idx), uniformDepExp);
		}

		Function function = factory.createFunction(sourceDims.getIndices(),sourceDims.getParameters(), map);
		
		// Create a random dependence domain
		Domain dependenceDomain = generateRandomDependencyDomain(
				sourceDims.getIndices(), sourceDims.getParameters());
		return createPRDGEdge(source, reference, dependenceDomain, function);
	}

	private Domain generateStatementDomain(List<Variable> indices,
			List<Variable> parameters) {
		IntConstraintSystem polyhedron = IntExpressionBuilder
				.constraintSystem();
		int dim = (int) (Math.random() * indices.size());
		for (int i = 0; i < dim; i++) {
			Variable index = indices.get(i);
			// lower bound
			IntExpression lbe = affine(term(index));
			polyhedron.getConstraints().add(
					constraint(lbe, affine(term(0)), ComparisonOperator.GE));

			// upper bound
			Variable parameter = random(parameters);
			IntExpression ube = affine(term(index), term(-1, parameter));
			polyhedron.getConstraints().add(
					constraint(ube, affine(term(0)), ComparisonOperator.LE));
		}
		Domain domain = factory.createDomain(indices, parameters, polyhedron);
		return domain;
	}

	private Domain generateRandomDependencyDomain(List<Variable> indices,
			List<Variable> parameters) {
		IntConstraintSystem polyhedron = constraintSystem();

		Domain domain = factory.createDomain(indices, parameters, polyhedron);
		int nbConstraints = (int) (Math.random() * (indices.size()));

		IntConstraintSystem system = constraintSystem();
		for (int i = 0; i < nbConstraints; ++i) {
			IntConstraint randomConstraint = randomConstraint(indices,
					parameters);
			system.getConstraints().add(randomConstraint);
		}

		return domain;
	}

	private IntConstraint randomConstraint(List<Variable> vars,
			List<Variable> params) {
		List<Variable> allVars = new ArrayList<Variable>(vars);
		allVars.addAll(params);
		int nbTerms = (int) (Math.random() * allVars.size());

		// terms
		List<AffineTerm> terms = new ArrayList<AffineTerm>();
		for (int i = 0; i < nbTerms; ++i) {
			int var = (int) (Math.random() * allVars.size());
			int coef = (int) (Math.random() * maxDependencyDepth);
			terms.add(term(coef, allVars.get(var)));
		}
		IntExpression expression = affine(terms.toArray(new AffineTerm[terms
				.size()]));

		int op = (int) (Math.random() * 6);
		ComparisonOperator comparator = ComparisonOperator.get(op);
		return constraint(expression, affine(term(0)), comparator);

	}

	private Variable random(List<Variable> vars) {
		int k = (int) (Math.random() * vars.size());
		return vars.get(k);
	}
}
