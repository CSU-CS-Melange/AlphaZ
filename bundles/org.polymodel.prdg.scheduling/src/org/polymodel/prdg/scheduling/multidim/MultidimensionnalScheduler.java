package org.polymodel.prdg.scheduling.multidim;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.Scheduler;

public class MultidimensionnalScheduler extends Scheduler {

	public MultidimensionnalScheduler(MultidimSchedulingDomainBuilder p) {
		super(p);
	}

	@Override
	protected ScheduledStatement buildScheduledStatement(PRDGNode statement,
			Domain d) {
		MultidimSchedulePrototype msp = findMultidimSchedulePrototype(
				statement, d);
		List<IntExpression> expressions = new ArrayList<IntExpression>();
		for (SchedulePrototype sp : msp.getPrototypes()) {
			IntExpression applied = sp.applyScheduling(d);
			expressions.add(applied);
		}
		return schedulingConcreteFactory.createScheduledStatement(statement,
				expressions);
	}

	private MultidimSchedulePrototype findMultidimSchedulePrototype(
			PRDGNode statement, Domain d) {

		for (Variable v : d.getDimensions().getIndices()) {
			if (v instanceof ScheduleCoefficient) {
				ScheduleCoefficient coef = (ScheduleCoefficient) v;
				SchedulePrototype sp = coef.getOwner();
				MultidimSchedulePrototype container = (MultidimSchedulePrototype) sp
						.eContainer();
				if (container.getReference() == schedulingPolyhedronBuilder
						.getSchedulePrototype(statement))
					return container;
			}
		}
		throw new IllegalArgumentException(
				"Unable to find the multidim schedule protoype for "
						+ statement);
	}

}
