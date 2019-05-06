package org.polymodel.prdg.scheduling.util;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mul;
import static org.polymodel.algebra.factory.IntExpressionBuilder.qaffine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.SchedulingFactory;
import org.polymodel.prdg.scheduling.internal.FastJNIIslSet;

public class SchedulingToolFunctions {
	private static SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);

	public static EList<ScheduleTerm> negate(List<ScheduleTerm> terms) {
		EList<ScheduleTerm> negated = new BasicEList<ScheduleTerm>();
		for (ScheduleTerm t : terms) {
			ScheduleTerm negt = SchedulingFactory.eINSTANCE
					.createScheduleTerm();
			negt.setVar(t.getVar());
			negt.setExp(negate(t.getExp()).toAffine());
			negated.add(negt);
		}
		return negated;
	}

	private static IntExpression negate(AffineExpression iterm) {
		IntExpression simplified = qaffine(mul(iterm, -1)).toAffine();
		return (simplified);
	}

	/**
	 * Factorize a list of schedule terms by a set of variables.
	 * 
	 * @param allTerms
	 * @param allVariables
	 * @return
	 */
	public static EList<ScheduleTerm> factorize(List<ScheduleTerm> allTerms,
			List<? extends Variable> allVariables) {
		if (!areDistributed(allTerms)) {
			List<ScheduleTerm> distributed = distribute(allTerms);
			allTerms = distributed;
		}
		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();
		Set<ScheduleTerm> factorizedTerms = new HashSet<ScheduleTerm>();
		for (Variable var : allVariables) {
			AffineExpression expFor = findExpressionFor(var, allTerms,
					factorizedTerms);
			if (expFor != null) {
				ScheduleTerm term = schedulingConcreteFactory
						.createScheduleTerm(var, expFor);
				terms.add(term);
			}
		}

		AffineExpression constant = SchedulingToolFunctions
				.findConstantExpressionFor(allTerms, factorizedTerms);
		if (constant != null) {
			ScheduleTerm constantTerm = schedulingConcreteFactory
					.createScheduleTerm(null, constant);
			terms.add(constantTerm);
		}
		assert (factorizedTerms.containsAll(allTerms)) : "Unable to factorize all terms";
		// Simplification
		// EList<ScheduleTerm> simplified = new BasicEList<ScheduleTerm>();
		for (ScheduleTerm term : terms) {
			term.simplify();
		}
		return terms;
	}

	public static List<ScheduleTerm> distribute(List<ScheduleTerm> allTerms) {
		List<ScheduleTerm> distributed = new ArrayList<ScheduleTerm>();
		for (ScheduleTerm t : allTerms) {
			distributed.addAll(t.distribute());
		}
		return distributed;
	}

	private static boolean areDistributed(List<ScheduleTerm> terms) {
		for (ScheduleTerm t : terms) {
			if (!isDistributed(t))
				return false;
		}
		return true;
	}

	private static boolean isDistributed(ScheduleTerm t) {
		return t.getExp().getTerms().size() == 1;
	}

	public static AffineExpression findExpressionFor(Variable var,
			List<ScheduleTerm> distributedScheduleTerms,
			Set<ScheduleTerm> identifiedTerms) {
		List<AffineTerm> terms = new ArrayList<AffineTerm>();
		for (ScheduleTerm t : distributedScheduleTerms) {
			AffineTerm simpleTermForVar = findSimpleTermFor(var, t);
			if (simpleTermForVar != null) {
				AffineTerm copy = EcoreUtil.copy(simpleTermForVar);
				copy.setVariable(t.getVar());
				terms.add(copy);
				identifiedTerms.add(t);
			}

		}
		if (terms.size() > 0)
			return affine(terms.toArray(new AffineTerm[terms.size()]));
		return affine();
	}

	private static AffineTerm findSimpleTermFor(Variable var, ScheduleTerm dist) {
		EList<AffineTerm> simpleTerms = dist.getExp().getTerms();
		if (simpleTerms.size() == 1) {
			if (simpleTerms.get(0).getVariable() == var) {
				return simpleTerms.get(0);
			}
		}
		return null;
	}

	public static AffineExpression findConstantExpressionFor(
			List<ScheduleTerm> distributedScheduleTerms,
			Set<ScheduleTerm> identified) {
		return findExpressionFor(null, distributedScheduleTerms, identified);
	}

	/**
	 * Substitute all key variables of the map by their mapped values in the
	 * expression. It modify the input expression.
	 * 
	 * @param variablesMap
	 * @param exp
	 */
	public static void substituteWithVariablesMap(
			Map<? extends Variable, ? extends Variable> variablesMap,
			AffineExpression exp) {
		for (AffineTerm term : exp.getTerms()) {
			Variable var = term.getVariable();
			if (var != null) {
				Variable scheduleVariable = variablesMap.get(var);
				if (scheduleVariable != null)
					term.setVariable(scheduleVariable);
			}
		}
	}

	/**
	 * Substitute all key variables of the map by their mapped values in the
	 * constraint. It modify the input constraint.
	 * 
	 * @param variablesMap
	 * @param exp
	 */
	public static void substituteWithVariablesMap(
			Map<? extends Variable, ? extends Variable> variablesMap,
			IntConstraint c) {
		substituteWithVariablesMap(variablesMap, (AffineExpression) c.getLhs());
		substituteWithVariablesMap(variablesMap, (AffineExpression) c.getRhs());
	}

	/**
	 * Build the intersection of two domains. Dimensions are normalized if
	 * needed.
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <D extends Domain> D intersection(D d1, D d2) {
		if (d1 == null && d2 == null) {
			return null;
		} else {
			if (d1 == null && d2 != null) {
				return d2;
			} else if (d1 != null && d2 == null) {
				return d1;
			} else {
				FastJNIIslSet dn1 = FastJNIIslSet
						.buildFrom((ISLSet) d1);
				FastJNIIslSet dn2 = FastJNIIslSet
						.buildFrom((ISLSet) d2);
				return (D) dn1.normalizedIntersection(dn2);
			}
		}
	}
	// public static <D extends Domain> Domain intersection(D d1, D d2) {
	// if (d1 == null && d2 == null) {
	// return null;
	// } else {
	// if (d1 == null && d2 != null) {
	// return d2;
	// } else if (d1 != null && d2 == null) {
	// return d1;
	// } else {
	// List<Variable> indices = new UniqueEList<Variable>();
	// List<Variable> parameters = new UniqueEList<Variable>();
	// boolean requireNormalization = false;
	// for (Variable i1 : d1.getDimensions().getIndices()) {
	// indices.add(i1);
	// }
	// for (Variable i2 : d2.getDimensions().getIndices()) {
	// boolean added = indices.add(i2);
	// if (added)
	// requireNormalization = true;
	// }
	// for (Variable p1 : d1.getDimensions().getParameters()) {
	// parameters.add(p1);
	// }
	// for (Variable p2 : d2.getDimensions().getParameters()) {
	// boolean added = parameters.add(p2);
	// if (added)
	// requireNormalization = true;
	// }
	// requireNormalization = requireNormalization
	// || (d1.getNbIndices() != d2.getNbIndices() || (d1
	// .getNbParams() != d2.getNbParams()));
	// Domain dn1 = d1;
	// Domain dn2 = d2;
	// if (requireNormalization) {
	// DomainDimensions dimensions = PolymodelComponent.INSTANCE
	// .getFactory().createDomainDimensions(indices,
	// parameters);
	// dn1 = FastJNIIslSetProxy.buildFrom((ISLSet) d1)
	// .normalize(dimensions);
	// dn2 = FastJNIIslSetProxy.buildFrom((ISLSet) d2)
	// .normalize(dimensions);
	//
	// }
	// return dn1.intersection(dn2);
	// }
	// }
	// }
}