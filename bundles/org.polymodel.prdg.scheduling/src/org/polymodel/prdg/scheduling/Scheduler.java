package org.polymodel.prdg.scheduling;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.le;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.modules.SchedulingModule;
import org.polymodel.prdg.scheduling.notifications.ScheduledStatementNotification;
import org.polymodel.prdg.scheduling.notifications.SchedulingNotification;

import fr.irisa.cairn.graph.observer.IObserver;
import fr.irisa.cairn.graph.observer.Observable;

/**
 * Abstract class for a PRDG scheduler. It is using an external scheduling
 * domain builder to build the polyhedral space of legal schedules.
 * 
 * @see SchedulingDomainBuilder
 * @author antoine
 * 
 */
public abstract class Scheduler extends Observable implements IPRDGScheduler {
	protected SchedulingDomainBuilder schedulingPolyhedronBuilder;
	protected PolymodelDefaultFactory factory;
	protected DimensionsManager dimensionsManager;
	protected SchedulingConcreteFactory schedulingConcreteFactory;
	protected ISchedulingStrategy solver;
	private Integer lb;
	private Integer ub;
	
	private final static SchedulingModule SCHEDULING_MODULE = new SchedulingModule();

	public Scheduler(SchedulingDomainBuilder schedulingPolyhedronBuilder,
			ISchedulingStrategy solver) {
		this.schedulingPolyhedronBuilder = schedulingPolyhedronBuilder;
		this.factory = PolymodelComponent.INSTANCE.getFactory();
		this.dimensionsManager = PolymodelComponent.INSTANCE
				.getDefaultDimensionsManager();
		this.schedulingConcreteFactory = PolymodelComponent.INSTANCE
				.getInstance(SchedulingConcreteFactory.class,SCHEDULING_MODULE);
		this.solver = solver;
	}

	@Override
	public void addObserver(IObserver o) {
		super.addObserver(o);
		schedulingPolyhedronBuilder.addObserver(o);
	}

	/**
	 * Build the scheduler using injected {@link ISchedulingStrategy}.
	 * 
	 * @param schedulingPolyhedronBuilder
	 *            builder of the scheduling domain
	 */
	public Scheduler(SchedulingDomainBuilder schedulingPolyhedronBuilder) {
		this(schedulingPolyhedronBuilder, PolymodelComponent.INSTANCE
				.getInstance(ISchedulingStrategy.class,SCHEDULING_MODULE));
	}

	public Integer getLb() {
		return lb;
	}

	/**
	 * Set the lower bound of schedule coefficients
	 * 
	 * @param lb
	 */
	public void setLb(Integer lb) {
		this.lb = lb;
	}

	public Integer getUb() {
		return ub;
	}

	/**
	 * Set the upper bound of schedule coefficients
	 * 
	 * @param lb
	 */
	public void setUb(Integer ub) {
		this.ub = ub;
	}

	/**
	 * Find the monodimensionnal schedule for a PRDG using the scheduler
	 * {@link ISchedulingStrategy}.
	 * 
	 * @param prdg
	 * @return
	 * @throws SchedulingException
	 */
	public EList<ScheduledStatement> schedule(PRDG prdg)
			throws SchedulingException {
		
		Domain schedulingDomain = schedulingPolyhedronBuilder
				.buildSchedulingDomain(prdg);

		// Upper and lower bounds context
		List<IntConstraint> context = new ArrayList<IntConstraint>();
		DomainDimensions dimensions = schedulingDomain.getDimensions();
		EList<Variable> indices = dimensions.getIndices();
		if (lb != null) {
			for (Variable v : indices) {
				context.add(ge(affine(term(v)), affine(term(lb))));
			}
		}

		if (ub != null) {
			for (Variable v : indices) {
				context.add(le(affine(term(v)), affine(term(ub))));
			}
		}
		if (context.size() > 0) {
			Domain contextDomain = factory.createDomain(dimensions.copy(), constraintSystem(context));
			schedulingDomain = intersection(schedulingDomain, contextDomain);
		}
		EList<ScheduledStatement> scheduled = new BasicEList<ScheduledStatement>();

		// Solve
		Domain solved = solver.solve(schedulingDomain);
		notify(new SchedulingNotification(this, solved));
		for (PRDGNode statement : prdg.getNodes()) {
			ScheduledStatement buildScheduledStatement = buildScheduledStatement(
					statement, solved);
			notify(new ScheduledStatementNotification(this,
					buildScheduledStatement));
			scheduled.add(buildScheduledStatement);
		}
		return scheduled;
	}

	protected abstract ScheduledStatement buildScheduledStatement(
			PRDGNode statement, Domain d);

}
