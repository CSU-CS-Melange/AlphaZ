package org.polymodel.prdg.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.prdg.PRDGEdge;

/**
 * A simple dependency provider that build only an {@link EdgeDependency}.
 * 
 * @author antoine
 * 
 */
public class SimpleMonodimensionalDependenciesProvider implements
		IDependenciesProvider {
	private SchedulingDomainBuilder schedulingDomainBuilder;

	public SimpleMonodimensionalDependenciesProvider(
			SchedulingDomainBuilder schedulingDomainBuilder) {
		this.schedulingDomainBuilder = schedulingDomainBuilder;
	}

	@Override
	public List<Dependency> getDependenciesFor(PRDGEdge e) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		StatementSchedulePrototype source = schedulingDomainBuilder
				.getSchedulePrototype(e.getSource());
		StatementSchedulePrototype ref = schedulingDomainBuilder
				.getSchedulePrototype(e.getDestination());
		Dependency dependency = schedulingDomainBuilder
				.getSchedulingConcreteFactory().createEdgeDependency(source,
						ref, e);
		dependencies.add(dependency);
		return dependencies;
	}
}
