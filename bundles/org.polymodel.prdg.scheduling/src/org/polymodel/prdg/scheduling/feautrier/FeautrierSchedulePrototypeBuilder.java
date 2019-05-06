package org.polymodel.prdg.scheduling.feautrier;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.ScheduleTerm;

/**
 * Build prototypes of schedules for Feautrier based approaches. Prototypes are
 * based on the farkas lemma and thus all schedule coefficients are positives.
 * 
 * <br>
 * <i>P. Feautrier. Some efficient solutions to the affine scheduling problem:
 * I. one-dimensional time. Int. J. Parallel Program., 21(5):313–348,
 * 1992.</i>
 * 
 * @author antoine
 * 
 */
public class FeautrierSchedulePrototypeBuilder extends SchedulePrototypeBuilder {

	

	public void initializePrototype(SchedulePrototype prototype,
			String prefix, Domain domain) {
		int l = 0;
		// Constant term
		ScheduleCoefficient lambdac = schedulingConcreteFactory.createScheduleCoefficient( prefix + l);
		prototype.getCoeficients().add(lambdac);
		ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
				lambdac, affine(term(1)));
		prototype.getTerms().add(constant);
		l++;

		// Definition domain terms
		for (IntConstraintSystem p : domain.getPolyhedra()) {
			for (IntConstraint c : p.getConstraints()) {
				// Create schedule term for this constraint

				ScheduleCoefficient lambda = schedulingConcreteFactory.createScheduleCoefficient( prefix + l);
				prototype.getCoeficients().add(lambda);

				AffineExpression scheduleTermExpression = buildScheduleTermExpression(c);
				ScheduleTerm term = schedulingConcreteFactory
						.createScheduleTerm(lambda, scheduleTermExpression);
				prototype.getTerms().add(term);
				l++;
			}
		}
	}

}
