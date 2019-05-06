package org.polymodel.prdg.scheduling;

import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.tom.RemoveRightSideTransformation;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl;

/**
 * Abstract class to all schedule prototypes builders. Since some of builders
 * may need to create polymodel objects, it has a reference on
 * {@link PolymodelDefaultFactory}.
 * 
 * @author antoine
 * 
 */
public abstract class SchedulePrototypeBuilder {

	protected PolymodelDefaultFactory factory;
	protected SchedulingConcreteFactory schedulingConcreteFactory;

	public SchedulePrototypeBuilder() {
		this.factory = PolymodelComponent.INSTANCE.getFactory();
		this.schedulingConcreteFactory = PolymodelComponent.INSTANCE
				.getInstance(SchedulingConcreteFactory.class);
	}

	/**
	 * Create the schedule prototype of a {@link PRDGNode} statement.
	 * 
	 * @param statement
	 * @return
	 */
	public StatementSchedulePrototype createSchedulePrototype(PRDGNode statement) {
		return createSchedulePrototype(statement, SchedulingConcreteFactory.SCHEDULE_COEF+"_"+statement.getName());
	}

	/**
	 * Create the schedule prototype of a {@link PRDGNode} statement.
	 * 
	 * @param statement
	 * @param name
	 *            name attached to the prefix of created schedule coefficients
	 * @return
	 */
	public StatementSchedulePrototype createSchedulePrototype(
			PRDGNode statement, String prefix) {
		StatementSchedulePrototypeImpl prototype = (StatementSchedulePrototypeImpl) SchedulingFactory.eINSTANCE
				.createStatementSchedulePrototype();
		prototype.setStatement(statement);
		prototype.setFactory(factory);
		initializePrototype(prototype, prefix, statement.getDomain());
		return prototype;
	}

	/**
	 * Initialize terms of a schedule prototype.
	 * 
	 * @param prototype
	 * @param name
	 * @param domain
	 */
	public abstract void initializePrototype(SchedulePrototype prototype,
			String name, Domain domain);

	/**
	 * Build the expression of a schedule term from a constraint.
	 * 
	 * @param c
	 * @return
	 */
	protected AffineExpression buildScheduleTermExpression(IntConstraint c) {
		c = RemoveRightSideTransformation.transform(c);
		return (AffineExpression) c.getLhs().toAffine().simplify();
	}

}
