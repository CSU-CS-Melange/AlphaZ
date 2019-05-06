package org.polymodel.prdg.scheduling.structured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.Variable;

public class BoundedStructuredScheduler extends StructuredScheduler {
	private Map<BoundedChannel, ChannelSchedulePrototype> allocationsMap;

	public BoundedStructuredScheduler(
			StructuredLinearSchedulePrototypeBuilder structuredSchedulePrototypeBuilder,
			LinearBoundedChannelConstraintsBuilder constraintsBuilder) {
		super(structuredSchedulePrototypeBuilder, constraintsBuilder);
	}

	
	@Override
	protected void initialize() {
		super.initialize();
		this.allocationsMap = new HashMap<BoundedChannel, ChannelSchedulePrototype>();
	}

	@Override
	protected ChannelSchedulePrototype buildChannelSchedulePrototype(Channel c) {
		return super.buildChannelSchedulePrototype(c);
	}

	public ChannelSchedulePrototype getAllocationSchedulePrototype(
			BoundedChannel c) {
		ChannelSchedulePrototype a = allocationsMap.get(c);
		if (a == null) {
			a = prototypeBuilder.createAllocationFunction(c);
			allocationsMap.put(c, a);
		}
		return a;
	}

	@Override
	protected List<Variable> getAllChannelsDimensions(ProcessNetwork n) {
		List<Variable> dimensions = super.getAllChannelsDimensions(n);
		for (Channel c : n.getChannels()) {
			dimensions
					.addAll(getAllocationSchedulePrototype((BoundedChannel) c)
							.getCoeficients());
		}
		return dimensions;
	}
}
