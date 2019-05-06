package org.polymodel.prdg.scheduling.structured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;

import fr.irisa.cairn.graph.observer.IObserver;

/**
 * A multidimensionnal builder of channel constraints. When building constraint
 * of a dependency, a {@link MultidimDependency} is created. Constraints for
 * this dependency are based on Pouchet convex space for multidimensionnal
 * scheduling. It may contains nullification terms if the dependency require a
 * causality.
 * 
 * @author antoine
 * 
 */
public class MultidimBoundedConstraintsBuilder extends
		BoundedChannelConstraintsBuilder {
	private int nbDimensions;
	private boolean buildScalarDimensions;
	private int K;

	/**
	 * Lower bound of coefficients (coefficients have to be bounded for the
	 * nullification)
	 */
	private int lb;
	/**
	 * Upper bound of coefficients (coefficients have to be bounded for the
	 * nullification)
	 */
	private int ub;

	private Map<SchedulePrototype, MultidimSchedulePrototype> schedulePrototypesMap = new HashMap<SchedulePrototype, MultidimSchedulePrototype>();

	public MultidimBoundedConstraintsBuilder(List<Long> linearizationFactors,
			int nbDimensions, boolean buildScalarDimensions, int k, int lb,
			int ub) {
		super(linearizationFactors);
		this.nbDimensions = nbDimensions;
		this.buildScalarDimensions = buildScalarDimensions;
		K = k;
		this.lb = lb;
		this.ub = ub;
	}

	@Override
	protected Domain buildConstraintsFor(Dependency dependency) {
		if (!(dependency instanceof CompositeDependency)) {

			MultidimDependency multiDimDep;
			if (dependency instanceof MemoryReadDependency) {
				multiDimDep = StructuredSchedulingConcreteFactory.INSTANCE
						.createMultidimensionalReadDependency(
								(MemoryReadDependency) dependency,
								nbDimensions, K, schedulePrototypesMap,
								buildScalarDimensions, linearizationFactors);
			} else
				multiDimDep = schedulingConcreteFactory
						.createMultidimensionalDependency(dependency,
								nbDimensions, K, schedulePrototypesMap,
								buildScalarDimensions);
			multiDimDep.setLb(lb);
			multiDimDep.setUb(ub);
			for (NullifiableDependency d : multiDimDep.getDependencies()) {
				manageVariables(d.getSource());
				manageVariables(d.getReference());
				if (d.requireNullification())
					modularVariables.add(d.getSatisfactionVariable());
			}
			for (IObserver observer : getObservers()) {
				multiDimDep.addObserver(observer);
			}
			return multiDimDep.computeConstraints();
		} else {
			return super.buildConstraintsFor(dependency);
		}
	}
}
