package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.polymodel.Domain;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl;

/**
 * Schedules prototypes builder for Feautrier structured scheduling. <br>
 * <i>P. Feautrier. Scalable and structured scheduling. Int. J. Parallel
 * Program., 34(5):459âp487, 2006.</i>
 * 
 * @author antoine
 * 
 */
public class StructuredLinearSchedulePrototypeBuilder extends
		SchedulePrototypeBuilder {
	protected SchedulePrototypeBuilder referenceBuilder;
	public final static String ALLOCATION_PREFIX = "alpha";

	public StructuredLinearSchedulePrototypeBuilder(
			SchedulePrototypeBuilder referenceBuilder) {
		super();
		this.referenceBuilder = referenceBuilder;
	}

	public ChannelSchedulePrototype createAllocationFunction(
			BoundedChannel channel) {
		ChannelSchedulePrototypeImpl prototype = (ChannelSchedulePrototypeImpl) StructuredFactory.eINSTANCE
				.createChannelSchedulePrototype();
		prototype.setChannel(channel);
		int l = 0;

		// Constant term
		ScheduleCoefficient lambdac = schedulingConcreteFactory
				.createScheduleCoefficient(ALLOCATION_PREFIX + "_"
						+ channel.getName() + "_" + l);
		prototype.getCoeficients().add(lambdac);
		ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
				lambdac, affine(term(1)));
		prototype.getTerms().add(constant);
		l++;

		// Channel subscript term
		ScheduleCoefficient lambda = schedulingConcreteFactory
				.createScheduleCoefficient(ALLOCATION_PREFIX + "_"
						+ channel.getName() + "_" + l);
		prototype.getCoeficients().add(lambda);
		ScheduleTerm term = schedulingConcreteFactory.createScheduleTerm(
				lambda, affine(term(channel.getSubscriptDimension())));
		prototype.getTerms().add(term);

		prototype.setFactory(factory);
		return prototype;
	}

	protected ChannelSchedulePrototype createChannelPrototype(Channel channel,
			String prefix) {
		ChannelSchedulePrototypeImpl prototype = (ChannelSchedulePrototypeImpl) StructuredFactory.eINSTANCE
				.createChannelSchedulePrototype();
		prototype.setChannel(channel);
		int l = 0;

		// Constant term
		ScheduleCoefficient lambdac = schedulingConcreteFactory
				.createScheduleCoefficient(prefix + "_" + channel.getName()
						+ "_" + l);
		prototype.getCoeficients().add(lambdac);
		ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
				lambdac, affine(term(1)));
		prototype.getTerms().add(constant);
		l++;

		// Channel subscript term
		ScheduleCoefficient lambda = schedulingConcreteFactory
				.createScheduleCoefficient(prefix + "_" + channel.getName()
						+ "_" + l);
		prototype.getCoeficients().add(lambda);
		ScheduleTerm term = schedulingConcreteFactory.createScheduleTerm(
				lambda, affine(term(channel.getSubscriptDimension())));
		prototype.getTerms().add(term);

		prototype.setFactory(factory);
		return prototype;
		// ChannelSchedulePrototypeImpl prototype =
		// (ChannelSchedulePrototypeImpl) StructuredFactory.eINSTANCE
		// .createChannelSchedulePrototype();
		// prototype.setChannel(channel);
		// int l = 0;
		//
		// // Constant term
		// Variable lambdac = schedulingConcreteFactory.createVariable(prefix
		// + "_" + channel.getName() + "_" + l);
		// prototype.getCoeficients().add(lambdac);
		// ScheduleTerm constant = schedulingConcreteFactory.createScheduleTerm(
		// lambdac, affine(term(1)));
		// prototype.getTerms().add(constant);
		// l++;
		//
		// // Definition domain terms
		// Domain domain = channel.getDomain();
		// for (IntConstraintSystem p : domain.getPolyhedra()) {
		// for (IntConstraint c : p.getConstraints()) {
		// // Create schedule term for this constraint
		//
		// Variable lambda = schedulingConcreteFactory
		// .createVariable(prefix + "_" + channel.getName() + "_"
		// + l);
		// prototype.getCoeficients().add(lambda);
		//
		// AffineExpression scheduleTermExpression =
		// buildScheduleTermExpression(c);
		// ScheduleTerm term = schedulingConcreteFactory
		// .createScheduleTerm(lambda, scheduleTermExpression);
		// prototype.getTerms().add(term);
		// l++;
		// }
		// }
		// prototype.setFactory(factory);
		// return prototype;
	}

	public ChannelSchedulePrototype createSchedulePrototype(Channel channel) {
		return createChannelPrototype(channel,
				SchedulingConcreteFactory.SCHEDULE_COEF);
	}

	@Override
	public StatementSchedulePrototype createSchedulePrototype(
			PRDGNode statement, String name) {
		return referenceBuilder.createSchedulePrototype(statement, name);
	}

	@Override
	public void initializePrototype(SchedulePrototype prototype, String name,
			Domain domain) {
		throw new RuntimeException(" to sync with protoyp builder modif");

	}

}
