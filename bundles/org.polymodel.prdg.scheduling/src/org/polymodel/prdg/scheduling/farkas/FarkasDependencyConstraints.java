package org.polymodel.prdg.scheduling.farkas;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.le;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.polymodel.Domain;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.internal.FastJNIIslSet;

/**
 * A farkas dependency apply the Farkas lemma to compute constraints on the
 * source and reference scheduling coefficients.
 * 
 * @author antoine
 * 
 */
public class FarkasDependencyConstraints {
	protected Dependency d;
	private ScheduleTermList depedencyTerms;
	private ScheduleTermList farkasTerms;
	private boolean requireFarkasLemma;
	private Integer lb;
	private Integer ub;
	private ISLSet allDependenciesDomain;
	private IntConstraintSystem equations;
	private List<IntConstraint> context;
	private FarkasBuilder farkasBuilder;

	public FarkasDependencyConstraints(Dependency dependency) {
		this(dependency, null);
	}

	public FarkasDependencyConstraints(Dependency dependency,
			List<IntConstraint> context) {
		this.d = dependency;
		this.context = context;
		this.farkasBuilder = new FarkasBuilder();
	}

	protected ScheduleTermList buildDependencyScheduleTerms() {
		return new ScheduleTermList(d.getTerms(true));
	}

