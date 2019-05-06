package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.ISchedulingStrategy;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.feautrier.FeautrierSchedulePrototypeBuilder;

public class StructuredScheduler {
	private Map<PRDGNode, StatementSchedulePrototype> nodesSchedulesMap;
	private Map<PRDGEdge, EdgeDependency> edgeDependenciesMap;
	private Map<Channel, ChannelSchedulePrototype> channelSchedulesMap;
	protected StructuredLinearSchedulePrototypeBuilder prototypeBuilder;
	private ProcessConstraintsBuilder processConstraintsBuilder;
	private PolymodelDefaultFactory polymodelDefaultFactory;
	private SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);
	private ISchedulingStrategy solver;

	public StructuredLinearSchedulePrototypeBuilder getPrototypeBuilder() {
		return prototypeBuilder;
	}

	public ProcessConstraintsBuilder getProcessConstraintsBuilder() {
		return processConstraintsBuilder;
	}

	public StructuredScheduler(
			StructuredLinearSchedulePrototypeBuilder prototypeBuilder,
			ProcessConstraintsBuilder processConstraintsBuilder) {
		this.prototypeBuilder = prototypeBuilder;
		this.processConstraintsBuilder = processConstraintsBuilder;
		this.polymodelDefaultFactory = PolymodelComponent.INSTANCE.getFactory();
		this.solver = PolymodelComponent.INSTANCE
				.getInstance(ISchedulingStrategy.class);
		initialize();
	}

	public StructuredScheduler(
			SchedulePrototypeBuilder referenceSchedulePrototypeBuilder) {
		this(new StructuredLinearSchedulePrototypeBuilder(
				referenceSchedulePrototypeBuilder),
				new ProcessConstraintsBuilder());
	}

	public StructuredScheduler() {
		this(new StructuredLinearSchedulePrototypeBuilder(
				new FeautrierSchedulePrototypeBuilder()),
				new ProcessConstraintsBuilder());
	}

	protected void initialize() {
		this.nodesSchedulesMap = new HashMap<PRDGNode, StatementSchedulePrototype>();
		this.edgeDependenciesMap = new HashMap<PRDGEdge, EdgeDependency>();
		this.channelSchedulesMap = new HashMap<Channel, ChannelSchedulePrototype>();
	}

	public void schedule(ProcessNetwork n) throws SchedulingException {
		Domain channelSchedule = scheduleChannels(n);
		System.out.println("StructuredScheduler.schedule()");
		System.out.println(channelSchedule);
	}

	void injectChannelSchedule(Domain channelSchedule) {
		throw new RuntimeException("not implemented");
	}

	public Domain scheduleChannels(ProcessNetwork n) throws SchedulingException {
		initialize();
		List<IntConstraint> constraints = findAllCommunicationConstraints(n);
		List<Variable> dimensions = getAllChannelsDimensions(n);
		Domain communicationsDomain = polymodelDefaultFactory.createDomain(
				dimensions, constraintSystem(constraints));
		return solver.solve(communicationsDomain);

	}

	protected List<Variable> getAllChannelsDimensions(ProcessNetwork n) {
		List<Variable> dimensions = new ArrayList<Variable>();
		for (Channel c : n.getChannels()) {
			dimensions.addAll(getSchedulePrototype(c).getCoeficients());
		}
		return dimensions;
	}
	
	private Map<Variable, Long> linearizationFactorsMap;

	private List<IntConstraint> findAllCommunicationConstraints(ProcessNetwork n) throws SchedulingException {

		List<IntConstraint> constraints = new ArrayList<IntConstraint>();
		for (Process process : n.getProcesses()) {
			Domain channelConstraints = processConstraintsBuilder
					.findChannelConstraints(process, this,linearizationFactorsMap);
			if (channelConstraints.getPolyhedra().size() > 0) {
				List<IntConstraint> processConstraints = channelConstraints
						.getPolyhedra().get(0).getConstraints();
				constraints.addAll(processConstraints);
			}
		}
		return constraints;
	}

	public StatementSchedulePrototype getSchedulePrototype(PRDGNode n) {
		StatementSchedulePrototype p = nodesSchedulesMap.get(n);
		if (p == null) {
			p = buildStatementSchedulePrototype(n);
		}
		return p;
	}

	protected StatementSchedulePrototype buildStatementSchedulePrototype(
			PRDGNode n) {
		StatementSchedulePrototype p;
		p = prototypeBuilder.createSchedulePrototype(n);
		nodesSchedulesMap.put(n, p);
		return p;
	}

	public ChannelSchedulePrototype getSchedulePrototype(Channel c) {
		ChannelSchedulePrototype p = channelSchedulesMap.get(c);
		if (p == null) {
			p = buildChannelSchedulePrototype(c);
		}
		return p;
	}

	protected ChannelSchedulePrototype buildChannelSchedulePrototype(Channel c) {
		ChannelSchedulePrototype p;
		p = prototypeBuilder.createSchedulePrototype(c);
		channelSchedulesMap.put(c, p);
		return p;
	}

	/**
	 * Get the dependency of an edge (lazy initialization).
	 * 
	 * @param e
	 * @return
	 */
	public EdgeDependency getDependency(PRDGEdge e) {
		EdgeDependency dep = edgeDependenciesMap.get(e);
		if (dep == null) {
			dep = buildDependency(e);
			edgeDependenciesMap.put(e, dep);
		}

		return dep;
	}

	/**
	 * Create a new dependency for an edge. Specialize this function if you want
	 * to create different types of dependencies.
	 * 
	 * @param e
	 * @return
	 */
	protected EdgeDependency buildDependency(PRDGEdge e) {
		StatementSchedulePrototype source = getSchedulePrototype(e.getSource());
		StatementSchedulePrototype ref = getSchedulePrototype(e
				.getDestination());
		return schedulingConcreteFactory.createEdgeDependency(source, ref, e);
	}

}
