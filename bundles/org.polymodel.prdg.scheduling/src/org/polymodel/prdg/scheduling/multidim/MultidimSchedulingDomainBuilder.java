package org.polymodel.prdg.scheduling.multidim;

import java.util.HashMap;

import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.farkas.FarkasSchedulingDomainBuilder;

import fr.irisa.cairn.graph.observer.IObserver;

public class MultidimSchedulingDomainBuilder extends
		FarkasSchedulingDomainBuilder {
	private boolean scalar;
	/**
	 * Nullification coefficient.
	 */
	private long K;
	private HashMap<SchedulePrototype, MultidimSchedulePrototype> schedulePrototypesMap = new HashMap<SchedulePrototype, MultidimSchedulePrototype>();

	public MultidimSchedulingDomainBuilder(
			SchedulePrototypeBuilder prototypeBuilder, boolean scalar, long k) {
		super(prototypeBuilder);
		this.scalar = scalar;
		K = k;
	}
	
	

	@Override
	protected Domain findDependencyConstraints(Dependency dependency) {
		int dims = dependency.getDependencyDomain().getNbIndices();
		MultidimDependency mdep = schedulingConcreteFactory
				.createMultidimensionalDependency(dependency, dims, K,
						schedulePrototypesMap, scalar);
		for(IObserver o: getObservers()){
			mdep.addObserver(o);
		}
		return mdep.computeConstraints();

	}
}
