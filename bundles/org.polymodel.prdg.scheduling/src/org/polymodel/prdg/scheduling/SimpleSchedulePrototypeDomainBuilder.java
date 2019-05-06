package org.polymodel.prdg.scheduling;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;

/**
 * Standard {@link SchedulePrototype} builder. It creates a schedule coeficient
 * for each dimension and each parameter of a statement domain.
 * 
 * @author antoine
 * 
 */
public class SimpleSchedulePrototypeDomainBuilder extends
		SchedulePrototypeBuilder {
	protected SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);

	public SimpleSchedulePrototypeDomainBuilder() {
		super();
	}

	@Override
	public void initializePrototype(SchedulePrototype prototype, String name,
			Domain domain) {
		int l = 1;

		// Definition domain terms
		for (Variable v : domain.getDimensions().getIndices()) {
			// Create schedule term for this constraint
			ScheduleCoefficient lambda = schedulingConcreteFactory.createScheduleCoefficient( name + l);
			prototype.getCoeficients().add(lambda);

			ScheduleTerm term = schedulingConcreteFactory.createScheduleTerm(
					lambda, affine(term(v)));
			prototype.getTerms().add(term);
			l++;
		}
		for (Variable v : domain.getDimensions().getParameters()) {
			// Create schedule term for this constraint
			ScheduleCoefficient lambda = schedulingConcreteFactory.createScheduleCoefficient( name + l);
			prototype.getCoeficients().add(lambda);

			ScheduleTerm term = schedulingConcreteFactory.createScheduleTerm(
					lambda, affine(term(v)));
			prototype.getTerms().add(term);
			l++;
		}

		// Constant term
		ScheduleCoefficient lambdac = schedulingConcreteFactory.createScheduleCoefficient( name + l);
		prototype.getCoeficients().add(lambdac);
		ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
				lambdac, affine(term(1)));
		prototype.getTerms().add(constant);

	}
}
