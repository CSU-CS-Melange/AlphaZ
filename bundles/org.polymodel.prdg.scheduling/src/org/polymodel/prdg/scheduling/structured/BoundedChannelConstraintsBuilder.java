package org.polymodel.prdg.scheduling.structured;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

/**
 * Builder for input and output constraints of process channels. Channels have a
 * limited memory.<br>
 * <br>
 * <i>P. Feautrier. Scalable and structured scheduling. Int. J. Parallel
 * Program., 34(5):459âp487, 2006.</i>
 * 
 * @author antoine
 * 
 */
public class BoundedChannelConstraintsBuilder extends
		LinearBoundedChannelConstraintsBuilder {
	protected List<Long> linearizationFactors;

	public BoundedChannelConstraintsBuilder(List<Long> linearizationFactors) {
		this.linearizationFactors = linearizationFactors;
	}

	public BoundedChannelConstraintsBuilder(Long... linearizationFactors) {
		this.linearizationFactors = new ArrayList<Long>();
		for (int i = 0; i < linearizationFactors.length; i++) {
			this.linearizationFactors.add(linearizationFactors[i]);
		}
	}



	protected List<Dependency> getReadDependencies(BoundedChannel channel,
			PRDGEdge edge, BoundedStructuredScheduler bscheduler) {
		List<Dependency> result = new ArrayList<Dependency>();
		EdgeDependency edgeDependency = bscheduler.getDependency(edge);
		ChannelSchedulePrototype allocation = bscheduler
				.getAllocationSchedulePrototype(channel);

		MemoryReadDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryReadDependency(channel, allocation,
						edgeDependency.getReference(), edge,
						linearizationFactors);
		result.add(readDependency);

		// Allocation dependency of a read
		MemoryAllocationDependency allocationDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryAllocationDependency(channel, allocation,
						edgeDependency.getReference(), edge);

		result.add(allocationDependency);
		return result;
	}

	protected List<Dependency> getWriteDependencies(BoundedChannel channel,
			StatementSchedulePrototype source,
			BoundedStructuredScheduler bscheduler) {
		List<Dependency> result = new ArrayList<Dependency>();
		ChannelSchedulePrototype allocation = bscheduler
				.getAllocationSchedulePrototype(channel);
		MemoryWriteDependency writeDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryWriteDependency(channel, source, allocation);
		result.add(writeDependency);
		return result;
	}
}
