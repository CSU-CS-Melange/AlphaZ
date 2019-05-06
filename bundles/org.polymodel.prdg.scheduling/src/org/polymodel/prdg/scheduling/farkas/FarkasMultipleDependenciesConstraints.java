package org.polymodel.prdg.scheduling.farkas;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.prdg.scheduling.Dependency;


public class FarkasMultipleDependenciesConstraints extends FarkasDependencyConstraints{
	private List<Dependency> dependencies = new ArrayList<Dependency>();
	
	public FarkasMultipleDependenciesConstraints(Dependency dependency) {
		super(dependency);
		addDependency(dependency);
	}
	
	public void addDependency(Dependency d){
		this.dependencies.add(d);
	}

	@Override
	protected ScheduleTermList buildDependencyScheduleTerms() {
		ScheduleTermList terms = new ScheduleTermList(d.getTerms(true));
		for(Dependency dep: dependencies){
			if(dep!=d){
				terms.addAll(dep.getTerms(true));
			}
		}
		return terms;
	}
}
