package org.polymodel.prdg.scheduling.structured;

import org.polymodel.prdg.scheduling.SimpleSchedulePrototypeDomainBuilder;
import org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl;

/**
 * Schedule prototype builder for bounded structured scheduler using a
 * linearized bound. Subscript access doesn't require to be linearized.
 * 
 * @author antoine
 * 
 */
public class StructuredSchedulePrototypeBuilder extends
		StructuredLinearSchedulePrototypeBuilder {

	public StructuredSchedulePrototypeBuilder() {
		super(new SimpleSchedulePrototypeDomainBuilder());
	}

	/**
	 * Create a channel schedule prototype of the following form: <br>
	 * <i>Theta(A, I) = mu_0 + mu_1*i_1 + ... + mu_k+i_k</i>
	 */
	@Override
	protected ChannelSchedulePrototype createChannelPrototype(Channel channel,
			String prefix) {

		ChannelSchedulePrototypeImpl prototype = (ChannelSchedulePrototypeImpl) StructuredFactory.eINSTANCE
				.createChannelSchedulePrototype();
		prototype.setFactory(factory);
		prototype.setChannel(channel);

		String name = prefix + "_" + channel.getName();
		prototype.setName(channel.getName());
		referenceBuilder.initializePrototype(prototype, name,
				channel.getDomain());
		return prototype;
	}

	/**
	 * Create an allocation schedule prototype of the following form: <br>
	 * <i>alpha(A, I) = a_0 + a_1*i_1 + ... + a_k+i_k</i>
	 */
	@Override
	public ChannelSchedulePrototype createAllocationFunction(
			BoundedChannel channel) {
		ChannelSchedulePrototype p= createChannelPrototype(channel, ALLOCATION_PREFIX);
		p.setName("alloc_"+channel.getName());
		return p;
	}

}
