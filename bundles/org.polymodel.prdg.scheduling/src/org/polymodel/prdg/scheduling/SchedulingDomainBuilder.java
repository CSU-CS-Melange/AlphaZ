package org.polymodel.prdg.scheduling;

import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.Domain;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.notifications.EdgeDependenciesNotification;
import org.polymodel.prdg.scheduling.notifications.SchedulePrototypeNotification;

import fr.irisa.cairn.graph.observer.Observable;

/**
 * Abstract class in charge of the construction of the polyhedral domain giving
 * the schedule search space. Each dimension of the schedule domain is a
 * schedule coefficient that will be applied to the schedule prototypes of the
 * PRDG nodes.
 * 
 * @author antoine
 * 
 */
public abstract class SchedulingDomainBuilder extends Observable {
	private Map<PRDGNode, StatementSchedulePrototype> prototypesMap;
	private Map<PRDGEdge, List<Dependency>> dependenciesMap;
	protected PolymodelDefaultFactory polymodelFactory;
	protected SchedulePrototypeBuilder prototypeBuilder;
	protected SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);
	private IDependenciesProvider dependenciesProvider;

	public SchedulingDomainBuilder(
			SchedulePrototypeBuilder prototypeBuilder) {
		this.polymodelFactory = PolymodelComponent.INSTANCE.getFactory();
		this.prototypeBuilder = prototypeBuilder;
		this.dependenciesProvider = new SimpleMonodimensionalDependenciesProvider(
				this);
	}

	protected void initialize() {
		this.prototypesMap = new HashMap<PRDGNode, StatementSchedulePrototype>();
		this.dependenciesMap = new HashMap<PRDGEdge, List<Dependency>>();
	}

	/**
	 * Build polyhedral domain of all legal schedules.
	 * 
	 * @param prdg
	 * @return
	 * @throws SchedulingException
	 *             if a dependency can't be scheduled
	 */
	public Domain buildSchedulingDomain(PRDG prdg) throws SchedulingException {
		return buildSchedulingDomainFor(prdg.getNodes(), prdg.getEdges());
	}

	/**
	 * Build polyhedral domain of all legal schedules.
	 * 
	 * @param nodes
	 * @param edges
	 * @return
	 * @throws SchedulingException
	 *             if a dependency can't be scheduled
	 */
	public Domain buildSchedulingDomainFor(List<PRDGNode> nodes,
			List<PRDGEdge> edges) throws SchedulingException {
		initialize();
		Domain schedulingDomain = null;
		for(PRDGNode n: nodes){
			StatementSchedulePrototype sp = getSchedulePrototype(n);
			Domain statementDomain = polymodelFactory.createDomain(sp.getCoeficients());
			schedulingDomain = intersection(schedulingDomain,statementDomain);
		}
		for (PRDGEdge e : edges) {
			for (Dependency dependency : getDependencies(e)) {
				Domain constraintsForEdge = findDependencyConstraints(dependency);
				schedulingDomain = intersection(schedulingDomain,
						constraintsForEdge);
				if (schedulingDomain.isEmpty())
					throw new SchedulingException(dependency);
			}
		}
		if (schedulingDomain == null) {
			if (edges.size() > 0) {
				throw new Error("Error : no domain build but there are edges in the PRDG.");
			} else {
				throw new SchedulingException("No dependence edge in the PRDG");
			}
		}
		return schedulingDomain;
	}

	protected abstract Domain findDependencyConstraints(Dependency d);

	/**
	 * Get the schedule prototype of a node (lazy initialization).
	 * 
	 * @param n
	 * @return
	 */
	public StatementSchedulePrototype getSchedulePrototype(PRDGNode n) {
		StatementSchedulePrototype s = prototypesMap.get(n);
		if (s == null) {
			s = prototypeBuilder.createSchedulePrototype(n);
			notify(new SchedulePrototypeNotification(this, s, n));
			prototypesMap.put(n, s);
		}
		return s;
	}

	/**
	 * Get the dependencies of an edge using the {@link IDependenciesProvider}
	 * (lazy initialization).
	 * 
	 * @param e
	 * @return
	 */
	public List<Dependency> getDependencies(PRDGEdge e) {
		List<Dependency> dependencies = dependenciesMap.get(e);
		if (dependencies == null) {
			dependencies = dependenciesProvider.getDependenciesFor(e);
			notify(new EdgeDependenciesNotification(this, e, dependencies));
			dependenciesMap.put(e, dependencies);
		}
		return dependencies;
	}

	public SchedulingConcreteFactory getSchedulingConcreteFactory() {
		return schedulingConcreteFactory;
	}

	public IDependenciesProvider getDependenciesProvider() {
		return dependenciesProvider;
	}

	public void setDependenciesProvider(
			IDependenciesProvider dependenciesProvider) {
		this.dependenciesProvider = dependenciesProvider;
	}

}
