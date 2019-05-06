package org.polymodel.prdg.scheduling.vertex;

import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.SchedulingDomainBuilder;
import org.polymodel.prdg.scheduling.SchedulingException;

/**
 * Concrete {@link SchedulingDomainBuilder} using Vertex method.
 * 
 * XXX: need to be rewritten with new org.polymodel version (require a way to
 * have vertices and rays) <br>
 * <br>
 * Reference:<br>
 * <i>Patrice Quinton, The systematic design of systolic arrays <BR>
 * Princeton University Press, 1987, pp. 229-260.</i>
 * 
 * @author antoine
 * 
 */
public class VertexSchedulingDomainBuilder extends SchedulingDomainBuilder {

	public VertexSchedulingDomainBuilder(
			SchedulePrototypeBuilder prototypeBuilder) {
		super(prototypeBuilder);
	}

	@Override
	public Domain buildSchedulingDomainFor(List<PRDGNode> nodes,
			List<PRDGEdge> edges) throws SchedulingException {
		Domain schedulingDomain = super.buildSchedulingDomainFor(nodes, edges);
		for (PRDGNode n : nodes) {
			for (IntConstraint c : buildPositiveTimeContraints(getSchedulePrototype(n))) {
				schedulingDomain.addConstraint(c);
			}
		}
		return schedulingDomain;
	}

	private List<IntConstraint> buildPositiveTimeContraints(
			SchedulePrototype schedulePrototype) {
		// PolylibDomain Dn = PolylibDefaultFactory2.INSTANCE
		// .domain(schedulePrototype.getDomain());
		// List<Variable> variables = new ArrayList<Variable>(
		// schedulePrototype.getScheduleIndices());
		// variables.addAll(Dn.getParams());
		// List<IntConstraint> constraints = new ArrayList<IntConstraint>();
		//
		// // Vertices constraints
		// for (EList<Vertex> vertices : Dn.getVertices()) {
		// EList<ScheduleTerm> factorized = SchedulingToolFunctions.factorize(
		// schedulePrototype.getTerms(), variables);
		// for (Vertex vertex : vertices) {
		// constraints.add(buildConstraintFrom(vertex,
		// schedulePrototype.getDomain(), factorized, 0));
		// }
		// }
		//
		// // Rays constraints
		// for (EList<MatrixRow> rays : Dn.getRays()) {
		// EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>(
		// schedulePrototype.getTerms());
		// terms.remove(schedulePrototype.getConstantTerm());
		// EList<ScheduleTerm> factorized = SchedulingToolFunctions.factorize(
		// terms, variables);
		// for (MatrixRow ray : rays) {
		// constraints.add(buildConstraintFrom(ray,
		// schedulePrototype.getDomain(), factorized, 0));
		// }
		// }
		// return constraints;
		throw new UnsupportedOperationException();
	}

	/**
	 * Apply causality of a dependency for each vertex and rays of its domain.
	 * 
	 * @param e
	 * @return
	 */
	private Domain causality(Dependency e) {

		// PolylibDomain Re = PolylibDefaultFactory2.INSTANCE.domain(e
		// .getDependencyDomain());
		//
		// Domain legalSchedulesDomain = buildUniverseSchedulingDomain();
		//
		// for (EList<Vertex> vertices : Re.getVertices()) {
		// for (Vertex vertex : vertices) {
		// legalSchedulesDomain.addConstraint(applyVertex(vertex, e));
		// }
		// }
		//
		// for (EList<MatrixRow> rays : Re.getRays()) {
		// for (MatrixRow ray : rays) {
		// legalSchedulesDomain.addConstraint(applyRay(ray, e));
		// }
		// }
		//
		// legalSchedulesDomain.simplify();
		// return
		// factory.getPolymodelFactory().createDomain(legalSchedulesDomain);
		throw new UnsupportedOperationException();
	}

	// private IntConstraint applyVertex(Vertex vertex, Dependency dep) {
	// EList<ScheduleTerm> terms = dep.getTerms(true);
	// return buildConstraintFrom(vertex, dep.getDependencyDomain(), terms, 0);
	// }
	//
	// private IntConstraint buildConstraintFrom(MatrixRow v, Domain domain,
	// EList<ScheduleTerm> factorizedTerms, int k) {
	// List<AffineTerm> linearTerms = new ArrayList<AffineTerm>();
	// for (ScheduleTerm t : factorizedTerms) {
	// if (!t.isConstant()) {
	// int value = getValue(v, t.getVar(), domain);
	//
	// AffineExpression exp = t.getExp();
	// IntExpression mul = qaffine(mul(exp, value)).simplify().toAffine();
	// linearTerms.add(mul);
	// } else {
	// linearTerms.add(t.getExp());
	// }
	// }
	// linearTerms.add(term(k));
	// IntConstraint linConstraint = linConstraint(linexp(sum(linearTerms)),
	// Operator.GE);
	// return linConstraint;
	// throw new RuntimeException();
	// }

	// /**
	// * Apply causality on rays.(doesn't use constant part of terms);
	// *
	// * @param ray
	// * @param dep
	// * @return
	// */
	// private IntConstraint applyRay(MatrixRow ray, Dependency dep) {
	// EList<ScheduleTerm> factorized = dep.getTerms(false);
	// IntConstraint c = buildConstraintFrom(ray, dep.getDependencyDomain(),
	// factorized, 1);
	// // c.setComparisonOperator(Operator.EQ);
	// return c;
	// }
	//
	// private static int getValue(MatrixRow v, Variable var, Domain d) {
	// int pos = getVariablePosition(var, d);
	// return (int) v.get(pos);
	// }

	static int getVariablePosition(Variable v, Domain d) {
		int pos = d.getDimensions().getParameters().indexOf(v);
		if (pos != -1)
			return pos;
		pos = d.getDimensions().getIndices().indexOf(v);
		if (pos != -1)
			return d.getDimensions().getParameters().size() + pos;
		else
			throw new IllegalArgumentException("Variable " + v
					+ " isn't a variable of " + d);
	}

	@Override
	protected Domain findDependencyConstraints(Dependency d) {
		return causality(d);

	}

}
