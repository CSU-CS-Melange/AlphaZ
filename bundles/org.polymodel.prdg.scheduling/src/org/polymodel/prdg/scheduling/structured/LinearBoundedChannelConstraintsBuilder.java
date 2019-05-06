package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

/**
 * Builder for input and output constraints of process channels. Each channel
 * has a maximal buffer size B, thus a produced data 'x' will be deallocated at
 * the same time that the data 'x+B' will be allocated. Access subscripts are
 * linearization of the iteration vector of each dependency. <b>Dimensions have
 * to be bounded to be able to linearize the acesses</b>.<br>
 * <br>
 * <i>P. Feautrier. Scalable and structured scheduling. Int. J. Parallel
 * Program., 34(5):459�p487, 2006.</i>
 * 
 * @author antoine
 * 
 */
public class LinearBoundedChannelConstraintsBuilder extends
		ProcessConstraintsBuilder {

	protected LinearMemoryWriteDependency buildMemoryWriteDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			StatementSchedulePrototype source) {
		LinearMemoryWriteDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createLinearMemoryWriteDependency(channel, source, allocation,
						findProducerSubscript(source.getStatement()));
		return readDependency;
	}

//	private Map<PRDGEdge, Domain> inputBoundedConstraintsCache = new CacheMap<PRDGEdge, Domain>(
//			1000);
	private Map<OutputPort, Domain> outputBoundedConstraintsCache = new CacheMap<OutputPort, Domain>(
			1000);

	@Override
	protected Domain buildChannelConstraints(Process process,
			StructuredScheduler scheduler,
			List<Variable> channelScheduleCoeficients)
			throws SchedulingException {
		Domain result = super.buildChannelConstraints(process, scheduler,
				channelScheduleCoeficients);
		BoundedStructuredScheduler bscheduler = (BoundedStructuredScheduler) scheduler;
		for (OutputPort out : process.getOutputs()) {
			if (out.getChannel() instanceof BoundedChannel) {
				Domain dout = buildMemoryOutputConstraints(bscheduler, out,
						outputBoundedConstraintsCache);
				if (dout != null && dout.isEmpty()) {
					throw new SchedulingException(
							"Channel "
									+ out.getChannel().getName()
									+ " doesn't respect the bounded memory constraints.");
				}
				result = intersection(result, dout);
			}
		}
		if (result != null && result.isEmpty()) {
			throw new SchedulingException("Channels of the process "
					+ process.getName() + " can't be scheduled.");
		}
		return result;
	}

	@Override
	protected ChannelWriteDependency buildWriteDependency(
			ChannelSchedulePrototype channelSchedulePrototype,
			StatementSchedulePrototype sourceSchedulePrototype,
			IntExpression subscript) {
		ChannelLinearWriteDependency writeDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createChannelLinearWriteDependency(channelSchedulePrototype,
						sourceSchedulePrototype, subscript);
		return writeDependency;
	}

	@Override
	protected ChannelReadDependency buildReadDependency(
			ChannelSchedulePrototype channelSchedulePrototype, PRDGEdge edge,
			EdgeDependency edgeDependency) {
		IntExpression consumerSubscript = findConsumerSubscript(edge);
		ChannelReadDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createChannelLinearReadDependency(channelSchedulePrototype,
						edgeDependency.getReference(), edge, consumerSubscript);
		return readDependency;
	}

	/**
	 * Build bounded dependency constraints for an output port of a channel.
	 * 
	 * @param bscheduler
	 *            bounded scheduler that contains all schedule prototypes
	 * @param out
	 *            channel output port
	 * @param memoryScheduleCoeficients
	 *            container of added schedule coefficients for the memory
	 *            schedule constraints
	 * @param outputBoundedConstraintsCache
	 *            cache to reuse constraints already built for an output port
	 */
	protected Domain buildMemoryOutputConstraints(
			BoundedStructuredScheduler bscheduler, OutputPort out,
			Map<OutputPort, Domain> outputBoundedConstraintsCache) {
		Domain cachedConstraints = outputBoundedConstraintsCache.get(out);
		BoundedChannel channel = (BoundedChannel) out.getChannel();
		verbose(2, "* Output allocation dependencies for channel "
				+ out.getChannel().getName());
		if (cachedConstraints == null) {
			StatementSchedulePrototype sourceSchedulePrototype = bscheduler
					.getSchedulePrototype(out.getSourceNode());

			for (Dependency writeDependency : getWriteDependencies(channel,
					sourceSchedulePrototype, bscheduler)) {
				Domain domain = (buildConstraintsFor(writeDependency));
				cachedConstraints = intersection(cachedConstraints, domain);
			}
			outputBoundedConstraintsCache.put(out, cachedConstraints);
		} else {
			verbose(3, "Constraints are already in cache");
		}
		return cachedConstraints;
	}

	@Override
	protected List<Dependency> getInputEdgeDependencies(
			ChannelSchedulePrototype channelSchedulePrototype, PRDGEdge edge,
			EdgeDependency edgeDependency, StructuredScheduler bscheduler) {
		List<Dependency> dependencies = super.getInputEdgeDependencies(
				channelSchedulePrototype, edge, edgeDependency, bscheduler);
		Channel channel = channelSchedulePrototype.getChannel();
		if (channel instanceof BoundedChannel) {
			dependencies.addAll(getReadDependencies((BoundedChannel) channel,
					edge, (BoundedStructuredScheduler) bscheduler));
		}
		return dependencies;
	}

	protected List<Dependency> getReadDependencies(BoundedChannel channel,
			PRDGEdge edge, BoundedStructuredScheduler bscheduler) {
		List<Dependency> result = new ArrayList<Dependency>();
		EdgeDependency edgeDependency = bscheduler.getDependency(edge);
		ChannelSchedulePrototype allocation = bscheduler
				.getAllocationSchedulePrototype(channel);
		IntExpression consumerSubscript = findConsumerSubscript(edge);

		// Feautrier constraints for a read dependency
		LinearMemoryReadDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createLinearMemoryReadDependency(channel, allocation,
						edgeDependency.getReference(), edge, consumerSubscript);
		verbose(3, "> " + edge.getSource().getName() + "->"
				+ edge.getDestination().getName() + " for data["
				+ consumerSubscript + "] : " + readDependency.getTerms(true)
				+ " >= 0");
		result.add(readDependency);

		// Allocation dependency of a read
		LinearMemoryAllocationDependency allocationDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createLinearMemoryAllocationDependency(channel, allocation,
						edgeDependency.getReference(), edge, consumerSubscript);
		verbose(3, "> Read allocation " + edge.getSource().getName() + "->"
				+ edge.getDestination().getName() + " for data["
				+ consumerSubscript + "] : " + readDependency.getTerms(true)
				+ " >= 0");
		result.add(allocationDependency);
		return result;
	}