	private ISLSet applyFarkasLemma() {

		// Apply the lemma
		depedencyTerms = buildDependencyScheduleTerms();
		farkasTerms = new ScheduleTermList(farkasBuilder.buildFarkasTerms(d
				.getDependencyDomain()));

		requireFarkasLemma = true;
		List<IntConstraint> equationsConstraints = new ArrayList<IntConstraint>();
		for (ScheduleTerm sterm : depedencyTerms) {
			if (!sterm.isConstant()) {
				requireFarkasLemma = true;
				ScheduleTerm farkasTerm = findTerm(sterm.getVar(), farkasTerms);
				if (farkasTerm != null) {
					IntConstraint constraint = constraint(sterm.getExp(),
							farkasTerm.getExp(), ComparisonOperator.EQ);
					equationsConstraints.add(constraint);
				}
			} else {
				// Find all farkas terms that have a constant expression
				List<AffineTerm> constantFarkasAffineTerms = new ArrayList<AffineTerm>();
				for (ScheduleTerm fterm : farkasTerms) {
					if (fterm.isConstant()) {
						constantFarkasAffineTerms.addAll(fterm.getExp()
								.getTerms());
					}
				}
				IntConstraint constraint = constraint(sterm.getExp(),
						affine(constantFarkasAffineTerms),
						ComparisonOperator.EQ);
				equationsConstraints.add(constraint);
			}
		}

		if (requireFarkasLemma) {
			equations = constraintSystem(equationsConstraints);

			List<IntConstraint> constraints = new ArrayList<IntConstraint>();

			// Farkas multipliers coefficients are non negatives
			for (Variable farkasMultiplier : farkasTerms.getCoeficients()) {
				constraints.add(constraint(affine(term(farkasMultiplier)),
						affine(term(0)), ComparisonOperator.GE));
			}
			for (IntConstraint c : equations.getConstraints()) {
				constraints.add(c.copy());
			}
			IntConstraintSystem applied = constraintSystem(constraints);

			List<Variable> allDimensions = new UniqueEList<Variable>();

			allDimensions.addAll(d.getSource().getCoeficients());
			allDimensions.addAll(d.getReference().getCoeficients());
			allDimensions.addAll(depedencyTerms.getCoeficients());
			allDimensions.addAll(farkasTerms.getCoeficients());
			ISLSet appliedDomain = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE)
					.createDomain(allDimensions, applied);
			ISLSet eliminated = eliminateFarkasMultipliers(appliedDomain);
			// if(eliminated.isEmpty()){
			// FarkasLatexPrinter printer = new FarkasLatexPrinter();
			// printer.notify(new FarkasNotification(this, this));
			// this.allDependenciesDomain=appliedDomain;
			// printer.print("farkas-debug.tex");
			// FastJNIIslSetProxy test =
			// FastJNIIslSetProxy.buildFrom(appliedDomain);
			// boolean empty = test.getJNIset().isEmpty()==1;
			// System.out
			// .println("FarkasDependencyConstraints.applyFarkasLemma()");
			//
			// }else{
			appliedDomain = eliminated;
			// }
			ISLSet contextDomain = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE)
					.createDomain(appliedDomain.getDimensions().copy(),
							constraintSystem(buildContext()));
			if (isUniverse(contextDomain)) {
				return (ISLSet) appliedDomain.simplify();
			} else {
				ISLSet resultDomain = (ISLSet) appliedDomain.intersection(
						contextDomain).simplify();
				return resultDomain;
			}
		} else {
			List<Variable> allDimensions = new ArrayList<Variable>(
					depedencyTerms.getCoeficients());
			allDimensions.addAll(farkasTerms.getCoeficients());
			IntConstraintSystem applied = constraintSystem();
			for (IntConstraint eq : equationsConstraints) {
				eq.setComparisonOperator(ComparisonOperator.GE);
				eq.setRhs(affine(term(0)));
				applied.getConstraints().add(eq);
			}
			ISLSet resultDomain = PolymodelComponent.INSTANCE.getFactory()
					.createDomain(allDimensions, applied);
			for (IntConstraint c : buildContext()) {
				resultDomain.addConstraint(c);
			}

			return resultDomain;
		}

	}

	private boolean isUniverse(ISLSet contextDomain) {
		return contextDomain.getPolyhedra().size() == 0
				&& contextDomain.getPolyhedra().get(0).getConstraints().size() == 0;
	}

	private List<IntConstraint> buildContext() {
		List<IntConstraint> applied = new ArrayList<IntConstraint>();
		for (Variable v : depedencyTerms.getCoeficients()) {
			if (lb != null) {
				applied.add(ge(affine(term(v)), affine(term(lb))));
			}
			if (ub != null) {
				applied.add(le(affine(term(v)), affine(term(ub))));
			}
		}

		if (context != null) {
			applied.addAll(context);

		}
		applied.addAll(d.getCoefficientsContext());
		return applied;
	}

	private ISLSet eliminateFarkasMultipliers(ISLSet allDependenciesDomain) {
		FastJNIIslSet islDomain = FastJNIIslSet
				.buildFrom(allDependenciesDomain);
		int start = allDependenciesDomain.getNbIndices()
				- farkasTerms.getCoeficients().size();
		FastJNIIslSet projected = islDomain.project(start, farkasTerms
				.getCoeficients().size());
		projected = projected.simplify();
		return projected;
	}

	private static ScheduleTerm findTerm(Variable v, List<ScheduleTerm> terms) {
		for (ScheduleTerm scheduleTerm : terms) {
			if (scheduleTerm.getVar() == v)
				return scheduleTerm;
		}
		return null;
	}

	/**
	 * Get the dependence constraints after Farkas lemma application and farkas
	 * multipliers elimination through projection.
	 * 
	 * @return System of constraints for the dependence
	 */
	public Domain getApplied() {
		if (allDependenciesDomain == null) {
			allDependenciesDomain = applyFarkasLemma();
		}
		return allDependenciesDomain;
	}

	public Dependency getDependency() {
		return d;
	}

	public ScheduleTermList getScheduleTerms() {
		return depedencyTerms;
	}

	public ScheduleTermList getFarkasTerms() {
		return farkasTerms;
	}

	public IntConstraintSystem getEquations() {
		return equations;
	}

	public void setScheduleCoeficientsLowerBound(Integer lb) {
		this.lb = lb;
	}

	public void setScheduleCoeficientsUpperBound(Integer ub) {
		this.ub = ub;
	}

	/**
	 * Test if the dependency has required farkas lemma
	 * 
	 * @return
	 */
	public boolean isRequireFarkasLemma() {
		return requireFarkasLemma;
	}

}