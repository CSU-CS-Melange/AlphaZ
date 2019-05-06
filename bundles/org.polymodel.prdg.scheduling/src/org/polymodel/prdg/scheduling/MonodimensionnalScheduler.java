package org.polymodel.prdg.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.prdg.PRDGNode;

/**
 * Monodimensionnal scheduler for a PRDG.
 * 
 * @author antoine
 * 
 */
public class MonodimensionnalScheduler extends Scheduler {

	public MonodimensionnalScheduler(
			SchedulingDomainBuilder schedulingPolyhedronBuilder,
			ISchedulingStrategy solver) {
		super(schedulingPolyhedronBuilder, solver);
	}

	public MonodimensionnalScheduler(
			SchedulingDomainBuilder schedulingPolyhedronBuilder) {
		super(schedulingPolyhedronBuilder);
	}

	protected ScheduledStatement buildScheduledStatement(PRDGNode statement,
			Domain d) {
		SchedulePrototype sp = schedulingPolyhedronBuilder
				.getSchedulePrototype(statement);
		List<IntExpression> expressions = new ArrayList<IntExpression>();
		expressions.add(sp.applyScheduling(d));

		ScheduledStatement result = schedulingConcreteFactory
				.createScheduledStatement(statement, expressions);
		return result;
	}

	public SchedulingDomainBuilder getSchedulingDomainBuilder() {
		return schedulingPolyhedronBuilder;
	}

}