//
//	@Override
//	protected List<Dependency> getInputDependencies(Channel channel,
//			Process process, StructuredScheduler scheduler) {
//		List<Dependency> result = super.getInputDependencies(channel, process,
//				scheduler);
//		if (channel instanceof BoundedChannel) {
//			BoundedChannel bchannel = (BoundedChannel) channel;
//			LinearMemoryDeallocationDependency deallocation = StructuredSchedulingConcreteFactory.INSTANCE
//					.createLinearMemoryDeallocationDependency(bchannel,
//							((BoundedStructuredScheduler) scheduler)
//									.getAllocationSchedulePrototype(bchannel),
//							findProducerSubscript(channel.getSource().getSourceNode()));
//			result.add(deallocation);
//		}
//		return result;
//	}

	protected List<Dependency> getWriteDependencies(BoundedChannel channel,
			StatementSchedulePrototype source,
			BoundedStructuredScheduler bscheduler) {
		List<Dependency> result = new ArrayList<Dependency>();
		ChannelSchedulePrototype allocation = bscheduler
				.getAllocationSchedulePrototype(channel);
		IntExpression producerSubscript = findProducerSubscript(source
				.getStatement());
		LinearMemoryWriteDependency writeDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createLinearMemoryWriteDependency(channel, source, allocation,
						producerSubscript);
		verbose(3, "> Produced data[" + producerSubscript + "] : "
				+ writeDependency.getTerms(true) + " >= 0");

		result.add(writeDependency);
		return result;
	}

}
