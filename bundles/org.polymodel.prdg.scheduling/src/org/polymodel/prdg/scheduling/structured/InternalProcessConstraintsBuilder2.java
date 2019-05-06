package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl;
import org.polymodel.prdg.scheduling.structured.impl.ProcessImpl;
import org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl;

public class InternalProcessConstraintsBuilder2 extends
		BoundedChannelConstraintsBuilder {

	/**
	 * Maximal size of internal channels.
	 */
	private int internalChannelsSize;
	/**
	 * Maximal size of external channels.
	 */
//	private int externalChannelsSize;

	private InternalProcessNetwork internalProcessNetwork;
	private BoundedStructuredScheduler scheduler;

	public InternalProcessConstraintsBuilder2(int internalSize,
			Long... linearizationFactors) {
		this.internalChannelsSize = internalSize;
		this.linearizationFactors = new ArrayList<Long>();
		for (int i = 0; i < linearizationFactors.length; i++) {
			this.linearizationFactors.add(linearizationFactors[i]);
		}
	}

	@Override
	protected Domain buildProcessConstraints(Process process,
			StructuredScheduler scheduler) throws SchedulingException {
		this.scheduler = new InternalBoundedStructuredSchedulerProxy(
				(BoundedStructuredScheduler) scheduler);
		InternalNetworkBuilder builder = new InternalNetworkBuilder(process,
				internalChannelsSize, this.scheduler);
		this.internalProcessNetwork = builder.buildInternalProcessNetwork();

		Domain allConstraints = null;
		for (PRDGNode n : process.getInternalNodes()) {
			Domain constraintsForNode = buildConstraints(n);
			allConstraints = intersection(constraintsForNode, allConstraints);
		}
		return allConstraints;
	}

	/**
	 * Build the internal constraints for a node <i>n</i>. These constraints
	 * are: <br>
	 * 1) Memory read constraints. For each input edge <i>in</i> : <i>T(n) <=
	 * phi(in.channel)</i><br>
	 * 2) Allocation constraints. For each input edge <i>in</i> : <i>T(n) >=
	 * alpha(in.channel) </i><br>
	 * 2) Memory write constraints. For each output channel <i>out</i> : <i>T(n)
	 * >= alpha(out) </i><br>
	 * 3) Deallocation constraints. For each output channel <i>out</i>
	 * :<i>phi(out) >= alpha(out) </i><br>
	 * </br>
	 * 
	 * @param node
	 * @return
	 * @throws SchedulingException
	 */
	protected Domain buildConstraints(PRDGNode node) throws SchedulingException {
		Domain allConstraints = null;
		List<Dependency> internalInputs = buildInternalInputDepencies(node);
		for (Dependency in : internalInputs) {
			Domain din = buildConstraintsFor(in);
			allConstraints = intersection(allConstraints, din);
			if (allConstraints.isEmpty()) {
				throw new SchedulingException(in);
			}
		}
		List<Dependency> internalOutputs = buildInternalOutputDepencies(node);
		for (Dependency out : internalOutputs) {
			Domain dout = buildConstraintsFor(out);
			allConstraints = intersection(allConstraints, dout);
			if (allConstraints.isEmpty()) {
				throw new SchedulingException(out);
			}
		}

		List<Dependency> externalInputs = buildExternalInputDepencies(node);
		for (Dependency in : externalInputs) {
			Domain din = buildConstraintsFor(in);
			allConstraints = intersection(allConstraints, din);
			if (allConstraints.isEmpty()) {
				throw new SchedulingException(in);
			}
		}
		return allConstraints;
	}

	protected List<Dependency> buildInternalInputDepencies(PRDGNode node) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		for (PRDGEdge input : node.getSources()) {
			if (internalProcessNetwork.isInternalNode(input.getSource())) {
				dependencies.add(createMemoryReadDependency(input));
				dependencies.add(createMemoryAllocationDependency(input));
			}
		}
		return dependencies;
	}

	protected List<Dependency> buildExternalInputDepencies(PRDGNode node) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Process internalProcess = internalProcessNetwork
				.getInternalProcess(node);
		for (InputPort pin : internalProcess.getInputs()) {
			if (pin.getChannel() instanceof ExternalChannel) {
				for (PRDGEdge input : pin.getChannel().getEdges()) {
					// dependencies.add(buildReadDependency(channelSchedulePrototype,
					// edge, edgeDependency, subscript));
					dependencies.add(createMemoryReadDependency(input));
					dependencies.add(createMemoryAllocationDependency(input));
				}
			}
		}
		return dependencies;
	}

	protected List<Dependency> buildInternalOutputDepencies(PRDGNode node) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Process internalProcess = internalProcessNetwork
				.getInternalProcess(node);
		for (OutputPort output : internalProcess.getOutputs()) {
			if (output.getChannel() instanceof InternalChannel) {
				InternalChannel channel = (InternalChannel) output.getChannel();
				dependencies.add(createMemoryWriteDependency(channel));
				dependencies.add(createMemoryDeallocationDependency(channel));
			}
		}
		return dependencies;
	}

	protected List<Dependency> buildExternalOutputDepencies(PRDGNode node) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Process internalProcess = internalProcessNetwork
				.getInternalProcess(node);
		for (OutputPort output : internalProcess.getOutputs()) {
			if (output.getChannel() instanceof ExternalChannel) {
				InternalChannel channel = (InternalChannel) output.getChannel();
				dependencies.add(createMemoryWriteDependency(channel));
				dependencies.add(createMemoryDeallocationDependency(channel));
			}
		}
		return dependencies;
	}

	/**
	 * Create the deallocation dependency of a channel. A data is deallocated
	 * strictly after its allocation.<br>
	 * <i>phi(channel) >= alpha(channel) </i><br>
	 * 
	 * @param channel
	 * @return
	 */
	private Dependency createMemoryDeallocationDependency(BoundedChannel channel) {
		ChannelSchedulePrototype allocation = scheduler
				.getAllocationSchedulePrototype(channel);
		MemoryDeallocationDependency dep = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryDeallocationDependency(channel, allocation,
						linearizationFactors);
		return dep;
	}

	private Dependency createMemoryWriteDependency(BoundedChannel output) {
		ChannelSchedulePrototype allocation = scheduler
				.getAllocationSchedulePrototype(output);
		StatementSchedulePrototype source = scheduler
				.getSchedulePrototype(output.getSource().getSourceNode());
		MemoryWriteDependency writeDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryWriteDependency(output, source, allocation);

		return writeDependency;
	}

	/**
	 * Create an internal memory allocation dependency for source node and a
	 * destination channel. It specifies that a node can't start before that all
	 * its required data have been allocated on the channel.<br>
	 * <br>
	 * <i>T(n) >= alpha(in)</i><br>
	 * 
	 * @param input
	 * @return
	 */
	private Dependency createMemoryAllocationDependency(PRDGEdge input) {
		BoundedChannel channel = internalProcessNetwork
				.getInternalChannel(input);
		ChannelSchedulePrototype allocation = scheduler
				.getAllocationSchedulePrototype(channel);
		StatementSchedulePrototype reference = scheduler
				.getSchedulePrototype(input.getDestination());
		MemoryAllocationDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryAllocationDependency(channel, allocation,
						reference, input);
		return readDependency;
	}

	/**
	 * Create an internal memory read dependency for source node and a
	 * destination channel.<br>
	 * <i>T(n) <= phi(in)</i><br>
	 * 
	 * @param input
	 * @return
	 */
	private MemoryReadDependency createMemoryReadDependency(PRDGEdge input) {
		BoundedChannel channel = internalProcessNetwork
				.getInternalChannel(input);
		ChannelSchedulePrototype allocation = scheduler
				.getAllocationSchedulePrototype(channel);
		StatementSchedulePrototype reference = scheduler
				.getSchedulePrototype(input.getDestination());
		MemoryReadDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createMemoryReadDependency(channel, allocation, reference,
						input, linearizationFactors);
		return readDependency;
	}

	private static class InternalProcessNetwork extends ProcessNetworkImpl {

		public InternalProcessNetwork(PRDG prdg) {
			setPrdg(prdg);
		}

		private Map<PRDGNode, Process> nodesToProcessMap = new HashMap<PRDGNode, Process>();
		private Map<PRDGEdge, BoundedChannel> edgesToChannelsMap = new HashMap<PRDGEdge, BoundedChannel>();

		public Process getInternalProcess(PRDGNode n) {
			Process process = nodesToProcessMap.get(n);
			if (process == null)
				throw new IllegalArgumentException(
						"Node isn't in this internal network");
			else
				return process;
		}

		public BoundedChannel getInternalChannel(PRDGEdge e) {
			return edgesToChannelsMap.get(e);
		}

		public void addInternalNodeProcess(PRDGNode n, Process p) {
			getProcesses().add(p);
			this.nodesToProcessMap.put(n, p);
		}

		public void addChannel(BoundedChannel channel) {
			getChannels().add(channel);
			for (PRDGEdge e : channel.getEdges()) {
				this.edgesToChannelsMap.put(e, channel);
			}
		}

		/**
		 * Test if a node is a part of this internal network.
		 * 
		 * @param n
		 * @return
		 */
		public boolean isInternalNode(PRDGNode n) {
			return nodesToProcessMap.get(n) != null;
		}
	}

	/**
	 * An internal channel has a source in the internal network and may have
	 * multiple destinations in the network.
	 * 
	 * @author antoine
	 * 
	 */
	private static class InternalChannel extends BoundedChannelImpl {

		public InternalChannel(String name, int size,
				InternalProcessNetwork network, List<PRDGEdge> edges) {
			this.setName(name);
			this.maximalChannelSize = size;
			this.setDestination(StructuredSchedulingConcreteFactory.INSTANCE
					.createIntputPort());
			this.setSource(StructuredSchedulingConcreteFactory.INSTANCE
					.createOutputPort());

			// Add Source and destinations ports
			Process source = null;
			List<Process> destinations = new UniqueEList<Process>();
			for (PRDGEdge e : edges) {
				Process esource = network.getInternalProcess(e.getSource());
				if (source == null) {
					source = esource;
					source.getOutputs().add(getSource());
				} else {
					if (source != esource)
						throw new IllegalArgumentException(
								"Channel can't be built from different source nodes.");
				}
				Process dest = network.getInternalProcess(e.getDestination());
				destinations.add(dest);
				getEdges().add(e);
			}
			for (Process process : destinations) {
				process.getInputs().add(getDestination());
			}
		}

	}

	private static class ExternalChannel extends BoundedChannelImpl {
		private BoundedChannel reference;

		public ExternalChannel(BoundedChannel reference) {
			this.reference = reference;
			this.setName("external_" + reference.getName());
			this.setDestination(StructuredSchedulingConcreteFactory.INSTANCE
					.createIntputPort());
			this.setSource(StructuredSchedulingConcreteFactory.INSTANCE
					.createOutputPort());
		}

		@Override
		public Domain getDomain() {
			return reference.getDomain();
		}

		@Override
		public int getMaximalChannelSize() {
			return reference.getMaximalChannelSize();
		}

		@Override
		public EList<BoundingCoefficient> getBoundingCoefficients() {
			return reference.getBoundingCoefficients();
		}

		@Override
		public BoundingCoefficient getBoundingCoefficient(int index,
				int dimension) {
			return reference.getBoundingCoefficient(index, dimension);
		}

		@Override
		public Variable getSizeVariable() {
			return reference.getSizeVariable();
		}

		@Override
		public Variable getSubscriptDimension() {
			return reference.getSubscriptDimension();
		}

		public Channel getReference() {
			return reference;
		}
	}

	protected void manageVariables(SchedulePrototype p) {
		if (p instanceof ChannelSchedulePrototype
				&& !isInternal((ChannelSchedulePrototype) p)) {
			modularVariables.addAll(p.getCoeficients());
		} else {
			projectedVariables.addAll(p.getCoeficients());
		}
	}

	private boolean isInternal(ChannelSchedulePrototype p) {
		return p.getChannel() instanceof InternalChannel;
	}

	private static class InternalNetworkBuilder {
		private Map<PRDGNode, Process> nodesToProcessMap = new HashMap<PRDGNode, Process>();

		/**
		 * Original process
		 */
		private Process referenceProcess;
		/**
		 * Ordered set of all external outputs channels
		 */
		private List<BoundedChannel> externalOutputs = new UniqueEList<BoundedChannel>();
		/**
		 * Ordered set of all external inputs channels
		 */
		private List<BoundedChannel> externalInputs = new UniqueEList<BoundedChannel>();
		/**
		 * Provider to get maximal size of internal channels.
		 */
		private InternalChannelSizeProvider sizeProvider;
		/**
		 * Size of internal channels that will be used if no
		 * {@link InternalChannelSizeProvider} has been set.
		 */
		private int size;
//		private BoundedStructuredScheduler scheduler;
		private InternalProcessNetwork internalNetwork;

		public InternalNetworkBuilder(Process process, int size,
				BoundedStructuredScheduler scheduler) {

			this.size = size;
			this.referenceProcess = process;
//			this.scheduler = scheduler;
		}

		public InternalProcessNetwork buildInternalProcessNetwork() {

			internalNetwork = new InternalProcessNetwork(
					((ProcessNetwork) referenceProcess.eContainer()).getPrdg());

			for (PRDGNode n : referenceProcess.getInternalNodes()) {
				internalNetwork.addInternalNodeProcess(n, getProcess(n));
			}
			for (PRDGNode n : referenceProcess.getInternalNodes()) {
				InternalChannel internalChannel = createInternalChannel(n);
				if (internalChannel != null)
					internalNetwork.addChannel(internalChannel);
				for (PRDGEdge in : n.getSources()) {
					if (!isInternalNode(in.getSource())) {
						externalInputs.add(findOriginalInputChannel(in));
					}
				}
			}

			// External inputs
			for (int i = 0; i < externalInputs.size(); ++i) {
				BoundedChannel channel = externalInputs.get(i);
				InputProcess inputProcess = new InputProcess(channel
						.getSource().getSourceNode());
				internalNetwork.getProcesses().add(inputProcess);

				BoundedChannel inputChannel = new ExternalChannel(channel);
				inputProcess.getOutputs().add(inputChannel.getSource());
				for (PRDGEdge edge : channel.getEdges()) {
					PRDGNode destination = edge.getDestination();
					if (isInternalNode(destination)) {
						getProcess(destination).getInputs().add(
								inputChannel.getDestination());
						inputChannel.getEdges().add(edge);
					}
				}
				internalNetwork.addChannel(inputChannel);
			}

			// External outputs
			for (int i = 0; i < externalOutputs.size(); ++i) {
				BoundedChannel channel = externalOutputs.get(i);
				BoundedChannel outputChannel = new ExternalChannel(channel);
				Process consumer = getProcess(channel.getSource()
						.getSourceNode());
				consumer.getOutputs().add(outputChannel.getSource());
				for (PRDGEdge edge : channel.getEdges()) {
					PRDGNode destination = edge.getDestination();
					if (!isInternalNode(destination)) {
						OutputProcess outputProcess = new OutputProcess(
								destination);
						outputProcess.getInputs().add(
								outputChannel.getDestination());
						outputChannel.getEdges().add(edge);
					}
				}
				internalNetwork.addChannel(outputChannel);
			}

			return internalNetwork;
		}

		/**
		 * Find the original input channel of the process from a edge going to a
		 * node in the original process.
		 * 
		 * @param reference
		 * @return
		 */
		private BoundedChannel findOriginalInputChannel(PRDGEdge edge) {
			for (InputPort in : referenceProcess.getInputs()) {
				for (PRDGEdge inputEdge : in.getChannel().getEdges()) {
					if (inputEdge == edge)
						return (BoundedChannel) in.getChannel();
				}
			}
			throw new IllegalArgumentException("Unable to find the channel for"
					+ edge + " input of process " + referenceProcess.getName());
		}

		private BoundedChannel findOriginalOutputChannel(PRDGEdge edge) {
			for (OutputPort out : referenceProcess.getOutputs()) {
				for (PRDGEdge outputEdge : out.getChannel().getEdges()) {
					if (outputEdge == edge)
						return (BoundedChannel) out.getChannel();
				}
			}
			throw new IllegalArgumentException("Unable to find the channel for"
					+ edge + " input of process " + referenceProcess.getName());
		}

		/**
		 * Get the size of an internal channel from its data producer node.
		 * 
		 * @param n
		 * @return
		 */
		@SuppressWarnings("unused")
		int getSize(PRDGNode n) {
			if (sizeProvider == null)
				return size;
			else
				return sizeProvider.getOutputSize(n);
		}

		/**
		 * Create an internal channel connecting the producer process to all its
		 * atomic consumers of the internal network.
		 * 
		 * @param source
		 * @return null if the source doesn't have any internal output
		 */
		private InternalChannel createInternalChannel(PRDGNode source) {

			if (source.getDestinations().size() > 0) {
				List<PRDGNode> destinations = new UniqueEList<PRDGNode>();

				// Collect all different destinations and notify external
				// outputs
				for (PRDGEdge destination : source.getDestinations()) {
					if (isInternalNode(destination.getDestination())) {
						destinations.add(destination.getDestination());
					} else {
						externalOutputs
								.add(findOriginalOutputChannel(destination));
					}
				}

				Process producer = getProcess(source);
				if (destinations.size() > 0) {
					String name = producer.getName() + "_output";
					List<PRDGEdge> edges = new ArrayList<PRDGEdge>();
					for (PRDGEdge edge : source.getDestinations()) {
						PRDGNode destination = edge.getDestination();
						if (destinations.contains(destination)) {
							edges.add(edge);
						}
					}
					InternalChannel output = new InternalChannel(name, size,
							internalNetwork, edges);
					output.setDomain(EcoreUtil.copy(source.getDomain()));
					for (int i = 0; i < source.getDomain().getNbIndices(); ++i) {
						BoundingCoefficient bcoef = StructuredSchedulingConcreteFactory.INSTANCE.createBoundingCoefficient(name, i);
						output.getBoundingCoefficients().add(bcoef);
					}
					return output;

				}
			}
			return null;

		}

		/**
		 * Test if a node is inside the analyzed process.
		 * 
		 * @param n
		 * @return
		 */
		private boolean isInternalNode(PRDGNode n) {
			for (PRDGNode node : referenceProcess.getInternalNodes()) {
				if (node == n)
					return true;
			}
			return false;
		}

		/**
		 * Get the internal process of a {@link PRDGNode} of the original
		 * process. It also add the node in the process.
		 * 
		 * @param n
		 *            a node in the original process
		 * @return
		 */
		private Process getProcess(PRDGNode n) {
			Process p = nodesToProcessMap.get(n);
			if (p == null) {
				p = StructuredSchedulingConcreteFactory.INSTANCE
						.createProcess();
				p.setName("P" + n.getName());
				nodesToProcessMap.put(n, p);
				p.getInternalNodes().add(n);
			}
			return p;
		}
	}

	private static abstract class VirtualChannelProcess extends ProcessImpl {
		private PRDGNode node;

		public VirtualChannelProcess(String name, PRDGNode externalNode) {
			super();
			this.node = externalNode;
			this.getInternalNodes().add(node);
			this.name = name;
		}

	}

	private static class InputProcess extends VirtualChannelProcess {

		public InputProcess(PRDGNode externalProducer) {
			super("VIN_" + externalProducer.getName(), externalProducer);

		}

	}

	private static class OutputProcess extends VirtualChannelProcess {

		public OutputProcess(PRDGNode externalConsumer) {
			super("VOUT" + externalConsumer.getName(), externalConsumer);

		}
	}

	private static class InternalBoundedStructuredSchedulerProxy extends
			BoundedStructuredScheduler {
		private BoundedStructuredScheduler nestedScheduler;

		public InternalBoundedStructuredSchedulerProxy(
				BoundedStructuredScheduler nested) {
			super((StructuredSchedulePrototypeBuilder) nested
					.getPrototypeBuilder(),
					(BoundedChannelConstraintsBuilder) nested
							.getProcessConstraintsBuilder());
			this.nestedScheduler = nested;
		}

		@Override
		public ChannelSchedulePrototype getSchedulePrototype(Channel c) {
			if (c instanceof ExternalChannel) {
				return nestedScheduler
						.getSchedulePrototype(((ExternalChannel) c)
								.getReference());
			} else
				return nestedScheduler.getSchedulePrototype(c);
		}

		@Override
		public ChannelSchedulePrototype getAllocationSchedulePrototype(
				BoundedChannel c) {
			if (c instanceof ExternalChannel) {
				return nestedScheduler
						.getAllocationSchedulePrototype((BoundedChannel) ((ExternalChannel) c)
								.getReference());
			} else
				return nestedScheduler.getAllocationSchedulePrototype(c);
		}

		@Override
		public EdgeDependency getDependency(PRDGEdge e) {
			return nestedScheduler.getDependency(e);
		}

		@Override
		public StatementSchedulePrototype getSchedulePrototype(PRDGNode n) {
			return nestedScheduler.getSchedulePrototype(n);
		}

		@SuppressWarnings("unused")
		public BoundedStructuredScheduler getNestedScheduler() {
			return nestedScheduler;
		}
	}

}
