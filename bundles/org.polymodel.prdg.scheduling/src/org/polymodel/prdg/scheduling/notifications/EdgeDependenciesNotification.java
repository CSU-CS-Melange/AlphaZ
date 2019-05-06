package org.polymodel.prdg.scheduling.notifications;

import java.util.List;

import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.Dependency;

public class EdgeDependenciesNotification extends ANotification{
	private PRDGEdge edge;
	private List<Dependency> dependencies;
	
	public EdgeDependenciesNotification(Object notifier, PRDGEdge edge,
			List<Dependency> dependencies) {
		super(notifier);
		this.edge = edge;
		this.dependencies = dependencies;
	}

	public PRDGEdge getEdge() {
		return edge;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}
	

}
