package org.polymodel.prdg.scheduling.pouchet;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

public class PouchetSchedulePrototypeBuilder extends SchedulePrototypeBuilder {

	public PouchetSchedulePrototypeBuilder() {
		super();
	}

	@Override
	public StatementSchedulePrototype createSchedulePrototype(PRDGNode statement) {
		return createSchedulePrototype(statement, "t"+"_"+statement.getName());
	}

	@Override
	public StatementSchedulePrototype createSchedulePrototype(
			PRDGNode statement, String prefix) {
		PouchetSchedulePrototype sp = new PouchetSchedulePrototype(statement);
		sp.setFactory(factory);
		initializePrototype(sp, prefix,
				statement.getDomain());
		return sp;
	}

	@Override
	public void initializePrototype(SchedulePrototype prototype, String name,
			Domain domain) {
		int l = 1;
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

		for (ScheduleTerm sterm : prototype.getTerms()) {
			AffineExpression exp = sterm.getExp();
			((PouchetSchedulePrototype) prototype)
					.substituteWithScheduledVariables(exp);
		}

		// Constant term
		ScheduleCoefficient lambdac = schedulingConcreteFactory.createScheduleCoefficient( name + l);
		prototype.getCoeficients().add(lambdac);
		ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
				lambdac, affine(term(1)));
		prototype.getTerms().add(constant);

	}

}
